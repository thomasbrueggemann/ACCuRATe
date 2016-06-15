package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.class_725;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
   public static final Creator<MaskedWalletRequest> CREATOR = new class_725();
   String aiI;
   String aiO;
   Cart aiX;
   boolean ajC;
   boolean ajD;
   boolean ajE;
   String ajF;
   String ajG;
   boolean ajH;
   boolean ajI;
   CountrySpecification[] ajJ;
   boolean ajK;
   boolean ajL;
   ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> ajM;
   // $FF: renamed from: xJ int
   private final int field_3636;

   MaskedWalletRequest() {
      this.field_3636 = 3;
      this.ajK = true;
      this.ajL = true;
   }

   MaskedWalletRequest(int var1, String var2, boolean var3, boolean var4, boolean var5, String var6, String var7, String var8, Cart var9, boolean var10, boolean var11, CountrySpecification[] var12, boolean var13, boolean var14, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> var15) {
      this.field_3636 = var1;
      this.aiO = var2;
      this.ajC = var3;
      this.ajD = var4;
      this.ajE = var5;
      this.ajF = var6;
      this.aiI = var7;
      this.ajG = var8;
      this.aiX = var9;
      this.ajH = var10;
      this.ajI = var11;
      this.ajJ = var12;
      this.ajK = var13;
      this.ajL = var14;
      this.ajM = var15;
   }

   public static MaskedWalletRequest.Builder newBuilder() {
      MaskedWalletRequest var0 = new MaskedWalletRequest();
      return var0.new Builder();
   }

   public boolean allowDebitCard() {
      return this.ajL;
   }

   public boolean allowPrepaidCard() {
      return this.ajK;
   }

   public int describeContents() {
      return 0;
   }

   public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping() {
      return this.ajM;
   }

   public CountrySpecification[] getAllowedShippingCountrySpecifications() {
      return this.ajJ;
   }

   public Cart getCart() {
      return this.aiX;
   }

   public String getCurrencyCode() {
      return this.aiI;
   }

   public String getEstimatedTotalPrice() {
      return this.ajF;
   }

   public String getMerchantName() {
      return this.ajG;
   }

   public String getMerchantTransactionId() {
      return this.aiO;
   }

   public int getVersionCode() {
      return this.field_3636;
   }

   public boolean isBillingAgreement() {
      return this.ajI;
   }

   public boolean isPhoneNumberRequired() {
      return this.ajC;
   }

   public boolean isShippingAddressRequired() {
      return this.ajD;
   }

   public boolean shouldRetrieveWalletObjects() {
      return this.ajH;
   }

   public boolean useMinimalBillingAddress() {
      return this.ajE;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_725.method_4107(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public MaskedWalletRequest.Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification var1) {
         if(MaskedWalletRequest.this.ajM == null) {
            MaskedWalletRequest.this.ajM = new ArrayList();
         }

         MaskedWalletRequest.this.ajM.add(var1);
         return this;
      }

      public MaskedWalletRequest.Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> var1) {
         if(var1 != null) {
            if(MaskedWalletRequest.this.ajM == null) {
               MaskedWalletRequest.this.ajM = new ArrayList();
            }

            MaskedWalletRequest.this.ajM.addAll(var1);
         }

         return this;
      }

      public MaskedWalletRequest build() {
         return MaskedWalletRequest.this;
      }

      public MaskedWalletRequest.Builder setAllowDebitCard(boolean var1) {
         MaskedWalletRequest.this.ajL = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setAllowPrepaidCard(boolean var1) {
         MaskedWalletRequest.this.ajK = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setCart(Cart var1) {
         MaskedWalletRequest.this.aiX = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setCurrencyCode(String var1) {
         MaskedWalletRequest.this.aiI = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setEstimatedTotalPrice(String var1) {
         MaskedWalletRequest.this.ajF = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setIsBillingAgreement(boolean var1) {
         MaskedWalletRequest.this.ajI = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setMerchantName(String var1) {
         MaskedWalletRequest.this.ajG = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setMerchantTransactionId(String var1) {
         MaskedWalletRequest.this.aiO = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setPhoneNumberRequired(boolean var1) {
         MaskedWalletRequest.this.ajC = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setShippingAddressRequired(boolean var1) {
         MaskedWalletRequest.this.ajD = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setShouldRetrieveWalletObjects(boolean var1) {
         MaskedWalletRequest.this.ajH = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setUseMinimalBillingAddress(boolean var1) {
         MaskedWalletRequest.this.ajE = var1;
         return this;
      }
   }
}
