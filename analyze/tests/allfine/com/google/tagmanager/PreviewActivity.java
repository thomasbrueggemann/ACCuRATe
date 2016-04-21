package com.google.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class PreviewActivity extends Activity {
    private void displayAlert(String var1, String var2, String var3) {
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
}
