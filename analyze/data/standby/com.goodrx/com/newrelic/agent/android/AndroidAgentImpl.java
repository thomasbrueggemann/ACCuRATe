package com.newrelic.agent.android;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.AgentInitializationException;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.NullAgentImpl;
import com.newrelic.agent.android.SavedState;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.api.v1.ConnectionEvent;
import com.newrelic.agent.android.api.v1.ConnectionListener;
import com.newrelic.agent.android.api.v1.DeviceForm;
import com.newrelic.agent.android.api.v2.TraceMachineInterface;
import com.newrelic.agent.android.background.ApplicationStateEvent;
import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.crashes.CrashReporter;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.sample.MachineMeasurementConsumer;
import com.newrelic.agent.android.sample.Sampler;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.ActivityLifecycleBackgroundListener;
import com.newrelic.agent.android.util.AndroidEncoder;
import com.newrelic.agent.android.util.Connectivity;
import com.newrelic.agent.android.util.Encoder;
import com.newrelic.agent.android.util.JsonCrashStore;
import com.newrelic.agent.android.util.PersistentUUID;
import com.newrelic.agent.android.util.SharedPrefsAnalyticAttributeStore;
import com.newrelic.agent.android.util.UiBackgroundListener;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import proguard.canary.NewRelicCanary;

public class AndroidAgentImpl implements AgentImpl, ConnectionListener, TraceMachineInterface, ApplicationStateListener {
   private static final float LOCATION_ACCURACY_THRESHOLD = 500.0F;
   private static final Comparator<TransactionData> cmp = new Comparator() {
      public int compare(TransactionData var1, TransactionData var2) {
         return var1.getTimestamp() > var2.getTimestamp()?-1:(var1.getTimestamp() < var2.getTimestamp()?1:0);
      }
   };
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final AgentConfiguration agentConfiguration;
   private ApplicationInformation applicationInformation;
   private final Context context;
   private DeviceInformation deviceInformation;
   private final Encoder encoder = new AndroidEncoder();
   private LocationListener locationListener;
   private final Lock lock = new ReentrantLock();
   private MachineMeasurementConsumer machineMeasurementConsumer;
   private SavedState savedState;

   public AndroidAgentImpl(Context var1, AgentConfiguration var2) throws AgentInitializationException {
      this.context = appContext(var1);
      this.agentConfiguration = var2;
      this.savedState = new SavedState(this.context);
      if(this.isDisabled()) {
         throw new AgentInitializationException("This version of the agent has been disabled");
      } else {
         this.initApplicationInformation();
         if(var2.useLocationService() && this.context.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", this.getApplicationInformation().getPackageId()) == 0) {
            log.debug("Location stats enabled");
            this.addLocationListener();
         }

         TraceMachine.setTraceMachineInterface(this);
         var2.setCrashStore(new JsonCrashStore(var1));
         var2.setAnalyticAttributeStore(new SharedPrefsAnalyticAttributeStore(var1));
         ApplicationStateMonitor.getInstance().addApplicationStateListener(this);
         if(VERSION.SDK_INT >= 14) {
            Object var3;
            if(Agent.getUnityInstrumentationFlag().equals("YES")) {
               var3 = new ActivityLifecycleBackgroundListener();
               if(var3 instanceof ActivityLifecycleCallbacks) {
                  try {
                     if(var1.getApplicationContext() instanceof Application) {
                        ((Application)var1.getApplicationContext()).registerActivityLifecycleCallbacks((ActivityLifecycleCallbacks)var3);
                     }
                  } catch (Exception var5) {
                     ;
                  }
               }
            } else {
               var3 = new UiBackgroundListener();
            }

            var1.registerComponentCallbacks((ComponentCallbacks)var3);
            this.setupSession();
         }

      }
   }

