package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import com.android.internal.util.Predicate;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingLruMap;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.cache.ValueDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CountingMemoryCache<K, V> implements MemoryTrimmable, MemoryCache<K, V> {
   @VisibleForTesting
   static final long PARAMS_INTERCHECK_INTERVAL_MS;
   private final CountingMemoryCache.CacheTrimStrategy mCacheTrimStrategy;
   @VisibleForTesting
   @GuardedBy("this")
   final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mCachedEntries;
   @VisibleForTesting
   @GuardedBy("this")
   final CountingLruMap<K, CountingMemoryCache.Entry<K, V>> mExclusiveEntries;
   @GuardedBy("this")
   private long mLastCacheParamsCheck;
   @GuardedBy("this")
   protected MemoryCacheParams mMemoryCacheParams;
   private final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
   private final ValueDescriptor<V> mValueDescriptor;

   static {
      PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
   }

   public CountingMemoryCache(ValueDescriptor<V> var1, CountingMemoryCache.CacheTrimStrategy var2, Supplier<MemoryCacheParams> var3) {
      this.mValueDescriptor = var1;
      this.mExclusiveEntries = new CountingLruMap(this.wrapValueDescriptor(var1));
      this.mCachedEntries = new CountingLruMap(this.wrapValueDescriptor(var1));
      this.mCacheTrimStrategy = var2;
      this.mMemoryCacheParamsSupplier = var3;
      this.mMemoryCacheParams = (MemoryCacheParams)this.mMemoryCacheParamsSupplier.get();
      this.mLastCacheParamsCheck = SystemClock.elapsedRealtime();
   }

   private boolean canCacheNewValue(V var1) {
      synchronized(this){}
      boolean var8 = false;

      boolean var4;
      label53: {
         int var3;
         int var5;
         int var6;
         try {
            var8 = true;
            var3 = this.mValueDescriptor.getSizeInBytes(var1);
            if(var3 > this.mMemoryCacheParams.maxCacheEntrySize) {
               var8 = false;
               break label53;
            }

            if(this.getInUseCount() > -1 + this.mMemoryCacheParams.maxCacheEntries) {
               var8 = false;
               break label53;
            }

            var5 = this.getInUseSizeInBytes();
            var6 = this.mMemoryCacheParams.maxCacheSize;
            var8 = false;
         } finally {
            if(var8) {
               ;
            }
         }

         if(var5 <= var6 - var3) {
            var4 = true;
            return var4;
         }
      }

      var4 = false;
      return var4;
   }

   private void decreaseClientCount(CountingMemoryCache.Entry<K, V> param1) {
      // $FF: Couldn't be decompiled
   }

   private void increaseClientCount(CountingMemoryCache.Entry<K, V> param1) {
      // $FF: Couldn't be decompiled
   }

   private void makeOrphan(CountingMemoryCache.Entry<K, V> param1) {
      // $FF: Couldn't be decompiled
   }

   private void makeOrphans(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean maybeAddToExclusives(CountingMemoryCache.Entry<K, V> var1) {
      synchronized(this){}
      boolean var5 = false;

      boolean var3;
      label54: {
         try {
            var5 = true;
            if(!var1.isOrphan) {
               if(var1.clientCount == 0) {
                  this.mExclusiveEntries.put(var1.key, var1);
                  var5 = false;
                  break label54;
               }

               var5 = false;
            } else {
               var5 = false;
            }
         } finally {
            if(var5) {
               ;
            }
         }

         var3 = false;
         return var3;
      }

      var3 = true;
      return var3;
   }

   private void maybeClose(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> var1) {
      if(var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            CloseableReference.closeSafely(this.referenceToClose((CountingMemoryCache.Entry)var2.next()));
         }
      }

   }

   private void maybeEvictEntries() {
      // $FF: Couldn't be decompiled
   }

   private static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable CountingMemoryCache.Entry<K, V> var0) {
      if(var0 != null && var0.observer != null) {
         var0.observer.onExclusivityChanged(var0.key, true);
      }

   }

   private static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable CountingMemoryCache.Entry<K, V> var0) {
      if(var0 != null && var0.observer != null) {
         var0.observer.onExclusivityChanged(var0.key, false);
      }

   }

   private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<CountingMemoryCache.Entry<K, V>> var1) {
      if(var1 != null) {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            maybeNotifyExclusiveEntryRemoval((CountingMemoryCache.Entry)var2.next());
         }
      }

   }

   private void maybeUpdateCacheParams() {
      // $FF: Couldn't be decompiled
   }

   private CloseableReference<V> newClientReference(final CountingMemoryCache.Entry<K, V> var1) {
      synchronized(this){}

      CloseableReference var3;
      try {
         this.increaseClientCount(var1);
         var3 = CloseableReference.method_307(var1.valueRef.get(), new ResourceReleaser() {
            public void release(V var1x) {
               CountingMemoryCache.this.releaseClientReference(var1);
            }
         });
      } finally {
         ;
      }

      return var3;
   }

   @Nullable
   private CloseableReference<V> referenceToClose(CountingMemoryCache.Entry<K, V> var1) {
      synchronized(this){}
      boolean var6 = false;

      CloseableReference var4;
      try {
         var6 = true;
         Preconditions.checkNotNull(var1);
         if(var1.isOrphan) {
            if(var1.clientCount == 0) {
               var4 = var1.valueRef;
               var6 = false;
               return var4;
            }

            var6 = false;
         } else {
            var6 = false;
         }
      } finally {
         if(var6) {
            ;
         }
      }

      var4 = null;
      return var4;
   }

   private void releaseClientReference(CountingMemoryCache.Entry<K, V> param1) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   private ArrayList<CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private ValueDescriptor<CountingMemoryCache.Entry<K, V>> wrapValueDescriptor(final ValueDescriptor<V> var1) {
      return new ValueDescriptor() {
         public int getSizeInBytes(CountingMemoryCache.Entry<K, V> var1x) {
            return var1.getSizeInBytes(var1x.valueRef.get());
         }
      };
   }

   public CloseableReference<V> cache(K var1, CloseableReference<V> var2) {
      return this.cache(var1, var2, (CountingMemoryCache.EntryStateObserver)null);
   }

   public CloseableReference<V> cache(K param1, CloseableReference<V> param2, CountingMemoryCache.EntryStateObserver<K> param3) {
      // $FF: Couldn't be decompiled
   }

   public void clear() {
      // $FF: Couldn't be decompiled
   }

   public boolean contains(Predicate<K> var1) {
      synchronized(this){}
      boolean var6 = false;

      boolean var3;
      try {
         var6 = true;
         var3 = this.mCachedEntries.getMatchingEntries(var1).isEmpty();
         var6 = false;
      } finally {
         if(var6) {
            ;
         }
      }

      boolean var4;
      if(!var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   @Nullable
   public CloseableReference<V> get(K param1) {
      // $FF: Couldn't be decompiled
   }

   public int getCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.mCachedEntries.getCount();
      } finally {
         ;
      }

      return var2;
   }

   public int getEvictionQueueCount() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.mExclusiveEntries.getCount();
      } finally {
         ;
      }

      return var2;
   }

   public int getEvictionQueueSizeInBytes() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.mExclusiveEntries.getSizeInBytes();
      } finally {
         ;
      }

      return var2;
   }

   public int getInUseCount() {
      synchronized(this){}
      boolean var6 = false;

      int var2;
      int var3;
      try {
         var6 = true;
         var2 = this.mCachedEntries.getCount();
         var3 = this.mExclusiveEntries.getCount();
         var6 = false;
      } finally {
         if(var6) {
            ;
         }
      }

      int var4 = var2 - var3;
      return var4;
   }

   public int getInUseSizeInBytes() {
      synchronized(this){}
      boolean var6 = false;

      int var2;
      int var3;
      try {
         var6 = true;
         var2 = this.mCachedEntries.getSizeInBytes();
         var3 = this.mExclusiveEntries.getSizeInBytes();
         var6 = false;
      } finally {
         if(var6) {
            ;
         }
      }

      int var4 = var2 - var3;
      return var4;
   }

   public int getSizeInBytes() {
      synchronized(this){}

      int var2;
      try {
         var2 = this.mCachedEntries.getSizeInBytes();
      } finally {
         ;
      }

      return var2;
   }

   public int removeAll(Predicate<K> param1) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   public CloseableReference<V> reuse(K param1) {
      // $FF: Couldn't be decompiled
   }

   public void trim(MemoryTrimType param1) {
      // $FF: Couldn't be decompiled
   }

   public interface CacheTrimStrategy {
      double getTrimRatio(MemoryTrimType var1);
   }

   @VisibleForTesting
   static class Entry<K, V> {
      public int clientCount;
      public boolean isOrphan;
      public final K key;
      @Nullable
      public final CountingMemoryCache.EntryStateObserver<K> observer;
      public final CloseableReference<V> valueRef;

      private Entry(K var1, CloseableReference<V> var2, @Nullable CountingMemoryCache.EntryStateObserver<K> var3) {
         this.key = Preconditions.checkNotNull(var1);
         this.valueRef = (CloseableReference)Preconditions.checkNotNull(CloseableReference.cloneOrNull(var2));
         this.clientCount = 0;
         this.isOrphan = false;
         this.observer = var3;
      }

      // $FF: renamed from: of (java.lang.Object, com.facebook.common.references.CloseableReference, com.facebook.imagepipeline.cache.CountingMemoryCache$EntryStateObserver) com.facebook.imagepipeline.cache.CountingMemoryCache$Entry
      @VisibleForTesting
      static <K, V> CountingMemoryCache.Entry<K, V> method_478(K var0, CloseableReference<V> var1, @Nullable CountingMemoryCache.EntryStateObserver<K> var2) {
         return new CountingMemoryCache.Entry(var0, var1, var2);
      }
   }

   public interface EntryStateObserver<K> {
      void onExclusivityChanged(K var1, boolean var2);
   }
}
