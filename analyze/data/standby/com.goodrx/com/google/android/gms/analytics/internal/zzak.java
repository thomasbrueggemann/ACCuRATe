package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzp;
import com.google.android.gms.analytics.internal.zzq;

public class zzak extends zzq<zzal> {
   public zzak(zzf var1) {
      super(var1, new zzak.zza(var1));
   }

   private static class zza extends zzc implements zzq.zza<zzal> {
      private final zzal zzTn = new zzal();

      public zza(zzf var1) {
         super(var1);
      }

      public void zzc(String var1, int var2) {
         if("ga_sessionTimeout".equals(var1)) {
            this.zzTn.zzTp = var2;
         } else {
            this.zzd("int configuration name not recognized", var1);
         }
      }

      public void zzf(String var1, boolean var2) {
         byte var3 = 1;
         if("ga_autoActivityTracking".equals(var1)) {
            zzal var6 = this.zzTn;
            if(!var2) {
               var3 = 0;
            }

            var6.zzTq = var3;
         } else if("ga_anonymizeIp".equals(var1)) {
            zzal var5 = this.zzTn;
            if(!var2) {
               var3 = 0;
            }

            var5.zzTr = var3;
         } else if("ga_reportUncaughtExceptions".equals(var1)) {
            zzal var4 = this.zzTn;
            if(!var2) {
               var3 = 0;
            }

            var4.zzTs = var3;
         } else {
            this.zzd("bool configuration name not recognized", var1);
         }
      }

      public void zzj(String var1, String var2) {
         this.zzTn.zzTt.put(var1, var2);
      }

      public void zzk(String var1, String var2) {
         if("ga_trackingId".equals(var1)) {
            this.zzTn.zzOV = var2;
         } else if("ga_sampleFrequency".equals(var1)) {
            try {
               this.zzTn.zzTo = Double.parseDouble(var2);
            } catch (NumberFormatException var4) {
               this.zzc("Error parsing ga_sampleFrequency value", var2, var4);
            }
         } else {
            this.zzd("string configuration name not recognized", var1);
         }
      }

      // $FF: synthetic method
      public zzp zzkq() {
         return this.zzlS();
      }

      public zzal zzlS() {
         return this.zzTn;
      }
   }
}
