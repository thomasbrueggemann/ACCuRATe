package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.analytics.class_649;
import com.google.android.gms.analytics.q;

// $FF: renamed from: com.google.android.gms.analytics.q
class class_648 extends BroadcastReceiver {
   // $FF: renamed from: tO java.lang.String
   static final String field_3397 = q.class.getName();
   // $FF: renamed from: tP com.google.android.gms.analytics.af
   private final class_649 field_3398;

   class_648(class_649 var1) {
      this.field_3398 = var1;
   }

   // $FF: renamed from: t (android.content.Context) void
   public static void method_3705(Context var0) {
      Intent var1 = new Intent("com.google.analytics.RADIO_POWERED");
      var1.addCategory(var0.getPackageName());
      var1.putExtra(field_3397, true);
      var0.sendBroadcast(var1);
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      if("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
         boolean var4 = var2.getBooleanExtra("noConnectivity", false);
         class_649 var5 = this.field_3398;
         boolean var6 = false;
         if(!var4) {
            var6 = true;
         }

         var5.method_3708(var6);
      } else if("com.google.analytics.RADIO_POWERED".equals(var3) && !var2.hasExtra(field_3397)) {
         this.field_3398.method_3707();
         return;
      }

   }

   // $FF: renamed from: s (android.content.Context) void
   public void method_3706(Context var1) {
      IntentFilter var2 = new IntentFilter();
      var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.registerReceiver(this, var2);
      IntentFilter var4 = new IntentFilter();
      var4.addAction("com.google.analytics.RADIO_POWERED");
      var4.addCategory(var1.getPackageName());
      var1.registerReceiver(this, var4);
   }
}
