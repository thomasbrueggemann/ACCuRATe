package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompatKitKat {
   public static int getContentChangeTypes(AccessibilityEvent var0) {
      return var0.getContentChangeTypes();
   }

   public static void setContentChangeTypes(AccessibilityEvent var0, int var1) {
      var0.setContentChangeTypes(var1);
   }
}
