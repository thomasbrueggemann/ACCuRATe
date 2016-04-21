package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_178;

// $FF: renamed from: com.google.android.gms.analytics.g
class class_926 implements class_178 {
    // $FF: renamed from: xP com.google.android.gms.analytics.g
    private static class_926 field_4232;
    // $FF: renamed from: xz java.lang.Object
    private static Object field_4233 = new Object();
    // $FF: renamed from: xL java.lang.String
    protected String field_4234;
    // $FF: renamed from: xM java.lang.String
    protected String field_4235;
    // $FF: renamed from: xN java.lang.String
    protected String field_4236;
    // $FF: renamed from: xO java.lang.String
    protected String field_4237;

    protected class_926() {
    }

    private class_926(Context param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dP () com.google.android.gms.analytics.g
    public static class_926 method_4776() {
        return field_4232;
    }

    // $FF: renamed from: y (android.content.Context) void
    public static void method_4777(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: ac (java.lang.String) boolean
    public boolean method_4778(String var1) {
        return "&an".equals(var1) || "&av".equals(var1) || "&aid".equals(var1) || "&aiid".equals(var1);
    }

    public String getValue(String var1) {
        if(var1 != null) {
            if(var1.equals("&an")) {
                return this.field_4234;
            }

            if(var1.equals("&av")) {
                return this.field_4235;
            }

            if(var1.equals("&aid")) {
                return this.field_4236;
            }

            if(var1.equals("&aiid")) {
                return this.field_4237;
            }
        }

        return null;
    }
}
