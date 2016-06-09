package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
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
import android.support.design.class_5;
import android.support.v7.graphics.drawable.DrawableWrapper;

class ShadowDrawableWrapper extends DrawableWrapper {
   static final double COS_45 = Math.cos(Math.toRadians(45.0D));
   static final float SHADOW_BOTTOM_SCALE = 1.0F;
   static final float SHADOW_HORIZ_SCALE = 0.5F;
   static final float SHADOW_MULTIPLIER = 1.5F;
   static final float SHADOW_TOP_SCALE = 0.25F;
   private boolean mAddPaddingForCorners = true;
   final RectF mContentBounds;
   float mCornerRadius;
   final Paint mCornerShadowPaint;
   Path mCornerShadowPath;
   private boolean mDirty = true;
   final Paint mEdgeShadowPaint;
   float mMaxShadowSize;
   private boolean mPrintedShadowClipWarning = false;
   float mRawMaxShadowSize;
   float mRawShadowSize;
   private float mRotation;
   private final int mShadowEndColor;
   private final int mShadowMiddleColor;
   float mShadowSize;
   private final int mShadowStartColor;

   public ShadowDrawableWrapper(Resources var1, Drawable var2, float var3, float var4, float var5) {
      super(var2);
      this.mShadowStartColor = var1.getColor(class_5.color.design_fab_shadow_start_color);
      this.mShadowMiddleColor = var1.getColor(class_5.color.design_fab_shadow_mid_color);
      this.mShadowEndColor = var1.getColor(class_5.color.design_fab_shadow_end_color);
      this.mCornerShadowPaint = new Paint(5);
      this.mCornerShadowPaint.setStyle(Style.FILL);
      this.mCornerRadius = (float)Math.round(var3);
      this.mContentBounds = new RectF();
      this.mEdgeShadowPaint = new Paint(this.mCornerShadowPaint);
      this.mEdgeShadowPaint.setAntiAlias(false);
      this.setShadowSize(var4, var5);
   }

   private void buildComponents(Rect var1) {
      float var2 = 1.5F * this.mRawMaxShadowSize;
      this.mContentBounds.set((float)var1.left + this.mRawMaxShadowSize, var2 + (float)var1.top, (float)var1.right - this.mRawMaxShadowSize, (float)var1.bottom - var2);
      this.getWrappedDrawable().setBounds((int)this.mContentBounds.left, (int)this.mContentBounds.top, (int)this.mContentBounds.right, (int)this.mContentBounds.bottom);
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
      float var3 = -var2.top;
      if(var3 > 0.0F) {
         float var9 = this.mCornerRadius / var3;
         float var10 = var9 + (1.0F - var9) / 2.0F;
         Paint var11 = this.mCornerShadowPaint;
         int[] var12 = new int[]{0, this.mShadowStartColor, this.mShadowMiddleColor, this.mShadowEndColor};
         var11.setShader(new RadialGradient(0.0F, 0.0F, var3, var12, new float[]{0.0F, var9, var10, 1.0F}, TileMode.CLAMP));
      }

      Paint var4 = this.mEdgeShadowPaint;
      float var5 = var1.top;
      float var6 = var2.top;
      int[] var7 = new int[]{this.mShadowStartColor, this.mShadowMiddleColor, this.mShadowEndColor};
      var4.setShader(new LinearGradient(0.0F, var5, 0.0F, var6, var7, new float[]{0.0F, 0.5F, 1.0F}, TileMode.CLAMP));
      this.mEdgeShadowPaint.setAntiAlias(false);
   }

   public static float calculateHorizontalPadding(float var0, float var1, boolean var2) {
      if(var2) {
         var0 = (float)((double)var0 + (1.0D - COS_45) * (double)var1);
      }

      return var0;
   }

   public static float calculateVerticalPadding(float var0, float var1, boolean var2) {
      return var2?(float)((double)(1.5F * var0) + (1.0D - COS_45) * (double)var1):1.5F * var0;
   }

