package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.PaymentMethodToken;
import com.google.android.gms.wallet.ProxyCard;

public class zze implements Creator<FullWallet> {
   static void zza(FullWallet var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzboo, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzbop, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzboq, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzbor, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzbos, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.zzbot, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String[])var0.zzbou, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.zzbov, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (Parcelable)var0.zzbow, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (Parcelable[])var0.zzbox, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (Parcelable)var0.zzboy, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhs(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkQ(var1);
   }

   public FullWallet zzhs(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      ProxyCard var6 = null;
      String var7 = null;
      Address var8 = null;
      Address var9 = null;
      String[] var10 = null;
      UserAddress var11 = null;
      UserAddress var12 = null;
      InstrumentInfo[] var13 = null;
      PaymentMethodToken var14 = null;

      while(var1.dataPosition() < var2) {
         int var15 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var15)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var15);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 4:
            var6 = (ProxyCard)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, ProxyCard.CREATOR);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var15);
            break;
         case 6:
            var8 = (Address)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, Address.CREATOR);
            break;
         case 7:
            var9 = (Address)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, Address.CREATOR);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzB(var1, var15);
            break;
         case 9:
            var11 = (UserAddress)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, UserAddress.CREATOR);
            break;
         case 10:
            var12 = (UserAddress)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, UserAddress.CREATOR);
            break;
         case 11:
            var13 = (InstrumentInfo[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15, InstrumentInfo.CREATOR);
            break;
         case 12:
            var14 = (PaymentMethodToken)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var15, PaymentMethodToken.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var15);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new FullWallet(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      }
   }

   public FullWallet[] zzkQ(int var1) {
      return new FullWallet[var1];
   }
}
