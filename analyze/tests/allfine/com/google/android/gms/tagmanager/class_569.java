package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.g
class class_569 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3082;
    private final Context mContext;

    static {
        field_3082 = class_530.field_2571.toString();
    }

    public class_569(Context var1) {
        super(field_3082, new String[0]);
        this.mContext = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        try {
            PackageManager var3 = this.mContext.getPackageManager();
            class_53.class_1172 var4 = class_634.method_3561(var3.getApplicationLabel(var3.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
            return var4;
        } catch (NameNotFoundException var5) {
            class_612.method_3460("App name is not found.", var5);
            return class_634.method_3556();
        }
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
