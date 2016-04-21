package crittercism.android;

import crittercism.android.class_670;
import crittercism.android.class_732;
import crittercism.android.class_807;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bl
public final class class_672 extends class_670 {
    // $FF: renamed from: a java.lang.String
    private String field_3248;
    // $FF: renamed from: b java.lang.String
    private String field_3249;
    // $FF: renamed from: c crittercism.android.bl$a
    private class_672.class_1232 field_3250;

    public class_672(class_672.class_1232 var1) {
        this.field_3248 = class_732.field_3484.method_3968();
        this.field_3249 = class_807.field_3864.method_4194();
        this.field_3250 = var1;
    }

    // $FF: renamed from: a () org.json.JSONArray
    public final JSONArray method_3730() {
        HashMap var1 = new HashMap();
        var1.put("event", this.field_3250.method_3639());
        return (new JSONArray()).put(this.field_3249).put(3).put(new JSONObject(var1));
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3248;
    }

    public static enum class_1232 {
        // $FF: renamed from: a crittercism.android.bl$a
        field_3176("foregrounded"),
        // $FF: renamed from: b crittercism.android.bl$a
        field_3177("backgrounded");

        // $FF: renamed from: c java.lang.String
        private String field_3179;

        static {
            class_672.class_1232[] var0 = new class_672.class_1232[]{field_3176, field_3177};
        }

        private class_1232(String var3) {
            this.field_3179 = var3;
        }

        // $FF: renamed from: a () java.lang.String
        public final String method_3639() {
            return this.field_3179;
        }
    }
}
