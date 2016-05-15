package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceId;

public class zzh implements Creator<NearbyDeviceId> {
   static void zza(NearbyDeviceId var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getType());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (byte[])var0.zzbbY, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgf(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjk(var1);
   }

   public NearbyDeviceId zzgf(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      byte[] var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var1, var6);
            break;
         case 1000:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new NearbyDeviceId(var5, var2, var4);
      }
   }

   public NearbyDeviceId[] zzjk(int var1) {
      return new NearbyDeviceId[var1];
   }
}
