package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzpu extends com.google.android.gms.measurement.zze<zzpu> {
   private String mCategory;
   private String zzSU;
   private long zzaDV;
   private String zzaUO;

   public String getAction() {
      return this.zzSU;
   }

   public String getLabel() {
      return this.zzaUO;
   }

   public long getValue() {
      return this.zzaDV;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("category", this.mCategory);
      var1.put("action", this.zzSU);
      var1.put("label", this.zzaUO);
      var1.put("value", Long.valueOf(this.zzaDV));
      return zzF(var1);
   }

   public String zzAZ() {
      return this.mCategory;
   }

   public void zzN(long var1) {
      this.zzaDV = var1;
   }

   public void zza(zzpu var1) {
      if(!TextUtils.isEmpty(this.mCategory)) {
         var1.zzeE(this.mCategory);
      }

      if(!TextUtils.isEmpty(this.zzSU)) {
         var1.zzeF(this.zzSU);
      }

      if(!TextUtils.isEmpty(this.zzaUO)) {
         var1.zzeG(this.zzaUO);
      }

      if(this.zzaDV != 0L) {
         var1.zzN(this.zzaDV);
      }

   }

   public void zzeE(String var1) {
      this.mCategory = var1;
   }

   public void zzeF(String var1) {
      this.zzSU = var1;
   }

   public void zzeG(String var1) {
      this.zzaUO = var1;
   }
}
