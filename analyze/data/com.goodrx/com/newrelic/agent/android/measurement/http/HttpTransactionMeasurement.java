package com.newrelic.agent.android.measurement.http;

import com.newrelic.agent.android.measurement.BaseMeasurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.Util;

public class HttpTransactionMeasurement extends BaseMeasurement {
   private String appData;
   private long bytesReceived;
   private long bytesSent;
   private int errorCode;
   private String httpMethod;
   private int statusCode;
   private double totalTime;
   private String url;

   public HttpTransactionMeasurement(String var1, String var2, int var3, int var4, long var5, double var7, long var9, long var11, String var13) {
      this(var1, var2, var3, var5, var7, var9, var11, var13);
      this.errorCode = var4;
   }

   public HttpTransactionMeasurement(String var1, String var2, int var3, long var4, double var6, long var8, long var10, String var12) {
      super(MeasurementType.Network);
      String var13 = Util.sanitizeUrl(var1);
      this.setName(var13);
      this.setScope(TraceMachine.getCurrentScope());
      this.setStartTime(var4);
      this.setEndTime(var4 + (long)((int)var6));
      this.setExclusiveTime((long)((int)(1000.0D * var6)));
      this.url = var13;
      this.httpMethod = var2;
      this.statusCode = var3;
      this.bytesSent = var8;
      this.bytesReceived = var10;
      this.totalTime = var6;
      this.appData = var12;
   }

   public double asDouble() {
      return this.totalTime;
   }

   public String getAppData() {
      return this.appData;
   }

   public long getBytesReceived() {
      return this.bytesReceived;
   }

   public long getBytesSent() {
      return this.bytesSent;
   }

   public int getErrorCode() {
      return this.errorCode;
   }

   public String getHttpMethod() {
      return this.httpMethod;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public double getTotalTime() {
      return this.totalTime;
   }

   public String getUrl() {
      return this.url;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   public String toString() {
      return "HttpTransactionMeasurement{url=\'" + this.url + '\'' + ", httpMethod=\'" + this.httpMethod + '\'' + ", totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", appData=\'" + this.appData + '\'' + '}';
   }
}
