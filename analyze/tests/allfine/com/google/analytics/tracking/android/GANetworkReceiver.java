package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.analytics.tracking.android.ServiceManager;
import com.google.android.gms.common.util.VisibleForTesting;

class GANetworkReceiver extends BroadcastReceiver {
    @VisibleForTesting
    static final String SELF_IDENTIFYING_EXTRA = GANetworkReceiver.class.getName();
    private final ServiceManager mManager;

    GANetworkReceiver(ServiceManager var1) {
        this.mManager = var1;
    }

    public static void sendRadioPoweredBroadcast(Context var0) {
        Intent var1 = new Intent("com.google.analytics.RADIO_POWERED");
        var1.addCategory(var0.getPackageName());
        var1.putExtra(SELF_IDENTIFYING_EXTRA, true);
        var0.sendBroadcast(var1);
    }

    public void onReceive(Context var1, Intent var2) {
        String var3 = var2.getAction();
        if("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
            boolean var4 = var2.getBooleanExtra("noConnectivity", false);
            ServiceManager var5 = this.mManager;
            boolean var6 = false;
            if(!var4) {
                var6 = true;
            }

            var5.updateConnectivityStatus(var6);
        } else if("com.google.analytics.RADIO_POWERED".equals(var3) && !var2.hasExtra(SELF_IDENTIFYING_EXTRA)) {
            this.mManager.onRadioPowered();
            return;
        }

    }

    public void register(Context var1) {
        IntentFilter var2 = new IntentFilter();
        var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        var1.registerReceiver(this, var2);
        IntentFilter var4 = new IntentFilter();
        var4.addAction("com.google.analytics.RADIO_POWERED");
        var4.addCategory(var1.getPackageName());
        var1.registerReceiver(this, var4);
    }
}
