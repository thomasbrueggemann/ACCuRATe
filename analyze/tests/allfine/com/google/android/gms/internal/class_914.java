package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_921;
import com.google.android.gms.internal.on;

// $FF: renamed from: com.google.android.gms.internal.on
public final class class_914 implements SafeParcelable {
    public static final Creator<on> CREATOR = new class_921();
    // $FF: renamed from: BR int
    private final int field_4219;
    int[] atN;

    class_914() {
        this(1, (int[])null);
    }

    class_914(int var1, int[] var2) {
        this.field_4219 = var1;
        this.atN = var2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_4219;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_921.method_4756(this, var1, var2);
    }
}
