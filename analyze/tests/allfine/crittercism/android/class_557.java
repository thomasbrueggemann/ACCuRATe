package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import crittercism.android.class_104;
import crittercism.android.class_552;
import crittercism.android.class_691;
import crittercism.android.class_741;
import crittercism.android.class_764;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.dk
public final class class_557 extends class_552 {
    // $FF: renamed from: a crittercism.android.ax
    private class_104 field_3019;
    // $FF: renamed from: b boolean
    private final boolean field_3020;
    // $FF: renamed from: c android.content.Context
    private Context field_3021;

    public class_557(Context var1, class_104 var2, boolean var3) {
        this.field_3019 = var2;
        this.field_3020 = var3;
        this.field_3021 = var1;
    }

    // $FF: renamed from: a () void
    public final void method_3390() {
        (new StringBuilder("Setting opt out status to ")).append(this.field_3020).append(".  This will take effect in the next user session.");
        class_764.method_4020();
        boolean var2 = this.field_3020;
        class_104 var3 = this.field_3019;
        String var4 = class_741.field_3507.method_3988();
        String var5 = class_741.field_3507.method_3989();
        JSONObject var6 = new JSONObject();

        try {
            var6.put("optOutStatus", var2).put("optOutStatusSet", true);
        } catch (JSONException var9) {
            ;
        }

        var3.method_412(var4, var5, var6.toString());
        if(this.field_3020) {
            Editor var8 = this.field_3021.getSharedPreferences("com.crittercism.optmz.config", 0).edit();
            var8.clear();
            var8.commit();
            class_691.method_3811(this.field_3021);
        }

    }
}
