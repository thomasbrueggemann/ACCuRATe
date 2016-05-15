package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewParentCompatICS;
import android.support.v4.view.ViewParentCompatKitKat;
import android.support.v4.view.ViewParentCompatLollipop;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public final class ViewParentCompat {
   static final ViewParentCompat.ViewParentCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new ViewParentCompat.ViewParentCompatLollipopImpl();
      } else if(var0 >= 19) {
         IMPL = new ViewParentCompat.ViewParentCompatKitKatImpl();
      } else if(var0 >= 14) {
         IMPL = new ViewParentCompat.ViewParentCompatICSImpl();
      } else {
         IMPL = new ViewParentCompat.ViewParentCompatStubImpl();
      }
   }

   public static void notifySubtreeAccessibilityStateChanged(ViewParent var0, View var1, View var2, int var3) {
      IMPL.notifySubtreeAccessibilityStateChanged(var0, var1, var2, var3);
   }

   public static boolean onNestedFling(ViewParent var0, View var1, float var2, float var3, boolean var4) {
      return IMPL.onNestedFling(var0, var1, var2, var3, var4);
   }

   public static boolean onNestedPreFling(ViewParent var0, View var1, float var2, float var3) {
      return IMPL.onNestedPreFling(var0, var1, var2, var3);
   }

   public static void onNestedPreScroll(ViewParent var0, View var1, int var2, int var3, int[] var4) {
      IMPL.onNestedPreScroll(var0, var1, var2, var3, var4);
   }

   public static void onNestedScroll(ViewParent var0, View var1, int var2, int var3, int var4, int var5) {
      IMPL.onNestedScroll(var0, var1, var2, var3, var4, var5);
   }

   public static void onNestedScrollAccepted(ViewParent var0, View var1, View var2, int var3) {
      IMPL.onNestedScrollAccepted(var0, var1, var2, var3);
   }

   public static boolean onStartNestedScroll(ViewParent var0, View var1, View var2, int var3) {
      return IMPL.onStartNestedScroll(var0, var1, var2, var3);
   }

   public static void onStopNestedScroll(ViewParent var0, View var1) {
      IMPL.onStopNestedScroll(var0, var1);
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
      void notifySubtreeAccessibilityStateChanged(ViewParent var1, View var2, View var3, int var4);

      boolean onNestedFling(ViewParent var1, View var2, float var3, float var4, boolean var5);

      boolean onNestedPreFling(ViewParent var1, View var2, float var3, float var4);

      void onNestedPreScroll(ViewParent var1, View var2, int var3, int var4, int[] var5);

      void onNestedScroll(ViewParent var1, View var2, int var3, int var4, int var5, int var6);

      void onNestedScrollAccepted(ViewParent var1, View var2, View var3, int var4);

      boolean onStartNestedScroll(ViewParent var1, View var2, View var3, int var4);

      void onStopNestedScroll(ViewParent var1, View var2);

      boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3);
   }

   static class ViewParentCompatKitKatImpl extends ViewParentCompat.ViewParentCompatICSImpl {
      public void notifySubtreeAccessibilityStateChanged(ViewParent var1, View var2, View var3, int var4) {
         ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(var1, var2, var3, var4);
      }
   }

   static class ViewParentCompatLollipopImpl extends ViewParentCompat.ViewParentCompatKitKatImpl {
      public boolean onNestedFling(ViewParent var1, View var2, float var3, float var4, boolean var5) {
         return ViewParentCompatLollipop.onNestedFling(var1, var2, var3, var4, var5);
      }

      public boolean onNestedPreFling(ViewParent var1, View var2, float var3, float var4) {
         return ViewParentCompatLollipop.onNestedPreFling(var1, var2, var3, var4);
      }

      public void onNestedPreScroll(ViewParent var1, View var2, int var3, int var4, int[] var5) {
         ViewParentCompatLollipop.onNestedPreScroll(var1, var2, var3, var4, var5);
      }

      public void onNestedScroll(ViewParent var1, View var2, int var3, int var4, int var5, int var6) {
         ViewParentCompatLollipop.onNestedScroll(var1, var2, var3, var4, var5, var6);
      }

      public void onNestedScrollAccepted(ViewParent var1, View var2, View var3, int var4) {
         ViewParentCompatLollipop.onNestedScrollAccepted(var1, var2, var3, var4);
      }

      public boolean onStartNestedScroll(ViewParent var1, View var2, View var3, int var4) {
         return ViewParentCompatLollipop.onStartNestedScroll(var1, var2, var3, var4);
      }

      public void onStopNestedScroll(ViewParent var1, View var2) {
         ViewParentCompatLollipop.onStopNestedScroll(var1, var2);
      }
   }

   static class ViewParentCompatStubImpl implements ViewParentCompat.ViewParentCompatImpl {
      public void notifySubtreeAccessibilityStateChanged(ViewParent var1, View var2, View var3, int var4) {
      }

      public boolean onNestedFling(ViewParent var1, View var2, float var3, float var4, boolean var5) {
         return var1 instanceof NestedScrollingParent?((NestedScrollingParent)var1).onNestedFling(var2, var3, var4, var5):false;
      }

      public boolean onNestedPreFling(ViewParent var1, View var2, float var3, float var4) {
         return var1 instanceof NestedScrollingParent?((NestedScrollingParent)var1).onNestedPreFling(var2, var3, var4):false;
      }

      public void onNestedPreScroll(ViewParent var1, View var2, int var3, int var4, int[] var5) {
         if(var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onNestedPreScroll(var2, var3, var4, var5);
         }

      }

      public void onNestedScroll(ViewParent var1, View var2, int var3, int var4, int var5, int var6) {
         if(var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onNestedScroll(var2, var3, var4, var5, var6);
         }

      }

      public void onNestedScrollAccepted(ViewParent var1, View var2, View var3, int var4) {
         if(var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onNestedScrollAccepted(var2, var3, var4);
         }

      }

      public boolean onStartNestedScroll(ViewParent var1, View var2, View var3, int var4) {
         return var1 instanceof NestedScrollingParent?((NestedScrollingParent)var1).onStartNestedScroll(var2, var3, var4):false;
      }

      public void onStopNestedScroll(ViewParent var1, View var2) {
         if(var1 instanceof NestedScrollingParent) {
            ((NestedScrollingParent)var1).onStopNestedScroll(var2);
         }

      }

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
