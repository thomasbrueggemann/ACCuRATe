package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.k
public class class_648 extends b<String> {
    public class_648(String var1, int var2) {
        super(var1, Collections.singleton(var1), Collections.emptySet(), var2);
    }

    // $FF: renamed from: bk (java.lang.String) java.util.Collection
    public static final Collection<String> method_3651(String var0) throws JSONException {
        if(var0 == null) {
            return null;
        } else {
            ArrayList var1 = new ArrayList();
            JSONArray var2 = new JSONArray(var0);

            for(int var3 = 0; var3 < var2.length(); ++var3) {
                var1.add(var2.getString(var3));
            }

            return Collections.unmodifiableCollection(var1);
        }
    }

    // $FF: renamed from: a (android.os.Bundle, java.util.Collection) void
    protected void method_3652(Bundle var1, Collection<String> var2) {
        var1.putStringArrayList(this.getName(), new ArrayList(var2));
    }

    // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
    // $FF: synthetic method
    protected Object method_3645(DataHolder var1, int var2, int var3) {
        return this.method_3650(var1, var2, var3);
    }

    // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, int, int) java.util.Collection
    protected Collection<String> method_3650(DataHolder var1, int var2, int var3) {
        try {
            Collection var5 = method_3651(var1.method_5989(this.getName(), var2, var3));
            return var5;
        } catch (JSONException var6) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", var6);
        }
    }

    // $FF: renamed from: g (android.os.Bundle) java.lang.Object
    // $FF: synthetic method
    protected Object method_3646(Bundle var1) {
        return this.method_3653(var1);
    }

    // $FF: renamed from: l (android.os.Bundle) java.util.Collection
    protected Collection<String> method_3653(Bundle var1) {
        return var1.getStringArrayList(this.getName());
    }
}
