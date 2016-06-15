package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityNodeInfoCompatJellybeanMr2 {
   public static String getViewIdResourceName(Object var0) {
      return ((AccessibilityNodeInfo)var0).getViewIdResourceName();
   }

   public static void setViewIdResourceName(Object var0, String var1) {
      ((AccessibilityNodeInfo)var0).setViewIdResourceName(var1);
   }
}
