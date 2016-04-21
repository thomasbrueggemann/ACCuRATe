package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1103;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Creator<OnSyncMoreResponse> CREATOR = new class_1103();
    // $FF: renamed from: BR int
    final int field_4995;
    // $FF: renamed from: Oz boolean
    final boolean field_4996;

    OnSyncMoreResponse(int var1, boolean var2) {
        this.field_4995 = var1;
        this.field_4996 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1103.method_5733(this, var1, var2);
    }
}
