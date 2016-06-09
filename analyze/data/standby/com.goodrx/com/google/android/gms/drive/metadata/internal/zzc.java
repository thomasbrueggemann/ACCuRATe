package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.CustomProperty;

public class zzc implements Creator<CustomProperty> {
   static void zza(CustomProperty var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzasN, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.mValue, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcf(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzea(var1);
   }

   public CustomProperty zzcf(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;

      CustomPropertyKey var5;
      String var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         CustomPropertyKey var8;
         int var9;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            CustomPropertyKey var10 = (CustomPropertyKey)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var6, CustomPropertyKey.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var6);
            var8 = var5;
            var9 = var4;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new CustomProperty(var4, var5, var2);
      }
   }

   public CustomProperty[] zzea(int var1) {
      return new CustomProperty[var1];
   }
}
