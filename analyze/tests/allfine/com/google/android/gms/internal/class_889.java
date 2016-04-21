package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_882;
import com.google.android.gms.internal.mt;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.mt
public final class class_889 implements SafeParcelable {
    public static final class_882 CREATOR;
    public static final class_889 aic = method_4572("test_type", 1);
    public static final class_889 aid = method_4572("trellis_store", 2);
    public static final class_889 aie = method_4572("labeled_place", 6);
    public static final Set<mt> aif;
    // $FF: renamed from: BR int
    final int field_4207;
    final int aig;
    // $FF: renamed from: uO java.lang.String
    final String field_4208;

    static {
        class_889[] var0 = new class_889[] {aic, aid, aie};
        aif = Collections.unmodifiableSet(new HashSet(Arrays.asList(var0)));
        CREATOR = new class_882();
    }

    class_889(int var1, String var2, int var3) {
        class_1090.method_5680(var2);
        this.field_4207 = var1;
        this.field_4208 = var2;
        this.aig = var3;
    }

    // $FF: renamed from: y (java.lang.String, int) com.google.android.gms.internal.mt
    private static class_889 method_4572(String var0, int var1) {
        return new class_889(0, var0, var1);
    }

    public int describeContents() {
        class_882 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof class_889)) {
                return false;
            }

            class_889 var2 = (class_889)var1;
            if(!this.field_4208.equals(var2.field_4208) || this.aig != var2.aig) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        return this.field_4208.hashCode();
    }

    public String toString() {
        return this.field_4208;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_882 var10000 = CREATOR;
        class_882.method_4555(this, var1, var2);
    }
}
