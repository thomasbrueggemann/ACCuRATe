package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_408;

// $FF: renamed from: com.google.android.gms.internal.hk
public class class_401 implements SafeParcelable {
    public static final class_408 CREATOR = new class_408();
    // $FF: renamed from: BR int
    final int field_1495;
    // $FF: renamed from: Ci android.os.Bundle
    final Bundle field_1496;
    // $FF: renamed from: id int
    public final int field_1497;

    class_401(int var1, int var2, Bundle var3) {
        this.field_1495 = var1;
        this.field_1497 = var2;
        this.field_1496 = var3;
    }

    public int describeContents() {
        class_408 var10000 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_408 var10000 = CREATOR;
        class_408.method_2645(this, var1, var2);
    }
}
