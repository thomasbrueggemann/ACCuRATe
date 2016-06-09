package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import com.nostra13.universalimageloader.utils.class_52;
import java.io.File;
import java.io.IOException;

public final class StorageUtils {
   public static File getCacheDirectory(Context var0) {
      return getCacheDirectory(var0, true);
   }

   public static File getCacheDirectory(Context var0, boolean var1) {
      String var3;
      label30: {
         String var9;
         try {
            var9 = Environment.getExternalStorageState();
         } catch (NullPointerException var10) {
            var3 = "";
            break label30;
         } catch (IncompatibleClassChangeError var11) {
            var3 = "";
            break label30;
         }

         var3 = var9;
      }

      File var4 = null;
      if(var1) {
         boolean var6 = "mounted".equals(var3);
         var4 = null;
         if(var6) {
            boolean var7 = hasExternalStoragePermission(var0);
            var4 = null;
            if(var7) {
               var4 = getExternalCacheDir(var0);
            }
         }
      }

      if(var4 == null) {
         var4 = var0.getCacheDir();
      }

      if(var4 == null) {
         String var5 = "/data/data/" + var0.getPackageName() + "/cache/";
         class_52.method_333("Can\'t define system cache directory! \'%s\' will be used.", new Object[]{var5});
         var4 = new File(var5);
      }

      return var4;
   }

   private static File getExternalCacheDir(Context var0) {
      File var1 = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), var0.getPackageName()), "cache");
      if(!var1.exists()) {
         if(var1.mkdirs()) {
            try {
               (new File(var1, ".nomedia")).createNewFile();
               return var1;
            } catch (IOException var3) {
               class_52.method_332("Can\'t create \".nomedia\" file in application external cache directory", new Object[0]);
               return var1;
            }
         }

         class_52.method_333("Unable to create external cache directory", new Object[0]);
         var1 = null;
      }

      return var1;
   }

   public static File getIndividualCacheDirectory(Context var0) {
      return getIndividualCacheDirectory(var0, "uil-images");
   }

   public static File getIndividualCacheDirectory(Context var0, String var1) {
      File var2 = getCacheDirectory(var0);
      File var3 = new File(var2, var1);
      if(!var3.exists() && !var3.mkdir()) {
         var3 = var2;
      }

      return var3;
   }

   private static boolean hasExternalStoragePermission(Context var0) {
      return var0.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
   }
}
