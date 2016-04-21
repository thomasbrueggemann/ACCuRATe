package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Runtime;
import com.google.tagmanager.Types;
import java.util.Map;

class EventMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_740;
    private final Runtime mRuntime;

    static {
        field_740 = FunctionType.EVENT.toString();
    }

    public EventMacro(Runtime var1) {
        super(field_740, new String[0]);
        this.mRuntime = var1;
    }

    public static String getFunctionId() {
        return field_740;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        String var2 = this.mRuntime.getCurrentEventName();
        return var2 == null?Types.getDefaultValue():Types.objectToValue(var2);
    }

    public boolean isCacheable() {
        return false;
    }
}
