package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.cr
class class_638 {
    // $FF: renamed from: a (int, com.google.android.gms.internal.c$f, com.google.android.gms.internal.d$a[], java.util.Set) com.google.android.gms.internal.d$a
    private static class_53.class_1172 method_3588(int var0, class_51.class_1327 var1, class_53.class_1172[] var2, Set<Integer> var3) throws class_638.class_1811 {
        int var4 = 0;
        if(var3.contains(Integer.valueOf(var0))) {
            method_3594("Value cycle detected.  Current value reference: " + var0 + "." + "  Previous value references: " + var3 + ".");
        }

        class_53.class_1172 var5 = (class_53.class_1172)method_3591(var1.field_973, var0, "values");
        if(var2[var0] != null) {
            return var2[var0];
        } else {
            class_53.class_1172 var8;
            var3.add(Integer.valueOf(var0));
            int var7 = var5.type;
            var8 = null;
            label54:
            switch(var7) {
                case 1:
                case 5:
                case 6:
                case 8:
                    var8 = var5;
                    break;
                case 2:
                    class_51.class_1325 var31 = method_3596(var5);
                    var8 = method_3595(var5);
                    var8.field_1021 = new class_53.class_1172[var31.field_1000.length];
                    int[] var32 = var31.field_1000;
                    int var33 = var32.length;
                    int var34 = 0;

                    while(true) {
                        if(var4 >= var33) {
                            break label54;
                        }

                        int var35 = var32[var4];
                        class_53.class_1172[] var36 = var8.field_1021;
                        int var37 = var34 + 1;
                        var36[var34] = method_3588(var35, var1, var2, var3);
                        ++var4;
                        var34 = var37;
                    }
                case 3:
                    var8 = method_3595(var5);
                    class_51.class_1325 var17 = method_3596(var5);
                    if(var17.field_1001.length != var17.field_1002.length) {
                        method_3594("Uneven map keys (" + var17.field_1001.length + ") and map values (" + var17.field_1002.length + ")");
                    }

                    var8.field_1022 = new class_53.class_1172[var17.field_1001.length];
                    var8.field_1023 = new class_53.class_1172[var17.field_1001.length];
                    int[] var18 = var17.field_1001;
                    int var19 = var18.length;
                    int var20 = 0;

                    int var30;
                    for(int var21 = 0; var20 < var19; var21 = var30) {
                        int var28 = var18[var20];
                        class_53.class_1172[] var29 = var8.field_1022;
                        var30 = var21 + 1;
                        var29[var21] = method_3588(var28, var1, var2, var3);
                        ++var20;
                    }

                    int[] var22 = var17.field_1002;
                    int var23 = var22.length;
                    int var24 = 0;

                    while(true) {
                        if(var4 >= var23) {
                            break label54;
                        }

                        int var25 = var22[var4];
                        class_53.class_1172[] var26 = var8.field_1023;
                        int var27 = var24 + 1;
                        var26[var24] = method_3588(var25, var1, var2, var3);
                        ++var4;
                        var24 = var27;
                    }
                case 4:
                    var8 = method_3595(var5);
                    var8.field_1024 = class_634.method_3543(method_3588(method_3596(var5).field_1005, var1, var2, var3));
                    break;
                case 7:
                    var8 = method_3595(var5);
                    class_51.class_1325 var10 = method_3596(var5);
                    var8.field_1017 = new class_53.class_1172[var10.field_1004.length];
                    int[] var11 = var10.field_1004;
                    int var12 = var11.length;

                    int var16;
                    for(int var13 = 0; var4 < var12; var13 = var16) {
                        int var14 = var11[var4];
                        class_53.class_1172[] var15 = var8.field_1017;
                        var16 = var13 + 1;
                        var15[var13] = method_3588(var14, var1, var2, var3);
                        ++var4;
                    }
            }

            if(var8 == null) {
                method_3594("Invalid value: " + var5);
            }

            var2[var0] = var8;
            var3.remove(Integer.valueOf(var0));
            return var8;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.c$b, com.google.android.gms.internal.c$f, com.google.android.gms.internal.d$a[], int) com.google.android.gms.tagmanager.cr$a
    private static class_638.class_1805 method_3589(class_51.class_1331 var0, class_51.class_1327 var1, class_53.class_1172[] var2, int var3) throws class_638.class_1811 {
        class_638.class_1806 var4 = class_638.class_1805.method_5618();
        int[] var5 = var0.field_957;
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Integer var8 = Integer.valueOf(var5[var7]);
            class_51.class_1328 var9 = (class_51.class_1328)method_3591(var1.field_974, var8.intValue(), "properties");
            String var10 = (String)method_3591(var1.field_972, var9.key, "keys");
            class_53.class_1172 var11 = (class_53.class_1172)method_3591(var2, var9.value, "values");
            if(class_529.field_2444.toString().equals(var10)) {
                var4.method_5623(var11);
            } else {
                var4.method_5622(var10, var11);
            }
        }

        return var4.method_5624();
    }

