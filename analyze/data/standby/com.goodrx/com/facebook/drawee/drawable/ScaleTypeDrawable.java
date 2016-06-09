package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.ScalingUtils;

public class ScaleTypeDrawable extends ForwardingDrawable {
   @VisibleForTesting
   Matrix mDrawMatrix;
   @VisibleForTesting
   PointF mFocusPoint = null;
   @VisibleForTesting
   ScalingUtils.ScaleType mScaleType;
   private Matrix mTempMatrix = new Matrix();
   @VisibleForTesting
   int mUnderlyingHeight = 0;
   @VisibleForTesting
   int mUnderlyingWidth = 0;

   public ScaleTypeDrawable(Drawable var1, ScalingUtils.ScaleType var2) {
      super((Drawable)Preconditions.checkNotNull(var1));
      this.mScaleType = var2;
   }

   private void configureBoundsIfUnderlyingChanged() {
      if(this.mUnderlyingWidth != this.getCurrent().getIntrinsicWidth() || this.mUnderlyingHeight != this.getCurrent().getIntrinsicHeight()) {
         this.configureBounds();
      }

   }

   @VisibleForTesting
   void configureBounds() {
      float var1 = 0.5F;
      Drawable var2 = this.getCurrent();
      Rect var3 = this.getBounds();
      int var4 = var3.width();
      int var5 = var3.height();
      int var6 = var2.getIntrinsicWidth();
      this.mUnderlyingWidth = var6;
      int var7 = var2.getIntrinsicHeight();
      this.mUnderlyingHeight = var7;
      if(var6 > 0 && var7 > 0) {
         if(var6 == var4 && var7 == var5) {
            var2.setBounds(var3);
            this.mDrawMatrix = null;
         } else if(this.mScaleType == ScalingUtils.ScaleType.FIT_XY) {
            var2.setBounds(var3);
            this.mDrawMatrix = null;
         } else {
            var2.setBounds(0, 0, var6, var7);
            Matrix var8 = this.mTempMatrix;
            float var9;
            if(this.mFocusPoint != null) {
               var9 = this.mFocusPoint.x;
            } else {
               var9 = var1;
            }

            if(this.mFocusPoint != null) {
               var1 = this.mFocusPoint.y;
            }

            ScalingUtils.getTransform(var8, var3, var6, var7, var9, var1, this.mScaleType);
            this.mDrawMatrix = this.mTempMatrix;
         }
      } else {
         var2.setBounds(var3);
         this.mDrawMatrix = null;
      }
   }

   public void draw(Canvas var1) {
      this.configureBoundsIfUnderlyingChanged();
      if(this.mDrawMatrix != null) {
         int var2 = var1.save();
         var1.clipRect(this.getBounds());
         var1.concat(this.mDrawMatrix);
         super.draw(var1);
         var1.restoreToCount(var2);
      } else {
         super.draw(var1);
      }
   }

   public PointF getFocusPoint() {
      return this.mFocusPoint;
   }

   public ScalingUtils.ScaleType getScaleType() {
      return this.mScaleType;
   }

   public void getTransform(Matrix var1) {
      this.getParentTransform(var1);
      this.configureBoundsIfUnderlyingChanged();
      if(this.mDrawMatrix != null) {
         var1.preConcat(this.mDrawMatrix);
      }

   }

   protected void onBoundsChange(Rect var1) {
      this.configureBounds();
   }

   public void setFocusPoint(PointF var1) {
      if(this.mFocusPoint == null) {
         this.mFocusPoint = new PointF();
      }

      this.mFocusPoint.set(var1);
      this.configureBounds();
      this.invalidateSelf();
   }

   public void setScaleType(ScalingUtils.ScaleType var1) {
      this.mScaleType = var1;
      this.configureBounds();
      this.invalidateSelf();
   }
}
