package android.support.v4.os;

import android.os.Environment;
import android.os.Build.VERSION;
import android.support.v4.os.EnvironmentCompatKitKat;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class EnvironmentCompat {
   public static final String MEDIA_UNKNOWN = "unknown";
   private static final String TAG = "EnvironmentCompat";

   public static String getStorageState(File var0) {
      if(VERSION.SDK_INT >= 19) {
         return EnvironmentCompatKitKat.getStorageState(var0);
      } else {
         try {
            if(var0.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath())) {
               String var3 = Environment.getExternalStorageState();
               return var3;
            }
         } catch (IOException var4) {
            Log.w("EnvironmentCompat", "Failed to resolve canonical path: " + var4);
         }

         return "unknown";
      }
   }
}
