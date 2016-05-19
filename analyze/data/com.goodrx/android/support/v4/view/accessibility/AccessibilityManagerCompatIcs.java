package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import java.util.List;

class AccessibilityManagerCompatIcs {
   public static boolean addAccessibilityStateChangeListener(AccessibilityManager var0, Object var1) {
      return var0.addAccessibilityStateChangeListener((AccessibilityStateChangeListener)var1);
   }

   public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager var0, int var1) {
      return var0.getEnabledAccessibilityServiceList(var1);
   }

   public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager var0) {
      return var0.getInstalledAccessibilityServiceList();
   }

   public static boolean isTouchExplorationEnabled(AccessibilityManager var0) {
      return var0.isTouchExplorationEnabled();
   }

   public static Object newAccessibilityStateChangeListener(final AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge var0) {
      return new AccessibilityStateChangeListener() {
         public void onAccessibilityStateChanged(boolean var1) {
            var0.onAccessibilityStateChanged(var1);
         }
      };
   }

   public static boolean removeAccessibilityStateChangeListener(AccessibilityManager var0, Object var1) {
      return var0.removeAccessibilityStateChangeListener((AccessibilityStateChangeListener)var1);
   }

   interface AccessibilityStateChangeListenerBridge {
      void onAccessibilityStateChanged(boolean var1);
   }
}
