package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.aa;
import com.google.android.gms.fitness.request.class_502;

// $FF: renamed from: com.google.android.gms.fitness.request.aa
public class class_504 implements SafeParcelable {
    public static final Creator<aa> CREATOR = new class_502();
    // $FF: renamed from: BR int
    private final int field_2153;
    private final PendingIntent mPendingIntent;

    class_504(int var1, PendingIntent var2) {
        this.field_2153 = var1;
        this.mPendingIntent = var2;
    }

    public class_504(PendingIntent var1) {
        this.field_2153 = 3;
        this.mPendingIntent = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.aa) boolean
    private boolean method_3071(class_504 var1) {
        return class_1089.equal(this.mPendingIntent, var1.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof class_504 && this.method_3071((class_504)var1);
    }

    int getVersionCode() {
        return this.field_2153;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.mPendingIntent};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: jr () android.app.PendingIntent
    public PendingIntent method_3072() {
        return this.mPendingIntent;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_502.method_3065(this, var1, var2);
    }
}
