package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.face.internal.client.FaceParcel;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;

public class zza implements Creator<FaceParcel> {
   static void zza(FaceParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.field_136);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.centerX);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.centerY);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.width);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.height);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzbnP);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzbnQ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable[])var0.zzbnR, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.zzbnS);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.zzbnT);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, var0.zzbnU);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhk(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkH(var1);
   }

   public FaceParcel zzhk(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      int var4 = 0;
      float var5 = 0.0F;
      float var6 = 0.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      float var10 = 0.0F;
      LandmarkParcel[] var11 = null;
      float var12 = 0.0F;
      float var13 = 0.0F;
      float var14 = 0.0F;

      while(var1.dataPosition() < var2) {
         int var15 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var15)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 9:
            var11 = (LandmarkParcel[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15, LandmarkParcel.CREATOR);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new FaceParcel(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   public FaceParcel[] zzkH(int var1) {
      return new FaceParcel[var1];
   }
}
