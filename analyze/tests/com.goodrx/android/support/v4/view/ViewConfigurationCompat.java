package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewConfigurationCompatFroyo;
import android.support.v4.view.ViewConfigurationCompatICS;
import android.view.ViewConfiguration;

public final class ViewConfigurationCompat {
   static final ViewConfigurationCompat.ViewConfigurationVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new ViewConfigurationCompat.IcsViewConfigurationVersionImpl();
      } else if(VERSION.SDK_INT >= 11) {
         IMPL = new ViewConfigurationCompat.HoneycombViewConfigurationVersionImpl();
      } else if(VERSION.SDK_INT >= 8) {
         IMPL = new ViewConfigurationCompat.FroyoViewConfigurationVersionImpl();
      } else {
         IMPL = new ViewConfigurationCompat.BaseViewConfigurationVersionImpl();
      }
   }

   public static int getScaledPagingTouchSlop(ViewConfiguration var0) {
      return IMPL.getScaledPagingTouchSlop(var0);
   }

   public static boolean hasPermanentMenuKey(ViewConfiguration var0) {
      return IMPL.hasPermanentMenuKey(var0);
   }

   static class BaseViewConfigurationVersionImpl implements ViewConfigurationCompat.ViewConfigurationVersionImpl {
      public int getScaledPagingTouchSlop(ViewConfiguration var1) {
         return var1.getScaledTouchSlop();
      }

      public boolean hasPermanentMenuKey(ViewConfiguration var1) {
         return true;
      }
   }

   static class FroyoViewConfigurationVersionImpl extends ViewConfigurationCompat.BaseViewConfigurationVersionImpl {
      public int getScaledPagingTouchSlop(ViewConfiguration var1) {
         return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(var1);
      }
   }

   static class HoneycombViewConfigurationVersionImpl extends ViewConfigurationCompat.FroyoViewConfigurationVersionImpl {
      public boolean hasPermanentMenuKey(ViewConfiguration var1) {
         return false;
      }
   }

   static class IcsViewConfigurationVersionImpl extends ViewConfigurationCompat.HoneycombViewConfigurationVersionImpl {
      public boolean hasPermanentMenuKey(ViewConfiguration var1) {
         return ViewConfigurationCompatICS.hasPermanentMenuKey(var1);
      }
   }

   interface ViewConfigurationVersionImpl {
      int getScaledPagingTouchSlop(ViewConfiguration var1);

      boolean hasPermanentMenuKey(ViewConfiguration var1);
   }
}
