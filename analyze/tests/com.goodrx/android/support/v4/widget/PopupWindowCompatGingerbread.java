package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompatGingerbread {
   private static Method sGetWindowLayoutTypeMethod;
   private static boolean sGetWindowLayoutTypeMethodAttempted;
   private static Method sSetWindowLayoutTypeMethod;
   private static boolean sSetWindowLayoutTypeMethodAttempted;

   static int getWindowLayoutType(PopupWindow var0) {
      if(!sGetWindowLayoutTypeMethodAttempted) {
         try {
            sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
            sGetWindowLayoutTypeMethod.setAccessible(true);
         } catch (Exception var4) {
            ;
         }

         sGetWindowLayoutTypeMethodAttempted = true;
      }

      if(sGetWindowLayoutTypeMethod != null) {
         try {
            int var2 = ((Integer)sGetWindowLayoutTypeMethod.invoke(var0, new Object[0])).intValue();
            return var2;
         } catch (Exception var5) {
            ;
         }
      }

      return 0;
   }

   static void setWindowLayoutType(PopupWindow var0, int var1) {
      if(!sSetWindowLayoutTypeMethodAttempted) {
         try {
            Class[] var7 = new Class[]{Integer.TYPE};
            sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", var7);
            sSetWindowLayoutTypeMethod.setAccessible(true);
         } catch (Exception var9) {
            ;
         }

         sSetWindowLayoutTypeMethodAttempted = true;
      }

      if(sSetWindowLayoutTypeMethod != null) {
         try {
            Method var3 = sSetWindowLayoutTypeMethod;
            Object[] var4 = new Object[]{Integer.valueOf(var1)};
            var3.invoke(var0, var4);
         } catch (Exception var8) {
            return;
         }
      }

   }
}
