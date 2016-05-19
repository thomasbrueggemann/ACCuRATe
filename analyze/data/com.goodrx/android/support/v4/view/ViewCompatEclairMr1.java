package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewCompatEclairMr1 {
   public static final String TAG = "ViewCompat";
   private static Method sChildrenDrawingOrderMethod;

   public static boolean isOpaque(View var0) {
      return var0.isOpaque();
   }

   public static void setChildrenDrawingOrderEnabled(ViewGroup var0, boolean var1) {
      if(sChildrenDrawingOrderMethod == null) {
         try {
            Class[] var13 = new Class[]{Boolean.TYPE};
            sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", var13);
         } catch (NoSuchMethodException var17) {
            Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", var17);
         }

         sChildrenDrawingOrderMethod.setAccessible(true);
      }

      try {
         Method var8 = sChildrenDrawingOrderMethod;
         Object[] var9 = new Object[]{Boolean.valueOf(var1)};
         var8.invoke(var0, var9);
      } catch (IllegalAccessException var14) {
         Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", var14);
      } catch (IllegalArgumentException var15) {
         Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", var15);
      } catch (InvocationTargetException var16) {
         Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", var16);
      }
   }
}
