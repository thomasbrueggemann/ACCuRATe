package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;
import com.google.android.gms.drive.internal.class_1112;

public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Creator<OnDrivePreferencesResponse> CREATOR = new class_1112();
    // $FF: renamed from: BR int
    final int field_4036;
    // $FF: renamed from: Pr com.google.android.gms.drive.DrivePreferences
    DrivePreferences field_4037;

    OnDrivePreferencesResponse(int var1, DrivePreferences var2) {
        this.field_4036 = var1;
        this.field_4037 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1112.method_5760(this, var1, var2);
    }
}
