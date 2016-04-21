package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.drive.metadata.a
public abstract class class_645<T> implements MetadataField<T> {
    // $FF: renamed from: PB java.lang.String
    private final String field_3188;
    // $FF: renamed from: PC java.util.Set
    private final Set<String> field_3189;
    // $FF: renamed from: PD java.util.Set
    private final Set<String> field_3190;
    // $FF: renamed from: PE int
    private final int field_3191;

    protected class_645(String var1, int var2) {
        this.field_3188 = (String)class_1090.method_5681(var1, "fieldName");
        this.field_3189 = Collections.singleton(var1);
        this.field_3190 = Collections.emptySet();
        this.field_3191 = var2;
    }

    protected class_645(String var1, Collection<String> var2, Collection<String> var3, int var4) {
        this.field_3188 = (String)class_1090.method_5681(var1, "fieldName");
        this.field_3189 = Collections.unmodifiableSet(new HashSet(var2));
        this.field_3190 = Collections.unmodifiableSet(new HashSet(var3));
        this.field_3191 = var4;
    }

    // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    public final T method_187(DataHolder var1, int var2, int var3) {
        return this.method_3644(var1, var2, var3)?this.method_3645(var1, var2, var3):null;
    }

    // $FF: renamed from: a (android.os.Bundle, java.lang.Object) void
    protected abstract void method_3643(Bundle var1, T var2);

    // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.metadata.internal.MetadataBundle, int, int) void
    public final void method_188(DataHolder var1, MetadataBundle var2, int var3, int var4) {
        class_1090.method_5681(var1, "dataHolder");
        class_1090.method_5681(var2, "bundle");
        var2.method_2101(this, this.method_187(var1, var3, var4));
    }

    // $FF: renamed from: a (java.lang.Object, android.os.Bundle) void
    public final void method_189(T var1, Bundle var2) {
        class_1090.method_5681(var2, "bundle");
        if(var1 == null) {
            var2.putString(this.getName(), (String)null);
        } else {
            this.method_3643(var2, var1);
        }
    }

    // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) boolean
    protected boolean method_3644(DataHolder var1, int var2, int var3) {
        Iterator var4 = this.field_3189.iterator();

        do {
            if(!var4.hasNext()) {
                return true;
            }
        } while(!var1.method_5999((String)var4.next(), var2, var3));

        return false;
    }

    // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    protected abstract T method_3645(DataHolder var1, int var2, int var3);

    // $FF: renamed from: f (android.os.Bundle) java.lang.Object
    public final T method_190(Bundle var1) {
        class_1090.method_5681(var1, "bundle");
        return var1.get(this.getName()) != null?this.method_3646(var1):null;
    }

    // $FF: renamed from: g (android.os.Bundle) java.lang.Object
    protected abstract T method_3646(Bundle var1);

    public final String getName() {
        return this.field_3188;
    }

    public String toString() {
        return this.field_3188;
    }
}
