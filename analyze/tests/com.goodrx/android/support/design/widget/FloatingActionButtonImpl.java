package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.design.class_5;
import android.support.design.widget.CircularBorderDrawable;
import android.support.design.widget.ShadowViewDelegate;
import android.support.design.widget.VisibilityAwareImageButton;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class FloatingActionButtonImpl {
   static final int[] EMPTY_STATE_SET = new int[0];
   static final int[] FOCUSED_ENABLED_STATE_SET = new int[]{16842908, 16842910};
   static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
   static final int SHOW_HIDE_ANIM_DURATION = 200;
   CircularBorderDrawable mBorderDrawable;
   Drawable mContentBackground;
   float mElevation;
   private OnPreDrawListener mPreDrawListener;
   float mPressedTranslationZ;
   Drawable mRippleDrawable;
   final ShadowViewDelegate mShadowViewDelegate;
   Drawable mShapeDrawable;
   private final Rect mTmpRect = new Rect();
   final VisibilityAwareImageButton mView;

   FloatingActionButtonImpl(VisibilityAwareImageButton var1, ShadowViewDelegate var2) {
      this.mView = var1;
      this.mShadowViewDelegate = var2;
   }

   private void ensurePreDrawListener() {
      if(this.mPreDrawListener == null) {
         this.mPreDrawListener = new OnPreDrawListener() {
            public boolean onPreDraw() {
               FloatingActionButtonImpl.this.onPreDraw();
               return true;
            }
         };
      }

   }

   CircularBorderDrawable createBorderDrawable(int var1, ColorStateList var2) {
      Resources var3 = this.mView.getResources();
      CircularBorderDrawable var4 = this.newCircularDrawable();
      var4.setGradientColors(var3.getColor(class_5.color.design_fab_stroke_top_outer_color), var3.getColor(class_5.color.design_fab_stroke_top_inner_color), var3.getColor(class_5.color.design_fab_stroke_end_inner_color), var3.getColor(class_5.color.design_fab_stroke_end_outer_color));
      var4.setBorderWidth((float)var1);
      var4.setBorderTint(var2);
      return var4;
   }

   GradientDrawable createShapeDrawable() {
      GradientDrawable var1 = new GradientDrawable();
      var1.setShape(1);
      var1.setColor(-1);
      return var1;
   }

   final Drawable getContentBackground() {
      return this.mContentBackground;
   }

   abstract float getElevation();

   abstract void getPadding(Rect var1);

   abstract void hide(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener var1, boolean var2);

   abstract void jumpDrawableToCurrentState();

   CircularBorderDrawable newCircularDrawable() {
      return new CircularBorderDrawable();
   }

   void onAttachedToWindow() {
      if(this.requirePreDrawListener()) {
         this.ensurePreDrawListener();
         this.mView.getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
      }

   }

   abstract void onCompatShadowChanged();

   void onDetachedFromWindow() {
      if(this.mPreDrawListener != null) {
         this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawListener);
         this.mPreDrawListener = null;
      }

   }

   abstract void onDrawableStateChanged(int[] var1);

   abstract void onElevationChanged(float var1);

   void onPaddingUpdated(Rect var1) {
   }

   void onPreDraw() {
   }

   abstract void onTranslationZChanged(float var1);

   boolean requirePreDrawListener() {
      return false;
   }

   abstract void setBackgroundDrawable(ColorStateList var1, Mode var2, int var3, int var4);

   abstract void setBackgroundTintList(ColorStateList var1);

   abstract void setBackgroundTintMode(Mode var1);

   final void setElevation(float var1) {
      if(this.mElevation != var1) {
         this.mElevation = var1;
         this.onElevationChanged(var1);
      }

   }

   final void setPressedTranslationZ(float var1) {
      if(this.mPressedTranslationZ != var1) {
         this.mPressedTranslationZ = var1;
         this.onTranslationZChanged(var1);
      }

   }

   abstract void setRippleColor(int var1);

   abstract void show(@Nullable FloatingActionButtonImpl.InternalVisibilityChangedListener var1, boolean var2);

   final void updatePadding() {
      Rect var1 = this.mTmpRect;
      this.getPadding(var1);
      this.onPaddingUpdated(var1);
      this.mShadowViewDelegate.setShadowPadding(var1.left, var1.top, var1.right, var1.bottom);
   }

   interface InternalVisibilityChangedListener {
      void onHidden();

      void onShown();
   }
}
