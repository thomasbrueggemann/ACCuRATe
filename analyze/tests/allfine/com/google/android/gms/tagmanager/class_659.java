package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ai
class class_659 {
    // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
    private static void method_3677(DataLayer var0, class_51.class_1329 var1) {
        class_53.class_1172[] var2 = var1.field_968;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            var0.method_5146(class_634.method_3543(var2[var4]));
        }

    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$i) void
    public static void method_3678(DataLayer var0, class_51.class_1319 var1) {
        if(var1.field_1012 == null) {
            class_612.method_3459("supplemental missing experimentSupplemental");
        } else {
            method_3677(var0, var1.field_1012);
            method_3679(var0, var1.field_1012);
            method_3681(var0, var1.field_1012);
        }
    }

    // $FF: renamed from: b (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
    private static void method_3679(DataLayer var0, class_51.class_1329 var1) {
        class_53.class_1172[] var2 = var1.field_967;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Map var5 = method_3680(var2[var4]);
            if(var5 != null) {
                var0.push(var5);
            }
        }

    }

    // $FF: renamed from: c (com.google.android.gms.internal.d$a) java.util.Map
    private static Map<String, Object> method_3680(class_53.class_1172 var0) {
        Object var1 = class_634.method_3548(var0);
        if(!(var1 instanceof Map)) {
            class_612.method_3459("value: " + var1 + " is not a map value, ignored.");
            return null;
        } else {
            return (Map)var1;
        }
    }

    // $FF: renamed from: c (com.google.android.gms.tagmanager.DataLayer, com.google.android.gms.internal.c$d) void
    private static void method_3681(DataLayer var0, class_51.class_1329 var1) {
        class_51.class_1330[] var2 = var1.field_969;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            class_51.class_1330 var5 = var2[var4];
            if(var5.field_962 == null) {
                class_612.method_3459("GaExperimentRandom: No key");
            } else {
                Object var6 = var0.get(var5.field_962);
                Long var7;
                if(!(var6 instanceof Number)) {
                    var7 = null;
                } else {
                    var7 = Long.valueOf(((Number)var6).longValue());
                }

                long var8 = var5.field_963;
                long var10 = var5.field_964;
                if(!var5.field_965 || var7 == null || var7.longValue() < var8 || var7.longValue() > var10) {
                    if(var8 > var10) {
                        class_612.method_3459("GaExperimentRandom: random range invalid");
                        continue;
                    }

                    var6 = Long.valueOf(Math.round(Math.random() * (double)(var10 - var8) + (double)var8));
                }

                var0.method_5146(var5.field_962);
                Map var12 = var0.method_5145(var5.field_962, var6);
                if(var5.field_966 > 0L) {
                    if(!var12.containsKey("gtm")) {
                        Object[] var15 = new Object[] {"lifetime", Long.valueOf(var5.field_966)};
                        var12.put("gtm", DataLayer.mapOf(var15));
                    } else {
                        Object var13 = var12.get("gtm");
                        if(var13 instanceof Map) {
                            ((Map)var13).put("lifetime", Long.valueOf(var5.field_966));
                        } else {
                            class_612.method_3459("GaExperimentRandom: gtm not a map");
                        }
                    }
                }

                var0.push(var12);
            }
        }

    }
}
