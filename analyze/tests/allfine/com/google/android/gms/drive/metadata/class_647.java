package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;
import java.util.Collection;

// $FF: renamed from: com.google.android.gms.drive.metadata.b
public abstract class class_647<T> extends a<Collection<T>> {
    protected class_647(String var1, Collection<String> var2, Collection<String> var3, int var4) {
        super(var1, var2, var3, var4);
    }

    // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_3645(DataHolder var1, int var2, int var3) {
        return this.method_3650(var1, var2, var3);
    }

    // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, int, int) java.util.Collection
    protected Collection<T> method_3650(DataHolder var1, int var2, int var3) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
