package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements Result, SafeParcelable {
    public static final StatusCreator CREATOR = new StatusCreator();
    // $FF: renamed from: Jv com.google.android.gms.common.api.Status
    public static final Status field_4739 = new Status(0);
    // $FF: renamed from: Jw com.google.android.gms.common.api.Status
    public static final Status field_4740 = new Status(14);
    // $FF: renamed from: Jx com.google.android.gms.common.api.Status
    public static final Status field_4741 = new Status(8);
    // $FF: renamed from: Jy com.google.android.gms.common.api.Status
    public static final Status field_4742 = new Status(15);
    // $FF: renamed from: Jz com.google.android.gms.common.api.Status
    public static final Status field_4743 = new Status(16);
    // $FF: renamed from: BR int
    private final int field_4744;
    // $FF: renamed from: HF int
    private final int field_4745;
    // $FF: renamed from: JA java.lang.String
    private final String field_4746;
    private final PendingIntent mPendingIntent;

    public Status(int var1) {
        this(var1, (String)null);
    }

    Status(int var1, int var2, String var3, PendingIntent var4) {
        this.field_4744 = var1;
        this.field_4745 = var2;
        this.field_4746 = var3;
        this.mPendingIntent = var4;
    }

    public Status(int var1, String var2) {
        this(1, var1, var2, (PendingIntent)null);
    }

    public Status(int var1, String var2, PendingIntent var3) {
        this(1, var1, var2, var3);
    }

    // $FF: renamed from: fX () java.lang.String
    private String method_5373() {
        return this.field_4746 != null?this.field_4746:CommonStatusCodes.getStatusCodeString(this.field_4745);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        if(var1 instanceof Status) {
            Status var2 = (Status)var1;
            if(this.field_4744 == var2.field_4744 && this.field_4745 == var2.field_4745 && class_1089.equal(this.field_4746, var2.field_4746) && class_1089.equal(this.mPendingIntent, var2.mPendingIntent)) {
                return true;
            }
        }

        return false;
    }

    PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.field_4745;
    }

    public String getStatusMessage() {
        return this.field_4746;
    }

    int getVersionCode() {
        return this.field_4744;
    }

    // $FF: renamed from: gt () com.google.android.gms.common.ConnectionResult
    @Deprecated
    public ConnectionResult method_5374() {
        return new ConnectionResult(this.field_4745, this.mPendingIntent);
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_4744), Integer.valueOf(this.field_4745), this.field_4746, this.mPendingIntent};
        return class_1089.hashCode(var1);
    }

    public boolean isCanceled() {
        return this.field_4745 == 16;
    }

    public boolean isInterrupted() {
        return this.field_4745 == 14;
    }

    public boolean isSuccess() {
        return this.field_4745 <= 0;
    }

    public void startResolutionForResult(Activity var1, int var2) throws SendIntentException {
        if(this.hasResolution()) {
            var1.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), var2, (Intent)null, 0, 0, 0);
        }
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("statusCode", this.method_5373()).method_5425("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        StatusCreator.method_4370(this, var1, var2);
    }
}
