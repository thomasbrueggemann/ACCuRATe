package crittercism.android;

import crittercism.android.class_670;
import crittercism.android.class_732;
import crittercism.android.class_807;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.ce
public final class class_674 extends class_670 {
    // $FF: renamed from: a java.lang.String
    private String field_3255;
    // $FF: renamed from: b java.lang.String
    private String field_3256;
    // $FF: renamed from: c crittercism.android.ce$a
    private class_674.class_1234 field_3257;
    // $FF: renamed from: d java.lang.String
    private String field_3258;
    // $FF: renamed from: e java.lang.String
    private String field_3259;
    // $FF: renamed from: f java.lang.String
    private String field_3260;

    public class_674(class_674.class_1234 var1) {
        if(var1 != class_674.class_1234.field_3368) {
            class_674.class_1234 var10000 = class_674.class_1234.field_3369;
        }

        this.field_3255 = class_732.field_3484.method_3968();
        this.field_3256 = class_807.field_3864.method_4194();
        this.field_3257 = var1;
    }

    public class_674(class_674.class_1234 var1, String var2) {
        if(var1 != class_674.class_1234.field_3370) {
            class_674.class_1234 var10000 = class_674.class_1234.field_3371;
        }

        this.field_3255 = class_732.field_3484.method_3968();
        this.field_3256 = class_807.field_3864.method_4194();
        this.field_3257 = var1;
        this.field_3258 = var2;
    }

    public class_674(class_674.class_1234 var1, String var2, String var3) {
        class_674.class_1234 var10000 = class_674.class_1234.field_3372;
        this.field_3255 = class_732.field_3484.method_3968();
        this.field_3256 = class_807.field_3864.method_4194();
        this.field_3257 = var1;
        this.field_3259 = var2;
        this.field_3260 = var3;
    }

    // $FF: renamed from: a () org.json.JSONArray
    public final JSONArray method_3730() {
        HashMap var1 = new HashMap();
        var1.put("change", Integer.valueOf(this.field_3257.ordinal()));
        if(this.field_3257 != class_674.class_1234.field_3370 && this.field_3257 != class_674.class_1234.field_3371) {
            if(this.field_3257 == class_674.class_1234.field_3372) {
                var1.put("oldType", this.field_3259);
                var1.put("newType", this.field_3260);
            }
        } else {
            var1.put("type", this.field_3258);
        }

        return (new JSONArray()).put(this.field_3256).put(4).put(new JSONObject(var1));
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3255;
    }

    public static enum class_1234 {
        // $FF: renamed from: a crittercism.android.ce$a
        field_3368,
        // $FF: renamed from: b crittercism.android.ce$a
        field_3369,
        // $FF: renamed from: c crittercism.android.ce$a
        field_3370,
        // $FF: renamed from: d crittercism.android.ce$a
        field_3371,
        // $FF: renamed from: e crittercism.android.ce$a
        field_3372;

        static {
            class_674.class_1234[] var0 = new class_674.class_1234[]{field_3368, field_3369, field_3370, field_3371, field_3372};
        }
    }
}
