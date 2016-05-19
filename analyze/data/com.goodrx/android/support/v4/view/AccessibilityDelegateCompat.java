package android.support.v4.view;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.AccessibilityDelegateCompatIcs;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityDelegateCompat {
   private static final Object DEFAULT_DELEGATE;
   private static final AccessibilityDelegateCompat.AccessibilityDelegateImpl IMPL;
   final Object mBridge;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityDelegateCompat.AccessibilityDelegateJellyBeanImpl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl();
      } else {
         IMPL = new AccessibilityDelegateCompat.AccessibilityDelegateStubImpl();
      }

      DEFAULT_DELEGATE = IMPL.newAccessiblityDelegateDefaultImpl();
   }

   public AccessibilityDelegateCompat() {
      this.mBridge = IMPL.newAccessiblityDelegateBridge(this);
   }

   public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      return IMPL.dispatchPopulateAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
      return IMPL.getAccessibilityNodeProvider(DEFAULT_DELEGATE, var1);
   }

   Object getBridge() {
      return this.mBridge;
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      IMPL.onInitializeAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      IMPL.onInitializeAccessibilityNodeInfo(DEFAULT_DELEGATE, var1, var2);
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      IMPL.onPopulateAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return IMPL.onRequestSendAccessibilityEvent(DEFAULT_DELEGATE, var1, var2, var3);
   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return IMPL.performAccessibilityAction(DEFAULT_DELEGATE, var1, var2, var3);
   }

   public void sendAccessibilityEvent(View var1, int var2) {
      IMPL.sendAccessibilityEvent(DEFAULT_DELEGATE, var1, var2);
   }

   public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
      IMPL.sendAccessibilityEventUnchecked(DEFAULT_DELEGATE, var1, var2);
   }

   static class AccessibilityDelegateIcsImpl extends AccessibilityDelegateCompat.AccessibilityDelegateStubImpl {
      public boolean dispatchPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
         return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(var1, var2, var3);
      }

      public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat var1) {
         return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge() {
            public boolean dispatchPopulateAccessibilityEvent(View var1x, AccessibilityEvent var2) {
               return var1.dispatchPopulateAccessibilityEvent(var1x, var2);
            }

            public void onInitializeAccessibilityEvent(View var1x, AccessibilityEvent var2) {
               var1.onInitializeAccessibilityEvent(var1x, var2);
            }

            public void onInitializeAccessibilityNodeInfo(View var1x, Object var2) {
               var1.onInitializeAccessibilityNodeInfo(var1x, new AccessibilityNodeInfoCompat(var2));
            }

            public void onPopulateAccessibilityEvent(View var1x, AccessibilityEvent var2) {
               var1.onPopulateAccessibilityEvent(var1x, var2);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup var1x, View var2, AccessibilityEvent var3) {
               return var1.onRequestSendAccessibilityEvent(var1x, var2, var3);
            }

            public void sendAccessibilityEvent(View var1x, int var2) {
               var1.sendAccessibilityEvent(var1x, var2);
            }

            public void sendAccessibilityEventUnchecked(View var1x, AccessibilityEvent var2) {
               var1.sendAccessibilityEventUnchecked(var1x, var2);
            }
         });
      }

      public Object newAccessiblityDelegateDefaultImpl() {
         return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
      }

      public void onInitializeAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
         AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(var1, var2, var3);
      }

      public void onInitializeAccessibilityNodeInfo(Object var1, View var2, AccessibilityNodeInfoCompat var3) {
         AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(var1, var2, var3.getInfo());
      }

      public void onPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
         AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(var1, var2, var3);
      }

      public boolean onRequestSendAccessibilityEvent(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4) {
         return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(var1, var2, var3, var4);
      }

      public void sendAccessibilityEvent(Object var1, View var2, int var3) {
         AccessibilityDelegateCompatIcs.sendAccessibilityEvent(var1, var2, var3);
      }

      public void sendAccessibilityEventUnchecked(Object var1, View var2, AccessibilityEvent var3) {
         AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(var1, var2, var3);
      }
   }

   interface AccessibilityDelegateImpl {
      boolean dispatchPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3);

      AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object var1, View var2);

      Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat var1);

      Object newAccessiblityDelegateDefaultImpl();

      void onInitializeAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3);

      void onInitializeAccessibilityNodeInfo(Object var1, View var2, AccessibilityNodeInfoCompat var3);

      void onPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3);

      boolean onRequestSendAccessibilityEvent(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4);

      boolean performAccessibilityAction(Object var1, View var2, int var3, Bundle var4);

      void sendAccessibilityEvent(Object var1, View var2, int var3);

      void sendAccessibilityEventUnchecked(Object var1, View var2, AccessibilityEvent var3);
   }

   static class AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateCompat.AccessibilityDelegateIcsImpl {
      public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object var1, View var2) {
         Object var3 = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(var1, var2);
         return var3 != null?new AccessibilityNodeProviderCompat(var3):null;
      }

      public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat var1) {
         return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean() {
            public boolean dispatchPopulateAccessibilityEvent(View var1x, AccessibilityEvent var2) {
               return var1.dispatchPopulateAccessibilityEvent(var1x, var2);
            }

            public Object getAccessibilityNodeProvider(View var1x) {
               AccessibilityNodeProviderCompat var2 = var1.getAccessibilityNodeProvider(var1x);
               return var2 != null?var2.getProvider():null;
            }

            public void onInitializeAccessibilityEvent(View var1x, AccessibilityEvent var2) {
               var1.onInitializeAccessibilityEvent(var1x, var2);
            }

            public void onInitializeAccessibilityNodeInfo(View var1x, Object var2) {
               var1.onInitializeAccessibilityNodeInfo(var1x, new AccessibilityNodeInfoCompat(var2));
            }

            public void onPopulateAccessibilityEvent(View var1x, AccessibilityEvent var2) {
               var1.onPopulateAccessibilityEvent(var1x, var2);
            }

            public boolean onRequestSendAccessibilityEvent(ViewGroup var1x, View var2, AccessibilityEvent var3) {
               return var1.onRequestSendAccessibilityEvent(var1x, var2, var3);
            }

            public boolean performAccessibilityAction(View var1x, int var2, Bundle var3) {
               return var1.performAccessibilityAction(var1x, var2, var3);
            }

            public void sendAccessibilityEvent(View var1x, int var2) {
               var1.sendAccessibilityEvent(var1x, var2);
            }

            public void sendAccessibilityEventUnchecked(View var1x, AccessibilityEvent var2) {
               var1.sendAccessibilityEventUnchecked(var1x, var2);
            }
         });
      }

      public boolean performAccessibilityAction(Object var1, View var2, int var3, Bundle var4) {
         return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(var1, var2, var3, var4);
      }
   }

   static class AccessibilityDelegateStubImpl implements AccessibilityDelegateCompat.AccessibilityDelegateImpl {
      public boolean dispatchPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
         return false;
      }

      public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object var1, View var2) {
         return null;
      }

      public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat var1) {
         return null;
      }

      public Object newAccessiblityDelegateDefaultImpl() {
         return null;
      }

      public void onInitializeAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      }

      public void onInitializeAccessibilityNodeInfo(Object var1, View var2, AccessibilityNodeInfoCompat var3) {
      }

      public void onPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      }

      public boolean onRequestSendAccessibilityEvent(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4) {
         return true;
      }

      public boolean performAccessibilityAction(Object var1, View var2, int var3, Bundle var4) {
         return false;
      }

      public void sendAccessibilityEvent(Object var1, View var2, int var3) {
      }

      public void sendAccessibilityEventUnchecked(Object var1, View var2, AccessibilityEvent var3) {
      }
   }
}
