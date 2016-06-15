package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.tagmanager.class_618;

public final class InstallReferrerService extends IntentService {
   CampaignTrackingService arF;
   Context arG;

   public InstallReferrerService() {
      super("InstallReferrerService");
   }

   public InstallReferrerService(String var1) {
      super(var1);
   }

   // $FF: renamed from: a (android.content.Context, android.content.Intent) void
   private void method_5357(Context var1, Intent var2) {
      if(this.arF == null) {
         this.arF = new CampaignTrackingService();
      }

      this.arF.processIntent(var1, var2);
   }

   protected void onHandleIntent(Intent var1) {
      String var2 = var1.getStringExtra("referrer");
      Context var3;
      if(this.arG != null) {
         var3 = this.arG;
      } else {
         var3 = this.getApplicationContext();
      }

      class_618.method_3516(var3, var2);
      this.method_5357(var3, var1);
   }
}
