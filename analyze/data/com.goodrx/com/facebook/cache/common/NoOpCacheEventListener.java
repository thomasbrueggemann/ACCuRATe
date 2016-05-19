package com.facebook.cache.common;

import com.facebook.cache.common.CacheEventListener;

public class NoOpCacheEventListener implements CacheEventListener {
   private static NoOpCacheEventListener sInstance = null;

   public static NoOpCacheEventListener getInstance() {
      synchronized(NoOpCacheEventListener.class){}

      NoOpCacheEventListener var1;
      try {
         if(sInstance == null) {
            sInstance = new NoOpCacheEventListener();
         }

         var1 = sInstance;
      } finally {
         ;
      }

      return var1;
   }

   public void onEviction(CacheEventListener.EvictionReason var1, int var2, long var3) {
   }

   public void onHit() {
   }

   public void onMiss() {
   }

   public void onReadException() {
   }

   public void onWriteAttempt() {
   }

   public void onWriteException() {
   }
}
