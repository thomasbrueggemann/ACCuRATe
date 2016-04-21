package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.b;
import com.google.android.gms.drive.metadata.class_647;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_1039;
import com.google.android.gms.drive.query.internal.class_1044;
import com.google.android.gms.drive.query.internal.f;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final class_1044 CREATOR = new class_1044();
    // $FF: renamed from: BR int
    final int field_2022;
    // $FF: renamed from: QL com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_2023;
    // $FF: renamed from: QW com.google.android.gms.drive.metadata.b
    private final b<T> field_2024;

    InFilter(int var1, MetadataBundle var2) {
        this.field_2022 = var1;
        this.field_2023 = var2;
        this.field_2024 = (class_647)class_1039.method_5399(var2);
    }

    public InFilter(SearchableCollectionMetadataField<T> var1, T var2) {
        this(1, MetadataBundle.method_2097(var1, Collections.singleton(var2)));
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
    public <F> F method_7(f<F> var1) {
        return var1.method_881(this.field_2024, this.getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection)this.field_2023.method_2100(this.field_2024)).iterator().next();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1044.method_5412(this, var1, var2);
    }
}
