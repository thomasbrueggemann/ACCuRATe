package android.support.v4.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
   private final float mStepSize;
   private final float[] mValues;

   public LookupTableInterpolator(float[] var1) {
      this.mValues = var1;
      this.mStepSize = 1.0F / (float)(-1 + this.mValues.length);
   }

   public float getInterpolation(float var1) {
      if(var1 >= 1.0F) {
         return 1.0F;
      } else if(var1 <= 0.0F) {
         return 0.0F;
      } else {
         int var2 = Math.min((int)(var1 * (float)(-1 + this.mValues.length)), -2 + this.mValues.length);
         float var3 = (var1 - (float)var2 * this.mStepSize) / this.mStepSize;
         return this.mValues[var2] + var3 * (this.mValues[var2 + 1] - this.mValues[var2]);
      }
   }
}
