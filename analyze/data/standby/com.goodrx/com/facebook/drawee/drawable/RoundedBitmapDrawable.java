package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import javax.annotation.Nullable;

public class RoundedBitmapDrawable extends BitmapDrawable implements Rounded, TransformAwareDrawable {
   @VisibleForTesting
   final RectF mBitmapBounds;
   private int mBorderColor;
   private final Paint mBorderPaint;
   private final Path mBorderPath;
   @VisibleForTesting
   final float[] mBorderRadii;
   private float mBorderWidth;
   @VisibleForTesting
   final Matrix mBoundsTransform;
   private final float[] mCornerRadii;
   @VisibleForTesting
   final RectF mDrawableBounds;
   @VisibleForTesting
   final Matrix mInverseParentTransform;
   private boolean mIsCircle;
   private boolean mIsPathDirty;
   private boolean mIsShaderTransformDirty;
   private WeakReference<Bitmap> mLastBitmap;
   private float mPadding;
   private final Paint mPaint;
   @VisibleForTesting
   final Matrix mParentTransform;
   private final Path mPath;
   @VisibleForTesting
   final Matrix mPrevBoundsTransform;
   @VisibleForTesting
   final Matrix mPrevParentTransform;
   @VisibleForTesting
   final RectF mPrevRootBounds;
   private boolean mRadiiNonZero;
   @VisibleForTesting
   final RectF mRootBounds;
   @VisibleForTesting
   final Matrix mTransform;
   @Nullable
   private TransformCallback mTransformCallback;

   public RoundedBitmapDrawable(Resources var1, Bitmap var2) {
      this(var1, var2, (Paint)null);
   }

   public RoundedBitmapDrawable(Resources var1, Bitmap var2, @Nullable Paint var3) {
      super(var1, var2);
      this.mIsCircle = false;
      this.mRadiiNonZero = false;
      this.mCornerRadii = new float[8];
      this.mBorderRadii = new float[8];
      this.mRootBounds = new RectF();
      this.mPrevRootBounds = new RectF();
      this.mBitmapBounds = new RectF();
      this.mDrawableBounds = new RectF();
      this.mBoundsTransform = new Matrix();
      this.mPrevBoundsTransform = new Matrix();
      this.mParentTransform = new Matrix();
      this.mPrevParentTransform = new Matrix();
      this.mInverseParentTransform = new Matrix();
      this.mTransform = new Matrix();
      this.mBorderWidth = 0.0F;
      this.mBorderColor = 0;
      this.mPadding = 0.0F;
      this.mPath = new Path();
      this.mBorderPath = new Path();
      this.mIsPathDirty = true;
      this.mPaint = new Paint();
      this.mBorderPaint = new Paint(1);
      this.mIsShaderTransformDirty = true;
      if(var3 != null) {
         this.mPaint.set(var3);
      }

      this.mPaint.setFlags(1);
      this.mBorderPaint.setStyle(Style.STROKE);
   }

   public static RoundedBitmapDrawable fromBitmapDrawable(Resources var0, BitmapDrawable var1) {
      return new RoundedBitmapDrawable(var0, var1.getBitmap(), var1.getPaint());
   }

   private void updatePaint() {
      Bitmap var1 = this.getBitmap();
      if(this.mLastBitmap == null || this.mLastBitmap.get() != var1) {
         this.mLastBitmap = new WeakReference(var1);
         this.mPaint.setShader(new BitmapShader(var1, TileMode.CLAMP, TileMode.CLAMP));
         this.mIsShaderTransformDirty = true;
      }

      if(this.mIsShaderTransformDirty) {
         this.mPaint.getShader().setLocalMatrix(this.mTransform);
         this.mIsShaderTransformDirty = false;
      }

   }

   private void updatePath() {
      if(this.mIsPathDirty) {
         this.mBorderPath.reset();
         this.mRootBounds.inset(this.mBorderWidth / 2.0F, this.mBorderWidth / 2.0F);
         if(this.mIsCircle) {
            float var2 = Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0F;
            this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), var2, Direction.CW);
         } else {
            for(int var1 = 0; var1 < this.mBorderRadii.length; ++var1) {
               this.mBorderRadii[var1] = this.mCornerRadii[var1] + this.mPadding - this.mBorderWidth / 2.0F;
            }

            this.mBorderPath.addRoundRect(this.mRootBounds, this.mBorderRadii, Direction.CW);
         }

