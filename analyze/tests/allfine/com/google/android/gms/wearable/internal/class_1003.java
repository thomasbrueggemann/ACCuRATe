package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_1004;
import com.google.android.gms.wearable.internal.class_993;
import com.google.android.gms.wearable.internal.x;

// $FF: renamed from: com.google.android.gms.wearable.internal.x
public class class_1003 implements SafeParcelable {
    public static final Creator<x> CREATOR = new class_1004();
    public final class_993 avA;
    public final int statusCode;
    public final int versionCode;

    class_1003(int var1, int var2, class_993 var3) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avA = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1004.method_5237(this, var1, var2);
    }
}
