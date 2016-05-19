package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.appcompat.class_22;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {
   static final int[] ATTRS;
   private static final String TAG = "ActionBarOverlayLayout";
   private final int ACTION_BAR_ANIMATE_DELAY;
   private int mActionBarHeight;
   private ActionBarContainer mActionBarTop;
   private ActionBarOverlayLayout.ActionBarVisibilityCallback mActionBarVisibilityCallback;
   private final Runnable mAddActionBarHideOffset;
   private boolean mAnimatingForFling;
   private final Rect mBaseContentInsets;
   private final Rect mBaseInnerInsets;
   private ContentFrameLayout mContent;
   private final Rect mContentInsets;
   private ViewPropertyAnimatorCompat mCurrentActionBarTopAnimator;
   private DecorToolbar mDecorToolbar;
   private ScrollerCompat mFlingEstimator;
   private boolean mHasNonEmbeddedTabs;
   private boolean mHideOnContentScroll;
   private int mHideOnContentScrollReference;
   private boolean mIgnoreWindowContentOverlay;
   private final Rect mInnerInsets;
   private final Rect mLastBaseContentInsets;
   private final Rect mLastInnerInsets;
   private int mLastSystemUiVisibility;
   private boolean mOverlayMode;
   private final NestedScrollingParentHelper mParentHelper;
   private final Runnable mRemoveActionBarHideOffset;
   private final ViewPropertyAnimatorListener mTopAnimatorListener;
   private Drawable mWindowContentOverlay;
   private int mWindowVisibility;

   static {
      int[] var0 = new int[]{class_22.attr.actionBarSize, 16842841};
      ATTRS = var0;
   }

   public ActionBarOverlayLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public ActionBarOverlayLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mWindowVisibility = 0;
      this.mBaseContentInsets = new Rect();
      this.mLastBaseContentInsets = new Rect();
      this.mContentInsets = new Rect();
      this.mBaseInnerInsets = new Rect();
      this.mInnerInsets = new Rect();
      this.mLastInnerInsets = new Rect();
      this.ACTION_BAR_ANIMATE_DELAY = 600;
      this.mTopAnimatorListener = new ViewPropertyAnimatorListenerAdapter() {
         public void onAnimationCancel(View var1) {
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
            ActionBarOverlayLayout.this.mAnimatingForFling = false;
         }

         public void onAnimationEnd(View var1) {
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = null;
            ActionBarOverlayLayout.this.mAnimatingForFling = false;
         }
      };
      this.mRemoveActionBarHideOffset = new Runnable() {
         public void run() {
            ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarTop).translationY(0.0F).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
         }
      };
      this.mAddActionBarHideOffset = new Runnable() {
         public void run() {
            ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
            ActionBarOverlayLayout.this.mCurrentActionBarTopAnimator = ViewCompat.animate(ActionBarOverlayLayout.this.mActionBarTop).translationY((float)(-ActionBarOverlayLayout.this.mActionBarTop.getHeight())).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
         }
      };
      this.init(var1);
      this.mParentHelper = new NestedScrollingParentHelper(this);
   }

   private void addActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.mAddActionBarHideOffset.run();
   }

   private boolean applyInsets(View var1, Rect var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      ActionBarOverlayLayout.LayoutParams var7 = (ActionBarOverlayLayout.LayoutParams)var1.getLayoutParams();
      boolean var8 = false;
      if(var3) {
         int var9 = var7.leftMargin;
         int var10 = var2.left;
         var8 = false;
         if(var9 != var10) {
            var8 = true;
            var7.leftMargin = var2.left;
         }
      }

      if(var4 && var7.topMargin != var2.top) {
         var8 = true;
         var7.topMargin = var2.top;
      }

      if(var6 && var7.rightMargin != var2.right) {
         var8 = true;
         var7.rightMargin = var2.right;
      }

      if(var5 && var7.bottomMargin != var2.bottom) {
         var8 = true;
         var7.bottomMargin = var2.bottom;
      }

      return var8;
   }

   private DecorToolbar getDecorToolbar(View var1) {
      if(var1 instanceof DecorToolbar) {
         return (DecorToolbar)var1;
      } else if(var1 instanceof Toolbar) {
         return ((Toolbar)var1).getWrapper();
      } else {
         throw new IllegalStateException("Can\'t make a decor toolbar out of " + var1.getClass().getSimpleName());
      }
   }

   private void haltActionBarHideOffsetAnimations() {
      this.removeCallbacks(this.mRemoveActionBarHideOffset);
      this.removeCallbacks(this.mAddActionBarHideOffset);
      if(this.mCurrentActionBarTopAnimator != null) {
         this.mCurrentActionBarTopAnimator.cancel();
      }

   }

   private void init(Context var1) {
      byte var2 = 1;
      TypedArray var3 = this.getContext().getTheme().obtainStyledAttributes(ATTRS);
      this.mActionBarHeight = var3.getDimensionPixelSize(0, 0);
      this.mWindowContentOverlay = var3.getDrawable(var2);
      byte var4;
      if(this.mWindowContentOverlay == null) {
         var4 = var2;
      } else {
         var4 = 0;
      }

      this.setWillNotDraw((boolean)var4);
      var3.recycle();
      if(var1.getApplicationInfo().targetSdkVersion >= 19) {
         var2 = 0;
      }

      this.mIgnoreWindowContentOverlay = (boolean)var2;
      this.mFlingEstimator = ScrollerCompat.create(var1);
   }

   private void postAddActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.postDelayed(this.mAddActionBarHideOffset, 600L);
   }

   private void postRemoveActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.postDelayed(this.mRemoveActionBarHideOffset, 600L);
   }

   private void removeActionBarHideOffset() {
      this.haltActionBarHideOffsetAnimations();
      this.mRemoveActionBarHideOffset.run();
   }

   private boolean shouldHideActionBarOnFling(float var1, float var2) {
      this.mFlingEstimator.fling(0, 0, 0, (int)var2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
      int var3 = this.mFlingEstimator.getFinalY();
      int var4 = this.mActionBarTop.getHeight();
      boolean var5 = false;
      if(var3 > var4) {
         var5 = true;
      }

      return var5;
   }

   public boolean canShowOverflowMenu() {
      this.pullChildren();
      return this.mDecorToolbar.canShowOverflowMenu();
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof ActionBarOverlayLayout.LayoutParams;
   }

   public void dismissPopups() {
      this.pullChildren();
      this.mDecorToolbar.dismissPopupMenus();
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      if(this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
         int var2;
         if(this.mActionBarTop.getVisibility() == 0) {
            var2 = (int)(0.5F + (float)this.mActionBarTop.getBottom() + ViewCompat.getTranslationY(this.mActionBarTop));
         } else {
            var2 = 0;
         }

         this.mWindowContentOverlay.setBounds(0, var2, this.getWidth(), var2 + this.mWindowContentOverlay.getIntrinsicHeight());
         this.mWindowContentOverlay.draw(var1);
      }

   }

   protected boolean fitSystemWindows(Rect var1) {
      this.pullChildren();
      if((256 & ViewCompat.getWindowSystemUiVisibility(this)) != 0) {
         ;
      }

      boolean var2 = this.applyInsets(this.mActionBarTop, var1, true, true, false, true);
      this.mBaseInnerInsets.set(var1);
      ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsets, this.mBaseContentInsets);
      if(!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
         var2 = true;
         this.mLastBaseContentInsets.set(this.mBaseContentInsets);
      }

      if(var2) {
         this.requestLayout();
      }

      return true;
   }

   protected ActionBarOverlayLayout.LayoutParams generateDefaultLayoutParams() {
      return new ActionBarOverlayLayout.LayoutParams(-1, -1);
   }

   public ActionBarOverlayLayout.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new ActionBarOverlayLayout.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return new ActionBarOverlayLayout.LayoutParams(var1);
   }

   public int getActionBarHideOffset() {
      return this.mActionBarTop != null?-((int)ViewCompat.getTranslationY(this.mActionBarTop)):0;
   }

   public int getNestedScrollAxes() {
      return this.mParentHelper.getNestedScrollAxes();
   }

   public CharSequence getTitle() {
      this.pullChildren();
      return this.mDecorToolbar.getTitle();
   }

   public boolean hasIcon() {
      this.pullChildren();
      return this.mDecorToolbar.hasIcon();
   }

   public boolean hasLogo() {
      this.pullChildren();
      return this.mDecorToolbar.hasLogo();
   }

   public boolean hideOverflowMenu() {
      this.pullChildren();
      return this.mDecorToolbar.hideOverflowMenu();
   }

   public void initFeature(int var1) {
      this.pullChildren();
      switch(var1) {
      case 2:
         this.mDecorToolbar.initProgress();
         return;
      case 5:
         this.mDecorToolbar.initIndeterminateProgress();
         return;
      case 109:
         this.setOverlayMode(true);
         return;
      default:
      }
   }

   public boolean isHideOnContentScrollEnabled() {
      return this.mHideOnContentScroll;
   }

   public boolean isInOverlayMode() {
      return this.mOverlayMode;
   }

   public boolean isOverflowMenuShowPending() {
      this.pullChildren();
      return this.mDecorToolbar.isOverflowMenuShowPending();
   }

   public boolean isOverflowMenuShowing() {
      this.pullChildren();
      return this.mDecorToolbar.isOverflowMenuShowing();
   }

   protected void onConfigurationChanged(Configuration var1) {
      if(VERSION.SDK_INT >= 8) {
         super.onConfigurationChanged(var1);
      }

      this.init(this.getContext());
      ViewCompat.requestApplyInsets(this);
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.haltActionBarHideOffsetAnimations();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var6 = this.getChildCount();
      int var7 = this.getPaddingLeft();
      int var10000 = var4 - var2 - this.getPaddingRight();
      int var9 = this.getPaddingTop();
      var10000 = var5 - var3 - this.getPaddingBottom();

      for(int var11 = 0; var11 < var6; ++var11) {
         View var12 = this.getChildAt(var11);
         if(var12.getVisibility() != 8) {
            ActionBarOverlayLayout.LayoutParams var13 = (ActionBarOverlayLayout.LayoutParams)var12.getLayoutParams();
            int var14 = var12.getMeasuredWidth();
            int var15 = var12.getMeasuredHeight();
            int var16 = var7 + var13.leftMargin;
            int var17 = var9 + var13.topMargin;
            var12.layout(var16, var17, var16 + var14, var17 + var15);
         }
      }

   }

   protected void onMeasure(int var1, int var2) {
      this.pullChildren();
      this.measureChildWithMargins(this.mActionBarTop, var1, 0, var2, 0);
      ActionBarOverlayLayout.LayoutParams var3 = (ActionBarOverlayLayout.LayoutParams)this.mActionBarTop.getLayoutParams();
      int var4 = Math.max(0, this.mActionBarTop.getMeasuredWidth() + var3.leftMargin + var3.rightMargin);
      int var5 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + var3.topMargin + var3.bottomMargin);
      int var6 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mActionBarTop));
      boolean var7;
      if((256 & ViewCompat.getWindowSystemUiVisibility(this)) != 0) {
         var7 = true;
      } else {
         var7 = false;
      }

      int var9;
      if(var7) {
         var9 = this.mActionBarHeight;
         if(this.mHasNonEmbeddedTabs && this.mActionBarTop.getTabContainer() != null) {
            var9 += this.mActionBarHeight;
         }
      } else {
         int var8 = this.mActionBarTop.getVisibility();
         var9 = 0;
         if(var8 != 8) {
            var9 = this.mActionBarTop.getMeasuredHeight();
         }
      }

      this.mContentInsets.set(this.mBaseContentInsets);
      this.mInnerInsets.set(this.mBaseInnerInsets);
      if(!this.mOverlayMode && !var7) {
         Rect var19 = this.mContentInsets;
         var19.top += var9;
         Rect var20 = this.mContentInsets;
         var20.bottom += 0;
      } else {
         Rect var10 = this.mInnerInsets;
         var10.top += var9;
         Rect var11 = this.mInnerInsets;
         var11.bottom += 0;
      }

      this.applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
      if(!this.mLastInnerInsets.equals(this.mInnerInsets)) {
         this.mLastInnerInsets.set(this.mInnerInsets);
         this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
      }

      this.measureChildWithMargins(this.mContent, var1, 0, var2, 0);
      ActionBarOverlayLayout.LayoutParams var13 = (ActionBarOverlayLayout.LayoutParams)this.mContent.getLayoutParams();
      int var14 = Math.max(var4, this.mContent.getMeasuredWidth() + var13.leftMargin + var13.rightMargin);
      int var15 = Math.max(var5, this.mContent.getMeasuredHeight() + var13.topMargin + var13.bottomMargin);
      int var16 = ViewUtils.combineMeasuredStates(var6, ViewCompat.getMeasuredState(this.mContent));
      int var17 = var14 + this.getPaddingLeft() + this.getPaddingRight();
      int var18 = Math.max(var15 + this.getPaddingTop() + this.getPaddingBottom(), this.getSuggestedMinimumHeight());
      this.setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(var17, this.getSuggestedMinimumWidth()), var1, var16), ViewCompat.resolveSizeAndState(var18, var2, var16 << 16));
   }

   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      if(this.mHideOnContentScroll && var4) {
         if(this.shouldHideActionBarOnFling(var2, var3)) {
            this.addActionBarHideOffset();
         } else {
            this.removeActionBarHideOffset();
         }

         this.mAnimatingForFling = true;
         return true;
      } else {
         return false;
      }
   }

   public boolean onNestedPreFling(View var1, float var2, float var3) {
      return false;
   }

   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
   }

   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      this.mHideOnContentScrollReference += var3;
      this.setActionBarHideOffset(this.mHideOnContentScrollReference);
   }

   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.mParentHelper.onNestedScrollAccepted(var1, var2, var3);
      this.mHideOnContentScrollReference = this.getActionBarHideOffset();
      this.haltActionBarHideOffsetAnimations();
      if(this.mActionBarVisibilityCallback != null) {
         this.mActionBarVisibilityCallback.onContentScrollStarted();
      }

   }

   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      return (var3 & 2) != 0 && this.mActionBarTop.getVisibility() == 0?this.mHideOnContentScroll:false;
   }

   public void onStopNestedScroll(View var1) {
      if(this.mHideOnContentScroll && !this.mAnimatingForFling) {
         if(this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
            this.postRemoveActionBarHideOffset();
         } else {
            this.postAddActionBarHideOffset();
         }
      }

      if(this.mActionBarVisibilityCallback != null) {
         this.mActionBarVisibilityCallback.onContentScrollStopped();
      }

   }

   public void onWindowSystemUiVisibilityChanged(int var1) {
      boolean var2 = true;
      if(VERSION.SDK_INT >= 16) {
         super.onWindowSystemUiVisibilityChanged(var1);
      }

      this.pullChildren();
      int var3 = var1 ^ this.mLastSystemUiVisibility;
      this.mLastSystemUiVisibility = var1;
      boolean var4;
      if((var1 & 4) == 0) {
         var4 = var2;
      } else {
         var4 = false;
      }

      boolean var5;
      if((var1 & 256) != 0) {
         var5 = var2;
      } else {
         var5 = false;
      }

      if(this.mActionBarVisibilityCallback != null) {
         ActionBarOverlayLayout.ActionBarVisibilityCallback var6 = this.mActionBarVisibilityCallback;
         if(var5) {
            var2 = false;
         }

         var6.enableContentAnimations(var2);
         if(!var4 && var5) {
            this.mActionBarVisibilityCallback.hideForSystem();
         } else {
            this.mActionBarVisibilityCallback.showForSystem();
         }
      }

      if((var3 & 256) != 0 && this.mActionBarVisibilityCallback != null) {
         ViewCompat.requestApplyInsets(this);
      }

   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      this.mWindowVisibility = var1;
      if(this.mActionBarVisibilityCallback != null) {
         this.mActionBarVisibilityCallback.onWindowVisibilityChanged(var1);
      }

   }

   void pullChildren() {
      if(this.mContent == null) {
         this.mContent = (ContentFrameLayout)this.findViewById(class_22.class_93.action_bar_activity_content);
         this.mActionBarTop = (ActionBarContainer)this.findViewById(class_22.class_93.action_bar_container);
         this.mDecorToolbar = this.getDecorToolbar(this.findViewById(class_22.class_93.action_bar));
      }

   }

   public void restoreToolbarHierarchyState(SparseArray<Parcelable> var1) {
      this.pullChildren();
      this.mDecorToolbar.restoreHierarchyState(var1);
   }

   public void saveToolbarHierarchyState(SparseArray<Parcelable> var1) {
      this.pullChildren();
      this.mDecorToolbar.saveHierarchyState(var1);
   }

   public void setActionBarHideOffset(int var1) {
      this.haltActionBarHideOffsetAnimations();
      int var2 = Math.max(0, Math.min(var1, this.mActionBarTop.getHeight()));
      ViewCompat.setTranslationY(this.mActionBarTop, (float)(-var2));
   }

   public void setActionBarVisibilityCallback(ActionBarOverlayLayout.ActionBarVisibilityCallback var1) {
      this.mActionBarVisibilityCallback = var1;
      if(this.getWindowToken() != null) {
         this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
         if(this.mLastSystemUiVisibility != 0) {
            this.onWindowSystemUiVisibilityChanged(this.mLastSystemUiVisibility);
            ViewCompat.requestApplyInsets(this);
         }
      }

   }

   public void setHasNonEmbeddedTabs(boolean var1) {
      this.mHasNonEmbeddedTabs = var1;
   }

   public void setHideOnContentScrollEnabled(boolean var1) {
      if(var1 != this.mHideOnContentScroll) {
         this.mHideOnContentScroll = var1;
         if(!var1) {
            this.haltActionBarHideOffsetAnimations();
            this.setActionBarHideOffset(0);
         }
      }

   }

   public void setIcon(int var1) {
      this.pullChildren();
      this.mDecorToolbar.setIcon(var1);
   }

   public void setIcon(Drawable var1) {
      this.pullChildren();
      this.mDecorToolbar.setIcon(var1);
   }

   public void setLogo(int var1) {
      this.pullChildren();
      this.mDecorToolbar.setLogo(var1);
   }

   public void setMenu(Menu var1, MenuPresenter.Callback var2) {
      this.pullChildren();
      this.mDecorToolbar.setMenu(var1, var2);
   }

   public void setMenuPrepared() {
      this.pullChildren();
      this.mDecorToolbar.setMenuPrepared();
   }

   public void setOverlayMode(boolean var1) {
      this.mOverlayMode = var1;
      boolean var2;
      if(var1 && this.getContext().getApplicationInfo().targetSdkVersion < 19) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.mIgnoreWindowContentOverlay = var2;
   }

   public void setShowingForActionMode(boolean var1) {
   }

   public void setUiOptions(int var1) {
   }

   public void setWindowCallback(Callback var1) {
      this.pullChildren();
      this.mDecorToolbar.setWindowCallback(var1);
   }

   public void setWindowTitle(CharSequence var1) {
      this.pullChildren();
      this.mDecorToolbar.setWindowTitle(var1);
   }

   public boolean shouldDelayChildPressedState() {
      return false;
   }

   public boolean showOverflowMenu() {
      this.pullChildren();
      return this.mDecorToolbar.showOverflowMenu();
   }

   public interface ActionBarVisibilityCallback {
      void enableContentAnimations(boolean var1);

      void hideForSystem();

      void onContentScrollStarted();

      void onContentScrollStopped();

      void onWindowVisibilityChanged(int var1);

      void showForSystem();
   }

   public static class LayoutParams extends MarginLayoutParams {
      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }
   }
}
