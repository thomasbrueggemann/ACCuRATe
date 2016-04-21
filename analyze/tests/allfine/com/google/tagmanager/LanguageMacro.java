package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Locale;
import java.util.Map;

class LanguageMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_756;

    static {
        field_756 = FunctionType.LANGUAGE.toString();
    }

    public LanguageMacro() {
        super(field_756, new String[0]);
    }

    public static String getFunctionId() {
        return field_756;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        Locale var2 = Locale.getDefault();
        if(var2 == null) {
            return Types.getDefaultValue();
        } else {
            String var3 = var2.getLanguage();
            return var3 == null?Types.getDefaultValue():Types.objectToValue(var3.toLowerCase());
        }
    }

    public boolean isCacheable() {
        return false;
    }
}
