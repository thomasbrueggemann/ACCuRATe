package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.am;
import com.google.android.gms.wearable.internal.class_1073;

// $FF: renamed from: com.google.android.gms.wearable.internal.am
public class class_1074 implements SafeParcelable {
    public static final Creator<am> CREATOR = new class_1073();
    public final long avN;
    public final String label;
    public final String packageName;
    public final int versionCode;

    class_1074(int var1, String var2, String var3, long var4) {
        this.versionCode = var1;
        this.packageName = var2;
        this.label = var3;
        this.avN = var4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1073.method_5595(this, var1, var2);
    }
}
