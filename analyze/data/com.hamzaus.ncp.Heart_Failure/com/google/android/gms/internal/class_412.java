package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_409;
import com.google.android.gms.internal.class_413;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.class_415;
import com.google.android.gms.internal.class_47;

// $FF: renamed from: com.google.android.gms.internal.cx
public final class class_412 extends class_47.class_1047 implements ServiceConnection {
   private Context mContext;
   // $FF: renamed from: oW com.google.android.gms.internal.cs
   private class_409 field_1816;
   // $FF: renamed from: pd java.lang.String
   private String field_1817;
   // $FF: renamed from: ph com.google.android.gms.internal.cw
   private class_413 field_1818;
   // $FF: renamed from: pm boolean
   private boolean field_1819 = false;
   // $FF: renamed from: pn int
   private int field_1820;
   // $FF: renamed from: po android.content.Intent
   private Intent field_1821;

   public class_412(Context var1, String var2, boolean var3, int var4, Intent var5, class_413 var6) {
      this.field_1817 = var2;
      this.field_1820 = var4;
      this.field_1821 = var5;
      this.field_1819 = var3;
      this.mContext = var1;
      this.field_1818 = var6;
   }

   public void finishPurchase() {
      int var1 = class_414.method_2531(this.field_1821);
      if(this.field_1820 == -1 && var1 == 0) {
         this.field_1816 = new class_409(this.mContext);
         Context var2 = this.mContext;
         Intent var3 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
         Context var10000 = this.mContext;
         var2.bindService(var3, this, 1);
      }
   }

   public String getProductId() {
      return this.field_1817;
   }

   public Intent getPurchaseData() {
      return this.field_1821;
   }

   public int getResultCode() {
      return this.field_1820;
   }

   public boolean isVerified() {
      return this.field_1819;
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      class_370.method_2356("In-app billing service connected.");
      this.field_1816.method_2520(var2);
      String var3 = class_414.method_2535(class_414.method_2532(this.field_1821));
      if(var3 != null) {
         if(this.field_1816.method_2517(this.mContext.getPackageName(), var3) == 0) {
            class_415.method_2537(this.mContext).method_2539(this.field_1818);
         }

         this.mContext.unbindService(this);
         this.field_1816.destroy();
      }
   }

   public void onServiceDisconnected(ComponentName var1) {
      class_370.method_2356("In-app billing service disconnected.");
      this.field_1816.destroy();
   }
}
