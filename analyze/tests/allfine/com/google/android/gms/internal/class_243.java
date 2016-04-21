package com.google.android.gms.internal;

import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.bv
@ez
public final class class_243 implements class_9 {
    // $FF: renamed from: pz com.google.android.gms.internal.bw
    private final class_8 field_639;

    public class_243(class_8 var1) {
        this.field_639 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
    public void method_24(gv var1, Map<String, String> var2) {
        String var3 = (String)var2.get("name");
        if(var3 == null) {
            class_378.method_2461("App event with no name parameter.");
        } else {
            this.field_639.onAppEvent(var3, (String)var2.get("info"));
        }
    }
}
