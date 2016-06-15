package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tagmanager.class_515;

// $FF: renamed from: com.google.android.gms.tagmanager.de
class class_535 {
   private GoogleAnalytics aig;
   private Context mContext;
   // $FF: renamed from: tM com.google.android.gms.analytics.Tracker
   private Tracker field_2897;

   class_535(Context var1) {
      this.mContext = var1;
   }

   // $FF: renamed from: cn (java.lang.String) void
   private void method_2993(String var1) {
      synchronized(this){}

      try {
         if(this.aig == null) {
            this.aig = GoogleAnalytics.getInstance(this.mContext);
            this.aig.setLogger(new class_535.class_1312());
            this.field_2897 = this.aig.newTracker(var1);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: cm (java.lang.String) com.google.android.gms.analytics.Tracker
   public Tracker method_2994(String var1) {
      this.method_2993(var1);
      return this.field_2897;
   }

   static class class_1312 implements Logger {
      // $FF: renamed from: dv (int) int
      private static int method_4252(int var0) {
         switch(var0) {
         case 2:
            return 0;
         case 3:
         case 4:
            return 1;
         case 5:
            return 2;
         case 6:
         default:
            return 3;
         }
      }

      public void error(Exception var1) {
         class_515.method_2920("", var1);
      }

      public void error(String var1) {
         class_515.method_2916(var1);
      }

      public int getLogLevel() {
         return method_4252(class_515.getLogLevel());
      }

      public void info(String var1) {
         class_515.method_2917(var1);
      }

      public void setLogLevel(int var1) {
         class_515.method_2919("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
      }

      public void verbose(String var1) {
         class_515.method_2918(var1);
      }

      public void warn(String var1) {
         class_515.method_2919(var1);
      }
   }
}
