package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.ThreadInfo;
import com.newrelic.agent.android.measurement.http.HttpErrorMeasurement;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.util.Util;
import java.util.HashMap;
import java.util.Map;

public class HttpErrorMeasurementProducer extends BaseMeasurementProducer {
   public static final String HTTP_METHOD_PARAMS_KEY = "http_method";
   public static final String WAN_TYPE_PARAMS_KEY = "wan_type";
   private static final AgentLog log = AgentLogManager.getAgentLog();

   public HttpErrorMeasurementProducer() {
      super(MeasurementType.HttpError);
   }

   private String getSanitizedStackTrace() {
      StringBuilder var1 = new StringBuilder();
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      int var3 = 0;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         StackTraceElement var5 = var2[var4];
         if(!this.shouldFilterStackTraceElement(var5)) {
            var1.append(var5.toString());
            if(var4 <= -1 + var2.length) {
               var1.append("\n");
            }

            ++var3;
            if(var3 >= Agent.getStackTraceLimit()) {
               break;
            }
         }
      }

      return var1.toString();
   }

   private boolean shouldFilterStackTraceElement(StackTraceElement var1) {
      String var2 = var1.getClassName();
      String var3 = var1.getMethodName();
      return var2.startsWith("com.newrelic") || var2.startsWith("dalvik.system.VMStack") && var3.startsWith("getThreadStackTrace") || var2.startsWith("java.lang.Thread") && var3.startsWith("getStackTrace");
   }

   public void produceMeasurement(String var1, String var2, int var3) {
      this.produceMeasurement(var1, var2, var3, "");
   }

   public void produceMeasurement(String var1, String var2, int var3, String var4) {
      this.produceMeasurement(var1, var2, var3, var4, (Map)null);
   }

   public void produceMeasurement(String var1, String var2, int var3, String var4, Map<String, String> var5) {
      this.produceMeasurement(var1, var2, var3, var4, var5, new ThreadInfo());
   }

   public void produceMeasurement(String var1, String var2, int var3, String var4, Map<String, String> var5, ThreadInfo var6) {
      String var7 = Util.sanitizeUrl(var1);
      if(var7 != null) {
         HttpErrorMeasurement var8 = new HttpErrorMeasurement(var7, var3);
         if(var5 == null) {
            var5 = new HashMap();
         }

         ((Map)var5).put("http_method", var2);
         ((Map)var5).put("wan_type", Agent.getActiveNetworkWanType());
         var8.setThreadInfo(var6);
         var8.setStackTrace(this.getSanitizedStackTrace());
         var8.setResponseBody(var4);
         var8.setParams((Map)var5);
         this.produceMeasurement(var8);
      }
   }
}
