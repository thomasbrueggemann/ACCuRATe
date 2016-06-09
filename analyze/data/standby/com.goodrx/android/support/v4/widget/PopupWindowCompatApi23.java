package android.support.v4.widget;

import android.widget.PopupWindow;

class PopupWindowCompatApi23 {
   static boolean getOverlapAnchor(PopupWindow var0) {
      return var0.getOverlapAnchor();
   }

   static int getWindowLayoutType(PopupWindow var0) {
      return var0.getWindowLayoutType();
   }

   static void setOverlapAnchor(PopupWindow var0, boolean var1) {
      var0.setOverlapAnchor(var1);
   }

   static void setWindowLayoutType(PopupWindow var0, int var1) {
      var0.setWindowLayoutType(var1);
   }
}
