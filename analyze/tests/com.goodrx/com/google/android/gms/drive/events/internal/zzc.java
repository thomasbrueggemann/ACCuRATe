package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.internal.TransferProgressData;

public class zzc implements Creator<TransferProgressData> {
   static void zza(TransferProgressData var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zzc(var1, 2, var0.zzapT);
      zzb.zza(var1, 3, (Parcelable)var0.zzaoz, var2, false);
      zzb.zzc(var1, 4, var0.zzBc);
      zzb.zza(var1, 5, var0.zzapW);
      zzb.zza(var1, 6, var0.zzapX);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaY(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcO(var1);
   }

   public TransferProgressData zzaY(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      int var5 = zza.zzau(var1);
      DriveId var6 = null;
      long var7 = var2;
      int var9 = 0;
      int var10 = 0;

      while(var1.dataPosition() < var5) {
         int var11 = zza.zzat(var1);
         switch(zza.zzca(var11)) {
         case 1:
            var10 = zza.zzg(var1, var11);
            break;
         case 2:
            var9 = zza.zzg(var1, var11);
            break;
         case 3:
            var6 = (DriveId)zza.zza(var1, var11, DriveId.CREATOR);
            break;
         case 4:
            var4 = zza.zzg(var1, var11);
            break;
         case 5:
            var7 = zza.zzi(var1, var11);
            break;
         case 6:
            var2 = zza.zzi(var1, var11);
            break;
         default:
            zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new TransferProgressData(var10, var9, var6, var4, var7, var2);
      }
   }

   public TransferProgressData[] zzcO(int var1) {
      return new TransferProgressData[var1];
   }
}
