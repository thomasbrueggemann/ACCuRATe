package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bh
public final class class_798 {
    // $FF: renamed from: a boolean
    public boolean field_3771 = false;
    // $FF: renamed from: b int
    public int field_3772 = 10;
    // $FF: renamed from: c int
    public int field_3773 = 3600000;
    // $FF: renamed from: d org.json.JSONObject
    public JSONObject field_3774 = new JSONObject();

    class_798() {
    }

    public class_798(JSONObject var1) {
        this.field_3771 = var1.optBoolean("enabled", false);
        this.field_3772 = var1.optInt("interval", 10);
        this.field_3773 = var1.optInt("defaultTimeout", 3600000);
        this.field_3774 = var1.optJSONObject("transactions");
        if(this.field_3774 == null) {
            this.field_3774 = new JSONObject();
        }

    }

    // $FF: renamed from: a (android.content.Context) crittercism.android.bh
    public static class_798 method_4147(Context var0) {
        SharedPreferences var1 = var0.getSharedPreferences("com.crittercism.txn.config", 0);
        class_798 var2 = new class_798();
        var2.field_3771 = var1.getBoolean("enabled", false);
        var2.field_3772 = var1.getInt("interval", 10);
        var2.field_3773 = var1.getInt("defaultTimeout", 3600000);
        String var3 = var1.getString("transactions", (String)null);
        var2.field_3774 = new JSONObject();
        if(var3 != null) {
            try {
                var2.field_3774 = new JSONObject(var3);
            } catch (JSONException var5) {
                return var2;
            }
        }

        return var2;
    }

    // $FF: renamed from: a (java.lang.String) long
    public final long method_4148(String var1) {
        JSONObject var2 = this.field_3774.optJSONObject(var1);
        return var2 != null?var2.optLong("timeout", (long)this.field_3773):(long)this.field_3773;
    }
}
