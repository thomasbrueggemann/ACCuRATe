package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageSupplier;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;

public class DefaultDiskStorageSupplier implements DiskStorageSupplier {
   private static final Class<?> TAG = DefaultDiskStorageSupplier.class;
   private final String mBaseDirectoryName;
   private final Supplier<File> mBaseDirectoryPathSupplier;
   private final CacheErrorLogger mCacheErrorLogger;
   @VisibleForTesting
   volatile DefaultDiskStorageSupplier.State mCurrentState;
   private final int mVersion;

   public DefaultDiskStorageSupplier(int var1, Supplier<File> var2, String var3, CacheErrorLogger var4) {
      this.mVersion = var1;
      this.mCacheErrorLogger = var4;
      this.mBaseDirectoryPathSupplier = var2;
      this.mBaseDirectoryName = var3;
      this.mCurrentState = new DefaultDiskStorageSupplier.State((File)null, (DiskStorage)null);
   }

   private void createStorage() throws IOException {
      File var1 = new File((File)this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
      this.createRootDirectoryIfNecessary(var1);
      this.mCurrentState = new DefaultDiskStorageSupplier.State(var1, new DefaultDiskStorage(var1, this.mVersion, this.mCacheErrorLogger));
   }

   private boolean shouldCreateNewStorage() {
      DefaultDiskStorageSupplier.State var1 = this.mCurrentState;
      return var1.storage == null || var1.rootDirectory == null || !var1.rootDirectory.exists();
   }

   @VisibleForTesting
   void createRootDirectoryIfNecessary(File var1) throws IOException {
      try {
         FileUtils.mkdirs(var1);
      } catch (FileUtils.CreateDirectoryException var3) {
         this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", var3);
         throw var3;
      }

      FLog.method_378(TAG, "Created cache directory %s", var1.getAbsolutePath());
   }

   @VisibleForTesting
   void deleteOldStorageIfNecessary() {
      if(this.mCurrentState.storage != null && this.mCurrentState.rootDirectory != null) {
         FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
      }

   }

   public DiskStorage get() throws IOException {
      synchronized(this){}

      DiskStorage var2;
      try {
         if(this.shouldCreateNewStorage()) {
            this.deleteOldStorageIfNecessary();
            this.createStorage();
         }

         var2 = (DiskStorage)Preconditions.checkNotNull(this.mCurrentState.storage);
      } finally {
         ;
      }

      return var2;
   }

   @VisibleForTesting
   static class State {
      @Nullable
      public final File rootDirectory;
      @Nullable
      public final DiskStorage storage;

      @VisibleForTesting
      State(@Nullable File var1, @Nullable DiskStorage var2) {
         this.storage = var2;
         this.rootDirectory = var1;
      }
   }
}
