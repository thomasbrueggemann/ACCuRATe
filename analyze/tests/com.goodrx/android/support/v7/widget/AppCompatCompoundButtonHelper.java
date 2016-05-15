package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper {
   private ColorStateList mButtonTintList = null;
   private Mode mButtonTintMode = null;
   private final AppCompatDrawableManager mDrawableManager;
   private boolean mHasButtonTint = false;
   private boolean mHasButtonTintMode = false;
   private boolean mSkipNextApply;
   private final CompoundButton mView;

   AppCompatCompoundButtonHelper(CompoundButton var1, AppCompatDrawableManager var2) {
      this.mView = var1;
      this.mDrawableManager = var2;
   }

   void applyButtonTint() {
      Drawable var1 = CompoundButtonCompat.getButtonDrawable(this.mView);
      if(var1 != null && (this.mHasButtonTint || this.mHasButtonTintMode)) {
         Drawable var2 = DrawableCompat.wrap(var1).mutate();
         if(this.mHasButtonTint) {
            DrawableCompat.setTintList(var2, this.mButtonTintList);
         }

         if(this.mHasButtonTintMode) {
            DrawableCompat.setTintMode(var2, this.mButtonTintMode);
         }

         if(var2.isStateful()) {
            var2.setState(this.mView.getDrawableState());
         }

         this.mView.setButtonDrawable(var2);
      }

   }

   int getCompoundPaddingLeft(int var1) {
      if(VERSION.SDK_INT < 17) {
         Drawable var2 = CompoundButtonCompat.getButtonDrawable(this.mView);
         if(var2 != null) {
            var1 += var2.getIntrinsicWidth();
         }
      }

      return var1;
   }

   ColorStateList getSupportButtonTintList() {
      return this.mButtonTintList;
   }

   Mode getSupportButtonTintMode() {
      return this.mButtonTintMode;
   }

   void loadFromAttributes(AttributeSet param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   void onSetButtonDrawable() {
      if(this.mSkipNextApply) {
         this.mSkipNextApply = false;
      } else {
         this.mSkipNextApply = true;
         this.applyButtonTint();
      }
   }

   void setSupportButtonTintList(ColorStateList var1) {
      this.mButtonTintList = var1;
      this.mHasButtonTint = true;
      this.applyButtonTint();
   }

   void setSupportButtonTintMode(@Nullable Mode var1) {
      this.mButtonTintMode = var1;
      this.mHasButtonTintMode = true;
      this.applyButtonTint();
   }

   interface DirectSetButtonDrawableInterface {
      void setButtonDrawable(Drawable var1);
   }
}
