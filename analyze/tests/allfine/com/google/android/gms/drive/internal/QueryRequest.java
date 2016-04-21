package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.class_1100;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
    public static final Creator<QueryRequest> CREATOR = new class_1100();
    // $FF: renamed from: BR int
    final int field_5152;
    // $FF: renamed from: Py com.google.android.gms.drive.query.Query
    final Query field_5153;

    QueryRequest(int var1, Query var2) {
        this.field_5152 = var1;
        this.field_5153 = var2;
    }

    public QueryRequest(Query var1) {
        this(1, var1);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1100.method_5724(this, var1, var2);
    }
}
