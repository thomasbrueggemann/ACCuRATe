package com.facebook.imagepipeline.gif;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class GifFrame implements AnimatedImageFrame {
   @DoNotStrip
   private long mNativeContext;

   @DoNotStrip
   GifFrame(long var1) {
      this.mNativeContext = var1;
   }

   private native void nativeDispose();

   private native void nativeFinalize();

   private native int nativeGetDisposalMode();

   private native int nativeGetDurationMs();

   private native int nativeGetHeight();

   private native int nativeGetWidth();

   private native int nativeGetXOffset();

   private native int nativeGetYOffset();

   private native boolean nativeHasTransparency();

   private native void nativeRenderFrame(int var1, int var2, Bitmap var3);

   public void dispose() {
      this.nativeDispose();
   }

   protected void finalize() {
      this.nativeFinalize();
   }

   public int getDisposalMode() {
      return this.nativeGetDisposalMode();
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

   public boolean hasTransparency() {
      return this.nativeHasTransparency();
   }

   public void renderFrame(int var1, int var2, Bitmap var3) {
      this.nativeRenderFrame(var1, var2, var3);
   }
}
