package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_340;
import com.google.android.gms.internal.class_342;
import com.google.android.gms.internal.class_350;
import com.google.android.gms.internal.class_354;
import com.google.android.gms.internal.class_356;
import com.google.android.gms.internal.class_361;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.ji
public abstract class class_268 {
    // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.ji$a, java.lang.Object) void
    private void method_1688(StringBuilder var1, class_268.class_1299 var2, Object var3) {
        if(var2.method_3876() == 11) {
            var1.append(((class_268)var2.method_3883().cast(var3)).toString());
        } else if(var2.method_3876() == 7) {
            var1.append("\"");
            var1.append(class_342.method_2316((String)var3));
            var1.append("\"");
        } else {
            var1.append(var3);
        }
    }

    // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.ji$a, java.util.ArrayList) void
    private void method_1689(StringBuilder var1, class_268.class_1299 var2, ArrayList<Object> var3) {
        var1.append("[");
        int var5 = 0;

        for(int var6 = var3.size(); var5 < var6; ++var5) {
            if(var5 > 0) {
                var1.append(",");
            }

            Object var8 = var3.get(var5);
            if(var8 != null) {
                this.method_1688(var1, var2, var8);
            }
        }

        var1.append("]");
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ji$a, java.lang.Object) java.lang.Object
    protected <O, I> I method_1690(class_268.class_1299<I, O> var1, Object var2) {
        if(var1.field_3430 != null) {
            var2 = var1.convertBack(var2);
        }

        return var2;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ji$a) boolean
    protected boolean method_1691(class_268.class_1299 var1) {
        return var1.method_3877() == 11?(var1.method_3880()?this.method_1696(var1.method_3881()):this.method_1695(var1.method_3881())):this.method_1694(var1.method_3881());
    }

    // $FF: renamed from: b (com.google.android.gms.internal.ji$a) java.lang.Object
    protected Object method_1692(class_268.class_1299 var1) {
        String var2 = var1.method_3881();
        if(var1.method_3883() != null) {
            boolean var3;
            if(this.method_1693(var1.method_3881()) == null) {
                var3 = true;
            } else {
                var3 = false;
            }

            Object[] var4 = new Object[] {var1.method_3881()};
            class_1090.method_5677(var3, "Concrete field shouldn\'t be value object: %s", var4);
            HashMap var5;
            if(var1.method_3880()) {
                var5 = this.method_1699();
            } else {
                var5 = this.method_1698();
            }

            if(var5 != null) {
                return var5.get(var2);
            } else {
                try {
                    String var7 = "get" + Character.toUpperCase(var2.charAt(0)) + var2.substring(1);
                    Object var8 = this.getClass().getMethod(var7, new Class[0]).invoke(this, new Object[0]);
                    return var8;
                } catch (Exception var9) {
                    throw new RuntimeException(var9);
                }
            }
        } else {
            return this.method_1693(var1.method_3881());
        }
    }

    // $FF: renamed from: ba (java.lang.String) java.lang.Object
    protected abstract Object method_1693(String var1);

    // $FF: renamed from: bb (java.lang.String) boolean
    protected abstract boolean method_1694(String var1);

    // $FF: renamed from: bc (java.lang.String) boolean
    protected boolean method_1695(String var1) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    // $FF: renamed from: bd (java.lang.String) boolean
    protected boolean method_1696(String var1) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    // $FF: renamed from: hf () java.util.HashMap
    public abstract HashMap<String, class_268.class_1299<?, ?>> method_1697();

    // $FF: renamed from: hg () java.util.HashMap
    public HashMap<String, Object> method_1698() {
        return null;
    }

    // $FF: renamed from: hh () java.util.HashMap
    public HashMap<String, Object> method_1699() {
        return null;
    }

    public String toString() {
        HashMap var1 = this.method_1697();
        StringBuilder var2 = new StringBuilder(100);
        Iterator var3 = var1.keySet().iterator();

        while(var3.hasNext()) {
            String var6 = (String)var3.next();
            class_268.class_1299 var7 = (class_268.class_1299)var1.get(var6);
            if(this.method_1691(var7)) {
                Object var8 = this.method_1690(var7, this.method_1692(var7));
                if(var2.length() == 0) {
                    var2.append("{");
                } else {
                    var2.append(",");
                }

                var2.append("\"").append(var6).append("\":");
                if(var8 == null) {
                    var2.append("null");
                } else {
                    switch(var7.method_3877()) {
                        case 8:
                            var2.append("\"").append(class_350.method_2344((byte[])((byte[])var8))).append("\"");
                            break;
                        case 9:
                            var2.append("\"").append(class_350.method_2345((byte[])((byte[])var8))).append("\"");
                            break;
                        case 10:
                            class_340.method_2314(var2, (HashMap)var8);
                            break;
                        default:
                            if(var7.method_3879()) {
                                this.method_1689(var2, var7, (ArrayList)var8);
                            } else {
                                this.method_1688(var2, var7, var8);
                            }
                    }
                }
            }
        }

        if(var2.length() > 0) {
            var2.append("}");
        } else {
            var2.append("{}");
        }

        return var2.toString();
    }