   private void drawShadow(Canvas var1) {
      int var2 = var1.save();
      var1.rotate(this.mRotation, this.mContentBounds.centerX(), this.mContentBounds.centerY());
      float var3 = -this.mCornerRadius - this.mShadowSize;
      float var4 = this.mCornerRadius;
      boolean var5;
      if(this.mContentBounds.width() - 2.0F * var4 > 0.0F) {
         var5 = true;
      } else {
         var5 = false;
      }

      boolean var6;
      if(this.mContentBounds.height() - 2.0F * var4 > 0.0F) {
         var6 = true;
      } else {
         var6 = false;
      }

      float var7 = this.mRawShadowSize - 0.25F * this.mRawShadowSize;
      float var8 = this.mRawShadowSize - 0.5F * this.mRawShadowSize;
      float var9 = this.mRawShadowSize - 1.0F * this.mRawShadowSize;
      float var10 = var4 / (var4 + var8);
      float var11 = var4 / (var4 + var7);
      float var12 = var4 / (var4 + var9);
      int var13 = var1.save();
      var1.translate(var4 + this.mContentBounds.left, var4 + this.mContentBounds.top);
      var1.scale(var10, var11);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var5) {
         var1.scale(1.0F / var10, 1.0F);
         var1.drawRect(0.0F, var3, this.mContentBounds.width() - 2.0F * var4, -this.mCornerRadius, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var13);
      int var14 = var1.save();
      var1.translate(this.mContentBounds.right - var4, this.mContentBounds.bottom - var4);
      var1.scale(var10, var12);
      var1.rotate(180.0F);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var5) {
         var1.scale(1.0F / var10, 1.0F);
         var1.drawRect(0.0F, var3, this.mContentBounds.width() - 2.0F * var4, -this.mCornerRadius + this.mShadowSize, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var14);
      int var15 = var1.save();
      var1.translate(var4 + this.mContentBounds.left, this.mContentBounds.bottom - var4);
      var1.scale(var10, var12);
      var1.rotate(270.0F);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var6) {
         var1.scale(1.0F / var12, 1.0F);
         var1.drawRect(0.0F, var3, this.mContentBounds.height() - 2.0F * var4, -this.mCornerRadius, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var15);
      int var16 = var1.save();
      var1.translate(this.mContentBounds.right - var4, var4 + this.mContentBounds.top);
      var1.scale(var10, var11);
      var1.rotate(90.0F);
      var1.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
      if(var6) {
         var1.scale(1.0F / var11, 1.0F);
         var1.drawRect(0.0F, var3, this.mContentBounds.height() - 2.0F * var4, -this.mCornerRadius, this.mEdgeShadowPaint);
      }

      var1.restoreToCount(var16);
      var1.restoreToCount(var2);
   }

   private static int toEven(float var0) {
      int var1 = Math.round(var0);
      if(var1 % 2 == 1) {
         --var1;
      }

      return var1;
   }

   public void draw(Canvas var1) {
      if(this.mDirty) {
         this.buildComponents(this.getBounds());
         this.mDirty = false;
      }

      this.drawShadow(var1);
      super.draw(var1);
   }

   public float getCornerRadius() {
      return this.mCornerRadius;
   }

   public float getMaxShadowSize() {
      return this.mRawMaxShadowSize;
   }

   public float getMinHeight() {
      return 2.0F * Math.max(this.mRawMaxShadowSize, this.mCornerRadius + 1.5F * this.mRawMaxShadowSize / 2.0F) + 2.0F * 1.5F * this.mRawMaxShadowSize;
   }

   public float getMinWidth() {
      return 2.0F * Math.max(this.mRawMaxShadowSize, this.mCornerRadius + this.mRawMaxShadowSize / 2.0F) + 2.0F * this.mRawMaxShadowSize;
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

   public float getShadowSize() {
      return this.mRawShadowSize;
   }

   protected void onBoundsChange(Rect var1) {
      this.mDirty = true;
   }

   public void setAddPaddingForCorners(boolean var1) {
      this.mAddPaddingForCorners = var1;
      this.invalidateSelf();
   }

   public void setAlpha(int var1) {
      super.setAlpha(var1);
      this.mCornerShadowPaint.setAlpha(var1);
      this.mEdgeShadowPaint.setAlpha(var1);
   }

   public void setCornerRadius(float var1) {
      float var2 = (float)Math.round(var1);
      if(this.mCornerRadius != var2) {
         this.mCornerRadius = var2;
         this.mDirty = true;
         this.invalidateSelf();
      }
   }

   public void setMaxShadowSize(float var1) {
      this.setShadowSize(this.mRawShadowSize, var1);
   }

   final void setRotation(float var1) {
      if(this.mRotation != var1) {
         this.mRotation = var1;
         this.invalidateSelf();
      }

   }

   public void setShadowSize(float var1) {
      this.setShadowSize(var1, this.mRawMaxShadowSize);
   }

   void setShadowSize(float var1, float var2) {
      if(var1 >= 0.0F && var2 >= 0.0F) {
         float var3 = (float)toEven(var1);
         float var4 = (float)toEven(var2);
         if(var3 > var4) {
            var3 = var4;
            if(!this.mPrintedShadowClipWarning) {
               this.mPrintedShadowClipWarning = true;
            }
         }

         if(this.mRawShadowSize != var3 || this.mRawMaxShadowSize != var4) {
            this.mRawShadowSize = var3;
            this.mRawMaxShadowSize = var4;
            this.mShadowSize = (float)Math.round(1.5F * var3);
            this.mMaxShadowSize = var4;
            this.mDirty = true;
            this.invalidateSelf();
         }
      } else {
         throw new IllegalArgumentException("invalid shadow size");
      }
   }
}
