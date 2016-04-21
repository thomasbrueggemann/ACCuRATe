package crittercism.android;

import crittercism.android.class_106;
import crittercism.android.class_552;
import crittercism.android.class_757;
import crittercism.android.class_767;
import crittercism.android.class_768;
import crittercism.android.class_790;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: crittercism.android.dl
public final class class_554 extends class_552 {
    // $FF: renamed from: a java.util.Map
    public Map field_2999 = new HashMap();
    // $FF: renamed from: b crittercism.android.dw
    private class_768 field_3000;
    // $FF: renamed from: c crittercism.android.au
    private class_106 field_3001;
    // $FF: renamed from: d boolean
    private boolean field_3002 = false;
    // $FF: renamed from: e boolean
    private boolean field_3003 = false;
    // $FF: renamed from: f boolean
    private boolean field_3004 = false;
    // $FF: renamed from: g boolean
    private boolean field_3005 = false;

    public class_554(class_106 var1) {
        this.field_3001 = var1;
        this.field_3000 = var1.method_439();
    }

    // $FF: renamed from: a (java.lang.String, java.lang.Object) void
    private void method_3395(String var1, Object var2) {
        synchronized(this) {}

        try {
            this.field_2999.put(var1, var2);
        } finally {
            ;
        }

    }

    // $FF: renamed from: a () void
    public final void method_3390() {
        boolean var1 = this.field_3000.method_4040();
        if(this.field_3002) {
            this.method_3395("optOutStatus", Boolean.valueOf(var1));
        }

        if(!var1) {
            if(this.field_3003) {
                this.method_3395("crashedOnLastLoad", Boolean.valueOf(class_757.field_3589));
            }

            if(this.field_3004) {
                this.method_3395("userUUID", this.field_3001.method_430());
            }

            if(this.field_3005) {
                class_767 var2 = class_790.method_4077().field_3688;
                if(var2 != null) {
                    boolean var3 = var2.field_3607.getBoolean("rateMyAppEnabled", false);
                    boolean var4 = false;
                    if(var3) {
                        boolean var5 = var2.field_3607.getBoolean("hasRatedApp", false);
                        var4 = false;
                        if(!var5) {
                            int var6 = var2.method_4031();
                            int var7 = var2.field_3607.getInt("rateAfterNumLoads", 5);
                            var4 = false;
                            if(var6 >= var7) {
                                int var8 = var2.field_3607.getInt("remindAfterNumLoads", 5);
                                int var9 = (var6 - var7) % var8;
                                var4 = false;
                                if(var9 == 0) {
                                    var4 = true;
                                }
                            }
                        }
                    }

                    this.method_3395("shouldShowRateAppAlert", Boolean.valueOf(var4));
                    this.method_3395("message", var2.method_4033());
                    this.method_3395("title", var2.method_4034());
                }
            }
        }

    }

    // $FF: renamed from: b () void
    public final void method_3396() {
        this.field_3002 = true;
    }

    // $FF: renamed from: c () void
    public final void method_3397() {
        this.field_3003 = true;
    }

    // $FF: renamed from: d () void
    public final void method_3398() {
        this.field_3004 = true;
    }

    // $FF: renamed from: e () void
    public final void method_3399() {
        this.field_3005 = true;
    }
}
