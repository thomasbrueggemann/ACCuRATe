package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tagmanager.class_613;

// $FF: renamed from: com.google.android.gms.tagmanager.df
class class_634 {
   private Context mContext;
   // $FF: renamed from: yO com.google.android.gms.analytics.Tracker
   private Tracker field_2751;
   // $FF: renamed from: yQ com.google.android.gms.analytics.GoogleAnalytics
   private GoogleAnalytics field_2752;

   class_634(Context var1) {
      this.mContext = var1;
   }

   // $FF: renamed from: cX (java.lang.String) void
   private void method_3572(String var1) {
      synchronized(this){}

      try {
         if(this.field_2752 == null) {
            this.field_2752 = GoogleAnalytics.getInstance(this.mContext);
            this.field_2752.setLogger(new class_634.class_1340());
            this.field_2751 = this.field_2752.newTracker(var1);
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: cW (java.lang.String) com.google.android.gms.analytics.Tracker
   public Tracker method_3573(String var1) {
      this.method_3572(var1);
      return this.field_2751;
   }

   static class class_1340 implements Logger {
      // $FF: renamed from: fP (int) int
      private static int method_3425(int var0) {
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
         class_613.method_3495("", var1);
      }

      public void error(String var1) {
         class_613.method_3491(var1);
      }

      public int getLogLevel() {
         return method_3425(class_613.getLogLevel());
      }

      public void info(String var1) {
         class_613.method_3492(var1);
      }

      public void setLogLevel(int var1) {
         class_613.method_3494("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
      }

      public void verbose(String var1) {
         class_613.method_3493(var1);
      }

      public void warn(String var1) {
         class_613.method_3494(var1);
      }
   }
}
