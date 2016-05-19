package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;

public class zzbp implements Creator<RemoveEventListenerRequest> {
   static void zza(RemoveEventListenerRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzanf);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzapZ, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbR(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdM(var1);
   }

   public RemoveEventListenerRequest zzbR(Parcel var1) {
      TransferProgressOptions var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      DriveId var5 = null;

      int var6;
      TransferProgressOptions var8;
      for(var6 = 0; var1.dataPosition() < var4; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         int var9;
         DriveId var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var3;
            var10 = var5;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            DriveId var14 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, DriveId.CREATOR);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var3;
            break;
         case 3:
            int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = (TransferProgressOptions)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, TransferProgressOptions.CREATOR);
            var9 = var3;
            var10 = var5;
            var11 = var6;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var3;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var3 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new RemoveEventListenerRequest(var6, var5, var3, var2);
      }
   }

   public RemoveEventListenerRequest[] zzdM(int var1) {
      return new RemoveEventListenerRequest[var1];
   }
}
