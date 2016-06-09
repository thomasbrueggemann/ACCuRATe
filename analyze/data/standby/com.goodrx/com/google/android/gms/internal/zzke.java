package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzke extends com.google.android.gms.measurement.zze<zzke> {
   private String zzPN;
   private String zzPO;
   private String zzPP;
   private boolean zzPQ;
   private String zzPR;
   private boolean zzPS;
   private double zzPT;
   private String zzrG;

   public String getClientId() {
      return this.zzPO;
   }

   public String getUserId() {
      return this.zzrG;
   }

   public void setClientId(String var1) {
      this.zzPO = var1;
   }

   public void setSampleRate(double var1) {
      boolean var3;
      if(var1 >= 0.0D && var1 <= 100.0D) {
         var3 = true;
      } else {
         var3 = false;
      }

      com.google.android.gms.common.internal.zzx.zzb(var3, "Sample rate must be between 0% and 100%");
      this.zzPT = var1;
   }

   public void setUserId(String var1) {
      this.zzrG = var1;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("hitType", this.zzPN);
      var1.put("clientId", this.zzPO);
      var1.put("userId", this.zzrG);
      var1.put("androidAdId", this.zzPP);
      var1.put("AdTargetingEnabled", Boolean.valueOf(this.zzPQ));
      var1.put("sessionControl", this.zzPR);
      var1.put("nonInteraction", Boolean.valueOf(this.zzPS));
      var1.put("sampleRate", Double.valueOf(this.zzPT));
      return zzF(var1);
   }

   public void zzH(boolean var1) {
      this.zzPQ = var1;
   }

   public void zzI(boolean var1) {
      this.zzPS = var1;
   }

   public void zza(zzke var1) {
      if(!TextUtils.isEmpty(this.zzPN)) {
         var1.zzaX(this.zzPN);
      }

      if(!TextUtils.isEmpty(this.zzPO)) {
         var1.setClientId(this.zzPO);
      }

      if(!TextUtils.isEmpty(this.zzrG)) {
         var1.setUserId(this.zzrG);
      }

      if(!TextUtils.isEmpty(this.zzPP)) {
         var1.zzaY(this.zzPP);
      }

      if(this.zzPQ) {
         var1.zzH(true);
      }

      if(!TextUtils.isEmpty(this.zzPR)) {
         var1.zzaZ(this.zzPR);
      }

      if(this.zzPS) {
         var1.zzI(this.zzPS);
      }

      if(this.zzPT != 0.0D) {
         var1.setSampleRate(this.zzPT);
      }

   }

   public void zzaX(String var1) {
      this.zzPN = var1;
   }

   public void zzaY(String var1) {
      this.zzPP = var1;
   }

   public void zzaZ(String var1) {
      this.zzPR = var1;
   }

   public String zziS() {
      return this.zzPN;
   }

   public String zziT() {
      return this.zzPP;
   }

   public boolean zziU() {
      return this.zzPQ;
   }

   public String zziV() {
      return this.zzPR;
   }

   public boolean zziW() {
      return this.zzPS;
   }

   public double zziX() {
      return this.zzPT;
   }
}
