package crittercism.android;

import crittercism.android.class_732;
import crittercism.android.class_740;
import crittercism.android.class_801;
import crittercism.android.class_803;
import crittercism.android.class_805;
import crittercism.android.class_806;
import crittercism.android.class_96;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.cd
public final class class_737 implements class_96 {
    // $FF: renamed from: a org.json.JSONObject
    private JSONObject field_3489;
    // $FF: renamed from: b org.json.JSONObject
    private JSONObject field_3490;
    // $FF: renamed from: c org.json.JSONArray
    private JSONArray field_3491;
    // $FF: renamed from: d org.json.JSONArray
    private JSONArray field_3492;
    // $FF: renamed from: e java.io.File
    private File field_3493;
    // $FF: renamed from: f java.lang.String
    private String field_3494;

    public class_737(File var1, class_803 var2, class_803 var3, class_803 var4, class_803 var5) {
        var1.exists();
        this.field_3494 = class_732.field_3484.method_3968();
        this.field_3493 = var1;
        this.field_3489 = (new class_805()).method_4178(new class_806.class_1429()).method_4178(new class_806.class_1428()).method_4178(new class_806.class_1430()).method_4178(new class_806.class_1432()).method_4178(new class_806.class_1441()).method_4178(new class_806.class_1442()).method_4178(new class_806.class_1436()).method_4178(new class_806.class_1434()).method_4178(new class_806.class_1452()).method_4178(new class_806.class_1427()).method_4178(new class_806.class_1437()).method_4178(new class_806.class_1444()).method_4178(new class_806.class_1439()).method_4178(new class_806.class_1445()).method_4178(new class_806.class_1449()).method_4178(new class_806.class_1450()).method_4179();
        HashMap var7 = new HashMap();
        var7.put("crashed_session", (new class_801(var2)).field_3795);
        if(var3.method_4169() > 0) {
            var7.put("previous_session", (new class_801(var3)).field_3795);
        }

        this.field_3490 = new JSONObject(var7);
        this.field_3491 = (new class_801(var4)).field_3795;
        this.field_3492 = (new class_801(var5)).field_3795;
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_391(OutputStream var1) {
        HashMap var2 = new HashMap();
        var2.put("app_state", this.field_3489);
        var2.put("breadcrumbs", this.field_3490);
        var2.put("endpoints", this.field_3491);
        var2.put("systemBreadcrumbs", this.field_3492);
        byte[] var7 = new byte[0];
        byte[] var8 = new byte[8192];
        FileInputStream var9 = new FileInputStream(this.field_3493);

        while(true) {
            int var10 = var9.read(var8);
            if(var10 == -1) {
                var9.close();
                HashMap var11 = new HashMap();
                var11.put("dmp_name", this.field_3493.getName());
                var11.put("dmp_file", class_740.method_3985(var7));
                var2.put("ndk_dmp_info", new JSONObject(var11));
                var1.write((new JSONObject(var2)).toString().getBytes());
                return;
            }

            byte[] var15 = new byte[var10 + var7.length];
            System.arraycopy(var7, 0, var15, 0, var7.length);
            System.arraycopy(var8, 0, var15, var7.length, var10);
            var7 = var15;
        }
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3494;
    }
}
