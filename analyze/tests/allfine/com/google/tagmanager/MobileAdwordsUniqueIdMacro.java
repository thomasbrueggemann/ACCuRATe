package com.google.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class MobileAdwordsUniqueIdMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_748;
    private final Context mContext;

    static {
        field_748 = FunctionType.MOBILE_ADWORDS_UNIQUE_ID.toString();
    }

    public MobileAdwordsUniqueIdMacro(Context var1) {
        super(field_748, new String[0]);
        this.mContext = var1;
    }

    public static String getFunctionId() {
        return field_748;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        String var2 = this.getAndroidId(this.mContext);
        return var2 == null?Types.getDefaultValue():Types.objectToValue(var2);
    }

    @VisibleForTesting
    protected String getAndroidId(Context var1) {
        return Secure.getString(var1.getContentResolver(), "android_id");
    }

    public boolean isCacheable() {
        return true;
    }
}
