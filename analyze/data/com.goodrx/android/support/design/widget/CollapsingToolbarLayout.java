package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.class_5;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingTextHelper;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewGroupUtils;
import android.support.design.widget.ViewOffsetHelper;
import android.support.design.widget.ViewUtils;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {
   private static final int SCRIM_ANIMATION_DURATION = 600;
   private final CollapsingTextHelper mCollapsingTextHelper;
   private boolean mCollapsingTitleEnabled;
   private Drawable mContentScrim;
   private int mCurrentOffset;
   private boolean mDrawCollapsingTitle;
   private View mDummyView;
   private int mExpandedMarginBottom;
   private int mExpandedMarginEnd;
   private int mExpandedMarginStart;
   private int mExpandedMarginTop;
   private WindowInsetsCompat mLastInsets;
   private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
   private boolean mRefreshToolbar;
   private int mScrimAlpha;
   private ValueAnimatorCompat mScrimAnimator;
   private boolean mScrimsAreShown;
   private Drawable mStatusBarScrim;
   private final Rect mTmpRect;
   private Toolbar mToolbar;
   private View mToolbarDirectChild;
   private int mToolbarId;

   public CollapsingToolbarLayout(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public CollapsingToolbarLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CollapsingToolbarLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mRefreshToolbar = true;
      this.mTmpRect = new Rect();
      ThemeUtils.checkAppCompatTheme(var1);
      this.mCollapsingTextHelper = new CollapsingTextHelper(this);
      this.mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_5.styleable.CollapsingToolbarLayout, var3, class_5.style.Widget_Design_CollapsingToolbar);
      this.mCollapsingTextHelper.setExpandedTextGravity(var4.getInt(class_5.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
      this.mCollapsingTextHelper.setCollapsedTextGravity(var4.getInt(class_5.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
      int var5 = var4.getDimensionPixelSize(class_5.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
      this.mExpandedMarginBottom = var5;
      this.mExpandedMarginEnd = var5;
      this.mExpandedMarginTop = var5;
      this.mExpandedMarginStart = var5;
      if(var4.hasValue(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
         this.mExpandedMarginStart = var4.getDimensionPixelSize(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
      }

      if(var4.hasValue(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
         this.mExpandedMarginEnd = var4.getDimensionPixelSize(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
      }

      if(var4.hasValue(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
         this.mExpandedMarginTop = var4.getDimensionPixelSize(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
      }

      if(var4.hasValue(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
         this.mExpandedMarginBottom = var4.getDimensionPixelSize(class_5.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
      }

      this.mCollapsingTitleEnabled = var4.getBoolean(class_5.styleable.CollapsingToolbarLayout_titleEnabled, true);
      this.setTitle(var4.getText(class_5.styleable.CollapsingToolbarLayout_title));
      this.mCollapsingTextHelper.setExpandedTextAppearance(class_5.style.TextAppearance_Design_CollapsingToolbar_Expanded);
      this.mCollapsingTextHelper.setCollapsedTextAppearance(class_5.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
      if(var4.hasValue(class_5.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
         this.mCollapsingTextHelper.setExpandedTextAppearance(var4.getResourceId(class_5.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
      }

      if(var4.hasValue(class_5.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
         this.mCollapsingTextHelper.setCollapsedTextAppearance(var4.getResourceId(class_5.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
      }

      this.setContentScrim(var4.getDrawable(class_5.styleable.CollapsingToolbarLayout_contentScrim));
      this.setStatusBarScrim(var4.getDrawable(class_5.styleable.CollapsingToolbarLayout_statusBarScrim));
      this.mToolbarId = var4.getResourceId(class_5.styleable.CollapsingToolbarLayout_toolbarId, -1);
      var4.recycle();
      this.setWillNotDraw(false);
      ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
         public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
            return CollapsingToolbarLayout.this.setWindowInsets(var2);
         }
      });
   }

   private void animateScrim(int var1) {
      this.ensureToolbar();
      if(this.mScrimAnimator == null) {
         this.mScrimAnimator = ViewUtils.createAnimator();
         this.mScrimAnimator.setDuration(600);
         ValueAnimatorCompat var2 = this.mScrimAnimator;
         Interpolator var3;
         if(var1 > this.mScrimAlpha) {
            var3 = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
         } else {
            var3 = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
         }

         var2.setInterpolator(var3);
         this.mScrimAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimatorCompat var1) {
               CollapsingToolbarLayout.this.setScrimAlpha(var1.getAnimatedIntValue());
            }
         });
      } else if(this.mScrimAnimator.isRunning()) {
         this.mScrimAnimator.cancel();
      }

      this.mScrimAnimator.setIntValues(this.mScrimAlpha, var1);
      this.mScrimAnimator.start();
   }

   private void ensureToolbar() {
      if(this.mRefreshToolbar) {
         this.mToolbar = null;
         this.mToolbarDirectChild = null;
         if(this.mToolbarId != -1) {
            this.mToolbar = (Toolbar)this.findViewById(this.mToolbarId);
            if(this.mToolbar != null) {
               this.mToolbarDirectChild = this.findDirectChild(this.mToolbar);
            }
         }

         if(this.mToolbar == null) {
            int var1 = 0;
            int var2 = this.getChildCount();

            Toolbar var3;
            while(true) {
               var3 = null;
               if(var1 >= var2) {
                  break;
               }

               View var4 = this.getChildAt(var1);
               if(var4 instanceof Toolbar) {
                  var3 = (Toolbar)var4;
                  break;
               }

               ++var1;
            }

            this.mToolbar = var3;
         }

         this.updateDummyView();
         this.mRefreshToolbar = false;
      }
   }

   private View findDirectChild(View var1) {
      View var2 = var1;

      for(ViewParent var3 = var1.getParent(); var3 != this && var3 != null; var3 = var3.getParent()) {
         if(var3 instanceof View) {
            var2 = (View)var3;
         }
      }

      return var2;
   }

   private static int getHeightWithMargins(@NonNull View var0) {
      android.view.ViewGroup.LayoutParams var1 = var0.getLayoutParams();
      if(var1 instanceof MarginLayoutParams) {
         MarginLayoutParams var2 = (MarginLayoutParams)var1;
         return var0.getHeight() + var2.topMargin + var2.bottomMargin;
      } else {
         return var0.getHeight();
      }
   }

   private static ViewOffsetHelper getViewOffsetHelper(View var0) {
      ViewOffsetHelper var1 = (ViewOffsetHelper)var0.getTag(class_5.class_113.view_offset_helper);
      if(var1 == null) {
         var1 = new ViewOffsetHelper(var0);
         var0.setTag(class_5.class_113.view_offset_helper, var1);
      }

      return var1;
   }

   private void setScrimAlpha(int var1) {
      if(var1 != this.mScrimAlpha) {
         if(this.mContentScrim != null && this.mToolbar != null) {
            ViewCompat.postInvalidateOnAnimation(this.mToolbar);
         }

         this.mScrimAlpha = var1;
         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   private WindowInsetsCompat setWindowInsets(WindowInsetsCompat var1) {
      if(this.mLastInsets != var1) {
         this.mLastInsets = var1;
         this.requestLayout();
      }

      return var1.consumeSystemWindowInsets();
   }

   private void updateDummyView() {
      if(!this.mCollapsingTitleEnabled && this.mDummyView != null) {
         ViewParent var1 = this.mDummyView.getParent();
         if(var1 instanceof ViewGroup) {
            ((ViewGroup)var1).removeView(this.mDummyView);
         }
      }

      if(this.mCollapsingTitleEnabled && this.mToolbar != null) {
         if(this.mDummyView == null) {
            this.mDummyView = new View(this.getContext());
         }

         if(this.mDummyView.getParent() == null) {
            this.mToolbar.addView(this.mDummyView, -1, -1);
         }
      }

   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof CollapsingToolbarLayout.LayoutParams;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      this.ensureToolbar();
      if(this.mToolbar == null && this.mContentScrim != null && this.mScrimAlpha > 0) {
         this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
         this.mContentScrim.draw(var1);
      }

      if(this.mCollapsingTitleEnabled && this.mDrawCollapsingTitle) {
         this.mCollapsingTextHelper.draw(var1);
      }

      if(this.mStatusBarScrim != null && this.mScrimAlpha > 0) {
         int var2;
         if(this.mLastInsets != null) {
            var2 = this.mLastInsets.getSystemWindowInsetTop();
         } else {
            var2 = 0;
         }

         if(var2 > 0) {
            this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, this.getWidth(), var2 - this.mCurrentOffset);
            this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
            this.mStatusBarScrim.draw(var1);
         }
      }

   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      this.ensureToolbar();
      if(var2 == this.mToolbar && this.mContentScrim != null && this.mScrimAlpha > 0) {
         this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
         this.mContentScrim.draw(var1);
      }

      return super.drawChild(var1, var2, var3);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var1 = this.getDrawableState();
      Drawable var2 = this.mStatusBarScrim;
      boolean var3 = false;
      if(var2 != null) {
         boolean var5 = var2.isStateful();
         var3 = false;
         if(var5) {
            var3 = false | var2.setState(var1);
         }
      }

      Drawable var4 = this.mContentScrim;
      if(var4 != null && var4.isStateful()) {
         var3 |= var4.setState(var1);
      }

      if(var3) {
         this.invalidate();
      }

   }

   protected CollapsingToolbarLayout.LayoutParams generateDefaultLayoutParams() {
      return new CollapsingToolbarLayout.LayoutParams(super.generateDefaultLayoutParams());
   }

   public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new CollapsingToolbarLayout.LayoutParams(this.getContext(), var1);
   }

   protected android.widget.FrameLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return new CollapsingToolbarLayout.LayoutParams(var1);
   }

   public int getCollapsedTitleGravity() {
      return this.mCollapsingTextHelper.getCollapsedTextGravity();
   }

   @NonNull
   public Typeface getCollapsedTitleTypeface() {
      return this.mCollapsingTextHelper.getCollapsedTypeface();
   }

   @Nullable
   public Drawable getContentScrim() {
      return this.mContentScrim;
   }

   public int getExpandedTitleGravity() {
      return this.mCollapsingTextHelper.getExpandedTextGravity();
   }

   public int getExpandedTitleMarginBottom() {
      return this.mExpandedMarginBottom;
   }

   public int getExpandedTitleMarginEnd() {
      return this.mExpandedMarginEnd;
   }

   public int getExpandedTitleMarginStart() {
      return this.mExpandedMarginStart;
   }

   public int getExpandedTitleMarginTop() {
      return this.mExpandedMarginTop;
   }

   @NonNull
   public Typeface getExpandedTitleTypeface() {
      return this.mCollapsingTextHelper.getExpandedTypeface();
   }

   final int getScrimTriggerOffset() {
      return 2 * ViewCompat.getMinimumHeight(this);
   }

   @Nullable
   public Drawable getStatusBarScrim() {
      return this.mStatusBarScrim;
   }

   @Nullable
   public CharSequence getTitle() {
      return this.mCollapsingTitleEnabled?this.mCollapsingTextHelper.getText():null;
   }

   public boolean isTitleEnabled() {
      return this.mCollapsingTitleEnabled;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      ViewParent var1 = this.getParent();
      if(var1 instanceof AppBarLayout) {
         if(this.mOnOffsetChangedListener == null) {
            this.mOnOffsetChangedListener = new CollapsingToolbarLayout.OffsetUpdateListener(null);
         }

         ((AppBarLayout)var1).addOnOffsetChangedListener(this.mOnOffsetChangedListener);
      }

      ViewCompat.requestApplyInsets(this);
   }

   protected void onDetachedFromWindow() {
      ViewParent var1 = this.getParent();
      if(this.mOnOffsetChangedListener != null && var1 instanceof AppBarLayout) {
         ((AppBarLayout)var1).removeOnOffsetChangedListener(this.mOnOffsetChangedListener);
      }

      super.onDetachedFromWindow();
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if(this.mCollapsingTitleEnabled && this.mDummyView != null) {
         boolean var10;
         if(ViewCompat.isAttachedToWindow(this.mDummyView) && this.mDummyView.getVisibility() == 0) {
            var10 = true;
         } else {
            var10 = false;
         }

         this.mDrawCollapsingTitle = var10;
         if(this.mDrawCollapsingTitle) {
            View var11 = this.mToolbarDirectChild;
            int var12 = 0;
            if(var11 != null) {
               View var19 = this.mToolbarDirectChild;
               var12 = 0;
               if(var19 != this) {
                  var12 = ((CollapsingToolbarLayout.LayoutParams)this.mToolbarDirectChild.getLayoutParams()).bottomMargin;
               }
            }

            ViewGroupUtils.getDescendantRect(this, this.mDummyView, this.mTmpRect);
            this.mCollapsingTextHelper.setCollapsedBounds(this.mTmpRect.left, var5 - this.mTmpRect.height() - var12, this.mTmpRect.right, var5 - var12);
            boolean var13;
            if(ViewCompat.getLayoutDirection(this) == 1) {
               var13 = true;
            } else {
               var13 = false;
            }

            CollapsingTextHelper var14 = this.mCollapsingTextHelper;
            int var15;
            if(var13) {
               var15 = this.mExpandedMarginEnd;
            } else {
               var15 = this.mExpandedMarginStart;
            }

            int var16 = this.mTmpRect.bottom + this.mExpandedMarginTop;
            int var17 = var4 - var2;
            int var18;
            if(var13) {
               var18 = this.mExpandedMarginStart;
            } else {
               var18 = this.mExpandedMarginEnd;
            }

            var14.setExpandedBounds(var15, var16, var17 - var18, var5 - var3 - this.mExpandedMarginBottom);
            this.mCollapsingTextHelper.recalculate();
         }
      }

      int var6 = 0;

      for(int var7 = this.getChildCount(); var6 < var7; ++var6) {
         View var8 = this.getChildAt(var6);
         if(this.mLastInsets != null && !ViewCompat.getFitsSystemWindows(var8)) {
            int var9 = this.mLastInsets.getSystemWindowInsetTop();
            if(var8.getTop() < var9) {
               ViewCompat.offsetTopAndBottom(var8, var9);
            }
         }

         getViewOffsetHelper(var8).onViewLayout();
      }

      if(this.mToolbar != null) {
         if(this.mCollapsingTitleEnabled && TextUtils.isEmpty(this.mCollapsingTextHelper.getText())) {
            this.mCollapsingTextHelper.setText(this.mToolbar.getTitle());
         }

         if(this.mToolbarDirectChild != null && this.mToolbarDirectChild != this) {
            this.setMinimumHeight(getHeightWithMargins(this.mToolbarDirectChild));
            return;
         }

         this.setMinimumHeight(getHeightWithMargins(this.mToolbar));
      }

   }

   protected void onMeasure(int var1, int var2) {
      this.ensureToolbar();
      super.onMeasure(var1, var2);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if(this.mContentScrim != null) {
         this.mContentScrim.setBounds(0, 0, var1, var2);
      }

   }

   public void setCollapsedTitleGravity(int var1) {
      this.mCollapsingTextHelper.setCollapsedTextGravity(var1);
   }

   public void setCollapsedTitleTextAppearance(@StyleRes int var1) {
      this.mCollapsingTextHelper.setCollapsedTextAppearance(var1);
   }

   public void setCollapsedTitleTextColor(@ColorInt int var1) {
      this.mCollapsingTextHelper.setCollapsedTextColor(var1);
   }

   public void setCollapsedTitleTypeface(@Nullable Typeface var1) {
      this.mCollapsingTextHelper.setCollapsedTypeface(var1);
   }

   public void setContentScrim(@Nullable Drawable var1) {
      if(this.mContentScrim != var1) {
         if(this.mContentScrim != null) {
            this.mContentScrim.setCallback((Callback)null);
         }

         Drawable var2 = null;
         if(var1 != null) {
            var2 = var1.mutate();
         }

         this.mContentScrim = var2;
         if(this.mContentScrim != null) {
            this.mContentScrim.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.mContentScrim.setCallback(this);
            this.mContentScrim.setAlpha(this.mScrimAlpha);
         }

         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void setContentScrimColor(@ColorInt int var1) {
      this.setContentScrim(new ColorDrawable(var1));
   }

   public void setContentScrimResource(@DrawableRes int var1) {
      this.setContentScrim(ContextCompat.getDrawable(this.getContext(), var1));
   }

   public void setExpandedTitleColor(@ColorInt int var1) {
      this.mCollapsingTextHelper.setExpandedTextColor(var1);
   }

   public void setExpandedTitleGravity(int var1) {
      this.mCollapsingTextHelper.setExpandedTextGravity(var1);
   }

   public void setExpandedTitleMargin(int var1, int var2, int var3, int var4) {
      this.mExpandedMarginStart = var1;
      this.mExpandedMarginTop = var2;
      this.mExpandedMarginEnd = var3;
      this.mExpandedMarginBottom = var4;
      this.requestLayout();
   }

   public void setExpandedTitleMarginBottom(int var1) {
      this.mExpandedMarginBottom = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginEnd(int var1) {
      this.mExpandedMarginEnd = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginStart(int var1) {
      this.mExpandedMarginStart = var1;
      this.requestLayout();
   }

   public void setExpandedTitleMarginTop(int var1) {
      this.mExpandedMarginTop = var1;
      this.requestLayout();
   }

   public void setExpandedTitleTextAppearance(@StyleRes int var1) {
      this.mCollapsingTextHelper.setExpandedTextAppearance(var1);
   }

   public void setExpandedTitleTypeface(@Nullable Typeface var1) {
      this.mCollapsingTextHelper.setExpandedTypeface(var1);
   }

   public void setScrimsShown(boolean var1) {
      boolean var2;
      if(ViewCompat.isLaidOut(this) && !this.isInEditMode()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setScrimsShown(var1, var2);
   }

   public void setScrimsShown(boolean var1, boolean var2) {
      short var3 = 255;
      if(this.mScrimsAreShown != var1) {
         if(var2) {
            if(!var1) {
               var3 = 0;
            }

            this.animateScrim(var3);
         } else {
            if(!var1) {
               var3 = 0;
            }

            this.setScrimAlpha(var3);
         }

         this.mScrimsAreShown = var1;
      }

   }

   public void setStatusBarScrim(@Nullable Drawable var1) {
      if(this.mStatusBarScrim != var1) {
         if(this.mStatusBarScrim != null) {
            this.mStatusBarScrim.setCallback((Callback)null);
         }

         Drawable var2 = null;
         if(var1 != null) {
            var2 = var1.mutate();
         }

         this.mStatusBarScrim = var2;
         if(this.mStatusBarScrim != null) {
            if(this.mStatusBarScrim.isStateful()) {
               this.mStatusBarScrim.setState(this.getDrawableState());
            }

            DrawableCompat.setLayoutDirection(this.mStatusBarScrim, ViewCompat.getLayoutDirection(this));
            Drawable var3 = this.mStatusBarScrim;
            boolean var4;
            if(this.getVisibility() == 0) {
               var4 = true;
            } else {
               var4 = false;
            }

            var3.setVisible(var4, false);
            this.mStatusBarScrim.setCallback(this);
            this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
         }

         ViewCompat.postInvalidateOnAnimation(this);
      }

   }

   public void setStatusBarScrimColor(@ColorInt int var1) {
      this.setStatusBarScrim(new ColorDrawable(var1));
   }

   public void setStatusBarScrimResource(@DrawableRes int var1) {
      this.setStatusBarScrim(ContextCompat.getDrawable(this.getContext(), var1));
   }

   public void setTitle(@Nullable CharSequence var1) {
      this.mCollapsingTextHelper.setText(var1);
   }

   public void setTitleEnabled(boolean var1) {
      if(var1 != this.mCollapsingTitleEnabled) {
         this.mCollapsingTitleEnabled = var1;
         this.updateDummyView();
         this.requestLayout();
      }

   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(this.mStatusBarScrim != null && this.mStatusBarScrim.isVisible() != var2) {
         this.mStatusBarScrim.setVisible(var2, false);
      }

      if(this.mContentScrim != null && this.mContentScrim.isVisible() != var2) {
         this.mContentScrim.setVisible(var2, false);
      }

   }

   protected boolean verifyDrawable(Drawable var1) {
      return super.verifyDrawable(var1) || var1 == this.mContentScrim || var1 == this.mStatusBarScrim;
   }

   public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
      public static final int COLLAPSE_MODE_OFF = 0;
      public static final int COLLAPSE_MODE_PARALLAX = 2;
      public static final int COLLAPSE_MODE_PIN = 1;
      private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5F;
      int mCollapseMode = 0;
      float mParallaxMult = 0.5F;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(int var1, int var2, int var3) {
         super(var1, var2, var3);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, class_5.styleable.CollapsingAppBarLayout_LayoutParams);
         this.mCollapseMode = var3.getInt(class_5.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
         this.setParallaxMultiplier(var3.getFloat(class_5.styleable.CollapsingAppBarLayout_LayoutParams_layout_collapseParallaxMultiplier, 0.5F));
         var3.recycle();
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.widget.FrameLayout.LayoutParams var1) {
         super(var1);
      }

      public int getCollapseMode() {
         return this.mCollapseMode;
      }

      public float getParallaxMultiplier() {
         return this.mParallaxMult;
      }

      public void setCollapseMode(int var1) {
         this.mCollapseMode = var1;
      }

      public void setParallaxMultiplier(float var1) {
         this.mParallaxMult = var1;
      }
   }

   private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
      private OffsetUpdateListener() {
      }

      // $FF: synthetic method
      OffsetUpdateListener(Object var2) {
         this();
      }

      public void onOffsetChanged(AppBarLayout var1, int var2) {
         CollapsingToolbarLayout.this.mCurrentOffset = var2;
         int var4;
         if(CollapsingToolbarLayout.this.mLastInsets != null) {
            var4 = CollapsingToolbarLayout.this.mLastInsets.getSystemWindowInsetTop();
         } else {
            var4 = 0;
         }

         int var5 = var1.getTotalScrollRange();
         int var6 = 0;

         for(int var7 = CollapsingToolbarLayout.this.getChildCount(); var6 < var7; ++var6) {
            View var13 = CollapsingToolbarLayout.this.getChildAt(var6);
            CollapsingToolbarLayout.LayoutParams var14 = (CollapsingToolbarLayout.LayoutParams)var13.getLayoutParams();
            ViewOffsetHelper var15 = CollapsingToolbarLayout.getViewOffsetHelper(var13);
            switch(var14.mCollapseMode) {
            case 1:
               if(var2 + (CollapsingToolbarLayout.this.getHeight() - var4) >= var13.getHeight()) {
                  var15.setTopAndBottomOffset(-var2);
               }
               break;
            case 2:
               var15.setTopAndBottomOffset(Math.round((float)(-var2) * var14.mParallaxMult));
            }
         }

         if(CollapsingToolbarLayout.this.mContentScrim != null || CollapsingToolbarLayout.this.mStatusBarScrim != null) {
            CollapsingToolbarLayout var8 = CollapsingToolbarLayout.this;
            int var9 = var2 + CollapsingToolbarLayout.this.getHeight();
            int var10 = var4 + CollapsingToolbarLayout.this.getScrimTriggerOffset();
            boolean var11 = false;
            if(var9 < var10) {
               var11 = true;
            }

            var8.setScrimsShown(var11);
         }

         if(CollapsingToolbarLayout.this.mStatusBarScrim != null && var4 > 0) {
            ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
         }

         int var12 = CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this) - var4;
         CollapsingToolbarLayout.this.mCollapsingTextHelper.setExpansionFraction((float)Math.abs(var2) / (float)var12);
         if(Math.abs(var2) == var5) {
            ViewCompat.setElevation(var1, var1.getTargetElevation());
         } else {
            ViewCompat.setElevation(var1, 0.0F);
         }
      }
   }
}
