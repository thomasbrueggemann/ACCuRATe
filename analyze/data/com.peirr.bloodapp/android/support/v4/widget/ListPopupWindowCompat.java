package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.widget.ListPopupWindowCompatKitKat;
import android.view.View;
import android.view.View.OnTouchListener;

public class ListPopupWindowCompat {
   static final ListPopupWindowCompat.ListPopupWindowImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new ListPopupWindowCompat.KitKatListPopupWindowImpl();
      } else {
         IMPL = new ListPopupWindowCompat.BaseListPopupWindowImpl();
      }
   }

   public static OnTouchListener createDragToOpenListener(Object var0, View var1) {
      return IMPL.createDragToOpenListener(var0, var1);
   }

   static class BaseListPopupWindowImpl implements ListPopupWindowCompat.ListPopupWindowImpl {
      public OnTouchListener createDragToOpenListener(Object var1, View var2) {
         return null;
      }
   }

   static class KitKatListPopupWindowImpl extends ListPopupWindowCompat.BaseListPopupWindowImpl {
      public OnTouchListener createDragToOpenListener(Object var1, View var2) {
         return ListPopupWindowCompatKitKat.createDragToOpenListener(var1, var2);
      }
   }

   interface ListPopupWindowImpl {
      OnTouchListener createDragToOpenListener(Object var1, View var2);
   }
}
