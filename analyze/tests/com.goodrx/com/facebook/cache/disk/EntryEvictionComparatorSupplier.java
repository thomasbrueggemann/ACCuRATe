package com.facebook.cache.disk;

import com.facebook.cache.disk.EntryEvictionComparator;

public interface EntryEvictionComparatorSupplier {
   EntryEvictionComparator get();
}
