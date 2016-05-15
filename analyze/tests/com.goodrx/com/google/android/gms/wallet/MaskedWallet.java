package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.zzl;

public final class MaskedWallet implements SafeParcelable {
   public static final Creator<MaskedWallet> CREATOR = new zzl();
   private final int mVersionCode;
   String zzboo;
   String zzbop;
   String zzbor;
   Address zzbos;
   Address zzbot;
   String[] zzbou;
   UserAddress zzbov;
   UserAddress zzbow;
   InstrumentInfo[] zzbox;
   LoyaltyWalletObject[] zzbpi;
   OfferWalletObject[] zzbpj;

   private MaskedWallet() {
      this.mVersionCode = 2;
   }

   MaskedWallet(int var1, String var2, String var3, String[] var4, String var5, Address var6, Address var7, LoyaltyWalletObject[] var8, OfferWalletObject[] var9, UserAddress var10, UserAddress var11, InstrumentInfo[] var12) {
      this.mVersionCode = var1;
      this.zzboo = var2;
      this.zzbop = var3;
      this.zzbou = var4;
      this.zzbor = var5;
      this.zzbos = var6;
      this.zzbot = var7;
      this.zzbpi = var8;
      this.zzbpj = var9;
      this.zzbov = var10;
      this.zzbow = var11;
      this.zzbox = var12;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl.zza(this, var1, var2);
   }
}
