package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.l
public final class class_287 extends Metadata {
    // $FF: renamed from: Or com.google.android.gms.drive.metadata.internal.MetadataBundle
    private final MetadataBundle field_867;

    public class_287(MetadataBundle var1) {
        this.field_867 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.drive.metadata.MetadataField) java.lang.Object
    protected <T> T method_1783(MetadataField<T> var1) {
        return this.field_867.method_2100(var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1786();
    }

    // $FF: renamed from: hR () com.google.android.gms.drive.Metadata
    public Metadata method_1786() {
        return new class_287(MetadataBundle.method_2098(this.field_867));
    }

    public boolean isDataValid() {
        return this.field_867 != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.field_867 + "]";
    }
}
