package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.internal.class_1099;

public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Creator<SetDrivePreferencesRequest> CREATOR = new class_1099();
    // $FF: renamed from: BR int
    final int field_2070;
    // $FF: renamed from: Pr com.google.android.gms.drive.DrivePreferences
    final DrivePreferences field_2071;

    SetDrivePreferencesRequest(int var1, DrivePreferences var2) {
        this.field_2070 = var1;
        this.field_2071 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1099.method_5721(this, var1, var2);
    }
}
