package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.StorageStats;
import com.google.android.gms.drive.internal.class_1106;

public class OnStorageStatsResponse implements SafeParcelable {
    public static final Creator<OnStorageStatsResponse> CREATOR = new class_1106();
    // $FF: renamed from: BR int
    final int field_5318;
    // $FF: renamed from: Pw com.google.android.gms.drive.StorageStats
    StorageStats field_5319;

    OnStorageStatsResponse(int var1, StorageStats var2) {
        this.field_5318 = var1;
        this.field_5319 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1106.method_5742(this, var1, var2);
    }
}
