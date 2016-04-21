package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_268;
import com.google.android.gms.internal.class_359;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.jd;

// $FF: renamed from: com.google.android.gms.internal.jd
public class class_361 implements SafeParcelable {
    public static final class_360 CREATOR = new class_360();
    // $FF: renamed from: BR int
    private final int field_1323;
    // $FF: renamed from: Ms com.google.android.gms.internal.jf
    private final class_359 field_1324;

    class_361(int var1, class_359 var2) {
        this.field_1323 = var1;
        this.field_1324 = var2;
    }

    private class_361(class_359 var1) {
        this.field_1323 = 1;
        this.field_1324 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ji$b) com.google.android.gms.internal.jd
    public static jd method_2387(class_268.class_1300<?, ?> var0) {
        if(var0 instanceof class_359) {
            return new class_361((class_359)var0);
        } else {
            throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        }
    }

    public int describeContents() {
        class_360 var10000 = CREATOR;
        return 0;
    }

    int getVersionCode() {
        return this.field_1323;
    }

    // $FF: renamed from: ha () com.google.android.gms.internal.jf
    class_359 method_2388() {
        return this.field_1324;
    }

    // $FF: renamed from: hb () com.google.android.gms.internal.ji$b
    public class_268.class_1300<?, ?> method_2389() {
        if(this.field_1324 != null) {
            return this.field_1324;
        } else {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_360 var10000 = CREATOR;
        class_360.method_2384(this, var1, var2);
    }
}
