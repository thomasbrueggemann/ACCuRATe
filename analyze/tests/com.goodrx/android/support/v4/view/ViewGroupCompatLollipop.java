package android.support.v4.view;

import android.view.ViewGroup;

class ViewGroupCompatLollipop {
   public static int getNestedScrollAxes(ViewGroup var0) {
      return var0.getNestedScrollAxes();
   }

   public static boolean isTransitionGroup(ViewGroup var0) {
      return var0.isTransitionGroup();
   }

   public static void setTransitionGroup(ViewGroup var0, boolean var1) {
      var0.setTransitionGroup(var1);
   }
}
