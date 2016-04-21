package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.ProxyCard;
import com.google.android.gms.wallet.class_1018;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR = new class_1018();
    // $FF: renamed from: BR int
    private final int field_4111;
    String asB;
    String asC;
    ProxyCard asD;
    String asE;
    Address asF;
    Address asG;
    String[] asH;
    UserAddress asI;
    UserAddress asJ;
    InstrumentInfo[] asK;

    private FullWallet() {
        this.field_4111 = 1;
    }

    FullWallet(int var1, String var2, String var3, ProxyCard var4, String var5, Address var6, Address var7, String[] var8, UserAddress var9, UserAddress var10, InstrumentInfo[] var11) {
        this.field_4111 = var1;
        this.asB = var2;
        this.asC = var3;
        this.asD = var4;
        this.asE = var5;
        this.asF = var6;
        this.asG = var7;
        this.asH = var8;
        this.asI = var9;
        this.asJ = var10;
        this.asK = var11;
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

    public String getMerchantTransactionId() {
        return this.asC;
    }

    public String[] getPaymentDescriptions() {
        return this.asH;
    }

    public ProxyCard getProxyCard() {
        return this.asD;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.asG;
    }

    public int getVersionCode() {
        return this.field_4111;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1018.method_5329(this, var1, var2);
    }
}
