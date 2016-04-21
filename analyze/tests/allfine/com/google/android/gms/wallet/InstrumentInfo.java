package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.class_1024;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR = new class_1024();
    // $FF: renamed from: BR int
    private final int field_4332;
    private String asN;
    private String asO;

    InstrumentInfo(int var1, String var2, String var3) {
        this.field_4332 = var1;
        this.asN = var2;
        this.asO = var3;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.asO;
    }

    public String getInstrumentType() {
        return this.asN;
    }

    public int getVersionCode() {
        return this.field_4332;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1024.method_5344(this, var1, var2);
    }
}
