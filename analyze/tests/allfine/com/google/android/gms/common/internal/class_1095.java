package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;

// $FF: renamed from: com.google.android.gms.common.internal.c
public class class_1095 implements OnClickListener {
    // $FF: renamed from: Lt android.support.v4.app.Fragment
    private final Fragment field_5143;
    // $FF: renamed from: Lu int
    private final int field_5144;
    private final Intent mIntent;
    // $FF: renamed from: nr android.app.Activity
    private final Activity field_5145;

    public class_1095(Activity var1, Intent var2, int var3) {
        this.field_5145 = var1;
        this.field_5143 = null;
        this.mIntent = var2;
        this.field_5144 = var3;
    }

    public class_1095(Fragment var1, Intent var2, int var3) {
        this.field_5145 = null;
        this.field_5143 = var1;
        this.mIntent = var2;
        this.field_5144 = var3;
    }

    public void onClick(DialogInterface param1, int param2) {
        // $FF: Couldn't be decompiled
    }
}
