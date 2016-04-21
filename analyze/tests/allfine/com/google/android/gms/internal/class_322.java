package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.internal.ja;

// $FF: renamed from: com.google.android.gms.internal.iz
public final class class_322 extends ja<class_322.class_1696, Drawable> {
    public class_322() {
        super(10);
    }

    public static final class class_1696 {
        // $FF: renamed from: Lp int
        public final int field_5034;
        // $FF: renamed from: Lq int
        public final int field_5035;

        public class_1696(int var1, int var2) {
            this.field_5034 = var1;
            this.field_5035 = var2;
        }

        public boolean equals(Object var1) {
            boolean var2 = true;
            if(!(var1 instanceof class_322.class_1696)) {
                var2 = false;
            } else if(this != var1) {
                class_322.class_1696 var3 = (class_322.class_1696)var1;
                if(var3.field_5034 != this.field_5034 || var3.field_5035 != this.field_5035) {
                    return false;
                }
            }

            return var2;
        }

        public int hashCode() {
            Object[] var1 = new Object[] {Integer.valueOf(this.field_5034), Integer.valueOf(this.field_5035)};
            return class_1089.hashCode(var1);
        }
    }
}
