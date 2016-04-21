package crittercism.android;

import crittercism.android.class_101;
import crittercism.android.class_761;

// $FF: renamed from: crittercism.android.do
public final class class_762 {
    public static final class class_1389 extends class_761 {
        // $FF: renamed from: a java.lang.String
        private String field_3597;

        private class_1389(String var1) {
            this.field_3597 = var1;
        }

        // $FF: synthetic method
        class_1389(String var1, byte var2) {
            this(var1);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_4014() {
            return "http://www.amazon.com/gp/mas/dl/android?p=" + this.field_3597;
        }
    }

    public static final class class_1390 implements class_101 {
        // $FF: renamed from: a (java.lang.String) crittercism.android.dm
        // $FF: synthetic method
        public final class_761 method_398(String var1) {
            if(var1 == null) {
                throw new NullPointerException("packageName cannot be null");
            } else {
                return new class_762.class_1389(var1, (byte)0);
            }
        }
    }

    public static final class class_1391 extends class_761 {
        // $FF: renamed from: a java.lang.String
        private String field_3596;

        private class_1391(String var1) {
            this.field_3596 = var1;
        }

        // $FF: synthetic method
        class_1391(String var1, byte var2) {
            this(var1);
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_4014() {
            return "market://details?id=" + this.field_3596;
        }
    }

    public static final class class_1392 implements class_101 {
        // $FF: renamed from: a (java.lang.String) crittercism.android.dm
        // $FF: synthetic method
        public final class_761 method_398(String var1) {
            if(var1 == null) {
                throw new NullPointerException("packageName cannot be null");
            } else {
                return new class_762.class_1391(var1, (byte)0);
            }
        }
    }
}
