package android.support.v4.view;

import android.view.View;

class ViewPropertyAnimatorCompatJB {
   public static void withEndAction(View var0, Runnable var1) {
      var0.animate().withEndAction(var1);
   }

   public static void withLayer(View var0) {
      var0.animate().withLayer();
   }

   public static void withStartAction(View var0, Runnable var1) {
      var0.animate().withStartAction(var1);
   }
}
