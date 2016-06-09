package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zzh implements Creator<Barcode.GeoPoint> {
   static void zza(Barcode.GeoPoint var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.lat);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.lng);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhd(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkA(var1);
   }

   public Barcode.GeoPoint zzhd(Parcel var1) {
      double var2 = 0.0D;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      double var6 = var2;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzn(var1, var8);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzn(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Barcode.GeoPoint(var5, var6, var2);
      }
   }

   public Barcode.GeoPoint[] zzkA(int var1) {
      return new Barcode.GeoPoint[var1];
   }
}
