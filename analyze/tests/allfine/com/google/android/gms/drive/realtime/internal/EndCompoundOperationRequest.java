package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_819;

public class EndCompoundOperationRequest implements SafeParcelable {
    public static final Creator<EndCompoundOperationRequest> CREATOR = new class_819();
    // $FF: renamed from: BR int
    final int field_5202;

    public EndCompoundOperationRequest() {
        this(1);
    }

    EndCompoundOperationRequest(int var1) {
        this.field_5202 = var1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_819.method_4252(this, var1, var2);
    }
}
