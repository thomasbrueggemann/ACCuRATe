package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class DrawableCompatJellybeanMr1 {
   private static final String TAG = "DrawableCompatJellybeanMr1";
   private static Method sGetLayoutDirectionMethod;
   private static boolean sGetLayoutDirectionMethodFetched;
   private static Method sSetLayoutDirectionMethod;
   private static boolean sSetLayoutDirectionMethodFetched;

   public static int getLayoutDirection(Drawable var0) {
      if(!sGetLayoutDirectionMethodFetched) {
         try {
            sGetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
            sGetLayoutDirectionMethod.setAccessible(true);
         } catch (NoSuchMethodException var5) {
            Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", var5);
         }

         sGetLayoutDirectionMethodFetched = true;
      }

      if(sGetLayoutDirectionMethod != null) {
         try {
            int var3 = ((Integer)sGetLayoutDirectionMethod.invoke(var0, new Object[0])).intValue();
            return var3;
         } catch (Exception var6) {
            Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", var6);
            sGetLayoutDirectionMethod = null;
         }
      }

      return -1;
   }

   public static void setLayoutDirection(Drawable var0, int var1) {
      if(!sSetLayoutDirectionMethodFetched) {
         try {
            Class[] var9 = new Class[]{Integer.TYPE};
            sSetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", var9);
            sSetLayoutDirectionMethod.setAccessible(true);
         } catch (NoSuchMethodException var11) {
            Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", var11);
         }

         sSetLayoutDirectionMethodFetched = true;
      }

      if(sSetLayoutDirectionMethod != null) {
         try {
            Method var4 = sSetLayoutDirectionMethod;
            Object[] var5 = new Object[]{Integer.valueOf(var1)};
            var4.invoke(var0, var5);
         } catch (Exception var10) {
            Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", var10);
            sSetLayoutDirectionMethod = null;
            return;
         }
      }

   }
}
