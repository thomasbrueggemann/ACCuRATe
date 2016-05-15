package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzaa;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzp;
import com.google.android.gms.analytics.internal.zzq;

public class zzz extends zzq<zzaa> {
   public zzz(zzf var1) {
      super(var1, new zzz.zza(var1));
   }

   private static class zza implements zzq.zza<zzaa> {
      private final zzf zzQj;
      private final zzaa zzSD;

      public zza(zzf var1) {
         this.zzQj = var1;
         this.zzSD = new zzaa();
      }

      public void zzc(String var1, int var2) {
         if("ga_dispatchPeriod".equals(var1)) {
            this.zzSD.zzSH = var2;
         } else {
            this.zzQj.zzjm().zzd("Int xml configuration name not recognized", var1);
         }
      }

      public void zzf(String var1, boolean var2) {
         if("ga_dryRun".equals(var1)) {
            zzaa var3 = this.zzSD;
            byte var4;
            if(var2) {
               var4 = 1;
            } else {
               var4 = 0;
            }

            var3.zzSI = var4;
         } else {
            this.zzQj.zzjm().zzd("Bool xml configuration name not recognized", var1);
         }
      }

      public void zzj(String var1, String var2) {
      }

      public void zzk(String var1, String var2) {
         if("ga_appName".equals(var1)) {
            this.zzSD.zzSE = var2;
         } else if("ga_appVersion".equals(var1)) {
            this.zzSD.zzSF = var2;
         } else if("ga_logLevel".equals(var1)) {
            this.zzSD.zzSG = var2;
         } else {
            this.zzQj.zzjm().zzd("String xml configuration name not recognized", var1);
         }
      }

      // $FF: synthetic method
      public zzp zzkq() {
         return this.zzle();
      }

      public zzaa zzle() {
         return this.zzSD;
      }
   }
}
