package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatKitKat {
   public static int getLiveRegion(Object var0) {
      return ((AccessibilityNodeInfo)var0).getLiveRegion();
   }

   public static void setLiveRegion(Object var0, int var1) {
      ((AccessibilityNodeInfo)var0).setLiveRegion(var1);
   }
}
