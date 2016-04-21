package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_728;

public class DrivePreferences implements SafeParcelable {
    public static final Creator<DrivePreferences> CREATOR = new class_728();
    // $FF: renamed from: BR int
    final int field_4686;
    // $FF: renamed from: Nm boolean
    final boolean field_4687;

    DrivePreferences(int var1, boolean var2) {
        this.field_4686 = var1;
        this.field_4687 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_728.method_3957(this, var1, var2);
    }
}
