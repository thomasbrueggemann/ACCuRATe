package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_529;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.tagmanager.class_564;
import com.google.android.gms.tagmanager.class_634;
import com.google.android.gms.tagmanager.class_638;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.tagmanager.ba
class class_608 {
    // $FF: renamed from: cG (java.lang.String) com.google.android.gms.tagmanager.cr$c
    public static class_638.class_1807 method_3448(String var0) throws JSONException {
        class_53.class_1172 var1 = method_3449(new JSONObject(var0));
        class_638.class_1808 var2 = class_638.class_1807.method_5664();

        for(int var3 = 0; var3 < var1.field_1022.length; ++var3) {
            var2.method_5659(class_638.class_1805.method_5618().method_5622(class_529.field_2395.toString(), var1.field_1022[var3]).method_5622(class_529.field_2332.toString(), class_634.method_3538(class_564.method_3417())).method_5622(class_564.method_3418(), var1.field_1023[var3]).method_5624());
        }

        return var2.method_5663();
    }

    // $FF: renamed from: n (java.lang.Object) com.google.android.gms.internal.d$a
    private static class_53.class_1172 method_3449(Object var0) throws JSONException {
        return class_634.method_3561(method_3450(var0));
    }

    // $FF: renamed from: o (java.lang.Object) java.lang.Object
    static Object method_3450(Object var0) throws JSONException {
        if(var0 instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if(JSONObject.NULL.equals(var0)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else {
            if(var0 instanceof JSONObject) {
                JSONObject var1 = (JSONObject)var0;
                HashMap var2 = new HashMap();
                Iterator var3 = var1.keys();

                while(var3.hasNext()) {
                    String var4 = (String)var3.next();
                    var2.put(var4, method_3450(var1.get(var4)));
                }

                var0 = var2;
            }

            return var0;
        }
    }
}
