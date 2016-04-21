package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class AdvertiserIdMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_738;
    private final Context mContext;

    static {
        field_738 = FunctionType.ADVERTISER_ID.toString();
    }

    public AdvertiserIdMacro(Context var1) {
        super(field_738, new String[0]);
        this.mContext = var1;
    }

    public static String getFunctionId() {
        return field_738;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.getDefaultValue();
    }

    public boolean isCacheable() {
        return true;
    }
}
