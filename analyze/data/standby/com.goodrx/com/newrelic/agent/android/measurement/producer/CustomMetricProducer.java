package com.newrelic.agent.android.measurement.producer;

import com.newrelic.agent.android.measurement.CustomMetricMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.producer.BaseMeasurementProducer;
import com.newrelic.agent.android.metric.MetricUnit;

public class CustomMetricProducer extends BaseMeasurementProducer {
   private static final String FILTER_REGEX = "[/\\[\\]|*]";

   public CustomMetricProducer() {
      super(MeasurementType.Custom);
   }

   private String createMetricName(String var1, String var2, MetricUnit var3, MetricUnit var4) {
      StringBuffer var5 = new StringBuffer();
      var5.append(var2.replaceAll("[/\\[\\]|*]", ""));
      var5.append("/");
      var5.append(var1.replaceAll("[/\\[\\]|*]", ""));
      if(var3 != null || var4 != null) {
         var5.append("[");
         if(var4 != null) {
            var5.append(var4.getLabel());
         }

         if(var3 != null) {
            var5.append("|");
            var5.append(var3.getLabel());
         }

         var5.append("]");
      }

      return var5.toString();
   }

   public void produceMeasurement(String var1, String var2, int var3, double var4, double var6) {
      this.produceMeasurement(var2, var1, var3, var4, var6, (MetricUnit)null, (MetricUnit)null);
   }

   public void produceMeasurement(String var1, String var2, int var3, double var4, double var6, MetricUnit var8, MetricUnit var9) {
      this.produceMeasurement(new CustomMetricMeasurement(this.createMetricName(var1, var2, var8, var9), var3, var4, var6));
   }
}
