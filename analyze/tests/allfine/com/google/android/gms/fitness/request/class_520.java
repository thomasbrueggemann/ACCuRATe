package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.class_519;
import com.google.android.gms.fitness.request.y;

// $FF: renamed from: com.google.android.gms.fitness.request.y
public class class_520 implements SafeParcelable {
    public static final Creator<y> CREATOR = new class_519();
    // $FF: renamed from: BR int
    private final int field_2214;
    // $FF: renamed from: Tq java.lang.String
    private final String field_2215;
    private final String mName;

    class_520(int var1, String var2, String var3) {
        this.field_2214 = var1;
        this.mName = var2;
        this.field_2215 = var3;
    }

    private class_520(class_520.class_1566 var1) {
        this.field_2214 = 1;
        this.mName = var1.mName;
        this.field_2215 = var1.field_4750;
    }

    // $FF: synthetic method
    class_520(class_520.class_1566 var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.y) boolean
    private boolean method_3156(class_520 var1) {
        return class_1089.equal(this.mName, var1.mName) && class_1089.equal(this.field_2215, var1.field_2215);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof class_520 && this.method_3156((class_520)var1);
    }

    public String getIdentifier() {
        return this.field_2215;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.field_2214;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.mName, this.field_2215};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("name", this.mName).method_5425("identifier", this.field_2215).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_519.method_3153(this, var1, var2);
    }

    public static class class_1566 {
        // $FF: renamed from: Tq java.lang.String
        private String field_4750;
        private String mName;

        // $FF: renamed from: bu (java.lang.String) com.google.android.gms.fitness.request.y$a
        public class_520.class_1566 method_5421(String var1) {
            this.mName = var1;
            return this;
        }

        // $FF: renamed from: bv (java.lang.String) com.google.android.gms.fitness.request.y$a
        public class_520.class_1566 method_5422(String var1) {
            this.field_4750 = var1;
            return this;
        }

        // $FF: renamed from: jB () com.google.android.gms.fitness.request.y
        public class_520 method_5423() {
            return new class_520(this);
        }
    }
}
