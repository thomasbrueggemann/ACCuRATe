package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_1031;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR = new class_1031();
    // $FF: renamed from: BR int
    private final int field_5298;
    String atD;
    CommonWalletObject atE;
    // $FF: renamed from: fl java.lang.String
    String field_5299;

    OfferWalletObject() {
        this.field_5298 = 3;
    }

    OfferWalletObject(int var1, String var2, String var3, CommonWalletObject var4) {
        this.field_5298 = var1;
        this.atD = var3;
        if(var1 < 3) {
            this.atE = CommonWalletObject.method_5937().method_3182(var2).method_3183();
        } else {
            this.atE = var4;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.atE.getId();
    }

    public String getRedemptionCode() {
        return this.atD;
    }

    public int getVersionCode() {
        return this.field_5298;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1031.method_5367(this, var1, var2);
    }
}
