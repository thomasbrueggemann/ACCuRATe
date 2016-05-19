package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzaj;
import com.google.android.gms.measurement.internal.zzw;

class zza {
   private String zzSF;
   private final zzw zzaTV;
   private final String zzaUa;
   private String zzaVc;
   private String zzaVd;
   private String zzaVe;
   private long zzaVf;
   private long zzaVg;
   private long zzaVh;
   private String zzaVi;
   private long zzaVj;
   private long zzaVk;
   private boolean zzaVl;
   private long zzaVm;
   private long zzaVn;
   private long zzaVo;
   private long zzaVp;
   private boolean zzaVq;
   private long zzaVr;
   private long zzaVs;

   zza(zzw var1, String var2) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      com.google.android.gms.common.internal.zzx.zzcM(var2);
      this.zzaTV = var1;
      this.zzaUa = var2;
      this.zzaTV.zzjk();
   }

   public void setAppVersion(String var1) {
      this.zzaTV.zzjk();
      this.zzaVq |= zzaj.zzQ(this.zzSF, var1);
      this.zzSF = var1;
   }

   public void setMeasurementEnabled(boolean var1) {
      this.zzaTV.zzjk();
      boolean var2 = this.zzaVq;
      boolean var3;
      if(this.zzaVl != var1) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.zzaVq = var3 | var2;
      this.zzaVl = var1;
   }

   public boolean zzAr() {
      this.zzaTV.zzjk();
      return this.zzaVl;
   }

   public void zzBi() {
      this.zzaTV.zzjk();
      this.zzaVq = false;
   }

   public String zzBj() {
      this.zzaTV.zzjk();
      return this.zzaVc;
   }

   public String zzBk() {
      this.zzaTV.zzjk();
      return this.zzaVd;
   }

   public String zzBl() {
      this.zzaTV.zzjk();
      return this.zzaVe;
   }

   public long zzBm() {
      this.zzaTV.zzjk();
      return this.zzaVg;
   }

   public long zzBn() {
      this.zzaTV.zzjk();
      return this.zzaVh;
   }

   public String zzBo() {
      this.zzaTV.zzjk();
      return this.zzaVi;
   }

   public long zzBp() {
      this.zzaTV.zzjk();
      return this.zzaVj;
   }

   public long zzBq() {
      this.zzaTV.zzjk();
      return this.zzaVk;
   }

   public long zzBr() {
      this.zzaTV.zzjk();
      return this.zzaVf;
   }

   public long zzBs() {
      this.zzaTV.zzjk();
      return this.zzaVr;
   }

   public long zzBt() {
      this.zzaTV.zzjk();
      return this.zzaVs;
   }

   public void zzBu() {
      this.zzaTV.zzjk();
      long var1 = 1L + this.zzaVf;
      if(var1 > 2147483647L) {
         this.zzaTV.zzAo().zzCF().zzfg("Bundle index overflow");
         var1 = 0L;
      }

      this.zzaVq = true;
      this.zzaVf = var1;
   }

   public long zzBv() {
      this.zzaTV.zzjk();
      return this.zzaVm;
   }

   public long zzBw() {
      this.zzaTV.zzjk();
      return this.zzaVn;
   }

   public long zzBx() {
      this.zzaTV.zzjk();
      return this.zzaVo;
   }

   public long zzBy() {
      this.zzaTV.zzjk();
      return this.zzaVp;
   }

   public void zzO(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVg != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVg = var1;
   }

   public void zzP(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVh != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVh = var1;
   }

   public void zzQ(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVj != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVj = var1;
   }

   public void zzR(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVk != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVk = var1;
   }

   public void zzS(long var1) {
      boolean var3 = true;
      boolean var4;
      if(var1 >= 0L) {
         var4 = var3;
      } else {
         var4 = false;
      }

      com.google.android.gms.common.internal.zzx.zzac(var4);
      this.zzaTV.zzjk();
      boolean var5 = this.zzaVq;
      if(this.zzaVf == var1) {
         var3 = false;
      }

      this.zzaVq = var5 | var3;
      this.zzaVf = var1;
   }

   public void zzT(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVr != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVr = var1;
   }

   public void zzU(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVs != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVs = var1;
   }

   public void zzV(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVm != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVm = var1;
   }

   public void zzW(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVn != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVn = var1;
   }

   public void zzX(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVo != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVo = var1;
   }

   public void zzY(long var1) {
      this.zzaTV.zzjk();
      boolean var3 = this.zzaVq;
      boolean var4;
      if(this.zzaVp != var1) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.zzaVq = var4 | var3;
      this.zzaVp = var1;
   }

   public void zzeM(String var1) {
      this.zzaTV.zzjk();
      this.zzaVq |= zzaj.zzQ(this.zzaVc, var1);
      this.zzaVc = var1;
   }

   public void zzeN(String var1) {
      this.zzaTV.zzjk();
      if(TextUtils.isEmpty(var1)) {
         var1 = null;
      }

      this.zzaVq |= zzaj.zzQ(this.zzaVd, var1);
      this.zzaVd = var1;
   }

   public void zzeO(String var1) {
      this.zzaTV.zzjk();
      this.zzaVq |= zzaj.zzQ(this.zzaVe, var1);
      this.zzaVe = var1;
   }

   public void zzeP(String var1) {
      this.zzaTV.zzjk();
      this.zzaVq |= zzaj.zzQ(this.zzaVi, var1);
      this.zzaVi = var1;
   }

   public String zzli() {
      this.zzaTV.zzjk();
      return this.zzSF;
   }

   public String zzwK() {
      this.zzaTV.zzjk();
      return this.zzaUa;
   }
}
