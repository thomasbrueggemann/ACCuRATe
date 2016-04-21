package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.class_1037;
import com.google.android.gms.drive.query.internal.class_1039;
import com.google.android.gms.drive.query.internal.f;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final class_1037 CREATOR = new class_1037();
    // $FF: renamed from: BR int
    final int field_2035;
    // $FF: renamed from: QK com.google.android.gms.drive.query.internal.Operator
    final Operator field_2036;
    // $FF: renamed from: QL com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_2037;
    // $FF: renamed from: QM com.google.android.gms.drive.metadata.MetadataField
    final MetadataField<T> field_2038;

    ComparisonFilter(int var1, Operator var2, MetadataBundle var3) {
        this.field_2035 = var1;
        this.field_2036 = var2;
        this.field_2037 = var3;
        this.field_2038 = class_1039.method_5399(var3);
    }

    public ComparisonFilter(Operator var1, SearchableMetadataField<T> var2, T var3) {
        this(1, var1, MetadataBundle.method_2097(var2, var3));
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
    public <F> F method_7(f<F> var1) {
        return var1.method_882(this.field_2036, this.field_2038, this.getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.field_2037.method_2100(this.field_2038);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1037.method_5393(this, var1, var2);
    }
}
