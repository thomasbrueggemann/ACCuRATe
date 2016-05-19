package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.class_91;

class RoundRectDrawableWithShadow extends Drawable {
   static final double COS_45 = Math.cos(Math.toRadians(45.0D));
   static final float SHADOW_MULTIPLIER = 1.5F;
   static RoundRectDrawableWithShadow.RoundRectHelper sRoundRectHelper;
   private boolean mAddPaddingForCorners = true;
   final RectF mCardBounds;
   float mCornerRadius;
   Paint mCornerShadowPaint;
   Path mCornerShadowPath;
   private boolean mDirty = true;
   Paint mEdgeShadowPaint;
   final int mInsetShadow;
   float mMaxShadowSize;
   Paint mPaint;
   private boolean mPrintedShadowClipWarning = false;
   float mRawMaxShadowSize;
   float mRawShadowSize;
   private final int mShadowEndColor;
   float mShadowSize;
   private final int mShadowStartColor;

   RoundRectDrawableWithShadow(Resources var1, int var2, float var3, float var4, float var5) {
      this.mShadowStartColor = var1.getColor(class_91.color.cardview_shadow_start_color);
      this.mShadowEndColor = var1.getColor(class_91.color.cardview_shadow_end_color);
      this.mInsetShadow = var1.getDimensionPixelSize(class_91.dimen.cardview_compat_inset_shadow);
      this.mPaint = new Paint(5);
      this.mPaint.setColor(var2);
      this.mCornerShadowPaint = new Paint(5);
      this.mCornerShadowPaint.setStyle(Style.FILL);
      this.mCornerRadius = (float)((int)(0.5F + var3));
      this.mCardBounds = new RectF();
      this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
      this.mEdgeShadowPaint.setAntiAlias(false);
      this.setShadowSize(var4, var5);
   }

   private void buildComponents(Rect var1) {
      float var2 = 1.5F * this.mRawMaxShadowSize;
      this.mCardBounds.set((float)var1.left + this.mRawMaxShadowSize, var2 + (float)var1.top, (float)var1.right - this.mRawMaxShadowSize, (float)var1.bottom - var2);
      this.buildShadowCorners();
   }

