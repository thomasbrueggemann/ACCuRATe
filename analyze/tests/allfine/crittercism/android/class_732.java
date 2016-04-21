package crittercism.android;

import java.util.Locale;

// $FF: renamed from: crittercism.android.cg
public final class class_732 {
    // $FF: renamed from: a crittercism.android.cg
    public static final class_732 field_3484 = new class_732();
    // $FF: renamed from: b int
    private volatile int field_3485 = 1;
    // $FF: renamed from: c long
    private final long field_3486 = System.currentTimeMillis();

    // $FF: renamed from: b () int
    private int method_3967() {
        synchronized(this) {}

        int var2;
        try {
            var2 = this.field_3485;
            this.field_3485 = var2 + 1;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: a () java.lang.String
    public final String method_3968() {
        Locale var1 = Locale.US;
        Object[] var2 = new Object[] {Integer.valueOf(1), Long.valueOf(this.field_3486), Integer.valueOf(this.method_3967())};
        return String.format(var1, "%d.%d.%09d", var2);
    }
}
