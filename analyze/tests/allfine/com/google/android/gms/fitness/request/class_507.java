package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.class_200;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.class_508;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.fitness.request.o
public class class_507 implements SafeParcelable {
    public static final Creator<o> CREATOR = new class_508();
    // $FF: renamed from: BR int
    private final int field_2192;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_2193;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_2194;
    // $FF: renamed from: Tt long
    private final long field_2195;
    // $FF: renamed from: Tu int
    private final int field_2196;
    // $FF: renamed from: UA com.google.android.gms.fitness.data.k
    private class_200 field_2197;
    // $FF: renamed from: UB int
    int field_2198;
    // $FF: renamed from: UC int
    int field_2199;
    // $FF: renamed from: UD long
    private final long field_2200;
    // $FF: renamed from: UE long
    private final long field_2201;
    // $FF: renamed from: UF java.util.List
    private final List<LocationRequest> field_2202;
    // $FF: renamed from: UG long
    private final long field_2203;
    // $FF: renamed from: UH java.util.List
    private final List field_2204;
    private final PendingIntent mPendingIntent;

    class_507(int var1, DataSource var2, DataType var3, IBinder var4, int var5, int var6, long var7, long var9, PendingIntent var11, long var12, int var14, List<LocationRequest> var15, long var16) {
        this.field_2192 = var1;
        this.field_2194 = var2;
        this.field_2193 = var3;
        class_200 var18;
        if(var4 == null) {
            var18 = null;
        } else {
            var18 = class_200.class_1284.method_3041(var4);
        }

        this.field_2197 = var18;
        if(var7 == 0L) {
            var7 = (long)var5;
        }

        this.field_2195 = var7;
        this.field_2201 = var12;
        if(var9 == 0L) {
            var9 = (long)var6;
        }

        this.field_2200 = var9;
        this.field_2202 = var15;
        this.mPendingIntent = var11;
        this.field_2196 = var14;
        this.field_2204 = Collections.emptyList();
        this.field_2203 = var16;
    }

    private class_507(DataSource var1, DataType var2, class_200 var3, PendingIntent var4, long var5, long var7, long var9, int var11, List var12, List var13, long var14) {
        this.field_2192 = 4;
        this.field_2194 = var1;
        this.field_2193 = var2;
        this.field_2197 = var3;
        this.mPendingIntent = var4;
        this.field_2195 = var5;
        this.field_2201 = var7;
        this.field_2200 = var9;
        this.field_2196 = var11;
        this.field_2202 = var12;
        this.field_2204 = var13;
        this.field_2203 = var14;
    }

    public class_507(SensorRequest var1, class_200 var2, PendingIntent var3) {
        this(var1.getDataSource(), var1.getDataType(), var2, var3, var1.getSamplingRate(TimeUnit.MICROSECONDS), var1.getFastestRate(TimeUnit.MICROSECONDS), var1.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), var1.getAccuracyMode(), (List)null, Collections.emptyList(), var1.method_3096());
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.o) boolean
    private boolean method_3106(class_507 var1) {
        return class_1089.equal(this.field_2194, var1.field_2194) && class_1089.equal(this.field_2193, var1.field_2193) && this.field_2195 == var1.field_2195 && this.field_2201 == var1.field_2201 && this.field_2200 == var1.field_2200 && this.field_2196 == var1.field_2196 && class_1089.equal(this.field_2202, var1.field_2202);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof class_507 && this.method_3106((class_507)var1);
    }

    public int getAccuracyMode() {
        return this.field_2196;
    }

    public DataSource getDataSource() {
        return this.field_2194;
    }

    public DataType getDataType() {
        return this.field_2193;
    }

    int getVersionCode() {
        return this.field_2192;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_2194, this.field_2193, this.field_2197, Long.valueOf(this.field_2195), Long.valueOf(this.field_2201), Long.valueOf(this.field_2200), Integer.valueOf(this.field_2196), this.field_2202};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iX () long
    public long method_3107() {
        return this.field_2195;
    }

    // $FF: renamed from: jr () android.app.PendingIntent
    public PendingIntent method_3108() {
        return this.mPendingIntent;
    }

    // $FF: renamed from: js () long
    public long method_3109() {
        return this.field_2201;
    }

    // $FF: renamed from: jt () long
    public long method_3110() {
        return this.field_2200;
    }

    // $FF: renamed from: ju () java.util.List
    public List<LocationRequest> method_3111() {
        return this.field_2202;
    }

    // $FF: renamed from: jv () long
    public long method_3112() {
        return this.field_2203;
    }

    // $FF: renamed from: jw () android.os.IBinder
    IBinder method_3113() {
        return this.field_2197 == null?null:this.field_2197.asBinder();
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_2193, this.field_2194, Long.valueOf(this.field_2195), Long.valueOf(this.field_2201), Long.valueOf(this.field_2200)};
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_508.method_3114(this, var1, var2);
    }
}
