package com.google.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class ResolutionMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_757;
    private final Context mContext;

    static {
        field_757 = FunctionType.RESOLUTION.toString();
    }

    public ResolutionMacro(Context var1) {
        super(field_757, new String[0]);
        this.mContext = var1;
    }

    public static String getFunctionId() {
        return field_757;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        DisplayMetrics var2 = new DisplayMetrics();
        ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(var2);
        int var3 = var2.widthPixels;
        int var4 = var2.heightPixels;
        return Types.objectToValue(var3 + "x" + var4);
    }

    public boolean isCacheable() {
        return true;
    }
}
