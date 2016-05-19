package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.io.HttpTransportMetrics;

public class HttpConnectionMetricsImpl {
   private final HttpTransportMetrics inTransportMetric;
   private final HttpTransportMetrics outTransportMetric;
   private long requestCount = 0L;
   private long responseCount = 0L;

   public HttpConnectionMetricsImpl(HttpTransportMetrics var1, HttpTransportMetrics var2) {
      this.inTransportMetric = var1;
      this.outTransportMetric = var2;
   }

   public void incrementRequestCount() {
      ++this.requestCount;
   }

   public void incrementResponseCount() {
      ++this.responseCount;
   }
}
