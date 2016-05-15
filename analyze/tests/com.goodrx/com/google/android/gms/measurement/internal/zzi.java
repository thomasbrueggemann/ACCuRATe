package com.google.android.gms.measurement.internal;

class zzi {
   final String mName;
   final String zzaUa;
   final long zzaVP;
   final long zzaVQ;
   final long zzaVR;

   zzi(String var1, String var2, long var3, long var5, long var7) {
      boolean var9 = true;
      super();
      com.google.android.gms.common.internal.zzx.zzcM(var1);
      com.google.android.gms.common.internal.zzx.zzcM(var2);
      boolean var12;
      if(var3 >= 0L) {
         var12 = var9;
      } else {
         var12 = false;
      }

      com.google.android.gms.common.internal.zzx.zzac(var12);
      if(var5 < 0L) {
         var9 = false;
      }

      com.google.android.gms.common.internal.zzx.zzac(var9);
      this.zzaUa = var1;
      this.mName = var2;
      this.zzaVP = var3;
      this.zzaVQ = var5;
      this.zzaVR = var7;
   }

   zzi zzCB() {
      return new zzi(this.zzaUa, this.mName, 1L + this.zzaVP, 1L + this.zzaVQ, this.zzaVR);
   }

   zzi zzab(long var1) {
      return new zzi(this.zzaUa, this.mName, this.zzaVP, this.zzaVQ, var1);
   }
}
