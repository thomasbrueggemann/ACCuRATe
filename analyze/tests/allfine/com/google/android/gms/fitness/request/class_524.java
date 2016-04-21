package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.class_523;
import com.google.android.gms.fitness.request.u;

// $FF: renamed from: com.google.android.gms.fitness.request.u
public class class_524 implements SafeParcelable {
    public static final Creator<u> CREATOR = new class_523();
    // $FF: renamed from: BR int
    private final int field_2218;
    private final PendingIntent mPendingIntent;

    class_524(int var1, PendingIntent var2) {
        this.field_2218 = var1;
        this.mPendingIntent = var2;
    }

    public class_524(PendingIntent var1) {
        this.field_2218 = 3;
        this.mPendingIntent = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.u) boolean
    private boolean method_3164(class_524 var1) {
        return class_1089.equal(this.mPendingIntent, var1.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof class_524 && this.method_3164((class_524)var1);
    }

    int getVersionCode() {
        return this.field_2218;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.mPendingIntent};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: jr () android.app.PendingIntent
    public PendingIntent method_3165() {
        return this.mPendingIntent;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_523.method_3161(this, var1, var2);
    }
}
