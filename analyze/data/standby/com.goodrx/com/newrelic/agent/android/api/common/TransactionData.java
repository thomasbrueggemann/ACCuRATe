package com.newrelic.agent.android.api.common;

import java.util.ArrayList;
import java.util.List;

public class TransactionData {
   private final String appData;
   private final long bytesReceived;
   private final long bytesSent;
   private final String carrier;
   private int errorCode;
   private final Object errorCodeLock = new Object();
   private final String httpMethod;
   private final int statusCode;
   private final float time;
   private final long timestamp;
   private final String url;
   private final String wanType;

   public TransactionData(String var1, String var2, String var3, float var4, int var5, int var6, long var7, long var9, String var11, String var12) {
      int var13 = var1.indexOf(63);
      if(var13 < 0) {
         var13 = var1.indexOf(59);
         if(var13 < 0) {
            var13 = var1.length();
         }
      }

      this.url = var1.substring(0, var13);
      this.httpMethod = var2;
      this.carrier = var3;
      this.time = var4;
      this.statusCode = var5;
      this.errorCode = var6;
      this.bytesSent = var7;
      this.bytesReceived = var9;
      this.appData = var11;
      this.wanType = var12;
      this.timestamp = System.currentTimeMillis();
   }

   public List<Object> asList() {
      ArrayList var1 = new ArrayList();
      var1.add(this.url);
      var1.add(this.carrier);
      var1.add(Float.valueOf(this.time));
      var1.add(Integer.valueOf(this.statusCode));
      var1.add(Integer.valueOf(this.errorCode));
      var1.add(Long.valueOf(this.bytesSent));
      var1.add(Long.valueOf(this.bytesReceived));
      var1.add(this.appData);
      return var1;
   }

   public TransactionData clone() {
      return new TransactionData(this.url, this.httpMethod, this.carrier, this.time, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.appData, this.wanType);
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
      // $FF: Couldn't be decompiled
   }

   public String getHttpMethod() {
      return this.httpMethod;
   }

   public int getStatusCode() {
      return this.statusCode;
   }

   public float getTime() {
      return this.time;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public String getUrl() {
      return this.url;
   }

   public String getWanType() {
      return this.wanType;
   }

   public void setErrorCode(int param1) {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      return "TransactionData{timestamp=" + this.timestamp + ", url=\'" + this.url + '\'' + ", httpMethod=\'" + this.httpMethod + '\'' + ", carrier=\'" + this.carrier + '\'' + ", time=" + this.time + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", errorCodeLock=" + this.errorCodeLock + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", appData=\'" + this.appData + '\'' + ", wanType=\'" + this.wanType + '\'' + '}';
   }
}
