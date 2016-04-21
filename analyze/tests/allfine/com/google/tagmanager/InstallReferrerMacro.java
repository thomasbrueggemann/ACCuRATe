package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.InstallReferrerUtil;
import com.google.tagmanager.Types;
import java.util.Map;

class InstallReferrerMacro extends FunctionCallImplementation {
    private static final String COMPONENT;
    // $FF: renamed from: ID java.lang.String
    private static final String field_737;
    private final Context context;

    static {
        field_737 = FunctionType.INSTALL_REFERRER.toString();
        COMPONENT = Key.COMPONENT.toString();
    }

    public InstallReferrerMacro(Context var1) {
        super(field_737, new String[0]);
        this.context = var1;
    }

    public static String getFunctionId() {
        return field_737;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        String var2;
        if((TypeSystem.Value)var1.get(COMPONENT) != null) {
            var2 = Types.valueToString((TypeSystem.Value)var1.get(COMPONENT));
        } else {
            var2 = null;
        }

        String var3 = InstallReferrerUtil.getInstallReferrer(this.context, var2);
        return var3 != null?Types.objectToValue(var3):Types.getDefaultValue();
    }

    public boolean isCacheable() {
        return true;
    }
}
