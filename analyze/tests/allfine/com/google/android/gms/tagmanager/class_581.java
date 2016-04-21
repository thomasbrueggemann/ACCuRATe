package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_579;
import com.google.android.gms.tagmanager.class_720;
import com.google.android.gms.tagmanager.class_74;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.i
class class_581 extends class_579 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3093;
    private static final String URL;
    private static final String anV;
    private static final String anW;
    static final String anX;
    private static final Set<String> anY;
    private final class_581.class_1791 anZ;
    private final Context mContext;

    static {
        field_3093 = class_530.field_2557.toString();
        URL = class_529.field_2439.toString();
        anV = class_529.field_2297.toString();
        anW = class_529.field_2438.toString();
        anX = "gtm_" + field_3093 + "_unrepeatable";
        anY = new HashSet();
    }

    public class_581(final Context var1) {
        this(var1, new class_581.class_1791() {
            // $FF: renamed from: nO () com.google.android.gms.tagmanager.aq
            public class_74 method_889() {
                return class_720.method_3949(var1);
            }
        });
    }

    class_581(Context var1, class_581.class_1791 var2) {
        String var3 = field_3093;
        String[] var4 = new String[] {URL};
        super(var3, var4);
        this.anZ = var2;
        this.mContext = var1;
    }

    // $FF: renamed from: cj (java.lang.String) boolean
    private boolean method_3422(String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: E (java.util.Map) void
    public void method_3419(Map<String, class_53.class_1172> param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ck (java.lang.String) boolean
    boolean method_3423(String var1) {
        return this.mContext.getSharedPreferences(anX, 0).contains(var1);
    }

    // $FF: renamed from: cl (java.lang.String) boolean
    boolean method_3424(String var1) {
        return anY.contains(var1);
    }

    public interface class_1791 {
        // $FF: renamed from: nO () com.google.android.gms.tagmanager.aq
        class_74 method_889();
    }
}
