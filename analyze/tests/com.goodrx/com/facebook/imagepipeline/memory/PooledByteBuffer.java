package com.facebook.imagepipeline.memory;

import java.io.Closeable;

public interface PooledByteBuffer extends Closeable {
   void close();

   long getNativePtr();

   boolean isClosed();

   byte read(int var1);

   void read(int var1, byte[] var2, int var3, int var4);

   int size();

   public static class ClosedException extends RuntimeException {
      public ClosedException() {
         super("Invalid bytebuf. Already closed");
      }
   }
}
