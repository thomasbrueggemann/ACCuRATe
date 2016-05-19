package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;
import com.google.android.gms.drive.internal.AddPermissionRequest;

public class zzb implements Creator<AddPermissionRequest> {
   static void zza(AddPermissionRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzaqa, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzaqb);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzaqc, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzaqd);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzaoV, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzba(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcQ(var1);
   }

   public AddPermissionRequest zzba(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      boolean var6 = false;
      Permission var7 = null;
      DriveId var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var8 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, DriveId.CREATOR);
            break;
         case 3:
            var7 = (Permission)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, Permission.CREATOR);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new AddPermissionRequest(var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public AddPermissionRequest[] zzcQ(int var1) {
      return new AddPermissionRequest[var1];
   }
}
