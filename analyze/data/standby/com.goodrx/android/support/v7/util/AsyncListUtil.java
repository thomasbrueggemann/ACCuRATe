package android.support.v7.util;

import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v7.util.MessageThreadUtil;
import android.support.v7.util.ThreadUtil;
import android.support.v7.util.TileList;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public class AsyncListUtil<T> {
   private static final boolean DEBUG = false;
   private static final String TAG = "AsyncListUtil";
   private boolean mAllowScrollHints;
   private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
   final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
   final AsyncListUtil.DataCallback<T> mDataCallback;
   int mDisplayedGeneration = 0;
   private int mItemCount = 0;
   private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
   final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
   private final SparseIntArray mMissingPositions;
   final int[] mPrevRange = new int[2];
   int mRequestedGeneration;
   private int mScrollHint = 0;
   final Class<T> mTClass;
   final TileList<T> mTileList;
   final int mTileSize;
   final int[] mTmpRange = new int[2];
   final int[] mTmpRangeExtended = new int[2];
   final AsyncListUtil.ViewCallback mViewCallback;

   public AsyncListUtil(Class<T> var1, int var2, AsyncListUtil.DataCallback<T> var3, AsyncListUtil.ViewCallback var4) {
      this.mRequestedGeneration = this.mDisplayedGeneration;
      this.mMissingPositions = new SparseIntArray();
      this.mMainThreadCallback = new ThreadUtil.MainThreadCallback() {
         private boolean isRequestedGeneration(int var1) {
            return var1 == AsyncListUtil.this.mRequestedGeneration;
         }

         private void recycleAllTiles() {
            for(int var1 = 0; var1 < AsyncListUtil.this.mTileList.size(); ++var1) {
               AsyncListUtil.this.mBackgroundProxy.recycleTile(AsyncListUtil.this.mTileList.getAtIndex(var1));
            }

            AsyncListUtil.this.mTileList.clear();
         }

         public void addTile(int var1, TileList.Tile<T> var2) {
            if(!this.isRequestedGeneration(var1)) {
               AsyncListUtil.this.mBackgroundProxy.recycleTile(var2);
            } else {
               TileList.Tile var3 = AsyncListUtil.this.mTileList.addOrReplace(var2);
               if(var3 != null) {
                  Log.e("AsyncListUtil", "duplicate tile @" + var3.mStartPosition);
                  AsyncListUtil.this.mBackgroundProxy.recycleTile(var3);
               }

               int var4 = var2.mStartPosition + var2.mItemCount;
               int var5 = 0;

               while(true) {
                  while(var5 < AsyncListUtil.this.mMissingPositions.size()) {
                     int var6 = AsyncListUtil.this.mMissingPositions.keyAt(var5);
                     if(var2.mStartPosition <= var6 && var6 < var4) {
                        AsyncListUtil.this.mMissingPositions.removeAt(var5);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(var6);
                     } else {
                        ++var5;
                     }
                  }

                  return;
               }
            }
         }

         public void removeTile(int var1, int var2) {
            if(this.isRequestedGeneration(var1)) {
               TileList.Tile var3 = AsyncListUtil.this.mTileList.removeAtPos(var2);
               if(var3 == null) {
                  Log.e("AsyncListUtil", "tile not found @" + var2);
               } else {
                  AsyncListUtil.this.mBackgroundProxy.recycleTile(var3);
               }
            }
         }

         public void updateItemCount(int var1, int var2) {
            if(this.isRequestedGeneration(var1)) {
               AsyncListUtil.this.mItemCount = var2;
               AsyncListUtil.this.mViewCallback.onDataRefresh();
               AsyncListUtil.this.mDisplayedGeneration = AsyncListUtil.this.mRequestedGeneration;
               this.recycleAllTiles();
               AsyncListUtil.this.mAllowScrollHints = false;
               AsyncListUtil.this.updateRange();
            }
         }
      };
      this.mBackgroundCallback = new ThreadUtil.BackgroundCallback() {
         private int mFirstRequiredTileStart;
         private int mGeneration;
         private int mItemCount;
         private int mLastRequiredTileStart;
         final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
         private TileList.Tile<T> mRecycledRoot;

         private TileList.Tile<T> acquireTile() {
            if(this.mRecycledRoot != null) {
               TileList.Tile var1 = this.mRecycledRoot;
               this.mRecycledRoot = this.mRecycledRoot.mNext;
               return var1;
            } else {
               return new TileList.Tile(AsyncListUtil.this.mTClass, AsyncListUtil.this.mTileSize);
            }
         }

         private void addTile(TileList.Tile<T> var1) {
            this.mLoadedTiles.put(var1.mStartPosition, true);
            AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, var1);
         }

         private void flushTileCache(int var1) {
            int var2 = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();

            while(this.mLoadedTiles.size() >= var2) {
               int var3 = this.mLoadedTiles.keyAt(0);
               int var4 = this.mLoadedTiles.keyAt(-1 + this.mLoadedTiles.size());
               int var5 = this.mFirstRequiredTileStart - var3;
               int var6 = var4 - this.mLastRequiredTileStart;
               if(var5 > 0 && (var5 >= var6 || var1 == 2)) {
                  this.removeTile(var3);
               } else {
                  if(var6 <= 0 || var5 >= var6 && var1 != 1) {
                     break;
                  }

                  this.removeTile(var4);
               }
            }

         }

         private int getTileStart(int var1) {
            return var1 - var1 % AsyncListUtil.this.mTileSize;
         }

         private boolean isTileLoaded(int var1) {
            return this.mLoadedTiles.get(var1);
         }

         private void log(String var1, Object... var2) {
            Log.d("AsyncListUtil", "[BKGR] " + String.format(var1, var2));
         }

         private void removeTile(int var1) {
            this.mLoadedTiles.delete(var1);
            AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, var1);
         }

         private void requestTiles(int var1, int var2, int var3, boolean var4) {
            for(int var5 = var1; var5 <= var2; var5 += AsyncListUtil.this.mTileSize) {
               int var6;
               if(var4) {
                  var6 = var2 + var1 - var5;
               } else {
                  var6 = var5;
               }

               AsyncListUtil.this.mBackgroundProxy.loadTile(var6, var3);
            }

         }

         public void loadTile(int var1, int var2) {
            if(!this.isTileLoaded(var1)) {
               TileList.Tile var3 = this.acquireTile();
               var3.mStartPosition = var1;
               var3.mItemCount = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - var3.mStartPosition);
               AsyncListUtil.this.mDataCallback.fillData(var3.mItems, var3.mStartPosition, var3.mItemCount);
               this.flushTileCache(var2);
               this.addTile(var3);
            }
         }

         public void recycleTile(TileList.Tile<T> var1) {
            AsyncListUtil.this.mDataCallback.recycleData(var1.mItems, var1.mItemCount);
            var1.mNext = this.mRecycledRoot;
            this.mRecycledRoot = var1;
         }

         public void refresh(int var1) {
            this.mGeneration = var1;
            this.mLoadedTiles.clear();
            this.mItemCount = AsyncListUtil.this.mDataCallback.refreshData();
            AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
         }

         public void updateRange(int var1, int var2, int var3, int var4, int var5) {
            if(var1 <= var2) {
               int var6 = this.getTileStart(var1);
               int var7 = this.getTileStart(var2);
               this.mFirstRequiredTileStart = this.getTileStart(var3);
               this.mLastRequiredTileStart = this.getTileStart(var4);
               if(var5 == 1) {
                  this.requestTiles(this.mFirstRequiredTileStart, var7, var5, true);
                  this.requestTiles(var7 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, var5, false);
               } else {
                  this.requestTiles(var6, this.mLastRequiredTileStart, var5, false);
                  this.requestTiles(this.mFirstRequiredTileStart, var6 - AsyncListUtil.this.mTileSize, var5, true);
               }
            }
         }
      };
      this.mTClass = var1;
      this.mTileSize = var2;
      this.mDataCallback = var3;
      this.mViewCallback = var4;
      this.mTileList = new TileList(this.mTileSize);
      MessageThreadUtil var5 = new MessageThreadUtil();
      this.mMainThreadProxy = var5.getMainThreadProxy(this.mMainThreadCallback);
      this.mBackgroundProxy = var5.getBackgroundProxy(this.mBackgroundCallback);
      this.refresh();
   }

   private boolean isRefreshPending() {
      return this.mRequestedGeneration != this.mDisplayedGeneration;
   }

   private void log(String var1, Object... var2) {
      Log.d("AsyncListUtil", "[MAIN] " + String.format(var1, var2));
   }

   private void updateRange() {
      this.mViewCallback.getItemRangeInto(this.mTmpRange);
      if(this.mTmpRange[0] <= this.mTmpRange[1] && this.mTmpRange[0] >= 0 && this.mTmpRange[1] < this.mItemCount) {
         if(!this.mAllowScrollHints) {
            this.mScrollHint = 0;
         } else if(this.mTmpRange[0] <= this.mPrevRange[1] && this.mPrevRange[0] <= this.mTmpRange[1]) {
            if(this.mTmpRange[0] < this.mPrevRange[0]) {
               this.mScrollHint = 1;
            } else if(this.mTmpRange[0] > this.mPrevRange[0]) {
               this.mScrollHint = 2;
            }
         } else {
            this.mScrollHint = 0;
         }

         this.mPrevRange[0] = this.mTmpRange[0];
         this.mPrevRange[1] = this.mTmpRange[1];
         this.mViewCallback.extendRangeInto(this.mTmpRange, this.mTmpRangeExtended, this.mScrollHint);
         this.mTmpRangeExtended[0] = Math.min(this.mTmpRange[0], Math.max(this.mTmpRangeExtended[0], 0));
         this.mTmpRangeExtended[1] = Math.max(this.mTmpRange[1], Math.min(this.mTmpRangeExtended[1], -1 + this.mItemCount));
         this.mBackgroundProxy.updateRange(this.mTmpRange[0], this.mTmpRange[1], this.mTmpRangeExtended[0], this.mTmpRangeExtended[1], this.mScrollHint);
      }
   }

   public T getItem(int var1) {
      if(var1 >= 0 && var1 < this.mItemCount) {
         Object var2 = this.mTileList.getItemAt(var1);
         if(var2 == null && !this.isRefreshPending()) {
            this.mMissingPositions.put(var1, 0);
         }

         return var2;
      } else {
         throw new IndexOutOfBoundsException(var1 + " is not within 0 and " + this.mItemCount);
      }
   }

   public int getItemCount() {
      return this.mItemCount;
   }

   public void onRangeChanged() {
      if(!this.isRefreshPending()) {
         this.updateRange();
         this.mAllowScrollHints = true;
      }
   }

   public void refresh() {
      this.mMissingPositions.clear();
      ThreadUtil.BackgroundCallback var1 = this.mBackgroundProxy;
      int var2 = 1 + this.mRequestedGeneration;
      this.mRequestedGeneration = var2;
      var1.refresh(var2);
   }

   public abstract static class DataCallback<T> {
      @WorkerThread
      public abstract void fillData(T[] var1, int var2, int var3);

      @WorkerThread
      public int getMaxCachedTiles() {
         return 10;
      }

      @WorkerThread
      public void recycleData(T[] var1, int var2) {
      }

      @WorkerThread
      public abstract int refreshData();
   }

   public abstract static class ViewCallback {
      public static final int HINT_SCROLL_ASC = 2;
      public static final int HINT_SCROLL_DESC = 1;
      public static final int HINT_SCROLL_NONE;

      @UiThread
      public void extendRangeInto(int[] var1, int[] var2, int var3) {
         int var4 = 1 + (var1[1] - var1[0]);
         int var5 = var4 / 2;
         int var6 = var1[0];
         int var7;
         if(var3 == 1) {
            var7 = var4;
         } else {
            var7 = var5;
         }

         var2[0] = var6 - var7;
         int var8 = var1[1];
         if(var3 != 2) {
            var4 = var5;
         }

         var2[1] = var8 + var4;
      }

      @UiThread
      public abstract void getItemRangeInto(int[] var1);

      @UiThread
      public abstract void onDataRefresh();

      @UiThread
      public abstract void onItemLoaded(int var1);
   }
}
