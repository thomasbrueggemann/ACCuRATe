package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;

public class zzo implements Creator<RawDataPoint> {
   static void zza(RawDataPoint var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.zzawj);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzawk);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable[])var0.zzawl, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaxg);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzaxh);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzawn);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzawo);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcZ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeY(var1);
   }

   public RawDataPoint zzcZ(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      long var4 = 0L;
      long var6 = 0L;
      Value[] var8 = null;
      int var9 = 0;
      int var10 = 0;
      long var11 = 0L;
      long var13 = 0L;

      while(var1.dataPosition() < var2) {
         int var15 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var15)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 3:
            var8 = (Value[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15, Value.CREATOR);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         case 6:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 7:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var15);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new RawDataPoint(var3, var4, var6, var8, var9, var10, var11, var13);
      }
   }

   public RawDataPoint[] zzeY(int var1) {
      return new RawDataPoint[var1];
   }
}
