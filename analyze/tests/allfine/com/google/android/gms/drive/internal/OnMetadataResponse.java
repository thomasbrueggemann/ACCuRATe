package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1107;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR = new class_1107();
    // $FF: renamed from: BR int
    final int field_5366;
    // $FF: renamed from: Ol com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_5367;

    OnMetadataResponse(int var1, MetadataBundle var2) {
        this.field_5366 = var1;
        this.field_5367 = var2;
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: il () com.google.android.gms.drive.metadata.internal.MetadataBundle
    public MetadataBundle method_6021() {
        return this.field_5367;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1107.method_5745(this, var1, var2);
    }
}
