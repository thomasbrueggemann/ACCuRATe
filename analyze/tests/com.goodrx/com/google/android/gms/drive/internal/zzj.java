package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ControlProgressRequest;
import com.google.android.gms.drive.internal.ParcelableTransferPreferences;

public class zzj implements Creator<ControlProgressRequest> {
   static void zza(ControlProgressRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzaqq);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzaqr);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzaqs, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbh(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcX(var1);
   }

   public ControlProgressRequest zzbh(Parcel var1) {
      ParcelableTransferPreferences var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      DriveId var5 = null;
      int var6 = 0;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 4:
            var5 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, DriveId.CREATOR);
            break;
         case 5:
            var2 = (ParcelableTransferPreferences)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, ParcelableTransferPreferences.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ControlProgressRequest(var7, var6, var3, var5, var2);
      }
   }

   public ControlProgressRequest[] zzcX(int var1) {
      return new ControlProgressRequest[var1];
   }
}
