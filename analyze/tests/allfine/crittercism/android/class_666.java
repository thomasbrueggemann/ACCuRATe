package crittercism.android;

import crittercism.android.class_106;
import crittercism.android.class_675;
import crittercism.android.class_764;
import crittercism.android.class_807;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.a
public final class class_666 {
    // $FF: renamed from: a org.json.JSONObject
    JSONObject field_3237 = new JSONObject();

    private class_666(class_106 var1, List var2) {
        var2.size();
        JSONArray var4 = new JSONArray();
        JSONArray var5 = new JSONArray();
        var5.put(var1.method_428());
        var5.put(var1.method_429());
        var5.put(var1.method_430());
        var5.put("5.1.4");
        var5.put(var1.method_432());
        var4.put(var5);
        JSONArray var12 = new JSONArray();
        var12.put(class_807.field_3864.method_4194());
        var12.put(var1.method_433());
        var12.put(var1.method_437());
        var12.put(var1.method_436());
        var12.put(var1.method_438());
        var12.put(var1.method_434());
        var12.put(var1.method_435());
        var4.put(var12);
        JSONArray var21 = new JSONArray();
        Iterator var22 = var2.iterator();

        while(var22.hasNext()) {
            var21.put(((class_675)var22.next()).method_3745());
        }

        var4.put(var21);
        this.field_3237.put("d", var4);
    }

    // $FF: renamed from: a (crittercism.android.au, java.util.List) crittercism.android.a
    public static class_666 method_3728(class_106 var0, List var1) {
        try {
            class_666 var2 = new class_666(var0, var1);
            return var2;
        } catch (JSONException var4) {
            class_764.method_4021("Unable to generate APM request\'s JSON: " + var4);
            return null;
        }
    }
}
