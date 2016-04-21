package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.class_1090;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// $FF: renamed from: com.google.android.gms.common.internal.n
public final class class_1089 {
    public static boolean equal(Object var0, Object var1) {
        return var0 == var1 || var0 != null && var0.equals(var1);
    }

    // $FF: renamed from: h (java.lang.Object) com.google.android.gms.common.internal.n$a
    public static class_1089.class_1785 method_5673(Object var0) {
        return new class_1089.class_1785(var0);
    }

    public static int hashCode(Object... var0) {
        return Arrays.hashCode(var0);
    }

    public static final class class_1785 {
        // $FF: renamed from: Mg java.util.List
        private final List<String> field_4756;
        // $FF: renamed from: Mh java.lang.Object
        private final Object field_4757;

        private class_1785(Object var1) {
            this.field_4757 = class_1090.method_5685(var1);
            this.field_4756 = new ArrayList();
        }

        // $FF: synthetic method
        class_1785(Object var1, Object var2) {
            this(var1);
        }

        // $FF: renamed from: a (java.lang.String, java.lang.Object) com.google.android.gms.common.internal.n$a
        public class_1089.class_1785 method_5425(String var1, Object var2) {
            this.field_4756.add((String)class_1090.method_5685(var1) + "=" + var2);
            return this;
        }

        public String toString() {
            StringBuilder var1 = (new StringBuilder(100)).append(this.field_4757.getClass().getSimpleName()).append('{');
            int var2 = this.field_4756.size();

            for(int var3 = 0; var3 < var2; ++var3) {
                var1.append((String)this.field_4756.get(var3));
                if(var3 < var2 - 1) {
                    var1.append(", ");
                }
            }

            return var1.append('}').toString();
        }
    }
}
