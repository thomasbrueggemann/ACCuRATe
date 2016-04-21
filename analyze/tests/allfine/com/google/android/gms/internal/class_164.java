package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_900;
import com.google.android.gms.internal.class_905;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import java.io.IOException;
import java.util.Arrays;

// $FF: renamed from: com.google.android.gms.internal.pr
public interface class_164 {
    public static final class class_1507 extends ph<class_164.class_1507> {
        public String[] axe;
        public String[] axf;
        public int[] axg;

        public class_1507() {
            this.method_2127();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.axe != null && this.axe.length > 0) {
                for(int var6 = 0; var6 < this.axe.length; ++var6) {
                    String var7 = this.axe[var6];
                    if(var7 != null) {
                        var1.method_4710(1, var7);
                    }
                }
            }

            if(this.axf != null && this.axf.length > 0) {
                for(int var4 = 0; var4 < this.axf.length; ++var4) {
                    String var5 = this.axf[var4];
                    if(var5 != null) {
                        var1.method_4710(2, var5);
                    }
                }
            }

            if(this.axg != null) {
                int var2 = this.axg.length;
                int var3 = 0;
                if(var2 > 0) {
                    while(var3 < this.axg.length) {
                        var1.method_4727(3, this.axg[var3]);
                        ++var3;
                    }
                }
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2128(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = 0;
            int var2 = super.method_2114();
            int var3;
            if(this.axe != null && this.axe.length > 0) {
                int var9 = 0;
                int var10 = 0;

                int var11;
                for(var11 = 0; var9 < this.axe.length; ++var9) {
                    String var12 = this.axe[var9];
                    if(var12 != null) {
                        ++var11;
                        var10 += class_909.method_4684(var12);
                    }
                }

                var3 = var2 + var10 + var11 * 1;
            } else {
                var3 = var2;
            }

            if(this.axf != null && this.axf.length > 0) {
                int var5 = 0;
                int var6 = 0;

                int var7;
                for(var7 = 0; var5 < this.axf.length; ++var5) {
                    String var8 = this.axf[var5];
                    if(var8 != null) {
                        ++var7;
                        var6 += class_909.method_4684(var8);
                    }
                }

                var3 = var3 + var6 + var7 * 1;
            }

            if(this.axg != null && this.axg.length > 0) {
                int var4;
                for(var4 = 0; var1 < this.axg.length; ++var1) {
                    var4 += class_909.method_4691(this.axg[var1]);
                }

                var3 = var3 + var4 + 1 * this.axg.length;
            }

            return var3;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_164.class_1507;
                var3 = false;
                if(var2) {
                    class_164.class_1507 var4 = (class_164.class_1507)var1;
                    boolean var5 = class_900.equals((Object[])this.axe, (Object[])var4.axe);
                    var3 = false;
                    if(var5) {
                        boolean var6 = class_900.equals((Object[])this.axf, (Object[])var4.axf);
                        var3 = false;
                        if(var6) {
                            boolean var7 = class_900.equals(this.axg, var4.axg);
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

        public int hashCode() {
            return 31 * (31 * (31 * (527 + class_900.hashCode((Object[])this.axe)) + class_900.hashCode((Object[])this.axf)) + class_900.hashCode(this.axg)) + this.qz();
        }

        // $FF: renamed from: qJ () com.google.android.gms.internal.pr$a
        public class_164.class_1507 method_2127() {
            this.axe = class_905.axb;
            this.axf = class_905.axb;
            this.axg = class_905.awW;
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: v (com.google.android.gms.internal.pf) com.google.android.gms.internal.pr$a
        public class_164.class_1507 method_2128(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                String[] var19;
                int var18;
                switch(var2) {
                    case 10:
                        int var17 = class_905.method_4635(var1, 10);
                        if(this.axe == null) {
                            var18 = 0;
                        } else {
                            var18 = this.axe.length;
                        }

                        var19 = new String[var17 + var18];
                        if(var18 != 0) {
                            System.arraycopy(this.axe, 0, var19, 0, var18);
                        }
                        break;
                    case 18:
                        int var13 = class_905.method_4635(var1, 18);
                        int var14;
                        if(this.axf == null) {
                            var14 = 0;
                        } else {
                            var14 = this.axf.length;
                        }

                        String[] var15 = new String[var13 + var14];
                        if(var14 != 0) {
                            System.arraycopy(this.axf, 0, var15, 0, var14);
                        }

                        while(var14 < -1 + var15.length) {
                            var15[var14] = var1.readString();
                            var1.method_4655();
                            ++var14;
                        }

                        var15[var14] = var1.readString();
                        this.axf = var15;
                        continue;
                    case 24:
                        int var9 = class_905.method_4635(var1, 24);
                        int var10;
                        if(this.axg == null) {
                            var10 = 0;
                        } else {
                            var10 = this.axg.length;
                        }

                        int[] var11 = new int[var9 + var10];
                        if(var10 != 0) {
                            System.arraycopy(this.axg, 0, var11, 0, var10);
                        }

                        while(var10 < -1 + var11.length) {
                            var11[var10] = var1.method_4658();
                            var1.method_4655();
                            ++var10;
                        }

                        var11[var10] = var1.method_4658();
                        this.axg = var11;
                        continue;
                    case 26:
                        int var3 = var1.method_4650(var1.method_4662());
                        int var4 = var1.getPosition();

                        int var5;
                        for(var5 = 0; var1.method_4666() > 0; ++var5) {
                            var1.method_4658();
                        }

                        var1.method_4652(var4);
                        int var6;
                        if(this.axg == null) {
                            var6 = 0;
                        } else {
                            var6 = this.axg.length;
                        }

                        int[] var7 = new int[var5 + var6];
                        if(var6 != 0) {
                            System.arraycopy(this.axg, 0, var7, 0, var6);
                        }

                        while(var6 < var7.length) {
                            var7[var6] = var1.method_4658();
                            ++var6;
                        }

                        this.axg = var7;
                        var1.method_4651(var3);
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var18 < -1 + var19.length) {
                    var19[var18] = var1.readString();
                    var1.method_4655();
                    ++var18;
                }

                var19[var18] = var1.readString();
                this.axe = var19;
            }
        }
    }

    public static final class class_1508 extends ph<class_164.class_1508> {
        public int axh;
        public String axi;
        public String version;

        public class_1508() {
            this.method_2129();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.axh != 0) {
                var1.method_4727(1, this.axh);
            }

            if(!this.axi.equals("")) {
                var1.method_4710(2, this.axi);
            }

            if(!this.version.equals("")) {
                var1.method_4710(3, this.version);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2130(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(this.axh != 0) {
                var1 += class_909.method_4697(1, this.axh);
            }

            if(!this.axi.equals("")) {
                var1 += class_909.method_4694(2, this.axi);
            }

            if(!this.version.equals("")) {
                var1 += class_909.method_4694(3, this.version);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_164.class_1508;
                var3 = false;
                if(var2) {
                    class_164.class_1508 var4 = (class_164.class_1508)var1;
                    int var5 = this.axh;
                    int var6 = var4.axh;
                    var3 = false;
                    if(var5 == var6) {
                        if(this.axi == null) {
                            String var8 = var4.axi;
                            var3 = false;
                            if(var8 != null) {
                                return var3;
                            }
                        } else if(!this.axi.equals(var4.axi)) {
                            return false;
                        }

                        if(this.version == null) {
                            String var7 = var4.version;
                            var3 = false;
                            if(var7 != null) {
                                return var3;
                            }
                        } else if(!this.version.equals(var4.version)) {
                            return false;
                        }

                        return this.a(var4);
                    }
                }
            }

            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (527 + this.axh);
            int var2;
            if(this.axi == null) {
                var2 = 0;
            } else {
                var2 = this.axi.hashCode();
            }

            int var3 = 31 * (var2 + var1);
            String var4 = this.version;
            int var5 = 0;
            if(var4 != null) {
                var5 = this.version.hashCode();
            }

            return 31 * (var3 + var5) + this.qz();
        }

        // $FF: renamed from: qK () com.google.android.gms.internal.pr$b
        public class_164.class_1508 method_2129() {
            this.axh = 0;
            this.axi = "";
            this.version = "";
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: w (com.google.android.gms.internal.pf) com.google.android.gms.internal.pr$b
        public class_164.class_1508 method_2130(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 8:
                        int var3 = var1.method_4658();
                        switch(var3) {
                            case 0:
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
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                this.axh = var3;
                            default:
                                continue;
                        }
                    case 18:
                        this.axi = var1.readString();
                        break;
                    case 26:
                        this.version = var1.readString();
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

    public static final class class_1509 extends ph<class_164.class_1509> {
        public long axj;
        public int axk;
        public int axl;
        public boolean axm;
        public class_164.class_1510[] axn;
        public class_164.class_1508 axo;
        public byte[] axp;
        public byte[] axq;
        public byte[] axr;
        public class_164.class_1507 axs;
        public String axt;
        public String tag;

        public class_1509() {
            this.method_2131();
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(this.axj != 0L) {
                var1.method_4709(1, this.axj);
            }

            if(!this.tag.equals("")) {
                var1.method_4710(2, this.tag);
            }

            if(this.axn != null && this.axn.length > 0) {
                for(int var2 = 0; var2 < this.axn.length; ++var2) {
                    class_164.class_1510 var3 = this.axn[var2];
                    if(var3 != null) {
                        var1.method_4705(3, var3);
                    }
                }
            }

            if(!Arrays.equals(this.axp, class_905.axd)) {
                var1.method_4706(6, this.axp);
            }

            if(this.axs != null) {
                var1.method_4705(7, this.axs);
            }

            if(!Arrays.equals(this.axq, class_905.axd)) {
                var1.method_4706(8, this.axq);
            }

            if(this.axo != null) {
                var1.method_4705(9, this.axo);
            }

            if(this.axm) {
                var1.method_4711(10, this.axm);
            }

            if(this.axk != 0) {
                var1.method_4727(11, this.axk);
            }

            if(this.axl != 0) {
                var1.method_4727(12, this.axl);
            }

            if(!Arrays.equals(this.axr, class_905.axd)) {
                var1.method_4706(13, this.axr);
            }

            if(!this.axt.equals("")) {
                var1.method_4710(14, this.axt);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2132(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(this.axj != 0L) {
                var1 += class_909.method_4682(1, this.axj);
            }

            if(!this.tag.equals("")) {
                var1 += class_909.method_4694(2, this.tag);
            }

            if(this.axn != null && this.axn.length > 0) {
                int var2 = var1;

                for(int var3 = 0; var3 < this.axn.length; ++var3) {
                    class_164.class_1510 var4 = this.axn[var3];
                    if(var4 != null) {
                        var2 += class_909.method_4680(3, var4);
                    }
                }

                var1 = var2;
            }

            if(!Arrays.equals(this.axp, class_905.axd)) {
                var1 += class_909.method_4677(6, this.axp);
            }

            if(this.axs != null) {
                var1 += class_909.method_4680(7, this.axs);
            }

            if(!Arrays.equals(this.axq, class_905.axd)) {
                var1 += class_909.method_4677(8, this.axq);
            }

            if(this.axo != null) {
                var1 += class_909.method_4680(9, this.axo);
            }

            if(this.axm) {
                var1 += class_909.method_4681(10, this.axm);
            }

            if(this.axk != 0) {
                var1 += class_909.method_4697(11, this.axk);
            }

            if(this.axl != 0) {
                var1 += class_909.method_4697(12, this.axl);
            }

            if(!Arrays.equals(this.axr, class_905.axd)) {
                var1 += class_909.method_4677(13, this.axr);
            }

            if(!this.axt.equals("")) {
                var1 += class_909.method_4694(14, this.axt);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_164.class_1509;
                var3 = false;
                if(var2) {
                    class_164.class_1509 var4 = (class_164.class_1509)var1;
                    long var20;
                    int var5 = (var20 = this.axj - var4.axj) == 0L?0:(var20 < 0L?-1:1);
                    var3 = false;
                    if(var5 == 0) {
                        if(this.tag == null) {
                            String var19 = var4.tag;
                            var3 = false;
                            if(var19 != null) {
                                return var3;
                            }
                        } else if(!this.tag.equals(var4.tag)) {
                            return false;
                        }

                        int var6 = this.axk;
                        int var7 = var4.axk;
                        var3 = false;
                        if(var6 == var7) {
                            int var8 = this.axl;
                            int var9 = var4.axl;
                            var3 = false;
                            if(var8 == var9) {
                                boolean var10 = this.axm;
                                boolean var11 = var4.axm;
                                var3 = false;
                                if(var10 == var11) {
                                    boolean var12 = class_900.equals((Object[])this.axn, (Object[])var4.axn);
                                    var3 = false;
                                    if(var12) {
                                        if(this.axo == null) {
                                            class_164.class_1508 var18 = var4.axo;
                                            var3 = false;
                                            if(var18 != null) {
                                                return var3;
                                            }
                                        } else if(!this.axo.equals(var4.axo)) {
                                            return false;
                                        }

                                        boolean var13 = Arrays.equals(this.axp, var4.axp);
                                        var3 = false;
                                        if(var13) {
                                            boolean var14 = Arrays.equals(this.axq, var4.axq);
                                            var3 = false;
                                            if(var14) {
                                                boolean var15 = Arrays.equals(this.axr, var4.axr);
                                                var3 = false;
                                                if(var15) {
                                                    if(this.axs == null) {
                                                        class_164.class_1507 var17 = var4.axs;
                                                        var3 = false;
                                                        if(var17 != null) {
                                                            return var3;
                                                        }
                                                    } else if(!this.axs.equals(var4.axs)) {
                                                        return false;
                                                    }

                                                    if(this.axt == null) {
                                                        String var16 = var4.axt;
                                                        var3 = false;
                                                        if(var16 != null) {
                                                            return var3;
                                                        }
                                                    } else if(!this.axt.equals(var4.axt)) {
                                                        return false;
                                                    }

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

            return var3;
        }

        public int hashCode() {
            int var1 = 31 * (527 + (int)(this.axj ^ this.axj >>> 32));
            int var2;
            if(this.tag == null) {
                var2 = 0;
            } else {
                var2 = this.tag.hashCode();
            }

            int var3 = 31 * (31 * (31 * (var2 + var1) + this.axk) + this.axl);
            short var4;
            if(this.axm) {
                var4 = 1231;
            } else {
                var4 = 1237;
            }

            int var5 = 31 * (31 * (var4 + var3) + class_900.hashCode((Object[])this.axn));
            int var6;
            if(this.axo == null) {
                var6 = 0;
            } else {
                var6 = this.axo.hashCode();
            }

            int var7 = 31 * (31 * (31 * (31 * (var6 + var5) + Arrays.hashCode(this.axp)) + Arrays.hashCode(this.axq)) + Arrays.hashCode(this.axr));
            int var8;
            if(this.axs == null) {
                var8 = 0;
            } else {
                var8 = this.axs.hashCode();
            }

            int var9 = 31 * (var8 + var7);
            String var10 = this.axt;
            int var11 = 0;
            if(var10 != null) {
                var11 = this.axt.hashCode();
            }

            return 31 * (var9 + var11) + this.qz();
        }

        // $FF: renamed from: qL () com.google.android.gms.internal.pr$c
        public class_164.class_1509 method_2131() {
            this.axj = 0L;
            this.tag = "";
            this.axk = 0;
            this.axl = 0;
            this.axm = false;
            this.axn = class_164.class_1510.method_2133();
            this.axo = null;
            this.axp = class_905.axd;
            this.axq = class_905.axd;
            this.axr = class_905.axd;
            this.axs = null;
            this.axt = "";
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: x (com.google.android.gms.internal.pf) com.google.android.gms.internal.pr$c
        public class_164.class_1509 method_2132(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var4;
                class_164.class_1510[] var5;
                switch(var2) {
                    case 8:
                        this.axj = var1.method_4657();
                        continue;
                    case 18:
                        this.tag = var1.readString();
                        continue;
                    case 26:
                        int var3 = class_905.method_4635(var1, 26);
                        if(this.axn == null) {
                            var4 = 0;
                        } else {
                            var4 = this.axn.length;
                        }

                        var5 = new class_164.class_1510[var3 + var4];
                        if(var4 != 0) {
                            System.arraycopy(this.axn, 0, var5, 0, var4);
                        }
                        break;
                    case 50:
                        this.axp = var1.readBytes();
                        continue;
                    case 58:
                        if(this.axs == null) {
                            this.axs = new class_164.class_1507();
                        }

                        var1.method_4646(this.axs);
                        continue;
                    case 66:
                        this.axq = var1.readBytes();
                        continue;
                    case 74:
                        if(this.axo == null) {
                            this.axo = new class_164.class_1508();
                        }

                        var1.method_4646(this.axo);
                        continue;
                    case 80:
                        this.axm = var1.method_4659();
                        continue;
                    case 88:
                        this.axk = var1.method_4658();
                        continue;
                    case 96:
                        this.axl = var1.method_4658();
                        continue;
                    case 106:
                        this.axr = var1.readBytes();
                        continue;
                    case 114:
                        this.axt = var1.readString();
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var4 < -1 + var5.length) {
                    var5[var4] = new class_164.class_1510();
                    var1.method_4646(var5[var4]);
                    var1.method_4655();
                    ++var4;
                }

                var5[var4] = new class_164.class_1510();
                var1.method_4646(var5[var4]);
                this.axn = var5;
            }
        }
    }

    public static final class class_1510 extends ph<class_164.class_1510> {
        private static volatile class_164.class_1510[] axu;
        // $FF: renamed from: fv java.lang.String
        public String field_953;
        public String value;

        public class_1510() {
            this.method_2134();
        }

        // $FF: renamed from: qM () com.google.android.gms.internal.pr$d[]
        public static class_164.class_1510[] method_2133() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            if(!this.field_953.equals("")) {
                var1.method_4710(1, this.field_953);
            }

            if(!this.value.equals("")) {
                var1.method_4710(2, this.value);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2135(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114();
            if(!this.field_953.equals("")) {
                var1 += class_909.method_4694(1, this.field_953);
            }

            if(!this.value.equals("")) {
                var1 += class_909.method_4694(2, this.value);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_164.class_1510;
                var3 = false;
                if(var2) {
                    class_164.class_1510 var4 = (class_164.class_1510)var1;
                    if(this.field_953 == null) {
                        String var6 = var4.field_953;
                        var3 = false;
                        if(var6 != null) {
                            return var3;
                        }
                    } else if(!this.field_953.equals(var4.field_953)) {
                        return false;
                    }

                    if(this.value == null) {
                        String var5 = var4.value;
                        var3 = false;
                        if(var5 != null) {
                            return var3;
                        }
                    } else if(!this.value.equals(var4.value)) {
                        return false;
                    }

                    return this.a(var4);
                }
            }

            return var3;
        }

        public int hashCode() {
            int var1;
            if(this.field_953 == null) {
                var1 = 0;
            } else {
                var1 = this.field_953.hashCode();
            }

            int var2 = 31 * (var1 + 527);
            String var3 = this.value;
            int var4 = 0;
            if(var3 != null) {
                var4 = this.value.hashCode();
            }

            return 31 * (var2 + var4) + this.qz();
        }

        // $FF: renamed from: qN () com.google.android.gms.internal.pr$d
        public class_164.class_1510 method_2134() {
            this.field_953 = "";
            this.value = "";
            this.awJ = null;
            this.awU = -1;
            return this;
        }

        // $FF: renamed from: y (com.google.android.gms.internal.pf) com.google.android.gms.internal.pr$d
        public class_164.class_1510 method_2135(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                switch(var2) {
                    case 10:
                        this.field_953 = var1.readString();
                        break;
                    case 18:
                        this.value = var1.readString();
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
