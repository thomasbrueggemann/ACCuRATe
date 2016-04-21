package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.class_281;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR = new class_281();
    // $FF: renamed from: BR int
    final int field_4694;
    // $FF: renamed from: Of com.google.android.gms.drive.Contents
    final Contents field_4695;
    // $FF: renamed from: Oh java.lang.Boolean
    final Boolean field_4696;

    CloseContentsRequest(int var1, Contents var2, Boolean var3) {
        this.field_4694 = var1;
        this.field_4695 = var2;
        this.field_4696 = var3;
    }

    public CloseContentsRequest(Contents var1, boolean var2) {
        this(1, var1, Boolean.valueOf(var2));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_281.method_1764(this, var1, var2);
    }
}
