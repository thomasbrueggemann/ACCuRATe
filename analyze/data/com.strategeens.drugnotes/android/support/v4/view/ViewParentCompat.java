package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewParentCompatICS;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public class ViewParentCompat {
   static final ViewParentCompat.ViewParentCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new ViewParentCompat.ViewParentCompatICSImpl();
      } else {
         IMPL = new ViewParentCompat.ViewParentCompatStubImpl();
      }
   }

   public static boolean requestSendAccessibilityEvent(ViewParent var0, View var1, AccessibilityEvent var2) {
      return IMPL.requestSendAccessibilityEvent(var0, var1, var2);
   }

   static class ViewParentCompatICSImpl extends ViewParentCompat.ViewParentCompatStubImpl {
      public boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3) {
         return ViewParentCompatICS.requestSendAccessibilityEvent(var1, var2, var3);
      }
   }

   interface ViewParentCompatImpl {
      boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3);
   }

   static class ViewParentCompatStubImpl implements ViewParentCompat.ViewParentCompatImpl {
      public boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3) {
         if(var2 == null) {
            return false;
         } else {
            ((AccessibilityManager)var2.getContext().getSystemService("accessibility")).sendAccessibilityEvent(var3);
            return true;
         }
      }
   }
}
