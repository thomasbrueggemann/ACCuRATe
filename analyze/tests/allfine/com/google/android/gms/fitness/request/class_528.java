package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.class_200;
import com.google.android.gms.fitness.request.class_527;
import com.google.android.gms.fitness.request.q;

// $FF: renamed from: com.google.android.gms.fitness.request.q
public class class_528 implements SafeParcelable {
    public static final Creator<q> CREATOR = new class_527();
    // $FF: renamed from: BR int
    private final int field_2219;
    // $FF: renamed from: UA com.google.android.gms.fitness.data.k
    private final class_200 field_2220;
    private final PendingIntent mPendingIntent;

    class_528(int var1, IBinder var2, PendingIntent var3) {
        this.field_2219 = var1;
        class_200 var4;
        if(var2 == null) {
            var4 = null;
        } else {
            var4 = class_200.class_1284.method_3041(var2);
        }

        this.field_2220 = var4;
        this.mPendingIntent = var3;
    }

    public class_528(class_200 var1, PendingIntent var2) {
        this.field_2219 = 2;
        this.field_2220 = var1;
        this.mPendingIntent = var2;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.field_2219;
    }

    // $FF: renamed from: jr () android.app.PendingIntent
    public PendingIntent method_3175() {
        return this.mPendingIntent;
    }

    // $FF: renamed from: jw () android.os.IBinder
    IBinder method_3176() {
        return this.field_2220 == null?null:this.field_2220.asBinder();
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_2220};
        return String.format("SensorUnregistrationRequest{%s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_527.method_3172(this, var1, var2);
    }
}
