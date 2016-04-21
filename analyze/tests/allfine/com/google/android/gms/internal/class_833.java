package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_144;
import com.google.android.gms.internal.lp;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.me;

// $FF: renamed from: com.google.android.gms.internal.lp
public class class_833 {
    // $FF: renamed from: Dd java.lang.String
    private final String field_4112;
    // $FF: renamed from: Dh com.google.android.gms.internal.me
    private final me<lx> field_4113;
    // $FF: renamed from: IM java.lang.String
    private final String field_4114;
    private class_144 aeA;
    private final Context mContext;

    private class_833(Context var1, String var2, String var3, me<lx> var4) {
        this.mContext = var1;
        this.field_4112 = var2;
        this.field_4113 = var4;
        this.aeA = null;
        this.field_4114 = var3;
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.internal.me) com.google.android.gms.internal.lp
    public static lp method_4456(Context var0, String var1, String var2, me<lx> var3) {
        return new class_833(var0, var1, var2, var3);
    }
}
