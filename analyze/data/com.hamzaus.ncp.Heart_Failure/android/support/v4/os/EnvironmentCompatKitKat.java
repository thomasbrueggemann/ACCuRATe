package android.support.v4.os;

import android.os.Environment;
import java.io.File;

class EnvironmentCompatKitKat {
   public static String getStorageState(File var0) {
      return Environment.getStorageState(var0);
   }
}
