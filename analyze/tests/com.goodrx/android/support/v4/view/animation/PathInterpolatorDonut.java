package android.support.v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

class PathInterpolatorDonut implements Interpolator {
   private static final float PRECISION = 0.002F;
   // $FF: renamed from: mX float[]
   private final float[] field_468;
   // $FF: renamed from: mY float[]
   private final float[] field_469;

   public PathInterpolatorDonut(float var1, float var2) {
      this(createQuad(var1, var2));
   }

   public PathInterpolatorDonut(float var1, float var2, float var3, float var4) {
      this(createCubic(var1, var2, var3, var4));
   }

   public PathInterpolatorDonut(Path var1) {
      PathMeasure var2 = new PathMeasure(var1, false);
      float var3 = var2.getLength();
      int var4 = 1 + (int)(var3 / 0.002F);
      this.field_468 = new float[var4];
      this.field_469 = new float[var4];
      float[] var5 = new float[2];

      for(int var6 = 0; var6 < var4; ++var6) {
         var2.getPosTan(var3 * (float)var6 / (float)(var4 - 1), var5, (float[])null);
         this.field_468[var6] = var5[0];
         this.field_469[var6] = var5[1];
      }

   }

   private static Path createCubic(float var0, float var1, float var2, float var3) {
      Path var4 = new Path();
      var4.moveTo(0.0F, 0.0F);
      var4.cubicTo(var0, var1, var2, var3, 1.0F, 1.0F);
      return var4;
   }

   private static Path createQuad(float var0, float var1) {
      Path var2 = new Path();
      var2.moveTo(0.0F, 0.0F);
      var2.quadTo(var0, var1, 1.0F, 1.0F);
      return var2;
   }

   public float getInterpolation(float var1) {
      if(var1 <= 0.0F) {
         return 0.0F;
      } else if(var1 >= 1.0F) {
         return 1.0F;
      } else {
         int var2 = 0;
         int var3 = -1 + this.field_468.length;

         while(var3 - var2 > 1) {
            int var7 = (var2 + var3) / 2;
            if(var1 < this.field_468[var7]) {
               var3 = var7;
            } else {
               var2 = var7;
            }
         }

         float var4 = this.field_468[var3] - this.field_468[var2];
         if(var4 == 0.0F) {
            return this.field_469[var2];
         } else {
            float var5 = (var1 - this.field_468[var2]) / var4;
            float var6 = this.field_469[var2];
            return var6 + var5 * (this.field_469[var3] - var6);
         }
      }
   }
}
