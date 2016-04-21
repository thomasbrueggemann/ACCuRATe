package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1120;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR = new class_1120();
    // $FF: renamed from: BR int
    final int field_5223;
    // $FF: renamed from: Od com.google.android.gms.drive.DriveId
    final DriveId field_5224;

    TrashResourceRequest(int var1, DriveId var2) {
        this.field_5223 = var1;
        this.field_5224 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1120.method_5786(this, var1, var2);
    }
}
