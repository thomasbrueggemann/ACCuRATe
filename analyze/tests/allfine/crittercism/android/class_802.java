package crittercism.android;

// $FF: renamed from: crittercism.android.bn
public final class class_802 {
    public static enum class_1424 {
        // $FF: renamed from: a crittercism.android.bn$a
        field_4879("00555300", "crittercism.com"),
        // $FF: renamed from: b crittercism.android.bn$a
        field_4880("00555304", "crit-ci.com"),
        // $FF: renamed from: c crittercism.android.bn$a
        field_4881("00555305", "crit-staging.com"),
        // $FF: renamed from: d crittercism.android.bn$a
        field_4882("00444503", "eu.crittercism.com");

        // $FF: renamed from: e java.lang.String
        private final String field_4884;
        // $FF: renamed from: f java.lang.String
        private final String field_4885;

        static {
            class_802.class_1424[] var0 = new class_802.class_1424[]{field_4879, field_4880, field_4881, field_4882};
        }

        private class_1424(String var3, String var4) {
            this.field_4884 = var3;
            this.field_4885 = var4;
        }

        // $FF: renamed from: a (java.lang.String) crittercism.android.bn$a
        public static class_802.class_1424 method_5480(String var0) {
            if(var0.matches("[0-9a-fA-F]+")) {
                if(var0.length() == 24) {
                    return field_4879;
                }

                if(var0.length() == 40) {
                    String var1 = var0.substring(-8 + var0.length());
                    class_802.class_1424[] var2 = values();
                    int var3 = var2.length;

                    for(int var4 = 0; var4 < var3; ++var4) {
                        class_802.class_1424 var5 = var2[var4];
                        if(var1.equals(var5.field_4884)) {
                            return var5;
                        }
                    }
                }
            }

            return null;
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_5481() {
            return this.field_4885;
        }
    }
}
