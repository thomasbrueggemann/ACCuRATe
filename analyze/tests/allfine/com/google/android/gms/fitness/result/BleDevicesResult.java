package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.class_1012;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Creator<BleDevicesResult> CREATOR = new class_1012();
    // $FF: renamed from: BR int
    private final int field_3133;
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_3134;
    // $FF: renamed from: UU java.util.List
    private final List<BleDevice> field_3135;

    BleDevicesResult(int var1, List<BleDevice> var2, Status var3) {
        this.field_3133 = var1;
        this.field_3135 = Collections.unmodifiableList(var2);
        this.field_3134 = var3;
    }

    public BleDevicesResult(List<BleDevice> var1, Status var2) {
        this.field_3133 = 3;
        this.field_3135 = Collections.unmodifiableList(var1);
        this.field_3134 = var2;
    }

    // $FF: renamed from: D (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.BleDevicesResult
    public static BleDevicesResult method_3494(Status var0) {
        return new BleDevicesResult(Collections.emptyList(), var0);
    }

    // $FF: renamed from: b (com.google.android.gms.fitness.result.BleDevicesResult) boolean
    private boolean method_3495(BleDevicesResult var1) {
        return this.field_3134.equals(var1.field_3134) && class_1089.equal(this.field_3135, var1.field_3135);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof BleDevicesResult && this.method_3495((BleDevicesResult)var1);
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.field_3135;
    }

    public List<BleDevice> getClaimedBleDevices(DataType var1) {
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.field_3135.iterator();

        while(var3.hasNext()) {
            BleDevice var4 = (BleDevice)var3.next();
            if(var4.getDataTypes().contains(var1)) {
                var2.add(var4);
            }
        }

        return Collections.unmodifiableList(var2);
    }

    public Status getStatus() {
        return this.field_3134;
    }

    int getVersionCode() {
        return this.field_3133;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_3134, this.field_3135};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("status", this.field_3134).method_5425("bleDevices", this.field_3135).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1012.method_5289(this, var1, var2);
    }
}
