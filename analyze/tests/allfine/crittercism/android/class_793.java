package crittercism.android;

import android.location.Location;
import crittercism.android.bc;

// $FF: renamed from: crittercism.android.bc
public final class class_793 {
    // $FF: renamed from: a android.location.Location
    private static Location field_3741;

    // $FF: renamed from: a () android.location.Location
    public static Location method_4110() {
        synchronized(bc.class) {}

        Location var1;
        try {
            var1 = field_3741;
        } finally {
            ;
        }

        return var1;
    }

    // $FF: renamed from: a (android.location.Location) void
    public static void method_4111(Location param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b () boolean
    public static boolean method_4112() {
        synchronized(bc.class) {}
        boolean var4 = false;

        Location var1;
        try {
            var4 = true;
            var1 = field_3741;
            var4 = false;
        } finally {
            if(var4) {
                ;
            }
        }

        boolean var2;
        if(var1 != null) {
            var2 = true;
        } else {
            var2 = false;
        }

        return var2;
    }
}
