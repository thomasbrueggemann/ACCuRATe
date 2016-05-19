package com.comscore.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.comscore.analytics.comScore;
import com.comscore.utils.CSLog;
import java.util.HashMap;

public class InstallReferrerReceiver extends BroadcastReceiver {
   public static final String CS_NONE = "CS_NONE";
   public static final String CS_REFERRER_PREF_KEY = "CS_REFERRER_PREF_KEY";
   public static final String REFERRER_LABEL = "ns_ap_referrer";
   // $FF: renamed from: a java.lang.String
   private static final String field_458 = "InstallReferrerReceiver";

   // $FF: renamed from: a (java.lang.String, android.content.Context) void
   private void method_349(String var1, Context var2) {
      Editor var3 = PreferenceManager.getDefaultSharedPreferences(var2).edit();
      var3.putString("CS_REFERRER_PREF_KEY", var1);
      var3.commit();
      CSLog.method_372("InstallReferrerReceiver", "Stored data");
   }

   public static HashMap<String, String> retrieveReferrerLabels(Context var0) {
      SharedPreferences var1 = PreferenceManager.getDefaultSharedPreferences(var0);
      if(var1.contains("CS_REFERRER_PREF_KEY")) {
         Editor var2 = var1.edit();
         String var3 = var1.getString("CS_REFERRER_PREF_KEY", "CS_NONE");
         CSLog.method_372(comScore.getAppName().toString(), "referrer was set as: \'" + var3 + "\'");
         var2.remove("CS_REFERRER_PREF_KEY");
         var2.commit();
         if(var3 != null && var3.length() > 0 && !var3.equals("CS_NONE")) {
            return splitReferrer(var3);
         }
      }

      return null;
   }

   public static HashMap<String, String> splitReferrer(String var0) {
      HashMap var1 = new HashMap();
      if(var0 != null && var0.length() > 0) {
         String[] var2 = var0.split("&");
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String var6 = var2[var4];
            int var7 = var6.indexOf("=");
            if(var7 >= 0) {
               var1.put(var6.substring(0, var7), var6.substring(var7 + 1));
            } else {
               var1.put("ns_ap_referrer", var6);
            }
         }

         if(var1.size() > 0 && !var1.containsKey("ns_ap_referrer")) {
            var1.put("ns_ap_referrer", "1");
         }
      }

      return var1;
   }

   public void onReceive(Context param1, Intent param2) {
      // $FF: Couldn't be decompiled
   }
}
