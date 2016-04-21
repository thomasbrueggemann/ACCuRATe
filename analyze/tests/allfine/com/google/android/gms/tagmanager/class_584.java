package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.class_53;
import com.google.android.gms.internal.class_530;
import com.google.android.gms.tagmanager.class_560;
import com.google.android.gms.tagmanager.class_634;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cj
class class_584 extends class_560 {
    // $FF: renamed from: ID java.lang.String
    private static final String field_3096;
    private final Context mContext;

    static {
        field_3096 = class_530.field_2499.toString();
    }

    public class_584(Context var1) {
        super(field_3096, new String[0]);
        this.mContext = var1;
    }

    // $FF: renamed from: C (java.util.Map) com.google.android.gms.internal.d$a
    public class_53.class_1172 method_3411(Map<String, class_53.class_1172> var1) {
        DisplayMetrics var2 = new DisplayMetrics();
        ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(var2);
        int var3 = var2.widthPixels;
        int var4 = var2.heightPixels;
        return class_634.method_3561(var3 + "x" + var4);
    }

    // $FF: renamed from: nN () boolean
    public boolean method_3413() {
        return true;
    }
}
