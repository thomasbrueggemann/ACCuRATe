package com.comscore.analytics;

import android.content.Context;
import com.comscore.analytics.Core;
import com.comscore.applications.EventType;
import com.comscore.utils.TransmissionMode;
import java.util.HashMap;

public class comScore {
   // $FF: renamed from: a com.comscore.analytics.Core
   private static Core field_459 = new Core();

   public static void aggregate(HashMap<String, String> var0) {
      field_459.notify(EventType.AGGREGATE, var0, true);
   }

   public static void allowLiveTransmission(TransmissionMode var0) {
      field_459.allowLiveTransmission(var0, true);
   }

   public static void allowOfflineTransmission(TransmissionMode var0) {
      field_459.allowOfflineTransmission(var0, true);
   }

   public static void disableAutoUpdate() {
      field_459.disableAutoUpdate();
   }

   public static void enableAutoUpdate() {
      enableAutoUpdate(60, true);
   }

   public static void enableAutoUpdate(int var0) {
      enableAutoUpdate(var0, true);
   }

   public static void enableAutoUpdate(int var0, boolean var1) {
      field_459.enableAutoUpdate(var0, var1, true);
   }

   public static void flushCache() {
      field_459.flush(true);
   }

   public static String getAppName() {
      return field_459.getAppName();
   }

   public static String getAutoStartLabel(String var0) {
      return field_459.getAutoStartLabel(var0);
   }

   public static HashMap<String, String> getAutoStartLabels() {
      return field_459.getAutoStartLabels();
   }

   public static long getCacheFlushingInterval() {
      return field_459.getCacheFlushingInterval();
   }

   public static int getCacheMaxBatchFiles() {
      return field_459.getCacheMaxBatchFiles();
   }

   public static int getCacheMaxFlushesInARow() {
      return field_459.getCacheMaxFlushesInARow();
   }

   public static int getCacheMaxMeasurements() {
      return field_459.getCacheMaxMeasurements();
   }

   public static long getCacheMeasurementExpiry() {
      return field_459.getCacheMeasurementExpiry();
   }

   public static long getCacheMinutesToRetry() {
      return field_459.getCacheMinutesToRetry();
   }

   public static Core getCore() {
      return field_459;
   }

   public static String getCustomerC2() {
      return field_459.getCustomerC2();
   }

   public static boolean getErrorHandlingEnabled() {
      return field_459.getErrorHandlingEnabled();
   }

   public static long getGenesis() {
      return field_459.getGenesis();
   }

   public static String getLabel(String var0) {
      return field_459.getLabel(var0);
   }

   public static HashMap<String, String> getLabels() {
      return field_459.getLabels();
   }

   public static TransmissionMode getLiveTransmissionMode() {
      return field_459.getLiveTransmissionMode();
   }

   public static String[] getMeasurementLabelOrder() {
      return field_459.getMeasurementLabelOrder();
   }

   public static TransmissionMode getOfflineTransmissionMode() {
      return field_459.getOfflineTransmissionMode();
   }

   public static String getPixelURL() {
      return field_459.getPixelURL();
   }

   public static String getPublisherSecret() {
      return field_459.getPublisherSecret();
   }

   public static String getVersion() {
      return field_459.getVersion();
   }

   public static String getVisitorID() {
      return field_459.getVisitorId();
   }

   public static void hidden() {
      field_459.notify(EventType.HIDDEN, new HashMap(), true);
   }

   public static void hidden(HashMap<String, String> var0) {
      field_459.notify(EventType.HIDDEN, var0, true);
   }

   public static boolean isAutoStartEnabled() {
      return field_459.isAutoStartEnabled();
   }

   public static boolean isEnabled() {
      return field_459.isEnabled();
   }

   public static boolean isKeepAliveEnabled() {
      return field_459.isKeepAliveEnabled();
   }

   public static boolean isSecure() {
      return field_459.isSecure();
   }

   public static void onEnterForeground() {
      field_459.onEnterForeground();
   }

   public static void onExitForeground() {
      field_459.onExitForeground();
   }

   public static void onUserInteraction() {
      field_459.onUserInteraction();
   }

   public static void onUxActive() {
      field_459.onUxActive();
   }

   public static void onUxInactive() {
      field_459.onUxInactive();
   }

   public static void setAppContext(Context var0) {
      field_459.setAppContext(var0);
   }

   public static void setAppName(String var0) {
      field_459.setAppName(var0, true);
   }

   public static void setAutoStartEnabled(boolean var0) {
      field_459.setAutoStartEnabled(var0, true);
   }

   public static void setAutoStartLabel(String var0, String var1) {
      field_459.setAutoStartLabel(var0, var1);
   }

   public static void setAutoStartLabels(HashMap<String, String> var0) {
      field_459.setAutoStartLabels(var0);
   }

   public static void setCacheFlushingInterval(long var0) {
      field_459.setCacheFlushingInterval(var0, true);
   }

   public static void setCacheMaxBatchFiles(int var0) {
      field_459.setCacheMaxBatchFiles(var0, true);
   }

   public static void setCacheMaxFlushesInARow(int var0) {
      field_459.setCacheMaxFlushesInARow(var0, true);
   }

   public static void setCacheMaxMeasurements(int var0) {
      field_459.setCacheMaxMeasurements(var0, true);
   }

   public static void setCacheMeasurementExpiry(int var0) {
      field_459.setCacheMeasurementExpiry(var0, true);
   }

   public static void setCacheMinutesToRetry(int var0) {
      field_459.setCacheMinutesToRetry(var0, true);
   }

   public static void setCustomerC2(String var0) {
      field_459.setCustomerC2(var0, true);
   }

   public static void setDebug(boolean var0) {
      field_459.setDebug(var0);
   }

   public static void setEnabled(boolean var0) {
      field_459.setEnabled(var0);
   }

   public static void setErrorHandlingEnabled(boolean var0) {
      field_459.setErrorHandlingEnabled(var0);
   }

   public static void setKeepAliveEnabled(boolean var0) {
      field_459.setKeepAliveEnabled(var0, true);
   }

   public static void setLabel(String var0, String var1) {
      field_459.setLabel(var0, var1, true);
   }

   public static void setLabels(HashMap<String, String> var0) {
      field_459.setLabels(var0, true);
   }

   public static void setMeasurementLabelOrder(String[] var0) {
      field_459.setMeasurementLabelOrder(var0, true);
   }

   public static void setOfflineURL(String var0) {
      field_459.setOfflineURL(var0);
   }

   public static void setPixelURL(String var0) {
      field_459.setPixelURL(var0, true);
   }

   public static void setPublisherSecret(String var0) {
      field_459.setPublisherSecret(var0, true);
   }

   public static void setSecure(boolean var0) {
      field_459.setSecure(var0, true);
   }

   public static void start() {
      field_459.notify(EventType.START, new HashMap(), true);
   }

   public static void start(HashMap<String, String> var0) {
      field_459.notify(EventType.START, var0, true);
   }

   public static void update() {
      field_459.update();
   }

   public static void view() {
      field_459.notify(EventType.VIEW, new HashMap(), true);
   }

   public static void view(HashMap<String, String> var0) {
      field_459.notify(EventType.VIEW, var0, true);
   }

   public static void waitForTasks() {
      field_459.getTaskExecutor().waitForTasks();
   }

   public boolean isAutoUpdateEnabled() {
      return field_459.isAutoUpdateEnabled();
   }
}
