package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zzf implements Creator<Barcode.DriverLicense> {
   static void zza(Barcode.DriverLicense var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.documentType, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.firstName, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.middleName, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.lastName, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.gender, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.addressStreet, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.addressCity, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.addressState, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (String)var0.addressZip, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (String)var0.licenseNumber, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (String)var0.issueDate, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (String)var0.expiryDate, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (String)var0.birthDate, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (String)var0.issuingCountry, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhb(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzky(var1);
   }

   public Barcode.DriverLicense zzhb(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      String var13 = null;
      String var14 = null;
      String var15 = null;
      String var16 = null;
      String var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var18)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 14:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 15:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new Barcode.DriverLicense(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   public Barcode.DriverLicense[] zzky(int var1) {
      return new Barcode.DriverLicense[var1];
   }
}
