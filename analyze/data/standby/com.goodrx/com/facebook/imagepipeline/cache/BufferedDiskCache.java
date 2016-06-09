package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.StagingArea;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache {
   private static final Class<?> TAG = BufferedDiskCache.class;
   private final FileCache mFileCache;
   private final ImageCacheStatsTracker mImageCacheStatsTracker;
   private final PooledByteBufferFactory mPooledByteBufferFactory;
   private final PooledByteStreams mPooledByteStreams;
   private final Executor mReadExecutor;
   private final StagingArea mStagingArea;
   private final Executor mWriteExecutor;

   public BufferedDiskCache(FileCache var1, PooledByteBufferFactory var2, PooledByteStreams var3, Executor var4, Executor var5, ImageCacheStatsTracker var6) {
      this.mFileCache = var1;
      this.mPooledByteBufferFactory = var2;
      this.mPooledByteStreams = var3;
      this.mReadExecutor = var4;
      this.mWriteExecutor = var5;
      this.mImageCacheStatsTracker = var6;
      this.mStagingArea = StagingArea.getInstance();
   }

   // $FF: synthetic method
   static PooledByteBuffer access$400(BufferedDiskCache var0, CacheKey var1) throws IOException {
      return var0.readFromDiskCache(var1);
   }

   private PooledByteBuffer readFromDiskCache(CacheKey param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private void writeToDiskCache(CacheKey var1, final EncodedImage var2) {
      FLog.method_418(TAG, "About to write to disk-cache for key %s", var1.toString());

      try {
         this.mFileCache.insert(var1, new WriterCallback() {
            public void write(OutputStream var1) throws IOException {
               BufferedDiskCache.this.mPooledByteStreams.copy(var2.getInputStream(), var1);
            }
         });
         FLog.method_418(TAG, "Successful disk-cache write for key %s", var1.toString());
      } catch (IOException var6) {
         Class var4 = TAG;
         Object[] var5 = new Object[]{var1.toString()};
         FLog.method_436(var4, var6, "Failed to write to disk-cache for key %s", var5);
      }
   }

   public Task<Void> clearAll() {
      this.mStagingArea.clearAll();

      try {
         Task var2 = Task.call(new Callable() {
            public Void call() throws Exception {
               BufferedDiskCache.this.mStagingArea.clearAll();
               BufferedDiskCache.this.mFileCache.clearAll();
               return null;
            }
         }, this.mWriteExecutor);
         return var2;
      } catch (Exception var3) {
         FLog.method_436(TAG, var3, "Failed to schedule disk-cache clear", new Object[0]);
         return Task.forError(var3);
      }
   }

   public Task<Boolean> contains(final CacheKey var1) {
      Preconditions.checkNotNull(var1);
      EncodedImage var3 = this.mStagingArea.get(var1);
      if(var3 != null) {
         var3.close();
         FLog.method_418(TAG, "Found image for %s in staging area", var1.toString());
         this.mImageCacheStatsTracker.onStagingAreaHit();
         return Task.forResult(Boolean.valueOf(true));
      } else {
         try {
            Task var7 = Task.call(new Callable() {
               public Boolean call() throws Exception {
                  EncodedImage var1x = BufferedDiskCache.this.mStagingArea.get(var1);
                  if(var1x != null) {
                     var1x.close();
                     FLog.method_418(BufferedDiskCache.TAG, "Found image for %s in staging area", var1.toString());
                     BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit();
                     return Boolean.valueOf(true);
                  } else {
                     FLog.method_418(BufferedDiskCache.TAG, "Did not find image for %s in staging area", var1.toString());
                     BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();

                     try {
                        Boolean var3 = Boolean.valueOf(BufferedDiskCache.this.mFileCache.hasKey(var1));
                        return var3;
                     } catch (Exception var4) {
                        return Boolean.valueOf(false);
                     }
                  }
               }
            }, this.mReadExecutor);
            return var7;
         } catch (Exception var8) {
            Class var5 = TAG;
            Object[] var6 = new Object[]{var1.toString()};
            FLog.method_436(var5, var8, "Failed to schedule disk-cache read for %s", var6);
            return Task.forError(var8);
         }
      }
   }

   public Task<EncodedImage> get(final CacheKey var1, final AtomicBoolean var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      EncodedImage var5 = this.mStagingArea.get(var1);
      if(var5 != null) {
         FLog.method_418(TAG, "Found image for %s in staging area", var1.toString());
         this.mImageCacheStatsTracker.onStagingAreaHit();
         return Task.forResult(var5);
      } else {
         try {
            Task var9 = Task.call(new Callable() {
               public EncodedImage call() throws Exception {
                  // $FF: Couldn't be decompiled
               }
            }, this.mReadExecutor);
            return var9;
         } catch (Exception var10) {
            Class var7 = TAG;
            Object[] var8 = new Object[]{var1.toString()};
            FLog.method_436(var7, var10, "Failed to schedule disk-cache read for %s", var8);
            return Task.forError(var10);
         }
      }
   }

   public void put(final CacheKey var1, EncodedImage var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkArgument(EncodedImage.isValid(var2));
      this.mStagingArea.put(var1, var2);
      final EncodedImage var4 = EncodedImage.cloneOrNull(var2);

      try {
         this.mWriteExecutor.execute(new Runnable() {
            public void run() {
               try {
                  BufferedDiskCache.this.writeToDiskCache(var1, var4);
               } finally {
                  BufferedDiskCache.this.mStagingArea.remove(var1, var4);
                  EncodedImage.closeSafely(var4);
               }

            }
         });
      } catch (Exception var8) {
         Class var6 = TAG;
         Object[] var7 = new Object[]{var1.toString()};
         FLog.method_436(var6, var8, "Failed to schedule disk-cache write for %s", var7);
         this.mStagingArea.remove(var1, var2);
         EncodedImage.closeSafely(var4);
      }
   }

   public Task<Void> remove(final CacheKey var1) {
      Preconditions.checkNotNull(var1);
      this.mStagingArea.remove(var1);

      try {
         Task var7 = Task.call(new Callable() {
            public Void call() throws Exception {
               BufferedDiskCache.this.mStagingArea.remove(var1);
               BufferedDiskCache.this.mFileCache.remove(var1);
               return null;
            }
         }, this.mWriteExecutor);
         return var7;
      } catch (Exception var8) {
         Class var5 = TAG;
         Object[] var6 = new Object[]{var1.toString()};
         FLog.method_436(var5, var8, "Failed to schedule disk-cache remove for %s", var6);
         return Task.forError(var8);
      }
   }
}
