package crittercism.android;

import crittercism.android.class_774;
import crittercism.android.class_777;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.ag
public final class class_786 extends class_774 {
    // $FF: renamed from: d int
    private int field_3670;
    // $FF: renamed from: e int
    private int field_3671 = 0;

    public class_786(class_774 var1, int var2) {
        super(var1);
        this.field_3670 = var2;
    }

    // $FF: renamed from: a (int) boolean
    public final boolean method_4062(int var1) {
        if(var1 == -1) {
            super.field_3652.method_404(class_777.field_3658);
            return true;
        } else {
            ++this.field_3671;
            ++this.c;
            if(this.field_3671 == this.field_3670) {
                super.field_3652.method_408(this.a());
                class_774 var2 = super.field_3652.method_407();
                super.field_3652.method_404(var2);
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

    // $FF: renamed from: b (byte[], int, int) int
    public final int method_4064(byte[] var1, int var2, int var3) {
        if(var3 == -1) {
            super.field_3652.method_404(class_777.field_3658);
            return -1;
        } else if(var3 + this.field_3671 < this.field_3670) {
            this.field_3671 += var3;
            this.c += var3;
            return var3;
        } else {
            int var4 = this.field_3670 - this.field_3671;
            this.c += var4;
            super.field_3652.method_408(this.a());
            super.field_3652.method_404(super.field_3652.method_407());
            return var4;
        }
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_4065() {
        return class_777.field_3658;
    }

    // $FF: renamed from: c () crittercism.android.af
    public final class_774 method_4067() {
        return class_777.field_3658;
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
