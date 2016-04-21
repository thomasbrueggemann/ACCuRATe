package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: com.google.android.gms.internal.jz
public final class class_342 {
    // $FF: renamed from: MT java.util.regex.Pattern
    private static final Pattern field_1206 = Pattern.compile("\\\\.");
    // $FF: renamed from: MU java.util.regex.Pattern
    private static final Pattern field_1207 = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    // $FF: renamed from: bf (java.lang.String) java.lang.String
    public static String method_2316(String var0) {
        if(!TextUtils.isEmpty(var0)) {
            Matcher var1 = field_1207.matcher(var0);
            StringBuffer var2 = null;

            while(var1.find()) {
                if(var2 == null) {
                    var2 = new StringBuffer();
                }

                switch(var1.group().charAt(0)) {
                    case '\b':
                        var1.appendReplacement(var2, "\\\\b");
                        break;
                    case '\t':
                        var1.appendReplacement(var2, "\\\\t");
                        break;
                    case '\n':
                        var1.appendReplacement(var2, "\\\\n");
                        break;
                    case '\f':
                        var1.appendReplacement(var2, "\\\\f");
                        break;
                    case '\r':
                        var1.appendReplacement(var2, "\\\\r");
                        break;
                    case '\"':
                        var1.appendReplacement(var2, "\\\\\\\"");
                        break;
                    case '/':
                        var1.appendReplacement(var2, "\\\\/");
                        break;
                    case '\\':
                        var1.appendReplacement(var2, "\\\\\\\\");
                }
            }

            if(var2 != null) {
                var1.appendTail(var2);
                return var2.toString();
            }
        }

        return var0;
    }

    // $FF: renamed from: d (java.lang.Object, java.lang.Object) boolean
    public static boolean method_2317(Object var0, Object var1) {
        if(var0 instanceof JSONObject && var1 instanceof JSONObject) {
            JSONObject var7 = (JSONObject)var0;
            JSONObject var8 = (JSONObject)var1;
            if(var7.length() == var8.length()) {
                Iterator var9 = var7.keys();

                while(true) {
                    if(!var9.hasNext()) {
                        return true;
                    }

                    String var10 = (String)var9.next();
                    if(!var8.has(var10)) {
                        break;
                    }

                    boolean var12;
                    try {
                        var12 = method_2317(var7.get(var10), var8.get(var10));
                    } catch (JSONException var14) {
                        return false;
                    }

                    if(!var12) {
                        return false;
                    }
                }
            }
        } else {
            if(!(var0 instanceof JSONArray) || !(var1 instanceof JSONArray)) {
                return var0.equals(var1);
            }

            JSONArray var2 = (JSONArray)var0;
            JSONArray var3 = (JSONArray)var1;
            if(var2.length() == var3.length()) {
                for(int var4 = 0; var4 < var2.length(); ++var4) {
                    boolean var6;
                    try {
                        var6 = method_2317(var2.get(var4), var3.get(var4));
                    } catch (JSONException var13) {
                        return false;
                    }

                    if(!var6) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }
}
