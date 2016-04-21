package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// $FF: renamed from: com.google.android.gms.common.internal.d
public abstract class class_533 implements SafeParcelable {
    // $FF: renamed from: Lv java.lang.Object
    private static final Object field_2770 = new Object();
    // $FF: renamed from: Lw java.lang.ClassLoader
    private static ClassLoader field_2771 = null;
    // $FF: renamed from: Lx java.lang.Integer
    private static Integer field_2772 = null;
    // $FF: renamed from: Ly boolean
    private boolean field_2773 = false;

    // $FF: renamed from: a (java.lang.Class) boolean
    private static boolean method_3190(Class<?> var0) {
        try {
            boolean var3 = "SAFE_PARCELABLE_NULL_STRING".equals(var0.getField("NULL").get((Object)null));
            return var3;
        } catch (NoSuchFieldException var4) {
            return false;
        } catch (IllegalAccessException var5) {
            return false;
        }
    }

    // $FF: renamed from: aV (java.lang.String) boolean
    protected static boolean method_3191(String var0) {
        ClassLoader var1 = method_3192();
        if(var1 == null) {
            return true;
        } else {
            try {
                boolean var3 = method_3190(var1.loadClass(var0));
                return var3;
            } catch (Exception var4) {
                return false;
            }
        }
    }

    // $FF: renamed from: gO () java.lang.ClassLoader
    protected static ClassLoader method_3192() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: gP () java.lang.Integer
    protected static Integer method_3193() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: gQ () boolean
    protected boolean method_3194() {
        return this.field_2773;
    }
}
