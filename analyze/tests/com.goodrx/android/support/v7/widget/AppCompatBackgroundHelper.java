package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.TintInfo;
import android.util.AttributeSet;
import android.view.View;

class AppCompatBackgroundHelper {
   private TintInfo mBackgroundTint;
   private final AppCompatDrawableManager mDrawableManager;
   private TintInfo mInternalBackgroundTint;
   private TintInfo mTmpInfo;
   private final View mView;

   AppCompatBackgroundHelper(View var1, AppCompatDrawableManager var2) {
      this.mView = var1;
      this.mDrawableManager = var2;
   }

   private void compatTintDrawableUsingFrameworkTint(@NonNull Drawable var1) {
      if(this.mTmpInfo == null) {
         this.mTmpInfo = new TintInfo();
      }

      TintInfo var2 = this.mTmpInfo;
      var2.clear();
      ColorStateList var3 = ViewCompat.getBackgroundTintList(this.mView);
      if(var3 != null) {
         var2.mHasTintList = true;
         var2.mTintList = var3;
      }

      Mode var4 = ViewCompat.getBackgroundTintMode(this.mView);
      if(var4 != null) {
         var2.mHasTintMode = true;
         var2.mTintMode = var4;
      }

      if(var2.mHasTintList || var2.mHasTintMode) {
         AppCompatDrawableManager.tintDrawable(var1, var2, this.mView.getDrawableState());
      }

   }

   private boolean shouldCompatTintUsingFrameworkTint(@NonNull Drawable var1) {
      return VERSION.SDK_INT == 21 && var1 instanceof GradientDrawable;
   }

   void applySupportBackgroundTint() {
      Drawable var1 = this.mView.getBackground();
      if(var1 != null) {
         if(this.mBackgroundTint != null) {
            AppCompatDrawableManager.tintDrawable(var1, this.mBackgroundTint, this.mView.getDrawableState());
         } else {
            if(this.mInternalBackgroundTint != null) {
               AppCompatDrawableManager.tintDrawable(var1, this.mInternalBackgroundTint, this.mView.getDrawableState());
               return;
            }

            if(this.shouldCompatTintUsingFrameworkTint(var1)) {
               this.compatTintDrawableUsingFrameworkTint(var1);
               return;
            }
         }
      }

   }

   ColorStateList getSupportBackgroundTintList() {
      return this.mBackgroundTint != null?this.mBackgroundTint.mTintList:null;
   }

   Mode getSupportBackgroundTintMode() {
      return this.mBackgroundTint != null?this.mBackgroundTint.mTintMode:null;
   }

   void loadFromAttributes(AttributeSet param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   void onSetBackgroundDrawable(Drawable var1) {
      this.setInternalBackgroundTint((ColorStateList)null);
   }

   void onSetBackgroundResource(int var1) {
      ColorStateList var2;
      if(this.mDrawableManager != null) {
         var2 = this.mDrawableManager.getTintList(this.mView.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setInternalBackgroundTint(var2);
   }

   void setInternalBackgroundTint(ColorStateList var1) {
      if(var1 != null) {
         if(this.mInternalBackgroundTint == null) {
            this.mInternalBackgroundTint = new TintInfo();
         }

         this.mInternalBackgroundTint.mTintList = var1;
         this.mInternalBackgroundTint.mHasTintList = true;
      } else {
         this.mInternalBackgroundTint = null;
      }

      this.applySupportBackgroundTint();
   }

   void setSupportBackgroundTintList(ColorStateList var1) {
      if(this.mBackgroundTint == null) {
         this.mBackgroundTint = new TintInfo();
      }

      this.mBackgroundTint.mTintList = var1;
      this.mBackgroundTint.mHasTintList = true;
      this.applySupportBackgroundTint();
   }

   void setSupportBackgroundTintMode(Mode var1) {
      if(this.mBackgroundTint == null) {
         this.mBackgroundTint = new TintInfo();
      }

      this.mBackgroundTint.mTintMode = var1;
      this.mBackgroundTint.mHasTintMode = true;
      this.applySupportBackgroundTint();
   }
}
