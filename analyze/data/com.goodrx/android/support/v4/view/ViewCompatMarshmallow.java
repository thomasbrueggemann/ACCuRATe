package android.support.v4.view;

import android.view.View;

class ViewCompatMarshmallow {
   public static int getScrollIndicators(View var0) {
      return var0.getScrollIndicators();
   }

   static void offsetLeftAndRight(View var0, int var1) {
      var0.offsetLeftAndRight(var1);
   }

   static void offsetTopAndBottom(View var0, int var1) {
      var0.offsetTopAndBottom(var1);
   }

   public static void setScrollIndicators(View var0, int var1) {
      var0.setScrollIndicators(var1);
   }

   public static void setScrollIndicators(View var0, int var1, int var2) {
      var0.setScrollIndicators(var1, var2);
   }
}
