package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.OnContentsResponse;

public class zzaw implements Creator<OnContentsResponse> {
   static void zza(OnContentsResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzara, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzasf);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbz(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdu(var1);
   }

   public OnContentsResponse zzbz(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Contents var4 = null;

      int var5;
      boolean var7;
      for(var5 = 0; var1.dataPosition() < var3; var2 = var7) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         Contents var8;
         int var9;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            var8 = var4;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            Contents var10 = (Contents)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, Contents.CREATOR);
            var9 = var5;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var6);
            var8 = var4;
            var9 = var5;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
            var7 = var2;
            var8 = var4;
            var9 = var5;
         }

         var5 = var9;
         var4 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new OnContentsResponse(var5, var4, var2);
      }
   }

   public OnContentsResponse[] zzdu(int var1) {
      return new OnContentsResponse[var1];
   }
}
