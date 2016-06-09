package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.bootstrap.Device;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;

public class zzf implements Creator<SendDataRequest> {
   static void zza(SendDataRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzEd(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (byte[])var0.getData(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (IBinder)var0.getCallbackBinder(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfV(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zziR(var1);
   }

   public SendDataRequest zzfV(Parcel var1) {
      IBinder var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      byte[] var5 = null;

      Device var6;
      IBinder var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         byte[] var9;
         Device var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            Device var16 = (Device)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Device.CREATOR);
            var11 = var4;
            var10 = var16;
            var8 = var2;
            var9 = var5;
            break;
         case 2:
            byte[] var12 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var1, var7);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 1000:
            int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var14;
            var8 = var2;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
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
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SendDataRequest(var4, var6, var5, var2);
      }
   }

   public SendDataRequest[] zziR(int var1) {
      return new SendDataRequest[var1];
   }
}
