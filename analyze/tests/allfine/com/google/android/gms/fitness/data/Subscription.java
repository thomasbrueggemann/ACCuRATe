package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.class_1135;

public class Subscription implements SafeParcelable {
    public static final Creator<Subscription> CREATOR = new class_1135();
    // $FF: renamed from: BR int
    private final int field_4326;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_4327;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_4328;
    // $FF: renamed from: Tt long
    private final long field_4329;
    // $FF: renamed from: Tu int
    private final int field_4330;

    Subscription(int var1, DataSource var2, DataType var3, long var4, int var6) {
        this.field_4326 = var1;
        this.field_4328 = var2;
        this.field_4327 = var3;
        this.field_4329 = var4;
        this.field_4330 = var6;
    }

    private Subscription(Subscription.class_1742 var1) {
        this.field_4326 = 1;
        this.field_4327 = var1.field_4581;
        this.field_4328 = var1.field_4582;
        this.field_4329 = var1.field_4583;
        this.field_4330 = var1.field_4584;
    }

    // $FF: synthetic method
    Subscription(Subscription.class_1742 var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.Subscription) boolean
    private boolean method_4910(Subscription var1) {
        return class_1089.equal(this.field_4328, var1.field_4328) && class_1089.equal(this.field_4327, var1.field_4327) && this.field_4329 == var1.field_4329 && this.field_4330 == var1.field_4330;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof Subscription && this.method_4910((Subscription)var1);
    }

    public int getAccuracyMode() {
        return this.field_4330;
    }

    public DataSource getDataSource() {
        return this.field_4328;
    }

    public DataType getDataType() {
        return this.field_4327;
    }

    int getVersionCode() {
        return this.field_4326;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_4328, this.field_4328, Long.valueOf(this.field_4329), Integer.valueOf(this.field_4330)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iX () long
    public long method_4911() {
        return this.field_4329;
    }

    // $FF: renamed from: iY () com.google.android.gms.fitness.data.DataType
    public DataType method_4912() {
        return this.field_4327 == null?this.field_4328.getDataType():this.field_4327;
    }

    public String toDebugString() {
        Object[] var1 = new Object[1];
        String var2;
        if(this.field_4328 == null) {
            var2 = this.field_4327.getName();
        } else {
            var2 = this.field_4328.toDebugString();
        }

        var1[0] = var2;
        return String.format("Subscription{%s}", var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("dataSource", this.field_4328).method_5425("dataType", this.field_4327).method_5425("samplingIntervalMicros", Long.valueOf(this.field_4329)).method_5425("accuracyMode", Integer.valueOf(this.field_4330)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1135.method_5895(this, var1, var2);
    }

    public static class class_1742 {
        // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
        private DataType field_4581;
        // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
        private DataSource field_4582;
        // $FF: renamed from: Tt long
        private long field_4583 = -1L;
        // $FF: renamed from: Tu int
        private int field_4584 = 2;

        // $FF: renamed from: b (com.google.android.gms.fitness.data.DataSource) com.google.android.gms.fitness.data.Subscription$a
        public Subscription.class_1742 method_5222(DataSource var1) {
            this.field_4582 = var1;
            return this;
        }

        // $FF: renamed from: b (com.google.android.gms.fitness.data.DataType) com.google.android.gms.fitness.data.Subscription$a
        public Subscription.class_1742 method_5223(DataType var1) {
            this.field_4581 = var1;
            return this;
        }

        // $FF: renamed from: iZ () com.google.android.gms.fitness.data.Subscription
        public Subscription method_5224() {
            boolean var1;
            if(this.field_4582 == null && this.field_4581 == null) {
                var1 = false;
            } else {
                var1 = true;
            }

            boolean var2;
            label17: {
                class_1090.method_5676(var1, "Must call setDataSource() or setDataType()");
                if(this.field_4581 != null && this.field_4582 != null) {
                    boolean var3 = this.field_4581.equals(this.field_4582.getDataType());
                    var2 = false;
                    if(!var3) {
                        break label17;
                    }
                }

                var2 = true;
            }

            class_1090.method_5676(var2, "Specified data type is incompatible with specified data source");
            return new Subscription(this);
        }
    }
}
