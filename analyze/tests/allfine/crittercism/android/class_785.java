package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_777;
import crittercism.android.class_780;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.ah
public final class class_785 extends class_774 {
    // $FF: renamed from: d crittercism.android.ai
    private class_780 field_3667;
    // $FF: renamed from: e int
    private int field_3668;
    // $FF: renamed from: f int
    private int field_3669 = 0;

    public class_785(class_780 var1, int var2) {
        super((class_774)var1);
        this.field_3667 = var1;
        this.field_3668 = var2;
    }

    // $FF: renamed from: a (int) boolean
    public final boolean method_4062(int var1) {
        if(this.field_3669 < 2 + this.field_3668) {
            if(var1 == -1) {
                super.field_3652.method_408(this.a());
                super.field_3652.method_404(class_777.field_3658);
                return true;
            }

            ++this.c;
            char var2 = (char)var1;
            ++this.field_3669;
            if(this.field_3669 > this.field_3668) {
                if(var2 == 10) {
                    this.field_3667.b(this.a());
                    super.field_3652.method_404(this.field_3667);
                    return true;
                }

                if(this.field_3669 == 2 + this.field_3668 && var2 != 10) {
                    super.field_3652.method_404(class_777.field_3658);
                    return true;
                }
            }
        }

        return false;
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public final boolean method_4063(CharArrayBuffer var1) {
        return true;
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        return this.field_3667;
    }

    // $FF: renamed from: c () crittercism.android.af
    public final class_774 method_4067() {
        return null;
    }

    // $FF: renamed from: d () int
    protected final int method_4068() {
        return 0;
    }

    // $FF: renamed from: e () int
    protected final int method_4069() {
        return 0;
    }

    // $FF: renamed from: f () void
    public final void method_4070() {
        super.field_3652.method_408(this.a());
        super.field_3652.method_404(class_777.field_3658);
    }
}
