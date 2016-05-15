package com.facebook.common.memory;

public enum MemoryTrimType {
   OnAppBackgrounded(1.0D),
   OnCloseToDalvikHeapLimit(0.5D),
   OnSystemLowMemoryWhileAppInBackground(1.0D),
   OnSystemLowMemoryWhileAppInForeground(0.5D);

   private double mSuggestedTrimRatio;

   static {
      MemoryTrimType[] var0 = new MemoryTrimType[]{OnCloseToDalvikHeapLimit, OnSystemLowMemoryWhileAppInForeground, OnSystemLowMemoryWhileAppInBackground, OnAppBackgrounded};
   }

   private MemoryTrimType(double var3) {
      this.mSuggestedTrimRatio = var3;
   }

   public double getSuggestedTrimRatio() {
      return this.mSuggestedTrimRatio;
   }
}
