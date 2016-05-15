package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import java.io.IOException;

public interface DiskStorageSupplier {
   DiskStorage get() throws IOException;
}
