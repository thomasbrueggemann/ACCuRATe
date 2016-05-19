package android.support.design.widget;

import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class DrawableUtils {
   private static final String LOG_TAG = "DrawableUtils";
   private static Field sDrawableContainerStateField;
   private static boolean sDrawableContainerStateFieldFetched;
   private static Method sSetConstantStateMethod;
   private static boolean sSetConstantStateMethodFetched;

   static boolean setContainerConstantState(DrawableContainer var0, ConstantState var1) {
      return VERSION.SDK_INT >= 9?setContainerConstantStateV9(var0, var1):setContainerConstantStateV7(var0, var1);
   }

   private static boolean setContainerConstantStateV7(DrawableContainer var0, ConstantState var1) {
      if(!sDrawableContainerStateFieldFetched) {
         try {
            sDrawableContainerStateField = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
            sDrawableContainerStateField.setAccessible(true);
         } catch (NoSuchFieldException var5) {
            Log.e("DrawableUtils", "Could not fetch mDrawableContainerStateField. Oh well.");
         }

         sDrawableContainerStateFieldFetched = true;
      }

      if(sDrawableContainerStateField != null) {
         try {
            sDrawableContainerStateField.set(var0, var1);
            return true;
         } catch (Exception var6) {
            Log.e("DrawableUtils", "Could not set mDrawableContainerStateField. Oh well.");
         }
      }

      return false;
   }

   private static boolean setContainerConstantStateV9(DrawableContainer var0, ConstantState var1) {
      if(!sSetConstantStateMethodFetched) {
         try {
            sSetConstantStateMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
            sSetConstantStateMethod.setAccessible(true);
         } catch (NoSuchMethodException var6) {
            Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
         }

         sSetConstantStateMethodFetched = true;
      }

      if(sSetConstantStateMethod != null) {
         try {
            sSetConstantStateMethod.invoke(var0, new Object[]{var1});
            return true;
         } catch (Exception var7) {
            Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
         }
      }

      return false;
   }
}
