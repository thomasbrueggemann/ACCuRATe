package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.Resources.NotFoundException;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
   private static final int CLOSE_ENOUGH = 2;
   private static final Comparator<ViewPager.ItemInfo> COMPARATOR = new Comparator() {
      public int compare(ViewPager.ItemInfo var1, ViewPager.ItemInfo var2) {
         return var1.position - var2.position;
      }
   };
   private static final boolean DEBUG = false;
   private static final int DEFAULT_GUTTER_SIZE = 16;
   private static final int DEFAULT_OFFSCREEN_PAGES = 1;
   private static final int DRAW_ORDER_DEFAULT = 0;
   private static final int DRAW_ORDER_FORWARD = 1;
   private static final int DRAW_ORDER_REVERSE = 2;
   private static final int INVALID_POINTER = -1;
   private static final int[] LAYOUT_ATTRS = new int[]{16842931};
   private static final int MAX_SETTLE_DURATION = 600;
   private static final int MIN_DISTANCE_FOR_FLING = 25;
   private static final int MIN_FLING_VELOCITY = 400;
   public static final int SCROLL_STATE_DRAGGING = 1;
   public static final int SCROLL_STATE_IDLE = 0;
   public static final int SCROLL_STATE_SETTLING = 2;
   private static final String TAG = "ViewPager";
   private static final boolean USE_CACHE;
   private static final Interpolator sInterpolator = new Interpolator() {
      public float getInterpolation(float var1) {
         float var2 = var1 - 1.0F;
         return 1.0F + var2 * var2 * var2 * var2 * var2;
      }
   };
   private static final ViewPager.ViewPositionComparator sPositionComparator = new ViewPager.ViewPositionComparator();
   private int mActivePointerId = -1;
   private PagerAdapter mAdapter;
   private ViewPager.OnAdapterChangeListener mAdapterChangeListener;
   private int mBottomPageBounds;
   private boolean mCalledSuper;
   private int mChildHeightMeasureSpec;
   private int mChildWidthMeasureSpec;
   private int mCloseEnough;
   private int mCurItem;
   private int mDecorChildCount;
   private int mDefaultGutterSize;
   private int mDrawingOrder;
   private ArrayList<View> mDrawingOrderedChildren;
   private final Runnable mEndScrollRunnable = new Runnable() {
      public void run() {
         ViewPager.this.setScrollState(0);
         ViewPager.this.populate();
      }
   };
   private int mExpectedAdapterCount;
   private long mFakeDragBeginTime;
   private boolean mFakeDragging;
   private boolean mFirstLayout = true;
   private float mFirstOffset = -3.4028235E38F;
   private int mFlingDistance;
   private int mGutterSize;
   private boolean mInLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private ViewPager.OnPageChangeListener mInternalPageChangeListener;
   private boolean mIsBeingDragged;
   private boolean mIsScrollStarted;
   private boolean mIsUnableToDrag;
   private final ArrayList<ViewPager.ItemInfo> mItems = new ArrayList();
   private float mLastMotionX;
   private float mLastMotionY;
   private float mLastOffset = Float.MAX_VALUE;
   private EdgeEffectCompat mLeftEdge;
   private Drawable mMarginDrawable;
   private int mMaximumVelocity;
   private int mMinimumVelocity;
   private boolean mNeedCalculatePageOffsets = false;
   private ViewPager.PagerObserver mObserver;
   private int mOffscreenPageLimit = 1;
   private ViewPager.OnPageChangeListener mOnPageChangeListener;
   private List<ViewPager.OnPageChangeListener> mOnPageChangeListeners;
   private int mPageMargin;
   private ViewPager.PageTransformer mPageTransformer;
   private boolean mPopulatePending;
   private Parcelable mRestoredAdapterState = null;
   private ClassLoader mRestoredClassLoader = null;
   private int mRestoredCurItem = -1;
   private EdgeEffectCompat mRightEdge;
   private int mScrollState = 0;
   private Scroller mScroller;
   private boolean mScrollingCacheEnabled;
   private Method mSetChildrenDrawingOrderEnabled;
   private final ViewPager.ItemInfo mTempItem = new ViewPager.ItemInfo();
   private final Rect mTempRect = new Rect();
   private int mTopPageBounds;
   private int mTouchSlop;
   private VelocityTracker mVelocityTracker;

   public ViewPager(Context var1) {
      super(var1);
      this.initViewPager();
   }

   public ViewPager(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initViewPager();
   }

   private void calculatePageOffsets(ViewPager.ItemInfo var1, int var2, ViewPager.ItemInfo var3) {
      int var4 = this.mAdapter.getCount();
      int var5 = this.getClientWidth();
      float var6;
      if(var5 > 0) {
         var6 = (float)this.mPageMargin / (float)var5;
      } else {
         var6 = 0.0F;
      }

      if(var3 != null) {
         int var22 = var3.position;
         if(var22 < var1.position) {
            int var27 = 0;
            float var28 = var6 + var3.offset + var3.widthFactor;

            for(int var29 = var22 + 1; var29 <= var1.position && var27 < this.mItems.size(); ++var29) {
               ViewPager.ItemInfo var30;
               for(var30 = (ViewPager.ItemInfo)this.mItems.get(var27); var29 > var30.position && var27 < -1 + this.mItems.size(); var30 = (ViewPager.ItemInfo)this.mItems.get(var27)) {
                  ++var27;
               }

               while(var29 < var30.position) {
                  var28 += var6 + this.mAdapter.getPageWidth(var29);
                  ++var29;
               }

               var30.offset = var28;
               var28 += var6 + var30.widthFactor;
            }
         } else if(var22 > var1.position) {
            int var23 = -1 + this.mItems.size();
            float var24 = var3.offset;

            for(int var25 = var22 - 1; var25 >= var1.position && var23 >= 0; --var25) {
               ViewPager.ItemInfo var26;
               for(var26 = (ViewPager.ItemInfo)this.mItems.get(var23); var25 < var26.position && var23 > 0; var26 = (ViewPager.ItemInfo)this.mItems.get(var23)) {
                  --var23;
               }

               while(var25 > var26.position) {
                  var24 -= var6 + this.mAdapter.getPageWidth(var25);
                  --var25;
               }

               var24 -= var6 + var26.widthFactor;
               var26.offset = var24;
            }
         }
      }

      int var7 = this.mItems.size();
      float var8 = var1.offset;
      int var9 = -1 + var1.position;
      float var10;
      if(var1.position == 0) {
         var10 = var1.offset;
      } else {
         var10 = -3.4028235E38F;
      }

      this.mFirstOffset = var10;
      float var11;
      if(var1.position == var4 - 1) {
         var11 = var1.offset + var1.widthFactor - 1.0F;
      } else {
         var11 = Float.MAX_VALUE;
      }

      this.mLastOffset = var11;

      for(int var12 = var2 - 1; var12 >= 0; --var9) {
         ViewPager.ItemInfo var19;
         int var21;
         for(var19 = (ViewPager.ItemInfo)this.mItems.get(var12); var9 > var19.position; var9 = var21) {
            PagerAdapter var20 = this.mAdapter;
            var21 = var9 - 1;
            var8 -= var6 + var20.getPageWidth(var9);
         }

         var8 -= var6 + var19.widthFactor;
         var19.offset = var8;
         if(var19.position == 0) {
            this.mFirstOffset = var8;
         }

         --var12;
      }

      float var13 = var6 + var1.offset + var1.widthFactor;
      int var14 = 1 + var1.position;

      for(int var15 = var2 + 1; var15 < var7; ++var14) {
         ViewPager.ItemInfo var16;
         int var18;
         for(var16 = (ViewPager.ItemInfo)this.mItems.get(var15); var14 < var16.position; var14 = var18) {
            PagerAdapter var17 = this.mAdapter;
            var18 = var14 + 1;
            var13 += var6 + var17.getPageWidth(var14);
         }

         if(var16.position == var4 - 1) {
            this.mLastOffset = var13 + var16.widthFactor - 1.0F;
         }

         var16.offset = var13;
         var13 += var6 + var16.widthFactor;
         ++var15;
      }

      this.mNeedCalculatePageOffsets = false;
   }

   private void completeScroll(boolean var1) {
      boolean var2 = true;
      boolean var3;
      if(this.mScrollState == 2) {
         var3 = var2;
      } else {
         var3 = false;
      }

      if(var3) {
         this.setScrollingCacheEnabled(false);
         if(this.mScroller.isFinished()) {
            var2 = false;
         }

         if(var2) {
            this.mScroller.abortAnimation();
            int var6 = this.getScrollX();
            int var7 = this.getScrollY();
            int var8 = this.mScroller.getCurrX();
            int var9 = this.mScroller.getCurrY();
            if(var6 != var8 || var7 != var9) {
               this.scrollTo(var8, var9);
               if(var8 != var6) {
                  this.pageScrolled(var8);
               }
            }
         }
      }

      this.mPopulatePending = false;

      for(int var4 = 0; var4 < this.mItems.size(); ++var4) {
         ViewPager.ItemInfo var5 = (ViewPager.ItemInfo)this.mItems.get(var4);
         if(var5.scrolling) {
            var3 = true;
            var5.scrolling = false;
         }
      }

      if(var3) {
         if(!var1) {
            this.mEndScrollRunnable.run();
            return;
         }

         ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
      }

   }

   private int determineTargetPage(int var1, float var2, int var3, int var4) {
      int var6;
      if(Math.abs(var4) > this.mFlingDistance && Math.abs(var3) > this.mMinimumVelocity) {
         if(var3 > 0) {
            var6 = var1;
         } else {
            var6 = var1 + 1;
         }
      } else {
         float var5;
         if(var1 >= this.mCurItem) {
            var5 = 0.4F;
         } else {
            var5 = 0.6F;
         }

         var6 = (int)(var5 + var2 + (float)var1);
      }

      if(this.mItems.size() > 0) {
         ViewPager.ItemInfo var7 = (ViewPager.ItemInfo)this.mItems.get(0);
         ViewPager.ItemInfo var8 = (ViewPager.ItemInfo)this.mItems.get(-1 + this.mItems.size());
         var6 = Math.max(var7.position, Math.min(var6, var8.position));
      }

      return var6;
   }

   private void dispatchOnPageScrolled(int var1, float var2, int var3) {
      if(this.mOnPageChangeListener != null) {
         this.mOnPageChangeListener.onPageScrolled(var1, var2, var3);
      }

      if(this.mOnPageChangeListeners != null) {
         int var4 = 0;

         for(int var5 = this.mOnPageChangeListeners.size(); var4 < var5; ++var4) {
            ViewPager.OnPageChangeListener var6 = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(var4);
            if(var6 != null) {
               var6.onPageScrolled(var1, var2, var3);
            }
         }
      }

      if(this.mInternalPageChangeListener != null) {
         this.mInternalPageChangeListener.onPageScrolled(var1, var2, var3);
      }

   }

   private void dispatchOnPageSelected(int var1) {
      if(this.mOnPageChangeListener != null) {
         this.mOnPageChangeListener.onPageSelected(var1);
      }

      if(this.mOnPageChangeListeners != null) {
         int var2 = 0;

         for(int var3 = this.mOnPageChangeListeners.size(); var2 < var3; ++var2) {
            ViewPager.OnPageChangeListener var4 = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(var2);
            if(var4 != null) {
               var4.onPageSelected(var1);
            }
         }
      }

      if(this.mInternalPageChangeListener != null) {
         this.mInternalPageChangeListener.onPageSelected(var1);
      }

   }

   private void dispatchOnScrollStateChanged(int var1) {
      if(this.mOnPageChangeListener != null) {
         this.mOnPageChangeListener.onPageScrollStateChanged(var1);
      }

      if(this.mOnPageChangeListeners != null) {
         int var2 = 0;

         for(int var3 = this.mOnPageChangeListeners.size(); var2 < var3; ++var2) {
            ViewPager.OnPageChangeListener var4 = (ViewPager.OnPageChangeListener)this.mOnPageChangeListeners.get(var2);
            if(var4 != null) {
               var4.onPageScrollStateChanged(var1);
            }
         }
      }

      if(this.mInternalPageChangeListener != null) {
         this.mInternalPageChangeListener.onPageScrollStateChanged(var1);
      }

   }

   private void enableLayers(boolean var1) {
      int var2 = this.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         byte var4;
         if(var1) {
            var4 = 2;
         } else {
            var4 = 0;
         }

         ViewCompat.setLayerType(this.getChildAt(var3), var4, (Paint)null);
      }

   }

   private void endDrag() {
      this.mIsBeingDragged = false;
      this.mIsUnableToDrag = false;
      if(this.mVelocityTracker != null) {
         this.mVelocityTracker.recycle();
         this.mVelocityTracker = null;
      }

   }

   private Rect getChildRectInPagerCoordinates(Rect var1, View var2) {
      if(var1 == null) {
         var1 = new Rect();
      }

      if(var2 == null) {
         var1.set(0, 0, 0, 0);
      } else {
         var1.left = var2.getLeft();
         var1.right = var2.getRight();
         var1.top = var2.getTop();
         var1.bottom = var2.getBottom();

         ViewGroup var4;
         for(ViewParent var3 = var2.getParent(); var3 instanceof ViewGroup && var3 != this; var3 = var4.getParent()) {
            var4 = (ViewGroup)var3;
            var1.left += var4.getLeft();
            var1.right += var4.getRight();
            var1.top += var4.getTop();
            var1.bottom += var4.getBottom();
         }
      }

      return var1;
   }

   private int getClientWidth() {
      return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
   }

   private ViewPager.ItemInfo infoForCurrentScrollPosition() {
      int var1 = this.getClientWidth();
      float var2;
      if(var1 > 0) {
         var2 = (float)this.getScrollX() / (float)var1;
      } else {
         var2 = 0.0F;
      }

      float var3 = 0.0F;
      if(var1 > 0) {
         var3 = (float)this.mPageMargin / (float)var1;
      }

      int var4 = -1;
      float var5 = 0.0F;
      float var6 = 0.0F;
      boolean var7 = true;
      ViewPager.ItemInfo var8 = null;

      for(int var9 = 0; var9 < this.mItems.size(); var7 = false) {
         ViewPager.ItemInfo var10 = (ViewPager.ItemInfo)this.mItems.get(var9);
         if(!var7 && var10.position != var4 + 1) {
            var10 = this.mTempItem;
            var10.offset = var3 + var5 + var6;
            var10.position = var4 + 1;
            var10.widthFactor = this.mAdapter.getPageWidth(var10.position);
            --var9;
         }

         float var11 = var10.offset;
         float var12 = var3 + var11 + var10.widthFactor;
         if(!var7 && var2 < var11) {
            break;
         }

         if(var2 < var12 || var9 == -1 + this.mItems.size()) {
            var8 = var10;
            break;
         }

         var4 = var10.position;
         var5 = var11;
         var6 = var10.widthFactor;
         var8 = var10;
         ++var9;
      }

      return var8;
   }

   private boolean isGutterDrag(float var1, float var2) {
      return var1 < (float)this.mGutterSize && var2 > 0.0F || var1 > (float)(this.getWidth() - this.mGutterSize) && var2 < 0.0F;
   }

   private void onSecondaryPointerUp(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionIndex(var1);
      if(MotionEventCompat.getPointerId(var1, var2) == this.mActivePointerId) {
         byte var3;
         if(var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.mLastMotionX = MotionEventCompat.getX(var1, var3);
         this.mActivePointerId = MotionEventCompat.getPointerId(var1, var3);
         if(this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
         }
      }

   }

   private boolean pageScrolled(int var1) {
      boolean var9;
      if(this.mItems.size() == 0) {
         this.mCalledSuper = false;
         this.onPageScrolled(0, 0.0F, 0);
         boolean var10 = this.mCalledSuper;
         var9 = false;
         if(!var10) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
         }
      } else {
         ViewPager.ItemInfo var2 = this.infoForCurrentScrollPosition();
         int var3 = this.getClientWidth();
         int var4 = var3 + this.mPageMargin;
         float var5 = (float)this.mPageMargin / (float)var3;
         int var6 = var2.position;
         float var7 = ((float)var1 / (float)var3 - var2.offset) / (var5 + var2.widthFactor);
         int var8 = (int)(var7 * (float)var4);
         this.mCalledSuper = false;
         this.onPageScrolled(var6, var7, var8);
         if(!this.mCalledSuper) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
         }

         var9 = true;
      }

      return var9;
   }

   private boolean performDrag(float var1) {
      float var2 = this.mLastMotionX - var1;
      this.mLastMotionX = var1;
      float var3 = var2 + (float)this.getScrollX();
      int var4 = this.getClientWidth();
      float var5 = (float)var4 * this.mFirstOffset;
      float var6 = (float)var4 * this.mLastOffset;
      boolean var7 = true;
      boolean var8 = true;
      ViewPager.ItemInfo var9 = (ViewPager.ItemInfo)this.mItems.get(0);
      ViewPager.ItemInfo var10 = (ViewPager.ItemInfo)this.mItems.get(-1 + this.mItems.size());
      if(var9.position != 0) {
         var7 = false;
         var5 = var9.offset * (float)var4;
      }

      if(var10.position != -1 + this.mAdapter.getCount()) {
         var8 = false;
         var6 = var10.offset * (float)var4;
      }

      boolean var11;
      if(var3 < var5) {
         var11 = false;
         if(var7) {
            float var13 = var5 - var3;
            var11 = this.mLeftEdge.onPull(Math.abs(var13) / (float)var4);
         }

         var3 = var5;
      } else {
         float var16;
         int var14 = (var16 = var3 - var6) == 0.0F?0:(var16 < 0.0F?-1:1);
         var11 = false;
         if(var14 > 0) {
            var11 = false;
            if(var8) {
               float var15 = var3 - var6;
               var11 = this.mRightEdge.onPull(Math.abs(var15) / (float)var4);
            }

            var3 = var6;
         }
      }

      this.mLastMotionX += var3 - (float)((int)var3);
      this.scrollTo((int)var3, this.getScrollY());
      this.pageScrolled((int)var3);
      return var11;
   }

   private void recomputeScrollPosition(int var1, int var2, int var3, int var4) {
      if(var2 > 0 && !this.mItems.isEmpty()) {
         this.scrollToItem(this.mCurItem, false, 0, false);
      } else {
         ViewPager.ItemInfo var5 = this.infoForPosition(this.mCurItem);
         float var6;
         if(var5 != null) {
            var6 = Math.min(var5.offset, this.mLastOffset);
         } else {
            var6 = 0.0F;
         }

         int var7 = (int)(var6 * (float)(var1 - this.getPaddingLeft() - this.getPaddingRight()));
         if(var7 != this.getScrollX()) {
            this.completeScroll(false);
            this.scrollTo(var7, this.getScrollY());
            return;
         }
      }

   }

   private void removeNonDecorViews() {
      for(int var1 = 0; var1 < this.getChildCount(); ++var1) {
         if(!((ViewPager.LayoutParams)this.getChildAt(var1).getLayoutParams()).isDecor) {
            this.removeViewAt(var1);
            --var1;
         }
      }

   }

   private void requestParentDisallowInterceptTouchEvent(boolean var1) {
      ViewParent var2 = this.getParent();
      if(var2 != null) {
         var2.requestDisallowInterceptTouchEvent(var1);
      }

   }

   private boolean resetTouch() {
      this.mActivePointerId = -1;
      this.endDrag();
      return this.mLeftEdge.onRelease() | this.mRightEdge.onRelease();
   }

   private void scrollToItem(int var1, boolean var2, int var3, boolean var4) {
      ViewPager.ItemInfo var5 = this.infoForPosition(var1);
      int var6 = 0;
      if(var5 != null) {
         var6 = (int)((float)this.getClientWidth() * Math.max(this.mFirstOffset, Math.min(var5.offset, this.mLastOffset)));
      }

      if(var2) {
         this.smoothScrollTo(var6, 0, var3);
         if(var4) {
            this.dispatchOnPageSelected(var1);
         }

      } else {
         if(var4) {
            this.dispatchOnPageSelected(var1);
         }

         this.completeScroll(false);
         this.scrollTo(var6, 0);
         this.pageScrolled(var6);
      }
   }

   private void setScrollState(int var1) {
      if(this.mScrollState != var1) {
         this.mScrollState = var1;
         if(this.mPageTransformer != null) {
            boolean var2;
            if(var1 != 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.enableLayers(var2);
         }

         this.dispatchOnScrollStateChanged(var1);
      }
   }

   private void setScrollingCacheEnabled(boolean var1) {
      if(this.mScrollingCacheEnabled != var1) {
         this.mScrollingCacheEnabled = var1;
      }

   }

   private void sortChildDrawingOrder() {
      if(this.mDrawingOrder != 0) {
         if(this.mDrawingOrderedChildren == null) {
            this.mDrawingOrderedChildren = new ArrayList();
         } else {
            this.mDrawingOrderedChildren.clear();
         }

         int var1 = this.getChildCount();

         for(int var2 = 0; var2 < var1; ++var2) {
            View var3 = this.getChildAt(var2);
            this.mDrawingOrderedChildren.add(var3);
         }

         Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
      }

   }

   public void addFocusables(ArrayList<View> var1, int var2, int var3) {
      int var4 = var1.size();
      int var5 = this.getDescendantFocusability();
      if(var5 != 393216) {
         for(int var7 = 0; var7 < this.getChildCount(); ++var7) {
            View var8 = this.getChildAt(var7);
            if(var8.getVisibility() == 0) {
               ViewPager.ItemInfo var9 = this.infoForChild(var8);
               if(var9 != null && var9.position == this.mCurItem) {
                  var8.addFocusables(var1, var2, var3);
               }
            }
         }
      }

      if((var5 != 262144 || var4 == var1.size()) && this.isFocusable() && ((var3 & 1) != 1 || !this.isInTouchMode() || this.isFocusableInTouchMode()) && var1 != null) {
         var1.add(this);
      }
   }

   ViewPager.ItemInfo addNewItem(int var1, int var2) {
      ViewPager.ItemInfo var3 = new ViewPager.ItemInfo();
      var3.position = var1;
      var3.object = this.mAdapter.instantiateItem((ViewGroup)this, var1);
      var3.widthFactor = this.mAdapter.getPageWidth(var1);
      if(var2 >= 0 && var2 < this.mItems.size()) {
         this.mItems.add(var2, var3);
         return var3;
      } else {
         this.mItems.add(var3);
         return var3;
      }
   }

   public void addOnPageChangeListener(ViewPager.OnPageChangeListener var1) {
      if(this.mOnPageChangeListeners == null) {
         this.mOnPageChangeListeners = new ArrayList();
      }

      this.mOnPageChangeListeners.add(var1);
   }

   public void addTouchables(ArrayList<View> var1) {
      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         View var3 = this.getChildAt(var2);
         if(var3.getVisibility() == 0) {
            ViewPager.ItemInfo var4 = this.infoForChild(var3);
            if(var4 != null && var4.position == this.mCurItem) {
               var3.addTouchables(var1);
            }
         }
      }

   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      if(!this.checkLayoutParams(var3)) {
         var3 = this.generateLayoutParams(var3);
      }

      ViewPager.LayoutParams var4 = (ViewPager.LayoutParams)var3;
      var4.isDecor |= var1 instanceof ViewPager.Decor;
      if(this.mInLayout) {
         if(var4 != null && var4.isDecor) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
         } else {
            var4.needsMeasure = true;
            this.addViewInLayout(var1, var2, var3);
         }
      } else {
         super.addView(var1, var2, var3);
      }
   }

   public boolean arrowScroll(int var1) {
      View var2 = this.findFocus();
      if(var2 == this) {
         var2 = null;
      } else if(var2 != null) {
         ViewParent var3 = var2.getParent();

         boolean var5;
         while(true) {
            boolean var4 = var3 instanceof ViewGroup;
            var5 = false;
            if(!var4) {
               break;
            }

            if(var3 == this) {
               var5 = true;
               break;
            }

            var3 = var3.getParent();
         }

         if(!var5) {
            StringBuilder var6 = new StringBuilder();
            var6.append(var2.getClass().getSimpleName());

            for(ViewParent var8 = var2.getParent(); var8 instanceof ViewGroup; var8 = var8.getParent()) {
               var6.append(" => ").append(var8.getClass().getSimpleName());
            }

            Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + var6.toString());
            var2 = null;
         }
      }

      View var10 = FocusFinder.getInstance().findNextFocus(this, var2, var1);
      boolean var11;
      if(var10 != null && var10 != var2) {
         if(var1 == 17) {
            int var14 = this.getChildRectInPagerCoordinates(this.mTempRect, var10).left;
            int var15 = this.getChildRectInPagerCoordinates(this.mTempRect, var2).left;
            if(var2 != null && var14 >= var15) {
               var11 = this.pageLeft();
            } else {
               var11 = var10.requestFocus();
            }
         } else {
            var11 = false;
            if(var1 == 66) {
               int var12 = this.getChildRectInPagerCoordinates(this.mTempRect, var10).left;
               int var13 = this.getChildRectInPagerCoordinates(this.mTempRect, var2).left;
               if(var2 != null && var12 <= var13) {
                  var11 = this.pageRight();
               } else {
                  var11 = var10.requestFocus();
               }
            }
         }
      } else if(var1 != 17 && var1 != 1) {
         label43: {
            if(var1 != 66) {
               var11 = false;
               if(var1 != 2) {
                  break label43;
               }
            }

            var11 = this.pageRight();
         }
      } else {
         var11 = this.pageLeft();
      }

      if(var11) {
         this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(var1));
      }

      return var11;
   }

   public boolean beginFakeDrag() {
      if(this.mIsBeingDragged) {
         return false;
      } else {
         this.mFakeDragging = true;
         this.setScrollState(1);
         this.mLastMotionX = 0.0F;
         this.mInitialMotionX = 0.0F;
         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         } else {
            this.mVelocityTracker.clear();
         }

         long var1 = SystemClock.uptimeMillis();
         MotionEvent var3 = MotionEvent.obtain(var1, var1, 0, 0.0F, 0.0F, 0);
         this.mVelocityTracker.addMovement(var3);
         var3.recycle();
         this.mFakeDragBeginTime = var1;
         return true;
      }
   }

   protected boolean canScroll(View var1, boolean var2, int var3, int var4, int var5) {
      if(var1 instanceof ViewGroup) {
         ViewGroup var6 = (ViewGroup)var1;
         int var7 = var1.getScrollX();
         int var8 = var1.getScrollY();

         for(int var9 = -1 + var6.getChildCount(); var9 >= 0; --var9) {
            View var10 = var6.getChildAt(var9);
            if(var4 + var7 >= var10.getLeft() && var4 + var7 < var10.getRight() && var5 + var8 >= var10.getTop() && var5 + var8 < var10.getBottom() && this.canScroll(var10, true, var3, var4 + var7 - var10.getLeft(), var5 + var8 - var10.getTop())) {
               return true;
            }
         }
      }

      return var2 && ViewCompat.canScrollHorizontally(var1, -var3);
   }

   public boolean canScrollHorizontally(int var1) {
      boolean var2 = true;
      if(this.mAdapter != null) {
         int var3 = this.getClientWidth();
         int var4 = this.getScrollX();
         if(var1 < 0) {
            if(var4 <= (int)((float)var3 * this.mFirstOffset)) {
               var2 = false;
            }

            return var2;
         }

         if(var1 > 0) {
            if(var4 >= (int)((float)var3 * this.mLastOffset)) {
               var2 = false;
            }

            return var2;
         }
      }

      return false;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof ViewPager.LayoutParams && super.checkLayoutParams(var1);
   }

   public void clearOnPageChangeListeners() {
      if(this.mOnPageChangeListeners != null) {
         this.mOnPageChangeListeners.clear();
      }

   }

   public void computeScroll() {
      this.mIsScrollStarted = true;
      if(!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
         int var1 = this.getScrollX();
         int var2 = this.getScrollY();
         int var3 = this.mScroller.getCurrX();
         int var4 = this.mScroller.getCurrY();
         if(var1 != var3 || var2 != var4) {
            this.scrollTo(var3, var4);
            if(!this.pageScrolled(var3)) {
               this.mScroller.abortAnimation();
               this.scrollTo(0, var4);
            }
         }

         ViewCompat.postInvalidateOnAnimation(this);
      } else {
         this.completeScroll(true);
      }
   }

   void dataSetChanged() {
      int var1 = this.mAdapter.getCount();
      this.mExpectedAdapterCount = var1;
      boolean var2;
      if(this.mItems.size() < 1 + 2 * this.mOffscreenPageLimit && this.mItems.size() < var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      int var3 = this.mCurItem;
      boolean var4 = false;

      for(int var5 = 0; var5 < this.mItems.size(); ++var5) {
         ViewPager.ItemInfo var9 = (ViewPager.ItemInfo)this.mItems.get(var5);
         int var10 = this.mAdapter.getItemPosition(var9.object);
         if(var10 != -1) {
            if(var10 == -2) {
               this.mItems.remove(var5);
               --var5;
               if(!var4) {
                  this.mAdapter.startUpdate((ViewGroup)this);
                  var4 = true;
               }

               this.mAdapter.destroyItem((ViewGroup)this, var9.position, var9.object);
               var2 = true;
               if(this.mCurItem == var9.position) {
                  var3 = Math.max(0, Math.min(this.mCurItem, var1 - 1));
                  var2 = true;
               }
            } else if(var9.position != var10) {
               if(var9.position == this.mCurItem) {
                  var3 = var10;
               }

               var9.position = var10;
               var2 = true;
            }
         }
      }

      if(var4) {
         this.mAdapter.finishUpdate((ViewGroup)this);
      }

      Collections.sort(this.mItems, COMPARATOR);
      if(var2) {
         int var6 = this.getChildCount();

         for(int var7 = 0; var7 < var6; ++var7) {
            ViewPager.LayoutParams var8 = (ViewPager.LayoutParams)this.getChildAt(var7).getLayoutParams();
            if(!var8.isDecor) {
               var8.widthFactor = 0.0F;
            }
         }

         this.setCurrentItemInternal(var3, false, true);
         this.requestLayout();
      }

   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      return super.dispatchKeyEvent(var1) || this.executeKeyEvent(var1);
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      if(var1.getEventType() == 4096) {
         return super.dispatchPopulateAccessibilityEvent(var1);
      } else {
         int var2 = this.getChildCount();

         for(int var3 = 0; var3 < var2; ++var3) {
            View var4 = this.getChildAt(var3);
            if(var4.getVisibility() == 0) {
               ViewPager.ItemInfo var5 = this.infoForChild(var4);
               if(var5 != null && var5.position == this.mCurItem && var4.dispatchPopulateAccessibilityEvent(var1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   float distanceInfluenceForSnapDuration(float var1) {
      return (float)Math.sin((double)((float)(0.4712389167638204D * (double)(var1 - 0.5F))));
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      int var2 = ViewCompat.getOverScrollMode(this);
      boolean var4;
      if(var2 != 0 && (var2 != 1 || this.mAdapter == null || this.mAdapter.getCount() <= 1)) {
         this.mLeftEdge.finish();
         this.mRightEdge.finish();
         var4 = false;
      } else {
         boolean var3 = this.mLeftEdge.isFinished();
         var4 = false;
         if(!var3) {
            int var8 = var1.save();
            int var9 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            int var10 = this.getWidth();
            var1.rotate(270.0F);
            var1.translate((float)(-var9 + this.getPaddingTop()), this.mFirstOffset * (float)var10);
            this.mLeftEdge.setSize(var9, var10);
            var4 = false | this.mLeftEdge.draw(var1);
            var1.restoreToCount(var8);
         }

         if(!this.mRightEdge.isFinished()) {
            int var5 = var1.save();
            int var6 = this.getWidth();
            int var7 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            var1.rotate(90.0F);
            var1.translate((float)(-this.getPaddingTop()), -(1.0F + this.mLastOffset) * (float)var6);
            this.mRightEdge.setSize(var7, var6);
            var4 |= this.mRightEdge.draw(var1);
            var1.restoreToCount(var5);
         }
      }

      if(var4) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      Drawable var1 = this.mMarginDrawable;
      if(var1 != null && var1.isStateful()) {
         var1.setState(this.getDrawableState());
      }

   }

   public void endFakeDrag() {
      if(!this.mFakeDragging) {
         throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      } else {
         if(this.mAdapter != null) {
            VelocityTracker var1 = this.mVelocityTracker;
            var1.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
            int var2 = (int)VelocityTrackerCompat.getXVelocity(var1, this.mActivePointerId);
            this.mPopulatePending = true;
            int var3 = this.getClientWidth();
            int var4 = this.getScrollX();
            ViewPager.ItemInfo var5 = this.infoForCurrentScrollPosition();
            this.setCurrentItemInternal(this.determineTargetPage(var5.position, ((float)var4 / (float)var3 - var5.offset) / var5.widthFactor, var2, (int)(this.mLastMotionX - this.mInitialMotionX)), true, true, var2);
         }

         this.endDrag();
         this.mFakeDragging = false;
      }
   }

   public boolean executeKeyEvent(KeyEvent var1) {
      if(var1.getAction() == 0) {
         switch(var1.getKeyCode()) {
         case 21:
            return this.arrowScroll(17);
         case 22:
            return this.arrowScroll(66);
         case 61:
            if(VERSION.SDK_INT >= 11) {
               if(KeyEventCompat.hasNoModifiers(var1)) {
                  return this.arrowScroll(2);
               }

               if(KeyEventCompat.hasModifiers(var1, 1)) {
                  return this.arrowScroll(1);
               }
            }
         }
      }

      return false;
   }

   public void fakeDragBy(float var1) {
      if(!this.mFakeDragging) {
         throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
      } else if(this.mAdapter != null) {
         this.mLastMotionX += var1;
         float var2 = (float)this.getScrollX() - var1;
         int var3 = this.getClientWidth();
         float var4 = (float)var3 * this.mFirstOffset;
         float var5 = (float)var3 * this.mLastOffset;
         ViewPager.ItemInfo var6 = (ViewPager.ItemInfo)this.mItems.get(0);
         ViewPager.ItemInfo var7 = (ViewPager.ItemInfo)this.mItems.get(-1 + this.mItems.size());
         if(var6.position != 0) {
            var4 = var6.offset * (float)var3;
         }

         if(var7.position != -1 + this.mAdapter.getCount()) {
            var5 = var7.offset * (float)var3;
         }

         if(var2 < var4) {
            var2 = var4;
         } else if(var2 > var5) {
            var2 = var5;
         }

         this.mLastMotionX += var2 - (float)((int)var2);
         this.scrollTo((int)var2, this.getScrollY());
         this.pageScrolled((int)var2);
         long var9 = SystemClock.uptimeMillis();
         MotionEvent var11 = MotionEvent.obtain(this.mFakeDragBeginTime, var9, 2, this.mLastMotionX, 0.0F, 0);
         this.mVelocityTracker.addMovement(var11);
         var11.recycle();
      }
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      return new ViewPager.LayoutParams();
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new ViewPager.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return this.generateDefaultLayoutParams();
   }

   public PagerAdapter getAdapter() {
      return this.mAdapter;
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      int var3;
      if(this.mDrawingOrder == 2) {
         var3 = var1 - 1 - var2;
      } else {
         var3 = var2;
      }

      return ((ViewPager.LayoutParams)((View)this.mDrawingOrderedChildren.get(var3)).getLayoutParams()).childIndex;
   }

   public int getCurrentItem() {
      return this.mCurItem;
   }

   public int getOffscreenPageLimit() {
      return this.mOffscreenPageLimit;
   }

   public int getPageMargin() {
      return this.mPageMargin;
   }

   ViewPager.ItemInfo infoForAnyChild(View var1) {
      while(true) {
         ViewParent var2 = var1.getParent();
         if(var2 != this) {
            if(var2 != null && var2 instanceof View) {
               var1 = (View)var2;
               continue;
            }

            return null;
         }

         return this.infoForChild(var1);
      }
   }

   ViewPager.ItemInfo infoForChild(View var1) {
      for(int var2 = 0; var2 < this.mItems.size(); ++var2) {
         ViewPager.ItemInfo var3 = (ViewPager.ItemInfo)this.mItems.get(var2);
         if(this.mAdapter.isViewFromObject(var1, var3.object)) {
            return var3;
         }
      }

      return null;
   }

   ViewPager.ItemInfo infoForPosition(int var1) {
      for(int var2 = 0; var2 < this.mItems.size(); ++var2) {
         ViewPager.ItemInfo var3 = (ViewPager.ItemInfo)this.mItems.get(var2);
         if(var3.position == var1) {
            return var3;
         }
      }

      return null;
   }

   void initViewPager() {
      this.setWillNotDraw(false);
      this.setDescendantFocusability(262144);
      this.setFocusable(true);
      Context var1 = this.getContext();
      this.mScroller = new Scroller(var1, sInterpolator);
      ViewConfiguration var2 = ViewConfiguration.get(var1);
      float var3 = var1.getResources().getDisplayMetrics().density;
      this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(var2);
      this.mMinimumVelocity = (int)(400.0F * var3);
      this.mMaximumVelocity = var2.getScaledMaximumFlingVelocity();
      this.mLeftEdge = new EdgeEffectCompat(var1);
      this.mRightEdge = new EdgeEffectCompat(var1);
      this.mFlingDistance = (int)(25.0F * var3);
      this.mCloseEnough = (int)(2.0F * var3);
      this.mDefaultGutterSize = (int)(16.0F * var3);
      ViewCompat.setAccessibilityDelegate(this, new ViewPager.MyAccessibilityDelegate());
      if(ViewCompat.getImportantForAccessibility(this) == 0) {
         ViewCompat.setImportantForAccessibility(this, 1);
      }

      ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
         private final Rect mTempRect = new Rect();

         public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
            WindowInsetsCompat var3 = ViewCompat.onApplyWindowInsets(var1, var2);
            if(var3.isConsumed()) {
               return var3;
            } else {
               Rect var4 = this.mTempRect;
               var4.left = var3.getSystemWindowInsetLeft();
               var4.top = var3.getSystemWindowInsetTop();
               var4.right = var3.getSystemWindowInsetRight();
               var4.bottom = var3.getSystemWindowInsetBottom();
               int var5 = 0;

               for(int var6 = ViewPager.this.getChildCount(); var5 < var6; ++var5) {
                  WindowInsetsCompat var7 = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(var5), var3);
                  var4.left = Math.min(var7.getSystemWindowInsetLeft(), var4.left);
                  var4.top = Math.min(var7.getSystemWindowInsetTop(), var4.top);
                  var4.right = Math.min(var7.getSystemWindowInsetRight(), var4.right);
                  var4.bottom = Math.min(var7.getSystemWindowInsetBottom(), var4.bottom);
               }

               return var3.replaceSystemWindowInsets(var4.left, var4.top, var4.right, var4.bottom);
            }
         }
      });
   }

   public boolean isFakeDragging() {
      return this.mFakeDragging;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mFirstLayout = true;
   }

   protected void onDetachedFromWindow() {
      this.removeCallbacks(this.mEndScrollRunnable);
      if(this.mScroller != null && !this.mScroller.isFinished()) {
         this.mScroller.abortAnimation();
      }

      super.onDetachedFromWindow();
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
         int var2 = this.getScrollX();
         int var3 = this.getWidth();
         float var4 = (float)this.mPageMargin / (float)var3;
         int var5 = 0;
         ViewPager.ItemInfo var6 = (ViewPager.ItemInfo)this.mItems.get(0);
         float var7 = var6.offset;
         int var8 = this.mItems.size();
         int var9 = var6.position;
         int var10 = ((ViewPager.ItemInfo)this.mItems.get(var8 - 1)).position;

         for(int var11 = var9; var11 < var10; ++var11) {
            while(var11 > var6.position && var5 < var8) {
               ArrayList var14 = this.mItems;
               ++var5;
               var6 = (ViewPager.ItemInfo)var14.get(var5);
            }

            float var13;
            if(var11 == var6.position) {
               var13 = (var6.offset + var6.widthFactor) * (float)var3;
               var7 = var4 + var6.offset + var6.widthFactor;
            } else {
               float var12 = this.mAdapter.getPageWidth(var11);
               var13 = (var7 + var12) * (float)var3;
               var7 += var12 + var4;
            }

            if(var13 + (float)this.mPageMargin > (float)var2) {
               this.mMarginDrawable.setBounds((int)var13, this.mTopPageBounds, (int)(0.5F + var13 + (float)this.mPageMargin), this.mBottomPageBounds);
               this.mMarginDrawable.draw(var1);
            }

            if(var13 > (float)(var2 + var3)) {
               break;
            }
         }
      }

   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var2 = 255 & var1.getAction();
      if(var2 != 3 && var2 != 1) {
         if(var2 != 0) {
            if(this.mIsBeingDragged) {
               return true;
            }

            if(this.mIsUnableToDrag) {
               return false;
            }
         }

         switch(var2) {
         case 0:
            float var4 = var1.getX();
            this.mInitialMotionX = var4;
            this.mLastMotionX = var4;
            float var5 = var1.getY();
            this.mInitialMotionY = var5;
            this.mLastMotionY = var5;
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if(this.mScrollState == 2 && Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) > this.mCloseEnough) {
               this.mScroller.abortAnimation();
               this.mPopulatePending = false;
               this.populate();
               this.mIsBeingDragged = true;
               this.requestParentDisallowInterceptTouchEvent(true);
               this.setScrollState(1);
            } else {
               this.completeScroll(false);
               this.mIsBeingDragged = false;
            }
            break;
         case 2:
            int var7 = this.mActivePointerId;
            if(var7 != -1) {
               int var8 = MotionEventCompat.findPointerIndex(var1, var7);
               float var9 = MotionEventCompat.getX(var1, var8);
               float var10 = var9 - this.mLastMotionX;
               float var11 = Math.abs(var10);
               float var12 = MotionEventCompat.getY(var1, var8);
               float var13 = Math.abs(var12 - this.mInitialMotionY);
               if(var10 != 0.0F && !this.isGutterDrag(this.mLastMotionX, var10) && this.canScroll(this, false, (int)var10, (int)var9, (int)var12)) {
                  this.mLastMotionX = var9;
                  this.mLastMotionY = var12;
                  this.mIsUnableToDrag = true;
                  return false;
               }

               if(var11 > (float)this.mTouchSlop && 0.5F * var11 > var13) {
                  this.mIsBeingDragged = true;
                  this.requestParentDisallowInterceptTouchEvent(true);
                  this.setScrollState(1);
                  float var14;
                  if(var10 > 0.0F) {
                     var14 = this.mInitialMotionX + (float)this.mTouchSlop;
                  } else {
                     var14 = this.mInitialMotionX - (float)this.mTouchSlop;
                  }

                  this.mLastMotionX = var14;
                  this.mLastMotionY = var12;
                  this.setScrollingCacheEnabled(true);
               } else if(var13 > (float)this.mTouchSlop) {
                  this.mIsUnableToDrag = true;
               }

               if(this.mIsBeingDragged && this.performDrag(var9)) {
                  ViewCompat.postInvalidateOnAnimation(this);
               }
            }
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
         }

         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         }

         this.mVelocityTracker.addMovement(var1);
         return this.mIsBeingDragged;
      } else {
         this.resetTouch();
         return false;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getChildCount();
      int var7 = var4 - var2;
      int var8 = var5 - var3;
      int var9 = this.getPaddingLeft();
      int var10 = this.getPaddingTop();
      int var11 = this.getPaddingRight();
      int var12 = this.getPaddingBottom();
      int var13 = this.getScrollX();
      int var14 = 0;

      for(int var15 = 0; var15 < var6; ++var15) {
         View var23 = this.getChildAt(var15);
         if(var23.getVisibility() != 8) {
            ViewPager.LayoutParams var24 = (ViewPager.LayoutParams)var23.getLayoutParams();
            if(var24.isDecor) {
               int var25 = 7 & var24.gravity;
               int var26 = 112 & var24.gravity;
               int var27;
               switch(var25) {
               case 1:
                  var27 = Math.max((var7 - var23.getMeasuredWidth()) / 2, var9);
                  break;
               case 2:
               case 4:
               default:
                  var27 = var9;
                  break;
               case 3:
                  var27 = var9;
                  var9 += var23.getMeasuredWidth();
                  break;
               case 5:
                  var27 = var7 - var11 - var23.getMeasuredWidth();
                  var11 += var23.getMeasuredWidth();
               }

               int var28;
               switch(var26) {
               case 16:
                  var28 = Math.max((var8 - var23.getMeasuredHeight()) / 2, var10);
                  break;
               case 48:
                  var28 = var10;
                  var10 += var23.getMeasuredHeight();
                  break;
               case 80:
                  var28 = var8 - var12 - var23.getMeasuredHeight();
                  var12 += var23.getMeasuredHeight();
                  break;
               default:
                  var28 = var10;
               }

               int var29 = var27 + var13;
               var23.layout(var29, var28, var29 + var23.getMeasuredWidth(), var28 + var23.getMeasuredHeight());
               ++var14;
            }
         }
      }

      int var16 = var7 - var9 - var11;

      for(int var17 = 0; var17 < var6; ++var17) {
         View var18 = this.getChildAt(var17);
         if(var18.getVisibility() != 8) {
            ViewPager.LayoutParams var19 = (ViewPager.LayoutParams)var18.getLayoutParams();
            if(!var19.isDecor) {
               ViewPager.ItemInfo var20 = this.infoForChild(var18);
               if(var20 != null) {
                  int var21 = var9 + (int)((float)var16 * var20.offset);
                  if(var19.needsMeasure) {
                     var19.needsMeasure = false;
                     var18.measure(MeasureSpec.makeMeasureSpec((int)((float)var16 * var19.widthFactor), 1073741824), MeasureSpec.makeMeasureSpec(var8 - var10 - var12, 1073741824));
                  }

                  var18.layout(var21, var10, var21 + var18.getMeasuredWidth(), var10 + var18.getMeasuredHeight());
               }
            }
         }
      }

      this.mTopPageBounds = var10;
      this.mBottomPageBounds = var8 - var12;
      this.mDecorChildCount = var14;
      if(this.mFirstLayout) {
         this.scrollToItem(this.mCurItem, false, 0, false);
      }

      this.mFirstLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(getDefaultSize(0, var1), getDefaultSize(0, var2));
      int var3 = this.getMeasuredWidth();
      this.mGutterSize = Math.min(var3 / 10, this.mDefaultGutterSize);
      int var4 = var3 - this.getPaddingLeft() - this.getPaddingRight();
      int var5 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
      int var6 = this.getChildCount();

      for(int var7 = 0; var7 < var6; ++var7) {
         View var12 = this.getChildAt(var7);
         if(var12.getVisibility() != 8) {
            ViewPager.LayoutParams var13 = (ViewPager.LayoutParams)var12.getLayoutParams();
            if(var13 != null && var13.isDecor) {
               int var14 = 7 & var13.gravity;
               int var15 = 112 & var13.gravity;
               int var16 = Integer.MIN_VALUE;
               int var17 = Integer.MIN_VALUE;
               boolean var18;
               if(var15 != 48 && var15 != 80) {
                  var18 = false;
               } else {
                  var18 = true;
               }

               boolean var19;
               if(var14 != 3 && var14 != 5) {
                  var19 = false;
               } else {
                  var19 = true;
               }

               if(var18) {
                  var16 = 1073741824;
               } else if(var19) {
                  var17 = 1073741824;
               }

               int var20 = var4;
               int var21 = var5;
               if(var13.width != -2) {
                  var16 = 1073741824;
                  if(var13.width != -1) {
                     var20 = var13.width;
                  }
               }

               if(var13.height != -2) {
                  var17 = 1073741824;
                  if(var13.height != -1) {
                     var21 = var13.height;
                  }
               }

               var12.measure(MeasureSpec.makeMeasureSpec(var20, var16), MeasureSpec.makeMeasureSpec(var21, var17));
               if(var18) {
                  var5 -= var12.getMeasuredHeight();
               } else if(var19) {
                  var4 -= var12.getMeasuredWidth();
               }
            }
         }
      }

      this.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(var4, 1073741824);
      this.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(var5, 1073741824);
      this.mInLayout = true;
      this.populate();
      this.mInLayout = false;
      int var8 = this.getChildCount();

      for(int var9 = 0; var9 < var8; ++var9) {
         View var10 = this.getChildAt(var9);
         if(var10.getVisibility() != 8) {
            ViewPager.LayoutParams var11 = (ViewPager.LayoutParams)var10.getLayoutParams();
            if(var11 == null || !var11.isDecor) {
               var10.measure(MeasureSpec.makeMeasureSpec((int)((float)var4 * var11.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
            }
         }
      }

   }

   @CallSuper
   protected void onPageScrolled(int var1, float var2, int var3) {
      if(this.mDecorChildCount > 0) {
         int var9 = this.getScrollX();
         int var10 = this.getPaddingLeft();
         int var11 = this.getPaddingRight();
         int var12 = this.getWidth();
         int var13 = this.getChildCount();

         for(int var14 = 0; var14 < var13; ++var14) {
            View var15 = this.getChildAt(var14);
            ViewPager.LayoutParams var16 = (ViewPager.LayoutParams)var15.getLayoutParams();
            if(var16.isDecor) {
               int var17;
               switch(7 & var16.gravity) {
               case 1:
                  var17 = Math.max((var12 - var15.getMeasuredWidth()) / 2, var10);
                  break;
               case 2:
               case 4:
               default:
                  var17 = var10;
                  break;
               case 3:
                  var17 = var10;
                  var10 += var15.getWidth();
                  break;
               case 5:
                  var17 = var12 - var11 - var15.getMeasuredWidth();
                  var11 += var15.getMeasuredWidth();
               }

               int var18 = var17 + var9 - var15.getLeft();
               if(var18 != 0) {
                  var15.offsetLeftAndRight(var18);
               }
            }
         }
      }

      this.dispatchOnPageScrolled(var1, var2, var3);
      if(this.mPageTransformer != null) {
         int var4 = this.getScrollX();
         int var5 = this.getChildCount();

         for(int var6 = 0; var6 < var5; ++var6) {
            View var7 = this.getChildAt(var6);
            if(!((ViewPager.LayoutParams)var7.getLayoutParams()).isDecor) {
               float var8 = (float)(var7.getLeft() - var4) / (float)this.getClientWidth();
               this.mPageTransformer.transformPage(var7, var8);
            }
         }
      }

      this.mCalledSuper = true;
   }

   protected boolean onRequestFocusInDescendants(int var1, Rect var2) {
      int var3 = this.getChildCount();
      int var4;
      byte var5;
      int var6;
      if((var1 & 2) != 0) {
         var4 = 0;
         var5 = 1;
         var6 = var3;
      } else {
         var4 = var3 - 1;
         var5 = -1;
         var6 = -1;
      }

      for(int var7 = var4; var7 != var6; var7 += var5) {
         View var8 = this.getChildAt(var7);
         if(var8.getVisibility() == 0) {
            ViewPager.ItemInfo var9 = this.infoForChild(var8);
            if(var9 != null && var9.position == this.mCurItem && var8.requestFocus(var1, var2)) {
               return true;
            }
         }
      }

      return false;
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(!(var1 instanceof ViewPager.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         ViewPager.SavedState var2 = (ViewPager.SavedState)var1;
         super.onRestoreInstanceState(var2.getSuperState());
         if(this.mAdapter != null) {
            this.mAdapter.restoreState(var2.adapterState, var2.loader);
            this.setCurrentItemInternal(var2.position, false, true);
         } else {
            this.mRestoredCurItem = var2.position;
            this.mRestoredAdapterState = var2.adapterState;
            this.mRestoredClassLoader = var2.loader;
         }
      }
   }

   public Parcelable onSaveInstanceState() {
      ViewPager.SavedState var1 = new ViewPager.SavedState(super.onSaveInstanceState());
      var1.position = this.mCurItem;
      if(this.mAdapter != null) {
         var1.adapterState = this.mAdapter.saveState();
      }

      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(var1 != var3) {
         this.recomputeScrollPosition(var1, var3, this.mPageMargin, this.mPageMargin);
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(this.mFakeDragging) {
         return true;
      } else if(var1.getAction() == 0 && var1.getEdgeFlags() != 0) {
         return false;
      } else if(this.mAdapter != null && this.mAdapter.getCount() != 0) {
         if(this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
         }

         this.mVelocityTracker.addMovement(var1);
         int var2 = 255 & var1.getAction();
         boolean var3 = false;
         switch(var2) {
         case 0:
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            this.populate();
            float var20 = var1.getX();
            this.mInitialMotionX = var20;
            this.mLastMotionX = var20;
            float var21 = var1.getY();
            this.mInitialMotionY = var21;
            this.mLastMotionY = var21;
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, 0);
            var3 = false;
            break;
         case 1:
            boolean var6 = this.mIsBeingDragged;
            var3 = false;
            if(var6) {
               VelocityTracker var7 = this.mVelocityTracker;
               var7.computeCurrentVelocity(1000, (float)this.mMaximumVelocity);
               int var8 = (int)VelocityTrackerCompat.getXVelocity(var7, this.mActivePointerId);
               this.mPopulatePending = true;
               int var9 = this.getClientWidth();
               int var10 = this.getScrollX();
               ViewPager.ItemInfo var11 = this.infoForCurrentScrollPosition();
               this.setCurrentItemInternal(this.determineTargetPage(var11.position, ((float)var10 / (float)var9 - var11.offset) / var11.widthFactor, var8, (int)(MotionEventCompat.getX(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId)) - this.mInitialMotionX)), true, true, var8);
               var3 = this.resetTouch();
            }
            break;
         case 2:
            if(!this.mIsBeingDragged) {
               int var13 = MotionEventCompat.findPointerIndex(var1, this.mActivePointerId);
               if(var13 == -1) {
                  var3 = this.resetTouch();
                  break;
               }

               float var14 = MotionEventCompat.getX(var1, var13);
               float var15 = Math.abs(var14 - this.mLastMotionX);
               float var16 = MotionEventCompat.getY(var1, var13);
               float var17 = Math.abs(var16 - this.mLastMotionY);
               if(var15 > (float)this.mTouchSlop && var15 > var17) {
                  this.mIsBeingDragged = true;
                  this.requestParentDisallowInterceptTouchEvent(true);
                  float var18;
                  if(var14 - this.mInitialMotionX > 0.0F) {
                     var18 = this.mInitialMotionX + (float)this.mTouchSlop;
                  } else {
                     var18 = this.mInitialMotionX - (float)this.mTouchSlop;
                  }

                  this.mLastMotionX = var18;
                  this.mLastMotionY = var16;
                  this.setScrollState(1);
                  this.setScrollingCacheEnabled(true);
                  ViewParent var19 = this.getParent();
                  if(var19 != null) {
                     var19.requestDisallowInterceptTouchEvent(true);
                  }
               }
            }

            boolean var12 = this.mIsBeingDragged;
            var3 = false;
            if(var12) {
               var3 = false | this.performDrag(MotionEventCompat.getX(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId)));
            }
            break;
         case 3:
            boolean var5 = this.mIsBeingDragged;
            var3 = false;
            if(var5) {
               this.scrollToItem(this.mCurItem, true, 0, false);
               var3 = this.resetTouch();
            }
         case 4:
         default:
            break;
         case 5:
            int var4 = MotionEventCompat.getActionIndex(var1);
            this.mLastMotionX = MotionEventCompat.getX(var1, var4);
            this.mActivePointerId = MotionEventCompat.getPointerId(var1, var4);
            var3 = false;
            break;
         case 6:
            this.onSecondaryPointerUp(var1);
            this.mLastMotionX = MotionEventCompat.getX(var1, MotionEventCompat.findPointerIndex(var1, this.mActivePointerId));
            var3 = false;
         }

         if(var3) {
            ViewCompat.postInvalidateOnAnimation(this);
         }

         return true;
      } else {
         return false;
      }
   }

   boolean pageLeft() {
      if(this.mCurItem > 0) {
         this.setCurrentItem(-1 + this.mCurItem, true);
         return true;
      } else {
         return false;
      }
   }

   boolean pageRight() {
      if(this.mAdapter != null && this.mCurItem < -1 + this.mAdapter.getCount()) {
         this.setCurrentItem(1 + this.mCurItem, true);
         return true;
      } else {
         return false;
      }
   }

   void populate() {
      this.populate(this.mCurItem);
   }

   void populate(int var1) {
      int var2 = this.mCurItem;
      ViewPager.ItemInfo var3 = null;
      if(var2 != var1) {
         var3 = this.infoForPosition(this.mCurItem);
         this.mCurItem = var1;
      }

      if(this.mAdapter == null) {
         this.sortChildDrawingOrder();
      } else {
         if(this.mPopulatePending) {
            this.sortChildDrawingOrder();
            return;
         }

         if(this.getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup)this);
            int var4 = this.mOffscreenPageLimit;
            int var5 = Math.max(0, this.mCurItem - var4);
            int var6 = this.mAdapter.getCount();
            int var7 = Math.min(var6 - 1, var4 + this.mCurItem);
            if(var6 != this.mExpectedAdapterCount) {
               String var55;
               String var56;
               try {
                  var56 = this.getResources().getResourceName(this.getId());
               } catch (NotFoundException var57) {
                  var55 = Integer.toHexString(this.getId());
                  throw new IllegalStateException("The application\'s PagerAdapter changed the adapter\'s contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + var6 + " Pager id: " + var55 + " Pager class: " + this.getClass() + " Problematic adapter: " + this.mAdapter.getClass());
               }

               var55 = var56;
               throw new IllegalStateException("The application\'s PagerAdapter changed the adapter\'s contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + var6 + " Pager id: " + var55 + " Pager class: " + this.getClass() + " Problematic adapter: " + this.mAdapter.getClass());
            }

            int var8 = 0;

            ViewPager.ItemInfo var10;
            while(true) {
               int var9 = this.mItems.size();
               var10 = null;
               if(var8 >= var9) {
                  break;
               }

               ViewPager.ItemInfo var51 = (ViewPager.ItemInfo)this.mItems.get(var8);
               if(var51.position >= this.mCurItem) {
                  int var52 = var51.position;
                  int var53 = this.mCurItem;
                  var10 = null;
                  if(var52 == var53) {
                     var10 = var51;
                  }
                  break;
               }

               ++var8;
            }

            if(var10 == null && var6 > 0) {
               var10 = this.addNewItem(this.mCurItem, var8);
            }

            if(var10 != null) {
               float var24 = 0.0F;
               int var25 = var8 - 1;
               ViewPager.ItemInfo var26;
               if(var25 >= 0) {
                  var26 = (ViewPager.ItemInfo)this.mItems.get(var25);
               } else {
                  var26 = null;
               }

               int var27 = this.getClientWidth();
               float var28;
               if(var27 <= 0) {
                  var28 = 0.0F;
               } else {
                  var28 = 2.0F - var10.widthFactor + (float)this.getPaddingLeft() / (float)var27;
               }

               for(int var29 = -1 + this.mCurItem; var29 >= 0; --var29) {
                  if(var24 >= var28 && var29 < var5) {
                     if(var26 == null) {
                        break;
                     }

                     int var47 = var26.position;
                     if(var29 == var47 && !var26.scrolling) {
                        this.mItems.remove(var25);
                        PagerAdapter var49 = this.mAdapter;
                        Object var50 = var26.object;
                        var49.destroyItem((ViewGroup)this, var29, var50);
                        --var25;
                        --var8;
                        if(var25 >= 0) {
                           var26 = (ViewPager.ItemInfo)this.mItems.get(var25);
                        } else {
                           var26 = null;
                        }
                     }
                  } else {
                     if(var26 != null) {
                        int var46 = var26.position;
                        if(var29 == var46) {
                           var24 += var26.widthFactor;
                           --var25;
                           if(var25 >= 0) {
                              var26 = (ViewPager.ItemInfo)this.mItems.get(var25);
                           } else {
                              var26 = null;
                           }
                           continue;
                        }
                     }

                     int var45 = var25 + 1;
                     var24 += this.addNewItem(var29, var45).widthFactor;
                     ++var8;
                     if(var25 >= 0) {
                        var26 = (ViewPager.ItemInfo)this.mItems.get(var25);
                     } else {
                        var26 = null;
                     }
                  }
               }

               float var30 = var10.widthFactor;
               int var31 = var8 + 1;
               if(var30 < 2.0F) {
                  int var32 = this.mItems.size();
                  ViewPager.ItemInfo var33;
                  if(var31 < var32) {
                     var33 = (ViewPager.ItemInfo)this.mItems.get(var31);
                  } else {
                     var33 = null;
                  }

                  float var34;
                  if(var27 <= 0) {
                     var34 = 0.0F;
                  } else {
                     var34 = 2.0F + (float)this.getPaddingRight() / (float)var27;
                  }

                  for(int var35 = 1 + this.mCurItem; var35 < var6; ++var35) {
                     if(var30 >= var34 && var35 > var7) {
                        if(var33 == null) {
                           break;
                        }

                        int var40 = var33.position;
                        if(var35 == var40 && !var33.scrolling) {
                           this.mItems.remove(var31);
                           PagerAdapter var42 = this.mAdapter;
                           Object var43 = var33.object;
                           var42.destroyItem((ViewGroup)this, var35, var43);
                           int var44 = this.mItems.size();
                           if(var31 < var44) {
                              var33 = (ViewPager.ItemInfo)this.mItems.get(var31);
                           } else {
                              var33 = null;
                           }
                        }
                     } else {
                        if(var33 != null) {
                           int var38 = var33.position;
                           if(var35 == var38) {
                              var30 += var33.widthFactor;
                              ++var31;
                              int var39 = this.mItems.size();
                              if(var31 < var39) {
                                 var33 = (ViewPager.ItemInfo)this.mItems.get(var31);
                              } else {
                                 var33 = null;
                              }
                              continue;
                           }
                        }

                        ViewPager.ItemInfo var36 = this.addNewItem(var35, var31);
                        ++var31;
                        var30 += var36.widthFactor;
                        int var37 = this.mItems.size();
                        if(var31 < var37) {
                           var33 = (ViewPager.ItemInfo)this.mItems.get(var31);
                        } else {
                           var33 = null;
                        }
                     }
                  }
               }

               this.calculatePageOffsets(var10, var8, var3);
            }

            PagerAdapter var11 = this.mAdapter;
            int var12 = this.mCurItem;
            Object var13;
            if(var10 != null) {
               var13 = var10.object;
            } else {
               var13 = null;
            }

            var11.setPrimaryItem((ViewGroup)this, var12, var13);
            this.mAdapter.finishUpdate((ViewGroup)this);
            int var14 = this.getChildCount();

            for(int var15 = 0; var15 < var14; ++var15) {
               View var21 = this.getChildAt(var15);
               ViewPager.LayoutParams var22 = (ViewPager.LayoutParams)var21.getLayoutParams();
               var22.childIndex = var15;
               if(!var22.isDecor && var22.widthFactor == 0.0F) {
                  ViewPager.ItemInfo var23 = this.infoForChild(var21);
                  if(var23 != null) {
                     var22.widthFactor = var23.widthFactor;
                     var22.position = var23.position;
                  }
               }
            }

            this.sortChildDrawingOrder();
            if(this.hasFocus()) {
               View var16 = this.findFocus();
               ViewPager.ItemInfo var17;
               if(var16 != null) {
                  var17 = this.infoForAnyChild(var16);
               } else {
                  var17 = null;
               }

               if(var17 == null || var17.position != this.mCurItem) {
                  for(int var18 = 0; var18 < this.getChildCount(); ++var18) {
                     View var19 = this.getChildAt(var18);
                     ViewPager.ItemInfo var20 = this.infoForChild(var19);
                     if(var20 != null && var20.position == this.mCurItem && var19.requestFocus(2)) {
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   public void removeOnPageChangeListener(ViewPager.OnPageChangeListener var1) {
      if(this.mOnPageChangeListeners != null) {
         this.mOnPageChangeListeners.remove(var1);
      }

   }

   public void removeView(View var1) {
      if(this.mInLayout) {
         this.removeViewInLayout(var1);
      } else {
         super.removeView(var1);
      }
   }

   public void setAdapter(PagerAdapter var1) {
      if(this.mAdapter != null) {
         this.mAdapter.setViewPagerObserver((DataSetObserver)null);
         this.mAdapter.startUpdate((ViewGroup)this);

         for(int var4 = 0; var4 < this.mItems.size(); ++var4) {
            ViewPager.ItemInfo var5 = (ViewPager.ItemInfo)this.mItems.get(var4);
            this.mAdapter.destroyItem((ViewGroup)this, var5.position, var5.object);
         }

         this.mAdapter.finishUpdate((ViewGroup)this);
         this.mItems.clear();
         this.removeNonDecorViews();
         this.mCurItem = 0;
         this.scrollTo(0, 0);
      }

      PagerAdapter var2 = this.mAdapter;
      this.mAdapter = var1;
      this.mExpectedAdapterCount = 0;
      if(this.mAdapter != null) {
         if(this.mObserver == null) {
            this.mObserver = new ViewPager.PagerObserver(null);
         }

         this.mAdapter.setViewPagerObserver(this.mObserver);
         this.mPopulatePending = false;
         boolean var3 = this.mFirstLayout;
         this.mFirstLayout = true;
         this.mExpectedAdapterCount = this.mAdapter.getCount();
         if(this.mRestoredCurItem >= 0) {
            this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
            this.setCurrentItemInternal(this.mRestoredCurItem, false, true);
            this.mRestoredCurItem = -1;
            this.mRestoredAdapterState = null;
            this.mRestoredClassLoader = null;
         } else if(!var3) {
            this.populate();
         } else {
            this.requestLayout();
         }
      }

      if(this.mAdapterChangeListener != null && var2 != var1) {
         this.mAdapterChangeListener.onAdapterChanged(var2, var1);
      }

   }

   void setChildrenDrawingOrderEnabledCompat(boolean var1) {
      if(VERSION.SDK_INT >= 7) {
         if(this.mSetChildrenDrawingOrderEnabled == null) {
            try {
               Class[] var9 = new Class[]{Boolean.TYPE};
               this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", var9);
            } catch (NoSuchMethodException var11) {
               Log.e("ViewPager", "Can\'t find setChildrenDrawingOrderEnabled", var11);
            }
         }

         try {
            Method var4 = this.mSetChildrenDrawingOrderEnabled;
            Object[] var5 = new Object[]{Boolean.valueOf(var1)};
            var4.invoke(this, var5);
         } catch (Exception var10) {
            Log.e("ViewPager", "Error changing children drawing order", var10);
            return;
         }
      }

   }

   public void setCurrentItem(int var1) {
      this.mPopulatePending = false;
      boolean var2;
      if(!this.mFirstLayout) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setCurrentItemInternal(var1, var2, false);
   }

   public void setCurrentItem(int var1, boolean var2) {
      this.mPopulatePending = false;
      this.setCurrentItemInternal(var1, var2, false);
   }

   void setCurrentItemInternal(int var1, boolean var2, boolean var3) {
      this.setCurrentItemInternal(var1, var2, var3, 0);
   }

   void setCurrentItemInternal(int var1, boolean var2, boolean var3, int var4) {
      boolean var5 = true;
      if(this.mAdapter != null && this.mAdapter.getCount() > 0) {
         if(!var3 && this.mCurItem == var1 && this.mItems.size() != 0) {
            this.setScrollingCacheEnabled(false);
         } else {
            if(var1 < 0) {
               var1 = 0;
            } else if(var1 >= this.mAdapter.getCount()) {
               var1 = -1 + this.mAdapter.getCount();
            }

            int var6 = this.mOffscreenPageLimit;
            if(var1 > var6 + this.mCurItem || var1 < this.mCurItem - var6) {
               for(int var7 = 0; var7 < this.mItems.size(); ++var7) {
                  ((ViewPager.ItemInfo)this.mItems.get(var7)).scrolling = var5;
               }
            }

            if(this.mCurItem == var1) {
               var5 = false;
            }

            if(this.mFirstLayout) {
               this.mCurItem = var1;
               if(var5) {
                  this.dispatchOnPageSelected(var1);
               }

               this.requestLayout();
            } else {
               this.populate(var1);
               this.scrollToItem(var1, var2, var4, var5);
            }
         }
      } else {
         this.setScrollingCacheEnabled(false);
      }
   }

   ViewPager.OnPageChangeListener setInternalPageChangeListener(ViewPager.OnPageChangeListener var1) {
      ViewPager.OnPageChangeListener var2 = this.mInternalPageChangeListener;
      this.mInternalPageChangeListener = var1;
      return var2;
   }

   public void setOffscreenPageLimit(int var1) {
      if(var1 < 1) {
         Log.w("ViewPager", "Requested offscreen page limit " + var1 + " too small; defaulting to " + 1);
         var1 = 1;
      }

      if(var1 != this.mOffscreenPageLimit) {
         this.mOffscreenPageLimit = var1;
         this.populate();
      }

   }

   void setOnAdapterChangeListener(ViewPager.OnAdapterChangeListener var1) {
      this.mAdapterChangeListener = var1;
   }

   @Deprecated
   public void setOnPageChangeListener(ViewPager.OnPageChangeListener var1) {
      this.mOnPageChangeListener = var1;
   }

   public void setPageMargin(int var1) {
      int var2 = this.mPageMargin;
      this.mPageMargin = var1;
      int var3 = this.getWidth();
      this.recomputeScrollPosition(var3, var3, var1, var2);
      this.requestLayout();
   }

   public void setPageMarginDrawable(@DrawableRes int var1) {
      this.setPageMarginDrawable(this.getContext().getResources().getDrawable(var1));
   }

   public void setPageMarginDrawable(Drawable var1) {
      this.mMarginDrawable = var1;
      if(var1 != null) {
         this.refreshDrawableState();
      }

      boolean var2;
      if(var1 == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   public void setPageTransformer(boolean var1, ViewPager.PageTransformer var2) {
      byte var3 = 1;
      if(VERSION.SDK_INT >= 11) {
         byte var4;
         if(var2 != null) {
            var4 = var3;
         } else {
            var4 = 0;
         }

         byte var5;
         if(this.mPageTransformer != null) {
            var5 = var3;
         } else {
            var5 = 0;
         }

         byte var6;
         if(var4 != var5) {
            var6 = var3;
         } else {
            var6 = 0;
         }

         this.mPageTransformer = var2;
         this.setChildrenDrawingOrderEnabledCompat((boolean)var4);
         if(var4 != 0) {
            if(var1) {
               var3 = 2;
            }

            this.mDrawingOrder = var3;
         } else {
            this.mDrawingOrder = 0;
         }

         if(var6 != 0) {
            this.populate();
         }
      }

   }

   void smoothScrollTo(int var1, int var2) {
      this.smoothScrollTo(var1, var2, 0);
   }

   void smoothScrollTo(int var1, int var2, int var3) {
      if(this.getChildCount() == 0) {
         this.setScrollingCacheEnabled(false);
      } else {
         boolean var4;
         if(this.mScroller != null && !this.mScroller.isFinished()) {
            var4 = true;
         } else {
            var4 = false;
         }

         int var5;
         if(var4) {
            if(this.mIsScrollStarted) {
               var5 = this.mScroller.getCurrX();
            } else {
               var5 = this.mScroller.getStartX();
            }

            this.mScroller.abortAnimation();
            this.setScrollingCacheEnabled(false);
         } else {
            var5 = this.getScrollX();
         }

         int var6 = this.getScrollY();
         int var7 = var1 - var5;
         int var8 = var2 - var6;
         if(var7 == 0 && var8 == 0) {
            this.completeScroll(false);
            this.populate();
            this.setScrollState(0);
         } else {
            this.setScrollingCacheEnabled(true);
            this.setScrollState(2);
            int var9 = this.getClientWidth();
            int var10 = var9 / 2;
            float var11 = Math.min(1.0F, 1.0F * (float)Math.abs(var7) / (float)var9);
            float var12 = (float)var10 + (float)var10 * this.distanceInfluenceForSnapDuration(var11);
            int var13 = Math.abs(var3);
            int var15;
            if(var13 > 0) {
               var15 = 4 * Math.round(1000.0F * Math.abs(var12 / (float)var13));
            } else {
               float var14 = (float)var9 * this.mAdapter.getPageWidth(this.mCurItem);
               var15 = (int)(100.0F * (1.0F + (float)Math.abs(var7) / (var14 + (float)this.mPageMargin)));
            }

            int var16 = Math.min(var15, 600);
            this.mIsScrollStarted = false;
            this.mScroller.startScroll(var5, var6, var7, var8, var16);
            ViewCompat.postInvalidateOnAnimation(this);
         }
      }
   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mMarginDrawable;
   }

   interface Decor {
   }

   static class ItemInfo {
      Object object;
      float offset;
      int position;
      boolean scrolling;
      float widthFactor;
   }

   public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
      int childIndex;
      public int gravity;
      public boolean isDecor;
      boolean needsMeasure;
      int position;
      float widthFactor = 0.0F;

      public LayoutParams() {
         super(-1, -1);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, ViewPager.LAYOUT_ATTRS);
         this.gravity = var3.getInteger(0, 48);
         var3.recycle();
      }
   }

   class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
      private boolean canScroll() {
         return ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.getCount() > 1;
      }

      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
         super.onInitializeAccessibilityEvent(var1, var2);
         var2.setClassName(ViewPager.class.getName());
         AccessibilityRecordCompat var3 = AccessibilityRecordCompat.obtain();
         var3.setScrollable(this.canScroll());
         if(var2.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
            var3.setItemCount(ViewPager.this.mAdapter.getCount());
            var3.setFromIndex(ViewPager.this.mCurItem);
            var3.setToIndex(ViewPager.this.mCurItem);
         }

      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         super.onInitializeAccessibilityNodeInfo(var1, var2);
         var2.setClassName(ViewPager.class.getName());
         var2.setScrollable(this.canScroll());
         if(ViewPager.this.canScrollHorizontally(1)) {
            var2.addAction(4096);
         }

         if(ViewPager.this.canScrollHorizontally(-1)) {
            var2.addAction(8192);
         }

      }

      public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
         if(super.performAccessibilityAction(var1, var2, var3)) {
            return true;
         } else {
            switch(var2) {
            case 4096:
               if(ViewPager.this.canScrollHorizontally(1)) {
                  ViewPager.this.setCurrentItem(1 + ViewPager.this.mCurItem);
                  return true;
               }

               return false;
            case 8192:
               if(ViewPager.this.canScrollHorizontally(-1)) {
                  ViewPager.this.setCurrentItem(-1 + ViewPager.this.mCurItem);
                  return true;
               }

               return false;
            default:
               return false;
            }
         }
      }
   }

   interface OnAdapterChangeListener {
      void onAdapterChanged(PagerAdapter var1, PagerAdapter var2);
   }

   public interface OnPageChangeListener {
      void onPageScrollStateChanged(int var1);

      void onPageScrolled(int var1, float var2, int var3);

      void onPageSelected(int var1);
   }

   public interface PageTransformer {
      void transformPage(View var1, float var2);
   }

   private class PagerObserver extends DataSetObserver {
      private PagerObserver() {
      }

      // $FF: synthetic method
      PagerObserver(Object var2) {
         this();
      }

      public void onChanged() {
         ViewPager.this.dataSetChanged();
      }

      public void onInvalidated() {
         ViewPager.this.dataSetChanged();
      }
   }

   public static class SavedState extends BaseSavedState {
      public static final Creator<ViewPager.SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {
         public ViewPager.SavedState createFromParcel(Parcel var1, ClassLoader var2) {
            return new ViewPager.SavedState(var1, var2);
         }

         public ViewPager.SavedState[] newArray(int var1) {
            return new ViewPager.SavedState[var1];
         }
      });
      Parcelable adapterState;
      ClassLoader loader;
      int position;

      SavedState(Parcel var1, ClassLoader var2) {
         super(var1);
         if(var2 == null) {
            var2 = this.getClass().getClassLoader();
         }

         this.position = var1.readInt();
         this.adapterState = var1.readParcelable(var2);
         this.loader = var2;
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      public String toString() {
         return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.position);
         var1.writeParcelable(this.adapterState, var2);
      }
   }

   public static class SimpleOnPageChangeListener implements ViewPager.OnPageChangeListener {
      public void onPageScrollStateChanged(int var1) {
      }

      public void onPageScrolled(int var1, float var2, int var3) {
      }

      public void onPageSelected(int var1) {
      }
   }

   static class ViewPositionComparator implements Comparator<View> {
      public int compare(View var1, View var2) {
         ViewPager.LayoutParams var3 = (ViewPager.LayoutParams)var1.getLayoutParams();
         ViewPager.LayoutParams var4 = (ViewPager.LayoutParams)var2.getLayoutParams();
         return var3.isDecor != var4.isDecor?(var3.isDecor?1:-1):var3.position - var4.position;
      }
   }
}
