package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.class_738;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new class_738();
    // $FF: renamed from: BR int
    final int field_5349;
    // $FF: renamed from: Dd java.lang.String
    private String field_5350;
    private MaskedWalletRequest atW;
    private MaskedWallet atX;
    private int auk;

    private WalletFragmentInitParams() {
        this.field_5349 = 1;
        this.auk = -1;
    }

    WalletFragmentInitParams(int var1, String var2, MaskedWalletRequest var3, int var4, MaskedWallet var5) {
        this.field_5349 = var1;
        this.field_5350 = var2;
        this.atW = var3;
        this.auk = var4;
        this.atX = var5;
    }

    public static WalletFragmentInitParams.Builder newBuilder() {
        WalletFragmentInitParams var0 = new WalletFragmentInitParams();
        return var0.new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.field_5350;
    }

    public MaskedWallet getMaskedWallet() {
        return this.atX;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.atW;
    }

    public int getMaskedWalletRequestCode() {
        return this.auk;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_738.method_3979(this, var1, var2);
    }

    public final class Builder {
        private Builder() {
        }

        // $FF: synthetic method
        Builder(Object var2) {
            this();
        }

        public WalletFragmentInitParams build() {
            boolean var1 = true;
            boolean var2;
            if((WalletFragmentInitParams.this.atX == null || WalletFragmentInitParams.this.atW != null) && (WalletFragmentInitParams.this.atX != null || WalletFragmentInitParams.this.atW == null)) {
                var2 = false;
            } else {
                var2 = var1;
            }

            class_1090.method_5676(var2, "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if(WalletFragmentInitParams.this.auk < 0) {
                var1 = false;
            }

            class_1090.method_5676(var1, "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public WalletFragmentInitParams.Builder setAccountName(String var1) {
            WalletFragmentInitParams.this.field_5350 = var1;
            return this;
        }

        public WalletFragmentInitParams.Builder setMaskedWallet(MaskedWallet var1) {
            WalletFragmentInitParams.this.atX = var1;
            return this;
        }

        public WalletFragmentInitParams.Builder setMaskedWalletRequest(MaskedWalletRequest var1) {
            WalletFragmentInitParams.this.atW = var1;
            return this;
        }

        public WalletFragmentInitParams.Builder setMaskedWalletRequestCode(int var1) {
            WalletFragmentInitParams.this.auk = var1;
            return this;
        }
    }
}
