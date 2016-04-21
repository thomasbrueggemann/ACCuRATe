package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_288;

public class DeleteResourceRequest implements SafeParcelable {
    public static final Creator<DeleteResourceRequest> CREATOR = new class_288();
    // $FF: renamed from: BR int
    final int field_4779;
    // $FF: renamed from: Od com.google.android.gms.drive.DriveId
    final DriveId field_4780;

    DeleteResourceRequest(int var1, DriveId var2) {
        this.field_4779 = var1;
        this.field_4780 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_288.method_1787(this, var1, var2);
    }
}
