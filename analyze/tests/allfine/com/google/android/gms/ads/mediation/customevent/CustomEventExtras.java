package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements NetworkExtras {
    // $FF: renamed from: xj java.util.HashMap
    private final HashMap<String, Object> field_4609 = new HashMap();

    public Object getExtra(String var1) {
        return this.field_4609.get(var1);
    }

    public void setExtra(String var1, Object var2) {
        this.field_4609.put(var1, var2);
    }
}
