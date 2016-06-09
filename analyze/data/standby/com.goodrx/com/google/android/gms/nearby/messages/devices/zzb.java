package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.zzc;

public class zzb {
   private final zzc zzbbZ;

   public zzb(byte[] var1) {
      this.zzbbZ = new zzc(zzu(var1));
   }

   private static byte[] zzu(byte[] var0) {
      boolean var1;
      if(var0.length == 16) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzx.zzb(var1, "Bytes must be a namespace plus instance (16 bytes).");
      return var0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof zzb)) {
         return false;
      } else {
         zzb var2 = (zzb)var1;
         return zzw.equal(this.zzbbZ, var2.zzbbZ);
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbbZ};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "EddystoneUid{id=" + this.zzEt() + '}';
   }

   public String zzEt() {
      return this.zzbbZ.zzEt();
   }
}