   private void addLocationListener() {
      LocationManager var1 = (LocationManager)this.context.getSystemService("location");
      if(var1 == null) {
         log.error("Unable to retrieve reference to LocationManager. Disabling location listener.");
      } else {
         this.locationListener = new LocationListener() {
            public void onLocationChanged(Location var1) {
               if(AndroidAgentImpl.this.isAccurate(var1)) {
                  AndroidAgentImpl.this.setLocation(var1);
               }

            }

            public void onProviderDisabled(String var1) {
               if("passive".equals(var1)) {
                  AndroidAgentImpl.this.removeLocationListener();
               }

            }

            public void onProviderEnabled(String var1) {
            }

            public void onStatusChanged(String var1, int var2, Bundle var3) {
            }
         };
         var1.requestLocationUpdates("passive", 1000L, 0.0F, this.locationListener);
      }
   }

   private static Context appContext(Context var0) {
      if(!(var0 instanceof Application)) {
         var0 = var0.getApplicationContext();
      }

      return var0;
   }

   private static DeviceForm deviceForm(Context var0) {
      int var1 = 15 & var0.getResources().getConfiguration().screenLayout;
      switch(var1) {
      case 1:
         return DeviceForm.SMALL;
      case 2:
         return DeviceForm.NORMAL;
      case 3:
         return DeviceForm.LARGE;
      default:
         return var1 > 3?DeviceForm.XLARGE:DeviceForm.UNKNOWN;
      }
   }

   private String getUUID() {
      String var1 = this.savedState.getConnectInformation().getDeviceInformation().getDeviceId();
      if(TextUtils.isEmpty(var1)) {
         var1 = (new PersistentUUID(this.context)).getPersistentUUID();
         this.savedState.saveDeviceId(var1);
      }

      return var1;
   }

   private String getUnhandledExceptionHandlerName() {
      try {
         String var2 = Thread.getDefaultUncaughtExceptionHandler().getClass().getName();
         return var2;
      } catch (Exception var3) {
         return "unknown";
      }
   }

   public static void init(Context var0, AgentConfiguration var1) {
      try {
         Agent.setImpl(new AndroidAgentImpl(var0, var1));
         Agent.start();
      } catch (AgentInitializationException var3) {
         log.error("Failed to initialize the agent: " + var3.toString());
      }
   }

   private boolean isAccurate(Location var1) {
      return var1 != null && 500.0F >= var1.getAccuracy();
   }

   private void pokeCanary() {
      NewRelicCanary.canaryMethod();
   }

   private void removeLocationListener() {
      // $FF: Couldn't be decompiled
   }

   private void stop(boolean var1) {
      this.finalizeSession();
      Sampler.shutdown();
      TraceMachine.haltTracing();
      int var2 = AnalyticsControllerImpl.getInstance().getEventManager().getEventsRecorded();
      int var3 = AnalyticsControllerImpl.getInstance().getEventManager().getEventsEjected();
      Measurements.addCustomMetric("Supportability/Events/Recorded", MetricCategory.NONE.name(), var2, (double)var3, (double)var3, MetricUnit.OPERATIONS, MetricUnit.OPERATIONS);
      if(var1) {
         if(this.isUIThread()) {
            StatsEngine.get().inc("Supportability/AgentHealth/HarvestOnMainThread");
         }

         Harvest.harvestNow();
      }

      AnalyticsControllerImpl.shutdown();
      TraceMachine.clearActivityHistory();
      Harvest.shutdown();
      Measurements.shutdown();
   }

   @Deprecated
   public void addTransactionData(TransactionData var1) {
   }

   public void applicationBackgrounded(ApplicationStateEvent var1) {
      log.info("AndroidAgentImpl: application backgrounded ");
      this.stop();
   }

   public void applicationForegrounded(ApplicationStateEvent var1) {
      log.info("AndroidAgentImpl: application foregrounded ");
      this.start();
   }

   @Deprecated
   public void connected(ConnectionEvent var1) {
      log.error("AndroidAgentImpl: connected ");
   }

   public void disable() {
      log.warning("PERMANENTLY DISABLING AGENT v" + Agent.getVersion());

      try {
         this.savedState.saveDisabledVersion(Agent.getVersion());
      } finally {
         try {
            this.stop(false);
         } finally {
            Agent.setImpl(NullAgentImpl.instance);
         }
      }

   }

