package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_938;

public final class MaskedWallet implements SafeParcelable {
   public static final Creator<MaskedWallet> CREATOR = new class_938();
   // $FF: renamed from: CK int
   private final int field_3664;
   String auL;
   String auM;
   String auO;
   Address auP;
   Address auQ;
   String[] auR;
   UserAddress auS;
   UserAddress auT;
   InstrumentInfo[] auU;
   LoyaltyWalletObject[] avw;
   OfferWalletObject[] avx;

   private MaskedWallet() {
      this.field_3664 = 2;
   }

   MaskedWallet(int var1, String var2, String var3, String[] var4, String var5, Address var6, Address var7, LoyaltyWalletObject[] var8, OfferWalletObject[] var9, UserAddress var10, UserAddress var11, InstrumentInfo[] var12) {
      this.field_3664 = var1;
      this.auL = var2;
      this.auM = var3;
      this.auR = var4;
      this.auO = var5;
      this.auP = var6;
      this.auQ = var7;
      this.avw = var8;
      this.avx = var9;
      this.auS = var10;
      this.auT = var11;
      this.auU = var12;
   }

   public static MaskedWallet.Builder newBuilderFrom(MaskedWallet var0) {
      class_335.method_2311(var0);
      return method_4825().setGoogleTransactionId(var0.getGoogleTransactionId()).setMerchantTransactionId(var0.getMerchantTransactionId()).setPaymentDescriptions(var0.getPaymentDescriptions()).setInstrumentInfos(var0.getInstrumentInfos()).setEmail(var0.getEmail()).setLoyaltyWalletObjects(var0.getLoyaltyWalletObjects()).setOfferWalletObjects(var0.getOfferWalletObjects()).setBuyerBillingAddress(var0.getBuyerBillingAddress()).setBuyerShippingAddress(var0.getBuyerShippingAddress());
   }

   // $FF: renamed from: rd () com.google.android.gms.wallet.MaskedWallet$Builder
   public static MaskedWallet.Builder method_4825() {
      MaskedWallet var0 = new MaskedWallet();
      return var0.new Builder();
   }

   public int describeContents() {
      return 0;
   }

   @Deprecated
   public Address getBillingAddress() {
      return this.auP;
   }

   public UserAddress getBuyerBillingAddress() {
      return this.auS;
   }

   public UserAddress getBuyerShippingAddress() {
      return this.auT;
   }

   public String getEmail() {
      return this.auO;
   }

   public String getGoogleTransactionId() {
      return this.auL;
   }

   public InstrumentInfo[] getInstrumentInfos() {
      return this.auU;
   }

   public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
      return this.avw;
   }

   public String getMerchantTransactionId() {
      return this.auM;
   }

   public OfferWalletObject[] getOfferWalletObjects() {
      return this.avx;
   }

   public String[] getPaymentDescriptions() {
      return this.auR;
   }

   @Deprecated
   public Address getShippingAddress() {
      return this.auQ;
   }

   public int getVersionCode() {
      return this.field_3664;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_938.method_5198(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public MaskedWallet build() {
         return MaskedWallet.this;
      }

      public MaskedWallet.Builder setBillingAddress(Address var1) {
         MaskedWallet.this.auP = var1;
         return this;
      }

      public MaskedWallet.Builder setBuyerBillingAddress(UserAddress var1) {
         MaskedWallet.this.auS = var1;
         return this;
      }

      public MaskedWallet.Builder setBuyerShippingAddress(UserAddress var1) {
         MaskedWallet.this.auT = var1;
         return this;
      }

      public MaskedWallet.Builder setEmail(String var1) {
         MaskedWallet.this.auO = var1;
         return this;
      }

      public MaskedWallet.Builder setGoogleTransactionId(String var1) {
         MaskedWallet.this.auL = var1;
         return this;
      }

      public MaskedWallet.Builder setInstrumentInfos(InstrumentInfo[] var1) {
         MaskedWallet.this.auU = var1;
         return this;
      }

      public MaskedWallet.Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] var1) {
         MaskedWallet.this.avw = var1;
         return this;
      }

      public MaskedWallet.Builder setMerchantTransactionId(String var1) {
         MaskedWallet.this.auM = var1;
         return this;
      }

      public MaskedWallet.Builder setOfferWalletObjects(OfferWalletObject[] var1) {
         MaskedWallet.this.avx = var1;
         return this;
      }

      public MaskedWallet.Builder setPaymentDescriptions(String[] var1) {
         MaskedWallet.this.auR = var1;
         return this;
      }

      public MaskedWallet.Builder setShippingAddress(Address var1) {
         MaskedWallet.this.auQ = var1;
         return this;
      }
   }
}
