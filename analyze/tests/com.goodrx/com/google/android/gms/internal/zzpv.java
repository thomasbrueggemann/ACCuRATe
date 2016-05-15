package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzpv extends com.google.android.gms.measurement.zze<zzpv> {
   public boolean zzaUP;
   public String zzaxl;

   public String getDescription() {
      return this.zzaxl;
   }

   public void setDescription(String var1) {
      this.zzaxl = var1;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("description", this.zzaxl);
      var1.put("fatal", Boolean.valueOf(this.zzaUP));
      return zzF(var1);
   }

   public boolean zzBa() {
      return this.zzaUP;
   }

   public void zza(zzpv var1) {
      if(!TextUtils.isEmpty(this.zzaxl)) {
         var1.setDescription(this.zzaxl);
      }

      if(this.zzaUP) {
         var1.zzao(this.zzaUP);
      }

   }

   public void zzao(boolean var1) {
      this.zzaUP = var1;
   }
}
