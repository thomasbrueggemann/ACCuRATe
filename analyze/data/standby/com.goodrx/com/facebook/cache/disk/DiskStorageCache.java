package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageSupplier;
import com.facebook.cache.disk.EntryEvictionComparatorSupplier;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.SecureHashUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class DiskStorageCache implements FileCache, DiskTrimmable {
   private static final long FILECACHE_SIZE_UPDATE_PERIOD_MS = 0L;
   private static final long FUTURE_TIMESTAMP_THRESHOLD_MS = 0L;
   public static final int START_OF_VERSIONING = 1;
   private static final Class<?> TAG = DiskStorageCache.class;
   private static final double TRIMMING_LOWER_BOUND = 0.02D;
   private static final long UNINITIALIZED = -1L;
   private final CacheErrorLogger mCacheErrorLogger;
   private final CacheEventListener mCacheEventListener;
   @GuardedBy("mLock")
   private long mCacheSizeLastUpdateTime;
   private long mCacheSizeLimit;
   private final long mCacheSizeLimitMinimum;
   private final DiskStorageCache.CacheStats mCacheStats;
   private final Clock mClock;
   private final long mDefaultCacheSizeLimit;
   private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
   private final Object mLock = new Object();
   private final long mLowDiskSpaceCacheSizeLimit;
   private final StatFsHelper mStatFsHelper;
   private final DiskStorageSupplier mStorageSupplier;

   static {
      FUTURE_TIMESTAMP_THRESHOLD_MS = TimeUnit.HOURS.toMillis(2L);
      FILECACHE_SIZE_UPDATE_PERIOD_MS = TimeUnit.MINUTES.toMillis(30L);
   }

   public DiskStorageCache(DiskStorageSupplier var1, EntryEvictionComparatorSupplier var2, DiskStorageCache.Params var3, CacheEventListener var4, CacheErrorLogger var5, @Nullable DiskTrimmableRegistry var6) {
      this.mLowDiskSpaceCacheSizeLimit = var3.mLowDiskSpaceCacheSizeLimit;
      this.mDefaultCacheSizeLimit = var3.mDefaultCacheSizeLimit;
      this.mCacheSizeLimit = var3.mDefaultCacheSizeLimit;
      this.mStatFsHelper = StatFsHelper.getInstance();
      this.mStorageSupplier = var1;
      this.mEntryEvictionComparatorSupplier = var2;
      this.mCacheSizeLastUpdateTime = -1L;
      this.mCacheEventListener = var4;
      this.mCacheSizeLimitMinimum = var3.mCacheSizeLimitMinimum;
      this.mCacheErrorLogger = var5;
      this.mCacheStats = new DiskStorageCache.CacheStats();
      if(var6 != null) {
         var6.registerDiskTrimmable(this);
      }

      this.mClock = SystemClock.get();
   }

   @GuardedBy("mLock")
   private void calcFileCacheSize() {
      // $FF: Couldn't be decompiled
   }

   private FileBinaryResource commitResource(String param1, CacheKey param2, FileBinaryResource param3) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private FileBinaryResource createTemporaryResource(String var1, CacheKey var2) throws IOException {
      this.maybeEvictFilesInCacheDir();
      return this.mStorageSupplier.get().createTemporary(var1, var2);
   }

   private void deleteTemporaryResource(FileBinaryResource var1) {
      File var2 = var1.getFile();
      if(var2.exists()) {
         FLog.method_395(TAG, "Temp file still on disk: %s ", new Object[]{var2});
         if(!var2.delete()) {
            FLog.method_395(TAG, "Failed to delete temp file: %s", new Object[]{var2});
         }
      }

   }

   @GuardedBy("mLock")
   private void evictAboveSize(long var1, CacheEventListener.EvictionReason var3) throws IOException {
      DiskStorage var4 = this.mStorageSupplier.get();

      Collection var6;
      try {
         var6 = this.getSortedEntries(var4.getEntries());
      } catch (IOException var16) {
         this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.EVICTION, TAG, "evictAboveSize: " + var16.getMessage(), var16);
         throw var16;
      }

      long var7 = this.mCacheStats.getSize() - var1;
      int var9 = 0;
      long var10 = 0L;
      Iterator var12 = var6.iterator();

      while(var12.hasNext()) {
         DiskStorage.Entry var13 = (DiskStorage.Entry)var12.next();
         if(var10 > var7) {
            break;
         }

         long var14 = var4.remove(var13);
         if(var14 > 0L) {
            ++var9;
            var10 += var14;
         }
      }

      this.mCacheStats.increment(-var10, (long)(-var9));
      var4.purgeUnexpectedResources();
      this.reportEviction(var3, var9, var10);
   }

   private Collection<DiskStorage.Entry> getSortedEntries(Collection<DiskStorage.Entry> var1) {
      long var2 = this.mClock.now() + FUTURE_TIMESTAMP_THRESHOLD_MS;
      ArrayList var4 = new ArrayList(var1.size());
      ArrayList var5 = new ArrayList(var1.size());
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         DiskStorage.Entry var8 = (DiskStorage.Entry)var6.next();
         if(var8.getTimestamp() > var2) {
            var4.add(var8);
         } else {
            var5.add(var8);
         }
      }

      Collections.sort(var5, this.mEntryEvictionComparatorSupplier.get());
      var4.addAll(var5);
      return var4;
   }

   private void maybeEvictFilesInCacheDir() throws IOException {
      // $FF: Couldn't be decompiled
   }

   @GuardedBy("mLock")
   private boolean maybeUpdateFileCacheSize() {
      long var1 = android.os.SystemClock.elapsedRealtime();
      boolean var3;
      if(this.mCacheStats.isInitialized() && this.mCacheSizeLastUpdateTime != -1L) {
         long var5;
         int var4 = (var5 = var1 - this.mCacheSizeLastUpdateTime - FILECACHE_SIZE_UPDATE_PERIOD_MS) == 0L?0:(var5 < 0L?-1:1);
         var3 = false;
         if(var4 <= 0) {
            return var3;
         }
      }

      this.calcFileCacheSize();
      this.mCacheSizeLastUpdateTime = var1;
      var3 = true;
      return var3;
   }

   private void reportEviction(CacheEventListener.EvictionReason var1, int var2, long var3) {
      this.mCacheEventListener.onEviction(var1, var2, var3);
   }

   private void trimBy(double param1) {
      // $FF: Couldn't be decompiled
   }

   @GuardedBy("mLock")
   private void updateFileCacheSizeLimit() {
      if(this.mStatFsHelper.testLowDiskSpace(StatFsHelper.StorageType.INTERNAL, this.mDefaultCacheSizeLimit - this.mCacheStats.getSize())) {
         this.mCacheSizeLimit = this.mLowDiskSpaceCacheSizeLimit;
      } else {
         this.mCacheSizeLimit = this.mDefaultCacheSizeLimit;
      }
   }

   public void clearAll() {
      // $FF: Couldn't be decompiled
   }

   public long clearOldEntries(long param1) {
      // $FF: Couldn't be decompiled
   }

   public DiskStorage.DiskDumpInfo getDumpInfo() throws IOException {
      return this.mStorageSupplier.get().getDumpInfo();
   }

   public BinaryResource getResource(CacheKey param1) {
      // $FF: Couldn't be decompiled
   }

   @VisibleForTesting
   String getResourceId(CacheKey var1) {
      try {
         String var3 = SecureHashUtil.makeSHA1HashBase64(var1.toString().getBytes("UTF-8"));
         return var3;
      } catch (UnsupportedEncodingException var4) {
         throw new RuntimeException(var4);
      }
   }

   public long getSize() {
      return this.mCacheStats.getSize();
   }

   public boolean hasKey(CacheKey var1) {
      try {
         boolean var3 = this.mStorageSupplier.get().contains(this.getResourceId(var1), var1);
         return var3;
      } catch (IOException var4) {
         return false;
      }
   }

   public BinaryResource insert(CacheKey param1, WriterCallback param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public boolean isEnabled() {
      try {
         boolean var2 = this.mStorageSupplier.get().isEnabled();
         return var2;
      } catch (IOException var3) {
         return false;
      }
   }

   public boolean probe(CacheKey param1) {
      // $FF: Couldn't be decompiled
   }

   public void remove(CacheKey param1) {
      // $FF: Couldn't be decompiled
   }

   public void trimToMinimum() {
      // $FF: Couldn't be decompiled
   }

   public void trimToNothing() {
      this.clearAll();
   }

   @VisibleForTesting
   static class CacheStats {
      private long mCount = -1L;
      private boolean mInitialized = false;
      private long mSize = -1L;

      public long getCount() {
         synchronized(this){}

         long var2;
         try {
            var2 = this.mCount;
         } finally {
            ;
         }

         return var2;
      }

      public long getSize() {
         synchronized(this){}

         long var2;
         try {
            var2 = this.mSize;
         } finally {
            ;
         }

         return var2;
      }

      public void increment(long var1, long var3) {
         synchronized(this){}

         try {
            if(this.mInitialized) {
               this.mSize += var1;
               this.mCount += var3;
            }
         } finally {
            ;
         }

      }

      public boolean isInitialized() {
         synchronized(this){}

         boolean var2;
         try {
            var2 = this.mInitialized;
         } finally {
            ;
         }

         return var2;
      }

      public void reset() {
         synchronized(this){}

         try {
            this.mInitialized = false;
            this.mCount = -1L;
            this.mSize = -1L;
         } finally {
            ;
         }

      }

      public void set(long var1, long var3) {
         synchronized(this){}

         try {
            this.mCount = var3;
            this.mSize = var1;
            this.mInitialized = true;
         } finally {
            ;
         }

      }
   }

   public static class Params {
      public final long mCacheSizeLimitMinimum;
      public final long mDefaultCacheSizeLimit;
      public final long mLowDiskSpaceCacheSizeLimit;

      public Params(long var1, long var3, long var5) {
         this.mCacheSizeLimitMinimum = var1;
         this.mLowDiskSpaceCacheSizeLimit = var3;
         this.mDefaultCacheSizeLimit = var5;
      }
   }
}
