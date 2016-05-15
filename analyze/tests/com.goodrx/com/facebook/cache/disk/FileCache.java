package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;

public interface FileCache extends DiskTrimmable {
   void clearAll();

   long clearOldEntries(long var1);

   DiskStorage.DiskDumpInfo getDumpInfo() throws IOException;

   BinaryResource getResource(CacheKey var1);

   long getSize();

   boolean hasKey(CacheKey var1);

   BinaryResource insert(CacheKey var1, WriterCallback var2) throws IOException;

   boolean isEnabled();

   boolean probe(CacheKey var1);

   void remove(CacheKey var1);
}
