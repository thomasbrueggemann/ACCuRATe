package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.tagmanager.zzct;

class zzbl extends BroadcastReceiver {
   static final String zzSZ = zzbl.class.getName();
   private final zzct zzbjA;

   zzbl(zzct var1) {
      this.zzbjA = var1;
   }

   public static void zzbb(Context var0) {
      Intent var1 = new Intent("com.google.analytics.RADIO_POWERED");
      var1.addCategory(var0.getPackageName());
      var1.putExtra(zzSZ, true);
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

         zzct var6 = this.zzbjA;
         boolean var7;
         if(!var5.booleanValue()) {
            var7 = true;
         } else {
            var7 = false;
         }

         var6.zzay(var7);
      } else if("com.google.analytics.RADIO_POWERED".equals(var3) && !var2.hasExtra(zzSZ)) {
         this.zzbjA.zzjg();
         return;
      }

   }

   public void zzba(Context var1) {
      IntentFilter var2 = new IntentFilter();
      var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.registerReceiver(this, var2);
      IntentFilter var4 = new IntentFilter();
      var4.addAction("com.google.analytics.RADIO_POWERED");
      var4.addCategory(var1.getPackageName());
      var1.registerReceiver(this, var4);
   }
}
