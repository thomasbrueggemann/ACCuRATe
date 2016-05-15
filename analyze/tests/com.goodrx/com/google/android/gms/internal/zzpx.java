package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzpx extends com.google.android.gms.measurement.zze<zzpx> {
   public String zzSU;
   public String zzaUY;
   public String zzaUZ;

   public String getAction() {
      return this.zzSU;
   }

   public String getTarget() {
      return this.zzaUZ;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("network", this.zzaUY);
      var1.put("action", this.zzSU);
      var1.put("target", this.zzaUZ);
      return zzF(var1);
   }

   public String zzBg() {
      return this.zzaUY;
   }

   public void zza(zzpx var1) {
      if(!TextUtils.isEmpty(this.zzaUY)) {
         var1.zzeJ(this.zzaUY);
      }

      if(!TextUtils.isEmpty(this.zzSU)) {
         var1.zzeF(this.zzSU);
      }

      if(!TextUtils.isEmpty(this.zzaUZ)) {
         var1.zzeK(this.zzaUZ);
      }

   }

   public void zzeF(String var1) {
      this.zzSU = var1;
   }

   public void zzeJ(String var1) {
      this.zzaUY = var1;
   }

   public void zzeK(String var1) {
      this.zzaUZ = var1;
   }
}
