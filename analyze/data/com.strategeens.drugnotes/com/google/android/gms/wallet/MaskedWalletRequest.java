package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.class_944;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
   public static final Creator<MaskedWalletRequest> CREATOR = new class_944();
   // $FF: renamed from: CK int
   private final int field_3774;
   String auG;
   String auM;
   Cart auV;
   boolean avA;
   boolean avB;
   String avC;
   String avD;
   boolean avE;
   boolean avF;
   CountrySpecification[] avG;
   boolean avH;
   boolean avI;
   ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> avJ;
   boolean avz;

   MaskedWalletRequest() {
      this.field_3774 = 3;
      this.avH = true;
      this.avI = true;
   }

   MaskedWalletRequest(int var1, String var2, boolean var3, boolean var4, boolean var5, String var6, String var7, String var8, Cart var9, boolean var10, boolean var11, CountrySpecification[] var12, boolean var13, boolean var14, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> var15) {
      this.field_3774 = var1;
      this.auM = var2;
      this.avz = var3;
      this.avA = var4;
      this.avB = var5;
      this.avC = var6;
      this.auG = var7;
      this.avD = var8;
      this.auV = var9;
      this.avE = var10;
      this.avF = var11;
      this.avG = var12;
      this.avH = var13;
      this.avI = var14;
      this.avJ = var15;
   }

   public static MaskedWalletRequest.Builder newBuilder() {
      MaskedWalletRequest var0 = new MaskedWalletRequest();
      return var0.new Builder();
   }

   public boolean allowDebitCard() {
      return this.avI;
   }

   public boolean allowPrepaidCard() {
      return this.avH;
   }

   public int describeContents() {
      return 0;
   }

   public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping() {
      return this.avJ;
   }

   public CountrySpecification[] getAllowedShippingCountrySpecifications() {
      return this.avG;
   }

   public Cart getCart() {
      return this.auV;
   }

   public String getCurrencyCode() {
      return this.auG;
   }

   public String getEstimatedTotalPrice() {
      return this.avC;
   }

   public String getMerchantName() {
      return this.avD;
   }

   public String getMerchantTransactionId() {
      return this.auM;
   }

   public int getVersionCode() {
      return this.field_3774;
   }

   public boolean isBillingAgreement() {
      return this.avF;
   }

   public boolean isPhoneNumberRequired() {
      return this.avz;
   }

   public boolean isShippingAddressRequired() {
      return this.avA;
   }

   public boolean shouldRetrieveWalletObjects() {
      return this.avE;
   }

   public boolean useMinimalBillingAddress() {
      return this.avB;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_944.method_5218(this, var1, var2);
   }

   public final class Builder {
      private Builder() {
      }

      // $FF: synthetic method
      Builder(Object var2) {
         this();
      }

      public MaskedWalletRequest.Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification var1) {
         if(MaskedWalletRequest.this.avJ == null) {
            MaskedWalletRequest.this.avJ = new ArrayList();
         }

         MaskedWalletRequest.this.avJ.add(var1);
         return this;
      }

      public MaskedWalletRequest.Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> var1) {
         if(var1 != null) {
            if(MaskedWalletRequest.this.avJ == null) {
               MaskedWalletRequest.this.avJ = new ArrayList();
            }

            MaskedWalletRequest.this.avJ.addAll(var1);
         }

         return this;
      }

      public MaskedWalletRequest build() {
         return MaskedWalletRequest.this;
      }

      public MaskedWalletRequest.Builder setAllowDebitCard(boolean var1) {
         MaskedWalletRequest.this.avI = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setAllowPrepaidCard(boolean var1) {
         MaskedWalletRequest.this.avH = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setCart(Cart var1) {
         MaskedWalletRequest.this.auV = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setCurrencyCode(String var1) {
         MaskedWalletRequest.this.auG = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setEstimatedTotalPrice(String var1) {
         MaskedWalletRequest.this.avC = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setIsBillingAgreement(boolean var1) {
         MaskedWalletRequest.this.avF = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setMerchantName(String var1) {
         MaskedWalletRequest.this.avD = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setMerchantTransactionId(String var1) {
         MaskedWalletRequest.this.auM = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setPhoneNumberRequired(boolean var1) {
         MaskedWalletRequest.this.avz = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setShippingAddressRequired(boolean var1) {
         MaskedWalletRequest.this.avA = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setShouldRetrieveWalletObjects(boolean var1) {
         MaskedWalletRequest.this.avE = var1;
         return this;
      }

      public MaskedWalletRequest.Builder setUseMinimalBillingAddress(boolean var1) {
         MaskedWalletRequest.this.avB = var1;
         return this;
      }
   }
}
