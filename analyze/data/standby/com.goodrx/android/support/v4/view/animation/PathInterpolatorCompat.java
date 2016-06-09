package android.support.v4.view.animation;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.support.v4.view.animation.PathInterpolatorCompatApi21;
import android.support.v4.view.animation.PathInterpolatorCompatBase;
import android.view.animation.Interpolator;

public final class PathInterpolatorCompat {
   public static Interpolator create(float var0, float var1) {
      return VERSION.SDK_INT >= 21?PathInterpolatorCompatApi21.create(var0, var1):PathInterpolatorCompatBase.create(var0, var1);
   }

   public static Interpolator create(float var0, float var1, float var2, float var3) {
      return VERSION.SDK_INT >= 21?PathInterpolatorCompatApi21.create(var0, var1, var2, var3):PathInterpolatorCompatBase.create(var0, var1, var2, var3);
   }

   public static Interpolator create(Path var0) {
      return VERSION.SDK_INT >= 21?PathInterpolatorCompatApi21.create(var0):PathInterpolatorCompatBase.create(var0);
   }
}
