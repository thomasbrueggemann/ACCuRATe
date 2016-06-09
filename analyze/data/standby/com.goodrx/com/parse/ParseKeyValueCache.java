package com.parse;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.PLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

class ParseKeyValueCache {
   static final int DEFAULT_MAX_KEY_VALUE_CACHE_BYTES = 2097152;
   static final int DEFAULT_MAX_KEY_VALUE_CACHE_FILES = 1000;
   private static final String DIR_NAME = "ParseKeyValueCache";
   private static final Object MUTEX_IO = new Object();
   private static final String TAG = "ParseKeyValueCache";
   private static File directory;
   static int maxKeyValueCacheBytes = 2097152;
   static int maxKeyValueCacheFiles = 1000;

   static void clearFromKeyValueCache(String param0) {
      // $FF: Couldn't be decompiled
   }

   static void clearKeyValueCacheDir() {
      // $FF: Couldn't be decompiled
   }

   private static File createKeyValueCacheFile(String var0) {
      String var1 = String.valueOf((new Date()).getTime()) + '.' + var0;
      return new File(getKeyValueCacheDir(), var1);
   }

   private static long getKeyValueCacheAge(File var0) {
      String var1 = var0.getName();

      try {
         long var3 = Long.parseLong(var1.substring(0, var1.indexOf(46)));
         return var3;
      } catch (NumberFormatException var5) {
         return 0L;
      }
   }

   private static File getKeyValueCacheDir() {
      if(directory != null && !directory.exists()) {
         directory.mkdir();
      }

      return directory;
   }

   private static File getKeyValueCacheFile(String var0) {
      final String var1 = '.' + var0;
      File[] var2 = getKeyValueCacheDir().listFiles(new FilenameFilter() {
         public boolean accept(File var1x, String var2) {
            return var2.endsWith(var1);
         }
      });
      return var2 != null && var2.length != 0?var2[0]:null;
   }

   static void initialize(Context var0) {
      initialize(new File(var0.getCacheDir(), "ParseKeyValueCache"));
   }

   static void initialize(File var0) {
      if(!var0.isDirectory() && !var0.mkdir()) {
         throw new RuntimeException("Could not create ParseKeyValueCache directory");
      } else {
         directory = var0;
      }
   }

   static JSONObject jsonFromKeyValueCache(String var0, long var1) {
      String var3 = loadFromKeyValueCache(var0, var1);
      if(var3 == null) {
         return null;
      } else {
         try {
            new JSONObject;
            JSONObject var6 = JSONObjectInstrumentation.init(var3);
            return var6;
         } catch (JSONException var7) {
            PLog.method_362("ParseKeyValueCache", "corrupted cache for " + var0, var7);
            clearFromKeyValueCache(var0);
            return null;
         }
      }
   }

   static String loadFromKeyValueCache(String param0, long param1) {
      // $FF: Couldn't be decompiled
   }

   static void saveToKeyValueCache(String param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   static int size() {
      File[] var0 = getKeyValueCacheDir().listFiles();
      return var0 == null?0:var0.length;
   }
}
