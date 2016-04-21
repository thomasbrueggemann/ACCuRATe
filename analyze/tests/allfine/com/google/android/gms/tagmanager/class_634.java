package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_635;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.tagmanager.di
class class_634 {
    private static final Object arU = null;
    private static Long arV = new Long(0L);
    private static Double arW = new Double(0.0D);
    private static class_635 arX = class_635.method_3567(0L);
    private static String arY = new String("");
    private static Boolean arZ = new Boolean(false);
    private static List<Object> asa = new ArrayList(0);
    private static Map<Object, Object> asb = new HashMap();
    private static class_53.class_1172 asc;

    static {
        asc = method_3561(arY);
    }

    // $FF: renamed from: cX (java.lang.String) com.google.android.gms.internal.d$a
    public static class_53.class_1172 method_3538(String var0) {
        class_53.class_1172 var1 = new class_53.class_1172();
        var1.type = 5;
        var1.field_1014 = var0;
        return var1;
    }

    // $FF: renamed from: cY (java.lang.String) com.google.android.gms.tagmanager.dh
    private static class_635 method_3539(String var0) {
        try {
            class_635 var2 = class_635.method_3566(var0);
            return var2;
        } catch (NumberFormatException var3) {
            class_612.method_3456("Failed to convert \'" + var0 + "\' to a number.");
            return arX;
        }
    }

    // $FF: renamed from: cZ (java.lang.String) java.lang.Long
    private static Long method_3540(String var0) {
        class_635 var1 = method_3539(var0);
        return var1 == arX?arV:Long.valueOf(var1.longValue());
    }

    // $FF: renamed from: da (java.lang.String) java.lang.Double
    private static Double method_3541(String var0) {
        class_635 var1 = method_3539(var0);
        return var1 == arX?arW:Double.valueOf(var1.doubleValue());
    }

    // $FF: renamed from: db (java.lang.String) java.lang.Boolean
    private static Boolean method_3542(String var0) {
        return "true".equalsIgnoreCase(var0)?Boolean.TRUE:("false".equalsIgnoreCase(var0)?Boolean.FALSE:arZ);
    }

    private static double getDouble(Object var0) {
        if(var0 instanceof Number) {
            return ((Number)var0).doubleValue();
        } else {
            class_612.method_3456("getDouble received non-Number");
            return 0.0D;
        }
    }

    // $FF: renamed from: j (com.google.android.gms.internal.d$a) java.lang.String
    public static String method_3543(class_53.class_1172 var0) {
        return method_3549(method_3548(var0));
    }

    // $FF: renamed from: k (com.google.android.gms.internal.d$a) com.google.android.gms.tagmanager.dh
    public static class_635 method_3544(class_53.class_1172 var0) {
        return method_3557(method_3548(var0));
    }

    // $FF: renamed from: l (com.google.android.gms.internal.d$a) java.lang.Long
    public static Long method_3545(class_53.class_1172 var0) {
        return method_3558(method_3548(var0));
    }

    // $FF: renamed from: m (com.google.android.gms.internal.d$a) java.lang.Double
    public static Double method_3546(class_53.class_1172 var0) {
        return method_3559(method_3548(var0));
    }

    // $FF: renamed from: n (com.google.android.gms.internal.d$a) java.lang.Boolean
    public static Boolean method_3547(class_53.class_1172 var0) {
        return method_3560(method_3548(var0));
    }

