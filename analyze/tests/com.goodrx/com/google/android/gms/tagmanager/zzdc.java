package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tagmanager.zzbg;

public class zzdc {
   private Context mContext;
   private Tracker zzPb;
   private GoogleAnalytics zzPd;

   public zzdc(Context var1) {
      this.mContext = var1;
   }

   private void zzgr(String var1) {
      synchronized(this){}

      try {
         if(this.zzPd == null) {
            this.zzPd = GoogleAnalytics.getInstance(this.mContext);
            this.zzPd.setLogger(new zzdc.zza());
            this.zzPb = this.zzPd.newTracker(var1);
         }
      } finally {
         ;
      }

   }

   public Tracker zzgq(String var1) {
      this.zzgr(var1);
      return this.zzPb;
   }

   static class zza implements Logger {
      private static int zzkn(int var0) {
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

      public void error(String var1) {
         zzbg.method_353(var1);
      }

      public int getLogLevel() {
         return zzkn(zzbg.getLogLevel());
      }

      public void info(String var1) {
         zzbg.zzaJ(var1);
      }

      public void setLogLevel(int var1) {
         zzbg.zzaK("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
      }

      public void verbose(String var1) {
         zzbg.method_354(var1);
      }

      public void warn(String var1) {
         zzbg.zzaK(var1);
      }
   }
}
