package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.class_30;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.class_425;
import com.google.android.gms.internal.class_426;
import com.google.android.gms.internal.class_429;
import com.google.android.gms.internal.class_472;
import com.google.android.gms.internal.class_473;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.dz
@ez
public class class_475 extends class_30.class_1156 implements ServiceConnection {
    // $FF: renamed from: nr android.app.Activity
    private final Activity field_1824;
    // $FF: renamed from: sm com.google.android.gms.internal.el
    private class_33 field_1825;
    // $FF: renamed from: sn com.google.android.gms.internal.dw
    private class_472 field_1826;
    // $FF: renamed from: so com.google.android.gms.internal.ec
    private final class_426 field_1827;
    // $FF: renamed from: sq com.google.android.gms.internal.ee
    private class_429 field_1828;
    // $FF: renamed from: sw android.content.Context
    private Context field_1829;
    // $FF: renamed from: sx com.google.android.gms.internal.eg
    private class_34 field_1830;
    // $FF: renamed from: sy com.google.android.gms.internal.ea
    private class_424 field_1831;
    // $FF: renamed from: sz java.lang.String
    private String field_1832 = null;

    public class_475(Activity var1) {
        this.field_1824 = var1;
        this.field_1827 = class_426.method_2685(this.field_1824.getApplicationContext());
    }

    // $FF: renamed from: a (android.content.Context, boolean, com.google.android.gms.internal.dv) void
    public static void method_2886(Context var0, boolean var1, class_473 var2) {
        Intent var3 = new Intent();
        var3.setClassName(var0, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
        var3.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", var1);
        class_473.method_2876(var3, var2);
        var0.startActivity(var3);
    }

    // $FF: renamed from: a (java.lang.String, boolean, int, android.content.Intent) void
    private void method_2887(String var1, boolean var2, int var3, Intent var4) {
        try {
            this.field_1825.method_161(new class_425(this.field_1829, var1, var2, var3, var4, this.field_1831));
        } catch (RemoteException var6) {
            class_378.method_2461("Fail to invoke PlayStorePurchaseListener.");
        }
    }

    public void onActivityResult(int param1, int param2, Intent param3) {
        // $FF: Couldn't be decompiled
    }

    public void onCreate() {
        class_473 var1 = class_473.method_2877(this.field_1824.getIntent());
        this.field_1825 = var1.field_1820;
        this.field_1828 = var1.field_1821;
        this.field_1830 = var1.field_1822;
        this.field_1826 = new class_472(this.field_1824.getApplicationContext());
        this.field_1829 = var1.field_1823;
        Intent var2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        var2.setPackage("com.android.vending");
        this.field_1824.bindService(var2, this, 1);
    }

    public void onDestroy() {
        this.field_1824.unbindService(this);
        this.field_1826.destroy();
    }

    public void onServiceConnected(ComponentName param1, IBinder param2) {
        // $FF: Couldn't be decompiled
    }

    public void onServiceDisconnected(ComponentName var1) {
        class_378.method_2459("In-app billing service disconnected.");
        this.field_1826.destroy();
    }
}