    // $FF: renamed from: o (com.google.android.gms.internal.d$a) java.lang.Object
    public static Object method_3548(class_53.class_1172 var0) {
        int var1 = 0;
        if(var0 == null) {
            return arU;
        } else {
            switch(var0.type) {
                case 1:
                    return var0.field_1020;
                case 2:
                    ArrayList var11 = new ArrayList(var0.field_1021.length);
                    class_53.class_1172[] var12 = var0.field_1021;

                    for(int var13 = var12.length; var1 < var13; ++var1) {
                        Object var14 = method_3548(var12[var1]);
                        if(var14 == arU) {
                            return arU;
                        }

                        var11.add(var14);
                    }

                    return var11;
                case 3:
                    if(var0.field_1022.length != var0.field_1023.length) {
                        class_612.method_3456("Converting an invalid value to object: " + var0.toString());
                        return arU;
                    } else {
                        HashMap var7;
                        for(var7 = new HashMap(var0.field_1023.length); var1 < var0.field_1022.length; ++var1) {
                            Object var8 = method_3548(var0.field_1022[var1]);
                            Object var9 = method_3548(var0.field_1023[var1]);
                            if(var8 == arU || var9 == arU) {
                                return arU;
                            }

                            var7.put(var8, var9);
                        }

                        return var7;
                    }
                case 4:
                    class_612.method_3456("Trying to convert a macro reference to object");
                    return arU;
                case 5:
                    class_612.method_3456("Trying to convert a function id to object");
                    return arU;
                case 6:
                    return Long.valueOf(var0.field_1015);
                case 7:
                    StringBuffer var2 = new StringBuffer();
                    class_53.class_1172[] var3 = var0.field_1017;

                    for(int var4 = var3.length; var1 < var4; ++var1) {
                        String var5 = method_3543(var3[var1]);
                        if(var5 == arY) {
                            return arU;
                        }

                        var2.append(var5);
                    }

                    return var2.toString();
                case 8:
                    return Boolean.valueOf(var0.field_1016);
                default:
                    class_612.method_3456("Failed to convert a value of type: " + var0.type);
                    return arU;
            }
        }
    }

    // $FF: renamed from: p (java.lang.Object) java.lang.String
    public static String method_3549(Object var0) {
        return var0 == null?arY:var0.toString();
    }

    // $FF: renamed from: pE () java.lang.Object
    public static Object method_3550() {
        return arU;
    }

    // $FF: renamed from: pF () java.lang.Long
    public static Long method_3551() {
        return arV;
    }

    // $FF: renamed from: pG () java.lang.Double
    public static Double method_3552() {
        return arW;
    }

    // $FF: renamed from: pH () java.lang.Boolean
    public static Boolean method_3553() {
        return arZ;
    }

    // $FF: renamed from: pI () com.google.android.gms.tagmanager.dh
    public static class_635 method_3554() {
        return arX;
    }

    // $FF: renamed from: pJ () java.lang.String
    public static String method_3555() {
        return arY;
    }

    // $FF: renamed from: pK () com.google.android.gms.internal.d$a
    public static class_53.class_1172 method_3556() {
        return asc;
    }

    // $FF: renamed from: q (java.lang.Object) com.google.android.gms.tagmanager.dh
    public static class_635 method_3557(Object var0) {
        return var0 instanceof class_635?(class_635)var0:(method_3563(var0)?class_635.method_3567(method_3564(var0)):(method_3562(var0)?class_635.method_3565(Double.valueOf(getDouble(var0))):method_3539(method_3549(var0))));
    }

    // $FF: renamed from: r (java.lang.Object) java.lang.Long
    public static Long method_3558(Object var0) {
        return method_3563(var0)?Long.valueOf(method_3564(var0)):method_3540(method_3549(var0));
    }

    // $FF: renamed from: s (java.lang.Object) java.lang.Double
    public static Double method_3559(Object var0) {
        return method_3562(var0)?Double.valueOf(getDouble(var0)):method_3541(method_3549(var0));
    }

    // $FF: renamed from: t (java.lang.Object) java.lang.Boolean
    public static Boolean method_3560(Object var0) {
        return var0 instanceof Boolean?(Boolean)var0:method_3542(method_3549(var0));
    }

