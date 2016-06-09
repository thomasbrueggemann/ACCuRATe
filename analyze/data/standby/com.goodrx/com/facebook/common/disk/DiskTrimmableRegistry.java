package com.facebook.common.disk;

import com.facebook.common.disk.DiskTrimmable;

public interface DiskTrimmableRegistry {
   void registerDiskTrimmable(DiskTrimmable var1);

   void unregisterDiskTrimmable(DiskTrimmable var1);
}
