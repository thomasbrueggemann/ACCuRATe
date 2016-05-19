package com.comscore.utils;

import android.content.Context;
import com.comscore.analytics.Core;
import com.comscore.utils.CSLog;
import com.comscore.utils.Storage;
import com.comscore.utils.Utils;
import com.comscore.utils.class_19;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtils {
   public static boolean deleteFile(Core var0, String var1) {
      Context var2 = var0.getAppContext();
      Storage var3 = var0.getStorage();
      boolean var4 = var2.deleteFile(var1);
      if(var4) {
         CSLog.method_371(FileUtils.class, "File" + var1 + " was removed");
         var3.remove(var1);
      }

      return var4;
   }

   public static ArrayList<String> getFileList(Context var0) {
      File var1 = var0.getFilesDir();
      String[] var2 = null;
      if(var1 != null) {
         boolean var3 = var1.isDirectory();
         var2 = null;
         if(var3) {
            var2 = var1.list(new class_19());
            if(var2 != null) {
               Arrays.sort(var2);
            } else {
               var2 = new String[0];
            }
         }
      }

      return new ArrayList(Arrays.asList(var2));
   }

   public static String[] readCachedEvents(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static void writeEvent(Core var0, String var1, int var2, String var3) {
      Context var4 = var0.getAppContext();
      Storage var5 = var0.getStorage();
      FileOutputStream var6 = null;
      int var7 = Utils.getInteger(var5.get(var1), 0);

      try {
         var6 = var4.openFileOutput(var1, var2);
         var6.write(var3.getBytes());
         var5.set(var1, String.valueOf(var7 + 1));
         return;
      } catch (Exception var19) {
         CSLog.method_373(FileUtils.class, "Exception in writeEvent:" + var19.getLocalizedMessage());
         CSLog.printStackTrace(var19);
      } finally {
         if(var6 != null) {
            try {
               var6.close();
            } catch (IOException var18) {
               CSLog.printStackTrace(var18);
            }
         }

      }

   }
}
