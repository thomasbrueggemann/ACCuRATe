package com.facebook.common.internal;

import com.facebook.common.internal.ByteStreams;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Files {
   static byte[] readFile(InputStream var0, long var1) throws IOException {
      if(var1 > 2147483647L) {
         throw new OutOfMemoryError("file is too large to fit in a byte array: " + var1 + " bytes");
      } else {
         return var1 == 0L?ByteStreams.toByteArray(var0):ByteStreams.toByteArray(var0, (int)var1);
      }
   }

   public static byte[] toByteArray(File var0) throws IOException {
      Object var1 = null;
      boolean var9 = false;

      FileInputStream var2;
      try {
         var9 = true;
         var2 = new FileInputStream(var0);
         var9 = false;
      } finally {
         if(var9) {
            if(var1 != null) {
               ((FileInputStream)var1).close();
            }

         }
      }

      byte[] var4;
      try {
         var4 = readFile(var2, var2.getChannel().size());
      } finally {
         ;
      }

      if(var2 != null) {
         var2.close();
      }

      return var4;
   }
}
