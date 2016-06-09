package android.support.v4.view;

import android.view.ScaleGestureDetector;

class ScaleGestureDetectorCompatKitKat {
   public static boolean isQuickScaleEnabled(Object var0) {
      return ((ScaleGestureDetector)var0).isQuickScaleEnabled();
   }

   public static void setQuickScaleEnabled(Object var0, boolean var1) {
      ((ScaleGestureDetector)var0).setQuickScaleEnabled(var1);
   }
}
