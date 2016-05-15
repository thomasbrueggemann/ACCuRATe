package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompatApi21;
import android.support.v4.content.ContextCompatApi23;
import android.support.v4.content.ContextCompatFroyo;
import android.support.v4.content.ContextCompatHoneycomb;
import android.support.v4.content.ContextCompatJellybean;
import android.support.v4.content.ContextCompatKitKat;
import java.io.File;

public class ContextCompat {
   private static final String DIR_ANDROID = "Android";
   private static final String DIR_CACHE = "cache";
   private static final String DIR_DATA = "data";
   private static final String DIR_FILES = "files";
   private static final String DIR_OBB = "obb";
   private static final String TAG = "ContextCompat";

   private static File buildPath(File var0, String... var1) {
      int var2 = var1.length;
      int var3 = 0;

      File var4;
      File var6;
      for(var4 = var0; var3 < var2; var4 = var6) {
         String var5 = var1[var3];
         if(var4 == null) {
            var6 = new File(var5);
         } else if(var5 != null) {
            var6 = new File(var4, var5);
         } else {
            var6 = var4;
         }

         ++var3;
      }

      return var4;
   }

   public static int checkSelfPermission(@NonNull Context var0, @NonNull String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("permission is null");
      } else {
         return var0.checkPermission(var1, Process.myPid(), Process.myUid());
      }
   }

   private static File createFilesDir(File param0) {
      // $FF: Couldn't be decompiled
   }

   public static File getCodeCacheDir(Context var0) {
      return VERSION.SDK_INT >= 21?ContextCompatApi21.getCodeCacheDir(var0):createFilesDir(new File(var0.getApplicationInfo().dataDir, "code_cache"));
   }

   public static final int getColor(Context var0, int var1) {
      return VERSION.SDK_INT >= 23?ContextCompatApi23.getColor(var0, var1):var0.getResources().getColor(var1);
   }

   public static final ColorStateList getColorStateList(Context var0, int var1) {
      return VERSION.SDK_INT >= 23?ContextCompatApi23.getColorStateList(var0, var1):var0.getResources().getColorStateList(var1);
   }

   public static final Drawable getDrawable(Context var0, int var1) {
      return VERSION.SDK_INT >= 21?ContextCompatApi21.getDrawable(var0, var1):var0.getResources().getDrawable(var1);
   }

   public static File[] getExternalCacheDirs(Context var0) {
      int var1 = VERSION.SDK_INT;
      if(var1 >= 19) {
         return ContextCompatKitKat.getExternalCacheDirs(var0);
      } else {
         File var4;
         if(var1 >= 8) {
            var4 = ContextCompatFroyo.getExternalCacheDir(var0);
         } else {
            File var2 = Environment.getExternalStorageDirectory();
            String[] var3 = new String[]{"Android", "data", var0.getPackageName(), "cache"};
            var4 = buildPath(var2, var3);
         }

         return new File[]{var4};
      }
   }

   public static File[] getExternalFilesDirs(Context var0, String var1) {
      int var2 = VERSION.SDK_INT;
      if(var2 >= 19) {
         return ContextCompatKitKat.getExternalFilesDirs(var0, var1);
      } else {
         File var5;
         if(var2 >= 8) {
            var5 = ContextCompatFroyo.getExternalFilesDir(var0, var1);
         } else {
            File var3 = Environment.getExternalStorageDirectory();
            String[] var4 = new String[]{"Android", "data", var0.getPackageName(), "files", var1};
            var5 = buildPath(var3, var4);
         }

         return new File[]{var5};
      }
   }

   public static File[] getObbDirs(Context var0) {
      int var1 = VERSION.SDK_INT;
      if(var1 >= 19) {
         return ContextCompatKitKat.getObbDirs(var0);
      } else {
         File var4;
         if(var1 >= 11) {
            var4 = ContextCompatHoneycomb.getObbDir(var0);
         } else {
            File var2 = Environment.getExternalStorageDirectory();
            String[] var3 = new String[]{"Android", "obb", var0.getPackageName()};
            var4 = buildPath(var2, var3);
         }

         return new File[]{var4};
      }
   }

   public static boolean startActivities(Context var0, Intent[] var1) {
      return startActivities(var0, var1, (Bundle)null);
   }

   public static boolean startActivities(Context var0, Intent[] var1, Bundle var2) {
      int var3 = VERSION.SDK_INT;
      if(var3 >= 16) {
         ContextCompatJellybean.startActivities(var0, var1, var2);
         return true;
      } else if(var3 >= 11) {
         ContextCompatHoneycomb.startActivities(var0, var1);
         return true;
      } else {
         return false;
      }
   }

   public final File getNoBackupFilesDir(Context var1) {
      return VERSION.SDK_INT >= 21?ContextCompatApi21.getNoBackupFilesDir(var1):createFilesDir(new File(var1.getApplicationInfo().dataDir, "no_backup"));
   }
}
