package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.class_425;
import com.google.android.gms.internal.class_426;
import com.google.android.gms.internal.class_427;
import com.google.android.gms.internal.class_429;
import com.google.android.gms.internal.class_472;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.ez;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.dx
@ez
public class class_371 extends class_370 implements ServiceConnection {
    private Context mContext;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1346 = new Object();
    // $FF: renamed from: sl boolean
    private boolean field_1347 = false;
    // $FF: renamed from: sm com.google.android.gms.internal.el
    private class_33 field_1348;
    // $FF: renamed from: sn com.google.android.gms.internal.dw
    private class_472 field_1349;
    // $FF: renamed from: so com.google.android.gms.internal.ec
    private class_426 field_1350;
    // $FF: renamed from: sp java.util.List
    private List<ea> field_1351 = null;
    // $FF: renamed from: sq com.google.android.gms.internal.ee
    private class_429 field_1352;

    public class_371(Context var1, class_33 var2, class_429 var3) {
        this.mContext = var1;
        this.field_1348 = var2;
        this.field_1352 = var3;
        this.field_1349 = new class_472(var1);
        this.field_1350 = class_426.method_2685(this.mContext);
        this.field_1351 = this.field_1350.method_2690(10L);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ea, java.lang.String, java.lang.String) void
    private void method_2421(final class_424 var1, String var2, String var3) {
        final Intent var4 = new Intent();
        var4.putExtra("RESPONSE_CODE", 0);
        var4.putExtra("INAPP_PURCHASE_DATA", var2);
        var4.putExtra("INAPP_DATA_SIGNATURE", var3);
        class_377.field_1386.post(new Runnable() {
            public void run() {
                try {
                    if(class_371.this.field_1352.method_2718(var1.field_1558, -1, var4)) {
                        class_371.this.field_1348.method_161(new class_425(class_371.this.mContext, var1.field_1559, true, -1, var4, var1));
                    } else {
                        class_371.this.field_1348.method_161(new class_425(class_371.this.mContext, var1.field_1559, false, -1, var4, var1));
                    }
                } catch (RemoteException var2) {
                    class_378.method_2461("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    // $FF: renamed from: b (long) void
    private void method_2423(long var1) {
        do {
            if(!this.method_2425(var1)) {
                class_378.method_2461("Timeout waiting for pending transaction to be processed.");
            }
        } while(!this.field_1347);

    }

    // $FF: renamed from: c (long) boolean
    private boolean method_2425(long var1) {
        long var3 = 60000L - (SystemClock.elapsedRealtime() - var1);
        if(var3 <= 0L) {
            return false;
        } else {
            try {
                this.field_1346.wait(var3);
            } catch (InterruptedException var6) {
                class_378.method_2461("waitWithTimeout_lock interrupted");
            }

            return true;
        }
    }

    // $FF: renamed from: cp () void
    private void method_2426() {
        if(!this.field_1351.isEmpty()) {
            HashMap var1 = new HashMap();
            Iterator var2 = this.field_1351.iterator();

            while(var2.hasNext()) {
                class_424 var18 = (class_424)var2.next();
                var1.put(var18.field_1559, var18);
            }

            String var3 = null;

            while(true) {
                Bundle var4 = this.field_1349.method_2874(this.mContext.getPackageName(), var3);
                if(var4 == null || class_427.method_2693(var4) != 0) {
                    break;
                }

                ArrayList var5 = var4.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList var6 = var4.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList var7 = var4.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String var8 = var4.getString("INAPP_CONTINUATION_TOKEN");

                for(int var9 = 0; var9 < var5.size(); ++var9) {
                    if(var1.containsKey(var5.get(var9))) {
                        String var12 = (String)var5.get(var9);
                        String var13 = (String)var6.get(var9);
                        String var14 = (String)var7.get(var9);
                        class_424 var15 = (class_424)var1.get(var12);
                        String var16 = class_427.method_2691(var13);
                        if(var15.field_1558.equals(var16)) {
                            this.method_2421(var15, var13, var14);
                            var1.remove(var12);
                        }
                    }
                }

                if(var8 == null || var1.isEmpty()) {
                    break;
                }

                var3 = var8;
            }

            Iterator var10 = var1.keySet().iterator();

            while(var10.hasNext()) {
                String var11 = (String)var10.next();
                this.field_1350.method_2687((class_424)var1.get(var11));
            }
        }

    }

    // $FF: renamed from: co () void
    public void method_2419() {
        // $FF: Couldn't be decompiled
    }

    public void onServiceConnected(ComponentName param1, IBinder param2) {
        // $FF: Couldn't be decompiled
    }

    public void onServiceDisconnected(ComponentName var1) {
        class_378.method_2459("In-app billing service disconnected.");
        this.field_1349.destroy();
    }

    public void onStop() {
        // $FF: Couldn't be decompiled
    }
}
