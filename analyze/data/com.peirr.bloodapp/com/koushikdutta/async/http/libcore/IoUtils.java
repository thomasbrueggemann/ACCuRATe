package com.koushikdutta.async.http.libcore;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

class IoUtils {
   static void closeQuietly(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (RuntimeException var3) {
            throw var3;
         } catch (Exception var4) {
            return;
         }
      }

   }

   static void deleteContents(File var0) throws IOException {
      File[] var1 = var0.listFiles();
      if(var1 == null) {
         throw new IllegalArgumentException("not a directory: " + var0);
      } else {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            File var4 = var1[var3];
            if(var4.isDirectory()) {
               deleteContents(var4);
            }

            if(!var4.delete()) {
               throw new IOException("failed to delete file: " + var4);
            }
         }

      }
   }
}
