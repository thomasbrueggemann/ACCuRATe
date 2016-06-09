package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzn implements Creator<CreateFileRequest> {
   static void zza(CreateFileRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaqy, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzaqw, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzaql, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Integer)var0.zzaqx, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzaqd);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzaoV, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.zzaqz);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 9, var0.zzaqA);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (String)var0.zzaoY, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbk(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdb(var1);
   }

   public CreateFileRequest zzbk(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      boolean var7 = false;
      Integer var8 = null;
      Contents var9 = null;
      MetadataBundle var10 = null;
      DriveId var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 2:
            var11 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, DriveId.CREATOR);
            break;
         case 3:
            var10 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, MetadataBundle.CREATOR);
            break;
         case 4:
            var9 = (Contents)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, Contents.CREATOR);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzh(var1, var13);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 9:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 10:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new CreateFileRequest(var12, var11, var10, var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public CreateFileRequest[] zzdb(int var1) {
      return new CreateFileRequest[var1];
   }
}
