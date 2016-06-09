package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

public class zzc implements Creator<Bucket> {
   static void zza(Bucket var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, var0.zzlO());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzud());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getSession(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzub());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.getDataSets(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.getBucketType());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzuc());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcP(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeN(var1);
   }

   public Bucket zzcP(Parcel var1) {
      long var2 = 0L;
      ArrayList var4 = null;
      boolean var5 = false;
      int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var7 = 0;
      int var8 = 0;
      Session var9 = null;
      long var10 = var2;
      int var12 = 0;

      while(var1.dataPosition() < var6) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var13);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var13);
            break;
         case 3:
            var9 = (Session)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, Session.CREATOR);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 5:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13, DataSet.CREATOR);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 1000:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var6, var1);
      } else {
         return new Bucket(var12, var10, var2, var9, var8, var4, var7, var5);
      }
   }

   public Bucket[] zzeN(int var1) {
      return new Bucket[var1];
   }
}
