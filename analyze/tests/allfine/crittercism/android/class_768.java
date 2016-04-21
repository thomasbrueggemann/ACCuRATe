package crittercism.android;

import crittercism.android.class_104;
import crittercism.android.class_759;
import crittercism.android.class_766;

// $FF: renamed from: crittercism.android.dw
public final class class_768 {
    // $FF: renamed from: a crittercism.android.ds
    private class_759 field_3621;
    // $FF: renamed from: b crittercism.android.du
    private class_766 field_3622;

    // $FF: renamed from: a () crittercism.android.du
    public final class_766 method_4038() {
        synchronized(this) {}

        class_766 var2;
        try {
            var2 = this.field_3622;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: a (crittercism.android.ax) void
    public final void method_4039(class_104 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b () boolean
    public final boolean method_4040() {
        synchronized(this) {}
        boolean var1 = true;
        boolean var5 = false;

        boolean var3;
        try {
            var5 = true;
            if(this.field_3621 == null) {
                var5 = false;
                return var1;
            }

            var3 = this.field_3621.method_4009();
            var5 = false;
        } finally {
            if(var5) {
                ;
            }
        }

        var1 = var3;
        return var1;
    }
}
