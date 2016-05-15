package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

public final class AccessibilityManagerCompat {
   private static final AccessibilityManagerCompat.AccessibilityManagerVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityManagerCompat.AccessibilityManagerIcsImpl();
      } else {
         IMPL = new AccessibilityManagerCompat.AccessibilityManagerStubImpl();
      }
   }

   public static boolean addAccessibilityStateChangeListener(AccessibilityManager var0, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var1) {
      return IMPL.addAccessibilityStateChangeListener(var0, var1);
   }

   public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager var0, int var1) {
      return IMPL.getEnabledAccessibilityServiceList(var0, var1);
   }

   public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager var0) {
      return IMPL.getInstalledAccessibilityServiceList(var0);
   }

   public static boolean isTouchExplorationEnabled(AccessibilityManager var0) {
      return IMPL.isTouchExplorationEnabled(var0);
   }

   public static boolean removeAccessibilityStateChangeListener(AccessibilityManager var0, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var1) {
      return IMPL.removeAccessibilityStateChangeListener(var0, var1);
   }

   static class AccessibilityManagerIcsImpl extends AccessibilityManagerCompat.AccessibilityManagerStubImpl {
      public boolean addAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var2) {
         return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(var1, var2.mListener);
      }

      public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager var1, int var2) {
         return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(var1, var2);
      }

      public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager var1) {
         return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(var1);
      }

      public boolean isTouchExplorationEnabled(AccessibilityManager var1) {
         return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(var1);
      }

      public Object newAccessiblityStateChangeListener(final AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var1) {
         return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge() {
            public void onAccessibilityStateChanged(boolean var1x) {
               var1.onAccessibilityStateChanged(var1x);
            }
         });
      }

      public boolean removeAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var2) {
         return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(var1, var2.mListener);
      }
   }

   static class AccessibilityManagerStubImpl implements AccessibilityManagerCompat.AccessibilityManagerVersionImpl {
      public boolean addAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var2) {
         return false;
      }

      public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager var1, int var2) {
         return Collections.emptyList();
      }

      public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager var1) {
         return Collections.emptyList();
      }

      public boolean isTouchExplorationEnabled(AccessibilityManager var1) {
         return false;
      }

      public Object newAccessiblityStateChangeListener(AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var1) {
         return null;
      }

      public boolean removeAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var2) {
         return false;
      }
   }

   interface AccessibilityManagerVersionImpl {
      boolean addAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var2);

      List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager var1, int var2);

      List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager var1);

      boolean isTouchExplorationEnabled(AccessibilityManager var1);

      Object newAccessiblityStateChangeListener(AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var1);

      boolean removeAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat var2);
   }

   public abstract static class AccessibilityStateChangeListenerCompat {
      final Object mListener;

      public AccessibilityStateChangeListenerCompat() {
         this.mListener = AccessibilityManagerCompat.IMPL.newAccessiblityStateChangeListener(this);
      }

      public abstract void onAccessibilityStateChanged(boolean var1);
   }
}
