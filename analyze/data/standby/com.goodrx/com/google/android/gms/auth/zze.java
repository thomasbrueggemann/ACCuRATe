package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.TokenData;
import java.util.ArrayList;

public class zze implements Creator<TokenData> {
   static void zza(TokenData var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getToken(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Long)var0.zzmn(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzmo());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzmp());
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 6, var0.zzmq(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzC(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzax(var1);
   }

   public TokenData zzC(Parcel var1) {
      ArrayList var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var5 = false;
      Long var6 = null;
      String var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzj(var1, var9);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var9);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new TokenData(var8, var7, var6, var5, var3, var2);
      }
   }

   public TokenData[] zzax(int var1) {
      return new TokenData[var1];
   }
}
