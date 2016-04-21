package com.google.android.gms.internal;

import com.google.android.gms.internal.class_909;
import java.io.IOException;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.pp
final class class_906 {
    final byte[] awV;
    final int tag;

    class_906(int var1, byte[] var2) {
        this.tag = var1;
        this.awV = var2;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pg) void
    void method_4639(class_909 var1) throws IOException {
        var1.method_4719(this.tag);
        var1.method_4729(this.awV);
    }

    // $FF: renamed from: c () int
    int method_4640() {
        return 0 + class_909.method_4689(this.tag) + this.awV.length;
    }

    public boolean equals(Object var1) {
        if(var1 != this) {
            if(!(var1 instanceof class_906)) {
                return false;
            }

            class_906 var2 = (class_906)var1;
            if(this.tag != var2.tag || !Arrays.equals(this.awV, var2.awV)) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        return 31 * (527 + this.tag) + Arrays.hashCode(this.awV);
    }
}
