package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
   private static final boolean DEBUG = false;
   public static final int DEFAULT_SPAN_COUNT = -1;
   private static final String TAG = "GridLayoutManager";
   int[] mCachedBorders;
   final Rect mDecorInsets = new Rect();
   boolean mPendingSpanCountChange = false;
   final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
   final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
   View[] mSet;
   int mSpanCount = -1;
   GridLayoutManager.SpanSizeLookup mSpanSizeLookup = new GridLayoutManager.DefaultSpanSizeLookup();

   public GridLayoutManager(Context var1, int var2) {
      super(var1);
      this.setSpanCount(var2);
   }

   public GridLayoutManager(Context var1, int var2, int var3, boolean var4) {
      super(var1, var3, var4);
      this.setSpanCount(var2);
   }

   public GridLayoutManager(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.setSpanCount(getProperties(var1, var2, var3, var4).spanCount);
   }

   private void assignSpans(RecyclerView.Recycler var1, RecyclerView.State var2, int var3, int var4, boolean var5) {
      int var6;
      int var7;
      byte var8;
      if(var5) {
         var6 = 0;
         var7 = var3;
         var8 = 1;
      } else {
         var6 = var3 - 1;
         var7 = -1;
         var8 = -1;
      }

      byte var9;
      int var10;
      if(this.mOrientation == 1 && this.isLayoutRTL()) {
         var10 = -1 + this.mSpanCount;
         var9 = -1;
      } else {
         var9 = 1;
         var10 = 0;
      }

      for(int var11 = var6; var11 != var7; var11 += var8) {
         View var12 = this.mSet[var11];
         GridLayoutManager.LayoutParams var13 = (GridLayoutManager.LayoutParams)var12.getLayoutParams();
         var13.mSpanSize = this.getSpanSize(var1, var2, this.getPosition(var12));
         if(var9 == -1 && var13.mSpanSize > 1) {
            var13.mSpanIndex = var10 - (-1 + var13.mSpanSize);
         } else {
            var13.mSpanIndex = var10;
         }

         var10 += var9 * var13.mSpanSize;
      }

   }

   private void cachePreLayoutSpanMapping() {
      int var1 = this.getChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         GridLayoutManager.LayoutParams var3 = (GridLayoutManager.LayoutParams)this.getChildAt(var2).getLayoutParams();
         int var4 = var3.getViewLayoutPosition();
         this.mPreLayoutSpanSizeCache.put(var4, var3.getSpanSize());
         this.mPreLayoutSpanIndexCache.put(var4, var3.getSpanIndex());
      }

   }

   private void calculateItemBorders(int var1) {
      this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, var1);
   }

   static int[] calculateItemBorders(int[] var0, int var1, int var2) {
      if(var0 == null || var0.length != var1 + 1 || var0[-1 + var0.length] != var2) {
         var0 = new int[var1 + 1];
      }

      var0[0] = 0;
      int var3 = var2 / var1;
      int var4 = var2 % var1;
      int var5 = 0;
      int var6 = 0;

      for(int var7 = 1; var7 <= var1; ++var7) {
         int var8 = var3;
         var6 += var4;
         if(var6 > 0 && var1 - var6 < var4) {
            var8 = var3 + 1;
            var6 -= var1;
         }

         var5 += var8;
         var0[var7] = var5;
      }

      return var0;
   }

   private void clearPreLayoutSpanMappingCache() {
      this.mPreLayoutSpanSizeCache.clear();
      this.mPreLayoutSpanIndexCache.clear();
   }

   private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3, int var4) {
      byte var5 = 1;
      if(var4 != var5) {
         var5 = 0;
      }

      int var6 = this.getSpanIndex(var1, var2, var3.mPosition);
      if(var5 != 0) {
         while(var6 > 0 && var3.mPosition > 0) {
            var3.mPosition += -1;
            var6 = this.getSpanIndex(var1, var2, var3.mPosition);
         }
      } else {
         int var7 = -1 + var2.getItemCount();
         int var8 = var3.mPosition;

         int var10;
         for(int var9 = var6; var8 < var7; var9 = var10) {
            var10 = this.getSpanIndex(var1, var2, var8 + 1);
            if(var10 <= var9) {
               break;
            }

            ++var8;
         }

         var3.mPosition = var8;
      }

   }

   private void ensureViewSet() {
      if(this.mSet == null || this.mSet.length != this.mSpanCount) {
         this.mSet = new View[this.mSpanCount];
      }

   }

   private int getSpanGroupIndex(RecyclerView.Recycler var1, RecyclerView.State var2, int var3) {
      if(!var2.isPreLayout()) {
         return this.mSpanSizeLookup.getSpanGroupIndex(var3, this.mSpanCount);
      } else {
         int var4 = var1.convertPreLayoutPositionToPostLayout(var3);
         if(var4 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + var3);
            return 0;
         } else {
            return this.mSpanSizeLookup.getSpanGroupIndex(var4, this.mSpanCount);
         }
      }
   }

   private int getSpanIndex(RecyclerView.Recycler var1, RecyclerView.State var2, int var3) {
      int var4;
      if(!var2.isPreLayout()) {
         var4 = this.mSpanSizeLookup.getCachedSpanIndex(var3, this.mSpanCount);
      } else {
         var4 = this.mPreLayoutSpanIndexCache.get(var3, -1);
         if(var4 == -1) {
            int var5 = var1.convertPreLayoutPositionToPostLayout(var3);
            if(var5 == -1) {
               Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + var3);
               return 0;
            }

            return this.mSpanSizeLookup.getCachedSpanIndex(var5, this.mSpanCount);
         }
      }

      return var4;
   }

   private int getSpanSize(RecyclerView.Recycler var1, RecyclerView.State var2, int var3) {
      int var4;
      if(!var2.isPreLayout()) {
         var4 = this.mSpanSizeLookup.getSpanSize(var3);
      } else {
         var4 = this.mPreLayoutSpanSizeCache.get(var3, -1);
         if(var4 == -1) {
            int var5 = var1.convertPreLayoutPositionToPostLayout(var3);
            if(var5 == -1) {
               Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + var3);
               return 1;
            }

            return this.mSpanSizeLookup.getSpanSize(var5);
         }
      }

      return var4;
   }

   private void guessMeasurement(float var1, int var2) {
      this.calculateItemBorders(Math.max(Math.round(var1 * (float)this.mSpanCount), var2));
   }

   private void measureChildWithDecorationsAndMargin(View var1, int var2, int var3, boolean var4, boolean var5) {
      this.calculateItemDecorationsForChild(var1, this.mDecorInsets);
      RecyclerView.LayoutParams var6 = (RecyclerView.LayoutParams)var1.getLayoutParams();
      if(var4 || this.mOrientation == 1) {
         var2 = this.updateSpecWithExtra(var2, var6.leftMargin + this.mDecorInsets.left, var6.rightMargin + this.mDecorInsets.right);
      }

      if(var4 || this.mOrientation == 0) {
         var3 = this.updateSpecWithExtra(var3, var6.topMargin + this.mDecorInsets.top, var6.bottomMargin + this.mDecorInsets.bottom);
      }

      boolean var7;
      if(var5) {
         var7 = this.shouldReMeasureChild(var1, var2, var3, var6);
      } else {
         var7 = this.shouldMeasureChild(var1, var2, var3, var6);
      }

      if(var7) {
         var1.measure(var2, var3);
      }

   }

   private void updateMeasurements() {
      int var1;
      if(this.getOrientation() == 1) {
         var1 = this.getWidth() - this.getPaddingRight() - this.getPaddingLeft();
      } else {
         var1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
      }

      this.calculateItemBorders(var1);
   }

   private int updateSpecWithExtra(int var1, int var2, int var3) {
      if(var2 != 0 || var3 != 0) {
         int var4 = MeasureSpec.getMode(var1);
         if(var4 == Integer.MIN_VALUE || var4 == 1073741824) {
            return MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(var1) - var2 - var3, var4);
         }
      }

      return var1;
   }

   public boolean checkLayoutParams(RecyclerView.LayoutParams var1) {
      return var1 instanceof GridLayoutManager.LayoutParams;
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
         if(var13 >= 0 && var13 < var5 && this.getSpanIndex(var1, var2, var13) == 0) {
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

   public RecyclerView.LayoutParams generateDefaultLayoutParams() {
      return this.mOrientation == 0?new GridLayoutManager.LayoutParams(-2, -1):new GridLayoutManager.LayoutParams(-1, -2);
   }

   public RecyclerView.LayoutParams generateLayoutParams(Context var1, AttributeSet var2) {
      return new GridLayoutManager.LayoutParams(var1, var2);
   }

   public RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof MarginLayoutParams?new GridLayoutManager.LayoutParams((MarginLayoutParams)var1):new GridLayoutManager.LayoutParams(var1);
   }

   public int getColumnCountForAccessibility(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.mOrientation == 1?this.mSpanCount:(var2.getItemCount() < 1?0:1 + this.getSpanGroupIndex(var1, var2, -1 + var2.getItemCount()));
   }

   public int getRowCountForAccessibility(RecyclerView.Recycler var1, RecyclerView.State var2) {
      return this.mOrientation == 0?this.mSpanCount:(var2.getItemCount() < 1?0:1 + this.getSpanGroupIndex(var1, var2, -1 + var2.getItemCount()));
   }

   public int getSpanCount() {
      return this.mSpanCount;
   }

   public GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
      return this.mSpanSizeLookup;
   }

   void layoutChunk(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.LayoutState var3, LinearLayoutManager.LayoutChunkResult var4) {
      int var5 = this.mOrientationHelper.getModeInOther();
      boolean var6;
      if(var5 != 1073741824) {
         var6 = true;
      } else {
         var6 = false;
      }

      int var7;
      if(this.getChildCount() > 0) {
         var7 = this.mCachedBorders[this.mSpanCount];
      } else {
         var7 = 0;
      }

      if(var6) {
         this.updateMeasurements();
      }

      boolean var8;
      if(var3.mItemDirection == 1) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var9 = this.mSpanCount;
      int var10 = 0;
      int var11 = 0;
      if(!var8) {
         var9 = this.getSpanIndex(var1, var2, var3.mCurrentPosition) + this.getSpanSize(var1, var2, var3.mCurrentPosition);
      }

      while(var10 < this.mSpanCount && var3.hasMore(var2) && var9 > 0) {
         int var51 = var3.mCurrentPosition;
         int var52 = this.getSpanSize(var1, var2, var51);
         if(var52 > this.mSpanCount) {
            throw new IllegalArgumentException("Item at position " + var51 + " requires " + var52 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
         }

         var9 -= var52;
         if(var9 < 0) {
            break;
         }

         View var53 = var3.next(var1);
         if(var53 == null) {
            break;
         }

         var11 += var52;
         this.mSet[var10] = var53;
         ++var10;
      }

      if(var10 == 0) {
         var4.mFinished = true;
      } else {
         int var12 = 0;
         float var13 = 0.0F;
         this.assignSpans(var1, var2, var10, var11, var8);

         for(int var14 = 0; var14 < var10; ++var14) {
            View var40 = this.mSet[var14];
            if(var3.mScrapList == null) {
               if(var8) {
                  this.addView(var40);
               } else {
                  this.addView(var40, 0);
               }
            } else if(var8) {
               this.addDisappearingView(var40);
            } else {
               this.addDisappearingView(var40, 0);
            }

            GridLayoutManager.LayoutParams var41 = (GridLayoutManager.LayoutParams)var40.getLayoutParams();
            int var42 = this.mCachedBorders[var41.mSpanIndex + var41.mSpanSize] - this.mCachedBorders[var41.mSpanIndex];
            int var43;
            if(this.mOrientation == 0) {
               var43 = var41.height;
            } else {
               var43 = var41.width;
            }

            int var44 = getChildMeasureSpec(var42, var5, 0, var43, false);
            int var45 = this.mOrientationHelper.getTotalSpace();
            int var46 = this.mOrientationHelper.getMode();
            int var47;
            if(this.mOrientation == 1) {
               var47 = var41.height;
            } else {
               var47 = var41.width;
            }

            int var48 = getChildMeasureSpec(var45, var46, 0, var47, true);
            if(this.mOrientation == 1) {
               this.measureChildWithDecorationsAndMargin(var40, var44, var48, false, false);
            } else {
               this.measureChildWithDecorationsAndMargin(var40, var48, var44, false, false);
            }

            int var49 = this.mOrientationHelper.getDecoratedMeasurement(var40);
            if(var49 > var12) {
               var12 = var49;
            }

            float var50 = 1.0F * (float)this.mOrientationHelper.getDecoratedMeasurementInOther(var40) / (float)var41.mSpanSize;
            if(var50 > var13) {
               var13 = var50;
            }
         }

         if(var6) {
            this.guessMeasurement(var13, var7);
            var12 = 0;

            for(int var29 = 0; var29 < var10; ++var29) {
               View var30 = this.mSet[var29];
               GridLayoutManager.LayoutParams var31 = (GridLayoutManager.LayoutParams)var30.getLayoutParams();
               int var32 = this.mCachedBorders[var31.mSpanIndex + var31.mSpanSize] - this.mCachedBorders[var31.mSpanIndex];
               int var33;
               if(this.mOrientation == 0) {
                  var33 = var31.height;
               } else {
                  var33 = var31.width;
               }

               int var34 = getChildMeasureSpec(var32, 1073741824, 0, var33, false);
               int var35 = this.mOrientationHelper.getTotalSpace();
               int var36 = this.mOrientationHelper.getMode();
               int var37;
               if(this.mOrientation == 1) {
                  var37 = var31.height;
               } else {
                  var37 = var31.width;
               }

               int var38 = getChildMeasureSpec(var35, var36, 0, var37, true);
               if(this.mOrientation == 1) {
                  this.measureChildWithDecorationsAndMargin(var30, var34, var38, false, true);
               } else {
                  this.measureChildWithDecorationsAndMargin(var30, var38, var34, false, true);
               }

               int var39 = this.mOrientationHelper.getDecoratedMeasurement(var30);
               if(var39 > var12) {
                  var12 = var39;
               }
            }
         }

         int var15 = MeasureSpec.makeMeasureSpec(var12, 1073741824);

         for(int var16 = 0; var16 < var10; ++var16) {
            View var24 = this.mSet[var16];
            if(this.mOrientationHelper.getDecoratedMeasurement(var24) != var12) {
               GridLayoutManager.LayoutParams var25 = (GridLayoutManager.LayoutParams)var24.getLayoutParams();
               int var26 = this.mCachedBorders[var25.mSpanIndex + var25.mSpanSize] - this.mCachedBorders[var25.mSpanIndex];
               int var27;
               if(this.mOrientation == 0) {
                  var27 = var25.height;
               } else {
                  var27 = var25.width;
               }

               int var28 = getChildMeasureSpec(var26, 1073741824, 0, var27, false);
               if(this.mOrientation == 1) {
                  this.measureChildWithDecorationsAndMargin(var24, var28, var15, true, true);
               } else {
                  this.measureChildWithDecorationsAndMargin(var24, var15, var28, true, true);
               }
            }
         }

         var4.mConsumed = var12;
         int var17 = 0;
         int var18 = 0;
         int var19;
         int var20;
         if(this.mOrientation == 1) {
            if(var3.mLayoutDirection == -1) {
               var19 = var3.mOffset;
               var20 = var19 - var12;
            } else {
               var20 = var3.mOffset;
               var19 = var20 + var12;
               var17 = 0;
               var18 = 0;
            }
         } else if(var3.mLayoutDirection == -1) {
            var18 = var3.mOffset;
            var17 = var18 - var12;
            var19 = 0;
            var20 = 0;
         } else {
            var17 = var3.mOffset;
            var18 = var17 + var12;
            var19 = 0;
            var20 = 0;
         }

         for(int var21 = 0; var21 < var10; ++var21) {
            View var22 = this.mSet[var21];
            GridLayoutManager.LayoutParams var23 = (GridLayoutManager.LayoutParams)var22.getLayoutParams();
            if(this.mOrientation == 1) {
               if(this.isLayoutRTL()) {
                  var18 = this.getPaddingLeft() + this.mCachedBorders[var23.mSpanIndex + var23.mSpanSize];
                  var17 = var18 - this.mOrientationHelper.getDecoratedMeasurementInOther(var22);
               } else {
                  var17 = this.getPaddingLeft() + this.mCachedBorders[var23.mSpanIndex];
                  var18 = var17 + this.mOrientationHelper.getDecoratedMeasurementInOther(var22);
               }
            } else {
               var20 = this.getPaddingTop() + this.mCachedBorders[var23.mSpanIndex];
               var19 = var20 + this.mOrientationHelper.getDecoratedMeasurementInOther(var22);
            }

            this.layoutDecorated(var22, var17 + var23.leftMargin, var20 + var23.topMargin, var18 - var23.rightMargin, var19 - var23.bottomMargin);
            if(var23.isItemRemoved() || var23.isItemChanged()) {
               var4.mIgnoreConsumed = true;
            }

            var4.mFocusable |= var22.isFocusable();
         }

         Arrays.fill(this.mSet, (Object)null);
      }
   }

   void onAnchorReady(RecyclerView.Recycler var1, RecyclerView.State var2, LinearLayoutManager.AnchorInfo var3, int var4) {
      super.onAnchorReady(var1, var2, var3, var4);
      this.updateMeasurements();
      if(var2.getItemCount() > 0 && !var2.isPreLayout()) {
         this.ensureAnchorIsInCorrectSpan(var1, var2, var3, var4);
      }

      this.ensureViewSet();
   }

   public View onFocusSearchFailed(View var1, int var2, RecyclerView.Recycler var3, RecyclerView.State var4) {
      View var5 = this.findContainingItemView(var1);
      View var20;
      if(var5 == null) {
         var20 = null;
      } else {
         GridLayoutManager.LayoutParams var6 = (GridLayoutManager.LayoutParams)var5.getLayoutParams();
         int var7 = var6.mSpanIndex;
         int var8 = var6.mSpanIndex + var6.mSpanSize;
         if(super.onFocusSearchFailed(var1, var2, var3, var4) == null) {
            return null;
         }

         boolean var9;
         if(this.convertFocusDirectionToLayoutDirection(var2) == 1) {
            var9 = true;
         } else {
            var9 = false;
         }

         boolean var10 = this.mShouldReverseLayout;
         boolean var11;
         if(var9 != var10) {
            var11 = true;
         } else {
            var11 = false;
         }

         byte var12;
         int var13;
         int var14;
         if(var11) {
            var14 = -1 + this.getChildCount();
            var12 = -1;
            var13 = -1;
         } else {
            var12 = 1;
            var13 = this.getChildCount();
            var14 = 0;
         }

         boolean var15;
         if(this.mOrientation == 1 && this.isLayoutRTL()) {
            var15 = true;
         } else {
            var15 = false;
         }

         View var16 = null;
         int var17 = -1;
         int var18 = 0;
         int var19 = var14;

         while(true) {
            if(var19 == var13) {
               return var16;
            }

            var20 = this.getChildAt(var19);
            if(var20 == var5) {
               return var16;
            }

            if(var20.isFocusable()) {
               GridLayoutManager.LayoutParams var21 = (GridLayoutManager.LayoutParams)var20.getLayoutParams();
               int var22 = var21.mSpanIndex;
               int var23 = var21.mSpanIndex + var21.mSpanSize;
               if(var22 == var7 && var23 == var8) {
                  break;
               }

               boolean var27;
               if(var16 == null) {
                  var27 = true;
               } else {
                  int var24 = Math.max(var22, var7);
                  int var25 = Math.min(var23, var8) - var24;
                  if(var25 > var18) {
                     var27 = true;
                  } else {
                     var27 = false;
                     if(var25 == var18) {
                        boolean var28;
                        if(var22 > var17) {
                           var28 = true;
                        } else {
                           var28 = false;
                        }

                        var27 = false;
                        if(var15 == var28) {
                           var27 = true;
                        }
                     }
                  }
               }

               if(var27) {
                  var16 = var20;
                  var17 = var21.mSpanIndex;
                  var18 = Math.min(var23, var8) - Math.max(var22, var7);
               }
            }

            var19 += var12;
         }
      }

      return var20;
   }

   public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler var1, RecyclerView.State var2, View var3, AccessibilityNodeInfoCompat var4) {
      android.view.ViewGroup.LayoutParams var5 = var3.getLayoutParams();
      if(!(var5 instanceof GridLayoutManager.LayoutParams)) {
         super.onInitializeAccessibilityNodeInfoForItem(var3, var4);
      } else {
         GridLayoutManager.LayoutParams var6 = (GridLayoutManager.LayoutParams)var5;
         int var7 = this.getSpanGroupIndex(var1, var2, var6.getViewLayoutPosition());
         if(this.mOrientation == 0) {
            int var11 = var6.getSpanIndex();
            int var12 = var6.getSpanSize();
            boolean var13;
            if(this.mSpanCount > 1 && var6.getSpanSize() == this.mSpanCount) {
               var13 = true;
            } else {
               var13 = false;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(var11, var12, var7, 1, var13, false));
         } else {
            int var8 = var6.getSpanIndex();
            int var9 = var6.getSpanSize();
            boolean var10;
            if(this.mSpanCount > 1 && var6.getSpanSize() == this.mSpanCount) {
               var10 = true;
            } else {
               var10 = false;
            }

            var4.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(var7, 1, var8, var9, var10, false));
         }
      }
   }

   public void onItemsAdded(RecyclerView var1, int var2, int var3) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsChanged(RecyclerView var1) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsMoved(RecyclerView var1, int var2, int var3, int var4) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsRemoved(RecyclerView var1, int var2, int var3) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onItemsUpdated(RecyclerView var1, int var2, int var3, Object var4) {
      this.mSpanSizeLookup.invalidateSpanIndexCache();
   }

   public void onLayoutChildren(RecyclerView.Recycler var1, RecyclerView.State var2) {
      if(var2.isPreLayout()) {
         this.cachePreLayoutSpanMapping();
      }

      super.onLayoutChildren(var1, var2);
      this.clearPreLayoutSpanMappingCache();
      if(!var2.isPreLayout()) {
         this.mPendingSpanCountChange = false;
      }

   }

   public int scrollHorizontallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      this.updateMeasurements();
      this.ensureViewSet();
      return super.scrollHorizontallyBy(var1, var2, var3);
   }

   public int scrollVerticallyBy(int var1, RecyclerView.Recycler var2, RecyclerView.State var3) {
      this.updateMeasurements();
      this.ensureViewSet();
      return super.scrollVerticallyBy(var1, var2, var3);
   }

   public void setMeasuredDimension(Rect var1, int var2, int var3) {
      if(this.mCachedBorders == null) {
         super.setMeasuredDimension(var1, var2, var3);
      }

      int var4 = this.getPaddingLeft() + this.getPaddingRight();
      int var5 = this.getPaddingTop() + this.getPaddingBottom();
      int var6;
      int var7;
      if(this.mOrientation == 1) {
         var7 = chooseSize(var3, var5 + var1.height(), this.getMinimumHeight());
         var6 = chooseSize(var2, var4 + this.mCachedBorders[-1 + this.mCachedBorders.length], this.getMinimumWidth());
      } else {
         var6 = chooseSize(var2, var4 + var1.width(), this.getMinimumWidth());
         var7 = chooseSize(var3, var5 + this.mCachedBorders[-1 + this.mCachedBorders.length], this.getMinimumHeight());
      }

      this.setMeasuredDimension(var6, var7);
   }

   public void setSpanCount(int var1) {
      if(var1 != this.mSpanCount) {
         this.mPendingSpanCountChange = true;
         if(var1 < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + var1);
         } else {
            this.mSpanCount = var1;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
         }
      }
   }

   public void setSpanSizeLookup(GridLayoutManager.SpanSizeLookup var1) {
      this.mSpanSizeLookup = var1;
   }

   public void setStackFromEnd(boolean var1) {
      if(var1) {
         throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
      } else {
         super.setStackFromEnd(false);
      }
   }

   public boolean supportsPredictiveItemAnimations() {
      return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
   }

   public static final class DefaultSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
      public int getSpanIndex(int var1, int var2) {
         return var1 % var2;
      }

      public int getSpanSize(int var1) {
         return 1;
      }
   }

   public static class LayoutParams extends RecyclerView.LayoutParams {
      public static final int INVALID_SPAN_ID = -1;
      private int mSpanIndex = -1;
      private int mSpanSize = 0;

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

      public int getSpanIndex() {
         return this.mSpanIndex;
      }

      public int getSpanSize() {
         return this.mSpanSize;
      }
   }

   public abstract static class SpanSizeLookup {
      private boolean mCacheSpanIndices = false;
      final SparseIntArray mSpanIndexCache = new SparseIntArray();

      int findReferenceIndexFromCache(int var1) {
         int var2 = 0;
         int var3 = -1 + this.mSpanIndexCache.size();

         while(var2 <= var3) {
            int var5 = var2 + var3 >>> 1;
            if(this.mSpanIndexCache.keyAt(var5) < var1) {
               var2 = var5 + 1;
            } else {
               var3 = var5 - 1;
            }
         }

         int var4 = var2 - 1;
         if(var4 >= 0 && var4 < this.mSpanIndexCache.size()) {
            return this.mSpanIndexCache.keyAt(var4);
         } else {
            return -1;
         }
      }

      int getCachedSpanIndex(int var1, int var2) {
         int var3;
         if(!this.mCacheSpanIndices) {
            var3 = this.getSpanIndex(var1, var2);
         } else {
            var3 = this.mSpanIndexCache.get(var1, -1);
            if(var3 == -1) {
               int var4 = this.getSpanIndex(var1, var2);
               this.mSpanIndexCache.put(var1, var4);
               return var4;
            }
         }

         return var3;
      }

      public int getSpanGroupIndex(int var1, int var2) {
         int var3 = 0;
         int var4 = 0;
         int var5 = this.getSpanSize(var1);

         for(int var6 = 0; var6 < var1; ++var6) {
            int var7 = this.getSpanSize(var6);
            var3 += var7;
            if(var3 == var2) {
               var3 = 0;
               ++var4;
            } else if(var3 > var2) {
               var3 = var7;
               ++var4;
            }
         }

         if(var3 + var5 > var2) {
            ++var4;
         }

         return var4;
      }

      public int getSpanIndex(int var1, int var2) {
         int var3 = this.getSpanSize(var1);
         int var5;
         if(var3 == var2) {
            var5 = 0;
         } else {
            boolean var4 = this.mCacheSpanIndices;
            var5 = 0;
            int var6 = 0;
            if(var4) {
               int var9 = this.mSpanIndexCache.size();
               var5 = 0;
               var6 = 0;
               if(var9 > 0) {
                  int var10 = this.findReferenceIndexFromCache(var1);
                  var5 = 0;
                  var6 = 0;
                  if(var10 >= 0) {
                     var5 = this.mSpanIndexCache.get(var10) + this.getSpanSize(var10);
                     var6 = var10 + 1;
                  }
               }
            }

            for(int var7 = var6; var7 < var1; ++var7) {
               int var8 = this.getSpanSize(var7);
               var5 += var8;
               if(var5 == var2) {
                  var5 = 0;
               } else if(var5 > var2) {
                  var5 = var8;
               }
            }

            if(var5 + var3 > var2) {
               return 0;
            }
         }

         return var5;
      }

      public abstract int getSpanSize(int var1);

      public void invalidateSpanIndexCache() {
         this.mSpanIndexCache.clear();
      }

      public boolean isSpanIndexCacheEnabled() {
         return this.mCacheSpanIndices;
      }

      public void setSpanIndexCacheEnabled(boolean var1) {
         this.mCacheSpanIndices = var1;
      }
   }
}
