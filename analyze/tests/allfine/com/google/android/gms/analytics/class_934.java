package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.analytics.class_930;
import com.google.android.gms.analytics.p;

// $FF: renamed from: com.google.android.gms.analytics.p
class class_934 extends BroadcastReceiver {
    // $FF: renamed from: ya java.lang.String
    static final String field_4279 = p.class.getName();
    // $FF: renamed from: yb com.google.android.gms.analytics.ae
    private final class_930 field_4280;

    class_934(class_930 var1) {
        this.field_4280 = var1;
    }

    // $FF: renamed from: A (android.content.Context) void
    public static void method_4841(Context var0) {
        Intent var1 = new Intent("com.google.analytics.RADIO_POWERED");
        var1.addCategory(var0.getPackageName());
        var1.putExtra(field_4279, true);
        var0.sendBroadcast(var1);
    }

    public void onReceive(Context var1, Intent var2) {
        String var3 = var2.getAction();
        if("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
            boolean var4 = var2.getBooleanExtra("noConnectivity", false);
            class_930 var5 = this.field_4280;
            boolean var6 = false;
            if(!var4) {
                var6 = true;
            }

            var5.method_4808(var6);
        } else if("com.google.analytics.RADIO_POWERED".equals(var3) && !var2.hasExtra(field_4279)) {
            this.field_4280.method_4809();
            return;
        }

    }

    // $FF: renamed from: z (android.content.Context) void
    public void method_4842(Context var1) {
        IntentFilter var2 = new IntentFilter();
        var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        var1.registerReceiver(this, var2);
        IntentFilter var4 = new IntentFilter();
        var4.addAction("com.google.analytics.RADIO_POWERED");
        var4.addCategory(var1.getPackageName());
        var1.registerReceiver(this, var4);
    }
}
