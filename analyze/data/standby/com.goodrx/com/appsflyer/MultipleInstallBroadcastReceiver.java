package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import java.util.Iterator;

public class MultipleInstallBroadcastReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      AFLogger.afLog("MultipleInstallBroadcastReceiver called");
      Iterator var3 = var1.getPackageManager().queryBroadcastReceivers(new Intent("com.android.vending.INSTALL_REFERRER"), 0).iterator();

      while(var3.hasNext()) {
         ResolveInfo var4 = (ResolveInfo)var3.next();
         String var5 = var2.getAction();
         if(var4.activityInfo.packageName.equals(var1.getPackageName()) && "com.android.vending.INSTALL_REFERRER".equals(var5) && !this.getClass().getName().equals(var4.activityInfo.name)) {
            AFLogger.afLog("trigger onReceive: class: " + var4.activityInfo.name);

            try {
               ((BroadcastReceiver)Class.forName(var4.activityInfo.name).newInstance()).onReceive(var1, var2);
            } catch (Throwable var7) {
               AFLogger.afLogE("error in BroadcastReceiver " + var4.activityInfo.name, var7);
            }
         }
      }

      AppsFlyerLib.getInstance().onReceive(var1, var2);
   }
}
