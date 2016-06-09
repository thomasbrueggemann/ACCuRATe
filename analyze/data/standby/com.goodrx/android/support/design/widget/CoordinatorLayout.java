package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.design.class_5;
import android.support.design.widget.CoordinatorLayoutInsetsHelper;
import android.support.design.widget.CoordinatorLayoutInsetsHelperLollipop;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ViewGroupUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent {
   static final Class<?>[] CONSTRUCTOR_PARAMS;
   static final CoordinatorLayoutInsetsHelper INSETS_HELPER;
   static final String TAG = "CoordinatorLayout";
   static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
   private static final int TYPE_ON_INTERCEPT = 0;
   private static final int TYPE_ON_TOUCH = 1;
   static final String WIDGET_PACKAGE_NAME;
   static final ThreadLocal<Map<String, Constructor<CoordinatorLayout.Behavior>>> sConstructors;
   private View mBehaviorTouchView;
   private final List<View> mDependencySortedChildren;
   private boolean mDrawStatusBarBackground;
   private boolean mIsAttachedToWindow;
   private int[] mKeylines;
   private WindowInsetsCompat mLastInsets;
   final Comparator<View> mLayoutDependencyComparator;
   private boolean mNeedsPreDrawListener;
   private View mNestedScrollingDirectChild;
   private final NestedScrollingParentHelper mNestedScrollingParentHelper;
   private View mNestedScrollingTarget;
   private OnHierarchyChangeListener mOnHierarchyChangeListener;
   private CoordinatorLayout.OnPreDrawListener mOnPreDrawListener;
   private Paint mScrimPaint;
   private Drawable mStatusBarBackground;
   private final List<View> mTempDependenciesList;
   private final int[] mTempIntPair;
   private final List<View> mTempList1;
   private final Rect mTempRect1;
   private final Rect mTempRect2;
   private final Rect mTempRect3;

   static {
      Package var0 = CoordinatorLayout.class.getPackage();
      String var1;
      if(var0 != null) {
         var1 = var0.getName();
      } else {
         var1 = null;
      }

      WIDGET_PACKAGE_NAME = var1;
      if(VERSION.SDK_INT >= 21) {
         TOP_SORTED_CHILDREN_COMPARATOR = new CoordinatorLayout.ViewElevationComparator();
         INSETS_HELPER = new CoordinatorLayoutInsetsHelperLollipop();
      } else {
         TOP_SORTED_CHILDREN_COMPARATOR = null;
         INSETS_HELPER = null;
      }

      CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
      sConstructors = new ThreadLocal();
   }

   public CoordinatorLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public CoordinatorLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CoordinatorLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mLayoutDependencyComparator = new Comparator() {
         public int compare(View var1, View var2) {
            return var1 == var2?0:(((CoordinatorLayout.LayoutParams)var1.getLayoutParams()).dependsOn(CoordinatorLayout.this, var1, var2)?1:(((CoordinatorLayout.LayoutParams)var2.getLayoutParams()).dependsOn(CoordinatorLayout.this, var2, var1)?-1:0));
         }
      };
      this.mDependencySortedChildren = new ArrayList();
      this.mTempList1 = new ArrayList();
      this.mTempDependenciesList = new ArrayList();
      this.mTempRect1 = new Rect();
      this.mTempRect2 = new Rect();
      this.mTempRect3 = new Rect();
      this.mTempIntPair = new int[2];
      this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
      ThemeUtils.checkAppCompatTheme(var1);
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_5.styleable.CoordinatorLayout, var3, class_5.style.Widget_Design_CoordinatorLayout);
      int var5 = var4.getResourceId(class_5.styleable.CoordinatorLayout_keylines, 0);
      if(var5 != 0) {
         Resources var6 = var1.getResources();
         this.mKeylines = var6.getIntArray(var5);
         float var7 = var6.getDisplayMetrics().density;
         int var8 = this.mKeylines.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            int[] var10 = this.mKeylines;
            var10[var9] = (int)(var7 * (float)var10[var9]);
         }
      }

      this.mStatusBarBackground = var4.getDrawable(class_5.styleable.CoordinatorLayout_statusBarBackground);
      var4.recycle();
      if(INSETS_HELPER != null) {
         INSETS_HELPER.setupForWindowInsets(this, new CoordinatorLayout.ApplyInsetsListener(null));
      }

      super.setOnHierarchyChangeListener(new CoordinatorLayout.HierarchyChangeListener(null));
   }

   private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat var1) {
      if(var1.isConsumed()) {
         return var1;
      } else {
         int var2 = 0;

         for(int var3 = this.getChildCount(); var2 < var3; ++var2) {
            View var4 = this.getChildAt(var2);
            if(ViewCompat.getFitsSystemWindows(var4)) {
               CoordinatorLayout.Behavior var5 = ((CoordinatorLayout.LayoutParams)var4.getLayoutParams()).getBehavior();
               if(var5 != null) {
                  var1 = var5.onApplyWindowInsets(this, var4, var1);
                  if(var1.isConsumed()) {
                     break;
                  }
               }
            }
         }

         return var1;
      }
   }

   private int getKeyline(int var1) {
      if(this.mKeylines == null) {
         Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + var1);
         return 0;
      } else if(var1 >= 0 && var1 < this.mKeylines.length) {
         return this.mKeylines[var1];
      } else {
         Log.e("CoordinatorLayout", "Keyline index " + var1 + " out of range for " + this);
         return 0;
      }
   }

   private void getTopSortedChildren(List<View> var1) {
      var1.clear();
      boolean var2 = this.isChildrenDrawingOrderEnabled();
      int var3 = this.getChildCount();

      for(int var4 = var3 - 1; var4 >= 0; --var4) {
         int var5;
         if(var2) {
            var5 = this.getChildDrawingOrder(var3, var4);
         } else {
            var5 = var4;
         }

         var1.add(this.getChildAt(var5));
      }

      if(TOP_SORTED_CHILDREN_COMPARATOR != null) {
         Collections.sort(var1, TOP_SORTED_CHILDREN_COMPARATOR);
      }

   }

   private void layoutChild(View var1, int var2) {
      CoordinatorLayout.LayoutParams var3 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      Rect var4 = this.mTempRect1;
      var4.set(this.getPaddingLeft() + var3.leftMargin, this.getPaddingTop() + var3.topMargin, this.getWidth() - this.getPaddingRight() - var3.rightMargin, this.getHeight() - this.getPaddingBottom() - var3.bottomMargin);
      if(this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(var1)) {
         var4.left += this.mLastInsets.getSystemWindowInsetLeft();
         var4.top += this.mLastInsets.getSystemWindowInsetTop();
         var4.right -= this.mLastInsets.getSystemWindowInsetRight();
         var4.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
      }

      Rect var5 = this.mTempRect2;
      GravityCompat.apply(resolveGravity(var3.gravity), var1.getMeasuredWidth(), var1.getMeasuredHeight(), var4, var5, var2);
      var1.layout(var5.left, var5.top, var5.right, var5.bottom);
   }

   private void layoutChildWithAnchor(View var1, View var2, int var3) {
      CoordinatorLayout.LayoutParams var10000 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      Rect var5 = this.mTempRect1;
      Rect var6 = this.mTempRect2;
      this.getDescendantRect(var2, var5);
      this.getDesiredAnchoredChildRect(var1, var3, var5, var6);
      var1.layout(var6.left, var6.top, var6.right, var6.bottom);
   }

   private void layoutChildWithKeyline(View var1, int var2, int var3) {
      CoordinatorLayout.LayoutParams var4 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      int var5 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(var4.gravity), var3);
      int var6 = var5 & 7;
      int var7 = var5 & 112;
      int var8 = this.getWidth();
      int var9 = this.getHeight();
      int var10 = var1.getMeasuredWidth();
      int var11 = var1.getMeasuredHeight();
      if(var3 == 1) {
         var2 = var8 - var2;
      }

      int var12 = this.getKeyline(var2) - var10;
      switch(var6) {
      case 1:
         var12 += var10 / 2;
         break;
      case 5:
         var12 += var10;
      }

      int var13 = 0;
      switch(var7) {
      case 16:
         var13 = 0 + var11 / 2;
         break;
      case 80:
         var13 = 0 + var11;
      }

      int var14 = Math.max(this.getPaddingLeft() + var4.leftMargin, Math.min(var12, var8 - this.getPaddingRight() - var10 - var4.rightMargin));
      int var15 = Math.max(this.getPaddingTop() + var4.topMargin, Math.min(var13, var9 - this.getPaddingBottom() - var11 - var4.bottomMargin));
      var1.layout(var14, var15, var14 + var10, var15 + var11);
   }

   static CoordinatorLayout.Behavior parseBehavior(Context param0, AttributeSet param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean performIntercept(MotionEvent var1, int var2) {
      boolean var3 = false;
      boolean var4 = false;
      MotionEvent var5 = null;
      int var6 = MotionEventCompat.getActionMasked(var1);
      List var7 = this.mTempList1;
      this.getTopSortedChildren(var7);
      int var8 = var7.size();

      for(int var9 = 0; var9 < var8; ++var9) {
         View var10 = (View)var7.get(var9);
         CoordinatorLayout.LayoutParams var11 = (CoordinatorLayout.LayoutParams)var10.getLayoutParams();
         CoordinatorLayout.Behavior var12 = var11.getBehavior();
         if((var3 || var4) && var6 != 0) {
            if(var12 != null) {
               if(var5 == null) {
                  long var17 = SystemClock.uptimeMillis();
                  var5 = MotionEvent.obtain(var17, var17, 3, 0.0F, 0.0F, 0);
               }

               switch(var2) {
               case 0:
                  var12.onInterceptTouchEvent(this, var10, var5);
                  break;
               case 1:
                  var12.onTouchEvent(this, var10, var5);
               }
            }
         } else {
            if(!var3 && var12 != null) {
               switch(var2) {
               case 0:
                  var3 = var12.onInterceptTouchEvent(this, var10, var1);
                  break;
               case 1:
                  var3 = var12.onTouchEvent(this, var10, var1);
               }

               if(var3) {
                  this.mBehaviorTouchView = var10;
               }
            }

            boolean var13 = var11.didBlockInteraction();
            boolean var14 = var11.isBlockingInteractionBelow(this, var10);
            if(var14 && !var13) {
               var4 = true;
            } else {
               var4 = false;
            }

            if(var14 && !var4) {
               break;
            }
         }
      }

      var7.clear();
      return var3;
   }

   private void prepareChildren() {
      this.mDependencySortedChildren.clear();
      int var1 = 0;

      for(int var2 = this.getChildCount(); var1 < var2; ++var1) {
         View var3 = this.getChildAt(var1);
         this.getResolvedLayoutParams(var3).findAnchorView(this, var3);
         this.mDependencySortedChildren.add(var3);
      }

      selectionSort(this.mDependencySortedChildren, this.mLayoutDependencyComparator);
   }

   private void resetTouchBehaviors() {
      if(this.mBehaviorTouchView != null) {
         CoordinatorLayout.Behavior var3 = ((CoordinatorLayout.LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
         if(var3 != null) {
            long var4 = SystemClock.uptimeMillis();
            MotionEvent var6 = MotionEvent.obtain(var4, var4, 3, 0.0F, 0.0F, 0);
            var3.onTouchEvent(this, this.mBehaviorTouchView, var6);
            var6.recycle();
         }

         this.mBehaviorTouchView = null;
      }

      int var1 = this.getChildCount();

      for(int var2 = 0; var2 < var1; ++var2) {
         ((CoordinatorLayout.LayoutParams)this.getChildAt(var2).getLayoutParams()).resetTouchBehaviorTracking();
      }

   }

   private static int resolveAnchoredChildGravity(int var0) {
      if(var0 == 0) {
         var0 = 17;
      }

      return var0;
   }

   private static int resolveGravity(int var0) {
      if(var0 == 0) {
         var0 = 8388659;
      }

      return var0;
   }

   private static int resolveKeylineGravity(int var0) {
      if(var0 == 0) {
         var0 = 8388661;
      }

      return var0;
   }

   private static void selectionSort(List<View> var0, Comparator<View> var1) {
      if(var0 != null && var0.size() >= 2) {
         View[] var2 = new View[var0.size()];
         var0.toArray(var2);
         int var4 = var2.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            int var8 = var5;

            for(int var9 = var5 + 1; var9 < var4; ++var9) {
               if(var1.compare(var2[var9], var2[var8]) < 0) {
                  var8 = var9;
               }
            }

            if(var5 != var8) {
               View var10 = var2[var8];
               var2[var8] = var2[var5];
               var2[var5] = var10;
            }
         }

         var0.clear();

         for(int var6 = 0; var6 < var4; ++var6) {
            var0.add(var2[var6]);
         }
      }

   }

   private WindowInsetsCompat setWindowInsets(WindowInsetsCompat var1) {
      boolean var2 = true;
      if(this.mLastInsets != var1) {
         this.mLastInsets = var1;
         boolean var3;
         if(var1 != null && var1.getSystemWindowInsetTop() > 0) {
            var3 = var2;
         } else {
            var3 = false;
         }

         this.mDrawStatusBarBackground = var3;
         if(this.mDrawStatusBarBackground || this.getBackground() != null) {
            var2 = false;
         }

         this.setWillNotDraw(var2);
         var1 = this.dispatchApplyWindowInsetsToBehaviors(var1);
         this.requestLayout();
      }

      return var1;
   }

   void addPreDrawListener() {
      if(this.mIsAttachedToWindow) {
         if(this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new CoordinatorLayout.OnPreDrawListener();
         }

         this.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
      }

      this.mNeedsPreDrawListener = true;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof CoordinatorLayout.LayoutParams && super.checkLayoutParams(var1);
   }

   void dispatchDependentViewRemoved(View var1) {
      int var2 = this.mDependencySortedChildren.size();
      boolean var3 = false;

      for(int var4 = 0; var4 < var2; ++var4) {
         View var5 = (View)this.mDependencySortedChildren.get(var4);
         if(var5 == var1) {
            var3 = true;
         } else if(var3) {
            CoordinatorLayout.LayoutParams var6 = (CoordinatorLayout.LayoutParams)var5.getLayoutParams();
            CoordinatorLayout.Behavior var7 = var6.getBehavior();
            if(var7 != null && var6.dependsOn(this, var5, var1)) {
               var7.onDependentViewRemoved(this, var5, var1);
            }
         }
      }

   }

   public void dispatchDependentViewsChanged(View var1) {
      int var2 = this.mDependencySortedChildren.size();
      boolean var3 = false;

      for(int var4 = 0; var4 < var2; ++var4) {
         View var5 = (View)this.mDependencySortedChildren.get(var4);
         if(var5 == var1) {
            var3 = true;
         } else if(var3) {
            CoordinatorLayout.LayoutParams var6 = (CoordinatorLayout.LayoutParams)var5.getLayoutParams();
            CoordinatorLayout.Behavior var7 = var6.getBehavior();
            if(var7 != null && var6.dependsOn(this, var5, var1)) {
               var7.onDependentViewChanged(this, var5, var1);
            }
         }
      }

   }

   void dispatchOnDependentViewChanged(boolean var1) {
      int var2 = ViewCompat.getLayoutDirection(this);
      int var3 = this.mDependencySortedChildren.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         View var5 = (View)this.mDependencySortedChildren.get(var4);
         CoordinatorLayout.LayoutParams var6 = (CoordinatorLayout.LayoutParams)var5.getLayoutParams();

         for(int var7 = 0; var7 < var4; ++var7) {
            View var15 = (View)this.mDependencySortedChildren.get(var7);
            if(var6.mAnchorDirectChild == var15) {
               this.offsetChildToAnchor(var5, var2);
            }
         }

         Rect var8 = this.mTempRect1;
         Rect var9 = this.mTempRect2;
         this.getLastChildRect(var5, var8);
         this.getChildRect(var5, true, var9);
         if(!var8.equals(var9)) {
            this.recordLastChildRect(var5, var9);

            for(int var10 = var4 + 1; var10 < var3; ++var10) {
               View var11 = (View)this.mDependencySortedChildren.get(var10);
               CoordinatorLayout.LayoutParams var12 = (CoordinatorLayout.LayoutParams)var11.getLayoutParams();
               CoordinatorLayout.Behavior var13 = var12.getBehavior();
               if(var13 != null && var13.layoutDependsOn(this, var11, var5)) {
                  if(!var1 && var12.getChangedAfterNestedScroll()) {
                     var12.resetChangedAfterNestedScroll();
                  } else {
                     boolean var14 = var13.onDependentViewChanged(this, var11, var5);
                     if(var1) {
                        var12.setChangedAfterNestedScroll(var14);
                     }
                  }
               }
            }
         }
      }

   }

   public boolean doViewsOverlap(View var1, View var2) {
      if(var1.getVisibility() == 0 && var2.getVisibility() == 0) {
         Rect var3 = this.mTempRect1;
         boolean var4;
         if(var1.getParent() != this) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.getChildRect(var1, var4, var3);
         Rect var5 = this.mTempRect2;
         boolean var6;
         if(var2.getParent() != this) {
            var6 = true;
         } else {
            var6 = false;
         }

         this.getChildRect(var2, var6, var5);
         return var3.left <= var5.right && var3.top <= var5.bottom && var3.right >= var5.left && var3.bottom >= var5.top;
      } else {
         return false;
      }
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
      if(var5.mBehavior != null && var5.mBehavior.getScrimOpacity(this, var2) > 0.0F) {
         if(this.mScrimPaint == null) {
            this.mScrimPaint = new Paint();
         }

         this.mScrimPaint.setColor(var5.mBehavior.getScrimColor(this, var2));
         var1.drawRect((float)this.getPaddingLeft(), (float)this.getPaddingTop(), (float)(this.getWidth() - this.getPaddingRight()), (float)(this.getHeight() - this.getPaddingBottom()), this.mScrimPaint);
      }

      return super.drawChild(var1, var2, var3);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var1 = this.getDrawableState();
      Drawable var2 = this.mStatusBarBackground;
      boolean var3 = false;
      if(var2 != null) {
         boolean var4 = var2.isStateful();
         var3 = false;
         if(var4) {
            var3 = false | var2.setState(var1);
         }
      }

      if(var3) {
         this.invalidate();
      }

   }

   void ensurePreDrawListener() {
      int var1 = this.getChildCount();
      int var2 = 0;

      boolean var3;
      while(true) {
         var3 = false;
         if(var2 >= var1) {
            break;
         }

         if(this.hasDependencies(this.getChildAt(var2))) {
            var3 = true;
            break;
         }

         ++var2;
      }

      if(var3 != this.mNeedsPreDrawListener) {
         if(!var3) {
            this.removePreDrawListener();
            return;
         }

         this.addPreDrawListener();
      }

   }

   protected CoordinatorLayout.LayoutParams generateDefaultLayoutParams() {
      return new CoordinatorLayout.LayoutParams(-2, -2);
   }

   public CoordinatorLayout.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new CoordinatorLayout.LayoutParams(this.getContext(), var1);
   }

   protected CoordinatorLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof CoordinatorLayout.LayoutParams?new CoordinatorLayout.LayoutParams((CoordinatorLayout.LayoutParams)var1):(var1 instanceof MarginLayoutParams?new CoordinatorLayout.LayoutParams((MarginLayoutParams)var1):new CoordinatorLayout.LayoutParams(var1));
   }

   void getChildRect(View var1, boolean var2, Rect var3) {
      if(!var1.isLayoutRequested() && var1.getVisibility() != 8) {
         if(var2) {
            this.getDescendantRect(var1, var3);
         } else {
            var3.set(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom());
         }
      } else {
         var3.set(0, 0, 0, 0);
      }
   }

   public List<View> getDependencies(View var1) {
      CoordinatorLayout.LayoutParams var2 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      List var3 = this.mTempDependenciesList;
      var3.clear();
      int var4 = this.getChildCount();

      for(int var5 = 0; var5 < var4; ++var5) {
         View var6 = this.getChildAt(var5);
         if(var6 != var1 && var2.dependsOn(this, var1, var6)) {
            var3.add(var6);
         }
      }

      return var3;
   }

   void getDescendantRect(View var1, Rect var2) {
      ViewGroupUtils.getDescendantRect(this, var1, var2);
   }

   void getDesiredAnchoredChildRect(View var1, int var2, Rect var3, Rect var4) {
      CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      int var6 = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(var5.gravity), var2);
      int var7 = GravityCompat.getAbsoluteGravity(resolveGravity(var5.anchorGravity), var2);
      int var8 = var6 & 7;
      int var9 = var6 & 112;
      int var10 = var7 & 7;
      int var11 = var7 & 112;
      int var12 = var1.getMeasuredWidth();
      int var13 = var1.getMeasuredHeight();
      int var14;
      switch(var10) {
      case 1:
         var14 = var3.left + var3.width() / 2;
         break;
      case 5:
         var14 = var3.right;
         break;
      default:
         var14 = var3.left;
      }

      int var15;
      switch(var11) {
      case 16:
         var15 = var3.top + var3.height() / 2;
         break;
      case 80:
         var15 = var3.bottom;
         break;
      default:
         var15 = var3.top;
      }

      switch(var8) {
      case 1:
         var14 -= var12 / 2;
      case 5:
         break;
      default:
         var14 -= var12;
      }

      switch(var9) {
      case 16:
         var15 -= var13 / 2;
      case 80:
         break;
      default:
         var15 -= var13;
      }

      int var16 = this.getWidth();
      int var17 = this.getHeight();
      int var18 = Math.max(this.getPaddingLeft() + var5.leftMargin, Math.min(var14, var16 - this.getPaddingRight() - var12 - var5.rightMargin));
      int var19 = Math.max(this.getPaddingTop() + var5.topMargin, Math.min(var15, var17 - this.getPaddingBottom() - var13 - var5.bottomMargin));
      var4.set(var18, var19, var18 + var12, var19 + var13);
   }

   void getLastChildRect(View var1, Rect var2) {
      var2.set(((CoordinatorLayout.LayoutParams)var1.getLayoutParams()).getLastChildRect());
   }

   public int getNestedScrollAxes() {
      return this.mNestedScrollingParentHelper.getNestedScrollAxes();
   }

   CoordinatorLayout.LayoutParams getResolvedLayoutParams(View var1) {
      CoordinatorLayout.LayoutParams var2 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if(!var2.mBehaviorResolved) {
         Class var3 = var1.getClass();

         CoordinatorLayout.DefaultBehavior var4;
         for(var4 = null; var3 != null; var3 = var3.getSuperclass()) {
            var4 = (CoordinatorLayout.DefaultBehavior)var3.getAnnotation(CoordinatorLayout.DefaultBehavior.class);
            if(var4 != null) {
               break;
            }
         }

         if(var4 != null) {
            try {
               var2.setBehavior((CoordinatorLayout.Behavior)var4.value().newInstance());
            } catch (Exception var6) {
               Log.e("CoordinatorLayout", "Default behavior class " + var4.value().getName() + " could not be instantiated. Did you forget a default constructor?", var6);
            }
         }

         var2.mBehaviorResolved = true;
      }

      return var2;
   }

   @Nullable
   public Drawable getStatusBarBackground() {
      return this.mStatusBarBackground;
   }

   protected int getSuggestedMinimumHeight() {
      return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
   }

   protected int getSuggestedMinimumWidth() {
      return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
   }

   boolean hasDependencies(View var1) {
      CoordinatorLayout.LayoutParams var2 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if(var2.mAnchorView != null) {
         return true;
      } else {
         int var3 = this.getChildCount();

         for(int var4 = 0; var4 < var3; ++var4) {
            View var5 = this.getChildAt(var4);
            if(var5 != var1 && var2.dependsOn(this, var1, var5)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean isPointInChildBounds(View var1, int var2, int var3) {
      Rect var4 = this.mTempRect1;
      this.getDescendantRect(var1, var4);
      return var4.contains(var2, var3);
   }

   void offsetChildToAnchor(View var1, int var2) {
      CoordinatorLayout.LayoutParams var3 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if(var3.mAnchorView != null) {
         Rect var4 = this.mTempRect1;
         Rect var5 = this.mTempRect2;
         Rect var6 = this.mTempRect3;
         this.getDescendantRect(var3.mAnchorView, var4);
         this.getChildRect(var1, false, var5);
         this.getDesiredAnchoredChildRect(var1, var2, var4, var6);
         int var7 = var6.left - var5.left;
         int var8 = var6.top - var5.top;
         if(var7 != 0) {
            var1.offsetLeftAndRight(var7);
         }

         if(var8 != 0) {
            var1.offsetTopAndBottom(var8);
         }

         if(var7 != 0 || var8 != 0) {
            CoordinatorLayout.Behavior var9 = var3.getBehavior();
            if(var9 != null) {
               var9.onDependentViewChanged(this, var1, var3.mAnchorView);
            }
         }
      }

   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.resetTouchBehaviors();
      if(this.mNeedsPreDrawListener) {
         if(this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new CoordinatorLayout.OnPreDrawListener();
         }

         this.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
      }

      if(this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
         ViewCompat.requestApplyInsets(this);
      }

      this.mIsAttachedToWindow = true;
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.resetTouchBehaviors();
      if(this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
         this.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
      }

      if(this.mNestedScrollingTarget != null) {
         this.onStopNestedScroll(this.mNestedScrollingTarget);
      }

      this.mIsAttachedToWindow = false;
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      if(this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
         int var2;
         if(this.mLastInsets != null) {
            var2 = this.mLastInsets.getSystemWindowInsetTop();
         } else {
            var2 = 0;
         }

         if(var2 > 0) {
            this.mStatusBarBackground.setBounds(0, 0, this.getWidth(), var2);
            this.mStatusBarBackground.draw(var1);
         }
      }

   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var2 = MotionEventCompat.getActionMasked(var1);
      if(var2 == 0) {
         this.resetTouchBehaviors();
      }

      boolean var3 = this.performIntercept(var1, 0);
      if(false) {
         null.recycle();
      }

      if(var2 == 1 || var2 == 3) {
         this.resetTouchBehaviors();
      }

      return var3;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var6 = ViewCompat.getLayoutDirection(this);
      int var7 = this.mDependencySortedChildren.size();

      for(int var8 = 0; var8 < var7; ++var8) {
         View var9 = (View)this.mDependencySortedChildren.get(var8);
         CoordinatorLayout.Behavior var10 = ((CoordinatorLayout.LayoutParams)var9.getLayoutParams()).getBehavior();
         if(var10 == null || !var10.onLayoutChild(this, var9, var6)) {
            this.onLayoutChild(var9, var6);
         }
      }

   }

   public void onLayoutChild(View var1, int var2) {
      CoordinatorLayout.LayoutParams var3 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if(var3.checkAnchorChanged()) {
         throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
      } else if(var3.mAnchorView != null) {
         this.layoutChildWithAnchor(var1, var3.mAnchorView, var2);
      } else if(var3.keyline >= 0) {
         this.layoutChildWithKeyline(var1, var3.keyline, var2);
      } else {
         this.layoutChild(var1, var2);
      }
   }

   protected void onMeasure(int var1, int var2) {
      this.prepareChildren();
      this.ensurePreDrawListener();
      int var3 = this.getPaddingLeft();
      int var4 = this.getPaddingTop();
      int var5 = this.getPaddingRight();
      int var6 = this.getPaddingBottom();
      int var7 = ViewCompat.getLayoutDirection(this);
      boolean var8;
      if(var7 == 1) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var9 = MeasureSpec.getMode(var1);
      int var10 = MeasureSpec.getSize(var1);
      int var11 = MeasureSpec.getMode(var2);
      int var12 = MeasureSpec.getSize(var2);
      int var13 = var3 + var5;
      int var14 = var4 + var6;
      int var15 = this.getSuggestedMinimumWidth();
      int var16 = this.getSuggestedMinimumHeight();
      int var17 = 0;
      boolean var18;
      if(this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
         var18 = true;
      } else {
         var18 = false;
      }

      int var19 = this.mDependencySortedChildren.size();

      for(int var20 = 0; var20 < var19; ++var20) {
         View var24 = (View)this.mDependencySortedChildren.get(var20);
         CoordinatorLayout.LayoutParams var25 = (CoordinatorLayout.LayoutParams)var24.getLayoutParams();
         int var26 = var25.keyline;
         int var27 = 0;
         if(var26 >= 0) {
            var27 = 0;
            if(var9 != 0) {
               int var35 = this.getKeyline(var25.keyline);
               int var36 = 7 & GravityCompat.getAbsoluteGravity(resolveKeylineGravity(var25.gravity), var7);
               if(var36 == 3 && !var8 || var36 == 5 && var8) {
                  var27 = Math.max(0, var10 - var5 - var35);
               } else {
                  label92: {
                     if(var36 != 5 || var8) {
                        var27 = 0;
                        if(var36 != 3) {
                           break label92;
                        }

                        var27 = 0;
                        if(!var8) {
                           break label92;
                        }
                     }

                     var27 = Math.max(0, var35 - var3);
                  }
               }
            }
         }

         int var28 = var1;
         int var29 = var2;
         if(var18 && !ViewCompat.getFitsSystemWindows(var24)) {
            int var33 = this.mLastInsets.getSystemWindowInsetLeft() + this.mLastInsets.getSystemWindowInsetRight();
            int var34 = this.mLastInsets.getSystemWindowInsetTop() + this.mLastInsets.getSystemWindowInsetBottom();
            var28 = MeasureSpec.makeMeasureSpec(var10 - var33, var9);
            var29 = MeasureSpec.makeMeasureSpec(var12 - var34, var11);
         }

         CoordinatorLayout.Behavior var30 = var25.getBehavior();
         if(var30 == null || !var30.onMeasureChild(this, var24, var28, var27, var29, 0)) {
            this.onMeasureChild(var24, var28, var27, var29, 0);
         }

         int var31 = var13 + var24.getMeasuredWidth() + var25.leftMargin + var25.rightMargin;
         var15 = Math.max(var15, var31);
         int var32 = var14 + var24.getMeasuredHeight() + var25.topMargin + var25.bottomMargin;
         var16 = Math.max(var16, var32);
         var17 = ViewCompat.combineMeasuredStates(var17, ViewCompat.getMeasuredState(var24));
      }

      int var21 = -16777216 & var17;
      int var22 = ViewCompat.resolveSizeAndState(var15, var1, var21);
      int var23 = var17 << 16;
      this.setMeasuredDimension(var22, ViewCompat.resolveSizeAndState(var16, var2, var23));
   }

   public void onMeasureChild(View var1, int var2, int var3, int var4, int var5) {
      this.measureChildWithMargins(var1, var2, var3, var4, var5);
   }

   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      boolean var5 = false;
      int var6 = this.getChildCount();

      for(int var7 = 0; var7 < var6; ++var7) {
         View var8 = this.getChildAt(var7);
         CoordinatorLayout.LayoutParams var9 = (CoordinatorLayout.LayoutParams)var8.getLayoutParams();
         if(var9.isNestedScrollAccepted()) {
            CoordinatorLayout.Behavior var10 = var9.getBehavior();
            if(var10 != null) {
               var5 |= var10.onNestedFling(this, var8, var1, var2, var3, var4);
            }
         }
      }

      if(var5) {
         this.dispatchOnDependentViewChanged(true);
      }

      return var5;
   }

   public boolean onNestedPreFling(View var1, float var2, float var3) {
      boolean var4 = false;
      int var5 = this.getChildCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         View var7 = this.getChildAt(var6);
         CoordinatorLayout.LayoutParams var8 = (CoordinatorLayout.LayoutParams)var7.getLayoutParams();
         if(var8.isNestedScrollAccepted()) {
            CoordinatorLayout.Behavior var9 = var8.getBehavior();
            if(var9 != null) {
               var4 |= var9.onNestedPreFling(this, var7, var1, var2, var3);
            }
         }
      }

      return var4;
   }

   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
      int var5 = 0;
      int var6 = 0;
      boolean var7 = false;
      int var8 = this.getChildCount();

      for(int var9 = 0; var9 < var8; ++var9) {
         View var10 = this.getChildAt(var9);
         CoordinatorLayout.LayoutParams var11 = (CoordinatorLayout.LayoutParams)var10.getLayoutParams();
         if(var11.isNestedScrollAccepted()) {
            CoordinatorLayout.Behavior var12 = var11.getBehavior();
            if(var12 != null) {
               int[] var13 = this.mTempIntPair;
               this.mTempIntPair[1] = 0;
               var13[0] = 0;
               var12.onNestedPreScroll(this, var10, var1, var2, var3, this.mTempIntPair);
               if(var2 > 0) {
                  var5 = Math.max(var5, this.mTempIntPair[0]);
               } else {
                  var5 = Math.min(var5, this.mTempIntPair[0]);
               }

               if(var3 > 0) {
                  var6 = Math.max(var6, this.mTempIntPair[1]);
               } else {
                  var6 = Math.min(var6, this.mTempIntPair[1]);
               }

               var7 = true;
            }
         }
      }

      var4[0] = var5;
      var4[1] = var6;
      if(var7) {
         this.dispatchOnDependentViewChanged(true);
      }

   }

   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getChildCount();
      boolean var7 = false;

      for(int var8 = 0; var8 < var6; ++var8) {
         View var9 = this.getChildAt(var8);
         CoordinatorLayout.LayoutParams var10 = (CoordinatorLayout.LayoutParams)var9.getLayoutParams();
         if(var10.isNestedScrollAccepted()) {
            CoordinatorLayout.Behavior var11 = var10.getBehavior();
            if(var11 != null) {
               var11.onNestedScroll(this, var9, var1, var2, var3, var4, var5);
               var7 = true;
            }
         }
      }

      if(var7) {
         this.dispatchOnDependentViewChanged(true);
      }

   }

   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.mNestedScrollingParentHelper.onNestedScrollAccepted(var1, var2, var3);
      this.mNestedScrollingDirectChild = var1;
      this.mNestedScrollingTarget = var2;
      int var4 = this.getChildCount();

      for(int var5 = 0; var5 < var4; ++var5) {
         View var6 = this.getChildAt(var5);
         CoordinatorLayout.LayoutParams var7 = (CoordinatorLayout.LayoutParams)var6.getLayoutParams();
         if(var7.isNestedScrollAccepted()) {
            CoordinatorLayout.Behavior var8 = var7.getBehavior();
            if(var8 != null) {
               var8.onNestedScrollAccepted(this, var6, var1, var2, var3);
            }
         }
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      CoordinatorLayout.SavedState var2 = (CoordinatorLayout.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      SparseArray var3 = var2.behaviorStates;
      int var4 = 0;

      for(int var5 = this.getChildCount(); var4 < var5; ++var4) {
         View var6 = this.getChildAt(var4);
         int var7 = var6.getId();
         CoordinatorLayout.Behavior var8 = this.getResolvedLayoutParams(var6).getBehavior();
         if(var7 != -1 && var8 != null) {
            Parcelable var9 = (Parcelable)var3.get(var7);
            if(var9 != null) {
               var8.onRestoreInstanceState(this, var6, var9);
            }
         }
      }

   }

   protected Parcelable onSaveInstanceState() {
      CoordinatorLayout.SavedState var1 = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
      SparseArray var2 = new SparseArray();
      int var3 = 0;

      for(int var4 = this.getChildCount(); var3 < var4; ++var3) {
         View var5 = this.getChildAt(var3);
         int var6 = var5.getId();
         CoordinatorLayout.Behavior var7 = ((CoordinatorLayout.LayoutParams)var5.getLayoutParams()).getBehavior();
         if(var6 != -1 && var7 != null) {
            Parcelable var8 = var7.onSaveInstanceState(this, var5);
            if(var8 != null) {
               var2.append(var6, var8);
            }
         }
      }

      var1.behaviorStates = var2;
      return var1;
   }

   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      boolean var4 = false;
      int var5 = this.getChildCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         View var7 = this.getChildAt(var6);
         CoordinatorLayout.LayoutParams var8 = (CoordinatorLayout.LayoutParams)var7.getLayoutParams();
         CoordinatorLayout.Behavior var9 = var8.getBehavior();
         if(var9 != null) {
            boolean var10 = var9.onStartNestedScroll(this, var7, var1, var2, var3);
            var4 |= var10;
            var8.acceptNestedScroll(var10);
         } else {
            var8.acceptNestedScroll(false);
         }
      }

      return var4;
   }

   public void onStopNestedScroll(View var1) {
      this.mNestedScrollingParentHelper.onStopNestedScroll(var1);
      int var2 = this.getChildCount();

      for(int var3 = 0; var3 < var2; ++var3) {
         View var4 = this.getChildAt(var3);
         CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var4.getLayoutParams();
         if(var5.isNestedScrollAccepted()) {
            CoordinatorLayout.Behavior var6 = var5.getBehavior();
            if(var6 != null) {
               var6.onStopNestedScroll(this, var4, var1);
            }

            var5.resetNestedScroll();
            var5.resetChangedAfterNestedScroll();
         }
      }

      this.mNestedScrollingDirectChild = null;
      this.mNestedScrollingTarget = null;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      MotionEvent var2;
      int var3;
      boolean var5;
      boolean var7;
      label41: {
         var2 = null;
         var3 = MotionEventCompat.getActionMasked(var1);
         View var4 = this.mBehaviorTouchView;
         var5 = false;
         if(var4 == null) {
            var5 = this.performIntercept(var1, 1);
            var7 = false;
            if(!var5) {
               break label41;
            }
         }

         CoordinatorLayout.Behavior var6 = ((CoordinatorLayout.LayoutParams)this.mBehaviorTouchView.getLayoutParams()).getBehavior();
         var7 = false;
         if(var6 != null) {
            var7 = var6.onTouchEvent(this, this.mBehaviorTouchView, var1);
         }
      }

      if(this.mBehaviorTouchView == null) {
         var7 |= super.onTouchEvent(var1);
      } else {
         var2 = null;
         if(var5) {
            var2 = null;
            if(true) {
               long var9 = SystemClock.uptimeMillis();
               var2 = MotionEvent.obtain(var9, var9, 3, 0.0F, 0.0F, 0);
            }

            super.onTouchEvent(var2);
         }
      }

      if(!var7 && var3 == 0) {
         ;
      }

      if(var2 != null) {
         var2.recycle();
      }

      if(var3 == 1 || var3 == 3) {
         this.resetTouchBehaviors();
      }

      return var7;
   }

   void recordLastChildRect(View var1, Rect var2) {
      ((CoordinatorLayout.LayoutParams)var1.getLayoutParams()).setLastChildRect(var2);
   }

   void removePreDrawListener() {
      if(this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
         this.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
      }

      this.mNeedsPreDrawListener = false;
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      super.requestDisallowInterceptTouchEvent(var1);
      if(var1) {
         this.resetTouchBehaviors();
      }

   }

   public void setOnHierarchyChangeListener(OnHierarchyChangeListener var1) {
      this.mOnHierarchyChangeListener = var1;
   }

   public void setStatusBarBackground(@Nullable Drawable var1) {
      if(this.mStatusBarBackground != var1) {
         if(this.mStatusBarBackground != null) {
            this.mStatusBarBackground.setCallback((Callback)null);
         }

         Drawable var2 = null;
         if(var1 != null) {
            var2 = var1.mutate();
         }

         this.mStatusBarBackground = var2;
         if(this.mStatusBarBackground != null) {
            if(this.mStatusBarBackground.isStateful()) {
               this.mStatusBarBackground.setState(this.getDrawableState());
            }

            DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
            Drawable var3 = this.mStatusBarBackground;
            boolean var4;
            if(this.getVisibility() == 0) {
               var4 = true;
            } else {
               var4 = false;
            }

            var3.setVisible(var4, false);
            this.mStatusBarBackground.setCallback(this);
         }

         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void setStatusBarBackgroundColor(@ColorInt int var1) {
      this.setStatusBarBackground(new ColorDrawable(var1));
   }

   public void setStatusBarBackgroundResource(@DrawableRes int var1) {
      Drawable var2;
      if(var1 != 0) {
         var2 = ContextCompat.getDrawable(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setStatusBarBackground(var2);
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(this.mStatusBarBackground != null && this.mStatusBarBackground.isVisible() != var2) {
         this.mStatusBarBackground.setVisible(var2, false);
      }

   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mStatusBarBackground;
   }

   private class ApplyInsetsListener implements OnApplyWindowInsetsListener {
      private ApplyInsetsListener() {
      }

      // $FF: synthetic method
      ApplyInsetsListener(Object var2) {
         this();
      }

      public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
         return CoordinatorLayout.this.setWindowInsets(var2);
      }
   }

   public abstract static class Behavior<V extends View> {
      public Behavior() {
      }

      public Behavior(Context var1, AttributeSet var2) {
      }

      public static Object getTag(View var0) {
         return ((CoordinatorLayout.LayoutParams)var0.getLayoutParams()).mBehaviorTag;
      }

      public static void setTag(View var0, Object var1) {
         ((CoordinatorLayout.LayoutParams)var0.getLayoutParams()).mBehaviorTag = var1;
      }

      public boolean blocksInteractionBelow(CoordinatorLayout var1, V var2) {
         return this.getScrimOpacity(var1, var2) > 0.0F;
      }

      public int getScrimColor(CoordinatorLayout var1, V var2) {
         return -16777216;
      }

      public float getScrimOpacity(CoordinatorLayout var1, V var2) {
         return 0.0F;
      }

      public boolean isDirty(CoordinatorLayout var1, V var2) {
         return false;
      }

      public boolean layoutDependsOn(CoordinatorLayout var1, V var2, View var3) {
         return false;
      }

      public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout var1, V var2, WindowInsetsCompat var3) {
         return var3;
      }

      public boolean onDependentViewChanged(CoordinatorLayout var1, V var2, View var3) {
         return false;
      }

      public void onDependentViewRemoved(CoordinatorLayout var1, V var2, View var3) {
      }

      public boolean onInterceptTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
         return false;
      }

      public boolean onLayoutChild(CoordinatorLayout var1, V var2, int var3) {
         return false;
      }

      public boolean onMeasureChild(CoordinatorLayout var1, V var2, int var3, int var4, int var5, int var6) {
         return false;
      }

      public boolean onNestedFling(CoordinatorLayout var1, V var2, View var3, float var4, float var5, boolean var6) {
         return false;
      }

      public boolean onNestedPreFling(CoordinatorLayout var1, V var2, View var3, float var4, float var5) {
         return false;
      }

      public void onNestedPreScroll(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int[] var6) {
      }

      public void onNestedScroll(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int var6, int var7) {
      }

      public void onNestedScrollAccepted(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
      }

      public void onRestoreInstanceState(CoordinatorLayout var1, V var2, Parcelable var3) {
      }

      public Parcelable onSaveInstanceState(CoordinatorLayout var1, V var2) {
         return BaseSavedState.EMPTY_STATE;
      }

      public boolean onStartNestedScroll(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
         return false;
      }

      public void onStopNestedScroll(CoordinatorLayout var1, V var2, View var3) {
      }

      public boolean onTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
         return false;
      }
   }

   @Retention(RetentionPolicy.RUNTIME)
   public @interface DefaultBehavior {
      Class<? extends CoordinatorLayout.Behavior> value();
   }

   private class HierarchyChangeListener implements OnHierarchyChangeListener {
      private HierarchyChangeListener() {
      }

      // $FF: synthetic method
      HierarchyChangeListener(Object var2) {
         this();
      }

      public void onChildViewAdded(View var1, View var2) {
         if(CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
            CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(var1, var2);
         }

      }

      public void onChildViewRemoved(View var1, View var2) {
         CoordinatorLayout.this.dispatchDependentViewRemoved(var2);
         if(CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
            CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(var1, var2);
         }

      }
   }

   public static class LayoutParams extends MarginLayoutParams {
      public int anchorGravity = 0;
      public int gravity = 0;
      public int keyline = -1;
      View mAnchorDirectChild;
      int mAnchorId = -1;
      View mAnchorView;
      CoordinatorLayout.Behavior mBehavior;
      boolean mBehaviorResolved = false;
      Object mBehaviorTag;
      private boolean mDidAcceptNestedScroll;
      private boolean mDidBlockInteraction;
      private boolean mDidChangeAfterNestedScroll;
      final Rect mLastChildRect = new Rect();

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, class_5.styleable.CoordinatorLayout_LayoutParams);
         this.gravity = var3.getInteger(class_5.styleable.CoordinatorLayout_LayoutParams_android_layout_gravity, 0);
         this.mAnchorId = var3.getResourceId(class_5.styleable.CoordinatorLayout_LayoutParams_layout_anchor, -1);
         this.anchorGravity = var3.getInteger(class_5.styleable.CoordinatorLayout_LayoutParams_layout_anchorGravity, 0);
         this.keyline = var3.getInteger(class_5.styleable.CoordinatorLayout_LayoutParams_layout_keyline, -1);
         this.mBehaviorResolved = var3.hasValue(class_5.styleable.CoordinatorLayout_LayoutParams_layout_behavior);
         if(this.mBehaviorResolved) {
            this.mBehavior = CoordinatorLayout.parseBehavior(var1, var2, var3.getString(class_5.styleable.CoordinatorLayout_LayoutParams_layout_behavior));
         }

         var3.recycle();
      }

      public LayoutParams(CoordinatorLayout.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      private void resolveAnchorView(View var1, CoordinatorLayout var2) {
         this.mAnchorView = var2.findViewById(this.mAnchorId);
         if(this.mAnchorView == null) {
            if(var2.isInEditMode()) {
               this.mAnchorDirectChild = null;
               this.mAnchorView = null;
            } else {
               throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + var2.getResources().getResourceName(this.mAnchorId) + " to anchor view " + var1);
            }
         } else if(this.mAnchorView == var2) {
            if(var2.isInEditMode()) {
               this.mAnchorDirectChild = null;
               this.mAnchorView = null;
            } else {
               throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
         } else {
            View var3 = this.mAnchorView;

            for(ViewParent var4 = this.mAnchorView.getParent(); var4 != var2 && var4 != null; var4 = var4.getParent()) {
               if(var4 == var1) {
                  if(var2.isInEditMode()) {
                     this.mAnchorDirectChild = null;
                     this.mAnchorView = null;
                     return;
                  }

                  throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
               }

               if(var4 instanceof View) {
                  var3 = (View)var4;
               }
            }

            this.mAnchorDirectChild = var3;
         }
      }

      private boolean verifyAnchorView(View var1, CoordinatorLayout var2) {
         if(this.mAnchorView.getId() != this.mAnchorId) {
            return false;
         } else {
            View var3 = this.mAnchorView;

            for(ViewParent var4 = this.mAnchorView.getParent(); var4 != var2; var4 = var4.getParent()) {
               if(var4 == null || var4 == var1) {
                  this.mAnchorDirectChild = null;
                  this.mAnchorView = null;
                  return false;
               }

               if(var4 instanceof View) {
                  var3 = (View)var4;
               }
            }

            this.mAnchorDirectChild = var3;
            return true;
         }
      }

      void acceptNestedScroll(boolean var1) {
         this.mDidAcceptNestedScroll = var1;
      }

      boolean checkAnchorChanged() {
         return this.mAnchorView == null && this.mAnchorId != -1;
      }

      boolean dependsOn(CoordinatorLayout var1, View var2, View var3) {
         return var3 == this.mAnchorDirectChild || this.mBehavior != null && this.mBehavior.layoutDependsOn(var1, var2, var3);
      }

      boolean didBlockInteraction() {
         if(this.mBehavior == null) {
            this.mDidBlockInteraction = false;
         }

         return this.mDidBlockInteraction;
      }

      View findAnchorView(CoordinatorLayout var1, View var2) {
         if(this.mAnchorId == -1) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
         } else {
            if(this.mAnchorView == null || !this.verifyAnchorView(var2, var1)) {
               this.resolveAnchorView(var2, var1);
            }

            return this.mAnchorView;
         }
      }

      public int getAnchorId() {
         return this.mAnchorId;
      }

      public CoordinatorLayout.Behavior getBehavior() {
         return this.mBehavior;
      }

      boolean getChangedAfterNestedScroll() {
         return this.mDidChangeAfterNestedScroll;
      }

      Rect getLastChildRect() {
         return this.mLastChildRect;
      }

      void invalidateAnchor() {
         this.mAnchorDirectChild = null;
         this.mAnchorView = null;
      }

      boolean isBlockingInteractionBelow(CoordinatorLayout var1, View var2) {
         if(this.mDidBlockInteraction) {
            return true;
         } else {
            boolean var3 = this.mDidBlockInteraction;
            boolean var4;
            if(this.mBehavior != null) {
               var4 = this.mBehavior.blocksInteractionBelow(var1, var2);
            } else {
               var4 = false;
            }

            boolean var5 = var4 | var3;
            this.mDidBlockInteraction = var5;
            return var5;
         }
      }

      boolean isDirty(CoordinatorLayout var1, View var2) {
         return this.mBehavior != null && this.mBehavior.isDirty(var1, var2);
      }

      boolean isNestedScrollAccepted() {
         return this.mDidAcceptNestedScroll;
      }

      void resetChangedAfterNestedScroll() {
         this.mDidChangeAfterNestedScroll = false;
      }

      void resetNestedScroll() {
         this.mDidAcceptNestedScroll = false;
      }

      void resetTouchBehaviorTracking() {
         this.mDidBlockInteraction = false;
      }

      public void setAnchorId(int var1) {
         this.invalidateAnchor();
         this.mAnchorId = var1;
      }

      public void setBehavior(CoordinatorLayout.Behavior var1) {
         if(this.mBehavior != var1) {
            this.mBehavior = var1;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
         }

      }

      void setChangedAfterNestedScroll(boolean var1) {
         this.mDidChangeAfterNestedScroll = var1;
      }

      void setLastChildRect(Rect var1) {
         this.mLastChildRect.set(var1);
      }
   }

   class OnPreDrawListener implements android.view.ViewTreeObserver.OnPreDrawListener {
      public boolean onPreDraw() {
         CoordinatorLayout.this.dispatchOnDependentViewChanged(false);
         return true;
      }
   }

   protected static class SavedState extends BaseSavedState {
      public static final Creator<CoordinatorLayout.SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks() {
         public CoordinatorLayout.SavedState createFromParcel(Parcel var1, ClassLoader var2) {
            return new CoordinatorLayout.SavedState(var1, var2);
         }

         public CoordinatorLayout.SavedState[] newArray(int var1) {
            return new CoordinatorLayout.SavedState[var1];
         }
      });
      SparseArray<Parcelable> behaviorStates;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1);
         int var3 = var1.readInt();
         int[] var4 = new int[var3];
         var1.readIntArray(var4);
         Parcelable[] var5 = var1.readParcelableArray(var2);
         this.behaviorStates = new SparseArray(var3);

         for(int var6 = 0; var6 < var3; ++var6) {
            this.behaviorStates.append(var4[var6], var5[var6]);
         }

      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         int var3;
         if(this.behaviorStates != null) {
            var3 = this.behaviorStates.size();
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
         int[] var4 = new int[var3];
         Parcelable[] var5 = new Parcelable[var3];

         for(int var6 = 0; var6 < var3; ++var6) {
            var4[var6] = this.behaviorStates.keyAt(var6);
            var5[var6] = (Parcelable)this.behaviorStates.valueAt(var6);
         }

         var1.writeIntArray(var4);
         var1.writeParcelableArray(var5, var2);
      }
   }

   static class ViewElevationComparator implements Comparator<View> {
      public int compare(View var1, View var2) {
         float var3 = ViewCompat.getZ(var1);
         float var4 = ViewCompat.getZ(var2);
         return var3 > var4?-1:(var3 < var4?1:0);
      }
   }
}
