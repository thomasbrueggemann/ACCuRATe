package com.facebook.imagepipeline.core;

import android.net.Uri;
import bolts.Continuation;
import bolts.Task;
import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ProducerSequenceFactory;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ImagePipeline {
   private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
   private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
   private final CacheKeyFactory mCacheKeyFactory;
   private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
   private AtomicLong mIdCounter = new AtomicLong();
   private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
   private final BufferedDiskCache mMainBufferedDiskCache;
   private final ProducerSequenceFactory mProducerSequenceFactory;
   private final RequestListener mRequestListener;
   private final BufferedDiskCache mSmallImageBufferedDiskCache;
   private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

   public ImagePipeline(ProducerSequenceFactory var1, Set<RequestListener> var2, Supplier<Boolean> var3, MemoryCache<CacheKey, CloseableImage> var4, MemoryCache<CacheKey, PooledByteBuffer> var5, BufferedDiskCache var6, BufferedDiskCache var7, CacheKeyFactory var8, ThreadHandoffProducerQueue var9) {
      this.mProducerSequenceFactory = var1;
      this.mRequestListener = new ForwardingRequestListener(var2);
      this.mIsPrefetchEnabledSupplier = var3;
      this.mBitmapMemoryCache = var4;
      this.mEncodedMemoryCache = var5;
      this.mMainBufferedDiskCache = var6;
      this.mSmallImageBufferedDiskCache = var7;
      this.mCacheKeyFactory = var8;
      this.mThreadHandoffProducerQueue = var9;
   }

   private String generateUniqueFutureId() {
      return String.valueOf(this.mIdCounter.getAndIncrement());
   }

   private Predicate<CacheKey> predicateForUri(Uri var1) {
      return new Predicate() {
         // $FF: synthetic field
         final String val$cacheKeySourceString;

         {
            this.val$cacheKeySourceString = var2;
         }

         public boolean apply(CacheKey var1) {
            return var1 instanceof BitmapMemoryCacheKey?((BitmapMemoryCacheKey)var1).getSourceUriString().equals(this.val$cacheKeySourceString):false;
         }
      };
   }

   private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> param1, ImageRequest param2, ImageRequest.RequestLevel param3, Object param4) {
      // $FF: Couldn't be decompiled
   }

   private DataSource<Void> submitPrefetchRequest(Producer<Void> var1, ImageRequest var2, ImageRequest.RequestLevel var3, Object var4) {
      try {
         ImageRequest.RequestLevel var6 = ImageRequest.RequestLevel.getMax(var2.getLowestPermittedRequestLevel(), var3);
         DataSource var7 = ProducerToDataSourceAdapter.create(var1, new SettableProducerContext(var2, this.generateUniqueFutureId(), this.mRequestListener, var4, var6, true, false, Priority.LOW), this.mRequestListener);
         return var7;
      } catch (Exception var8) {
         return DataSources.immediateFailedDataSource(var8);
      }
   }

   public void clearCaches() {
      this.clearMemoryCaches();
      this.clearDiskCaches();
   }

   public void clearDiskCaches() {
      this.mMainBufferedDiskCache.clearAll();
      this.mSmallImageBufferedDiskCache.clearAll();
   }

   public void clearMemoryCaches() {
      Predicate var1 = new Predicate() {
         public boolean apply(CacheKey var1) {
            return true;
         }
      };
      this.mBitmapMemoryCache.removeAll(var1);
      this.mEncodedMemoryCache.removeAll(var1);
   }

   public void evictFromCache(Uri var1) {
      this.evictFromMemoryCache(var1);
      this.evictFromDiskCache(var1);
   }

   public void evictFromDiskCache(Uri var1) {
      this.evictFromDiskCache(ImageRequest.fromUri(var1));
   }

   public void evictFromDiskCache(ImageRequest var1) {
      CacheKey var2 = this.mCacheKeyFactory.getEncodedCacheKey(var1);
      this.mMainBufferedDiskCache.remove(var2);
      this.mSmallImageBufferedDiskCache.remove(var2);
   }

   public void evictFromMemoryCache(Uri var1) {
      Predicate var2 = this.predicateForUri(var1);
      this.mBitmapMemoryCache.removeAll(var2);
      Predicate var4 = new Predicate() {
         // $FF: synthetic field
         final String val$cacheKeySourceString;

         {
            this.val$cacheKeySourceString = var2;
         }

         public boolean apply(CacheKey var1) {
            return var1.toString().equals(this.val$cacheKeySourceString);
         }
      };
      this.mEncodedMemoryCache.removeAll(var4);
   }

   public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest var1, Object var2) {
      try {
         DataSource var4 = this.submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(var1), var1, ImageRequest.RequestLevel.FULL_FETCH, var2);
         return var4;
      } catch (Exception var5) {
         return DataSources.immediateFailedDataSource(var5);
      }
   }

   public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest var1, Object var2) {
      Preconditions.checkNotNull(var1.getSourceUri());

      try {
         Producer var5 = this.mProducerSequenceFactory.getEncodedImageProducerSequence(var1);
         if(var1.getResizeOptions() != null) {
            var1 = ImageRequestBuilder.fromRequest(var1).setResizeOptions((ResizeOptions)null).build();
         }

         DataSource var6 = this.submitFetchRequest(var5, var1, ImageRequest.RequestLevel.FULL_FETCH, var2);
         return var6;
      } catch (Exception var7) {
         return DataSources.immediateFailedDataSource(var7);
      }
   }

   public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest var1, Object var2) {
      try {
         DataSource var4 = this.submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(var1), var1, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, var2);
         return var4;
      } catch (Exception var5) {
         return DataSources.immediateFailedDataSource(var5);
      }
   }

   public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest var1, final Object var2, final boolean var3) {
      return new Supplier() {
         public DataSource<CloseableReference<CloseableImage>> get() {
            return var3?ImagePipeline.this.fetchImageFromBitmapCache(var1, var2):ImagePipeline.this.fetchDecodedImage(var1, var2);
         }

         public String toString() {
            return Objects.toStringHelper((Object)this).add("uri", var1.getSourceUri()).toString();
         }
      };
   }

   public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest var1, final Object var2) {
      return new Supplier() {
         public DataSource<CloseableReference<PooledByteBuffer>> get() {
            return ImagePipeline.this.fetchEncodedImage(var1, var2);
         }

         public String toString() {
            return Objects.toStringHelper((Object)this).add("uri", var1.getSourceUri()).toString();
         }
      };
   }

   public boolean isInBitmapMemoryCache(Uri var1) {
      Predicate var2 = this.predicateForUri(var1);
      return this.mBitmapMemoryCache.contains(var2);
   }

   public boolean isInBitmapMemoryCache(ImageRequest var1) {
      CacheKey var2 = this.mCacheKeyFactory.getBitmapCacheKey(var1);
      CloseableReference var3 = this.mBitmapMemoryCache.get(var2);

      boolean var5;
      try {
         var5 = CloseableReference.isValid(var3);
      } finally {
         CloseableReference.closeSafely(var3);
      }

      return var5;
   }

   public DataSource<Boolean> isInDiskCache(Uri var1) {
      return this.isInDiskCache(ImageRequest.fromUri(var1));
   }

   public DataSource<Boolean> isInDiskCache(ImageRequest var1) {
      final CacheKey var2 = this.mCacheKeyFactory.getEncodedCacheKey(var1);
      final SimpleDataSource var3 = SimpleDataSource.create();
      this.mMainBufferedDiskCache.contains(var2).continueWithTask(new Continuation() {
         public Task<Boolean> then(Task<Boolean> var1) throws Exception {
            return !var1.isCancelled() && !var1.isFaulted() && ((Boolean)var1.getResult()).booleanValue()?Task.forResult(Boolean.valueOf(true)):ImagePipeline.this.mSmallImageBufferedDiskCache.contains(var2);
         }
      }).continueWith(new Continuation() {
         public Void then(Task<Boolean> var1) throws Exception {
            SimpleDataSource var2 = var3;
            boolean var3x;
            if(!var1.isCancelled() && !var1.isFaulted() && ((Boolean)var1.getResult()).booleanValue()) {
               var3x = true;
            } else {
               var3x = false;
            }

            var2.setResult(Boolean.valueOf(var3x));
            return null;
         }
      });
      return var3;
   }

   public boolean isPaused() {
      return this.mThreadHandoffProducerQueue.isQueueing();
   }

   public void pause() {
      this.mThreadHandoffProducerQueue.startQueueing();
   }

   public DataSource<Void> prefetchToBitmapCache(ImageRequest var1, Object var2) {
      if(!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
         return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
      } else {
         try {
            DataSource var4 = this.submitPrefetchRequest(this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(var1), var1, ImageRequest.RequestLevel.FULL_FETCH, var2);
            return var4;
         } catch (Exception var5) {
            return DataSources.immediateFailedDataSource(var5);
         }
      }
   }

   public DataSource<Void> prefetchToDiskCache(ImageRequest var1, Object var2) {
      if(!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
         return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
      } else {
         try {
            DataSource var4 = this.submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(var1), var1, ImageRequest.RequestLevel.FULL_FETCH, var2);
            return var4;
         } catch (Exception var5) {
            return DataSources.immediateFailedDataSource(var5);
         }
      }
   }

   public void resume() {
      this.mThreadHandoffProducerQueue.stopQueuing();
   }
}
