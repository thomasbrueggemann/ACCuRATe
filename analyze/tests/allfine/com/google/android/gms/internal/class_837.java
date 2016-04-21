package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.class_838;
import com.google.android.gms.internal.li;

// $FF: renamed from: com.google.android.gms.internal.li
public class class_837 implements SafeParcelable {
    public static final Creator<li> CREATOR = new class_838();
    // $FF: renamed from: BR int
    private final int field_4121;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_4122;

    class_837(int var1, DataSource var2) {
        this.field_4121 = var1;
        this.field_4122 = var2;
    }

    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.field_4122;
    }

    int getVersionCode() {
        return this.field_4121;
    }

    public String toString() {
        Object[] var1 = new Object[] {this.field_4122};
        return String.format("ApplicationUnregistrationRequest{%s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_838.method_4460(this, var1, var2);
    }
}
