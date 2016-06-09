package com.facebook.common.internal;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class ByteStreams {
   private static final int BUF_SIZE = 4096;

   public static long copy(InputStream var0, OutputStream var1) throws IOException {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      byte[] var4 = new byte[4096];
      long var5 = 0L;

      while(true) {
         int var7 = var0.read(var4);
         if(var7 == -1) {
            return var5;
         }

         var1.write(var4, 0, var7);
         var5 += (long)var7;
      }
   }

   public static int read(InputStream var0, byte[] var1, int var2, int var3) throws IOException {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      if(var3 < 0) {
         throw new IndexOutOfBoundsException("len is negative");
      } else {
         int var6;
         int var7;
         for(var6 = 0; var6 < var3; var6 += var7) {
            var7 = var0.read(var1, var2 + var6, var3 - var6);
            if(var7 == -1) {
               break;
            }
         }

         return var6;
      }
   }

   public static void readFully(InputStream var0, byte[] var1, int var2, int var3) throws IOException {
      int var4 = read(var0, var1, var2, var3);
      if(var4 != var3) {
         throw new EOFException("reached end of stream after reading " + var4 + " bytes; " + var3 + " bytes expected");
      }
   }

   public static byte[] toByteArray(InputStream var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      copy(var0, var1);
      return var1.toByteArray();
   }

   public static byte[] toByteArray(InputStream var0, int var1) throws IOException {
      byte[] var2 = new byte[var1];
      int var3 = var1;

      while(true) {
         if(var3 <= 0) {
            int var4 = var0.read();
            if(var4 != -1) {
               ByteStreams.FastByteArrayOutputStream var5 = new ByteStreams.FastByteArrayOutputStream();
               var5.write(var4);
               copy(var0, var5);
               byte[] var8 = new byte[var2.length + var5.size()];
               System.arraycopy(var2, 0, var8, 0, var2.length);
               var5.writeTo(var8, var2.length);
               return var8;
            }
            break;
         }

         int var9 = var1 - var3;
         int var10 = var0.read(var2, var9, var3);
         if(var10 == -1) {
            var2 = Arrays.copyOf(var2, var9);
            break;
         }

         var3 -= var10;
      }

      return var2;
   }

   private static final class FastByteArrayOutputStream extends ByteArrayOutputStream {
      private FastByteArrayOutputStream() {
      }

      // $FF: synthetic method
      FastByteArrayOutputStream(Object var1) {
         this();
      }

      void writeTo(byte[] var1, int var2) {
         System.arraycopy(this.buf, 0, var1, var2, this.count);
      }
   }
}
