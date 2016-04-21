package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_427;
import com.google.android.gms.internal.class_430;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.ee
@ez
public class class_429 {
    // $FF: renamed from: oA java.lang.String
    private final String field_1586;

    public class_429(String var1) {
        this.field_1586 = var1;
    }

    // $FF: renamed from: a (java.lang.String, int, android.content.Intent) boolean
    public boolean method_2718(String var1, int var2, Intent var3) {
        if(var1 != null && var3 != null) {
            String var4 = class_427.method_2695(var3);
            String var5 = class_427.method_2696(var3);
            if(var4 != null && var5 != null) {
                if(!var1.equals(class_427.method_2691(var4))) {
                    class_378.method_2461("Developer payload not match.");
                    return false;
                }

                if(this.field_1586 != null && !class_430.method_2722(this.field_1586, var4, var5)) {
                    class_378.method_2461("Fail to verify signature.");
                    return false;
                }

                return true;
            }
        }

        return false;
    }

    // $FF: renamed from: ct () java.lang.String
    public String method_2719() {
        return class_383.method_2527();
    }
}
