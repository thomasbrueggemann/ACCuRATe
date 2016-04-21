package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.class_221;
import com.google.android.gms.internal.class_30;
import com.google.android.gms.internal.class_378;

public final class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    // $FF: renamed from: xk com.google.android.gms.internal.ei
    private class_30 field_4684;

    protected void onActivityResult(int var1, int var2, Intent var3) {
        try {
            if(this.field_4684 != null) {
                this.field_4684.onActivityResult(var1, var2, var3);
            }
        } catch (RemoteException var5) {
            class_378.method_2465("Could not forward onActivityResult to in-app purchase manager:", var5);
        }

        super.onActivityResult(var1, var2, var3);
    }

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.field_4684 = class_221.method_1520(this);
        if(this.field_4684 == null) {
            class_378.method_2461("Could not create in-app purchase manager.");
            this.finish();
        } else {
            try {
                this.field_4684.onCreate();
            } catch (RemoteException var3) {
                class_378.method_2465("Could not forward onCreate to in-app purchase manager:", var3);
                this.finish();
            }
        }
    }

    protected void onDestroy() {
        try {
            if(this.field_4684 != null) {
                this.field_4684.onDestroy();
            }
        } catch (RemoteException var2) {
            class_378.method_2465("Could not forward onDestroy to in-app purchase manager:", var2);
        }

        super.onDestroy();
    }
}
