package com.facebook.cache.common;

import com.facebook.cache.common.CacheErrorLogger;
import javax.annotation.Nullable;

public class NoOpCacheErrorLogger implements CacheErrorLogger {
   private static NoOpCacheErrorLogger sInstance = null;

   public static NoOpCacheErrorLogger getInstance() {
      synchronized(NoOpCacheErrorLogger.class){}

      NoOpCacheErrorLogger var1;
      try {
         if(sInstance == null) {
            sInstance = new NoOpCacheErrorLogger();
         }

         var1 = sInstance;
      } finally {
         ;
      }

      return var1;
   }

   public void logError(CacheErrorLogger.CacheErrorCategory var1, Class<?> var2, String var3, @Nullable Throwable var4) {
   }
}
