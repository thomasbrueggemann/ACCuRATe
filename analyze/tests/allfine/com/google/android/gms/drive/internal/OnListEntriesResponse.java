package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_490;
import com.google.android.gms.drive.internal.class_1109;

public class OnListEntriesResponse extends class_490 implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR = new class_1109();
    // $FF: renamed from: BR int
    final int field_1981;
    // $FF: renamed from: Oz boolean
    final boolean field_1982;
    // $FF: renamed from: Pu com.google.android.gms.common.data.DataHolder
    final DataHolder field_1983;

    OnListEntriesResponse(int var1, DataHolder var2, boolean var3) {
        this.field_1981 = var1;
        this.field_1983 = var2;
        this.field_1982 = var3;
    }

    // $FF: renamed from: I (android.os.Parcel, int) void
    protected void method_2996(Parcel var1, int var2) {
        class_1109.method_5751(this, var1, var2);
    }

    public int describeContents() {
        return 0;
    }

    // $FF: renamed from: ii () com.google.android.gms.common.data.DataHolder
    public DataHolder method_2999() {
        return this.field_1983;
    }

    // $FF: renamed from: ij () boolean
    public boolean method_3000() {
        return this.field_1982;
    }
}
