package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.class_1048;
import com.google.android.gms.wearable.internal.class_999;
import com.google.android.gms.wearable.internal.t;

// $FF: renamed from: com.google.android.gms.wearable.internal.t
public class class_1000 implements SafeParcelable {
    public static final Creator<t> CREATOR = new class_999();
    public final class_1048[] avy;
    public final int statusCode;
    public final int versionCode;

    class_1000(int var1, int var2, class_1048[] var3) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avy = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_999.method_5231(this, var1, var2);
    }
}
