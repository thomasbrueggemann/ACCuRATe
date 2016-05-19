package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;

public class zzb implements Creator<ClaimBleDeviceRequest> {
   static void zza(ClaimBleDeviceRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.getDeviceAddress(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzuK(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdh(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfh(var1);
   }

   public ClaimBleDeviceRequest zzdh(Parcel var1) {
      IBinder var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      BleDevice var5 = null;

      String var6;
      IBinder var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = zza.zzat(var1);
         BleDevice var9;
         String var10;
         int var11;
         switch(zza.zzca(var7)) {
         case 1:
            String var16 = zza.zzp(var1, var7);
            var11 = var4;
            var10 = var16;
            var8 = var2;
            var9 = var5;
            break;
         case 2:
            BleDevice var12 = (BleDevice)zza.zza(var1, var7, BleDevice.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 3:
            var8 = zza.zzq(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 1000:
            int var14 = zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var14;
            var8 = var2;
            break;
         default:
            zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ClaimBleDeviceRequest(var4, var6, var5, var2);
      }
   }

   public ClaimBleDeviceRequest[] zzfh(int var1) {
      return new ClaimBleDeviceRequest[var1];
   }
}
