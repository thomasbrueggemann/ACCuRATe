package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_424;
import com.google.android.gms.internal.class_426;
import com.google.android.gms.internal.class_427;
import com.google.android.gms.internal.class_472;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.eb
@ez
public final class class_425 extends class_32.class_1468 implements ServiceConnection {
    private Context mContext;
    // $FF: renamed from: sD boolean
    private boolean field_1560 = false;
    // $FF: renamed from: sE int
    private int field_1561;
    // $FF: renamed from: sF android.content.Intent
    private Intent field_1562;
    // $FF: renamed from: sn com.google.android.gms.internal.dw
    private class_472 field_1563;
    // $FF: renamed from: su java.lang.String
    private String field_1564;
    // $FF: renamed from: sy com.google.android.gms.internal.ea
    private class_424 field_1565;

    public class_425(Context var1, String var2, boolean var3, int var4, Intent var5, class_424 var6) {
        this.field_1564 = var2;
        this.field_1561 = var4;
        this.field_1562 = var5;
        this.field_1560 = var3;
        this.mContext = var1;
        this.field_1565 = var6;
    }

    public void finishPurchase() {
        int var1 = class_427.method_2694(this.field_1562);
        if(this.field_1561 == -1 && var1 == 0) {
            this.field_1563 = new class_472(this.mContext);
            Context var2 = this.mContext;
            Intent var3 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            Context var10000 = this.mContext;
            var2.bindService(var3, this, 1);
        }
    }

    public String getProductId() {
        return this.field_1564;
    }

    public Intent getPurchaseData() {
        return this.field_1562;
    }

    public int getResultCode() {
        return this.field_1561;
    }

    public boolean isVerified() {
        return this.field_1560;
    }

    public void onServiceConnected(ComponentName var1, IBinder var2) {
        class_378.method_2459("In-app billing service connected.");
        this.field_1563.method_2875(var2);
        String var3 = class_427.method_2692(class_427.method_2695(this.field_1562));
        if(var3 != null) {
            if(this.field_1563.method_2873(this.mContext.getPackageName(), var3) == 0) {
                class_426.method_2685(this.mContext).method_2687(this.field_1565);
            }

            this.mContext.unbindService(this);
            this.field_1563.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName var1) {
        class_378.method_2459("In-app billing service disconnected.");
        this.field_1563.destroy();
    }
}
