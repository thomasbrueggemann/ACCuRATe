package com.newrelic.agent.android;

import com.newrelic.agent.android.analytics.AnalyticAttributeStore;
import com.newrelic.agent.android.crashes.CrashStore;
import java.util.UUID;

public class AgentConfiguration {
   private static final String DEFAULT_COLLECTOR_HOST = "mobile-collector.newrelic.com";
   private static final String DEFAULT_CRASH_COLLECTOR_HOST = "mobile-crash.newrelic.com";
   private AnalyticAttributeStore analyticAttributeStore;
   private String appName;
   private String applicationToken;
   private String collectorHost = "mobile-collector.newrelic.com";
   private String crashCollectorHost = "mobile-crash.newrelic.com";
   private CrashStore crashStore;
   private String customApplicationVersion = null;
   private String customBuildId = null;
   private boolean enableAnalyticsEvents = true;
   private boolean reportCrashes = true;
   private String sessionID = this.provideSessionId();
   private boolean useLocationService;
   private boolean useSsl = true;

   public AnalyticAttributeStore getAnalyticAttributeStore() {
      return this.analyticAttributeStore;
   }

   public String getAppName() {
      return this.appName;
   }

   public String getApplicationToken() {
      return this.applicationToken;
   }

   public String getCollectorHost() {
      return this.collectorHost;
   }

   public String getCrashCollectorHost() {
      return this.crashCollectorHost;
   }

   public CrashStore getCrashStore() {
      return this.crashStore;
   }

   public String getCustomApplicationVersion() {
      return this.customApplicationVersion;
   }

   public String getCustomBuildIdentifier() {
      return this.customBuildId;
   }

   public boolean getEnableAnalyticsEvents() {
      return this.enableAnalyticsEvents;
   }

   public boolean getReportCrashes() {
      return this.reportCrashes;
   }

   public String getSessionID() {
      return this.sessionID;
   }

   protected String provideSessionId() {
      this.sessionID = UUID.randomUUID().toString();
      return this.sessionID;
   }

   public void setAnalyticAttributeStore(AnalyticAttributeStore var1) {
      this.analyticAttributeStore = var1;
   }

   public void setAppName(String var1) {
      this.appName = var1;
   }

   public void setApplicationToken(String var1) {
      this.applicationToken = var1;
   }

   public void setCollectorHost(String var1) {
      this.collectorHost = var1;
   }

   public void setCrashCollectorHost(String var1) {
      this.crashCollectorHost = var1;
   }

   public void setCrashStore(CrashStore var1) {
      this.crashStore = var1;
   }

   public void setCustomApplicationVersion(String var1) {
      this.customApplicationVersion = var1;
   }

   public void setCustomBuildIdentifier(String var1) {
      this.customBuildId = var1;
   }

   public void setEnableAnalyticsEvents(boolean var1) {
      this.enableAnalyticsEvents = var1;
   }

   public void setReportCrashes(boolean var1) {
      this.reportCrashes = var1;
   }

   public void setSessionID(String var1) {
      this.sessionID = var1;
   }

   public void setUseLocationService(boolean var1) {
      this.useLocationService = var1;
   }

   public void setUseSsl(boolean var1) {
      this.useSsl = var1;
   }

   public boolean useLocationService() {
      return this.useLocationService;
   }

   public boolean useSsl() {
      return this.useSsl;
   }
}
