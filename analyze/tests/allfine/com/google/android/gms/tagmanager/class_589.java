package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_636;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.az
class class_589 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3101;
    private static final String apA;
    private static final String apB;
    private static final String apC;
    private static final String apf;

    static {
        field_3101 = class_530.field_2537.toString();
        apf = class_529.field_2308.toString();
        apA = class_529.field_2398.toString();
        apB = class_529.field_2402.toString();
        apC = class_529.field_2319.toString();
    }

    public class_589() {
        String var1 = field_3101;
        String[] var2 = new String[] {apf};
        super(var1, var2);
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.tagmanager.az$a, java.util.Set) java.lang.String
    private String method_3440(String var1, class_589.class_1790 var2, Set<Character> var3) {
        switch(null.apD[var2.ordinal()]) {
            case 1:
                try {
                    String var9 = class_636.method_3579(var1);
                    return var9;
                } catch (UnsupportedEncodingException var10) {
                    class_612.method_3460("Joiner: unsupported encoding", var10);
                    return var1;
                }
            case 2:
                String var4 = var1.replace("\\", "\\\\");
                Iterator var5 = var3.iterator();

                String var6;
                String var7;
                for(var6 = var4; var5.hasNext(); var6 = var6.replace(var7, "\\" + var7)) {
                    var7 = ((Character)var5.next()).toString();
                }

                return var6;
            default:
                return var1;
        }
    }

    // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String, com.google.android.gms.tagmanager.az$a, java.util.Set) void
    private void method_3441(StringBuilder var1, String var2, class_589.class_1790 var3, Set<Character> var4) {
        var1.append(this.method_3440(var2, var3, var4));
    }

    // $FF: renamed from: a (java.util.Set, java.lang.String) void
    private void method_3442(Set<Character> var1, String var2) {
        for(int var3 = 0; var3 < var2.length(); ++var3) {
            var1.add(Character.valueOf(var2.charAt(var3)));
        }

    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        class_53.class_1172 var2 = (class_53.class_1172)var1.get(apf);
        if(var2 == null) {
            return class_634.method_3556();
        } else {
            class_53.class_1172 var3 = (class_53.class_1172)var1.get(apA);
            String var4;
            if(var3 != null) {
                var4 = class_634.method_3543(var3);
            } else {
                var4 = "";
            }

            class_53.class_1172 var5 = (class_53.class_1172)var1.get(apB);
            String var6;
            if(var5 != null) {
                var6 = class_634.method_3543(var5);
            } else {
                var6 = "=";
            }

            class_589.class_1790 var7 = class_589.class_1790.apE;
            class_53.class_1172 var8 = (class_53.class_1172)var1.get(apC);
            class_589.class_1790 var9;
            HashSet var10;
            if(var8 != null) {
                String var23 = class_634.method_3543(var8);
                if("url".equals(var23)) {
                    var9 = class_589.class_1790.apF;
                    var10 = null;
                } else {
                    if(!"backslash".equals(var23)) {
                        class_612.method_3456("Joiner: unsupported escape type: " + var23);
                        return class_634.method_3556();
                    }

                    var9 = class_589.class_1790.apG;
                    var10 = new HashSet();
                    this.method_3442(var10, var4);
                    this.method_3442(var10, var6);
                    var10.remove(Character.valueOf('\\'));
                }
            } else {
                var9 = var7;
                var10 = null;
            }

            StringBuilder var11 = new StringBuilder();
            switch(var2.type) {
                case 2:
                    boolean var17 = true;
                    class_53.class_1172[] var18 = var2.field_1021;
                    int var19 = var18.length;

                    for(int var20 = 0; var20 < var19; var17 = false) {
                        class_53.class_1172 var21 = var18[var20];
                        if(!var17) {
                            var11.append(var4);
                        }

                        this.method_3441(var11, class_634.method_3543(var21), var9, var10);
                        ++var20;
                    }

                    return class_634.method_3561(var11.toString());
                case 3:
                    for(int var12 = 0; var12 < var2.field_1022.length; ++var12) {
                        if(var12 > 0) {
                            var11.append(var4);
                        }

                        String var13 = class_634.method_3543(var2.field_1022[var12]);
                        String var14 = class_634.method_3543(var2.field_1023[var12]);
                        this.method_3441(var11, var13, var9, var10);
                        var11.append(var6);
                        this.method_3441(var11, var14, var9, var10);
                    }

                    return class_634.method_3561(var11.toString());
                default:
                    this.method_3441(var11, class_634.method_3543(var2), var9, var10);
                    return class_634.method_3561(var11.toString());
            }
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }

    private static enum class_1790 {
        apE,
        apF,
        apG;

        static {
            class_589.class_1790[] var0 = new class_589.class_1790[]{apE, apF, apG};
        }
    }
}
