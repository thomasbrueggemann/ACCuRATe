package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;

public class zza implements Creator<WalletFragmentInitParams> {
   static void zza(WalletFragmentInitParams var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.getAccountName(), false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.getMaskedWalletRequest(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.getMaskedWalletRequestCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.getMaskedWallet(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhL(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlj(var1);
   }

   public WalletFragmentInitParams zzhL(Parcel var1) {
      MaskedWallet var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      int var5 = -1;
      MaskedWalletRequest var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var6 = (MaskedWalletRequest)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, MaskedWalletRequest.CREATOR);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 5:
            var2 = (MaskedWallet)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, MaskedWallet.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new WalletFragmentInitParams(var4, var7, var6, var5, var2);
      }
   }

   public WalletFragmentInitParams[] zzlj(int var1) {
      return new WalletFragmentInitParams[var1];
   }
}
