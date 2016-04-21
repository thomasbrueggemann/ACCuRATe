package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

// $FF: renamed from: com.google.android.gms.tagmanager.cz
class class_643 {
    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, java.lang.String) void
    static void method_3633(Context var0, String var1, String var2, String var3) {
        Editor var4 = var0.getSharedPreferences(var1, 0).edit();
        var4.putString(var2, var3);
        method_3634(var4);
    }

    // $FF: renamed from: a (android.content.SharedPreferences.Editor) void
    static void method_3634(final Editor var0) {
        if(VERSION.SDK_INT >= 9) {
            var0.apply();
        } else {
            (new Thread(new Runnable() {
                public void run() {
                    var0.commit();
                }
            })).start();
        }
    }
}
