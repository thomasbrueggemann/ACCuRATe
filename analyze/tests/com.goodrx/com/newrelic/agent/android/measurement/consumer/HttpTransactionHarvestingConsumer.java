package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.consumer.BaseMeasurementConsumer;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;

public class HttpTransactionHarvestingConsumer extends BaseMeasurementConsumer {
   public HttpTransactionHarvestingConsumer() {
      super(MeasurementType.Network);
   }

   public void consumeMeasurement(Measurement var1) {
      HttpTransactionMeasurement var2 = (HttpTransactionMeasurement)var1;
      HttpTransaction var3 = new HttpTransaction();
      var3.setUrl(var2.getUrl());
      var3.setHttpMethod(var2.getHttpMethod());
      var3.setStatusCode(var2.getStatusCode());
      var3.setErrorCode(var2.getErrorCode());
      var3.setTotalTime(var2.getTotalTime());
      var3.setCarrier(Agent.getActiveNetworkCarrier());
      var3.setWanType(Agent.getActiveNetworkWanType());
      var3.setBytesReceived(var2.getBytesReceived());
      var3.setBytesSent(var2.getBytesSent());
      var3.setAppData(var2.getAppData());
      var3.setTimestamp(Long.valueOf(var2.getStartTime()));
      Harvest.addHttpTransaction(var3);
   }
}
