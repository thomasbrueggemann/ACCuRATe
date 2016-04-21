package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_775;
import crittercism.android.class_777;
import crittercism.android.class_785;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.ai
public final class class_780 extends class_774 {
    // $FF: renamed from: d int
    private int field_3660 = -1;

    public class_780(class_774 var1) {
        super(var1);
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public final boolean method_4063(CharArrayBuffer var1) {
        int var2 = var1.indexOf(59);
        int var3 = var1.length();
        if(var2 <= 0) {
            var2 = var3;
        }

        try {
            this.field_3660 = Integer.parseInt(var1.substringTrimmed(0, var2), 16);
            return true;
        } catch (NumberFormatException var5) {
            return false;
        }
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        int var10000 = this.field_3660;
        if(this.field_3660 == 0) {
            return new class_775(this);
        } else {
            super.field_3653.clear();
            return new class_785(this, this.field_3660);
        }
    }

    // $FF: renamed from: c () crittercism.android.af
    public final class_774 method_4067() {
        return class_777.field_3658;
    }

    // $FF: renamed from: d () int
    protected final int method_4068() {
        return 16;
    }

    // $FF: renamed from: e () int
    protected final int method_4069() {
        return 256;
    }

    // $FF: renamed from: f () void
    public final void method_4070() {
        super.field_3652.method_408(this.a());
        super.field_3652.method_404(class_777.field_3658);
    }
}
