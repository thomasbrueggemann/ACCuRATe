package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.class_341;

// $FF: renamed from: com.google.android.gms.internal.kw
public class class_848 {
    // $FF: renamed from: Ty java.lang.ThreadLocal
    private static final ThreadLocal<String> field_4133 = new ThreadLocal();

    // $FF: renamed from: bt (java.lang.String) java.lang.String
    public static String method_4469(String var0) {
        return method_4472(var0, (String)field_4133.get());
    }

    // $FF: renamed from: c (com.google.android.gms.fitness.data.DataSource) com.google.android.gms.fitness.data.DataSource
    public static DataSource method_4470(DataSource var0) {
        if(var0.method_3091()) {
            String var1 = (String)field_4133.get();
            if(!method_4471() && !var1.equals(var0.getAppPackageName())) {
                return var0.method_3092();
            }
        }

        return var0;
    }

    // $FF: renamed from: jc () boolean
    public static boolean method_4471() {
        String var0 = (String)field_4133.get();
        return var0 == null || var0.startsWith("com.google");
    }

    // $FF: renamed from: s (java.lang.String, java.lang.String) java.lang.String
    private static String method_4472(String var0, String var1) {
        if(var0 != null && var1 != null) {
            byte[] var2 = new byte[var0.length() + var1.length()];
            System.arraycopy(var0.getBytes(), 0, var2, 0, var0.length());
            System.arraycopy(var1.getBytes(), 0, var2, var0.length(), var1.length());
            return Integer.toHexString(class_341.method_2315(var2, 0, var2.length, 0));
        } else {
            return var0;
        }
    }
}
