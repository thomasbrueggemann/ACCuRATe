package crittercism.android;

import crittercism.android.class_675;
import crittercism.android.class_764;
import java.io.OutputStream;

// $FF: renamed from: crittercism.android.u
public final class class_686 extends OutputStream {
    // $FF: renamed from: a java.io.OutputStream
    private final OutputStream field_3342;
    // $FF: renamed from: b crittercism.android.c
    private final class_675 field_3343;

    public class_686(OutputStream var1, class_675 var2) {
        if(var1 == null) {
            throw new NullPointerException("delegate was null");
        } else if(var2 == null) {
            throw new NullPointerException("stats were null");
        } else {
            this.field_3342 = var1;
            this.field_3343 = var2;
        }
    }

    public final void close() {
        this.field_3342.close();
    }

    public final void flush() {
        this.field_3342.flush();
    }

    public final void write(int var1) {
        try {
            if(this.field_3343 != null) {
                this.field_3343.method_3740();
                this.field_3343.method_3744(1L);
            }
        } catch (ThreadDeath var4) {
            throw var4;
        } catch (Throwable var5) {
            class_764.method_4019(var5);
        }

        this.field_3342.write(var1);
    }

    public final void write(byte[] var1) {
        if(this.field_3343 != null) {
            this.field_3343.method_3740();
            if(var1 != null) {
                this.field_3343.method_3744((long)var1.length);
            }
        }

        this.field_3342.write(var1);
    }

    public final void write(byte[] var1, int var2, int var3) {
        if(this.field_3343 != null) {
            this.field_3343.method_3740();
            if(var1 != null) {
                this.field_3343.method_3744((long)var3);
            }
        }

        this.field_3342.write(var1, var2, var3);
    }
}