   @Deprecated
   public void disconnected(ConnectionEvent var1) {
      this.savedState.clear();
   }

   protected void finalizeSession() {
   }

   @Deprecated
   public List<TransactionData> getAndClearTransactionData() {
      return null;
   }

   public ApplicationInformation getApplicationInformation() {
      return this.applicationInformation;
   }

   public String getCrossProcessId() {
      this.lock.lock();

      String var2;
      try {
         var2 = this.savedState.getCrossProcessId();
      } finally {
         this.lock.unlock();
      }

      return var2;
   }

   public long getCurrentThreadId() {
      return Thread.currentThread().getId();
   }

   public String getCurrentThreadName() {
      return Thread.currentThread().getName();
   }

   public DeviceInformation getDeviceInformation() {
      if(this.deviceInformation != null) {
         return this.deviceInformation;
      } else {
         DeviceInformation var1 = new DeviceInformation();
         var1.setOsName("Android");
         var1.setOsVersion(VERSION.RELEASE);
         var1.setOsBuild(VERSION.INCREMENTAL);
         var1.setModel(Build.MODEL);
         var1.setAgentName("AndroidAgent");
         var1.setAgentVersion(Agent.getVersion());
         var1.setManufacturer(Build.MANUFACTURER);
         var1.setDeviceId(this.getUUID());
         var1.setArchitecture(System.getProperty("os.arch"));
         var1.setRunTime(System.getProperty("java.vm.version"));
         var1.setSize(deviceForm(this.context).name().toLowerCase());
         this.deviceInformation = var1;
         return this.deviceInformation;
      }
   }

   public Encoder getEncoder() {
      return this.encoder;
   }

   public EnvironmentInformation getEnvironmentInformation() {
      EnvironmentInformation var1 = new EnvironmentInformation();
      ActivityManager var2 = (ActivityManager)this.context.getSystemService("activity");
      long[] var3 = new long[2];

      try {
         StatFs var4 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
         StatFs var5 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
         if(VERSION.SDK_INT >= 18) {
            var3[0] = var4.getAvailableBlocksLong() * var4.getBlockSizeLong();
            var3[1] = var5.getAvailableBlocksLong() * var4.getBlockSizeLong();
         } else {
            var3[0] = (long)(var4.getAvailableBlocks() * var4.getBlockSize());
            var3[1] = (long)(var5.getAvailableBlocks() * var5.getBlockSize());
         }
      } catch (Exception var10) {
         AgentHealth.noticeException(var10);
      } finally {
         if(var3[0] < 0L) {
            var3[0] = 0L;
         }

         if(var3[1] < 0L) {
            var3[1] = 0L;
         }

         var1.setDiskAvailable(var3);
      }

      var1.setMemoryUsage(Sampler.sampleMemory(var2).getSampleValue().asLong().longValue());
      var1.setOrientation(this.context.getResources().getConfiguration().orientation);
      var1.setNetworkStatus(this.getNetworkCarrier());
      var1.setNetworkWanType(this.getNetworkWanType());
      return var1;
   }

   public String getNetworkCarrier() {
      return Connectivity.carrierNameFromContext(this.context);
   }

   public String getNetworkWanType() {
      return Connectivity.wanType(this.context);
   }

   public int getResponseBodyLimit() {
      this.lock.lock();

      int var2;
      try {
         var2 = this.savedState.getHarvestConfiguration().getResponse_body_limit();
      } finally {
         this.lock.unlock();
      }

      return var2;
   }

   protected SavedState getSavedState() {
      return this.savedState;
   }

   public long getSessionDurationMillis() {
      return Harvest.getMillisSinceStart();
   }

   public int getStackTraceLimit() {
      this.lock.lock();

      int var2;
      try {
         var2 = this.savedState.getStackTraceLimit();
      } finally {
         this.lock.unlock();
      }

      return var2;
   }

   public void initApplicationInformation() throws AgentInitializationException {
      // $FF: Couldn't be decompiled
   }

