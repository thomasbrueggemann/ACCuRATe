package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_719;

public final class MaskedWallet implements SafeParcelable {
   public static final Creator<MaskedWallet> CREATOR = new class_719();
   String aiN;
   String aiO;
   String aiQ;
   Address aiR;
   Address aiS;
   String[] aiT;
   UserAddress aiU;
   UserAddress aiV;
   InstrumentInfo[] aiW;
   OfferWalletObject[] ajA;
   LoyaltyWalletObject[] ajz;
   // $FF: renamed from: xJ int
   private final int field_3517;

   private MaskedWallet() {
      this.field_3517 = 2;
   }

   MaskedWallet(int var1, String var2, String var3, String[] var4, String var5, Address var6, Address var7, LoyaltyWalletObject[] var8, OfferWalletObject[] var9, UserAddress var10, UserAddress var11, InstrumentInfo[] var12) {
      this.field_3517 = var1;
      this.aiN = var2;
      this.aiO = var3;
      this.aiT = var4;
      this.aiQ = var5;
      this.aiR = var6;
      this.aiS = var7;
      this.ajz = var8;
      this.ajA = var9;
      this.aiU = var10;
      this.aiV = var11;
      this.aiW = var12;
   }

   // $FF: renamed from: nb () com.google.android.gms.wallet.MaskedWallet$Builder
   public static MaskedWallet.Builder method_3854() {
      MaskedWallet var0 = new MaskedWallet();
      return var0.new Builder();
   }

   public static MaskedWallet.Builder newBuilderFrom(MaskedWallet var0) {
      class_347.method_2170(var0);
      return method_3854().setGoogleTransactionId(var0.getGoogleTransactionId()).setMerchantTransactionId(var0.getMerchantTransactionId()).setPaymentDescriptions(var0.getPaymentDescriptions()).setInstrumentInfos(var0.getInstrumentInfos()).setEmail(var0.getEmail()).setLoyaltyWalletObjects(var0.getLoyaltyWalletObjects()).setOfferWalletObjects(var0.getOfferWalletObjects()).setBuyerBillingAddress(var0.getBuyerBillingAddress()).setBuyerShippingAddress(var0.getBuyerShippingAddress());
   }

   public int describeContents() {
      return 0;
   }

   @Deprecated
   public Address getBillingAddress() {
      return this.aiR;
   }

   public UserAddress getBuyerBillingAddress() {
      return this.aiU;
   }

   public UserAddress getBuyerShippingAddress() {
      return this.aiV;
   }

   public String getEmail() {
      return this.aiQ;
   }

   public String getGoogleTransactionId() {
      return this.aiN;
   }

   public InstrumentInfo[] getInstrumentInfos() {
      return this.aiW;
   }

   public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
      return this.ajz;
   }

   public String getMerchantTransactionId() {
      return this.aiO;
   }

   public OfferWalletObject[] getOfferWalletObjects() {
      return this.ajA;
   }

   public String[] getPaymentDescriptions() {
      return this.aiT;
   }

   @Deprecated
   public Address getShippingAddress() {
      return this.aiS;
   }

   public int getVersionCode() {
      return this.field_3517;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_719.method_4087(this, var1, var2);
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
         MaskedWallet.this.aiR = var1;
         return this;
      }

      public MaskedWallet.Builder setBuyerBillingAddress(UserAddress var1) {
         MaskedWallet.this.aiU = var1;
         return this;
      }

      public MaskedWallet.Builder setBuyerShippingAddress(UserAddress var1) {
         MaskedWallet.this.aiV = var1;
         return this;
      }

      public MaskedWallet.Builder setEmail(String var1) {
         MaskedWallet.this.aiQ = var1;
         return this;
      }

      public MaskedWallet.Builder setGoogleTransactionId(String var1) {
         MaskedWallet.this.aiN = var1;
         return this;
      }

      public MaskedWallet.Builder setInstrumentInfos(InstrumentInfo[] var1) {
         MaskedWallet.this.aiW = var1;
         return this;
      }

      public MaskedWallet.Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] var1) {
         MaskedWallet.this.ajz = var1;
         return this;
      }

      public MaskedWallet.Builder setMerchantTransactionId(String var1) {
         MaskedWallet.this.aiO = var1;
         return this;
      }

      public MaskedWallet.Builder setOfferWalletObjects(OfferWalletObject[] var1) {
         MaskedWallet.this.ajA = var1;
         return this;
      }

      public MaskedWallet.Builder setPaymentDescriptions(String[] var1) {
         MaskedWallet.this.aiT = var1;
         return this;
      }

      public MaskedWallet.Builder setShippingAddress(Address var1) {
         MaskedWallet.this.aiS = var1;
         return this;
      }
   }
}
