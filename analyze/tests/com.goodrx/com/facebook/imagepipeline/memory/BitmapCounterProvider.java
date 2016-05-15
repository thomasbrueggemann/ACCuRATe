package com.facebook.imagepipeline.memory;

import com.facebook.imagepipeline.memory.BitmapCounter;

public class BitmapCounterProvider {
   // $FF: renamed from: KB long
   private static final long field_410 = 1024L;
   public static final int MAX_BITMAP_COUNT = 384;
   public static final int MAX_BITMAP_TOTAL_SIZE = getMaxSizeHardCap();
   // $FF: renamed from: MB long
   private static final long field_411 = 1048576L;
   private static BitmapCounter sBitmapCounter;

   public static BitmapCounter get() {
      if(sBitmapCounter == null) {
         sBitmapCounter = new BitmapCounter(384, MAX_BITMAP_TOTAL_SIZE);
      }

      return sBitmapCounter;
   }

   private static int getMaxSizeHardCap() {
      int var0 = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
      return (long)var0 > 16777216L?3 * (var0 / 4):var0 / 2;
   }
}
