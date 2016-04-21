package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

// $FF: renamed from: com.google.android.gms.analytics.t
class class_940 {
    // $FF: renamed from: ze com.google.android.gms.analytics.t
    private static final class_940 field_4301 = new class_940();
    // $FF: renamed from: zb java.util.SortedSet
    private SortedSet<class_940.class_1617> field_4302 = new TreeSet();
    // $FF: renamed from: zc java.lang.StringBuilder
    private StringBuilder field_4303 = new StringBuilder();
    // $FF: renamed from: zd boolean
    private boolean field_4304 = false;

    // $FF: renamed from: ep () com.google.android.gms.analytics.t
    public static class_940 method_4863() {
        return field_4301;
    }

    // $FF: renamed from: B (boolean) void
    public void method_4864(boolean var1) {
        synchronized(this) {}

        try {
            this.field_4304 = var1;
        } finally {
            ;
        }

    }

    // $FF: renamed from: a (com.google.android.gms.analytics.t$a) void
    public void method_4865(class_940.class_1617 var1) {
        synchronized(this) {}

        try {
            if(!this.field_4304) {
                this.field_4302.add(var1);
                this.field_4303.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(var1.ordinal()));
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: eq () java.lang.String
    public String method_4866() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: er () java.lang.String
    public String method_4867() {
        synchronized(this) {}

        String var2;
        try {
            if(this.field_4303.length() > 0) {
                this.field_4303.insert(0, ".");
            }

            var2 = this.field_4303.toString();
            this.field_4303 = new StringBuilder();
        } finally {
            ;
        }

        return var2;
    }

    public static enum class_1617 {
        // $FF: renamed from: Aa com.google.android.gms.analytics.t$a
        field_4898,
        // $FF: renamed from: Ab com.google.android.gms.analytics.t$a
        field_4899,
        // $FF: renamed from: Ac com.google.android.gms.analytics.t$a
        field_4900,
        // $FF: renamed from: Ad com.google.android.gms.analytics.t$a
        field_4901,
        // $FF: renamed from: Ae com.google.android.gms.analytics.t$a
        field_4902,
        // $FF: renamed from: Af com.google.android.gms.analytics.t$a
        field_4903,
        // $FF: renamed from: Ag com.google.android.gms.analytics.t$a
        field_4904,
        // $FF: renamed from: Ah com.google.android.gms.analytics.t$a
        field_4905,
        // $FF: renamed from: Ai com.google.android.gms.analytics.t$a
        field_4906,
        // $FF: renamed from: Aj com.google.android.gms.analytics.t$a
        field_4907,
        // $FF: renamed from: Ak com.google.android.gms.analytics.t$a
        field_4908,
        // $FF: renamed from: Al com.google.android.gms.analytics.t$a
        field_4909,
        // $FF: renamed from: Am com.google.android.gms.analytics.t$a
        field_4910,
        // $FF: renamed from: An com.google.android.gms.analytics.t$a
        field_4911,
        // $FF: renamed from: Ao com.google.android.gms.analytics.t$a
        field_4912,
        // $FF: renamed from: Ap com.google.android.gms.analytics.t$a
        field_4913,
        // $FF: renamed from: zA com.google.android.gms.analytics.t$a
        field_4915,
        // $FF: renamed from: zB com.google.android.gms.analytics.t$a
        field_4916,
        // $FF: renamed from: zC com.google.android.gms.analytics.t$a
        field_4917,
        // $FF: renamed from: zD com.google.android.gms.analytics.t$a
        field_4918,
        // $FF: renamed from: zE com.google.android.gms.analytics.t$a
        field_4919,
        // $FF: renamed from: zF com.google.android.gms.analytics.t$a
        field_4920,
        // $FF: renamed from: zG com.google.android.gms.analytics.t$a
        field_4921,
        // $FF: renamed from: zH com.google.android.gms.analytics.t$a
        field_4922,
        // $FF: renamed from: zI com.google.android.gms.analytics.t$a
        field_4923,
        // $FF: renamed from: zJ com.google.android.gms.analytics.t$a
        field_4924,
        // $FF: renamed from: zK com.google.android.gms.analytics.t$a
        field_4925,
        // $FF: renamed from: zL com.google.android.gms.analytics.t$a
        field_4926,
        // $FF: renamed from: zM com.google.android.gms.analytics.t$a
        field_4927,
        // $FF: renamed from: zN com.google.android.gms.analytics.t$a
        field_4928,
        // $FF: renamed from: zO com.google.android.gms.analytics.t$a
        field_4929,
        // $FF: renamed from: zP com.google.android.gms.analytics.t$a
        field_4930,
        // $FF: renamed from: zQ com.google.android.gms.analytics.t$a
        field_4931,
        // $FF: renamed from: zR com.google.android.gms.analytics.t$a
        field_4932,
        // $FF: renamed from: zS com.google.android.gms.analytics.t$a
        field_4933,
        // $FF: renamed from: zT com.google.android.gms.analytics.t$a
        field_4934,
        // $FF: renamed from: zU com.google.android.gms.analytics.t$a
        field_4935,
        // $FF: renamed from: zV com.google.android.gms.analytics.t$a
        field_4936,
        // $FF: renamed from: zW com.google.android.gms.analytics.t$a
        field_4937,
        // $FF: renamed from: zX com.google.android.gms.analytics.t$a
        field_4938,
        // $FF: renamed from: zY com.google.android.gms.analytics.t$a
        field_4939,
        // $FF: renamed from: zZ com.google.android.gms.analytics.t$a
        field_4940,
        // $FF: renamed from: zf com.google.android.gms.analytics.t$a
        field_4941,
        // $FF: renamed from: zg com.google.android.gms.analytics.t$a
        field_4942,
        // $FF: renamed from: zh com.google.android.gms.analytics.t$a
        field_4943,
        // $FF: renamed from: zi com.google.android.gms.analytics.t$a
        field_4944,
        // $FF: renamed from: zj com.google.android.gms.analytics.t$a
        field_4945,
        // $FF: renamed from: zk com.google.android.gms.analytics.t$a
        field_4946,
        // $FF: renamed from: zl com.google.android.gms.analytics.t$a
        field_4947,
        // $FF: renamed from: zm com.google.android.gms.analytics.t$a
        field_4948,
        // $FF: renamed from: zn com.google.android.gms.analytics.t$a
        field_4949,
        // $FF: renamed from: zo com.google.android.gms.analytics.t$a
        field_4950,
        // $FF: renamed from: zp com.google.android.gms.analytics.t$a
        field_4951,
        // $FF: renamed from: zq com.google.android.gms.analytics.t$a
        field_4952,
        // $FF: renamed from: zr com.google.android.gms.analytics.t$a
        field_4953,
        // $FF: renamed from: zs com.google.android.gms.analytics.t$a
        field_4954,
        // $FF: renamed from: zt com.google.android.gms.analytics.t$a
        field_4955,
        // $FF: renamed from: zu com.google.android.gms.analytics.t$a
        field_4956,
        // $FF: renamed from: zv com.google.android.gms.analytics.t$a
        field_4957,
        // $FF: renamed from: zw com.google.android.gms.analytics.t$a
        field_4958,
        // $FF: renamed from: zx com.google.android.gms.analytics.t$a
        field_4959,
        // $FF: renamed from: zy com.google.android.gms.analytics.t$a
        field_4960,
        // $FF: renamed from: zz com.google.android.gms.analytics.t$a
        field_4961;

        static {
            class_940.class_1617[] var0 = new class_940.class_1617[]{field_4941, field_4942, field_4943, field_4944, field_4945, field_4946, field_4947, field_4948, field_4949, field_4950, field_4951, field_4952, field_4953, field_4954, field_4955, field_4956, field_4957, field_4958, field_4959, field_4960, field_4961, field_4915, field_4916, field_4917, field_4918, field_4919, field_4920, field_4921, field_4922, field_4923, field_4924, field_4925, field_4926, field_4927, field_4928, field_4929, field_4930, field_4931, field_4932, field_4933, field_4934, field_4935, field_4936, field_4937, field_4938, field_4939, field_4940, field_4898, field_4899, field_4900, field_4901, field_4902, field_4903, field_4904, field_4905, field_4906, field_4907, field_4908, field_4909, field_4910, field_4911, field_4912, field_4913};
        }
    }
}
