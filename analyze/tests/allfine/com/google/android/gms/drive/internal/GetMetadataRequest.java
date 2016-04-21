package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1118;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR = new class_1118();
    // $FF: renamed from: BR int
    final int field_5300;
    // $FF: renamed from: Od com.google.android.gms.drive.DriveId
    final DriveId field_5301;

    GetMetadataRequest(int var1, DriveId var2) {
        this.field_5300 = var1;
        this.field_5301 = var2;
    }

    public GetMetadataRequest(DriveId var1) {
        this(1, var1);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1118.method_5778(this, var1, var2);
    }
}
