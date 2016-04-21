package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.ah;
import com.google.android.gms.fitness.request.class_497;

// $FF: renamed from: com.google.android.gms.fitness.request.ah
public class class_496 implements SafeParcelable {
    public static final Creator<ah> CREATOR = new class_497();
    // $FF: renamed from: BR int
    private final int field_2135;
    // $FF: renamed from: Ui java.lang.String
    private final String field_2136;

    class_496(int var1, String var2) {
        this.field_2135 = var1;
        this.field_2136 = var2;
    }

    public class_496(String var1) {
        this(3, var1);
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.field_2136;
    }

    int getVersionCode() {
        return this.field_2135;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_2136};
        return String.format("UnclaimBleDeviceRequest{%s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_497.method_3042(this, var1, var2);
    }
}
