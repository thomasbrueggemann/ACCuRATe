package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.PutDataRequest;

public class zzh implements Creator<PutDataRequest> {
   static void zza(PutDataRequest var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (Parcelable)var0.getUri(), var2, false);
      zzb.zza(var1, 4, (Bundle)var0.zzIv(), false);
      zzb.zza(var1, 5, (byte[])var0.getData(), false);
      zzb.zza(var1, 6, var0.zzIw());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhZ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlA(var1);
   }

   public PutDataRequest zzhZ(Parcel var1) {
      byte[] var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      long var5 = 0L;
      Bundle var7 = null;
      Uri var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = zza.zzat(var1);
         switch(zza.zzca(var9)) {
         case 1:
            var4 = zza.zzg(var1, var9);
            break;
         case 2:
            var8 = (Uri)zza.zza(var1, var9, Uri.CREATOR);
            break;
         case 3:
         default:
            zza.zzb(var1, var9);
            break;
         case 4:
            var7 = zza.zzr(var1, var9);
            break;
         case 5:
            var2 = zza.zzs(var1, var9);
            break;
         case 6:
            var5 = zza.zzi(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PutDataRequest(var4, var8, var7, var2, var5);
      }
   }

   public PutDataRequest[] zzlA(int var1) {
      return new PutDataRequest[var1];
   }
}
