package crittercism.android;

import crittercism.android.class_104;
import crittercism.android.class_108;

// $FF: renamed from: crittercism.android.du
public final class class_766 implements class_108 {
    // $FF: renamed from: a int
    public int field_3604;

    public class_766(int var1) {
        this.field_3604 = var1;
    }

    // $FF: renamed from: a (crittercism.android.ax, java.lang.String, java.lang.String) void
    public final void method_4030(class_104 var1, String var2, String var3) {
        synchronized(this) {}

        try {
            var1.method_411(var2, var3, Integer.valueOf(this.field_3604).intValue());
        } finally {
            ;
        }

    }

    // $FF: renamed from: b () java.lang.Object
    // $FF: synthetic method
    public final Object method_633() {
        return Integer.valueOf(this.field_3604);
    }
}
