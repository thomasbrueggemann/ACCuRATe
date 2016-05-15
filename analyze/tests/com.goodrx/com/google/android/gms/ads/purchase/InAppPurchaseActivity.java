package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzin;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class InAppPurchaseActivity extends Activity implements TraceFieldInterface {
   private zzge zzOw;

   protected void onActivityResult(int var1, int var2, Intent var3) {
      try {
         if(this.zzOw != null) {
            this.zzOw.onActivityResult(var1, var2, var3);
         }
      } catch (RemoteException var5) {
         zzin.zzd("Could not forward onActivityResult to in-app purchase manager:", var5);
      }

      super.onActivityResult(var1, var2, var3);
   }

   protected void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onDestroy() {
      try {
         if(this.zzOw != null) {
            this.zzOw.onDestroy();
         }
      } catch (RemoteException var2) {
         zzin.zzd("Could not forward onDestroy to in-app purchase manager:", var2);
      }

      super.onDestroy();
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }
}
