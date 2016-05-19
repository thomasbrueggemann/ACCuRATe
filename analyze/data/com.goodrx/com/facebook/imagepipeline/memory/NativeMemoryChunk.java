package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.soloader.SoLoaderShim;
import java.io.Closeable;

@DoNotStrip
public class NativeMemoryChunk implements Closeable {
   private static final String TAG = "NativeMemoryChunk";
   private boolean mClosed;
   private final long mNativePtr;
   private final int mSize;

   static {
      SoLoaderShim.loadLibrary("memchunk");
   }

   @VisibleForTesting
   public NativeMemoryChunk() {
      this.mSize = 0;
      this.mNativePtr = 0L;
      this.mClosed = true;
   }

   public NativeMemoryChunk(int var1) {
      boolean var2;
      if(var1 > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      this.mSize = var1;
      this.mNativePtr = nativeAllocate(this.mSize);
      this.mClosed = false;
   }

   private int adjustByteCount(int var1, int var2) {
      return Math.min(Math.max(0, this.mSize - var1), var2);
   }

   private void checkBounds(int var1, int var2, int var3, int var4) {
      boolean var5 = true;
      boolean var6;
      if(var4 >= 0) {
         var6 = var5;
      } else {
         var6 = false;
      }

      Preconditions.checkArgument(var6);
      boolean var7;
      if(var1 >= 0) {
         var7 = var5;
      } else {
         var7 = false;
      }

      Preconditions.checkArgument(var7);
      boolean var8;
      if(var3 >= 0) {
         var8 = var5;
      } else {
         var8 = false;
      }

      Preconditions.checkArgument(var8);
      boolean var9;
      if(var1 + var4 <= this.mSize) {
         var9 = var5;
      } else {
         var9 = false;
      }

      Preconditions.checkArgument(var9);
      if(var3 + var4 > var2) {
         var5 = false;
      }

      Preconditions.checkArgument(var5);
   }

   private void doCopy(int var1, NativeMemoryChunk var2, int var3, int var4) {
      boolean var5 = true;
      boolean var6;
      if(!this.isClosed()) {
         var6 = var5;
      } else {
         var6 = false;
      }

      Preconditions.checkState(var6);
      if(var2.isClosed()) {
         var5 = false;
      }

      Preconditions.checkState(var5);
      this.checkBounds(var1, var2.mSize, var3, var4);
      nativeMemcpy(var2.mNativePtr + (long)var3, this.mNativePtr + (long)var1, var4);
   }

   @DoNotStrip
   private static native long nativeAllocate(int var0);

   @DoNotStrip
   private static native void nativeCopyFromByteArray(long var0, byte[] var2, int var3, int var4);

   @DoNotStrip
   private static native void nativeCopyToByteArray(long var0, byte[] var2, int var3, int var4);

   @DoNotStrip
   private static native void nativeFree(long var0);

   @DoNotStrip
   private static native void nativeMemcpy(long var0, long var2, int var4);

   @DoNotStrip
   private static native byte nativeReadByte(long var0);

   public void close() {
      synchronized(this){}

      try {
         if(!this.mClosed) {
            this.mClosed = true;
            nativeFree(this.mNativePtr);
         }
      } finally {
         ;
      }

   }

   public void copy(int param1, NativeMemoryChunk param2, int param3, int param4) {
      // $FF: Couldn't be decompiled
   }

   protected void finalize() throws Throwable {
      if(!this.isClosed()) {
         Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.mNativePtr));

         try {
            this.close();
         } finally {
            super.finalize();
         }

      }
   }

   public long getNativePtr() {
      return this.mNativePtr;
   }

   public int getSize() {
      return this.mSize;
   }

   public boolean isClosed() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mClosed;
      } finally {
         ;
      }

      return var2;
   }

   public byte read(int param1) {
      // $FF: Couldn't be decompiled
   }

   public int read(int param1, byte[] param2, int param3, int param4) {
      // $FF: Couldn't be decompiled
   }

   public int write(int param1, byte[] param2, int param3, int param4) {
      // $FF: Couldn't be decompiled
   }
}
