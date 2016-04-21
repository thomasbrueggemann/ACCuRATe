package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.class_284;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<CreateFileIntentSenderRequest> CREATOR = new class_284();
    // $FF: renamed from: BR int
    final int field_4518;
    // $FF: renamed from: Nw java.lang.String
    final String field_4519;
    // $FF: renamed from: Ny com.google.android.gms.drive.DriveId
    final DriveId field_4520;
    // $FF: renamed from: Ol com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_4521;
    // $FF: renamed from: Om java.lang.Integer
    final Integer field_4522;
    // $FF: renamed from: uQ int
    final int field_4523;

    CreateFileIntentSenderRequest(int var1, MetadataBundle var2, int var3, String var4, DriveId var5, Integer var6) {
        this.field_4518 = var1;
        this.field_4521 = var2;
        this.field_4523 = var3;
        this.field_4519 = var4;
        this.field_4520 = var5;
        this.field_4522 = var6;
    }

    public CreateFileIntentSenderRequest(MetadataBundle var1, int var2, String var3, DriveId var4, int var5) {
        this(1, var1, var2, var3, var4, Integer.valueOf(var5));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_284.method_1774(this, var1, var2);
    }
}
