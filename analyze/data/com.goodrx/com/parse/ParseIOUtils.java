package com.parse;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class ParseIOUtils {
   private static final int DEFAULT_BUFFER_SIZE = 4096;
   private static final int EOF = -1;
   private static final int SKIP_BUFFER_SIZE = 2048;
   private static byte[] SKIP_BYTE_BUFFER;

   public static void closeQuietly(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            return;
         }
      }

   }

   public static void closeQuietly(InputStream var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            return;
         }
      }

   }

   public static void closeQuietly(OutputStream var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            return;
         }
      }

   }

   public static int copy(InputStream var0, OutputStream var1) throws IOException {
      long var2 = copyLarge(var0, var1);
      return var2 > 2147483647L?-1:(int)var2;
   }

   public static long copyLarge(InputStream var0, OutputStream var1) throws IOException {
      return copyLarge(var0, var1, new byte[4096]);
   }

   public static long copyLarge(InputStream var0, OutputStream var1, long var2, long var4) throws IOException {
      return copyLarge(var0, var1, var2, var4, new byte[4096]);
   }

   public static long copyLarge(InputStream var0, OutputStream var1, long var2, long var4, byte[] var6) throws IOException {
      if(var2 > 0L) {
         skipFully(var0, var2);
      }

      long var9;
      if(var4 == 0L) {
         var9 = 0L;
      } else {
         int var7 = var6.length;
         int var8 = var7;
         if(var4 > 0L && var4 < (long)var7) {
            var8 = (int)var4;
         }

         var9 = 0L;

         while(var8 > 0) {
            int var11 = var0.read(var6, 0, var8);
            if(-1 == var11) {
               break;
            }

            var1.write(var6, 0, var11);
            var9 += (long)var11;
            if(var4 > 0L) {
               var8 = (int)Math.min(var4 - var9, (long)var7);
            }
         }
      }

      return var9;
   }

   public static long copyLarge(InputStream var0, OutputStream var1, byte[] var2) throws IOException {
      long var3 = 0L;

      while(true) {
         int var5 = var0.read(var2);
         if(-1 == var5) {
            return var3;
         }

         var1.write(var2, 0, var5);
         var3 += (long)var5;
      }
   }

   public static long skip(InputStream var0, long var1) throws IOException {
      if(var1 < 0L) {
         throw new IllegalArgumentException("Skip count must be non-negative, actual: " + var1);
      } else {
         if(SKIP_BYTE_BUFFER == null) {
            SKIP_BYTE_BUFFER = new byte[2048];
         }

         long var3;
         long var5;
         for(var3 = var1; var3 > 0L; var3 -= var5) {
            var5 = (long)var0.read(SKIP_BYTE_BUFFER, 0, (int)Math.min(var3, 2048L));
            if(var5 < 0L) {
               break;
            }
         }

         return var1 - var3;
      }
   }

   public static void skipFully(InputStream var0, long var1) throws IOException {
      if(var1 < 0L) {
         throw new IllegalArgumentException("Bytes to skip must not be negative: " + var1);
      } else {
         long var3 = skip(var0, var1);
         if(var3 != var1) {
            throw new EOFException("Bytes to skip: " + var1 + " actual: " + var3);
         }
      }
   }

   public static byte[] toByteArray(InputStream var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      copy(var0, var1);
      return var1.toByteArray();
   }
}
