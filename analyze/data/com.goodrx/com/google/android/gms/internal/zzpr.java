package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzpr extends com.google.android.gms.measurement.zze<zzpr> {
   private String mName;
   private String zzaPI;
   private String zzaUF;
   private String zzaUG;
   private String zzaUH;
   private String zzaUI;
   private String zzaUJ;
   private String zzaUK;
   private String zzxG;
   private String zzyv;

   public String getContent() {
      return this.zzxG;
   }

   public String getId() {
      return this.zzyv;
   }

   public String getName() {
      return this.mName;
   }

   public String getSource() {
      return this.zzaPI;
   }

   public void setName(String var1) {
      this.mName = var1;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("name", this.mName);
      var1.put("source", this.zzaPI);
      var1.put("medium", this.zzaUF);
      var1.put("keyword", this.zzaUG);
      var1.put("content", this.zzxG);
      var1.put("id", this.zzyv);
      var1.put("adNetworkId", this.zzaUH);
      var1.put("gclid", this.zzaUI);
      var1.put("dclid", this.zzaUJ);
      var1.put("aclid", this.zzaUK);
      return zzF(var1);
   }

   public String zzAK() {
      return this.zzaUF;
   }

   public String zzAL() {
      return this.zzaUG;
   }

   public String zzAM() {
      return this.zzaUH;
   }

   public String zzAN() {
      return this.zzaUI;
   }

   public String zzAO() {
      return this.zzaUJ;
   }

   public String zzAP() {
      return this.zzaUK;
   }

   public void zza(zzpr var1) {
      if(!TextUtils.isEmpty(this.mName)) {
         var1.setName(this.mName);
      }

      if(!TextUtils.isEmpty(this.zzaPI)) {
         var1.zzev(this.zzaPI);
      }

      if(!TextUtils.isEmpty(this.zzaUF)) {
         var1.zzew(this.zzaUF);
      }

      if(!TextUtils.isEmpty(this.zzaUG)) {
         var1.zzex(this.zzaUG);
      }

      if(!TextUtils.isEmpty(this.zzxG)) {
         var1.zzey(this.zzxG);
      }

      if(!TextUtils.isEmpty(this.zzyv)) {
         var1.zzez(this.zzyv);
      }

      if(!TextUtils.isEmpty(this.zzaUH)) {
         var1.zzeA(this.zzaUH);
      }

      if(!TextUtils.isEmpty(this.zzaUI)) {
         var1.zzeB(this.zzaUI);
      }

      if(!TextUtils.isEmpty(this.zzaUJ)) {
         var1.zzeC(this.zzaUJ);
      }

      if(!TextUtils.isEmpty(this.zzaUK)) {
         var1.zzeD(this.zzaUK);
      }

   }

   public void zzeA(String var1) {
      this.zzaUH = var1;
   }

   public void zzeB(String var1) {
      this.zzaUI = var1;
   }

   public void zzeC(String var1) {
      this.zzaUJ = var1;
   }

   public void zzeD(String var1) {
      this.zzaUK = var1;
   }

   public void zzev(String var1) {
      this.zzaPI = var1;
   }

   public void zzew(String var1) {
      this.zzaUF = var1;
   }

   public void zzex(String var1) {
      this.zzaUG = var1;
   }

   public void zzey(String var1) {
      this.zzxG = var1;
   }

   public void zzez(String var1) {
      this.zzyv = var1;
   }
}
