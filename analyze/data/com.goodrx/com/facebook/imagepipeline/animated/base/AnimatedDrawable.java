package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.imagepipeline.animated.base.AnimatableDrawable;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AnimatedDrawable extends Drawable implements DrawableWithCaches, AnimatableDrawable {
   private static final int NO_FRAME = -1;
   private static final int POLL_FOR_RENDERED_FRAME_MS = 5;
   private static final Class<?> TAG = AnimatedDrawable.class;
   private static final long WATCH_DOG_TIMER_MIN_TIMEOUT_MS = 1000L;
   private static final long WATCH_DOG_TIMER_POLL_INTERVAL_MS = 2000L;
   private AnimatedDrawableCachingBackend mAnimatedDrawableBackend;
   private final AnimatedDrawableDiagnostics mAnimatedDrawableDiagnostics;
   private boolean mApplyTransformation;
   private final Rect mDstRect = new Rect();
   private final int mDurationMs;
   private final int mFrameCount;
   private boolean mHaveWatchdogScheduled;
   private final Runnable mInvalidateTask = new Runnable() {
      public void run() {
         FLog.method_418(AnimatedDrawable.TAG, "(%s) Invalidate Task", AnimatedDrawable.this.mLogId);
         AnimatedDrawable.this.mInvalidateTaskScheduled = false;
         AnimatedDrawable.this.doInvalidateSelf();
      }
   };
   private boolean mInvalidateTaskScheduled;
   private boolean mIsRunning;
   private CloseableReference<Bitmap> mLastDrawnFrame;
   private int mLastDrawnFrameMonotonicNumber = -1;
   private int mLastDrawnFrameNumber = -1;
   private long mLastInvalidateTimeMs = -1L;
   private volatile String mLogId;
   private final MonotonicClock mMonotonicClock;
   private final Runnable mNextFrameTask = new Runnable() {
      public void run() {
         FLog.method_418(AnimatedDrawable.TAG, "(%s) Next Frame Task", AnimatedDrawable.this.mLogId);
         AnimatedDrawable.this.onNextFrame();
      }
   };
   private long mNextFrameTaskMs = -1L;
   private final Paint mPaint = new Paint(6);
   private int mPendingRenderedFrameMonotonicNumber;
   private int mPendingRenderedFrameNumber;
   private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;
   private int mScheduledFrameMonotonicNumber;
   private int mScheduledFrameNumber;
   private final Runnable mStartTask = new Runnable() {
      public void run() {
         AnimatedDrawable.this.onStart();
      }
   };
   private long mStartTimeMs;
   private float mSx = 1.0F;
   private float mSy = 1.0F;
   private final int mTotalLoops;
   private final Paint mTransparentPaint;
   private boolean mWaitingForDraw;
   private final Runnable mWatchdogTask = new Runnable() {
      public void run() {
         FLog.method_418(AnimatedDrawable.TAG, "(%s) Watchdog Task", AnimatedDrawable.this.mLogId);
         AnimatedDrawable.this.doWatchdogCheck();
      }
   };

   public AnimatedDrawable(ScheduledExecutorService var1, AnimatedDrawableCachingBackend var2, AnimatedDrawableDiagnostics var3, MonotonicClock var4) {
      this.mScheduledExecutorServiceForUiThread = var1;
      this.mAnimatedDrawableBackend = var2;
      this.mAnimatedDrawableDiagnostics = var3;
      this.mMonotonicClock = var4;
      this.mDurationMs = this.mAnimatedDrawableBackend.getDurationMs();
      this.mFrameCount = this.mAnimatedDrawableBackend.getFrameCount();
      this.mAnimatedDrawableDiagnostics.setBackend(this.mAnimatedDrawableBackend);
      this.mTotalLoops = this.mAnimatedDrawableBackend.getLoopCount();
      this.mTransparentPaint = new Paint();
      this.mTransparentPaint.setColor(0);
      this.mTransparentPaint.setStyle(Style.FILL);
      this.resetToPreviewFrame();
   }

   private void computeAndScheduleNextFrame(boolean var1) {
      if(this.mDurationMs != 0) {
         long var2 = this.mMonotonicClock.now();
         int var4 = (int)((var2 - this.mStartTimeMs) / (long)this.mDurationMs);
         if(this.mTotalLoops <= 0 || var4 < this.mTotalLoops) {
            int var5 = (int)((var2 - this.mStartTimeMs) % (long)this.mDurationMs);
            int var6 = this.mAnimatedDrawableBackend.getFrameForTimestampMs(var5);
            boolean var7;
            if(this.mScheduledFrameNumber != var6) {
               var7 = true;
            } else {
               var7 = false;
            }

            this.mScheduledFrameNumber = var6;
            this.mScheduledFrameMonotonicNumber = var6 + var4 * this.mFrameCount;
            if(var1) {
               if(var7) {
                  this.doInvalidateSelf();
                  return;
               }

               int var8 = this.mAnimatedDrawableBackend.getTimestampMsForFrame(this.mScheduledFrameNumber) + this.mAnimatedDrawableBackend.getDurationMsForFrame(this.mScheduledFrameNumber) - var5;
               int var9 = (1 + this.mScheduledFrameNumber) % this.mFrameCount;
               long var10 = var2 + (long)var8;
               if(this.mNextFrameTaskMs == -1L || this.mNextFrameTaskMs > var10) {
                  FLog.method_420(TAG, "(%s) Next frame (%d) in %d ms", this.mLogId, Integer.valueOf(var9), Integer.valueOf(var8));
                  this.unscheduleSelf(this.mNextFrameTask);
                  this.scheduleSelf(this.mNextFrameTask, var10);
                  this.mNextFrameTaskMs = var10;
                  return;
               }
            }
         }
      }

   }

   private void doInvalidateSelf() {
      this.mWaitingForDraw = true;
      this.mLastInvalidateTimeMs = this.mMonotonicClock.now();
      this.invalidateSelf();
   }

   private void doWatchdogCheck() {
      this.mHaveWatchdogScheduled = false;
      if(this.mIsRunning) {
         long var1 = this.mMonotonicClock.now();
         boolean var3;
         if(this.mWaitingForDraw && var1 - this.mLastInvalidateTimeMs > 1000L) {
            var3 = true;
         } else {
            var3 = false;
         }

         boolean var4;
         if(this.mNextFrameTaskMs != -1L && var1 - this.mNextFrameTaskMs > 1000L) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(!var3 && !var4) {
            this.mScheduledExecutorServiceForUiThread.schedule(this.mWatchdogTask, 2000L, TimeUnit.MILLISECONDS);
            this.mHaveWatchdogScheduled = true;
         } else {
            this.dropCaches();
            this.doInvalidateSelf();
         }
      }
   }

   private void onNextFrame() {
      this.mNextFrameTaskMs = -1L;
      if(this.mIsRunning && this.mDurationMs != 0) {
         this.mAnimatedDrawableDiagnostics.onNextFrameMethodBegin();

         try {
            this.computeAndScheduleNextFrame(true);
         } finally {
            this.mAnimatedDrawableDiagnostics.onNextFrameMethodEnd();
         }

      }
   }

   private void onStart() {
      if(this.mIsRunning) {
         this.mAnimatedDrawableDiagnostics.onStartMethodBegin();

         try {
            this.mStartTimeMs = this.mMonotonicClock.now();
            this.mScheduledFrameNumber = 0;
            this.mScheduledFrameMonotonicNumber = 0;
            long var2 = this.mStartTimeMs + (long)this.mAnimatedDrawableBackend.getDurationMsForFrame(0);
            this.scheduleSelf(this.mNextFrameTask, var2);
            this.mNextFrameTaskMs = var2;
            this.doInvalidateSelf();
         } finally {
            this.mAnimatedDrawableDiagnostics.onStartMethodEnd();
         }

      }
   }

   private boolean renderFrame(Canvas var1, int var2, int var3) {
      CloseableReference var4 = this.mAnimatedDrawableBackend.getBitmapForFrame(var2);
      if(var4 != null) {
         var1.drawBitmap((Bitmap)var4.get(), 0.0F, 0.0F, this.mPaint);
         if(this.mLastDrawnFrame != null) {
            this.mLastDrawnFrame.close();
         }

         if(this.mIsRunning && var3 > this.mLastDrawnFrameMonotonicNumber) {
            int var5 = -1 + (var3 - this.mLastDrawnFrameMonotonicNumber);
            this.mAnimatedDrawableDiagnostics.incrementDrawnFrames(1);
            this.mAnimatedDrawableDiagnostics.incrementDroppedFrames(var5);
            if(var5 > 0) {
               FLog.method_419(TAG, "(%s) Dropped %d frames", this.mLogId, Integer.valueOf(var5));
            }
         }

         this.mLastDrawnFrame = var4;
         this.mLastDrawnFrameNumber = var2;
         this.mLastDrawnFrameMonotonicNumber = var3;
         FLog.method_419(TAG, "(%s) Drew frame %d", this.mLogId, Integer.valueOf(var2));
         return true;
      } else {
         return false;
      }
   }

   private void resetToPreviewFrame() {
      this.mScheduledFrameNumber = this.mAnimatedDrawableBackend.getFrameForPreview();
      this.mScheduledFrameMonotonicNumber = this.mScheduledFrameNumber;
      this.mPendingRenderedFrameNumber = -1;
      this.mPendingRenderedFrameMonotonicNumber = -1;
   }

   private void scheduleInvalidatePoll() {
      if(!this.mInvalidateTaskScheduled) {
         this.mInvalidateTaskScheduled = true;
         this.scheduleSelf(this.mInvalidateTask, 5L);
      }
   }

   public ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener() {
      return new ValueAnimator.AnimatorUpdateListener() {
         public void onAnimationUpdate(ValueAnimator var1) {
            AnimatedDrawable.this.setLevel(((Integer)var1.getAnimatedValue()).intValue());
         }
      };
   }

   public ValueAnimator createValueAnimator() {
      int var1 = this.mAnimatedDrawableBackend.getLoopCount();
      ValueAnimator var2 = new ValueAnimator();
      int[] var3 = new int[]{0, this.mDurationMs};
      var2.setIntValues(var3);
      var2.setDuration((long)this.mDurationMs);
      if(var1 == 0) {
         var1 = -1;
      }

      var2.setRepeatCount(var1);
      var2.setRepeatMode(1);
      var2.setInterpolator(new LinearInterpolator());
      var2.addUpdateListener(this.createAnimatorUpdateListener());
      return var2;
   }

   public ValueAnimator createValueAnimator(int var1) {
      ValueAnimator var2 = this.createValueAnimator();
      var2.setRepeatCount(Math.max(var1 / this.mAnimatedDrawableBackend.getDurationMs(), 1));
      return var2;
   }

   public boolean didLastDrawRender() {
      return this.mLastDrawnFrame != null;
   }

   public void draw(Canvas param1) {
      // $FF: Couldn't be decompiled
   }

   public void dropCaches() {
      FLog.method_418(TAG, "(%s) Dropping caches", this.mLogId);
      if(this.mLastDrawnFrame != null) {
         this.mLastDrawnFrame.close();
         this.mLastDrawnFrame = null;
         this.mLastDrawnFrameNumber = -1;
         this.mLastDrawnFrameMonotonicNumber = -1;
      }

      this.mAnimatedDrawableBackend.dropCaches();
   }

   protected void finalize() throws Throwable {
      super.finalize();
      if(this.mLastDrawnFrame != null) {
         this.mLastDrawnFrame.close();
         this.mLastDrawnFrame = null;
      }

   }

   public int getIntrinsicHeight() {
      return this.mAnimatedDrawableBackend.getHeight();
   }

   public int getIntrinsicWidth() {
      return this.mAnimatedDrawableBackend.getWidth();
   }

   public int getOpacity() {
      return -3;
   }

   @VisibleForTesting
   int getScheduledFrameNumber() {
      return this.mScheduledFrameNumber;
   }

   public boolean isRunning() {
      return this.mIsRunning;
   }

   @VisibleForTesting
   boolean isWaitingForDraw() {
      return this.mWaitingForDraw;
   }

   @VisibleForTesting
   boolean isWaitingForNextFrame() {
      return this.mNextFrameTaskMs != -1L;
   }

   protected void onBoundsChange(Rect var1) {
      super.onBoundsChange(var1);
      this.mApplyTransformation = true;
      if(this.mLastDrawnFrame != null) {
         this.mLastDrawnFrame.close();
         this.mLastDrawnFrame = null;
      }

      this.mLastDrawnFrameNumber = -1;
      this.mLastDrawnFrameMonotonicNumber = -1;
      this.mAnimatedDrawableBackend.dropCaches();
   }

   protected boolean onLevelChange(int var1) {
      if(!this.mIsRunning) {
         int var2 = this.mAnimatedDrawableBackend.getFrameForTimestampMs(var1);
         if(var2 != this.mScheduledFrameNumber) {
            try {
               this.mScheduledFrameNumber = var2;
               this.mScheduledFrameMonotonicNumber = var2;
               this.doInvalidateSelf();
               return true;
            } catch (IllegalStateException var4) {
               return false;
            }
         }
      }

      return false;
   }

   public void setAlpha(int var1) {
      this.mPaint.setAlpha(var1);
      this.doInvalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
      this.doInvalidateSelf();
   }

   public void setLogId(String var1) {
      this.mLogId = var1;
   }

   public void start() {
      if(this.mDurationMs != 0 && this.mFrameCount > 1) {
         this.mIsRunning = true;
         this.scheduleSelf(this.mStartTask, this.mMonotonicClock.now());
      }
   }

   public void stop() {
      this.mIsRunning = false;
   }
}
