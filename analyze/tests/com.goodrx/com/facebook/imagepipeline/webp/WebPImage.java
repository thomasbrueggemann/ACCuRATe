package com.facebook.imagepipeline.webp;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.webp.WebPFrame;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WebPImage implements AnimatedImage {
   private static volatile boolean sInitialized;
   @DoNotStrip
   private long mNativeContext;

   @DoNotStrip
   WebPImage(long var1) {
      this.mNativeContext = var1;
   }

   public static WebPImage create(long var0, int var2) {
      ensure();
      boolean var3;
      if(var0 != 0L) {
         var3 = true;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      return nativeCreateFromNativeMemory(var0, var2);
   }

   public static WebPImage create(byte[] var0) {
      ensure();
      Preconditions.checkNotNull(var0);
      ByteBuffer var2 = ByteBuffer.allocateDirect(var0.length);
      var2.put(var0);
      var2.rewind();
      return nativeCreateFromDirectByteBuffer(var2);
   }

   private static void ensure() {
      synchronized(WebPImage.class){}

      try {
         if(!sInitialized) {
            sInitialized = true;

            try {
               SoLoaderShim.loadLibrary("webp");
            } catch (UnsatisfiedLinkError var4) {
               ;
            }

            SoLoaderShim.loadLibrary("webpimage");
         }
      } finally {
         ;
      }

   }

   private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer var0);

   private static native WebPImage nativeCreateFromNativeMemory(long var0, int var2);

   private native void nativeDispose();

   private native void nativeFinalize();

   private native int nativeGetDuration();

   private native WebPFrame nativeGetFrame(int var1);

   private native int nativeGetFrameCount();

   private native int[] nativeGetFrameDurations();

   private native int nativeGetHeight();

   private native int nativeGetLoopCount();

   private native int nativeGetSizeInBytes();

   private native int nativeGetWidth();

   public void dispose() {
      this.nativeDispose();
   }

   public boolean doesRenderSupportScaling() {
      return true;
   }

   protected void finalize() {
      this.nativeFinalize();
   }

   public int getDuration() {
      return this.nativeGetDuration();
   }

   public WebPFrame getFrame(int var1) {
      return this.nativeGetFrame(var1);
   }

   public int getFrameCount() {
      return this.nativeGetFrameCount();
   }

   public int[] getFrameDurations() {
      return this.nativeGetFrameDurations();
   }

   public AnimatedDrawableFrameInfo getFrameInfo(int param1) {
      // $FF: Couldn't be decompiled
   }

   public int getHeight() {
      return this.nativeGetHeight();
   }

   public int getLoopCount() {
      return this.nativeGetLoopCount();
   }

   public int getSizeInBytes() {
      return this.nativeGetSizeInBytes();
   }

   public int getWidth() {
      return this.nativeGetWidth();
   }
}
