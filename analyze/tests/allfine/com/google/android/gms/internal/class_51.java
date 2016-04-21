package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_899;
import com.google.android.gms.internal.class_900;
import com.google.android.gms.internal.class_902;
import com.google.android.gms.internal.class_905;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import com.google.android.gms.internal.pi;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.c
public interface class_51 {
    public static final class class_1334 extends ph<class_51.class_1334> {
        // $FF: renamed from: fn int
        public int field_954;
        // $FF: renamed from: fo int
        public int field_955;
        public int level;

        public class_1334() {
            this.method_2150();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$a
        public class_51.class_1334 method_2149(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 8:
                        int var3 = var1.method_4658();
                        switch(var3) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = var3;
                            default:
                                continue;
                        }
                    case 16:
                        this.field_954 = var1.method_4658();
                        break;
                    case 24:
                        this.field_955 = var1.method_4658();
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

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.level != 1) {
                var1.method_4727(1, this.level);
            }

            if(this.field_954 != 0) {
                var1.method_4727(2, this.field_954);
            }

            if(this.field_955 != 0) {
                var1.method_4727(3, this.field_955);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b () com.google.android.gms.internal.c$a
        public class_51.class_1334 method_2150() {
            this.level = 1;
            this.field_954 = 0;
            this.field_955 = 0;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2149(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(this.level != 1) {
                var1 += class_909.method_4697(1, this.level);
            }

            if(this.field_954 != 0) {
                var1 += class_909.method_4697(2, this.field_954);
            }

            if(this.field_955 != 0) {
                var1 += class_909.method_4697(3, this.field_955);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1334;
                var3 = false;
                if(var2) {
                    class_51.class_1334 var4 = (class_51.class_1334)var1;
                    int var5 = this.level;
                    int var6 = var4.level;
                    var3 = false;
                    if(var5 == var6) {
                        int var7 = this.field_954;
                        int var8 = var4.field_954;
                        var3 = false;
                        if(var7 == var8) {
                            int var9 = this.field_955;
                            int var10 = var4.field_955;
                            var3 = false;
                            if(var9 == var10) {
                                return this.a(var4);
                            }
                        }
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            return 31 * (31 * (31 * (527 + this.level) + this.field_954) + this.field_955) + this.qz();
        }
    }

    public static final class class_1331 extends ph<class_51.class_1331> {
        // $FF: renamed from: fp com.google.android.gms.internal.c$b[]
        private static volatile class_51.class_1331[] field_956;
        // $FF: renamed from: fq int[]
        public int[] field_957;
        // $FF: renamed from: fr int
        public int field_958;
        // $FF: renamed from: fs boolean
        public boolean field_959;
        // $FF: renamed from: ft boolean
        public boolean field_960;
        public int name;

        public class_1331() {
            this.method_2153();
        }

        // $FF: renamed from: d () com.google.android.gms.internal.c$b[]
        public static class_51.class_1331[] method_2151() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.field_960) {
                var1.method_4711(1, this.field_960);
            }

            var1.method_4727(2, this.field_958);
            if(this.field_957 != null && this.field_957.length > 0) {
                for(int var2 = 0; var2 < this.field_957.length; ++var2) {
                    var1.method_4727(3, this.field_957[var2]);
                }
            }

            if(this.name != 0) {
                var1.method_4727(4, this.name);
            }

            if(this.field_959) {
                var1.method_4711(6, this.field_959);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2152(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = 0;
            int var2 = super.method_2114();
            if(this.field_960) {
                var2 += class_909.method_4681(1, this.field_960);
            }

            int var3 = var2 + class_909.method_4697(2, this.field_958);
            int var4;
            if(this.field_957 != null && this.field_957.length > 0) {
                for(int var5 = 0; var5 < this.field_957.length; ++var5) {
                    var1 += class_909.method_4691(this.field_957[var5]);
                }

                var4 = var3 + var1 + 1 * this.field_957.length;
            } else {
                var4 = var3;
            }

            if(this.name != 0) {
                var4 += class_909.method_4697(4, this.name);
            }

            if(this.field_959) {
                var4 += class_909.method_4681(6, this.field_959);
            }

            return var4;
        }

        // $FF: renamed from: c (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$b
        public class_51.class_1331 method_2152(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var10;
                int[] var11;
                switch(var2) {
                    case 8:
                        this.field_960 = var1.method_4659();
                        continue;
                    case 16:
                        this.field_958 = var1.method_4658();
                        continue;
                    case 24:
                        int var9 = class_905.method_4635(var1, 24);
                        if(this.field_957 == null) {
                            var10 = 0;
                        } else {
                            var10 = this.field_957.length;
                        }

                        var11 = new int[var9 + var10];
                        if(var10 != 0) {
                            System.arraycopy(this.field_957, 0, var11, 0, var10);
                        }
                        break;
                    case 26:
                        int var3 = var1.method_4650(var1.method_4662());
                        int var4 = var1.getPosition();

                        int var5;
                        for(var5 = 0; var1.method_4666() > 0; ++var5) {
                            var1.method_4658();
                        }

                        var1.method_4652(var4);
                        int var6;
                        if(this.field_957 == null) {
                            var6 = 0;
                        } else {
                            var6 = this.field_957.length;
                        }

                        int[] var7 = new int[var5 + var6];
                        if(var6 != 0) {
                            System.arraycopy(this.field_957, 0, var7, 0, var6);
                        }

                        while(var6 < var7.length) {
                            var7[var6] = var1.method_4658();
                            ++var6;
                        }

                        this.field_957 = var7;
                        var1.method_4651(var3);
                        continue;
                    case 32:
                        this.name = var1.method_4658();
                        continue;
                    case 48:
                        this.field_959 = var1.method_4659();
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var10 < -1 + var11.length) {
                    var11[var10] = var1.method_4658();
                    var1.method_4655();
                    ++var10;
                }

                var11[var10] = var1.method_4658();
                this.field_957 = var11;
            }
        }

        // $FF: renamed from: e () com.google.android.gms.internal.c$b
        public class_51.class_1331 method_2153() {
            this.field_957 = class_905.awW;
            this.field_958 = 0;
            this.name = 0;
            this.field_959 = false;
            this.field_960 = false;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1331;
                var3 = false;
                if(var2) {
                    class_51.class_1331 var4 = (class_51.class_1331)var1;
                    boolean var5 = class_900.equals(this.field_957, var4.field_957);
                    var3 = false;
                    if(var5) {
                        int var6 = this.field_958;
                        int var7 = var4.field_958;
                        var3 = false;
                        if(var6 == var7) {
                            int var8 = this.name;
                            int var9 = var4.name;
                            var3 = false;
                            if(var8 == var9) {
                                boolean var10 = this.field_959;
                                boolean var11 = var4.field_959;
                                var3 = false;
                                if(var10 == var11) {
                                    boolean var12 = this.field_960;
                                    boolean var13 = var4.field_960;
                                    var3 = false;
                                    if(var12 == var13) {
                                        return this.a(var4);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            short var1 = 1231;
            int var2 = 31 * (31 * (31 * (527 + class_900.hashCode(this.field_957)) + this.field_958) + this.name);
            short var3;
            if(this.field_959) {
                var3 = var1;
            } else {
                var3 = 1237;
            }

            int var4 = 31 * (var3 + var2);
            if(!this.field_960) {
                var1 = 1237;
            }

            return 31 * (var4 + var1) + this.qz();
        }
    }

    public static final class class_1330 extends ph<class_51.class_1330> {
        // $FF: renamed from: fu com.google.android.gms.internal.c$c[]
        private static volatile class_51.class_1330[] field_961;
        // $FF: renamed from: fv java.lang.String
        public String field_962;
        // $FF: renamed from: fw long
        public long field_963;
        // $FF: renamed from: fx long
        public long field_964;
        // $FF: renamed from: fy boolean
        public boolean field_965;
        // $FF: renamed from: fz long
        public long field_966;

        public class_1330() {
            this.method_2156();
        }

        // $FF: renamed from: f () com.google.android.gms.internal.c$c[]
        public static class_51.class_1330[] method_2154() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(!this.field_962.equals("")) {
                var1.method_4710(1, this.field_962);
            }

            if(this.field_963 != 0L) {
                var1.method_4709(2, this.field_963);
            }

            if(this.field_964 != 2147483647L) {
                var1.method_4709(3, this.field_964);
            }

            if(this.field_965) {
                var1.method_4711(4, this.field_965);
            }

            if(this.field_966 != 0L) {
                var1.method_4709(5, this.field_966);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2155(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(!this.field_962.equals("")) {
                var1 += class_909.method_4694(1, this.field_962);
            }

            if(this.field_963 != 0L) {
                var1 += class_909.method_4682(2, this.field_963);
            }

            if(this.field_964 != 2147483647L) {
                var1 += class_909.method_4682(3, this.field_964);
            }

            if(this.field_965) {
                var1 += class_909.method_4681(4, this.field_965);
            }

            if(this.field_966 != 0L) {
                var1 += class_909.method_4682(5, this.field_966);
            }

            return var1;
        }

        // $FF: renamed from: d (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$c
        public class_51.class_1330 method_2155(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 10:
                        this.field_962 = var1.readString();
                        break;
                    case 16:
                        this.field_963 = var1.method_4657();
                        break;
                    case 24:
                        this.field_964 = var1.method_4657();
                        break;
                    case 32:
                        this.field_965 = var1.method_4659();
                        break;
                    case 40:
                        this.field_966 = var1.method_4657();
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

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1330;
                var3 = false;
                if(var2) {
                    class_51.class_1330 var4 = (class_51.class_1330)var1;
                    if(this.field_962 == null) {
                        String var10 = var4.field_962;
                        var3 = false;
                        if(var10 != null) {
                            return var3;
                        }
                    } else if(!this.field_962.equals(var4.field_962)) {
                        return false;
                    }

                    long var11;
                    int var5 = (var11 = this.field_963 - var4.field_963) == 0L?0:(var11 < 0L?-1:1);
                    var3 = false;
                    if(var5 == 0) {
                        long var12;
                        int var6 = (var12 = this.field_964 - var4.field_964) == 0L?0:(var12 < 0L?-1:1);
                        var3 = false;
                        if(var6 == 0) {
                            boolean var7 = this.field_965;
                            boolean var8 = var4.field_965;
                            var3 = false;
                            if(var7 == var8) {
                                long var13;
                                int var9 = (var13 = this.field_966 - var4.field_966) == 0L?0:(var13 < 0L?-1:1);
                                var3 = false;
                                if(var9 == 0) {
                                    return this.a(var4);
                                }
                            }
                        }
                    }
                }
            }

            return var3;
        }

        // $FF: renamed from: g () com.google.android.gms.internal.c$c
        public class_51.class_1330 method_2156() {
            this.field_962 = "";
            this.field_963 = 0L;
            this.field_964 = 2147483647L;
            this.field_965 = false;
            this.field_966 = 0L;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        public int hashCode() {
            int var1;
            if(this.field_962 == null) {
                var1 = 0;
            } else {
                var1 = this.field_962.hashCode();
            }

            int var2 = 31 * (31 * (31 * (var1 + 527) + (int)(this.field_963 ^ this.field_963 >>> 32)) + (int)(this.field_964 ^ this.field_964 >>> 32));
            short var3;
            if(this.field_965) {
                var3 = 1231;
            } else {
                var3 = 1237;
            }

            return 31 * (31 * (var3 + var2) + (int)(this.field_966 ^ this.field_966 >>> 32)) + this.qz();
        }
    }

    public static final class class_1329 extends ph<class_51.class_1329> {
        // $FF: renamed from: fA com.google.android.gms.internal.d$a[]
        public class_53.class_1172[] field_967;
        // $FF: renamed from: fB com.google.android.gms.internal.d$a[]
        public class_53.class_1172[] field_968;
        // $FF: renamed from: fC com.google.android.gms.internal.c$c[]
        public class_51.class_1330[] field_969;

        public class_1329() {
            this.method_2158();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.field_967 != null && this.field_967.length > 0) {
                for(int var7 = 0; var7 < this.field_967.length; ++var7) {
                    class_53.class_1172 var8 = this.field_967[var7];
                    if(var8 != null) {
                        var1.method_4705(1, var8);
                    }
                }
            }

            if(this.field_968 != null && this.field_968.length > 0) {
                for(int var5 = 0; var5 < this.field_968.length; ++var5) {
                    class_53.class_1172 var6 = this.field_968[var5];
                    if(var6 != null) {
                        var1.method_4705(2, var6);
                    }
                }
            }

            if(this.field_969 != null) {
                int var2 = this.field_969.length;
                int var3 = 0;
                if(var2 > 0) {
                    for(; var3 < this.field_969.length; ++var3) {
                        class_51.class_1330 var4 = this.field_969[var3];
                        if(var4 != null) {
                            var1.method_4705(3, var4);
                        }
                    }
                }
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2157(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(this.field_967 != null && this.field_967.length > 0) {
                int var8 = var1;

                for(int var9 = 0; var9 < this.field_967.length; ++var9) {
                    class_53.class_1172 var10 = this.field_967[var9];
                    if(var10 != null) {
                        var8 += class_909.method_4680(1, var10);
                    }
                }

                var1 = var8;
            }

            if(this.field_968 != null && this.field_968.length > 0) {
                int var5 = var1;

                for(int var6 = 0; var6 < this.field_968.length; ++var6) {
                    class_53.class_1172 var7 = this.field_968[var6];
                    if(var7 != null) {
                        var5 += class_909.method_4680(2, var7);
                    }
                }

                var1 = var5;
            }

            if(this.field_969 != null) {
                int var2 = this.field_969.length;
                int var3 = 0;
                if(var2 > 0) {
                    for(; var3 < this.field_969.length; ++var3) {
                        class_51.class_1330 var4 = this.field_969[var3];
                        if(var4 != null) {
                            var1 += class_909.method_4680(3, var4);
                        }
                    }
                }
            }

            return var1;
        }

        // $FF: renamed from: e (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$d
        public class_51.class_1329 method_2157(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var12;
                class_53.class_1172[] var13;
                switch(var2) {
                    case 10:
                        int var11 = class_905.method_4635(var1, 10);
                        if(this.field_967 == null) {
                            var12 = 0;
                        } else {
                            var12 = this.field_967.length;
                        }

                        var13 = new class_53.class_1172[var11 + var12];
                        if(var12 != 0) {
                            System.arraycopy(this.field_967, 0, var13, 0, var12);
                        }
                        break;
                    case 18:
                        int var7 = class_905.method_4635(var1, 18);
                        int var8;
                        if(this.field_968 == null) {
                            var8 = 0;
                        } else {
                            var8 = this.field_968.length;
                        }

                        class_53.class_1172[] var9 = new class_53.class_1172[var7 + var8];
                        if(var8 != 0) {
                            System.arraycopy(this.field_968, 0, var9, 0, var8);
                        }

                        while(var8 < -1 + var9.length) {
                            var9[var8] = new class_53.class_1172();
                            var1.method_4646(var9[var8]);
                            var1.method_4655();
                            ++var8;
                        }

                        var9[var8] = new class_53.class_1172();
                        var1.method_4646(var9[var8]);
                        this.field_968 = var9;
                        continue;
                    case 26:
                        int var3 = class_905.method_4635(var1, 26);
                        int var4;
                        if(this.field_969 == null) {
                            var4 = 0;
                        } else {
                            var4 = this.field_969.length;
                        }

                        class_51.class_1330[] var5 = new class_51.class_1330[var3 + var4];
                        if(var4 != 0) {
                            System.arraycopy(this.field_969, 0, var5, 0, var4);
                        }

                        while(var4 < -1 + var5.length) {
                            var5[var4] = new class_51.class_1330();
                            var1.method_4646(var5[var4]);
                            var1.method_4655();
                            ++var4;
                        }

                        var5[var4] = new class_51.class_1330();
                        var1.method_4646(var5[var4]);
                        this.field_969 = var5;
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var12 < -1 + var13.length) {
                    var13[var12] = new class_53.class_1172();
                    var1.method_4646(var13[var12]);
                    var1.method_4655();
                    ++var12;
                }

                var13[var12] = new class_53.class_1172();
                var1.method_4646(var13[var12]);
                this.field_967 = var13;
            }
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1329;
                var3 = false;
                if(var2) {
                    class_51.class_1329 var4 = (class_51.class_1329)var1;
                    boolean var5 = class_900.equals((Object[])this.field_967, (Object[])var4.field_967);
                    var3 = false;
                    if(var5) {
                        boolean var6 = class_900.equals((Object[])this.field_968, (Object[])var4.field_968);
                        var3 = false;
                        if(var6) {
                            boolean var7 = class_900.equals((Object[])this.field_969, (Object[])var4.field_969);
                            var3 = false;
                            if(var7) {
                                return this.a(var4);
                            }
                        }
                    }
                }
            }

            return var3;
        }

        // $FF: renamed from: h () com.google.android.gms.internal.c$d
        public class_51.class_1329 method_2158() {
            this.field_967 = class_53.class_1172.method_2179();
            this.field_968 = class_53.class_1172.method_2179();
            this.field_969 = class_51.class_1330.method_2154();
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        public int hashCode() {
            return 31 * (31 * (31 * (527 + class_900.hashCode((Object[])this.field_967)) + class_900.hashCode((Object[])this.field_968)) + class_900.hashCode((Object[])this.field_969)) + this.qz();
        }
    }

    public static final class class_1328 extends ph<class_51.class_1328> {
        // $FF: renamed from: fD com.google.android.gms.internal.c$e[]
        private static volatile class_51.class_1328[] field_970;
        public int key;
        public int value;

        public class_1328() {
            this.method_2161();
        }

        // $FF: renamed from: i () com.google.android.gms.internal.c$e[]
        public static class_51.class_1328[] method_2159() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            var1.method_4727(1, this.key);
            var1.method_4727(2, this.value);
            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2160(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            return super.method_2114() + class_909.method_4697(1, this.key) + class_909.method_4697(2, this.value);
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1328;
                var3 = false;
                if(var2) {
                    class_51.class_1328 var4 = (class_51.class_1328)var1;
                    int var5 = this.key;
                    int var6 = var4.key;
                    var3 = false;
                    if(var5 == var6) {
                        int var7 = this.value;
                        int var8 = var4.value;
                        var3 = false;
                        if(var7 == var8) {
                            return this.a(var4);
                        }
                    }
                }
            }

            return var3;
        }

        // $FF: renamed from: f (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$e
        public class_51.class_1328 method_2160(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 8:
                        this.key = var1.method_4658();
                        break;
                    case 16:
                        this.value = var1.method_4658();
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

        public int hashCode() {
            return 31 * (31 * (527 + this.key) + this.value) + this.qz();
        }

        // $FF: renamed from: j () com.google.android.gms.internal.c$e
        public class_51.class_1328 method_2161() {
            this.key = 0;
            this.value = 0;
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }

    public static final class class_1327 extends ph<class_51.class_1327> {
        // $FF: renamed from: fE java.lang.String[]
        public String[] field_971;
        // $FF: renamed from: fF java.lang.String[]
        public String[] field_972;
        // $FF: renamed from: fG com.google.android.gms.internal.d$a[]
        public class_53.class_1172[] field_973;
        // $FF: renamed from: fH com.google.android.gms.internal.c$e[]
        public class_51.class_1328[] field_974;
        // $FF: renamed from: fI com.google.android.gms.internal.c$b[]
        public class_51.class_1331[] field_975;
        // $FF: renamed from: fJ com.google.android.gms.internal.c$b[]
        public class_51.class_1331[] field_976;
        // $FF: renamed from: fK com.google.android.gms.internal.c$b[]
        public class_51.class_1331[] field_977;
        // $FF: renamed from: fL com.google.android.gms.internal.c$g[]
        public class_51.class_1326[] field_978;
        // $FF: renamed from: fM java.lang.String
        public String field_979;
        // $FF: renamed from: fN java.lang.String
        public String field_980;
        // $FF: renamed from: fO java.lang.String
        public String field_981;
        // $FF: renamed from: fP com.google.android.gms.internal.c$a
        public class_51.class_1334 field_982;
        // $FF: renamed from: fQ float
        public float field_983;
        // $FF: renamed from: fR boolean
        public boolean field_984;
        // $FF: renamed from: fS java.lang.String[]
        public String[] field_985;
        // $FF: renamed from: fT int
        public int field_986;
        public String version;

        public class_1327() {
            this.method_2164();
        }

        // $FF: renamed from: a (byte[]) com.google.android.gms.internal.c$f
        public static class_51.class_1327 method_2162(byte[] var0) throws class_899 {
            return (class_51.class_1327)class_307.method_2108(new class_51.class_1327(), var0);
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.field_972 != null && this.field_972.length > 0) {
                for(int var19 = 0; var19 < this.field_972.length; ++var19) {
                    String var20 = this.field_972[var19];
                    if(var20 != null) {
                        var1.method_4710(1, var20);
                    }
                }
            }

            if(this.field_973 != null && this.field_973.length > 0) {
                for(int var17 = 0; var17 < this.field_973.length; ++var17) {
                    class_53.class_1172 var18 = this.field_973[var17];
                    if(var18 != null) {
                        var1.method_4705(2, var18);
                    }
                }
            }

            if(this.field_974 != null && this.field_974.length > 0) {
                for(int var15 = 0; var15 < this.field_974.length; ++var15) {
                    class_51.class_1328 var16 = this.field_974[var15];
                    if(var16 != null) {
                        var1.method_4705(3, var16);
                    }
                }
            }

            if(this.field_975 != null && this.field_975.length > 0) {
                for(int var13 = 0; var13 < this.field_975.length; ++var13) {
                    class_51.class_1331 var14 = this.field_975[var13];
                    if(var14 != null) {
                        var1.method_4705(4, var14);
                    }
                }
            }

            if(this.field_976 != null && this.field_976.length > 0) {
                for(int var11 = 0; var11 < this.field_976.length; ++var11) {
                    class_51.class_1331 var12 = this.field_976[var11];
                    if(var12 != null) {
                        var1.method_4705(5, var12);
                    }
                }
            }

            if(this.field_977 != null && this.field_977.length > 0) {
                for(int var9 = 0; var9 < this.field_977.length; ++var9) {
                    class_51.class_1331 var10 = this.field_977[var9];
                    if(var10 != null) {
                        var1.method_4705(6, var10);
                    }
                }
            }

            if(this.field_978 != null && this.field_978.length > 0) {
                for(int var7 = 0; var7 < this.field_978.length; ++var7) {
                    class_51.class_1326 var8 = this.field_978[var7];
                    if(var8 != null) {
                        var1.method_4705(7, var8);
                    }
                }
            }

            if(!this.field_979.equals("")) {
                var1.method_4710(9, this.field_979);
            }

            if(!this.field_980.equals("")) {
                var1.method_4710(10, this.field_980);
            }

            if(!this.field_981.equals("0")) {
                var1.method_4710(12, this.field_981);
            }

            if(!this.version.equals("")) {
                var1.method_4710(13, this.version);
            }

            if(this.field_982 != null) {
                var1.method_4705(14, this.field_982);
            }

            if(Float.floatToIntBits(this.field_983) != Float.floatToIntBits(0.0F)) {
                var1.method_4708(15, this.field_983);
            }

            if(this.field_985 != null && this.field_985.length > 0) {
                for(int var5 = 0; var5 < this.field_985.length; ++var5) {
                    String var6 = this.field_985[var5];
                    if(var6 != null) {
                        var1.method_4710(16, var6);
                    }
                }
            }

            if(this.field_986 != 0) {
                var1.method_4727(17, this.field_986);
            }

            if(this.field_984) {
                var1.method_4711(18, this.field_984);
            }

            if(this.field_971 != null) {
                int var2 = this.field_971.length;
                int var3 = 0;
                if(var2 > 0) {
                    for(; var3 < this.field_971.length; ++var3) {
                        String var4 = this.field_971[var3];
                        if(var4 != null) {
                            var1.method_4710(19, var4);
                        }
                    }
                }
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2163(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = 0;
            int var2 = super.method_2114();
            int var3;
            if(this.field_972 != null && this.field_972.length > 0) {
                int var29 = 0;
                int var30 = 0;

                int var31;
                for(var31 = 0; var29 < this.field_972.length; ++var29) {
                    String var32 = this.field_972[var29];
                    if(var32 != null) {
                        ++var31;
                        var30 += class_909.method_4684(var32);
                    }
                }

                var3 = var2 + var30 + var31 * 1;
            } else {
                var3 = var2;
            }

            if(this.field_973 != null && this.field_973.length > 0) {
                int var26 = var3;

                for(int var27 = 0; var27 < this.field_973.length; ++var27) {
                    class_53.class_1172 var28 = this.field_973[var27];
                    if(var28 != null) {
                        var26 += class_909.method_4680(2, var28);
                    }
                }

                var3 = var26;
            }

            if(this.field_974 != null && this.field_974.length > 0) {
                int var23 = var3;

                for(int var24 = 0; var24 < this.field_974.length; ++var24) {
                    class_51.class_1328 var25 = this.field_974[var24];
                    if(var25 != null) {
                        var23 += class_909.method_4680(3, var25);
                    }
                }

                var3 = var23;
            }

            if(this.field_975 != null && this.field_975.length > 0) {
                int var20 = var3;

                for(int var21 = 0; var21 < this.field_975.length; ++var21) {
                    class_51.class_1331 var22 = this.field_975[var21];
                    if(var22 != null) {
                        var20 += class_909.method_4680(4, var22);
                    }
                }

                var3 = var20;
            }

            if(this.field_976 != null && this.field_976.length > 0) {
                int var17 = var3;

                for(int var18 = 0; var18 < this.field_976.length; ++var18) {
                    class_51.class_1331 var19 = this.field_976[var18];
                    if(var19 != null) {
                        var17 += class_909.method_4680(5, var19);
                    }
                }

                var3 = var17;
            }

            if(this.field_977 != null && this.field_977.length > 0) {
                int var14 = var3;

                for(int var15 = 0; var15 < this.field_977.length; ++var15) {
                    class_51.class_1331 var16 = this.field_977[var15];
                    if(var16 != null) {
                        var14 += class_909.method_4680(6, var16);
                    }
                }

                var3 = var14;
            }

            if(this.field_978 != null && this.field_978.length > 0) {
                int var11 = var3;

                for(int var12 = 0; var12 < this.field_978.length; ++var12) {
                    class_51.class_1326 var13 = this.field_978[var12];
                    if(var13 != null) {
                        var11 += class_909.method_4680(7, var13);
                    }
                }

                var3 = var11;
            }

            if(!this.field_979.equals("")) {
                var3 += class_909.method_4694(9, this.field_979);
            }

            if(!this.field_980.equals("")) {
                var3 += class_909.method_4694(10, this.field_980);
            }

            if(!this.field_981.equals("0")) {
                var3 += class_909.method_4694(12, this.field_981);
            }

            if(!this.version.equals("")) {
                var3 += class_909.method_4694(13, this.version);
            }

            if(this.field_982 != null) {
                var3 += class_909.method_4680(14, this.field_982);
            }

            if(Float.floatToIntBits(this.field_983) != Float.floatToIntBits(0.0F)) {
                var3 += class_909.method_4679(15, this.field_983);
            }

            if(this.field_985 != null && this.field_985.length > 0) {
                int var7 = 0;
                int var8 = 0;

                int var9;
                for(var9 = 0; var7 < this.field_985.length; ++var7) {
                    String var10 = this.field_985[var7];
                    if(var10 != null) {
                        ++var9;
                        var8 += class_909.method_4684(var10);
                    }
                }

                var3 = var3 + var8 + var9 * 2;
            }

            if(this.field_986 != 0) {
                var3 += class_909.method_4697(17, this.field_986);
            }

            if(this.field_984) {
                var3 += class_909.method_4681(18, this.field_984);
            }

            if(this.field_971 != null && this.field_971.length > 0) {
                int var4 = 0;

                int var5;
                for(var5 = 0; var1 < this.field_971.length; ++var1) {
                    String var6 = this.field_971[var1];
                    if(var6 != null) {
                        ++var5;
                        var4 += class_909.method_4684(var6);
                    }
                }

                var3 = var3 + var4 + var5 * 2;
            }

            return var3;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1327;
                var3 = false;
                if(var2) {
                    class_51.class_1327 var4 = (class_51.class_1327)var1;
                    boolean var5 = class_900.equals((Object[])this.field_971, (Object[])var4.field_971);
                    var3 = false;
                    if(var5) {
                        boolean var6 = class_900.equals((Object[])this.field_972, (Object[])var4.field_972);
                        var3 = false;
                        if(var6) {
                            boolean var7 = class_900.equals((Object[])this.field_973, (Object[])var4.field_973);
                            var3 = false;
                            if(var7) {
                                boolean var8 = class_900.equals((Object[])this.field_974, (Object[])var4.field_974);
                                var3 = false;
                                if(var8) {
                                    boolean var9 = class_900.equals((Object[])this.field_975, (Object[])var4.field_975);
                                    var3 = false;
                                    if(var9) {
                                        boolean var10 = class_900.equals((Object[])this.field_976, (Object[])var4.field_976);
                                        var3 = false;
                                        if(var10) {
                                            boolean var11 = class_900.equals((Object[])this.field_977, (Object[])var4.field_977);
                                            var3 = false;
                                            if(var11) {
                                                boolean var12 = class_900.equals((Object[])this.field_978, (Object[])var4.field_978);
                                                var3 = false;
                                                if(var12) {
                                                    if(this.field_979 == null) {
                                                        String var24 = var4.field_979;
                                                        var3 = false;
                                                        if(var24 != null) {
                                                            return var3;
                                                        }
                                                    } else if(!this.field_979.equals(var4.field_979)) {
                                                        return false;
                                                    }

                                                    if(this.field_980 == null) {
                                                        String var23 = var4.field_980;
                                                        var3 = false;
                                                        if(var23 != null) {
                                                            return var3;
                                                        }
                                                    } else if(!this.field_980.equals(var4.field_980)) {
                                                        return false;
                                                    }

                                                    if(this.field_981 == null) {
                                                        String var22 = var4.field_981;
                                                        var3 = false;
                                                        if(var22 != null) {
                                                            return var3;
                                                        }
                                                    } else if(!this.field_981.equals(var4.field_981)) {
                                                        return false;
                                                    }

                                                    if(this.version == null) {
                                                        String var21 = var4.version;
                                                        var3 = false;
                                                        if(var21 != null) {
                                                            return var3;
                                                        }
                                                    } else if(!this.version.equals(var4.version)) {
                                                        return false;
                                                    }

                                                    if(this.field_982 == null) {
                                                        class_51.class_1334 var20 = var4.field_982;
                                                        var3 = false;
                                                        if(var20 != null) {
                                                            return var3;
                                                        }
                                                    } else if(!this.field_982.equals(var4.field_982)) {
                                                        return false;
                                                    }

                                                    int var13 = Float.floatToIntBits(this.field_983);
                                                    int var14 = Float.floatToIntBits(var4.field_983);
                                                    var3 = false;
                                                    if(var13 == var14) {
                                                        boolean var15 = this.field_984;
                                                        boolean var16 = var4.field_984;
                                                        var3 = false;
                                                        if(var15 == var16) {
                                                            boolean var17 = class_900.equals((Object[])this.field_985, (Object[])var4.field_985);
                                                            var3 = false;
                                                            if(var17) {
                                                                int var18 = this.field_986;
                                                                int var19 = var4.field_986;
                                                                var3 = false;
                                                                if(var18 == var19) {
                                                                    return this.a(var4);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return var3;
        }

        // $FF: renamed from: g (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$f
        public class_51.class_1327 method_2163(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var36;
                String[] var37;
                switch(var2) {
                    case 10:
                        int var35 = class_905.method_4635(var1, 10);
                        if(this.field_972 == null) {
                            var36 = 0;
                        } else {
                            var36 = this.field_972.length;
                        }

                        var37 = new String[var35 + var36];
                        if(var36 != 0) {
                            System.arraycopy(this.field_972, 0, var37, 0, var36);
                        }
                        break;
                    case 18:
                        int var31 = class_905.method_4635(var1, 18);
                        int var32;
                        if(this.field_973 == null) {
                            var32 = 0;
                        } else {
                            var32 = this.field_973.length;
                        }

                        class_53.class_1172[] var33 = new class_53.class_1172[var31 + var32];
                        if(var32 != 0) {
                            System.arraycopy(this.field_973, 0, var33, 0, var32);
                        }

                        while(var32 < -1 + var33.length) {
                            var33[var32] = new class_53.class_1172();
                            var1.method_4646(var33[var32]);
                            var1.method_4655();
                            ++var32;
                        }

                        var33[var32] = new class_53.class_1172();
                        var1.method_4646(var33[var32]);
                        this.field_973 = var33;
                        continue;
                    case 26:
                        int var27 = class_905.method_4635(var1, 26);
                        int var28;
                        if(this.field_974 == null) {
                            var28 = 0;
                        } else {
                            var28 = this.field_974.length;
                        }

                        class_51.class_1328[] var29 = new class_51.class_1328[var27 + var28];
                        if(var28 != 0) {
                            System.arraycopy(this.field_974, 0, var29, 0, var28);
                        }

                        while(var28 < -1 + var29.length) {
                            var29[var28] = new class_51.class_1328();
                            var1.method_4646(var29[var28]);
                            var1.method_4655();
                            ++var28;
                        }

                        var29[var28] = new class_51.class_1328();
                        var1.method_4646(var29[var28]);
                        this.field_974 = var29;
                        continue;
                    case 34:
                        int var23 = class_905.method_4635(var1, 34);
                        int var24;
                        if(this.field_975 == null) {
                            var24 = 0;
                        } else {
                            var24 = this.field_975.length;
                        }

                        class_51.class_1331[] var25 = new class_51.class_1331[var23 + var24];
                        if(var24 != 0) {
                            System.arraycopy(this.field_975, 0, var25, 0, var24);
                        }

                        while(var24 < -1 + var25.length) {
                            var25[var24] = new class_51.class_1331();
                            var1.method_4646(var25[var24]);
                            var1.method_4655();
                            ++var24;
                        }

                        var25[var24] = new class_51.class_1331();
                        var1.method_4646(var25[var24]);
                        this.field_975 = var25;
                        continue;
                    case 42:
                        int var19 = class_905.method_4635(var1, 42);
                        int var20;
                        if(this.field_976 == null) {
                            var20 = 0;
                        } else {
                            var20 = this.field_976.length;
                        }

                        class_51.class_1331[] var21 = new class_51.class_1331[var19 + var20];
                        if(var20 != 0) {
                            System.arraycopy(this.field_976, 0, var21, 0, var20);
                        }

                        while(var20 < -1 + var21.length) {
                            var21[var20] = new class_51.class_1331();
                            var1.method_4646(var21[var20]);
                            var1.method_4655();
                            ++var20;
                        }

                        var21[var20] = new class_51.class_1331();
                        var1.method_4646(var21[var20]);
                        this.field_976 = var21;
                        continue;
                    case 50:
                        int var15 = class_905.method_4635(var1, 50);
                        int var16;
                        if(this.field_977 == null) {
                            var16 = 0;
                        } else {
                            var16 = this.field_977.length;
                        }

                        class_51.class_1331[] var17 = new class_51.class_1331[var15 + var16];
                        if(var16 != 0) {
                            System.arraycopy(this.field_977, 0, var17, 0, var16);
                        }

                        while(var16 < -1 + var17.length) {
                            var17[var16] = new class_51.class_1331();
                            var1.method_4646(var17[var16]);
                            var1.method_4655();
                            ++var16;
                        }

                        var17[var16] = new class_51.class_1331();
                        var1.method_4646(var17[var16]);
                        this.field_977 = var17;
                        continue;
                    case 58:
                        int var11 = class_905.method_4635(var1, 58);
                        int var12;
                        if(this.field_978 == null) {
                            var12 = 0;
                        } else {
                            var12 = this.field_978.length;
                        }

                        class_51.class_1326[] var13 = new class_51.class_1326[var11 + var12];
                        if(var12 != 0) {
                            System.arraycopy(this.field_978, 0, var13, 0, var12);
                        }

                        while(var12 < -1 + var13.length) {
                            var13[var12] = new class_51.class_1326();
                            var1.method_4646(var13[var12]);
                            var1.method_4655();
                            ++var12;
                        }

                        var13[var12] = new class_51.class_1326();
                        var1.method_4646(var13[var12]);
                        this.field_978 = var13;
                        continue;
                    case 74:
                        this.field_979 = var1.readString();
                        continue;
                    case 82:
                        this.field_980 = var1.readString();
                        continue;
                    case 98:
                        this.field_981 = var1.readString();
                        continue;
                    case 106:
                        this.version = var1.readString();
                        continue;
                    case 114:
                        if(this.field_982 == null) {
                            this.field_982 = new class_51.class_1334();
                        }

                        var1.method_4646(this.field_982);
                        continue;
                    case 125:
                        this.field_983 = var1.readFloat();
                        continue;
                    case 130:
                        int var7 = class_905.method_4635(var1, 130);
                        int var8;
                        if(this.field_985 == null) {
                            var8 = 0;
                        } else {
                            var8 = this.field_985.length;
                        }

                        String[] var9 = new String[var7 + var8];
                        if(var8 != 0) {
                            System.arraycopy(this.field_985, 0, var9, 0, var8);
                        }

                        while(var8 < -1 + var9.length) {
                            var9[var8] = var1.readString();
                            var1.method_4655();
                            ++var8;
                        }

                        var9[var8] = var1.readString();
                        this.field_985 = var9;
                        continue;
                    case 136:
                        this.field_986 = var1.method_4658();
                        continue;
                    case 144:
                        this.field_984 = var1.method_4659();
                        continue;
                    case 154:
                        int var3 = class_905.method_4635(var1, 154);
                        int var4;
                        if(this.field_971 == null) {
                            var4 = 0;
                        } else {
                            var4 = this.field_971.length;
                        }

                        String[] var5 = new String[var3 + var4];
                        if(var4 != 0) {
                            System.arraycopy(this.field_971, 0, var5, 0, var4);
                        }

                        while(var4 < -1 + var5.length) {
                            var5[var4] = var1.readString();
                            var1.method_4655();
                            ++var4;
                        }

                        var5[var4] = var1.readString();
                        this.field_971 = var5;
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var36 < -1 + var37.length) {
                    var37[var36] = var1.readString();
                    var1.method_4655();
                    ++var36;
                }

                var37[var36] = var1.readString();
                this.field_972 = var37;
            }
        }

        public int hashCode() {
            int var1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_900.hashCode((Object[])this.field_971)) + class_900.hashCode((Object[])this.field_972)) + class_900.hashCode((Object[])this.field_973)) + class_900.hashCode((Object[])this.field_974)) + class_900.hashCode((Object[])this.field_975)) + class_900.hashCode((Object[])this.field_976)) + class_900.hashCode((Object[])this.field_977)) + class_900.hashCode((Object[])this.field_978));
            int var2;
            if(this.field_979 == null) {
                var2 = 0;
            } else {
                var2 = this.field_979.hashCode();
            }

            int var3 = 31 * (var2 + var1);
            int var4;
            if(this.field_980 == null) {
                var4 = 0;
            } else {
                var4 = this.field_980.hashCode();
            }

            int var5 = 31 * (var4 + var3);
            int var6;
            if(this.field_981 == null) {
                var6 = 0;
            } else {
                var6 = this.field_981.hashCode();
            }

            int var7 = 31 * (var6 + var5);
            int var8;
            if(this.version == null) {
                var8 = 0;
            } else {
                var8 = this.version.hashCode();
            }

            int var9 = 31 * (var8 + var7);
            class_51.class_1334 var10 = this.field_982;
            int var11 = 0;
            if(var10 != null) {
                var11 = this.field_982.hashCode();
            }

            int var12 = 31 * (31 * (var9 + var11) + Float.floatToIntBits(this.field_983));
            short var13;
            if(this.field_984) {
                var13 = 1231;
            } else {
                var13 = 1237;
            }

            return 31 * (31 * (31 * (var13 + var12) + class_900.hashCode((Object[])this.field_985)) + this.field_986) + this.qz();
        }

        // $FF: renamed from: k () com.google.android.gms.internal.c$f
        public class_51.class_1327 method_2164() {
            this.field_971 = class_905.axb;
            this.field_972 = class_905.axb;
            this.field_973 = class_53.class_1172.method_2179();
            this.field_974 = class_51.class_1328.method_2159();
            this.field_975 = class_51.class_1331.method_2151();
            this.field_976 = class_51.class_1331.method_2151();
            this.field_977 = class_51.class_1331.method_2151();
            this.field_978 = class_51.class_1326.method_2165();
            this.field_979 = "";
            this.field_980 = "";
            this.field_981 = "0";
            this.version = "";
            this.field_982 = null;
            this.field_983 = 0.0F;
            this.field_984 = false;
            this.field_985 = class_905.axb;
            this.field_986 = 0;
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }

    public static final class class_1326 extends ph<class_51.class_1326> {
        // $FF: renamed from: fU com.google.android.gms.internal.c$g[]
        private static volatile class_51.class_1326[] field_987;
        // $FF: renamed from: fV int[]
        public int[] field_988;
        // $FF: renamed from: fW int[]
        public int[] field_989;
        // $FF: renamed from: fX int[]
        public int[] field_990;
        // $FF: renamed from: fY int[]
        public int[] field_991;
        // $FF: renamed from: fZ int[]
        public int[] field_992;
        // $FF: renamed from: ga int[]
        public int[] field_993;
        // $FF: renamed from: gb int[]
        public int[] field_994;
        // $FF: renamed from: gc int[]
        public int[] field_995;
        // $FF: renamed from: gd int[]
        public int[] field_996;
        // $FF: renamed from: ge int[]
        public int[] field_997;

        public class_1326() {
            this.method_2167();
        }

        // $FF: renamed from: l () com.google.android.gms.internal.c$g[]
        public static class_51.class_1326[] method_2165() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.field_988 != null && this.field_988.length > 0) {
                for(int var12 = 0; var12 < this.field_988.length; ++var12) {
                    var1.method_4727(1, this.field_988[var12]);
                }
            }

            if(this.field_989 != null && this.field_989.length > 0) {
                for(int var11 = 0; var11 < this.field_989.length; ++var11) {
                    var1.method_4727(2, this.field_989[var11]);
                }
            }

            if(this.field_990 != null && this.field_990.length > 0) {
                for(int var10 = 0; var10 < this.field_990.length; ++var10) {
                    var1.method_4727(3, this.field_990[var10]);
                }
            }

            if(this.field_991 != null && this.field_991.length > 0) {
                for(int var9 = 0; var9 < this.field_991.length; ++var9) {
                    var1.method_4727(4, this.field_991[var9]);
                }
            }

            if(this.field_992 != null && this.field_992.length > 0) {
                for(int var8 = 0; var8 < this.field_992.length; ++var8) {
                    var1.method_4727(5, this.field_992[var8]);
                }
            }

            if(this.field_993 != null && this.field_993.length > 0) {
                for(int var7 = 0; var7 < this.field_993.length; ++var7) {
                    var1.method_4727(6, this.field_993[var7]);
                }
            }

            if(this.field_994 != null && this.field_994.length > 0) {
                for(int var6 = 0; var6 < this.field_994.length; ++var6) {
                    var1.method_4727(7, this.field_994[var6]);
                }
            }

            if(this.field_995 != null && this.field_995.length > 0) {
                for(int var5 = 0; var5 < this.field_995.length; ++var5) {
                    var1.method_4727(8, this.field_995[var5]);
                }
            }

            if(this.field_996 != null && this.field_996.length > 0) {
                for(int var4 = 0; var4 < this.field_996.length; ++var4) {
                    var1.method_4727(9, this.field_996[var4]);
                }
            }

            if(this.field_997 != null) {
                int var2 = this.field_997.length;
                int var3 = 0;
                if(var2 > 0) {
                    while(var3 < this.field_997.length) {
                        var1.method_4727(10, this.field_997[var3]);
                        ++var3;
                    }
                }
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2166(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = 0;
            int var2 = super.method_2114();
            int var3;
            if(this.field_988 != null && this.field_988.length > 0) {
                int var21 = 0;

                int var22;
                for(var22 = 0; var21 < this.field_988.length; ++var21) {
                    var22 += class_909.method_4691(this.field_988[var21]);
                }

                var3 = var2 + var22 + 1 * this.field_988.length;
            } else {
                var3 = var2;
            }

            if(this.field_989 != null && this.field_989.length > 0) {
                int var19 = 0;

                int var20;
                for(var20 = 0; var19 < this.field_989.length; ++var19) {
                    var20 += class_909.method_4691(this.field_989[var19]);
                }

                var3 = var3 + var20 + 1 * this.field_989.length;
            }

            if(this.field_990 != null && this.field_990.length > 0) {
                int var17 = 0;

                int var18;
                for(var18 = 0; var17 < this.field_990.length; ++var17) {
                    var18 += class_909.method_4691(this.field_990[var17]);
                }

                var3 = var3 + var18 + 1 * this.field_990.length;
            }

            if(this.field_991 != null && this.field_991.length > 0) {
                int var15 = 0;

                int var16;
                for(var16 = 0; var15 < this.field_991.length; ++var15) {
                    var16 += class_909.method_4691(this.field_991[var15]);
                }

                var3 = var3 + var16 + 1 * this.field_991.length;
            }

            if(this.field_992 != null && this.field_992.length > 0) {
                int var13 = 0;

                int var14;
                for(var14 = 0; var13 < this.field_992.length; ++var13) {
                    var14 += class_909.method_4691(this.field_992[var13]);
                }

                var3 = var3 + var14 + 1 * this.field_992.length;
            }

            if(this.field_993 != null && this.field_993.length > 0) {
                int var11 = 0;

                int var12;
                for(var12 = 0; var11 < this.field_993.length; ++var11) {
                    var12 += class_909.method_4691(this.field_993[var11]);
                }

                var3 = var3 + var12 + 1 * this.field_993.length;
            }

            if(this.field_994 != null && this.field_994.length > 0) {
                int var9 = 0;

                int var10;
                for(var10 = 0; var9 < this.field_994.length; ++var9) {
                    var10 += class_909.method_4691(this.field_994[var9]);
                }

                var3 = var3 + var10 + 1 * this.field_994.length;
            }

            if(this.field_995 != null && this.field_995.length > 0) {
                int var7 = 0;

                int var8;
                for(var8 = 0; var7 < this.field_995.length; ++var7) {
                    var8 += class_909.method_4691(this.field_995[var7]);
                }

                var3 = var3 + var8 + 1 * this.field_995.length;
            }

            if(this.field_996 != null && this.field_996.length > 0) {
                int var5 = 0;

                int var6;
                for(var6 = 0; var5 < this.field_996.length; ++var5) {
                    var6 += class_909.method_4691(this.field_996[var5]);
                }

                var3 = var3 + var6 + 1 * this.field_996.length;
            }

            if(this.field_997 != null && this.field_997.length > 0) {
                int var4;
                for(var4 = 0; var1 < this.field_997.length; ++var1) {
                    var4 += class_909.method_4691(this.field_997[var1]);
                }

                var3 = var3 + var4 + 1 * this.field_997.length;
            }

            return var3;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1326;
                var3 = false;
                if(var2) {
                    class_51.class_1326 var4 = (class_51.class_1326)var1;
                    boolean var5 = class_900.equals(this.field_988, var4.field_988);
                    var3 = false;
                    if(var5) {
                        boolean var6 = class_900.equals(this.field_989, var4.field_989);
                        var3 = false;
                        if(var6) {
                            boolean var7 = class_900.equals(this.field_990, var4.field_990);
                            var3 = false;
                            if(var7) {
                                boolean var8 = class_900.equals(this.field_991, var4.field_991);
                                var3 = false;
                                if(var8) {
                                    boolean var9 = class_900.equals(this.field_992, var4.field_992);
                                    var3 = false;
                                    if(var9) {
                                        boolean var10 = class_900.equals(this.field_993, var4.field_993);
                                        var3 = false;
                                        if(var10) {
                                            boolean var11 = class_900.equals(this.field_994, var4.field_994);
                                            var3 = false;
                                            if(var11) {
                                                boolean var12 = class_900.equals(this.field_995, var4.field_995);
                                                var3 = false;
                                                if(var12) {
                                                    boolean var13 = class_900.equals(this.field_996, var4.field_996);
                                                    var3 = false;
                                                    if(var13) {
                                                        boolean var14 = class_900.equals(this.field_997, var4.field_997);
                                                        var3 = false;
                                                        if(var14) {
                                                            return this.a(var4);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return var3;
        }

        // $FF: renamed from: h (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$g
        public class_51.class_1326 method_2166(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var100;
                int[] var101;
                switch(var2) {
                    case 8:
                        int var99 = class_905.method_4635(var1, 8);
                        if(this.field_988 == null) {
                            var100 = 0;
                        } else {
                            var100 = this.field_988.length;
                        }

                        var101 = new int[var99 + var100];
                        if(var100 != 0) {
                            System.arraycopy(this.field_988, 0, var101, 0, var100);
                        }
                        break;
                    case 10:
                        int var93 = var1.method_4650(var1.method_4662());
                        int var94 = var1.getPosition();

                        int var95;
                        for(var95 = 0; var1.method_4666() > 0; ++var95) {
                            var1.method_4658();
                        }

                        var1.method_4652(var94);
                        int var96;
                        if(this.field_988 == null) {
                            var96 = 0;
                        } else {
                            var96 = this.field_988.length;
                        }

                        int[] var97 = new int[var95 + var96];
                        if(var96 != 0) {
                            System.arraycopy(this.field_988, 0, var97, 0, var96);
                        }

                        while(var96 < var97.length) {
                            var97[var96] = var1.method_4658();
                            ++var96;
                        }

                        this.field_988 = var97;
                        var1.method_4651(var93);
                        continue;
                    case 16:
                        int var89 = class_905.method_4635(var1, 16);
                        int var90;
                        if(this.field_989 == null) {
                            var90 = 0;
                        } else {
                            var90 = this.field_989.length;
                        }

                        int[] var91 = new int[var89 + var90];
                        if(var90 != 0) {
                            System.arraycopy(this.field_989, 0, var91, 0, var90);
                        }

                        while(var90 < -1 + var91.length) {
                            var91[var90] = var1.method_4658();
                            var1.method_4655();
                            ++var90;
                        }

                        var91[var90] = var1.method_4658();
                        this.field_989 = var91;
                        continue;
                    case 18:
                        int var83 = var1.method_4650(var1.method_4662());
                        int var84 = var1.getPosition();

                        int var85;
                        for(var85 = 0; var1.method_4666() > 0; ++var85) {
                            var1.method_4658();
                        }

                        var1.method_4652(var84);
                        int var86;
                        if(this.field_989 == null) {
                            var86 = 0;
                        } else {
                            var86 = this.field_989.length;
                        }

                        int[] var87 = new int[var85 + var86];
                        if(var86 != 0) {
                            System.arraycopy(this.field_989, 0, var87, 0, var86);
                        }

                        while(var86 < var87.length) {
                            var87[var86] = var1.method_4658();
                            ++var86;
                        }

                        this.field_989 = var87;
                        var1.method_4651(var83);
                        continue;
                    case 24:
                        int var79 = class_905.method_4635(var1, 24);
                        int var80;
                        if(this.field_990 == null) {
                            var80 = 0;
                        } else {
                            var80 = this.field_990.length;
                        }

                        int[] var81 = new int[var79 + var80];
                        if(var80 != 0) {
                            System.arraycopy(this.field_990, 0, var81, 0, var80);
                        }

                        while(var80 < -1 + var81.length) {
                            var81[var80] = var1.method_4658();
                            var1.method_4655();
                            ++var80;
                        }

                        var81[var80] = var1.method_4658();
                        this.field_990 = var81;
                        continue;
                    case 26:
                        int var73 = var1.method_4650(var1.method_4662());
                        int var74 = var1.getPosition();

                        int var75;
                        for(var75 = 0; var1.method_4666() > 0; ++var75) {
                            var1.method_4658();
                        }

                        var1.method_4652(var74);
                        int var76;
                        if(this.field_990 == null) {
                            var76 = 0;
                        } else {
                            var76 = this.field_990.length;
                        }

                        int[] var77 = new int[var75 + var76];
                        if(var76 != 0) {
                            System.arraycopy(this.field_990, 0, var77, 0, var76);
                        }

                        while(var76 < var77.length) {
                            var77[var76] = var1.method_4658();
                            ++var76;
                        }

                        this.field_990 = var77;
                        var1.method_4651(var73);
                        continue;
                    case 32:
                        int var69 = class_905.method_4635(var1, 32);
                        int var70;
                        if(this.field_991 == null) {
                            var70 = 0;
                        } else {
                            var70 = this.field_991.length;
                        }

                        int[] var71 = new int[var69 + var70];
                        if(var70 != 0) {
                            System.arraycopy(this.field_991, 0, var71, 0, var70);
                        }

                        while(var70 < -1 + var71.length) {
                            var71[var70] = var1.method_4658();
                            var1.method_4655();
                            ++var70;
                        }

                        var71[var70] = var1.method_4658();
                        this.field_991 = var71;
                        continue;
                    case 34:
                        int var63 = var1.method_4650(var1.method_4662());
                        int var64 = var1.getPosition();

                        int var65;
                        for(var65 = 0; var1.method_4666() > 0; ++var65) {
                            var1.method_4658();
                        }

                        var1.method_4652(var64);
                        int var66;
                        if(this.field_991 == null) {
                            var66 = 0;
                        } else {
                            var66 = this.field_991.length;
                        }

                        int[] var67 = new int[var65 + var66];
                        if(var66 != 0) {
                            System.arraycopy(this.field_991, 0, var67, 0, var66);
                        }

                        while(var66 < var67.length) {
                            var67[var66] = var1.method_4658();
                            ++var66;
                        }

                        this.field_991 = var67;
                        var1.method_4651(var63);
                        continue;
                    case 40:
                        int var59 = class_905.method_4635(var1, 40);
                        int var60;
                        if(this.field_992 == null) {
                            var60 = 0;
                        } else {
                            var60 = this.field_992.length;
                        }

                        int[] var61 = new int[var59 + var60];
                        if(var60 != 0) {
                            System.arraycopy(this.field_992, 0, var61, 0, var60);
                        }

                        while(var60 < -1 + var61.length) {
                            var61[var60] = var1.method_4658();
                            var1.method_4655();
                            ++var60;
                        }

                        var61[var60] = var1.method_4658();
                        this.field_992 = var61;
                        continue;
                    case 42:
                        int var53 = var1.method_4650(var1.method_4662());
                        int var54 = var1.getPosition();

                        int var55;
                        for(var55 = 0; var1.method_4666() > 0; ++var55) {
                            var1.method_4658();
                        }

                        var1.method_4652(var54);
                        int var56;
                        if(this.field_992 == null) {
                            var56 = 0;
                        } else {
                            var56 = this.field_992.length;
                        }

                        int[] var57 = new int[var55 + var56];
                        if(var56 != 0) {
                            System.arraycopy(this.field_992, 0, var57, 0, var56);
                        }

                        while(var56 < var57.length) {
                            var57[var56] = var1.method_4658();
                            ++var56;
                        }

                        this.field_992 = var57;
                        var1.method_4651(var53);
                        continue;
                    case 48:
                        int var49 = class_905.method_4635(var1, 48);
                        int var50;
                        if(this.field_993 == null) {
                            var50 = 0;
                        } else {
                            var50 = this.field_993.length;
                        }

                        int[] var51 = new int[var49 + var50];
                        if(var50 != 0) {
                            System.arraycopy(this.field_993, 0, var51, 0, var50);
                        }

                        while(var50 < -1 + var51.length) {
                            var51[var50] = var1.method_4658();
                            var1.method_4655();
                            ++var50;
                        }

                        var51[var50] = var1.method_4658();
                        this.field_993 = var51;
                        continue;
                    case 50:
                        int var43 = var1.method_4650(var1.method_4662());
                        int var44 = var1.getPosition();

                        int var45;
                        for(var45 = 0; var1.method_4666() > 0; ++var45) {
                            var1.method_4658();
                        }

                        var1.method_4652(var44);
                        int var46;
                        if(this.field_993 == null) {
                            var46 = 0;
                        } else {
                            var46 = this.field_993.length;
                        }

                        int[] var47 = new int[var45 + var46];
                        if(var46 != 0) {
                            System.arraycopy(this.field_993, 0, var47, 0, var46);
                        }

                        while(var46 < var47.length) {
                            var47[var46] = var1.method_4658();
                            ++var46;
                        }

                        this.field_993 = var47;
                        var1.method_4651(var43);
                        continue;
                    case 56:
                        int var39 = class_905.method_4635(var1, 56);
                        int var40;
                        if(this.field_994 == null) {
                            var40 = 0;
                        } else {
                            var40 = this.field_994.length;
                        }

                        int[] var41 = new int[var39 + var40];
                        if(var40 != 0) {
                            System.arraycopy(this.field_994, 0, var41, 0, var40);
                        }

                        while(var40 < -1 + var41.length) {
                            var41[var40] = var1.method_4658();
                            var1.method_4655();
                            ++var40;
                        }

                        var41[var40] = var1.method_4658();
                        this.field_994 = var41;
                        continue;
                    case 58:
                        int var33 = var1.method_4650(var1.method_4662());
                        int var34 = var1.getPosition();

                        int var35;
                        for(var35 = 0; var1.method_4666() > 0; ++var35) {
                            var1.method_4658();
                        }

                        var1.method_4652(var34);
                        int var36;
                        if(this.field_994 == null) {
                            var36 = 0;
                        } else {
                            var36 = this.field_994.length;
                        }

                        int[] var37 = new int[var35 + var36];
                        if(var36 != 0) {
                            System.arraycopy(this.field_994, 0, var37, 0, var36);
                        }

                        while(var36 < var37.length) {
                            var37[var36] = var1.method_4658();
                            ++var36;
                        }

                        this.field_994 = var37;
                        var1.method_4651(var33);
                        continue;
                    case 64:
                        int var29 = class_905.method_4635(var1, 64);
                        int var30;
                        if(this.field_995 == null) {
                            var30 = 0;
                        } else {
                            var30 = this.field_995.length;
                        }

                        int[] var31 = new int[var29 + var30];
                        if(var30 != 0) {
                            System.arraycopy(this.field_995, 0, var31, 0, var30);
                        }

                        while(var30 < -1 + var31.length) {
                            var31[var30] = var1.method_4658();
                            var1.method_4655();
                            ++var30;
                        }

                        var31[var30] = var1.method_4658();
                        this.field_995 = var31;
                        continue;
                    case 66:
                        int var23 = var1.method_4650(var1.method_4662());
                        int var24 = var1.getPosition();

                        int var25;
                        for(var25 = 0; var1.method_4666() > 0; ++var25) {
                            var1.method_4658();
                        }

                        var1.method_4652(var24);
                        int var26;
                        if(this.field_995 == null) {
                            var26 = 0;
                        } else {
                            var26 = this.field_995.length;
                        }

                        int[] var27 = new int[var25 + var26];
                        if(var26 != 0) {
                            System.arraycopy(this.field_995, 0, var27, 0, var26);
                        }

                        while(var26 < var27.length) {
                            var27[var26] = var1.method_4658();
                            ++var26;
                        }

                        this.field_995 = var27;
                        var1.method_4651(var23);
                        continue;
                    case 72:
                        int var19 = class_905.method_4635(var1, 72);
                        int var20;
                        if(this.field_996 == null) {
                            var20 = 0;
                        } else {
                            var20 = this.field_996.length;
                        }

                        int[] var21 = new int[var19 + var20];
                        if(var20 != 0) {
                            System.arraycopy(this.field_996, 0, var21, 0, var20);
                        }

                        while(var20 < -1 + var21.length) {
                            var21[var20] = var1.method_4658();
                            var1.method_4655();
                            ++var20;
                        }

                        var21[var20] = var1.method_4658();
                        this.field_996 = var21;
                        continue;
                    case 74:
                        int var13 = var1.method_4650(var1.method_4662());
                        int var14 = var1.getPosition();

                        int var15;
                        for(var15 = 0; var1.method_4666() > 0; ++var15) {
                            var1.method_4658();
                        }

                        var1.method_4652(var14);
                        int var16;
                        if(this.field_996 == null) {
                            var16 = 0;
                        } else {
                            var16 = this.field_996.length;
                        }

                        int[] var17 = new int[var15 + var16];
                        if(var16 != 0) {
                            System.arraycopy(this.field_996, 0, var17, 0, var16);
                        }

                        while(var16 < var17.length) {
                            var17[var16] = var1.method_4658();
                            ++var16;
                        }

                        this.field_996 = var17;
                        var1.method_4651(var13);
                        continue;
                    case 80:
                        int var9 = class_905.method_4635(var1, 80);
                        int var10;
                        if(this.field_997 == null) {
                            var10 = 0;
                        } else {
                            var10 = this.field_997.length;
                        }

                        int[] var11 = new int[var9 + var10];
                        if(var10 != 0) {
                            System.arraycopy(this.field_997, 0, var11, 0, var10);
                        }

                        while(var10 < -1 + var11.length) {
                            var11[var10] = var1.method_4658();
                            var1.method_4655();
                            ++var10;
                        }

                        var11[var10] = var1.method_4658();
                        this.field_997 = var11;
                        continue;
                    case 82:
                        int var3 = var1.method_4650(var1.method_4662());
                        int var4 = var1.getPosition();

                        int var5;
                        for(var5 = 0; var1.method_4666() > 0; ++var5) {
                            var1.method_4658();
                        }

                        var1.method_4652(var4);
                        int var6;
                        if(this.field_997 == null) {
                            var6 = 0;
                        } else {
                            var6 = this.field_997.length;
                        }

                        int[] var7 = new int[var5 + var6];
                        if(var6 != 0) {
                            System.arraycopy(this.field_997, 0, var7, 0, var6);
                        }

                        while(var6 < var7.length) {
                            var7[var6] = var1.method_4658();
                            ++var6;
                        }

                        this.field_997 = var7;
                        var1.method_4651(var3);
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var100 < -1 + var101.length) {
                    var101[var100] = var1.method_4658();
                    var1.method_4655();
                    ++var100;
                }

                var101[var100] = var1.method_4658();
                this.field_988 = var101;
            }
        }

        public int hashCode() {
            return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_900.hashCode(this.field_988)) + class_900.hashCode(this.field_989)) + class_900.hashCode(this.field_990)) + class_900.hashCode(this.field_991)) + class_900.hashCode(this.field_992)) + class_900.hashCode(this.field_993)) + class_900.hashCode(this.field_994)) + class_900.hashCode(this.field_995)) + class_900.hashCode(this.field_996)) + class_900.hashCode(this.field_997)) + this.qz();
        }

        // $FF: renamed from: m () com.google.android.gms.internal.c$g
        public class_51.class_1326 method_2167() {
            this.field_988 = class_905.awW;
            this.field_989 = class_905.awW;
            this.field_990 = class_905.awW;
            this.field_991 = class_905.awW;
            this.field_992 = class_905.awW;
            this.field_993 = class_905.awW;
            this.field_994 = class_905.awW;
            this.field_995 = class_905.awW;
            this.field_996 = class_905.awW;
            this.field_997 = class_905.awW;
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }

    public static final class class_1325 extends ph<class_51.class_1325> {
        // $FF: renamed from: gf com.google.android.gms.internal.pi
        public static final pi<class_53.class_1172, class_51.class_1325> field_998 = class_902.method_4612(11, class_51.class_1325.class, 810);
        // $FF: renamed from: gg com.google.android.gms.internal.c$h[]
        private static final class_51.class_1325[] field_999 = new class_51.class_1325[0];
        // $FF: renamed from: gh int[]
        public int[] field_1000;
        // $FF: renamed from: gi int[]
        public int[] field_1001;
        // $FF: renamed from: gj int[]
        public int[] field_1002;
        // $FF: renamed from: gk int
        public int field_1003;
        // $FF: renamed from: gl int[]
        public int[] field_1004;
        // $FF: renamed from: gm int
        public int field_1005;
        // $FF: renamed from: gn int
        public int field_1006;

        public class_1325() {
            this.method_2169();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.field_1000 != null && this.field_1000.length > 0) {
                for(int var6 = 0; var6 < this.field_1000.length; ++var6) {
                    var1.method_4727(1, this.field_1000[var6]);
                }
            }

            if(this.field_1001 != null && this.field_1001.length > 0) {
                for(int var5 = 0; var5 < this.field_1001.length; ++var5) {
                    var1.method_4727(2, this.field_1001[var5]);
                }
            }

            if(this.field_1002 != null && this.field_1002.length > 0) {
                for(int var4 = 0; var4 < this.field_1002.length; ++var4) {
                    var1.method_4727(3, this.field_1002[var4]);
                }
            }

            if(this.field_1003 != 0) {
                var1.method_4727(4, this.field_1003);
            }

            if(this.field_1004 != null) {
                int var2 = this.field_1004.length;
                int var3 = 0;
                if(var2 > 0) {
                    while(var3 < this.field_1004.length) {
                        var1.method_4727(5, this.field_1004[var3]);
                        ++var3;
                    }
                }
            }

            if(this.field_1005 != 0) {
                var1.method_4727(6, this.field_1005);
            }

            if(this.field_1006 != 0) {
                var1.method_4727(7, this.field_1006);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2168(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = 0;
            int var2 = super.method_2114();
            int var3;
            if(this.field_1000 != null && this.field_1000.length > 0) {
                int var9 = 0;

                int var10;
                for(var10 = 0; var9 < this.field_1000.length; ++var9) {
                    var10 += class_909.method_4691(this.field_1000[var9]);
                }

                var3 = var2 + var10 + 1 * this.field_1000.length;
            } else {
                var3 = var2;
            }

            if(this.field_1001 != null && this.field_1001.length > 0) {
                int var7 = 0;

                int var8;
                for(var8 = 0; var7 < this.field_1001.length; ++var7) {
                    var8 += class_909.method_4691(this.field_1001[var7]);
                }

                var3 = var3 + var8 + 1 * this.field_1001.length;
            }

            if(this.field_1002 != null && this.field_1002.length > 0) {
                int var5 = 0;

                int var6;
                for(var6 = 0; var5 < this.field_1002.length; ++var5) {
                    var6 += class_909.method_4691(this.field_1002[var5]);
                }

                var3 = var3 + var6 + 1 * this.field_1002.length;
            }

            if(this.field_1003 != 0) {
                var3 += class_909.method_4697(4, this.field_1003);
            }

            if(this.field_1004 != null && this.field_1004.length > 0) {
                int var4;
                for(var4 = 0; var1 < this.field_1004.length; ++var1) {
                    var4 += class_909.method_4691(this.field_1004[var1]);
                }

                var3 = var3 + var4 + 1 * this.field_1004.length;
            }

            if(this.field_1005 != 0) {
                var3 += class_909.method_4697(6, this.field_1005);
            }

            if(this.field_1006 != 0) {
                var3 += class_909.method_4697(7, this.field_1006);
            }

            return var3;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1325;
                var3 = false;
                if(var2) {
                    class_51.class_1325 var4 = (class_51.class_1325)var1;
                    boolean var5 = class_900.equals(this.field_1000, var4.field_1000);
                    var3 = false;
                    if(var5) {
                        boolean var6 = class_900.equals(this.field_1001, var4.field_1001);
                        var3 = false;
                        if(var6) {
                            boolean var7 = class_900.equals(this.field_1002, var4.field_1002);
                            var3 = false;
                            if(var7) {
                                int var8 = this.field_1003;
                                int var9 = var4.field_1003;
                                var3 = false;
                                if(var8 == var9) {
                                    boolean var10 = class_900.equals(this.field_1004, var4.field_1004);
                                    var3 = false;
                                    if(var10) {
                                        int var11 = this.field_1005;
                                        int var12 = var4.field_1005;
                                        var3 = false;
                                        if(var11 == var12) {
                                            int var13 = this.field_1006;
                                            int var14 = var4.field_1006;
                                            var3 = false;
                                            if(var13 == var14) {
                                                return this.a(var4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + class_900.hashCode(this.field_1000)) + class_900.hashCode(this.field_1001)) + class_900.hashCode(this.field_1002)) + this.field_1003) + class_900.hashCode(this.field_1004)) + this.field_1005) + this.field_1006) + this.qz();
        }

        // $FF: renamed from: i (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$h
        public class_51.class_1325 method_2168(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var40;
                int[] var41;
                switch(var2) {
                    case 8:
                        int var39 = class_905.method_4635(var1, 8);
                        if(this.field_1000 == null) {
                            var40 = 0;
                        } else {
                            var40 = this.field_1000.length;
                        }

                        var41 = new int[var39 + var40];
                        if(var40 != 0) {
                            System.arraycopy(this.field_1000, 0, var41, 0, var40);
                        }
                        break;
                    case 10:
                        int var33 = var1.method_4650(var1.method_4662());
                        int var34 = var1.getPosition();

                        int var35;
                        for(var35 = 0; var1.method_4666() > 0; ++var35) {
                            var1.method_4658();
                        }

                        var1.method_4652(var34);
                        int var36;
                        if(this.field_1000 == null) {
                            var36 = 0;
                        } else {
                            var36 = this.field_1000.length;
                        }

                        int[] var37 = new int[var35 + var36];
                        if(var36 != 0) {
                            System.arraycopy(this.field_1000, 0, var37, 0, var36);
                        }

                        while(var36 < var37.length) {
                            var37[var36] = var1.method_4658();
                            ++var36;
                        }

                        this.field_1000 = var37;
                        var1.method_4651(var33);
                        continue;
                    case 16:
                        int var29 = class_905.method_4635(var1, 16);
                        int var30;
                        if(this.field_1001 == null) {
                            var30 = 0;
                        } else {
                            var30 = this.field_1001.length;
                        }

                        int[] var31 = new int[var29 + var30];
                        if(var30 != 0) {
                            System.arraycopy(this.field_1001, 0, var31, 0, var30);
                        }

                        while(var30 < -1 + var31.length) {
                            var31[var30] = var1.method_4658();
                            var1.method_4655();
                            ++var30;
                        }

                        var31[var30] = var1.method_4658();
                        this.field_1001 = var31;
                        continue;
                    case 18:
                        int var23 = var1.method_4650(var1.method_4662());
                        int var24 = var1.getPosition();

                        int var25;
                        for(var25 = 0; var1.method_4666() > 0; ++var25) {
                            var1.method_4658();
                        }

                        var1.method_4652(var24);
                        int var26;
                        if(this.field_1001 == null) {
                            var26 = 0;
                        } else {
                            var26 = this.field_1001.length;
                        }

                        int[] var27 = new int[var25 + var26];
                        if(var26 != 0) {
                            System.arraycopy(this.field_1001, 0, var27, 0, var26);
                        }

                        while(var26 < var27.length) {
                            var27[var26] = var1.method_4658();
                            ++var26;
                        }

                        this.field_1001 = var27;
                        var1.method_4651(var23);
                        continue;
                    case 24:
                        int var19 = class_905.method_4635(var1, 24);
                        int var20;
                        if(this.field_1002 == null) {
                            var20 = 0;
                        } else {
                            var20 = this.field_1002.length;
                        }

                        int[] var21 = new int[var19 + var20];
                        if(var20 != 0) {
                            System.arraycopy(this.field_1002, 0, var21, 0, var20);
                        }

                        while(var20 < -1 + var21.length) {
                            var21[var20] = var1.method_4658();
                            var1.method_4655();
                            ++var20;
                        }

                        var21[var20] = var1.method_4658();
                        this.field_1002 = var21;
                        continue;
                    case 26:
                        int var13 = var1.method_4650(var1.method_4662());
                        int var14 = var1.getPosition();

                        int var15;
                        for(var15 = 0; var1.method_4666() > 0; ++var15) {
                            var1.method_4658();
                        }

                        var1.method_4652(var14);
                        int var16;
                        if(this.field_1002 == null) {
                            var16 = 0;
                        } else {
                            var16 = this.field_1002.length;
                        }

                        int[] var17 = new int[var15 + var16];
                        if(var16 != 0) {
                            System.arraycopy(this.field_1002, 0, var17, 0, var16);
                        }

                        while(var16 < var17.length) {
                            var17[var16] = var1.method_4658();
                            ++var16;
                        }

                        this.field_1002 = var17;
                        var1.method_4651(var13);
                        continue;
                    case 32:
                        this.field_1003 = var1.method_4658();
                        continue;
                    case 40:
                        int var9 = class_905.method_4635(var1, 40);
                        int var10;
                        if(this.field_1004 == null) {
                            var10 = 0;
                        } else {
                            var10 = this.field_1004.length;
                        }

                        int[] var11 = new int[var9 + var10];
                        if(var10 != 0) {
                            System.arraycopy(this.field_1004, 0, var11, 0, var10);
                        }

                        while(var10 < -1 + var11.length) {
                            var11[var10] = var1.method_4658();
                            var1.method_4655();
                            ++var10;
                        }

                        var11[var10] = var1.method_4658();
                        this.field_1004 = var11;
                        continue;
                    case 42:
                        int var3 = var1.method_4650(var1.method_4662());
                        int var4 = var1.getPosition();

                        int var5;
                        for(var5 = 0; var1.method_4666() > 0; ++var5) {
                            var1.method_4658();
                        }

                        var1.method_4652(var4);
                        int var6;
                        if(this.field_1004 == null) {
                            var6 = 0;
                        } else {
                            var6 = this.field_1004.length;
                        }

                        int[] var7 = new int[var5 + var6];
                        if(var6 != 0) {
                            System.arraycopy(this.field_1004, 0, var7, 0, var6);
                        }

                        while(var6 < var7.length) {
                            var7[var6] = var1.method_4658();
                            ++var6;
                        }

                        this.field_1004 = var7;
                        var1.method_4651(var3);
                        continue;
                    case 48:
                        this.field_1005 = var1.method_4658();
                        continue;
                    case 56:
                        this.field_1006 = var1.method_4658();
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var40 < -1 + var41.length) {
                    var41[var40] = var1.method_4658();
                    var1.method_4655();
                    ++var40;
                }

                var41[var40] = var1.method_4658();
                this.field_1000 = var41;
            }
        }

        // $FF: renamed from: n () com.google.android.gms.internal.c$h
        public class_51.class_1325 method_2169() {
            this.field_1000 = class_905.awW;
            this.field_1001 = class_905.awW;
            this.field_1002 = class_905.awW;
            this.field_1003 = 0;
            this.field_1004 = class_905.awW;
            this.field_1005 = 0;
            this.field_1006 = 0;
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }

    public static final class class_1319 extends ph<class_51.class_1319> {
        // $FF: renamed from: go com.google.android.gms.internal.c$i[]
        private static volatile class_51.class_1319[] field_1010;
        // $FF: renamed from: gp com.google.android.gms.internal.d$a
        public class_53.class_1172 field_1011;
        // $FF: renamed from: gq com.google.android.gms.internal.c$d
        public class_51.class_1329 field_1012;
        public String name;

        public class_1319() {
            this.method_2175();
        }

        // $FF: renamed from: o () com.google.android.gms.internal.c$i[]
        public static class_51.class_1319[] method_2173() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(!this.name.equals("")) {
                var1.method_4710(1, this.name);
            }

            if(this.field_1011 != null) {
                var1.method_4705(2, this.field_1011);
            }

            if(this.field_1012 != null) {
                var1.method_4705(3, this.field_1012);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2174(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(!this.name.equals("")) {
                var1 += class_909.method_4694(1, this.name);
            }

            if(this.field_1011 != null) {
                var1 += class_909.method_4680(2, this.field_1011);
            }

            if(this.field_1012 != null) {
                var1 += class_909.method_4680(3, this.field_1012);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1319;
                var3 = false;
                if(var2) {
                    class_51.class_1319 var4 = (class_51.class_1319)var1;
                    if(this.name == null) {
                        String var7 = var4.name;
                        var3 = false;
                        if(var7 != null) {
                            return var3;
                        }
                    } else if(!this.name.equals(var4.name)) {
                        return false;
                    }

                    if(this.field_1011 == null) {
                        class_53.class_1172 var6 = var4.field_1011;
                        var3 = false;
                        if(var6 != null) {
                            return var3;
                        }
                    } else if(!this.field_1011.equals(var4.field_1011)) {
                        return false;
                    }

                    if(this.field_1012 == null) {
                        class_51.class_1329 var5 = var4.field_1012;
                        var3 = false;
                        if(var5 != null) {
                            return var3;
                        }
                    } else if(!this.field_1012.equals(var4.field_1012)) {
                        return false;
                    }

                    return this.a(var4);
                }
            }

            return var3;
        }

        public int hashCode() {
            int var1;
            if(this.name == null) {
                var1 = 0;
            } else {
                var1 = this.name.hashCode();
            }

            int var2 = 31 * (var1 + 527);
            int var3;
            if(this.field_1011 == null) {
                var3 = 0;
            } else {
                var3 = this.field_1011.hashCode();
            }

            int var4 = 31 * (var3 + var2);
            class_51.class_1329 var5 = this.field_1012;
            int var6 = 0;
            if(var5 != null) {
                var6 = this.field_1012.hashCode();
            }

            return 31 * (var4 + var6) + this.qz();
        }

        // $FF: renamed from: j (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$i
        public class_51.class_1319 method_2174(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 10:
                        this.name = var1.readString();
                        break;
                    case 18:
                        if(this.field_1011 == null) {
                            this.field_1011 = new class_53.class_1172();
                        }

                        var1.method_4646(this.field_1011);
                        break;
                    case 26:
                        if(this.field_1012 == null) {
                            this.field_1012 = new class_51.class_1329();
                        }

                        var1.method_4646(this.field_1012);
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

        // $FF: renamed from: p () com.google.android.gms.internal.c$i
        public class_51.class_1319 method_2175() {
            this.name = "";
            this.field_1011 = null;
            this.field_1012 = null;
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }

    public static final class class_1320 extends ph<class_51.class_1320> {
        // $FF: renamed from: gr com.google.android.gms.internal.c$i[]
        public class_51.class_1319[] field_1007;
        // $FF: renamed from: gs com.google.android.gms.internal.c$f
        public class_51.class_1327 field_1008;
        // $FF: renamed from: gt java.lang.String
        public String field_1009;

        public class_1320() {
            this.method_2172();
        }

        // $FF: renamed from: b (byte[]) com.google.android.gms.internal.c$j
        public static class_51.class_1320 method_2170(byte[] var0) throws class_899 {
            return (class_51.class_1320)class_307.method_2108(new class_51.class_1320(), var0);
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.field_1007 != null && this.field_1007.length > 0) {
                for(int var2 = 0; var2 < this.field_1007.length; ++var2) {
                    class_51.class_1319 var3 = this.field_1007[var2];
                    if(var3 != null) {
                        var1.method_4705(1, var3);
                    }
                }
            }

            if(this.field_1008 != null) {
                var1.method_4705(2, this.field_1008);
            }

            if(!this.field_1009.equals("")) {
                var1.method_4710(3, this.field_1009);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2171(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(this.field_1007 != null && this.field_1007.length > 0) {
                for(int var2 = 0; var2 < this.field_1007.length; ++var2) {
                    class_51.class_1319 var3 = this.field_1007[var2];
                    if(var3 != null) {
                        var1 += class_909.method_4680(1, var3);
                    }
                }
            }

            if(this.field_1008 != null) {
                var1 += class_909.method_4680(2, this.field_1008);
            }

            if(!this.field_1009.equals("")) {
                var1 += class_909.method_4694(3, this.field_1009);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_51.class_1320;
                var3 = false;
                if(var2) {
                    class_51.class_1320 var4 = (class_51.class_1320)var1;
                    boolean var5 = class_900.equals((Object[])this.field_1007, (Object[])var4.field_1007);
                    var3 = false;
                    if(var5) {
                        if(this.field_1008 == null) {
                            class_51.class_1327 var7 = var4.field_1008;
                            var3 = false;
                            if(var7 != null) {
                                return var3;
                            }
                        } else if(!this.field_1008.equals(var4.field_1008)) {
                            return false;
                        }

                        if(this.field_1009 == null) {
                            String var6 = var4.field_1009;
                            var3 = false;
                            if(var6 != null) {
                                return var3;
                            }
                        } else if(!this.field_1009.equals(var4.field_1009)) {
                            return false;
                        }

                        return this.a(var4);
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (527 + class_900.hashCode((Object[])this.field_1007));
            int var2;
            if(this.field_1008 == null) {
                var2 = 0;
            } else {
                var2 = this.field_1008.hashCode();
            }

            int var3 = 31 * (var2 + var1);
            String var4 = this.field_1009;
            int var5 = 0;
            if(var4 != null) {
                var5 = this.field_1009.hashCode();
            }

            return 31 * (var3 + var5) + this.qz();
        }

        // $FF: renamed from: k (com.google.android.gms.internal.pf) com.google.android.gms.internal.c$j
        public class_51.class_1320 method_2171(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var4;
                class_51.class_1319[] var5;
                switch(var2) {
                    case 10:
                        int var3 = class_905.method_4635(var1, 10);
                        if(this.field_1007 == null) {
                            var4 = 0;
                        } else {
                            var4 = this.field_1007.length;
                        }

                        var5 = new class_51.class_1319[var3 + var4];
                        if(var4 != 0) {
                            System.arraycopy(this.field_1007, 0, var5, 0, var4);
                        }
                        break;
                    case 18:
                        if(this.field_1008 == null) {
                            this.field_1008 = new class_51.class_1327();
                        }

                        var1.method_4646(this.field_1008);
                        continue;
                    case 26:
                        this.field_1009 = var1.readString();
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var4 < -1 + var5.length) {
                    var5[var4] = new class_51.class_1319();
                    var1.method_4646(var5[var4]);
                    var1.method_4655();
                    ++var4;
                }

                var5[var4] = new class_51.class_1319();
                var1.method_4646(var5[var4]);
                this.field_1007 = var5;
            }
        }

        // $FF: renamed from: q () com.google.android.gms.internal.c$j
        public class_51.class_1320 method_2172() {
            this.field_1007 = class_51.class_1319.method_2173();
            this.field_1008 = null;
            this.field_1009 = "";
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }
}
