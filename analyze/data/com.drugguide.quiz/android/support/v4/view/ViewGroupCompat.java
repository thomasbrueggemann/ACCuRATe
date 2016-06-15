package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewGroupCompatHC;
import android.support.v4.view.ViewGroupCompatIcs;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ViewGroupCompat {
   static final ViewGroupCompat.ViewGroupCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 14) {
         IMPL = new ViewGroupCompat.ViewGroupCompatIcsImpl();
      } else if(var0 >= 11) {
         IMPL = new ViewGroupCompat.ViewGroupCompatHCImpl();
      } else {
         IMPL = new ViewGroupCompat.ViewGroupCompatStubImpl();
      }
   }

   public static boolean onRequestSendAccessibilityEvent(ViewGroup var0, View var1, AccessibilityEvent var2) {
      return IMPL.onRequestSendAccessibilityEvent(var0, var1, var2);
   }

   public static void setMotionEventSplittingEnabled(ViewGroup var0, boolean var1) {
      IMPL.setMotionEventSplittingEnabled(var0, var1);
   }

   static class ViewGroupCompatHCImpl extends ViewGroupCompat.ViewGroupCompatStubImpl {
      public void setMotionEventSplittingEnabled(ViewGroup var1, boolean var2) {
         ViewGroupCompatHC.setMotionEventSplittingEnabled(var1, var2);
      }
   }

   static class ViewGroupCompatIcsImpl extends ViewGroupCompat.ViewGroupCompatHCImpl {
      public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
         return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(var1, var2, var3);
      }
   }

   interface ViewGroupCompatImpl {
      boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3);

      void setMotionEventSplittingEnabled(ViewGroup var1, boolean var2);
   }

   static class ViewGroupCompatStubImpl implements ViewGroupCompat.ViewGroupCompatImpl {
      public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
         return true;
      }

      public void setMotionEventSplittingEnabled(ViewGroup var1, boolean var2) {
      }
   }
}
