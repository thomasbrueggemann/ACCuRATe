package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.tagmanager.class_520;

public final class InstallReferrerService extends IntentService {
   CampaignTrackingService afN;
   Context afO;

   public InstallReferrerService() {
      super("InstallReferrerService");
   }

   public InstallReferrerService(String var1) {
      super(var1);
   }

   // $FF: renamed from: a (android.content.Context, android.content.Intent) void
   private void method_4251(Context var1, Intent var2) {
      if(this.afN == null) {
         this.afN = new CampaignTrackingService();
      }

      this.afN.processIntent(var1, var2);
   }

   protected void onHandleIntent(Intent var1) {
      String var2 = var1.getStringExtra("referrer");
      Context var3;
      if(this.afO != null) {
         var3 = this.afO;
      } else {
         var3 = this.getApplicationContext();
      }

      class_520.method_2942(var3, var2);
      this.method_4251(var3, var1);
   }
}
