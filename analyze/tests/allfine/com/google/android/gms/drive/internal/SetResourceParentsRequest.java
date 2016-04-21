package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1121;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Creator<SetResourceParentsRequest> CREATOR = new class_1121();
    // $FF: renamed from: BR int
    final int field_4030;
    // $FF: renamed from: PA java.util.List
    final List<DriveId> field_4031;
    // $FF: renamed from: Pz com.google.android.gms.drive.DriveId
    final DriveId field_4032;

    SetResourceParentsRequest(int var1, DriveId var2, List<DriveId> var3) {
        this.field_4030 = var1;
        this.field_4032 = var2;
        this.field_4031 = var3;
    }

    public SetResourceParentsRequest(DriveId var1, List<DriveId> var2) {
        this(1, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1121.method_5792(this, var1, var2);
    }
}