    public static class class_1299<I, O> implements SafeParcelable {
        public static final class_356 CREATOR = new class_356();
        // $FF: renamed from: BR int
        private final int field_3422;
        // $FF: renamed from: MA int
        protected final int field_3423;
        // $FF: renamed from: MB boolean
        protected final boolean field_3424;
        // $FF: renamed from: MC java.lang.String
        protected final String field_3425;
        // $FF: renamed from: MD int
        protected final int field_3426;
        // $FF: renamed from: ME java.lang.Class
        protected final Class<? extends ji> field_3427;
        // $FF: renamed from: MF java.lang.String
        protected final String field_3428;
        // $FF: renamed from: MG com.google.android.gms.internal.jm
        private class_354 field_3429;
        // $FF: renamed from: MH com.google.android.gms.internal.ji$b
        private class_268.class_1300<I, O> field_3430;
        // $FF: renamed from: My int
        protected final int field_3431;
        // $FF: renamed from: Mz boolean
        protected final boolean field_3432;

        class_1299(int var1, int var2, boolean var3, int var4, boolean var5, String var6, int var7, String var8, class_361 var9) {
            this.field_3422 = var1;
            this.field_3431 = var2;
            this.field_3432 = var3;
            this.field_3423 = var4;
            this.field_3424 = var5;
            this.field_3425 = var6;
            this.field_3426 = var7;
            if(var8 == null) {
                this.field_3427 = null;
                this.field_3428 = null;
            } else {
                this.field_3427 = jp.class;
                this.field_3428 = var8;
            }

            if(var9 == null) {
                this.field_3430 = null;
            } else {
                this.field_3430 = var9.method_2389();
            }
        }

        protected class_1299(int var1, boolean var2, int var3, boolean var4, String var5, int var6, Class<? extends ji> var7, class_268.class_1300<I, O> var8) {
            this.field_3422 = 1;
            this.field_3431 = var1;
            this.field_3432 = var2;
            this.field_3423 = var3;
            this.field_3424 = var4;
            this.field_3425 = var5;
            this.field_3426 = var6;
            this.field_3427 = var7;
            if(var7 == null) {
                this.field_3428 = null;
            } else {
                this.field_3428 = var7.getCanonicalName();
            }

            this.field_3430 = var8;
        }

        // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.internal.ji$b, boolean) com.google.android.gms.internal.ji$a
        public static class_268.class_1299 method_3866(String var0, int var1, class_268.class_1300<?, ?> var2, boolean var3) {
            return new class_268.class_1299(var2.method_378(), var3, var2.method_379(), false, var0, var1, (Class)null, var2);
        }

        // $FF: renamed from: a (java.lang.String, int, java.lang.Class) com.google.android.gms.internal.ji$a
        public static <T extends ji> class_268.class_1299<T, T> method_3867(String var0, int var1, Class<T> var2) {
            return new class_268.class_1299(11, false, 11, false, var0, var1, var2, (class_268.class_1300)null);
        }

        // $FF: renamed from: b (java.lang.String, int, java.lang.Class) com.google.android.gms.internal.ji$a
        public static <T extends ji> class_268.class_1299<ArrayList<T>, ArrayList<T>> method_3868(String var0, int var1, Class<T> var2) {
            return new class_268.class_1299(11, true, 11, true, var0, var1, var2, (class_268.class_1300)null);
        }

        // $FF: renamed from: i (java.lang.String, int) com.google.android.gms.internal.ji$a
        public static class_268.class_1299<Integer, Integer> method_3870(String var0, int var1) {
            return new class_268.class_1299(0, false, 0, false, var0, var1, (Class)null, (class_268.class_1300)null);
        }

        // $FF: renamed from: j (java.lang.String, int) com.google.android.gms.internal.ji$a
        public static class_268.class_1299<Double, Double> method_3871(String var0, int var1) {
            return new class_268.class_1299(4, false, 4, false, var0, var1, (Class)null, (class_268.class_1300)null);
        }

