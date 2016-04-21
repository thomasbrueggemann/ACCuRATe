package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.h
class class_571 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3084;
    private final Context mContext;

    static {
        field_3084 = class_530.field_2572.toString();
    }

    public class_571(Context var1) {
        super(field_3084, new String[0]);
        this.mContext = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        try {
            class_53.class_1172 var3 = class_634.method_3561(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
            return var3;
        } catch (NameNotFoundException var4) {
            class_612.method_3456("Package name " + this.mContext.getPackageName() + " not found. " + var4.getMessage());
            return class_634.method_3556();
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
