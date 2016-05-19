package com.facebook.cache.common;

public interface CacheEventListener {
   void onEviction(CacheEventListener.EvictionReason var1, int var2, long var3);

   void onHit();

   void onMiss();

   void onReadException();

   void onWriteAttempt();

   void onWriteException();

   public static enum EvictionReason {
      CACHE_FULL,
      CACHE_MANAGER_TRIMMED,
      CONTENT_STALE,
      USER_FORCED;

      static {
         CacheEventListener.EvictionReason[] var0 = new CacheEventListener.EvictionReason[]{CACHE_FULL, CONTENT_STALE, USER_FORCED, CACHE_MANAGER_TRIMMED};
      }
   }
}
