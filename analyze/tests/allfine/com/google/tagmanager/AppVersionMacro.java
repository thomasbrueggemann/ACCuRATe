package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import java.util.Map;

class AppVersionMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_759;
    private final Context mContext;

    static {
        field_759 = FunctionType.APP_VERSION.toString();
    }

    public AppVersionMacro(Context var1) {
        super(field_759, new String[0]);
        this.mContext = var1;
    }

    public static String getFunctionId() {
        return field_759;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        try {
            TypeSystem.Value var3 = Types.objectToValue(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
            return var3;
        } catch (NameNotFoundException var4) {
            Log.method_5503("Package name " + this.mContext.getPackageName() + " not found. " + var4.getMessage());
            return Types.getDefaultValue();
        }
    }

    public boolean isCacheable() {
        return true;
    }
}
