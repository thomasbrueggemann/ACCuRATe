package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class AccessibilityServiceInfoCompatIcs {
   public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo var0) {
      return var0.getCanRetrieveWindowContent();
   }

   public static String getDescription(AccessibilityServiceInfo var0) {
      return var0.getDescription();
   }

   public static String getId(AccessibilityServiceInfo var0) {
      return var0.getId();
   }

   public static ResolveInfo getResolveInfo(AccessibilityServiceInfo var0) {
      return var0.getResolveInfo();
   }

   public static String getSettingsActivityName(AccessibilityServiceInfo var0) {
      return var0.getSettingsActivityName();
   }
}
