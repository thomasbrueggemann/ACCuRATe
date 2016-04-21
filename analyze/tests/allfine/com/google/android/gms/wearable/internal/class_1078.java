package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.am;
import com.google.android.gms.wearable.internal.au;
import com.google.android.gms.wearable.internal.class_1077;
import java.util.List;

// $FF: renamed from: com.google.android.gms.wearable.internal.au
public class class_1078 implements SafeParcelable {
    public static final Creator<au> CREATOR = new class_1077();
    public final long avN;
    public final List<am> avP;
    public final int statusCode;
    public final int versionCode;

    class_1078(int var1, int var2, long var3, List<am> var5) {
        this.versionCode = var1;
        this.statusCode = var2;
        this.avN = var3;
        this.avP = var5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1077.method_5603(this, var1, var2);
    }
}
