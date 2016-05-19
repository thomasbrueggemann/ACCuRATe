package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class PooledByteArrayBufferedInputStream extends InputStream {
   private static final String TAG = "PooledByteInputStream";
   private int mBufferOffset;
   private int mBufferedSize;
   private final byte[] mByteArray;
   private boolean mClosed;
   private final InputStream mInputStream;
   private final ResourceReleaser<byte[]> mResourceReleaser;

   public PooledByteArrayBufferedInputStream(InputStream var1, byte[] var2, ResourceReleaser<byte[]> var3) {
      this.mInputStream = (InputStream)Preconditions.checkNotNull(var1);
      this.mByteArray = (byte[])Preconditions.checkNotNull(var2);
      this.mResourceReleaser = (ResourceReleaser)Preconditions.checkNotNull(var3);
      this.mBufferedSize = 0;
      this.mBufferOffset = 0;
      this.mClosed = false;
   }

   private boolean ensureDataInBuffer() throws IOException {
      if(this.mBufferOffset < this.mBufferedSize) {
         return true;
      } else {
         int var1 = this.mInputStream.read(this.mByteArray);
         if(var1 <= 0) {
            return false;
         } else {
            this.mBufferedSize = var1;
            this.mBufferOffset = 0;
            return true;
         }
      }
   }

   private void ensureNotClosed() throws IOException {
      if(this.mClosed) {
         throw new IOException("stream already closed");
      }
   }

   public int available() throws IOException {
      boolean var1;
      if(this.mBufferOffset <= this.mBufferedSize) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkState(var1);
      this.ensureNotClosed();
      return this.mBufferedSize - this.mBufferOffset + this.mInputStream.available();
   }

   public void close() throws IOException {
      if(!this.mClosed) {
         this.mClosed = true;
         this.mResourceReleaser.release(this.mByteArray);
         super.close();
      }

   }

   protected void finalize() throws Throwable {
      if(!this.mClosed) {
         FLog.method_397("PooledByteInputStream", "Finalized without closing");
         this.close();
      }

      super.finalize();
   }

   public int read() throws IOException {
      boolean var1;
      if(this.mBufferOffset <= this.mBufferedSize) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkState(var1);
      this.ensureNotClosed();
      if(!this.ensureDataInBuffer()) {
         return -1;
      } else {
         byte[] var2 = this.mByteArray;
         int var3 = this.mBufferOffset;
         this.mBufferOffset = var3 + 1;
         return 255 & var2[var3];
      }
   }

   public int read(byte[] var1, int var2, int var3) throws IOException {
      boolean var4;
      if(this.mBufferOffset <= this.mBufferedSize) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkState(var4);
      this.ensureNotClosed();
      if(!this.ensureDataInBuffer()) {
         return -1;
      } else {
         int var5 = Math.min(this.mBufferedSize - this.mBufferOffset, var3);
         System.arraycopy(this.mByteArray, this.mBufferOffset, var1, var2, var5);
         this.mBufferOffset += var5;
         return var5;
      }
   }

   public long skip(long var1) throws IOException {
      boolean var3;
      if(this.mBufferOffset <= this.mBufferedSize) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkState(var3);
      this.ensureNotClosed();
      int var4 = this.mBufferedSize - this.mBufferOffset;
      if((long)var4 >= var1) {
         this.mBufferOffset = (int)(var1 + (long)this.mBufferOffset);
         return var1;
      } else {
         this.mBufferOffset = this.mBufferedSize;
         return (long)var4 + this.mInputStream.skip(var1 - (long)var4);
      }
   }
}
