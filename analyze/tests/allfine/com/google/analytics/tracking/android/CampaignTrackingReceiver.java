package com.google.analytics.tracking.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingService;

public final class CampaignTrackingReceiver extends BroadcastReceiver {
    static final String CAMPAIGN_KEY = "referrer";
    static final String INSTALL_ACTION = "com.android.vending.INSTALL_REFERRER";

    public void onReceive(Context var1, Intent var2) {
        String var3 = var2.getStringExtra("referrer");
        if("com.android.vending.INSTALL_REFERRER".equals(var2.getAction()) && var3 != null) {
            Intent var4 = new Intent(var1, CampaignTrackingService.class);
            var4.putExtra("referrer", var3);
            var1.startService(var4);
        }
    }
}
