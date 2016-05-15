package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.LogEvent;

public class zzc implements Creator<LogEvent> {
   static void zza(LogEvent var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, var0.zzbdA);
      zzb.zza(var1, 3, (String)var0.tag, false);
      zzb.zza(var1, 4, (byte[])var0.zzbdC, false);
      zzb.zza(var1, 5, (Bundle)var0.zzbdD, false);
      zzb.zza(var1, 6, var0.zzbdB);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgy(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjE(var1);
   }

   public LogEvent zzgy(Parcel var1) {
      long var2 = 0L;
      Bundle var4 = null;
      int var5 = zza.zzau(var1);
      int var6 = 0;
      byte[] var7 = null;
      String var8 = null;
      long var9 = var2;

      while(var1.dataPosition() < var5) {
         int var11 = zza.zzat(var1);
         switch(zza.zzca(var11)) {
         case 1:
            var6 = zza.zzg(var1, var11);
            break;
         case 2:
            var9 = zza.zzi(var1, var11);
            break;
         case 3:
            var8 = zza.zzp(var1, var11);
            break;
         case 4:
            var7 = zza.zzs(var1, var11);
            break;
         case 5:
            var4 = zza.zzr(var1, var11);
            break;
         case 6:
            var2 = zza.zzi(var1, var11);
            break;
         default:
            zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new LogEvent(var6, var9, var2, var8, var7, var4);
      }
   }

   public LogEvent[] zzjE(int var1) {
      return new LogEvent[var1];
   }
}
