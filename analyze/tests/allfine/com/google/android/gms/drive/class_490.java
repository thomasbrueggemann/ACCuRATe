package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.class_1090;

// $FF: renamed from: com.google.android.gms.drive.i
public abstract class class_490 implements Parcelable {
    // $FF: renamed from: NL boolean
    private transient volatile boolean field_1978 = false;

    // $FF: renamed from: I (android.os.Parcel, int) void
    protected abstract void method_2996(Parcel var1, int var2);

    // $FF: renamed from: hT () boolean
    public final boolean method_2997() {
        return this.field_1978;
    }

    public void writeToParcel(Parcel var1, int var2) {
        boolean var3;
        if(!this.method_2997()) {
            var3 = true;
        } else {
            var3 = false;
        }

        class_1090.method_5674(var3);
        this.field_1978 = true;
        this.method_2996(var1, var2);
    }
}
