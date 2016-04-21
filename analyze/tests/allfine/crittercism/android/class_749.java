package crittercism.android;

import crittercism.android.class_100;
import crittercism.android.class_106;
import crittercism.android.class_764;
import crittercism.android.class_801;
import crittercism.android.class_803;
import crittercism.android.class_99;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.cu
public final class class_749 implements class_100 {
    // $FF: renamed from: a java.util.Map
    public Map field_3562 = new HashMap();

    public class_749(class_106 var1) {
        this.field_3562.put("app_id", var1.method_428());
        this.field_3562.put("hashed_device_id", var1.method_430());
        this.field_3562.put("library_version", "5.1.4");
    }

    // $FF: renamed from: a (java.lang.String, java.lang.String) crittercism.android.cu
    public final class_749 method_3996(String var1, String var2) {
        this.field_3562.put(var1, var2);
        return this;
    }

    // $FF: renamed from: a (java.lang.String, org.json.JSONArray) crittercism.android.cu
    public final class_749 method_3997(String var1, JSONArray var2) {
        this.field_3562.put(var1, var2);
        return this;
    }

    // $FF: renamed from: a (crittercism.android.bs) crittercism.android.cw
    // $FF: synthetic method
    public final class_100 method_396(class_803 var1) {
        String var10000 = var1.field_3799;
        this.field_3562.put(var1.field_3799, (new class_801(var1)).field_3795);
        return this;
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_397(OutputStream var1) {
        class_764.method_4020();
        var1.write((new JSONObject(this.field_3562)).toString().getBytes("UTF8"));
    }

    public final String toString() {
        try {
            String var2 = (new JSONObject(this.field_3562)).toString(4);
            return var2;
        } catch (JSONException var3) {
            class_764.method_4015();
            return null;
        }
    }

    public static final class class_1255 implements class_99 {
        // $FF: renamed from: a (crittercism.android.au) crittercism.android.cw
        // $FF: synthetic method
        public final class_100 method_395(class_106 var1) {
            return new class_749(var1);
        }
    }
}
