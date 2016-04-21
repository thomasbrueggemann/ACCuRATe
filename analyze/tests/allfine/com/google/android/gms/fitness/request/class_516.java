package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.b;
import com.google.android.gms.fitness.request.class_517;

// $FF: renamed from: com.google.android.gms.fitness.request.b
public class class_516 implements SafeParcelable {
    public static final Creator<b> CREATOR = new class_517();
    // $FF: renamed from: BR int
    private final int field_2208;
    // $FF: renamed from: Ui java.lang.String
    private final String field_2209;
    // $FF: renamed from: Uj com.google.android.gms.fitness.data.BleDevice
    private final BleDevice field_2210;

    class_516(int var1, String var2, BleDevice var3) {
        this.field_2208 = var1;
        this.field_2209 = var2;
        this.field_2210 = var3;
    }

    public class_516(BleDevice var1) {
        this(2, var1.getAddress(), var1);
    }

    public class_516(String var1) {
        this(2, var1, (BleDevice)null);
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.field_2209;
    }

    int getVersionCode() {
        return this.field_2208;
    }

    // $FF: renamed from: jf () com.google.android.gms.fitness.data.BleDevice
    public BleDevice method_3137() {
        return this.field_2210;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_2209, this.field_2210};
        return String.format("ClaimBleDeviceRequest{%s %s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_517.method_3138(this, var1, var2);
    }
}
