package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.face.internal.client.LandmarkParcel;

public class zze implements Creator<LandmarkParcel> {
   static void zza(LandmarkParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.field_455);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.field_456);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.type);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhm(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkK(var1);
   }

   public LandmarkParcel zzhm(Parcel var1) {
      int var2 = 0;
      float var3 = 0.0F;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      float var5 = 0.0F;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var7);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var7);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new LandmarkParcel(var6, var5, var3, var2);
      }
   }

   public LandmarkParcel[] zzkK(int var1) {
      return new LandmarkParcel[var1];
   }
}
