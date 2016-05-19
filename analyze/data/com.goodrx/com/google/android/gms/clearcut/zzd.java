package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Creator<LogEventParcelable> {
   static void zza(LogEventParcelable var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzafh, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (byte[])var0.zzafi, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (int[])var0.zzafj, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaf(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzbs(var1);
   }

   public LogEventParcelable zzaf(Parcel var1) {
      int[] var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      byte[] var5 = null;

      PlayLoggerContext var6;
      int[] var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = zza.zzat(var1);
         byte[] var9;
         PlayLoggerContext var10;
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
            PlayLoggerContext var14 = (PlayLoggerContext)zza.zza(var1, var7, PlayLoggerContext.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            byte[] var12 = zza.zzs(var1, var7);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = zza.zzv(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         default:
            zza.zzb(var1, var7);
            var8 = var2;
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
         return new LogEventParcelable(var4, var6, var5, var2);
      }
   }

   public LogEventParcelable[] zzbs(int var1) {
      return new LogEventParcelable[var1];
   }
}
