package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.class_1029;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new class_1029();
    // $FF: renamed from: BR int
    private final int field_4511;
    String asC;
    Cart asL;
    String asw;
    boolean atp;
    boolean atq;
    boolean atr;
    String ats;
    String att;
    boolean atu;
    boolean atv;
    CountrySpecification[] atw;
    boolean atx;
    boolean aty;
    ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> atz;

    MaskedWalletRequest() {
        this.field_4511 = 3;
        this.atx = true;
        this.aty = true;
    }

    MaskedWalletRequest(int var1, String var2, boolean var3, boolean var4, boolean var5, String var6, String var7, String var8, Cart var9, boolean var10, boolean var11, CountrySpecification[] var12, boolean var13, boolean var14, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> var15) {
        this.field_4511 = var1;
        this.asC = var2;
        this.atp = var3;
        this.atq = var4;
        this.atr = var5;
        this.ats = var6;
        this.asw = var7;
        this.att = var8;
        this.asL = var9;
        this.atu = var10;
        this.atv = var11;
        this.atw = var12;
        this.atx = var13;
        this.aty = var14;
        this.atz = var15;
    }

    public static MaskedWalletRequest.Builder newBuilder() {
        MaskedWalletRequest var0 = new MaskedWalletRequest();
        return var0.new Builder();
    }

    public boolean allowDebitCard() {
        return this.aty;
    }

    public boolean allowPrepaidCard() {
        return this.atx;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.atz;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.atw;
    }

    public Cart getCart() {
        return this.asL;
    }

    public String getCurrencyCode() {
        return this.asw;
    }

    public String getEstimatedTotalPrice() {
        return this.ats;
    }

    public String getMerchantName() {
        return this.att;
    }

    public String getMerchantTransactionId() {
        return this.asC;
    }

    public int getVersionCode() {
        return this.field_4511;
    }

    public boolean isBillingAgreement() {
        return this.atv;
    }

    public boolean isPhoneNumberRequired() {
        return this.atp;
    }

    public boolean isShippingAddressRequired() {
        return this.atq;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.atu;
    }

    public boolean useMinimalBillingAddress() {
        return this.atr;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1029.method_5361(this, var1, var2);
    }

    public final class Builder {
        private Builder() {
        }

        // $FF: synthetic method
        Builder(Object var2) {
            this();
        }

        public MaskedWalletRequest.Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification var1) {
            if(MaskedWalletRequest.this.atz == null) {
                MaskedWalletRequest.this.atz = new ArrayList();
            }

            MaskedWalletRequest.this.atz.add(var1);
            return this;
        }

        public MaskedWalletRequest.Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> var1) {
            if(var1 != null) {
                if(MaskedWalletRequest.this.atz == null) {
                    MaskedWalletRequest.this.atz = new ArrayList();
                }

                MaskedWalletRequest.this.atz.addAll(var1);
            }

            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public MaskedWalletRequest.Builder setAllowDebitCard(boolean var1) {
            MaskedWalletRequest.this.aty = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setAllowPrepaidCard(boolean var1) {
            MaskedWalletRequest.this.atx = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setCart(Cart var1) {
            MaskedWalletRequest.this.asL = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setCurrencyCode(String var1) {
            MaskedWalletRequest.this.asw = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setEstimatedTotalPrice(String var1) {
            MaskedWalletRequest.this.ats = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setIsBillingAgreement(boolean var1) {
            MaskedWalletRequest.this.atv = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setMerchantName(String var1) {
            MaskedWalletRequest.this.att = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setMerchantTransactionId(String var1) {
            MaskedWalletRequest.this.asC = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setPhoneNumberRequired(boolean var1) {
            MaskedWalletRequest.this.atp = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setShippingAddressRequired(boolean var1) {
            MaskedWalletRequest.this.atq = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setShouldRetrieveWalletObjects(boolean var1) {
            MaskedWalletRequest.this.atu = var1;
            return this;
        }

        public MaskedWalletRequest.Builder setUseMinimalBillingAddress(boolean var1) {
            MaskedWalletRequest.this.atr = var1;
            return this;
        }
    }
}
