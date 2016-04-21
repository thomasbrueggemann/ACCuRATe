package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_780;
import crittercism.android.class_781;
import crittercism.android.class_782;
import crittercism.android.class_786;

// $FF: renamed from: crittercism.android.ao
public final class class_784 extends class_782 {
    // $FF: renamed from: g int
    private int field_3666;

    public class_784(class_774 var1, int var2) {
        super(var1);
        this.field_3666 = var2;
    }

    // $FF: renamed from: g () crittercism.android.af
    protected final class_774 method_4071() {
        boolean var1;
        if(!super.field_3652.method_409().equals("HEAD") && (this.field_3666 < 100 || this.field_3666 > 199) && this.field_3666 != 204 && this.field_3666 != 304) {
            var1 = false;
        } else {
            var1 = true;
        }

        if(var1) {
            super.field_3652.method_408(this.a());
            return super.field_3652.method_407();
        } else if(super.field_3663) {
            return new class_780(this);
        } else if(super.field_3661) {
            if(super.field_3662 > 0) {
                return new class_786(this, super.field_3662);
            } else {
                super.field_3652.method_408(this.a());
                return super.field_3652.method_407();
            }
        } else if(super.field_3652.method_409().equals("CONNECT")) {
            super.field_3652.method_408(this.a());
            return super.field_3652.method_407();
        } else {
            return new class_781(this);
        }
    }
}
