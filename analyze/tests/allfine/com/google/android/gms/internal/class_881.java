package com.google.android.gms.internal;

import com.google.android.gms.internal.class_880;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.me;
import com.google.android.gms.internal.mw;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.mw
public class class_881 {
    private static final String TAG = mw.class.getSimpleName();
    // $FF: renamed from: Dh com.google.android.gms.internal.me
    private final me<lx> field_4200;
    private final class_880 aih;
    private final Locale aii;

    public class_881(String var1, me<lx> var2, String var3) {
        this.field_4200 = var2;
        this.aii = Locale.getDefault();
        this.aih = new class_880(var1, this.aii, var3);
    }
}
