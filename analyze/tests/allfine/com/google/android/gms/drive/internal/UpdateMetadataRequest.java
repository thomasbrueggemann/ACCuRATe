package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_1119;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
    public static final Creator<UpdateMetadataRequest> CREATOR = new class_1119();
    // $FF: renamed from: BR int
    final int field_5017;
    // $FF: renamed from: Od com.google.android.gms.drive.DriveId
    final DriveId field_5018;
    // $FF: renamed from: Oe com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_5019;

    UpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3) {
        this.field_5017 = var1;
        this.field_5018 = var2;
        this.field_5019 = var3;
    }

    public UpdateMetadataRequest(DriveId var1, MetadataBundle var2) {
        this(1, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1119.method_5783(this, var1, var2);
    }
}
