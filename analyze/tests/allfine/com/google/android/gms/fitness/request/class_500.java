package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ad;
import com.google.android.gms.fitness.request.class_349;
import com.google.android.gms.fitness.request.class_50;
import com.google.android.gms.fitness.request.class_501;

// $FF: renamed from: com.google.android.gms.fitness.request.ad
public class class_500 implements SafeParcelable {
    public static final Creator<ad> CREATOR = new class_501();
    // $FF: renamed from: BR int
    private final int field_2140;
    // $FF: renamed from: UQ com.google.android.gms.fitness.request.l
    private final class_50 field_2141;

    class_500(int var1, IBinder var2) {
        this.field_2140 = var1;
        this.field_2141 = class_50.class_1193.method_2343(var2);
    }

    public class_500(BleScanCallback var1) {
        this.field_2140 = 1;
        this.field_2141 = class_349.class_1362.method_3361().method_3363(var1);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.field_2140;
    }

    // $FF: renamed from: jC () android.os.IBinder
    public IBinder method_3050() {
        return this.field_2141.asBinder();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_501.method_3052(this, var1, var2);
    }
}
