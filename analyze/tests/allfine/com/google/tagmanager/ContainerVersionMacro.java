package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Runtime;
import com.google.tagmanager.Types;
import java.util.Map;

class ContainerVersionMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_746;
    private final Runtime mRuntime;

    static {
        field_746 = FunctionType.CONTAINER_VERSION.toString();
    }

    public ContainerVersionMacro(Runtime var1) {
        super(field_746, new String[0]);
        this.mRuntime = var1;
    }

    public static String getFunctionId() {
        return field_746;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        String var2 = this.mRuntime.getResource().getVersion();
        return var2 == null?Types.getDefaultValue():Types.objectToValue(var2);
    }

    public boolean isCacheable() {
        return true;
    }
}
