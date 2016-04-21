package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.class_1048;
import com.google.android.gms.wearable.internal.class_1001;
import com.google.android.gms.wearable.internal.r;

// $FF: renamed from: com.google.android.gms.wearable.internal.r
@Deprecated
public class class_1002 implements SafeParcelable {
    public static final Creator<r> CREATOR = new class_1001();
    public final class_1048 avx;
    public final int statusCode;
    public final int versionCode;

    class_1002(int var1, int var2, class_1048 var3) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avx = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1001.method_5234(this, var1, var2);
    }
}
