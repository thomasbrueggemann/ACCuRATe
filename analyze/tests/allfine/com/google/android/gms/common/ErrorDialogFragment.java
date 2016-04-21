package com.google.android.gms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.class_1090;

public class ErrorDialogFragment extends DialogFragment {
    // $FF: renamed from: HG android.content.DialogInterface.OnCancelListener
    private OnCancelListener field_1043 = null;
    private Dialog mDialog = null;

    public static ErrorDialogFragment newInstance(Dialog var0) {
        return newInstance(var0, (OnCancelListener)null);
    }

    public static ErrorDialogFragment newInstance(Dialog var0, OnCancelListener var1) {
        ErrorDialogFragment var2 = new ErrorDialogFragment();
        Dialog var3 = (Dialog)class_1090.method_5681(var0, "Cannot display null dialog");
        var3.setOnCancelListener((OnCancelListener)null);
        var3.setOnDismissListener((OnDismissListener)null);
        var2.mDialog = var3;
        if(var1 != null) {
            var2.field_1043 = var1;
        }

        return var2;
    }

    public void onCancel(DialogInterface var1) {
        if(this.field_1043 != null) {
            this.field_1043.onCancel(var1);
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
