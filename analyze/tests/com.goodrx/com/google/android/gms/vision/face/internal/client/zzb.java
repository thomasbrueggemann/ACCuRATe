package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;

public class zzb implements Creator<FaceSettingsParcel> {
   static void zza(FaceSettingsParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.mode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzbnV);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzbnW);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzbnX);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzbnY);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzbnZ);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhl(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkI(var1);
   }

   public FaceSettingsParcel zzhl(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      float var4 = -1.0F;
      boolean var5 = false;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 7:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new FaceSettingsParcel(var9, var8, var7, var6, var5, var2, var4);
      }
   }

   public FaceSettingsParcel[] zzkI(int var1) {
      return new FaceSettingsParcel[var1];
   }
}
