package com.appsflyer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.Build.VERSION;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.AttributionIDNotReady;
import com.appsflyer.BackgroundHttpTask;
import com.appsflyer.DebugLogQueue;
import com.appsflyer.Foreground;
import com.appsflyer.Installation;
import com.appsflyer.LogMessages;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.iid.InstanceID;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class AppsFlyerLib extends BroadcastReceiver {
   public static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
   private static final List<String> IGNORABLE_KEYS = Arrays.asList(new String[]{"is_cache"});
   private static ScheduledExecutorService cacheScheduler = null;
   private static AppsFlyerConversionListener conversionDataListener = null;
   private static AppsFlyerLib instance = new AppsFlyerLib();
   private static boolean isDuringCheckCache = false;
   private static long lastCacheCheck;
   private static long timeInApp = System.currentTimeMillis();
   private static AppsFlyerInAppPurchaseValidatorListener validatorListener = null;
   private Foreground.Listener listener;

   // $FF: synthetic method
   static String access$1000(AppsFlyerLib var0, Context var1) {
      return var0.getConfiguredChannel(var1);
   }

   // $FF: synthetic method
   static String access$1100(AppsFlyerLib var0, Context var1, String var2) throws NameNotFoundException {
      return var0.getCachedChannel(var1, var2);
   }

   // $FF: synthetic method
   static void access$1200(AppsFlyerLib var0, Context var1, String var2, long var3) {
      var0.saveLongToSharedPreferences(var1, var2, var3);
   }

   // $FF: synthetic method
   static Map access$1300(AppsFlyerLib var0, String var1) {
      return var0.attributionStringToMap(var1);
   }

   // $FF: synthetic method
   static void access$1400(AppsFlyerLib var0, Context var1, String var2, String var3) {
      var0.saveDataToSharedPreferences(var1, var2, var3);
   }

   // $FF: synthetic method
   static boolean access$1500() {
      return isDuringCheckCache;
   }

   // $FF: synthetic method
   static boolean access$1502(boolean var0) {
      isDuringCheckCache = var0;
      return var0;
   }

   // $FF: synthetic method
   static long access$1602(long var0) {
      lastCacheCheck = var0;
      return var0;
   }

   // $FF: synthetic method
   static ScheduledExecutorService access$1700() {
      return cacheScheduler;
   }

   // $FF: synthetic method
   static ScheduledExecutorService access$1702(ScheduledExecutorService var0) {
      cacheScheduler = var0;
      return var0;
   }

   // $FF: synthetic method
   static int access$500(AppsFlyerLib var0, Context var1, String var2, boolean var3) {
      return var0.getCounter(var1, var2, var3);
   }

   // $FF: synthetic method
   static long access$600(AppsFlyerLib var0, Context var1, boolean var2) {
      return var0.getTimePassedSinceLastLaunch(var1, var2);
   }

   // $FF: synthetic method
   static void access$800(AppsFlyerLib var0, String var1, String var2, String var3, WeakReference var4, String var5, boolean var6) throws IOException {
      var0.sendRequestToServer(var1, var2, var3, var4, var5, var6);
   }

   private void addAdvertiserIDData(Context param1, Map<String, String> param2) {
      // $FF: Couldn't be decompiled
   }

   private void addDeviceTracking(Context param1, Map<String, String> param2) {
      // $FF: Couldn't be decompiled
   }

   private Map<String, String> attributionStringToMap(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void callRegisterBackground(Context var1) {
      HashMap var2 = new HashMap();
      var2.put("devkey", this.getProperty("AppsFlyerKey"));
      var2.put("uid", this.getAppsFlyerUID(var1));
      var2.put("af_gcm_token", AppsFlyerProperties.getInstance().getString("GCM_TOKEN"));
      var2.put("advertiserId", AppsFlyerProperties.getInstance().getString("advertiserId"));
      var2.put("af_google_instance_id", AppsFlyerProperties.getInstance().getString("GCM_INSTANCE_ID"));
      var2.put("launch_counter", Integer.toString(this.getCounter(var1, "appsFlyerCount", false)));
      var2.put("sdk", Integer.toString(VERSION.SDK_INT));
      if(AppsFlyerProperties.getInstance().getBoolean("collectFingerPrint", true)) {
         String var14 = this.getUniquePsuedoID();
         if(var14 != null) {
            var2.put("deviceFingerPrintId", var14);
         }
      }

      BackgroundHttpTask var10 = new BackgroundHttpTask(var1);
      var10.bodyParameters = var2;
      String[] var11 = new String[]{"https://register.appsflyer.com/api/v4/androidevent?buildnumber=3.2&app_id=" + var1.getPackageName()};
      if(!(var10 instanceof AsyncTask)) {
         var10.execute(var11);
      } else {
         AsyncTaskInstrumentation.execute((AsyncTask)var10, var11);
      }
   }

   private void callServer(URL param1, String param2, String param3, WeakReference<Context> param4, String param5, boolean param6) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private void callStatsBackground(Context var1) {
      AFLogger.afLog("app went to background");
      AppsFlyerProperties.getInstance().saveProperties(var1);
      long var2 = System.currentTimeMillis() - timeInApp;
      HashMap var4 = new HashMap();
      String var5 = this.getProperty("AppsFlyerKey");
      var4.put("app_id", var1.getPackageName());
      var4.put("devkey", var5);
      var4.put("uid", this.getAppsFlyerUID(var1));
      var4.put("time_in_app", String.valueOf(var2 / 1000L));
      var4.put("statType", "user_closed_app");
      var4.put("platform", "Android");
      var4.put("launch_counter", Integer.toString(this.getCounter(var1, "appsFlyerCount", false)));
      var4.put("gcd_conversion_data_timing", Long.toString(var1.getSharedPreferences("appsflyer-data", 0).getLong("appsflyerGetConversionDataTiming", 0L)));
      if(AppsFlyerProperties.getInstance().getBoolean("collectFingerPrint", true)) {
         String var18 = this.getUniquePsuedoID();
         if(var18 != null) {
            var4.put("deviceFingerPrintId", var18);
         }
      }

      BackgroundHttpTask var14 = new BackgroundHttpTask(var1);
      var14.bodyParameters = var4;
      String[] var15 = new String[]{"https://stats.appsflyer.com/stats"};
      if(!(var14 instanceof AsyncTask)) {
         var14.execute(var15);
      } else {
         AsyncTaskInstrumentation.execute((AsyncTask)var14, var15);
      }
   }

   private void checkCache(Context var1) {
      if(!isDuringCheckCache && System.currentTimeMillis() - lastCacheCheck >= 15000L && cacheScheduler == null) {
         cacheScheduler = Executors.newSingleThreadScheduledExecutor();
         cacheScheduler.schedule(new AppsFlyerLib.CachedRequestSender(var1), 1L, TimeUnit.SECONDS);
      }
   }

   private void checkPlatform(Context var1, Map<String, String> var2) {
      try {
         Class.forName("com.unity3d.player.UnityPlayer");
         var2.put("platformextension", "android_unity");
      } catch (ClassNotFoundException var5) {
         var2.put("platformextension", "android_native");
      } catch (Exception var6) {
         ;
      }
   }

   private void debugAction(String var1, String var2, Context var3) {
      if(var3 != null && "com.appsflyer".equals(var3.getPackageName())) {
         DebugLogQueue.getInstance().push(var1 + var2);
      }

   }

   private String getCachedChannel(Context var1, String var2) throws NameNotFoundException {
      SharedPreferences var3 = var1.getSharedPreferences("appsflyer-data", 0);
      if(var3.contains("CACHED_CHANNEL")) {
         return var3.getString("CACHED_CHANNEL", (String)null);
      } else {
         this.saveDataToSharedPreferences(var1, "CACHED_CHANNEL", var2);
         return var2;
      }
   }

   private String getCachedStore(Context var1) {
      SharedPreferences var2 = var1.getSharedPreferences("appsflyer-data", 0);
      if(var2.contains("INSTALL_STORE")) {
         return var2.getString("INSTALL_STORE", (String)null);
      } else {
         boolean var3 = this.isAppsFlyerFirstLaunch(var1);
         String var4 = null;
         if(var3) {
            var4 = this.getCurrentStore(var1);
         }

         this.saveDataToSharedPreferences(var1, "INSTALL_STORE", var4);
         return var4;
      }
   }

   private String getConfiguredChannel(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private int getCounter(Context var1, String var2, boolean var3) {
      SharedPreferences var4 = var1.getSharedPreferences("appsflyer-data", 0);
      int var5 = var4.getInt(var2, 0);
      if(var3) {
         ++var5;
         Editor var6 = var4.edit();
         var6.putInt(var2, var5);
         var6.commit();
      }

      return var5;
   }

   private String getCurrentStore(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private String getFirstInstallDate(SimpleDateFormat var1, Context var2) {
      String var3 = var2.getSharedPreferences("appsflyer-data", 0).getString("appsFlyerFirstInstall", (String)null);
      if(var3 == null) {
         if(this.isAppsFlyerFirstLaunch(var2)) {
            AFLogger.afDebugLog("AppsFlyer: first launch detected");
            var3 = var1.format(new Date());
         } else {
            var3 = "";
         }

         this.saveDataToSharedPreferences(var2, "appsFlyerFirstInstall", var3);
      }

      AFLogger.afLog("AppsFlyer: first launch date: " + var3);
      return var3;
   }

   public static AppsFlyerLib getInstance() {
      return instance;
   }

   private String getNetwork(Context var1) {
      NetworkInfo var2 = ((ConnectivityManager)var1.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var2 != null) {
         if(var2.getType() == 1) {
            return "WIFI";
         }

         if(var2.getType() == 0) {
            return "MOBILE";
         }
      }

      return "unknown";
   }

   private String getPreInstallName(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private long getTimePassedSinceLastLaunch(Context var1, boolean var2) {
      SharedPreferences var3 = var1.getSharedPreferences("appsflyer-data", 0);
      long var4 = var3.getLong("AppsFlyerTimePassedSincePrevLaunch", 0L);
      var3.edit();
      long var7 = System.currentTimeMillis();
      long var9;
      if(var4 > 0L) {
         var9 = var7 - var4;
      } else {
         var9 = -1L;
      }

      if(var2) {
         this.saveLongToSharedPreferences(var1, "AppsFlyerTimePassedSincePrevLaunch", var7);
      }

      return var9 / 1000L;
   }

   private boolean isAppsFlyerFirstLaunch(Context var1) {
      boolean var2 = var1.getSharedPreferences("appsflyer-data", 0).contains("appsFlyerCount");
      boolean var3 = false;
      if(!var2) {
         var3 = true;
      }

      return var3;
   }

   private boolean isGooglePlayServicesAvailable(Context var1) {
      int var3;
      try {
         var3 = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(var1);
      } catch (Exception var5) {
         AFLogger.afLog("WARNING:Google play services is unavailable.");
         return false;
      }

      boolean var4 = false;
      if(var3 == 0) {
         var4 = true;
      }

      return var4;
   }

   private void monitor(Context var1, String var2, String var3, String var4) {
      if(AppsFlyerProperties.getInstance().getBoolean("shouldMonitor", false)) {
         Intent var5 = new Intent("com.appsflyer.MonitorBroadcast");
         var5.setPackage("com.appsflyer.nightvision");
         var5.putExtra("message", var3);
         var5.putExtra("value", var4);
         var5.putExtra("packageName", "true");
         var5.putExtra("pid", new Integer(Process.myPid()));
         var5.putExtra("eventIdentifier", var2);
         var5.putExtra("sdk", "4.3.2");
         var1.sendBroadcast(var5);
      }

   }

   private Map<String, String> referrerStringToMap(Context var1, String var2) {
      LinkedHashMap var3 = new LinkedHashMap();
      String[] var4 = var2.split("&");
      boolean var5 = false;
      int var6 = var4.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String var16 = var4[var7];
         int var17 = var16.indexOf("=");
         String var18;
         if(var17 > 0) {
            var18 = var16.substring(0, var17);
         } else {
            var18 = var16;
         }

         if(!var3.containsKey(var18)) {
            if(var18.equals("c")) {
               var18 = "campaign";
            } else if(var18.equals("pid")) {
               var18 = "media_source";
            } else if(var18.equals("af_prt")) {
               var5 = true;
               var18 = "agency";
            }

            var3.put(var18, new String());
         }

         String var19;
         if(var17 > 0 && var16.length() > var17 + 1) {
            var19 = var16.substring(var17 + 1);
         } else {
            var19 = null;
         }

         var3.put(var18, var19);
      }

      try {
         if(!var3.containsKey("install_time")) {
            long var11 = var1.getPackageManager().getPackageInfo(var1.getPackageName(), 0).firstInstallTime;
            SimpleDateFormat var13 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date var14 = new Date(var11);
            var3.put("install_time", var13.format(var14));
         }
      } catch (Exception var20) {
         AFLogger.afWarnLog("Could not fetch install time");
      }

      if(!var3.containsKey("af_status")) {
         var3.put("af_status", "Non-organic");
      }

      if(var5) {
         var3.remove("media_source");
      }

      return var3;
   }

   private void registerForAppEvents(Activity var1) {
      if(this.listener == null) {
         AppsFlyerProperties.getInstance().loadProperties(var1);
         if(VERSION.SDK_INT < 14) {
            AFLogger.afLog("SDK<14 call trackAppLaunch manually");
            this.trackEvent(var1, (String)null, (Map)null);
            return;
         }

         Foreground.init(var1.getApplication());
         this.listener = new Foreground.Listener() {
            public void onBecameBackground(Activity var1) {
               AFLogger.afLog("onBecameBackground");
               AppsFlyerLib.this.new SchedulerTask(var1.getBaseContext(), 1);
            }

            public void onBecameForeground(Activity var1) {
               AFLogger.afLog("onBecameForeground");
               AppsFlyerLib.this.trackEvent(var1, (String)null, (Map)null);
            }
         };
         Foreground.getInstance().addListener(this.listener);
      }

   }

   private void registerOnGCM(final Context var1) {
      final String var2 = AppsFlyerProperties.getInstance().getString("GCM_PROJECT_ID");
      if(var2 != null && AppsFlyerProperties.getInstance().getString("GCM_TOKEN") == null) {
         (new Thread(new Runnable() {
            public void run() {
               try {
                  InstanceID var3 = InstanceID.getInstance(var1);
                  String var4 = var3.getToken(var2, "GCM", (Bundle)null);
                  AFLogger.afLog("-------token=" + var4);
                  AppsFlyerProperties.getInstance().set("GCM_TOKEN", var4);
                  String var5 = var3.getId();
                  AFLogger.afLog("-------instance id=" + var5);
                  AppsFlyerProperties.getInstance().set("GCM_INSTANCE_ID", var5);
                  AppsFlyerLib.this.callRegisterBackground(var1);
               } catch (Exception var6) {
                  AFLogger.afLogE("Could not load registration ID", var6);
               } catch (Error var7) {
                  AFLogger.afLogE("Caught Exception", var7);
               }
            }
         })).start();
      }

   }

   private void runInBackground(Context var1, String var2, String var3, String var4, String var5, boolean var6) {
      ScheduledExecutorService var7 = Executors.newSingleThreadScheduledExecutor();
      var7.schedule(new AppsFlyerLib.DataCollector(var1, var2, var3, var4, var5, var6, var7, null), 5L, TimeUnit.MILLISECONDS);
   }

   private void saveDataToSharedPreferences(Context var1, String var2, String var3) {
      Editor var4 = var1.getSharedPreferences("appsflyer-data", 0).edit();
      var4.putString(var2, var3);
      if(VERSION.SDK_INT >= 9) {
         var4.apply();
      } else {
         var4.commit();
      }
   }

   private void saveIntegerToSharedPreferences(Context var1, String var2, int var3) {
      Editor var4 = var1.getSharedPreferences("appsflyer-data", 0).edit();
      var4.putInt(var2, var3);
      if(VERSION.SDK_INT >= 9) {
         var4.apply();
      } else {
         var4.commit();
      }
   }

   private void saveLongToSharedPreferences(Context var1, String var2, long var3) {
      Editor var5 = var1.getSharedPreferences("appsflyer-data", 0).edit();
      var5.putLong(var2, var3);
      if(VERSION.SDK_INT >= 9) {
         var5.apply();
      } else {
         var5.commit();
      }
   }

   private void sendRequestToServer(String var1, String var2, String var3, WeakReference<Context> var4, String var5, boolean var6) throws IOException {
      URL var7 = new URL(var1);
      AFLogger.afLog("url: " + var7.toString());
      this.debugAction("call server.", "\n" + var7.toString() + "\nPOST:" + var2, (Context)var4.get());
      LogMessages.logMessageMaskKey("data: " + var2);
      this.monitor((Context)var4.get(), "AppsFlyer_3.2", "EVENT_DATA", var2);
      if(var6) {
         AppsFlyerProperties.getInstance().setLaunchCollectedReferrer();
      }

      try {
         this.callServer(var7, var2, var3, var4, var5, var6);
      } catch (IOException var9) {
         if(AppsFlyerProperties.getInstance().getBoolean("useHttpFallback", false)) {
            this.debugAction("https failed: " + var9.getLocalizedMessage(), "", (Context)var4.get());
            this.callServer(new URL(var1.replace("https:", "http:")), var2, var3, var4, var5, var6);
         } else {
            AFLogger.afLog("failed to send requeset to server. " + var9.getLocalizedMessage());
            this.monitor((Context)var4.get(), "AppsFlyer_3.2", "ERROR", var9.getLocalizedMessage());
            throw var9;
         }
      }
   }

   private void sendTrackingWithEvent(Context param1, String param2, String param3, String param4, String param5, boolean param6) {
      // $FF: Couldn't be decompiled
   }

   public String getAppUserId() {
      return this.getProperty("AppUserId");
   }

   public String getAppsFlyerUID(Context var1) {
      return Installation.method_358(var1);
   }

   public String getAttributionId(ContentResolver param1) {
      // $FF: Couldn't be decompiled
   }

   public Map<String, String> getConversionData(Context var1) throws AttributionIDNotReady {
      SharedPreferences var2 = var1.getSharedPreferences("appsflyer-data", 0);
      String var3 = AppsFlyerProperties.getInstance().getReferrer(var1);
      if(var3 != null && var3.length() > 0 && var3.contains("af_tranid")) {
         return this.referrerStringToMap(var1, var3);
      } else {
         String var4 = var2.getString("attributionId", (String)null);
         if(var4 != null && var4.length() > 0) {
            return this.attributionStringToMap(var4);
         } else {
            throw new AttributionIDNotReady();
         }
      }
   }

   public String getProperty(String var1) {
      return AppsFlyerProperties.getInstance().getString(var1);
   }

   public String getUniquePsuedoID() {
      String var1 = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10;

      try {
         String var3 = Build.class.getField("SERIAL").get((Object)null).toString();
         String var4 = (new UUID((long)var1.hashCode(), (long)var3.hashCode())).toString();
         return var4;
      } catch (Exception var5) {
         return (new UUID((long)var1.hashCode(), (long)"serial".hashCode())).toString();
      }
   }

   public boolean isPreInstalledApp(Context var1) {
      int var3;
      try {
         var3 = var1.getPackageManager().getApplicationInfo(var1.getPackageName(), 0).flags;
      } catch (NameNotFoundException var6) {
         AFLogger.afLogE("Could not check if app is pre installed", var6);
         return false;
      }

      int var4 = var3 & 1;
      boolean var5 = false;
      if(var4 != 0) {
         var5 = true;
      }

      return var5;
   }

   public String mapToString(Map<String, String> var1) throws UnsupportedEncodingException {
      StringBuilder var2 = new StringBuilder();

      String var4;
      String var6;
      for(Iterator var3 = var1.keySet().iterator(); var3.hasNext(); var2.append(var4).append('=').append(var6)) {
         var4 = (String)var3.next();
         String var5 = (String)var1.get(var4);
         if(var5 == null) {
            var6 = "";
         } else {
            var6 = URLEncoder.encode(var5, "UTF-8");
         }

         if(var2.length() > 0) {
            var2.append('&');
         }
      }

      return var2.toString();
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("shouldMonitor");
      if(var3 != null) {
         AFLogger.afLog("Turning on monitoring.");
         AppsFlyerProperties.getInstance().set("shouldMonitor", var3.equals("true"));
         this.monitor(var1, (String)null, "START_TRACKING", var1.getPackageName());
      } else {
         AFLogger.afLog("****** onReceive called *******");
         this.debugAction("******* onReceive: ", "", var1);
         AppsFlyerProperties.getInstance().setOnReceiveCalled();
         String var4 = var2.getStringExtra("referrer");
         AFLogger.afLog("Play store referrer: " + var4);
         if(var4 != null) {
            this.debugAction("BroadcastReceiver got referrer: ", var4, var1);
            this.debugAction("onRecieve called. refferer=", var4, var1);
            this.saveDataToSharedPreferences(var1, "referrer", var4);
            AppsFlyerProperties.getInstance().setReferrer(var4);
            if(AppsFlyerProperties.getInstance().isLaunchCollectedReferrerd()) {
               AFLogger.afLog("onReceive: isLaunchCalled");
               this.runInBackground(var1, (String)null, (String)null, (String)null, var4, false);
               return;
            }
         }
      }

   }

   public void registerConversionListener(Context var1, AppsFlyerConversionListener var2) {
      if(var2 != null) {
         conversionDataListener = var2;
      }
   }

   protected void setProperty(String var1, String var2) {
      AppsFlyerProperties.getInstance().set(var1, var2);
   }

   public void startTracking(Activity var1, String var2) {
      this.registerOnGCM(var1);
      this.registerForAppEvents(var1);
      this.setProperty("AppsFlyerKey", var2);
      LogMessages.setDevKey(var2);
   }

   public void trackEvent(Context var1, String var2, Map<String, Object> var3) {
      if(var3 == null) {
         var3 = new HashMap();
      }

      JSONObject var4 = new JSONObject((Map)var3);
      String var5 = AppsFlyerProperties.getInstance().getReferrer(var1);
      String var6;
      if(!(var4 instanceof JSONObject)) {
         var6 = var4.toString();
      } else {
         var6 = JSONObjectInstrumentation.toString((JSONObject)var4);
      }

      String var7;
      if(var5 == null) {
         var7 = "";
      } else {
         var7 = var5;
      }

      this.runInBackground(var1, (String)null, var2, var6, var7, true);
   }

   private abstract class AttributionIdFetcher implements Runnable {
      private String appsFlyerDevKey;
      protected WeakReference<Context> ctxReference = null;
      private AtomicInteger currentRequestsCounter = new AtomicInteger(0);
      private ScheduledExecutorService executorService;

      public AttributionIdFetcher(Context var2, String var3, ScheduledExecutorService var4) {
         this.ctxReference = new WeakReference(var2);
         this.appsFlyerDevKey = var3;
         this.executorService = var4;
      }

      protected abstract void attributionCallback(Map<String, String> var1);

      protected abstract void attributionCallbackFailure(String var1, int var2);

      public abstract String getUrl();

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   private class CachedRequestSender implements Runnable {
      private WeakReference<Context> ctxReference = null;

      public CachedRequestSender(Context var2) {
         this.ctxReference = new WeakReference(var2);
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   private class DataCollector implements Runnable {
      private String appsFlyerKey;
      private Context context;
      private String eventName;
      private String eventValue;
      private ExecutorService executor;
      private boolean isNewAPI;
      private String referrer;

      private DataCollector(Context var2, String var3, String var4, String var5, String var6, boolean var7, ExecutorService var8) {
         this.context = var2;
         this.appsFlyerKey = var3;
         this.eventName = var4;
         this.eventValue = var5;
         this.referrer = var6;
         this.isNewAPI = var7;
         this.executor = var8;
      }

      // $FF: synthetic method
      DataCollector(Context var2, String var3, String var4, String var5, String var6, boolean var7, ExecutorService var8, Object var9) {
         this();
      }

      public void run() {
         AppsFlyerLib.this.sendTrackingWithEvent(this.context, this.appsFlyerKey, this.eventName, this.eventValue, this.referrer, this.isNewAPI);
         this.executor.shutdown();
      }
   }

   private class InstallAttributionIdFetcher extends AppsFlyerLib.AttributionIdFetcher {
      public InstallAttributionIdFetcher(Context var2, String var3, ScheduledExecutorService var4) {
         super();
      }

      protected void attributionCallback(Map<String, String> var1) {
         AppsFlyerLib.conversionDataListener.onInstallConversionDataLoaded(var1);
         ((Context)this.ctxReference.get()).getSharedPreferences("appsflyer-data", 0);
         AppsFlyerLib.this.saveIntegerToSharedPreferences((Context)this.ctxReference.get(), "appsflyerConversionDataRequestRetries", 0);
      }

      protected void attributionCallbackFailure(String var1, int var2) {
         AppsFlyerLib.conversionDataListener.onInstallConversionFailure(var1);
         if(var2 >= 400 && var2 < 500) {
            int var3 = ((Context)this.ctxReference.get()).getSharedPreferences("appsflyer-data", 0).getInt("appsflyerConversionDataRequestRetries", 0);
            AppsFlyerLib.this.saveIntegerToSharedPreferences((Context)this.ctxReference.get(), "appsflyerConversionDataRequestRetries", var3 + 1);
         }

      }

      public String getUrl() {
         return "https://api.appsflyer.com/install_data/v3/";
      }
   }

   public class SchedulerTask {
      Timer timer = new Timer();

      public SchedulerTask(Context var2, int var3) {
         this.timer.schedule(new AppsFlyerLib.checkResumeTask(var2), (long)(var3 * 1000));
      }
   }

   class checkResumeTask extends TimerTask {
      private Context context;

      public checkResumeTask(Context var2) {
         this.context = var2;
      }

      public void run() {
         AFLogger.afLog("callStatsBackground background call");
         AppsFlyerLib.super.this$0.callStatsBackground(this.context);
         AppsFlyerLib.super.timer.cancel();
      }
   }

   private class SendToServerRunnable implements Runnable {
      private WeakReference<Context> ctxReference;
      boolean isLaunch;
      Map<String, String> params;
      private String urlString;

      private SendToServerRunnable(String var1, Map<String, String> var2, Context var3, boolean var4) {
         this.ctxReference = null;
         this.urlString = var2;
         this.params = var3;
         this.ctxReference = new WeakReference(var4);
         this.isLaunch = var5;
      }

      // $FF: synthetic method
      SendToServerRunnable(String var2, Map var3, Context var4, boolean var5, Object var6) {
         this();
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
