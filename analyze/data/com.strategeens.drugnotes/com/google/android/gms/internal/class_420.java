package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.class_30;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_412;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.class_419;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.eg
@ey
public final class class_420 extends class_30.class_1218 implements ServiceConnection {
   private Context mContext;
   // $FF: renamed from: sF com.google.android.gms.internal.eb
   private class_412 field_1314;
   // $FF: renamed from: sM java.lang.String
   private String field_1315;
   // $FF: renamed from: sQ com.google.android.gms.internal.ef
   private class_419 field_1316;
   // $FF: renamed from: sW boolean
   private boolean field_1317 = false;
   // $FF: renamed from: sX int
   private int field_1318;
   // $FF: renamed from: sY android.content.Intent
   private Intent field_1319;

   public class_420(Context var1, String var2, boolean var3, int var4, Intent var5, class_419 var6) {
      this.field_1315 = var2;
      this.field_1318 = var4;
      this.field_1319 = var5;
      this.field_1317 = var3;
      this.mContext = var1;
      this.field_1316 = var6;
   }

   public void finishPurchase() {
      int var1 = class_414.method_2744(this.field_1319);
      if(this.field_1318 == -1 && var1 == 0) {
         this.field_1314 = new class_412(this.mContext);
         Intent var2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
         var2.setPackage("com.android.vending");
         this.mContext.bindService(var2, this, 1);
      }
   }

   public String getProductId() {
      return this.field_1315;
   }

   public Intent getPurchaseData() {
      return this.field_1319;
   }

   public int getResultCode() {
      return this.field_1318;
   }

   public boolean isVerified() {
      return this.field_1317;
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      class_368.method_2504("In-app billing service connected.");
      this.field_1314.method_2735(var2);
      String var3 = class_414.method_2742(class_414.method_2745(this.field_1319));
      if(var3 != null) {
         if(this.field_1314.method_2733(this.mContext.getPackageName(), var3) == 0) {
            class_421.method_2778(this.mContext).method_2780(this.field_1316);
         }

         this.mContext.unbindService(this);
         this.field_1314.destroy();
      }
   }

   public void onServiceDisconnected(ComponentName var1) {
      class_368.method_2504("In-app billing service disconnected.");
      this.field_1314.destroy();
   }
}
