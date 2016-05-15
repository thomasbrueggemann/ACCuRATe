package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import java.util.ArrayList;
import java.util.List;

public class zzm implements Creator<MaskedWalletRequest> {
   static void zza(MaskedWalletRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzbop, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzbpl);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, var0.zzbpm);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzbpn);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzbpo, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzboi, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzbpp, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.zzboz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, var0.zzbpq);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, var0.zzbpr);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (Parcelable[])var0.zzbps, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, var0.zzbpt);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, var0.zzbpu);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 15, var0.zzbpv, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 17, (List)var0.zzbpx, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 16, (Parcelable)var0.zzbpw, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkY(var1);
   }

   public MaskedWalletRequest zzhA(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      Cart var11 = null;
      boolean var12 = false;
      boolean var13 = false;
      CountrySpecification[] var14 = null;
      boolean var15 = true;
      boolean var16 = true;
      ArrayList var17 = null;
      PaymentMethodTokenizationParameters var18 = null;
      ArrayList var19 = null;

      while(var1.dataPosition() < var2) {
         int var20 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var20)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var20);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var20);
            break;
         case 9:
            var11 = (Cart)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var20, Cart.CREATOR);
            break;
         case 10:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 11:
            var13 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 12:
            var14 = (CountrySpecification[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var20, CountrySpecification.CREATOR);
            break;
         case 13:
            var15 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 14:
            var16 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20);
            break;
         case 15:
            var17 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var20, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
            break;
         case 16:
            var18 = (PaymentMethodTokenizationParameters)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var20, PaymentMethodTokenizationParameters.CREATOR);
            break;
         case 17:
            var19 = com.google.android.gms.common.internal.safeparcel.zza.zzC(var1, var20);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var20);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new MaskedWalletRequest(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
      }
   }

   public MaskedWalletRequest[] zzkY(int var1) {
      return new MaskedWalletRequest[var1];
   }
}
