package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.internal.class_280;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new class_280();
    // $FF: renamed from: BR int
    final int field_5255;
    // $FF: renamed from: Nn java.lang.String
    final String field_5256;
    // $FF: renamed from: No boolean
    final boolean field_5257;
    // $FF: renamed from: Od com.google.android.gms.drive.DriveId
    final DriveId field_5258;
    // $FF: renamed from: Oe com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_5259;
    // $FF: renamed from: Of com.google.android.gms.drive.Contents
    final Contents field_5260;
    // $FF: renamed from: Og int
    final int field_5261;

    CloseContentsAndUpdateMetadataRequest(int var1, DriveId var2, MetadataBundle var3, Contents var4, boolean var5, String var6, int var7) {
        this.field_5255 = var1;
        this.field_5258 = var2;
        this.field_5259 = var3;
        this.field_5260 = var4;
        this.field_5257 = var5;
        this.field_5256 = var6;
        this.field_5261 = var7;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId var1, MetadataBundle var2, Contents var3, ExecutionOptions var4) {
        this(1, var1, var2, var3, var4.method_4486(), var4.method_4485(), var4.method_4487());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_280.method_1761(this, var1, var2);
    }
}
