package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;

public class AnimatedDrawableDiagnosticsNoop implements AnimatedDrawableDiagnostics {
   private static AnimatedDrawableDiagnosticsNoop sInstance = new AnimatedDrawableDiagnosticsNoop();

   public static AnimatedDrawableDiagnosticsNoop getInstance() {
      return sInstance;
   }

   public void drawDebugOverlay(Canvas var1, Rect var2) {
   }

   public void incrementDrawnFrames(int var1) {
   }

   public void incrementDroppedFrames(int var1) {
   }

   public void onDrawMethodBegin() {
   }

   public void onDrawMethodEnd() {
   }

   public void onNextFrameMethodBegin() {
   }

   public void onNextFrameMethodEnd() {
   }

   public void onStartMethodBegin() {
   }

   public void onStartMethodEnd() {
   }

   public void setBackend(AnimatedDrawableCachingBackend var1) {
   }
}
