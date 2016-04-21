package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_1038;
import com.google.android.gms.drive.query.internal.class_1039;
import com.google.android.gms.drive.query.internal.f;

public class HasFilter<T> extends AbstractFilter {
    public static final class_1038 CREATOR = new class_1038();
    // $FF: renamed from: BR int
    final int field_2032;
    // $FF: renamed from: QL com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_2033;
    // $FF: renamed from: QM com.google.android.gms.drive.metadata.MetadataField
    final MetadataField<T> field_2034;

    HasFilter(int var1, MetadataBundle var2) {
        this.field_2032 = var1;
        this.field_2033 = var2;
        this.field_2034 = class_1039.method_5399(var2);
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
    public <F> F method_7(f<F> var1) {
        return var1.method_885(this.field_2034, this.getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.field_2033.method_2100(this.field_2034);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1038.method_5396(this, var1, var2);
    }
}
