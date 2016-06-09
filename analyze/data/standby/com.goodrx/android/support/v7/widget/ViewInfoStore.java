package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;

class ViewInfoStore {
   private static final boolean DEBUG;
   @VisibleForTesting
   final ArrayMap<RecyclerView.ViewHolder, ViewInfoStore.InfoRecord> mLayoutHolderMap = new ArrayMap();
   @VisibleForTesting
   final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();

   private RecyclerView.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder var1, int var2) {
      int var3 = this.mLayoutHolderMap.indexOfKey(var1);
      RecyclerView.ItemHolderInfo var4 = null;
      if(var3 >= 0) {
         ViewInfoStore.InfoRecord var5 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.valueAt(var3);
         var4 = null;
         if(var5 != null) {
            int var6 = var2 & var5.flags;
            var4 = null;
            if(var6 != 0) {
               var5.flags &= ~var2;
               if(var2 == 4) {
                  var4 = var5.preInfo;
               } else {
                  if(var2 != 8) {
                     throw new IllegalArgumentException("Must provide flag PRE or POST");
                  }

                  var4 = var5.postInfo;
               }

               if((12 & var5.flags) == 0) {
                  this.mLayoutHolderMap.removeAt(var3);
                  ViewInfoStore.InfoRecord.recycle(var5);
                  return var4;
               }
            }
         }
      }

      return var4;
   }

   void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder var1, RecyclerView.ItemHolderInfo var2) {
      ViewInfoStore.InfoRecord var3 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(var1);
      if(var3 == null) {
         var3 = ViewInfoStore.InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var3);
      }

      var3.flags |= 2;
      var3.preInfo = var2;
   }

   void addToDisappearedInLayout(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(var1);
      if(var2 == null) {
         var2 = ViewInfoStore.InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var2);
      }

      var2.flags |= 1;
   }

   void addToOldChangeHolders(long var1, RecyclerView.ViewHolder var3) {
      this.mOldChangedHolders.put(var1, var3);
   }

   void addToPostLayout(RecyclerView.ViewHolder var1, RecyclerView.ItemHolderInfo var2) {
      ViewInfoStore.InfoRecord var3 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(var1);
      if(var3 == null) {
         var3 = ViewInfoStore.InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var3);
      }

      var3.postInfo = var2;
      var3.flags |= 8;
   }

   void addToPreLayout(RecyclerView.ViewHolder var1, RecyclerView.ItemHolderInfo var2) {
      ViewInfoStore.InfoRecord var3 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(var1);
      if(var3 == null) {
         var3 = ViewInfoStore.InfoRecord.obtain();
         this.mLayoutHolderMap.put(var1, var3);
      }

      var3.preInfo = var2;
      var3.flags |= 4;
   }

   void clear() {
      this.mLayoutHolderMap.clear();
      this.mOldChangedHolders.clear();
   }

   RecyclerView.ViewHolder getFromOldChangeHolders(long var1) {
      return (RecyclerView.ViewHolder)this.mOldChangedHolders.get(var1);
   }

   boolean isDisappearing(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(var1);
      return var2 != null && (1 & var2.flags) != 0;
   }

   boolean isInPreLayout(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(var1);
      return var2 != null && (4 & var2.flags) != 0;
   }

   void onDetach() {
      ViewInfoStore.InfoRecord.drainCache();
   }

   public void onViewDetached(RecyclerView.ViewHolder var1) {
      this.removeFromDisappearedInLayout(var1);
   }

   @Nullable
   RecyclerView.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder var1) {
      return this.popFromLayoutStep(var1, 8);
   }

   @Nullable
   RecyclerView.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder var1) {
      return this.popFromLayoutStep(var1, 4);
   }

   void process(ViewInfoStore.ProcessCallback var1) {
      for(int var2 = -1 + this.mLayoutHolderMap.size(); var2 >= 0; --var2) {
         RecyclerView.ViewHolder var3 = (RecyclerView.ViewHolder)this.mLayoutHolderMap.keyAt(var2);
         ViewInfoStore.InfoRecord var4 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.removeAt(var2);
         if((3 & var4.flags) == 3) {
            var1.unused(var3);
         } else if((1 & var4.flags) != 0) {
            var1.processDisappeared(var3, var4.preInfo, var4.postInfo);
         } else if((14 & var4.flags) == 14) {
            var1.processAppeared(var3, var4.preInfo, var4.postInfo);
         } else if((12 & var4.flags) == 12) {
            var1.processPersistent(var3, var4.preInfo, var4.postInfo);
         } else if((4 & var4.flags) != 0) {
            var1.processDisappeared(var3, var4.preInfo, (RecyclerView.ItemHolderInfo)null);
         } else if((8 & var4.flags) != 0) {
            var1.processAppeared(var3, var4.preInfo, var4.postInfo);
         } else if((2 & var4.flags) != 0) {
            ;
         }

         ViewInfoStore.InfoRecord.recycle(var4);
      }

   }

   void removeFromDisappearedInLayout(RecyclerView.ViewHolder var1) {
      ViewInfoStore.InfoRecord var2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(var1);
      if(var2 != null) {
         var2.flags &= -2;
      }
   }

   void removeViewHolder(RecyclerView.ViewHolder var1) {
      for(int var2 = -1 + this.mOldChangedHolders.size(); var2 >= 0; --var2) {
         if(var1 == this.mOldChangedHolders.valueAt(var2)) {
            this.mOldChangedHolders.removeAt(var2);
            break;
         }
      }

      ViewInfoStore.InfoRecord var3 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.remove(var1);
      if(var3 != null) {
         ViewInfoStore.InfoRecord.recycle(var3);
      }

   }

   static class InfoRecord {
      static final int FLAG_APPEAR = 2;
      static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
      static final int FLAG_APPEAR_PRE_AND_POST = 14;
      static final int FLAG_DISAPPEARED = 1;
      static final int FLAG_POST = 8;
      static final int FLAG_PRE = 4;
      static final int FLAG_PRE_AND_POST = 12;
      static Pools.Pool<ViewInfoStore.InfoRecord> sPool = new Pools.SimplePool(20);
      int flags;
      @Nullable
      RecyclerView.ItemHolderInfo postInfo;
      @Nullable
      RecyclerView.ItemHolderInfo preInfo;

      static void drainCache() {
         while(sPool.acquire() != null) {
            ;
         }

      }

      static ViewInfoStore.InfoRecord obtain() {
         ViewInfoStore.InfoRecord var0 = (ViewInfoStore.InfoRecord)sPool.acquire();
         if(var0 == null) {
            var0 = new ViewInfoStore.InfoRecord();
         }

         return var0;
      }

      static void recycle(ViewInfoStore.InfoRecord var0) {
         var0.flags = 0;
         var0.preInfo = null;
         var0.postInfo = null;
         sPool.release(var0);
      }
   }

   interface ProcessCallback {
      void processAppeared(RecyclerView.ViewHolder var1, @Nullable RecyclerView.ItemHolderInfo var2, RecyclerView.ItemHolderInfo var3);

      void processDisappeared(RecyclerView.ViewHolder var1, RecyclerView.ItemHolderInfo var2, @Nullable RecyclerView.ItemHolderInfo var3);

      void processPersistent(RecyclerView.ViewHolder var1, @NonNull RecyclerView.ItemHolderInfo var2, @NonNull RecyclerView.ItemHolderInfo var3);

      void unused(RecyclerView.ViewHolder var1);
   }
}
