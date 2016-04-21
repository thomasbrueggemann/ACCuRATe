package crittercism.android;

import crittercism.android.class_668;
import crittercism.android.class_764;
import java.io.OutputStream;
import org.json.JSONArray;

// $FF: renamed from: crittercism.android.ci
public abstract class class_670 extends class_668 {
    // $FF: renamed from: a () org.json.JSONArray
    public abstract JSONArray method_3730();

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_391(OutputStream var1) {
        String var2 = this.method_3730().toString();
        (new StringBuilder("BREADCRUMB WRITING ")).append(var2);
        class_764.method_4020();
        var1.write(var2.getBytes());
    }
}
