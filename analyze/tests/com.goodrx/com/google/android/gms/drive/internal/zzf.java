package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ChangeResourceParentsRequest;
import java.util.ArrayList;

public class zzf implements Creator<ChangeResourceParentsRequest> {
   static void zza(ChangeResourceParentsRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaqf, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzaqg, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaqh, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbd(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcT(var1);
   }

   public ChangeResourceParentsRequest zzbd(Parcel var1) {
      ArrayList var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = null;

      DriveId var6;
      ArrayList var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         ArrayList var9;
         DriveId var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            DriveId var14 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, DriveId.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            ArrayList var12 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, DriveId.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var7, DriveId.CREATOR);
            var9 = var5;
            var10 = var6;
            var11 = var4;
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
         return new ChangeResourceParentsRequest(var4, var6, var5, var2);
      }
   }

   public ChangeResourceParentsRequest[] zzcT(int var1) {
      return new ChangeResourceParentsRequest[var1];
   }
}
