package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.NativeMemoryChunk;
import com.facebook.imagepipeline.memory.NativeMemoryChunkPool;
import com.facebook.imagepipeline.memory.NativePooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class NativePooledByteBufferOutputStream extends PooledByteBufferOutputStream {
   private CloseableReference<NativeMemoryChunk> mBufRef;
   private int mCount;
   private final NativeMemoryChunkPool mPool;

   public NativePooledByteBufferOutputStream(NativeMemoryChunkPool var1) {
      this(var1, var1.getMinBufferSize());
   }

   public NativePooledByteBufferOutputStream(NativeMemoryChunkPool var1, int var2) {
      boolean var3;
      if(var2 > 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      this.mPool = (NativeMemoryChunkPool)Preconditions.checkNotNull(var1);
      this.mCount = 0;
      this.mBufRef = CloseableReference.method_307(this.mPool.get(var2), this.mPool);
   }

   private void ensureValid() {
      if(!CloseableReference.isValid(this.mBufRef)) {
         throw new NativePooledByteBufferOutputStream.InvalidStreamException();
      }
   }

   public void close() {
      CloseableReference.closeSafely(this.mBufRef);
      this.mBufRef = null;
      this.mCount = -1;
      super.close();
   }

   @VisibleForTesting
   void realloc(int var1) {
      this.ensureValid();
      if(var1 > ((NativeMemoryChunk)this.mBufRef.get()).getSize()) {
         NativeMemoryChunk var2 = (NativeMemoryChunk)this.mPool.get(var1);
         ((NativeMemoryChunk)this.mBufRef.get()).copy(0, var2, 0, this.mCount);
         this.mBufRef.close();
         this.mBufRef = CloseableReference.method_307(var2, this.mPool);
      }
   }

   public int size() {
      return this.mCount;
   }

   public NativePooledByteBuffer toByteBuffer() {
      this.ensureValid();
      return new NativePooledByteBuffer(this.mBufRef, this.mCount);
   }

   public void write(int var1) throws IOException {
      byte[] var2 = new byte[]{(byte)var1};
      this.write(var2);
   }

   public void write(byte[] var1, int var2, int var3) throws IOException {
      if(var2 >= 0 && var3 >= 0 && var2 + var3 <= var1.length) {
         this.ensureValid();
         this.realloc(var3 + this.mCount);
         ((NativeMemoryChunk)this.mBufRef.get()).write(this.mCount, var1, var2, var3);
         this.mCount += var3;
      } else {
         throw new ArrayIndexOutOfBoundsException("length=" + var1.length + "; regionStart=" + var2 + "; regionLength=" + var3);
      }
   }

   public static class InvalidStreamException extends RuntimeException {
      public InvalidStreamException() {
         super("OutputStream no longer valid");
      }
   }
}
