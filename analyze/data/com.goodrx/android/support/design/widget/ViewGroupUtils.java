package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.ViewGroupUtilsHoneycomb;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils {
   private static final ViewGroupUtils.ViewGroupUtilsImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new ViewGroupUtils.ViewGroupUtilsImplHoneycomb();
      } else {
         IMPL = new ViewGroupUtils.ViewGroupUtilsImplBase();
      }
   }

   static void getDescendantRect(ViewGroup var0, View var1, Rect var2) {
      var2.set(0, 0, var1.getWidth(), var1.getHeight());
      offsetDescendantRect(var0, var1, var2);
   }

   static void offsetDescendantRect(ViewGroup var0, View var1, Rect var2) {
      IMPL.offsetDescendantRect(var0, var1, var2);
   }

   private interface ViewGroupUtilsImpl {
      void offsetDescendantRect(ViewGroup var1, View var2, Rect var3);
   }

   private static class ViewGroupUtilsImplBase implements ViewGroupUtils.ViewGroupUtilsImpl {
      private ViewGroupUtilsImplBase() {
      }

      // $FF: synthetic method
      ViewGroupUtilsImplBase(Object var1) {
         this();
      }

      public void offsetDescendantRect(ViewGroup var1, View var2, Rect var3) {
         var1.offsetDescendantRectToMyCoords(var2, var3);
         var3.offset(var2.getScrollX(), var2.getScrollY());
      }
   }

   private static class ViewGroupUtilsImplHoneycomb implements ViewGroupUtils.ViewGroupUtilsImpl {
      private ViewGroupUtilsImplHoneycomb() {
      }

      // $FF: synthetic method
      ViewGroupUtilsImplHoneycomb(Object var1) {
         this();
      }

      public void offsetDescendantRect(ViewGroup var1, View var2, Rect var3) {
         ViewGroupUtilsHoneycomb.offsetDescendantRect(var1, var2, var3);
      }
   }
}
