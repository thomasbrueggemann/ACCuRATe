package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.RemovePermissionRequest;

public class zzbq implements Creator<RemovePermissionRequest> {
   static void zza(RemovePermissionRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzapk, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzaqd);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzaoV, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbS(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdN(var1);
   }

   public RemovePermissionRequest zzbS(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      DriveId var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, DriveId.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var8);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new RemovePermissionRequest(var7, var6, var5, var2, var3);
      }
   }

   public RemovePermissionRequest[] zzdN(int var1) {
      return new RemovePermissionRequest[var1];
   }
}
