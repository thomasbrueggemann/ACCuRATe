package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.class_513;
import com.google.android.gms.fitness.request.e;

// $FF: renamed from: com.google.android.gms.fitness.request.e
public class class_512 implements SafeParcelable {
    public static final Creator<e> CREATOR = new class_513();
    // $FF: renamed from: BR int
    private final int field_2206;
    // $FF: renamed from: Ts com.google.android.gms.fitness.data.DataSet
    private final DataSet field_2207;

    class_512(int var1, DataSet var2) {
        this.field_2206 = var1;
        this.field_2207 = var2;
    }

    private class_512(class_512.class_1351 var1) {
        this.field_2206 = 1;
        this.field_2207 = var1.field_2863;
    }

    // $FF: synthetic method
    class_512(class_512.class_1351 var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.e) boolean
    private boolean method_3126(class_512 var1) {
        return class_1089.equal(this.field_2207, var1.field_2207);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof class_512 && this.method_3126((class_512)var1);
    }

    int getVersionCode() {
        return this.field_2206;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_2207};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iW () com.google.android.gms.fitness.data.DataSet
    public DataSet method_3127() {
        return this.field_2207;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("dataSet", this.field_2207).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_513.method_3128(this, var1, var2);
    }

    public static class class_1351 {
        // $FF: renamed from: Ts com.google.android.gms.fitness.data.DataSet
        private DataSet field_2863;

        // $FF: renamed from: b (com.google.android.gms.fitness.data.DataSet) com.google.android.gms.fitness.request.e$a
        public class_512.class_1351 method_3263(DataSet var1) {
            this.field_2863 = var1;
            return this;
        }

        // $FF: renamed from: jj () com.google.android.gms.fitness.request.e
        public class_512 method_3264() {
            boolean var1 = true;
            boolean var2;
            if(this.field_2863 != null) {
                var2 = var1;
            } else {
                var2 = false;
            }

            class_1090.method_5676(var2, "Must set the data set");
            boolean var3;
            if(!this.field_2863.getDataPoints().isEmpty()) {
                var3 = var1;
            } else {
                var3 = false;
            }

            class_1090.method_5676(var3, "Cannot use an empty data set");
            if(this.field_2863.getDataSource().method_3090() == null) {
                var1 = false;
            }

            class_1090.method_5676(var1, "Must set the app package name for the data source");
            return new class_512(this);
        }
    }
}
