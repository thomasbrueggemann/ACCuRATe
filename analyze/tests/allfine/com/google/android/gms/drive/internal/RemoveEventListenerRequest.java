package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1101;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR = new class_1101();
    // $FF: renamed from: BR int
    final int field_4424;
    // $FF: renamed from: MW com.google.android.gms.drive.DriveId
    final DriveId field_4425;
    // $FF: renamed from: Oa int
    final int field_4426;

    RemoveEventListenerRequest(int var1, DriveId var2, int var3) {
        this.field_4424 = var1;
        this.field_4425 = var2;
        this.field_4426 = var3;
    }

    public RemoveEventListenerRequest(DriveId var1, int var2) {
        this(1, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1101.method_5727(this, var1, var2);
    }
}
