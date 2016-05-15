package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;

public class AnimatedImageCompositor {
   private final AnimatedDrawableBackend mAnimatedDrawableBackend;
   private final AnimatedImageCompositor.Callback mCallback;
   private final Paint mTransparentFillPaint;

   public AnimatedImageCompositor(AnimatedDrawableBackend var1, AnimatedImageCompositor.Callback var2) {
      this.mAnimatedDrawableBackend = var1;
      this.mCallback = var2;
      this.mTransparentFillPaint = new Paint();
      this.mTransparentFillPaint.setColor(0);
      this.mTransparentFillPaint.setStyle(Style.FILL);
      this.mTransparentFillPaint.setXfermode(new PorterDuffXfermode(Mode.SRC));
   }

   private void disposeToBackground(Canvas var1, AnimatedDrawableFrameInfo var2) {
      var1.drawRect((float)var2.xOffset, (float)var2.yOffset, (float)(var2.xOffset + var2.width), (float)(var2.yOffset + var2.height), this.mTransparentFillPaint);
   }

   private AnimatedImageCompositor.FrameNeededResult isFrameNeededForRendering(int var1) {
      AnimatedDrawableFrameInfo var2 = this.mAnimatedDrawableBackend.getFrameInfo(var1);
      AnimatedDrawableFrameInfo.DisposalMethod var3 = var2.disposalMethod;
      return var3 == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT?AnimatedImageCompositor.FrameNeededResult.REQUIRED:(var3 == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND?(var2.xOffset == 0 && var2.yOffset == 0 && var2.width == this.mAnimatedDrawableBackend.getRenderedWidth() && var2.height == this.mAnimatedDrawableBackend.getRenderedHeight()?AnimatedImageCompositor.FrameNeededResult.NOT_REQUIRED:AnimatedImageCompositor.FrameNeededResult.REQUIRED):(var3 == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS?AnimatedImageCompositor.FrameNeededResult.SKIP:AnimatedImageCompositor.FrameNeededResult.ABORT));
   }

   private int prepareCanvasWithClosestCachedFrame(int var1, Canvas var2) {
      for(int var3 = var1; var3 >= 0; --var3) {
         AnimatedImageCompositor.FrameNeededResult var4 = this.isFrameNeededForRendering(var3);
         switch(null.$SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[var4.ordinal()]) {
         case 1:
            AnimatedDrawableFrameInfo var5 = this.mAnimatedDrawableBackend.getFrameInfo(var3);
            CloseableReference var6 = this.mCallback.getCachedBitmap(var3);
            if(var6 == null) {
               if(!var5.shouldBlendWithPreviousFrame) {
                  return var3;
               }
               break;
            } else {
               boolean var9 = false;

               try {
                  var9 = true;
                  var2.drawBitmap((Bitmap)var6.get(), 0.0F, 0.0F, (Paint)null);
                  if(var5.disposalMethod == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                     this.disposeToBackground(var2, var5);
                     var9 = false;
                  } else {
                     var9 = false;
                  }
               } finally {
                  if(var9) {
                     var6.close();
                  }
               }

               ++var3;
               var6.close();
            }
         case 3:
            return var3;
         case 2:
            return var3 + 1;
         }
      }

      return 0;
   }

   public void renderFrame(int var1, Bitmap var2) {
      Canvas var3 = new Canvas(var2);
      var3.drawColor(0, Mode.SRC);
      int var4;
      if(this.mAnimatedDrawableBackend.getFrameInfo(var1).shouldBlendWithPreviousFrame && var1 > 0) {
         var4 = this.prepareCanvasWithClosestCachedFrame(var1 - 1, var3);
      } else {
         var4 = var1;
      }

      for(int var5 = var4; var5 < var1; ++var5) {
         AnimatedDrawableFrameInfo var6 = this.mAnimatedDrawableBackend.getFrameInfo(var5);
         AnimatedDrawableFrameInfo.DisposalMethod var7 = var6.disposalMethod;
         if(var7 != AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            this.mAnimatedDrawableBackend.renderFrame(var5, var3);
            this.mCallback.onIntermediateResult(var5, var2);
            if(var7 == AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
               this.disposeToBackground(var3, var6);
            }
         }
      }

      this.mAnimatedDrawableBackend.renderFrame(var1, var3);
   }

   public interface Callback {
      CloseableReference<Bitmap> getCachedBitmap(int var1);

      void onIntermediateResult(int var1, Bitmap var2);
   }

   private static enum FrameNeededResult {
      ABORT,
      NOT_REQUIRED,
      REQUIRED,
      SKIP;

      static {
         AnimatedImageCompositor.FrameNeededResult[] var0 = new AnimatedImageCompositor.FrameNeededResult[]{REQUIRED, NOT_REQUIRED, SKIP, ABORT};
      }
   }
}
