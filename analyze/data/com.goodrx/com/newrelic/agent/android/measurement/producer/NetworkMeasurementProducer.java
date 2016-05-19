package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.util.Util;

public class NetworkMeasurementProducer extends BaseMeasurementProducer {
   public NetworkMeasurementProducer() {
      super(MeasurementType.Network);
   }

   public void produceMeasurement(HttpTransactionMeasurement var1) {
      String var2 = Util.sanitizeUrl(var1.getUrl());
      if(var2 != null) {
         var1.setUrl(var2);
         super.produceMeasurement(var1);
      }
   }

   public void produceMeasurement(String var1, String var2, int var3, int var4, long var5, double var7, long var9, long var11, String var13) {
      String var14 = Util.sanitizeUrl(var1);
      if(var14 != null) {
         this.produceMeasurement(new HttpTransactionMeasurement(var14, var2, var3, var4, var5, var7, var9, var11, var13));
      }
   }
}
