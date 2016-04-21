package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_286;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR = new class_286();
    // $FF: renamed from: BR int
    final int field_4023;
    // $FF: renamed from: Ol com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_4024;
    // $FF: renamed from: On com.google.android.gms.drive.DriveId
    final DriveId field_4025;

    CreateFolderRequest(int var1, DriveId var2, MetadataBundle var3) {
        this.field_4023 = var1;
        this.field_4025 = (DriveId)class_1090.method_5685(var2);
        this.field_4024 = (MetadataBundle)class_1090.method_5685(var3);
    }

    public CreateFolderRequest(DriveId var1, MetadataBundle var2) {
        this(1, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_286.method_1780(this, var1, var2);
    }
}
