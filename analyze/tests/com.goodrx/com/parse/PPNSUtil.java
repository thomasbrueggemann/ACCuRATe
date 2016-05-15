package com.parse;

import android.app.Service;
import com.parse.ProxyService;
import java.lang.reflect.InvocationTargetException;

class PPNSUtil {
   static String CLASS_PPNS_SERVICE = "com.parse.PPNSService";

   public static boolean isPPNSAvailable() {
      try {
         Class.forName(CLASS_PPNS_SERVICE);
         return true;
      } catch (ClassNotFoundException var1) {
         return false;
      }
   }

   public static ProxyService newPPNSService(Service var0) {
      try {
         ProxyService var6 = (ProxyService)Class.forName(CLASS_PPNS_SERVICE).getDeclaredConstructor(new Class[]{Service.class}).newInstance(new Object[]{var0});
         return var6;
      } catch (ClassNotFoundException var7) {
         throw new RuntimeException(var7);
      } catch (NoSuchMethodException var8) {
         throw new RuntimeException(var8);
      } catch (InvocationTargetException var9) {
         throw new RuntimeException(var9);
      } catch (InstantiationException var10) {
         throw new RuntimeException(var10);
      } catch (IllegalAccessException var11) {
         throw new RuntimeException(var11);
      }
   }
}
