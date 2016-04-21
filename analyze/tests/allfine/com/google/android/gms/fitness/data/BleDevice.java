package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.class_1140;
import com.google.android.gms.internal.class_850;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR = new class_1140();
    // $FF: renamed from: BR int
    private final int field_2925;
    // $FF: renamed from: SA java.util.List
    private final List<String> field_2926;
    // $FF: renamed from: SB java.util.List
    private final List<DataType> field_2927;
    // $FF: renamed from: Sz java.lang.String
    private final String field_2928;
    private final String mName;

    BleDevice(int var1, String var2, String var3, List<String> var4, List<DataType> var5) {
        this.field_2925 = var1;
        this.field_2928 = var2;
        this.mName = var3;
        this.field_2926 = Collections.unmodifiableList(var4);
        this.field_2927 = Collections.unmodifiableList(var5);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.BleDevice) boolean
    private boolean method_3359(BleDevice var1) {
        return this.mName.equals(var1.mName) && this.field_2928.equals(var1.field_2928) && class_850.method_4488(var1.field_2926, this.field_2926) && class_850.method_4488(this.field_2927, var1.field_2927);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof BleDevice && this.method_3359((BleDevice)var1);
    }

    public String getAddress() {
        return this.field_2928;
    }

    public List<DataType> getDataTypes() {
        return this.field_2927;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.field_2926;
    }

    int getVersionCode() {
        return this.field_2925;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.mName, this.field_2928, this.field_2926, this.field_2927};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("name", this.mName).method_5425("address", this.field_2928).method_5425("dataTypes", this.field_2927).method_5425("supportedProfiles", this.field_2926).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1140.method_5909(this, var1, var2);
    }
}
