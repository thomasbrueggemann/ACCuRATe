package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.class_996;
import com.google.android.gms.wearable.internal.p;

// $FF: renamed from: com.google.android.gms.wearable.internal.p
public class class_997 implements SafeParcelable {
    public static final Creator<p> CREATOR = new class_996();
    public final int avw;
    public final int statusCode;
    public final int versionCode;

    class_997(int var1, int var2, int var3) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avw = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_996.method_5225(this, var1, var2);
    }
}
