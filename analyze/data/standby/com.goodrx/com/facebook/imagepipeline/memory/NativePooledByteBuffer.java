package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.NativeMemoryChunk;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class NativePooledByteBuffer implements PooledByteBuffer {
   @VisibleForTesting
   @GuardedBy("this")
   CloseableReference<NativeMemoryChunk> mBufRef;
   private final int mSize;

   public NativePooledByteBuffer(CloseableReference<NativeMemoryChunk> var1, int var2) {
      Preconditions.checkNotNull(var1);
      boolean var4;
      if(var2 >= 0 && var2 <= ((NativeMemoryChunk)var1.get()).getSize()) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      this.mBufRef = var1.clone();
      this.mSize = var2;
   }

   public void close() {
      synchronized(this){}

      try {
         CloseableReference.closeSafely(this.mBufRef);
         this.mBufRef = null;
      } finally {
         ;
      }

   }

   void ensureValid() {
      synchronized(this){}

      try {
         if(this.isClosed()) {
            throw new PooledByteBuffer.ClosedException();
         }
      } finally {
         ;
      }

   }

   public long getNativePtr() {
      synchronized(this){}

      long var2;
      try {
         this.ensureValid();
         var2 = ((NativeMemoryChunk)this.mBufRef.get()).getNativePtr();
      } finally {
         ;
      }

      return var2;
   }

   public boolean isClosed() {
      synchronized(this){}
      boolean var5 = false;

      boolean var2;
      try {
         var5 = true;
         var2 = CloseableReference.isValid(this.mBufRef);
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var3;
      if(!var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public byte read(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void read(int param1, byte[] param2, int param3, int param4) {
      // $FF: Couldn't be decompiled
   }

   public int size() {
      synchronized(this){}

      int var2;
      try {
         this.ensureValid();
         var2 = this.mSize;
      } finally {
         ;
      }

      return var2;
   }
}
