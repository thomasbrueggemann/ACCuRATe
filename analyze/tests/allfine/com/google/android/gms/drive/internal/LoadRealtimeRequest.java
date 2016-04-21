package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1116;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new class_1116();
    // $FF: renamed from: BR int
    final int field_4488;
    // $FF: renamed from: MW com.google.android.gms.drive.DriveId
    final DriveId field_4489;
    // $FF: renamed from: Pk boolean
    final boolean field_4490;

    LoadRealtimeRequest(int var1, DriveId var2, boolean var3) {
        this.field_4488 = var1;
        this.field_4489 = var2;
        this.field_4490 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1116.method_5772(this, var1, var2);
    }
}
