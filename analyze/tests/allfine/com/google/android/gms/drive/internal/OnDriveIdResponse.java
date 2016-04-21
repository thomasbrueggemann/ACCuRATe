package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1113;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new class_1113();
    // $FF: renamed from: BR int
    final int field_3883;
    // $FF: renamed from: Od com.google.android.gms.drive.DriveId
    DriveId field_3884;

    OnDriveIdResponse(int var1, DriveId var2) {
        this.field_3883 = var1;
        this.field_3884 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.field_3884;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1113.method_5763(this, var1, var2);
    }
}
