package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_331;
import com.google.android.gms.internal.class_334;
import com.google.android.gms.internal.il;

// $FF: renamed from: com.google.android.gms.internal.il
public class class_333 implements SafeParcelable {
    public static final Creator<il> CREATOR = new class_331();
    // $FF: renamed from: BR int
    private final int field_1137;
    // $FF: renamed from: FA double
    private double field_1138;
    // $FF: renamed from: FB boolean
    private boolean field_1139;
    // $FF: renamed from: GB int
    private int field_1140;
    // $FF: renamed from: GC int
    private int field_1141;
    // $FF: renamed from: GN com.google.android.gms.cast.ApplicationMetadata
    private ApplicationMetadata field_1142;

    public class_333() {
        this(3, Double.NaN, false, -1, (ApplicationMetadata)null, -1);
    }

    class_333(int var1, double var2, boolean var4, int var5, ApplicationMetadata var6, int var7) {
        this.field_1137 = var1;
        this.field_1138 = var2;
        this.field_1139 = var4;
        this.field_1140 = var5;
        this.field_1142 = var6;
        this.field_1141 = var7;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof class_333)) {
                return false;
            }

            class_333 var2 = (class_333)var1;
            if(this.field_1138 != var2.field_1138 || this.field_1139 != var2.field_1139 || this.field_1140 != var2.field_1140 || !class_334.method_2300(this.field_1142, var2.field_1142) || this.field_1141 != var2.field_1141) {
                return false;
            }
        }

        return true;
    }

    // $FF: renamed from: fE () double
    public double method_2296() {
        return this.field_1138;
    }

    // $FF: renamed from: fM () boolean
    public boolean method_2297() {
        return this.field_1139;
    }

    // $FF: renamed from: fN () int
    public int method_2298() {
        return this.field_1140;
    }

    // $FF: renamed from: fO () int
    public int method_2299() {
        return this.field_1141;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.field_1142;
    }

    public int getVersionCode() {
        return this.field_1137;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Double.valueOf(this.field_1138), Boolean.valueOf(this.field_1139), Integer.valueOf(this.field_1140), this.field_1142, Integer.valueOf(this.field_1141)};
        return class_1089.hashCode(var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_331.method_2276(this, var1, var2);
    }
}
