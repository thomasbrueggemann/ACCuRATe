package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class AppIdMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_763;
    private final Context mContext;

    static {
        field_763 = FunctionType.APP_ID.toString();
    }

    public AppIdMacro(Context var1) {
        super(field_763, new String[0]);
        this.mContext = var1;
    }

    public static String getFunctionId() {
        return field_763;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.objectToValue(this.mContext.getPackageName());
    }

    public boolean isCacheable() {
        return true;
    }
}
