package crittercism.android;

import crittercism.android.class_102;
import crittercism.android.class_103;
import crittercism.android.class_675;
import crittercism.android.class_688;
import crittercism.android.class_764;
import crittercism.android.class_774;
import crittercism.android.class_777;
import crittercism.android.class_778;
import java.io.OutputStream;

// $FF: renamed from: crittercism.android.w
public final class class_684 extends OutputStream implements class_103 {
    // $FF: renamed from: a crittercism.android.ae
    private class_102 field_3332;
    // $FF: renamed from: b java.io.OutputStream
    private OutputStream field_3333;
    // $FF: renamed from: c crittercism.android.c
    private class_675 field_3334;
    // $FF: renamed from: d crittercism.android.af
    private class_774 field_3335;

    public class_684(class_102 var1, OutputStream var2) {
        if(var1 == null) {
            throw new NullPointerException("socket was null");
        } else if(var2 == null) {
            throw new NullPointerException("output stream was null");
        } else {
            this.field_3332 = var1;
            this.field_3333 = var2;
            this.field_3335 = this.method_407();
            if(this.field_3335 == null) {
                throw new NullPointerException("parser was null");
            }
        }
    }

    // $FF: renamed from: a (byte[], int, int) void
    private void method_3784(byte[] var1, int var2, int var3) {
        try {
            this.field_3335.method_4061(var1, var2, var3);
        } catch (ThreadDeath var6) {
            throw var6;
        } catch (Throwable var7) {
            class_764.method_4019(var7);
            this.field_3335 = class_777.field_3658;
        }
    }

    // $FF: renamed from: d () crittercism.android.c
    private class_675 method_3785() {
        if(this.field_3334 == null) {
            this.field_3334 = this.field_3332.method_399();
        }

        class_675 var10000 = this.field_3334;
        return this.field_3334;
    }

    // $FF: renamed from: a () crittercism.android.af
    public final class_774 method_402() {
        return this.field_3335;
    }

    // $FF: renamed from: a (int) void
    public final void method_403(int var1) {
    }

    // $FF: renamed from: a (crittercism.android.af) void
    public final void method_404(class_774 var1) {
        this.field_3335 = var1;
    }

    // $FF: renamed from: a (java.lang.String) void
    public final void method_405(String var1) {
        class_675 var2 = this.method_3785();
        if(var2 != null) {
            var2.method_3742(var1);
        }

    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) void
    public final void method_406(String var1, String var2) {
        class_675 var3 = this.method_3785();
        var3.method_3740();
        var3.field_3266 = var1;
        var3.field_3269 = null;
        class_688 var4 = var3.field_3268;
        if(var2 != null) {
            var4.field_3349 = var2;
        }

        this.field_3332.method_400(var3);
    }

    // $FF: renamed from: a (java.io.OutputStream) boolean
    public final boolean method_3786(OutputStream var1) {
        return this.field_3333 == var1;
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_407() {
        return new class_778(this);
    }

    // $FF: renamed from: b (int) void
    public final void method_408(int var1) {
        class_675 var2 = this.field_3334;
        this.field_3334 = null;
        if(var2 != null) {
            var2.method_3746((long)var1);
        }

    }

    // $FF: renamed from: c () java.lang.String
    public final String method_409() {
        class_675 var1 = this.method_3785();
        String var2 = null;
        if(var1 != null) {
            var2 = var1.field_3266;
        }

        return var2;
    }

    public final void close() {
        this.field_3333.close();
    }

    public final void flush() {
        this.field_3333.flush();
    }

    public final void write(int var1) {
        this.field_3333.write(var1);

        try {
            this.field_3335.method_4062(var1);
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
            this.field_3335 = class_777.field_3658;
        }
    }

    public final void write(byte[] var1) {
        this.field_3333.write(var1);
        if(var1 != null) {
            this.method_3784(var1, 0, var1.length);
        }

    }

    public final void write(byte[] var1, int var2, int var3) {
        this.field_3333.write(var1, var2, var3);
        if(var1 != null) {
            this.method_3784(var1, var2, var3);
        }

    }
}
