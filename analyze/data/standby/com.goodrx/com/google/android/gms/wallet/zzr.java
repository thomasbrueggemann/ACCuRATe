package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.ProxyCard;

public class zzr implements Creator<ProxyCard> {
   static void zza(ProxyCard var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzbpF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzbpG, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzbpH);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.zzbpI);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzld(var1);
   }

   public ProxyCard zzhF(Parcel var1) {
      String var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 0;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new ProxyCard(var7, var6, var2, var5, var3);
      }
   }

   public ProxyCard[] zzld(int var1) {
      return new ProxyCard[var1];
   }
}
