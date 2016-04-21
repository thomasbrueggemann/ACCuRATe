package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_1023;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new class_1023();
    // $FF: renamed from: BR int
    private final int field_4428;
    String asB;
    String asC;
    String asE;
    Address asF;
    Address asG;
    String[] asH;
    UserAddress asI;
    UserAddress asJ;
    InstrumentInfo[] asK;
    LoyaltyWalletObject[] atm;
    OfferWalletObject[] atn;

    private MaskedWallet() {
        this.field_4428 = 2;
    }

    MaskedWallet(int var1, String var2, String var3, String[] var4, String var5, Address var6, Address var7, LoyaltyWalletObject[] var8, OfferWalletObject[] var9, UserAddress var10, UserAddress var11, InstrumentInfo[] var12) {
        this.field_4428 = var1;
        this.asB = var2;
        this.asC = var3;
        this.asH = var4;
        this.asE = var5;
        this.asF = var6;
        this.asG = var7;
        this.atm = var8;
        this.atn = var9;
        this.asI = var10;
        this.asJ = var11;
        this.asK = var12;
    }

    public static MaskedWallet.Builder newBuilderFrom(MaskedWallet var0) {
        class_1090.method_5685(var0);
        return method_4987().setGoogleTransactionId(var0.getGoogleTransactionId()).setMerchantTransactionId(var0.getMerchantTransactionId()).setPaymentDescriptions(var0.getPaymentDescriptions()).setInstrumentInfos(var0.getInstrumentInfos()).setEmail(var0.getEmail()).setLoyaltyWalletObjects(var0.getLoyaltyWalletObjects()).setOfferWalletObjects(var0.getOfferWalletObjects()).setBuyerBillingAddress(var0.getBuyerBillingAddress()).setBuyerShippingAddress(var0.getBuyerShippingAddress());
    }

    // $FF: renamed from: pM () com.google.android.gms.wallet.MaskedWallet$Builder
    public static MaskedWallet.Builder method_4987() {
        MaskedWallet var0 = new MaskedWallet();
        return var0.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.asF;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.asI;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.asJ;
    }

    public String getEmail() {
        return this.asE;
    }

    public String getGoogleTransactionId() {
        return this.asB;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.asK;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.atm;
    }

    public String getMerchantTransactionId() {
        return this.asC;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.atn;
    }

    public String[] getPaymentDescriptions() {
        return this.asH;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.asG;
    }

    public int getVersionCode() {
        return this.field_4428;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1023.method_5341(this, var1, var2);
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
            MaskedWallet.this.asF = var1;
            return this;
        }

        public MaskedWallet.Builder setBuyerBillingAddress(UserAddress var1) {
            MaskedWallet.this.asI = var1;
            return this;
        }

        public MaskedWallet.Builder setBuyerShippingAddress(UserAddress var1) {
            MaskedWallet.this.asJ = var1;
            return this;
        }

        public MaskedWallet.Builder setEmail(String var1) {
            MaskedWallet.this.asE = var1;
            return this;
        }

        public MaskedWallet.Builder setGoogleTransactionId(String var1) {
            MaskedWallet.this.asB = var1;
            return this;
        }

        public MaskedWallet.Builder setInstrumentInfos(InstrumentInfo[] var1) {
            MaskedWallet.this.asK = var1;
            return this;
        }

        public MaskedWallet.Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] var1) {
            MaskedWallet.this.atm = var1;
            return this;
        }

        public MaskedWallet.Builder setMerchantTransactionId(String var1) {
            MaskedWallet.this.asC = var1;
            return this;
        }

        public MaskedWallet.Builder setOfferWalletObjects(OfferWalletObject[] var1) {
            MaskedWallet.this.atn = var1;
            return this;
        }

        public MaskedWallet.Builder setPaymentDescriptions(String[] var1) {
            MaskedWallet.this.asH = var1;
            return this;
        }

        public MaskedWallet.Builder setShippingAddress(Address var1) {
            MaskedWallet.this.asG = var1;
            return this;
        }
    }
}
