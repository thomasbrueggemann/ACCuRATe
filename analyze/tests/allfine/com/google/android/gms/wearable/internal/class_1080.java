package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ab;
import com.google.android.gms.wearable.internal.class_1072;
import com.google.android.gms.wearable.internal.class_1085;

// $FF: renamed from: com.google.android.gms.wearable.internal.ab
public class class_1080 implements SafeParcelable {
    public static final Creator<ab> CREATOR = new class_1085();
    public final class_1072 avC;
    public final int statusCode;
    public final int versionCode;

    class_1080(int var1, int var2, class_1072 var3) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avC = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1085.method_5614(this, var1, var2);
    }
}
