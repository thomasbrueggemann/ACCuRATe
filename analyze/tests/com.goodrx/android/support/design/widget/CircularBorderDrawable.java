package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.ColorUtils;

class CircularBorderDrawable extends Drawable {
   private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333F;
   private ColorStateList mBorderTint;
   float mBorderWidth;
   private int mBottomInnerStrokeColor;
   private int mBottomOuterStrokeColor;
   private int mCurrentBorderTintColor;
   private boolean mInvalidateShader = true;
   final Paint mPaint = new Paint(1);
   final Rect mRect = new Rect();
   final RectF mRectF = new RectF();
   private float mRotation;
   private int mTopInnerStrokeColor;
   private int mTopOuterStrokeColor;

   public CircularBorderDrawable() {
      this.mPaint.setStyle(Style.STROKE);
   }

   private Shader createGradientShader() {
      Rect var1 = this.mRect;
      this.copyBounds(var1);
      float var2 = this.mBorderWidth / (float)var1.height();
      int[] var3 = new int[]{ColorUtils.compositeColors(this.mTopOuterStrokeColor, this.mCurrentBorderTintColor), ColorUtils.compositeColors(this.mTopInnerStrokeColor, this.mCurrentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.mTopInnerStrokeColor, 0), this.mCurrentBorderTintColor), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.mBottomInnerStrokeColor, 0), this.mCurrentBorderTintColor), ColorUtils.compositeColors(this.mBottomInnerStrokeColor, this.mCurrentBorderTintColor), ColorUtils.compositeColors(this.mBottomOuterStrokeColor, this.mCurrentBorderTintColor)};
      float[] var4 = new float[]{0.0F, var2, 0.5F, 0.5F, 1.0F - var2, 1.0F};
      return new LinearGradient(0.0F, (float)var1.top, 0.0F, (float)var1.bottom, var3, var4, TileMode.CLAMP);
   }

   public void draw(Canvas var1) {
      if(this.mInvalidateShader) {
         this.mPaint.setShader(this.createGradientShader());
         this.mInvalidateShader = false;
      }

      float var2 = this.mPaint.getStrokeWidth() / 2.0F;
      RectF var3 = this.mRectF;
      this.copyBounds(this.mRect);
      var3.set(this.mRect);
      var3.left += var2;
      var3.top += var2;
      var3.right -= var2;
      var3.bottom -= var2;
      var1.save();
      var1.rotate(this.mRotation, var3.centerX(), var3.centerY());
      var1.drawOval(var3, this.mPaint);
      var1.restore();
   }

   public int getOpacity() {
      return this.mBorderWidth > 0.0F?-3:-2;
   }

   public boolean getPadding(Rect var1) {
      int var2 = Math.round(this.mBorderWidth);
      var1.set(var2, var2, var2, var2);
      return true;
   }

   public boolean isStateful() {
      return this.mBorderTint != null && this.mBorderTint.isStateful() || super.isStateful();
   }

   protected void onBoundsChange(Rect var1) {
      this.mInvalidateShader = true;
   }

   protected boolean onStateChange(int[] var1) {
      if(this.mBorderTint != null) {
         int var2 = this.mBorderTint.getColorForState(var1, this.mCurrentBorderTintColor);
         if(var2 != this.mCurrentBorderTintColor) {
            this.mInvalidateShader = true;
            this.mCurrentBorderTintColor = var2;
         }
      }

      if(this.mInvalidateShader) {
         this.invalidateSelf();
      }

      return this.mInvalidateShader;
   }

   public void setAlpha(int var1) {
      this.mPaint.setAlpha(var1);
      this.invalidateSelf();
   }

   void setBorderTint(ColorStateList var1) {
      if(var1 != null) {
         this.mCurrentBorderTintColor = var1.getColorForState(this.getState(), this.mCurrentBorderTintColor);
      }

      this.mBorderTint = var1;
      this.mInvalidateShader = true;
      this.invalidateSelf();
   }

   void setBorderWidth(float var1) {
      if(this.mBorderWidth != var1) {
         this.mBorderWidth = var1;
         this.mPaint.setStrokeWidth(1.3333F * var1);
         this.mInvalidateShader = true;
         this.invalidateSelf();
      }

   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
      this.invalidateSelf();
   }

   void setGradientColors(int var1, int var2, int var3, int var4) {
      this.mTopOuterStrokeColor = var1;
      this.mTopInnerStrokeColor = var2;
      this.mBottomOuterStrokeColor = var3;
      this.mBottomInnerStrokeColor = var4;
   }

   final void setRotation(float var1) {
      if(var1 != this.mRotation) {
         this.mRotation = var1;
         this.invalidateSelf();
      }

   }
}
