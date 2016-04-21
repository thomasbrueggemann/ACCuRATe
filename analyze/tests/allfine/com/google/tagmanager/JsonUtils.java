package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.ConstantMacro;
import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.Types;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsonUtils {
    public static ResourceUtil.ExpandedResource expandedResourceFromJsonString(String var0) throws JSONException {
        TypeSystem.Value var1 = jsonObjectToValue(new JSONObject(var0));
        ResourceUtil.ExpandedResourceBuilder var2 = ResourceUtil.ExpandedResource.newBuilder();

        for(int var3 = 0; var3 < var1.mapKey.length; ++var3) {
            var2.addMacro(ResourceUtil.ExpandedFunctionCall.newBuilder().addProperty(Key.INSTANCE_NAME.toString(), var1.mapKey[var3]).addProperty(Key.FUNCTION.toString(), Types.functionIdToValue(ConstantMacro.getFunctionId())).addProperty(ConstantMacro.getValueKey(), var1.mapValue[var3]).build());
        }

        return var2.build();
    }

    @VisibleForTesting
    static Object jsonObjectToObject(Object var0) throws JSONException {
        if(var0 instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if(JSONObject.NULL.equals(var0)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else {
            Object var1;
            if(var0 instanceof JSONObject) {
                JSONObject var2 = (JSONObject)var0;
                var1 = new HashMap();
                Iterator var3 = var2.keys();

                while(var3.hasNext()) {
                    String var4 = (String)var3.next();
                    ((Map)var1).put(var4, jsonObjectToObject(var2.get(var4)));
                }
            } else {
                var1 = var0;
            }

            return var1;
        }
    }

    private static TypeSystem.Value jsonObjectToValue(Object var0) throws JSONException {
        return Types.objectToValue(jsonObjectToObject(var0));
    }
}
