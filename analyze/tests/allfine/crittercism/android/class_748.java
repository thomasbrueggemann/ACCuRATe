package crittercism.android;

// $FF: renamed from: crittercism.android.cv
public final class class_748 {
    // $FF: renamed from: a long
    private long field_3560 = 0L;
    // $FF: renamed from: b long
    private long field_3561;

    public class_748(long var1) {
        this.field_3561 = var1;
    }

    // $FF: renamed from: a () boolean
    public final boolean method_3994() {
        synchronized(this) {}
        boolean var8 = false;

        long var2;
        long var4;
        try {
            var8 = true;
            var2 = System.nanoTime() - this.field_3560;
            var4 = this.field_3561;
            var8 = false;
        } finally {
            if(var8) {
                ;
            }
        }

        boolean var6;
        if(var2 > var4) {
            var6 = true;
        } else {
            var6 = false;
        }

        return var6;
    }

    // $FF: renamed from: b () void
    public final void method_3995() {
        synchronized(this) {}

        try {
            this.field_3560 = System.nanoTime();
        } finally {
            ;
        }

    }
}
