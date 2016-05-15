package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.Rounded;
import java.util.Arrays;

public class RoundedCornersDrawable extends ForwardingDrawable implements Rounded {
   private int mBorderColor;
   private final Path mBorderPath;
   @VisibleForTesting
   final float[] mBorderRadii;
   private float mBorderWidth;
   private boolean mIsCircle;
   private int mOverlayColor;
   private float mPadding;
   @VisibleForTesting
   final Paint mPaint;
   private final Path mPath;
   private final float[] mRadii;
   private final RectF mTempRectangle;
   @VisibleForTesting
   RoundedCornersDrawable.Type mType;

   public RoundedCornersDrawable(Drawable var1) {
      super((Drawable)Preconditions.checkNotNull(var1));
      this.mType = RoundedCornersDrawable.Type.OVERLAY_COLOR;
      this.mRadii = new float[8];
      this.mBorderRadii = new float[8];
      this.mPaint = new Paint(1);
      this.mIsCircle = false;
      this.mBorderWidth = 0.0F;
      this.mBorderColor = 0;
      this.mOverlayColor = 0;
      this.mPadding = 0.0F;
      this.mPath = new Path();
      this.mBorderPath = new Path();
      this.mTempRectangle = new RectF();
   }

   private void updatePath() {
      this.mPath.reset();
      this.mBorderPath.reset();
      this.mTempRectangle.set(this.getBounds());
      this.mTempRectangle.inset(this.mPadding, this.mPadding);
      if(this.mIsCircle) {
         this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0F, Direction.CW);
      } else {
         this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, Direction.CW);
      }

      this.mTempRectangle.inset(-this.mPadding, -this.mPadding);
      this.mTempRectangle.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
      if(this.mIsCircle) {
         float var2 = Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0F;
         this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), var2, Direction.CW);
      } else {
         for(int var1 = 0; var1 < this.mBorderRadii.length; ++var1) {
            this.mBorderRadii[var1] = this.mRadii[var1] + this.mPadding - this.mBorderWidth / 2.0F;
         }

         this.mBorderPath.addRoundRect(this.mTempRectangle, this.mBorderRadii, Direction.CW);
      }

      this.mTempRectangle.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
   }

   public void draw(Canvas var1) {
      Rect var2 = this.getBounds();
      switch(null.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()]) {
      case 1:
         int var5 = var1.save();
         this.mPath.setFillType(FillType.EVEN_ODD);
         var1.clipPath(this.mPath);
         super.draw(var1);
         var1.restoreToCount(var5);
         break;
      case 2:
         super.draw(var1);
         this.mPaint.setColor(this.mOverlayColor);
         this.mPaint.setStyle(Style.FILL);
         this.mPath.setFillType(FillType.INVERSE_EVEN_ODD);
         var1.drawPath(this.mPath, this.mPaint);
         if(this.mIsCircle) {
            float var3 = ((float)(var2.width() - var2.height()) + this.mBorderWidth) / 2.0F;
            float var4 = ((float)(var2.height() - var2.width()) + this.mBorderWidth) / 2.0F;
            if(var3 > 0.0F) {
               var1.drawRect((float)var2.left, (float)var2.top, var3 + (float)var2.left, (float)var2.bottom, this.mPaint);
               var1.drawRect((float)var2.right - var3, (float)var2.top, (float)var2.right, (float)var2.bottom, this.mPaint);
            }

            if(var4 > 0.0F) {
               var1.drawRect((float)var2.left, (float)var2.top, (float)var2.right, var4 + (float)var2.top, this.mPaint);
               var1.drawRect((float)var2.left, (float)var2.bottom - var4, (float)var2.right, (float)var2.bottom, this.mPaint);
            }
         }
      }

      if(this.mBorderColor != 0) {
         this.mPaint.setStyle(Style.STROKE);
         this.mPaint.setColor(this.mBorderColor);
         this.mPaint.setStrokeWidth(this.mBorderWidth);
         this.mPath.setFillType(FillType.EVEN_ODD);
         var1.drawPath(this.mBorderPath, this.mPaint);
      }

   }

   public int getBorderColor() {
      return this.mBorderColor;
   }

   public float getBorderWidth() {
      return this.mBorderWidth;
   }

   public int getOverlayColor() {
      return this.mOverlayColor;
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

   public void setBorder(int var1, float var2) {
      this.mBorderColor = var1;
      this.mBorderWidth = var2;
      this.updatePath();
      this.invalidateSelf();
   }

   public void setCircle(boolean var1) {
      this.mIsCircle = var1;
      this.updatePath();
      this.invalidateSelf();
   }

   public void setOverlayColor(int var1) {
      this.mOverlayColor = var1;
      this.invalidateSelf();
   }

   public void setPadding(float var1) {
      this.mPadding = var1;
      this.updatePath();
      this.invalidateSelf();
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
      Arrays.fill(this.mRadii, var1);
      this.updatePath();
      this.invalidateSelf();
   }

   public void setType(RoundedCornersDrawable.Type var1) {
      this.mType = var1;
      this.invalidateSelf();
   }

   public static enum Type {
      CLIPPING,
      OVERLAY_COLOR;

      static {
         RoundedCornersDrawable.Type[] var0 = new RoundedCornersDrawable.Type[]{OVERLAY_COLOR, CLIPPING};
      }
   }
}
