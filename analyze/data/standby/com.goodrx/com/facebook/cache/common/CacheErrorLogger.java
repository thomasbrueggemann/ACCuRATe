package com.facebook.cache.common;

import javax.annotation.Nullable;

public interface CacheErrorLogger {
   void logError(CacheErrorLogger.CacheErrorCategory var1, Class<?> var2, String var3, @Nullable Throwable var4);

   public static enum CacheErrorCategory {
      DELETE_FILE,
      EVICTION,
      GENERIC_IO,
      OTHER,
      READ_DECODE,
      READ_FILE,
      READ_FILE_NOT_FOUND,
      READ_INVALID_ENTRY,
      WRITE_CALLBACK_ERROR,
      WRITE_CREATE_DIR,
      WRITE_CREATE_TEMPFILE,
      WRITE_ENCODE,
      WRITE_INVALID_ENTRY,
      WRITE_RENAME_FILE_OTHER,
      WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND,
      WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND,
      WRITE_UPDATE_FILE_NOT_FOUND;

      static {
         CacheErrorLogger.CacheErrorCategory[] var0 = new CacheErrorLogger.CacheErrorCategory[]{READ_DECODE, READ_FILE, READ_FILE_NOT_FOUND, READ_INVALID_ENTRY, WRITE_ENCODE, WRITE_CREATE_TEMPFILE, WRITE_UPDATE_FILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND, WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND, WRITE_RENAME_FILE_OTHER, WRITE_CREATE_DIR, WRITE_CALLBACK_ERROR, WRITE_INVALID_ENTRY, DELETE_FILE, EVICTION, GENERIC_IO, OTHER};
      }
   }
}
