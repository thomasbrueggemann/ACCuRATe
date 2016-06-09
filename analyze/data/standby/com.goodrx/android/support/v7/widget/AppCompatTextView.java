package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v7.widget.AppCompatBackgroundHelper;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatTextHelper;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements TintableBackgroundView {
   private AppCompatBackgroundHelper mBackgroundTintHelper;
   private AppCompatDrawableManager mDrawableManager;
   private AppCompatTextHelper mTextHelper;

   public AppCompatTextView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatTextView(Context var1, AttributeSet var2) {
      this(var1, var2, 16842884);
   }

   public AppCompatTextView(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.wrap(var1), var2, var3);
      this.mDrawableManager = AppCompatDrawableManager.get();
      this.mBackgroundTintHelper = new AppCompatBackgroundHelper(this, this.mDrawableManager);
      this.mBackgroundTintHelper.loadFromAttributes(var2, var3);
      this.mTextHelper = AppCompatTextHelper.create(this);
      this.mTextHelper.loadFromAttributes(var2, var3);
      this.mTextHelper.applyCompoundDrawablesTints();
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.applySupportBackgroundTint();
      }

      if(this.mTextHelper != null) {
         this.mTextHelper.applyCompoundDrawablesTints();
      }

   }

   @Nullable
   public ColorStateList getSupportBackgroundTintList() {
      return this.mBackgroundTintHelper != null?this.mBackgroundTintHelper.getSupportBackgroundTintList():null;
   }

   @Nullable
   public Mode getSupportBackgroundTintMode() {
      return this.mBackgroundTintHelper != null?this.mBackgroundTintHelper.getSupportBackgroundTintMode():null;
   }

   public void setBackgroundDrawable(Drawable var1) {
      super.setBackgroundDrawable(var1);
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.onSetBackgroundDrawable(var1);
      }

   }

   public void setBackgroundResource(@DrawableRes int var1) {
      super.setBackgroundResource(var1);
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.onSetBackgroundResource(var1);
      }

   }

   public void setSupportBackgroundTintList(@Nullable ColorStateList var1) {
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.setSupportBackgroundTintList(var1);
      }

   }

   public void setSupportBackgroundTintMode(@Nullable Mode var1) {
      if(this.mBackgroundTintHelper != null) {
         this.mBackgroundTintHelper.setSupportBackgroundTintMode(var1);
      }

   }

   public void setTextAppearance(Context var1, int var2) {
      super.setTextAppearance(var1, var2);
      if(this.mTextHelper != null) {
         this.mTextHelper.onSetTextAppearance(var1, var2);
      }

   }
}
