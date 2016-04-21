package com.google.android.gms.internal;

import com.google.android.gms.internal.class_307;
import com.google.android.gms.internal.class_900;
import com.google.android.gms.internal.class_905;
import com.google.android.gms.internal.class_908;
import com.google.android.gms.internal.class_909;
import com.google.android.gms.internal.ph;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.d
public interface class_53 {
    public static final class class_1172 extends ph<class_53.class_1172> {
        // $FF: renamed from: gu com.google.android.gms.internal.d$a[]
        private static volatile class_53.class_1172[] field_1013;
        // $FF: renamed from: gA java.lang.String
        public String field_1014;
        // $FF: renamed from: gB long
        public long field_1015;
        // $FF: renamed from: gC boolean
        public boolean field_1016;
        // $FF: renamed from: gD com.google.android.gms.internal.d$a[]
        public class_53.class_1172[] field_1017;
        // $FF: renamed from: gE int[]
        public int[] field_1018;
        // $FF: renamed from: gF boolean
        public boolean field_1019;
        // $FF: renamed from: gv java.lang.String
        public String field_1020;
        // $FF: renamed from: gw com.google.android.gms.internal.d$a[]
        public class_53.class_1172[] field_1021;
        // $FF: renamed from: gx com.google.android.gms.internal.d$a[]
        public class_53.class_1172[] field_1022;
        // $FF: renamed from: gy com.google.android.gms.internal.d$a[]
        public class_53.class_1172[] field_1023;
        // $FF: renamed from: gz java.lang.String
        public String field_1024;
        public int type;

        public class_1172() {
            this.method_2181();
        }

