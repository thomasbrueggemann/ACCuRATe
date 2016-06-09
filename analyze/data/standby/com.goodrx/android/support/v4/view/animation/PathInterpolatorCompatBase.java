package android.support.v4.view.animation;

import android.graphics.Path;
import android.support.v4.view.animation.PathInterpolatorDonut;
import android.view.animation.Interpolator;

class PathInterpolatorCompatBase {
   public static Interpolator create(float var0, float var1) {
      return new PathInterpolatorDonut(var0, var1);
   }

   public static Interpolator create(float var0, float var1, float var2, float var3) {
      return new PathInterpolatorDonut(var0, var1, var2, var3);
   }

   public static Interpolator create(Path var0) {
      return new PathInterpolatorDonut(var0);
   }
}
