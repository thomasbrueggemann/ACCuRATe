package crittercism.android;

import java.net.InetAddress;

// $FF: renamed from: crittercism.android.k
public final class class_688 {
    // $FF: renamed from: a java.net.InetAddress
    InetAddress field_3347;
    // $FF: renamed from: b java.lang.String
    String field_3348;
    // $FF: renamed from: c java.lang.String
    public String field_3349 = "/";
    // $FF: renamed from: d crittercism.android.k$a
    class_688.class_1196 field_3350 = null;
    // $FF: renamed from: e int
    int field_3351 = -1;
    // $FF: renamed from: f boolean
    boolean field_3352 = false;

    public static enum class_1196 {
        // $FF: renamed from: a crittercism.android.k$a
        field_4524("http", 80),
        // $FF: renamed from: b crittercism.android.k$a
        field_4525("https", 443);

        // $FF: renamed from: c java.lang.String
        private String field_4527;
        // $FF: renamed from: d int
        private int field_4528;

        static {
            class_688.class_1196[] var0 = new class_688.class_1196[]{field_4524, field_4525};
        }

        private class_1196(String var3, int var4) {
            this.field_4527 = var3;
            this.field_4528 = var4;
        }

        // $FF: renamed from: a (crittercism.android.k$a) java.lang.String
        // $FF: synthetic method
        static String method_5084(class_688.class_1196 var0) {
            return var0.field_4527;
        }

        // $FF: renamed from: b (crittercism.android.k$a) int
        // $FF: synthetic method
        static int method_5085(class_688.class_1196 var0) {
            return var0.field_4528;
        }
    }
}
