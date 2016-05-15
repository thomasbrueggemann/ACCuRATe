package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;

public class zzh implements Creator<PlusSession> {
   static void zza(PlusSession var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getAccountName(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (String[])var0.zzFd(), false);
      zzb.zza(var1, 3, (String[])var0.zzFe(), false);
      zzb.zza(var1, 4, (String[])var0.zzFf(), false);
      zzb.zza(var1, 5, (String)var0.zzFg(), false);
      zzb.zza(var1, 6, (String)var0.zzFh(), false);
      zzb.zza(var1, 7, (String)var0.zznX(), false);
      zzb.zza(var1, 8, (String)var0.zzFi(), false);
      zzb.zza(var1, 9, (Parcelable)var0.zzFj(), var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzjI(var1);
   }

   public PlusSession zzgB(Parcel var1) {
      PlusCommonExtras var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String[] var9 = null;
      String[] var10 = null;
      String[] var11 = null;
      String var12 = null;

      while(var1.dataPosition() < var3) {
         int var13 = zza.zzat(var1);
         switch(zza.zzca(var13)) {
         case 1:
            var12 = zza.zzp(var1, var13);
            break;
         case 2:
            var11 = zza.zzB(var1, var13);
            break;
         case 3:
            var10 = zza.zzB(var1, var13);
            break;
         case 4:
            var9 = zza.zzB(var1, var13);
            break;
         case 5:
            var8 = zza.zzp(var1, var13);
            break;
         case 6:
            var7 = zza.zzp(var1, var13);
            break;
         case 7:
            var6 = zza.zzp(var1, var13);
            break;
         case 8:
            var5 = zza.zzp(var1, var13);
            break;
         case 9:
            var2 = (PlusCommonExtras)zza.zza(var1, var13, PlusCommonExtras.CREATOR);
            break;
         case 1000:
            var4 = zza.zzg(var1, var13);
            break;
         default:
            zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PlusSession(var4, var12, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public PlusSession[] zzjI(int var1) {
      return new PlusSession[var1];
   }
}
