package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
   private static final int DEFAULT_FADE_COLOR = -858993460;
   private static final int DEFAULT_OVERHANG_SIZE = 32;
   static final SlidingPaneLayout.SlidingPanelLayoutImpl IMPL;
   private static final int MIN_FLING_VELOCITY = 400;
   private static final String TAG = "SlidingPaneLayout";
   private boolean mCanSlide;
   private int mCoveredFadeColor;
   private final ViewDragHelper mDragHelper;
   private boolean mFirstLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private boolean mIsUnableToDrag;
   private final int mOverhangSize;
   private SlidingPaneLayout.PanelSlideListener mPanelSlideListener;
   private int mParallaxBy;
   private float mParallaxOffset;
   private final ArrayList<SlidingPaneLayout.DisableLayerRunnable> mPostedRunnables;
   private boolean mPreservedOpenState;
   private Drawable mShadowDrawableLeft;
   private Drawable mShadowDrawableRight;
   private float mSlideOffset;
   private int mSlideRange;
   private View mSlideableView;
   private int mSliderFadeColor;
   private final Rect mTmpRect;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 17) {
         IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplJBMR1();
      } else if(var0 >= 16) {
         IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplJB();
      } else {
         IMPL = new SlidingPaneLayout.SlidingPanelLayoutImplBase();
      }
   }

   public SlidingPaneLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public SlidingPaneLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SlidingPaneLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mSliderFadeColor = -858993460;
      this.mFirstLayout = true;
      this.mTmpRect = new Rect();
      this.mPostedRunnables = new ArrayList();
      float var4 = var1.getResources().getDisplayMetrics().density;
      this.mOverhangSize = (int)(0.5F + 32.0F * var4);
      ViewConfiguration.get(var1);
      this.setWillNotDraw(false);
      ViewCompat.setAccessibilityDelegate(this, new SlidingPaneLayout.AccessibilityDelegate());
      ViewCompat.setImportantForAccessibility(this, 1);
      this.mDragHelper = ViewDragHelper.create(this, 0.5F, new SlidingPaneLayout.DragHelperCallback());
      this.mDragHelper.setMinVelocity(400.0F * var4);
   }

   private boolean closePane(View var1, int var2) {
      boolean var3;
      if(!this.mFirstLayout) {
         boolean var4 = this.smoothSlideTo(0.0F, var2);
         var3 = false;
         if(!var4) {
            return var3;
         }
      }

      this.mPreservedOpenState = false;
      var3 = true;
      return var3;
   }

   private void dimChildView(View var1, float var2, int var3) {
      SlidingPaneLayout.LayoutParams var4 = (SlidingPaneLayout.LayoutParams)var1.getLayoutParams();
      if(var2 > 0.0F && var3 != 0) {
         int var8 = (int)(var2 * (float)((-16777216 & var3) >>> 24)) << 24 | 16777215 & var3;
         if(var4.dimPaint == null) {
            var4.dimPaint = new Paint();
         }

         var4.dimPaint.setColorFilter(new PorterDuffColorFilter(var8, Mode.SRC_OVER));
         if(ViewCompat.getLayerType(var1) != 2) {
            ViewCompat.setLayerType(var1, 2, var4.dimPaint);
         }

         this.invalidateChildRegion(var1);
      } else if(ViewCompat.getLayerType(var1) != 0) {
         if(var4.dimPaint != null) {
            var4.dimPaint.setColorFilter((ColorFilter)null);
         }

         SlidingPaneLayout.DisableLayerRunnable var5 = new SlidingPaneLayout.DisableLayerRunnable(var1);
         this.mPostedRunnables.add(var5);
         ViewCompat.postOnAnimation(this, var5);
         return;
      }

   }

   private void invalidateChildRegion(View var1) {
      IMPL.invalidateChildRegion(this, var1);
   }

   private boolean isLayoutRtlSupport() {
      return ViewCompat.getLayoutDirection(this) == 1;
   }

   private void onPanelDragged(int var1) {
      if(this.mSlideableView == null) {
         this.mSlideOffset = 0.0F;
      } else {
         boolean var2 = this.isLayoutRtlSupport();
         SlidingPaneLayout.LayoutParams var3 = (SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams();
         int var4 = this.mSlideableView.getWidth();
         int var5;
         if(var2) {
            var5 = this.getWidth() - var1 - var4;
         } else {
            var5 = var1;
         }

         int var6;
         if(var2) {
            var6 = this.getPaddingRight();
         } else {
            var6 = this.getPaddingLeft();
         }

         int var7;
         if(var2) {
            var7 = var3.rightMargin;
         } else {
            var7 = var3.leftMargin;
         }

         this.mSlideOffset = (float)(var5 - (var6 + var7)) / (float)this.mSlideRange;
         if(this.mParallaxBy != 0) {
            this.parallaxOtherViews(this.mSlideOffset);
         }

         if(var3.dimWhenOffset) {
            this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
         }

         this.dispatchOnPanelSlide(this.mSlideableView);
      }
   }

   private boolean openPane(View var1, int var2) {
      if(!this.mFirstLayout && !this.smoothSlideTo(1.0F, var2)) {
         return false;
      } else {
         this.mPreservedOpenState = true;
         return true;
      }
   }

   private void parallaxOtherViews(float var1) {
      boolean var2;
      boolean var4;
      label39: {
         var2 = this.isLayoutRtlSupport();
         SlidingPaneLayout.LayoutParams var3 = (SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams();
         if(var3.dimWhenOffset) {
            int var11;
            if(var2) {
               var11 = var3.rightMargin;
            } else {
               var11 = var3.leftMargin;
            }

            if(var11 <= 0) {
               var4 = true;
               break label39;
            }
         }

         var4 = false;
      }

      int var5 = this.getChildCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         View var7 = this.getChildAt(var6);
         if(var7 != this.mSlideableView) {
            int var8 = (int)((1.0F - this.mParallaxOffset) * (float)this.mParallaxBy);
            this.mParallaxOffset = var1;
            int var9 = var8 - (int)((1.0F - var1) * (float)this.mParallaxBy);
            if(var2) {
               var9 = -var9;
            }

            var7.offsetLeftAndRight(var9);
            if(var4) {
               float var10;
               if(var2) {
                  var10 = this.mParallaxOffset - 1.0F;
               } else {
                  var10 = 1.0F - this.mParallaxOffset;
               }

               this.dimChildView(var7, var10, this.mCoveredFadeColor);
            }
         }
      }

   }

   private static boolean viewIsOpaque(View var0) {
      if(!ViewCompat.isOpaque(var0)) {
         if(VERSION.SDK_INT >= 18) {
            return false;
         }

         Drawable var1 = var0.getBackground();
         if(var1 == null) {
            return false;
         }

         if(var1.getOpacity() != -1) {
            return false;
         }
      }

      return true;
   }

   protected boolean canScroll(View var1, boolean var2, int var3, int var4, int var5) {
      if(var1 instanceof ViewGroup) {
         ViewGroup var6 = (ViewGroup)var1;
         int var7 = var1.getScrollX();
         int var8 = var1.getScrollY();

         for(int var9 = -1 + var6.getChildCount(); var9 >= 0; --var9) {
            View var10 = var6.getChildAt(var9);
            if(var4 + var7 >= var10.getLeft() && var4 + var7 < var10.getRight() && var5 + var8 >= var10.getTop() && var5 + var8 < var10.getBottom()) {
               int var11 = var4 + var7 - var10.getLeft();
               int var12 = var5 + var8 - var10.getTop();
               if(this.canScroll(var10, true, var3, var11, var12)) {
                  return true;
               }
            }
         }
      }

      if(var2) {
         if(!this.isLayoutRtlSupport()) {
            var3 = -var3;
         }

         if(ViewCompat.canScrollHorizontally(var1, var3)) {
            return true;
         }
      }

      return false;
   }

   @Deprecated
   public boolean canSlide() {
      return this.mCanSlide;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof SlidingPaneLayout.LayoutParams && super.checkLayoutParams(var1);
   }

   public boolean closePane() {
      return this.closePane(this.mSlideableView, 0);
   }

   public void computeScroll() {
      if(this.mDragHelper.continueSettling(true)) {
         if(this.mCanSlide) {
            ViewCompat.postInvalidateOnAnimation(this);
            return;
         }

         this.mDragHelper.abort();
      }

   }

   void dispatchOnPanelClosed(View var1) {
      if(this.mPanelSlideListener != null) {
         this.mPanelSlideListener.onPanelClosed(var1);
      }

      this.sendAccessibilityEvent(32);
   }

   void dispatchOnPanelOpened(View var1) {
      if(this.mPanelSlideListener != null) {
         this.mPanelSlideListener.onPanelOpened(var1);
      }

      this.sendAccessibilityEvent(32);
   }

   void dispatchOnPanelSlide(View var1) {
      if(this.mPanelSlideListener != null) {
         this.mPanelSlideListener.onPanelSlide(var1, this.mSlideOffset);
      }

   }

   public void draw(Canvas var1) {
      super.draw(var1);
      Drawable var2;
      if(this.isLayoutRtlSupport()) {
         var2 = this.mShadowDrawableRight;
      } else {
         var2 = this.mShadowDrawableLeft;
      }

      View var3;
      if(this.getChildCount() > 1) {
         var3 = this.getChildAt(1);
      } else {
         var3 = null;
      }

      if(var3 != null && var2 != null) {
         int var4 = var3.getTop();
         int var5 = var3.getBottom();
         int var6 = var2.getIntrinsicWidth();
         int var7;
         int var8;
         if(this.isLayoutRtlSupport()) {
            var8 = var3.getRight();
            var7 = var8 + var6;
         } else {
            var7 = var3.getLeft();
            var8 = var7 - var6;
         }

         var2.setBounds(var8, var4, var7, var5);
         var2.draw(var1);
      }
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      SlidingPaneLayout.LayoutParams var5 = (SlidingPaneLayout.LayoutParams)var2.getLayoutParams();
      int var6 = var1.save(2);
      if(this.mCanSlide && !var5.slideable && this.mSlideableView != null) {
         var1.getClipBounds(this.mTmpRect);
         if(this.isLayoutRtlSupport()) {
            this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
         } else {
            this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
         }

         var1.clipRect(this.mTmpRect);
      }

      boolean var7;
      if(VERSION.SDK_INT >= 11) {
         var7 = super.drawChild(var1, var2, var3);
      } else if(var5.dimWhenOffset && this.mSlideOffset > 0.0F) {
         if(!var2.isDrawingCacheEnabled()) {
            var2.setDrawingCacheEnabled(true);
         }

         Bitmap var8 = var2.getDrawingCache();
         if(var8 != null) {
            var1.drawBitmap(var8, (float)var2.getLeft(), (float)var2.getTop(), var5.dimPaint);
            var7 = false;
         } else {
            Log.e("SlidingPaneLayout", "drawChild: child view " + var2 + " returned null drawing cache");
            var7 = super.drawChild(var1, var2, var3);
         }
      } else {
         if(var2.isDrawingCacheEnabled()) {
            var2.setDrawingCacheEnabled(false);
         }

         var7 = super.drawChild(var1, var2, var3);
      }

      var1.restoreToCount(var6);
      return var7;
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      return new SlidingPaneLayout.LayoutParams();
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new SlidingPaneLayout.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof MarginLayoutParams?new SlidingPaneLayout.LayoutParams((MarginLayoutParams)var1):new SlidingPaneLayout.LayoutParams(var1);
   }

   public int getCoveredFadeColor() {
      return this.mCoveredFadeColor;
   }

   public int getParallaxDistance() {
      return this.mParallaxBy;
   }

   public int getSliderFadeColor() {
      return this.mSliderFadeColor;
   }

   boolean isDimmed(View var1) {
      if(var1 != null) {
         SlidingPaneLayout.LayoutParams var2 = (SlidingPaneLayout.LayoutParams)var1.getLayoutParams();
         if(this.mCanSlide && var2.dimWhenOffset && this.mSlideOffset > 0.0F) {
            return true;
         }
      }

      return false;
   }

   public boolean isOpen() {
      return !this.mCanSlide || this.mSlideOffset == 1.0F;
   }

   public boolean isSlideable() {
      return this.mCanSlide;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mFirstLayout = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mFirstLayout = true;
      int var1 = 0;

      for(int var2 = this.mPostedRunnables.size(); var1 < var2; ++var1) {
         ((SlidingPaneLayout.DisableLayerRunnable)this.mPostedRunnables.get(var1)).run();
      }

      this.mPostedRunnables.clear();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(!this.mCanSlide && var2 == 0 && this.getChildCount() > 1) {
         View var14 = this.getChildAt(1);
         if(var14 != null) {
            boolean var15;
            if(!this.mDragHelper.isViewUnder(var14, (int)var1.getX(), (int)var1.getY())) {
               var15 = true;
            } else {
               var15 = false;
            }

            this.mPreservedOpenState = var15;
         }
      }

      if(!this.mCanSlide || this.mIsUnableToDrag && var2 != 0) {
         this.mDragHelper.cancel();
         return super.onInterceptTouchEvent(var1);
      } else if(var2 != 3 && var2 != 1) {
         boolean var3 = false;
         switch(var2) {
         case 0:
            this.mIsUnableToDrag = false;
            float var10 = var1.getX();
            float var11 = var1.getY();
            this.mInitialMotionX = var10;
            this.mInitialMotionY = var11;
            boolean var12 = this.mDragHelper.isViewUnder(this.mSlideableView, (int)var10, (int)var11);
            var3 = false;
            if(var12) {
               boolean var13 = this.isDimmed(this.mSlideableView);
               var3 = false;
               if(var13) {
                  var3 = true;
               }
            }
         case 1:
         default:
            break;
         case 2:
            float var4 = var1.getX();
            float var5 = var1.getY();
            float var6 = Math.abs(var4 - this.mInitialMotionX);
            float var7 = Math.abs(var5 - this.mInitialMotionY);
            float var16;
            int var8 = (var16 = var6 - (float)this.mDragHelper.getTouchSlop()) == 0.0F?0:(var16 < 0.0F?-1:1);
            var3 = false;
            if(var8 > 0) {
               float var17;
               int var9 = (var17 = var7 - var6) == 0.0F?0:(var17 < 0.0F?-1:1);
               var3 = false;
               if(var9 > 0) {
                  this.mDragHelper.cancel();
                  this.mIsUnableToDrag = true;
                  return false;
               }
            }
         }

         return this.mDragHelper.shouldInterceptTouchEvent(var1) || var3;
      } else {
         this.mDragHelper.cancel();
         return false;
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      boolean var6 = this.isLayoutRtlSupport();
      if(var6) {
         this.mDragHelper.setEdgeTrackingEnabled(2);
      } else {
         this.mDragHelper.setEdgeTrackingEnabled(1);
      }

      int var7 = var4 - var2;
      int var8;
      if(var6) {
         var8 = this.getPaddingRight();
      } else {
         var8 = this.getPaddingLeft();
      }

      int var9;
      if(var6) {
         var9 = this.getPaddingLeft();
      } else {
         var9 = this.getPaddingRight();
      }

      int var10 = this.getPaddingTop();
      int var11 = this.getChildCount();
      int var12 = var8;
      int var13 = var8;
      if(this.mFirstLayout) {
         float var28;
         if(this.mCanSlide && this.mPreservedOpenState) {
            var28 = 1.0F;
         } else {
            var28 = 0.0F;
         }

         this.mSlideOffset = var28;
      }

      for(int var14 = 0; var14 < var11; ++var14) {
         View var16 = this.getChildAt(var14);
         if(var16.getVisibility() != 8) {
            SlidingPaneLayout.LayoutParams var17 = (SlidingPaneLayout.LayoutParams)var16.getLayoutParams();
            int var18 = var16.getMeasuredWidth();
            int var19 = 0;
            if(var17.slideable) {
               int var22 = var17.leftMargin + var17.rightMargin;
               int var23 = var7 - var9 - this.mOverhangSize;
               int var24 = Math.min(var13, var23) - var12 - var22;
               this.mSlideRange = var24;
               int var25;
               if(var6) {
                  var25 = var17.rightMargin;
               } else {
                  var25 = var17.leftMargin;
               }

               boolean var26;
               if(var24 + var12 + var25 + var18 / 2 > var7 - var9) {
                  var26 = true;
               } else {
                  var26 = false;
               }

               var17.dimWhenOffset = var26;
               int var27 = (int)((float)var24 * this.mSlideOffset);
               var12 += var27 + var25;
               this.mSlideOffset = (float)var27 / (float)this.mSlideRange;
            } else if(this.mCanSlide && this.mParallaxBy != 0) {
               var19 = (int)((1.0F - this.mSlideOffset) * (float)this.mParallaxBy);
               var12 = var13;
            } else {
               var12 = var13;
               var19 = 0;
            }

            int var21;
            int var20;
            if(var6) {
               var21 = var19 + (var7 - var12);
               var20 = var21 - var18;
            } else {
               var20 = var12 - var19;
               var21 = var20 + var18;
            }

            var16.layout(var20, var10, var21, var10 + var16.getMeasuredHeight());
            var13 += var16.getWidth();
         }
      }

      if(this.mFirstLayout) {
         if(this.mCanSlide) {
            if(this.mParallaxBy != 0) {
               this.parallaxOtherViews(this.mSlideOffset);
            }

            if(((SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams()).dimWhenOffset) {
               this.dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
         } else {
            for(int var15 = 0; var15 < var11; ++var15) {
               this.dimChildView(this.getChildAt(var15), 0.0F, this.mSliderFadeColor);
            }
         }

         this.updateObscuredViewsVisibility(this.mSlideableView);
      }

      this.mFirstLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var1);
      int var4 = MeasureSpec.getSize(var1);
      int var5 = MeasureSpec.getMode(var2);
      int var6 = MeasureSpec.getSize(var2);
      if(var3 != 1073741824) {
         if(!this.isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
         }

         if(var3 != Integer.MIN_VALUE && var3 == 0) {
            var4 = 300;
         }
      } else if(var5 == 0) {
         if(!this.isInEditMode()) {
            throw new IllegalStateException("Height must not be UNSPECIFIED");
         }

         if(var5 == 0) {
            var5 = Integer.MIN_VALUE;
            var6 = 300;
         }
      }

      int var7 = -1;
      int var8 = 0;
      switch(var5) {
      case Integer.MIN_VALUE:
         var7 = var6 - this.getPaddingTop() - this.getPaddingBottom();
         var8 = 0;
         break;
      case 1073741824:
         var7 = var6 - this.getPaddingTop() - this.getPaddingBottom();
         var8 = var7;
      }

      float var9 = 0.0F;
      boolean var10 = false;
      int var11 = var4 - this.getPaddingLeft() - this.getPaddingRight();
      int var12 = var11;
      int var13 = this.getChildCount();
      if(var13 > 2) {
         Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
      }

      this.mSlideableView = null;

      for(int var14 = 0; var14 < var13; ++var14) {
         View var26 = this.getChildAt(var14);
         SlidingPaneLayout.LayoutParams var27 = (SlidingPaneLayout.LayoutParams)var26.getLayoutParams();
         if(var26.getVisibility() == 8) {
            var27.dimWhenOffset = false;
         } else {
            if(var27.weight > 0.0F) {
               var9 += var27.weight;
               if(var27.width == 0) {
                  continue;
               }
            }

            int var28 = var27.leftMargin + var27.rightMargin;
            int var29;
            if(var27.width == -2) {
               var29 = MeasureSpec.makeMeasureSpec(var11 - var28, Integer.MIN_VALUE);
            } else if(var27.width == -1) {
               var29 = MeasureSpec.makeMeasureSpec(var11 - var28, 1073741824);
            } else {
               var29 = MeasureSpec.makeMeasureSpec(var27.width, 1073741824);
            }

            int var30;
            if(var27.height == -2) {
               var30 = MeasureSpec.makeMeasureSpec(var7, Integer.MIN_VALUE);
            } else if(var27.height == -1) {
               var30 = MeasureSpec.makeMeasureSpec(var7, 1073741824);
            } else {
               var30 = MeasureSpec.makeMeasureSpec(var27.height, 1073741824);
            }

            var26.measure(var29, var30);
            int var31 = var26.getMeasuredWidth();
            int var32 = var26.getMeasuredHeight();
            if(var5 == Integer.MIN_VALUE && var32 > var8) {
               var8 = Math.min(var32, var7);
            }

            var12 -= var31;
            boolean var33;
            if(var12 < 0) {
               var33 = true;
            } else {
               var33 = false;
            }

            var27.slideable = var33;
            var10 |= var33;
            if(var27.slideable) {
               this.mSlideableView = var26;
            }
         }
      }

      if(var10 || var9 > 0.0F) {
         int var15 = var11 - this.mOverhangSize;

         for(int var16 = 0; var16 < var13; ++var16) {
            View var17 = this.getChildAt(var16);
            if(var17.getVisibility() != 8) {
               SlidingPaneLayout.LayoutParams var18 = (SlidingPaneLayout.LayoutParams)var17.getLayoutParams();
               if(var17.getVisibility() != 8) {
                  boolean var19;
                  if(var18.width == 0 && var18.weight > 0.0F) {
                     var19 = true;
                  } else {
                     var19 = false;
                  }

                  int var20;
                  if(var19) {
                     var20 = 0;
                  } else {
                     var20 = var17.getMeasuredWidth();
                  }

                  if(var10 && var17 != this.mSlideableView) {
                     if(var18.width < 0 && (var20 > var15 || var18.weight > 0.0F)) {
                        int var25;
                        if(var19) {
                           if(var18.height == -2) {
                              var25 = MeasureSpec.makeMeasureSpec(var7, Integer.MIN_VALUE);
                           } else if(var18.height == -1) {
                              var25 = MeasureSpec.makeMeasureSpec(var7, 1073741824);
                           } else {
                              var25 = MeasureSpec.makeMeasureSpec(var18.height, 1073741824);
                           }
                        } else {
                           var25 = MeasureSpec.makeMeasureSpec(var17.getMeasuredHeight(), 1073741824);
                        }

                        var17.measure(MeasureSpec.makeMeasureSpec(var15, 1073741824), var25);
                     }
                  } else if(var18.weight > 0.0F) {
                     int var21;
                     if(var18.width == 0) {
                        if(var18.height == -2) {
                           var21 = MeasureSpec.makeMeasureSpec(var7, Integer.MIN_VALUE);
                        } else if(var18.height == -1) {
                           var21 = MeasureSpec.makeMeasureSpec(var7, 1073741824);
                        } else {
                           var21 = MeasureSpec.makeMeasureSpec(var18.height, 1073741824);
                        }
                     } else {
                        var21 = MeasureSpec.makeMeasureSpec(var17.getMeasuredHeight(), 1073741824);
                     }

                     if(var10) {
                        int var23 = var11 - (var18.leftMargin + var18.rightMargin);
                        int var24 = MeasureSpec.makeMeasureSpec(var23, 1073741824);
                        if(var20 != var23) {
                           var17.measure(var24, var21);
                        }
                     } else {
                        int var22 = Math.max(0, var12);
                        var17.measure(MeasureSpec.makeMeasureSpec(var20 + (int)(var18.weight * (float)var22 / var9), 1073741824), var21);
                     }
                  }
               }
            }
         }
      }

      this.setMeasuredDimension(var4, var8 + this.getPaddingTop() + this.getPaddingBottom());
      this.mCanSlide = var10;
      if(this.mDragHelper.getViewDragState() != 0 && !var10) {
         this.mDragHelper.abort();
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      SlidingPaneLayout.SavedState var2 = (SlidingPaneLayout.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      if(var2.isOpen) {
         this.openPane();
      } else {
         this.closePane();
      }

      this.mPreservedOpenState = var2.isOpen;
   }

   protected Parcelable onSaveInstanceState() {
      SlidingPaneLayout.SavedState var1 = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
      boolean var2;
      if(this.isSlideable()) {
         var2 = this.isOpen();
      } else {
         var2 = this.mPreservedOpenState;
      }

      var1.isOpen = var2;
      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(var1 != var3) {
         this.mFirstLayout = true;
      }

   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var3;
      if(!this.mCanSlide) {
         var3 = super.onTouchEvent(var1);
      } else {
         this.mDragHelper.processTouchEvent(var1);
         int var2 = var1.getAction();
         var3 = true;
         switch(var2 & 255) {
         case 0:
            float var10 = var1.getX();
            float var11 = var1.getY();
            this.mInitialMotionX = var10;
            this.mInitialMotionY = var11;
            return var3;
         case 1:
            if(this.isDimmed(this.mSlideableView)) {
               float var4 = var1.getX();
               float var5 = var1.getY();
               float var6 = var4 - this.mInitialMotionX;
               float var7 = var5 - this.mInitialMotionY;
               int var8 = this.mDragHelper.getTouchSlop();
               if(var6 * var6 + var7 * var7 < (float)(var8 * var8) && this.mDragHelper.isViewUnder(this.mSlideableView, (int)var4, (int)var5)) {
                  this.closePane(this.mSlideableView, 0);
                  return var3;
               }
            }
            break;
         default:
            return var3;
         }
      }

      return var3;
   }

   public boolean openPane() {
      return this.openPane(this.mSlideableView, 0);
   }

   public void requestChildFocus(View var1, View var2) {
      super.requestChildFocus(var1, var2);
      if(!this.isInTouchMode() && !this.mCanSlide) {
         boolean var3;
         if(var1 == this.mSlideableView) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.mPreservedOpenState = var3;
      }

   }

   void setAllChildrenVisible() {
      int var1 = 0;

      for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         if(var3.getVisibility() == 4) {
            var3.setVisibility(0);
         }
      }

   }

   public void setCoveredFadeColor(int var1) {
      this.mCoveredFadeColor = var1;
   }

   public void setPanelSlideListener(SlidingPaneLayout.PanelSlideListener var1) {
      this.mPanelSlideListener = var1;
   }

   public void setParallaxDistance(int var1) {
      this.mParallaxBy = var1;
      this.requestLayout();
   }

   @Deprecated
   public void setShadowDrawable(Drawable var1) {
      this.setShadowDrawableLeft(var1);
   }

   public void setShadowDrawableLeft(Drawable var1) {
      this.mShadowDrawableLeft = var1;
   }

   public void setShadowDrawableRight(Drawable var1) {
      this.mShadowDrawableRight = var1;
   }

   @Deprecated
   public void setShadowResource(int var1) {
      this.setShadowDrawable(this.getResources().getDrawable(var1));
   }

   public void setShadowResourceLeft(int var1) {
      this.setShadowDrawableLeft(this.getResources().getDrawable(var1));
   }

   public void setShadowResourceRight(int var1) {
      this.setShadowDrawableRight(this.getResources().getDrawable(var1));
   }

   public void setSliderFadeColor(int var1) {
      this.mSliderFadeColor = var1;
   }

   @Deprecated
   public void smoothSlideClosed() {
      this.closePane();
   }

   @Deprecated
   public void smoothSlideOpen() {
      this.openPane();
   }

   boolean smoothSlideTo(float var1, int var2) {
      if(this.mCanSlide) {
         boolean var3 = this.isLayoutRtlSupport();
         SlidingPaneLayout.LayoutParams var4 = (SlidingPaneLayout.LayoutParams)this.mSlideableView.getLayoutParams();
         int var5;
         if(var3) {
            int var6 = this.getPaddingRight() + var4.rightMargin;
            int var7 = this.mSlideableView.getWidth();
            var5 = (int)((float)this.getWidth() - ((float)var6 + var1 * (float)this.mSlideRange + (float)var7));
         } else {
            var5 = (int)((float)(this.getPaddingLeft() + var4.leftMargin) + var1 * (float)this.mSlideRange);
         }

         if(this.mDragHelper.smoothSlideViewTo(this.mSlideableView, var5, this.mSlideableView.getTop())) {
            this.setAllChildrenVisible();
            ViewCompat.postInvalidateOnAnimation(this);
            return true;
         }
      }

      return false;
   }

   void updateObscuredViewsVisibility(View var1) {
      boolean var2 = this.isLayoutRtlSupport();
      int var3;
      if(var2) {
         var3 = this.getWidth() - this.getPaddingRight();
      } else {
         var3 = this.getPaddingLeft();
      }

      int var4;
      if(var2) {
         var4 = this.getPaddingLeft();
      } else {
         var4 = this.getWidth() - this.getPaddingRight();
      }

      int var5 = this.getPaddingTop();
      int var6 = this.getHeight() - this.getPaddingBottom();
      int var7;
      int var8;
      int var9;
      int var10;
      if(var1 != null && viewIsOpaque(var1)) {
         var8 = var1.getLeft();
         var9 = var1.getRight();
         var10 = var1.getTop();
         var7 = var1.getBottom();
      } else {
         var7 = 0;
         var8 = 0;
         var9 = 0;
         var10 = 0;
      }

      int var11 = 0;

      for(int var12 = this.getChildCount(); var11 < var12; ++var11) {
         View var13 = this.getChildAt(var11);
         if(var13 == var1) {
            break;
         }

         int var14;
         if(var2) {
            var14 = var4;
         } else {
            var14 = var3;
         }

         int var15 = Math.max(var14, var13.getLeft());
         int var16 = Math.max(var5, var13.getTop());
         int var17;
         if(var2) {
            var17 = var3;
         } else {
            var17 = var4;
         }

         int var18 = Math.min(var17, var13.getRight());
         int var19 = Math.min(var6, var13.getBottom());
         byte var20;
         if(var15 >= var8 && var16 >= var10 && var18 <= var9 && var19 <= var7) {
            var20 = 4;
         } else {
            var20 = 0;
         }

         var13.setVisibility(var20);
      }

   }

   class AccessibilityDelegate extends AccessibilityDelegateCompat {
      private final Rect mTmpRect = new Rect();

      private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat var1, AccessibilityNodeInfoCompat var2) {
         Rect var3 = this.mTmpRect;
         var2.getBoundsInParent(var3);
         var1.setBoundsInParent(var3);
         var2.getBoundsInScreen(var3);
         var1.setBoundsInScreen(var3);
         var1.setVisibleToUser(var2.isVisibleToUser());
         var1.setPackageName(var2.getPackageName());
         var1.setClassName(var2.getClassName());
         var1.setContentDescription(var2.getContentDescription());
         var1.setEnabled(var2.isEnabled());
         var1.setClickable(var2.isClickable());
         var1.setFocusable(var2.isFocusable());
         var1.setFocused(var2.isFocused());
         var1.setAccessibilityFocused(var2.isAccessibilityFocused());
         var1.setSelected(var2.isSelected());
         var1.setLongClickable(var2.isLongClickable());
         var1.addAction(var2.getActions());
         var1.setMovementGranularities(var2.getMovementGranularities());
      }

      public boolean filter(View var1) {
         return SlidingPaneLayout.this.isDimmed(var1);
      }

      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
         super.onInitializeAccessibilityEvent(var1, var2);
         var2.setClassName(SlidingPaneLayout.class.getName());
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         AccessibilityNodeInfoCompat var3 = AccessibilityNodeInfoCompat.obtain(var2);
         super.onInitializeAccessibilityNodeInfo(var1, var3);
         this.copyNodeInfoNoChildren(var2, var3);
         var3.recycle();
         var2.setClassName(SlidingPaneLayout.class.getName());
         var2.setSource(var1);
         ViewParent var4 = ViewCompat.getParentForAccessibility(var1);
         if(var4 instanceof View) {
            var2.setParent((View)var4);
         }

         int var5 = SlidingPaneLayout.this.getChildCount();

         for(int var6 = 0; var6 < var5; ++var6) {
            View var7 = SlidingPaneLayout.this.getChildAt(var6);
            if(!this.filter(var7) && var7.getVisibility() == 0) {
               ViewCompat.setImportantForAccessibility(var7, 1);
               var2.addChild(var7);
            }
         }

      }

      public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
         return !this.filter(var2)?super.onRequestSendAccessibilityEvent(var1, var2, var3):false;
      }
   }

   private class DisableLayerRunnable implements Runnable {
      final View mChildView;

      DisableLayerRunnable(View var2) {
         this.mChildView = var2;
      }

      public void run() {
         if(this.mChildView.getParent() == SlidingPaneLayout.this) {
            ViewCompat.setLayerType(this.mChildView, 0, (Paint)null);
            SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
         }

         SlidingPaneLayout.this.mPostedRunnables.remove(this);
      }
   }

   private class DragHelperCallback extends ViewDragHelper.Callback {
      private DragHelperCallback() {
      }

      // $FF: synthetic method
      DragHelperCallback(Object var2) {
         this();
      }

      public int clampViewPositionHorizontal(View var1, int var2, int var3) {
         SlidingPaneLayout.LayoutParams var4 = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.mSlideableView.getLayoutParams();
         if(SlidingPaneLayout.this.isLayoutRtlSupport()) {
            int var7 = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.getPaddingRight() + var4.rightMargin + SlidingPaneLayout.this.mSlideableView.getWidth());
            int var8 = var7 - SlidingPaneLayout.this.mSlideRange;
            return Math.max(Math.min(var2, var7), var8);
         } else {
            int var5 = SlidingPaneLayout.this.getPaddingLeft() + var4.leftMargin;
            int var6 = var5 + SlidingPaneLayout.this.mSlideRange;
            return Math.min(Math.max(var2, var5), var6);
         }
      }

      public int clampViewPositionVertical(View var1, int var2, int var3) {
         return var1.getTop();
      }

      public int getViewHorizontalDragRange(View var1) {
         return SlidingPaneLayout.this.mSlideRange;
      }

      public void onEdgeDragStarted(int var1, int var2) {
         SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, var2);
      }

      public void onViewCaptured(View var1, int var2) {
         SlidingPaneLayout.this.setAllChildrenVisible();
      }

      public void onViewDragStateChanged(int var1) {
         if(SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
            if(SlidingPaneLayout.this.mSlideOffset != 0.0F) {
               SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
               SlidingPaneLayout.this.mPreservedOpenState = true;
               return;
            }

            SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
            SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
            SlidingPaneLayout.this.mPreservedOpenState = false;
         }

      }

      public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
         SlidingPaneLayout.this.onPanelDragged(var2);
         SlidingPaneLayout.this.invalidate();
      }

      public void onViewReleased(View var1, float var2, float var3) {
         SlidingPaneLayout.LayoutParams var4 = (SlidingPaneLayout.LayoutParams)var1.getLayoutParams();
         int var5;
         if(SlidingPaneLayout.this.isLayoutRtlSupport()) {
            int var7 = SlidingPaneLayout.this.getPaddingRight() + var4.rightMargin;
            if(var2 < 0.0F || var2 == 0.0F && SlidingPaneLayout.this.mSlideOffset > 0.5F) {
               var7 += SlidingPaneLayout.this.mSlideRange;
            }

            int var8 = SlidingPaneLayout.this.mSlideableView.getWidth();
            var5 = SlidingPaneLayout.this.getWidth() - var7 - var8;
         } else {
            var5 = SlidingPaneLayout.this.getPaddingLeft() + var4.leftMargin;
            if(var2 > 0.0F || var2 == 0.0F && SlidingPaneLayout.this.mSlideOffset > 0.5F) {
               var5 += SlidingPaneLayout.this.mSlideRange;
            }
         }

         SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(var5, var1.getTop());
         SlidingPaneLayout.this.invalidate();
      }

      public boolean tryCaptureView(View var1, int var2) {
         return SlidingPaneLayout.this.mIsUnableToDrag?false:((SlidingPaneLayout.LayoutParams)var1.getLayoutParams()).slideable;
      }
   }

   public static class LayoutParams extends MarginLayoutParams {
      private static final int[] ATTRS = new int[]{16843137};
      Paint dimPaint;
      boolean dimWhenOffset;
      boolean slideable;
      public float weight = 0.0F;

      public LayoutParams() {
         super(-1, -1);
      }

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, ATTRS);
         this.weight = var3.getFloat(0, 0.0F);
         var3.recycle();
      }

      public LayoutParams(SlidingPaneLayout.LayoutParams var1) {
         super(var1);
         this.weight = var1.weight;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }
   }

   public interface PanelSlideListener {
      void onPanelClosed(View var1);

      void onPanelOpened(View var1);

      void onPanelSlide(View var1, float var2);
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<SlidingPaneLayout.SavedState> CREATOR = new Creator() {
         public SlidingPaneLayout.SavedState createFromParcel(Parcel var1) {
            return new SlidingPaneLayout.SavedState(var1);
         }

         public SlidingPaneLayout.SavedState[] newArray(int var1) {
            return new SlidingPaneLayout.SavedState[var1];
         }
      };
      boolean isOpen;

      private SavedState(Parcel var1) {
         super(var1);
         boolean var2;
         if(var1.readInt() != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.isOpen = var2;
      }

      // $FF: synthetic method
      SavedState(Parcel var1, Object var2) {
         this(var1);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         byte var3;
         if(this.isOpen) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
      }
   }

   public static class SimplePanelSlideListener implements SlidingPaneLayout.PanelSlideListener {
      public void onPanelClosed(View var1) {
      }

      public void onPanelOpened(View var1) {
      }

      public void onPanelSlide(View var1, float var2) {
      }
   }

   interface SlidingPanelLayoutImpl {
      void invalidateChildRegion(SlidingPaneLayout var1, View var2);
   }

   static class SlidingPanelLayoutImplBase implements SlidingPaneLayout.SlidingPanelLayoutImpl {
      public void invalidateChildRegion(SlidingPaneLayout var1, View var2) {
         ViewCompat.postInvalidateOnAnimation(var1, var2.getLeft(), var2.getTop(), var2.getRight(), var2.getBottom());
      }
   }

   static class SlidingPanelLayoutImplJB extends SlidingPaneLayout.SlidingPanelLayoutImplBase {
      private Method mGetDisplayList;
      private Field mRecreateDisplayList;

      SlidingPanelLayoutImplJB() {
         try {
            this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
         } catch (NoSuchMethodException var5) {
            Log.e("SlidingPaneLayout", "Couldn\'t fetch getDisplayList method; dimming won\'t work right.", var5);
         }

         try {
            this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
            this.mRecreateDisplayList.setAccessible(true);
         } catch (NoSuchFieldException var4) {
            Log.e("SlidingPaneLayout", "Couldn\'t fetch mRecreateDisplayList field; dimming will be slow.", var4);
         }
      }

      public void invalidateChildRegion(SlidingPaneLayout var1, View var2) {
         if(this.mGetDisplayList != null && this.mRecreateDisplayList != null) {
            try {
               this.mRecreateDisplayList.setBoolean(var2, true);
               this.mGetDisplayList.invoke(var2, (Object[])null);
            } catch (Exception var4) {
               Log.e("SlidingPaneLayout", "Error refreshing display list state", var4);
            }

            super.invalidateChildRegion(var1, var2);
         } else {
            var2.invalidate();
         }
      }
   }

   static class SlidingPanelLayoutImplJBMR1 extends SlidingPaneLayout.SlidingPanelLayoutImplBase {
      public void invalidateChildRegion(SlidingPaneLayout var1, View var2) {
         ViewCompat.setLayerPaint(var2, ((SlidingPaneLayout.LayoutParams)var2.getLayoutParams()).dimPaint);
      }
   }
}
