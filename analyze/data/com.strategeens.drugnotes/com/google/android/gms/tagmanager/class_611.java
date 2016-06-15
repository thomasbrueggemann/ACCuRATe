package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.tagmanager.bo;
import com.google.android.gms.tagmanager.class_642;

// $FF: renamed from: com.google.android.gms.tagmanager.bo
class class_611 extends BroadcastReceiver {
   // $FF: renamed from: yR java.lang.String
   static final String field_2716 = bo.class.getName();
   private final class_642 asb;

   class_611(class_642 var1) {
      this.asb = var1;
   }

   // $FF: renamed from: aa (android.content.Context) void
   public static void method_3486(Context var0) {
      Intent var1 = new Intent("com.google.analytics.RADIO_POWERED");
      var1.addCategory(var0.getPackageName());
      var1.putExtra(field_2716, true);
      var0.sendBroadcast(var1);
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      if("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
         Bundle var4 = var2.getExtras();
         Boolean var5 = Boolean.FALSE;
         if(var4 != null) {
            var5 = Boolean.valueOf(var2.getExtras().getBoolean("noConnectivity"));
         }

         class_642 var6 = this.asb;
         boolean var7;
         if(!var5.booleanValue()) {
            var7 = true;
         } else {
            var7 = false;
         }

         var6.method_3655(var7);
      } else if("com.google.analytics.RADIO_POWERED".equals(var3) && !var2.hasExtra(field_2716)) {
         this.asb.method_3656();
         return;
      }

   }

   // $FF: renamed from: z (android.content.Context) void
   public void method_3487(Context var1) {
      IntentFilter var2 = new IntentFilter();
      var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.registerReceiver(this, var2);
      IntentFilter var4 = new IntentFilter();
      var4.addAction("com.google.analytics.RADIO_POWERED");
      var4.addCategory(var1.getPackageName());
      var1.registerReceiver(this, var4);
   }
}
