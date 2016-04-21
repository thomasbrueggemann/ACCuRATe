package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.bz;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_630;
import com.google.android.gms.tagmanager.class_634;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// $FF: renamed from: com.google.android.gms.tagmanager.dm
class class_636 {
    // $FF: renamed from: a (com.google.android.gms.tagmanager.bz) com.google.android.gms.tagmanager.bz
    private static bz<class_53.class_1172> method_3576(bz<class_53.class_1172> var0) {
        try {
            class_630 var1 = new class_630(class_634.method_3561(method_3579(class_634.method_3543((class_53.class_1172)var0.getObject()))), var0.method_3528());
            return var1;
        } catch (UnsupportedEncodingException var3) {
            class_612.method_3460("Escape URI: unsupported encoding", var3);
            return var0;
        }
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.bz, int) com.google.android.gms.tagmanager.bz
    private static bz<class_53.class_1172> method_3577(bz<class_53.class_1172> var0, int var1) {
        if(!method_3580((class_53.class_1172)var0.getObject())) {
            class_612.method_3456("Escaping can only be applied to strings.");
            return var0;
        } else {
            switch(var1) {
                case 12:
                    return method_3576(var0);
                default:
                    class_612.method_3456("Unsupported Value Escaping: " + var1);
                    return var0;
            }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.tagmanager.bz, int[]) com.google.android.gms.tagmanager.bz
    static bz<class_53.class_1172> method_3578(bz<class_53.class_1172> var0, int... var1) {
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            var0 = method_3577(var0, var1[var3]);
        }

        return var0;
    }

    // $FF: renamed from: de (java.lang.String) java.lang.String
    static String method_3579(String var0) throws UnsupportedEncodingException {
        return URLEncoder.encode(var0, "UTF-8").replaceAll("\\+", "%20");
    }

    // $FF: renamed from: q (com.google.android.gms.internal.d$a) boolean
    private static boolean method_3580(class_53.class_1172 var0) {
        return class_634.method_3548(var0) instanceof String;
    }
}
