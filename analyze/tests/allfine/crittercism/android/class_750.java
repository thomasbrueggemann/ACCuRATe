package crittercism.android;

import android.content.Context;
import crittercism.android.class_106;
import crittercism.android.class_803;
import crittercism.android.class_97;
import crittercism.android.class_98;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.da
public class class_750 implements class_98 {
    // $FF: renamed from: a crittercism.android.bs
    private class_803 field_3563;
    // $FF: renamed from: b crittercism.android.bs
    private class_803 field_3564;

    public class_750(class_803 var1, class_803 var2) {
        this.field_3563 = var1;
        this.field_3564 = var2;
    }

    // $FF: renamed from: a (boolean, int, org.json.JSONObject) void
    public void method_394(boolean var1, int var2, JSONObject var3) {
        boolean var4;
        if(!var1 && (var2 < 200 || var2 >= 300)) {
            var4 = false;
        } else {
            var4 = true;
        }

        if(var4) {
            this.field_3563.method_4165();
        } else {
            this.field_3563.method_4166(this.field_3564);
        }
    }

    public static final class class_1263 implements class_97 {
        // $FF: renamed from: a (crittercism.android.bs, crittercism.android.bs, java.lang.String, android.content.Context, crittercism.android.au) crittercism.android.cy
        // $FF: synthetic method
        public final class_98 method_393(class_803 var1, class_803 var2, String var3, Context var4, class_106 var5) {
            return new class_750(var1, var2);
        }
    }
}
