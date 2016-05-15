package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.drawee.drawable.Rounded;
import java.util.Arrays;

public class RoundedColorDrawable extends Drawable implements Rounded {
   private int mAlpha;
   private int mBorderColor;
   @VisibleForTesting
   final Path mBorderPath;
   @VisibleForTesting
   final float[] mBorderRadii;
   private float mBorderWidth;
   private int mColor;
   private boolean mIsCircle;
   private float mPadding;
   @VisibleForTesting
   final Paint mPaint;
   @VisibleForTesting
   final Path mPath;
   private final float[] mRadii;
   private final RectF mTempRect;

   public RoundedColorDrawable(float var1, int var2) {
      this(var2);
      this.setRadius(var1);
   }

   public RoundedColorDrawable(int var1) {
      this.mRadii = new float[8];
      this.mBorderRadii = new float[8];
      this.mPaint = new Paint(1);
      this.mIsCircle = false;
      this.mBorderWidth = 0.0F;
      this.mPadding = 0.0F;
      this.mBorderColor = 0;
      this.mPath = new Path();
      this.mBorderPath = new Path();
      this.mColor = 0;
      this.mTempRect = new RectF();
      this.mAlpha = 255;
      this.setColor(var1);
   }

   public RoundedColorDrawable(float[] var1, int var2) {
      this(var2);
      this.setRadii(var1);
   }

   public static RoundedColorDrawable fromColorDrawable(ColorDrawable var0) {
      return new RoundedColorDrawable(var0.getColor());
   }

   private void updatePath() {
      this.mPath.reset();
      this.mBorderPath.reset();
      this.mTempRect.set(this.getBounds());
      this.mTempRect.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      if(this.mIsCircle) {
         float var3 = Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0F;
         this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), var3, Direction.CW);
      } else {
         for(int var1 = 0; var1 < this.mBorderRadii.length; ++var1) {
            this.mBorderRadii[var1] = this.mRadii[var1] + this.mPadding - this.mBorderWidth / 2.0F;
         }

         this.mBorderPath.addRoundRect(this.mTempRect, this.mBorderRadii, Direction.CW);
      }

      this.mTempRect.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
      this.mTempRect.inset(this.mPadding, this.mPadding);
      if(this.mIsCircle) {
         float var2 = Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0F;
         this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), var2, Direction.CW);
      } else {
         this.mPath.addRoundRect(this.mTempRect, this.mRadii, Direction.CW);
      }

      this.mTempRect.inset(-this.mPadding, -this.mPadding);
   }

   public void draw(Canvas var1) {
      this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
      this.mPaint.setStyle(Style.FILL);
      var1.drawPath(this.mPath, this.mPaint);
      if(this.mBorderWidth != 0.0F) {
         this.mPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
         this.mPaint.setStyle(Style.STROKE);
         this.mPaint.setStrokeWidth(this.mBorderWidth);
         var1.drawPath(this.mBorderPath, this.mPaint);
      }

   }

   public int getAlpha() {
      return this.mAlpha;
   }

   public int getBorderColor() {
      return this.mBorderColor;
   }

   public float getBorderWidth() {
      return this.mBorderWidth;
   }

   public int getColor() {
      return this.mColor;
   }

   public int getOpacity() {
      return DrawableUtils.getOpacityFromColor(DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
   }

   public float getPadding() {
      return this.mPadding;
   }

   public float[] getRadii() {
      return this.mRadii;
   }

   public boolean isCircle() {
      return this.mIsCircle;
   }

   protected void onBoundsChange(Rect var1) {
      super.onBoundsChange(var1);
      this.updatePath();
   }

   public void setAlpha(int var1) {
      if(var1 != this.mAlpha) {
         this.mAlpha = var1;
         this.invalidateSelf();
      }

   }

   public void setBorder(int var1, float var2) {
      if(this.mBorderColor != var1) {
         this.mBorderColor = var1;
         this.invalidateSelf();
      }

      if(this.mBorderWidth != var2) {
         this.mBorderWidth = var2;
         this.updatePath();
         this.invalidateSelf();
      }

   }

   public void setCircle(boolean var1) {
      this.mIsCircle = var1;
      this.updatePath();
      this.invalidateSelf();
   }

   public void setColor(int var1) {
      if(this.mColor != var1) {
         this.mColor = var1;
         this.invalidateSelf();
      }

   }

   public void setColorFilter(ColorFilter var1) {
   }

   public void setPadding(float var1) {
      if(this.mPadding != var1) {
         this.mPadding = var1;
         this.updatePath();
         this.invalidateSelf();
      }

   }

   public void setRadii(float[] var1) {
      if(var1 == null) {
         Arrays.fill(this.mRadii, 0.0F);
      } else {
         boolean var2;
         if(var1.length == 8) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkArgument(var2, "radii should have exactly 8 values");
         System.arraycopy(var1, 0, this.mRadii, 0, 8);
      }

      this.updatePath();
      this.invalidateSelf();
   }

   public void setRadius(float var1) {
      boolean var2;
      if(var1 >= 0.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2, "radius should be non negative");
      Arrays.fill(this.mRadii, var1);
      this.updatePath();
      this.invalidateSelf();
   }
}
