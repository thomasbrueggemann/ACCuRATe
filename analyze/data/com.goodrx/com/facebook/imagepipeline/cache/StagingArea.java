package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class StagingArea {
   private static final Class<?> TAG = StagingArea.class;
   @GuardedBy("this")
   private Map<CacheKey, EncodedImage> mMap = new HashMap();

   public static StagingArea getInstance() {
      return new StagingArea();
   }

   private void logStats() {
      synchronized(this){}

      try {
         FLog.method_418(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
      } finally {
         ;
      }

   }

   public void clearAll() {
      // $FF: Couldn't be decompiled
   }

   public EncodedImage get(CacheKey param1) {
      // $FF: Couldn't be decompiled
   }

   public void put(CacheKey var1, EncodedImage var2) {
      synchronized(this){}

      try {
         Preconditions.checkNotNull(var1);
         Preconditions.checkArgument(EncodedImage.isValid(var2));
         EncodedImage.closeSafely((EncodedImage)this.mMap.put(var1, EncodedImage.cloneOrNull(var2)));
         this.logStats();
      } finally {
         ;
      }

   }

   public boolean remove(CacheKey param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean remove(CacheKey param1, EncodedImage param2) {
      // $FF: Couldn't be decompiled
   }
}
