package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.DrawerLayoutCompatApi21;
import android.support.v4.widget.DrawerLayoutImpl;
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
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements DrawerLayoutImpl {
   private static final boolean ALLOW_EDGE_LOCK = false;
   private static final boolean CAN_HIDE_DESCENDANTS = false;
   private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
   private static final int DEFAULT_SCRIM_COLOR = -1728053248;
   private static final int DRAWER_ELEVATION = 10;
   static final DrawerLayout.DrawerLayoutCompatImpl IMPL;
   private static final int[] LAYOUT_ATTRS;
   public static final int LOCK_MODE_LOCKED_CLOSED = 1;
   public static final int LOCK_MODE_LOCKED_OPEN = 2;
   public static final int LOCK_MODE_UNDEFINED = 3;
   public static final int LOCK_MODE_UNLOCKED = 0;
   private static final int MIN_DRAWER_MARGIN = 64;
   private static final int MIN_FLING_VELOCITY = 400;
   private static final int PEEK_DELAY = 160;
   private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
   public static final int STATE_DRAGGING = 1;
   public static final int STATE_IDLE = 0;
   public static final int STATE_SETTLING = 2;
   private static final String TAG = "DrawerLayout";
   private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
   private final DrawerLayout.ChildAccessibilityDelegate mChildAccessibilityDelegate;
   private boolean mChildrenCanceledTouch;
   private boolean mDisallowInterceptRequested;
   private boolean mDrawStatusBarBackground;
   private float mDrawerElevation;
   private int mDrawerState;
   private boolean mFirstLayout;
   private boolean mInLayout;
   private float mInitialMotionX;
   private float mInitialMotionY;
   private Object mLastInsets;
   private final DrawerLayout.ViewDragCallback mLeftCallback;
   private final ViewDragHelper mLeftDragger;
   @Deprecated
   @Nullable
   private DrawerLayout.DrawerListener mListener;
   private List<DrawerLayout.DrawerListener> mListeners;
   private int mLockModeEnd;
   private int mLockModeLeft;
   private int mLockModeRight;
   private int mLockModeStart;
   private int mMinDrawerMargin;
   private final ArrayList<View> mNonDrawerViews;
   private final DrawerLayout.ViewDragCallback mRightCallback;
   private final ViewDragHelper mRightDragger;
   private int mScrimColor;
   private float mScrimOpacity;
   private Paint mScrimPaint;
   private Drawable mShadowEnd;
   private Drawable mShadowLeft;
   private Drawable mShadowLeftResolved;
   private Drawable mShadowRight;
   private Drawable mShadowRightResolved;
   private Drawable mShadowStart;
   private Drawable mStatusBarBackground;
   private CharSequence mTitleLeft;
   private CharSequence mTitleRight;

   static {
      byte var0 = 1;
      int[] var1 = new int[var0];
      var1[0] = 16842931;
      LAYOUT_ATTRS = var1;
      byte var2;
      if(VERSION.SDK_INT >= 19) {
         var2 = var0;
      } else {
         var2 = 0;
      }

      CAN_HIDE_DESCENDANTS = (boolean)var2;
      if(VERSION.SDK_INT < 21) {
         var0 = 0;
      }

      SET_DRAWER_SHADOW_FROM_ELEVATION = (boolean)var0;
      if(VERSION.SDK_INT >= 21) {
         IMPL = new DrawerLayout.DrawerLayoutCompatImplApi21();
      } else {
         IMPL = new DrawerLayout.DrawerLayoutCompatImplBase();
      }
   }

   public DrawerLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public DrawerLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public DrawerLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mChildAccessibilityDelegate = new DrawerLayout.ChildAccessibilityDelegate();
      this.mScrimColor = -1728053248;
      this.mScrimPaint = new Paint();
      this.mFirstLayout = true;
      this.mLockModeLeft = 3;
      this.mLockModeRight = 3;
      this.mLockModeStart = 3;
      this.mLockModeEnd = 3;
      this.mShadowStart = null;
      this.mShadowEnd = null;
      this.mShadowLeft = null;
      this.mShadowRight = null;
      this.setDescendantFocusability(262144);
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
      ViewCompat.setImportantForAccessibility(this, 1);
      ViewCompat.setAccessibilityDelegate(this, new DrawerLayout.AccessibilityDelegate());
      ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
      if(ViewCompat.getFitsSystemWindows(this)) {
         IMPL.configureApplyInsets(this);
         this.mStatusBarBackground = IMPL.getDefaultStatusBarBackground(var1);
      }

      this.mDrawerElevation = 10.0F * var4;
      this.mNonDrawerViews = new ArrayList();
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

   private static boolean includeChildForAccessibility(View var0) {
      return ViewCompat.getImportantForAccessibility(var0) != 4 && ViewCompat.getImportantForAccessibility(var0) != 2;
   }

   private boolean mirror(Drawable var1, int var2) {
      if(var1 != null && DrawableCompat.isAutoMirrored(var1)) {
         DrawableCompat.setLayoutDirection(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   private Drawable resolveLeftShadow() {
      int var1 = ViewCompat.getLayoutDirection(this);
      if(var1 == 0) {
         if(this.mShadowStart != null) {
            this.mirror(this.mShadowStart, var1);
            return this.mShadowStart;
         }
      } else if(this.mShadowEnd != null) {
         this.mirror(this.mShadowEnd, var1);
         return this.mShadowEnd;
      }

      return this.mShadowLeft;
   }

   private Drawable resolveRightShadow() {
      int var1 = ViewCompat.getLayoutDirection(this);
      if(var1 == 0) {
         if(this.mShadowEnd != null) {
            this.mirror(this.mShadowEnd, var1);
            return this.mShadowEnd;
         }
      } else if(this.mShadowStart != null) {
         this.mirror(this.mShadowStart, var1);
         return this.mShadowStart;
      }

      return this.mShadowRight;
   }

   private void resolveShadowDrawables() {
      if(!SET_DRAWER_SHADOW_FROM_ELEVATION) {
         this.mShadowLeftResolved = this.resolveLeftShadow();
         this.mShadowRightResolved = this.resolveRightShadow();
      }
   }

   private void updateChildrenImportantForAccessibility(View var1, boolean var2) {
      int var3 = this.getChildCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         View var5 = this.getChildAt(var4);
         if((var2 || this.isDrawerView(var5)) && (!var2 || var5 != var1)) {
            ViewCompat.setImportantForAccessibility(var5, 4);
         } else {
            ViewCompat.setImportantForAccessibility(var5, 1);
         }
      }

   }

   public void addDrawerListener(@NonNull DrawerLayout.DrawerListener var1) {
      if(var1 != null) {
         if(this.mListeners == null) {
            this.mListeners = new ArrayList();
         }

         this.mListeners.add(var1);
      }
   }

   public void addFocusables(ArrayList<View> var1, int var2, int var3) {
      if(this.getDescendantFocusability() != 393216) {
         int var4 = this.getChildCount();
         boolean var5 = false;

         for(int var6 = 0; var6 < var4; ++var6) {
            View var10 = this.getChildAt(var6);
            if(this.isDrawerView(var10)) {
               if(this.isDrawerOpen(var10)) {
                  var5 = true;
                  var10.addFocusables(var1, var2, var3);
               }
            } else {
               this.mNonDrawerViews.add(var10);
            }
         }

         if(!var5) {
            int var7 = this.mNonDrawerViews.size();

            for(int var8 = 0; var8 < var7; ++var8) {
               View var9 = (View)this.mNonDrawerViews.get(var8);
               if(var9.getVisibility() == 0) {
                  var9.addFocusables(var1, var2, var3);
               }
            }
         }

         this.mNonDrawerViews.clear();
      }
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      super.addView(var1, var2, var3);
      if(this.findOpenDrawer() == null && !this.isDrawerView(var1)) {
         ViewCompat.setImportantForAccessibility(var1, 1);
      } else {
         ViewCompat.setImportantForAccessibility(var1, 4);
      }

      if(!CAN_HIDE_DESCENDANTS) {
         ViewCompat.setAccessibilityDelegate(var1, this.mChildAccessibilityDelegate);
      }

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
         DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
         if(this.mFirstLayout) {
            var2.onScreen = 0.0F;
            var2.openState = 0;
         } else {
            DrawerLayout.LayoutParams.access$176(var2, 4);
            if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
               this.mLeftDragger.smoothSlideViewTo(var1, -var1.getWidth(), var1.getTop());
            } else {
               this.mRightDragger.smoothSlideViewTo(var1, this.getWidth(), var1.getTop());
            }
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
      if((1 & var2.openState) == 1) {
         var2.openState = 0;
         if(this.mListeners != null) {
            for(int var5 = -1 + this.mListeners.size(); var5 >= 0; --var5) {
               ((DrawerLayout.DrawerListener)this.mListeners.get(var5)).onDrawerClosed(var1);
            }
         }

         this.updateChildrenImportantForAccessibility(var1, false);
         if(this.hasWindowFocus()) {
            View var4 = this.getRootView();
            if(var4 != null) {
               var4.sendAccessibilityEvent(32);
            }
         }
      }

   }

   void dispatchOnDrawerOpened(View var1) {
      DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if((1 & var2.openState) == 0) {
         var2.openState = 1;
         if(this.mListeners != null) {
            for(int var5 = -1 + this.mListeners.size(); var5 >= 0; --var5) {
               ((DrawerLayout.DrawerListener)this.mListeners.get(var5)).onDrawerOpened(var1);
            }
         }

         this.updateChildrenImportantForAccessibility(var1, true);
         if(this.hasWindowFocus()) {
            this.sendAccessibilityEvent(32);
         }

         var1.requestFocus();
      }

   }

   void dispatchOnDrawerSlide(View var1, float var2) {
      if(this.mListeners != null) {
         for(int var3 = -1 + this.mListeners.size(); var3 >= 0; --var3) {
            ((DrawerLayout.DrawerListener)this.mListeners.get(var3)).onDrawerSlide(var1, var2);
         }
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
         if(this.mShadowLeftResolved != null && this.checkDrawerViewAbsoluteGravity(var2, 3)) {
            int var16 = this.mShadowLeftResolved.getIntrinsicWidth();
            int var17 = var2.getRight();
            int var18 = this.mLeftDragger.getEdgeSize();
            float var19 = Math.max(0.0F, Math.min((float)var17 / (float)var18, 1.0F));
            this.mShadowLeftResolved.setBounds(var17, var2.getTop(), var17 + var16, var2.getBottom());
            this.mShadowLeftResolved.setAlpha((int)(255.0F * var19));
            this.mShadowLeftResolved.draw(var1);
            return var10;
         }

         if(this.mShadowRightResolved != null && this.checkDrawerViewAbsoluteGravity(var2, 5)) {
            int var11 = this.mShadowRightResolved.getIntrinsicWidth();
            int var12 = var2.getLeft();
            int var13 = this.getWidth() - var12;
            int var14 = this.mRightDragger.getEdgeSize();
            float var15 = Math.max(0.0F, Math.min((float)var13 / (float)var14, 1.0F));
            this.mShadowRightResolved.setBounds(var12 - var11, var2.getTop(), var12, var2.getBottom());
            this.mShadowRightResolved.setAlpha((int)(255.0F * var15));
            this.mShadowRightResolved.draw(var1);
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
         if((1 & ((DrawerLayout.LayoutParams)var3.getLayoutParams()).openState) == 1) {
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

   public float getDrawerElevation() {
      return SET_DRAWER_SHADOW_FROM_ELEVATION?this.mDrawerElevation:0.0F;
   }

   public int getDrawerLockMode(int var1) {
      int var2 = ViewCompat.getLayoutDirection(this);
      switch(var1) {
      case 3:
         if(this.mLockModeLeft != 3) {
            return this.mLockModeLeft;
         }

         int var6;
         if(var2 == 0) {
            var6 = this.mLockModeStart;
         } else {
            var6 = this.mLockModeEnd;
         }

         if(var6 != 3) {
            return var6;
         }
         break;
      case 5:
         if(this.mLockModeRight != 3) {
            return this.mLockModeRight;
         }

         int var5;
         if(var2 == 0) {
            var5 = this.mLockModeEnd;
         } else {
            var5 = this.mLockModeStart;
         }

         if(var5 != 3) {
            return var5;
         }
         break;
      case 8388611:
         if(this.mLockModeStart != 3) {
            return this.mLockModeStart;
         }

         int var4;
         if(var2 == 0) {
            var4 = this.mLockModeLeft;
         } else {
            var4 = this.mLockModeRight;
         }

         if(var4 != 3) {
            return var4;
         }
         break;
      case 8388613:
         if(this.mLockModeEnd != 3) {
            return this.mLockModeEnd;
         }

         int var3;
         if(var2 == 0) {
            var3 = this.mLockModeRight;
         } else {
            var3 = this.mLockModeLeft;
         }

         if(var3 != 3) {
            return var3;
         }
      }

      return 0;
   }

   public int getDrawerLockMode(View var1) {
      if(!this.isDrawerView(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return this.getDrawerLockMode(((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity);
      }
   }

   @Nullable
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

   public Drawable getStatusBarBackgroundDrawable() {
      return this.mStatusBarBackground;
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
         return (1 & ((DrawerLayout.LayoutParams)var1.getLayoutParams()).openState) == 1;
      }
   }

   boolean isDrawerView(View var1) {
      int var2 = GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)var1.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(var1));
      return (var2 & 3) != 0?true:(var2 & 5) != 0;
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

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
         int var2 = IMPL.getTopInset(this.mLastInsets);
         if(var2 > 0) {
            this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), var2);
            this.mStatusBarBackground.draw(var1);
         }
      }

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
         float var13;
         int var10 = (var13 = this.mScrimOpacity - 0.0F) == 0.0F?0:(var13 < 0.0F?-1:1);
         var4 = false;
         if(var10 > 0) {
            View var11 = this.mLeftDragger.findTopChildUnder((int)var8, (int)var9);
            var4 = false;
            if(var11 != null) {
               boolean var12 = this.isContentView(var11);
               var4 = false;
               if(var12) {
                  var4 = true;
               }
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
      boolean var7;
      if(this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
         var7 = true;
      } else {
         var7 = false;
      }

      int var8 = ViewCompat.getLayoutDirection(this);
      boolean var9 = false;
      boolean var10 = false;
      int var11 = this.getChildCount();

      for(int var12 = 0; var12 < var11; ++var12) {
         View var13 = this.getChildAt(var12);
         if(var13.getVisibility() != 8) {
            DrawerLayout.LayoutParams var14 = (DrawerLayout.LayoutParams)var13.getLayoutParams();
            if(var7) {
               int var17 = GravityCompat.getAbsoluteGravity(var14.gravity, var8);
               if(ViewCompat.getFitsSystemWindows(var13)) {
                  IMPL.dispatchChildInsets(var13, this.mLastInsets, var17);
               } else {
                  IMPL.applyMarginInsets(var14, this.mLastInsets, var17);
               }
            }

            if(this.isContentView(var13)) {
               var13.measure(MeasureSpec.makeMeasureSpec(var5 - var14.leftMargin - var14.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec(var6 - var14.topMargin - var14.bottomMargin, 1073741824));
            } else {
               if(!this.isDrawerView(var13)) {
                  throw new IllegalStateException("Child " + var13 + " at index " + var12 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
               }

               if(SET_DRAWER_SHADOW_FROM_ELEVATION && ViewCompat.getElevation(var13) != this.mDrawerElevation) {
                  ViewCompat.setElevation(var13, this.mDrawerElevation);
               }

               int var15 = 7 & this.getDrawerViewAbsoluteGravity(var13);
               boolean var16;
               if(var15 == 3) {
                  var16 = true;
               } else {
                  var16 = false;
               }

               if(var16 && var9 || !var16 && var10) {
                  throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(var15) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
               }

               if(var16) {
                  var9 = true;
               } else {
                  var10 = true;
               }

               var13.measure(getChildMeasureSpec(var1, this.mMinDrawerMargin + var14.leftMargin + var14.rightMargin, var14.width), getChildMeasureSpec(var2, var14.topMargin + var14.bottomMargin, var14.height));
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

      if(var2.lockModeLeft != 3) {
         this.setDrawerLockMode(var2.lockModeLeft, 3);
      }

      if(var2.lockModeRight != 3) {
         this.setDrawerLockMode(var2.lockModeRight, 5);
      }

      if(var2.lockModeStart != 3) {
         this.setDrawerLockMode(var2.lockModeStart, 8388611);
      }

      if(var2.lockModeEnd != 3) {
         this.setDrawerLockMode(var2.lockModeEnd, 8388613);
      }

   }

   public void onRtlPropertiesChanged(int var1) {
      this.resolveShadowDrawables();
   }

   protected Parcelable onSaveInstanceState() {
      DrawerLayout.SavedState var1 = new DrawerLayout.SavedState(super.onSaveInstanceState());
      int var2 = this.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         DrawerLayout.LayoutParams var4 = (DrawerLayout.LayoutParams)this.getChildAt(var3).getLayoutParams();
         boolean var5;
         if(var4.openState == 1) {
            var5 = true;
         } else {
            var5 = false;
         }

         boolean var6;
         if(var4.openState == 2) {
            var6 = true;
         } else {
            var6 = false;
         }

         if(var5 || var6) {
            var1.openDrawerGravity = var4.gravity;
            break;
         }
      }

      var1.lockModeLeft = this.mLockModeLeft;
      var1.lockModeRight = this.mLockModeRight;
      var1.lockModeStart = this.mLockModeStart;
      var1.lockModeEnd = this.mLockModeEnd;
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
         DrawerLayout.LayoutParams var2 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
         if(this.mFirstLayout) {
            var2.onScreen = 1.0F;
            var2.openState = 1;
            this.updateChildrenImportantForAccessibility(var1, true);
         } else {
            DrawerLayout.LayoutParams.access$176(var2, 2);
            if(this.checkDrawerViewAbsoluteGravity(var1, 3)) {
               this.mLeftDragger.smoothSlideViewTo(var1, 0, var1.getTop());
            } else {
               this.mRightDragger.smoothSlideViewTo(var1, this.getWidth() - var1.getWidth(), var1.getTop());
            }
         }

         this.invalidate();
      }
   }

   public void removeDrawerListener(@NonNull DrawerLayout.DrawerListener var1) {
      if(var1 != null) {
         this.mListeners.remove(var1);
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

   public void setChildInsets(Object var1, boolean var2) {
      this.mLastInsets = var1;
      this.mDrawStatusBarBackground = var2;
      boolean var3;
      if(!var2 && this.getBackground() == null) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.setWillNotDraw(var3);
      this.requestLayout();
   }

   public void setDrawerElevation(float var1) {
      this.mDrawerElevation = var1;

      for(int var2 = 0; var2 < this.getChildCount(); ++var2) {
         View var3 = this.getChildAt(var2);
         if(this.isDrawerView(var3)) {
            ViewCompat.setElevation(var3, this.mDrawerElevation);
         }
      }

   }

   @Deprecated
   public void setDrawerListener(DrawerLayout.DrawerListener var1) {
      if(this.mListener != null) {
         this.removeDrawerListener(this.mListener);
      }

      if(var1 != null) {
         this.addDrawerListener(var1);
      }

      this.mListener = var1;
   }

   public void setDrawerLockMode(int var1) {
      this.setDrawerLockMode(var1, 3);
      this.setDrawerLockMode(var1, 5);
   }

   public void setDrawerLockMode(int var1, int var2) {
      int var3 = GravityCompat.getAbsoluteGravity(var2, ViewCompat.getLayoutDirection(this));
      switch(var2) {
      case 3:
         this.mLockModeLeft = var1;
         break;
      case 5:
         this.mLockModeRight = var1;
         break;
      case 8388611:
         this.mLockModeStart = var1;
         break;
      case 8388613:
         this.mLockModeEnd = var1;
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

   public void setDrawerShadow(@DrawableRes int var1, int var2) {
      this.setDrawerShadow(this.getResources().getDrawable(var1), var2);
   }

   public void setDrawerShadow(Drawable var1, int var2) {
      if(!SET_DRAWER_SHADOW_FROM_ELEVATION) {
         if((var2 & 8388611) == 8388611) {
            this.mShadowStart = var1;
         } else if((var2 & 8388613) == 8388613) {
            this.mShadowEnd = var1;
         } else if((var2 & 3) == 3) {
            this.mShadowLeft = var1;
         } else {
            if((var2 & 5) != 5) {
               return;
            }

            this.mShadowRight = var1;
         }

         this.resolveShadowDrawables();
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

   public void setScrimColor(@ColorInt int var1) {
      this.mScrimColor = var1;
      this.invalidate();
   }

   public void setStatusBarBackground(int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = ContextCompat.getDrawable(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.mStatusBarBackground = var2;
      this.invalidate();
   }

   public void setStatusBarBackground(Drawable var1) {
      this.mStatusBarBackground = var1;
      this.invalidate();
   }

   public void setStatusBarBackgroundColor(@ColorInt int var1) {
      this.mStatusBarBackground = new ColorDrawable(var1);
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
         DrawerLayout.LayoutParams var8 = (DrawerLayout.LayoutParams)var3.getLayoutParams();
         if(var8.onScreen == 0.0F) {
            this.dispatchOnDrawerClosed(var3);
         } else if(var8.onScreen == 1.0F) {
            this.dispatchOnDrawerOpened(var3);
         }
      }

      if(var6 != this.mDrawerState) {
         this.mDrawerState = var6;
         if(this.mListeners != null) {
            for(int var7 = -1 + this.mListeners.size(); var7 >= 0; --var7) {
               ((DrawerLayout.DrawerListener)this.mListeners.get(var7)).onDrawerStateChanged(var6);
            }
         }
      }

   }

   class AccessibilityDelegate extends AccessibilityDelegateCompat {
      private final Rect mTmpRect = new Rect();

      private void addChildrenForAccessibility(AccessibilityNodeInfoCompat var1, ViewGroup var2) {
         int var3 = var2.getChildCount();

         for(int var4 = 0; var4 < var3; ++var4) {
            View var5 = var2.getChildAt(var4);
            if(DrawerLayout.includeChildForAccessibility(var5)) {
               var1.addChild(var5);
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

      public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
         super.onInitializeAccessibilityEvent(var1, var2);
         var2.setClassName(DrawerLayout.class.getName());
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         if(DrawerLayout.CAN_HIDE_DESCENDANTS) {
            super.onInitializeAccessibilityNodeInfo(var1, var2);
         } else {
            AccessibilityNodeInfoCompat var3 = AccessibilityNodeInfoCompat.obtain(var2);
            super.onInitializeAccessibilityNodeInfo(var1, var3);
            var2.setSource(var1);
            ViewParent var4 = ViewCompat.getParentForAccessibility(var1);
            if(var4 instanceof View) {
               var2.setParent((View)var4);
            }

            this.copyNodeInfoNoChildren(var2, var3);
            var3.recycle();
            this.addChildrenForAccessibility(var2, (ViewGroup)var1);
         }

         var2.setClassName(DrawerLayout.class.getName());
         var2.setFocusable(false);
         var2.setFocused(false);
         var2.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
         var2.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
      }

      public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
         return !DrawerLayout.CAN_HIDE_DESCENDANTS && !DrawerLayout.includeChildForAccessibility(var2)?false:super.onRequestSendAccessibilityEvent(var1, var2, var3);
      }
   }

   final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         super.onInitializeAccessibilityNodeInfo(var1, var2);
         if(!DrawerLayout.includeChildForAccessibility(var1)) {
            var2.setParent((View)null);
         }

      }
   }

   interface DrawerLayoutCompatImpl {
      void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3);

      void configureApplyInsets(View var1);

      void dispatchChildInsets(View var1, Object var2, int var3);

      Drawable getDefaultStatusBarBackground(Context var1);

      int getTopInset(Object var1);
   }

   static class DrawerLayoutCompatImplApi21 implements DrawerLayout.DrawerLayoutCompatImpl {
      public void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3) {
         DrawerLayoutCompatApi21.applyMarginInsets(var1, var2, var3);
      }

      public void configureApplyInsets(View var1) {
         DrawerLayoutCompatApi21.configureApplyInsets(var1);
      }

      public void dispatchChildInsets(View var1, Object var2, int var3) {
         DrawerLayoutCompatApi21.dispatchChildInsets(var1, var2, var3);
      }

      public Drawable getDefaultStatusBarBackground(Context var1) {
         return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(var1);
      }

      public int getTopInset(Object var1) {
         return DrawerLayoutCompatApi21.getTopInset(var1);
      }
   }

   static class DrawerLayoutCompatImplBase implements DrawerLayout.DrawerLayoutCompatImpl {
      public void applyMarginInsets(MarginLayoutParams var1, Object var2, int var3) {
      }

      public void configureApplyInsets(View var1) {
      }

      public void dispatchChildInsets(View var1, Object var2, int var3) {
      }

      public Drawable getDefaultStatusBarBackground(Context var1) {
         return null;
      }

      public int getTopInset(Object var1) {
         return 0;
      }
   }

   public interface DrawerListener {
      void onDrawerClosed(View var1);

      void onDrawerOpened(View var1);

      void onDrawerSlide(View var1, float var2);

      void onDrawerStateChanged(int var1);
   }

   public static class LayoutParams extends MarginLayoutParams {
      private static final int FLAG_IS_CLOSING = 4;
      private static final int FLAG_IS_OPENED = 1;
      private static final int FLAG_IS_OPENING = 2;
      public int gravity;
      private boolean isPeeking;
      private float onScreen;
      private int openState;

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

      // $FF: synthetic method
      static int access$176(DrawerLayout.LayoutParams var0, int var1) {
         int var2 = var1 | var0.openState;
         var0.openState = var2;
         return var2;
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
      int lockModeEnd;
      int lockModeLeft;
      int lockModeRight;
      int lockModeStart;
      int openDrawerGravity = 0;

      public SavedState(Parcel var1) {
         super(var1);
         this.openDrawerGravity = var1.readInt();
         this.lockModeLeft = var1.readInt();
         this.lockModeRight = var1.readInt();
         this.lockModeStart = var1.readInt();
         this.lockModeEnd = var1.readInt();
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.openDrawerGravity);
         var1.writeInt(this.lockModeLeft);
         var1.writeInt(this.lockModeRight);
         var1.writeInt(this.lockModeStart);
         var1.writeInt(this.lockModeEnd);
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
            int var8 = 0;
            if(var3 != null) {
               var8 = -var3.getWidth();
            }

            var4 = var8 + var1;
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
         return DrawerLayout.this.isDrawerView(var1)?var1.getWidth():0;
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
