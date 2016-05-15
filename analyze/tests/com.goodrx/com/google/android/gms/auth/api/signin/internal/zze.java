package com.google.android.gms.auth.api.signin.internal;

public class zze {
   static int zzXy = 31;
   private int zzXz = 1;

   public zze zzP(boolean var1) {
      int var2 = zzXy * this.zzXz;
      byte var3;
      if(var1) {
         var3 = 1;
      } else {
         var3 = 0;
      }

      this.zzXz = var3 + var2;
      return this;
   }

   public int zzne() {
      return this.zzXz;
   }

   public zze zzp(Object var1) {
      int var2 = zzXy * this.zzXz;
      int var3;
      if(var1 == null) {
         var3 = 0;
      } else {
         var3 = var1.hashCode();
      }

      this.zzXz = var3 + var2;
      return this;
   }
}
