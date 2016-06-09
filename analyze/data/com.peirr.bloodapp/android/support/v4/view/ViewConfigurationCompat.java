package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewConfigurationCompatFroyo;
import android.view.ViewConfiguration;

public class ViewConfigurationCompat {
   static final ViewConfigurationCompat.ViewConfigurationVersionImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new ViewConfigurationCompat.FroyoViewConfigurationVersionImpl();
      } else {
         IMPL = new ViewConfigurationCompat.BaseViewConfigurationVersionImpl();
      }
   }

   public static int getScaledPagingTouchSlop(ViewConfiguration var0) {
      return IMPL.getScaledPagingTouchSlop(var0);
   }

   static class BaseViewConfigurationVersionImpl implements ViewConfigurationCompat.ViewConfigurationVersionImpl {
      public int getScaledPagingTouchSlop(ViewConfiguration var1) {
         return var1.getScaledTouchSlop();
      }
   }

   static class FroyoViewConfigurationVersionImpl implements ViewConfigurationCompat.ViewConfigurationVersionImpl {
      public int getScaledPagingTouchSlop(ViewConfiguration var1) {
         return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(var1);
      }
   }

   interface ViewConfigurationVersionImpl {
      int getScaledPagingTouchSlop(ViewConfiguration var1);
   }
}
