package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzaq {
   private final long zzSL;
   private final long zzbiX;
   private final long zzbiY;
   private String zzbiZ;

   zzaq(long var1, long var3, long var5) {
      this.zzbiX = var1;
      this.zzSL = var3;
      this.zzbiY = var5;
   }

   long zzGD() {
      return this.zzbiX;
   }

   long zzGE() {
      return this.zzbiY;
   }

   String zzGF() {
      return this.zzbiZ;
   }

   void zzgf(String var1) {
      if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
         this.zzbiZ = var1;
      }
   }
}
