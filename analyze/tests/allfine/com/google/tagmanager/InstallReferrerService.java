package com.google.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.analytics.tracking.android.CampaignTrackingService;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.InstallReferrerUtil;

public final class InstallReferrerService extends IntentService {
    @VisibleForTesting
    Context contextOverride;
    @VisibleForTesting
    CampaignTrackingService gaService;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String var1) {
        super(var1);
    }

    private void forwardToGoogleAnalytics(Context var1, Intent var2) {
        if(this.gaService == null) {
            this.gaService = new CampaignTrackingService();
        }

        this.gaService.processIntent(var1, var2);
    }

    protected void onHandleIntent(Intent var1) {
        String var2 = var1.getStringExtra("referrer");
        Context var3;
        if(this.contextOverride != null) {
            var3 = this.contextOverride;
        } else {
            var3 = this.getApplicationContext();
        }

        InstallReferrerUtil.saveInstallReferrer(var3, var2);
        this.forwardToGoogleAnalytics(var3, var1);
    }
}
