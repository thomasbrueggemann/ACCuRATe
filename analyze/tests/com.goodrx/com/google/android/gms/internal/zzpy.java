package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzpy extends com.google.android.gms.measurement.zze<zzpy> {
   public String mCategory;
   public String zzaUO;
   public String zzaVa;
   public long zzaVb;

   public String getLabel() {
      return this.zzaUO;
   }

   public long getTimeInMillis() {
      return this.zzaVb;
   }

   public void setTimeInMillis(long var1) {
      this.zzaVb = var1;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("variableName", this.zzaVa);
      var1.put("timeInMillis", Long.valueOf(this.zzaVb));
      var1.put("category", this.mCategory);
      var1.put("label", this.zzaUO);
      return zzF(var1);
   }

   public String zzAZ() {
      return this.mCategory;
   }

   public String zzBh() {
      return this.zzaVa;
   }

   public void zza(zzpy var1) {
      if(!TextUtils.isEmpty(this.zzaVa)) {
         var1.zzeL(this.zzaVa);
      }

      if(this.zzaVb != 0L) {
         var1.setTimeInMillis(this.zzaVb);
      }

      if(!TextUtils.isEmpty(this.mCategory)) {
         var1.zzeE(this.mCategory);
      }

      if(!TextUtils.isEmpty(this.zzaUO)) {
         var1.zzeG(this.zzaUO);
      }

   }

   public void zzeE(String var1) {
      this.mCategory = var1;
   }

   public void zzeG(String var1) {
      this.zzaUO = var1;
   }

   public void zzeL(String var1) {
      this.zzaVa = var1;
   }
}
