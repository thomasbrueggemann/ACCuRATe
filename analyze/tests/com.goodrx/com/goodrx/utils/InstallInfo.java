package com.goodrx.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class InstallInfo {
   private static final String CAMPAIGN = "campaign";
   private static final String INSTALL_DATE = "install_date";
   private static final String INSTALL_INFO_SHARED_PREFERENCE = "install_info";
   private static final String IS_VALID = "is_valid";
   private static final String LAST_VERSION = "last_version";
   private static final String MEDIA_SOURCE = "media_source";

   public static String getCampaign(Context var0) {
      return getSharedPreference(var0).getString("campaign", (String)null);
   }

   public static long getInstallTime(Context var0) {
      return getSharedPreference(var0).getLong("install_date", 0L);
   }

   public static int getLastVersion(Context var0) {
      return getSharedPreference(var0).getInt("last_version", -1);
   }

   public static String getMediaSource(Context var0) {
      return getSharedPreference(var0).getString("media_source", (String)null);
   }

   private static SharedPreferences getSharedPreference(Context var0) {
      return var0.getSharedPreferences("install_info", 0);
   }

   public static boolean isValid(Context var0) {
      return getSharedPreference(var0).getBoolean("is_valid", false);
   }

   public static void setCampaign(Context var0, String var1) {
      getSharedPreference(var0).edit().putString("campaign", var1).apply();
   }

   public static void setInstallTime(Context var0, long var1) {
      getSharedPreference(var0).edit().putLong("install_date", var1).apply();
   }

   public static void setLastVersion(Context var0, int var1) {
      getSharedPreference(var0).edit().putInt("last_version", var1).apply();
   }

   public static void setMediaSource(Context var0, String var1) {
      getSharedPreference(var0).edit().putString("media_source", var1).apply();
   }

   public static void setValid(Context var0, boolean var1) {
      getSharedPreference(var0).edit().putBoolean("is_valid", var1).apply();
   }
}
