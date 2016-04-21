package crittercism.android;

import android.content.Context;
import android.os.Build.VERSION;
import com.crittercism.app.CrittercismConfig;

// $FF: renamed from: crittercism.android.bf
public final class class_797 {
    // $FF: renamed from: a boolean
    public boolean field_3767;
    // $FF: renamed from: b boolean
    public boolean field_3768;
    // $FF: renamed from: c boolean
    public boolean field_3769;

    public class_797(Context var1, CrittercismConfig var2) {
        boolean var3 = true;
        super();
        if(!var2.isLogcatReportingEnabled() || VERSION.SDK_INT < 16 && !method_4146("android.permission.READ_LOGS", var1)) {
            var3 = false;
        }

        this.field_3767 = var3;
        this.field_3769 = method_4146("android.permission.ACCESS_NETWORK_STATE", var1);
        this.field_3768 = method_4146("android.permission.GET_TASKS", var1);
    }

    // $FF: renamed from: a (java.lang.String, android.content.Context) boolean
    private static boolean method_4146(String var0, Context var1) {
        return var1.getPackageManager().checkPermission(var0, var1.getPackageName()) == 0;
    }
}
