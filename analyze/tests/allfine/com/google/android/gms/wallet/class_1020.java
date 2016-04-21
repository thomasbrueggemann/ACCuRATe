package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.class_1021;
import com.google.android.gms.wallet.d;

// $FF: renamed from: com.google.android.gms.wallet.d
public final class class_1020 implements SafeParcelable {
    public static final Creator<d> CREATOR = new class_1021();
    // $FF: renamed from: BR int
    private final int field_4720;
    OfferWalletObject asA;
    LoyaltyWalletObject asz;

    class_1020() {
        this.field_4720 = 2;
    }

    class_1020(int var1, LoyaltyWalletObject var2, OfferWalletObject var3) {
        this.field_4720 = var1;
        this.asz = var2;
        this.asA = var3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_4720;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1021.method_5335(this, var1, var2);
    }
}
