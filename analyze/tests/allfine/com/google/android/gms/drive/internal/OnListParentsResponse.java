package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_490;
import com.google.android.gms.drive.internal.class_1110;

public class OnListParentsResponse extends class_490 implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new class_1110();
    // $FF: renamed from: BR int
    final int field_1979;
    // $FF: renamed from: Pv com.google.android.gms.common.data.DataHolder
    final DataHolder field_1980;

    OnListParentsResponse(int var1, DataHolder var2) {
        this.field_1979 = var1;
        this.field_1980 = var2;
    }

    // $FF: renamed from: I (android.os.Parcel, int) void
    protected void method_2996(Parcel var1, int var2) {
        class_1110.method_5754(this, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: ik () com.google.android.gms.common.data.DataHolder
    public DataHolder method_2998() {
        return this.field_1980;
    }
}
