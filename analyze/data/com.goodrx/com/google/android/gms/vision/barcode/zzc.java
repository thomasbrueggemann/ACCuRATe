package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zzc implements Creator<Barcode.CalendarDateTime> {
   static void zza(Barcode.CalendarDateTime var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.year);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.month);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.day);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.hours);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.minutes);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.seconds);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.isUtc);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.rawValue, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgY(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkv(var1);
   }

   public Barcode.CalendarDateTime zzgY(Parcel var1) {
      boolean var2 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      int var11 = 0;

      while(var1.dataPosition() < var3) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         case 9:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Barcode.CalendarDateTime(var11, var10, var9, var8, var7, var6, var5, var2, var4);
      }
   }

   public Barcode.CalendarDateTime[] zzkv(int var1) {
      return new Barcode.CalendarDateTime[var1];
   }
}
