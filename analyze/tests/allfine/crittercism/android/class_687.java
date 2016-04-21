package crittercism.android;

import crittercism.android.class_661;
import crittercism.android.class_675;
import crittercism.android.class_764;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: crittercism.android.t
public final class class_687 extends InputStream {
    // $FF: renamed from: a java.io.InputStream
    private final InputStream field_3344;
    // $FF: renamed from: b crittercism.android.e
    private final class_661 field_3345;
    // $FF: renamed from: c crittercism.android.c
    private final class_675 field_3346;

    public class_687(InputStream var1, class_661 var2, class_675 var3) {
        if(var1 == null) {
            throw new NullPointerException("delegate was null");
        } else if(var2 == null) {
            throw new NullPointerException("dispatch was null");
        } else if(var3 == null) {
            throw new NullPointerException("stats were null");
        } else {
            this.field_3344 = var1;
            this.field_3345 = var2;
            this.field_3346 = var3;
        }
    }

    // $FF: renamed from: a (int, int) void
    private void method_3794(int param1, int param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.Exception) void
    private void method_3795(Exception var1) {
        try {
            this.field_3346.method_3738(var1);
            this.field_3345.method_3709(this.field_3346);
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
        }
    }

    public final int available() {
        return this.field_3344.available();
    }

    public final void close() {
        this.field_3344.close();
    }

    public final void mark(int var1) {
        this.field_3344.mark(var1);
    }

    public final boolean markSupported() {
        return this.field_3344.markSupported();
    }

    public final int read() {
        int var2;
        try {
            var2 = this.field_3344.read();
        } catch (IOException var3) {
            this.method_3795(var3);
            throw var3;
        }

        this.method_3794(var2, 1);
        return var2;
    }

    public final int read(byte[] var1) {
        int var3;
        try {
            var3 = this.field_3344.read(var1);
        } catch (IOException var4) {
            this.method_3795(var4);
            throw var4;
        }

        this.method_3794(var3, var3);
        return var3;
    }

    public final int read(byte[] var1, int var2, int var3) {
        int var5;
        try {
            var5 = this.field_3344.read(var1, var2, var3);
        } catch (IOException var6) {
            this.method_3795(var6);
            throw var6;
        }

        this.method_3794(var5, var5);
        return var5;
    }

    public final void reset() {
        synchronized(this) {}

        try {
            this.field_3344.reset();
        } finally {
            ;
        }

    }

    public final long skip(long var1) {
        long var3 = this.field_3344.skip(var1);

        try {
            if(this.field_3346 != null) {
                this.field_3346.method_3734(var3);
            }

            return var3;
        } catch (ThreadDeath var7) {
            throw var7;
        } catch (Throwable var8) {
            class_764.method_4019(var8);
            return var3;
        }
    }
}
