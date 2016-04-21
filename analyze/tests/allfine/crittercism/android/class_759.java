package crittercism.android;

import crittercism.android.class_104;
import crittercism.android.class_741;
import crittercism.android.class_764;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.ds
public final class class_759 {
    // $FF: renamed from: a boolean
    private boolean field_3591;
    // $FF: renamed from: b boolean
    private boolean field_3592;

    public class_759(boolean var1) {
        this.field_3591 = var1;
        this.field_3592 = true;
    }

    // $FF: renamed from: a () boolean
    public final boolean method_4009() {
        synchronized(this) {}

        boolean var2;
        try {
            var2 = this.field_3591;
        } finally {
            ;
        }

        return var2;
    }

    public static final class class_1264 {
        // $FF: renamed from: a (crittercism.android.ax) crittercism.android.ds
        public static class_759 method_4598(class_104 var0) {
            JSONObject var3;
            label25: {
                String var1 = var0.method_410(class_741.field_3507.method_3988(), class_741.field_3507.method_3989());
                JSONObject var2;
                if(var1 != null) {
                    try {
                        var2 = new JSONObject(var1);
                    } catch (JSONException var7) {
                        class_764.method_4020();
                        var3 = null;
                        break label25;
                    }
                } else {
                    var2 = null;
                }

                var3 = var2;
            }

            boolean var4;
            if(var3 != null) {
                var4 = var3.optBoolean("optOutStatusSet", false);
            } else {
                var4 = false;
            }

            boolean var5;
            if(var4) {
                var5 = var3.optBoolean("optOutStatus", false);
            } else {
                var5 = var0.method_414(class_741.field_3510.method_3988(), class_741.field_3510.method_3989());
            }

            return new class_759(var5);
        }
    }
}
