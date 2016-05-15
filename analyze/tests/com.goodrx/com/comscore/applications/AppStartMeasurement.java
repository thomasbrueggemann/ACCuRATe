package com.comscore.applications;

import com.comscore.analytics.Core;
import com.comscore.applications.ApplicationMeasurement;
import com.comscore.applications.EventType;
import com.comscore.measurement.Label;
import com.comscore.utils.InstallReferrerReceiver;
import com.comscore.utils.RootDetector;
import java.util.HashMap;
import java.util.Iterator;

public class AppStartMeasurement extends ApplicationMeasurement {
   protected AppStartMeasurement(Core var1, EventType var2, String var3, boolean var4) {
      super(var1, var2, var3, var4, true, true);
      this.setLabel(new Label("ns_ap_gs", String.valueOf(var1.getFirstInstallId()), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_install", String.valueOf(var1.getInstallId()), Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_runs", String.valueOf(var1.getRunsCount()), Boolean.valueOf(false)));
      if(var4) {
         this.setLabel(new Label("ns_ap_csf", "1", Boolean.valueOf(false)));
      }

      String var5 = "0";
      if(RootDetector.isDeviceRooted()) {
         var5 = "1";
      }

      this.setLabel(new Label("ns_ap_jb", var5, Boolean.valueOf(false)));
      this.setLabel(new Label("ns_ap_lastrun", String.valueOf(var1.getPreviousGenesis()), Boolean.valueOf(false)));
      String var6 = var1.getPreviousVersion();
      if(var6 != null && var6.length() > 0) {
         this.setLabel(new Label("ns_ap_updated", var6, Boolean.valueOf(false)));
      }

      String var7 = var1.getStorage().get("exception_ocurrences");
      if(var7 != null && var7.length() > 0 && !var7.equals("0")) {
         this.setLabel(new Label("ns_ap_er", var7, Boolean.valueOf(false)));
         var1.getStorage().remove("exception_ocurrences");
      }

      if(var4) {
         HashMap var8 = InstallReferrerReceiver.retrieveReferrerLabels(var1.getAppContext());
         if(var8 != null) {
            Iterator var9 = var8.keySet().iterator();

            while(var9.hasNext()) {
               String var10 = (String)var9.next();
               this.setLabel(var10, (String)var8.get(var10));
            }
         }
      }

   }
}
