package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_899;
import com.google.android.gms.internal.class_900;
import com.google.android.gms.internal.class_905;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.ph;
import java.io.IOException;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.pd
public final class class_310 extends ph<pd> {
    public class_310.class_1226[] awd;

    public class_310() {
        this.method_2142();
    }

    // $FF: renamed from: n (byte[]) com.google.android.gms.internal.pd
    public static class_310 method_2140(byte[] var0) throws class_899 {
        return (class_310)class_307.method_2108(new class_310(), var0);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.pg) void
    public void method_2112(class_909 var1) throws IOException {
        if(this.awd != null && this.awd.length > 0) {
            for(int var2 = 0; var2 < this.awd.length; ++var2) {
                class_310.class_1226 var3 = this.awd[var2];
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
        return this.method_2141(var1);
    }

    // $FF: renamed from: c () int
    protected int method_2114() {
        int var1 = super.method_2114();
        if(this.awd != null && this.awd.length > 0) {
            for(int var2 = 0; var2 < this.awd.length; ++var2) {
                class_310.class_1226 var3 = this.awd[var2];
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
            boolean var2 = var1 instanceof class_310;
            var3 = false;
            if(var2) {
                class_310 var4 = (class_310)var1;
                boolean var5 = class_900.equals((Object[])this.awd, (Object[])var4.awd);
                var3 = false;
                if(var5) {
                    return this.a(var4);
                }
            }
        }

        return var3;
    }

    public int hashCode() {
        return 31 * (527 + class_900.hashCode((Object[])this.awd)) + this.qz();
    }

    // $FF: renamed from: q (com.google.android.gms.internal.pf) com.google.android.gms.internal.pd
    public class_310 method_2141(class_908 var1) throws IOException {
        while(true) {
            int var2 = var1.method_4655();
            int var4;
            class_310.class_1226[] var5;
            switch(var2) {
                case 10:
                    int var3 = class_905.method_4635(var1, 10);
                    if(this.awd == null) {
                        var4 = 0;
                    } else {
                        var4 = this.awd.length;
                    }

                    var5 = new class_310.class_1226[var3 + var4];
                    if(var4 != 0) {
                        System.arraycopy(this.awd, 0, var5, 0, var4);
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
                var5[var4] = new class_310.class_1226();
                var1.method_4646(var5[var4]);
                var1.method_4655();
                ++var4;
            }

            var5[var4] = new class_310.class_1226();
            var1.method_4646(var5[var4]);
            this.awd = var5;
        }
    }

    // $FF: renamed from: qc () com.google.android.gms.internal.pd
    public class_310 method_2142() {
        this.awd = class_310.class_1226.method_2176();
        this.awJ = null;
        this.awU = -1;
        return this;
    }

    public static final class class_1226 extends ph<class_310.class_1226> {
        private static volatile class_310.class_1226[] awe;
        public class_310.class_1227 awf;
        public String name;

        public class_1226() {
            this.method_2177();
        }

        // $FF: renamed from: qd () com.google.android.gms.internal.pd$a[]
        public static class_310.class_1226[] method_2176() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            var1.method_4710(1, this.name);
            if(this.awf != null) {
                var1.method_4705(2, this.awf);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2178(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114() + class_909.method_4694(1, this.name);
            if(this.awf != null) {
                var1 += class_909.method_4680(2, this.awf);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_310.class_1226;
                var3 = false;
                if(var2) {
                    class_310.class_1226 var4 = (class_310.class_1226)var1;
                    if(this.name == null) {
                        String var6 = var4.name;
                        var3 = false;
                        if(var6 != null) {
                            return var3;
                        }
                    } else if(!this.name.equals(var4.name)) {
                        return false;
                    }

                    if(this.awf == null) {
                        class_310.class_1227 var5 = var4.awf;
                        var3 = false;
                        if(var5 != null) {
                            return var3;
                        }
                    } else if(!this.awf.equals(var4.awf)) {
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
            class_310.class_1227 var3 = this.awf;
            int var4 = 0;
            if(var3 != null) {
                var4 = this.awf.hashCode();
            }

            return 31 * (var2 + var4) + this.qz();
        }

        // $FF: renamed from: qe () com.google.android.gms.internal.pd$a
        public class_310.class_1226 method_2177() {
            this.name = "";
            this.awf = null;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: r (com.google.android.gms.internal.pf) com.google.android.gms.internal.pd$a
        public class_310.class_1226 method_2178(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 10:
                        this.name = var1.readString();
                        break;
                    case 18:
                        if(this.awf == null) {
                            this.awf = new class_310.class_1227();
                        }

                        var1.method_4646(this.awf);
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

    public static final class class_1227 extends ph<class_310.class_1227> {
        private static volatile class_310.class_1227[] awg;
        public class_310.class_1228 awh;
        public int type;

        public class_1227() {
            this.method_2144();
        }

        // $FF: renamed from: qf () com.google.android.gms.internal.pd$a$a[]
        public static class_310.class_1227[] method_2143() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            var1.method_4727(1, this.type);
            if(this.awh != null) {
                var1.method_4705(2, this.awh);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2145(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114() + class_909.method_4697(1, this.type);
            if(this.awh != null) {
                var1 += class_909.method_4680(2, this.awh);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_310.class_1227;
                var3 = false;
                if(var2) {
                    class_310.class_1227 var4 = (class_310.class_1227)var1;
                    int var5 = this.type;
                    int var6 = var4.type;
                    var3 = false;
                    if(var5 == var6) {
                        if(this.awh == null) {
                            class_310.class_1228 var7 = var4.awh;
                            var3 = false;
                            if(var7 != null) {
                                return var3;
                            }
                        } else if(!this.awh.equals(var4.awh)) {
                            return false;
                        }

                        return this.a(var4);
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (527 + this.type);
            int var2;
            if(this.awh == null) {
                var2 = 0;
            } else {
                var2 = this.awh.hashCode();
            }

            return 31 * (var2 + var1) + this.qz();
        }

        // $FF: renamed from: qg () com.google.android.gms.internal.pd$a$a
        public class_310.class_1227 method_2144() {
            this.type = 1;
            this.awh = null;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: s (com.google.android.gms.internal.pf) com.google.android.gms.internal.pd$a$a
        public class_310.class_1227 method_2145(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 8:
                        int var3 = var1.method_4658();
                        switch(var3) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                                this.type = var3;
                            default:
                                continue;
                        }
                    case 18:
                        if(this.awh == null) {
                            this.awh = new class_310.class_1228();
                        }

                        var1.method_4646(this.awh);
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

    public static final class class_1228 extends ph<class_310.class_1228> {
        public byte[] awi;
        public String awj;
        public double awk;
        public float awl;
        public long awm;
        public int awn;
        public int awo;
        public boolean awp;
        public class_310.class_1226[] awq;
        public class_310.class_1227[] awr;
        public String[] aws;
        public long[] awt;
        public float[] awu;
        public long awv;

        public class_1228() {
            this.method_2138();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(!Arrays.equals(this.awi, class_905.axd)) {
                var1.method_4706(1, this.awi);
            }

            if(!this.awj.equals("")) {
                var1.method_4710(2, this.awj);
            }

            if(Double.doubleToLongBits(this.awk) != Double.doubleToLongBits(0.0D)) {
                var1.method_4704(3, this.awk);
            }

            if(Float.floatToIntBits(this.awl) != Float.floatToIntBits(0.0F)) {
                var1.method_4708(4, this.awl);
            }

            if(this.awm != 0L) {
                var1.method_4709(5, this.awm);
            }

            if(this.awn != 0) {
                var1.method_4727(6, this.awn);
            }

            if(this.awo != 0) {
                var1.method_4728(7, this.awo);
            }

            if(this.awp) {
                var1.method_4711(8, this.awp);
            }

            if(this.awq != null && this.awq.length > 0) {
                for(int var9 = 0; var9 < this.awq.length; ++var9) {
                    class_310.class_1226 var10 = this.awq[var9];
                    if(var10 != null) {
                        var1.method_4705(9, var10);
                    }
                }
            }

            if(this.awr != null && this.awr.length > 0) {
                for(int var7 = 0; var7 < this.awr.length; ++var7) {
                    class_310.class_1227 var8 = this.awr[var7];
                    if(var8 != null) {
                        var1.method_4705(10, var8);
                    }
                }
            }

            if(this.aws != null && this.aws.length > 0) {
                for(int var5 = 0; var5 < this.aws.length; ++var5) {
                    String var6 = this.aws[var5];
                    if(var6 != null) {
                        var1.method_4710(11, var6);
                    }
                }
            }

            if(this.awt != null && this.awt.length > 0) {
                for(int var4 = 0; var4 < this.awt.length; ++var4) {
                    var1.method_4709(12, this.awt[var4]);
                }
            }

            if(this.awv != 0L) {
                var1.method_4709(13, this.awv);
            }

            if(this.awu != null) {
                int var2 = this.awu.length;
                int var3 = 0;
                if(var2 > 0) {
                    while(var3 < this.awu.length) {
                        var1.method_4708(14, this.awu[var3]);
                        ++var3;
                    }
                }
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2139(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = 0;
            int var2 = super.method_2114();
            if(!Arrays.equals(this.awi, class_905.axd)) {
                var2 += class_909.method_4677(1, this.awi);
            }

            if(!this.awj.equals("")) {
                var2 += class_909.method_4694(2, this.awj);
            }

            if(Double.doubleToLongBits(this.awk) != Double.doubleToLongBits(0.0D)) {
                var2 += class_909.method_4675(3, this.awk);
            }

            if(Float.floatToIntBits(this.awl) != Float.floatToIntBits(0.0F)) {
                var2 += class_909.method_4679(4, this.awl);
            }

            if(this.awm != 0L) {
                var2 += class_909.method_4682(5, this.awm);
            }

            if(this.awn != 0) {
                var2 += class_909.method_4697(6, this.awn);
            }

            if(this.awo != 0) {
                var2 += class_909.method_4698(7, this.awo);
            }

            if(this.awp) {
                var2 += class_909.method_4681(8, this.awp);
            }

            if(this.awq != null && this.awq.length > 0) {
                int var11 = var2;

                for(int var12 = 0; var12 < this.awq.length; ++var12) {
                    class_310.class_1226 var13 = this.awq[var12];
                    if(var13 != null) {
                        var11 += class_909.method_4680(9, var13);
                    }
                }

                var2 = var11;
            }

            if(this.awr != null && this.awr.length > 0) {
                int var8 = var2;

                for(int var9 = 0; var9 < this.awr.length; ++var9) {
                    class_310.class_1227 var10 = this.awr[var9];
                    if(var10 != null) {
                        var8 += class_909.method_4680(10, var10);
                    }
                }

                var2 = var8;
            }

            if(this.aws != null && this.aws.length > 0) {
                int var4 = 0;
                int var5 = 0;

                int var6;
                for(var6 = 0; var4 < this.aws.length; ++var4) {
                    String var7 = this.aws[var4];
                    if(var7 != null) {
                        ++var6;
                        var5 += class_909.method_4684(var7);
                    }
                }

                var2 = var2 + var5 + var6 * 1;
            }

            if(this.awt != null && this.awt.length > 0) {
                int var3;
                for(var3 = 0; var1 < this.awt.length; ++var1) {
                    var3 += class_909.method_4670(this.awt[var1]);
                }

                var2 = var2 + var3 + 1 * this.awt.length;
            }

            if(this.awv != 0L) {
                var2 += class_909.method_4682(13, this.awv);
            }

            if(this.awu != null && this.awu.length > 0) {
                var2 = var2 + 4 * this.awu.length + 1 * this.awu.length;
            }

            return var2;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_310.class_1228;
                var3 = false;
                if(var2) {
                    class_310.class_1228 var4 = (class_310.class_1228)var1;
                    boolean var5 = Arrays.equals(this.awi, var4.awi);
                    var3 = false;
                    if(var5) {
                        if(this.awj == null) {
                            String var22 = var4.awj;
                            var3 = false;
                            if(var22 != null) {
                                return var3;
                            }
                        } else if(!this.awj.equals(var4.awj)) {
                            return false;
                        }

                        long var23;
                        int var6 = (var23 = Double.doubleToLongBits(this.awk) - Double.doubleToLongBits(var4.awk)) == 0L?0:(var23 < 0L?-1:1);
                        var3 = false;
                        if(var6 == 0) {
                            int var7 = Float.floatToIntBits(this.awl);
                            int var8 = Float.floatToIntBits(var4.awl);
                            var3 = false;
                            if(var7 == var8) {
                                long var24;
                                int var9 = (var24 = this.awm - var4.awm) == 0L?0:(var24 < 0L?-1:1);
                                var3 = false;
                                if(var9 == 0) {
                                    int var10 = this.awn;
                                    int var11 = var4.awn;
                                    var3 = false;
                                    if(var10 == var11) {
                                        int var12 = this.awo;
                                        int var13 = var4.awo;
                                        var3 = false;
                                        if(var12 == var13) {
                                            boolean var14 = this.awp;
                                            boolean var15 = var4.awp;
                                            var3 = false;
                                            if(var14 == var15) {
                                                boolean var16 = class_900.equals((Object[])this.awq, (Object[])var4.awq);
                                                var3 = false;
                                                if(var16) {
                                                    boolean var17 = class_900.equals((Object[])this.awr, (Object[])var4.awr);
                                                    var3 = false;
                                                    if(var17) {
                                                        boolean var18 = class_900.equals((Object[])this.aws, (Object[])var4.aws);
                                                        var3 = false;
                                                        if(var18) {
                                                            boolean var19 = class_900.equals(this.awt, var4.awt);
                                                            var3 = false;
                                                            if(var19) {
                                                                boolean var20 = class_900.equals(this.awu, var4.awu);
                                                                var3 = false;
                                                                if(var20) {
                                                                    long var25;
                                                                    int var21 = (var25 = this.awv - var4.awv) == 0L?0:(var25 < 0L?-1:1);
                                                                    var3 = false;
                                                                    if(var21 == 0) {
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
            }

            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (527 + Arrays.hashCode(this.awi));
            int var2;
            if(this.awj == null) {
                var2 = 0;
            } else {
                var2 = this.awj.hashCode();
            }

            int var3 = var2 + var1;
            long var4 = Double.doubleToLongBits(this.awk);
            int var6 = 31 * (31 * (31 * (31 * (31 * (var3 * 31 + (int)(var4 ^ var4 >>> 32)) + Float.floatToIntBits(this.awl)) + (int)(this.awm ^ this.awm >>> 32)) + this.awn) + this.awo);
            short var7;
            if(this.awp) {
                var7 = 1231;
            } else {
                var7 = 1237;
            }

            return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (var7 + var6) + class_900.hashCode((Object[])this.awq)) + class_900.hashCode((Object[])this.awr)) + class_900.hashCode((Object[])this.aws)) + class_900.hashCode(this.awt)) + class_900.hashCode(this.awu)) + (int)(this.awv ^ this.awv >>> 32)) + this.qz();
        }

        // $FF: renamed from: qh () com.google.android.gms.internal.pd$a$a$a
        public class_310.class_1228 method_2138() {
            this.awi = class_905.axd;
            this.awj = "";
            this.awk = 0.0D;
            this.awl = 0.0F;
            this.awm = 0L;
            this.awn = 0;
            this.awo = 0;
            this.awp = false;
            this.awq = class_310.class_1226.method_2176();
            this.awr = class_310.class_1227.method_2143();
            this.aws = class_905.axb;
            this.awt = class_905.awX;
            this.awu = class_905.awY;
            this.awv = 0L;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: t (com.google.android.gms.internal.pf) com.google.android.gms.internal.pd$a$a$a
        public class_310.class_1228 method_2139(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var32;
                class_310.class_1226[] var33;
                switch(var2) {
                    case 10:
                        this.awi = var1.readBytes();
                        continue;
                    case 18:
                        this.awj = var1.readString();
                        continue;
                    case 25:
                        this.awk = var1.readDouble();
                        continue;
                    case 37:
                        this.awl = var1.readFloat();
                        continue;
                    case 40:
                        this.awm = var1.method_4657();
                        continue;
                    case 48:
                        this.awn = var1.method_4658();
                        continue;
                    case 56:
                        this.awo = var1.method_4660();
                        continue;
                    case 64:
                        this.awp = var1.method_4659();
                        continue;
                    case 74:
                        int var31 = class_905.method_4635(var1, 74);
                        if(this.awq == null) {
                            var32 = 0;
                        } else {
                            var32 = this.awq.length;
                        }

                        var33 = new class_310.class_1226[var31 + var32];
                        if(var32 != 0) {
                            System.arraycopy(this.awq, 0, var33, 0, var32);
                        }
                        break;
                    case 82:
                        int var27 = class_905.method_4635(var1, 82);
                        int var28;
                        if(this.awr == null) {
                            var28 = 0;
                        } else {
                            var28 = this.awr.length;
                        }

                        class_310.class_1227[] var29 = new class_310.class_1227[var27 + var28];
                        if(var28 != 0) {
                            System.arraycopy(this.awr, 0, var29, 0, var28);
                        }

                        while(var28 < -1 + var29.length) {
                            var29[var28] = new class_310.class_1227();
                            var1.method_4646(var29[var28]);
                            var1.method_4655();
                            ++var28;
                        }

                        var29[var28] = new class_310.class_1227();
                        var1.method_4646(var29[var28]);
                        this.awr = var29;
                        continue;
                    case 90:
                        int var23 = class_905.method_4635(var1, 90);
                        int var24;
                        if(this.aws == null) {
                            var24 = 0;
                        } else {
                            var24 = this.aws.length;
                        }

                        String[] var25 = new String[var23 + var24];
                        if(var24 != 0) {
                            System.arraycopy(this.aws, 0, var25, 0, var24);
                        }

                        while(var24 < -1 + var25.length) {
                            var25[var24] = var1.readString();
                            var1.method_4655();
                            ++var24;
                        }

                        var25[var24] = var1.readString();
                        this.aws = var25;
                        continue;
                    case 96:
                        int var19 = class_905.method_4635(var1, 96);
                        int var20;
                        if(this.awt == null) {
                            var20 = 0;
                        } else {
                            var20 = this.awt.length;
                        }

                        long[] var21 = new long[var19 + var20];
                        if(var20 != 0) {
                            System.arraycopy(this.awt, 0, var21, 0, var20);
                        }

                        while(var20 < -1 + var21.length) {
                            var21[var20] = var1.method_4657();
                            var1.method_4655();
                            ++var20;
                        }

                        var21[var20] = var1.method_4657();
                        this.awt = var21;
                        continue;
                    case 98:
                        int var12 = var1.method_4650(var1.method_4662());
                        int var13 = var1.getPosition();

                        int var14;
                        for(var14 = 0; var1.method_4666() > 0; ++var14) {
                            var1.method_4657();
                        }

                        var1.method_4652(var13);
                        int var15;
                        if(this.awt == null) {
                            var15 = 0;
                        } else {
                            var15 = this.awt.length;
                        }

                        long[] var16 = new long[var14 + var15];
                        if(var15 != 0) {
                            System.arraycopy(this.awt, 0, var16, 0, var15);
                        }

                        while(var15 < var16.length) {
                            var16[var15] = var1.method_4657();
                            ++var15;
                        }

                        this.awt = var16;
                        var1.method_4651(var12);
                        continue;
                    case 104:
                        this.awv = var1.method_4657();
                        continue;
                    case 114:
                        int var3 = var1.method_4662();
                        int var4 = var1.method_4650(var3);
                        int var5 = var3 / 4;
                        int var6;
                        if(this.awu == null) {
                            var6 = 0;
                        } else {
                            var6 = this.awu.length;
                        }

                        float[] var7 = new float[var5 + var6];
                        if(var6 != 0) {
                            System.arraycopy(this.awu, 0, var7, 0, var6);
                        }

                        while(var6 < var7.length) {
                            var7[var6] = var1.readFloat();
                            ++var6;
                        }

                        this.awu = var7;
                        var1.method_4651(var4);
                        continue;
                    case 117:
                        int var8 = class_905.method_4635(var1, 117);
                        int var9;
                        if(this.awu == null) {
                            var9 = 0;
                        } else {
                            var9 = this.awu.length;
                        }

                        float[] var10 = new float[var8 + var9];
                        if(var9 != 0) {
                            System.arraycopy(this.awu, 0, var10, 0, var9);
                        }

                        while(var9 < -1 + var10.length) {
                            var10[var9] = var1.readFloat();
                            var1.method_4655();
                            ++var9;
                        }

                        var10[var9] = var1.readFloat();
                        this.awu = var10;
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var32 < -1 + var33.length) {
                    var33[var32] = new class_310.class_1226();
                    var1.method_4646(var33[var32]);
                    var1.method_4655();
                    ++var32;
                }

                var33[var32] = new class_310.class_1226();
                var1.method_4646(var33[var32]);
                this.awq = var33;
            }
        }
    }
}
