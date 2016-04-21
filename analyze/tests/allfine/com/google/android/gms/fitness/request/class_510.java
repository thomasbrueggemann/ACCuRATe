package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.class_511;
import com.google.android.gms.fitness.request.j;

// $FF: renamed from: com.google.android.gms.fitness.request.j
public class class_510 implements SafeParcelable {
    public static final Creator<j> CREATOR = new class_511();
    // $FF: renamed from: BR int
    private final int field_2205;
    private final String mName;

    class_510(int var1, String var2) {
        this.field_2205 = var1;
        this.mName = var2;
    }

    public class_510(String var1) {
        this.field_2205 = 1;
        this.mName = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.j) boolean
    private boolean method_3120(class_510 var1) {
        return class_1089.equal(this.mName, var1.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof class_510 && this.method_3120((class_510)var1);
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.field_2205;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.mName};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("name", this.mName).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_511.method_3122(this, var1, var2);
    }
}
