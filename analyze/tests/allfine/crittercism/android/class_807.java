package crittercism.android;

import crittercism.android.class_110;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

// $FF: renamed from: crittercism.android.ed
public final class class_807 {
    // $FF: renamed from: a crittercism.android.ed
    public static final class_807 field_3864 = new class_807();
    // $FF: renamed from: b crittercism.android.ee
    private class_110 field_3865 = new class_807.class_1453((byte)0);
    // $FF: renamed from: c java.text.SimpleDateFormat
    private SimpleDateFormat field_3866 = null;

    private class_807() {
        try {
            this.field_3866 = method_4192();
        } catch (Exception var2) {
            ;
        }
    }

    // $FF: renamed from: b () java.text.SimpleDateFormat
    private static SimpleDateFormat method_4192() {
        SimpleDateFormat var0 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSSZ", Locale.US);
        var0.setTimeZone(TimeZone.getTimeZone("GMT"));
        return var0;
    }

    // $FF: renamed from: a (java.lang.String) long
    public final long method_4193(String var1) {
        return this.field_3866.parse(var1).getTime();
    }

    // $FF: renamed from: a () java.lang.String
    public final String method_4194() {
        return this.method_4195(this.field_3865.method_635());
    }

    // $FF: renamed from: a (java.util.Date) java.lang.String
    public final String method_4195(Date var1) {
        if(this.field_3866 != null) {
            return this.field_3866.format(var1);
        } else {
            method_4192();
            return "";
        }
    }

    final class class_1453 implements class_110 {
        private class_1453() {
        }

        // $FF: synthetic method
        class_1453(byte var2) {
            this();
        }

        // $FF: renamed from: a () java.util.Date
        public final Date method_635() {
            return new Date();
        }
    }
}
