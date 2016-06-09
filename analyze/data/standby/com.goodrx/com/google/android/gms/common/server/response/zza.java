package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse;

public class zza implements Creator<FastJsonResponse.Field> {
   static void zza(FastJsonResponse.Field var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzrj());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzrp());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzrk());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzrq());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzrr(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzrs());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzru(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.zzrw(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcg(var1);
   }

   public FastJsonResponse.Field zzaA(Parcel var1) {
      ConverterWrapper var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var5 = null;
      String var6 = null;
      boolean var7 = false;
      int var8 = 0;
      boolean var9 = false;
      int var10 = 0;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 9:
            var2 = (ConverterWrapper)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, ConverterWrapper.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new FastJsonResponse.Field(var11, var10, var9, var8, var7, var6, var3, var5, var2);
      }
   }

   public FastJsonResponse.Field[] zzcg(int var1) {
      return new FastJsonResponse.Field[var1];
   }
}
