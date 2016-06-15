package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompatHC {
   public static float getAlpha(View var0) {
      return var0.getAlpha();
   }

   static long getFrameTime() {
      return ValueAnimator.getFrameDelay();
   }

   public static int getLayerType(View var0) {
      return var0.getLayerType();
   }

   public static void setLayerType(View var0, int var1, Paint var2) {
      var0.setLayerType(var1, var2);
   }
}
