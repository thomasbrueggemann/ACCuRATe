package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.NativeMemoryChunkPool;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.NativePooledByteBufferOutputStream;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBufferFactory implements PooledByteBufferFactory {
   private final NativeMemoryChunkPool mPool;
   private final PooledByteStreams mPooledByteStreams;

   public NativePooledByteBufferFactory(NativeMemoryChunkPool var1, PooledByteStreams var2) {
      this.mPool = var1;
      this.mPooledByteStreams = var2;
   }

   @VisibleForTesting
   NativePooledByteBuffer newByteBuf(InputStream var1, NativePooledByteBufferOutputStream var2) throws IOException {
      this.mPooledByteStreams.copy(var1, var2);
      return var2.toByteBuffer();
   }

   public NativePooledByteBuffer newByteBuffer(int var1) {
      boolean var2;
      if(var1 > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      CloseableReference var3 = CloseableReference.method_307(this.mPool.get(var1), this.mPool);

      NativePooledByteBuffer var4;
      try {
         var4 = new NativePooledByteBuffer(var3, var1);
      } finally {
         var3.close();
      }

      return var4;
   }

   public NativePooledByteBuffer newByteBuffer(InputStream var1) throws IOException {
      NativePooledByteBufferOutputStream var2 = new NativePooledByteBufferOutputStream(this.mPool);

      NativePooledByteBuffer var4;
      try {
         var4 = this.newByteBuf(var1, var2);
      } finally {
         var2.close();
      }

      return var4;
   }

   public NativePooledByteBuffer newByteBuffer(InputStream var1, int var2) throws IOException {
      NativePooledByteBufferOutputStream var3 = new NativePooledByteBufferOutputStream(this.mPool, var2);

      NativePooledByteBuffer var5;
      try {
         var5 = this.newByteBuf(var1, var3);
      } finally {
         var3.close();
      }

      return var5;
   }

   public NativePooledByteBuffer newByteBuffer(byte[] var1) {
      NativePooledByteBufferOutputStream var2 = new NativePooledByteBufferOutputStream(this.mPool, var1.length);

      NativePooledByteBuffer var5;
      try {
         var2.write(var1, 0, var1.length);
         var5 = var2.toByteBuffer();
      } catch (IOException var8) {
         throw Throwables.propagate(var8);
      } finally {
         var2.close();
      }

      return var5;
   }

   public NativePooledByteBufferOutputStream newOutputStream() {
      return new NativePooledByteBufferOutputStream(this.mPool);
   }

   public NativePooledByteBufferOutputStream newOutputStream(int var1) {
      return new NativePooledByteBufferOutputStream(this.mPool, var1);
   }
}
