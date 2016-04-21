package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ao;
import com.google.android.gms.wearable.internal.class_1067;
import com.google.android.gms.wearable.internal.class_993;

// $FF: renamed from: com.google.android.gms.wearable.internal.ao
public class class_1068 implements SafeParcelable {
    public static final Creator<ao> CREATOR = new class_1067();
    public final class_993 avA;
    public final int statusCode;
    public final int versionCode;

    class_1068(int var1, int var2, class_993 var3) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avA = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1067.method_5585(this, var1, var2);
    }
}
