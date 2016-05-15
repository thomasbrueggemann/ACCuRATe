package com.facebook.imagepipeline.animated.impl;

import android.os.SystemClock;

class RollingStat {
   private static final int WINDOWS = 60;
   private final short[] mStat = new short[60];

   int getSum(int var1) {
      long var2 = SystemClock.uptimeMillis() / 1000L;
      int var4 = (int)((var2 - (long)var1) % 60L);
      int var5 = (int)(255L & var2 / 60L);
      int var6 = 0;

      for(int var7 = 0; var7 < var1; ++var7) {
         short var8 = this.mStat[(var4 + var7) % 60];
         int var9 = var8 & 255;
         if((255 & var8 >> 8) == var5) {
            var6 += var9;
         }
      }

      return var6;
   }

   void incrementStats(int var1) {
      long var2 = SystemClock.uptimeMillis() / 1000L;
      int var4 = (int)(var2 % 60L);
      int var5 = (int)(255L & var2 / 60L);
      short var6 = this.mStat[var4];
      int var7 = var6 & 255;
      int var8;
      if(var5 != (255 & var6 >> 8)) {
         var8 = var1;
      } else {
         var8 = var7 + var1;
      }

      int var9 = var8 | var5 << 8;
      this.mStat[var4] = (short)var9;
   }
}
