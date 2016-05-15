package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;

public class zzb implements Creator<WebImage> {
   static void zza(WebImage var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getUrl(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getWidth());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getHeight());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzal(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbN(var1);
   }

   public WebImage zzal(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Uri var4 = null;
      int var5 = 0;

      int var6;
      int var8;
      for(var6 = 0; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         int var9;
         Uri var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var4;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            Uri var14 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, Uri.CREATOR);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var10 = var4;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var4;
            var11 = var6;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var4;
            var11 = var6;
         }

         var6 = var11;
         var4 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new WebImage(var6, var4, var5, var2);
      }
   }

   public WebImage[] zzbN(int var1) {
      return new WebImage[var1];
   }
}
