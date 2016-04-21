package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_919;
import com.google.android.gms.internal.op;

// $FF: renamed from: com.google.android.gms.internal.op
public final class class_920 implements SafeParcelable {
    public static final Creator<op> CREATOR = new class_919();
    // $FF: renamed from: BR int
    private final int field_4223;
    String[] atO;
    byte[][] atP;

    class_920() {
        this(1, new String[0], new byte[0][]);
    }

    class_920(int var1, String[] var2, byte[][] var3) {
        this.field_4223 = var1;
        this.atO = var2;
        this.atP = var3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.field_4223;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_919.method_4753(this, var1, var2);
    }
}
