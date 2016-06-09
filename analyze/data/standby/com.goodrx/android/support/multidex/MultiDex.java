package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.multidex.MultiDexExtractor;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class MultiDex {
   private static final boolean IS_VM_MULTIDEX_CAPABLE = false;
   private static final int MAX_SUPPORTED_SDK_VERSION = 20;
   private static final int MIN_SDK_VERSION = 4;
   private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
   private static final String SECONDARY_FOLDER_NAME;
   static final String TAG = "MultiDex";
   private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
   private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
   private static final Set<String> installedApk;

   static {
      SECONDARY_FOLDER_NAME = "code_cache" + File.separator + "secondary-dexes";
      installedApk = new HashSet();
      IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
   }

   private static boolean checkValidZipFiles(List<File> var0) {
      Iterator var1 = var0.iterator();

      do {
         if(!var1.hasNext()) {
            return true;
         }
      } while(MultiDexExtractor.verifyZipFile((File)var1.next()));

      return false;
   }

   private static void clearOldDexDir(Context var0) throws Exception {
      File var1 = new File(var0.getFilesDir(), "secondary-dexes");
      if(var1.isDirectory()) {
         Log.i("MultiDex", "Clearing old secondary dex dir (" + var1.getPath() + ").");
         File[] var3 = var1.listFiles();
         if(var3 != null) {
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               File var8 = var3[var5];
               Log.i("MultiDex", "Trying to delete old file " + var8.getPath() + " of size " + var8.length());
               if(!var8.delete()) {
                  Log.w("MultiDex", "Failed to delete old file " + var8.getPath());
               } else {
                  Log.i("MultiDex", "Deleted old file " + var8.getPath());
               }
            }

            if(!var1.delete()) {
               Log.w("MultiDex", "Failed to delete secondary dex dir " + var1.getPath());
               return;
            }

            Log.i("MultiDex", "Deleted old secondary dex dir " + var1.getPath());
            return;
         }

         Log.w("MultiDex", "Failed to list secondary dex dir content (" + var1.getPath() + ").");
      }

   }

   private static void expandFieldArray(Object var0, String var1, Object[] var2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
      Field var3 = findField(var0, var1);
      Object[] var4 = (Object[])((Object[])var3.get(var0));
      Object[] var5 = (Object[])((Object[])Array.newInstance(var4.getClass().getComponentType(), var4.length + var2.length));
      System.arraycopy(var4, 0, var5, 0, var4.length);
      System.arraycopy(var2, 0, var5, var4.length, var2.length);
      var3.set(var0, var5);
   }

   private static Field findField(Object var0, String var1) throws NoSuchFieldException {
      Class var2 = var0.getClass();

      while(var2 != null) {
         try {
            Field var4 = var2.getDeclaredField(var1);
            if(!var4.isAccessible()) {
               var4.setAccessible(true);
            }

            return var4;
         } catch (NoSuchFieldException var5) {
            var2 = var2.getSuperclass();
         }
      }

      throw new NoSuchFieldException("Field " + var1 + " not found in " + var0.getClass());
   }

   private static Method findMethod(Object var0, String var1, Class... var2) throws NoSuchMethodException {
      Class var3 = var0.getClass();

      while(var3 != null) {
         try {
            Method var5 = var3.getDeclaredMethod(var1, var2);
            if(!var5.isAccessible()) {
               var5.setAccessible(true);
            }

            return var5;
         } catch (NoSuchMethodException var6) {
            var3 = var3.getSuperclass();
         }
      }

      throw new NoSuchMethodException("Method " + var1 + " with parameters " + Arrays.asList(var2) + " not found in " + var0.getClass());
   }

   private static ApplicationInfo getApplicationInfo(Context var0) throws NameNotFoundException {
      PackageManager var3;
      String var4;
      try {
         var3 = var0.getPackageManager();
         var4 = var0.getPackageName();
      } catch (RuntimeException var5) {
         Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", var5);
         return null;
      }

      return var3 != null && var4 != null?var3.getApplicationInfo(var4, 128):null;
   }

   public static void install(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private static void installSecondaryDexes(ClassLoader var0, File var1, List<File> var2) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
      if(!var2.isEmpty()) {
         if(VERSION.SDK_INT < 19) {
            if(VERSION.SDK_INT >= 14) {
               MultiDex.V14.install(var0, var2, var1);
               return;
            }

            MultiDex.class_104.install(var0, var2);
            return;
         }

         MultiDex.V19.install(var0, var2, var1);
      }

   }

   static boolean isVMMultidexCapable(String var0) {
      boolean var1 = false;
      if(var0 != null) {
         Matcher var5 = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(var0);
         boolean var6 = var5.matches();
         var1 = false;
         if(var6) {
            label39: {
               int var8;
               int var9;
               try {
                  var8 = Integer.parseInt(var5.group(1));
                  var9 = Integer.parseInt(var5.group(2));
               } catch (NumberFormatException var10) {
                  var1 = false;
                  break label39;
               }

               if(var8 <= 2 && (var8 != 2 || var9 < 1)) {
                  var1 = false;
               } else {
                  var1 = true;
               }
            }
         }
      }

      StringBuilder var2 = (new StringBuilder()).append("VM with version ").append(var0);
      String var3;
      if(var1) {
         var3 = " has multidex support";
      } else {
         var3 = " does not have multidex support";
      }

      Log.i("MultiDex", var2.append(var3).toString());
      return var1;
   }

   private static final class V14 {
      private static void install(ClassLoader var0, List<File> var1, File var2) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
         Object var3 = MultiDex.findField(var0, "pathList").get(var0);
         MultiDex.expandFieldArray(var3, "dexElements", makeDexElements(var3, new ArrayList(var1), var2));
      }

      private static Object[] makeDexElements(Object var0, ArrayList<File> var1, File var2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
         return (Object[])((Object[])MultiDex.findMethod(var0, "makeDexElements", new Class[]{ArrayList.class, File.class}).invoke(var0, new Object[]{var1, var2}));
      }
   }

   private static final class V19 {
      private static void install(ClassLoader var0, List<File> var1, File var2) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
         Object var3 = MultiDex.findField(var0, "pathList").get(var0);
         ArrayList var4 = new ArrayList();
         MultiDex.expandFieldArray(var3, "dexElements", makeDexElements(var3, new ArrayList(var1), var2, var4));
         if(var4.size() > 0) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               Log.w("MultiDex", "Exception in makeDexElement", (IOException)var5.next());
            }

            Field var6 = MultiDex.findField(var0, "dexElementsSuppressedExceptions");
            IOException[] var7 = (IOException[])((IOException[])var6.get(var0));
            IOException[] var10;
            if(var7 == null) {
               var10 = (IOException[])var4.toArray(new IOException[var4.size()]);
            } else {
               IOException[] var8 = new IOException[var4.size() + var7.length];
               var4.toArray(var8);
               System.arraycopy(var7, 0, var8, var4.size(), var7.length);
               var10 = var8;
            }

            var6.set(var0, var10);
         }

      }

      private static Object[] makeDexElements(Object var0, ArrayList<File> var1, File var2, ArrayList<IOException> var3) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
         return (Object[])((Object[])MultiDex.findMethod(var0, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(var0, new Object[]{var1, var2, var3}));
      }
   }

   private static final class class_104 {
      private static void install(ClassLoader var0, List<File> var1) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
         int var2 = var1.size();
         Field var3 = MultiDex.findField(var0, "path");
         StringBuilder var4 = new StringBuilder((String)var3.get(var0));
         String[] var5 = new String[var2];
         File[] var6 = new File[var2];
         ZipFile[] var7 = new ZipFile[var2];
         DexFile[] var8 = new DexFile[var2];

         String var11;
         int var13;
         for(ListIterator var9 = var1.listIterator(); var9.hasNext(); var8[var13] = DexFile.loadDex(var11, var11 + ".dex", 0)) {
            File var10 = (File)var9.next();
            var11 = var10.getAbsolutePath();
            var4.append(':').append(var11);
            var13 = var9.previousIndex();
            var5[var13] = var11;
            var6[var13] = var10;
            var7[var13] = new ZipFile(var10);
         }

         var3.set(var0, var4.toString());
         MultiDex.expandFieldArray(var0, "mPaths", var5);
         MultiDex.expandFieldArray(var0, "mFiles", var6);
         MultiDex.expandFieldArray(var0, "mZips", var7);
         MultiDex.expandFieldArray(var0, "mDexs", var8);
      }
   }
}
