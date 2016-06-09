package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ExceptionParser;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.internal.zzae;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
   private final Context mContext;
   private final UncaughtExceptionHandler zzPa;
   private final Tracker zzPb;
   private ExceptionParser zzPc;
   private GoogleAnalytics zzPd;

   public ExceptionReporter(Tracker var1, UncaughtExceptionHandler var2, Context var3) {
      if(var1 == null) {
         throw new NullPointerException("tracker cannot be null");
      } else if(var3 == null) {
         throw new NullPointerException("context cannot be null");
      } else {
         this.zzPa = var2;
         this.zzPb = var1;
         this.zzPc = new StandardExceptionParser(var3, new ArrayList());
         this.mContext = var3.getApplicationContext();
         StringBuilder var4 = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
         String var5;
         if(var2 == null) {
            var5 = "null";
         } else {
            var5 = var2.getClass().getName();
         }

         zzae.method_303(var4.append(var5).toString());
      }
   }

   public void uncaughtException(Thread var1, Throwable var2) {
      String var3 = "UncaughtException";
      if(this.zzPc != null) {
         String var5;
         if(var1 != null) {
            var5 = var1.getName();
         } else {
            var5 = null;
         }

         var3 = this.zzPc.getDescription(var5, var2);
      }

      zzae.method_303("Reporting uncaught exception: " + var3);
      this.zzPb.send((new HitBuilders.ExceptionBuilder()).setDescription(var3).setFatal(true).build());
      GoogleAnalytics var4 = this.zziC();
      var4.dispatchLocalHits();
      var4.zziG();
      if(this.zzPa != null) {
         zzae.method_303("Passing exception to the original handler");
         this.zzPa.uncaughtException(var1, var2);
      }

   }

   GoogleAnalytics zziC() {
      if(this.zzPd == null) {
         this.zzPd = GoogleAnalytics.getInstance(this.mContext);
      }

      return this.zzPd;
   }

   UncaughtExceptionHandler zziD() {
      return this.zzPa;
   }
}
