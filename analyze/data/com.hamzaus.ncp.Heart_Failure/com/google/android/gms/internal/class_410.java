package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_407;
import com.google.android.gms.internal.class_409;
import com.google.android.gms.internal.class_412;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_439;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_49;
import com.google.android.gms.internal.class_50;

// $FF: renamed from: com.google.android.gms.internal.cv
public class class_410 extends class_49.class_848 implements ServiceConnection {
   // $FF: renamed from: oV com.google.android.gms.internal.dh
   private class_50 field_1803;
   // $FF: renamed from: oW com.google.android.gms.internal.cs
   private class_409 field_1804;
   // $FF: renamed from: oX com.google.android.gms.internal.cy
   private final class_415 field_1805;
   // $FF: renamed from: oZ com.google.android.gms.internal.da
   private class_439 field_1806;
   // $FF: renamed from: oe android.app.Activity
   private final Activity field_1807;
   // $FF: renamed from: pf android.content.Context
   private Context field_1808;
   // $FF: renamed from: pg com.google.android.gms.internal.dc
   private class_45 field_1809;
   // $FF: renamed from: ph com.google.android.gms.internal.cw
   private class_413 field_1810;
   // $FF: renamed from: pi java.lang.String
   private String field_1811 = null;

   public class_410(Activity var1) {
      this.field_1807 = var1;
      this.field_1805 = class_415.method_2537(this.field_1807.getApplicationContext());
   }

   // $FF: renamed from: a (android.content.Context, boolean, com.google.android.gms.internal.cr) void
   public static void method_2522(Context var0, boolean var1, class_407 var2) {
      Intent var3 = new Intent();
      var3.setClassName(var0, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
      var3.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", var1);
      class_407.method_2508(var3, var2);
      var0.startActivity(var3);
   }

   // $FF: renamed from: a (java.lang.String, boolean, int, android.content.Intent) void
   private void method_2523(String var1, boolean var2, int var3, Intent var4) {
      try {
         this.field_1803.method_209(new class_412(this.field_1808, var1, var2, var3, var4, this.field_1810));
      } catch (RemoteException var6) {
         class_370.method_2358("Fail to invoke PlayStorePurchaseListener.");
      }
   }

   public void onActivityResult(int param1, int param2, Intent param3) {
      // $FF: Couldn't be decompiled
   }

   public void onCreate() {
      class_407 var1 = class_407.method_2509(this.field_1807.getIntent());
      this.field_1803 = var1.field_1798;
      this.field_1806 = var1.field_1799;
      this.field_1809 = var1.field_1800;
      this.field_1804 = new class_409(this.field_1807.getApplicationContext());
      this.field_1808 = var1.field_1801;
      Activity var2 = this.field_1807;
      Intent var3 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      this.field_1807.getApplicationContext();
      var2.bindService(var3, this, 1);
   }

   public void onDestroy() {
      this.field_1807.unbindService(this);
      this.field_1804.destroy();
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $FF: Couldn't be decompiled
   }

   public void onServiceDisconnected(ComponentName var1) {
      class_370.method_2356("In-app billing service disconnected.");
      this.field_1804.destroy();
   }
}
