package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BundleCompatDonut {
   private static final String TAG = "BundleCompatDonut";
   private static Method sGetIBinderMethod;
   private static boolean sGetIBinderMethodFetched;
   private static Method sPutIBinderMethod;
   private static boolean sPutIBinderMethodFetched;

   public static IBinder getBinder(Bundle var0, String var1) {
      if(!sGetIBinderMethodFetched) {
         try {
            sGetIBinderMethod = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
            sGetIBinderMethod.setAccessible(true);
         } catch (NoSuchMethodException var9) {
            Log.i("BundleCompatDonut", "Failed to retrieve getIBinder method", var9);
         }

         sGetIBinderMethodFetched = true;
      }

      if(sGetIBinderMethod != null) {
         Object var2;
         try {
            IBinder var4 = (IBinder)sGetIBinderMethod.invoke(var0, new Object[]{var1});
            return var4;
         } catch (InvocationTargetException var6) {
            var2 = var6;
         } catch (IllegalAccessException var7) {
            var2 = var7;
         } catch (IllegalArgumentException var8) {
            var2 = var8;
         }

         Log.i("BundleCompatDonut", "Failed to invoke getIBinder via reflection", (Throwable)var2);
         sGetIBinderMethod = null;
      }

      return null;
   }

   public static void putBinder(Bundle var0, String var1, IBinder var2) {
      if(!sPutIBinderMethodFetched) {
         try {
            sPutIBinderMethod = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
            sPutIBinderMethod.setAccessible(true);
         } catch (NoSuchMethodException var7) {
            Log.i("BundleCompatDonut", "Failed to retrieve putIBinder method", var7);
         }

         sPutIBinderMethodFetched = true;
      }

      if(sPutIBinderMethod != null) {
         Object var3;
         try {
            sPutIBinderMethod.invoke(var0, new Object[]{var1, var2});
            return;
         } catch (InvocationTargetException var8) {
            var3 = var8;
         } catch (IllegalAccessException var9) {
            var3 = var9;
         } catch (IllegalArgumentException var10) {
            var3 = var10;
         }

         Log.i("BundleCompatDonut", "Failed to invoke putIBinder via reflection", (Throwable)var3);
         sPutIBinderMethod = null;
      }
   }
}
