package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1104;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR = new class_1104();
    // $FF: renamed from: BR int
    final int field_5323;
    // $FF: renamed from: MV int
    final int field_5324;
    // $FF: renamed from: Od com.google.android.gms.drive.DriveId
    final DriveId field_5325;
    // $FF: renamed from: Px int
    final int field_5326;

    OpenContentsRequest(int var1, DriveId var2, int var3, int var4) {
        this.field_5323 = var1;
        this.field_5325 = var2;
        this.field_5324 = var3;
        this.field_5326 = var4;
    }

    public OpenContentsRequest(DriveId var1, int var2, int var3) {
        this(1, var1, var2, var3);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1104.method_5736(this, var1, var2);
    }
}
