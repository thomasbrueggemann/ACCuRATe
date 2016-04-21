package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.class_818;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Creator<BeginCompoundOperationRequest> CREATOR = new class_818();
    // $FF: renamed from: BR int
    final int field_5047;
    // $FF: renamed from: Ri boolean
    final boolean field_5048;
    // $FF: renamed from: Rj boolean
    final boolean field_5049;
    final String mName;

    BeginCompoundOperationRequest(int var1, boolean var2, String var3, boolean var4) {
        this.field_5047 = var1;
        this.field_5048 = var2;
        this.mName = var3;
        this.field_5049 = var4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_818.method_4249(this, var1, var2);
    }
}
