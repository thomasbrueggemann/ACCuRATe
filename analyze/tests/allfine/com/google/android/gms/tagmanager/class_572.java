package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_717;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ac
class class_572 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3085;
    private static final String apf;
    private static final String apg;
    private static final String aph;
    private static final String api;

    static {
        field_3085 = class_530.field_2533.toString();
        apf = class_529.field_2308.toString();
        apg = class_529.field_2371.toString();
        aph = class_529.field_2394.toString();
        api = class_529.field_2379.toString();
    }

    public class_572() {
        String var1 = field_3085;
        String[] var2 = new String[] {apf};
        super(var1, var2);
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        class_53.class_1172 var2 = (class_53.class_1172)var1.get(apf);
        if(var2 != null && var2 != class_634.method_3556()) {
            String var3 = class_634.method_3543(var2);
            class_53.class_1172 var4 = (class_53.class_1172)var1.get(aph);
            String var5;
            if(var4 == null) {
                var5 = "text";
            } else {
                var5 = class_634.method_3543(var4);
            }

            class_53.class_1172 var6 = (class_53.class_1172)var1.get(api);
            String var7;
            if(var6 == null) {
                var7 = "base16";
            } else {
                var7 = class_634.method_3543(var6);
            }

            class_53.class_1172 var8 = (class_53.class_1172)var1.get(apg);
            byte var9;
            if(var8 != null && class_634.method_3547(var8).booleanValue()) {
                var9 = 3;
            } else {
                var9 = 2;
            }

            byte[] var12;
            label64: {
                byte[] var14;
                try {
                    if(!"text".equals(var5)) {
                        if("base16".equals(var5)) {
                            var12 = class_717.method_3919(var3);
                        } else if("base64".equals(var5)) {
                            var12 = Base64.decode(var3, var9);
                        } else {
                            if(!"base64url".equals(var5)) {
                                class_612.method_3456("Encode: unknown input format: " + var5);
                                class_53.class_1172 var11 = class_634.method_3556();
                                return var11;
                            }

                            var12 = Base64.decode(var3, var9 | 8);
                        }
                        break label64;
                    }

                    var14 = var3.getBytes();
                } catch (IllegalArgumentException var15) {
                    class_612.method_3456("Encode: invalid input:");
                    return class_634.method_3556();
                }

                var12 = var14;
            }

            String var13;
            if("base16".equals(var7)) {
                var13 = class_717.method_3920(var12);
            } else if("base64".equals(var7)) {
                var13 = Base64.encodeToString(var12, var9);
            } else {
                if(!"base64url".equals(var7)) {
                    class_612.method_3456("Encode: unknown output format: " + var7);
                    return class_634.method_3556();
                }

                var13 = Base64.encodeToString(var12, var9 | 8);
            }

            return class_634.method_3561(var13);
        } else {
            return class_634.method_3556();
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
