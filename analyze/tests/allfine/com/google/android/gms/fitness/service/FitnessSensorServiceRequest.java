package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.class_200;
import com.google.android.gms.fitness.service.SensorEventDispatcher;
import com.google.android.gms.fitness.service.class_1051;
import com.google.android.gms.fitness.service.class_1052;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Creator<FitnessSensorServiceRequest> CREATOR = new class_1051();
    public static final int UNSPECIFIED = -1;
    // $FF: renamed from: BR int
    private final int field_4587;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_4588;
    // $FF: renamed from: UA com.google.android.gms.fitness.data.k
    private final class_200 field_4589;
    // $FF: renamed from: Vc long
    private final long field_4590;
    // $FF: renamed from: Vd long
    private final long field_4591;

    FitnessSensorServiceRequest(int var1, DataSource var2, IBinder var3, long var4, long var6) {
        this.field_4587 = var1;
        this.field_4588 = var2;
        this.field_4589 = class_200.class_1284.method_3041(var3);
        this.field_4590 = var4;
        this.field_4591 = var6;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest) boolean
    private boolean method_5243(FitnessSensorServiceRequest var1) {
        return class_1089.equal(this.field_4588, var1.field_4588) && this.field_4590 == var1.field_4590 && this.field_4591 == var1.field_4591;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof FitnessSensorServiceRequest && this.method_5243((FitnessSensorServiceRequest)var1);
    }

    public long getBatchInterval(TimeUnit var1) {
        return var1.convert(this.field_4591, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.field_4588;
    }

    public SensorEventDispatcher getDispatcher() {
        return new class_1052(this.field_4589);
    }

    public long getSamplingRate(TimeUnit var1) {
        return this.field_4590 == -1L?-1L:var1.convert(this.field_4590, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.field_4587;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_4588, Long.valueOf(this.field_4590), Long.valueOf(this.field_4591)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iX () long
    public long method_5244() {
        return this.field_4590;
    }

    // $FF: renamed from: jN () long
    public long method_5245() {
        return this.field_4591;
    }

    // $FF: renamed from: jw () android.os.IBinder
    IBinder method_5246() {
        return this.field_4589.asBinder();
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_4588};
        return String.format("FitnessSensorServiceRequest{%s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1051.method_5511(this, var1, var2);
    }
}
