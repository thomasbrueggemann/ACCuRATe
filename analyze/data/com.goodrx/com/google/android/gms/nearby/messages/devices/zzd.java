package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.zze;
import java.util.UUID;

public class zzd {
   private final zze zzbca;

   public zzd(byte[] var1) {
      this.zzbca = new zze(zzu(var1));
   }

   private static byte[] zzu(byte[] var0) {
      boolean var1;
      if(var0.length == 20) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzx.zzb(var1, "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
      return var0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof zzd)) {
         return false;
      } else {
         zzd var2 = (zzd)var1;
         return zzw.equal(this.zzbca, var2.zzbca);
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbca};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "IBeaconId{proximityUuid=" + this.zzEu() + ", major=" + this.zzEv() + ", minor=" + this.zzEw() + '}';
   }

   public UUID zzEu() {
      return this.zzbca.zzEu();
   }

   public short zzEv() {
      return this.zzbca.zzEx().shortValue();
   }

   public short zzEw() {
      return this.zzbca.zzEy().shortValue();
   }
}
