package android.support.v4.util;

public final class Pools {
   public interface Pool<T> {
      T acquire();

      boolean release(T var1);
   }

   public static class SimplePool<T> implements Pools.Pool<T> {
      private final Object[] mPool;
      private int mPoolSize;

      public SimplePool(int var1) {
         if(var1 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
         } else {
            this.mPool = new Object[var1];
         }
      }

      private boolean isInPool(T var1) {
         for(int var2 = 0; var2 < this.mPoolSize; ++var2) {
            if(this.mPool[var2] == var1) {
               return true;
            }
         }

         return false;
      }

      public T acquire() {
         if(this.mPoolSize > 0) {
            int var1 = -1 + this.mPoolSize;
            Object var2 = this.mPool[var1];
            this.mPool[var1] = null;
            this.mPoolSize += -1;
            return var2;
         } else {
            return null;
         }
      }

      public boolean release(T var1) {
         if(this.isInPool(var1)) {
            throw new IllegalStateException("Already in the pool!");
         } else if(this.mPoolSize < this.mPool.length) {
            this.mPool[this.mPoolSize] = var1;
            ++this.mPoolSize;
            return true;
         } else {
            return false;
         }
      }
   }

   public static class SynchronizedPool<T> extends Pools.SimplePool<T> {
      private final Object mLock = new Object();

      public SynchronizedPool(int var1) {
         super(var1);
      }

      public T acquire() {
         // $FF: Couldn't be decompiled
      }

      public boolean release(T param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