   private void buildShadowCorners() {
      RectF var1 = new RectF(-this.mCornerRadius, -this.mCornerRadius, this.mCornerRadius, this.mCornerRadius);
      RectF var2 = new RectF(var1);
      var2.inset(-this.mShadowSize, -this.mShadowSize);
      if(this.mCornerShadowPath == null) {
         this.mCornerShadowPath = new Path();
      } else {
         this.mCornerShadowPath.reset();
      }

      this.mCornerShadowPath.setFillType(FillType.EVEN_ODD);
      this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0F);
      this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0F);
      this.mCornerShadowPath.arcTo(var2, 180.0F, 90.0F, false);
      this.mCornerShadowPath.arcTo(var1, 270.0F, -90.0F, false);
      this.mCornerShadowPath.close();
      float var3 = this.mCornerRadius / (this.mCornerRadius + this.mShadowSize);
      Paint var4 = this.mCornerShadowPaint;
      float var5 = this.mCornerRadius + this.mShadowSize;
      int[] var6 = new int[]{this.mShadowStartColor, this.mShadowStartColor, this.mShadowEndColor};
      var4.setShader(new RadialGradient(0.0F, 0.0F, var5, var6, new float[]{0.0F, var3, 1.0F}, TileMode.CLAMP));
      Paint var8 = this.mEdgeShadowPaint;
      float var9 = -this.mCornerRadius + this.mShadowSize;
      float var10 = -this.mCornerRadius - this.mShadowSize;
      int[] var11 = new int[]{this.mShadowStartColor, this.mShadowStartColor, this.mShadowEndColor};
      var8.setShader(new LinearGradient(0.0F, var9, 0.0F, var10, var11, new float[]{0.0F, 0.5F, 1.0F}, TileMode.CLAMP));
      this.mEdgeShadowPaint.setAntiAlias(false);
   }

   static float calculateHorizontalPadding(float var0, float var1, boolean var2) {
      if(var2) {
         var0 = (float)((double)var0 + (1.0D - COS_45) * (double)var1);
      }

      return var0;
   }

   static float calculateVerticalPadding(float var0, float var1, boolean var2) {
      return var2?(float)((double)(1.5F * var0) + (1.0D - COS_45) * (double)var1):1.5F * var0;
   }

   private void drawShadow(Canvas var1) {
      float var2 = -this.mCornerRadius - this.mShadowSize;
      float var3 = this.mCornerRadius + (float)this.mInsetShadow + this.mRawShadowSize / 2.0F;
      boolean var4;
      if(this.mCardBounds.width() - 2.0F * var3 > 0.0F) {
         var4 = true;
      } else {
         var4 = false;
      }

      boolean var5;
      if(this.mCardBounds.height() - 2.0F * var3 > 0.0F) {
         var5 = true;
      } else {
         var5 = false;
      }

      int var6 = var1.save();
      var1.translate(var3 + this.mCardBounds.left, var3 + this.mCardBounds.top);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var4) {
         var1.drawRect(0.0F, var2, this.mCardBounds.width() - 2.0F * var3, -this.mCornerRadius, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var6);
      int var7 = var1.save();
      var1.translate(this.mCardBounds.right - var3, this.mCardBounds.bottom - var3);
      var1.rotate(180.0F);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var4) {
         var1.drawRect(0.0F, var2, this.mCardBounds.width() - 2.0F * var3, -this.mCornerRadius + this.mShadowSize, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var7);
      int var8 = var1.save();
      var1.translate(var3 + this.mCardBounds.left, this.mCardBounds.bottom - var3);
      var1.rotate(270.0F);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var5) {
         var1.drawRect(0.0F, var2, this.mCardBounds.height() - 2.0F * var3, -this.mCornerRadius, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var8);
      int var9 = var1.save();
      var1.translate(this.mCardBounds.right - var3, var3 + this.mCardBounds.top);
      var1.rotate(90.0F);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var5) {
         var1.drawRect(0.0F, var2, this.mCardBounds.height() - 2.0F * var3, -this.mCornerRadius, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var9);
   }

   private int toEven(float var1) {
      int var2 = (int)(0.5F + var1);
      if(var2 % 2 == 1) {
         --var2;
      }

      return var2;
   }

   public void draw(Canvas var1) {
      if(this.mDirty) {
         this.buildComponents(this.getBounds());
         this.mDirty = false;
      }

      var1.translate(0.0F, this.mRawShadowSize / 2.0F);
      this.drawShadow(var1);
      var1.translate(0.0F, -this.mRawShadowSize / 2.0F);
      sRoundRectHelper.drawRoundRect(var1, this.mCardBounds, this.mCornerRadius, this.mPaint);
   }

   float getCornerRadius() {
      return this.mCornerRadius;
   }

   void getMaxShadowAndCornerPadding(Rect var1) {
      this.getPadding(var1);
   }

   float getMaxShadowSize() {
      return this.mRawMaxShadowSize;
   }

   float getMinHeight() {
      return 2.0F * Math.max(this.mRawMaxShadowSize, this.mCornerRadius + (float)this.mInsetShadow + 1.5F * this.mRawMaxShadowSize / 2.0F) + 2.0F * (1.5F * this.mRawMaxShadowSize + (float)this.mInsetShadow);
   }

   float getMinWidth() {
      return 2.0F * Math.max(this.mRawMaxShadowSize, this.mCornerRadius + (float)this.mInsetShadow + this.mRawMaxShadowSize / 2.0F) + 2.0F * (this.mRawMaxShadowSize + (float)this.mInsetShadow);
   }

   public int getOpacity() {
      return -3;
   }

   public boolean getPadding(Rect var1) {
      int var2 = (int)Math.ceil((double)calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
      int var3 = (int)Math.ceil((double)calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
      var1.set(var3, var2, var3, var2);
      return true;
   }

   float getShadowSize() {
      return this.mRawShadowSize;
   }

   protected void onBoundsChange(Rect var1) {
      super.onBoundsChange(var1);
      this.mDirty = true;
   }

   public void setAddPaddingForCorners(boolean var1) {
      this.mAddPaddingForCorners = var1;
      this.invalidateSelf();
   }

   public void setAlpha(int var1) {
      this.mPaint.setAlpha(var1);
      this.mCornerShadowPaint.setAlpha(var1);
      this.mEdgeShadowPaint.setAlpha(var1);
   }

   public void setColor(int var1) {
      this.mPaint.setColor(var1);
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
   }

   void setCornerRadius(float var1) {
      if(var1 < 0.0F) {
         throw new IllegalArgumentException("Invalid radius " + var1 + ". Must be >= 0");
      } else {
         float var2 = (float)((int)(0.5F + var1));
         if(this.mCornerRadius != var2) {
            this.mCornerRadius = var2;
            this.mDirty = true;
            this.invalidateSelf();
         }
      }
   }

   void setMaxShadowSize(float var1) {
      this.setShadowSize(this.mRawShadowSize, var1);
   }

   void setShadowSize(float var1) {
      this.setShadowSize(var1, this.mRawMaxShadowSize);
   }

   void setShadowSize(float var1, float var2) {
      if(var1 < 0.0F) {
         throw new IllegalArgumentException("Invalid shadow size " + var1 + ". Must be >= 0");
      } else if(var2 < 0.0F) {
         throw new IllegalArgumentException("Invalid max shadow size " + var2 + ". Must be >= 0");
      } else {
         float var3 = (float)this.toEven(var1);
         float var4 = (float)this.toEven(var2);
         if(var3 > var4) {
            var3 = var4;
            if(!this.mPrintedShadowClipWarning) {
               this.mPrintedShadowClipWarning = true;
            }
         }

         if(this.mRawShadowSize != var3 || this.mRawMaxShadowSize != var4) {
            this.mRawShadowSize = var3;
            this.mRawMaxShadowSize = var4;
            this.mShadowSize = (float)((int)(0.5F + 1.5F * var3 + (float)this.mInsetShadow));
            this.mMaxShadowSize = var4 + (float)this.mInsetShadow;
            this.mDirty = true;
            this.invalidateSelf();
         }
      }
   }

   interface RoundRectHelper {
      void drawRoundRect(Canvas var1, RectF var2, float var3, Paint var4);
   }
}
