package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.tagmanager.class_617;

public final class InstallReferrerService extends IntentService {
    CampaignTrackingService apw;
    Context apx;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String var1) {
        super(var1);
    }

    // $FF: renamed from: a (android.content.Context, android.content.Intent) void
    private void method_5474(Context var1, Intent var2) {
        if(this.apw == null) {
            this.apw = new CampaignTrackingService();
        }

        this.apw.processIntent(var1, var2);
    }

    protected void onHandleIntent(Intent var1) {
        String var2 = var1.getStringExtra("referrer");
        Context var3;
        if(this.apx != null) {
            var3 = this.apx;
        } else {
            var3 = this.getApplicationContext();
        }

        class_617.method_3480(var3, var2);
        this.method_5474(var3, var1);
    }
}
