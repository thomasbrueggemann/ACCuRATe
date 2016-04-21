package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_776;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.aq
public final class class_775 extends class_774 {
    // $FF: renamed from: d boolean
    private boolean field_3656 = false;

    public class_775(class_774 var1) {
        super(var1);
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public final boolean method_4063(CharArrayBuffer var1) {
        int var2 = var1.substringTrimmed(0, var1.length()).length();
        boolean var3 = false;
        if(var2 == 0) {
            var3 = true;
        }

        this.field_3656 = var3;
        return true;
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        if(this.field_3656) {
            super.field_3652.method_408(this.a());
            return super.field_3652.method_407();
        } else {
            super.field_3653.clear();
            return this;
        }
    }

    // $FF: renamed from: c () crittercism.android.af
    public final class_774 method_4067() {
        super.field_3653.clear();
        return new class_776(this);
    }

    // $FF: renamed from: d () int
    protected final int method_4068() {
        return 8;
    }

    // $FF: renamed from: e () int
    protected final int method_4069() {
        return 128;
    }
}
