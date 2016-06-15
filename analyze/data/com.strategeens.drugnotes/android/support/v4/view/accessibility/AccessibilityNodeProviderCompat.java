package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
   private static final AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl IMPL;
   private final Object mProvider;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl();
      } else {
         IMPL = new AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl();
      }
   }

   public AccessibilityNodeProviderCompat() {
      this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
   }

   public AccessibilityNodeProviderCompat(Object var1) {
      this.mProvider = var1;
   }

   public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int var1) {
      return null;
   }

   public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String var1, int var2) {
      return null;
   }

   public AccessibilityNodeInfoCompat findFocus(int var1) {
      return null;
   }

   public Object getProvider() {
      return this.mProvider;
   }

   public boolean performAction(int var1, int var2, Bundle var3) {
      return false;
   }

   interface AccessibilityNodeProviderImpl {
      Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat var1);
   }

   static class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl {
      public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat var1) {
         return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge() {
            public Object createAccessibilityNodeInfo(int var1x) {
               AccessibilityNodeInfoCompat var2 = var1.createAccessibilityNodeInfo(var1x);
               return var2 == null?null:var2.getInfo();
            }

            public List<Object> findAccessibilityNodeInfosByText(String var1x, int var2) {
               List var3 = var1.findAccessibilityNodeInfosByText(var1x, var2);
               ArrayList var4 = new ArrayList();
               int var5 = var3.size();

               for(int var6 = 0; var6 < var5; ++var6) {
                  var4.add(((AccessibilityNodeInfoCompat)var3.get(var6)).getInfo());
               }

               return var4;
            }

            public boolean performAction(int var1x, int var2, Bundle var3) {
               return var1.performAction(var1x, var2, var3);
            }
         });
      }
   }

   static class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl {
      public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat var1) {
         return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge() {
            public Object createAccessibilityNodeInfo(int var1x) {
               AccessibilityNodeInfoCompat var2 = var1.createAccessibilityNodeInfo(var1x);
               return var2 == null?null:var2.getInfo();
            }

            public List<Object> findAccessibilityNodeInfosByText(String var1x, int var2) {
               List var3 = var1.findAccessibilityNodeInfosByText(var1x, var2);
               ArrayList var4 = new ArrayList();
               int var5 = var3.size();

               for(int var6 = 0; var6 < var5; ++var6) {
                  var4.add(((AccessibilityNodeInfoCompat)var3.get(var6)).getInfo());
               }

               return var4;
            }

            public Object findFocus(int var1x) {
               AccessibilityNodeInfoCompat var2 = var1.findFocus(var1x);
               return var2 == null?null:var2.getInfo();
            }

            public boolean performAction(int var1x, int var2, Bundle var3) {
               return var1.performAction(var1x, var2, var3);
            }
         });
      }
   }

   static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl {
      public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat var1) {
         return null;
      }
   }
}
