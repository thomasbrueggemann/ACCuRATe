package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras implements NetworkExtras {
    private final Bundle mExtras;

    public AdMobExtras(Bundle var1) {
        Bundle var2;
        if(var1 != null) {
            var2 = new Bundle(var1);
        } else {
            var2 = null;
        }

        this.mExtras = var2;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }
}
