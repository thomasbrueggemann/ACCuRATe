package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_506;
import com.google.android.gms.fitness.request.m;

// $FF: renamed from: com.google.android.gms.fitness.request.m
public class class_505 implements SafeParcelable {
    public static final Creator<m> CREATOR = new class_506();
    // $FF: renamed from: BR int
    private final int field_2190;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_2191;

    class_505(int var1, DataType var2) {
        this.field_2190 = var1;
        this.field_2191 = var2;
    }

    private class_505(class_505.class_1343 var1) {
        this.field_2190 = 1;
        this.field_2191 = var1.field_2838;
    }

    // $FF: synthetic method
    class_505(class_505.class_1343 var1, Object var2) {
        this(var1);
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.field_2191;
    }

    int getVersionCode() {
        return this.field_2190;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_506.method_3103(this, var1, var2);
    }

    public static class class_1343 {
        // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
        private DataType field_2838;

        // $FF: renamed from: c (com.google.android.gms.fitness.data.DataType) com.google.android.gms.fitness.request.m$a
        public class_505.class_1343 method_3250(DataType var1) {
            this.field_2838 = var1;
            return this;
        }

        // $FF: renamed from: jq () com.google.android.gms.fitness.request.m
        public class_505 method_3251() {
            return new class_505(this);
        }
    }
}
