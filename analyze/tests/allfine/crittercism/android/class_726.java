package crittercism.android;

import crittercism.android.class_724;
import crittercism.android.class_731;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.ca
public final class class_726 extends class_724 {
    private class_726(File var1) {
        super(var1);
    }

    // $FF: synthetic method
    class_726(File var1, byte var2) {
        this(var1);
    }

    // $FF: renamed from: a () java.lang.Object
    public final Object method_3953() {
        try {
            JSONObject var1 = new JSONObject((String)super.method_3953());
            return var1;
        } catch (JSONException var3) {
            return null;
        }
    }

    public static final class class_1240 extends class_731 {
        // $FF: renamed from: a (java.io.File) crittercism.android.bq
        public final class_724 method_3966(File var1) {
            return new class_726(var1, (byte)0);
        }
    }
}