   protected void initialize() {
      this.setupSession();
      AnalyticsControllerImpl.getInstance();
      AnalyticsControllerImpl.initialize(this.agentConfiguration, this);
      Harvest.addHarvestListener(this.savedState);
      Harvest.initialize(this.agentConfiguration);
      Harvest.setHarvestConfiguration(this.savedState.getHarvestConfiguration());
      Harvest.setHarvestConnectInformation(this.savedState.getConnectInformation());
      Measurements.initialize();
      AgentLog var2 = log;
      Object[] var3 = new Object[]{Agent.getVersion()};
      var2.info(MessageFormat.format("New Relic Agent v{0}", var3));
      AgentLog var4 = log;
      Object[] var5 = new Object[]{this.agentConfiguration.getApplicationToken()};
      var4.verbose(MessageFormat.format("Application token: {0}", var5));
      this.machineMeasurementConsumer = new MachineMeasurementConsumer();
      Measurements.addMeasurementConsumer(this.machineMeasurementConsumer);
      StatsEngine.get().inc("Supportability/AgentHealth/UncaughtExceptionHandler/" + this.getUnhandledExceptionHandlerName());
      CrashReporter.initialize(this.agentConfiguration);
      Sampler.init(this.context);
   }

   public boolean isDisabled() {
      return Agent.getVersion().equals(this.savedState.getDisabledVersion());
   }

   public boolean isUIThread() {
      return Looper.myLooper() == Looper.getMainLooper();
   }

   @Deprecated
   public void mergeTransactionData(List<TransactionData> var1) {
   }

   public void setLocation(Location var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Location must not be null.");
      } else {
         Geocoder var2 = new Geocoder(this.context);

         List var4;
         label27: {
            List var8;
            try {
               var8 = var2.getFromLocation(var1.getLatitude(), var1.getLongitude(), 1);
            } catch (IOException var9) {
               log.error("Unable to geocode location: " + var9.toString());
               var4 = null;
               break label27;
            }

            var4 = var8;
         }

         if(var4 != null && var4.size() != 0) {
            Address var5 = (Address)var4.get(0);
            if(var5 != null) {
               String var6 = var5.getCountryCode();
               String var7 = var5.getAdminArea();
               if(var6 != null && var7 != null) {
                  this.setLocation(var6, var7);
                  this.removeLocationListener();
                  return;
               }
            }
         }

      }
   }

   public void setLocation(String var1, String var2) {
      if(var1 == null || var2 == null) {
         throw new IllegalArgumentException("Country code and administrative region are required.");
      }
   }

   protected void setSavedState(SavedState var1) {
      this.savedState = var1;
   }

   protected void setupSession() {
      this.agentConfiguration.provideSessionId();
   }

   public void start() {
      if(!this.isDisabled()) {
         this.initialize();
         Harvest.start();
      } else {
         this.stop(false);
      }
   }

   public void stop() {
      this.stop(true);
   }

   public boolean updateSavedConnectInformation() {
      ConnectInformation var1 = this.savedState.getConnectInformation();
      ConnectInformation var2 = new ConnectInformation(this.getApplicationInformation(), this.getDeviceInformation());
      String var3 = this.savedState.getAppToken();
      boolean var4;
      if(var2.equals(var1)) {
         boolean var7 = this.agentConfiguration.getApplicationToken().equals(var3);
         var4 = false;
         if(var7) {
            return var4;
         }
      }

      if(var2.getApplicationInformation().isAppUpgrade(var1.getApplicationInformation())) {
         StatsEngine.get().inc("Mobile/App/Upgrade");
         AnalyticAttribute var5 = new AnalyticAttribute("upgradeFrom", var1.getApplicationInformation().getAppVersion());
         AnalyticsControllerImpl.getInstance().addAttributeUnchecked(var5, false);
      }

      this.savedState.clear();
      this.savedState.saveConnectInformation(var2);
      this.savedState.saveAppToken(this.agentConfiguration.getApplicationToken());
      var4 = true;
      return var4;
   }
}
