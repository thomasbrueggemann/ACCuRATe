package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_535;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.x
@ez
public final class class_536 implements SafeParcelable {
    public static final class_535 CREATOR = new class_535();
    // $FF: renamed from: lX boolean
    public final boolean field_2873;
    // $FF: renamed from: mh boolean
    public final boolean field_2874;
    public final int versionCode;

    class_536(int var1, boolean var2, boolean var3) {
        this.versionCode = var1;
        this.field_2873 = var2;
        this.field_2874 = var3;
    }

    public class_536(boolean var1, boolean var2) {
        this.versionCode = 1;
        this.field_2873 = var1;
        this.field_2874 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_535.method_3271(this, var1, var2);
    }
}
