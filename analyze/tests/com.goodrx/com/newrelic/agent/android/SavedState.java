package com.newrelic.agent.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SavedState extends HarvestAdapter {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final String NEW_RELIC_AGENT_DISABLED_VERSION_KEY = "NewRelicAgentDisabledVersion";
   private final String PREFERENCE_FILE_PREFIX = "com.newrelic.android.agent.v1_";
   private final String PREF_ACTIVITY_TRACE_MIN_UTILIZATION = "activityTraceMinUtilization";
   private final String PREF_AGENT_NAME = "agentName";
   private final String PREF_AGENT_VERSION = "agentVersion";
   private final String PREF_APP_BUILD = "appBuild";
   private final String PREF_APP_NAME = "appName";
   private final String PREF_APP_TOKEN = "appToken";
   private final String PREF_APP_VERSION = "appVersion";
   private final String PREF_COLLECT_NETWORK_ERRORS = "collectNetworkErrors";
   private final String PREF_CROSS_PROCESS_ID = "crossProcessId";
   private final String PREF_DATA_TOKEN = "dataToken";
   private final String PREF_DEVICE_ARCHITECTURE = "deviceArchitecture";
   private final String PREF_DEVICE_ID = "deviceId";
   private final String PREF_DEVICE_MANUFACTURER = "deviceManufacturer";
   private final String PREF_DEVICE_MODEL = "deviceModel";
   private final String PREF_DEVICE_RUN_TIME = "deviceRunTime";
   private final String PREF_DEVICE_SIZE = "deviceSize";
   private final String PREF_ERROR_LIMIT = "errorLimit";
   private final String PREF_HARVEST_INTERVAL = "harvestIntervalInSeconds";
   private final String PREF_MAX_TRANSACTION_AGE = "maxTransactionAgeInSeconds";
   private final String PREF_MAX_TRANSACTION_COUNT = "maxTransactionCount";
   private final String PREF_OS_BUILD = "osBuild";
   private final String PREF_OS_NAME = "osName";
   private final String PREF_OS_VERSION = "osVersion";
   private final String PREF_PACKAGE_ID = "packageId";
   private final String PREF_RESPONSE_BODY_LIMIT = "responseBodyLimit";
   private final String PREF_SERVER_TIMESTAMP = "serverTimestamp";
   private final String PREF_STACK_TRACE_LIMIT = "stackTraceLimit";
   private final String PREF_VERSION_CODE = "versionCode";
   private Float activityTraceMinUtilization;
   private final HarvestConfiguration configuration = new HarvestConfiguration();
   private final ConnectInformation connectInformation = new ConnectInformation(new ApplicationInformation(), new DeviceInformation());
   private final Editor editor;
   private final Lock lock = new ReentrantLock();
   private final SharedPreferences prefs;

   public SavedState(Context var1) {
      this.prefs = var1.getSharedPreferences(this.getPreferenceFileName(var1.getPackageName()), 0);
      this.editor = this.prefs.edit();
      this.loadHarvestConfiguration();
      this.loadConnectInformation();
   }

   private String getPreferenceFileName(String var1) {
      return "com.newrelic.android.agent.v1_" + var1;
   }

   private boolean has(String var1) {
      return this.prefs.contains(var1);
   }

   private void saveApplicationInformation(ApplicationInformation var1) {
      this.save("appName", var1.getAppName());
      this.save("appVersion", var1.getAppVersion());
      this.save("appBuild", var1.getAppBuild());
      this.save("packageId", var1.getPackageId());
      this.save("versionCode", var1.getVersionCode());
   }

   private void saveDeviceInformation(DeviceInformation var1) {
      this.save("agentName", var1.getAgentName());
      this.save("agentVersion", var1.getAgentVersion());
      this.save("deviceArchitecture", var1.getArchitecture());
      this.save("deviceId", var1.getDeviceId());
      this.save("deviceModel", var1.getModel());
      this.save("deviceManufacturer", var1.getManufacturer());
      this.save("deviceRunTime", var1.getRunTime());
      this.save("deviceSize", var1.getSize());
      this.save("osName", var1.getOsName());
      this.save("osBuild", var1.getOsBuild());
      this.save("osVersion", var1.getOsVersion());
   }

   public void clear() {
      this.lock.lock();

      try {
         this.editor.clear();
         this.editor.commit();
         this.configuration.setDefaultValues();
      } finally {
         this.lock.unlock();
      }

   }

   public float getActivityTraceMinUtilization() {
      if(this.activityTraceMinUtilization == null) {
         this.activityTraceMinUtilization = this.getFloat("activityTraceMinUtilization");
      }

      return this.activityTraceMinUtilization.floatValue();
   }

   public String getAgentName() {
      return this.getString("agentName");
   }

   public String getAgentVersion() {
      return this.getString("agentVersion");
   }

   public String getAppBuild() {
      return this.getString("appBuild");
   }

   public String getAppName() {
      return this.getString("appName");
   }

   public String getAppToken() {
      return this.getString("appToken");
   }

   public String getAppVersion() {
      return this.getString("appVersion");
   }

   public boolean getBoolean(String var1) {
      return this.prefs.getBoolean(var1, false);
   }

   public ConnectInformation getConnectInformation() {
      return this.connectInformation;
   }

   public String getCrossProcessId() {
      return this.getString("crossProcessId");
   }

   public int[] getDataToken() {
      // $FF: Couldn't be decompiled
   }

   public String getDeviceArchitecture() {
      return this.getString("deviceArchitecture");
   }

   public String getDeviceId() {
      return this.getString("deviceId");
   }

   public String getDeviceManufacturer() {
      return this.getString("deviceManufacturer");
   }

   public String getDeviceModel() {
      return this.getString("deviceModel");
   }

   public String getDeviceRunTime() {
      return this.getString("deviceRunTime");
   }

   public String getDeviceSize() {
      return this.getString("deviceSize");
   }

   public String getDisabledVersion() {
      return this.getString("NewRelicAgentDisabledVersion");
   }

   public int getErrorLimit() {
      return this.getInt("errorLimit");
   }

   public Float getFloat(String var1) {
      return !this.prefs.contains(var1)?null:Float.valueOf((float)((int)(100.0F * this.prefs.getFloat(var1, 0.0F))) / 100.0F);
   }

   public HarvestConfiguration getHarvestConfiguration() {
      return this.configuration;
   }

   public long getHarvestInterval() {
      return this.getLong("harvestIntervalInSeconds");
   }

   public long getHarvestIntervalInSeconds() {
      return this.getHarvestInterval();
   }

   public int getInt(String var1) {
      return this.prefs.getInt(var1, 0);
   }

   public long getLong(String var1) {
      return this.prefs.getLong(var1, 0L);
   }

   public long getMaxTransactionAge() {
      return this.getLong("maxTransactionAgeInSeconds");
   }

   public long getMaxTransactionAgeInSeconds() {
      return this.getMaxTransactionAge();
   }

   public long getMaxTransactionCount() {
      return this.getLong("maxTransactionCount");
   }

   public String getOsBuild() {
      return this.getString("osBuild");
   }

   public String getOsName() {
      return this.getString("osName");
   }

   public String getOsVersion() {
      return this.getString("osVersion");
   }

   public String getPackageId() {
      return this.getString("packageId");
   }

   public int getResponseBodyLimit() {
      return this.getInt("responseBodyLimit");
   }

   public long getServerTimestamp() {
      return this.getLong("serverTimestamp");
   }

   public int getStackTraceLimit() {
      return this.getInt("stackTraceLimit");
   }

   public String getString(String var1) {
      return !this.prefs.contains(var1)?null:this.prefs.getString(var1, (String)null);
   }

   public int getVersionCode() {
      return this.getInt("versionCode");
   }

   public boolean isCollectingNetworkErrors() {
      return this.getBoolean("collectNetworkErrors");
   }

   public void loadConnectInformation() {
      ApplicationInformation var1 = new ApplicationInformation();
      if(this.has("appName")) {
         var1.setAppName(this.getAppName());
      }

      if(this.has("appVersion")) {
         var1.setAppVersion(this.getAppVersion());
      }

      if(this.has("appBuild")) {
         var1.setAppBuild(this.getAppBuild());
      }

      if(this.has("packageId")) {
         var1.setPackageId(this.getPackageId());
      }

      if(this.has("versionCode")) {
         var1.setVersionCode(this.getVersionCode());
      }

      DeviceInformation var2 = new DeviceInformation();
      if(this.has("agentName")) {
         var2.setAgentName(this.getAgentName());
      }

      if(this.has("agentVersion")) {
         var2.setAgentVersion(this.getAgentVersion());
      }

      if(this.has("deviceArchitecture")) {
         var2.setArchitecture(this.getDeviceArchitecture());
      }

      if(this.has("deviceId")) {
         var2.setDeviceId(this.getDeviceId());
      }

      if(this.has("deviceModel")) {
         var2.setModel(this.getDeviceModel());
      }

      if(this.has("deviceManufacturer")) {
         var2.setManufacturer(this.getDeviceManufacturer());
      }

      if(this.has("deviceRunTime")) {
         var2.setRunTime(this.getDeviceRunTime());
      }

      if(this.has("deviceSize")) {
         var2.setSize(this.getDeviceSize());
      }

      if(this.has("osName")) {
         var2.setOsName(this.getOsName());
      }

      if(this.has("osBuild")) {
         var2.setOsBuild(this.getOsBuild());
      }

      if(this.has("osVersion")) {
         var2.setOsVersion(this.getOsVersion());
      }

      this.connectInformation.setApplicationInformation(var1);
      this.connectInformation.setDeviceInformation(var2);
   }

   public void loadHarvestConfiguration() {
      if(this.has("dataToken")) {
         this.configuration.setData_token(this.getDataToken());
      }

      if(this.has("crossProcessId")) {
         this.configuration.setCross_process_id(this.getCrossProcessId());
      }

      if(this.has("serverTimestamp")) {
         this.configuration.setServer_timestamp(this.getServerTimestamp());
      }

      if(this.has("harvestIntervalInSeconds")) {
         this.configuration.setData_report_period((int)this.getHarvestIntervalInSeconds());
      }

      if(this.has("maxTransactionAgeInSeconds")) {
         this.configuration.setReport_max_transaction_age((int)this.getMaxTransactionAgeInSeconds());
      }

      if(this.has("maxTransactionCount")) {
         this.configuration.setReport_max_transaction_count((int)this.getMaxTransactionCount());
      }

      if(this.has("stackTraceLimit")) {
         this.configuration.setStack_trace_limit(this.getStackTraceLimit());
      }

      if(this.has("responseBodyLimit")) {
         this.configuration.setResponse_body_limit(this.getResponseBodyLimit());
      }

      if(this.has("collectNetworkErrors")) {
         this.configuration.setCollect_network_errors(this.isCollectingNetworkErrors());
      }

      if(this.has("errorLimit")) {
         this.configuration.setError_limit(this.getErrorLimit());
      }

      if(this.has("activityTraceMinUtilization")) {
         this.configuration.setActivity_trace_min_utilization((double)this.getActivityTraceMinUtilization());
      }

      log.info("Loaded configuration: " + this.configuration);
   }

   public void onHarvestComplete() {
      this.saveHarvestConfiguration(Harvest.getHarvestConfiguration());
   }

   public void onHarvestConnected() {
      this.saveHarvestConfiguration(Harvest.getHarvestConfiguration());
   }

   public void onHarvestDisabled() {
      String var1 = Agent.getDeviceInformation().getAgentVersion();
      log.info("Disabling agent version " + var1);
      this.saveDisabledVersion(var1);
   }

   public void onHarvestDisconnected() {
      log.info("Clearing harvest configuration.");
      this.clear();
   }

   public void save(String var1, float var2) {
      this.lock.lock();

      try {
         this.editor.putFloat(var1, var2);
         this.editor.commit();
      } finally {
         this.lock.unlock();
      }

   }

   public void save(String var1, int var2) {
      this.lock.lock();

      try {
         this.editor.putInt(var1, var2);
         this.editor.commit();
      } finally {
         this.lock.unlock();
      }

   }

   public void save(String var1, long var2) {
      this.lock.lock();

      try {
         this.editor.putLong(var1, var2);
         this.editor.commit();
      } finally {
         this.lock.unlock();
      }

   }

   public void save(String var1, String var2) {
      this.lock.lock();

      try {
         this.editor.putString(var1, var2);
         this.editor.commit();
      } finally {
         this.lock.unlock();
      }

   }

   public void save(String var1, boolean var2) {
      this.lock.lock();

      try {
         this.editor.putBoolean(var1, var2);
         this.editor.commit();
      } finally {
         this.lock.unlock();
      }

   }

   public void saveActivityTraceMinUtilization(float var1) {
      this.activityTraceMinUtilization = Float.valueOf(var1);
      this.save("activityTraceMinUtilization", var1);
   }

   public void saveAppToken(String var1) {
      this.save("appToken", var1);
   }

   public void saveConnectInformation(ConnectInformation var1) {
      if(!this.connectInformation.equals(var1)) {
         this.saveApplicationInformation(var1.getApplicationInformation());
         this.saveDeviceInformation(var1.getDeviceInformation());
         this.loadConnectInformation();
      }
   }

   public void saveDeviceId(String var1) {
      this.save("deviceId", var1);
      this.connectInformation.getDeviceInformation().setDeviceId(var1);
   }

   public void saveDisabledVersion(String var1) {
      this.save("NewRelicAgentDisabledVersion", var1);
   }

   public void saveHarvestConfiguration(HarvestConfiguration var1) {
      if(!this.configuration.equals(var1)) {
         if(!var1.getDataToken().isValid()) {
            var1.setData_token(this.configuration.getData_token());
         }

         log.info("Saving configuration: " + var1);
         String var2 = var1.getDataToken().toJsonString();
         log.debug("!! saving data token: " + var2);
         this.save("dataToken", var2);
         this.save("crossProcessId", var1.getCross_process_id());
         this.save("serverTimestamp", var1.getServer_timestamp());
         this.save("harvestIntervalInSeconds", (long)var1.getData_report_period());
         this.save("maxTransactionAgeInSeconds", (long)var1.getReport_max_transaction_age());
         this.save("maxTransactionCount", (long)var1.getReport_max_transaction_count());
         this.save("stackTraceLimit", var1.getStack_trace_limit());
         this.save("responseBodyLimit", var1.getResponse_body_limit());
         this.save("collectNetworkErrors", var1.isCollect_network_errors());
         this.save("errorLimit", var1.getError_limit());
         this.saveActivityTraceMinUtilization((float)var1.getActivity_trace_min_utilization());
         this.loadHarvestConfiguration();
      }
   }
}
