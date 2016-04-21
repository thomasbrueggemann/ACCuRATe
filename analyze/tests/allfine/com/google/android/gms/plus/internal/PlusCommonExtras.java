package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_822;
import com.google.android.gms.plus.internal.class_955;

public class PlusCommonExtras implements SafeParcelable {
    public static final class_955 CREATOR = new class_955();
    public static String TAG = "PlusCommonExtras";
    // $FF: renamed from: BR int
    private final int field_2050;
    private String alA;
    private String alB;

    public PlusCommonExtras() {
        this.field_2050 = 1;
        this.alA = "";
        this.alB = "";
    }

    PlusCommonExtras(int var1, String var2, String var3) {
        this.field_2050 = var1;
        this.alA = var2;
        this.alB = var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof PlusCommonExtras) {
            PlusCommonExtras var2 = (PlusCommonExtras)var1;
            if(this.field_2050 == var2.field_2050 && class_1089.equal(this.alA, var2.alA) && class_1089.equal(this.alB, var2.alB)) {
                return true;
            }
        }

        return false;
    }

    public int getVersionCode() {
        return this.field_2050;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_2050), this.alA, this.alB};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: ne () java.lang.String
    public String method_3002() {
        return this.alA;
    }

    // $FF: renamed from: nf () java.lang.String
    public String method_3003() {
        return this.alB;
    }

    // $FF: renamed from: o (android.os.Bundle) void
    public void method_3004(Bundle var1) {
        var1.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", class_822.method_4297(this));
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("versionCode", Integer.valueOf(this.field_2050)).method_5425("Gpsrc", this.alA).method_5425("ClientCallingPackage", this.alB).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_955.method_5040(this, var1, var2);
    }
}
