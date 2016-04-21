package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.b;
import com.google.android.gms.wallet.wobs.class_700;

// $FF: renamed from: com.google.android.gms.wallet.wobs.b
public final class class_701 implements SafeParcelable {
    public static final Creator<b> CREATOR = new class_700();
    // $FF: renamed from: BR int
    private final int field_3401;
    String label;
    String value;

    class_701() {
        this.field_3401 = 1;
    }

    class_701(int var1, String var2, String var3) {
        this.field_3401 = var1;
        this.label = var2;
        this.value = var3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_3401;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_700.method_3839(this, var1, var2);
    }
}
