package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.class_22;
import android.support.v7.widget.AppCompatCompoundButtonHelper;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {
   private AppCompatCompoundButtonHelper mCompoundButtonHelper;
   private AppCompatDrawableManager mDrawableManager;

   public AppCompatCheckBox(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public AppCompatCheckBox(Context var1, AttributeSet var2) {
      this(var1, var2, class_22.attr.checkboxStyle);
   }

   public AppCompatCheckBox(Context var1, AttributeSet var2, int var3) {
      super(TintContextWrapper.wrap(var1), var2, var3);
      this.mDrawableManager = AppCompatDrawableManager.get();
      this.mCompoundButtonHelper = new AppCompatCompoundButtonHelper(this, this.mDrawableManager);
      this.mCompoundButtonHelper.loadFromAttributes(var2, var3);
   }

   public int getCompoundPaddingLeft() {
      int var1 = super.getCompoundPaddingLeft();
      if(this.mCompoundButtonHelper != null) {
         var1 = this.mCompoundButtonHelper.getCompoundPaddingLeft(var1);
      }

      return var1;
   }

   @Nullable
   public ColorStateList getSupportButtonTintList() {
      return this.mCompoundButtonHelper != null?this.mCompoundButtonHelper.getSupportButtonTintList():null;
   }

   @Nullable
   public Mode getSupportButtonTintMode() {
      return this.mCompoundButtonHelper != null?this.mCompoundButtonHelper.getSupportButtonTintMode():null;
   }

   public void setButtonDrawable(@DrawableRes int var1) {
      Drawable var2;
      if(this.mDrawableManager != null) {
         var2 = this.mDrawableManager.getDrawable(this.getContext(), var1);
      } else {
         var2 = ContextCompat.getDrawable(this.getContext(), var1);
      }

      this.setButtonDrawable(var2);
   }

   public void setButtonDrawable(Drawable var1) {
      super.setButtonDrawable(var1);
      if(this.mCompoundButtonHelper != null) {
         this.mCompoundButtonHelper.onSetButtonDrawable();
      }

   }

   public void setSupportButtonTintList(@Nullable ColorStateList var1) {
      if(this.mCompoundButtonHelper != null) {
         this.mCompoundButtonHelper.setSupportButtonTintList(var1);
      }

   }

   public void setSupportButtonTintMode(@Nullable Mode var1) {
      if(this.mCompoundButtonHelper != null) {
         this.mCompoundButtonHelper.setSupportButtonTintMode(var1);
      }

   }
}
