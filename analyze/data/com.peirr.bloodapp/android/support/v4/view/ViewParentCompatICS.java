package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public class ViewParentCompatICS {
   public static boolean requestSendAccessibilityEvent(ViewParent var0, View var1, AccessibilityEvent var2) {
      return var0.requestSendAccessibilityEvent(var1, var2);
   }
}
