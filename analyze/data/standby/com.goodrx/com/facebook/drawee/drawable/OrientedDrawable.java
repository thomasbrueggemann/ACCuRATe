package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ForwardingDrawable;

public class OrientedDrawable extends ForwardingDrawable {
   private int mRotationAngle;
   @VisibleForTesting
   final Matrix mRotationMatrix;
   private final Matrix mTempMatrix = new Matrix();
   private final RectF mTempRectF = new RectF();

   public OrientedDrawable(Drawable var1, int var2) {
      super(var1);
      boolean var3;
      if(var2 % 90 == 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      this.mRotationMatrix = new Matrix();
      this.mRotationAngle = var2;
   }

   public void draw(Canvas var1) {
      if(this.mRotationAngle <= 0) {
         super.draw(var1);
      } else {
         int var2 = var1.save();
         var1.concat(this.mRotationMatrix);
         super.draw(var1);
         var1.restoreToCount(var2);
      }
   }

   public int getIntrinsicHeight() {
      return this.mRotationAngle % 180 == 0?super.getIntrinsicHeight():super.getIntrinsicWidth();
   }

   public int getIntrinsicWidth() {
      return this.mRotationAngle % 180 == 0?super.getIntrinsicWidth():super.getIntrinsicHeight();
   }

   public void getTransform(Matrix var1) {
      this.getParentTransform(var1);
      if(!this.mRotationMatrix.isIdentity()) {
         var1.preConcat(this.mRotationMatrix);
      }

   }

   protected void onBoundsChange(Rect var1) {
      Drawable var2 = this.getCurrent();
      if(this.mRotationAngle > 0) {
         this.mRotationMatrix.setRotate((float)this.mRotationAngle, (float)var1.centerX(), (float)var1.centerY());
         this.mTempMatrix.reset();
         this.mRotationMatrix.invert(this.mTempMatrix);
         this.mTempRectF.set(var1);
         this.mTempMatrix.mapRect(this.mTempRectF);
         var2.setBounds((int)this.mTempRectF.left, (int)this.mTempRectF.top, (int)this.mTempRectF.right, (int)this.mTempRectF.bottom);
      } else {
         var2.setBounds(var1);
      }
   }
}
