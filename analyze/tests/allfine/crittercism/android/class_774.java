package crittercism.android;

import crittercism.android.class_103;
import crittercism.android.class_777;
import org.apache.http.util.CharArrayBuffer;

// $FF: renamed from: crittercism.android.af
public abstract class class_774 {
    // $FF: renamed from: a crittercism.android.al
    class_103 field_3652;
    // $FF: renamed from: b org.apache.http.util.CharArrayBuffer
    CharArrayBuffer field_3653;
    // $FF: renamed from: c int
    protected int field_3654;
    // $FF: renamed from: d int
    private int field_3655;

    public class_774(class_774 var1) {
        this.method_4058(var1.field_3652, var1.field_3654);
    }

    public class_774(class_103 var1) {
        this.method_4058(var1, 0);
    }

    // $FF: renamed from: a (crittercism.android.al, int) void
    private void method_4058(class_103 var1, int var2) {
        this.field_3652 = var1;
        this.field_3655 = this.method_4069();
        this.field_3653 = new CharArrayBuffer(this.method_4068());
        this.field_3654 = var2;
    }

    // $FF: renamed from: g () void
    private void method_4059() {
        this.field_3652.method_404(class_777.field_3658);
    }

    // $FF: renamed from: a () int
    public final int method_4060() {
        return this.field_3654;
    }

    // $FF: renamed from: a (byte[], int, int) void
    public final void method_4061(byte[] var1, int var2, int var3) {
        int var5;
        for(int var4 = this.method_4064(var1, var2, var3); var4 > 0 && var4 < var3; var4 += var5) {
            var5 = this.field_3652.method_402().method_4064(var1, var2 + var4, var3 - var4);
            if(var5 <= 0) {
                break;
            }
        }

    }

    // $FF: renamed from: a (int) boolean
    public boolean method_4062(int var1) {
        if(var1 == -1) {
            this.method_4059();
        } else {
            ++this.field_3654;
            char var2 = (char)var1;
            Object var3;
            if(var2 == 10) {
                if(this.method_4063(this.field_3653)) {
                    var3 = this.method_4065();
                } else {
                    var3 = class_777.field_3658;
                }
            } else if(this.field_3653.length() < this.field_3655) {
                this.field_3653.append(var2);
                var3 = this;
            } else {
                var3 = this.method_4067();
            }

            if(var3 != this) {
                this.field_3652.method_404((class_774)var3);
            }

            if(var3 == this) {
                return false;
            }
        }

        return true;
    }

    // $FF: renamed from: a (org.apache.http.util.CharArrayBuffer) boolean
    public abstract boolean method_4063(CharArrayBuffer var1);

    // $FF: renamed from: b (byte[], int, int) int
    protected int method_4064(byte[] var1, int var2, int var3) {
        boolean var4 = false;
        int var5 = -1;
        if(var3 == var5) {
            this.method_4059();
        } else if(var1 != null && var3 != 0) {
            for(var5 = 0; !var4 && var5 < var3; ++var5) {
                var4 = this.method_4062((char)var1[var2 + var5]);
            }
        }

        return var5;
    }

    // $FF: renamed from: b () crittercism.android.af
    public abstract class_774 method_4065();

    // $FF: renamed from: b (int) void
    public final void method_4066(int var1) {
        this.field_3654 = var1;
    }

    // $FF: renamed from: c () crittercism.android.af
    public abstract class_774 method_4067();

    // $FF: renamed from: d () int
    protected abstract int method_4068();

    // $FF: renamed from: e () int
    protected abstract int method_4069();

    // $FF: renamed from: f () void
    public void method_4070() {
        if(this.field_3652 != null) {
            this.field_3652.method_404(class_777.field_3658);
        }

    }

    public final String toString() {
        return this.field_3653.toString();
    }
}
