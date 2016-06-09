package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.measurement.zzf;
import com.google.android.gms.measurement.zzi;
import java.util.ListIterator;

public class zza extends zzf<zza> {
   private final com.google.android.gms.analytics.internal.zzf zzOK;
   private boolean zzOL;

   public zza(com.google.android.gms.analytics.internal.zzf var1) {
      super(var1.zzjo(), var1.zzjl());
      this.zzOK = var1;
   }

   public void enableAdvertisingIdCollection(boolean var1) {
      this.zzOL = var1;
   }

   protected void zza(com.google.android.gms.measurement.zzc var1) {
      zzke var2 = (zzke)var1.zzf(zzke.class);
      if(TextUtils.isEmpty(var2.getClientId())) {
         var2.setClientId(this.zzOK.zzjC().zzkk());
      }

      if(this.zzOL && TextUtils.isEmpty(var2.zziT())) {
         com.google.android.gms.analytics.internal.zza var3 = this.zzOK.zzjB();
         var2.zzaY(var3.zziY());
         var2.zzH(var3.zziU());
      }

   }

   public void zzaS(String var1) {
      zzx.zzcM(var1);
      this.zzaT(var1);
      this.zzAG().add(new zzb(this.zzOK, var1));
   }

   public void zzaT(String var1) {
      Uri var2 = zzb.zzaU(var1);
      ListIterator var3 = this.zzAG().listIterator();

      while(var3.hasNext()) {
         if(var2.equals(((zzi)var3.next()).zziA())) {
            var3.remove();
         }
      }

   }

   com.google.android.gms.analytics.internal.zzf zzix() {
      return this.zzOK;
   }

   public com.google.android.gms.measurement.zzc zziy() {
      com.google.android.gms.measurement.zzc var1 = this.zzAF().zzAu();
      var1.zzb(this.zzOK.zzjt().zzjS());
      var1.zzb(this.zzOK.zzju().zzkZ());
      this.zzd(var1);
      return var1;
   }
}
