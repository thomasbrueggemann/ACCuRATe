package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ScrollbarHelper;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler {
   private static final boolean DEBUG = false;
   public static final int HORIZONTAL = 0;
   public static final int INVALID_OFFSET = Integer.MIN_VALUE;
   private static final float MAX_SCROLL_FACTOR = 0.33333334F;
   private static final String TAG = "LinearLayoutManager";
   public static final int VERTICAL = 1;
   final LinearLayoutManager.AnchorInfo mAnchorInfo;
   private boolean mLastStackFromEnd;
   private LinearLayoutManager.LayoutState mLayoutState;
   int mOrientation;
   OrientationHelper mOrientationHelper;
   LinearLayoutManager.SavedState mPendingSavedState;
   int mPendingScrollPosition;
   int mPendingScrollPositionOffset;
   private boolean mRecycleChildrenOnDetach;
   private boolean mReverseLayout;
   boolean mShouldReverseLayout;
   private boolean mSmoothScrollbarEnabled;
   private boolean mStackFromEnd;

   public LinearLayoutManager(Context var1) {
      this(var1, 1, false);
   }

   public LinearLayoutManager(Context var1, int var2, boolean var3) {
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mStackFromEnd = false;
      this.mSmoothScrollbarEnabled = true;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mPendingSavedState = null;
      this.mAnchorInfo = new LinearLayoutManager.AnchorInfo();
      this.setOrientation(var2);
      this.setReverseLayout(var3);
      this.setAutoMeasureEnabled(true);
   }

   public LinearLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mStackFromEnd = false;
      this.mSmoothScrollbarEnabled = true;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mPendingSavedState = null;
      this.mAnchorInfo = new LinearLayoutManager.AnchorInfo();
      RecyclerView.Properties var5 = getProperties(var1, var2, var3, var4);
      this.setOrientation(var5.orientation);
      this.setReverseLayout(var5.reverseLayout);
      this.setStackFromEnd(var5.stackFromEnd);
      this.setAutoMeasureEnabled(true);
   }

   private int computeScrollExtent(RecyclerView.State var1) {
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureLayoutState();
         OrientationHelper var2 = this.mOrientationHelper;
         boolean var3;
         if(!this.mSmoothScrollbarEnabled) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var4 = this.findFirstVisibleChildClosestToStart(var3, true);
         boolean var5 = this.mSmoothScrollbarEnabled;
         boolean var6 = false;
         if(!var5) {
            var6 = true;
         }

         return ScrollbarHelper.computeScrollExtent(var1, var2, var4, this.findFirstVisibleChildClosestToEnd(var6, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private int computeScrollOffset(RecyclerView.State var1) {
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureLayoutState();
         OrientationHelper var2 = this.mOrientationHelper;
         boolean var3;
         if(!this.mSmoothScrollbarEnabled) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var4 = this.findFirstVisibleChildClosestToStart(var3, true);
         boolean var5 = this.mSmoothScrollbarEnabled;
         boolean var6 = false;
         if(!var5) {
            var6 = true;
         }

         return ScrollbarHelper.computeScrollOffset(var1, var2, var4, this.findFirstVisibleChildClosestToEnd(var6, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
      }
   }

   private int computeScrollRange(RecyclerView.State var1) {
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureLayoutState();
         OrientationHelper var2 = this.mOrientationHelper;
         boolean var3;
         if(!this.mSmoothScrollbarEnabled) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var4 = this.findFirstVisibleChildClosestToStart(var3, true);
         boolean var5 = this.mSmoothScrollbarEnabled;
         boolean var6 = false;
         if(!var5) {
            var6 = true;
         }

         return ScrollbarHelper.computeScrollRange(var1, var2, var4, this.findFirstVisibleChildClosestToEnd(var6, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private View findFirstReferenceChild(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.findReferenceChild(var1, var2, 0, this.getChildCount(), var2.getItemCount());
   }

   private View findFirstVisibleChildClosestToEnd(boolean var1, boolean var2) {
      return this.mShouldReverseLayout?this.findOneVisibleChild(0, this.getChildCount(), var1, var2):this.findOneVisibleChild(-1 + this.getChildCount(), -1, var1, var2);
   }

   private View findFirstVisibleChildClosestToStart(boolean var1, boolean var2) {
      return this.mShouldReverseLayout?this.findOneVisibleChild(-1 + this.getChildCount(), -1, var1, var2):this.findOneVisibleChild(0, this.getChildCount(), var1, var2);
   }

   private View findLastReferenceChild(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.findReferenceChild(var1, var2, -1 + this.getChildCount(), -1, var2.getItemCount());
   }

   private View findReferenceChildClosestToEnd(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.mShouldReverseLayout?this.findFirstReferenceChild(var1, var2):this.findLastReferenceChild(var1, var2);
   }

   private View findReferenceChildClosestToStart(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.mShouldReverseLayout?this.findLastReferenceChild(var1, var2):this.findFirstReferenceChild(var1, var2);
   }

   private int fixLayoutEndGap(int var1, RecyclerView.Recycler var2, RecyclerView.State var3, boolean var4) {
      int var5 = this.mOrientationHelper.getEndAfterPadding() - var1;
      if(var5 > 0) {
         int var6 = -this.scrollBy(-var5, var2, var3);
         int var7 = var1 + var6;
         if(var4) {
            int var8 = this.mOrientationHelper.getEndAfterPadding() - var7;
            if(var8 > 0) {
               this.mOrientationHelper.offsetChildren(var8);
               return var8 + var6;
            }
         }

         return var6;
      } else {
         return 0;
      }
   }

   private int fixLayoutStartGap(int var1, RecyclerView.Recycler var2, RecyclerView.State var3, boolean var4) {
      int var5 = var1 - this.mOrientationHelper.getStartAfterPadding();
      if(var5 > 0) {
         int var6 = -this.scrollBy(var5, var2, var3);
         int var7 = var1 + var6;
         if(var4) {
            int var8 = var7 - this.mOrientationHelper.getStartAfterPadding();
            if(var8 > 0) {
               this.mOrientationHelper.offsetChildren(-var8);
               return var6 - var8;
            }
         }

         return var6;
      } else {
         return 0;
      }
   }

   private View getChildClosestToEnd() {
      int var1;
      if(this.mShouldReverseLayout) {
         var1 = 0;
      } else {
         var1 = -1 + this.getChildCount();
      }

      return this.getChildAt(var1);
   }

   private View getChildClosestToStart() {
      int var1;
      if(this.mShouldReverseLayout) {
         var1 = -1 + this.getChildCount();
      } else {
         var1 = 0;
      }

      return this.getChildAt(var1);
   }

   private void layoutForPredictiveAnimations(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4) {
      if(var2.willRunPredictiveAnimations() && this.getChildCount() != 0 && !var2.isPreLayout() && this.supportsPredictiveItemAnimations()) {
         int var5 = 0;
         int var6 = 0;
         List var7 = var1.getScrapList();
         int var8 = var7.size();
         int var9 = this.getPosition(this.getChildAt(0));

         for(int var10 = 0; var10 < var8; ++var10) {
            RecyclerView.ViewHolder var13 = (RecyclerView.ViewHolder)var7.get(var10);
            if(!var13.isRemoved()) {
               boolean var14;
               if(var13.getLayoutPosition() < var9) {
                  var14 = true;
               } else {
                  var14 = false;
               }

               byte var15;
               if(var14 != this.mShouldReverseLayout) {
                  var15 = -1;
               } else {
                  var15 = 1;
               }

               if(var15 == -1) {
                  var5 += this.mOrientationHelper.getDecoratedMeasurement(var13.itemView);
               } else {
                  var6 += this.mOrientationHelper.getDecoratedMeasurement(var13.itemView);
               }
            }
         }

         this.mLayoutState.mScrapList = var7;
         if(var5 > 0) {
            this.updateLayoutStateToFillStart(this.getPosition(this.getChildClosestToStart()), var3);
            this.mLayoutState.mExtra = var5;
            this.mLayoutState.mAvailable = 0;
            this.mLayoutState.assignPositionFromScrapList();
            this.fill(var1, this.mLayoutState, var2, false);
         }

         if(var6 > 0) {
            this.updateLayoutStateToFillEnd(this.getPosition(this.getChildClosestToEnd()), var4);
            this.mLayoutState.mExtra = var6;
            this.mLayoutState.mAvailable = 0;
            this.mLayoutState.assignPositionFromScrapList();
            this.fill(var1, this.mLayoutState, var2, false);
         }

         this.mLayoutState.mScrapList = null;
      }
   }

   private void logChildren() {
      Log.d("LinearLayoutManager", "internal representation of views on the screen");

      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         View var4 = this.getChildAt(var2);
         Log.d("LinearLayoutManager", "item " + this.getPosition(var4) + ", coord:" + this.mOrientationHelper.getDecoratedStart(var4));
      }

      Log.d("LinearLayoutManager", "==============");
   }

   private void recycleByLayoutState(RecyclerView.Recycler var1, LinearLayoutManager.LayoutState var2) {
      if(var2.mRecycle && !var2.mInfinite) {
         if(var2.mLayoutDirection == -1) {
            this.recycleViewsFromEnd(var1, var2.mScrollingOffset);
         } else {
            this.recycleViewsFromStart(var1, var2.mScrollingOffset);
         }
      }
   }

   private void recycleChildren(RecyclerView.Recycler var1, int var2, int var3) {
      if(var2 != var3) {
         if(var3 > var2) {
            for(int var5 = var3 - 1; var5 >= var2; --var5) {
               this.removeAndRecycleViewAt(var5, var1);
            }
         } else {
            for(int var4 = var2; var4 > var3; --var4) {
               this.removeAndRecycleViewAt(var4, var1);
            }
         }
      }

   }

   private void recycleViewsFromEnd(RecyclerView.Recycler var1, int var2) {
      int var3 = this.getChildCount();
      if(var2 >= 0) {
         int var4 = this.mOrientationHelper.getEnd() - var2;
         if(this.mShouldReverseLayout) {
            for(int var7 = 0; var7 < var3; ++var7) {
               View var8 = this.getChildAt(var7);
               if(this.mOrientationHelper.getDecoratedStart(var8) < var4) {
                  this.recycleChildren(var1, 0, var7);
                  return;
               }
            }
         } else {
            for(int var5 = var3 - 1; var5 >= 0; --var5) {
               View var6 = this.getChildAt(var5);
               if(this.mOrientationHelper.getDecoratedStart(var6) < var4) {
                  this.recycleChildren(var1, var3 - 1, var5);
                  return;
               }
            }
         }
      }

   }

   private void recycleViewsFromStart(RecyclerView.Recycler var1, int var2) {
      if(var2 >= 0) {
         int var3 = this.getChildCount();
         if(this.mShouldReverseLayout) {
            for(int var6 = var3 - 1; var6 >= 0; --var6) {
               View var7 = this.getChildAt(var6);
               if(this.mOrientationHelper.getDecoratedEnd(var7) > var2) {
                  this.recycleChildren(var1, var3 - 1, var6);
                  return;
               }
            }
         } else {
            for(int var4 = 0; var4 < var3; ++var4) {
               View var5 = this.getChildAt(var4);
               if(this.mOrientationHelper.getDecoratedEnd(var5) > var2) {
                  this.recycleChildren(var1, 0, var4);
                  return;
               }
            }
         }
      }

   }

   private void resolveShouldLayoutReverse() {
      byte var1 = 1;
      if(this.mOrientation != var1 && this.isLayoutRTL()) {
         if(this.mReverseLayout) {
            var1 = 0;
         }

         this.mShouldReverseLayout = (boolean)var1;
      } else {
         this.mShouldReverseLayout = this.mReverseLayout;
      }
   }

   private boolean updateAnchorFromChildren(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3) {
      if(this.getChildCount() != 0) {
         View var4 = this.getFocusedChild();
         if(var4 != null && var3.isViewValidAsAnchor(var4, var2)) {
            var3.assignFromViewAndKeepVisibleRect(var4);
            return true;
         }

         if(this.mLastStackFromEnd == this.mStackFromEnd) {
            View var5;
            if(var3.mLayoutFromEnd) {
               var5 = this.findReferenceChildClosestToEnd(var1, var2);
            } else {
               var5 = this.findReferenceChildClosestToStart(var1, var2);
            }

            if(var5 != null) {
               var3.assignFromView(var5);
               if(!var2.isPreLayout() && this.supportsPredictiveItemAnimations()) {
                  boolean var6;
                  if(this.mOrientationHelper.getDecoratedStart(var5) < this.mOrientationHelper.getEndAfterPadding() && this.mOrientationHelper.getDecoratedEnd(var5) >= this.mOrientationHelper.getStartAfterPadding()) {
                     var6 = false;
                  } else {
                     var6 = true;
                  }

                  if(var6) {
                     int var7;
                     if(var3.mLayoutFromEnd) {
                        var7 = this.mOrientationHelper.getEndAfterPadding();
                     } else {
                        var7 = this.mOrientationHelper.getStartAfterPadding();
                     }

                     var3.mCoordinate = var7;
                  }
               }

               return true;
            }
         }
      }

      return false;
   }

   private boolean updateAnchorFromPendingData(RecyclerView.State var1, LinearLayoutManager.AnchorInfo var2) {
      if(!var1.isPreLayout() && this.mPendingScrollPosition != -1) {
         if(this.mPendingScrollPosition >= 0 && this.mPendingScrollPosition < var1.getItemCount()) {
            var2.mPosition = this.mPendingScrollPosition;
            if(this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
               var2.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
               if(var2.mLayoutFromEnd) {
                  var2.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                  return true;
               } else {
                  var2.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                  return true;
               }
            } else if(this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
               View var3 = this.findViewByPosition(this.mPendingScrollPosition);
               if(var3 != null) {
                  if(this.mOrientationHelper.getDecoratedMeasurement(var3) > this.mOrientationHelper.getTotalSpace()) {
                     var2.assignCoordinateFromPadding();
                     return true;
                  } else if(this.mOrientationHelper.getDecoratedStart(var3) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                     var2.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                     var2.mLayoutFromEnd = false;
                     return true;
                  } else if(this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var3) < 0) {
                     var2.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                     var2.mLayoutFromEnd = true;
                     return true;
                  } else {
                     int var8;
                     if(var2.mLayoutFromEnd) {
                        var8 = this.mOrientationHelper.getDecoratedEnd(var3) + this.mOrientationHelper.getTotalSpaceChange();
                     } else {
                        var8 = this.mOrientationHelper.getDecoratedStart(var3);
                     }

                     var2.mCoordinate = var8;
                     return true;
                  }
               } else {
                  if(this.getChildCount() > 0) {
                     int var4 = this.getPosition(this.getChildAt(0));
                     boolean var5;
                     if(this.mPendingScrollPosition < var4) {
                        var5 = true;
                     } else {
                        var5 = false;
                     }

                     boolean var6 = this.mShouldReverseLayout;
                     boolean var7 = false;
                     if(var5 == var6) {
                        var7 = true;
                     }

                     var2.mLayoutFromEnd = var7;
                  }

                  var2.assignCoordinateFromPadding();
                  return true;
               }
            } else {
               var2.mLayoutFromEnd = this.mShouldReverseLayout;
               if(this.mShouldReverseLayout) {
                  var2.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                  return true;
               } else {
                  var2.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                  return true;
               }
            }
         } else {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            return false;
         }
      } else {
         return false;
      }
   }

   private void updateAnchorInfoForLayout(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3) {
      if(!this.updateAnchorFromPendingData(var2, var3) && !this.updateAnchorFromChildren(var1, var2, var3)) {
         var3.assignCoordinateFromPadding();
         int var4;
         if(this.mStackFromEnd) {
            var4 = -1 + var2.getItemCount();
         } else {
            var4 = 0;
         }

         var3.mPosition = var4;
      }
   }

   private void updateLayoutState(int var1, int var2, boolean var3, RecyclerView.State var4) {
      byte var5 = 1;
      LinearLayoutManager.LayoutState var6 = this.mLayoutState;
      byte var7;
      if(this.mOrientationHelper.getMode() == 0) {
         var7 = var5;
      } else {
         var7 = 0;
      }

      var6.mInfinite = (boolean)var7;
      this.mLayoutState.mExtra = this.getExtraLayoutSpace(var4);
      this.mLayoutState.mLayoutDirection = var1;
      int var11;
      if(var1 == var5) {
         LinearLayoutManager.LayoutState var13 = this.mLayoutState;
         var13.mExtra += this.mOrientationHelper.getEndPadding();
         View var14 = this.getChildClosestToEnd();
         LinearLayoutManager.LayoutState var15 = this.mLayoutState;
         if(this.mShouldReverseLayout) {
            var5 = -1;
         }

         var15.mItemDirection = var5;
         this.mLayoutState.mCurrentPosition = this.getPosition(var14) + this.mLayoutState.mItemDirection;
         this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(var14);
         var11 = this.mOrientationHelper.getDecoratedEnd(var14) - this.mOrientationHelper.getEndAfterPadding();
      } else {
         View var8 = this.getChildClosestToStart();
         LinearLayoutManager.LayoutState var9 = this.mLayoutState;
         var9.mExtra += this.mOrientationHelper.getStartAfterPadding();
         LinearLayoutManager.LayoutState var10 = this.mLayoutState;
         if(!this.mShouldReverseLayout) {
            var5 = -1;
         }

         var10.mItemDirection = var5;
         this.mLayoutState.mCurrentPosition = this.getPosition(var8) + this.mLayoutState.mItemDirection;
         this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(var8);
         var11 = -this.mOrientationHelper.getDecoratedStart(var8) + this.mOrientationHelper.getStartAfterPadding();
      }

      this.mLayoutState.mAvailable = var2;
      if(var3) {
         LinearLayoutManager.LayoutState var12 = this.mLayoutState;
         var12.mAvailable -= var11;
      }

      this.mLayoutState.mScrollingOffset = var11;
   }

   private void updateLayoutStateToFillEnd(int var1, int var2) {
      this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - var2;
      LinearLayoutManager.LayoutState var3 = this.mLayoutState;
      byte var4;
      if(this.mShouldReverseLayout) {
         var4 = -1;
      } else {
         var4 = 1;
      }

      var3.mItemDirection = var4;
      this.mLayoutState.mCurrentPosition = var1;
      this.mLayoutState.mLayoutDirection = 1;
      this.mLayoutState.mOffset = var2;
      this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
   }

   private void updateLayoutStateToFillEnd(LinearLayoutManager.AnchorInfo var1) {
      this.updateLayoutStateToFillEnd(var1.mPosition, var1.mCoordinate);
   }

   private void updateLayoutStateToFillStart(int var1, int var2) {
      this.mLayoutState.mAvailable = var2 - this.mOrientationHelper.getStartAfterPadding();
      this.mLayoutState.mCurrentPosition = var1;
      LinearLayoutManager.LayoutState var3 = this.mLayoutState;
      byte var4;
      if(this.mShouldReverseLayout) {
         var4 = 1;
      } else {
         var4 = -1;
      }

      var3.mItemDirection = var4;
      this.mLayoutState.mLayoutDirection = -1;
      this.mLayoutState.mOffset = var2;
      this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
   }

   private void updateLayoutStateToFillStart(LinearLayoutManager.AnchorInfo var1) {
      this.updateLayoutStateToFillStart(var1.mPosition, var1.mCoordinate);
   }

   public void assertNotInLayoutOrScroll(String var1) {
      if(this.mPendingSavedState == null) {
         super.assertNotInLayoutOrScroll(var1);
      }

   }

   public boolean canScrollHorizontally() {
      return this.mOrientation == 0;
   }

   public boolean canScrollVertically() {
      return this.mOrientation == 1;
   }

   public int computeHorizontalScrollExtent(RecyclerView.State var1) {
      return this.computeScrollExtent(var1);
   }

   public int computeHorizontalScrollOffset(RecyclerView.State var1) {
      return this.computeScrollOffset(var1);
   }

   public int computeHorizontalScrollRange(RecyclerView.State var1) {
      return this.computeScrollRange(var1);
   }

   public PointF computeScrollVectorForPosition(int var1) {
      if(this.getChildCount() == 0) {
         return null;
      } else {
         int var2 = this.getPosition(this.getChildAt(0));
         boolean var3 = false;
         if(var1 < var2) {
            var3 = true;
         }

         byte var4;
         if(var3 != this.mShouldReverseLayout) {
            var4 = -1;
         } else {
            var4 = 1;
         }

         return this.mOrientation == 0?new PointF((float)var4, 0.0F):new PointF(0.0F, (float)var4);
      }
   }

   public int computeVerticalScrollExtent(RecyclerView.State var1) {
      return this.computeScrollExtent(var1);
   }

   public int computeVerticalScrollOffset(RecyclerView.State var1) {
      return this.computeScrollOffset(var1);
   }

   public int computeVerticalScrollRange(RecyclerView.State var1) {
      return this.computeScrollRange(var1);
   }

   int convertFocusDirectionToLayoutDirection(int var1) {
      int var2 = -1;
      int var3 = 1;
      int var4 = Integer.MIN_VALUE;
      switch(var1) {
      case 1:
         break;
      case 2:
         return var3;
      case 17:
         if(this.mOrientation != 0) {
            return var4;
         }
         break;
      case 33:
         if(this.mOrientation != var3) {
            return var4;
         }
         break;
      case 66:
         if(this.mOrientation != 0) {
            var3 = var4;
         }

         return var3;
      case 130:
         if(this.mOrientation == var3) {
            var4 = var3;
         }

         return var4;
      default:
         var2 = var4;
      }

      return var2;
   }

   LinearLayoutManager.LayoutState createLayoutState() {
      return new LinearLayoutManager.LayoutState();
   }

   void ensureLayoutState() {
      if(this.mLayoutState == null) {
         this.mLayoutState = this.createLayoutState();
      }

      if(this.mOrientationHelper == null) {
         this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
      }

   }

   int fill(RecyclerView.Recycler var1, LinearLayoutManager.LayoutState var2, RecyclerView.State var3, boolean var4) {
      int var5 = var2.mAvailable;
      if(var2.mScrollingOffset != Integer.MIN_VALUE) {
         if(var2.mAvailable < 0) {
            var2.mScrollingOffset += var2.mAvailable;
         }

         this.recycleByLayoutState(var1, var2);
      }

      int var6 = var2.mAvailable + var2.mExtra;
      LinearLayoutManager.LayoutChunkResult var7 = new LinearLayoutManager.LayoutChunkResult();

      while((var2.mInfinite || var6 > 0) && var2.hasMore(var3)) {
         var7.resetInternal();
         this.layoutChunk(var1, var3, var2, var7);
         if(var7.mFinished) {
            break;
         }

         var2.mOffset += var7.mConsumed * var2.mLayoutDirection;
         if(!var7.mIgnoreConsumed || this.mLayoutState.mScrapList != null || !var3.isPreLayout()) {
            var2.mAvailable -= var7.mConsumed;
            var6 -= var7.mConsumed;
         }

         if(var2.mScrollingOffset != Integer.MIN_VALUE) {
            var2.mScrollingOffset += var7.mConsumed;
            if(var2.mAvailable < 0) {
               var2.mScrollingOffset += var2.mAvailable;
            }

            this.recycleByLayoutState(var1, var2);
         }

         if(var4 && var7.mFocusable) {
            break;
         }
      }

      return var5 - var2.mAvailable;
   }

   public int findFirstCompletelyVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(0, this.getChildCount(), true, false);
      return var1 == null?-1:this.getPosition(var1);
   }

   public int findFirstVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(0, this.getChildCount(), false, true);
      return var1 == null?-1:this.getPosition(var1);
   }

   public int findLastCompletelyVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(-1 + this.getChildCount(), -1, true, false);
      return var1 == null?-1:this.getPosition(var1);
   }

   public int findLastVisibleItemPosition() {
      View var1 = this.findOneVisibleChild(-1 + this.getChildCount(), -1, false, true);
      return var1 == null?-1:this.getPosition(var1);
   }

   View findOneVisibleChild(int var1, int var2, boolean var3, boolean var4) {
      this.ensureLayoutState();
      int var5 = this.mOrientationHelper.getStartAfterPadding();
      int var6 = this.mOrientationHelper.getEndAfterPadding();
      byte var7;
      if(var2 > var1) {
         var7 = 1;
      } else {
         var7 = -1;
      }

      View var8 = null;

      for(int var9 = var1; var9 != var2; var9 += var7) {
         View var10 = this.getChildAt(var9);
         int var11 = this.mOrientationHelper.getDecoratedStart(var10);
         int var12 = this.mOrientationHelper.getDecoratedEnd(var10);
         if(var11 < var6 && var12 > var5) {
            if(!var3 || var11 >= var5 && var12 <= var6) {
               return var10;
            }

            if(var4 && var8 == null) {
               var8 = var10;
            }
         }
      }

      return var8;
   }

   View findReferenceChild(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4, int var5) {
      this.ensureLayoutState();
      View var6 = null;
      View var7 = null;
      int var8 = this.mOrientationHelper.getStartAfterPadding();
      int var9 = this.mOrientationHelper.getEndAfterPadding();
      byte var10;
      if(var4 > var3) {
         var10 = 1;
      } else {
         var10 = -1;
      }

      int var11 = var3;

      View var12;
      while(true) {
         if(var11 == var4) {
            if(var7 == null) {
               var7 = var6;
            }

            var12 = var7;
            break;
         }

         var12 = this.getChildAt(var11);
         int var13 = this.getPosition(var12);
         if(var13 >= 0 && var13 < var5) {
            if(((RecyclerView.LayoutParams)var12.getLayoutParams()).isItemRemoved()) {
               if(var6 == null) {
                  var6 = var12;
               }
            } else {
               if(this.mOrientationHelper.getDecoratedStart(var12) < var9 && this.mOrientationHelper.getDecoratedEnd(var12) >= var8) {
                  break;
               }

               if(var7 == null) {
                  var7 = var12;
               }
            }
         }

         var11 += var10;
      }

      return var12;
   }

   public View findViewByPosition(int var1) {
      int var2 = this.getChildCount();
      View var4;
      if(var2 == 0) {
         var4 = null;
         return var4;
      } else {
         int var3 = var1 - this.getPosition(this.getChildAt(0));
         if(var3 >= 0 && var3 < var2) {
            var4 = this.getChildAt(var3);
            if(this.getPosition(var4) == var1) {
               return var4;
            }
         }

         return super.findViewByPosition(var1);
      }
   }

   public RecyclerView.LayoutParams generateDefaultLayoutParams() {
      return new RecyclerView.LayoutParams(-2, -2);
   }

   protected int getExtraLayoutSpace(RecyclerView.State var1) {
      return var1.hasTargetScrollPosition()?this.mOrientationHelper.getTotalSpace():0;
   }

   public int getOrientation() {
      return this.mOrientation;
   }

   public boolean getRecycleChildrenOnDetach() {
      return this.mRecycleChildrenOnDetach;
   }

   public boolean getReverseLayout() {
      return this.mReverseLayout;
   }

   public boolean getStackFromEnd() {
      return this.mStackFromEnd;
   }

   protected boolean isLayoutRTL() {
      return this.getLayoutDirection() == 1;
   }

   public boolean isSmoothScrollbarEnabled() {
      return this.mSmoothScrollbarEnabled;
   }

   void layoutChunk(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.LayoutState var3, LinearLayoutManager.LayoutChunkResult var4) {
      View var5 = var3.next(var1);
      if(var5 == null) {
         var4.mFinished = true;
      } else {
         RecyclerView.LayoutParams var6 = (RecyclerView.LayoutParams)var5.getLayoutParams();
         if(var3.mScrapList == null) {
            boolean var13 = this.mShouldReverseLayout;
            boolean var14;
            if(var3.mLayoutDirection == -1) {
               var14 = true;
            } else {
               var14 = false;
            }

            if(var13 == var14) {
               this.addView(var5);
            } else {
               this.addView(var5, 0);
            }
         } else {
            boolean var7 = this.mShouldReverseLayout;
            boolean var8;
            if(var3.mLayoutDirection == -1) {
               var8 = true;
            } else {
               var8 = false;
            }

            if(var7 == var8) {
               this.addDisappearingView(var5);
            } else {
               this.addDisappearingView(var5, 0);
            }
         }

         this.measureChildWithMargins(var5, 0, 0);
         var4.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(var5);
         int var9;
         int var10;
         int var11;
         int var12;
         if(this.mOrientation == 1) {
            if(this.isLayoutRTL()) {
               var12 = this.getWidth() - this.getPaddingRight();
               var11 = var12 - this.mOrientationHelper.getDecoratedMeasurementInOther(var5);
            } else {
               var11 = this.getPaddingLeft();
               var12 = var11 + this.mOrientationHelper.getDecoratedMeasurementInOther(var5);
            }

            if(var3.mLayoutDirection == -1) {
               var10 = var3.mOffset;
               var9 = var3.mOffset - var4.mConsumed;
            } else {
               var9 = var3.mOffset;
               var10 = var3.mOffset + var4.mConsumed;
            }
         } else {
            var9 = this.getPaddingTop();
            var10 = var9 + this.mOrientationHelper.getDecoratedMeasurementInOther(var5);
            if(var3.mLayoutDirection == -1) {
               var12 = var3.mOffset;
               var11 = var3.mOffset - var4.mConsumed;
            } else {
               var11 = var3.mOffset;
               var12 = var3.mOffset + var4.mConsumed;
            }
         }

         this.layoutDecorated(var5, var11 + var6.leftMargin, var9 + var6.topMargin, var12 - var6.rightMargin, var10 - var6.bottomMargin);
         if(var6.isItemRemoved() || var6.isItemChanged()) {
            var4.mIgnoreConsumed = true;
         }

         var4.mFocusable = var5.isFocusable();
      }
   }

   void onAnchorReady(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3, int var4) {
   }

   public void onDetachedFromWindow(RecyclerView var1, RecyclerView.Recycler var2) {
      super.onDetachedFromWindow(var1, var2);
      if(this.mRecycleChildrenOnDetach) {
         this.removeAndRecycleAllViews(var2);
         var2.clear();
      }

   }

   public View onFocusSearchFailed(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
      this.resolveShouldLayoutReverse();
      View var8;
      if(this.getChildCount() == 0) {
         var8 = null;
      } else {
         int var5 = this.convertFocusDirectionToLayoutDirection(var2);
         if(var5 == Integer.MIN_VALUE) {
            return null;
         }

         this.ensureLayoutState();
         View var6;
         if(var5 == -1) {
            var6 = this.findReferenceChildClosestToStart(var3, var4);
         } else {
            var6 = this.findReferenceChildClosestToEnd(var3, var4);
         }

         if(var6 == null) {
            return null;
         }

         this.ensureLayoutState();
         this.updateLayoutState(var5, (int)(0.33333334F * (float)this.mOrientationHelper.getTotalSpace()), false, var4);
         this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
         this.mLayoutState.mRecycle = false;
         this.fill(var3, this.mLayoutState, var4, true);
         if(var5 == -1) {
            var8 = this.getChildClosestToStart();
         } else {
            var8 = this.getChildClosestToEnd();
         }

         if(var8 == var6 || !var8.isFocusable()) {
            return null;
         }
      }

      return var8;
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      if(this.getChildCount() > 0) {
         AccessibilityRecordCompat var2 = AccessibilityEventCompat.asRecord(var1);
         var2.setFromIndex(this.findFirstVisibleItemPosition());
         var2.setToIndex(this.findLastVisibleItemPosition());
      }

   }

   public void onLayoutChildren(RecyclerView.Recycler var1, RecyclerView.State var2) {
      if((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && var2.getItemCount() == 0) {
         this.removeAndRecycleAllViews(var1);
      } else {
         if(this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
         }

         this.ensureLayoutState();
         this.mLayoutState.mRecycle = false;
         this.resolveShouldLayoutReverse();
         this.mAnchorInfo.reset();
         this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
         this.updateAnchorInfoForLayout(var1, var2, this.mAnchorInfo);
         int var3 = this.getExtraLayoutSpace(var2);
         int var4;
         int var5;
         if(this.mLayoutState.mLastScrollDelta >= 0) {
            var5 = var3;
            var4 = 0;
         } else {
            var4 = var3;
            var5 = 0;
         }

         int var6 = var4 + this.mOrientationHelper.getStartAfterPadding();
         int var7 = var5 + this.mOrientationHelper.getEndPadding();
         if(var2.isPreLayout() && this.mPendingScrollPosition != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
            View var33 = this.findViewByPosition(this.mPendingScrollPosition);
            if(var33 != null) {
               int var35;
               if(this.mShouldReverseLayout) {
                  var35 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var33) - this.mPendingScrollPositionOffset;
               } else {
                  int var34 = this.mOrientationHelper.getDecoratedStart(var33) - this.mOrientationHelper.getStartAfterPadding();
                  var35 = this.mPendingScrollPositionOffset - var34;
               }

               if(var35 > 0) {
                  var6 += var35;
               } else {
                  var7 -= var35;
               }
            }
         }

         byte var8;
         if(this.mAnchorInfo.mLayoutFromEnd) {
            if(this.mShouldReverseLayout) {
               var8 = 1;
            } else {
               var8 = -1;
            }
         } else if(this.mShouldReverseLayout) {
            var8 = -1;
         } else {
            var8 = 1;
         }

         this.onAnchorReady(var1, var2, this.mAnchorInfo, var8);
         this.detachAndScrapAttachedViews(var1);
         LinearLayoutManager.LayoutState var9 = this.mLayoutState;
         boolean var10;
         if(this.mOrientationHelper.getMode() == 0) {
            var10 = true;
         } else {
            var10 = false;
         }

         var9.mInfinite = var10;
         this.mLayoutState.mIsPreLayout = var2.isPreLayout();
         int var12;
         int var16;
         if(this.mAnchorInfo.mLayoutFromEnd) {
            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = var6;
            this.fill(var1, this.mLayoutState, var2, false);
            var16 = this.mLayoutState.mOffset;
            int var28 = this.mLayoutState.mCurrentPosition;
            if(this.mLayoutState.mAvailable > 0) {
               var7 += this.mLayoutState.mAvailable;
            }

            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = var7;
            LinearLayoutManager.LayoutState var29 = this.mLayoutState;
            var29.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2, false);
            var12 = this.mLayoutState.mOffset;
            if(this.mLayoutState.mAvailable > 0) {
               int var31 = this.mLayoutState.mAvailable;
               this.updateLayoutStateToFillStart(var28, var16);
               this.mLayoutState.mExtra = var31;
               this.fill(var1, this.mLayoutState, var2, false);
               var16 = this.mLayoutState.mOffset;
            }
         } else {
            this.updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = var7;
            this.fill(var1, this.mLayoutState, var2, false);
            var12 = this.mLayoutState.mOffset;
            int var13 = this.mLayoutState.mCurrentPosition;
            if(this.mLayoutState.mAvailable > 0) {
               var6 += this.mLayoutState.mAvailable;
            }

            this.updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = var6;
            LinearLayoutManager.LayoutState var14 = this.mLayoutState;
            var14.mCurrentPosition += this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2, false);
            var16 = this.mLayoutState.mOffset;
            if(this.mLayoutState.mAvailable > 0) {
               int var17 = this.mLayoutState.mAvailable;
               this.updateLayoutStateToFillEnd(var13, var12);
               this.mLayoutState.mExtra = var17;
               this.fill(var1, this.mLayoutState, var2, false);
               var12 = this.mLayoutState.mOffset;
            }
         }

         if(this.getChildCount() > 0) {
            if(this.mShouldReverseLayout ^ this.mStackFromEnd) {
               int var23 = this.fixLayoutEndGap(var12, var1, var2, true);
               int var24 = var16 + var23;
               int var25 = var12 + var23;
               int var26 = this.fixLayoutStartGap(var24, var1, var2, false);
               var16 = var24 + var26;
               var12 = var25 + var26;
            } else {
               int var19 = this.fixLayoutStartGap(var16, var1, var2, true);
               int var20 = var16 + var19;
               int var21 = var12 + var19;
               int var22 = this.fixLayoutEndGap(var21, var1, var2, false);
               var16 = var20 + var22;
               var12 = var21 + var22;
            }
         }

         this.layoutForPredictiveAnimations(var1, var2, var16, var12);
         if(!var2.isPreLayout()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            this.mOrientationHelper.onLayoutComplete();
         }

         this.mLastStackFromEnd = this.mStackFromEnd;
         this.mPendingSavedState = null;
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(var1 instanceof LinearLayoutManager.SavedState) {
         this.mPendingSavedState = (LinearLayoutManager.SavedState)var1;
         this.requestLayout();
      }

   }

   public Parcelable onSaveInstanceState() {
      if(this.mPendingSavedState != null) {
         return new LinearLayoutManager.SavedState(this.mPendingSavedState);
      } else {
         LinearLayoutManager.SavedState var1 = new LinearLayoutManager.SavedState();
         if(this.getChildCount() > 0) {
            this.ensureLayoutState();
            boolean var2 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            var1.mAnchorLayoutFromEnd = var2;
            if(var2) {
               View var4 = this.getChildClosestToEnd();
               var1.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var4);
               var1.mAnchorPosition = this.getPosition(var4);
               return var1;
            } else {
               View var3 = this.getChildClosestToStart();
               var1.mAnchorPosition = this.getPosition(var3);
               var1.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(var3) - this.mOrientationHelper.getStartAfterPadding();
               return var1;
            }
         } else {
            var1.invalidateAnchor();
            return var1;
         }
      }
   }

   public void prepareForDrop(View var1, View var2, int var3, int var4) {
      this.assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
      this.ensureLayoutState();
      this.resolveShouldLayoutReverse();
      int var5 = this.getPosition(var1);
      int var6 = this.getPosition(var2);
      byte var7;
      if(var5 < var6) {
         var7 = 1;
      } else {
         var7 = -1;
      }

      if(this.mShouldReverseLayout) {
         if(var7 == 1) {
            this.scrollToPositionWithOffset(var6, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(var2) + this.mOrientationHelper.getDecoratedMeasurement(var1)));
         } else {
            this.scrollToPositionWithOffset(var6, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(var2));
         }
      } else if(var7 == -1) {
         this.scrollToPositionWithOffset(var6, this.mOrientationHelper.getDecoratedStart(var2));
      } else {
         this.scrollToPositionWithOffset(var6, this.mOrientationHelper.getDecoratedEnd(var2) - this.mOrientationHelper.getDecoratedMeasurement(var1));
      }
   }

   int scrollBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      if(this.getChildCount() != 0 && var1 != 0) {
         this.mLayoutState.mRecycle = true;
         this.ensureLayoutState();
         byte var4;
         if(var1 > 0) {
            var4 = 1;
         } else {
            var4 = -1;
         }

         int var5 = Math.abs(var1);
         this.updateLayoutState(var4, var5, true, var3);
         int var6 = this.mLayoutState.mScrollingOffset + this.fill(var2, this.mLayoutState, var3, false);
         if(var6 >= 0) {
            int var7;
            if(var5 > var6) {
               var7 = var4 * var6;
            } else {
               var7 = var1;
            }

            this.mOrientationHelper.offsetChildren(-var7);
            this.mLayoutState.mLastScrollDelta = var7;
            return var7;
         }
      }

      return 0;
   }

   public int scrollHorizontallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      return this.mOrientation == 1?0:this.scrollBy(var1, var2, var3);
   }

   public void scrollToPosition(int var1) {
      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      if(this.mPendingSavedState != null) {
         this.mPendingSavedState.invalidateAnchor();
      }

      this.requestLayout();
   }

   public void scrollToPositionWithOffset(int var1, int var2) {
      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = var2;
      if(this.mPendingSavedState != null) {
         this.mPendingSavedState.invalidateAnchor();
      }

      this.requestLayout();
   }

   public int scrollVerticallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      return this.mOrientation == 0?0:this.scrollBy(var1, var2, var3);
   }

   public void setOrientation(int var1) {
      if(var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("invalid orientation:" + var1);
      } else {
         this.assertNotInLayoutOrScroll((String)null);
         if(var1 != this.mOrientation) {
            this.mOrientation = var1;
            this.mOrientationHelper = null;
            this.requestLayout();
         }
      }
   }

   public void setRecycleChildrenOnDetach(boolean var1) {
      this.mRecycleChildrenOnDetach = var1;
   }

   public void setReverseLayout(boolean var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(var1 != this.mReverseLayout) {
         this.mReverseLayout = var1;
         this.requestLayout();
      }
   }

   public void setSmoothScrollbarEnabled(boolean var1) {
      this.mSmoothScrollbarEnabled = var1;
   }

   public void setStackFromEnd(boolean var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(this.mStackFromEnd != var1) {
         this.mStackFromEnd = var1;
         this.requestLayout();
      }
   }

   boolean shouldMeasureTwice() {
      return this.getHeightMode() != 1073741824 && this.getWidthMode() != 1073741824 && this.hasFlexibleChildInBothOrientations();
   }

   public void smoothScrollToPosition(RecyclerView var1, RecyclerView.State var2, int var3) {
      LinearSmoothScroller var4 = new LinearSmoothScroller(var1.getContext()) {
         public PointF computeScrollVectorForPosition(int var1) {
            return LinearLayoutManager.this.computeScrollVectorForPosition(var1);
         }
      };
      var4.setTargetPosition(var3);
      this.startSmoothScroll(var4);
   }

   public boolean supportsPredictiveItemAnimations() {
      return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
   }

   void validateChildOrder() {
      byte var1 = 1;
      Log.d("LinearLayoutManager", "validating child count " + this.getChildCount());
      if(this.getChildCount() >= var1) {
         int var3 = this.getPosition(this.getChildAt(0));
         int var4 = this.mOrientationHelper.getDecoratedStart(this.getChildAt(0));
         if(this.mShouldReverseLayout) {
            for(int var10 = 1; var10 < this.getChildCount(); ++var10) {
               View var11 = this.getChildAt(var10);
               int var12 = this.getPosition(var11);
               int var13 = this.mOrientationHelper.getDecoratedStart(var11);
               if(var12 < var3) {
                  this.logChildren();
                  StringBuilder var14 = (new StringBuilder()).append("detected invalid position. loc invalid? ");
                  if(var13 >= var4) {
                     var1 = 0;
                  }

                  throw new RuntimeException(var14.append((boolean)var1).toString());
               }

               if(var13 > var4) {
                  this.logChildren();
                  throw new RuntimeException("detected invalid location");
               }
            }
         } else {
            for(int var5 = 1; var5 < this.getChildCount(); ++var5) {
               View var6 = this.getChildAt(var5);
               int var7 = this.getPosition(var6);
               int var8 = this.mOrientationHelper.getDecoratedStart(var6);
               if(var7 < var3) {
                  this.logChildren();
                  StringBuilder var9 = (new StringBuilder()).append("detected invalid position. loc invalid? ");
                  if(var8 >= var4) {
                     var1 = 0;
                  }

                  throw new RuntimeException(var9.append((boolean)var1).toString());
               }

               if(var8 < var4) {
                  this.logChildren();
                  throw new RuntimeException("detected invalid location");
               }
            }
         }
      }

   }

   class AnchorInfo {
      int mCoordinate;
      boolean mLayoutFromEnd;
      int mPosition;

      private boolean isViewValidAsAnchor(View var1, RecyclerView.State var2) {
         RecyclerView.LayoutParams var3 = (RecyclerView.LayoutParams)var1.getLayoutParams();
         return !var3.isItemRemoved() && var3.getViewLayoutPosition() >= 0 && var3.getViewLayoutPosition() < var2.getItemCount();
      }

      void assignCoordinateFromPadding() {
         int var1;
         if(this.mLayoutFromEnd) {
            var1 = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();
         } else {
            var1 = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
         }

         this.mCoordinate = var1;
      }

      public void assignFromView(View var1) {
         if(this.mLayoutFromEnd) {
            this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(var1) + LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
         } else {
            this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(var1);
         }

         this.mPosition = LinearLayoutManager.this.getPosition(var1);
      }

      public void assignFromViewAndKeepVisibleRect(View var1) {
         int var2 = LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
         if(var2 >= 0) {
            this.assignFromView(var1);
         } else {
            this.mPosition = LinearLayoutManager.this.getPosition(var1);
            if(this.mLayoutFromEnd) {
               int var8 = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - var2 - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(var1);
               this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - var8;
               if(var8 > 0) {
                  int var9 = LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(var1);
                  int var10 = this.mCoordinate - var9;
                  int var11 = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
                  int var12 = var10 - (var11 + Math.min(LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(var1) - var11, 0));
                  if(var12 < 0) {
                     this.mCoordinate += Math.min(var8, -var12);
                     return;
                  }
               }
            } else {
               int var3 = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(var1);
               int var4 = var3 - LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
               this.mCoordinate = var3;
               if(var4 > 0) {
                  int var5 = var3 + LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(var1);
                  int var6 = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - var2 - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(var1);
                  int var7 = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - Math.min(0, var6) - var5;
                  if(var7 < 0) {
                     this.mCoordinate -= Math.min(var4, -var7);
                     return;
                  }
               }
            }
         }

      }

      void reset() {
         this.mPosition = -1;
         this.mCoordinate = Integer.MIN_VALUE;
         this.mLayoutFromEnd = false;
      }

      public String toString() {
         return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + '}';
      }
   }

   protected static class LayoutChunkResult {
      public int mConsumed;
      public boolean mFinished;
      public boolean mFocusable;
      public boolean mIgnoreConsumed;

      void resetInternal() {
         this.mConsumed = 0;
         this.mFinished = false;
         this.mIgnoreConsumed = false;
         this.mFocusable = false;
      }
   }

   static class LayoutState {
      static final int INVALID_LAYOUT = Integer.MIN_VALUE;
      static final int ITEM_DIRECTION_HEAD = -1;
      static final int ITEM_DIRECTION_TAIL = 1;
      static final int LAYOUT_END = 1;
      static final int LAYOUT_START = -1;
      static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
      static final String TAG = "LinearLayoutManager#LayoutState";
      int mAvailable;
      int mCurrentPosition;
      int mExtra = 0;
      boolean mInfinite;
      boolean mIsPreLayout = false;
      int mItemDirection;
      int mLastScrollDelta;
      int mLayoutDirection;
      int mOffset;
      boolean mRecycle = true;
      List<RecyclerView.ViewHolder> mScrapList = null;
      int mScrollingOffset;

      private View nextViewFromScrapList() {
         int var1 = this.mScrapList.size();

         for(int var2 = 0; var2 < var1; ++var2) {
            View var3 = ((RecyclerView.ViewHolder)this.mScrapList.get(var2)).itemView;
            RecyclerView.LayoutParams var4 = (RecyclerView.LayoutParams)var3.getLayoutParams();
            if(!var4.isItemRemoved() && this.mCurrentPosition == var4.getViewLayoutPosition()) {
               this.assignPositionFromScrapList(var3);
               return var3;
            }
         }

         return null;
      }

      public void assignPositionFromScrapList() {
         this.assignPositionFromScrapList((View)null);
      }

      public void assignPositionFromScrapList(View var1) {
         View var2 = this.nextViewInLimitedList(var1);
         if(var2 == null) {
            this.mCurrentPosition = -1;
         } else {
            this.mCurrentPosition = ((RecyclerView.LayoutParams)var2.getLayoutParams()).getViewLayoutPosition();
         }
      }

      boolean hasMore(RecyclerView.State var1) {
         return this.mCurrentPosition >= 0 && this.mCurrentPosition < var1.getItemCount();
      }

      void log() {
         Log.d("LinearLayoutManager#LayoutState", "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
      }

      View next(RecyclerView.Recycler var1) {
         if(this.mScrapList != null) {
            return this.nextViewFromScrapList();
         } else {
            View var2 = var1.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return var2;
         }
      }

      public View nextViewInLimitedList(View var1) {
         int var2 = this.mScrapList.size();
         View var3 = null;
         int var4 = Integer.MAX_VALUE;

         for(int var5 = 0; var5 < var2; ++var5) {
            View var6 = ((RecyclerView.ViewHolder)this.mScrapList.get(var5)).itemView;
            RecyclerView.LayoutParams var7 = (RecyclerView.LayoutParams)var6.getLayoutParams();
            if(var6 != var1 && !var7.isItemRemoved()) {
               int var8 = (var7.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
               if(var8 >= 0 && var8 < var4) {
                  var3 = var6;
                  var4 = var8;
                  if(var8 == 0) {
                     break;
                  }
               }
            }
         }

         return var3;
      }
   }

   public static class SavedState implements Parcelable {
      public static final Creator<LinearLayoutManager.SavedState> CREATOR = new Creator() {
         public LinearLayoutManager.SavedState createFromParcel(Parcel var1) {
            return new LinearLayoutManager.SavedState(var1);
         }

         public LinearLayoutManager.SavedState[] newArray(int var1) {
            return new LinearLayoutManager.SavedState[var1];
         }
      };
      boolean mAnchorLayoutFromEnd;
      int mAnchorOffset;
      int mAnchorPosition;

      public SavedState() {
      }

      SavedState(Parcel var1) {
         byte var2 = 1;
         super();
         this.mAnchorPosition = var1.readInt();
         this.mAnchorOffset = var1.readInt();
         if(var1.readInt() != var2) {
            var2 = 0;
         }

         this.mAnchorLayoutFromEnd = (boolean)var2;
      }

      public SavedState(LinearLayoutManager.SavedState var1) {
         this.mAnchorPosition = var1.mAnchorPosition;
         this.mAnchorOffset = var1.mAnchorOffset;
         this.mAnchorLayoutFromEnd = var1.mAnchorLayoutFromEnd;
      }

      public int describeContents() {
         return 0;
      }

      boolean hasValidAnchor() {
         return this.mAnchorPosition >= 0;
      }

      void invalidateAnchor() {
         this.mAnchorPosition = -1;
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.mAnchorPosition);
         var1.writeInt(this.mAnchorOffset);
         byte var3;
         if(this.mAnchorLayoutFromEnd) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
      }
   }
}
