package com.parse;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.ParseIOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

class ParseFileUtils {
   private static final long FILE_COPY_BUFFER_SIZE = 31457280L;
   public static final long ONE_KB = 1024L;
   public static final long ONE_MB = 1048576L;

   public static void cleanDirectory(File var0) throws IOException {
      if(!var0.exists()) {
         throw new IllegalArgumentException(var0 + " does not exist");
      } else if(!var0.isDirectory()) {
         throw new IllegalArgumentException(var0 + " is not a directory");
      } else {
         File[] var1 = var0.listFiles();
         if(var1 == null) {
            throw new IOException("Failed to list contents of " + var0);
         } else {
            IOException var2 = null;
            int var3 = var1.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               File var5 = var1[var4];

               try {
                  forceDelete(var5);
               } catch (IOException var7) {
                  var2 = var7;
               }
            }

            if(var2 != null) {
               throw var2;
            }
         }
      }
   }

   public static void copyFile(File var0, File var1) throws IOException {
      copyFile(var0, var1, true);
   }

   public static void copyFile(File var0, File var1, boolean var2) throws IOException {
      if(var0 == null) {
         throw new NullPointerException("Source must not be null");
      } else if(var1 == null) {
         throw new NullPointerException("Destination must not be null");
      } else if(!var0.exists()) {
         throw new FileNotFoundException("Source \'" + var0 + "\' does not exist");
      } else if(var0.isDirectory()) {
         throw new IOException("Source \'" + var0 + "\' exists but is a directory");
      } else if(var0.getCanonicalPath().equals(var1.getCanonicalPath())) {
         throw new IOException("Source \'" + var0 + "\' and destination \'" + var1 + "\' are the same");
      } else {
         File var3 = var1.getParentFile();
         if(var3 != null && !var3.mkdirs() && !var3.isDirectory()) {
            throw new IOException("Destination \'" + var3 + "\' directory cannot be created");
         } else if(var1.exists() && !var1.canWrite()) {
            throw new IOException("Destination \'" + var1 + "\' exists but is read-only");
         } else {
            doCopyFile(var0, var1, var2);
         }
      }
   }

   public static void deleteDirectory(File var0) throws IOException {
      if(var0.exists()) {
         if(!isSymlink(var0)) {
            cleanDirectory(var0);
         }

         if(!var0.delete()) {
            throw new IOException("Unable to delete directory " + var0 + ".");
         }
      }

   }

   public static boolean deleteQuietly(File var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            if(var0.isDirectory()) {
               cleanDirectory(var0);
            }
         } catch (Exception var5) {
            ;
         }

         try {
            boolean var3 = var0.delete();
            return var3;
         } catch (Exception var4) {
            return false;
         }
      }
   }

   private static void doCopyFile(File param0, File param1, boolean param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public static void forceDelete(File var0) throws IOException {
      if(var0.isDirectory()) {
         deleteDirectory(var0);
      } else {
         boolean var1 = var0.exists();
         if(!var0.delete()) {
            if(!var1) {
               throw new FileNotFoundException("File does not exist: " + var0);
            }

            throw new IOException("Unable to delete file: " + var0);
         }
      }

   }

   public static boolean isSymlink(File var0) throws IOException {
      if(var0 == null) {
         throw new NullPointerException("File must not be null");
      } else {
         File var1;
         if(var0.getParent() == null) {
            var1 = var0;
         } else {
            var1 = new File(var0.getParentFile().getCanonicalFile(), var0.getName());
         }

         return !var1.getCanonicalFile().equals(var1.getAbsoluteFile());
      }
   }

   public static void moveFile(File var0, File var1) throws IOException {
      if(var0 == null) {
         throw new NullPointerException("Source must not be null");
      } else if(var1 == null) {
         throw new NullPointerException("Destination must not be null");
      } else if(!var0.exists()) {
         throw new FileNotFoundException("Source \'" + var0 + "\' does not exist");
      } else if(var0.isDirectory()) {
         throw new IOException("Source \'" + var0 + "\' is a directory");
      } else if(var1.exists()) {
         throw new IOException("Destination \'" + var1 + "\' already exists");
      } else if(var1.isDirectory()) {
         throw new IOException("Destination \'" + var1 + "\' is a directory");
      } else {
         if(!var0.renameTo(var1)) {
            copyFile(var0, var1);
            if(!var0.delete()) {
               deleteQuietly(var1);
               throw new IOException("Failed to delete original file \'" + var0 + "\' after copy to \'" + var1 + "\'");
            }
         }

      }
   }

   public static FileInputStream openInputStream(File var0) throws IOException {
      if(var0.exists()) {
         if(var0.isDirectory()) {
            throw new IOException("File \'" + var0 + "\' exists but is a directory");
         } else if(!var0.canRead()) {
            throw new IOException("File \'" + var0 + "\' cannot be read");
         } else {
            return new FileInputStream(var0);
         }
      } else {
         throw new FileNotFoundException("File \'" + var0 + "\' does not exist");
      }
   }

   public static FileOutputStream openOutputStream(File var0) throws IOException {
      if(var0.exists()) {
         if(var0.isDirectory()) {
            throw new IOException("File \'" + var0 + "\' exists but is a directory");
         }

         if(!var0.canWrite()) {
            throw new IOException("File \'" + var0 + "\' cannot be written to");
         }
      } else {
         File var1 = var0.getParentFile();
         if(var1 != null && !var1.exists() && !var1.mkdirs()) {
            throw new IOException("File \'" + var0 + "\' could not be created");
         }
      }

      return new FileOutputStream(var0);
   }

   public static byte[] readFileToByteArray(File var0) throws IOException {
      FileInputStream var1 = null;

      byte[] var3;
      try {
         var1 = openInputStream(var0);
         var3 = ParseIOUtils.toByteArray(var1);
      } finally {
         ParseIOUtils.closeQuietly((InputStream)var1);
      }

      return var3;
   }

   public static JSONObject readFileToJSONObject(File var0) throws IOException, JSONException {
      String var1 = readFileToString(var0, "UTF-8");
      new JSONObject;
      return JSONObjectInstrumentation.init(var1);
   }

   public static String readFileToString(File var0, String var1) throws IOException {
      return readFileToString(var0, Charset.forName(var1));
   }

   public static String readFileToString(File var0, Charset var1) throws IOException {
      return new String(readFileToByteArray(var0), var1);
   }

   public static void writeByteArrayToFile(File var0, byte[] var1) throws IOException {
      FileOutputStream var2 = null;

      try {
         var2 = openOutputStream(var0);
         var2.write(var1);
      } finally {
         ParseIOUtils.closeQuietly((OutputStream)var2);
      }

   }

   public static void writeJSONObjectToFile(File var0, JSONObject var1) throws IOException {
      String var2;
      if(!(var1 instanceof JSONObject)) {
         var2 = var1.toString();
      } else {
         var2 = JSONObjectInstrumentation.toString((JSONObject)var1);
      }

      writeByteArrayToFile(var0, var2.getBytes(Charset.forName("UTF-8")));
   }

   public static void writeStringToFile(File var0, String var1, String var2) throws IOException {
      writeStringToFile(var0, var1, Charset.forName(var2));
   }

   public static void writeStringToFile(File var0, String var1, Charset var2) throws IOException {
      writeByteArrayToFile(var0, var1.getBytes(var2));
   }
}
