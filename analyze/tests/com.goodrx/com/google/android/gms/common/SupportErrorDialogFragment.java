package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.zzx;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class SupportErrorDialogFragment extends DialogFragment implements TraceFieldInterface {
   private Dialog mDialog = null;
   private OnCancelListener zzafD = null;

   public static SupportErrorDialogFragment newInstance(Dialog var0, OnCancelListener var1) {
      SupportErrorDialogFragment var2 = new SupportErrorDialogFragment();
      Dialog var3 = (Dialog)zzx.zzb(var0, "Cannot display null dialog");
      var3.setOnCancelListener((OnCancelListener)null);
      var3.setOnDismissListener((OnDismissListener)null);
      var2.mDialog = var3;
      if(var1 != null) {
         var2.zzafD = var1;
      }

      return var2;
   }

   public void onCancel(DialogInterface var1) {
      if(this.zzafD != null) {
         this.zzafD.onCancel(var1);
      }

   }

   public Dialog onCreateDialog(Bundle var1) {
      if(this.mDialog == null) {
         this.setShowsDialog(false);
      }

      return this.mDialog;
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }

   public void show(FragmentManager var1, String var2) {
      super.show(var1, var2);
   }
}
