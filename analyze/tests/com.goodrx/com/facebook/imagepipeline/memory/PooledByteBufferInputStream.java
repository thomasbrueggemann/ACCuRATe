package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class PooledByteBufferInputStream extends InputStream {
   @VisibleForTesting
   int mMark;
   @VisibleForTesting
   int mOffset;
   @VisibleForTesting
   final PooledByteBuffer mPooledByteBuffer;

   public PooledByteBufferInputStream(PooledByteBuffer var1) {
      boolean var2;
      if(!var1.isClosed()) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.mPooledByteBuffer = (PooledByteBuffer)Preconditions.checkNotNull(var1);
      this.mOffset = 0;
      this.mMark = 0;
   }

   public int available() {
      return this.mPooledByteBuffer.size() - this.mOffset;
   }

   public void mark(int var1) {
      this.mMark = this.mOffset;
   }

   public boolean markSupported() {
      return true;
   }

   public int read() {
      if(this.available() <= 0) {
         return -1;
      } else {
         PooledByteBuffer var1 = this.mPooledByteBuffer;
         int var2 = this.mOffset;
         this.mOffset = var2 + 1;
         return 255 & var1.read(var2);
      }
   }

   public int read(byte[] var1) {
      return this.read(var1, 0, var1.length);
   }

   public int read(byte[] var1, int var2, int var3) {
      if(var2 >= 0 && var3 >= 0 && var2 + var3 <= var1.length) {
         int var4 = this.available();
         if(var4 <= 0) {
            return -1;
         } else if(var3 <= 0) {
            return 0;
         } else {
            int var5 = Math.min(var4, var3);
            this.mPooledByteBuffer.read(this.mOffset, var1, var2, var5);
            this.mOffset += var5;
            return var5;
         }
      } else {
         throw new ArrayIndexOutOfBoundsException("length=" + var1.length + "; regionStart=" + var2 + "; regionLength=" + var3);
      }
   }

   public void reset() {
      this.mOffset = this.mMark;
   }

   public long skip(long var1) {
      boolean var3;
      if(var1 >= 0L) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      int var4 = Math.min((int)var1, this.available());
      this.mOffset += var4;
      return (long)var4;
   }
}
