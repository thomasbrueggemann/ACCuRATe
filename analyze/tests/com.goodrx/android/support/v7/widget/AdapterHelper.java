package android.support.v7.widget;

import android.support.v4.util.Pools;
import android.support.v7.widget.OpReorderer;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AdapterHelper implements OpReorderer.Callback {
   private static final boolean DEBUG = false;
   static final int POSITION_TYPE_INVISIBLE = 0;
   static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
   private static final String TAG = "AHT";
   final AdapterHelper.Callback mCallback;
   final boolean mDisableRecycler;
   private int mExistingUpdateTypes;
   Runnable mOnItemProcessedCallback;
   final OpReorderer mOpReorderer;
   final ArrayList<AdapterHelper.UpdateOp> mPendingUpdates;
   final ArrayList<AdapterHelper.UpdateOp> mPostponedList;
   private Pools.Pool<AdapterHelper.UpdateOp> mUpdateOpPool;

   AdapterHelper(AdapterHelper.Callback var1) {
      this(var1, false);
   }

   AdapterHelper(AdapterHelper.Callback var1, boolean var2) {
      this.mUpdateOpPool = new Pools.SimplePool(30);
      this.mPendingUpdates = new ArrayList();
      this.mPostponedList = new ArrayList();
      this.mExistingUpdateTypes = 0;
      this.mCallback = var1;
      this.mDisableRecycler = var2;
      this.mOpReorderer = new OpReorderer(this);
   }

   private void applyAdd(AdapterHelper.UpdateOp var1) {
      this.postponeAndUpdateViewHolders(var1);
   }

   private void applyMove(AdapterHelper.UpdateOp var1) {
      this.postponeAndUpdateViewHolders(var1);
   }

   private void applyRemove(AdapterHelper.UpdateOp var1) {
      int var2 = var1.positionStart;
      int var3 = 0;
      int var4 = var1.positionStart + var1.itemCount;
      byte var5 = -1;

      for(int var6 = var1.positionStart; var6 < var4; ++var6) {
         boolean var7;
         if(this.mCallback.findViewHolder(var6) == null && !this.canFindInPreLayout(var6)) {
            var7 = false;
            if(var5 == 1) {
               this.postponeAndUpdateViewHolders(this.obtainUpdateOp(2, var2, var3, (Object)null));
               var7 = true;
            }

            var5 = 0;
         } else {
            var7 = false;
            if(var5 == 0) {
               this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(2, var2, var3, (Object)null));
               var7 = true;
            }

            var5 = 1;
         }

         if(var7) {
            var6 -= var3;
            var4 -= var3;
            var3 = 1;
         } else {
            ++var3;
         }
      }

      if(var3 != var1.itemCount) {
         this.recycleUpdateOp(var1);
         var1 = this.obtainUpdateOp(2, var2, var3, (Object)null);
      }

      if(var5 == 0) {
         this.dispatchAndUpdateViewHolders(var1);
      } else {
         this.postponeAndUpdateViewHolders(var1);
      }
   }

   private void applyUpdate(AdapterHelper.UpdateOp var1) {
      int var2 = var1.positionStart;
      int var3 = 0;
      int var4 = var1.positionStart + var1.itemCount;
      byte var5 = -1;

      for(int var6 = var1.positionStart; var6 < var4; ++var6) {
         if(this.mCallback.findViewHolder(var6) == null && !this.canFindInPreLayout(var6)) {
            if(var5 == 1) {
               this.postponeAndUpdateViewHolders(this.obtainUpdateOp(4, var2, var3, var1.payload));
               var3 = 0;
               var2 = var6;
            }

            var5 = 0;
         } else {
            if(var5 == 0) {
               this.dispatchAndUpdateViewHolders(this.obtainUpdateOp(4, var2, var3, var1.payload));
               var3 = 0;
               var2 = var6;
            }

            var5 = 1;
         }

         ++var3;
      }

      if(var3 != var1.itemCount) {
         Object var7 = var1.payload;
         this.recycleUpdateOp(var1);
         var1 = this.obtainUpdateOp(4, var2, var3, var7);
      }

      if(var5 == 0) {
         this.dispatchAndUpdateViewHolders(var1);
      } else {
         this.postponeAndUpdateViewHolders(var1);
      }
   }

   private boolean canFindInPreLayout(int var1) {
      int var2 = this.mPostponedList.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         AdapterHelper.UpdateOp var4 = (AdapterHelper.UpdateOp)this.mPostponedList.get(var3);
         if(var4.cmd == 8) {
            if(this.findPositionOffset(var4.itemCount, var3 + 1) == var1) {
               return true;
            }
         } else if(var4.cmd == 1) {
            int var5 = var4.positionStart + var4.itemCount;

            for(int var6 = var4.positionStart; var6 < var5; ++var6) {
               if(this.findPositionOffset(var6, var3 + 1) == var1) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private void dispatchAndUpdateViewHolders(AdapterHelper.UpdateOp var1) {
      if(var1.cmd != 1 && var1.cmd != 8) {
         int var2 = this.updatePositionWithPostponed(var1.positionStart, var1.cmd);
         int var3 = 1;
         int var4 = var1.positionStart;
         byte var5;
         switch(var1.cmd) {
         case 2:
            var5 = 0;
            break;
         case 3:
         default:
            throw new IllegalArgumentException("op should be remove or update." + var1);
         case 4:
            var5 = 1;
         }

         for(int var6 = 1; var6 < var1.itemCount; ++var6) {
            int var9 = this.updatePositionWithPostponed(var1.positionStart + var5 * var6, var1.cmd);
            int var10 = var1.cmd;
            boolean var11 = false;
            switch(var10) {
            case 2:
               if(var9 == var2) {
                  var11 = true;
               } else {
                  var11 = false;
               }
            case 3:
            default:
               break;
            case 4:
               if(var9 == var2 + 1) {
                  var11 = true;
               } else {
                  var11 = false;
               }
            }

            if(var11) {
               ++var3;
            } else {
               AdapterHelper.UpdateOp var12 = this.obtainUpdateOp(var1.cmd, var2, var3, var1.payload);
               this.dispatchFirstPassAndUpdateViewHolders(var12, var4);
               this.recycleUpdateOp(var12);
               if(var1.cmd == 4) {
                  var4 += var3;
               }

               var2 = var9;
               var3 = 1;
            }
         }

         Object var7 = var1.payload;
         this.recycleUpdateOp(var1);
         if(var3 > 0) {
            AdapterHelper.UpdateOp var8 = this.obtainUpdateOp(var1.cmd, var2, var3, var7);
            this.dispatchFirstPassAndUpdateViewHolders(var8, var4);
            this.recycleUpdateOp(var8);
         }

      } else {
         throw new IllegalArgumentException("should not dispatch add or move for pre layout");
      }
   }

   private void postponeAndUpdateViewHolders(AdapterHelper.UpdateOp var1) {
      this.mPostponedList.add(var1);
      switch(var1.cmd) {
      case 1:
         this.mCallback.offsetPositionsForAdd(var1.positionStart, var1.itemCount);
         return;
      case 2:
         this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(var1.positionStart, var1.itemCount);
         return;
      case 3:
      case 5:
      case 6:
      case 7:
      default:
         throw new IllegalArgumentException("Unknown update op type for " + var1);
      case 4:
         this.mCallback.markViewHoldersUpdated(var1.positionStart, var1.itemCount, var1.payload);
         return;
      case 8:
         this.mCallback.offsetPositionsForMove(var1.positionStart, var1.itemCount);
      }
   }

   private int updatePositionWithPostponed(int var1, int var2) {
      for(int var3 = -1 + this.mPostponedList.size(); var3 >= 0; --var3) {
         AdapterHelper.UpdateOp var8 = (AdapterHelper.UpdateOp)this.mPostponedList.get(var3);
         if(var8.cmd == 8) {
            int var9;
            int var10;
            if(var8.positionStart < var8.itemCount) {
               var9 = var8.positionStart;
               var10 = var8.itemCount;
            } else {
               var9 = var8.itemCount;
               var10 = var8.positionStart;
            }

            if(var1 >= var9 && var1 <= var10) {
               if(var9 == var8.positionStart) {
                  if(var2 == 1) {
                     ++var8.itemCount;
                  } else if(var2 == 2) {
                     var8.itemCount += -1;
                  }

                  ++var1;
               } else {
                  if(var2 == 1) {
                     ++var8.positionStart;
                  } else if(var2 == 2) {
                     var8.positionStart += -1;
                  }

                  --var1;
               }
            } else if(var1 < var8.positionStart) {
               if(var2 == 1) {
                  ++var8.positionStart;
                  ++var8.itemCount;
               } else if(var2 == 2) {
                  var8.positionStart += -1;
                  var8.itemCount += -1;
               }
            }
         } else if(var8.positionStart <= var1) {
            if(var8.cmd == 1) {
               var1 -= var8.itemCount;
            } else if(var8.cmd == 2) {
               var1 += var8.itemCount;
            }
         } else if(var2 == 1) {
            ++var8.positionStart;
         } else if(var2 == 2) {
            var8.positionStart += -1;
         }
      }

      for(int var4 = -1 + this.mPostponedList.size(); var4 >= 0; --var4) {
         AdapterHelper.UpdateOp var5 = (AdapterHelper.UpdateOp)this.mPostponedList.get(var4);
         if(var5.cmd == 8) {
            if(var5.itemCount == var5.positionStart || var5.itemCount < 0) {
               this.mPostponedList.remove(var4);
               this.recycleUpdateOp(var5);
            }
         } else if(var5.itemCount <= 0) {
            this.mPostponedList.remove(var4);
            this.recycleUpdateOp(var5);
         }
      }

      return var1;
   }

   AdapterHelper addUpdateOp(AdapterHelper.UpdateOp... var1) {
      Collections.addAll(this.mPendingUpdates, var1);
      return this;
   }

   public int applyPendingUpdatesToPosition(int var1) {
      int var2 = this.mPendingUpdates.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         AdapterHelper.UpdateOp var4 = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(var3);
         switch(var4.cmd) {
         case 1:
            if(var4.positionStart <= var1) {
               var1 += var4.itemCount;
            }
            break;
         case 2:
            if(var4.positionStart <= var1) {
               if(var4.positionStart + var4.itemCount > var1) {
                  var1 = -1;
                  return var1;
               }

               var1 -= var4.itemCount;
            }
            break;
         case 8:
            if(var4.positionStart == var1) {
               var1 = var4.itemCount;
            } else {
               if(var4.positionStart < var1) {
                  --var1;
               }

               if(var4.itemCount <= var1) {
                  ++var1;
               }
            }
         }
      }

      return var1;
   }

   void consumePostponedUpdates() {
      int var1 = this.mPostponedList.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         this.mCallback.onDispatchSecondPass((AdapterHelper.UpdateOp)this.mPostponedList.get(var2));
      }

      this.recycleUpdateOpsAndClearList(this.mPostponedList);
      this.mExistingUpdateTypes = 0;
   }

   void consumeUpdatesInOnePass() {
      this.consumePostponedUpdates();
      int var1 = this.mPendingUpdates.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         AdapterHelper.UpdateOp var3 = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(var2);
         switch(var3.cmd) {
         case 1:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.offsetPositionsForAdd(var3.positionStart, var3.itemCount);
            break;
         case 2:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.offsetPositionsForRemovingInvisible(var3.positionStart, var3.itemCount);
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.markViewHoldersUpdated(var3.positionStart, var3.itemCount, var3.payload);
            break;
         case 8:
            this.mCallback.onDispatchSecondPass(var3);
            this.mCallback.offsetPositionsForMove(var3.positionStart, var3.itemCount);
         }

         if(this.mOnItemProcessedCallback != null) {
            this.mOnItemProcessedCallback.run();
         }
      }

      this.recycleUpdateOpsAndClearList(this.mPendingUpdates);
      this.mExistingUpdateTypes = 0;
   }

   void dispatchFirstPassAndUpdateViewHolders(AdapterHelper.UpdateOp var1, int var2) {
      this.mCallback.onDispatchFirstPass(var1);
      switch(var1.cmd) {
      case 2:
         this.mCallback.offsetPositionsForRemovingInvisible(var2, var1.itemCount);
         return;
      case 3:
      default:
         throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
      case 4:
         this.mCallback.markViewHoldersUpdated(var2, var1.itemCount, var1.payload);
      }
   }

   int findPositionOffset(int var1) {
      return this.findPositionOffset(var1, 0);
   }

   int findPositionOffset(int var1, int var2) {
      int var3 = this.mPostponedList.size();

      for(int var4 = var2; var4 < var3; ++var4) {
         AdapterHelper.UpdateOp var5 = (AdapterHelper.UpdateOp)this.mPostponedList.get(var4);
         if(var5.cmd == 8) {
            if(var5.positionStart == var1) {
               var1 = var5.itemCount;
            } else {
               if(var5.positionStart < var1) {
                  --var1;
               }

               if(var5.itemCount <= var1) {
                  ++var1;
               }
            }
         } else if(var5.positionStart <= var1) {
            if(var5.cmd == 2) {
               if(var1 < var5.positionStart + var5.itemCount) {
                  var1 = -1;
                  break;
               }

               var1 -= var5.itemCount;
            } else if(var5.cmd == 1) {
               var1 += var5.itemCount;
            }
         }
      }

      return var1;
   }

   boolean hasAnyUpdateTypes(int var1) {
      return (var1 & this.mExistingUpdateTypes) != 0;
   }

   boolean hasPendingUpdates() {
      return this.mPendingUpdates.size() > 0;
   }

   boolean hasUpdates() {
      return !this.mPostponedList.isEmpty() && !this.mPendingUpdates.isEmpty();
   }

   public AdapterHelper.UpdateOp obtainUpdateOp(int var1, int var2, int var3, Object var4) {
      AdapterHelper.UpdateOp var5 = (AdapterHelper.UpdateOp)this.mUpdateOpPool.acquire();
      if(var5 == null) {
         return new AdapterHelper.UpdateOp(var1, var2, var3, var4);
      } else {
         var5.cmd = var1;
         var5.positionStart = var2;
         var5.itemCount = var3;
         var5.payload = var4;
         return var5;
      }
   }

   boolean onItemRangeChanged(int var1, int var2, Object var3) {
      this.mPendingUpdates.add(this.obtainUpdateOp(4, var1, var2, var3));
      this.mExistingUpdateTypes |= 4;
      return this.mPendingUpdates.size() == 1;
   }

   boolean onItemRangeInserted(int var1, int var2) {
      this.mPendingUpdates.add(this.obtainUpdateOp(1, var1, var2, (Object)null));
      this.mExistingUpdateTypes |= 1;
      return this.mPendingUpdates.size() == 1;
   }

   boolean onItemRangeMoved(int var1, int var2, int var3) {
      byte var4 = 1;
      if(var1 == var2) {
         return false;
      } else if(var3 != var4) {
         throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
      } else {
         this.mPendingUpdates.add(this.obtainUpdateOp(8, var1, var2, (Object)null));
         this.mExistingUpdateTypes |= 8;
         if(this.mPendingUpdates.size() != var4) {
            var4 = 0;
         }

         return (boolean)var4;
      }
   }

   boolean onItemRangeRemoved(int var1, int var2) {
      this.mPendingUpdates.add(this.obtainUpdateOp(2, var1, var2, (Object)null));
      this.mExistingUpdateTypes |= 2;
      return this.mPendingUpdates.size() == 1;
   }

   void preProcess() {
      this.mOpReorderer.reorderOps(this.mPendingUpdates);
      int var1 = this.mPendingUpdates.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         AdapterHelper.UpdateOp var3 = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(var2);
         switch(var3.cmd) {
         case 1:
            this.applyAdd(var3);
            break;
         case 2:
            this.applyRemove(var3);
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            break;
         case 4:
            this.applyUpdate(var3);
            break;
         case 8:
            this.applyMove(var3);
         }

         if(this.mOnItemProcessedCallback != null) {
            this.mOnItemProcessedCallback.run();
         }
      }

      this.mPendingUpdates.clear();
   }

   public void recycleUpdateOp(AdapterHelper.UpdateOp var1) {
      if(!this.mDisableRecycler) {
         var1.payload = null;
         this.mUpdateOpPool.release(var1);
      }

   }

   void recycleUpdateOpsAndClearList(List<AdapterHelper.UpdateOp> var1) {
      int var2 = var1.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         this.recycleUpdateOp((AdapterHelper.UpdateOp)var1.get(var3));
      }

      var1.clear();
   }

   void reset() {
      this.recycleUpdateOpsAndClearList(this.mPendingUpdates);
      this.recycleUpdateOpsAndClearList(this.mPostponedList);
      this.mExistingUpdateTypes = 0;
   }

   interface Callback {
      RecyclerView.ViewHolder findViewHolder(int var1);

      void markViewHoldersUpdated(int var1, int var2, Object var3);

      void offsetPositionsForAdd(int var1, int var2);

      void offsetPositionsForMove(int var1, int var2);

      void offsetPositionsForRemovingInvisible(int var1, int var2);

      void offsetPositionsForRemovingLaidOutOrNewView(int var1, int var2);

      void onDispatchFirstPass(AdapterHelper.UpdateOp var1);

      void onDispatchSecondPass(AdapterHelper.UpdateOp var1);
   }

   static class UpdateOp {
      static final int ADD = 1;
      static final int MOVE = 8;
      static final int POOL_SIZE = 30;
      static final int REMOVE = 2;
      static final int UPDATE = 4;
      int cmd;
      int itemCount;
      Object payload;
      int positionStart;

      UpdateOp(int var1, int var2, int var3, Object var4) {
         this.cmd = var1;
         this.positionStart = var2;
         this.itemCount = var3;
         this.payload = var4;
      }

      String cmdToString() {
         switch(this.cmd) {
         case 1:
            return "add";
         case 2:
            return "rm";
         case 3:
         case 5:
         case 6:
         case 7:
         default:
            return "??";
         case 4:
            return "up";
         case 8:
            return "mv";
         }
      }

      public boolean equals(Object var1) {
         if(this != var1) {
            if(var1 == null || this.getClass() != var1.getClass()) {
               return false;
            }

            AdapterHelper.UpdateOp var2 = (AdapterHelper.UpdateOp)var1;
            if(this.cmd != var2.cmd) {
               return false;
            }

            if(this.cmd != 8 || Math.abs(this.itemCount - this.positionStart) != 1 || this.itemCount != var2.positionStart || this.positionStart != var2.itemCount) {
               if(this.itemCount != var2.itemCount) {
                  return false;
               }

               if(this.positionStart != var2.positionStart) {
                  return false;
               }

               if(this.payload != null) {
                  if(!this.payload.equals(var2.payload)) {
                     return false;
                  }
               } else if(var2.payload != null) {
                  return false;
               }
            }
         }

         return true;
      }

      public int hashCode() {
         return 31 * (31 * this.cmd + this.positionStart) + this.itemCount;
      }

      public String toString() {
         return Integer.toHexString(System.identityHashCode(this)) + "[" + this.cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
      }
   }
}
