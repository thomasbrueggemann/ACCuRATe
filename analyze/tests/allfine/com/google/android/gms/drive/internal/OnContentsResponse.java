package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.class_1115;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR = new class_1115();
    // $FF: renamed from: BR int
    final int field_5147;
    // $FF: renamed from: Ox com.google.android.gms.drive.Contents
    final Contents field_5148;
    // $FF: renamed from: Po boolean
    final boolean field_5149;

    OnContentsResponse(int var1, Contents var2, boolean var3) {
        this.field_5147 = var1;
        this.field_5148 = var2;
        this.field_5149 = var3;
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: id () com.google.android.gms.drive.Contents
    public Contents method_5715() {
        return this.field_5148;
    }

    // $FF: renamed from: ie () boolean
    public boolean method_5716() {
        return this.field_5149;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1115.method_5769(this, var1, var2);
    }
}
