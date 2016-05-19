package android.support.v7.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {
   private static final int CAPACITY_GROWTH = 10;
   private static final int DELETION = 2;
   private static final int INSERTION = 1;
   public static final int INVALID_POSITION = -1;
   private static final int LOOKUP = 4;
   private static final int MIN_CAPACITY = 10;
   private SortedList.BatchedCallback mBatchedCallback;
   private SortedList.Callback mCallback;
   T[] mData;
   private int mMergedSize;
   private T[] mOldData;
   private int mOldDataSize;
   private int mOldDataStart;
   private int mSize;
   private final Class<T> mTClass;

   public SortedList(Class<T> var1, SortedList.Callback<T> var2) {
      this(var1, var2, 10);
   }

   public SortedList(Class<T> var1, SortedList.Callback<T> var2, int var3) {
      this.mTClass = var1;
      this.mData = (Object[])((Object[])Array.newInstance(var1, var3));
      this.mCallback = var2;
      this.mSize = 0;
   }

   private int add(T var1, boolean var2) {
      int var3 = this.findIndexOf(var1, this.mData, 0, this.mSize, 1);
      if(var3 == -1) {
         var3 = 0;
      } else if(var3 < this.mSize) {
         Object var4 = this.mData[var3];
         if(this.mCallback.areItemsTheSame(var4, var1)) {
            if(this.mCallback.areContentsTheSame(var4, var1)) {
               this.mData[var3] = var1;
               return var3;
            }

            this.mData[var3] = var1;
            this.mCallback.onChanged(var3, 1);
            return var3;
         }
      }

      this.addToData(var3, var1);
      if(var2) {
         this.mCallback.onInserted(var3, 1);
      }

      return var3;
   }

   private void addAllInternal(T[] var1) {
      boolean var2;
      if(!(this.mCallback instanceof SortedList.BatchedCallback)) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var2) {
         this.beginBatchedUpdates();
      }

      this.mOldData = this.mData;
      this.mOldDataStart = 0;
      this.mOldDataSize = this.mSize;
      Arrays.sort(var1, this.mCallback);
      int var3 = this.deduplicate(var1);
      if(this.mSize == 0) {
         this.mData = var1;
         this.mSize = var3;
         this.mMergedSize = var3;
         this.mCallback.onInserted(0, var3);
      } else {
         this.merge(var1, var3);
      }

      this.mOldData = null;
      if(var2) {
         this.endBatchedUpdates();
      }

   }

   private void addToData(int var1, T var2) {
      if(var1 > this.mSize) {
         throw new IndexOutOfBoundsException("cannot add item to " + var1 + " because size is " + this.mSize);
      } else {
         if(this.mSize == this.mData.length) {
            Object[] var3 = (Object[])((Object[])Array.newInstance(this.mTClass, 10 + this.mData.length));
            System.arraycopy(this.mData, 0, var3, 0, var1);
            var3[var1] = var2;
            System.arraycopy(this.mData, var1, var3, var1 + 1, this.mSize - var1);
            this.mData = var3;
         } else {
            System.arraycopy(this.mData, var1, this.mData, var1 + 1, this.mSize - var1);
            this.mData[var1] = var2;
         }

         ++this.mSize;
      }
   }

   private int deduplicate(T[] var1) {
      if(var1.length == 0) {
         throw new IllegalArgumentException("Input array must be non-empty");
      } else {
         int var2 = 0;
         int var3 = 1;

         for(int var4 = 1; var4 < var1.length; ++var4) {
            Object var5 = var1[var4];
            int var6 = this.mCallback.compare(var1[var2], var5);
            if(var6 > 0) {
               throw new IllegalArgumentException("Input must be sorted in ascending order.");
            }

            if(var6 == 0) {
               int var8 = this.findSameItem(var5, var1, var2, var3);
               if(var8 != -1) {
                  var1[var8] = var5;
               } else {
                  if(var3 != var4) {
                     var1[var3] = var5;
                  }

                  ++var3;
               }
            } else {
               if(var3 != var4) {
                  var1[var3] = var5;
               }

               int var7 = var3 + 1;
               var2 = var3;
               var3 = var7;
            }
         }

         return var3;
      }
   }

   private int findIndexOf(T var1, T[] var2, int var3, int var4, int var5) {
      while(var3 < var4) {
         int var6 = (var3 + var4) / 2;
         Object var7 = var2[var6];
         int var8 = this.mCallback.compare(var7, var1);
         if(var8 < 0) {
            var3 = var6 + 1;
         } else {
            if(var8 == 0) {
               if(!this.mCallback.areItemsTheSame(var7, var1)) {
                  int var9 = this.linearEqualitySearch(var1, var6, var3, var4);
                  if(var5 != 1) {
                     return var9;
                  }

                  if(var9 != -1) {
                     return var9;
                  }
               }

               return var6;
            }

            var4 = var6;
         }
      }

      if(var5 != 1) {
         var3 = -1;
      }

      return var3;
   }

   private int findSameItem(T var1, T[] var2, int var3, int var4) {
      for(int var5 = var3; var5 < var4; ++var5) {
         if(this.mCallback.areItemsTheSame(var2[var5], var1)) {
            return var5;
         }
      }

      return -1;
   }

   private int linearEqualitySearch(T var1, int var2, int var3, int var4) {
      for(int var5 = var2 - 1; var5 >= var3; --var5) {
         Object var8 = this.mData[var5];
         if(this.mCallback.compare(var8, var1) != 0) {
            break;
         }

         if(this.mCallback.areItemsTheSame(var8, var1)) {
            return var5;
         }
      }

      for(int var6 = var2 + 1; var6 < var4; ++var6) {
         Object var7 = this.mData[var6];
         if(this.mCallback.compare(var7, var1) != 0) {
            break;
         }

         if(this.mCallback.areItemsTheSame(var7, var1)) {
            return var6;
         }
      }

      return -1;
   }

   private void merge(T[] var1, int var2) {
      int var3 = 10 + var2 + this.mSize;
      this.mData = (Object[])((Object[])Array.newInstance(this.mTClass, var3));
      this.mMergedSize = 0;
      int var4 = 0;

      while(this.mOldDataStart < this.mOldDataSize || var4 < var2) {
         if(this.mOldDataStart == this.mOldDataSize) {
            int var15 = var2 - var4;
            System.arraycopy(var1, var4, this.mData, this.mMergedSize, var15);
            this.mMergedSize += var15;
            this.mSize += var15;
            this.mCallback.onInserted(this.mMergedSize - var15, var15);
            break;
         }

         if(var4 == var2) {
            int var14 = this.mOldDataSize - this.mOldDataStart;
            System.arraycopy(this.mOldData, this.mOldDataStart, this.mData, this.mMergedSize, var14);
            this.mMergedSize += var14;
            return;
         }

         Object var5 = this.mOldData[this.mOldDataStart];
         Object var6 = var1[var4];
         int var7 = this.mCallback.compare(var5, var6);
         if(var7 > 0) {
            Object[] var12 = this.mData;
            int var13 = this.mMergedSize;
            this.mMergedSize = var13 + 1;
            var12[var13] = var6;
            ++this.mSize;
            ++var4;
            this.mCallback.onInserted(-1 + this.mMergedSize, 1);
         } else if(var7 == 0 && this.mCallback.areItemsTheSame(var5, var6)) {
            Object[] var10 = this.mData;
            int var11 = this.mMergedSize;
            this.mMergedSize = var11 + 1;
            var10[var11] = var6;
            ++var4;
            ++this.mOldDataStart;
            if(!this.mCallback.areContentsTheSame(var5, var6)) {
               this.mCallback.onChanged(-1 + this.mMergedSize, 1);
            }
         } else {
            Object[] var8 = this.mData;
            int var9 = this.mMergedSize;
            this.mMergedSize = var9 + 1;
            var8[var9] = var5;
            ++this.mOldDataStart;
         }
      }

   }

   private boolean remove(T var1, boolean var2) {
      int var3 = this.findIndexOf(var1, this.mData, 0, this.mSize, 2);
      if(var3 == -1) {
         return false;
      } else {
         this.removeItemAtIndex(var3, var2);
         return true;
      }
   }

   private void removeItemAtIndex(int var1, boolean var2) {
      System.arraycopy(this.mData, var1 + 1, this.mData, var1, -1 + (this.mSize - var1));
      this.mSize += -1;
      this.mData[this.mSize] = null;
      if(var2) {
         this.mCallback.onRemoved(var1, 1);
      }

   }

   private void throwIfMerging() {
      if(this.mOldData != null) {
         throw new IllegalStateException("Cannot call this method from within addAll");
      }
   }

   public int add(T var1) {
      this.throwIfMerging();
      return this.add(var1, true);
   }

   public void addAll(Collection<T> var1) {
      this.addAll(var1.toArray((Object[])((Object[])Array.newInstance(this.mTClass, var1.size()))), true);
   }

   public void addAll(T... var1) {
      this.addAll(var1, false);
   }

   public void addAll(T[] var1, boolean var2) {
      this.throwIfMerging();
      if(var1.length != 0) {
         if(var2) {
            this.addAllInternal(var1);
         } else {
            Object[] var3 = (Object[])((Object[])Array.newInstance(this.mTClass, var1.length));
            System.arraycopy(var1, 0, var3, 0, var1.length);
            this.addAllInternal(var3);
         }
      }
   }

   public void beginBatchedUpdates() {
      this.throwIfMerging();
      if(!(this.mCallback instanceof SortedList.BatchedCallback)) {
         if(this.mBatchedCallback == null) {
            this.mBatchedCallback = new SortedList.BatchedCallback(this.mCallback);
         }

         this.mCallback = this.mBatchedCallback;
      }
   }

   public void clear() {
      this.throwIfMerging();
      if(this.mSize != 0) {
         int var1 = this.mSize;
         Arrays.fill(this.mData, 0, var1, (Object)null);
         this.mSize = 0;
         this.mCallback.onRemoved(0, var1);
      }
   }

   public void endBatchedUpdates() {
      this.throwIfMerging();
      if(this.mCallback instanceof SortedList.BatchedCallback) {
         ((SortedList.BatchedCallback)this.mCallback).dispatchLastEvent();
      }

      if(this.mCallback == this.mBatchedCallback) {
         this.mCallback = this.mBatchedCallback.mWrappedCallback;
      }

   }

   public T get(int var1) throws IndexOutOfBoundsException {
      if(var1 < this.mSize && var1 >= 0) {
         return this.mOldData != null && var1 >= this.mMergedSize?this.mOldData[var1 - this.mMergedSize + this.mOldDataStart]:this.mData[var1];
      } else {
         throw new IndexOutOfBoundsException("Asked to get item at " + var1 + " but size is " + this.mSize);
      }
   }

   public int indexOf(T var1) {
      if(this.mOldData != null) {
         int var2 = this.findIndexOf(var1, this.mData, 0, this.mMergedSize, 4);
         if(var2 != -1) {
            return var2;
         } else {
            int var3 = this.findIndexOf(var1, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            return var3 != -1?var3 - this.mOldDataStart + this.mMergedSize:-1;
         }
      } else {
         return this.findIndexOf(var1, this.mData, 0, this.mSize, 4);
      }
   }

   public void recalculatePositionOfItemAt(int var1) {
      this.throwIfMerging();
      Object var2 = this.get(var1);
      this.removeItemAtIndex(var1, false);
      int var3 = this.add(var2, false);
      if(var1 != var3) {
         this.mCallback.onMoved(var1, var3);
      }

   }

   public boolean remove(T var1) {
      this.throwIfMerging();
      return this.remove(var1, true);
   }

   public T removeItemAt(int var1) {
      this.throwIfMerging();
      Object var2 = this.get(var1);
      this.removeItemAtIndex(var1, true);
      return var2;
   }

   public int size() {
      return this.mSize;
   }

   public void updateItemAt(int var1, T var2) {
      this.throwIfMerging();
      Object var3 = this.get(var1);
      boolean var4;
      if(var3 != var2 && this.mCallback.areContentsTheSame(var3, var2)) {
         var4 = false;
      } else {
         var4 = true;
      }

      if(var3 != var2 && this.mCallback.compare(var3, var2) == 0) {
         this.mData[var1] = var2;
         if(var4) {
            this.mCallback.onChanged(var1, 1);
         }
      } else {
         if(var4) {
            this.mCallback.onChanged(var1, 1);
         }

         this.removeItemAtIndex(var1, false);
         int var5 = this.add(var2, false);
         if(var1 != var5) {
            this.mCallback.onMoved(var1, var5);
            return;
         }
      }

   }

   public static class BatchedCallback<T2> extends SortedList.Callback<T2> {
      static final int TYPE_ADD = 1;
      static final int TYPE_CHANGE = 3;
      static final int TYPE_MOVE = 4;
      static final int TYPE_NONE = 0;
      static final int TYPE_REMOVE = 2;
      int mLastEventCount = -1;
      int mLastEventPosition = -1;
      int mLastEventType = 0;
      private final SortedList.Callback<T2> mWrappedCallback;

      public BatchedCallback(SortedList.Callback<T2> var1) {
         this.mWrappedCallback = var1;
      }

      public boolean areContentsTheSame(T2 var1, T2 var2) {
         return this.mWrappedCallback.areContentsTheSame(var1, var2);
      }

      public boolean areItemsTheSame(T2 var1, T2 var2) {
         return this.mWrappedCallback.areItemsTheSame(var1, var2);
      }

      public int compare(T2 var1, T2 var2) {
         return this.mWrappedCallback.compare(var1, var2);
      }

      public void dispatchLastEvent() {
         if(this.mLastEventType != 0) {
            switch(this.mLastEventType) {
            case 1:
               this.mWrappedCallback.onInserted(this.mLastEventPosition, this.mLastEventCount);
               break;
            case 2:
               this.mWrappedCallback.onRemoved(this.mLastEventPosition, this.mLastEventCount);
               break;
            case 3:
               this.mWrappedCallback.onChanged(this.mLastEventPosition, this.mLastEventCount);
            }

            this.mLastEventType = 0;
         }
      }

      public void onChanged(int var1, int var2) {
         if(this.mLastEventType == 3 && var1 <= this.mLastEventPosition + this.mLastEventCount && var1 + var2 >= this.mLastEventPosition) {
            int var3 = this.mLastEventPosition + this.mLastEventCount;
            this.mLastEventPosition = Math.min(var1, this.mLastEventPosition);
            this.mLastEventCount = Math.max(var3, var1 + var2) - this.mLastEventPosition;
         } else {
            this.dispatchLastEvent();
            this.mLastEventPosition = var1;
            this.mLastEventCount = var2;
            this.mLastEventType = 3;
         }
      }

      public void onInserted(int var1, int var2) {
         if(this.mLastEventType == 1 && var1 >= this.mLastEventPosition && var1 <= this.mLastEventPosition + this.mLastEventCount) {
            this.mLastEventCount += var2;
            this.mLastEventPosition = Math.min(var1, this.mLastEventPosition);
         } else {
            this.dispatchLastEvent();
            this.mLastEventPosition = var1;
            this.mLastEventCount = var2;
            this.mLastEventType = 1;
         }
      }

      public void onMoved(int var1, int var2) {
         this.dispatchLastEvent();
         this.mWrappedCallback.onMoved(var1, var2);
      }

      public void onRemoved(int var1, int var2) {
         if(this.mLastEventType == 2 && this.mLastEventPosition == var1) {
            this.mLastEventCount += var2;
         } else {
            this.dispatchLastEvent();
            this.mLastEventPosition = var1;
            this.mLastEventCount = var2;
            this.mLastEventType = 2;
         }
      }
   }

   public abstract static class Callback<T2> implements Comparator<T2> {
      public abstract boolean areContentsTheSame(T2 var1, T2 var2);

      public abstract boolean areItemsTheSame(T2 var1, T2 var2);

      public abstract int compare(T2 var1, T2 var2);

      public abstract void onChanged(int var1, int var2);

      public abstract void onInserted(int var1, int var2);

      public abstract void onMoved(int var1, int var2);

      public abstract void onRemoved(int var1, int var2);
   }
}
