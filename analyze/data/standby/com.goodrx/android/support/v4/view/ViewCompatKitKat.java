package android.support.v4.view;

import android.view.View;

class ViewCompatKitKat {
   public static int getAccessibilityLiveRegion(View var0) {
      return var0.getAccessibilityLiveRegion();
   }

   public static boolean isAttachedToWindow(View var0) {
      return var0.isAttachedToWindow();
   }

   public static boolean isLaidOut(View var0) {
      return var0.isLaidOut();
   }

   public static void setAccessibilityLiveRegion(View var0, int var1) {
      var0.setAccessibilityLiveRegion(var1);
   }
}
