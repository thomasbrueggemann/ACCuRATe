package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzps extends com.google.android.gms.measurement.zze<zzps> {
   public int zzDC;
   public int zzDD;
   public int zzaUL;
   public int zzaUM;
   public int zzaUN;
   private String zzaaL;

   public String getLanguage() {
      return this.zzaaL;
   }

   public void setLanguage(String var1) {
      this.zzaaL = var1;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("language", this.zzaaL);
      var1.put("screenColors", Integer.valueOf(this.zzaUL));
      var1.put("screenWidth", Integer.valueOf(this.zzDC));
      var1.put("screenHeight", Integer.valueOf(this.zzDD));
      var1.put("viewportWidth", Integer.valueOf(this.zzaUM));
      var1.put("viewportHeight", Integer.valueOf(this.zzaUN));
      return zzF(var1);
   }

   public int zzAQ() {
      return this.zzaUL;
   }

   public int zzAR() {
      return this.zzDC;
   }

   public int zzAS() {
      return this.zzDD;
   }

   public int zzAT() {
      return this.zzaUM;
   }

   public int zzAU() {
      return this.zzaUN;
   }

   public void zza(zzps var1) {
      if(this.zzaUL != 0) {
         var1.zziA(this.zzaUL);
      }

      if(this.zzDC != 0) {
         var1.zziB(this.zzDC);
      }

      if(this.zzDD != 0) {
         var1.zziC(this.zzDD);
      }

      if(this.zzaUM != 0) {
         var1.zziD(this.zzaUM);
      }

      if(this.zzaUN != 0) {
         var1.zziE(this.zzaUN);
      }

      if(!TextUtils.isEmpty(this.zzaaL)) {
         var1.setLanguage(this.zzaaL);
      }

   }

   public void zziA(int var1) {
      this.zzaUL = var1;
   }

   public void zziB(int var1) {
      this.zzDC = var1;
   }

   public void zziC(int var1) {
      this.zzDD = var1;
   }

   public void zziD(int var1) {
      this.zzaUM = var1;
   }

   public void zziE(int var1) {
      this.zzaUN = var1;
   }
}
