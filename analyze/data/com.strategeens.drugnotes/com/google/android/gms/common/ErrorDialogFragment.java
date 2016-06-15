package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.google.android.gms.internal.class_335;

public class ErrorDialogFragment extends DialogFragment {
   // $FF: renamed from: Iw android.content.DialogInterface.OnCancelListener
   private OnCancelListener field_748 = null;
   private Dialog mDialog = null;

   public static ErrorDialogFragment newInstance(Dialog var0) {
      return newInstance(var0, (OnCancelListener)null);
   }

   public static ErrorDialogFragment newInstance(Dialog var0, OnCancelListener var1) {
      ErrorDialogFragment var2 = new ErrorDialogFragment();
      Dialog var3 = (Dialog)class_335.method_2306(var0, "Cannot display null dialog");
      var3.setOnCancelListener((OnCancelListener)null);
      var3.setOnDismissListener((OnDismissListener)null);
      var2.mDialog = var3;
      if(var1 != null) {
         var2.field_748 = var1;
      }

      return var2;
   }

   public void onCancel(DialogInterface var1) {
      if(this.field_748 != null) {
         this.field_748.onCancel(var1);
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
