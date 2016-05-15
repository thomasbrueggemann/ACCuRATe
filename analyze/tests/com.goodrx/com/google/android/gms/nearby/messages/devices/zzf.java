package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceId;

public class zzf implements Creator<NearbyDevice> {
   static void zza(NearbyDevice var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzEz(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getUrl(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzEC(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable[])var0.zzEA(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String[])var0.zzEB(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgd(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzji(var1);
   }

   public NearbyDevice zzgd(Parcel var1) {
      String[] var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      NearbyDeviceId[] var5 = null;
      String var6 = null;
      String var7 = null;
      NearbyDeviceId var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = (NearbyDeviceId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, NearbyDeviceId.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 4:
            var5 = (NearbyDeviceId[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9, NearbyDeviceId.CREATOR);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var9);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new NearbyDevice(var4, var8, var7, var6, var5, var2);
      }
   }

   public NearbyDevice[] zzji(int var1) {
      return new NearbyDevice[var1];
   }
}
