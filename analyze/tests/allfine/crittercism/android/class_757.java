package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences.Editor;

// $FF: renamed from: crittercism.android.dq
public final class class_757 {
    // $FF: renamed from: a boolean
    public static boolean field_3589 = false;

    // $FF: renamed from: a (android.content.Context) java.lang.Boolean
    public static Boolean method_4006(Context var0) {
        return Boolean.valueOf(var0.getSharedPreferences("com.crittercism.usersettings", 0).getBoolean("crashedOnLastLoad", false));
    }

    // $FF: renamed from: a (android.content.Context, boolean) void
    public static void method_4007(Context var0, boolean var1) {
        Editor var2 = var0.getSharedPreferences("com.crittercism.usersettings", 0).edit();
        var2.putBoolean("crashedOnLastLoad", var1);
        var2.commit();
    }
}
