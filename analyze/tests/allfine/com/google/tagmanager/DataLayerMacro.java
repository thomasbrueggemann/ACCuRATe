package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.DataLayer;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class DataLayerMacro extends FunctionCallImplementation {
    private static final String DEFAULT_VALUE;
    // $FF: renamed from: ID java.lang.String
    private static final String field_745;
    private static final String NAME;
    private final DataLayer mDataLayer;

    static {
        field_745 = FunctionType.CUSTOM_VAR.toString();
        NAME = Key.NAME.toString();
        DEFAULT_VALUE = Key.DEFAULT_VALUE.toString();
    }

    public DataLayerMacro(DataLayer var1) {
        String var2 = field_745;
        String[] var3 = new String[] {NAME};
        super(var2, var3);
        this.mDataLayer = var1;
    }

    public static String getDefaultValueKey() {
        return DEFAULT_VALUE;
    }

    public static String getFunctionId() {
        return field_745;
    }

    public static String getNameKey() {
        return NAME;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        Object var2 = this.mDataLayer.get(Types.valueToString((TypeSystem.Value)var1.get(NAME)));
        if(var2 == null) {
            TypeSystem.Value var3 = (TypeSystem.Value)var1.get(DEFAULT_VALUE);
            return var3 != null?var3:Types.getDefaultValue();
        } else {
            return Types.objectToValue(var2);
        }
    }

    public boolean isCacheable() {
        return false;
    }
}