        // $FF: renamed from: r () com.google.android.gms.internal.d$a[]
        public static class_53.class_1172[] method_2179() {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.pg) void
        public void method_2112(class_909 var1) throws IOException {
            var1.method_4727(1, this.type);
            if(!this.field_1020.equals("")) {
                var1.method_4710(2, this.field_1020);
            }

            if(this.field_1021 != null && this.field_1021.length > 0) {
                for(int var10 = 0; var10 < this.field_1021.length; ++var10) {
                    class_53.class_1172 var11 = this.field_1021[var10];
                    if(var11 != null) {
                        var1.method_4705(3, var11);
                    }
                }
            }

            if(this.field_1022 != null && this.field_1022.length > 0) {
                for(int var8 = 0; var8 < this.field_1022.length; ++var8) {
                    class_53.class_1172 var9 = this.field_1022[var8];
                    if(var9 != null) {
                        var1.method_4705(4, var9);
                    }
                }
            }

            if(this.field_1023 != null && this.field_1023.length > 0) {
                for(int var6 = 0; var6 < this.field_1023.length; ++var6) {
                    class_53.class_1172 var7 = this.field_1023[var6];
                    if(var7 != null) {
                        var1.method_4705(5, var7);
                    }
                }
            }

            if(!this.field_1024.equals("")) {
                var1.method_4710(6, this.field_1024);
            }

            if(!this.field_1014.equals("")) {
                var1.method_4710(7, this.field_1014);
            }

            if(this.field_1015 != 0L) {
                var1.method_4709(8, this.field_1015);
            }

            if(this.field_1019) {
                var1.method_4711(9, this.field_1019);
            }

            if(this.field_1018 != null && this.field_1018.length > 0) {
                for(int var5 = 0; var5 < this.field_1018.length; ++var5) {
                    var1.method_4727(10, this.field_1018[var5]);
                }
            }

            if(this.field_1017 != null) {
                int var2 = this.field_1017.length;
                int var3 = 0;
                if(var2 > 0) {
                    for(; var3 < this.field_1017.length; ++var3) {
                        class_53.class_1172 var4 = this.field_1017[var3];
                        if(var4 != null) {
                            var1.method_4705(11, var4);
                        }
                    }
                }
            }

            if(this.field_1016) {
                var1.method_4711(12, this.field_1016);
            }

            super.method_2112(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.internal.pf) com.google.android.gms.internal.pn
        // $FF: synthetic method
        public class_307 method_2113(class_908 var1) throws IOException {
            return this.method_2180(var1);
        }

        // $FF: renamed from: c () int
        protected int method_2114() {
            int var1 = super.method_2114() + class_909.method_4697(1, this.type);
            if(!this.field_1020.equals("")) {
                var1 += class_909.method_4694(2, this.field_1020);
            }

            if(this.field_1021 != null && this.field_1021.length > 0) {
                int var13 = var1;

                for(int var14 = 0; var14 < this.field_1021.length; ++var14) {
                    class_53.class_1172 var15 = this.field_1021[var14];
                    if(var15 != null) {
                        var13 += class_909.method_4680(3, var15);
                    }
                }

                var1 = var13;
            }

            if(this.field_1022 != null && this.field_1022.length > 0) {
                int var10 = var1;

                for(int var11 = 0; var11 < this.field_1022.length; ++var11) {
                    class_53.class_1172 var12 = this.field_1022[var11];
                    if(var12 != null) {
                        var10 += class_909.method_4680(4, var12);
                    }
                }

                var1 = var10;
            }

            if(this.field_1023 != null && this.field_1023.length > 0) {
                int var7 = var1;

                for(int var8 = 0; var8 < this.field_1023.length; ++var8) {
                    class_53.class_1172 var9 = this.field_1023[var8];
                    if(var9 != null) {
                        var7 += class_909.method_4680(5, var9);
                    }
                }

                var1 = var7;
            }

            if(!this.field_1024.equals("")) {
                var1 += class_909.method_4694(6, this.field_1024);
            }

            if(!this.field_1014.equals("")) {
                var1 += class_909.method_4694(7, this.field_1014);
            }

            if(this.field_1015 != 0L) {
                var1 += class_909.method_4682(8, this.field_1015);
            }

            if(this.field_1019) {
                var1 += class_909.method_4681(9, this.field_1019);
            }

            if(this.field_1018 != null && this.field_1018.length > 0) {
                int var5 = 0;

                int var6;
                for(var6 = 0; var5 < this.field_1018.length; ++var5) {
                    var6 += class_909.method_4691(this.field_1018[var5]);
                }

                var1 = var1 + var6 + 1 * this.field_1018.length;
            }

            if(this.field_1017 != null) {
                int var2 = this.field_1017.length;
                int var3 = 0;
                if(var2 > 0) {
                    for(; var3 < this.field_1017.length; ++var3) {
                        class_53.class_1172 var4 = this.field_1017[var3];
                        if(var4 != null) {
                            var1 += class_909.method_4680(11, var4);
                        }
                    }
                }
            }

            if(this.field_1016) {
                var1 += class_909.method_4681(12, this.field_1016);
            }

            return var1;
        }

        public boolean equals(Object var1) {
            boolean var3;
            if(var1 == this) {
                var3 = true;
            } else {
                boolean var2 = var1 instanceof class_53.class_1172;
                var3 = false;
                if(var2) {
                    class_53.class_1172 var4 = (class_53.class_1172)var1;
                    int var5 = this.type;
                    int var6 = var4.type;
                    var3 = false;
                    if(var5 == var6) {
                        if(this.field_1020 == null) {
                            String var19 = var4.field_1020;
                            var3 = false;
                            if(var19 != null) {
                                return var3;
                            }
                        } else if(!this.field_1020.equals(var4.field_1020)) {
                            return false;
                        }

                        boolean var7 = class_900.equals((Object[])this.field_1021, (Object[])var4.field_1021);
                        var3 = false;
                        if(var7) {
                            boolean var8 = class_900.equals((Object[])this.field_1022, (Object[])var4.field_1022);
                            var3 = false;
                            if(var8) {
                                boolean var9 = class_900.equals((Object[])this.field_1023, (Object[])var4.field_1023);
                                var3 = false;
                                if(var9) {
                                    if(this.field_1024 == null) {
                                        String var18 = var4.field_1024;
                                        var3 = false;
                                        if(var18 != null) {
                                            return var3;
                                        }
                                    } else if(!this.field_1024.equals(var4.field_1024)) {
                                        return false;
                                    }

                                    if(this.field_1014 == null) {
                                        String var17 = var4.field_1014;
                                        var3 = false;
                                        if(var17 != null) {
                                            return var3;
                                        }
                                    } else if(!this.field_1014.equals(var4.field_1014)) {
                                        return false;
                                    }

                                    long var20;
                                    int var10 = (var20 = this.field_1015 - var4.field_1015) == 0L?0:(var20 < 0L?-1:1);
                                    var3 = false;
                                    if(var10 == 0) {
                                        boolean var11 = this.field_1016;
                                        boolean var12 = var4.field_1016;
                                        var3 = false;
                                        if(var11 == var12) {
                                            boolean var13 = class_900.equals((Object[])this.field_1017, (Object[])var4.field_1017);
                                            var3 = false;
                                            if(var13) {
                                                boolean var14 = class_900.equals(this.field_1018, var4.field_1018);
                                                var3 = false;
                                                if(var14) {
                                                    boolean var15 = this.field_1019;
                                                    boolean var16 = var4.field_1019;
                                                    var3 = false;
                                                    if(var15 == var16) {
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

            return var3;
        }

        public int hashCode() {
            short var1 = 1231;
            int var2 = 31 * (527 + this.type);
            int var3;
            if(this.field_1020 == null) {
                var3 = 0;
            } else {
                var3 = this.field_1020.hashCode();
            }

            int var4 = 31 * (31 * (31 * (31 * (var3 + var2) + class_900.hashCode((Object[])this.field_1021)) + class_900.hashCode((Object[])this.field_1022)) + class_900.hashCode((Object[])this.field_1023));
            int var5;
            if(this.field_1024 == null) {
                var5 = 0;
            } else {
                var5 = this.field_1024.hashCode();
            }

            int var6 = 31 * (var5 + var4);
            String var7 = this.field_1014;
            int var8 = 0;
            if(var7 != null) {
                var8 = this.field_1014.hashCode();
            }

            int var9 = 31 * (31 * (var6 + var8) + (int)(this.field_1015 ^ this.field_1015 >>> 32));
            short var10;
            if(this.field_1016) {
                var10 = var1;
            } else {
                var10 = 1237;
            }

            int var11 = 31 * (31 * (31 * (var10 + var9) + class_900.hashCode((Object[])this.field_1017)) + class_900.hashCode(this.field_1018));
            if(!this.field_1019) {
                var1 = 1237;
            }

            return 31 * (var11 + var1) + this.qz();
        }

        // $FF: renamed from: l (com.google.android.gms.internal.pf) com.google.android.gms.internal.d$a
        public class_53.class_1172 method_2180(class_908 var1) throws IOException {
            while(true) {
                int var2 = var1.method_4655();
                int var32;
                class_53.class_1172[] var33;
                switch(var2) {
                    case 8:
                        int var35 = var1.method_4658();
                        switch(var35) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = var35;
                            default:
                                continue;
                        }
                    case 18:
                        this.field_1020 = var1.readString();
                        continue;
                    case 26:
                        int var31 = class_905.method_4635(var1, 26);
                        if(this.field_1021 == null) {
                            var32 = 0;
                        } else {
                            var32 = this.field_1021.length;
                        }

                        var33 = new class_53.class_1172[var31 + var32];
                        if(var32 != 0) {
                            System.arraycopy(this.field_1021, 0, var33, 0, var32);
                        }
                        break;
                    case 34:
                        int var27 = class_905.method_4635(var1, 34);
                        int var28;
                        if(this.field_1022 == null) {
                            var28 = 0;
                        } else {
                            var28 = this.field_1022.length;
                        }

                        class_53.class_1172[] var29 = new class_53.class_1172[var27 + var28];
                        if(var28 != 0) {
                            System.arraycopy(this.field_1022, 0, var29, 0, var28);
                        }

                        while(var28 < -1 + var29.length) {
                            var29[var28] = new class_53.class_1172();
                            var1.method_4646(var29[var28]);
                            var1.method_4655();
                            ++var28;
                        }

                        var29[var28] = new class_53.class_1172();
                        var1.method_4646(var29[var28]);
                        this.field_1022 = var29;
                        continue;
                    case 42:
                        int var23 = class_905.method_4635(var1, 42);
                        int var24;
                        if(this.field_1023 == null) {
                            var24 = 0;
                        } else {
                            var24 = this.field_1023.length;
                        }

                        class_53.class_1172[] var25 = new class_53.class_1172[var23 + var24];
                        if(var24 != 0) {
                            System.arraycopy(this.field_1023, 0, var25, 0, var24);
                        }

                        while(var24 < -1 + var25.length) {
                            var25[var24] = new class_53.class_1172();
                            var1.method_4646(var25[var24]);
                            var1.method_4655();
                            ++var24;
                        }

                        var25[var24] = new class_53.class_1172();
                        var1.method_4646(var25[var24]);
                        this.field_1023 = var25;
                        continue;
                    case 50:
                        this.field_1024 = var1.readString();
                        continue;
                    case 58:
                        this.field_1014 = var1.readString();
                        continue;
                    case 64:
                        this.field_1015 = var1.method_4657();
                        continue;
                    case 72:
                        this.field_1019 = var1.method_4659();
                        continue;
                    case 80:
                        int var14 = class_905.method_4635(var1, 80);
                        int[] var15 = new int[var14];
                        int var16 = 0;

                        int var17;
                        int var21;
                        for(var17 = 0; var16 < var14; var17 = var21) {
                            if(var16 != 0) {
                                var1.method_4655();
                            }

                            int var20 = var1.method_4658();
                            switch(var20) {
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
                                    var21 = var17 + 1;
                                    var15[var17] = var20;
                                    break;
                                default:
                                    var21 = var17;
                            }

                            ++var16;
                        }

                        if(var17 == 0) {
                            continue;
                        }

                        int var18;
                        if(this.field_1018 == null) {
                            var18 = 0;
                        } else {
                            var18 = this.field_1018.length;
                        }

                        if(var18 == 0 && var17 == var15.length) {
                            this.field_1018 = var15;
                            continue;
                        }

                        int[] var19 = new int[var18 + var17];
                        if(var18 != 0) {
                            System.arraycopy(this.field_1018, 0, var19, 0, var18);
                        }

                        System.arraycopy(var15, 0, var19, var18, var17);
                        this.field_1018 = var19;
                        continue;
                    case 82:
                        int var7 = var1.method_4650(var1.method_4662());
                        int var8 = var1.getPosition();
                        int var9 = 0;

                        while(var1.method_4666() > 0) {
                            switch(var1.method_4658()) {
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
                                    ++var9;
                            }
                        }

                        if(var9 != 0) {
                            var1.method_4652(var8);
                            int var10;
                            if(this.field_1018 == null) {
                                var10 = 0;
                            } else {
                                var10 = this.field_1018.length;
                            }

                            int[] var11 = new int[var9 + var10];
                            if(var10 != 0) {
                                System.arraycopy(this.field_1018, 0, var11, 0, var10);
                            }

                            while(var1.method_4666() > 0) {
                                int var12 = var1.method_4658();
                                switch(var12) {
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
                                        int var13 = var10 + 1;
                                        var11[var10] = var12;
                                        var10 = var13;
                                }
                            }

                            this.field_1018 = var11;
                        }

                        var1.method_4651(var7);
                        continue;
                    case 90:
                        int var3 = class_905.method_4635(var1, 90);
                        int var4;
                        if(this.field_1017 == null) {
                            var4 = 0;
                        } else {
                            var4 = this.field_1017.length;
                        }

                        class_53.class_1172[] var5 = new class_53.class_1172[var3 + var4];
                        if(var4 != 0) {
                            System.arraycopy(this.field_1017, 0, var5, 0, var4);
                        }

                        while(var4 < -1 + var5.length) {
                            var5[var4] = new class_53.class_1172();
                            var1.method_4646(var5[var4]);
                            var1.method_4655();
                            ++var4;
                        }

                        var5[var4] = new class_53.class_1172();
                        var1.method_4646(var5[var4]);
                        this.field_1017 = var5;
                        continue;
                    case 96:
                        this.field_1016 = var1.method_4659();
                        continue;
                    default:
                        if(this.a(var1, var2)) {
                            continue;
                        }
                    case 0:
                        return this;
                }

                while(var32 < -1 + var33.length) {
                    var33[var32] = new class_53.class_1172();
                    var1.method_4646(var33[var32]);
                    var1.method_4655();
                    ++var32;
                }

                var33[var32] = new class_53.class_1172();
                var1.method_4646(var33[var32]);
                this.field_1021 = var33;
            }
        }

        // $FF: renamed from: s () com.google.android.gms.internal.d$a
        public class_53.class_1172 method_2181() {
            this.type = 1;
            this.field_1020 = "";
            this.field_1021 = method_2179();
            this.field_1022 = method_2179();
            this.field_1023 = method_2179();
            this.field_1024 = "";
            this.field_1014 = "";
            this.field_1015 = 0L;
            this.field_1016 = false;
            this.field_1017 = method_2179();
            this.field_1018 = class_905.awW;
            this.field_1019 = false;
            this.awJ = null;
            this.awU = -1;
            return this;
        }
    }
}
