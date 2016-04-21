package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_717;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ao
class class_591 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3104;
    private static final String apf;
    private static final String aph;
    private static final String apl;

    static {
        field_3104 = class_530.field_2535.toString();
        apf = class_529.field_2308.toString();
        apl = class_529.field_2299.toString();
        aph = class_529.field_2394.toString();
    }

    public class_591() {
        String var1 = field_3104;
        String[] var2 = new String[] {apf};
        super(var1, var2);
    }

    // $FF: renamed from: d (java.lang.String, byte[]) byte[]
    private byte[] method_3443(String var1, byte[] var2) throws NoSuchAlgorithmException {
        MessageDigest var3 = MessageDigest.getInstance(var1);
        var3.update(var2);
        return var3.digest();
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        class_53.class_1172 var2 = (class_53.class_1172)var1.get(apf);
        if(var2 != null && var2 != class_634.method_3556()) {
            String var3 = class_634.method_3543(var2);
            class_53.class_1172 var4 = (class_53.class_1172)var1.get(apl);
            String var5;
            if(var4 == null) {
                var5 = "MD5";
            } else {
                var5 = class_634.method_3543(var4);
            }

            class_53.class_1172 var6 = (class_53.class_1172)var1.get(aph);
            String var7;
            if(var6 == null) {
                var7 = "text";
            } else {
                var7 = class_634.method_3543(var6);
            }

            byte[] var8;
            if("text".equals(var7)) {
                var8 = var3.getBytes();
            } else {
                if(!"base16".equals(var7)) {
                    class_612.method_3456("Hash: unknown input format: " + var7);
                    return class_634.method_3556();
                }

                var8 = class_717.method_3919(var3);
            }

            try {
                class_53.class_1172 var10 = class_634.method_3561(class_717.method_3920(this.method_3443(var5, var8)));
                return var10;
            } catch (NoSuchAlgorithmException var11) {
                class_612.method_3456("Hash: unknown algorithm: " + var5);
                return class_634.method_3556();
            }
        } else {
            return class_634.method_3556();
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
