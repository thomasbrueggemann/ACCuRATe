package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_899;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.ol
public interface class_167 {
    public static final class class_1513 extends ph<class_167.class_1513> {
        public long asr;
        public class_51.class_1320 ass;
        // $FF: renamed from: gs com.google.android.gms.internal.c$f
        public class_51.class_1327 field_952;

        public class_1513() {
            this.method_2126();
        }

        // $FF: renamed from: l (byte[]) com.google.android.gms.internal.ol$a
        public static class_167.class_1513 method_2124(byte[] var0) throws class_899 {
            return (class_167.class_1513)class_307.method_2108(new class_167.class_1513(), var0);
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            var1.method_4709(1, this.asr);
            if(this.field_952 != null) {
                var1.method_4705(2, this.field_952);
            }

            if(this.ass != null) {
                var1.method_4705(3, this.ass);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2125(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114() + class_909.method_4682(1, this.asr);
            if(this.field_952 != null) {
                var1 += class_909.method_4680(2, this.field_952);
            }

            if(this.ass != null) {
                var1 += class_909.method_4680(3, this.ass);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_167.class_1513;
                var3 = false;
                if(var2) {
                    class_167.class_1513 var4 = (class_167.class_1513)var1;
                    long var8;
                    int var5 = (var8 = this.asr - var4.asr) == 0L?0:(var8 < 0L?-1:1);
                    var3 = false;
                    if(var5 == 0) {
                        if(this.field_952 == null) {
                            class_51.class_1327 var7 = var4.field_952;
                            var3 = false;
                            if(var7 != null) {
                                return var3;
                            }
                        } else if(!this.field_952.equals(var4.field_952)) {
                            return false;
                        }

                        if(this.ass == null) {
                            class_51.class_1320 var6 = var4.ass;
                            var3 = false;
                            if(var6 != null) {
                                return var3;
                            }
                        } else if(!this.ass.equals(var4.ass)) {
                            return false;
                        }

                        return this.a(var4);
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (527 + (int)(this.asr ^ this.asr >>> 32));
            int var2;
            if(this.field_952 == null) {
                var2 = 0;
            } else {
                var2 = this.field_952.hashCode();
            }

            int var3 = 31 * (var2 + var1);
            class_51.class_1320 var4 = this.ass;
            int var5 = 0;
            if(var4 != null) {
                var5 = this.ass.hashCode();
            }

            return 31 * (var3 + var5) + this.qz();
        }

        // $FF: renamed from: p (com.google.android.gms.internal.pf) com.google.android.gms.internal.ol$a
        public class_167.class_1513 method_2125(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 8:
                        this.asr = var1.method_4657();
                        break;
                    case 18:
                        if(this.field_952 == null) {
                            this.field_952 = new class_51.class_1327();
                        }

                        var1.method_4646(this.field_952);
                        break;
                    case 26:
                        if(this.ass == null) {
                            this.ass = new class_51.class_1320();
                        }

                        var1.method_4646(this.ass);
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

        // $FF: renamed from: pL () com.google.android.gms.internal.ol$a
        public class_167.class_1513 method_2126() {
            this.asr = 0L;
            this.field_952 = null;
            this.ass = null;
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }
}
