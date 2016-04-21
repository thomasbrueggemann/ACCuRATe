package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.class_1041;
import com.google.android.gms.drive.query.internal.f;

public class NotFilter extends AbstractFilter {
    public static final Creator<NotFilter> CREATOR = new class_1041();
    // $FF: renamed from: BR int
    final int field_2040;
    // $FF: renamed from: QY com.google.android.gms.drive.query.internal.FilterHolder
    final FilterHolder field_2041;

    NotFilter(int var1, FilterHolder var2) {
        this.field_2040 = var1;
        this.field_2041 = var2;
    }

    public NotFilter(Filter var1) {
        this(1, new FilterHolder(var1));
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
    public <T> T method_7(f<T> var1) {
        return var1.method_887(this.field_2041.getFilter().method_7(var1));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1041.method_5403(this, var1, var2);
    }
}
