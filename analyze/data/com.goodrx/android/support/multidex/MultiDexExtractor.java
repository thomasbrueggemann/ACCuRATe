package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.support.multidex.ZipUtil;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class MultiDexExtractor {
   private static final int BUFFER_SIZE = 16384;
   private static final String DEX_PREFIX = "classes";
   private static final String DEX_SUFFIX = ".dex";
   private static final String EXTRACTED_NAME_EXT = ".classes";
   private static final String EXTRACTED_SUFFIX = ".zip";
   private static final String KEY_CRC = "crc";
   private static final String KEY_DEX_NUMBER = "dex.number";
   private static final String KEY_TIME_STAMP = "timestamp";
   private static final int MAX_EXTRACT_ATTEMPTS = 3;
   private static final long NO_VALUE = -1L;
   private static final String PREFS_FILE = "multidex.version";
   private static final String TAG = "MultiDex";
   private static Method sApplyMethod;

   static {
      try {
         sApplyMethod = Editor.class.getMethod("apply", new Class[0]);
      } catch (NoSuchMethodException var1) {
         sApplyMethod = null;
      }
   }

   private static void apply(Editor var0) {
      if(sApplyMethod != null) {
         try {
            sApplyMethod.invoke(var0, new Object[0]);
            return;
         } catch (InvocationTargetException var4) {
            ;
         } catch (IllegalAccessException var5) {
            ;
         }
      }

      var0.commit();
   }

   private static void closeQuietly(Closeable var0) {
      try {
         var0.close();
      } catch (IOException var2) {
         Log.w("MultiDex", "Failed to close resource", var2);
      }
   }

   private static void extract(ZipFile param0, ZipEntry param1, File param2, String param3) throws IOException, FileNotFoundException {
      // $FF: Couldn't be decompiled
   }

   private static SharedPreferences getMultiDexPreferences(Context var0) {
      byte var1;
      if(VERSION.SDK_INT < 11) {
         var1 = 0;
      } else {
         var1 = 4;
      }

      return var0.getSharedPreferences("multidex.version", var1);
   }

   private static long getTimeStamp(File var0) {
      long var1 = var0.lastModified();
      if(var1 == -1L) {
         --var1;
      }

      return var1;
   }

   private static long getZipCrc(File var0) throws IOException {
      long var1 = ZipUtil.getZipCrc(var0);
      if(var1 == -1L) {
         --var1;
      }

      return var1;
   }

   private static boolean isModified(Context var0, File var1, long var2) {
      SharedPreferences var4 = getMultiDexPreferences(var0);
      return var4.getLong("timestamp", -1L) != getTimeStamp(var1) || var4.getLong("crc", -1L) != var2;
   }

   static List<File> load(Context var0, ApplicationInfo var1, File var2, boolean var3) throws IOException {
      Log.i("MultiDex", "MultiDexExtractor.load(" + var1.sourceDir + ", " + var3 + ")");
      File var5 = new File(var1.sourceDir);
      long var6 = getZipCrc(var5);
      List var9;
      if(!var3 && !isModified(var0, var5, var6)) {
         label15: {
            List var13;
            try {
               var13 = loadExistingExtractions(var0, var5, var2);
            } catch (IOException var14) {
               Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", var14);
               var9 = performExtractions(var5, var2);
               putStoredApkInfo(var0, getTimeStamp(var5), var6, 1 + var9.size());
               break label15;
            }

            var9 = var13;
         }
      } else {
         Log.i("MultiDex", "Detected that extraction must be performed.");
         var9 = performExtractions(var5, var2);
         putStoredApkInfo(var0, getTimeStamp(var5), var6, 1 + var9.size());
      }

      Log.i("MultiDex", "load found " + var9.size() + " secondary dex files");
      return var9;
   }

   private static List<File> loadExistingExtractions(Context var0, File var1, File var2) throws IOException {
      Log.i("MultiDex", "loading existing secondary dex files");
      String var4 = var1.getName() + ".classes";
      int var5 = getMultiDexPreferences(var0).getInt("dex.number", 1);
      ArrayList var6 = new ArrayList(var5);

      for(int var7 = 2; var7 <= var5; ++var7) {
         File var8 = new File(var2, var4 + var7 + ".zip");
         if(!var8.isFile()) {
            throw new IOException("Missing extracted secondary dex file \'" + var8.getPath() + "\'");
         }

         var6.add(var8);
         if(!verifyZipFile(var8)) {
            Log.i("MultiDex", "Invalid zip file: " + var8);
            throw new IOException("Invalid ZIP file.");
         }
      }

      return var6;
   }

   private static void mkdirChecked(File var0) throws IOException {
      var0.mkdir();
      if(!var0.isDirectory()) {
         File var2 = var0.getParentFile();
         if(var2 == null) {
            Log.e("MultiDex", "Failed to create dir " + var0.getPath() + ". Parent file is null.");
         } else {
            Log.e("MultiDex", "Failed to create dir " + var0.getPath() + ". parent file is a dir " + var2.isDirectory() + ", a file " + var2.isFile() + ", exists " + var2.exists() + ", readable " + var2.canRead() + ", writable " + var2.canWrite());
         }

         throw new IOException("Failed to create cache directory " + var0.getPath());
      }
   }

   private static List<File> performExtractions(File param0, File param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private static void prepareDexDir(File var0, final String var1) throws IOException {
      mkdirChecked(var0.getParentFile());
      mkdirChecked(var0);
      File[] var2 = var0.listFiles(new FileFilter() {
         public boolean accept(File var1x) {
            return !var1x.getName().startsWith(var1);
         }
      });
      if(var2 == null) {
         Log.w("MultiDex", "Failed to list secondary dex dir content (" + var0.getPath() + ").");
      } else {
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            File var5 = var2[var4];
            Log.i("MultiDex", "Trying to delete old file " + var5.getPath() + " of size " + var5.length());
            if(!var5.delete()) {
               Log.w("MultiDex", "Failed to delete old file " + var5.getPath());
            } else {
               Log.i("MultiDex", "Deleted old file " + var5.getPath());
            }
         }
      }

   }

   private static void putStoredApkInfo(Context var0, long var1, long var3, int var5) {
      Editor var6 = getMultiDexPreferences(var0).edit();
      var6.putLong("timestamp", var1);
      var6.putLong("crc", var3);
      var6.putInt("dex.number", var5);
      apply(var6);
   }

   static boolean verifyZipFile(File param0) {
      // $FF: Couldn't be decompiled
   }
}
