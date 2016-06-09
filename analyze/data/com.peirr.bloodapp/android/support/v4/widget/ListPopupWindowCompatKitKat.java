package android.support.v4.widget;

import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListPopupWindow;

class ListPopupWindowCompatKitKat {
   public static OnTouchListener createDragToOpenListener(Object var0, View var1) {
      return ((ListPopupWindow)var0).createDragToOpenListener(var1);
   }
}
