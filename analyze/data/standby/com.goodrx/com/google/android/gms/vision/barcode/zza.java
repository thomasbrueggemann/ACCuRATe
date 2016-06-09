package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<Barcode.Address> {
   static void zza(Barcode.Address var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.type);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String[])var0.addressLines, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgW(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkt(var1);
   }

   public Barcode.Address zzgW(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String[] var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Barcode.Address(var5, var2, var4);
      }
   }

   public Barcode.Address[] zzkt(int var1) {
      return new Barcode.Address[var1];
   }
}
