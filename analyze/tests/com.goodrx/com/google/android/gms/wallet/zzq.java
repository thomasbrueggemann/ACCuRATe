package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;

public class zzq implements Creator<PaymentMethodTokenizationParameters> {
   static void zza(PaymentMethodTokenizationParameters var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzbpC);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Bundle)var0.zzbpD, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlc(var1);
   }

   public PaymentMethodTokenizationParameters zzhE(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      Bundle var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzr(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PaymentMethodTokenizationParameters(var5, var2, var4);
      }
   }

   public PaymentMethodTokenizationParameters[] zzlc(int var1) {
      return new PaymentMethodTokenizationParameters[var1];
   }
}
