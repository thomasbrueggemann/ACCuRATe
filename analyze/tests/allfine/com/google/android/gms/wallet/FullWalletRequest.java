package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.class_1019;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR = new class_1019();
    // $FF: renamed from: BR int
    private final int field_3487;
    String asB;
    String asC;
    Cart asL;

    FullWalletRequest() {
        this.field_3487 = 1;
    }

    FullWalletRequest(int var1, String var2, String var3, Cart var4) {
        this.field_3487 = var1;
        this.asB = var2;
        this.asC = var3;
        this.asL = var4;
    }

    public static FullWalletRequest.Builder newBuilder() {
        FullWalletRequest var0 = new FullWalletRequest();
        return var0.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.asL;
    }

    public String getGoogleTransactionId() {
        return this.asB;
    }

    public String getMerchantTransactionId() {
        return this.asC;
    }

    public int getVersionCode() {
        return this.field_3487;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1019.method_5332(this, var1, var2);
    }

    public final class Builder {
        private Builder() {
        }

        // $FF: synthetic method
        Builder(Object var2) {
            this();
        }

        public FullWalletRequest build() {
            return FullWalletRequest.this;
        }

        public FullWalletRequest.Builder setCart(Cart var1) {
            FullWalletRequest.this.asL = var1;
            return this;
        }

        public FullWalletRequest.Builder setGoogleTransactionId(String var1) {
            FullWalletRequest.this.asB = var1;
            return this;
        }

        public FullWalletRequest.Builder setMerchantTransactionId(String var1) {
            FullWalletRequest.this.asC = var1;
            return this;
        }
    }
}