         this.mRootBounds.inset(-this.mBorderWidth / 2.0F, -this.mBorderWidth / 2.0F);
         this.mPath.reset();
         this.mRootBounds.inset(this.mPadding, this.mPadding);
         if(this.mIsCircle) {
            this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0F, Direction.CW);
         } else {
            this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Direction.CW);
         }

         this.mRootBounds.inset(-this.mPadding, -this.mPadding);
         this.mPath.setFillType(FillType.WINDING);
         this.mIsPathDirty = false;
      }

   }

   private void updateTransform() {
      if(this.mTransformCallback != null) {
         this.mTransformCallback.getTransform(this.mParentTransform);
         this.mTransformCallback.getRootBounds(this.mRootBounds);
      } else {
         this.mParentTransform.reset();
         this.mRootBounds.set(this.getBounds());
      }

      this.mBitmapBounds.set(0.0F, 0.0F, (float)this.getBitmap().getWidth(), (float)this.getBitmap().getHeight());
      this.mDrawableBounds.set(this.getBounds());
      this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, ScaleToFit.FILL);
      if(!this.mParentTransform.equals(this.mPrevParentTransform) || !this.mBoundsTransform.equals(this.mPrevBoundsTransform)) {
         this.mIsShaderTransformDirty = true;
         this.mParentTransform.invert(this.mInverseParentTransform);
         this.mTransform.set(this.mParentTransform);
         this.mTransform.preConcat(this.mBoundsTransform);
         this.mPrevParentTransform.set(this.mParentTransform);
         this.mPrevBoundsTransform.set(this.mBoundsTransform);
      }

      if(!this.mRootBounds.equals(this.mPrevRootBounds)) {
         this.mIsPathDirty = true;
         this.mPrevRootBounds.set(this.mRootBounds);
      }

   }

   public void draw(Canvas var1) {
      if(!this.shouldRound()) {
         super.draw(var1);
      } else {
         this.updateTransform();
         this.updatePath();
         this.updatePaint();
         int var2 = var1.save();
         var1.concat(this.mInverseParentTransform);
         var1.drawPath(this.mPath, this.mPaint);
         if(this.mBorderWidth > 0.0F) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
            var1.drawPath(this.mBorderPath, this.mBorderPaint);
         }

         var1.restoreToCount(var2);
      }
   }

   public int getBorderColor() {
      return this.mBorderColor;
   }

   public float getBorderWidth() {
      return this.mBorderWidth;
   }

   public float getPadding() {
      return this.mPadding;
   }

   public float[] getRadii() {
      return this.mCornerRadii;
   }

   public boolean isCircle() {
      return this.mIsCircle;
   }

   public void setAlpha(int var1) {
      if(var1 != this.mPaint.getAlpha()) {
         this.mPaint.setAlpha(var1);
         this.invalidateSelf();
      }

   }

   public void setBorder(int var1, float var2) {
      if(this.mBorderColor != var1 || this.mBorderWidth != var2) {
         this.mBorderColor = var1;
         this.mBorderWidth = var2;
         this.mIsPathDirty = true;
         this.invalidateSelf();
      }

   }

   public void setCircle(boolean var1) {
      this.mIsCircle = var1;
      this.mIsPathDirty = true;
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
      super.setColorFilter(var1);
   }

   public void setPadding(float var1) {
      if(this.mPadding != var1) {
         this.mPadding = var1;
         this.mIsPathDirty = true;
         this.invalidateSelf();
      }

   }

   public void setRadii(float[] var1) {
      if(var1 == null) {
         Arrays.fill(this.mCornerRadii, 0.0F);
         this.mRadiiNonZero = false;
      } else {
         boolean var2;
         if(var1.length == 8) {
            var2 = true;
         } else {
            var2 = false;
         }

         Preconditions.checkArgument(var2, "radii should have exactly 8 values");
         System.arraycopy(var1, 0, this.mCornerRadii, 0, 8);
         this.mRadiiNonZero = false;

         for(int var3 = 0; var3 < 8; ++var3) {
            boolean var4 = this.mRadiiNonZero;
            boolean var5;
            if(var1[var3] > 0.0F) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.mRadiiNonZero = var5 | var4;
         }
      }

      this.mIsPathDirty = true;
      this.invalidateSelf();
   }

   public void setRadius(float var1) {
      boolean var2;
      if(var1 >= 0.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkState(var2);
      Arrays.fill(this.mCornerRadii, var1);
      float var5;
      int var3 = (var5 = var1 - 0.0F) == 0.0F?0:(var5 < 0.0F?-1:1);
      boolean var4 = false;
      if(var3 != 0) {
         var4 = true;
      }

      this.mRadiiNonZero = var4;
      this.mIsPathDirty = true;
      this.invalidateSelf();
   }

   public void setTransformCallback(@Nullable TransformCallback var1) {
      this.mTransformCallback = var1;
   }

   @VisibleForTesting
   boolean shouldRound() {
      return this.mIsCircle || this.mRadiiNonZero || this.mBorderWidth > 0.0F;
   }
}
