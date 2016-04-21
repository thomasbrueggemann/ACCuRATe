package crittercism.android;

import crittercism.android.class_668;
import crittercism.android.class_732;
import crittercism.android.class_764;
import crittercism.android.class_807;
import java.io.OutputStream;
import org.json.JSONArray;

// $FF: renamed from: crittercism.android.cf
public final class class_669 extends class_668 {
    // $FF: renamed from: a crittercism.android.cf
    public static final class_669 field_3239;
    // $FF: renamed from: b java.lang.String
    private String field_3240;
    // $FF: renamed from: c java.lang.String
    private String field_3241;
    // $FF: renamed from: d java.lang.String
    private String field_3242;
    // $FF: renamed from: e crittercism.android.cf$a
    private class_669.class_1235 field_3243;

    static {
        field_3239 = new class_669("session_start", class_669.class_1235.field_3966);
    }

    public class_669(String var1, class_669.class_1235 var2) {
        this(var1, class_807.field_3864.method_4194(), var2);
    }

    private class_669(String var1, String var2, class_669.class_1235 var3) {
        this.field_3242 = class_732.field_3484.method_3968();
        if(var1.length() > 140) {
            var1 = var1.substring(0, 140);
        }

        this.field_3240 = var1;
        this.field_3241 = var2;
        this.field_3243 = var3;
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_391(OutputStream var1) {
        JSONArray var2 = new JSONArray();
        var2.put(this.field_3240);
        var2.put(this.field_3241);
        String var5 = var2.toString();
        (new StringBuilder("BREADCRUMB WRITING ")).append(var5);
        class_764.method_4020();
        var1.write(var5.getBytes());
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3242;
    }

    public static enum class_1235 {
        // $FF: renamed from: a crittercism.android.cf$a
        field_3966,
        // $FF: renamed from: b crittercism.android.cf$a
        field_3967;

        static {
            class_669.class_1235[] var0 = new class_669.class_1235[]{field_3966, field_3967};
        }
    }
}
