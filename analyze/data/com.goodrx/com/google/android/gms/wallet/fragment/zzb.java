package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public class zzb implements Creator<WalletFragmentOptions> {
   static void zza(WalletFragmentOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.getEnvironment());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.getTheme());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.getFragmentStyle(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.getMode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhM(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlk(var1);
   }

   public WalletFragmentOptions zzhM(Parcel var1) {
      int var2 = 1;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      WalletFragmentStyle var5 = null;
      int var6 = var2;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 4:
            var5 = (WalletFragmentStyle)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, WalletFragmentStyle.CREATOR);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new WalletFragmentOptions(var7, var6, var3, var5, var2);
      }
   }

   public WalletFragmentOptions[] zzlk(int var1) {
      return new WalletFragmentOptions[var1];
   }
}
