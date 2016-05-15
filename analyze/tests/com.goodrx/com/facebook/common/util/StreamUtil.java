package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {
   public static byte[] getBytesFromStream(InputStream var0) throws IOException {
      return getBytesFromStream(var0, var0.available());
   }

   public static byte[] getBytesFromStream(InputStream var0, final int var1) throws IOException {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream(var1) {
         public byte[] toByteArray() {
            return this.count == this.buf.length?this.buf:super.toByteArray();
         }
      };
      ByteStreams.copy(var0, var2);
      return var2.toByteArray();
   }

   public static long skip(InputStream var0, long var1) throws IOException {
      Preconditions.checkNotNull(var0);
      boolean var4;
      if(var1 >= 0L) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      long var5 = var1;

      while(var5 > 0L) {
         long var7 = var0.skip(var5);
         if(var7 > 0L) {
            var5 -= var7;
         } else {
            if(var0.read() == -1) {
               var1 -= var5;
               break;
            }

            --var5;
         }
      }

      return var1;
   }
}
