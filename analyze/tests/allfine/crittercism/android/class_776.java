package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_777;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.ar
public final class class_776 extends class_774 {
    // $FF: renamed from: d crittercism.android.af
    private class_774 field_3657;

    public class_776(class_774 var1) {
        super(var1);
        this.field_3657 = var1;
    }

    // $FF: renamed from: a (int) boolean
    public final boolean method_4062(int var1) {
        if(var1 == -1) {
            super.field_3652.method_404(class_777.field_3658);
            return true;
        } else {
            ++this.c;
            if((char)var1 == 10) {
                this.field_3657.method_4066(this.a());
                super.field_3652.method_404(this.field_3657);
                return true;
            } else {
                return false;
            }
        }
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public final boolean method_4063(CharArrayBuffer var1) {
        return true;
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        return this;
    }

    // $FF: renamed from: c () crittercism.android.af
    public final class_774 method_4067() {
        return this;
    }

    // $FF: renamed from: d () int
    protected final int method_4068() {
        return 0;
    }

    // $FF: renamed from: e () int
    protected final int method_4069() {
        return 0;
    }
}
