package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.class_863;
import java.io.FileOutputStream;
import java.io.IOException;

public class CampaignTrackingService extends IntentService {
   public CampaignTrackingService() {
      super("CampaignIntentService");
   }

   public CampaignTrackingService(String var1) {
      super(var1);
   }

   public void onHandleIntent(Intent var1) {
      this.processIntent(this, var1);
   }

   public void processIntent(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("referrer");

      try {
         FileOutputStream var5 = var1.openFileOutput("gaInstallData", 0);
         var5.write(var3.getBytes());
         var5.close();
         class_863.method_4841("Stored campaign information.");
      } catch (IOException var6) {
         class_863.method_4839("Error storing install campaign.");
      }
   }
}
