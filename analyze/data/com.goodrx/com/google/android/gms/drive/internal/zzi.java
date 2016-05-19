package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.CloseContentsRequest;

public class zzi implements Creator<CloseContentsRequest> {
   static void zza(CloseContentsRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaql, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Boolean)var0.zzaqp, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaqn);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbg(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcW(var1);
   }

   public CloseContentsRequest zzbg(Parcel var1) {
      Boolean var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Contents var5 = null;

      int var6;
      int var8;
      for(var6 = 0; var1.dataPosition() < var4; var3 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         Boolean var9;
         Contents var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var16;
            var8 = var3;
            break;
         case 2:
            Contents var14 = (Contents)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Contents.CREATOR);
            var11 = var6;
            var10 = var14;
            var8 = var3;
            var9 = var2;
            break;
         case 3:
            Boolean var12 = com.google.android.gms.common.internal.safeparcel.zza.zzd(var1, var7);
            var10 = var5;
            var11 = var6;
            var9 = var12;
            var8 = var3;
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var2;
            var10 = var5;
            var11 = var6;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var3;
            var9 = var2;
            var10 = var5;
            var11 = var6;
         }

         var6 = var11;
         var5 = var10;
         var2 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new CloseContentsRequest(var6, var5, var2, var3);
      }
   }

   public CloseContentsRequest[] zzcW(int var1) {
      return new CloseContentsRequest[var1];
   }
}
