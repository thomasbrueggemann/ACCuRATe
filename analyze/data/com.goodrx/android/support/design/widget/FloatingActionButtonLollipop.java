package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.design.widget.CircularBorderDrawable;
import android.support.design.widget.CircularBorderDrawableLollipop;
import android.support.design.widget.FloatingActionButtonIcs;
import android.support.design.widget.ShadowDrawableWrapper;
import android.support.design.widget.ShadowViewDelegate;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.Interpolator;

@TargetApi(21)
class FloatingActionButtonLollipop extends FloatingActionButtonIcs {
   private InsetDrawable mInsetDrawable;
   private final Interpolator mInterpolator;

   FloatingActionButtonLollipop(VisibilityAwareImageButton var1, ShadowViewDelegate var2) {
      super(var1, var2);
      Interpolator var3;
      if(var1.isInEditMode()) {
         var3 = null;
      } else {
         var3 = android.view.animation.AnimationUtils.loadInterpolator(this.mView.getContext(), 17563661);
      }

      this.mInterpolator = var3;
   }

   private Animator setupAnimator(Animator var1) {
      var1.setInterpolator(this.mInterpolator);
      return var1;
   }

   public float getElevation() {
      return this.mView.getElevation();
   }

   void getPadding(Rect var1) {
      if(this.mShadowViewDelegate.isCompatPaddingEnabled()) {
         float var2 = this.mShadowViewDelegate.getRadius();
         float var3 = this.getElevation() + this.mPressedTranslationZ;
         int var4 = (int)Math.ceil((double)ShadowDrawableWrapper.calculateHorizontalPadding(var3, var2, false));
         int var5 = (int)Math.ceil((double)ShadowDrawableWrapper.calculateVerticalPadding(var3, var2, false));
         var1.set(var4, var5, var4, var5);
      } else {
         var1.set(0, 0, 0, 0);
      }
   }

   void jumpDrawableToCurrentState() {
   }

   CircularBorderDrawable newCircularDrawable() {
      return new CircularBorderDrawableLollipop();
   }

   void onCompatShadowChanged() {
      this.updatePadding();
   }

   void onDrawableStateChanged(int[] var1) {
   }

   public void onElevationChanged(float var1) {
      this.mView.setElevation(var1);
      if(this.mShadowViewDelegate.isCompatPaddingEnabled()) {
         this.updatePadding();
      }

   }

   void onPaddingUpdated(Rect var1) {
      if(this.mShadowViewDelegate.isCompatPaddingEnabled()) {
         this.mInsetDrawable = new InsetDrawable(this.mRippleDrawable, var1.left, var1.top, var1.right, var1.bottom);
         this.mShadowViewDelegate.setBackgroundDrawable(this.mInsetDrawable);
      } else {
         this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
      }
   }

   void onTranslationZChanged(float var1) {
      android.animation.StateListAnimator var2 = new android.animation.StateListAnimator();
      var2.addState(PRESSED_ENABLED_STATE_SET, this.setupAnimator(ObjectAnimator.ofFloat(this.mView, "translationZ", new float[]{var1})));
      var2.addState(FOCUSED_ENABLED_STATE_SET, this.setupAnimator(ObjectAnimator.ofFloat(this.mView, "translationZ", new float[]{var1})));
      var2.addState(EMPTY_STATE_SET, this.setupAnimator(ObjectAnimator.ofFloat(this.mView, "translationZ", new float[]{0.0F})));
      this.mView.setStateListAnimator(var2);
      if(this.mShadowViewDelegate.isCompatPaddingEnabled()) {
         this.updatePadding();
      }

   }

   boolean requirePreDrawListener() {
      return false;
   }

   void setBackgroundDrawable(ColorStateList var1, Mode var2, int var3, int var4) {
      this.mShapeDrawable = DrawableCompat.wrap(this.createShapeDrawable());
      DrawableCompat.setTintList(this.mShapeDrawable, var1);
      if(var2 != null) {
         DrawableCompat.setTintMode(this.mShapeDrawable, var2);
      }

      Object var5;
      if(var4 > 0) {
         this.mBorderDrawable = this.createBorderDrawable(var4, var1);
         Drawable[] var6 = new Drawable[]{this.mBorderDrawable, this.mShapeDrawable};
         var5 = new LayerDrawable(var6);
      } else {
         this.mBorderDrawable = null;
         var5 = this.mShapeDrawable;
      }

      this.mRippleDrawable = new RippleDrawable(ColorStateList.valueOf(var3), (Drawable)var5, (Drawable)null);
      this.mContentBackground = this.mRippleDrawable;
      this.mShadowViewDelegate.setBackgroundDrawable(this.mRippleDrawable);
   }

   void setRippleColor(int var1) {
      if(this.mRippleDrawable instanceof RippleDrawable) {
         ((RippleDrawable)this.mRippleDrawable).setColor(ColorStateList.valueOf(var1));
      } else {
         super.setRippleColor(var1);
      }
   }
}
