package cz.msebera.android.httpclient.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CloneUtils {
   public static <T> T cloneObject(T var0) throws CloneNotSupportedException {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof Cloneable) {
         Class var1 = var0.getClass();

         Method var3;
         try {
            var3 = var1.getMethod("clone", (Class[])null);
         } catch (NoSuchMethodException var8) {
            throw new NoSuchMethodError(var8.getMessage());
         }

         try {
            Object var7 = var3.invoke(var0, (Object[])null);
            return var7;
         } catch (InvocationTargetException var9) {
            Throwable var6 = var9.getCause();
            if(var6 instanceof CloneNotSupportedException) {
               throw (CloneNotSupportedException)var6;
            } else {
               throw new Error("Unexpected exception", var6);
            }
         } catch (IllegalAccessException var10) {
            throw new IllegalAccessError(var10.getMessage());
         }
      } else {
         throw new CloneNotSupportedException();
      }
   }
}
