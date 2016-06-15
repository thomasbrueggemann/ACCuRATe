package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class DrawerLayout extends ViewGroup {
   private static final boolean ALLOW_EDGE_LOCK = false;
   private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
   private static final int DEFAULT_SCRIM_COLOR = -1728053248;
   private static final int[] LAYOUT_ATTRS = new int[]{16842931};
   public static final int LOCK_MODE_LOCKED_CLOSED = 1;
   public static final int LOCK_MODE_LOCKED_OPEN = 2;
   public static final int LOCK_MODE_UNLOCKED = 0;
   private static final int MIN_DRAWER_MARGIN = 64;
   private static final int MIN_FLING_VELOCITY = 400;
   private static final int PEEK_DELAY = 160;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   private static final String TAG = "DrawerLayout";
   private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
   private boolean mChildrenCanceledTouch;
   private boolean mDisallowInterceptRequested;
   private int mDrawerState;
   private boolean mFirstLayout;
   private boolean mInLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private final DrawerLayout.ViewDragCallback mLeftCallback;
   private final ViewDragHelper mLeftDragger;
   private DrawerLayout.DrawerListener mListener;
   private int mLockModeLeft;
   private int mLockModeRight;
   private int mMinDrawerMargin;
   private final DrawerLayout.ViewDragCallback mRightCallback;
   private final ViewDragHelper mRightDragger;
   private int mScrimColor;
   private float mScrimOpacity;
   private Paint mScrimPaint;
   private Drawable mShadowLeft;
   private Drawable mShadowRight;
   private CharSequence mTitleLeft;
   private CharSequence mTitleRight;

   public DrawerLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public DrawerLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public DrawerLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mScrimColor = -1728053248;
      this.mScrimPaint = new Paint();
      this.mFirstLayout = true;
      float var4 = this.getResources().getDisplayMetrics().density;
      this.mMinDrawerMargin = (int)(0.5F + 64.0F * var4);
      float var5 = 400.0F * var4;
      this.mLeftCallback = new DrawerLayout.ViewDragCallback(3);
      this.mRightCallback = new DrawerLayout.ViewDragCallback(5);
      this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
      this.mLeftDragger.setEdgeTrackingEnabled(1);
      this.mLeftDragger.setMinVelocity(var5);
      this.mLeftCallback.setDragger(this.mLeftDragger);
      this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
      this.mRightDragger.setEdgeTrackingEnabled(2);
      this.mRightDragger.setMinVelocity(var5);
      this.mRightCallback.setDragger(this.mRightDragger);
      this.setFocusableInTouchMode(true);
      ViewCompat.setAccessibilityDelegate(this, new DrawerLayout.AccessibilityDelegate());
      ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
   }

   private View findVisibleDrawer() {
      int var1 = this.getChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         View var3 = this.getChildAt(var2);
         if(this.isDrawerView(var3) && this.isDrawerVisible(var3)) {
            return var3;
         }
      }

      return null;
   }

   static String gravityToString(int var0) {
      return (var0 & 3) == 3?"LEFT":((var0 & 5) == 5?"RIGHT":Integer.toHexString(var0));
   }

   private static boolean hasOpaqueBackground(View var0) {
      Drawable var1 = var0.getBackground();
      boolean var2 = false;
      if(var1 != null) {
         int var3 = var1.getOpacity();
         var2 = false;
         if(var3 == -1) {
            var2 = true;
         }
      }

      return var2;
   }

   private boolean hasPeekingDrawer() {
      int var1 = this.getChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         if(((DrawerLayout.LayoutParams)this.getChildAt(var2).getLayoutParams()).isPeeking) {
            return true;
         }
      }

      return false;
   }

   private boolean hasVisibleDrawer() {
      return this.findVisibleDrawer() != null;
   }

   void cancelChildViewTouch() {
      if(!this.mChildrenCanceledTouch) {
         long var1 = SystemClock.uptimeMillis();
         MotionEvent var3 = MotionEvent.obtain(var1, var1, 3, 0.0F, 0.0F, 0);
         int var4 = this.getChildCount();

         for(int var5 = 0; var5 < var4; ++var5) {
            this.getChildAt(var5).dispatchTouchEvent(var3);
         }

         var3.recycle();
         this.mChildrenCanceledTouch = true;
      }

   }

   boolean checkDrawerViewAbsoluteGravity(View var1, int var2) {
      return (var2 & this.getDrawerViewAbsoluteGravity(var1)) == var2;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof DrawerLayout.LayoutParams && super.checkLayoutParams(var1);
   }

   public void closeDrawer(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(var1));
      } else {
         this.closeDrawer(var2);
      }
   }

   public void closeDrawer(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      } else {
         if(this.mFirstLayout) {
            DrawerLayout.LayoutParams var4 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
            var4.onScreen = 0.0F;
            var4.knownOpen = false;
         } else if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            this.mLeftDragger.smoothSlideViewTo(var1, -var1.getWidth(), var1.getTop());
         } else {
            this.mRightDragger.smoothSlideViewTo(var1, this.getWidth(), var1.getTop());
         }

         this.invalidate();
      }
   }

   public void closeDrawers() {
      this.closeDrawers(false);
   }

   void closeDrawers(boolean var1) {
      boolean var2 = false;
      int var3 = this.getChildCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         View var5 = this.getChildAt(var4);
         DrawerLayout.LayoutParams var6 = (DrawerLayout.LayoutParams)var5.getLayoutParams();
         if(this.isDrawerView(var5) && (!var1 || var6.isPeeking)) {
            int var7 = var5.getWidth();
            if(this.checkDrawerViewAbsoluteGravity(var5, 3)) {
               var2 |= this.mLeftDragger.smoothSlideViewTo(var5, -var7, var5.getTop());
            } else {
               var2 |= this.mRightDragger.smoothSlideViewTo(var5, this.getWidth(), var5.getTop());
            }

            var6.isPeeking = false;
         }
      }

      this.mLeftCallback.removeCallbacks();
      this.mRightCallback.removeCallbacks();
      if(var2) {
         this.invalidate();
      }

   }

   public void computeScroll() {
      int var1 = this.getChildCount();
      float var2 = 0.0F;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = Math.max(var2, ((DrawerLayout.LayoutParams)this.getChildAt(var3).getLayoutParams()).onScreen);
      }

      this.mScrimOpacity = var2;
      if(this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true)) {
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   void dispatchOnDrawerClosed(View var1) {
      DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if(var2.knownOpen) {
         var2.knownOpen = false;
         if(this.mListener != null) {
            this.mListener.onDrawerClosed(var1);
         }

         if(this.hasWindowFocus()) {
            View var3 = this.getRootView();
            if(var3 != null) {
               var3.sendAccessibilityEvent(32);
            }
         }
      }

   }

   void dispatchOnDrawerOpened(View var1) {
      DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if(!var2.knownOpen) {
         var2.knownOpen = true;
         if(this.mListener != null) {
            this.mListener.onDrawerOpened(var1);
         }

         this.sendAccessibilityEvent(32);
      }

   }

   void dispatchOnDrawerSlide(View var1, float var2) {
      if(this.mListener != null) {
         this.mListener.onDrawerSlide(var1, var2);
      }

   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      int var5 = this.getHeight();
      boolean var6 = this.isContentView(var2);
      int var7 = this.getWidth();
      int var8 = var1.save();
      int var9 = 0;
      if(var6) {
         int var21 = this.getChildCount();

         for(int var22 = 0; var22 < var21; ++var22) {
            View var24 = this.getChildAt(var22);
            if(var24 != var2 && var24.getVisibility() == 0 && hasOpaqueBackground(var24) && this.isDrawerView(var24) && var24.getHeight() >= var5) {
               if(this.checkDrawerViewAbsoluteGravity(var24, 3)) {
                  int var26 = var24.getRight();
                  if(var26 > var9) {
                     var9 = var26;
                  }
               } else {
                  int var25 = var24.getLeft();
                  if(var25 < var7) {
                     var7 = var25;
                  }
               }
            }
         }

         var1.clipRect(var9, 0, var7, this.getHeight());
      }

      boolean var10 = super.drawChild(var1, var2, var3);
      var1.restoreToCount(var8);
      if(this.mScrimOpacity > 0.0F && var6) {
         int var20 = (int)((float)((-16777216 & this.mScrimColor) >>> 24) * this.mScrimOpacity) << 24 | 16777215 & this.mScrimColor;
         this.mScrimPaint.setColor(var20);
         var1.drawRect((float)var9, 0.0F, (float)var7, (float)this.getHeight(), this.mScrimPaint);
      } else {
         if(this.mShadowLeft != null && this.checkDrawerViewAbsoluteGravity(var2, 3)) {
            int var16 = this.mShadowLeft.getIntrinsicWidth();
            int var17 = var2.getRight();
            int var18 = this.mLeftDragger.getEdgeSize();
            float var19 = Math.max(0.0F, Math.min((float)var17 / (float)var18, 1.0F));
            this.mShadowLeft.setBounds(var17, var2.getTop(), var17 + var16, var2.getBottom());
            this.mShadowLeft.setAlpha((int)(255.0F * var19));
            this.mShadowLeft.draw(var1);
            return var10;
         }

         if(this.mShadowRight != null && this.checkDrawerViewAbsoluteGravity(var2, 5)) {
            int var11 = this.mShadowRight.getIntrinsicWidth();
            int var12 = var2.getLeft();
            int var13 = this.getWidth() - var12;
            int var14 = this.mRightDragger.getEdgeSize();
            float var15 = Math.max(0.0F, Math.min((float)var13 / (float)var14, 1.0F));
            this.mShadowRight.setBounds(var12 - var11, var2.getTop(), var12, var2.getBottom());
            this.mShadowRight.setAlpha((int)(255.0F * var15));
            this.mShadowRight.draw(var1);
            return var10;
         }
      }

      return var10;
   }

   View findDrawerWithGravity(int var1) {
      int var2 = 7 & GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      int var3 = this.getChildCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         View var5 = this.getChildAt(var4);
         if((7 & this.getDrawerViewAbsoluteGravity(var5)) == var2) {
            return var5;
         }
      }

      return null;
   }

   View findOpenDrawer() {
      int var1 = this.getChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         View var3 = this.getChildAt(var2);
         if(((DrawerLayout.LayoutParams)var3.getLayoutParams()).knownOpen) {
            return var3;
         }
      }

      return null;
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      return new DrawerLayout.LayoutParams(-1, -1);
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new DrawerLayout.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof DrawerLayout.LayoutParams?new DrawerLayout.LayoutParams((DrawerLayout.LayoutParams)var1):(var1 instanceof MarginLayoutParams?new DrawerLayout.LayoutParams((MarginLayoutParams)var1):new DrawerLayout.LayoutParams(var1));
   }

   public int getDrawerLockMode(int var1) {
      int var2 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      return var2 == 3?this.mLockModeLeft:(var2 == 5?this.mLockModeRight:0);
   }

   public int getDrawerLockMode(View var1) {
      int var2 = this.getDrawerViewAbsoluteGravity(var1);
      return var2 == 3?this.mLockModeLeft:(var2 == 5?this.mLockModeRight:0);
   }

   public CharSequence getDrawerTitle(int var1) {
      int var2 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      return var2 == 3?this.mTitleLeft:(var2 == 5?this.mTitleRight:null);
   }

   int getDrawerViewAbsoluteGravity(View var1) {
      return GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
   }

   float getDrawerViewOffset(View var1) {
      return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).onScreen;
   }

   boolean isContentView(View var1) {
      return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity == 0;
   }

   public boolean isDrawerOpen(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      return var2 != null?this.isDrawerOpen(var2):false;
   }

   public boolean isDrawerOpen(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).knownOpen;
      }
   }

   boolean isDrawerView(View var1) {
      return (7 & GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(var1))) != 0;
   }

   public boolean isDrawerVisible(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      return var2 != null?this.isDrawerVisible(var2):false;
   }

   public boolean isDrawerVisible(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).onScreen > 0.0F;
      }
   }

   void moveDrawerToOffset(View var1, float var2) {
      float var3 = this.getDrawerViewOffset(var1);
      int var4 = var1.getWidth();
      int var5 = (int)(var3 * (float)var4);
      int var6 = (int)(var2 * (float)var4) - var5;
      if(!this.checkDrawerViewAbsoluteGravity(var1, 3)) {
         var6 = -var6;
      }

      var1.offsetLeftAndRight(var6);
      this.setDrawerViewOffset(var1, var2);
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.mFirstLayout = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.mFirstLayout = true;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      boolean var3 = this.mLeftDragger.shouldInterceptTouchEvent(var1) | this.mRightDragger.shouldInterceptTouchEvent(var1);
      boolean var4 = false;
      switch(var2) {
      case 0:
         float var8 = var1.getX();
         float var9 = var1.getY();
         this.mInitialMotionX = var8;
         this.mInitialMotionY = var9;
         float var12;
         int var10 = (var12 = this.mScrimOpacity - 0.0F) == 0.0F?0:(var12 < 0.0F?-1:1);
         var4 = false;
         if(var10 > 0) {
            boolean var11 = this.isContentView(this.mLeftDragger.findTopChildUnder((int)var8, (int)var9));
            var4 = false;
            if(var11) {
               var4 = true;
            }
         }

         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         break;
      case 1:
      case 3:
         this.closeDrawers(true);
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         var4 = false;
         break;
      case 2:
         boolean var7 = this.mLeftDragger.checkTouchSlop(3);
         var4 = false;
         if(var7) {
            this.mLeftCallback.removeCallbacks();
            this.mRightCallback.removeCallbacks();
            var4 = false;
         }
      }

      boolean var5;
      if(!var3 && !var4 && !this.hasPeekingDrawer()) {
         boolean var6 = this.mChildrenCanceledTouch;
         var5 = false;
         if(!var6) {
            return var5;
         }
      }

      var5 = true;
      return var5;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4 && this.hasVisibleDrawer()) {
         KeyEventCompat.startTracking(var2);
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      if(var1 == 4) {
         View var3 = this.findVisibleDrawer();
         if(var3 != null && this.getDrawerLockMode(var3) == 0) {
            this.closeDrawers();
         }

         return var3 != null;
      } else {
         return super.onKeyUp(var1, var2);
      }
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.mInLayout = true;
      int var6 = var4 - var2;
      int var7 = this.getChildCount();

      for(int var8 = 0; var8 < var7; ++var8) {
         View var9 = this.getChildAt(var8);
         if(var9.getVisibility() != 8) {
            DrawerLayout.LayoutParams var10 = (DrawerLayout.LayoutParams)var9.getLayoutParams();
            if(this.isContentView(var9)) {
               var9.layout(var10.leftMargin, var10.topMargin, var10.leftMargin + var9.getMeasuredWidth(), var10.topMargin + var9.getMeasuredHeight());
            } else {
               int var11 = var9.getMeasuredWidth();
               int var12 = var9.getMeasuredHeight();
               int var13;
               float var14;
               if(this.checkDrawerViewAbsoluteGravity(var9, 3)) {
                  var13 = -var11 + (int)((float)var11 * var10.onScreen);
                  var14 = (float)(var11 + var13) / (float)var11;
               } else {
                  var13 = var6 - (int)((float)var11 * var10.onScreen);
                  var14 = (float)(var6 - var13) / (float)var11;
               }

               boolean var15;
               if(var14 != var10.onScreen) {
                  var15 = true;
               } else {
                  var15 = false;
               }

               switch(112 & var10.gravity) {
               case 16:
                  int var16 = var5 - var3;
                  int var17 = (var16 - var12) / 2;
                  if(var17 < var10.topMargin) {
                     var17 = var10.topMargin;
                  } else if(var17 + var12 > var16 - var10.bottomMargin) {
                     var17 = var16 - var10.bottomMargin - var12;
                  }

                  var9.layout(var13, var17, var13 + var11, var17 + var12);
                  break;
               case 80:
                  int var19 = var5 - var3;
                  var9.layout(var13, var19 - var10.bottomMargin - var9.getMeasuredHeight(), var13 + var11, var19 - var10.bottomMargin);
                  break;
               default:
                  var9.layout(var13, var10.topMargin, var13 + var11, var12 + var10.topMargin);
               }

               if(var15) {
                  this.setDrawerViewOffset(var9, var14);
               }

               byte var18;
               if(var10.onScreen > 0.0F) {
                  var18 = 0;
               } else {
                  var18 = 4;
               }

               if(var9.getVisibility() != var18) {
                  var9.setVisibility(var18);
               }
            }
         }
      }

      this.mInLayout = false;
      this.mFirstLayout = false;
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var1);
      int var4 = MeasureSpec.getMode(var2);
      int var5 = MeasureSpec.getSize(var1);
      int var6 = MeasureSpec.getSize(var2);
      if(var3 != 1073741824 || var4 != 1073741824) {
         if(!this.isInEditMode()) {
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
         }

         if(var3 != Integer.MIN_VALUE && var3 == 0) {
            var5 = 300;
         }

         if(var4 != Integer.MIN_VALUE && var4 == 0) {
            var6 = 300;
         }
      }

      this.setMeasuredDimension(var5, var6);
      int var7 = this.getChildCount();

      for(int var8 = 0; var8 < var7; ++var8) {
         View var9 = this.getChildAt(var8);
         if(var9.getVisibility() != 8) {
            DrawerLayout.LayoutParams var10 = (DrawerLayout.LayoutParams)var9.getLayoutParams();
            if(this.isContentView(var9)) {
               var9.measure(MeasureSpec.makeMeasureSpec(var5 - var10.leftMargin - var10.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec(var6 - var10.topMargin - var10.bottomMargin, 1073741824));
            } else {
               if(!this.isDrawerView(var9)) {
                  throw new IllegalStateException("Child " + var9 + " at index " + var8 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
               }

               int var11 = 7 & this.getDrawerViewAbsoluteGravity(var9);
               if((0 & var11) != 0) {
                  throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(var11) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
               }

               var9.measure(getChildMeasureSpec(var1, this.mMinDrawerMargin + var10.leftMargin + var10.rightMargin, var10.width), getChildMeasureSpec(var2, var10.topMargin + var10.bottomMargin, var10.height));
            }
         }
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      DrawerLayout.SavedState var2 = (DrawerLayout.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      if(var2.openDrawerGravity != 0) {
         View var3 = this.findDrawerWithGravity(var2.openDrawerGravity);
         if(var3 != null) {
            this.openDrawer(var3);
         }
      }

      this.setDrawerLockMode(var2.lockModeLeft, 3);
      this.setDrawerLockMode(var2.lockModeRight, 5);
   }

   protected Parcelable onSaveInstanceState() {
      DrawerLayout.SavedState var1 = new DrawerLayout.SavedState(super.onSaveInstanceState());
      int var2 = this.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         View var4 = this.getChildAt(var3);
         if(this.isDrawerView(var4)) {
            DrawerLayout.LayoutParams var5 = (DrawerLayout.LayoutParams)var4.getLayoutParams();
            if(var5.knownOpen) {
               var1.openDrawerGravity = var5.gravity;
               break;
            }
         }
      }

      var1.lockModeLeft = this.mLockModeLeft;
      var1.lockModeRight = this.mLockModeRight;
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.mLeftDragger.processTouchEvent(var1);
      this.mRightDragger.processTouchEvent(var1);
      switch(255 & var1.getAction()) {
      case 0:
         float var10 = var1.getX();
         float var11 = var1.getY();
         this.mInitialMotionX = var10;
         this.mInitialMotionY = var11;
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         return true;
      case 1:
         float var2 = var1.getX();
         float var3 = var1.getY();
         boolean var4 = true;
         View var5 = this.mLeftDragger.findTopChildUnder((int)var2, (int)var3);
         if(var5 != null && this.isContentView(var5)) {
            float var6 = var2 - this.mInitialMotionX;
            float var7 = var3 - this.mInitialMotionY;
            int var8 = this.mLeftDragger.getTouchSlop();
            if(var6 * var6 + var7 * var7 < (float)(var8 * var8)) {
               View var9 = this.findOpenDrawer();
               if(var9 != null) {
                  if(this.getDrawerLockMode(var9) == 2) {
                     var4 = true;
                  } else {
                     var4 = false;
                  }
               }
            }
         }

         this.closeDrawers(var4);
         this.mDisallowInterceptRequested = false;
         return true;
      case 2:
      default:
         return true;
      case 3:
         this.closeDrawers(true);
         this.mDisallowInterceptRequested = false;
         this.mChildrenCanceledTouch = false;
         return true;
      }
   }

   public void openDrawer(int var1) {
      View var2 = this.findDrawerWithGravity(var1);
      if(var2 == null) {
         throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(var1));
      } else {
         this.openDrawer(var2);
      }
   }

   public void openDrawer(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      } else {
         if(this.mFirstLayout) {
            DrawerLayout.LayoutParams var4 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
            var4.onScreen = 1.0F;
            var4.knownOpen = true;
         } else if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            this.mLeftDragger.smoothSlideViewTo(var1, 0, var1.getTop());
         } else {
            this.mRightDragger.smoothSlideViewTo(var1, this.getWidth() - var1.getWidth(), var1.getTop());
         }

         this.invalidate();
      }
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      super.requestDisallowInterceptTouchEvent(var1);
      this.mDisallowInterceptRequested = var1;
      if(var1) {
         this.closeDrawers(true);
      }

   }

   public void requestLayout() {
      if(!this.mInLayout) {
         super.requestLayout();
      }

   }

   public void setDrawerListener(DrawerLayout.DrawerListener var1) {
      this.mListener = var1;
   }

   public void setDrawerLockMode(int var1) {
      this.setDrawerLockMode(var1, 3);
      this.setDrawerLockMode(var1, 5);
   }

   public void setDrawerLockMode(int var1, int var2) {
      int var3 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      if(var3 == 3) {
         this.mLockModeLeft = var1;
      } else if(var3 == 5) {
         this.mLockModeRight = var1;
      }

      if(var1 != 0) {
         ViewDragHelper var6;
         if(var3 == 3) {
            var6 = this.mLeftDragger;
         } else {
            var6 = this.mRightDragger;
         }

         var6.cancel();
      }

      switch(var1) {
      case 1:
         View var4 = this.findDrawerWithGravity(var3);
         if(var4 != null) {
            this.closeDrawer(var4);
            return;
         }
         break;
      case 2:
         View var5 = this.findDrawerWithGravity(var3);
         if(var5 != null) {
            this.openDrawer(var5);
            return;
         }
      }

   }

   public void setDrawerLockMode(int var1, View var2) {
      if(!this.isDrawerView(var2)) {
         throw new IllegalArgumentException("View " + var2 + " is not a " + "drawer with appropriate layout_gravity");
      } else {
         this.setDrawerLockMode(var1, ((DrawerLayout.LayoutParams)var2.getLayoutParams()).gravity);
      }
   }

   public void setDrawerShadow(int var1, int var2) {
      this.setDrawerShadow(this.getResources().getDrawable(var1), var2);
   }

   public void setDrawerShadow(Drawable var1, int var2) {
      int var3 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      if((var3 & 3) == 3) {
         this.mShadowLeft = var1;
         this.invalidate();
      }

      if((var3 & 5) == 5) {
         this.mShadowRight = var1;
         this.invalidate();
      }

   }

   public void setDrawerTitle(int var1, CharSequence var2) {
      int var3 = GravityCompat.getAbsoluteGravity(var1, ViewCompat.getLayoutDirection(this));
      if(var3 == 3) {
         this.mTitleLeft = var2;
      } else if(var3 == 5) {
         this.mTitleRight = var2;
         return;
      }

   }

   void setDrawerViewOffset(View var1, float var2) {
      DrawerLayout.LayoutParams var3 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if(var2 != var3.onScreen) {
         var3.onScreen = var2;
         this.dispatchOnDrawerSlide(var1, var2);
      }
   }

   public void setScrimColor(int var1) {
      this.mScrimColor = var1;
      this.invalidate();
   }

   void updateDrawerState(int var1, int var2, View var3) {
      int var4 = this.mLeftDragger.getViewDragState();
      int var5 = this.mRightDragger.getViewDragState();
      byte var6;
      if(var4 != 1 && var5 != 1) {
         if(var4 != 2 && var5 != 2) {
            var6 = 0;
         } else {
            var6 = 2;
         }
      } else {
         var6 = 1;
      }

      if(var3 != null && var2 == 0) {
         DrawerLayout.LayoutParams var7 = (DrawerLayout.LayoutParams)var3.getLayoutParams();
         if(var7.onScreen == 0.0F) {
            this.dispatchOnDrawerClosed(var3);
         } else if(var7.onScreen == 1.0F) {
            this.dispatchOnDrawerOpened(var3);
         }
      }

      if(var6 != this.mDrawerState) {
         this.mDrawerState = var6;
         if(this.mListener != null) {
            this.mListener.onDrawerStateChanged(var6);
         }
      }

   }

   class AccessibilityDelegate extends AccessibilityDelegateCompat {
      private final Rect mTmpRect = new Rect();

      private void addChildrenForAccessibility(AccessibilityNodeInfoCompat var1, ViewGroup var2) {
         int var3 = var2.getChildCount();

         for(int var4 = 0; var4 < var3; ++var4) {
            View var5 = var2.getChildAt(var4);
            if(!this.filter(var5)) {
               switch(ViewCompat.getImportantForAccessibility(var5)) {
               case 0:
                  ViewCompat.setImportantForAccessibility(var5, 1);
               case 1:
                  var1.addChild(var5);
                  break;
               case 2:
                  if(var5 instanceof ViewGroup) {
                     this.addChildrenForAccessibility(var1, (ViewGroup)var5);
                  }
               case 3:
               case 4:
               }
            }
         }

      }

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
      }

      public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
         if(var2.getEventType() == 32) {
            List var3 = var2.getText();
            View var4 = DrawerLayout.this.findVisibleDrawer();
            if(var4 != null) {
               int var5 = DrawerLayout.this.getDrawerViewAbsoluteGravity(var4);
               CharSequence var6 = DrawerLayout.this.getDrawerTitle(var5);
               if(var6 != null) {
                  var3.add(var6);
               }
            }

            return true;
         } else {
            return super.dispatchPopulateAccessibilityEvent(var1, var2);
         }
      }

      public boolean filter(View var1) {
         View var2 = DrawerLayout.this.findOpenDrawer();
         return var2 != null && var2 != var1;
      }

      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
         super.onInitializeAccessibilityEvent(var1, var2);
         var2.setClassName(DrawerLayout.class.getName());
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         AccessibilityNodeInfoCompat var3 = AccessibilityNodeInfoCompat.obtain(var2);
         super.onInitializeAccessibilityNodeInfo(var1, var3);
         var2.setClassName(DrawerLayout.class.getName());
         var2.setSource(var1);
         ViewParent var4 = ViewCompat.getParentForAccessibility(var1);
         if(var4 instanceof View) {
            var2.setParent((View)var4);
         }

         this.copyNodeInfoNoChildren(var2, var3);
         var3.recycle();
         this.addChildrenForAccessibility(var2, (ViewGroup)var1);
      }

      public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
         return !this.filter(var2)?super.onRequestSendAccessibilityEvent(var1, var2, var3):false;
      }
   }

   public interface DrawerListener {
      void onDrawerClosed(View var1);

      void onDrawerOpened(View var1);

      void onDrawerSlide(View var1, float var2);

      void onDrawerStateChanged(int var1);
   }

   public static class LayoutParams extends MarginLayoutParams {
      public int gravity;
      boolean isPeeking;
      boolean knownOpen;
      float onScreen;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
         this.gravity = 0;
      }

      public LayoutParams(int var1, int var2, int var3) {
         this(var1, var2);
         this.gravity = var3;
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         this.gravity = 0;
         TypedArray var3 = var1.obtainStyledAttributes(var2, DrawerLayout.LAYOUT_ATTRS);
         this.gravity = var3.getInt(0, 0);
         var3.recycle();
      }

      public LayoutParams(DrawerLayout.LayoutParams var1) {
         super(var1);
         this.gravity = 0;
         this.gravity = var1.gravity;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
         this.gravity = 0;
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
         this.gravity = 0;
      }
   }

   protected static class SavedState extends BaseSavedState {
      public static final Creator<DrawerLayout.SavedState> CREATOR = new Creator() {
         public DrawerLayout.SavedState createFromParcel(Parcel var1) {
            return new DrawerLayout.SavedState(var1);
         }

         public DrawerLayout.SavedState[] newArray(int var1) {
            return new DrawerLayout.SavedState[var1];
         }
      };
      int lockModeLeft = 0;
      int lockModeRight = 0;
      int openDrawerGravity = 0;

      public SavedState(Parcel var1) {
         super(var1);
         this.openDrawerGravity = var1.readInt();
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.openDrawerGravity);
      }
   }

   public abstract static class SimpleDrawerListener implements DrawerLayout.DrawerListener {
      public void onDrawerClosed(View var1) {
      }

      public void onDrawerOpened(View var1) {
      }

      public void onDrawerSlide(View var1, float var2) {
      }

      public void onDrawerStateChanged(int var1) {
      }
   }

   private class ViewDragCallback extends ViewDragHelper.Callback {
      private final int mAbsGravity;
      private ViewDragHelper mDragger;
      private final Runnable mPeekRunnable = new Runnable() {
         public void run() {
            ViewDragCallback.this.peekDrawer();
         }
      };

      public ViewDragCallback(int var2) {
         this.mAbsGravity = var2;
      }

      private void closeOtherDrawer() {
         byte var1 = 3;
         if(this.mAbsGravity == var1) {
            var1 = 5;
         }

         View var2 = DrawerLayout.this.findDrawerWithGravity(var1);
         if(var2 != null) {
            DrawerLayout.this.closeDrawer(var2);
         }

      }

      private void peekDrawer() {
         int var1 = this.mDragger.getEdgeSize();
         boolean var2;
         if(this.mAbsGravity == 3) {
            var2 = true;
         } else {
            var2 = false;
         }

         View var3;
         int var4;
         if(var2) {
            var3 = DrawerLayout.this.findDrawerWithGravity(3);
            int var7 = 0;
            if(var3 != null) {
               var7 = -var3.getWidth();
            }

            var4 = var7 + var1;
         } else {
            var3 = DrawerLayout.this.findDrawerWithGravity(5);
            var4 = DrawerLayout.this.getWidth() - var1;
         }

         if(var3 != null && (var2 && var3.getLeft() < var4 || !var2 && var3.getLeft() > var4) && DrawerLayout.this.getDrawerLockMode(var3) == 0) {
            DrawerLayout.LayoutParams var5 = (DrawerLayout.LayoutParams)var3.getLayoutParams();
            this.mDragger.smoothSlideViewTo(var3, var4, var3.getTop());
            var5.isPeeking = true;
            DrawerLayout.this.invalidate();
            this.closeOtherDrawer();
            DrawerLayout.this.cancelChildViewTouch();
         }

      }

      public int clampViewPositionHorizontal(View var1, int var2, int var3) {
         if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            return Math.max(-var1.getWidth(), Math.min(var2, 0));
         } else {
            int var4 = DrawerLayout.this.getWidth();
            return Math.max(var4 - var1.getWidth(), Math.min(var2, var4));
         }
      }

      public int clampViewPositionVertical(View var1, int var2, int var3) {
         return var1.getTop();
      }

      public int getViewHorizontalDragRange(View var1) {
         return var1.getWidth();
      }

      public void onEdgeDragStarted(int var1, int var2) {
         View var3;
         if((var1 & 1) == 1) {
            var3 = DrawerLayout.this.findDrawerWithGravity(3);
         } else {
            var3 = DrawerLayout.this.findDrawerWithGravity(5);
         }

         if(var3 != null && DrawerLayout.this.getDrawerLockMode(var3) == 0) {
            this.mDragger.captureChildView(var3, var2);
         }

      }

      public boolean onEdgeLock(int var1) {
         return false;
      }

      public void onEdgeTouched(int var1, int var2) {
         DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
      }

      public void onViewCaptured(View var1, int var2) {
         ((DrawerLayout.LayoutParams)var1.getLayoutParams()).isPeeking = false;
         this.closeOtherDrawer();
      }

      public void onViewDragStateChanged(int var1) {
         DrawerLayout.this.updateDrawerState(this.mAbsGravity, var1, this.mDragger.getCapturedView());
      }

      public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
         int var6 = var1.getWidth();
         float var7;
         if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            var7 = (float)(var6 + var2) / (float)var6;
         } else {
            var7 = (float)(DrawerLayout.this.getWidth() - var2) / (float)var6;
         }

         DrawerLayout.this.setDrawerViewOffset(var1, var7);
         byte var8;
         if(var7 == 0.0F) {
            var8 = 4;
         } else {
            var8 = 0;
         }

         var1.setVisibility(var8);
         DrawerLayout.this.invalidate();
      }

      public void onViewReleased(View var1, float var2, float var3) {
         float var4 = DrawerLayout.this.getDrawerViewOffset(var1);
         int var5 = var1.getWidth();
         int var7;
         if(DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, 3)) {
            if(var2 <= 0.0F && (var2 != 0.0F || var4 <= 0.5F)) {
               var7 = -var5;
            } else {
               var7 = 0;
            }
         } else {
            int var6 = DrawerLayout.this.getWidth();
            if(var2 >= 0.0F && (var2 != 0.0F || var4 <= 0.5F)) {
               var7 = var6;
            } else {
               var7 = var6 - var5;
            }
         }

         this.mDragger.settleCapturedViewAt(var7, var1.getTop());
         DrawerLayout.this.invalidate();
      }

      public void removeCallbacks() {
         DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
      }

      public void setDragger(ViewDragHelper var1) {
         this.mDragger = var1;
      }

      public boolean tryCaptureView(View var1, int var2) {
         return DrawerLayout.this.isDrawerView(var1) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(var1, this.mAbsGravity) && DrawerLayout.this.getDrawerLockMode(var1) == 0;
      }
   }
}
