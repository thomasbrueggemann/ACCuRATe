package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.nearby.messages.Strategy;

public class zzd implements Creator<Strategy> {
   static void zza(Strategy var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.zzbbL);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzbbM);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzbbN);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzbbO);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzEr());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzEs());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgc(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjh(var1);
   }

   public Strategy zzgc(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      boolean var5 = false;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 5:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 1000:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Strategy(var9, var8, var7, var6, var5, var4, var2);
      }
   }

   public Strategy[] zzjh(int var1) {
      return new Strategy[var1];
   }
}
