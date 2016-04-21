package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.class_1090;

public class SupportErrorDialogFragment extends DialogFragment {
    // $FF: renamed from: HG android.content.DialogInterface.OnCancelListener
    private OnCancelListener field_5036 = null;
    private Dialog mDialog = null;

    public static SupportErrorDialogFragment newInstance(Dialog var0) {
        return newInstance(var0, (OnCancelListener)null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog var0, OnCancelListener var1) {
        SupportErrorDialogFragment var2 = new SupportErrorDialogFragment();
        Dialog var3 = (Dialog)class_1090.method_5681(var0, "Cannot display null dialog");
        var3.setOnCancelListener((OnCancelListener)null);
        var3.setOnDismissListener((OnDismissListener)null);
        var2.mDialog = var3;
        if(var1 != null) {
            var2.field_5036 = var1;
        }

        return var2;
    }

    public void onCancel(DialogInterface var1) {
        if(this.field_5036 != null) {
            this.field_5036.onCancel(var1);
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