    // $FF: renamed from: a (com.google.android.gms.internal.c$g, java.util.List, java.util.List, java.util.List, com.google.android.gms.internal.c$f) com.google.android.gms.tagmanager.cr$e
    private static class_638.class_1809 method_3590(class_51.class_1326 var0, List<class_638.class_1805> var1, List<class_638.class_1805> var2, List<class_638.class_1805> var3, class_51.class_1327 var4) {
        class_638.class_1810 var5 = class_638.class_1809.method_5648();
        int[] var6 = var0.field_988;
        int var7 = var6.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            var5.method_5637((class_638.class_1805)var3.get(Integer.valueOf(var6[var8]).intValue()));
        }

        int[] var9 = var0.field_989;
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            var5.method_5638((class_638.class_1805)var3.get(Integer.valueOf(var9[var11]).intValue()));
        }

        int[] var12 = var0.field_990;
        int var13 = var12.length;

        for(int var14 = 0; var14 < var13; ++var14) {
            var5.method_5643((class_638.class_1805)var1.get(Integer.valueOf(var12[var14]).intValue()));
        }

        int[] var15 = var0.field_992;
        int var16 = var15.length;

        for(int var17 = 0; var17 < var16; ++var17) {
            Integer var45 = Integer.valueOf(var15[var17]);
            var5.method_5639(var4.field_973[var45.intValue()].field_1020);
        }

        int[] var18 = var0.field_991;
        int var19 = var18.length;

        for(int var20 = 0; var20 < var19; ++var20) {
            var5.method_5644((class_638.class_1805)var1.get(Integer.valueOf(var18[var20]).intValue()));
        }

        int[] var21 = var0.field_993;
        int var22 = var21.length;

        for(int var23 = 0; var23 < var22; ++var23) {
            Integer var42 = Integer.valueOf(var21[var23]);
            var5.method_5640(var4.field_973[var42.intValue()].field_1020);
        }

        int[] var24 = var0.field_994;
        int var25 = var24.length;

        for(int var26 = 0; var26 < var25; ++var26) {
            var5.method_5645((class_638.class_1805)var2.get(Integer.valueOf(var24[var26]).intValue()));
        }

        int[] var27 = var0.field_996;
        int var28 = var27.length;

        for(int var29 = 0; var29 < var28; ++var29) {
            Integer var39 = Integer.valueOf(var27[var29]);
            var5.method_5641(var4.field_973[var39.intValue()].field_1020);
        }

        int[] var30 = var0.field_995;
        int var31 = var30.length;

        for(int var32 = 0; var32 < var31; ++var32) {
            var5.method_5646((class_638.class_1805)var2.get(Integer.valueOf(var30[var32]).intValue()));
        }

        int[] var33 = var0.field_997;
        int var34 = var33.length;

        for(int var35 = 0; var35 < var34; ++var35) {
            Integer var36 = Integer.valueOf(var33[var35]);
            var5.method_5642(var4.field_973[var36.intValue()].field_1020);
        }

        return var5.method_5647();
    }

    // $FF: renamed from: a (java.lang.Object[], int, java.lang.String) java.lang.Object
    private static <T> T method_3591(T[] var0, int var1, String var2) throws class_638.class_1811 {
        if(var1 < 0 || var1 >= var0.length) {
            method_3594("Index out of bounds detected: " + var1 + " in " + var2);
        }

        return var0[var1];
    }

    // $FF: renamed from: b (com.google.android.gms.internal.c$f) com.google.android.gms.tagmanager.cr$c
    public static class_638.class_1807 method_3592(class_51.class_1327 var0) throws class_638.class_1811 {
        int var1 = 0;
        class_53.class_1172[] var2 = new class_53.class_1172[var0.field_973.length];

        for(int var3 = 0; var3 < var0.field_973.length; ++var3) {
            method_3588(var3, var0, var2, new HashSet(0));
        }

        class_638.class_1808 var4 = class_638.class_1807.method_5664();
        ArrayList var5 = new ArrayList();

        for(int var6 = 0; var6 < var0.field_976.length; ++var6) {
            var5.add(method_3589(var0.field_976[var6], var0, var2, var6));
        }

        ArrayList var7 = new ArrayList();

        for(int var8 = 0; var8 < var0.field_977.length; ++var8) {
            var7.add(method_3589(var0.field_977[var8], var0, var2, var8));
        }

        ArrayList var9 = new ArrayList();

        for(int var10 = 0; var10 < var0.field_975.length; ++var10) {
            class_638.class_1805 var16 = method_3589(var0.field_975[var10], var0, var2, var10);
            var4.method_5659(var16);
            var9.add(var16);
        }

        class_51.class_1326[] var11 = var0.field_978;

        for(int var12 = var11.length; var1 < var12; ++var1) {
            var4.method_5660(method_3590(var11[var1], var5, var9, var7, var0));
        }

        var4.method_5661(var0.version);
        var4.method_5662(var0.field_986);
        return var4.method_5663();
    }

    // $FF: renamed from: b (java.io.InputStream, java.io.OutputStream) void
    public static void method_3593(InputStream var0, OutputStream var1) throws IOException {
        byte[] var2 = new byte[1024];

        while(true) {
            int var3 = var0.read(var2);
            if(var3 == -1) {
                return;
            }

            var1.write(var2, 0, var3);
        }
    }

    // $FF: renamed from: cL (java.lang.String) void
    private static void method_3594(String var0) throws class_638.class_1811 {
        class_612.method_3456(var0);
        throw new class_638.class_1811(var0);
    }

    // $FF: renamed from: g (com.google.android.gms.internal.d$a) com.google.android.gms.internal.d$a
    public static class_53.class_1172 method_3595(class_53.class_1172 var0) {
        class_53.class_1172 var1 = new class_53.class_1172();
        var1.type = var0.type;
        var1.field_1018 = (int[])var0.field_1018.clone();
        if(var0.field_1019) {
            var1.field_1019 = var0.field_1019;
        }

        return var1;
    }

    // $FF: renamed from: h (com.google.android.gms.internal.d$a) com.google.android.gms.internal.c$h
    private static class_51.class_1325 method_3596(class_53.class_1172 var0) throws class_638.class_1811 {
        if((class_51.class_1325)var0.a(class_51.class_1325.field_998) == null) {
            method_3594("Expected a ServingValue and didn\'t get one. Value is: " + var0);
        }

        return (class_51.class_1325)var0.a(class_51.class_1325.field_998);
    }

    public static class class_1805 {
        private final Map<String, class_53.class_1172> aqD;
        private final class_53.class_1172 aqE;

        private class_1805(Map<String, class_53.class_1172> var1, class_53.class_1172 var2) {
            this.aqD = var1;
            this.aqE = var2;
        }

        // $FF: synthetic method
        class_1805(Map var1, class_53.class_1172 var2, Object var3) {
            this(var1, var2);
        }

        // $FF: renamed from: oT () com.google.android.gms.tagmanager.cr$b
        public static class_638.class_1806 method_5618() {
            return new class_638.class_1806();
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.d$a) void
        public void method_5619(String var1, class_53.class_1172 var2) {
            this.aqD.put(var1, var2);
        }

        // $FF: renamed from: oU () java.util.Map
        public Map<String, class_53.class_1172> method_5620() {
            return Collections.unmodifiableMap(this.aqD);
        }

        // $FF: renamed from: oV () com.google.android.gms.internal.d$a
        public class_53.class_1172 method_5621() {
            return this.aqE;
        }

        public String toString() {
            return "Properties: " + this.method_5620() + " pushAfterEvaluate: " + this.aqE;
        }
    }

    public static class class_1806 {
        private final Map<String, class_53.class_1172> aqD;
        private class_53.class_1172 aqE;

        private class_1806() {
            this.aqD = new HashMap();
        }

        // $FF: synthetic method
        class_1806(Object var1) {
            this();
        }

        // $FF: renamed from: b (java.lang.String, com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.cr$b
        public class_638.class_1806 method_5622(String var1, class_53.class_1172 var2) {
            this.aqD.put(var1, var2);
            return this;
        }

        // $FF: renamed from: i (com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.cr$b
        public class_638.class_1806 method_5623(class_53.class_1172 var1) {
            this.aqE = var1;
            return this;
        }

        // $FF: renamed from: oW () com.google.android.gms.tagmanager.cr$a
        public class_638.class_1805 method_5624() {
            return new class_638.class_1805(this.aqD, this.aqE);
        }
    }

    public static class class_1807 {
        // $FF: renamed from: Sx java.lang.String
        private final String field_5126;
        private final List<class_638.class_1809> aqF;
        private final Map<String, List<class_638.class_1805>> aqG;
        private final int aqH;

        private class_1807(List<class_638.class_1809> var1, Map<String, List<class_638.class_1805>> var2, String var3, int var4) {
            this.aqF = Collections.unmodifiableList(var1);
            this.aqG = Collections.unmodifiableMap(var2);
            this.field_5126 = var3;
            this.aqH = var4;
        }

        // $FF: synthetic method
        class_1807(List var1, Map var2, String var3, int var4, Object var5) {
            this(var1, var2, var3, var4);
        }

        // $FF: renamed from: oX () com.google.android.gms.tagmanager.cr$d
        public static class_638.class_1808 method_5664() {
            return new class_638.class_1808();
        }

        public String getVersion() {
            return this.field_5126;
        }

        // $FF: renamed from: oY () java.util.List
        public List<class_638.class_1809> method_5665() {
            return this.aqF;
        }

        // $FF: renamed from: oZ () java.util.Map
        public Map<String, List<class_638.class_1805>> method_5666() {
            return this.aqG;
        }

        public String toString() {
            return "Rules: " + this.method_5665() + "  Macros: " + this.aqG;
        }
    }

    public static class class_1808 {
        // $FF: renamed from: Sx java.lang.String
        private String field_5125;
        private final List<class_638.class_1809> aqF;
        private final Map<String, List<class_638.class_1805>> aqG;
        private int aqH;

        private class_1808() {
            this.aqF = new ArrayList();
            this.aqG = new HashMap();
            this.field_5125 = "";
            this.aqH = 0;
        }

        // $FF: synthetic method
        class_1808(Object var1) {
            this();
        }

        // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$d
        public class_638.class_1808 method_5659(class_638.class_1805 var1) {
            String var2 = class_634.method_3543((class_53.class_1172)var1.method_5620().get(class_529.field_2395.toString()));
            Object var3 = (List)this.aqG.get(var2);
            if(var3 == null) {
                var3 = new ArrayList();
                this.aqG.put(var2, var3);
            }

            ((List)var3).add(var1);
            return this;
        }

        // $FF: renamed from: a (com.google.android.gms.tagmanager.cr$e) com.google.android.gms.tagmanager.cr$d
        public class_638.class_1808 method_5660(class_638.class_1809 var1) {
            this.aqF.add(var1);
            return this;
        }

        // $FF: renamed from: cM (java.lang.String) com.google.android.gms.tagmanager.cr$d
        public class_638.class_1808 method_5661(String var1) {
            this.field_5125 = var1;
            return this;
        }

        // $FF: renamed from: fm (int) com.google.android.gms.tagmanager.cr$d
        public class_638.class_1808 method_5662(int var1) {
            this.aqH = var1;
            return this;
        }

        // $FF: renamed from: pa () com.google.android.gms.tagmanager.cr$c
        public class_638.class_1807 method_5663() {
            return new class_638.class_1807(this.aqF, this.aqG, this.field_5125, this.aqH);
        }
    }

    public static class class_1809 {
        private final List<class_638.class_1805> aqI;
        private final List<class_638.class_1805> aqJ;
        private final List<class_638.class_1805> aqK;
        private final List<class_638.class_1805> aqL;
        private final List<class_638.class_1805> aqM;
        private final List<class_638.class_1805> aqN;
        private final List<String> aqO;
        private final List<String> aqP;
        private final List<String> aqQ;
        private final List<String> aqR;

        private class_1809(List<class_638.class_1805> var1, List<class_638.class_1805> var2, List<class_638.class_1805> var3, List<class_638.class_1805> var4, List<class_638.class_1805> var5, List<class_638.class_1805> var6, List<String> var7, List<String> var8, List<String> var9, List<String> var10) {
            this.aqI = Collections.unmodifiableList(var1);
            this.aqJ = Collections.unmodifiableList(var2);
            this.aqK = Collections.unmodifiableList(var3);
            this.aqL = Collections.unmodifiableList(var4);
            this.aqM = Collections.unmodifiableList(var5);
            this.aqN = Collections.unmodifiableList(var6);
            this.aqO = Collections.unmodifiableList(var7);
            this.aqP = Collections.unmodifiableList(var8);
            this.aqQ = Collections.unmodifiableList(var9);
            this.aqR = Collections.unmodifiableList(var10);
        }

        // $FF: synthetic method
        class_1809(List var1, List var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, Object var11) {
            this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
        }

        // $FF: renamed from: pb () com.google.android.gms.tagmanager.cr$f
        public static class_638.class_1810 method_5648() {
            return new class_638.class_1810();
        }

        // $FF: renamed from: pc () java.util.List
        public List<class_638.class_1805> method_5649() {
            return this.aqI;
        }

        // $FF: renamed from: pd () java.util.List
        public List<class_638.class_1805> method_5650() {
            return this.aqJ;
        }

        // $FF: renamed from: pe () java.util.List
        public List<class_638.class_1805> method_5651() {
            return this.aqK;
        }

        // $FF: renamed from: pf () java.util.List
        public List<class_638.class_1805> method_5652() {
            return this.aqL;
        }

        // $FF: renamed from: pg () java.util.List
        public List<class_638.class_1805> method_5653() {
            return this.aqM;
        }

        // $FF: renamed from: ph () java.util.List
        public List<String> method_5654() {
            return this.aqO;
        }

        // $FF: renamed from: pi () java.util.List
        public List<String> method_5655() {
            return this.aqP;
        }

        // $FF: renamed from: pj () java.util.List
        public List<String> method_5656() {
            return this.aqQ;
        }

        // $FF: renamed from: pk () java.util.List
        public List<String> method_5657() {
            return this.aqR;
        }

        // $FF: renamed from: pl () java.util.List
        public List<class_638.class_1805> method_5658() {
            return this.aqN;
        }

        public String toString() {
            return "Positive predicates: " + this.method_5649() + "  Negative predicates: " + this.method_5650() + "  Add tags: " + this.method_5651() + "  Remove tags: " + this.method_5652() + "  Add macros: " + this.method_5653() + "  Remove macros: " + this.method_5658();
        }
    }

    public static class class_1810 {
        private final List<class_638.class_1805> aqI;
        private final List<class_638.class_1805> aqJ;
        private final List<class_638.class_1805> aqK;
        private final List<class_638.class_1805> aqL;
        private final List<class_638.class_1805> aqM;
        private final List<class_638.class_1805> aqN;
        private final List<String> aqO;
        private final List<String> aqP;
        private final List<String> aqQ;
        private final List<String> aqR;

        private class_1810() {
            this.aqI = new ArrayList();
            this.aqJ = new ArrayList();
            this.aqK = new ArrayList();
            this.aqL = new ArrayList();
            this.aqM = new ArrayList();
            this.aqN = new ArrayList();
            this.aqO = new ArrayList();
            this.aqP = new ArrayList();
            this.aqQ = new ArrayList();
            this.aqR = new ArrayList();
        }

        // $FF: synthetic method
        class_1810(Object var1) {
            this();
        }

        // $FF: renamed from: b (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5637(class_638.class_1805 var1) {
            this.aqI.add(var1);
            return this;
        }

        // $FF: renamed from: c (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5638(class_638.class_1805 var1) {
            this.aqJ.add(var1);
            return this;
        }

        // $FF: renamed from: cN (java.lang.String) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5639(String var1) {
            this.aqQ.add(var1);
            return this;
        }

        // $FF: renamed from: cO (java.lang.String) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5640(String var1) {
            this.aqR.add(var1);
            return this;
        }

        // $FF: renamed from: cP (java.lang.String) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5641(String var1) {
            this.aqO.add(var1);
            return this;
        }

        // $FF: renamed from: cQ (java.lang.String) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5642(String var1) {
            this.aqP.add(var1);
            return this;
        }

        // $FF: renamed from: d (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5643(class_638.class_1805 var1) {
            this.aqK.add(var1);
            return this;
        }

        // $FF: renamed from: e (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5644(class_638.class_1805 var1) {
            this.aqL.add(var1);
            return this;
        }

        // $FF: renamed from: f (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5645(class_638.class_1805 var1) {
            this.aqM.add(var1);
            return this;
        }

        // $FF: renamed from: g (com.google.android.gms.tagmanager.cr$a) com.google.android.gms.tagmanager.cr$f
        public class_638.class_1810 method_5646(class_638.class_1805 var1) {
            this.aqN.add(var1);
            return this;
        }

        // $FF: renamed from: pm () com.google.android.gms.tagmanager.cr$e
        public class_638.class_1809 method_5647() {
            return new class_638.class_1809(this.aqI, this.aqJ, this.aqK, this.aqL, this.aqM, this.aqN, this.aqO, this.aqP, this.aqQ, this.aqR);
        }
    }

    public static class class_1811 extends Exception {
        public class_1811(String var1) {
            super(var1);
        }
    }
}
