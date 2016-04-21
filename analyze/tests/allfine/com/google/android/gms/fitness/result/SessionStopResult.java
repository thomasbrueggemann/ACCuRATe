package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.result.class_1017;
import java.util.Collections;
import java.util.List;

public class SessionStopResult implements Result, SafeParcelable {
    public static final Creator<SessionStopResult> CREATOR = new class_1017();
    // $FF: renamed from: BR int
    private final int field_5073;
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_5074;
    // $FF: renamed from: Ul java.util.List
    private final List<Session> field_5075;

    SessionStopResult(int var1, Status var2, List<Session> var3) {
        this.field_5073 = var1;
        this.field_5074 = var2;
        this.field_5075 = Collections.unmodifiableList(var3);
    }

    public SessionStopResult(Status var1, List<Session> var2) {
        this.field_5073 = 3;
        this.field_5074 = var1;
        this.field_5075 = Collections.unmodifiableList(var2);
    }

    // $FF: renamed from: I (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionStopResult
    public static SessionStopResult method_5569(Status var0) {
        return new SessionStopResult(var0, Collections.emptyList());
    }

    // $FF: renamed from: b (com.google.android.gms.fitness.result.SessionStopResult) boolean
    private boolean method_5570(SessionStopResult var1) {
        return this.field_5074.equals(var1.field_5074) && class_1089.equal(this.field_5075, var1.field_5075);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof SessionStopResult && this.method_5570((SessionStopResult)var1);
    }

    public List<Session> getSessions() {
        return this.field_5075;
    }

    public Status getStatus() {
        return this.field_5074;
    }

    int getVersionCode() {
        return this.field_5073;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_5074, this.field_5075};
        return class_1089.hashCode(var1);
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("status", this.field_5074).method_5425("sessions", this.field_5075).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1017.method_5304(this, var1, var2);
    }
}
