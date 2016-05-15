package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdSizeParcel;

public class zzi implements Creator<AdSizeParcel> {
   static void zza(AdSizeParcel var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzuh, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.height);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.heightPixels);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzui);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.width);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.widthPixels);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable[])var0.zzuj, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, var0.zzuk);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.zzul);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.zzum);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzc(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzm(var1);
   }

   public AdSizeParcel zzc(Parcel var1) {
      AdSizeParcel[] var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var5 = false;
      boolean var6 = false;
      int var7 = 0;
      int var8 = 0;
      boolean var9 = false;
      int var10 = 0;
      int var11 = 0;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var14)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var14);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 8:
            var2 = (AdSizeParcel[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var14, AdSizeParcel.CREATOR);
            break;
         case 9:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var14);
            break;
         case 10:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var14);
            break;
         case 11:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var14);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new AdSizeParcel(var13, var12, var11, var10, var9, var8, var7, var2, var6, var5, var3);
      }
   }

   public AdSizeParcel[] zzm(int var1) {
      return new AdSizeParcel[var1];
   }
}
