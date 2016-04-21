package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import java.util.Map;

class AppNameMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_762;
    private final Context mContext;

    static {
        field_762 = FunctionType.APP_NAME.toString();
    }

    public AppNameMacro(Context var1) {
        super(field_762, new String[0]);
        this.mContext = var1;
    }

    public static String getFunctionId() {
        return field_762;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        try {
            PackageManager var3 = this.mContext.getPackageManager();
            TypeSystem.Value var4 = Types.objectToValue(var3.getApplicationLabel(var3.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
            return var4;
        } catch (NameNotFoundException var5) {
            Log.method_5504("App name is not found.", var5);
            return Types.getDefaultValue();
        }
    }

    public boolean isCacheable() {
        return true;
    }
}
