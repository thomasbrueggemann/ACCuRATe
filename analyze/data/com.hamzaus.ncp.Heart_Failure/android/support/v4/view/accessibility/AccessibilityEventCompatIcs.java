package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityEventCompatIcs {
   public static void appendRecord(AccessibilityEvent var0, Object var1) {
      var0.appendRecord((AccessibilityRecord)var1);
   }

   public static Object getRecord(AccessibilityEvent var0, int var1) {
      return var0.getRecord(var1);
   }

   public static int getRecordCount(AccessibilityEvent var0) {
      return var0.getRecordCount();
   }
}
