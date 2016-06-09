package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

class StreamProcessor {
   public static int readPackedInt(InputStream var0, int var1, boolean var2) throws IOException {
      int var3 = 0;

      for(int var4 = 0; var4 < var1; ++var4) {
         int var5 = var0.read();
         if(var5 == -1) {
            throw new IOException("no more bytes");
         }

         if(var2) {
            var3 |= (var5 & 255) << var4 * 8;
         } else {
            var3 = var3 << 8 | var5 & 255;
         }
      }

      return var3;
   }
}
