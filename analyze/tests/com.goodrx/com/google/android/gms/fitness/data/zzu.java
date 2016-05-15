package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Value;

public class zzu implements Creator<Value> {
   static void zza(Value var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getFormat());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.isSet());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzuv());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzuA(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Bundle)var0.zzuB(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (int[])var0.zzuC(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (float[])var0.zzuD(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (byte[])var0.zzuE(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzde(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfe(var1);
   }

   public Value zzde(Parcel var1) {
      boolean var2 = false;
      byte[] var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      float var5 = 0.0F;
      float[] var6 = null;
      int[] var7 = null;
      Bundle var8 = null;
      String var9 = null;
      int var10 = 0;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var12);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var12);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var12);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzv(var1, var12);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzy(var1, var12);
            break;
         case 8:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var1, var12);
            break;
         case 1000:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Value(var11, var10, var2, var5, var9, var8, var7, var6, var3);
      }
   }

   public Value[] zzfe(int var1) {
      return new Value[var1];
   }
}
