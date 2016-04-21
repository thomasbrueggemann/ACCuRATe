package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.class_544;
import com.google.android.gms.internal.class_545;
import com.google.android.gms.internal.class_66;
import com.google.android.gms.internal.class_67;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.i
public abstract class class_546 extends class_545 {
    // $FF: renamed from: kA java.lang.reflect.Method
    private static Method field_2901;
    // $FF: renamed from: kB java.lang.reflect.Method
    private static Method field_2902;
    // $FF: renamed from: kC java.lang.reflect.Method
    private static Method field_2903;
    // $FF: renamed from: kD java.lang.reflect.Method
    private static Method field_2904;
    // $FF: renamed from: kE java.lang.reflect.Method
    private static Method field_2905;
    // $FF: renamed from: kF java.lang.reflect.Method
    private static Method field_2906;
    // $FF: renamed from: kG java.lang.reflect.Method
    private static Method field_2907;
    // $FF: renamed from: kH java.lang.reflect.Method
    private static Method field_2908;
    // $FF: renamed from: kI java.lang.reflect.Method
    private static Method field_2909;
    // $FF: renamed from: kJ java.lang.String
    private static String field_2910;
    // $FF: renamed from: kK java.lang.String
    private static String field_2911;
    // $FF: renamed from: kL java.lang.String
    private static String field_2912;
    // $FF: renamed from: kM com.google.android.gms.internal.o
    private static class_544 field_2913;
    // $FF: renamed from: kN boolean
    static boolean field_2914 = false;
    private static long startTime = 0L;

