package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.AbstractFilter;
import com.google.android.gms.drive.query.internal.class_1036;
import com.google.android.gms.drive.query.internal.class_1039;
import com.google.android.gms.drive.query.internal.f;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Creator<FieldOnlyFilter> CREATOR = new class_1036();
    // $FF: renamed from: BR int
    final int field_2029;
    // $FF: renamed from: QL com.google.android.gms.drive.metadata.internal.MetadataBundle
    final MetadataBundle field_2030;
    // $FF: renamed from: QM com.google.android.gms.drive.metadata.MetadataField
    private final MetadataField<?> field_2031;

    FieldOnlyFilter(int var1, MetadataBundle var2) {
        this.field_2029 = var1;
        this.field_2030 = var2;
        this.field_2031 = class_1039.method_5399(var2);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> var1) {
        this(1, MetadataBundle.method_2097(var1, (Object)null));
    }

    // $FF: renamed from: a (com.google.android.gms.drive.query.internal.f) java.lang.Object
    public <T> T method_7(f<T> var1) {
        return var1.method_884(this.field_2031);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1036.method_5390(this, var1, var2);
    }
}
