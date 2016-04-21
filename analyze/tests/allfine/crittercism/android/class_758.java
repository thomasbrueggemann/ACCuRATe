package crittercism.android;

import crittercism.android.class_101;
import crittercism.android.class_762;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: crittercism.android.dp
public final class class_758 {
    // $FF: renamed from: a java.util.Map
    private static Map field_3590;

    static {
        HashMap var0 = new HashMap();
        field_3590 = var0;
        var0.put("com.amazon.venezia", new class_762.class_1390());
        field_3590.put("com.android.vending", new class_762.class_1392());
    }

    // $FF: renamed from: a (java.lang.String) crittercism.android.dn
    public static class_101 method_4008(String var0) {
        return var0 != null && field_3590.containsKey(var0)?(class_101)field_3590.get(var0):null;
    }
}
