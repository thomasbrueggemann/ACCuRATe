package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;

public class HttpTransaction extends HarvestableArray {
   private String appData;
   private long bytesReceived;
   private long bytesSent;
   private String carrier;
   private int errorCode;
   private String httpMethod;
   private int statusCode;
   private Long timestamp;
   private double totalTime;
   private String url;
   private String wanType;

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      var1.add(SafeJsonPrimitive.factory(this.url));
      var1.add(SafeJsonPrimitive.factory(this.carrier));
      var1.add(SafeJsonPrimitive.factory((Number)Double.valueOf(this.totalTime)));
      var1.add(SafeJsonPrimitive.factory((Number)Integer.valueOf(this.statusCode)));
      var1.add(SafeJsonPrimitive.factory((Number)Integer.valueOf(this.errorCode)));
      var1.add(SafeJsonPrimitive.factory((Number)Long.valueOf(this.bytesSent)));
      var1.add(SafeJsonPrimitive.factory((Number)Long.valueOf(this.bytesReceived)));
      JsonPrimitive var2;
      if(this.appData == null) {
         var2 = null;
      } else {
         var2 = SafeJsonPrimitive.factory(this.appData);
      }

      var1.add(var2);
      var1.add(SafeJsonPrimitive.factory(this.wanType));
      var1.add(SafeJsonPrimitive.factory(this.httpMethod));
      return var1;
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

   public String getCarrier() {
      return this.carrier;
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

   public Long getTimestamp() {
      return this.timestamp;
   }

   public double getTotalTime() {
      return this.totalTime;
   }

   public String getUrl() {
      return this.url;
   }

   public String getWanType() {
      return this.wanType;
   }

   public void setAppData(String var1) {
      this.appData = var1;
   }

   public void setBytesReceived(long var1) {
      this.bytesReceived = var1;
   }

   public void setBytesSent(long var1) {
      this.bytesSent = var1;
   }

   public void setCarrier(String var1) {
      this.carrier = var1;
   }

   public void setErrorCode(int var1) {
      this.errorCode = var1;
   }

   public void setHttpMethod(String var1) {
      this.httpMethod = var1;
   }

   public void setStatusCode(int var1) {
      this.statusCode = var1;
   }

   public void setTimestamp(Long var1) {
      this.timestamp = var1;
   }

   public void setTotalTime(double var1) {
      this.totalTime = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   public void setWanType(String var1) {
      this.wanType = var1;
   }

   public String toString() {
      return "HttpTransaction{url=\'" + this.url + '\'' + ", carrier=\'" + this.carrier + '\'' + ", wanType=\'" + this.wanType + '\'' + ", httpMethod=\'" + this.httpMethod + '\'' + ", totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", appData=\'" + this.appData + '\'' + ", timestamp=" + this.timestamp + '}';
   }
}
