package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewGroupCompatHC;
import android.support.v4.view.ViewGroupCompatIcs;
import android.support.v4.view.ViewGroupCompatJellybeanMR2;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class ViewGroupCompat {
   static final ViewGroupCompat.ViewGroupCompatImpl IMPL;
   public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
   public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 18) {
         IMPL = new ViewGroupCompat.ViewGroupCompatJellybeanMR2Impl();
      } else if(var0 >= 14) {
         IMPL = new ViewGroupCompat.ViewGroupCompatIcsImpl();
      } else if(var0 >= 11) {
         IMPL = new ViewGroupCompat.ViewGroupCompatHCImpl();
      } else {
         IMPL = new ViewGroupCompat.ViewGroupCompatStubImpl();
      }
   }

   public static int getLayoutMode(ViewGroup var0) {
      return IMPL.getLayoutMode(var0);
   }

   public static boolean onRequestSendAccessibilityEvent(ViewGroup var0, View var1, AccessibilityEvent var2) {
      return IMPL.onRequestSendAccessibilityEvent(var0, var1, var2);
   }

   public static void setLayoutMode(ViewGroup var0, int var1) {
      IMPL.setLayoutMode(var0, var1);
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
      int getLayoutMode(ViewGroup var1);

      boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3);

      void setLayoutMode(ViewGroup var1, int var2);

      void setMotionEventSplittingEnabled(ViewGroup var1, boolean var2);
   }

   static class ViewGroupCompatJellybeanMR2Impl extends ViewGroupCompat.ViewGroupCompatIcsImpl {
      public int getLayoutMode(ViewGroup var1) {
         return ViewGroupCompatJellybeanMR2.getLayoutMode(var1);
      }

      public void setLayoutMode(ViewGroup var1, int var2) {
         ViewGroupCompatJellybeanMR2.setLayoutMode(var1, var2);
      }
   }

   static class ViewGroupCompatStubImpl implements ViewGroupCompat.ViewGroupCompatImpl {
      public int getLayoutMode(ViewGroup var1) {
         return 0;
      }

      public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
         return true;
      }

      public void setLayoutMode(ViewGroup var1, int var2) {
      }

      public void setMotionEventSplittingEnabled(ViewGroup var1, boolean var2) {
      }
   }
}
