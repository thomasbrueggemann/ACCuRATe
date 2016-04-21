package com.google.android.gms.internal;

import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.class_9;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.ah
public interface class_0 {
    // $FF: renamed from: a (com.google.android.gms.internal.ah$a) void
    void method_0(class_0.class_1657 var1);

    // $FF: renamed from: a (com.google.android.gms.internal.t, com.google.android.gms.internal.dn, com.google.android.gms.internal.bw, com.google.android.gms.internal.dq, boolean, com.google.android.gms.internal.bz) void
    void method_1(class_63 var1, class_46 var2, class_8 var3, class_48 var4, boolean var5, class_42 var6);

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.by) void
    void method_2(String var1, class_9 var2);

    // $FF: renamed from: a (java.lang.String, org.json.JSONObject) void
    void method_3(String var1, JSONObject var2);

    void destroy();

    // $FF: renamed from: f (java.lang.String) void
    void method_4(String var1);

    // $FF: renamed from: g (java.lang.String) void
    void method_5(String var1);

    void pause();

    void resume();

    public interface class_1657 {
        // $FF: renamed from: aM () void
        void method_719();
    }
}
