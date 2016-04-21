package crittercism.android;

import crittercism.android.class_670;
import crittercism.android.class_732;
import crittercism.android.class_807;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bj
public final class class_673 extends class_670 {
    // $FF: renamed from: a java.lang.String
    private String field_3251;
    // $FF: renamed from: b java.lang.String
    private String field_3252;
    // $FF: renamed from: c crittercism.android.bj$a
    private class_673.class_1231 field_3253;
    // $FF: renamed from: d java.lang.String
    private String field_3254;

    public class_673(class_673.class_1231 var1, String var2) {
        this.field_3251 = class_732.field_3484.method_3968();
        this.field_3252 = class_807.field_3864.method_4194();
        this.field_3253 = var1;
        this.field_3254 = var2;
    }

    // $FF: renamed from: a () org.json.JSONArray
    public final JSONArray method_3730() {
        HashMap var1 = new HashMap();
        var1.put("event", Integer.valueOf(this.field_3253.ordinal()));
        var1.put("viewName", this.field_3254);
        return (new JSONArray()).put(this.field_3252).put(5).put(new JSONObject(var1));
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3251;
    }

    public static enum class_1231 {
        // $FF: renamed from: a crittercism.android.bj$a
        field_4220,
        // $FF: renamed from: b crittercism.android.bj$a
        field_4221;

        static {
            class_673.class_1231[] var0 = new class_673.class_1231[]{field_4220, field_4221};
        }
    }
}
