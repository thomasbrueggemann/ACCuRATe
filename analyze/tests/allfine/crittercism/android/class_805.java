package crittercism.android;

import crittercism.android.class_108;
import crittercism.android.class_109;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bu
public final class class_805 implements class_108 {
    // $FF: renamed from: a java.util.Map
    private Map field_3825 = new HashMap();

    // $FF: renamed from: a (crittercism.android.bw) crittercism.android.bu
    public final class_805 method_4178(class_109 var1) {
        if(var1.b() != null) {
            this.field_3825.put(var1.method_634(), var1.b());
        }

        return this;
    }

    // $FF: renamed from: a () org.json.JSONObject
    public final JSONObject method_4179() {
        return new JSONObject(this.field_3825);
    }

    // $FF: renamed from: b () java.lang.Object
    // $FF: synthetic method
    public final Object method_633() {
        return this.method_4179();
    }
}
