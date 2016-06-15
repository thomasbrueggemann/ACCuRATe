package android.support.v4.content;

import android.content.Context;
import java.io.File;

class ContextCompatKitKat {
   public static File[] getExternalCacheDirs(Context var0) {
      return var0.getExternalCacheDirs();
   }

   public static File[] getExternalFilesDirs(Context var0, String var1) {
      return var0.getExternalFilesDirs(var1);
   }

   public static File[] getObbDirs(Context var0) {
      return var0.getObbDirs();
   }
}
