package com.facebook.imagepipeline.memory;

import com.facebook.imagepipeline.memory.BasePool;

public interface PoolStatsTracker {
   String BUCKETS_USED_PREFIX = "buckets_used_";
   String FREE_BYTES = "free_bytes";
   String FREE_COUNT = "free_count";
   String HARD_CAP = "hard_cap";
   String SOFT_CAP = "soft_cap";
   String USED_BYTES = "used_bytes";
   String USED_COUNT = "used_count";

   void onAlloc(int var1);

   void onFree(int var1);

   void onHardCapReached();

   void onSoftCapReached();

   void onValueRelease(int var1);

   void onValueReuse(int var1);

   void setBasePool(BasePool var1);
}
