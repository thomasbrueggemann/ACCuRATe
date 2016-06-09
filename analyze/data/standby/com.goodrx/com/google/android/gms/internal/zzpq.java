package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzpq extends com.google.android.gms.measurement.zze<zzpq> {
   private String zzSE;
   private String zzSF;
   private String zzaUE;
   private String zzaUa;

   public void setAppId(String var1) {
      this.zzaUa = var1;
   }

   public void setAppInstallerId(String var1) {
      this.zzaUE = var1;
   }

   public void setAppName(String var1) {
      this.zzSE = var1;
   }

   public void setAppVersion(String var1) {
      this.zzSF = var1;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("appName", this.zzSE);
      var1.put("appVersion", this.zzSF);
      var1.put("appId", this.zzaUa);
      var1.put("appInstallerId", this.zzaUE);
      return zzF(var1);
   }

   public String zzAJ() {
      return this.zzaUE;
   }

   public void zza(zzpq var1) {
      if(!TextUtils.isEmpty(this.zzSE)) {
         var1.setAppName(this.zzSE);
      }

      if(!TextUtils.isEmpty(this.zzSF)) {
         var1.setAppVersion(this.zzSF);
      }

      if(!TextUtils.isEmpty(this.zzaUa)) {
         var1.setAppId(this.zzaUa);
      }

      if(!TextUtils.isEmpty(this.zzaUE)) {
         var1.setAppInstallerId(this.zzaUE);
      }

   }

   public String zzlg() {
      return this.zzSE;
   }

   public String zzli() {
      return this.zzSF;
   }

   public String zzwK() {
      return this.zzaUa;
   }
}