    // $FF: renamed from: u (java.lang.Object) com.google.android.gms.internal.d$a
    public static class_53.class_1172 method_3561(Object var0) {
        boolean var1 = false;
        class_53.class_1172 var2 = new class_53.class_1172();
        if(var0 instanceof class_53.class_1172) {
            return (class_53.class_1172)var0;
        } else {
            if(var0 instanceof String) {
                var2.type = 1;
                var2.field_1020 = (String)var0;
            } else if(var0 instanceof List) {
                var2.type = 2;
                List var16 = (List)var0;
                ArrayList var17 = new ArrayList(var16.size());
                Iterator var18 = var16.iterator();

                boolean var19;
                boolean var21;
                for(var19 = false; var18.hasNext(); var19 = var21) {
                    class_53.class_1172 var20 = method_3561(var18.next());
                    if(var20 == asc) {
                        return asc;
                    }

                    if(!var19 && !var20.field_1019) {
                        var21 = false;
                    } else {
                        var21 = true;
                    }

                    var17.add(var20);
                }

                var2.field_1021 = (class_53.class_1172[])var17.toArray(new class_53.class_1172[0]);
                var1 = var19;
            } else if(!(var0 instanceof Map)) {
                if(method_3562(var0)) {
                    var2.type = 1;
                    var2.field_1020 = var0.toString();
                    var1 = false;
                } else if(method_3563(var0)) {
                    var2.type = 6;
                    var2.field_1015 = method_3564(var0);
                    var1 = false;
                } else {
                    if(!(var0 instanceof Boolean)) {
                        StringBuilder var3 = (new StringBuilder()).append("Converting to Value from unknown object type: ");
                        String var4;
                        if(var0 == null) {
                            var4 = "null";
                        } else {
                            var4 = var0.getClass().toString();
                        }

                        class_612.method_3456(var3.append(var4).toString());
                        return asc;
                    }

                    var2.type = 8;
                    var2.field_1016 = ((Boolean)var0).booleanValue();
                    var1 = false;
                }
            } else {
                var2.type = 3;
                Set var5 = ((Map)var0).entrySet();
                ArrayList var6 = new ArrayList(var5.size());
                ArrayList var7 = new ArrayList(var5.size());
                Iterator var8 = var5.iterator();
                boolean var9 = false;

                while(true) {
                    if(!var8.hasNext()) {
                        var2.field_1022 = (class_53.class_1172[])var6.toArray(new class_53.class_1172[0]);
                        var2.field_1023 = (class_53.class_1172[])var7.toArray(new class_53.class_1172[0]);
                        var1 = var9;
                        break;
                    }

                    Entry var10 = (Entry)var8.next();
                    class_53.class_1172 var11 = method_3561(var10.getKey());
                    class_53.class_1172 var12 = method_3561(var10.getValue());
                    if(var11 == asc || var12 == asc) {
                        return asc;
                    }

                    boolean var13;
                    if(!var9 && !var11.field_1019 && !var12.field_1019) {
                        var13 = false;
                    } else {
                        var13 = true;
                    }

                    var6.add(var11);
                    var7.add(var12);
                    var9 = var13;
                }
            }

            var2.field_1019 = var1;
            return var2;
        }
    }

    // $FF: renamed from: v (java.lang.Object) boolean
    private static boolean method_3562(Object var0) {
        return var0 instanceof Double || var0 instanceof Float || var0 instanceof class_635 && ((class_635)var0).method_3573();
    }

    // $FF: renamed from: w (java.lang.Object) boolean
    private static boolean method_3563(Object var0) {
        return var0 instanceof Byte || var0 instanceof Short || var0 instanceof Integer || var0 instanceof Long || var0 instanceof class_635 && ((class_635)var0).method_3569();
    }

    // $FF: renamed from: x (java.lang.Object) long
    private static long method_3564(Object var0) {
        if(var0 instanceof Number) {
            return ((Number)var0).longValue();
        } else {
            class_612.method_3456("getInt64 received non-Number");
            return 0L;
        }
    }
}
