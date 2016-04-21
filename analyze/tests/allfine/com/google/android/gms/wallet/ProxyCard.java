package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_1032;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new class_1032();
    // $FF: renamed from: BR int
    private final int field_3437;
    String atF;
    String atG;
    int atH;
    int atI;

    ProxyCard(int var1, String var2, String var3, int var4, int var5) {
        this.field_3437 = var1;
        this.atF = var2;
        this.atG = var3;
        this.atH = var4;
        this.atI = var5;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.atG;
    }

    public int getExpirationMonth() {
        return this.atH;
    }

    public int getExpirationYear() {
        return this.atI;
    }

    public String getPan() {
        return this.atF;
    }

    public int getVersionCode() {
        return this.field_3437;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1032.method_5370(this, var1, var2);
    }
}
