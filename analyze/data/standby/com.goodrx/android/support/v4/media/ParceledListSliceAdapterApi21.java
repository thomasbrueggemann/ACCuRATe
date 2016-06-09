package android.support.v4.media;

import android.media.browse.MediaBrowser.MediaItem;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

class ParceledListSliceAdapterApi21 {
   private static Constructor sConstructor;

   static {
      Object var0;
      try {
         sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class});
         return;
      } catch (ClassNotFoundException var1) {
         var0 = var1;
      } catch (NoSuchMethodException var2) {
         var0 = var2;
      }

      ((ReflectiveOperationException)var0).printStackTrace();
   }

   static Object newInstance(List<MediaItem> var0) {
      Object var1;
      try {
         Object var2 = sConstructor.newInstance(new Object[]{var0});
         return var2;
      } catch (InstantiationException var3) {
         var1 = var3;
      } catch (IllegalAccessException var4) {
         var1 = var4;
      } catch (InvocationTargetException var5) {
         var1 = var5;
      }

      ((ReflectiveOperationException)var1).printStackTrace();
      return null;
   }
}
