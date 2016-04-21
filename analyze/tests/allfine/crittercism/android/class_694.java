package crittercism.android;

import crittercism.android.class_102;
import crittercism.android.class_103;
import crittercism.android.class_661;
import crittercism.android.class_675;
import crittercism.android.class_743;
import crittercism.android.class_744;
import crittercism.android.class_745;
import crittercism.android.class_764;
import crittercism.android.class_774;
import crittercism.android.class_777;
import crittercism.android.class_779;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: crittercism.android.x
public final class class_694 extends InputStream implements class_103 {
    // $FF: renamed from: a crittercism.android.ae
    private class_102 field_3384;
    // $FF: renamed from: b crittercism.android.c
    private class_675 field_3385;
    // $FF: renamed from: c java.io.InputStream
    private InputStream field_3386;
    // $FF: renamed from: d crittercism.android.e
    private class_661 field_3387;
    // $FF: renamed from: e crittercism.android.af
    private class_774 field_3388;

    public class_694(class_102 var1, InputStream var2, class_661 var3) {
        if(var1 == null) {
            throw new NullPointerException("socket was null");
        } else if(var2 == null) {
            throw new NullPointerException("delegate was null");
        } else if(var3 == null) {
            throw new NullPointerException("dispatch was null");
        } else {
            this.field_3384 = var1;
            this.field_3386 = var2;
            this.field_3387 = var3;
            this.field_3388 = this.method_407();
            if(this.field_3388 == null) {
                throw new NullPointerException("parser was null");
            }
        }
    }

    // $FF: renamed from: a (java.lang.Exception) void
    private void method_3818(Exception param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (byte[], int, int) void
    private void method_3819(byte[] var1, int var2, int var3) {
        try {
            this.field_3388.method_4061(var1, var2, var3);
        } catch (ThreadDeath var6) {
            throw var6;
        } catch (Throwable var7) {
            this.field_3388 = class_777.field_3658;
            class_764.method_4019(var7);
        }
    }

    // $FF: renamed from: e () crittercism.android.c
    private class_675 method_3820() {
        if(this.field_3385 == null) {
            this.field_3385 = this.field_3384.method_401();
        }

        return this.field_3385;
    }

    // $FF: renamed from: a () crittercism.android.af
    public final class_774 method_402() {
        return this.field_3388;
    }

    // $FF: renamed from: a (int) void
    public final void method_403(int var1) {
        class_675 var2 = this.method_3820();
        if(var2 != null) {
            var2.method_3743();
            var2.field_3265 = var1;
        }

    }

    // $FF: renamed from: a (crittercism.android.af) void
    public final void method_404(class_774 var1) {
        this.field_3388 = var1;
    }

    // $FF: renamed from: a (java.lang.String) void
    public final void method_405(String var1) {
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) void
    public final void method_406(String var1, String var2) {
    }

    // $FF: renamed from: a (java.io.InputStream) boolean
    public final boolean method_3821(InputStream var1) {
        return this.field_3386 == var1;
    }

    public final int available() {
        return this.field_3386.available();
    }

    // $FF: renamed from: b () crittercism.android.af
    public final class_774 method_407() {
        return new class_779(this);
    }

    // $FF: renamed from: b (int) void
    public final void method_408(int var1) {
        class_675 var3 = this.field_3385;
        class_675 var4 = null;
        if(var3 != null) {
            int var5 = this.field_3385.field_3265;
            var4 = null;
            if(var5 >= 100) {
                var4 = null;
                if(var5 < 200) {
                    var4 = new class_675(this.field_3385.method_3732());
                    var4.method_3747(this.field_3385.field_3261);
                    var4.method_3746(this.field_3385.field_3264);
                    var4.field_3266 = this.field_3385.field_3266;
                }
            }

            this.field_3385.method_3741((long)var1);
            this.field_3387.method_3710(this.field_3385, class_675.class_1233.field_3856);
        }

        this.field_3385 = var4;
    }

    // $FF: renamed from: c () java.lang.String
    public final String method_409() {
        class_675 var1 = this.method_3820();
        String var2 = null;
        if(var1 != null) {
            var2 = var1.field_3266;
        }

        return var2;
    }

    public final void close() {
        try {
            this.field_3388.method_4070();
        } catch (ThreadDeath var3) {
            throw var3;
        } catch (Throwable var4) {
            class_764.method_4019(var4);
        }

        this.field_3386.close();
    }

    // $FF: renamed from: d () void
    public final void method_3822() {
        if(this.field_3385 != null) {
            class_744 var1 = this.field_3385.field_3267;
            class_745 var2 = class_745.field_3526;
            boolean var3;
            if(var1.field_3520 == class_743.field_3517.ordinal() && var1.field_3521 == var2.method_3993()) {
                var3 = true;
            } else {
                var3 = false;
            }

            if(var3 && this.field_3388 != null) {
                this.field_3388.method_4070();
            }
        }

    }

    public final void mark(int var1) {
        this.field_3386.mark(var1);
    }

    public final boolean markSupported() {
        return this.field_3386.markSupported();
    }

    public final int read() {
        int var2;
        try {
            var2 = this.field_3386.read();
        } catch (IOException var7) {
            this.method_3818(var7);
            throw var7;
        }

        try {
            this.field_3388.method_4062(var2);
            return var2;
        } catch (ThreadDeath var5) {
            throw var5;
        } catch (Throwable var6) {
            this.field_3388 = class_777.field_3658;
            class_764.method_4019(var6);
            return var2;
        }
    }

    public final int read(byte[] var1) {
        int var3;
        try {
            var3 = this.field_3386.read(var1);
        } catch (IOException var4) {
            this.method_3818(var4);
            throw var4;
        }

        this.method_3819(var1, 0, var3);
        return var3;
    }

    public final int read(byte[] var1, int var2, int var3) {
        int var5;
        try {
            var5 = this.field_3386.read(var1, var2, var3);
        } catch (IOException var6) {
            this.method_3818(var6);
            throw var6;
        }

        this.method_3819(var1, var2, var5);
        return var5;
    }

    public final void reset() {
        synchronized(this) {}

        try {
            this.field_3386.reset();
        } finally {
            ;
        }

    }

    public final long skip(long var1) {
        return this.field_3386.skip(var1);
    }
}
