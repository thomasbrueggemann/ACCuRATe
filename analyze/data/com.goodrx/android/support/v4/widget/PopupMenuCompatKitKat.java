package android.support.v4.widget;

import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

class PopupMenuCompatKitKat {
   public static OnTouchListener getDragToOpenListener(Object var0) {
      return ((PopupMenu)var0).getDragToOpenListener();
   }
}
