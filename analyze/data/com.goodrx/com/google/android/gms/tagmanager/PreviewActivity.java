package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class PreviewActivity extends Activity implements TraceFieldInterface {
   private void zzm(String var1, String var2, String var3) {
      AlertDialog var4 = (new Builder(this)).create();
      var4.setTitle(var1);
      var4.setMessage(var2);
      var4.setButton(-1, var3, new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
         }
      });
      var4.show();
   }

   public void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
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
