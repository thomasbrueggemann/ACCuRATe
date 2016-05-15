package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

public class zzh implements Creator<WakeLockEvent> {
   static void zza(WakeLockEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.getTimeMillis());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzrR(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzrT());
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 6, var0.zzrU(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzrN());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (String)var0.zzrS(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 11, var0.getEventType());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (String)var0.zzrK(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (String)var0.zzrW(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 14, var0.zzrV());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, var0.zzrX());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 16, var0.zzrY());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaG(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcm(var1);
   }

   public WakeLockEvent zzaG(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      long var4 = 0L;
      int var6 = 0;
      String var7 = null;
      int var8 = 0;
      ArrayList var9 = null;
      String var10 = null;
      long var11 = 0L;
      int var13 = 0;
      String var14 = null;
      String var15 = null;
      float var16 = 0.0F;
      long var17 = 0L;

      while(var1.dataPosition() < var2) {
         int var19 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var19)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var19);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var19);
            break;
         case 3:
         case 7:
         case 9:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var19);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var19);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var19);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var19);
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var19);
            break;
         case 10:
            var14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var19);
            break;
         case 11:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var19);
            break;
         case 12:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var19);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var19);
            break;
         case 14:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var19);
            break;
         case 15:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzl(var1, var19);
            break;
         case 16:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var19);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new WakeLockEvent(var3, var4, var6, var7, var8, var9, var10, var11, var13, var14, var15, var16, var17);
      }
   }

   public WakeLockEvent[] zzcm(int var1) {
      return new WakeLockEvent[var1];
   }
}
