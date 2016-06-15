package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.class_32;
import com.google.android.gms.internal.class_34;
import com.google.android.gms.internal.class_36;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_411;
import com.google.android.gms.internal.class_412;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_419;
import com.google.android.gms.internal.class_421;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.ee
@ey
public class class_418 extends class_34.class_1216 implements ServiceConnection {
   // $FF: renamed from: nB android.app.Activity
   private final Activity field_1302;
   // $FF: renamed from: sF com.google.android.gms.internal.eb
   private class_412 field_1303;
   // $FF: renamed from: sG com.google.android.gms.internal.eh
   private final class_421 field_1304;
   // $FF: renamed from: sI com.google.android.gms.internal.ek
   private class_415 field_1305;
   // $FF: renamed from: sO android.content.Context
   private Context field_1306;
   // $FF: renamed from: sP com.google.android.gms.internal.em
   private class_32 field_1307;
   // $FF: renamed from: sQ com.google.android.gms.internal.ef
   private class_419 field_1308;
   // $FF: renamed from: sR com.google.android.gms.internal.ej
   private class_36 field_1309;
   // $FF: renamed from: sS java.lang.String
   private String field_1310 = null;

   public class_418(Activity var1) {
      this.field_1302 = var1;
      this.field_1304 = class_421.method_2778(this.field_1302.getApplicationContext());
   }

   // $FF: renamed from: a (android.content.Context, boolean, com.google.android.gms.internal.ea) void
   public static void method_2774(Context var0, boolean var1, class_411 var2) {
      Intent var3 = new Intent();
      var3.setClassName(var0, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
      var3.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", var1);
      class_411.method_2726(var3, var2);
      var0.startActivity(var3);
   }

   // $FF: renamed from: a (java.lang.String, boolean, int, android.content.Intent) void
   private void method_2775(String var1, boolean var2, int var3, Intent var4) {
      if(this.field_1309 != null) {
         this.field_1309.method_192(var1, var2, var3, var4, this.field_1308);
      }

   }

   public void onActivityResult(int param1, int param2, Intent param3) {
      // $FF: Couldn't be decompiled
   }

   public void onCreate() {
      class_411 var1 = class_411.method_2727(this.field_1302.getIntent());
      this.field_1309 = var1.field_1278;
      this.field_1305 = var1.field_1276;
      this.field_1307 = var1.field_1279;
      this.field_1303 = new class_412(this.field_1302.getApplicationContext());
      this.field_1306 = var1.field_1277;
      if(this.field_1302.getResources().getConfiguration().orientation == 2) {
         this.field_1302.setRequestedOrientation(6);
      } else {
         this.field_1302.setRequestedOrientation(7);
      }

      Intent var2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      var2.setPackage("com.android.vending");
      this.field_1302.bindService(var2, this, 1);
   }

   public void onDestroy() {
      this.field_1302.unbindService(this);
      this.field_1303.destroy();
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $FF: Couldn't be decompiled
   }

   public void onServiceDisconnected(ComponentName var1) {
      class_368.method_2504("In-app billing service disconnected.");
      this.field_1303.destroy();
   }
}
