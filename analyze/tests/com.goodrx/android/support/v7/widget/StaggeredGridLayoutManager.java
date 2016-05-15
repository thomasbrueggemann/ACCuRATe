package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.LayoutState;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ScrollbarHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager {
   private static final boolean DEBUG = false;
   @Deprecated
   public static final int GAP_HANDLING_LAZY = 1;
   public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
   public static final int GAP_HANDLING_NONE = 0;
   public static final int HORIZONTAL = 0;
   private static final int INVALID_OFFSET = Integer.MIN_VALUE;
   private static final float MAX_SCROLL_FACTOR = 0.33333334F;
   public static final String TAG = "StaggeredGridLayoutManager";
   public static final int VERTICAL = 1;
   private final StaggeredGridLayoutManager.AnchorInfo mAnchorInfo;
   private final Runnable mCheckForGapsRunnable;
   private int mFullSizeSpec;
   private int mGapStrategy;
   private boolean mLaidOutInvalidFullSpan;
   private boolean mLastLayoutFromEnd;
   private boolean mLastLayoutRTL;
   private LayoutState mLayoutState;
   StaggeredGridLayoutManager.LazySpanLookup mLazySpanLookup;
   private int mOrientation;
   private StaggeredGridLayoutManager.SavedState mPendingSavedState;
   int mPendingScrollPosition;
   int mPendingScrollPositionOffset;
   OrientationHelper mPrimaryOrientation;
   private BitSet mRemainingSpans;
   private boolean mReverseLayout;
   OrientationHelper mSecondaryOrientation;
   boolean mShouldReverseLayout;
   private int mSizePerSpan;
   private boolean mSmoothScrollbarEnabled;
   private int mSpanCount;
   private StaggeredGridLayoutManager.Span[] mSpans;
   private final Rect mTmpRect;

   public StaggeredGridLayoutManager(int var1, int var2) {
      boolean var3 = true;
      super();
      this.mSpanCount = -1;
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mLazySpanLookup = new StaggeredGridLayoutManager.LazySpanLookup();
      this.mGapStrategy = 2;
      this.mTmpRect = new Rect();
      this.mAnchorInfo = new StaggeredGridLayoutManager.AnchorInfo(null);
      this.mLaidOutInvalidFullSpan = false;
      this.mSmoothScrollbarEnabled = var3;
      this.mCheckForGapsRunnable = new Runnable() {
         public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
         }
      };
      this.mOrientation = var2;
      this.setSpanCount(var1);
      if(this.mGapStrategy == 0) {
         var3 = false;
      }

      this.setAutoMeasureEnabled(var3);
   }

   public StaggeredGridLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      boolean var5 = true;
      super();
      this.mSpanCount = -1;
      this.mReverseLayout = false;
      this.mShouldReverseLayout = false;
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.mLazySpanLookup = new StaggeredGridLayoutManager.LazySpanLookup();
      this.mGapStrategy = 2;
      this.mTmpRect = new Rect();
      this.mAnchorInfo = new StaggeredGridLayoutManager.AnchorInfo(null);
      this.mLaidOutInvalidFullSpan = false;
      this.mSmoothScrollbarEnabled = var5;
      this.mCheckForGapsRunnable = new Runnable() {
         public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
         }
      };
      RecyclerView.Properties var6 = getProperties(var1, var2, var3, var4);
      this.setOrientation(var6.orientation);
      this.setSpanCount(var6.spanCount);
      this.setReverseLayout(var6.reverseLayout);
      if(this.mGapStrategy == 0) {
         var5 = false;
      }

      this.setAutoMeasureEnabled(var5);
   }

   private void appendViewToAllSpans(View var1) {
      for(int var2 = -1 + this.mSpanCount; var2 >= 0; --var2) {
         this.mSpans[var2].appendToSpan(var1);
      }

   }

   private void applyPendingSavedState(StaggeredGridLayoutManager.AnchorInfo var1) {
      if(this.mPendingSavedState.mSpanOffsetsSize > 0) {
         if(this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount) {
            for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
               this.mSpans[var2].clear();
               int var3 = this.mPendingSavedState.mSpanOffsets[var2];
               if(var3 != Integer.MIN_VALUE) {
                  if(this.mPendingSavedState.mAnchorLayoutFromEnd) {
                     var3 += this.mPrimaryOrientation.getEndAfterPadding();
                  } else {
                     var3 += this.mPrimaryOrientation.getStartAfterPadding();
                  }
               }

               this.mSpans[var2].setLine(var3);
            }
         } else {
            this.mPendingSavedState.invalidateSpanInfo();
            this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
         }
      }

      this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
      this.setReverseLayout(this.mPendingSavedState.mReverseLayout);
      this.resolveShouldLayoutReverse();
      if(this.mPendingSavedState.mAnchorPosition != -1) {
         this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
         var1.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
      } else {
         var1.mLayoutFromEnd = this.mShouldReverseLayout;
      }

      if(this.mPendingSavedState.mSpanLookupSize > 1) {
         this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
         this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
      }

   }

   private void attachViewToSpans(View var1, StaggeredGridLayoutManager.LayoutParams var2, LayoutState var3) {
      if(var3.mLayoutDirection == 1) {
         if(var2.mFullSpan) {
            this.appendViewToAllSpans(var1);
         } else {
            var2.mSpan.appendToSpan(var1);
         }
      } else if(var2.mFullSpan) {
         this.prependViewToAllSpans(var1);
      } else {
         var2.mSpan.prependToSpan(var1);
      }
   }

   private int calculateScrollDirectionForPosition(int var1) {
      byte var2 = -1;
      if(this.getChildCount() == 0) {
         return this.mShouldReverseLayout?1:var2;
      } else {
         boolean var3;
         if(var1 < this.getFirstChildPosition()) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3 == this.mShouldReverseLayout) {
            var2 = 1;
         }

         return var2;
      }
   }

   private boolean checkForGaps() {
      if(this.getChildCount() != 0 && this.mGapStrategy != 0 && this.isAttachedToWindow()) {
         int var1;
         int var2;
         if(this.mShouldReverseLayout) {
            var1 = this.getLastChildPosition();
            var2 = this.getFirstChildPosition();
         } else {
            var1 = this.getFirstChildPosition();
            var2 = this.getLastChildPosition();
         }

         if(var1 == 0 && this.hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            this.requestSimpleAnimationsInNextLayout();
            this.requestLayout();
            return true;
         } else if(!this.mLaidOutInvalidFullSpan) {
            return false;
         } else {
            byte var3;
            if(this.mShouldReverseLayout) {
               var3 = -1;
            } else {
               var3 = 1;
            }

            StaggeredGridLayoutManager.FullSpanItem var4 = this.mLazySpanLookup.getFirstFullSpanItemInRange(var1, var2 + 1, var3, true);
            if(var4 == null) {
               this.mLaidOutInvalidFullSpan = false;
               this.mLazySpanLookup.forceInvalidateAfter(var2 + 1);
               return false;
            } else {
               StaggeredGridLayoutManager.FullSpanItem var5 = this.mLazySpanLookup.getFirstFullSpanItemInRange(var1, var4.mPosition, var3 * -1, true);
               if(var5 == null) {
                  this.mLazySpanLookup.forceInvalidateAfter(var4.mPosition);
               } else {
                  this.mLazySpanLookup.forceInvalidateAfter(1 + var5.mPosition);
               }

               this.requestSimpleAnimationsInNextLayout();
               this.requestLayout();
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean checkSpanForGap(StaggeredGridLayoutManager.Span var1) {
      if(this.mShouldReverseLayout) {
         if(var1.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
            if(var1.getLayoutParams((View)var1.mViews.get(-1 + var1.mViews.size())).mFullSpan) {
               return false;
            }

            return true;
         }
      } else if(var1.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
         if(var1.getLayoutParams((View)var1.mViews.get(0)).mFullSpan) {
            return false;
         }

         return true;
      }

      return false;
   }

   private int computeScrollExtent(RecyclerView.State var1) {
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureOrientationHelper();
         OrientationHelper var2 = this.mPrimaryOrientation;
         boolean var3;
         if(!this.mSmoothScrollbarEnabled) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var4 = this.findFirstVisibleItemClosestToStart(var3, true);
         boolean var5 = this.mSmoothScrollbarEnabled;
         boolean var6 = false;
         if(!var5) {
            var6 = true;
         }

         return ScrollbarHelper.computeScrollExtent(var1, var2, var4, this.findFirstVisibleItemClosestToEnd(var6, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private int computeScrollOffset(RecyclerView.State var1) {
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureOrientationHelper();
         OrientationHelper var2 = this.mPrimaryOrientation;
         boolean var3;
         if(!this.mSmoothScrollbarEnabled) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var4 = this.findFirstVisibleItemClosestToStart(var3, true);
         boolean var5 = this.mSmoothScrollbarEnabled;
         boolean var6 = false;
         if(!var5) {
            var6 = true;
         }

         return ScrollbarHelper.computeScrollOffset(var1, var2, var4, this.findFirstVisibleItemClosestToEnd(var6, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
      }
   }

   private int computeScrollRange(RecyclerView.State var1) {
      if(this.getChildCount() == 0) {
         return 0;
      } else {
         this.ensureOrientationHelper();
         OrientationHelper var2 = this.mPrimaryOrientation;
         boolean var3;
         if(!this.mSmoothScrollbarEnabled) {
            var3 = true;
         } else {
            var3 = false;
         }

         View var4 = this.findFirstVisibleItemClosestToStart(var3, true);
         boolean var5 = this.mSmoothScrollbarEnabled;
         boolean var6 = false;
         if(!var5) {
            var6 = true;
         }

         return ScrollbarHelper.computeScrollRange(var1, var2, var4, this.findFirstVisibleItemClosestToEnd(var6, true), this, this.mSmoothScrollbarEnabled);
      }
   }

   private int convertFocusDirectionToLayoutDirection(int var1) {
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

   private StaggeredGridLayoutManager.FullSpanItem createFullSpanItemFromEnd(int var1) {
      StaggeredGridLayoutManager.FullSpanItem var2 = new StaggeredGridLayoutManager.FullSpanItem();
      var2.mGapPerSpan = new int[this.mSpanCount];

      for(int var3 = 0; var3 < this.mSpanCount; ++var3) {
         var2.mGapPerSpan[var3] = var1 - this.mSpans[var3].getEndLine(var1);
      }

      return var2;
   }

   private StaggeredGridLayoutManager.FullSpanItem createFullSpanItemFromStart(int var1) {
      StaggeredGridLayoutManager.FullSpanItem var2 = new StaggeredGridLayoutManager.FullSpanItem();
      var2.mGapPerSpan = new int[this.mSpanCount];

      for(int var3 = 0; var3 < this.mSpanCount; ++var3) {
         var2.mGapPerSpan[var3] = this.mSpans[var3].getStartLine(var1) - var1;
      }

      return var2;
   }

   private void ensureOrientationHelper() {
      if(this.mPrimaryOrientation == null) {
         this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
         this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
         this.mLayoutState = new LayoutState();
      }

   }

   private int fill(RecyclerView.Recycler var1, LayoutState var2, RecyclerView.State var3) {
      this.mRemainingSpans.set(0, this.mSpanCount, true);
      int var4;
      if(this.mLayoutState.mInfinite) {
         if(var2.mLayoutDirection == 1) {
            var4 = Integer.MAX_VALUE;
         } else {
            var4 = Integer.MIN_VALUE;
         }
      } else if(var2.mLayoutDirection == 1) {
         var4 = var2.mEndLine + var2.mAvailable;
      } else {
         var4 = var2.mStartLine - var2.mAvailable;
      }

      this.updateAllRemainingSpans(var2.mLayoutDirection, var4);
      int var5;
      if(this.mShouldReverseLayout) {
         var5 = this.mPrimaryOrientation.getEndAfterPadding();
      } else {
         var5 = this.mPrimaryOrientation.getStartAfterPadding();
      }

      boolean var6;
      for(var6 = false; var2.hasMore(var3) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty()); var6 = true) {
         View var9 = var2.next(var1);
         StaggeredGridLayoutManager.LayoutParams var10 = (StaggeredGridLayoutManager.LayoutParams)var9.getLayoutParams();
         int var11 = var10.getViewLayoutPosition();
         int var12 = this.mLazySpanLookup.getSpan(var11);
         boolean var13;
         if(var12 == -1) {
            var13 = true;
         } else {
            var13 = false;
         }

         StaggeredGridLayoutManager.Span var14;
         if(var13) {
            if(var10.mFullSpan) {
               var14 = this.mSpans[0];
            } else {
               var14 = this.getNextSpan(var2);
            }

            this.mLazySpanLookup.setSpan(var11, var14);
         } else {
            var14 = this.mSpans[var12];
         }

         var10.mSpan = var14;
         if(var2.mLayoutDirection == 1) {
            this.addView(var9);
         } else {
            this.addView(var9, 0);
         }

         this.measureChildWithDecorationsAndMargin(var9, var10, false);
         int var15;
         int var16;
         if(var2.mLayoutDirection == 1) {
            if(var10.mFullSpan) {
               var16 = this.getMaxEnd(var5);
            } else {
               var16 = var14.getEndLine(var5);
            }

            var15 = var16 + this.mPrimaryOrientation.getDecoratedMeasurement(var9);
            if(var13 && var10.mFullSpan) {
               StaggeredGridLayoutManager.FullSpanItem var23 = this.createFullSpanItemFromEnd(var16);
               var23.mGapDir = -1;
               var23.mPosition = var11;
               this.mLazySpanLookup.addFullSpanItem(var23);
            }
         } else {
            if(var10.mFullSpan) {
               var15 = this.getMinStart(var5);
            } else {
               var15 = var14.getStartLine(var5);
            }

            var16 = var15 - this.mPrimaryOrientation.getDecoratedMeasurement(var9);
            if(var13 && var10.mFullSpan) {
               StaggeredGridLayoutManager.FullSpanItem var17 = this.createFullSpanItemFromStart(var15);
               var17.mGapDir = 1;
               var17.mPosition = var11;
               this.mLazySpanLookup.addFullSpanItem(var17);
            }
         }

         if(var10.mFullSpan && var2.mItemDirection == -1) {
            if(var13) {
               this.mLaidOutInvalidFullSpan = true;
            } else {
               boolean var21;
               if(var2.mLayoutDirection == 1) {
                  if(!this.areAllEndsEqual()) {
                     var21 = true;
                  } else {
                     var21 = false;
                  }
               } else if(!this.areAllStartsEqual()) {
                  var21 = true;
               } else {
                  var21 = false;
               }

               if(var21) {
                  StaggeredGridLayoutManager.FullSpanItem var22 = this.mLazySpanLookup.getFullSpanItem(var11);
                  if(var22 != null) {
                     var22.mHasUnwantedGapAfter = true;
                  }

                  this.mLaidOutInvalidFullSpan = true;
               }
            }
         }

         this.attachViewToSpans(var9, var10, var2);
         int var19;
         int var18;
         if(this.isLayoutRTL() && this.mOrientation == 1) {
            if(var10.mFullSpan) {
               var19 = this.mSecondaryOrientation.getEndAfterPadding();
            } else {
               var19 = this.mSecondaryOrientation.getEndAfterPadding() - (-1 + this.mSpanCount - var14.mIndex) * this.mSizePerSpan;
            }

            var18 = var19 - this.mSecondaryOrientation.getDecoratedMeasurement(var9);
         } else {
            if(var10.mFullSpan) {
               var18 = this.mSecondaryOrientation.getStartAfterPadding();
            } else {
               var18 = var14.mIndex * this.mSizePerSpan + this.mSecondaryOrientation.getStartAfterPadding();
            }

            var19 = var18 + this.mSecondaryOrientation.getDecoratedMeasurement(var9);
         }

         if(this.mOrientation == 1) {
            this.layoutDecoratedWithMargins(var9, var18, var16, var19, var15);
         } else {
            this.layoutDecoratedWithMargins(var9, var16, var18, var15, var19);
         }

         if(var10.mFullSpan) {
            this.updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, var4);
         } else {
            int var20 = this.mLayoutState.mLayoutDirection;
            this.updateRemainingSpans(var14, var20, var4);
         }

         this.recycle(var1, this.mLayoutState);
         if(this.mLayoutState.mStopInFocusable && var9.isFocusable()) {
            if(var10.mFullSpan) {
               this.mRemainingSpans.clear();
            } else {
               this.mRemainingSpans.set(var14.mIndex, false);
            }
         }
      }

      if(!var6) {
         this.recycle(var1, this.mLayoutState);
      }

      int var7;
      if(this.mLayoutState.mLayoutDirection == -1) {
         int var8 = this.getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
         var7 = this.mPrimaryOrientation.getStartAfterPadding() - var8;
      } else {
         var7 = this.getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
      }

      return var7 > 0?Math.min(var2.mAvailable, var7):0;
   }

   private int findFirstReferenceChildPosition(int var1) {
      int var2 = this.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.getPosition(this.getChildAt(var3));
         if(var4 >= 0 && var4 < var1) {
            return var4;
         }
      }

      return 0;
   }

   private int findLastReferenceChildPosition(int var1) {
      for(int var2 = -1 + this.getChildCount(); var2 >= 0; --var2) {
         int var3 = this.getPosition(this.getChildAt(var2));
         if(var3 >= 0 && var3 < var1) {
            return var3;
         }
      }

      return 0;
   }

   private void fixEndGap(RecyclerView.Recycler var1, RecyclerView.State var2, boolean var3) {
      int var4 = this.getMaxEnd(Integer.MIN_VALUE);
      if(var4 != Integer.MIN_VALUE) {
         int var5 = this.mPrimaryOrientation.getEndAfterPadding() - var4;
         if(var5 > 0) {
            int var6 = var5 - -this.scrollBy(-var5, var1, var2);
            if(var3 && var6 > 0) {
               this.mPrimaryOrientation.offsetChildren(var6);
               return;
            }
         }
      }

   }

   private void fixStartGap(RecyclerView.Recycler var1, RecyclerView.State var2, boolean var3) {
      int var4 = this.getMinStart(Integer.MAX_VALUE);
      if(var4 != Integer.MAX_VALUE) {
         int var5 = var4 - this.mPrimaryOrientation.getStartAfterPadding();
         if(var5 > 0) {
            int var6 = var5 - this.scrollBy(var5, var1, var2);
            if(var3 && var6 > 0) {
               this.mPrimaryOrientation.offsetChildren(-var6);
               return;
            }
         }
      }

   }

   private int getFirstChildPosition() {
      return this.getChildCount() == 0?0:this.getPosition(this.getChildAt(0));
   }

   private int getLastChildPosition() {
      int var1 = this.getChildCount();
      return var1 == 0?0:this.getPosition(this.getChildAt(var1 - 1));
   }

   private int getMaxEnd(int var1) {
      int var2 = this.mSpans[0].getEndLine(var1);

      for(int var3 = 1; var3 < this.mSpanCount; ++var3) {
         int var4 = this.mSpans[var3].getEndLine(var1);
         if(var4 > var2) {
            var2 = var4;
         }
      }

      return var2;
   }

   private int getMaxStart(int var1) {
      int var2 = this.mSpans[0].getStartLine(var1);

      for(int var3 = 1; var3 < this.mSpanCount; ++var3) {
         int var4 = this.mSpans[var3].getStartLine(var1);
         if(var4 > var2) {
            var2 = var4;
         }
      }

      return var2;
   }

   private int getMinEnd(int var1) {
      int var2 = this.mSpans[0].getEndLine(var1);

      for(int var3 = 1; var3 < this.mSpanCount; ++var3) {
         int var4 = this.mSpans[var3].getEndLine(var1);
         if(var4 < var2) {
            var2 = var4;
         }
      }

      return var2;
   }

   private int getMinStart(int var1) {
      int var2 = this.mSpans[0].getStartLine(var1);

      for(int var3 = 1; var3 < this.mSpanCount; ++var3) {
         int var4 = this.mSpans[var3].getStartLine(var1);
         if(var4 < var2) {
            var2 = var4;
         }
      }

      return var2;
   }

   private StaggeredGridLayoutManager.Span getNextSpan(LayoutState var1) {
      int var2;
      byte var3;
      int var4;
      if(this.preferLastSpan(var1.mLayoutDirection)) {
         var4 = -1 + this.mSpanCount;
         var2 = -1;
         var3 = -1;
      } else {
         var2 = this.mSpanCount;
         var3 = 1;
         var4 = 0;
      }

      StaggeredGridLayoutManager.Span var9;
      if(var1.mLayoutDirection == 1) {
         var9 = null;
         int var12 = Integer.MAX_VALUE;
         int var13 = this.mPrimaryOrientation.getStartAfterPadding();

         for(int var14 = var4; var14 != var2; var14 += var3) {
            StaggeredGridLayoutManager.Span var15 = this.mSpans[var14];
            int var16 = var15.getEndLine(var13);
            if(var16 < var12) {
               var9 = var15;
               var12 = var16;
            }
         }
      } else {
         StaggeredGridLayoutManager.Span var5 = null;
         int var6 = Integer.MIN_VALUE;
         int var7 = this.mPrimaryOrientation.getEndAfterPadding();

         for(int var8 = var4; var8 != var2; var8 += var3) {
            StaggeredGridLayoutManager.Span var10 = this.mSpans[var8];
            int var11 = var10.getStartLine(var7);
            if(var11 > var6) {
               var5 = var10;
               var6 = var11;
            }
         }

         var9 = var5;
      }

      return var9;
   }

   private void handleUpdate(int var1, int var2, int var3) {
      int var4;
      if(this.mShouldReverseLayout) {
         var4 = this.getLastChildPosition();
      } else {
         var4 = this.getFirstChildPosition();
      }

      int var5;
      int var6;
      if(var3 == 8) {
         if(var1 < var2) {
            var6 = var2 + 1;
            var5 = var1;
         } else {
            var6 = var1 + 1;
            var5 = var2;
         }
      } else {
         var5 = var1;
         var6 = var1 + var2;
      }

      this.mLazySpanLookup.invalidateAfter(var5);
      switch(var3) {
      case 1:
         this.mLazySpanLookup.offsetForAddition(var1, var2);
         break;
      case 2:
         this.mLazySpanLookup.offsetForRemoval(var1, var2);
         break;
      case 8:
         this.mLazySpanLookup.offsetForRemoval(var1, 1);
         this.mLazySpanLookup.offsetForAddition(var2, 1);
      }

      if(var6 > var4) {
         int var8;
         if(this.mShouldReverseLayout) {
            var8 = this.getFirstChildPosition();
         } else {
            var8 = this.getLastChildPosition();
         }

         if(var5 <= var8) {
            this.requestLayout();
            return;
         }
      }

   }

   private void layoutDecoratedWithMargins(View var1, int var2, int var3, int var4, int var5) {
      StaggeredGridLayoutManager.LayoutParams var6 = (StaggeredGridLayoutManager.LayoutParams)var1.getLayoutParams();
      this.layoutDecorated(var1, var2 + var6.leftMargin, var3 + var6.topMargin, var4 - var6.rightMargin, var5 - var6.bottomMargin);
   }

   private void measureChildWithDecorationsAndMargin(View var1, int var2, int var3, boolean var4) {
      this.calculateItemDecorationsForChild(var1, this.mTmpRect);
      StaggeredGridLayoutManager.LayoutParams var5 = (StaggeredGridLayoutManager.LayoutParams)var1.getLayoutParams();
      int var6 = this.updateSpecWithExtra(var2, var5.leftMargin + this.mTmpRect.left, var5.rightMargin + this.mTmpRect.right);
      int var7 = this.updateSpecWithExtra(var3, var5.topMargin + this.mTmpRect.top, var5.bottomMargin + this.mTmpRect.bottom);
      boolean var8;
      if(var4) {
         var8 = this.shouldReMeasureChild(var1, var6, var7, var5);
      } else {
         var8 = this.shouldMeasureChild(var1, var6, var7, var5);
      }

      if(var8) {
         var1.measure(var6, var7);
      }

   }

   private void measureChildWithDecorationsAndMargin(View var1, StaggeredGridLayoutManager.LayoutParams var2, boolean var3) {
      if(var2.mFullSpan) {
         if(this.mOrientation == 1) {
            this.measureChildWithDecorationsAndMargin(var1, this.mFullSizeSpec, getChildMeasureSpec(this.getHeight(), this.getHeightMode(), 0, var2.height, true), var3);
         } else {
            this.measureChildWithDecorationsAndMargin(var1, getChildMeasureSpec(this.getWidth(), this.getWidthMode(), 0, var2.width, true), this.mFullSizeSpec, var3);
         }
      } else if(this.mOrientation == 1) {
         this.measureChildWithDecorationsAndMargin(var1, getChildMeasureSpec(this.mSizePerSpan, this.getWidthMode(), 0, var2.width, false), getChildMeasureSpec(this.getHeight(), this.getHeightMode(), 0, var2.height, true), var3);
      } else {
         this.measureChildWithDecorationsAndMargin(var1, getChildMeasureSpec(this.getWidth(), this.getWidthMode(), 0, var2.width, true), getChildMeasureSpec(this.mSizePerSpan, this.getHeightMode(), 0, var2.height, false), var3);
      }
   }

   private void onLayoutChildren(RecyclerView.Recycler var1, RecyclerView.State var2, boolean var3) {
      byte var4 = 1;
      this.ensureOrientationHelper();
      StaggeredGridLayoutManager.AnchorInfo var5 = this.mAnchorInfo;
      var5.reset();
      if((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && var2.getItemCount() == 0) {
         this.removeAndRecycleAllViews(var1);
      } else {
         if(this.mPendingSavedState != null) {
            this.applyPendingSavedState(var5);
         } else {
            this.resolveShouldLayoutReverse();
            var5.mLayoutFromEnd = this.mShouldReverseLayout;
         }

         this.updateAnchorInfoForLayout(var2, var5);
         if(this.mPendingSavedState == null && (var5.mLayoutFromEnd != this.mLastLayoutFromEnd || this.isLayoutRTL() != this.mLastLayoutRTL)) {
            this.mLazySpanLookup.clear();
            var5.mInvalidateOffsets = (boolean)var4;
         }

         if(this.getChildCount() > 0 && (this.mPendingSavedState == null || this.mPendingSavedState.mSpanOffsetsSize < var4)) {
            if(var5.mInvalidateOffsets) {
               for(int var15 = 0; var15 < this.mSpanCount; ++var15) {
                  this.mSpans[var15].clear();
                  if(var5.mOffset != Integer.MIN_VALUE) {
                     this.mSpans[var15].setLine(var5.mOffset);
                  }
               }
            } else {
               for(int var14 = 0; var14 < this.mSpanCount; ++var14) {
                  this.mSpans[var14].cacheReferenceLineAndClear(this.mShouldReverseLayout, var5.mOffset);
               }
            }
         }

         this.detachAndScrapAttachedViews(var1);
         this.mLayoutState.mRecycle = false;
         this.mLaidOutInvalidFullSpan = false;
         this.updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
         this.updateLayoutState(var5.mPosition, var2);
         if(var5.mLayoutFromEnd) {
            this.setLayoutStateDirection(-1);
            this.fill(var1, this.mLayoutState, var2);
            this.setLayoutStateDirection(var4);
            this.mLayoutState.mCurrentPosition = var5.mPosition + this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2);
         } else {
            this.setLayoutStateDirection(var4);
            this.fill(var1, this.mLayoutState, var2);
            this.setLayoutStateDirection(-1);
            this.mLayoutState.mCurrentPosition = var5.mPosition + this.mLayoutState.mItemDirection;
            this.fill(var1, this.mLayoutState, var2);
         }

         this.repositionToWrapContentIfNecessary();
         if(this.getChildCount() > 0) {
            if(this.mShouldReverseLayout) {
               this.fixEndGap(var1, var2, (boolean)var4);
               this.fixStartGap(var1, var2, false);
            } else {
               this.fixStartGap(var1, var2, (boolean)var4);
               this.fixEndGap(var1, var2, false);
            }
         }

         boolean var8 = false;
         if(var3) {
            boolean var9 = var2.isPreLayout();
            var8 = false;
            if(!var9) {
               if(this.mGapStrategy == 0 || this.getChildCount() <= 0 || !this.mLaidOutInvalidFullSpan && this.hasGapsToFix() == null) {
                  var4 = 0;
               }

               var8 = false;
               if(var4 != 0) {
                  this.removeCallbacks(this.mCheckForGapsRunnable);
                  boolean var11 = this.checkForGaps();
                  var8 = false;
                  if(var11) {
                     var8 = true;
                  }
               }

               this.mPendingScrollPosition = -1;
               this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            }
         }

         this.mLastLayoutFromEnd = var5.mLayoutFromEnd;
         this.mLastLayoutRTL = this.isLayoutRTL();
         this.mPendingSavedState = null;
         if(var8) {
            this.onLayoutChildren(var1, var2, false);
            return;
         }
      }

   }

   private boolean preferLastSpan(int var1) {
      if(this.mOrientation == 0) {
         boolean var4;
         if(var1 == -1) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(var4 == this.mShouldReverseLayout) {
            return false;
         }
      } else {
         boolean var2;
         if(var1 == -1) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3;
         if(var2 == this.mShouldReverseLayout) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(var3 != this.isLayoutRTL()) {
            return false;
         }
      }

      return true;
   }

   private void prependViewToAllSpans(View var1) {
      for(int var2 = -1 + this.mSpanCount; var2 >= 0; --var2) {
         this.mSpans[var2].prependToSpan(var1);
      }

   }

   private void recycle(RecyclerView.Recycler var1, LayoutState var2) {
      if(var2.mRecycle && !var2.mInfinite) {
         if(var2.mAvailable == 0) {
            if(var2.mLayoutDirection == -1) {
               this.recycleFromEnd(var1, var2.mEndLine);
            } else {
               this.recycleFromStart(var1, var2.mStartLine);
            }
         } else if(var2.mLayoutDirection == -1) {
            int var5 = var2.mStartLine - this.getMaxStart(var2.mStartLine);
            int var6;
            if(var5 < 0) {
               var6 = var2.mEndLine;
            } else {
               var6 = var2.mEndLine - Math.min(var5, var2.mAvailable);
            }

            this.recycleFromEnd(var1, var6);
         } else {
            int var3 = this.getMinEnd(var2.mEndLine) - var2.mEndLine;
            int var4;
            if(var3 < 0) {
               var4 = var2.mStartLine;
            } else {
               var4 = var2.mStartLine + Math.min(var3, var2.mAvailable);
            }

            this.recycleFromStart(var1, var4);
         }
      }
   }

   private void recycleFromEnd(RecyclerView.Recycler var1, int var2) {
      for(int var3 = -1 + this.getChildCount(); var3 >= 0; --var3) {
         View var4 = this.getChildAt(var3);
         if(this.mPrimaryOrientation.getDecoratedStart(var4) < var2) {
            break;
         }

         StaggeredGridLayoutManager.LayoutParams var5 = (StaggeredGridLayoutManager.LayoutParams)var4.getLayoutParams();
         if(var5.mFullSpan) {
            for(int var6 = 0; var6 < this.mSpanCount; ++var6) {
               if(this.mSpans[var6].mViews.size() == 1) {
                  return;
               }
            }

            for(int var7 = 0; var7 < this.mSpanCount; ++var7) {
               this.mSpans[var7].popEnd();
            }
         } else {
            if(var5.mSpan.mViews.size() == 1) {
               break;
            }

            var5.mSpan.popEnd();
         }

         this.removeAndRecycleView(var4, var1);
      }

   }

   private void recycleFromStart(RecyclerView.Recycler var1, int var2) {
      View var3;
      for(; this.getChildCount() > 0; this.removeAndRecycleView(var3, var1)) {
         var3 = this.getChildAt(0);
         if(this.mPrimaryOrientation.getDecoratedEnd(var3) > var2) {
            break;
         }

         StaggeredGridLayoutManager.LayoutParams var4 = (StaggeredGridLayoutManager.LayoutParams)var3.getLayoutParams();
         if(!var4.mFullSpan) {
            if(var4.mSpan.mViews.size() == 1) {
               break;
            }

            var4.mSpan.popStart();
         } else {
            for(int var5 = 0; var5 < this.mSpanCount; ++var5) {
               if(this.mSpans[var5].mViews.size() == 1) {
                  return;
               }
            }

            for(int var6 = 0; var6 < this.mSpanCount; ++var6) {
               this.mSpans[var6].popStart();
            }
         }
      }

   }

   private void repositionToWrapContentIfNecessary() {
      if(this.mSecondaryOrientation.getMode() != 1073741824) {
         float var1 = 0.0F;
         int var2 = this.getChildCount();

         for(int var3 = 0; var3 < var2; ++var3) {
            View var11 = this.getChildAt(var3);
            float var12 = (float)this.mSecondaryOrientation.getDecoratedMeasurement(var11);
            if(var12 >= var1) {
               if(((StaggeredGridLayoutManager.LayoutParams)var11.getLayoutParams()).isFullSpan()) {
                  var12 = 1.0F * var12 / (float)this.mSpanCount;
               }

               var1 = Math.max(var1, var12);
            }
         }

         int var4 = this.mSizePerSpan;
         int var5 = Math.round(var1 * (float)this.mSpanCount);
         if(this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            var5 = Math.min(var5, this.mSecondaryOrientation.getTotalSpace());
         }

         this.updateMeasureSpecs(var5);
         if(this.mSizePerSpan != var4) {
            for(int var6 = 0; var6 < var2; ++var6) {
               View var7 = this.getChildAt(var6);
               StaggeredGridLayoutManager.LayoutParams var8 = (StaggeredGridLayoutManager.LayoutParams)var7.getLayoutParams();
               if(!var8.mFullSpan) {
                  if(this.isLayoutRTL() && this.mOrientation == 1) {
                     var7.offsetLeftAndRight(-(-1 + this.mSpanCount - var8.mSpan.mIndex) * this.mSizePerSpan - var4 * -(-1 + this.mSpanCount - var8.mSpan.mIndex));
                  } else {
                     int var9 = var8.mSpan.mIndex * this.mSizePerSpan;
                     int var10 = var4 * var8.mSpan.mIndex;
                     if(this.mOrientation == 1) {
                        var7.offsetLeftAndRight(var9 - var10);
                     } else {
                        var7.offsetTopAndBottom(var9 - var10);
                     }
                  }
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

   private void setLayoutStateDirection(int var1) {
      byte var2 = 1;
      this.mLayoutState.mLayoutDirection = var1;
      LayoutState var3 = this.mLayoutState;
      byte var4 = this.mShouldReverseLayout;
      byte var5;
      if(var1 == -1) {
         var5 = var2;
      } else {
         var5 = 0;
      }

      if(var4 != var5) {
         var2 = -1;
      }

      var3.mItemDirection = var2;
   }

   private void updateAllRemainingSpans(int var1, int var2) {
      for(int var3 = 0; var3 < this.mSpanCount; ++var3) {
         if(!this.mSpans[var3].mViews.isEmpty()) {
            this.updateRemainingSpans(this.mSpans[var3], var1, var2);
         }
      }

   }

   private boolean updateAnchorFromChildren(RecyclerView.State var1, StaggeredGridLayoutManager.AnchorInfo var2) {
      int var3;
      if(this.mLastLayoutFromEnd) {
         var3 = this.findLastReferenceChildPosition(var1.getItemCount());
      } else {
         var3 = this.findFirstReferenceChildPosition(var1.getItemCount());
      }

      var2.mPosition = var3;
      var2.mOffset = Integer.MIN_VALUE;
      return true;
   }

   private void updateLayoutState(int var1, RecyclerView.State var2) {
      boolean var3 = true;
      this.mLayoutState.mAvailable = 0;
      this.mLayoutState.mCurrentPosition = var1;
      boolean var4 = this.isSmoothScrolling();
      int var5 = 0;
      int var6 = 0;
      if(var4) {
         int var8 = var2.getTargetScrollPosition();
         var5 = 0;
         var6 = 0;
         if(var8 != -1) {
            boolean var9 = this.mShouldReverseLayout;
            boolean var10;
            if(var8 < var1) {
               var10 = var3;
            } else {
               var10 = false;
            }

            if(var9 == var10) {
               var5 = this.mPrimaryOrientation.getTotalSpace();
            } else {
               var6 = this.mPrimaryOrientation.getTotalSpace();
               var5 = 0;
            }
         }
      }

      if(this.getClipToPadding()) {
         this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - var6;
         this.mLayoutState.mEndLine = var5 + this.mPrimaryOrientation.getEndAfterPadding();
      } else {
         this.mLayoutState.mEndLine = var5 + this.mPrimaryOrientation.getEnd();
         this.mLayoutState.mStartLine = -var6;
      }

      this.mLayoutState.mStopInFocusable = false;
      this.mLayoutState.mRecycle = var3;
      LayoutState var7 = this.mLayoutState;
      if(this.mPrimaryOrientation.getMode() != 0) {
         var3 = false;
      }

      var7.mInfinite = var3;
   }

   private void updateRemainingSpans(StaggeredGridLayoutManager.Span var1, int var2, int var3) {
      int var4 = var1.getDeletedSize();
      if(var2 == -1) {
         if(var4 + var1.getStartLine() <= var3) {
            this.mRemainingSpans.set(var1.mIndex, false);
         }
      } else if(var1.getEndLine() - var4 >= var3) {
         this.mRemainingSpans.set(var1.mIndex, false);
         return;
      }

   }

   private int updateSpecWithExtra(int var1, int var2, int var3) {
      if(var2 != 0 || var3 != 0) {
         int var4 = MeasureSpec.getMode(var1);
         if(var4 == Integer.MIN_VALUE || var4 == 1073741824) {
            return MeasureSpec.makeMeasureSpec(Math.max(0, MeasureSpec.getSize(var1) - var2 - var3), var4);
         }
      }

      return var1;
   }

   boolean areAllEndsEqual() {
      int var1 = this.mSpans[0].getEndLine(Integer.MIN_VALUE);

      for(int var2 = 1; var2 < this.mSpanCount; ++var2) {
         if(this.mSpans[var2].getEndLine(Integer.MIN_VALUE) != var1) {
            return false;
         }
      }

      return true;
   }

   boolean areAllStartsEqual() {
      int var1 = this.mSpans[0].getStartLine(Integer.MIN_VALUE);

      for(int var2 = 1; var2 < this.mSpanCount; ++var2) {
         if(this.mSpans[var2].getStartLine(Integer.MIN_VALUE) != var1) {
            return false;
         }
      }

      return true;
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

   public boolean checkLayoutParams(RecyclerView.LayoutParams var1) {
      return var1 instanceof StaggeredGridLayoutManager.LayoutParams;
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

   public int computeVerticalScrollExtent(RecyclerView.State var1) {
      return this.computeScrollExtent(var1);
   }

   public int computeVerticalScrollOffset(RecyclerView.State var1) {
      return this.computeScrollOffset(var1);
   }

   public int computeVerticalScrollRange(RecyclerView.State var1) {
      return this.computeScrollRange(var1);
   }

   public int[] findFirstCompletelyVisibleItemPositions(int[] var1) {
      if(var1 == null) {
         var1 = new int[this.mSpanCount];
      } else if(var1.length < this.mSpanCount) {
         throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var1[var2] = this.mSpans[var2].findFirstCompletelyVisibleItemPosition();
      }

      return var1;
   }

   View findFirstVisibleItemClosestToEnd(boolean var1, boolean var2) {
      this.ensureOrientationHelper();
      int var3 = this.mPrimaryOrientation.getStartAfterPadding();
      int var4 = this.mPrimaryOrientation.getEndAfterPadding();
      View var5 = null;

      for(int var6 = -1 + this.getChildCount(); var6 >= 0; --var6) {
         View var7 = this.getChildAt(var6);
         int var8 = this.mPrimaryOrientation.getDecoratedStart(var7);
         int var9 = this.mPrimaryOrientation.getDecoratedEnd(var7);
         if(var9 > var3 && var8 < var4) {
            if(var9 <= var4 || !var1) {
               return var7;
            }

            if(var2 && var5 == null) {
               var5 = var7;
            }
         }
      }

      return var5;
   }

   View findFirstVisibleItemClosestToStart(boolean var1, boolean var2) {
      this.ensureOrientationHelper();
      int var3 = this.mPrimaryOrientation.getStartAfterPadding();
      int var4 = this.mPrimaryOrientation.getEndAfterPadding();
      int var5 = this.getChildCount();
      View var6 = null;

      for(int var7 = 0; var7 < var5; ++var7) {
         View var8 = this.getChildAt(var7);
         int var9 = this.mPrimaryOrientation.getDecoratedStart(var8);
         if(this.mPrimaryOrientation.getDecoratedEnd(var8) > var3 && var9 < var4) {
            if(var9 >= var3 || !var1) {
               return var8;
            }

            if(var2 && var6 == null) {
               var6 = var8;
            }
         }
      }

      return var6;
   }

   int findFirstVisibleItemPositionInt() {
      View var1;
      if(this.mShouldReverseLayout) {
         var1 = this.findFirstVisibleItemClosestToEnd(true, true);
      } else {
         var1 = this.findFirstVisibleItemClosestToStart(true, true);
      }

      return var1 == null?-1:this.getPosition(var1);
   }

   public int[] findFirstVisibleItemPositions(int[] var1) {
      if(var1 == null) {
         var1 = new int[this.mSpanCount];
      } else if(var1.length < this.mSpanCount) {
         throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var1[var2] = this.mSpans[var2].findFirstVisibleItemPosition();
      }

      return var1;
   }

   public int[] findLastCompletelyVisibleItemPositions(int[] var1) {
      if(var1 == null) {
         var1 = new int[this.mSpanCount];
      } else if(var1.length < this.mSpanCount) {
         throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var1[var2] = this.mSpans[var2].findLastCompletelyVisibleItemPosition();
      }

      return var1;
   }

   public int[] findLastVisibleItemPositions(int[] var1) {
      if(var1 == null) {
         var1 = new int[this.mSpanCount];
      } else if(var1.length < this.mSpanCount) {
         throw new IllegalArgumentException("Provided int[]\'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + var1.length);
      }

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         var1[var2] = this.mSpans[var2].findLastVisibleItemPosition();
      }

      return var1;
   }

   public RecyclerView.LayoutParams generateDefaultLayoutParams() {
      return this.mOrientation == 0?new StaggeredGridLayoutManager.LayoutParams(-2, -1):new StaggeredGridLayoutManager.LayoutParams(-1, -2);
   }

   public RecyclerView.LayoutParams generateLayoutParams(Context var1, AttributeSet var2) {
      return new StaggeredGridLayoutManager.LayoutParams(var1, var2);
   }

   public RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof MarginLayoutParams?new StaggeredGridLayoutManager.LayoutParams((MarginLayoutParams)var1):new StaggeredGridLayoutManager.LayoutParams(var1);
   }

   public int getColumnCountForAccessibility(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.mOrientation == 1?this.mSpanCount:super.getColumnCountForAccessibility(var1, var2);
   }

   public int getGapStrategy() {
      return this.mGapStrategy;
   }

   public int getOrientation() {
      return this.mOrientation;
   }

   public boolean getReverseLayout() {
      return this.mReverseLayout;
   }

   public int getRowCountForAccessibility(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.mOrientation == 0?this.mSpanCount:super.getRowCountForAccessibility(var1, var2);
   }

   public int getSpanCount() {
      return this.mSpanCount;
   }

   View hasGapsToFix() {
      int var1 = -1 + this.getChildCount();
      BitSet var2 = new BitSet(this.mSpanCount);
      var2.set(0, this.mSpanCount, true);
      byte var3;
      if(this.mOrientation == 1 && this.isLayoutRTL()) {
         var3 = 1;
      } else {
         var3 = -1;
      }

      int var4;
      int var5;
      if(this.mShouldReverseLayout) {
         var5 = var1;
         var4 = 0 - 1;
      } else {
         var4 = var1 + 1;
         var5 = 0;
      }

      byte var6;
      if(var5 < var4) {
         var6 = 1;
      } else {
         var6 = -1;
      }

      int var7 = var5;

      View var8;
      while(true) {
         if(var7 == var4) {
            return null;
         }

         var8 = this.getChildAt(var7);
         StaggeredGridLayoutManager.LayoutParams var9 = (StaggeredGridLayoutManager.LayoutParams)var8.getLayoutParams();
         if(var2.get(var9.mSpan.mIndex)) {
            if(this.checkSpanForGap(var9.mSpan)) {
               break;
            }

            var2.clear(var9.mSpan.mIndex);
         }

         if(!var9.mFullSpan && var7 + var6 != var4) {
            View var10 = this.getChildAt(var7 + var6);
            boolean var13;
            if(this.mShouldReverseLayout) {
               int var17 = this.mPrimaryOrientation.getDecoratedEnd(var8);
               int var18 = this.mPrimaryOrientation.getDecoratedEnd(var10);
               if(var17 < var18) {
                  break;
               }

               var13 = false;
               if(var17 == var18) {
                  var13 = true;
               }
            } else {
               int var11 = this.mPrimaryOrientation.getDecoratedStart(var8);
               int var12 = this.mPrimaryOrientation.getDecoratedStart(var10);
               if(var11 > var12) {
                  break;
               }

               var13 = false;
               if(var11 == var12) {
                  var13 = true;
               }
            }

            if(var13) {
               StaggeredGridLayoutManager.LayoutParams var14 = (StaggeredGridLayoutManager.LayoutParams)var10.getLayoutParams();
               boolean var15;
               if(var9.mSpan.mIndex - var14.mSpan.mIndex < 0) {
                  var15 = true;
               } else {
                  var15 = false;
               }

               boolean var16;
               if(var3 < 0) {
                  var16 = true;
               } else {
                  var16 = false;
               }

               if(var15 != var16) {
                  return var8;
               }
            }
         }

         var7 += var6;
      }

      return var8;
   }

   public void invalidateSpanAssignments() {
      this.mLazySpanLookup.clear();
      this.requestLayout();
   }

   boolean isLayoutRTL() {
      return this.getLayoutDirection() == 1;
   }

   public void offsetChildrenHorizontal(int var1) {
      super.offsetChildrenHorizontal(var1);

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         this.mSpans[var2].onOffset(var1);
      }

   }

   public void offsetChildrenVertical(int var1) {
      super.offsetChildrenVertical(var1);

      for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
         this.mSpans[var2].onOffset(var1);
      }

   }

   public void onDetachedFromWindow(RecyclerView var1, RecyclerView.Recycler var2) {
      this.removeCallbacks(this.mCheckForGapsRunnable);

      for(int var4 = 0; var4 < this.mSpanCount; ++var4) {
         this.mSpans[var4].clear();
      }

   }

   @Nullable
   public View onFocusSearchFailed(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
      View var12;
      if(this.getChildCount() == 0) {
         var12 = null;
         return var12;
      } else if(this.findContainingItemView(var1) == null) {
         return null;
      } else {
         this.ensureOrientationHelper();
         this.resolveShouldLayoutReverse();
         int var5 = this.convertFocusDirectionToLayoutDirection(var2);
         if(var5 == Integer.MIN_VALUE) {
            return null;
         } else {
            StaggeredGridLayoutManager.LayoutParams var6 = (StaggeredGridLayoutManager.LayoutParams)var1.getLayoutParams();
            boolean var7 = var6.mFullSpan;
            StaggeredGridLayoutManager.Span var8 = var6.mSpan;
            int var9;
            if(var5 == 1) {
               var9 = this.getLastChildPosition();
            } else {
               var9 = this.getFirstChildPosition();
            }

            this.updateLayoutState(var9, var4);
            this.setLayoutStateDirection(var5);
            this.mLayoutState.mCurrentPosition = var9 + this.mLayoutState.mItemDirection;
            this.mLayoutState.mAvailable = (int)(0.33333334F * (float)this.mPrimaryOrientation.getTotalSpace());
            this.mLayoutState.mStopInFocusable = true;
            this.mLayoutState.mRecycle = false;
            this.fill(var3, this.mLayoutState, var4);
            this.mLastLayoutFromEnd = this.mShouldReverseLayout;
            if(!var7) {
               var12 = var8.getFocusableViewAfter(var9, var5);
               if(var12 != null && var12 != var1) {
                  return var12;
               }
            }

            if(this.preferLastSpan(var5)) {
               for(int var13 = -1 + this.mSpanCount; var13 >= 0; --var13) {
                  var12 = this.mSpans[var13].getFocusableViewAfter(var9, var5);
                  if(var12 != null && var12 != var1) {
                     return var12;
                  }
               }
            } else {
               for(int var11 = 0; var11 < this.mSpanCount; ++var11) {
                  var12 = this.mSpans[var11].getFocusableViewAfter(var9, var5);
                  if(var12 != null && var12 != var1) {
                     return var12;
                  }
               }
            }

            return null;
         }
      }
   }

   public void onInitializeAccessibilityEvent(AccessibilityEvent var1) {
      super.onInitializeAccessibilityEvent(var1);
      if(this.getChildCount() > 0) {
         AccessibilityRecordCompat var2 = AccessibilityEventCompat.asRecord(var1);
         View var3 = this.findFirstVisibleItemClosestToStart(false, true);
         View var4 = this.findFirstVisibleItemClosestToEnd(false, true);
         if(var3 != null && var4 != null) {
            int var5 = this.getPosition(var3);
            int var6 = this.getPosition(var4);
            if(var5 < var6) {
               var2.setFromIndex(var5);
               var2.setToIndex(var6);
               return;
            }

            var2.setFromIndex(var6);
            var2.setToIndex(var5);
            return;
         }
      }

   }

   public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, AccessibilityNodeInfoCompat var4) {
      android.view.ViewGroup.LayoutParams var5 = var3.getLayoutParams();
      if(!(var5 instanceof StaggeredGridLayoutManager.LayoutParams)) {
         super.onInitializeAccessibilityNodeInfoForItem(var3, var4);
      } else {
         StaggeredGridLayoutManager.LayoutParams var6 = (StaggeredGridLayoutManager.LayoutParams)var5;
         if(this.mOrientation == 0) {
            int var9 = var6.getSpanIndex();
            int var10;
            if(var6.mFullSpan) {
               var10 = this.mSpanCount;
            } else {
               var10 = 1;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(var9, var10, -1, -1, var6.mFullSpan, false));
         } else {
            int var7 = var6.getSpanIndex();
            int var8;
            if(var6.mFullSpan) {
               var8 = this.mSpanCount;
            } else {
               var8 = 1;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, var7, var8, var6.mFullSpan, false));
         }
      }
   }

   public void onItemsAdded(RecyclerView var1, int var2, int var3) {
      this.handleUpdate(var2, var3, 1);
   }

   public void onItemsChanged(RecyclerView var1) {
      this.mLazySpanLookup.clear();
      this.requestLayout();
   }

   public void onItemsMoved(RecyclerView var1, int var2, int var3, int var4) {
      this.handleUpdate(var2, var3, 8);
   }

   public void onItemsRemoved(RecyclerView var1, int var2, int var3) {
      this.handleUpdate(var2, var3, 2);
   }

   public void onItemsUpdated(RecyclerView var1, int var2, int var3, Object var4) {
      this.handleUpdate(var2, var3, 4);
   }

   public void onLayoutChildren(RecyclerView.Recycler var1, RecyclerView.State var2) {
      this.onLayoutChildren(var1, var2, true);
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(var1 instanceof StaggeredGridLayoutManager.SavedState) {
         this.mPendingSavedState = (StaggeredGridLayoutManager.SavedState)var1;
         this.requestLayout();
      }

   }

   public Parcelable onSaveInstanceState() {
      StaggeredGridLayoutManager.SavedState var1;
      if(this.mPendingSavedState != null) {
         var1 = new StaggeredGridLayoutManager.SavedState(this.mPendingSavedState);
      } else {
         var1 = new StaggeredGridLayoutManager.SavedState();
         var1.mReverseLayout = this.mReverseLayout;
         var1.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
         var1.mLastLayoutRTL = this.mLastLayoutRTL;
         if(this.mLazySpanLookup != null && this.mLazySpanLookup.mData != null) {
            var1.mSpanLookup = this.mLazySpanLookup.mData;
            var1.mSpanLookupSize = var1.mSpanLookup.length;
            var1.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
         } else {
            var1.mSpanLookupSize = 0;
         }

         if(this.getChildCount() <= 0) {
            var1.mAnchorPosition = -1;
            var1.mVisibleAnchorPosition = -1;
            var1.mSpanOffsetsSize = 0;
            return var1;
         }

         this.ensureOrientationHelper();
         int var2;
         if(this.mLastLayoutFromEnd) {
            var2 = this.getLastChildPosition();
         } else {
            var2 = this.getFirstChildPosition();
         }

         var1.mAnchorPosition = var2;
         var1.mVisibleAnchorPosition = this.findFirstVisibleItemPositionInt();
         var1.mSpanOffsetsSize = this.mSpanCount;
         var1.mSpanOffsets = new int[this.mSpanCount];

         for(int var3 = 0; var3 < this.mSpanCount; ++var3) {
            int var4;
            if(this.mLastLayoutFromEnd) {
               var4 = this.mSpans[var3].getEndLine(Integer.MIN_VALUE);
               if(var4 != Integer.MIN_VALUE) {
                  var4 -= this.mPrimaryOrientation.getEndAfterPadding();
               }
            } else {
               var4 = this.mSpans[var3].getStartLine(Integer.MIN_VALUE);
               if(var4 != Integer.MIN_VALUE) {
                  var4 -= this.mPrimaryOrientation.getStartAfterPadding();
               }
            }

            var1.mSpanOffsets[var3] = var4;
         }
      }

      return var1;
   }

   public void onScrollStateChanged(int var1) {
      if(var1 == 0) {
         this.checkForGaps();
      }

   }

   int scrollBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      this.ensureOrientationHelper();
      byte var4;
      int var5;
      if(var1 > 0) {
         var4 = 1;
         var5 = this.getLastChildPosition();
      } else {
         var4 = -1;
         var5 = this.getFirstChildPosition();
      }

      this.mLayoutState.mRecycle = true;
      this.updateLayoutState(var5, var3);
      this.setLayoutStateDirection(var4);
      this.mLayoutState.mCurrentPosition = var5 + this.mLayoutState.mItemDirection;
      int var6 = Math.abs(var1);
      this.mLayoutState.mAvailable = var6;
      int var7 = this.fill(var2, this.mLayoutState, var3);
      int var8;
      if(var6 < var7) {
         var8 = var1;
      } else if(var1 < 0) {
         var8 = -var7;
      } else {
         var8 = var7;
      }

      this.mPrimaryOrientation.offsetChildren(-var8);
      this.mLastLayoutFromEnd = this.mShouldReverseLayout;
      return var8;
   }

   public int scrollHorizontallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      return this.scrollBy(var1, var2, var3);
   }

   public void scrollToPosition(int var1) {
      if(this.mPendingSavedState != null && this.mPendingSavedState.mAnchorPosition != var1) {
         this.mPendingSavedState.invalidateAnchorPositionInfo();
      }

      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      this.requestLayout();
   }

   public void scrollToPositionWithOffset(int var1, int var2) {
      if(this.mPendingSavedState != null) {
         this.mPendingSavedState.invalidateAnchorPositionInfo();
      }

      this.mPendingScrollPosition = var1;
      this.mPendingScrollPositionOffset = var2;
      this.requestLayout();
   }

   public int scrollVerticallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      return this.scrollBy(var1, var2, var3);
   }

   public void setGapStrategy(int var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(var1 != this.mGapStrategy) {
         if(var1 != 0 && var1 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
         } else {
            this.mGapStrategy = var1;
            boolean var2;
            if(this.mGapStrategy != 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.setAutoMeasureEnabled(var2);
            this.requestLayout();
         }
      }
   }

   public void setMeasuredDimension(Rect var1, int var2, int var3) {
      int var4 = this.getPaddingLeft() + this.getPaddingRight();
      int var5 = this.getPaddingTop() + this.getPaddingBottom();
      int var6;
      int var7;
      if(this.mOrientation == 1) {
         var7 = chooseSize(var3, var5 + var1.height(), this.getMinimumHeight());
         var6 = chooseSize(var2, var4 + this.mSizePerSpan * this.mSpanCount, this.getMinimumWidth());
      } else {
         var6 = chooseSize(var2, var4 + var1.width(), this.getMinimumWidth());
         var7 = chooseSize(var3, var5 + this.mSizePerSpan * this.mSpanCount, this.getMinimumHeight());
      }

      this.setMeasuredDimension(var6, var7);
   }

   public void setOrientation(int var1) {
      if(var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("invalid orientation.");
      } else {
         this.assertNotInLayoutOrScroll((String)null);
         if(var1 != this.mOrientation) {
            this.mOrientation = var1;
            if(this.mPrimaryOrientation != null && this.mSecondaryOrientation != null) {
               OrientationHelper var2 = this.mPrimaryOrientation;
               this.mPrimaryOrientation = this.mSecondaryOrientation;
               this.mSecondaryOrientation = var2;
            }

            this.requestLayout();
         }
      }
   }

   public void setReverseLayout(boolean var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(this.mPendingSavedState != null && this.mPendingSavedState.mReverseLayout != var1) {
         this.mPendingSavedState.mReverseLayout = var1;
      }

      this.mReverseLayout = var1;
      this.requestLayout();
   }

   public void setSpanCount(int var1) {
      this.assertNotInLayoutOrScroll((String)null);
      if(var1 != this.mSpanCount) {
         this.invalidateSpanAssignments();
         this.mSpanCount = var1;
         this.mRemainingSpans = new BitSet(this.mSpanCount);
         this.mSpans = new StaggeredGridLayoutManager.Span[this.mSpanCount];

         for(int var2 = 0; var2 < this.mSpanCount; ++var2) {
            this.mSpans[var2] = new StaggeredGridLayoutManager.Span(var2, null);
         }

         this.requestLayout();
      }

   }

   public void smoothScrollToPosition(RecyclerView var1, RecyclerView.State var2, int var3) {
      LinearSmoothScroller var4 = new LinearSmoothScroller(var1.getContext()) {
         public PointF computeScrollVectorForPosition(int var1) {
            int var2 = StaggeredGridLayoutManager.this.calculateScrollDirectionForPosition(var1);
            return var2 == 0?null:(StaggeredGridLayoutManager.this.mOrientation == 0?new PointF((float)var2, 0.0F):new PointF(0.0F, (float)var2));
         }
      };
      var4.setTargetPosition(var3);
      this.startSmoothScroll(var4);
   }

   public boolean supportsPredictiveItemAnimations() {
      return this.mPendingSavedState == null;
   }

   boolean updateAnchorFromPendingData(RecyclerView.State var1, StaggeredGridLayoutManager.AnchorInfo var2) {
      if(!var1.isPreLayout() && this.mPendingScrollPosition != -1) {
         if(this.mPendingScrollPosition >= 0 && this.mPendingScrollPosition < var1.getItemCount()) {
            if(this.mPendingSavedState != null && this.mPendingSavedState.mAnchorPosition != -1 && this.mPendingSavedState.mSpanOffsetsSize >= 1) {
               var2.mOffset = Integer.MIN_VALUE;
               var2.mPosition = this.mPendingScrollPosition;
               return true;
            } else {
               View var3 = this.findViewByPosition(this.mPendingScrollPosition);
               if(var3 != null) {
                  int var6;
                  if(this.mShouldReverseLayout) {
                     var6 = this.getLastChildPosition();
                  } else {
                     var6 = this.getFirstChildPosition();
                  }

                  var2.mPosition = var6;
                  if(this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                     if(var2.mLayoutFromEnd) {
                        var2.mOffset = this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedEnd(var3);
                        return true;
                     } else {
                        var2.mOffset = this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset - this.mPrimaryOrientation.getDecoratedStart(var3);
                        return true;
                     }
                  } else if(this.mPrimaryOrientation.getDecoratedMeasurement(var3) > this.mPrimaryOrientation.getTotalSpace()) {
                     int var9;
                     if(var2.mLayoutFromEnd) {
                        var9 = this.mPrimaryOrientation.getEndAfterPadding();
                     } else {
                        var9 = this.mPrimaryOrientation.getStartAfterPadding();
                     }

                     var2.mOffset = var9;
                     return true;
                  } else {
                     int var7 = this.mPrimaryOrientation.getDecoratedStart(var3) - this.mPrimaryOrientation.getStartAfterPadding();
                     if(var7 < 0) {
                        var2.mOffset = -var7;
                        return true;
                     } else {
                        int var8 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(var3);
                        if(var8 < 0) {
                           var2.mOffset = var8;
                           return true;
                        } else {
                           var2.mOffset = Integer.MIN_VALUE;
                           return true;
                        }
                     }
                  }
               } else {
                  var2.mPosition = this.mPendingScrollPosition;
                  if(this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                     int var4 = this.calculateScrollDirectionForPosition(var2.mPosition);
                     boolean var5 = false;
                     if(var4 == 1) {
                        var5 = true;
                     }

                     var2.mLayoutFromEnd = var5;
                     var2.assignCoordinateFromPadding();
                  } else {
                     var2.assignCoordinateFromPadding(this.mPendingScrollPositionOffset);
                  }

                  var2.mInvalidateOffsets = true;
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

   void updateAnchorInfoForLayout(RecyclerView.State var1, StaggeredGridLayoutManager.AnchorInfo var2) {
      if(!this.updateAnchorFromPendingData(var1, var2) && !this.updateAnchorFromChildren(var1, var2)) {
         var2.assignCoordinateFromPadding();
         var2.mPosition = 0;
      }
   }

   void updateMeasureSpecs(int var1) {
      this.mSizePerSpan = var1 / this.mSpanCount;
      this.mFullSizeSpec = MeasureSpec.makeMeasureSpec(var1, this.mSecondaryOrientation.getMode());
   }

   private class AnchorInfo {
      boolean mInvalidateOffsets;
      boolean mLayoutFromEnd;
      int mOffset;
      int mPosition;

      private AnchorInfo() {
      }

      // $FF: synthetic method
      AnchorInfo(Object var2) {
         this();
      }

      void assignCoordinateFromPadding() {
         int var1;
         if(this.mLayoutFromEnd) {
            var1 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
         } else {
            var1 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
         }

         this.mOffset = var1;
      }

      void assignCoordinateFromPadding(int var1) {
         if(this.mLayoutFromEnd) {
            this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - var1;
         } else {
            this.mOffset = var1 + StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
         }
      }

      void reset() {
         this.mPosition = -1;
         this.mOffset = Integer.MIN_VALUE;
         this.mLayoutFromEnd = false;
         this.mInvalidateOffsets = false;
      }
   }

   public static class LayoutParams extends RecyclerView.LayoutParams {
      public static final int INVALID_SPAN_ID = -1;
      boolean mFullSpan;
      StaggeredGridLayoutManager.Span mSpan;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(RecyclerView.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      public final int getSpanIndex() {
         return this.mSpan == null?-1:this.mSpan.mIndex;
      }

      public boolean isFullSpan() {
         return this.mFullSpan;
      }

      public void setFullSpan(boolean var1) {
         this.mFullSpan = var1;
      }
   }

   static class LazySpanLookup {
      private static final int MIN_SIZE = 10;
      int[] mData;
      List<StaggeredGridLayoutManager.FullSpanItem> mFullSpanItems;

      private int invalidateFullSpansAfter(int var1) {
         if(this.mFullSpanItems != null) {
            StaggeredGridLayoutManager.FullSpanItem var2 = this.getFullSpanItem(var1);
            if(var2 != null) {
               this.mFullSpanItems.remove(var2);
            }

            int var3 = -1;
            int var4 = this.mFullSpanItems.size();

            for(int var5 = 0; var5 < var4; ++var5) {
               if(((StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var5)).mPosition >= var1) {
                  var3 = var5;
                  break;
               }
            }

            if(var3 != -1) {
               StaggeredGridLayoutManager.FullSpanItem var6 = (StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var3);
               this.mFullSpanItems.remove(var3);
               return var6.mPosition;
            }
         }

         return -1;
      }

      private void offsetFullSpansForAddition(int var1, int var2) {
         if(this.mFullSpanItems != null) {
            for(int var3 = -1 + this.mFullSpanItems.size(); var3 >= 0; --var3) {
               StaggeredGridLayoutManager.FullSpanItem var4 = (StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var3);
               if(var4.mPosition >= var1) {
                  var4.mPosition += var2;
               }
            }
         }

      }

      private void offsetFullSpansForRemoval(int var1, int var2) {
         if(this.mFullSpanItems != null) {
            int var3 = var1 + var2;

            for(int var4 = -1 + this.mFullSpanItems.size(); var4 >= 0; --var4) {
               StaggeredGridLayoutManager.FullSpanItem var5 = (StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var4);
               if(var5.mPosition >= var1) {
                  if(var5.mPosition < var3) {
                     this.mFullSpanItems.remove(var4);
                  } else {
                     var5.mPosition -= var2;
                  }
               }
            }
         }

      }

      public void addFullSpanItem(StaggeredGridLayoutManager.FullSpanItem var1) {
         if(this.mFullSpanItems == null) {
            this.mFullSpanItems = new ArrayList();
         }

         int var2 = this.mFullSpanItems.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            StaggeredGridLayoutManager.FullSpanItem var5 = (StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var3);
            if(var5.mPosition == var1.mPosition) {
               this.mFullSpanItems.remove(var3);
            }

            if(var5.mPosition >= var1.mPosition) {
               this.mFullSpanItems.add(var3, var1);
               return;
            }
         }

         this.mFullSpanItems.add(var1);
      }

      void clear() {
         if(this.mData != null) {
            Arrays.fill(this.mData, -1);
         }

         this.mFullSpanItems = null;
      }

      void ensureSize(int var1) {
         if(this.mData == null) {
            this.mData = new int[1 + Math.max(var1, 10)];
            Arrays.fill(this.mData, -1);
         } else if(var1 >= this.mData.length) {
            int[] var2 = this.mData;
            this.mData = new int[this.sizeForPosition(var1)];
            System.arraycopy(var2, 0, this.mData, 0, var2.length);
            Arrays.fill(this.mData, var2.length, this.mData.length, -1);
            return;
         }

      }

      int forceInvalidateAfter(int var1) {
         if(this.mFullSpanItems != null) {
            for(int var2 = -1 + this.mFullSpanItems.size(); var2 >= 0; --var2) {
               if(((StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var2)).mPosition >= var1) {
                  this.mFullSpanItems.remove(var2);
               }
            }
         }

         return this.invalidateAfter(var1);
      }

      public StaggeredGridLayoutManager.FullSpanItem getFirstFullSpanItemInRange(int var1, int var2, int var3, boolean var4) {
         StaggeredGridLayoutManager.FullSpanItem var7;
         if(this.mFullSpanItems == null) {
            var7 = null;
         } else {
            int var5 = this.mFullSpanItems.size();
            int var6 = 0;

            while(true) {
               if(var6 >= var5) {
                  return null;
               }

               var7 = (StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var6);
               if(var7.mPosition >= var2) {
                  return null;
               }

               if(var7.mPosition >= var1 && (var3 == 0 || var7.mGapDir == var3 || var4 && var7.mHasUnwantedGapAfter)) {
                  break;
               }

               ++var6;
            }
         }

         return var7;
      }

      public StaggeredGridLayoutManager.FullSpanItem getFullSpanItem(int var1) {
         StaggeredGridLayoutManager.FullSpanItem var3;
         if(this.mFullSpanItems == null) {
            var3 = null;
         } else {
            int var2 = -1 + this.mFullSpanItems.size();

            while(true) {
               if(var2 < 0) {
                  return null;
               }

               var3 = (StaggeredGridLayoutManager.FullSpanItem)this.mFullSpanItems.get(var2);
               if(var3.mPosition == var1) {
                  break;
               }

               --var2;
            }
         }

         return var3;
      }

      int getSpan(int var1) {
         return this.mData != null && var1 < this.mData.length?this.mData[var1]:-1;
      }

      int invalidateAfter(int var1) {
         if(this.mData != null && var1 < this.mData.length) {
            int var2 = this.invalidateFullSpansAfter(var1);
            if(var2 == -1) {
               Arrays.fill(this.mData, var1, this.mData.length, -1);
               return this.mData.length;
            } else {
               Arrays.fill(this.mData, var1, var2 + 1, -1);
               return var2 + 1;
            }
         } else {
            return -1;
         }
      }

      void offsetForAddition(int var1, int var2) {
         if(this.mData != null && var1 < this.mData.length) {
            this.ensureSize(var1 + var2);
            System.arraycopy(this.mData, var1, this.mData, var1 + var2, this.mData.length - var1 - var2);
            Arrays.fill(this.mData, var1, var1 + var2, -1);
            this.offsetFullSpansForAddition(var1, var2);
         }
      }

      void offsetForRemoval(int var1, int var2) {
         if(this.mData != null && var1 < this.mData.length) {
            this.ensureSize(var1 + var2);
            System.arraycopy(this.mData, var1 + var2, this.mData, var1, this.mData.length - var1 - var2);
            Arrays.fill(this.mData, this.mData.length - var2, this.mData.length, -1);
            this.offsetFullSpansForRemoval(var1, var2);
         }
      }

      void setSpan(int var1, StaggeredGridLayoutManager.Span var2) {
         this.ensureSize(var1);
         this.mData[var1] = var2.mIndex;
      }

      int sizeForPosition(int var1) {
         int var2;
         for(var2 = this.mData.length; var2 <= var1; var2 *= 2) {
            ;
         }

         return var2;
      }
   }

   static class FullSpanItem implements Parcelable {
      public static final Creator<StaggeredGridLayoutManager.FullSpanItem> CREATOR = new Creator() {
         public StaggeredGridLayoutManager.FullSpanItem createFromParcel(Parcel var1) {
            return new StaggeredGridLayoutManager.FullSpanItem(var1);
         }

         public StaggeredGridLayoutManager.FullSpanItem[] newArray(int var1) {
            return new StaggeredGridLayoutManager.FullSpanItem[var1];
         }
      };
      int mGapDir;
      int[] mGapPerSpan;
      boolean mHasUnwantedGapAfter;
      int mPosition;

      public FullSpanItem() {
      }

      public FullSpanItem(Parcel var1) {
         byte var2 = 1;
         super();
         this.mPosition = var1.readInt();
         this.mGapDir = var1.readInt();
         if(var1.readInt() != var2) {
            var2 = 0;
         }

         this.mHasUnwantedGapAfter = (boolean)var2;
         int var3 = var1.readInt();
         if(var3 > 0) {
            this.mGapPerSpan = new int[var3];
            var1.readIntArray(this.mGapPerSpan);
         }

      }

      public int describeContents() {
         return 0;
      }

      int getGapForSpan(int var1) {
         return this.mGapPerSpan == null?0:this.mGapPerSpan[var1];
      }

      public String toString() {
         return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
      }

      public void writeToParcel(Parcel var1, int var2) {
         var1.writeInt(this.mPosition);
         var1.writeInt(this.mGapDir);
         byte var3;
         if(this.mHasUnwantedGapAfter) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
         if(this.mGapPerSpan != null && this.mGapPerSpan.length > 0) {
            var1.writeInt(this.mGapPerSpan.length);
            var1.writeIntArray(this.mGapPerSpan);
         } else {
            var1.writeInt(0);
         }
      }
   }

   public static class SavedState implements Parcelable {
      public static final Creator<StaggeredGridLayoutManager.SavedState> CREATOR = new Creator() {
         public StaggeredGridLayoutManager.SavedState createFromParcel(Parcel var1) {
            return new StaggeredGridLayoutManager.SavedState(var1);
         }

         public StaggeredGridLayoutManager.SavedState[] newArray(int var1) {
            return new StaggeredGridLayoutManager.SavedState[var1];
         }
      };
      boolean mAnchorLayoutFromEnd;
      int mAnchorPosition;
      List<StaggeredGridLayoutManager.FullSpanItem> mFullSpanItems;
      boolean mLastLayoutRTL;
      boolean mReverseLayout;
      int[] mSpanLookup;
      int mSpanLookupSize;
      int[] mSpanOffsets;
      int mSpanOffsetsSize;
      int mVisibleAnchorPosition;

      public SavedState() {
      }

      SavedState(Parcel var1) {
         byte var2 = 1;
         super();
         this.mAnchorPosition = var1.readInt();
         this.mVisibleAnchorPosition = var1.readInt();
         this.mSpanOffsetsSize = var1.readInt();
         if(this.mSpanOffsetsSize > 0) {
            this.mSpanOffsets = new int[this.mSpanOffsetsSize];
            var1.readIntArray(this.mSpanOffsets);
         }

         this.mSpanLookupSize = var1.readInt();
         if(this.mSpanLookupSize > 0) {
            this.mSpanLookup = new int[this.mSpanLookupSize];
            var1.readIntArray(this.mSpanLookup);
         }

         byte var3;
         if(var1.readInt() == var2) {
            var3 = var2;
         } else {
            var3 = 0;
         }

         this.mReverseLayout = (boolean)var3;
         byte var4;
         if(var1.readInt() == var2) {
            var4 = var2;
         } else {
            var4 = 0;
         }

         this.mAnchorLayoutFromEnd = (boolean)var4;
         if(var1.readInt() != var2) {
            var2 = 0;
         }

         this.mLastLayoutRTL = (boolean)var2;
         this.mFullSpanItems = var1.readArrayList(StaggeredGridLayoutManager.FullSpanItem.class.getClassLoader());
      }

      public SavedState(StaggeredGridLayoutManager.SavedState var1) {
         this.mSpanOffsetsSize = var1.mSpanOffsetsSize;
         this.mAnchorPosition = var1.mAnchorPosition;
         this.mVisibleAnchorPosition = var1.mVisibleAnchorPosition;
         this.mSpanOffsets = var1.mSpanOffsets;
         this.mSpanLookupSize = var1.mSpanLookupSize;
         this.mSpanLookup = var1.mSpanLookup;
         this.mReverseLayout = var1.mReverseLayout;
         this.mAnchorLayoutFromEnd = var1.mAnchorLayoutFromEnd;
         this.mLastLayoutRTL = var1.mLastLayoutRTL;
         this.mFullSpanItems = var1.mFullSpanItems;
      }

      public int describeContents() {
         return 0;
      }

      void invalidateAnchorPositionInfo() {
         this.mSpanOffsets = null;
         this.mSpanOffsetsSize = 0;
         this.mAnchorPosition = -1;
         this.mVisibleAnchorPosition = -1;
      }

      void invalidateSpanInfo() {
         this.mSpanOffsets = null;
         this.mSpanOffsetsSize = 0;
         this.mSpanLookupSize = 0;
         this.mSpanLookup = null;
         this.mFullSpanItems = null;
      }

      public void writeToParcel(Parcel var1, int var2) {
         byte var3 = 1;
         var1.writeInt(this.mAnchorPosition);
         var1.writeInt(this.mVisibleAnchorPosition);
         var1.writeInt(this.mSpanOffsetsSize);
         if(this.mSpanOffsetsSize > 0) {
            var1.writeIntArray(this.mSpanOffsets);
         }

         var1.writeInt(this.mSpanLookupSize);
         if(this.mSpanLookupSize > 0) {
            var1.writeIntArray(this.mSpanLookup);
         }

         byte var4;
         if(this.mReverseLayout) {
            var4 = var3;
         } else {
            var4 = 0;
         }

         var1.writeInt(var4);
         byte var5;
         if(this.mAnchorLayoutFromEnd) {
            var5 = var3;
         } else {
            var5 = 0;
         }

         var1.writeInt(var5);
         if(!this.mLastLayoutRTL) {
            var3 = 0;
         }

         var1.writeInt(var3);
         var1.writeList(this.mFullSpanItems);
      }
   }

   class Span {
      static final int INVALID_LINE = Integer.MIN_VALUE;
      int mCachedEnd;
      int mCachedStart;
      int mDeletedSize;
      final int mIndex;
      private ArrayList<View> mViews;

      private Span(int var2) {
         this.mViews = new ArrayList();
         this.mCachedStart = Integer.MIN_VALUE;
         this.mCachedEnd = Integer.MIN_VALUE;
         this.mDeletedSize = 0;
         this.mIndex = var2;
      }

      // $FF: synthetic method
      Span(int var2, Object var3) {
         this();
      }

      void appendToSpan(View var1) {
         StaggeredGridLayoutManager.LayoutParams var2 = this.getLayoutParams(var1);
         var2.mSpan = this;
         this.mViews.add(var1);
         this.mCachedEnd = Integer.MIN_VALUE;
         if(this.mViews.size() == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
         }

         if(var2.isItemRemoved() || var2.isItemChanged()) {
            this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(var1);
         }

      }

      void cacheReferenceLineAndClear(boolean var1, int var2) {
         int var3;
         if(var1) {
            var3 = this.getEndLine(Integer.MIN_VALUE);
         } else {
            var3 = this.getStartLine(Integer.MIN_VALUE);
         }

         this.clear();
         if(var3 != Integer.MIN_VALUE && (!var1 || var3 >= StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) && (var1 || var3 <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding())) {
            if(var2 != Integer.MIN_VALUE) {
               var3 += var2;
            }

            this.mCachedEnd = var3;
            this.mCachedStart = var3;
         }
      }

      void calculateCachedEnd() {
         View var1 = (View)this.mViews.get(-1 + this.mViews.size());
         StaggeredGridLayoutManager.LayoutParams var2 = this.getLayoutParams(var1);
         this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(var1);
         if(var2.mFullSpan) {
            StaggeredGridLayoutManager.FullSpanItem var3 = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(var2.getViewLayoutPosition());
            if(var3 != null && var3.mGapDir == 1) {
               this.mCachedEnd += var3.getGapForSpan(this.mIndex);
            }
         }

      }

      void calculateCachedStart() {
         View var1 = (View)this.mViews.get(0);
         StaggeredGridLayoutManager.LayoutParams var2 = this.getLayoutParams(var1);
         this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(var1);
         if(var2.mFullSpan) {
            StaggeredGridLayoutManager.FullSpanItem var3 = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(var2.getViewLayoutPosition());
            if(var3 != null && var3.mGapDir == -1) {
               this.mCachedStart -= var3.getGapForSpan(this.mIndex);
            }
         }

      }

      void clear() {
         this.mViews.clear();
         this.invalidateCache();
         this.mDeletedSize = 0;
      }

      public int findFirstCompletelyVisibleItemPosition() {
         return StaggeredGridLayoutManager.this.mReverseLayout?this.findOneVisibleChild(-1 + this.mViews.size(), -1, true):this.findOneVisibleChild(0, this.mViews.size(), true);
      }

      public int findFirstVisibleItemPosition() {
         return StaggeredGridLayoutManager.this.mReverseLayout?this.findOneVisibleChild(-1 + this.mViews.size(), -1, false):this.findOneVisibleChild(0, this.mViews.size(), false);
      }

      public int findLastCompletelyVisibleItemPosition() {
         return StaggeredGridLayoutManager.this.mReverseLayout?this.findOneVisibleChild(0, this.mViews.size(), true):this.findOneVisibleChild(-1 + this.mViews.size(), -1, true);
      }

      public int findLastVisibleItemPosition() {
         return StaggeredGridLayoutManager.this.mReverseLayout?this.findOneVisibleChild(0, this.mViews.size(), false):this.findOneVisibleChild(-1 + this.mViews.size(), -1, false);
      }

      int findOneVisibleChild(int var1, int var2, boolean var3) {
         int var4 = -1;
         int var5 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
         int var6 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
         int var7;
         if(var2 > var1) {
            var7 = 1;
         } else {
            var7 = var4;
         }

         for(int var8 = var1; var8 != var2; var8 += var7) {
            View var9 = (View)this.mViews.get(var8);
            int var10 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(var9);
            int var11 = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(var9);
            if(var10 < var6 && var11 > var5) {
               if(!var3) {
                  return StaggeredGridLayoutManager.this.getPosition(var9);
               }

               if(var10 >= var5 && var11 <= var6) {
                  var4 = StaggeredGridLayoutManager.this.getPosition(var9);
                  break;
               }
            }
         }

         return var4;
      }

      public int getDeletedSize() {
         return this.mDeletedSize;
      }

      int getEndLine() {
         if(this.mCachedEnd != Integer.MIN_VALUE) {
            return this.mCachedEnd;
         } else {
            this.calculateCachedEnd();
            return this.mCachedEnd;
         }
      }

      int getEndLine(int var1) {
         if(this.mCachedEnd != Integer.MIN_VALUE) {
            var1 = this.mCachedEnd;
         } else if(this.mViews.size() != 0) {
            this.calculateCachedEnd();
            return this.mCachedEnd;
         }

         return var1;
      }

      public View getFocusableViewAfter(int var1, int var2) {
         View var3 = null;
         if(var2 == -1) {
            int var8 = this.mViews.size();

            for(int var9 = 0; var9 < var8; ++var9) {
               View var10 = (View)this.mViews.get(var9);
               if(!var10.isFocusable()) {
                  break;
               }

               boolean var11;
               if(StaggeredGridLayoutManager.this.getPosition(var10) > var1) {
                  var11 = true;
               } else {
                  var11 = false;
               }

               if(var11 != StaggeredGridLayoutManager.this.mReverseLayout) {
                  break;
               }

               var3 = var10;
            }
         } else {
            for(int var4 = -1 + this.mViews.size(); var4 >= 0; --var4) {
               View var5 = (View)this.mViews.get(var4);
               if(!var5.isFocusable()) {
                  break;
               }

               boolean var6;
               if(StaggeredGridLayoutManager.this.getPosition(var5) > var1) {
                  var6 = true;
               } else {
                  var6 = false;
               }

               boolean var7;
               if(!StaggeredGridLayoutManager.this.mReverseLayout) {
                  var7 = true;
               } else {
                  var7 = false;
               }

               if(var6 != var7) {
                  break;
               }

               var3 = var5;
            }
         }

         return var3;
      }

      StaggeredGridLayoutManager.LayoutParams getLayoutParams(View var1) {
         return (StaggeredGridLayoutManager.LayoutParams)var1.getLayoutParams();
      }

      int getStartLine() {
         if(this.mCachedStart != Integer.MIN_VALUE) {
            return this.mCachedStart;
         } else {
            this.calculateCachedStart();
            return this.mCachedStart;
         }
      }

      int getStartLine(int var1) {
         if(this.mCachedStart != Integer.MIN_VALUE) {
            var1 = this.mCachedStart;
         } else if(this.mViews.size() != 0) {
            this.calculateCachedStart();
            return this.mCachedStart;
         }

         return var1;
      }

      void invalidateCache() {
         this.mCachedStart = Integer.MIN_VALUE;
         this.mCachedEnd = Integer.MIN_VALUE;
      }

      void onOffset(int var1) {
         if(this.mCachedStart != Integer.MIN_VALUE) {
            this.mCachedStart += var1;
         }

         if(this.mCachedEnd != Integer.MIN_VALUE) {
            this.mCachedEnd += var1;
         }

      }

      void popEnd() {
         int var1 = this.mViews.size();
         View var2 = (View)this.mViews.remove(var1 - 1);
         StaggeredGridLayoutManager.LayoutParams var3 = this.getLayoutParams(var2);
         var3.mSpan = null;
         if(var3.isItemRemoved() || var3.isItemChanged()) {
            this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(var2);
         }

         if(var1 == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
         }

         this.mCachedEnd = Integer.MIN_VALUE;
      }

      void popStart() {
         View var1 = (View)this.mViews.remove(0);
         StaggeredGridLayoutManager.LayoutParams var2 = this.getLayoutParams(var1);
         var2.mSpan = null;
         if(this.mViews.size() == 0) {
            this.mCachedEnd = Integer.MIN_VALUE;
         }

         if(var2.isItemRemoved() || var2.isItemChanged()) {
            this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(var1);
         }

         this.mCachedStart = Integer.MIN_VALUE;
      }

      void prependToSpan(View var1) {
         StaggeredGridLayoutManager.LayoutParams var2 = this.getLayoutParams(var1);
         var2.mSpan = this;
         this.mViews.add(0, var1);
         this.mCachedStart = Integer.MIN_VALUE;
         if(this.mViews.size() == 1) {
            this.mCachedEnd = Integer.MIN_VALUE;
         }

         if(var2.isItemRemoved() || var2.isItemChanged()) {
            this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(var1);
         }

      }

      void setLine(int var1) {
         this.mCachedStart = var1;
         this.mCachedEnd = var1;
      }
   }
}
