package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_900;
import com.google.android.gms.internal.class_905;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.ll
public interface class_145 {
    public static final class class_1538 extends ph<class_145.class_1538> {
        public class_145.class_1539[] adE;

        public class_1538() {
            this.method_2136();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.adE != null && this.adE.length > 0) {
                for(int var2 = 0; var2 < this.adE.length; ++var2) {
                    class_145.class_1539 var3 = this.adE[var2];
                    if(var3 != null) {
                        var1.method_4705(1, var3);
                    }
                }
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2137(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(this.adE != null && this.adE.length > 0) {
                for(int var2 = 0; var2 < this.adE.length; ++var2) {
                    class_145.class_1539 var3 = this.adE[var2];
                    if(var3 != null) {
                        var1 += class_909.method_4680(1, var3);
                    }
                }
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_145.class_1538;
                var3 = false;
                if(var2) {
                    class_145.class_1538 var4 = (class_145.class_1538)var1;
                    boolean var5 = class_900.equals((Object[])this.adE, (Object[])var4.adE);
                    var3 = false;
                    if(var5) {
                        return this.a(var4);
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            return 31 * (527 + class_900.hashCode((Object[])this.adE)) + this.qz();
        }

        // $FF: renamed from: lP () com.google.android.gms.internal.ll$a
        public class_145.class_1538 method_2136() {
            this.adE = class_145.class_1539.method_2146();
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: n (com.google.android.gms.internal.pf) com.google.android.gms.internal.ll$a
        public class_145.class_1538 method_2137(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var4;
                class_145.class_1539[] var5;
                switch(var2) {
                    case 10:
                        int var3 = class_905.method_4635(var1, 10);
                        if(this.adE == null) {
                            var4 = 0;
                        } else {
                            var4 = this.adE.length;
                        }

                        var5 = new class_145.class_1539[var3 + var4];
                        if(var4 != 0) {
                            System.arraycopy(this.adE, 0, var5, 0, var4);
                        }
                        break;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var4 < -1 + var5.length) {
                    var5[var4] = new class_145.class_1539();
                    var1.method_4646(var5[var4]);
                    var1.method_4655();
                    ++var4;
                }

                var5[var4] = new class_145.class_1539();
                var1.method_4646(var5[var4]);
                this.adE = var5;
            }
        }
    }

    public static final class class_1539 extends ph<class_145.class_1539> {
        private static volatile class_145.class_1539[] adF;
        public String adG;
        public String adH;
        public int viewId;

        public class_1539() {
            this.method_2147();
        }

        // $FF: renamed from: lQ () com.google.android.gms.internal.ll$a$a[]
        public static class_145.class_1539[] method_2146() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(!this.adG.equals("")) {
                var1.method_4710(1, this.adG);
            }

            if(!this.adH.equals("")) {
                var1.method_4710(2, this.adH);
            }

            if(this.viewId != 0) {
                var1.method_4727(3, this.viewId);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2148(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(!this.adG.equals("")) {
                var1 += class_909.method_4694(1, this.adG);
            }

            if(!this.adH.equals("")) {
                var1 += class_909.method_4694(2, this.adH);
            }

            if(this.viewId != 0) {
                var1 += class_909.method_4697(3, this.viewId);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_145.class_1539;
                var3 = false;
                if(var2) {
                    class_145.class_1539 var4 = (class_145.class_1539)var1;
                    if(this.adG == null) {
                        String var8 = var4.adG;
                        var3 = false;
                        if(var8 != null) {
                            return var3;
                        }
                    } else if(!this.adG.equals(var4.adG)) {
                        return false;
                    }

                    if(this.adH == null) {
                        String var7 = var4.adH;
                        var3 = false;
                        if(var7 != null) {
                            return var3;
                        }
                    } else if(!this.adH.equals(var4.adH)) {
                        return false;
                    }

                    int var5 = this.viewId;
                    int var6 = var4.viewId;
                    var3 = false;
                    if(var5 == var6) {
                        return this.a(var4);
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            int var1;
            if(this.adG == null) {
                var1 = 0;
            } else {
                var1 = this.adG.hashCode();
            }

            int var2 = 31 * (var1 + 527);
            String var3 = this.adH;
            int var4 = 0;
            if(var3 != null) {
                var4 = this.adH.hashCode();
            }

            return 31 * (31 * (var2 + var4) + this.viewId) + this.qz();
        }

        // $FF: renamed from: lR () com.google.android.gms.internal.ll$a$a
        public class_145.class_1539 method_2147() {
            this.adG = "";
            this.adH = "";
            this.viewId = 0;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: o (com.google.android.gms.internal.pf) com.google.android.gms.internal.ll$a$a
        public class_145.class_1539 method_2148(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 10:
                        this.adG = var1.readString();
                        break;
                    case 18:
                        this.adH = var1.readString();
                        break;
                    case 24:
                        this.viewId = var1.method_4658();
                        break;
                    default:
                        if(this.a(var1, var2)) {
                            break;
                        }
                    case 0:
                        return this;
                }
            }
        }
    }
}
