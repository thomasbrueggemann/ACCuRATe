package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.ArrayDrawable;
import java.util.Arrays;

public class FadeDrawable extends ArrayDrawable {
   @VisibleForTesting
   public static final int TRANSITION_NONE = 2;
   @VisibleForTesting
   public static final int TRANSITION_RUNNING = 1;
   @VisibleForTesting
   public static final int TRANSITION_STARTING;
   @VisibleForTesting
   int mAlpha;
   @VisibleForTesting
   int[] mAlphas;
   @VisibleForTesting
   int mDurationMs;
   @VisibleForTesting
   boolean[] mIsLayerOn;
   private final Drawable[] mLayers;
   @VisibleForTesting
   int mPreventInvalidateCount;
   @VisibleForTesting
   int[] mStartAlphas;
   @VisibleForTesting
   long mStartTimeMs;
   @VisibleForTesting
   int mTransitionState;

   public FadeDrawable(Drawable[] var1) {
      byte var2 = 1;
      super(var1);
      if(var1.length < var2) {
         var2 = 0;
      }

      Preconditions.checkState((boolean)var2, "At least one layer required!");
      this.mLayers = var1;
      this.mStartAlphas = new int[var1.length];
      this.mAlphas = new int[var1.length];
      this.mAlpha = 255;
      this.mIsLayerOn = new boolean[var1.length];
      this.mPreventInvalidateCount = 0;
      this.resetInternal();
   }

   private void drawDrawableWithAlpha(Canvas var1, Drawable var2, int var3) {
      if(var2 != null && var3 > 0) {
         ++this.mPreventInvalidateCount;
         var2.mutate().setAlpha(var3);
         this.mPreventInvalidateCount += -1;
         var2.draw(var1);
      }

   }

   private void resetInternal() {
      this.mTransitionState = 2;
      Arrays.fill(this.mStartAlphas, 0);
      this.mStartAlphas[0] = 255;
      Arrays.fill(this.mAlphas, 0);
      this.mAlphas[0] = 255;
      Arrays.fill(this.mIsLayerOn, false);
      this.mIsLayerOn[0] = true;
   }

   private boolean updateAlphas(float var1) {
      boolean var2 = true;

      for(int var3 = 0; var3 < this.mLayers.length; ++var3) {
         byte var4;
         if(this.mIsLayerOn[var3]) {
            var4 = 1;
         } else {
            var4 = -1;
         }

         this.mAlphas[var3] = (int)((float)this.mStartAlphas[var3] + var1 * (float)(var4 * 255));
         if(this.mAlphas[var3] < 0) {
            this.mAlphas[var3] = 0;
         }

         if(this.mAlphas[var3] > 255) {
            this.mAlphas[var3] = 255;
         }

         if(this.mIsLayerOn[var3] && this.mAlphas[var3] < 255) {
            var2 = false;
         }

         if(!this.mIsLayerOn[var3] && this.mAlphas[var3] > 0) {
            var2 = false;
         }
      }

      return var2;
   }

   public void beginBatchMode() {
      ++this.mPreventInvalidateCount;
   }

   public void draw(Canvas var1) {
      byte var2 = 2;
      boolean var3 = true;
      switch(this.mTransitionState) {
      case 0:
         System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
         this.mStartTimeMs = this.getCurrentTimeMs();
         float var7;
         if(this.mDurationMs == 0) {
            var7 = 1.0F;
         } else {
            var7 = 0.0F;
         }

         var3 = this.updateAlphas(var7);
         if(!var3) {
            var2 = 1;
         }

         this.mTransitionState = var2;
         break;
      case 1:
         int var5 = this.mDurationMs;
         boolean var6 = false;
         if(var5 > 0) {
            var6 = true;
         }

         Preconditions.checkState(var6);
         var3 = this.updateAlphas((float)(this.getCurrentTimeMs() - this.mStartTimeMs) / (float)this.mDurationMs);
         if(!var3) {
            var2 = 1;
         }

         this.mTransitionState = var2;
         break;
      case 2:
         var3 = true;
      }

      for(int var4 = 0; var4 < this.mLayers.length; ++var4) {
         this.drawDrawableWithAlpha(var1, this.mLayers[var4], this.mAlphas[var4] * this.mAlpha / 255);
      }

      if(!var3) {
         this.invalidateSelf();
      }

   }

   public void endBatchMode() {
      this.mPreventInvalidateCount += -1;
      this.invalidateSelf();
   }

   public void fadeInAllLayers() {
      this.mTransitionState = 0;
      Arrays.fill(this.mIsLayerOn, true);
      this.invalidateSelf();
   }

   public void fadeInLayer(int var1) {
      this.mTransitionState = 0;
      this.mIsLayerOn[var1] = true;
      this.invalidateSelf();
   }

   public void fadeOutAllLayers() {
      this.mTransitionState = 0;
      Arrays.fill(this.mIsLayerOn, false);
      this.invalidateSelf();
   }

   public void fadeOutLayer(int var1) {
      this.mTransitionState = 0;
      this.mIsLayerOn[var1] = false;
      this.invalidateSelf();
   }

   public void fadeToLayer(int var1) {
      this.mTransitionState = 0;
      Arrays.fill(this.mIsLayerOn, false);
      this.mIsLayerOn[var1] = true;
      this.invalidateSelf();
   }

   public void fadeUpToLayer(int var1) {
      this.mTransitionState = 0;
      Arrays.fill(this.mIsLayerOn, 0, var1 + 1, true);
      Arrays.fill(this.mIsLayerOn, var1 + 1, this.mLayers.length, false);
      this.invalidateSelf();
   }

   public void finishTransitionImmediately() {
      this.mTransitionState = 2;

      for(int var1 = 0; var1 < this.mLayers.length; ++var1) {
         int[] var2 = this.mAlphas;
         short var3;
         if(this.mIsLayerOn[var1]) {
            var3 = 255;
         } else {
            var3 = 0;
         }

         var2[var1] = var3;
      }

      this.invalidateSelf();
   }

   public int getAlpha() {
      return this.mAlpha;
   }

   protected long getCurrentTimeMs() {
      return SystemClock.uptimeMillis();
   }

   public int getTransitionDuration() {
      return this.mDurationMs;
   }

   @VisibleForTesting
   public int getTransitionState() {
      return this.mTransitionState;
   }

   public void invalidateSelf() {
      if(this.mPreventInvalidateCount == 0) {
         super.invalidateSelf();
      }

   }

   public boolean isLayerOn(int var1) {
      return this.mIsLayerOn[var1];
   }

   public void reset() {
      this.resetInternal();
      this.invalidateSelf();
   }

   public void setAlpha(int var1) {
      if(this.mAlpha != var1) {
         this.mAlpha = var1;
         this.invalidateSelf();
      }

   }

   public void setTransitionDuration(int var1) {
      this.mDurationMs = var1;
      if(this.mTransitionState == 1) {
         this.mTransitionState = 0;
      }

   }
}