    protected class_546(Context var1, class_66 var2, class_67 var3) {
        super(var1, var2, var3);
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.m) java.lang.String
    static String method_3335(Context param0, class_66 param1) throws class_546.class_1789 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.view.MotionEvent, android.util.DisplayMetrics) java.util.ArrayList
    static ArrayList<Long> method_3336(MotionEvent var0, DisplayMetrics var1) throws class_546.class_1789 {
        if(field_2905 != null && var0 != null) {
            try {
                ArrayList var4 = (ArrayList)field_2905.invoke((Object)null, new Object[] {var0, var1});
                return var4;
            } catch (IllegalAccessException var5) {
                throw new class_546.class_1789(var5);
            } catch (InvocationTargetException var6) {
                throw new class_546.class_1789(var6);
            }
        } else {
            throw new class_546.class_1789();
        }
    }

    // $FF: renamed from: a (java.lang.String, android.content.Context, com.google.android.gms.internal.m) void
    protected static void method_3337(String param0, Context param1, class_66 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.m) java.lang.String
    static String method_3338(Context param0, class_66 param1) throws class_546.class_1789 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (byte[], java.lang.String) java.lang.String
    private static String method_3339(byte[] var0, String var1) throws class_546.class_1789 {
        try {
            String var2 = new String(field_2913.method_3325(var0, var1), "UTF-8");
            return var2;
        } catch (class_544.class_1662 var5) {
            throw new class_546.class_1789(var5);
        } catch (UnsupportedEncodingException var6) {
            throw new class_546.class_1789(var6);
        }
    }

    // $FF: renamed from: d (android.content.Context) java.lang.String
    static String method_3340(Context param0) throws class_546.class_1789 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: e (android.content.Context) java.util.ArrayList
    static ArrayList<Long> method_3341(Context param0) throws class_546.class_1789 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: f (android.content.Context) int[]
    static int[] method_3342(Context var0) throws class_546.class_1789 {
        if(field_2909 == null) {
            throw new class_546.class_1789();
        } else {
            try {
                int[] var3 = (int[])((int[])field_2909.invoke((Object)null, new Object[] {var0}));
                return var3;
            } catch (IllegalAccessException var4) {
                throw new class_546.class_1789(var4);
            } catch (InvocationTargetException var5) {
                throw new class_546.class_1789(var5);
            }
        }
    }

    // $FF: renamed from: g (android.content.Context) void
    private static void method_3343(Context param0) throws class_546.class_1789 {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: v () java.lang.String
    static String method_3344() throws class_546.class_1789 {
        if(field_2910 == null) {
            throw new class_546.class_1789();
        } else {
            return field_2910;
        }
    }

    // $FF: renamed from: w () java.lang.Long
    static Long method_3345() throws class_546.class_1789 {
        if(field_2901 == null) {
            throw new class_546.class_1789();
        } else {
            try {
                Long var2 = (Long)field_2901.invoke((Object)null, new Object[0]);
                return var2;
            } catch (IllegalAccessException var3) {
                throw new class_546.class_1789(var3);
            } catch (InvocationTargetException var4) {
                throw new class_546.class_1789(var4);
            }
        }
    }

    // $FF: renamed from: x () java.lang.String
    static String method_3346() throws class_546.class_1789 {
        if(field_2903 == null) {
            throw new class_546.class_1789();
        } else {
            try {
                String var2 = (String)field_2903.invoke((Object)null, new Object[0]);
                return var2;
            } catch (IllegalAccessException var3) {
                throw new class_546.class_1789(var3);
            } catch (InvocationTargetException var4) {
                throw new class_546.class_1789(var4);
            }
        }
    }

    // $FF: renamed from: y () java.lang.Long
    static Long method_3347() throws class_546.class_1789 {
        if(field_2902 == null) {
            throw new class_546.class_1789();
        } else {
            try {
                Long var2 = (Long)field_2902.invoke((Object)null, new Object[0]);
                return var2;
            } catch (IllegalAccessException var3) {
                throw new class_546.class_1789(var3);
            } catch (InvocationTargetException var4) {
                throw new class_546.class_1789(var4);
            }
        }
    }

    // $FF: renamed from: b (android.content.Context) void
    protected void method_3333(Context var1) {
        try {
            try {
                this.a(1, method_3346());
            } catch (class_546.class_1789 var22) {
                ;
            }

            try {
                this.a(2, method_3344());
            } catch (class_546.class_1789 var21) {
                ;
            }

            try {
                long var13 = method_3345().longValue();
                this.a(25, var13);
                if(startTime != 0L) {
                    this.a(17, var13 - startTime);
                    this.a(23, startTime);
                }
            } catch (class_546.class_1789 var20) {
                ;
            }

            try {
                ArrayList var12 = method_3341(var1);
                this.a(31, ((Long)var12.get(0)).longValue());
                this.a(32, ((Long)var12.get(1)).longValue());
            } catch (class_546.class_1789 var19) {
                ;
            }

            try {
                this.a(33, method_3347().longValue());
            } catch (class_546.class_1789 var18) {
                ;
            }

            try {
                this.a(27, method_3335(var1, this.ky));
            } catch (class_546.class_1789 var17) {
                ;
            }

            try {
                this.a(29, method_3338(var1, this.ky));
            } catch (class_546.class_1789 var16) {
                ;
            }

            try {
                int[] var11 = method_3342(var1);
                this.a(5, (long)var11[0]);
                this.a(6, (long)var11[1]);
            } catch (class_546.class_1789 var15) {
                ;
            }
        } catch (IOException var23) {
            ;
        }
    }

    // $FF: renamed from: c (android.content.Context) void
    protected void method_3334(Context var1) {
        try {
            try {
                this.a(2, method_3344());
            } catch (class_546.class_1789 var11) {
                ;
            }

            try {
                this.a(1, method_3346());
            } catch (class_546.class_1789 var10) {
                ;
            }

            try {
                this.a(25, method_3345().longValue());
            } catch (class_546.class_1789 var9) {
                ;
            }

            try {
                ArrayList var7 = method_3336(this.kw, this.kx);
                this.a(14, ((Long)var7.get(0)).longValue());
                this.a(15, ((Long)var7.get(1)).longValue());
                if(var7.size() >= 3) {
                    this.a(16, ((Long)var7.get(2)).longValue());
                }

            } catch (class_546.class_1789 var8) {
                ;
            }
        } catch (IOException var12) {
            ;
        }
    }

    static class class_1789 extends Exception {
        public class_1789() {
        }

        public class_1789(Throwable var1) {
            super(var1);
        }
    }
}
