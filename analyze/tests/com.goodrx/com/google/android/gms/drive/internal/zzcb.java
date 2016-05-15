package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.UpdatePermissionRequest;

public class zzcb implements Creator<UpdatePermissionRequest> {
   static void zza(UpdatePermissionRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzapk, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzasE);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzaqd);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzaoV, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcc(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdX(var1);
   }

   public UpdatePermissionRequest zzcc(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      DriveId var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var7 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DriveId.CREATOR);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new UpdatePermissionRequest(var8, var7, var6, var5, var3, var2);
      }
   }

   public UpdatePermissionRequest[] zzdX(int var1) {
      return new UpdatePermissionRequest[var1];
   }
}
