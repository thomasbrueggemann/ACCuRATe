package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.class_5;
import android.support.design.widget.AnimationUtils;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButtonEclairMr1;
import android.support.design.widget.FloatingActionButtonIcs;
import android.support.design.widget.FloatingActionButtonImpl;
import android.support.design.widget.FloatingActionButtonLollipop;
import android.support.design.widget.ShadowViewDelegate;
import android.support.design.widget.Snackbar;
import android.support.design.widget.ThemeUtils;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ViewGroupUtils;
import android.support.design.widget.ViewUtils;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@CoordinatorLayout.DefaultBehavior("Landroid/support/design/widget/FloatingActionButton$Behavior;")
public class FloatingActionButton extends VisibilityAwareImageButton {
   private static final String LOG_TAG = "FloatingActionButton";
   private static final int SIZE_MINI = 1;
   private static final int SIZE_NORMAL;
   private ColorStateList mBackgroundTint;
   private Mode mBackgroundTintMode;
   private int mBorderWidth;
   private boolean mCompatPadding;
   private int mImagePadding;
   private FloatingActionButtonImpl mImpl;
   private int mRippleColor;
   private final Rect mShadowPadding;
   private int mSize;

   public FloatingActionButton(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public FloatingActionButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public FloatingActionButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.mShadowPadding = new Rect();
      ThemeUtils.checkAppCompatTheme(var1);
      TypedArray var4 = var1.obtainStyledAttributes(var2, class_5.styleable.FloatingActionButton, var3, class_5.style.Widget_Design_FloatingActionButton);
      this.mBackgroundTint = var4.getColorStateList(class_5.styleable.FloatingActionButton_backgroundTint);
      this.mBackgroundTintMode = parseTintMode(var4.getInt(class_5.styleable.FloatingActionButton_backgroundTintMode, -1), (Mode)null);
      this.mRippleColor = var4.getColor(class_5.styleable.FloatingActionButton_rippleColor, 0);
      this.mSize = var4.getInt(class_5.styleable.FloatingActionButton_fabSize, 0);
      this.mBorderWidth = var4.getDimensionPixelSize(class_5.styleable.FloatingActionButton_borderWidth, 0);
      float var5 = var4.getDimension(class_5.styleable.FloatingActionButton_elevation, 0.0F);
      float var6 = var4.getDimension(class_5.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
      this.mCompatPadding = var4.getBoolean(class_5.styleable.FloatingActionButton_useCompatPadding, false);
      var4.recycle();
      int var7 = (int)this.getResources().getDimension(class_5.dimen.design_fab_image_size);
      this.mImagePadding = (this.getSizeDimension() - var7) / 2;
      this.getImpl().setBackgroundDrawable(this.mBackgroundTint, this.mBackgroundTintMode, this.mRippleColor, this.mBorderWidth);
      this.getImpl().setElevation(var5);
      this.getImpl().setPressedTranslationZ(var6);
      this.getImpl().updatePadding();
   }

   private FloatingActionButtonImpl createImpl() {
      int var1 = VERSION.SDK_INT;
      return (FloatingActionButtonImpl)(var1 >= 21?new FloatingActionButtonLollipop(this, new FloatingActionButton.ShadowDelegateImpl(null)):(var1 >= 14?new FloatingActionButtonIcs(this, new FloatingActionButton.ShadowDelegateImpl(null)):new FloatingActionButtonEclairMr1(this, new FloatingActionButton.ShadowDelegateImpl(null))));
   }

   private FloatingActionButtonImpl getImpl() {
      if(this.mImpl == null) {
         this.mImpl = this.createImpl();
      }

      return this.mImpl;
   }

   private void hide(@Nullable FloatingActionButton.OnVisibilityChangedListener var1, boolean var2) {
      this.getImpl().hide(this.wrapOnVisibilityChangedListener(var1), var2);
   }

   static Mode parseTintMode(int var0, Mode var1) {
      switch(var0) {
      case 3:
         return Mode.SRC_OVER;
      case 5:
         return Mode.SRC_IN;
      case 9:
         return Mode.SRC_ATOP;
      case 14:
         return Mode.MULTIPLY;
      case 15:
         return Mode.SCREEN;
      default:
         return var1;
      }
   }

   private static int resolveAdjustedSize(int var0, int var1) {
      int var2 = MeasureSpec.getMode(var1);
      int var3 = MeasureSpec.getSize(var1);
      switch(var2) {
      case Integer.MIN_VALUE:
         return Math.min(var0, var3);
      case 0:
         return var0;
      case 1073741824:
         return var3;
      default:
         return var0;
      }
   }

   private void show(FloatingActionButton.OnVisibilityChangedListener var1, boolean var2) {
      this.getImpl().show(this.wrapOnVisibilityChangedListener(var1), var2);
   }

   @Nullable
   private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(@Nullable final FloatingActionButton.OnVisibilityChangedListener var1) {
      return var1 == null?null:new FloatingActionButtonImpl.InternalVisibilityChangedListener() {
         public void onHidden() {
            var1.onHidden(FloatingActionButton.this);
         }

         public void onShown() {
            var1.onShown(FloatingActionButton.this);
         }
      };
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      this.getImpl().onDrawableStateChanged(this.getDrawableState());
   }

   @Nullable
   public ColorStateList getBackgroundTintList() {
      return this.mBackgroundTint;
   }

   @Nullable
   public Mode getBackgroundTintMode() {
      return this.mBackgroundTintMode;
   }

   public float getCompatElevation() {
      return this.getImpl().getElevation();
   }

   @NonNull
   public Drawable getContentBackground() {
      return this.getImpl().getContentBackground();
   }

   public boolean getContentRect(@NonNull Rect var1) {
      boolean var2 = ViewCompat.isLaidOut(this);
      boolean var3 = false;
      if(var2) {
         var1.set(0, 0, this.getWidth(), this.getHeight());
         var1.left += this.mShadowPadding.left;
         var1.top += this.mShadowPadding.top;
         var1.right -= this.mShadowPadding.right;
         var1.bottom -= this.mShadowPadding.bottom;
         var3 = true;
      }

      return var3;
   }

   final int getSizeDimension() {
      switch(this.mSize) {
      case 1:
         return this.getResources().getDimensionPixelSize(class_5.dimen.design_fab_size_mini);
      default:
         return this.getResources().getDimensionPixelSize(class_5.dimen.design_fab_size_normal);
      }
   }

   public boolean getUseCompatPadding() {
      return this.mCompatPadding;
   }

   public void hide() {
      this.hide((FloatingActionButton.OnVisibilityChangedListener)null);
   }

   public void hide(@Nullable FloatingActionButton.OnVisibilityChangedListener var1) {
      this.hide(var1, true);
   }

   @TargetApi(11)
   public void jumpDrawablesToCurrentState() {
      super.jumpDrawablesToCurrentState();
      this.getImpl().jumpDrawableToCurrentState();
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.getImpl().onAttachedToWindow();
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.getImpl().onDetachedFromWindow();
   }

   protected void onMeasure(int var1, int var2) {
      int var3 = this.getSizeDimension();
      int var4 = Math.min(resolveAdjustedSize(var3, var1), resolveAdjustedSize(var3, var2));
      this.setMeasuredDimension(var4 + this.mShadowPadding.left + this.mShadowPadding.right, var4 + this.mShadowPadding.top + this.mShadowPadding.bottom);
   }

   public void setBackgroundColor(int var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundDrawable(Drawable var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundResource(int var1) {
      Log.i("FloatingActionButton", "Setting a custom background is not supported.");
   }

   public void setBackgroundTintList(@Nullable ColorStateList var1) {
      if(this.mBackgroundTint != var1) {
         this.mBackgroundTint = var1;
         this.getImpl().setBackgroundTintList(var1);
      }

   }

   public void setBackgroundTintMode(@Nullable Mode var1) {
      if(this.mBackgroundTintMode != var1) {
         this.mBackgroundTintMode = var1;
         this.getImpl().setBackgroundTintMode(var1);
      }

   }

   public void setCompatElevation(float var1) {
      this.getImpl().setElevation(var1);
   }

   public void setRippleColor(@ColorInt int var1) {
      if(this.mRippleColor != var1) {
         this.mRippleColor = var1;
         this.getImpl().setRippleColor(var1);
      }

   }

   public void setUseCompatPadding(boolean var1) {
      if(this.mCompatPadding != var1) {
         this.mCompatPadding = var1;
         this.getImpl().onCompatShadowChanged();
      }

   }

   public void show() {
      this.show((FloatingActionButton.OnVisibilityChangedListener)null);
   }

   public void show(@Nullable FloatingActionButton.OnVisibilityChangedListener var1) {
      this.show(var1, true);
   }

   public static class Behavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
      private static final boolean SNACKBAR_BEHAVIOR_ENABLED;
      private float mFabTranslationY;
      private ValueAnimatorCompat mFabTranslationYAnimator;
      private Rect mTmpRect;

      static {
         boolean var0;
         if(VERSION.SDK_INT >= 11) {
            var0 = true;
         } else {
            var0 = false;
         }

         SNACKBAR_BEHAVIOR_ENABLED = var0;
      }

      private float getFabTranslationYForSnackbar(CoordinatorLayout var1, FloatingActionButton var2) {
         float var3 = 0.0F;
         List var4 = var1.getDependencies(var2);
         int var5 = 0;

         for(int var6 = var4.size(); var5 < var6; ++var5) {
            View var7 = (View)var4.get(var5);
            if(var7 instanceof Snackbar.SnackbarLayout && var1.doViewsOverlap(var2, var7)) {
               var3 = Math.min(var3, ViewCompat.getTranslationY(var7) - (float)var7.getHeight());
            }
         }

         return var3;
      }

      private void offsetIfNeeded(CoordinatorLayout var1, FloatingActionButton var2) {
         Rect var3 = var2.mShadowPadding;
         if(var3 != null && var3.centerX() > 0 && var3.centerY() > 0) {
            CoordinatorLayout.LayoutParams var4 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
            int var7;
            if(var2.getRight() >= var1.getWidth() - var4.rightMargin) {
               var7 = var3.right;
            } else {
               int var5 = var2.getLeft();
               int var6 = var4.leftMargin;
               var7 = 0;
               if(var5 <= var6) {
                  var7 = -var3.left;
               }
            }

            int var10;
            if(var2.getBottom() >= var1.getBottom() - var4.bottomMargin) {
               var10 = var3.bottom;
            } else {
               int var8 = var2.getTop();
               int var9 = var4.topMargin;
               var10 = 0;
               if(var8 <= var9) {
                  var10 = -var3.top;
               }
            }

            var2.offsetTopAndBottom(var10);
            var2.offsetLeftAndRight(var7);
         }

      }

      private void updateFabTranslationForSnackbar(CoordinatorLayout var1, final FloatingActionButton var2, View var3) {
         float var4 = this.getFabTranslationYForSnackbar(var1, var2);
         if(this.mFabTranslationY != var4) {
            float var5 = ViewCompat.getTranslationY(var2);
            if(this.mFabTranslationYAnimator != null && this.mFabTranslationYAnimator.isRunning()) {
               this.mFabTranslationYAnimator.cancel();
            }

            if(var2.isShown() && Math.abs(var5 - var4) > 0.667F * (float)var2.getHeight()) {
               if(this.mFabTranslationYAnimator == null) {
                  this.mFabTranslationYAnimator = ViewUtils.createAnimator();
                  this.mFabTranslationYAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                  this.mFabTranslationYAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
                     public void onAnimationUpdate(ValueAnimatorCompat var1) {
                        ViewCompat.setTranslationY(var2, var1.getAnimatedFloatValue());
                     }
                  });
               }

               this.mFabTranslationYAnimator.setFloatValues(var5, var4);
               this.mFabTranslationYAnimator.start();
            } else {
               ViewCompat.setTranslationY(var2, var4);
            }

            this.mFabTranslationY = var4;
         }
      }

      private boolean updateFabVisibility(CoordinatorLayout var1, AppBarLayout var2, FloatingActionButton var3) {
         if(((CoordinatorLayout.LayoutParams)var3.getLayoutParams()).getAnchorId() == var2.getId() && var3.getUserSetVisibility() == 0) {
            if(this.mTmpRect == null) {
               this.mTmpRect = new Rect();
            }

            Rect var4 = this.mTmpRect;
            ViewGroupUtils.getDescendantRect(var1, var2, var4);
            if(var4.bottom <= var2.getMinimumHeightForVisibleOverlappingContent()) {
               var3.hide((FloatingActionButton.OnVisibilityChangedListener)null, false);
            } else {
               var3.show((FloatingActionButton.OnVisibilityChangedListener)null, false);
            }

            return true;
         } else {
            return false;
         }
      }

      public boolean layoutDependsOn(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
         return SNACKBAR_BEHAVIOR_ENABLED && var3 instanceof Snackbar.SnackbarLayout;
      }

      public boolean onDependentViewChanged(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
         if(var3 instanceof Snackbar.SnackbarLayout) {
            this.updateFabTranslationForSnackbar(var1, var2, var3);
         } else if(var3 instanceof AppBarLayout) {
            this.updateFabVisibility(var1, (AppBarLayout)var3, var2);
         }

         return false;
      }

      public boolean onLayoutChild(CoordinatorLayout var1, FloatingActionButton var2, int var3) {
         List var4 = var1.getDependencies(var2);
         int var5 = 0;

         for(int var6 = var4.size(); var5 < var6; ++var5) {
            View var7 = (View)var4.get(var5);
            if(var7 instanceof AppBarLayout && this.updateFabVisibility(var1, (AppBarLayout)var7, var2)) {
               break;
            }
         }

         var1.onLayoutChild(var2, var3);
         this.offsetIfNeeded(var1, var2);
         return true;
      }
   }

   public abstract static class OnVisibilityChangedListener {
      public void onHidden(FloatingActionButton var1) {
      }

      public void onShown(FloatingActionButton var1) {
      }
   }

   private class ShadowDelegateImpl implements ShadowViewDelegate {
      private ShadowDelegateImpl() {
      }

      // $FF: synthetic method
      ShadowDelegateImpl(Object var2) {
         this();
      }

      public float getRadius() {
         return (float)FloatingActionButton.this.getSizeDimension() / 2.0F;
      }

      public boolean isCompatPaddingEnabled() {
         return FloatingActionButton.this.mCompatPadding;
      }

      public void setBackgroundDrawable(Drawable var1) {
         FloatingActionButton.super.setBackgroundDrawable(var1);
      }

      public void setShadowPadding(int var1, int var2, int var3, int var4) {
         FloatingActionButton.this.mShadowPadding.set(var1, var2, var3, var4);
         FloatingActionButton.this.setPadding(var1 + FloatingActionButton.this.mImagePadding, var2 + FloatingActionButton.this.mImagePadding, var3 + FloatingActionButton.this.mImagePadding, var4 + FloatingActionButton.this.mImagePadding);
      }
   }
}
