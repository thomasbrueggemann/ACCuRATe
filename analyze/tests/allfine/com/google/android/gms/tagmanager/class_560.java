package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.aj
abstract class class_560 {
    private final Set<String> apj;
    private final String apk;

    public class_560(String var1, String... var2) {
        this.apk = var1;
        this.apj = new HashSet(var2.length);
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            this.apj.add(var5);
        }

    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public abstract class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1);

    // $FF: renamed from: a (java.util.Set) boolean
    boolean method_3412(Set<String> var1) {
        return var1.containsAll(this.apj);
    }

    // $FF: renamed from: nN () boolean
    public abstract boolean method_3413();

    // $FF: renamed from: or () java.lang.String
    public String method_3414() {
        return this.apk;
    }

    // $FF: renamed from: os () java.util.Set
    public Set<String> method_3415() {
        return this.apj;
    }
}
