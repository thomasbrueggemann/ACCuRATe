package com.google.android.gms.tagmanager;

import android.net.Uri;

class zzcb {
   private static zzcb zzbjQ;
   private volatile String zzbhM;
   private volatile zzcb.zza zzbjR;
   private volatile String zzbjS;
   private volatile String zzbjT;

   zzcb() {
      this.clear();
   }

   static zzcb zzGU() {
      // $FF: Couldn't be decompiled
   }

   private String zzgk(String var1) {
      return var1.split("&")[0].split("=")[1];
   }

   private String zzq(Uri var1) {
      return var1.getQuery().replace("&gtm_debug=x", "");
   }

   void clear() {
      this.zzbjR = zzcb.zza.zzbjU;
      this.zzbjS = null;
      this.zzbhM = null;
      this.zzbjT = null;
   }

   String getContainerId() {
      return this.zzbhM;
   }

   zzcb.zza zzGV() {
      return this.zzbjR;
   }

   String zzGW() {
      return this.zzbjS;
   }

   boolean zzp(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   static enum zza {
      zzbjU,
      zzbjV,
      zzbjW;

      static {
         zzcb.zza[] var0 = new zzcb.zza[]{zzbjU, zzbjV, zzbjW};
      }
   }
}
