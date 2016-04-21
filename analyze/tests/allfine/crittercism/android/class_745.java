package crittercism.android;

import java.util.HashMap;

// $FF: renamed from: crittercism.android.cm
public enum class_745 {
    // $FF: renamed from: A crittercism.android.cm
    field_3522(26, "javax.net.ssl.SSLProtocolException"),
    // $FF: renamed from: B crittercism.android.cm
    field_3523(-1, "__UNKNOWN__");

    // $FF: renamed from: C java.util.HashMap
    private static HashMap field_3524;
    // $FF: renamed from: a crittercism.android.cm
    field_3526(0, (String)null),
    // $FF: renamed from: b crittercism.android.cm
    field_3527(1, "java.lang.AssertionError"),
    // $FF: renamed from: c crittercism.android.cm
    field_3528(2, "java.net.BindException"),
    // $FF: renamed from: d crittercism.android.cm
    field_3529(3, "java.lang.ClassNotFoundException"),
    // $FF: renamed from: e crittercism.android.cm
    field_3530(4, "java.lang.Error"),
    // $FF: renamed from: f crittercism.android.cm
    field_3531(5, "java.io.IOException"),
    // $FF: renamed from: g crittercism.android.cm
    field_3532(6, "java.lang.IllegalArgumentException"),
    // $FF: renamed from: h crittercism.android.cm
    field_3533(7, "java.lang.IllegalStateException"),
    // $FF: renamed from: i crittercism.android.cm
    field_3534(8, "java.lang.IndexOutOfBoundsException"),
    // $FF: renamed from: j crittercism.android.cm
    field_3535(9, "java.net.MalformedURLException"),
    // $FF: renamed from: k crittercism.android.cm
    field_3536(10, "java.security.NoSuchProviderException"),
    // $FF: renamed from: l crittercism.android.cm
    field_3537(11, "java.lang.NullPointerException"),
    // $FF: renamed from: m crittercism.android.cm
    field_3538(12, "java.net.ProtocolException"),
    // $FF: renamed from: n crittercism.android.cm
    field_3539(13, "java.lang.SecurityException"),
    // $FF: renamed from: o crittercism.android.cm
    field_3540(14, "java.net.SocketException"),
    // $FF: renamed from: p crittercism.android.cm
    field_3541(15, "java.net.SocketTimeoutException"),
    // $FF: renamed from: q crittercism.android.cm
    field_3542(16, "javax.net.ssl.SSLPeerUnverifiedException"),
    // $FF: renamed from: r crittercism.android.cm
    field_3543(17, "java.lang.StringIndexOutOfBoundsException"),
    // $FF: renamed from: s crittercism.android.cm
    field_3544(18, "java.net.UnknownHostException"),
    // $FF: renamed from: t crittercism.android.cm
    field_3545(19, "java.net.UnknownServiceException"),
    // $FF: renamed from: u crittercism.android.cm
    field_3546(20, "java.lang.UnsupportedOperationException"),
    // $FF: renamed from: v crittercism.android.cm
    field_3547(21, "java.net.URISyntaxException"),
    // $FF: renamed from: w crittercism.android.cm
    field_3548(22, "java.net.ConnectException"),
    // $FF: renamed from: x crittercism.android.cm
    field_3549(23, "javax.net.ssl.SSLException"),
    // $FF: renamed from: y crittercism.android.cm
    field_3550(24, "javax.net.ssl.SSLHandshakeException"),
    // $FF: renamed from: z crittercism.android.cm
    field_3551(25, "javax.net.ssl.SSLKeyException");

    // $FF: renamed from: D int
    private int field_3552;
    // $FF: renamed from: E java.lang.String
    private String field_3553;

    static {
        class_745[] var0 = new class_745[]{field_3526, field_3527, field_3528, field_3529, field_3530, field_3531, field_3532, field_3533, field_3534, field_3535, field_3536, field_3537, field_3538, field_3539, field_3540, field_3541, field_3542, field_3543, field_3544, field_3545, field_3546, field_3547, field_3548, field_3549, field_3550, field_3551, field_3522, field_3523};
    }

    private class_745(int var3, String var4) {
        this.field_3552 = var3;
        this.field_3553 = var4;
    }

    // $FF: renamed from: a (java.lang.Throwable) crittercism.android.cm
    public static class_745 method_3991(Throwable var0) {
        if(field_3524 == null) {
            method_3992();
        }

        String var1 = null;
        if(var0 != null) {
            var1 = var0.getClass().getName();
        }

        class_745 var2 = (class_745)field_3524.get(var1);
        if(var2 == null) {
            var2 = field_3523;
        }

        return var2;
    }

    // $FF: renamed from: b () void
    private static void method_3992() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a () int
    public final int method_3993() {
        return this.field_3552;
    }
}
