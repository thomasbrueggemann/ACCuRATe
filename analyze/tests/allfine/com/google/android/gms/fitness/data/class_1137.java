package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1136;
import com.google.android.gms.fitness.data.q;

// $FF: renamed from: com.google.android.gms.fitness.data.q
public class class_1137 implements SafeParcelable {
    public static final Creator<q> CREATOR = new class_1136();
    // $FF: renamed from: BR int
    final int field_5244;
    // $FF: renamed from: St com.google.android.gms.fitness.data.Session
    private final Session field_5245;
    // $FF: renamed from: Ts com.google.android.gms.fitness.data.DataSet
    private final DataSet field_5246;

    class_1137(int var1, Session var2, DataSet var3) {
        this.field_5244 = var1;
        this.field_5245 = var2;
        this.field_5246 = var3;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.q) boolean
    private boolean method_5901(class_1137 var1) {
        return class_1089.equal(this.field_5245, var1.field_5245) && class_1089.equal(this.field_5246, var1.field_5246);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof class_1137 && this.method_5901((class_1137)var1);
    }

    public Session getSession() {
        return this.field_5245;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_5245, this.field_5246};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iW () com.google.android.gms.fitness.data.DataSet
    public DataSet method_5902() {
        return this.field_5246;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("session", this.field_5245).method_5425("dataSet", this.field_5246).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1136.method_5898(this, var1, var2);
    }
}
