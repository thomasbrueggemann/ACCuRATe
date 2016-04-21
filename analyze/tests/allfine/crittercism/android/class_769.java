package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.dv
public final class class_769 {
    // $FF: renamed from: a android.content.SharedPreferences
    private SharedPreferences field_3623;

    public class_769(Context var1, String var2) {
        this.field_3623 = var1.getSharedPreferences("com.crittercism." + var2 + ".usermetadata", 0);
        if(!this.field_3623.contains("data")) {
            JSONObject var3 = new JSONObject();

            try {
                var3.putOpt("username", "anonymous");
                this.method_4043(var3);
            } catch (JSONException var5) {
                return;
            }
        }

    }

    // $FF: renamed from: b (org.json.JSONObject) void
    private void method_4041(JSONObject var1) {
        Editor var2 = this.field_3623.edit();
        var2.putString("data", var1.toString());
        var2.commit();
    }

    // $FF: renamed from: a () org.json.JSONObject
    public final JSONObject method_4042() {
        String var1 = this.field_3623.getString("data", "{}");

        try {
            JSONObject var2 = new JSONObject(var1);
            return var2;
        } catch (JSONException var4) {
            return new JSONObject();
        }
    }

    // $FF: renamed from: a (org.json.JSONObject) void
    public final void method_4043(JSONObject var1) {
        JSONObject var2 = this.method_4042();
        if(var2.length() == 0) {
            if(var1.length() > 0) {
                this.method_4041(var1);
                this.method_4044(true);
            }
        } else {
            Iterator var3 = var1.keys();
            boolean var4 = false;

            while(true) {
                String var5;
                Object var6;
                boolean var8;
                do {
                    if(!var3.hasNext()) {
                        if(var4) {
                            this.method_4041(var2);
                            this.method_4044(true);
                            return;
                        }

                        return;
                    }

                    var5 = (String)var3.next();
                    var6 = var1.opt(var5);
                    Object var7 = var2.opt(var5);
                    if(var7 == null) {
                        var8 = true;
                    } else {
                        var8 = false;
                    }

                    if(var7 != null) {
                        if(!(var6 instanceof JSONObject) && !(var6 instanceof JSONArray)) {
                            if(!var7.equals(var6)) {
                                var8 = true;
                            } else {
                                var8 = false;
                            }
                        } else {
                            String var11 = var6.toString();
                            if(!var7.toString().equals(var11)) {
                                var8 = true;
                            } else {
                                var8 = false;
                            }
                        }
                    }
                } while(!var8);

                try {
                    var2.put(var5, var6);
                } catch (JSONException var12) {
                    continue;
                }

                var4 = true;
            }
        }

    }

    // $FF: renamed from: a (boolean) void
    public final void method_4044(boolean var1) {
        this.field_3623.edit().putBoolean("dirty", var1).commit();
    }

    // $FF: renamed from: b () boolean
    public final boolean method_4045() {
        return this.field_3623.getBoolean("dirty", false);
    }
}
