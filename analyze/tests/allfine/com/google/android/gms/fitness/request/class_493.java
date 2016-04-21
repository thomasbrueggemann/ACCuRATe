package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.aj;
import com.google.android.gms.fitness.request.class_494;

// $FF: renamed from: com.google.android.gms.fitness.request.aj
public class class_493 implements SafeParcelable {
    public static final Creator<aj> CREATOR = new class_494();
    // $FF: renamed from: BR int
    private final int field_2131;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_2132;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_2133;

    class_493(int var1, DataType var2, DataSource var3) {
        this.field_2131 = var1;
        this.field_2132 = var2;
        this.field_2133 = var3;
    }

    private class_493(class_493.class_1615 var1) {
        this.field_2131 = 1;
        this.field_2132 = var1.field_3887;
        this.field_2133 = var1.field_3888;
    }

    // $FF: synthetic method
    class_493(class_493.class_1615 var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.aj) boolean
    private boolean method_3037(class_493 var1) {
        return class_1089.equal(this.field_2133, var1.field_2133) && class_1089.equal(this.field_2132, var1.field_2132);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof class_493 && this.method_3037((class_493)var1);
    }

    public DataSource getDataSource() {
        return this.field_2133;
    }

    public DataType getDataType() {
        return this.field_2132;
    }

    int getVersionCode() {
        return this.field_2131;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_2133, this.field_2132};
        return class_1089.hashCode(var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_494.method_3038(this, var1, var2);
    }

    public static class class_1615 {
        // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
        private DataType field_3887;
        // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
        private DataSource field_3888;

        // $FF: renamed from: d (com.google.android.gms.fitness.data.DataSource) com.google.android.gms.fitness.request.aj$a
        public class_493.class_1615 method_4216(DataSource var1) {
            this.field_3888 = var1;
            return this;
        }

        // $FF: renamed from: d (com.google.android.gms.fitness.data.DataType) com.google.android.gms.fitness.request.aj$a
        public class_493.class_1615 method_4217(DataType var1) {
            this.field_3887 = var1;
            return this;
        }

        // $FF: renamed from: jG () com.google.android.gms.fitness.request.aj
        public class_493 method_4218() {
            if(this.field_3887 != null && this.field_3888 != null) {
                throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
            } else {
                return new class_493(this);
            }
        }
    }
}
