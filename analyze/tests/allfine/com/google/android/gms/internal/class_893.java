package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_897;
import com.google.android.gms.internal.class_898;

// $FF: renamed from: com.google.android.gms.internal.mh
public final class class_893 implements SafeParcelable {
    public static final class_897 CREATOR = new class_897();
    // $FF: renamed from: BR int
    private final int field_4211;
    private final int aeh;
    private final int afp;
    private final class_898 afq;

    class_893(int var1, int var2, int var3, class_898 var4) {
        this.field_4211 = var1;
        this.aeh = var2;
        this.afp = var3;
        this.afq = var4;
    }

    public int describeContents() {
        class_897 var10000 = CREATOR;
        return 0;
    }

    public boolean equals(Object var1) {
        if(this != var1) {
            if(!(var1 instanceof class_893)) {
                return false;
            }

            class_893 var2 = (class_893)var1;
            if(this.aeh != var2.aeh || this.afp != var2.afp || !this.afq.equals(var2.afq)) {
                return false;
            }
        }

        return true;
    }

    public int getVersionCode() {
        return this.field_4211;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.aeh), Integer.valueOf(this.afp)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: mc () int
    public int method_4582() {
        return this.aeh;
    }

    // $FF: renamed from: mg () int
    public int method_4583() {
        return this.afp;
    }

    // $FF: renamed from: mh () com.google.android.gms.internal.mj
    public class_898 method_4584() {
        return this.afq;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("transitionTypes", Integer.valueOf(this.aeh)).method_5425("loiteringTimeMillis", Integer.valueOf(this.afp)).method_5425("placeFilter", this.afq).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_897 var10000 = CREATOR;
        class_897.method_4591(this, var1, var2);
    }
}
