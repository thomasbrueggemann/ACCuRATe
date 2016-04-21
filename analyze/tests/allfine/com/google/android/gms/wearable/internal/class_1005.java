package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ak;
import com.google.android.gms.wearable.internal.class_1006;
import com.google.android.gms.wearable.internal.v;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.v
public class class_1005 implements SafeParcelable {
    public static final Creator<v> CREATOR = new class_1006();
    public final List<ak> avz;
    public final int statusCode;
    public final int versionCode;

    class_1005(int var1, int var2, List<ak> var3) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avz = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1006.method_5240(this, var1, var2);
    }
}
