package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1137;
import com.google.android.gms.fitness.data.q;
import com.google.android.gms.fitness.result.class_1015;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR = new class_1015();
    // $FF: renamed from: BR int
    private final int field_3129;
    // $FF: renamed from: CM com.google.android.gms.common.api.Status
    private final Status field_3130;
    // $FF: renamed from: UZ java.util.List
    private final List<q> field_3131;
    // $FF: renamed from: Ul java.util.List
    private final List<Session> field_3132;

    SessionReadResult(int var1, List<Session> var2, List<q> var3, Status var4) {
        this.field_3129 = var1;
        this.field_3132 = var2;
        this.field_3131 = Collections.unmodifiableList(var3);
        this.field_3130 = var4;
    }

    public SessionReadResult(List<Session> var1, List<q> var2, Status var3) {
        this.field_3129 = 3;
        this.field_3132 = var1;
        this.field_3131 = Collections.unmodifiableList(var2);
        this.field_3130 = var3;
    }

    // $FF: renamed from: H (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.SessionReadResult
    public static SessionReadResult method_3485(Status var0) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), var0);
    }

    // $FF: renamed from: b (com.google.android.gms.fitness.result.SessionReadResult) boolean
    private boolean method_3486(SessionReadResult var1) {
        return this.field_3130.equals(var1.field_3130) && class_1089.equal(this.field_3132, var1.field_3132) && class_1089.equal(this.field_3131, var1.field_3131);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof SessionReadResult && this.method_3486((SessionReadResult)var1);
    }

    public List<DataSet> getDataSet(Session var1) {
        class_1090.method_5684(this.field_3132.contains(var1), "Attempting to read data for session %s which was not returned", new Object[] {var1});
        ArrayList var2 = new ArrayList();
        Iterator var3 = this.field_3131.iterator();

        while(var3.hasNext()) {
            class_1137 var4 = (class_1137)var3.next();
            if(class_1089.equal(var1, var4.getSession())) {
                var2.add(var4.method_5902());
            }
        }

        return var2;
    }

    public List<DataSet> getDataSet(Session var1, DataType var2) {
        class_1090.method_5684(this.field_3132.contains(var1), "Attempting to read data for session %s which was not returned", new Object[] {var1});
        ArrayList var3 = new ArrayList();
        Iterator var4 = this.field_3131.iterator();

        while(var4.hasNext()) {
            class_1137 var5 = (class_1137)var4.next();
            if(class_1089.equal(var1, var5.getSession()) && var2.equals(var5.method_5902().getDataType())) {
                var3.add(var5.method_5902());
            }
        }

        return var3;
    }

    public List<Session> getSessions() {
        return this.field_3132;
    }

    public Status getStatus() {
        return this.field_3130;
    }

    int getVersionCode() {
        return this.field_3129;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_3130, this.field_3132, this.field_3131};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: jL () java.util.List
    public List<q> method_3487() {
        return this.field_3131;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("status", this.field_3130).method_5425("sessions", this.field_3132).method_5425("sessionDataSets", this.field_3131).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1015.method_5298(this, var1, var2);
    }
}
