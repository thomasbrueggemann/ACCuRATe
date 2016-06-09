package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils {
   public static void closeSilently(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (Exception var2) {
            return;
         }
      }

   }

   public static boolean copyStream(InputStream var0, OutputStream var1, IoUtils.CopyListener var2, int var3) throws IOException {
      int var4 = var0.available();
      if(var4 <= 0) {
         var4 = 512000;
      }

      byte[] var5 = new byte[var3];
      boolean var6 = shouldStopLoading(var2, 0, var4);
      int var7 = 0;
      if(var6) {
         return false;
      } else {
         do {
            int var8 = var0.read(var5, 0, var3);
            if(var8 == -1) {
               var1.flush();
               return true;
            }

            var1.write(var5, 0, var8);
            var7 += var8;
         } while(!shouldStopLoading(var2, var7, var4));

         return false;
      }
   }

   public static void readAndCloseStream(InputStream var0) {
      byte[] var1 = new byte['耀'];

      int var4;
      do {
         boolean var7 = false;

         try {
            var7 = true;
            var4 = var0.read(var1, 0, '耀');
            var7 = false;
            continue;
         } catch (IOException var8) {
            var7 = false;
         } finally {
            if(var7) {
               closeSilently(var0);
            }
         }

         closeSilently(var0);
         return;
      } while(var4 != -1);

      closeSilently(var0);
   }

   private static boolean shouldStopLoading(IoUtils.CopyListener var0, int var1, int var2) {
      return var0 != null && !var0.onBytesCopied(var1, var2) && var1 * 100 / var2 < 75;
   }

   public interface CopyListener {
      boolean onBytesCopied(int var1, int var2);
   }
}
