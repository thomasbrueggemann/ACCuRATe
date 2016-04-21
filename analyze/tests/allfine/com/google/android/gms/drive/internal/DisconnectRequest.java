package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_289;

public class DisconnectRequest implements SafeParcelable {
    public static final Creator<DisconnectRequest> CREATOR = new class_289();
    // $FF: renamed from: BR int
    final int field_5230;

    public DisconnectRequest() {
        this(1);
    }

    DisconnectRequest(int var1) {
        this.field_5230 = var1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_289.method_1790(this, var1, var2);
    }
}
