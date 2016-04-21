package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_776;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.ak
public abstract class class_782 extends class_774 {
    // $FF: renamed from: d boolean
    boolean field_3661 = false;
    // $FF: renamed from: e int
    int field_3662;
    // $FF: renamed from: f boolean
    boolean field_3663 = false;
    // $FF: renamed from: g boolean
    private boolean field_3664 = false;
    // $FF: renamed from: h boolean
    private boolean field_3665 = false;

    public class_782(class_774 var1) {
        super(var1);
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public final boolean method_4063(CharArrayBuffer param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        if(this.field_3665) {
            return this.method_4071();
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
        return 32;
    }

    // $FF: renamed from: e () int
    protected final int method_4069() {
        return 128;
    }

    // $FF: renamed from: g () crittercism.android.af
    protected abstract class_774 method_4071();
}
