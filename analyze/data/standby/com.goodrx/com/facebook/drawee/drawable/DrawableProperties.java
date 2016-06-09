package com.facebook.drawee.drawable;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class DrawableProperties {
   private static final int UNSET = -1;
   private int mAlpha = -1;
   private ColorFilter mColorFilter = null;
   private int mDither = -1;
   private int mFilterBitmap = -1;
   private boolean mIsSetColorFilter = false;

   public void applyTo(Drawable var1) {
      boolean var2 = true;
      if(var1 != null) {
         if(this.mAlpha != -1) {
            var1.setAlpha(this.mAlpha);
         }

         if(this.mIsSetColorFilter) {
            var1.setColorFilter(this.mColorFilter);
         }

         if(this.mDither != -1) {
            boolean var3;
            if(this.mDither != 0) {
               var3 = var2;
            } else {
               var3 = false;
            }

            var1.setDither(var3);
         }

         if(this.mFilterBitmap != -1) {
            if(this.mFilterBitmap == 0) {
               var2 = false;
            }

            var1.setFilterBitmap(var2);
            return;
         }
      }

   }

   public void setAlpha(int var1) {
      this.mAlpha = var1;
   }

   public void setColorFilter(ColorFilter var1) {
      this.mColorFilter = var1;
      this.mIsSetColorFilter = true;
   }

   public void setDither(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.mDither = var2;
   }

   public void setFilterBitmap(boolean var1) {
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.mFilterBitmap = var2;
   }
}
