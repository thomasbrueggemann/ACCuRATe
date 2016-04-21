package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tagmanager.InstallReferrerService;
import com.google.android.gms.tagmanager.class_617;

public final class InstallReferrerReceiver extends BroadcastReceiver {
    public void onReceive(Context var1, Intent var2) {
        String var3 = var2.getStringExtra("referrer");
        if("com.android.vending.INSTALL_REFERRER".equals(var2.getAction()) && var3 != null) {
            class_617.method_3479(var3);
            Intent var4 = new Intent(var1, InstallReferrerService.class);
            var4.putExtra("referrer", var3);
            var1.startService(var4);
        }
    }
}
