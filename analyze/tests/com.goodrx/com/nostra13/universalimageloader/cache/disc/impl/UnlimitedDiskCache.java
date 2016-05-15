package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

public class UnlimitedDiskCache extends BaseDiskCache {
   public UnlimitedDiskCache(File var1, File var2, FileNameGenerator var3) {
      super(var1, var2, var3);
   }
}
