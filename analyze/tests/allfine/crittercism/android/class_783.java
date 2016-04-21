package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_780;
import crittercism.android.class_782;
import crittercism.android.class_786;

// $FF: renamed from: crittercism.android.am
public final class class_783 extends class_782 {
    public class_783(class_774 var1) {
        super(var1);
    }

    // $FF: renamed from: g () crittercism.android.af
    protected final class_774 method_4071() {
        if(super.field_3663) {
            return new class_780(this);
        } else if(super.field_3661 && super.field_3662 > 0) {
            return new class_786(this, super.field_3662);
        } else {
            super.field_3652.method_408(this.a());
            return super.field_3652.method_407();
        }
    }
}
