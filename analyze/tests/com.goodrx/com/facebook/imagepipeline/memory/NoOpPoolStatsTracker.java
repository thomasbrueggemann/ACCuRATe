package com.facebook.imagepipeline.memory;

import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.PoolStatsTracker;

public class NoOpPoolStatsTracker implements PoolStatsTracker {
   private static NoOpPoolStatsTracker sInstance = null;

   public static NoOpPoolStatsTracker getInstance() {
      synchronized(NoOpPoolStatsTracker.class){}

      NoOpPoolStatsTracker var1;
      try {
         if(sInstance == null) {
            sInstance = new NoOpPoolStatsTracker();
         }

         var1 = sInstance;
      } finally {
         ;
      }

      return var1;
   }

   public void onAlloc(int var1) {
   }

   public void onFree(int var1) {
   }

   public void onHardCapReached() {
   }

   public void onSoftCapReached() {
   }

   public void onValueRelease(int var1) {
   }

   public void onValueReuse(int var1) {
   }

   public void setBasePool(BasePool var1) {
   }
}
