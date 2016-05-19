package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.facebook.imagepipeline.animated.impl.RollingStat;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

public class AnimatedDrawableDiagnosticsImpl implements AnimatedDrawableDiagnostics {
   private static final Class<?> TAG = AnimatedDrawableDiagnostics.class;
   private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
   private final AnimatedDrawableUtil mAnimatedDrawableUtil;
   private final TextPaint mDebugTextPaint;
   private final DisplayMetrics mDisplayMetrics;
   private final RollingStat mDrawnFrames;
   private final RollingStat mDroppedFramesStat;
   private long mLastTimeStamp;
   private final StringBuilder sbTemp;

   public AnimatedDrawableDiagnosticsImpl(AnimatedDrawableUtil var1, DisplayMetrics var2) {
      this.mAnimatedDrawableUtil = var1;
      this.mDisplayMetrics = var2;
      this.mDroppedFramesStat = new RollingStat();
      this.mDrawnFrames = new RollingStat();
      this.sbTemp = new StringBuilder();
      this.mDebugTextPaint = new TextPaint();
      this.mDebugTextPaint.setColor(-16776961);
      this.mDebugTextPaint.setTextSize((float)this.convertDpToPx(14));
   }

   private int convertDpToPx(int var1) {
      return (int)TypedValue.applyDimension(1, (float)var1, this.mDisplayMetrics);
   }

   public void drawDebugOverlay(Canvas var1, Rect var2) {
      int var3 = this.mDroppedFramesStat.getSum(10);
      int var4 = this.mDrawnFrames.getSum(10);
      int var5 = var4 + var3;
      int var6 = this.convertDpToPx(10);
      int var7 = var6;
      int var8 = this.convertDpToPx(20);
      int var9 = this.convertDpToPx(5);
      if(var5 > 0) {
         int var13 = var4 * 100 / var5;
         this.sbTemp.setLength(0);
         this.sbTemp.append(var13);
         this.sbTemp.append("%");
         var1.drawText(this.sbTemp, 0, this.sbTemp.length(), (float)var6, (float)var8, this.mDebugTextPaint);
         var7 = var9 + (int)((float)var6 + this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length()));
      }

      int var10 = this.mAnimatedDrawableBackend.getMemoryUsage();
      this.sbTemp.setLength(0);
      this.mAnimatedDrawableUtil.appendMemoryString(this.sbTemp, var10);
      float var11 = this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length());
      if(var11 + (float)var7 > (float)var2.width()) {
         var7 = var6;
         var8 = (int)((float)var8 + this.mDebugTextPaint.getTextSize() + (float)var9);
      }

      var1.drawText(this.sbTemp, 0, this.sbTemp.length(), (float)var7, (float)var8, this.mDebugTextPaint);
      int var12 = var9 + (int)(var11 + (float)var7);
      this.sbTemp.setLength(0);
      this.mAnimatedDrawableBackend.appendDebugOptionString(this.sbTemp);
      if(this.mDebugTextPaint.measureText(this.sbTemp, 0, this.sbTemp.length()) + (float)var12 > (float)var2.width()) {
         var12 = var6;
         var8 = (int)((float)var8 + this.mDebugTextPaint.getTextSize() + (float)var9);
      }

      var1.drawText(this.sbTemp, 0, this.sbTemp.length(), (float)var12, (float)var8, this.mDebugTextPaint);
   }

   public void incrementDrawnFrames(int var1) {
      this.mDrawnFrames.incrementStats(var1);
   }

   public void incrementDroppedFrames(int var1) {
      this.mDroppedFramesStat.incrementStats(var1);
      if(var1 > 0) {
         FLog.method_418(TAG, "Dropped %d frames", Integer.valueOf(var1));
      }

   }

   public void onDrawMethodBegin() {
      this.mLastTimeStamp = SystemClock.elapsedRealtime();
   }

   public void onDrawMethodEnd() {
      long var1 = SystemClock.elapsedRealtime() - this.mLastTimeStamp;
      FLog.method_418(TAG, "draw took %d", Long.valueOf(var1));
   }

   public void onNextFrameMethodBegin() {
      this.mLastTimeStamp = SystemClock.elapsedRealtime();
   }

   public void onNextFrameMethodEnd() {
      long var1 = SystemClock.elapsedRealtime() - this.mLastTimeStamp;
      if(var1 > 3L) {
         FLog.method_418(TAG, "onNextFrame took %d", Long.valueOf(var1));
      }

   }

   public void onStartMethodBegin() {
      this.mLastTimeStamp = SystemClock.elapsedRealtime();
   }

   public void onStartMethodEnd() {
      long var1 = SystemClock.elapsedRealtime() - this.mLastTimeStamp;
      if(var1 > 3L) {
         FLog.method_418(TAG, "onStart took %d", Long.valueOf(var1));
      }

   }

   public void setBackend(AnimatedDrawableCachingBackend var1) {
      this.mAnimatedDrawableBackend = var1;
   }
}
