package crittercism.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.crittercism.app.CrittercismConfig;

// $FF: renamed from: crittercism.android.at
public final class class_787 {
    // $FF: renamed from: a java.lang.String
    public String field_3676 = "1.0";
    // $FF: renamed from: b int
    public int field_3677 = 0;

    public class_787(Context var1, CrittercismConfig var2) {
        try {
            PackageInfo var5 = var1.getPackageManager().getPackageInfo(var1.getPackageName(), 0);
            this.field_3676 = var5.versionName;
            this.field_3677 = var5.versionCode;
        } catch (NameNotFoundException var6) {
            ;
        }

        String var4 = var2.getCustomVersionName();
        if(var4 != null && var4.length() > 0) {
            this.field_3676 = var4;
        }

        if(var2.isVersionCodeToBeIncludedInVersionString()) {
            this.field_3676 = this.field_3676 + "-" + Integer.toString(this.field_3677);
        }

    }
}
