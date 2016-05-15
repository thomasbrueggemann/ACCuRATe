package com.comscore.utils;

import com.comscore.analytics.Core;
import com.comscore.applications.EventType;
import com.comscore.utils.CSLog;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.URLEncoder;
import java.util.HashMap;

public class CustomExceptionHandler implements UncaughtExceptionHandler {
   // $FF: renamed from: a java.lang.Thread.UncaughtExceptionHandler
   private UncaughtExceptionHandler field_31 = Thread.getDefaultUncaughtExceptionHandler();
   // $FF: renamed from: b com.comscore.analytics.Core
   private Core field_32;

   public CustomExceptionHandler(Core var1) {
      this.field_32 = var1;
   }

   // $FF: renamed from: a (java.lang.Throwable) void
   private void method_34(Throwable var1) {
      StackTraceElement[] var2 = var1.getStackTrace();
      String var3 = "";

      String var11;
      for(int var4 = 0; var4 < var2.length && var4 < 5; var3 = var11) {
         StackTraceElement var10 = var2[var4];
         var11 = var10.getFileName() + "@" + var10.getLineNumber() + "|" + var10.getClassName() + "." + var10.getMethodName();
         if(!var3.equals("")) {
            var11 = var3 + ";" + var11;
         }

         ++var4;
      }

      HashMap var5 = new HashMap();
      if(!var3.equals("")) {
         try {
            var5.put("ns_ap_uxc", URLEncoder.encode(var3, "UTF-8"));
         } catch (UnsupportedEncodingException var13) {
            CSLog.method_374(this, "Error encoding the URL (ns_ap_uxc)");
            CSLog.printStackTrace(var13);
         }
      }

      try {
         var5.put("ns_ap_uxs", URLEncoder.encode(var1.toString(), "UTF-8"));
      } catch (UnsupportedEncodingException var12) {
         CSLog.method_374(this, "Error encoding the URL (ns_ap_uxs)");
         CSLog.printStackTrace(var12);
      }

      this.field_32.getOfflineCache().saveApplicationMeasurement(EventType.HIDDEN, var5, true);
   }

   public void uncaughtException(Thread var1, Throwable var2) {
      this.method_34(var2);
      this.field_31.uncaughtException(var1, var2);
   }
}
