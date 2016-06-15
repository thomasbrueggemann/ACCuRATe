package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.analytics.class_852;
import com.google.android.gms.analytics.u;

// $FF: renamed from: com.google.android.gms.analytics.u
class class_854 extends BroadcastReceiver {
   // $FF: renamed from: yR java.lang.String
   static final String field_3562 = u.class.getName();
   // $FF: renamed from: yS com.google.android.gms.analytics.aj
   private final class_852 field_3563;

   class_854(class_852 var1) {
      this.field_3563 = var1;
   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      if("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
         boolean var4 = var2.getBooleanExtra("noConnectivity", false);
         class_852 var5 = this.field_3563;
         boolean var6 = false;
         if(!var4) {
            var6 = true;
         }

         var5.method_4722(var6);
      } else if("com.google.analytics.RADIO_POWERED".equals(var3) && !var2.hasExtra(field_3562)) {
         this.field_3563.method_4723();
         return;
      }

   }

   // $FF: renamed from: z (android.content.Context) void
   public void method_4736(Context var1) {
      IntentFilter var2 = new IntentFilter();
      var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.registerReceiver(this, var2);
      IntentFilter var4 = new IntentFilter();
      var4.addAction("com.google.analytics.RADIO_POWERED");
      var4.addCategory(var1.getPackageName());
      var1.registerReceiver(this, var4);
   }
}
