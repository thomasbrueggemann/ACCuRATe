package com.facebook.cache.disk;

import com.facebook.cache.disk.DefaultDiskStorageSupplier;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DiskStorageSupplier;

public class DiskCacheFactory {
   public static DiskStorageCache newDiskStorageCache(DiskCacheConfig var0) {
      DiskStorageSupplier var1 = newDiskStorageSupplier(var0);
      DiskStorageCache.Params var2 = new DiskStorageCache.Params(var0.getMinimumSizeLimit(), var0.getLowDiskSpaceSizeLimit(), var0.getDefaultSizeLimit());
      return new DiskStorageCache(var1, var0.getEntryEvictionComparatorSupplier(), var2, var0.getCacheEventListener(), var0.getCacheErrorLogger(), var0.getDiskTrimmableRegistry());
   }

   private static DiskStorageSupplier newDiskStorageSupplier(DiskCacheConfig var0) {
      return new DefaultDiskStorageSupplier(var0.getVersion(), var0.getBaseDirectoryPathSupplier(), var0.getBaseDirectoryName(), var0.getCacheErrorLogger());
   }
}
