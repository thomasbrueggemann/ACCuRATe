package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.zza;
import java.nio.ByteBuffer;
import java.util.UUID;

class zze extends zza {
   public zze(byte[] var1) {
      super(zzu(var1));
   }

   private static byte[] zzu(byte[] var0) {
      boolean var1;
      if(var0.length != 16 && var0.length != 18 && var0.length != 20) {
         var1 = false;
      } else {
         var1 = true;
      }

      zzx.zzb(var1, "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
      return var0;
   }

   public String toString() {
      return "IBeaconIdPrefix{proximityUuid=" + this.zzEu() + ", major=" + this.zzEx() + ", minor=" + this.zzEy() + '}';
   }

   public UUID zzEu() {
      ByteBuffer var1 = ByteBuffer.wrap(this.getBytes());
      return new UUID(var1.getLong(), var1.getLong());
   }

   public Short zzEx() {
      byte[] var1 = this.getBytes();
      return var1.length >= 18?Short.valueOf(ByteBuffer.wrap(var1).getShort(16)):null;
   }

   public Short zzEy() {
      byte[] var1 = this.getBytes();
      return var1.length == 20?Short.valueOf(ByteBuffer.wrap(var1).getShort(18)):null;
   }
}
