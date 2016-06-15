package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ExceptionParser;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.StandardExceptionParser;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.class_863;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
   private final Context mContext;
   // $FF: renamed from: yN java.lang.Thread.UncaughtExceptionHandler
   private final UncaughtExceptionHandler field_4012;
   // $FF: renamed from: yO com.google.android.gms.analytics.Tracker
   private final Tracker field_4013;
   // $FF: renamed from: yP com.google.android.gms.analytics.ExceptionParser
   private ExceptionParser field_4014;
   // $FF: renamed from: yQ com.google.android.gms.analytics.GoogleAnalytics
   private GoogleAnalytics field_4015;

   public ExceptionReporter(Tracker var1, UncaughtExceptionHandler var2, Context var3) {
      if(var1 == null) {
         throw new NullPointerException("tracker cannot be null");
      } else if(var3 == null) {
         throw new NullPointerException("context cannot be null");
      } else {
         this.field_4012 = var2;
         this.field_4013 = var1;
         this.field_4014 = new StandardExceptionParser(var3, new ArrayList());
         this.mContext = var3.getApplicationContext();
         StringBuilder var4 = (new StringBuilder()).append("ExceptionReporter created, original handler is ");
         String var5;
         if(var2 == null) {
            var5 = "null";
         } else {
            var5 = var2.getClass().getName();
         }

         class_863.method_4841(var4.append(var5).toString());
      }
   }

   // $FF: renamed from: es () com.google.android.gms.analytics.GoogleAnalytics
   GoogleAnalytics method_5300() {
      if(this.field_4015 == null) {
         this.field_4015 = GoogleAnalytics.getInstance(this.mContext);
      }

      return this.field_4015;
   }

   // $FF: renamed from: et () java.lang.Thread.UncaughtExceptionHandler
   UncaughtExceptionHandler method_5301() {
      return this.field_4012;
   }

   public ExceptionParser getExceptionParser() {
      return this.field_4014;
   }

   public void setExceptionParser(ExceptionParser var1) {
      this.field_4014 = var1;
   }

   public void uncaughtException(Thread var1, Throwable var2) {
      String var3 = "UncaughtException";
      if(this.field_4014 != null) {
         String var5;
         if(var1 != null) {
            var5 = var1.getName();
         } else {
            var5 = null;
         }

         var3 = this.field_4014.getDescription(var5, var2);
      }

      class_863.method_4841("Tracking Exception: " + var3);
      this.field_4013.send((new HitBuilders.ExceptionBuilder()).setDescription(var3).setFatal(true).build());
      GoogleAnalytics var4 = this.method_5300();
      var4.dispatchLocalHits();
      var4.method_3107();
      if(this.field_4012 != null) {
         class_863.method_4841("Passing exception to original handler.");
         this.field_4012.uncaughtException(var1, var2);
      }

   }
}
