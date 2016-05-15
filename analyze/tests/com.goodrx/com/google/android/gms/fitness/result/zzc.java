package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.ArrayList;

public class zzc implements Creator<DataReadResult> {
   static void zza(DataReadResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzd(var1, 1, var0.zzvl(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzd(var1, 3, var0.zzvk(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzvj());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzul(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzvm(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzdP(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzfQ(var1);
   }

   public DataReadResult zzdP(Parcel var1) {
      int var2 = 0;
      ArrayList var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = null;
      Status var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, var5, this.getClass().getClassLoader());
            break;
         case 2:
            var8 = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, Status.CREATOR);
            break;
         case 3:
            com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, var6, this.getClass().getClassLoader());
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10, DataSource.CREATOR);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10, DataType.CREATOR);
            break;
         case 1000:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new DataReadResult(var9, var5, var8, var6, var2, var7, var3);
      }
   }

   public DataReadResult[] zzfQ(int var1) {
      return new DataReadResult[var1];
   }
}
