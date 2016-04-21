package crittercism.android;

import android.content.Context;
import crittercism.android.class_764;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

// $FF: renamed from: crittercism.android.h
public final class class_691 {
    // $FF: renamed from: a boolean
    public boolean field_3364 = false;
    // $FF: renamed from: b boolean
    public boolean field_3365 = false;
    // $FF: renamed from: c boolean
    public boolean field_3366 = false;
    // $FF: renamed from: d int
    public int field_3367 = 10;

    public class_691(Context var1) {
        if(method_3810(var1).exists()) {
            this.field_3366 = true;
        }

    }

    public class_691(JSONObject var1) {
        if(var1.has("net")) {
            JSONObject var3;
            try {
                var3 = var1.getJSONObject("net");
            } catch (JSONException var4) {
                return;
            }

            this.field_3364 = var3.optBoolean("enabled", false);
            this.field_3365 = var3.optBoolean("persist", false);
            this.field_3366 = var3.optBoolean("kill", false);
            this.field_3367 = var3.optInt("interval", 10);
        }
    }

    // $FF: renamed from: a (android.content.Context) java.io.File
    public static File method_3810(Context var0) {
        return new File(var0.getFilesDir().getAbsolutePath() + "/.crittercism.apm.disabled.");
    }

    // $FF: renamed from: b (android.content.Context) void
    public static void method_3811(Context var0) {
        try {
            method_3810(var0).createNewFile();
        } catch (IOException var2) {
            class_764.method_4021("Unable to kill APM: " + var2.getMessage());
        }
    }

    public final boolean equals(Object var1) {
        if(this != var1) {
            if(var1 == null) {
                return false;
            }

            if(!(var1 instanceof class_691)) {
                return false;
            }

            class_691 var2 = (class_691)var1;
            if(this.field_3366 != var2.field_3366) {
                return false;
            }

            if(this.field_3364 != var2.field_3364) {
                return false;
            }

            if(this.field_3365 != var2.field_3365) {
                return false;
            }

            if(this.field_3367 != var2.field_3367) {
                return false;
            }
        }

        return true;
    }

    public final int hashCode() {
        short var1 = 1231;
        short var2;
        if(this.field_3366) {
            var2 = var1;
        } else {
            var2 = 1237;
        }

        int var3 = 31 * (var2 + 31);
        short var4;
        if(this.field_3364) {
            var4 = var1;
        } else {
            var4 = 1237;
        }

        int var5 = 31 * (var4 + var3);
        if(!this.field_3365) {
            var1 = 1237;
        }

        return 31 * (var5 + var1) + this.field_3367;
    }

    public final String toString() {
        return "OptmzConfiguration [\nisSendTaskEnabled=" + this.field_3364 + "\n, shouldPersist=" + this.field_3365 + "\n, isKilled=" + this.field_3366 + "\n, statisticsSendInterval=" + this.field_3367 + "]";
    }
}
