package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zzi implements Creator<Barcode.PersonName> {
   static void zza(Barcode.PersonName var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.formattedName, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.pronunciation, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.prefix, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.first, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.middle, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.last, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.suffix, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhe(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkB(var1);
   }

   public Barcode.PersonName zzhe(Parcel var1) {
      String var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Barcode.PersonName(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public Barcode.PersonName[] zzkB(int var1) {
      return new Barcode.PersonName[var1];
   }
}
