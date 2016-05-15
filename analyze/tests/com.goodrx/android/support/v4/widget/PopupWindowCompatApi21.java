package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class PopupWindowCompatApi21 {
   private static final String TAG = "PopupWindowCompatApi21";
   private static Field sOverlapAnchorField;

   static {
      try {
         sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
         sOverlapAnchorField.setAccessible(true);
      } catch (NoSuchFieldException var1) {
         Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", var1);
      }
   }

   static boolean getOverlapAnchor(PopupWindow var0) {
      if(sOverlapAnchorField != null) {
         try {
            boolean var3 = ((Boolean)sOverlapAnchorField.get(var0)).booleanValue();
            return var3;
         } catch (IllegalAccessException var4) {
            Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", var4);
         }
      }

      return false;
   }

   static void setOverlapAnchor(PopupWindow var0, boolean var1) {
      if(sOverlapAnchorField != null) {
         try {
            sOverlapAnchorField.set(var0, Boolean.valueOf(var1));
         } catch (IllegalAccessException var3) {
            Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", var3);
            return;
         }
      }

   }
}
