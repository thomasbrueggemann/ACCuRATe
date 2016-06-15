package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.widget.PopupMenuCompatKitKat;
import android.view.View.OnTouchListener;

public class PopupMenuCompat {
   static final PopupMenuCompat.PopupMenuImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new PopupMenuCompat.KitKatPopupMenuImpl();
      } else {
         IMPL = new PopupMenuCompat.BasePopupMenuImpl();
      }
   }

   public static OnTouchListener getDragToOpenListener(Object var0) {
      return IMPL.getDragToOpenListener(var0);
   }

   static class BasePopupMenuImpl implements PopupMenuCompat.PopupMenuImpl {
      public OnTouchListener getDragToOpenListener(Object var1) {
         return null;
      }
   }

   static class KitKatPopupMenuImpl extends PopupMenuCompat.BasePopupMenuImpl {
      public OnTouchListener getDragToOpenListener(Object var1) {
         return PopupMenuCompatKitKat.getDragToOpenListener(var1);
      }
   }

   interface PopupMenuImpl {
      OnTouchListener getDragToOpenListener(Object var1);
   }
}
