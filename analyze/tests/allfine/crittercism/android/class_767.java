package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;

// $FF: renamed from: crittercism.android.dt
public final class class_767 {
    // $FF: renamed from: a android.content.SharedPreferences
    public SharedPreferences field_3607;

    protected class_767() {
    }

    public class_767(Context var1) {
        this.field_3607 = var1.getSharedPreferences("com.crittercism.ratemyapp", 0);
    }

    // $FF: renamed from: a () int
    public final int method_4031() {
        return this.field_3607.getInt("numAppLoads", 0);
    }

    // $FF: renamed from: a (boolean) void
    public final void method_4032(boolean var1) {
        this.field_3607.edit().putBoolean("rateMyAppEnabled", var1).commit();
    }

    // $FF: renamed from: b () java.lang.String
    public final String method_4033() {
        return this.field_3607.getString("rateAppMessage", "Would you mind taking a second to rate my app?  I would really appreciate it!");
    }

    // $FF: renamed from: c () java.lang.String
    public final String method_4034() {
        return this.field_3607.getString("rateAppTitle", "Rate My App");
    }

    // $FF: renamed from: d () void
    public final void method_4035() {
        this.field_3607.edit().putBoolean("hasRatedApp", true).commit();
    }
}
