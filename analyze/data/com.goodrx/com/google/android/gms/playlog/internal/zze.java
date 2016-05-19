package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zze implements Creator<PlayLoggerContext> {
   static void zza(PlayLoggerContext var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zza(var1, 2, (String)var0.packageName, false);
      zzb.zzc(var1, 3, var0.zzbdL);
      zzb.zzc(var1, 4, var0.zzbdM);
      zzb.zza(var1, 5, (String)var0.zzbdN, false);
      zzb.zza(var1, 6, (String)var0.zzbdO, false);
      zzb.zza(var1, 7, var0.zzbdP);
      zzb.zza(var1, 8, (String)var0.zzbdQ, false);
      zzb.zza(var1, 9, var0.zzbdR);
      zzb.zzc(var1, 10, var0.zzbdS);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgz(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjF(var1);
   }

   public PlayLoggerContext zzgz(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = zza.zzau(var1);
      boolean var5 = true;
      boolean var6 = false;
      String var7 = null;
      String var8 = null;
      int var9 = 0;
      int var10 = 0;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = zza.zzat(var1);
         switch(zza.zzca(var13)) {
         case 1:
            var12 = zza.zzg(var1, var13);
            break;
         case 2:
            var11 = zza.zzp(var1, var13);
            break;
         case 3:
            var10 = zza.zzg(var1, var13);
            break;
         case 4:
            var9 = zza.zzg(var1, var13);
            break;
         case 5:
            var8 = zza.zzp(var1, var13);
            break;
         case 6:
            var7 = zza.zzp(var1, var13);
            break;
         case 7:
            var5 = zza.zzc(var1, var13);
            break;
         case 8:
            var2 = zza.zzp(var1, var13);
            break;
         case 9:
            var6 = zza.zzc(var1, var13);
            break;
         case 10:
            var3 = zza.zzg(var1, var13);
            break;
         default:
            zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new PlayLoggerContext(var12, var11, var10, var9, var8, var7, var5, var2, var6, var3);
      }
   }

   public PlayLoggerContext[] zzjF(int var1) {
      return new PlayLoggerContext[var1];
   }
}
