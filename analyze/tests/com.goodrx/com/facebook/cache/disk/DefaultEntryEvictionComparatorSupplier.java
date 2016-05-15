package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.EntryEvictionComparator;
import com.facebook.cache.disk.EntryEvictionComparatorSupplier;

public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
   public EntryEvictionComparator get() {
      return new EntryEvictionComparator() {
         public int compare(DiskStorage.Entry var1, DiskStorage.Entry var2) {
            long var3 = var1.getTimestamp();
            long var5 = var2.getTimestamp();
            return var3 < var5?-1:(var5 == var3?0:1);
         }
      };
   }
}
