package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.InstallReferrerUtil;
import com.google.tagmanager.Types;
import java.util.Map;

class AdwordsClickReferrerMacro extends FunctionCallImplementation {
    private static final String COMPONENT;
    private static final String CONVERSION_ID;
    // $FF: renamed from: ID java.lang.String
    private static final String field_744;
    private final Context context;

    static {
        field_744 = FunctionType.ADWORDS_CLICK_REFERRER.toString();
        COMPONENT = Key.COMPONENT.toString();
        CONVERSION_ID = Key.CONVERSION_ID.toString();
    }

    public AdwordsClickReferrerMacro(Context var1) {
        String var2 = field_744;
        String[] var3 = new String[] {CONVERSION_ID};
        super(var2, var3);
        this.context = var1;
    }

    public static String getFunctionId() {
        return field_744;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        TypeSystem.Value var2 = (TypeSystem.Value)var1.get(CONVERSION_ID);
        if(var2 == null) {
            return Types.getDefaultValue();
        } else {
            String var3 = Types.valueToString(var2);
            TypeSystem.Value var4 = (TypeSystem.Value)var1.get(COMPONENT);
            String var5;
            if(var4 != null) {
                var5 = Types.valueToString(var4);
            } else {
                var5 = null;
            }

            String var6 = InstallReferrerUtil.getClickReferrer(this.context, var3, var5);
            return var6 != null?Types.objectToValue(var6):Types.getDefaultValue();
        }
    }

    public boolean isCacheable() {
        return true;
    }
}
