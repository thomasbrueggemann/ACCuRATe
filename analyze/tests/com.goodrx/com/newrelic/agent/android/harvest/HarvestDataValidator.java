package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.ActivityTraces;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.harvest.HarvestData;
import com.newrelic.agent.android.harvest.MachineMeasurements;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import java.util.Iterator;
import java.util.List;

public class HarvestDataValidator extends HarvestAdapter {
   public void ensureActivityNameMetricsExist() {
      HarvestData var1 = Harvest.getInstance().getHarvestData();
      ActivityTraces var2 = var1.getActivityTraces();
      if(var2 != null && var2.count() != 0) {
         MachineMeasurements var3 = var1.getMetrics();
         if(var3 != null && !var3.isEmpty()) {
            Iterator var4 = var2.getActivityTraces().iterator();

            while(var4.hasNext()) {
               String var5 = ((ActivityTrace)var4.next()).rootTrace.displayName;
               int var6 = var5.indexOf("#");
               if(var6 > 0) {
                  var5 = var5.substring(0, var6);
               }

               String var7 = "Mobile/Activity/Name/" + var5;
               List var8 = var3.getMetrics().getAllUnscoped();
               boolean var9 = false;
               if(var8 != null) {
                  int var10 = var8.size();
                  var9 = false;
                  if(var10 > 0) {
                     Iterator var11 = var8.iterator();

                     while(true) {
                        boolean var12 = var11.hasNext();
                        var9 = false;
                        if(!var12) {
                           break;
                        }

                        if(((Metric)var11.next()).getName().startsWith(var7)) {
                           var9 = true;
                           break;
                        }
                     }
                  }
               }

               if(!var9) {
                  var3.addMetric(new Metric(var7));
               }
            }
         }
      }

   }

   public void onHarvestFinalize() {
      if(Harvest.isInitialized()) {
         this.ensureActivityNameMetricsExist();
      }
   }
}
