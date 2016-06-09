package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;

public class zze implements Creator<DataHolder> {
   static void zza(DataHolder var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String[])var0.zzqe(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable[])var0.zzqf(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getStatusCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Bundle)var0.zzpZ(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzak(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbJ(var1);
   }

   public DataHolder zzak(Parcel var1) {
      int var2 = 0;
      Bundle var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      CursorWindow[] var5 = null;
      String[] var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var9);
            break;
         case 2:
            var5 = (CursorWindow[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9, CursorWindow.CREATOR);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var9);
            break;
         case 1000:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         DataHolder var8 = new DataHolder(var7, var6, var5, var2, var3);
         var8.zzqd();
         return var8;
      }
   }

   public DataHolder[] zzbJ(int var1) {
      return new DataHolder[var1];
   }
}
