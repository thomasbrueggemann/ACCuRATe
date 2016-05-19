package com.newrelic.agent.android.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import java.io.File;
import java.util.Arrays;
import java.util.UUID;

public class PersistentUUID {
   public static final String METRIC_UUID_RECOVERED = "UUIDRecovered";
   private static File UUID_FILE = new File(Environment.getDataDirectory(), "nr_installation");
   private static final String UUID_FILENAME = "nr_installation";
   private static final String UUID_KEY = "nr_uuid";
   private static AgentLog log = AgentLogManager.getAgentLog();

   public PersistentUUID(Context var1) {
      UUID_FILE = new File(var1.getFilesDir(), "nr_installation");
   }

   private String generateUniqueID(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private String intToHexString(int var1, int var2) {
      String var3 = "";
      String var4 = Integer.toHexString(var1);
      char[] var5 = new char[var2 - var4.length()];
      Arrays.fill(var5, '0');
      String var6 = new String(var5) + var4;
      int var7 = 0;

      for(int var8 = -1 + var6.length(); var8 >= 0; --var8) {
         ++var7;
         var3 = var6.substring(var8, var8 + 1) + var3;
         if(var7 % var2 == 0) {
            var3 = "-" + var3;
         }
      }

      if(var3.startsWith("-")) {
         var3 = var3.substring(1, var3.length());
      }

      return var3;
   }

   public String getDeviceId(Context var1) {
      String var2 = this.generateUniqueID(var1);
      if(TextUtils.isEmpty(var2)) {
         var2 = UUID.randomUUID().toString();
      }

      return var2;
   }

   public String getPersistentUUID() {
      String var1 = this.getUUIDFromFileStore();
      if(!TextUtils.isEmpty(var1)) {
         this.noticeUUIDMetric("UUIDRecovered");
         return var1;
      } else {
         String var2 = UUID.randomUUID().toString();
         log.info("Created random UUID: " + var2);
         StatsEngine.get().inc("Mobile/App/Install");
         AnalyticAttribute var3 = new AnalyticAttribute("install", true);
         AnalyticsControllerImpl.getInstance().addAttributeUnchecked(var3, false);
         this.setPersistedUUID(var2);
         return var2;
      }
   }

   protected String getUUIDFromFileStore() {
      // $FF: Couldn't be decompiled
   }

   protected void noticeUUIDMetric(String var1) {
      StatsEngine var2 = StatsEngine.get();
      if(var2 != null) {
         var2.inc("Supportability/AgentHealth/" + var1);
      } else {
         log.error("StatsEngine is null. " + var1 + "  not recorded.");
      }
   }

   protected void putUUIDToFileStore(String param1) {
      // $FF: Couldn't be decompiled
   }

   protected void setPersistedUUID(String var1) {
      this.putUUIDToFileStore(var1);
   }
}
