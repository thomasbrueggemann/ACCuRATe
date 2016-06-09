package com.newrelic.agent.android.api.common;

import java.util.concurrent.TimeUnit;

public final class ConnectionState {
   public static final ConnectionState NULL = new ConnectionState();
   private final boolean collectingNetworkErrors;
   private final String crossProcessId;
   private final Object dataToken;
   private final int errorLimit;
   private final long harvestInterval;
   private final TimeUnit harvestIntervalTimeUnit;
   private final long maxTransactionAge;
   private final TimeUnit maxTransactionAgeTimeUnit;
   private final long maxTransactionCount;
   private final int responseBodyLimit;
   private final long serverTimestamp;
   private final int stackTraceLimit;

   private ConnectionState() {
      this.dataToken = null;
      this.crossProcessId = null;
      this.serverTimestamp = 0L;
      this.harvestInterval = 60L;
      this.harvestIntervalTimeUnit = TimeUnit.SECONDS;
      this.maxTransactionAge = 600L;
      this.maxTransactionAgeTimeUnit = TimeUnit.SECONDS;
      this.maxTransactionCount = 1000L;
      this.stackTraceLimit = 50;
      this.responseBodyLimit = 1024;
      this.collectingNetworkErrors = true;
      this.errorLimit = 10;
   }

   public ConnectionState(Object var1, String var2, long var3, long var5, TimeUnit var7, long var8, TimeUnit var10, long var11, int var13, int var14, boolean var15, int var16) {
      this.dataToken = var1;
      this.crossProcessId = var2;
      this.serverTimestamp = var3;
      this.harvestInterval = var5;
      this.harvestIntervalTimeUnit = var7;
      this.maxTransactionAge = var8;
      this.maxTransactionAgeTimeUnit = var10;
      this.maxTransactionCount = var11;
      this.stackTraceLimit = var13;
      this.responseBodyLimit = var14;
      this.collectingNetworkErrors = var15;
      this.errorLimit = var16;
   }

   public String getCrossProcessId() {
      return this.crossProcessId;
   }

   public Object getDataToken() {
      return this.dataToken;
   }

   public int getErrorLimit() {
      return this.errorLimit;
   }

   public long getHarvestIntervalInMilliseconds() {
      return TimeUnit.MILLISECONDS.convert(this.harvestInterval, this.harvestIntervalTimeUnit);
   }

   public long getHarvestIntervalInSeconds() {
      return TimeUnit.SECONDS.convert(this.harvestInterval, this.harvestIntervalTimeUnit);
   }

   public long getMaxTransactionAgeInMilliseconds() {
      return TimeUnit.MILLISECONDS.convert(this.maxTransactionAge, this.maxTransactionAgeTimeUnit);
   }

   public long getMaxTransactionAgeInSeconds() {
      return TimeUnit.SECONDS.convert(this.maxTransactionAge, this.maxTransactionAgeTimeUnit);
   }

   public long getMaxTransactionCount() {
      return this.maxTransactionCount;
   }

   public int getResponseBodyLimit() {
      return this.responseBodyLimit;
   }

   public long getServerTimestamp() {
      return this.serverTimestamp;
   }

   public int getStackTraceLimit() {
      return this.stackTraceLimit;
   }

   public boolean isCollectingNetworkErrors() {
      return this.collectingNetworkErrors;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.dataToken);
      return var1.toString();
   }
}
