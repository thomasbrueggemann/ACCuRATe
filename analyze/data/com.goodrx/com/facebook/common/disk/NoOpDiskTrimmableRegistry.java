package com.facebook.common.disk;

import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;

public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
   private static NoOpDiskTrimmableRegistry sInstance = null;

   public static NoOpDiskTrimmableRegistry getInstance() {
      synchronized(NoOpDiskTrimmableRegistry.class){}

      NoOpDiskTrimmableRegistry var1;
      try {
         if(sInstance == null) {
            sInstance = new NoOpDiskTrimmableRegistry();
         }

         var1 = sInstance;
      } finally {
         ;
      }

      return var1;
   }

   public void registerDiskTrimmable(DiskTrimmable var1) {
   }

   public void unregisterDiskTrimmable(DiskTrimmable var1) {
   }
}
