package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_254;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR = new class_254();
    // $FF: renamed from: BR int
    final int field_4610;
    // $FF: renamed from: MW com.google.android.gms.drive.DriveId
    final DriveId field_4611;
    // $FF: renamed from: Oa int
    final int field_4612;

    AddEventListenerRequest(int var1, DriveId var2, int var3) {
        this.field_4610 = var1;
        this.field_4611 = var2;
        this.field_4612 = var3;
    }

    public AddEventListenerRequest(DriveId var1, int var2) {
        this(1, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_254.method_1639(this, var1, var2);
    }
}
