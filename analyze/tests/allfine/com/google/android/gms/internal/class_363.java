package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_362;

// $FF: renamed from: com.google.android.gms.internal.jb
public class class_363 implements SafeParcelable {
    public static final class_362 CREATOR = new class_362();
    // $FF: renamed from: BR int
    final int field_1325;
    // $FF: renamed from: Mq java.lang.String
    public final String field_1326;
    // $FF: renamed from: Mr int
    public final int field_1327;

    public class_363(int var1, String var2, int var3) {
        this.field_1325 = var1;
        this.field_1326 = var2;
        this.field_1327 = var3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_362.method_2390(this, var1, var2);
    }
}
