package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier;
import com.facebook.cache.disk.EntryEvictionComparatorSupplier;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import java.io.File;
import javax.annotation.Nullable;

public class DiskCacheConfig {
   private final String mBaseDirectoryName;
   private final Supplier<File> mBaseDirectoryPathSupplier;
   private final CacheErrorLogger mCacheErrorLogger;
   private final CacheEventListener mCacheEventListener;
   private final long mDefaultSizeLimit;
   private final DiskTrimmableRegistry mDiskTrimmableRegistry;
   private final EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
   private final long mLowDiskSpaceSizeLimit;
   private final long mMinimumSizeLimit;
   private final int mVersion;

   private DiskCacheConfig(DiskCacheConfig.Builder var1) {
      this.mVersion = var1.mVersion;
      this.mBaseDirectoryName = (String)Preconditions.checkNotNull(var1.mBaseDirectoryName);
      this.mBaseDirectoryPathSupplier = (Supplier)Preconditions.checkNotNull(var1.mBaseDirectoryPathSupplier);
      this.mDefaultSizeLimit = var1.mMaxCacheSize;
      this.mLowDiskSpaceSizeLimit = var1.mMaxCacheSizeOnLowDiskSpace;
      this.mMinimumSizeLimit = var1.mMaxCacheSizeOnVeryLowDiskSpace;
      this.mEntryEvictionComparatorSupplier = (EntryEvictionComparatorSupplier)Preconditions.checkNotNull(var1.mEntryEvictionComparatorSupplier);
      Object var2;
      if(var1.mCacheErrorLogger == null) {
         var2 = NoOpCacheErrorLogger.getInstance();
      } else {
         var2 = var1.mCacheErrorLogger;
      }

      this.mCacheErrorLogger = (CacheErrorLogger)var2;
      Object var3;
      if(var1.mCacheEventListener == null) {
         var3 = NoOpCacheEventListener.getInstance();
      } else {
         var3 = var1.mCacheEventListener;
      }

      this.mCacheEventListener = (CacheEventListener)var3;
      Object var4;
      if(var1.mDiskTrimmableRegistry == null) {
         var4 = NoOpDiskTrimmableRegistry.getInstance();
      } else {
         var4 = var1.mDiskTrimmableRegistry;
      }

      this.mDiskTrimmableRegistry = (DiskTrimmableRegistry)var4;
   }

   // $FF: synthetic method
   DiskCacheConfig(DiskCacheConfig.Builder var1, Object var2) {
      this(var1);
   }

   public static DiskCacheConfig.Builder newBuilder(@Nullable Context var0) {
      return new DiskCacheConfig.Builder(var0);
   }

   public String getBaseDirectoryName() {
      return this.mBaseDirectoryName;
   }

   public Supplier<File> getBaseDirectoryPathSupplier() {
      return this.mBaseDirectoryPathSupplier;
   }

   public CacheErrorLogger getCacheErrorLogger() {
      return this.mCacheErrorLogger;
   }

   public CacheEventListener getCacheEventListener() {
      return this.mCacheEventListener;
   }

   public long getDefaultSizeLimit() {
      return this.mDefaultSizeLimit;
   }

   public DiskTrimmableRegistry getDiskTrimmableRegistry() {
      return this.mDiskTrimmableRegistry;
   }

   public EntryEvictionComparatorSupplier getEntryEvictionComparatorSupplier() {
      return this.mEntryEvictionComparatorSupplier;
   }

   public long getLowDiskSpaceSizeLimit() {
      return this.mLowDiskSpaceSizeLimit;
   }

   public long getMinimumSizeLimit() {
      return this.mMinimumSizeLimit;
   }

   public int getVersion() {
      return this.mVersion;
   }

   public static class Builder {
      private String mBaseDirectoryName;
      private Supplier<File> mBaseDirectoryPathSupplier;
      private CacheErrorLogger mCacheErrorLogger;
      private CacheEventListener mCacheEventListener;
      @Nullable
      private final Context mContext;
      private DiskTrimmableRegistry mDiskTrimmableRegistry;
      private EntryEvictionComparatorSupplier mEntryEvictionComparatorSupplier;
      private long mMaxCacheSize;
      private long mMaxCacheSizeOnLowDiskSpace;
      private long mMaxCacheSizeOnVeryLowDiskSpace;
      private int mVersion;

      private Builder(@Nullable Context var1) {
         this.mVersion = 1;
         this.mBaseDirectoryName = "image_cache";
         this.mMaxCacheSize = 41943040L;
         this.mMaxCacheSizeOnLowDiskSpace = 10485760L;
         this.mMaxCacheSizeOnVeryLowDiskSpace = 2097152L;
         this.mEntryEvictionComparatorSupplier = new DefaultEntryEvictionComparatorSupplier();
         this.mContext = var1;
      }

      // $FF: synthetic method
      Builder(Context var1, Object var2) {
         this(var1);
      }

      public DiskCacheConfig build() {
         boolean var1;
         if(this.mBaseDirectoryPathSupplier == null && this.mContext == null) {
            var1 = false;
         } else {
            var1 = true;
         }

         Preconditions.checkState(var1, "Either a non-null context or a base directory path or supplier must be provided.");
         if(this.mBaseDirectoryPathSupplier == null && this.mContext != null) {
            this.mBaseDirectoryPathSupplier = new Supplier() {
               public File get() {
                  return Builder.this.mContext.getApplicationContext().getCacheDir();
               }
            };
         }

         return new DiskCacheConfig(this);
      }

      public DiskCacheConfig.Builder setBaseDirectoryName(String var1) {
         this.mBaseDirectoryName = var1;
         return this;
      }

      public DiskCacheConfig.Builder setBaseDirectoryPath(File var1) {
         this.mBaseDirectoryPathSupplier = Suppliers.method_601(var1);
         return this;
      }

      public DiskCacheConfig.Builder setBaseDirectoryPathSupplier(Supplier<File> var1) {
         this.mBaseDirectoryPathSupplier = var1;
         return this;
      }

      public DiskCacheConfig.Builder setCacheErrorLogger(CacheErrorLogger var1) {
         this.mCacheErrorLogger = var1;
         return this;
      }

      public DiskCacheConfig.Builder setCacheEventListener(CacheEventListener var1) {
         this.mCacheEventListener = var1;
         return this;
      }

      public DiskCacheConfig.Builder setDiskTrimmableRegistry(DiskTrimmableRegistry var1) {
         this.mDiskTrimmableRegistry = var1;
         return this;
      }

      public DiskCacheConfig.Builder setEntryEvictionComparatorSupplier(EntryEvictionComparatorSupplier var1) {
         this.mEntryEvictionComparatorSupplier = var1;
         return this;
      }

      public DiskCacheConfig.Builder setMaxCacheSize(long var1) {
         this.mMaxCacheSize = var1;
         return this;
      }

      public DiskCacheConfig.Builder setMaxCacheSizeOnLowDiskSpace(long var1) {
         this.mMaxCacheSizeOnLowDiskSpace = var1;
         return this;
      }

      public DiskCacheConfig.Builder setMaxCacheSizeOnVeryLowDiskSpace(long var1) {
         this.mMaxCacheSizeOnVeryLowDiskSpace = var1;
         return this;
      }

      public DiskCacheConfig.Builder setVersion(int var1) {
         this.mVersion = var1;
         return this;
      }
   }
}