        // $FF: renamed from: k (java.lang.String, int) com.google.android.gms.internal.ji$a
        public static class_268.class_1299<Boolean, Boolean> method_3872(String var0, int var1) {
            return new class_268.class_1299(6, false, 6, false, var0, var1, (Class)null, (class_268.class_1300)null);
        }

        // $FF: renamed from: l (java.lang.String, int) com.google.android.gms.internal.ji$a
        public static class_268.class_1299<String, String> method_3873(String var0, int var1) {
            return new class_268.class_1299(7, false, 7, false, var0, var1, (Class)null, (class_268.class_1300)null);
        }

        // $FF: renamed from: m (java.lang.String, int) com.google.android.gms.internal.ji$a
        public static class_268.class_1299<ArrayList<String>, ArrayList<String>> method_3874(String var0, int var1) {
            return new class_268.class_1299(7, true, 7, true, var0, var1, (Class)null, (class_268.class_1300)null);
        }

        // $FF: renamed from: a (com.google.android.gms.internal.jm) void
        public void method_3875(class_354 var1) {
            this.field_3429 = var1;
        }

        public I convertBack(O var1) {
            return this.field_3430.convertBack(var1);
        }

        public int describeContents() {
            class_356 var10000 = CREATOR;
            return 0;
        }

        public int getVersionCode() {
            return this.field_3422;
        }

        // $FF: renamed from: hd () int
        public int method_3876() {
            return this.field_3431;
        }

        // $FF: renamed from: he () int
        public int method_3877() {
            return this.field_3423;
        }

        // $FF: renamed from: hi () com.google.android.gms.internal.ji$a
        public class_268.class_1299<I, O> method_3878() {
            return new class_268.class_1299(this.field_3422, this.field_3431, this.field_3432, this.field_3423, this.field_3424, this.field_3425, this.field_3426, this.field_3428, this.method_3886());
        }

        // $FF: renamed from: hj () boolean
        public boolean method_3879() {
            return this.field_3432;
        }

        // $FF: renamed from: hk () boolean
        public boolean method_3880() {
            return this.field_3424;
        }

        // $FF: renamed from: hl () java.lang.String
        public String method_3881() {
            return this.field_3425;
        }

        // $FF: renamed from: hm () int
        public int method_3882() {
            return this.field_3426;
        }

        // $FF: renamed from: hn () java.lang.Class
        public Class<? extends ji> method_3883() {
            return this.field_3427;
        }

        // $FF: renamed from: ho () java.lang.String
        String method_3884() {
            return this.field_3428 == null?null:this.field_3428;
        }

        // $FF: renamed from: hp () boolean
        public boolean method_3885() {
            return this.field_3430 != null;
        }

        // $FF: renamed from: hq () com.google.android.gms.internal.jd
        class_361 method_3886() {
            return this.field_3430 == null?null:class_361.method_2387(this.field_3430);
        }

        // $FF: renamed from: hr () java.util.HashMap
        public HashMap<String, class_268.class_1299<?, ?>> method_3887() {
            class_1090.method_5685(this.field_3428);
            class_1090.method_5685(this.field_3429);
            return this.field_3429.method_2359(this.field_3428);
        }

        public String toString() {
            StringBuilder var1 = new StringBuilder();
            var1.append("Field\n");
            var1.append("            versionCode=").append(this.field_3422).append('\n');
            var1.append("                 typeIn=").append(this.field_3431).append('\n');
            var1.append("            typeInArray=").append(this.field_3432).append('\n');
            var1.append("                typeOut=").append(this.field_3423).append('\n');
            var1.append("           typeOutArray=").append(this.field_3424).append('\n');
            var1.append("        outputFieldName=").append(this.field_3425).append('\n');
            var1.append("      safeParcelFieldId=").append(this.field_3426).append('\n');
            var1.append("       concreteTypeName=").append(this.method_3884()).append('\n');
            if(this.method_3883() != null) {
                var1.append("     concreteType.class=").append(this.method_3883().getCanonicalName()).append('\n');
            }

            StringBuilder var11 = var1.append("          converterName=");
            String var12;
            if(this.field_3430 == null) {
                var12 = "null";
            } else {
                var12 = this.field_3430.getClass().getCanonicalName();
            }

            var11.append(var12).append('\n');
            return var1.toString();
        }

        public void writeToParcel(Parcel var1, int var2) {
            class_356 var10000 = CREATOR;
            class_356.method_2371(this, var1, var2);
        }
    }

    public interface class_1300<I, O> {
        I convertBack(O var1);

        // $FF: renamed from: hd () int
        int method_378();

        // $FF: renamed from: he () int
        int method_379();
    }
}
