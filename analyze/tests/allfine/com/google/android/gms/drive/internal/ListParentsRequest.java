package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1117;

public class ListParentsRequest implements SafeParcelable {
    public static final Creator<ListParentsRequest> CREATOR = new class_1117();
    // $FF: renamed from: BR int
    final int field_2853;
    // $FF: renamed from: Pj com.google.android.gms.drive.DriveId
    final DriveId field_2854;

    ListParentsRequest(int var1, DriveId var2) {
        this.field_2853 = var1;
        this.field_2854 = var2;
    }

    public ListParentsRequest(DriveId var1) {
        this(1, var1);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1117.method_5775(this, var1, var2);
    }
}
