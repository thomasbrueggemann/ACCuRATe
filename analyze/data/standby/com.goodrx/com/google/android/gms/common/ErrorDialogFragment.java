package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

@TargetApi(11)
public class ErrorDialogFragment extends DialogFragment {
   private Dialog mDialog = null;
   private OnCancelListener zzafD = null;

   public static ErrorDialogFragment newInstance(Dialog var0, OnCancelListener var1) {
      ErrorDialogFragment var2 = new ErrorDialogFragment();
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

   public void show(FragmentManager var1, String var2) {
      super.show(var1, var2);
   }
}
