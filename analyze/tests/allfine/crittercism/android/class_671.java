package crittercism.android;

import crittercism.android.class_670;
import crittercism.android.class_732;
import crittercism.android.class_807;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.by
public final class class_671 extends class_670 {
    // $FF: renamed from: a java.lang.String
    private String field_3244;
    // $FF: renamed from: b java.lang.String
    private String field_3245;
    // $FF: renamed from: c java.lang.String
    private String field_3246;
    // $FF: renamed from: d java.lang.String
    private String field_3247;

    public class_671(String var1, String var2) {
        this.field_3244 = class_732.field_3484.method_3968();
        this.field_3245 = class_807.field_3864.method_4194();
        this.field_3246 = var1;
        this.field_3247 = var2;
    }

    // $FF: renamed from: a () org.json.JSONArray
    public final JSONArray method_3730() {
        HashMap var1 = new HashMap();
        var1.put("name", this.field_3246);
        var1.put("reason", this.field_3247);
        return (new JSONArray()).put(this.field_3245).put(6).put(new JSONObject(var1));
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3244;
    }
}
