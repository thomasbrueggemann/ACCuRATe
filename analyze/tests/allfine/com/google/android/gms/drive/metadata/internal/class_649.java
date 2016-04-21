package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.i
public class class_649<T extends Parcelable> extends b<T> {
    public class_649(String var1, int var2) {
        super(var1, Collections.emptySet(), Collections.singleton(var1), var2);
    }

    // $FF: renamed from: a (android.os.Bundle, java.util.Collection) void
    protected void method_3654(Bundle var1, Collection<T> var2) {
        var1.putParcelableArrayList(this.getName(), new ArrayList(var2));
    }

    // $FF: renamed from: g (android.os.Bundle) java.lang.Object
    // $FF: synthetic method
    protected Object method_3646(Bundle var1) {
        return this.method_3655(var1);
    }

    // $FF: renamed from: l (android.os.Bundle) java.util.Collection
    protected Collection<T> method_3655(Bundle var1) {
        return var1.getParcelableArrayList(this.getName());
    }
}
