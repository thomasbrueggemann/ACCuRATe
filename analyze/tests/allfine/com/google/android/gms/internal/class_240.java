package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.class_4;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.ba
@ez
public final class class_240 extends class_4.class_1321 {
    // $FF: renamed from: oi com.google.android.gms.ads.doubleclick.AppEventListener
    private final AppEventListener field_635;

    public class_240(AppEventListener var1) {
        this.field_635 = var1;
    }

    public void onAppEvent(String var1, String var2) {
        this.field_635.onAppEvent(var1, var2);
    }
}
