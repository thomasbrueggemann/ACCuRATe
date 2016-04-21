package crittercism.android;

import crittercism.android.class_106;
import crittercism.android.class_732;
import crittercism.android.class_806;
import crittercism.android.class_96;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.bm
public final class class_800 implements class_96 {
    // $FF: renamed from: a org.json.JSONObject
    private JSONObject field_3793;
    // $FF: renamed from: b java.lang.String
    private String field_3794;

    public class_800(class_106 var1) {
        this.field_3794 = class_732.field_3484.method_3968();

        try {
            this.field_3793 = (new JSONObject()).put("appID", var1.method_428()).put("deviceID", var1.method_430()).put("crPlatform", "android").put("crVersion", var1.method_431()).put("deviceModel", var1.method_437()).put("osName", "android").put("osVersion", var1.method_438()).put("carrier", var1.method_433()).put("mobileCountryCode", var1.method_434()).put("mobileNetworkCode", var1.method_435()).put("appVersion", var1.method_429()).put("locale", (new class_806.class_1437()).field_4642);
        } catch (JSONException var3) {
            ;
        }
    }

    // $FF: renamed from: a (java.io.OutputStream) void
    public final void method_391(OutputStream var1) {
        var1.write(this.field_3793.toString().getBytes());
    }

    // $FF: renamed from: e () java.lang.String
    public final String method_392() {
        return this.field_3794;
    }
}
