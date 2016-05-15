package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.internal.zzpq;

public class zzk extends zzd {
   private final zzpq zzQX = new zzpq();

   zzk(zzf var1) {
      super(var1);
   }

   public void zziE() {
      zzan var1 = this.zziI();
      String var2 = var1.zzlg();
      if(var2 != null) {
         this.zzQX.setAppName(var2);
      }

      String var3 = var1.zzli();
      if(var3 != null) {
         this.zzQX.setAppVersion(var3);
      }

   }

   protected void zziJ() {
      this.zzjo().zzAH().zza(this.zzQX);
      this.zziE();
   }

   public zzpq zzjS() {
      this.zzjv();
      return this.zzQX;
   }
}
