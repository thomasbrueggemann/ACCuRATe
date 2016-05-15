package com.facebook.imagepipeline.animated.base;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;

public interface AnimatedDrawableDiagnostics {
   void drawDebugOverlay(Canvas var1, Rect var2);

   void incrementDrawnFrames(int var1);

   void incrementDroppedFrames(int var1);

   void onDrawMethodBegin();

   void onDrawMethodEnd();

   void onNextFrameMethodBegin();

   void onNextFrameMethodEnd();

   void onStartMethodBegin();

   void onStartMethodEnd();

   void setBackend(AnimatedDrawableCachingBackend var1);
}
