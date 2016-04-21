package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.Log;
import com.google.tagmanager.ObjectAndStatic;
import com.google.tagmanager.Types;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class ValueEscapeUtil {
    private static ObjectAndStatic<TypeSystem.Value> applyEscaping(ObjectAndStatic<TypeSystem.Value> var0, int var1) {
        if(!isValidStringType((TypeSystem.Value)var0.getObject())) {
            Log.method_5503("Escaping can only be applied to strings.");
            return var0;
        } else {
            switch(var1) {
                case 12:
                    return escapeUri(var0);
                default:
                    Log.method_5503("Unsupported Value Escaping: " + var1);
                    return var0;
            }
        }
    }

    static ObjectAndStatic<TypeSystem.Value> applyEscapings(ObjectAndStatic<TypeSystem.Value> var0, int... var1) {
        ObjectAndStatic var2 = var0;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            var2 = applyEscaping(var2, var1[var4]);
        }

        return var2;
    }

    private static ObjectAndStatic<TypeSystem.Value> escapeUri(ObjectAndStatic<TypeSystem.Value> var0) {
        try {
            ObjectAndStatic var1 = new ObjectAndStatic(Types.objectToValue(urlEncode(Types.valueToString((TypeSystem.Value)var0.getObject()))), var0.isStatic());
            return var1;
        } catch (UnsupportedEncodingException var3) {
            Log.method_5504("Escape URI: unsupported encoding", var3);
            return var0;
        }
    }

    private static boolean isValidStringType(TypeSystem.Value var0) {
        return Types.valueToObject(var0) instanceof String;
    }

    static String urlEncode(String var0) throws UnsupportedEncodingException {
        return URLEncoder.encode(var0, "UTF-8").replaceAll("\\+", "%20");
    }
}
