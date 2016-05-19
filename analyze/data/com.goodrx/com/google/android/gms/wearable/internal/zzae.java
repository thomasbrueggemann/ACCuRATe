package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.internal.DataItemParcelable;

public class zzae implements Creator<DataItemParcelable> {
   static void zza(DataItemParcelable var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (Parcelable)var0.getUri(), var2, false);
      zzb.zza(var1, 4, (Bundle)var0.zzIv(), false);
      zzb.zza(var1, 5, (byte[])var0.getData(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzil(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlP(var1);
   }

   public DataItemParcelable zzil(Parcel var1) {
      byte[] var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      Bundle var5 = null;

      Uri var6;
      byte[] var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = zza.zzat(var1);
         Bundle var9;
         Uri var10;
         int var11;
         switch(zza.zzca(var7)) {
         case 1:
            int var16 = zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            Uri var14 = (Uri)zza.zza(var1, var7, Uri.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
         default:
            zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 4:
            Bundle var12 = zza.zzr(var1, var7);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 5:
            var8 = zza.zzs(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DataItemParcelable(var4, var6, var5, var2);
      }
   }

   public DataItemParcelable[] zzlP(int var1) {
      return new DataItemParcelable[var1];
   }
}
