package com.facebook.imagepipeline.webp;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WebPFrame implements AnimatedImageFrame {
   @DoNotStrip
   private long mNativeContext;

   @DoNotStrip
   WebPFrame(long var1) {
      this.mNativeContext = var1;
   }

   private native void nativeDispose();

   private native void nativeFinalize();

   private native int nativeGetDurationMs();

   private native int nativeGetHeight();

   private native int nativeGetWidth();

   private native int nativeGetXOffset();

   private native int nativeGetYOffset();

   private native void nativeRenderFrame(int var1, int var2, Bitmap var3);

   private native boolean nativeShouldBlendWithPreviousFrame();

   private native boolean nativeShouldDisposeToBackgroundColor();

   public void dispose() {
      this.nativeDispose();
   }

   protected void finalize() {
      this.nativeFinalize();
   }

   public int getDurationMs() {
      return this.nativeGetDurationMs();
   }

   public int getHeight() {
      return this.nativeGetHeight();
   }

   public int getWidth() {
      return this.nativeGetWidth();
   }

   public int getXOffset() {
      return this.nativeGetXOffset();
   }

   public int getYOffset() {
      return this.nativeGetYOffset();
   }

   public void renderFrame(int var1, int var2, Bitmap var3) {
      this.nativeRenderFrame(var1, var2, var3);
   }

   public boolean shouldBlendWithPreviousFrame() {
      return this.nativeShouldBlendWithPreviousFrame();
   }

   public boolean shouldDisposeToBackgroundColor() {
      return this.nativeShouldDisposeToBackgroundColor();
   }
}
