package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.DrawableUtils;

public class ProgressBarDrawable extends Drawable {
   private int mBackgroundColor = Integer.MIN_VALUE;
   private int mBarWidth = 20;
   private int mColor = -2147450625;
   private boolean mHideWhenZero = false;
   private int mLevel = 0;
   private int mPadding = 10;
   private final Paint mPaint = new Paint(1);

   private void drawBar(Canvas var1, int var2, int var3) {
      Rect var4 = this.getBounds();
      int var5 = var2 * (var4.width() - 2 * this.mPadding) / 10000;
      int var6 = var4.left + this.mPadding;
      int var7 = var4.bottom - this.mPadding - this.mBarWidth;
      this.mPaint.setColor(var3);
      var1.drawRect((float)var6, (float)var7, (float)(var6 + var5), (float)(var7 + this.mBarWidth), this.mPaint);
   }

   public void draw(Canvas var1) {
      if(!this.mHideWhenZero || this.mLevel != 0) {
         this.drawBar(var1, 10000, this.mBackgroundColor);
         this.drawBar(var1, this.mLevel, this.mColor);
      }
   }

   public int getBackgroundColor() {
      return this.mBackgroundColor;
   }

   public int getBarWidth() {
      return this.mBarWidth;
   }

   public int getColor() {
      return this.mColor;
   }

   public boolean getHideWhenZero() {
      return this.mHideWhenZero;
   }

   public int getOpacity() {
      return DrawableUtils.getOpacityFromColor(this.mPaint.getColor());
   }

   public boolean getPadding(Rect var1) {
      var1.set(this.mPadding, this.mPadding, this.mPadding, this.mPadding);
      return this.mPadding != 0;
   }

   protected boolean onLevelChange(int var1) {
      this.mLevel = var1;
      this.invalidateSelf();
      return true;
   }

   public void setAlpha(int var1) {
      this.mPaint.setAlpha(var1);
   }

   public void setBackgroundColor(int var1) {
      if(this.mBackgroundColor != var1) {
         this.mBackgroundColor = var1;
         this.invalidateSelf();
      }

   }

   public void setBarWidth(int var1) {
      if(this.mBarWidth != var1) {
         this.mBarWidth = var1;
         this.invalidateSelf();
      }

   }

   public void setColor(int var1) {
      if(this.mColor != var1) {
         this.mColor = var1;
         this.invalidateSelf();
      }

   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
   }

   public void setHideWhenZero(boolean var1) {
      this.mHideWhenZero = var1;
   }

   public void setPadding(int var1) {
      if(this.mPadding != var1) {
         this.mPadding = var1;
         this.invalidateSelf();
      }

   }
}
