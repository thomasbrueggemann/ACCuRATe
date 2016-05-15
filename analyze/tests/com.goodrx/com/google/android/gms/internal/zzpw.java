package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.UUID;

public final class zzpw extends com.google.android.gms.measurement.zze<zzpw> {
   private String zzaUQ;
   private int zzaUR;
   private int zzaUS;
   private String zzaUT;
   private String zzaUU;
   private boolean zzaUV;
   private boolean zzaUW;
   private boolean zzaUX;

   public zzpw() {
      this(false);
   }

   public zzpw(boolean var1) {
      this(var1, zzBb());
   }

   public zzpw(boolean var1, int var2) {
      com.google.android.gms.common.internal.zzx.zzbV(var2);
      this.zzaUR = var2;
      this.zzaUW = var1;
   }

   static int zzBb() {
      UUID var0 = UUID.randomUUID();
      int var1 = (int)(2147483647L & var0.getLeastSignificantBits());
      if(var1 == 0) {
         var1 = (int)(2147483647L & var0.getMostSignificantBits());
         if(var1 == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            return Integer.MAX_VALUE;
         }
      }

      return var1;
   }

   private void zzBf() {
      if(this.zzaUX) {
         throw new IllegalStateException("ScreenViewInfo is immutable");
      }
   }

   public void setScreenName(String var1) {
      this.zzBf();
      this.zzaUQ = var1;
   }

   public String toString() {
      HashMap var1 = new HashMap();
      var1.put("screenName", this.zzaUQ);
      var1.put("interstitial", Boolean.valueOf(this.zzaUV));
      var1.put("automatic", Boolean.valueOf(this.zzaUW));
      var1.put("screenId", Integer.valueOf(this.zzaUR));
      var1.put("referrerScreenId", Integer.valueOf(this.zzaUS));
      var1.put("referrerScreenName", this.zzaUT);
      var1.put("referrerUri", this.zzaUU);
      return zzF(var1);
   }

   public String zzBc() {
      return this.zzaUQ;
   }

   public int zzBd() {
      return this.zzaUR;
   }

   public String zzBe() {
      return this.zzaUU;
   }

   public void zza(zzpw var1) {
      if(!TextUtils.isEmpty(this.zzaUQ)) {
         var1.setScreenName(this.zzaUQ);
      }

      if(this.zzaUR != 0) {
         var1.zziF(this.zzaUR);
      }

      if(this.zzaUS != 0) {
         var1.zziG(this.zzaUS);
      }

      if(!TextUtils.isEmpty(this.zzaUT)) {
         var1.zzeH(this.zzaUT);
      }

      if(!TextUtils.isEmpty(this.zzaUU)) {
         var1.zzeI(this.zzaUU);
      }

      if(this.zzaUV) {
         var1.zzaq(this.zzaUV);
      }

      if(this.zzaUW) {
         var1.zzap(this.zzaUW);
      }

   }

   public void zzap(boolean var1) {
      this.zzBf();
      this.zzaUW = var1;
   }

   public void zzaq(boolean var1) {
      this.zzBf();
      this.zzaUV = var1;
   }

   public void zzeH(String var1) {
      this.zzBf();
      this.zzaUT = var1;
   }

   public void zzeI(String var1) {
      this.zzBf();
      if(TextUtils.isEmpty(var1)) {
         this.zzaUU = null;
      } else {
         this.zzaUU = var1;
      }
   }

   public void zziF(int var1) {
      this.zzBf();
      this.zzaUR = var1;
   }

   public void zziG(int var1) {
      this.zzBf();
      this.zzaUS = var1;
   }
}
