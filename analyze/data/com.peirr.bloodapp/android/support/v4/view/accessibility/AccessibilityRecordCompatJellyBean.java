package android.support.v4.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

class AccessibilityRecordCompatJellyBean {
   public static void setSource(Object var0, View var1, int var2) {
      ((AccessibilityRecord)var0).setSource(var1, var2);
   }
}
