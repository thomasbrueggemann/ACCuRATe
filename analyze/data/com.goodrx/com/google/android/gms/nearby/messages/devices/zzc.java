package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.zza;

class zzc extends zza {
   public zzc(byte[] var1) {
      super(zzu(var1));
   }

   private static byte[] zzu(byte[] var0) {
      boolean var1;
      if(var0.length != 10 && var0.length != 16) {
         var1 = false;
      } else {
         var1 = true;
      }

      zzx.zzb(var1, "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
      return var0;
   }

   public String toString() {
      return "EddystoneUidPrefix{bytes=" + this.zzEt() + '}';
   }
}
