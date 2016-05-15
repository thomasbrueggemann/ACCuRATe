package com.newrelic.agent.android.harvest;

public class EnvironmentInformation {
   private long[] diskAvailable;
   private long memoryUsage;
   private String networkStatus;
   private String networkWanType;
   private int orientation;

   public EnvironmentInformation() {
   }

   public EnvironmentInformation(long var1, int var3, String var4, String var5, long[] var6) {
      this.memoryUsage = var1;
      this.orientation = var3;
      this.networkStatus = var4;
      this.networkWanType = var5;
      this.diskAvailable = var6;
   }

   public long[] getDiskAvailable() {
      return this.diskAvailable;
   }

   public long getMemoryUsage() {
      return this.memoryUsage;
   }

   public String getNetworkStatus() {
      return this.networkStatus;
   }

   public String getNetworkWanType() {
      return this.networkWanType;
   }

   public int getOrientation() {
      return this.orientation;
   }

   public void setDiskAvailable(long[] var1) {
      this.diskAvailable = var1;
   }

   public void setMemoryUsage(long var1) {
      this.memoryUsage = var1;
   }

   public void setNetworkStatus(String var1) {
      this.networkStatus = var1;
   }

   public void setNetworkWanType(String var1) {
      this.networkWanType = var1;
   }

   public void setOrientation(int var1) {
      this.orientation = var1;
   }
}
