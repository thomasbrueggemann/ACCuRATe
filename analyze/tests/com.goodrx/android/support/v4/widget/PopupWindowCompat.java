package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.widget.PopupWindowCompatApi21;
import android.support.v4.widget.PopupWindowCompatApi23;
import android.support.v4.widget.PopupWindowCompatGingerbread;
import android.support.v4.widget.PopupWindowCompatKitKat;
import android.view.View;
import android.widget.PopupWindow;

public final class PopupWindowCompat {
   static final PopupWindowCompat.PopupWindowImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new PopupWindowCompat.Api23PopupWindowImpl();
      } else if(var0 >= 21) {
         IMPL = new PopupWindowCompat.Api21PopupWindowImpl();
      } else if(var0 >= 19) {
         IMPL = new PopupWindowCompat.KitKatPopupWindowImpl();
      } else if(var0 >= 9) {
         IMPL = new PopupWindowCompat.GingerbreadPopupWindowImpl();
      } else {
         IMPL = new PopupWindowCompat.BasePopupWindowImpl();
      }
   }

   public static boolean getOverlapAnchor(PopupWindow var0) {
      return IMPL.getOverlapAnchor(var0);
   }

   public static int getWindowLayoutType(PopupWindow var0) {
      return IMPL.getWindowLayoutType(var0);
   }

   public static void setOverlapAnchor(PopupWindow var0, boolean var1) {
      IMPL.setOverlapAnchor(var0, var1);
   }

   public static void setWindowLayoutType(PopupWindow var0, int var1) {
      IMPL.setWindowLayoutType(var0, var1);
   }

   public static void showAsDropDown(PopupWindow var0, View var1, int var2, int var3, int var4) {
      IMPL.showAsDropDown(var0, var1, var2, var3, var4);
   }

   static class Api21PopupWindowImpl extends PopupWindowCompat.KitKatPopupWindowImpl {
      public boolean getOverlapAnchor(PopupWindow var1) {
         return PopupWindowCompatApi21.getOverlapAnchor(var1);
      }

      public void setOverlapAnchor(PopupWindow var1, boolean var2) {
         PopupWindowCompatApi21.setOverlapAnchor(var1, var2);
      }
   }

   static class Api23PopupWindowImpl extends PopupWindowCompat.Api21PopupWindowImpl {
      public boolean getOverlapAnchor(PopupWindow var1) {
         return PopupWindowCompatApi23.getOverlapAnchor(var1);
      }

      public int getWindowLayoutType(PopupWindow var1) {
         return PopupWindowCompatApi23.getWindowLayoutType(var1);
      }

      public void setOverlapAnchor(PopupWindow var1, boolean var2) {
         PopupWindowCompatApi23.setOverlapAnchor(var1, var2);
      }

      public void setWindowLayoutType(PopupWindow var1, int var2) {
         PopupWindowCompatApi23.setWindowLayoutType(var1, var2);
      }
   }

   static class BasePopupWindowImpl implements PopupWindowCompat.PopupWindowImpl {
      public boolean getOverlapAnchor(PopupWindow var1) {
         return false;
      }

      public int getWindowLayoutType(PopupWindow var1) {
         return 0;
      }

      public void setOverlapAnchor(PopupWindow var1, boolean var2) {
      }

      public void setWindowLayoutType(PopupWindow var1, int var2) {
      }

      public void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5) {
         var1.showAsDropDown(var2, var3, var4);
      }
   }

   static class GingerbreadPopupWindowImpl extends PopupWindowCompat.BasePopupWindowImpl {
      public int getWindowLayoutType(PopupWindow var1) {
         return PopupWindowCompatGingerbread.getWindowLayoutType(var1);
      }

      public void setWindowLayoutType(PopupWindow var1, int var2) {
         PopupWindowCompatGingerbread.setWindowLayoutType(var1, var2);
      }
   }

   static class KitKatPopupWindowImpl extends PopupWindowCompat.GingerbreadPopupWindowImpl {
      public void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5) {
         PopupWindowCompatKitKat.showAsDropDown(var1, var2, var3, var4, var5);
      }
   }

   interface PopupWindowImpl {
      boolean getOverlapAnchor(PopupWindow var1);

      int getWindowLayoutType(PopupWindow var1);

      void setOverlapAnchor(PopupWindow var1, boolean var2);

      void setWindowLayoutType(PopupWindow var1, int var2);

      void showAsDropDown(PopupWindow var1, View var2, int var3, int var4, int var5);
   }
}
