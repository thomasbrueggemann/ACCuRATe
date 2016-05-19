package com.facebook.imagepipeline.animated.factory;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.List;

public class AnimatedImageFactory {
   private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
   private final PlatformBitmapFactory mBitmapFactory;

   public AnimatedImageFactory(AnimatedDrawableBackendProvider var1, PlatformBitmapFactory var2) {
      this.mAnimatedDrawableBackendProvider = var1;
      this.mBitmapFactory = var2;
   }

   @SuppressLint({"NewApi"})
   private CloseableReference<Bitmap> createBitmap(int var1, int var2, Config var3) {
      CloseableReference var4 = this.mBitmapFactory.createBitmap(var1, var2, var3);
      ((Bitmap)var4.get()).eraseColor(0);
      if(VERSION.SDK_INT >= 12) {
         ((Bitmap)var4.get()).setHasAlpha(true);
      }

      return var4;
   }

   private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage var1, Config var2, int var3) {
      CloseableReference var4 = this.createBitmap(var1.getWidth(), var1.getHeight(), var2);
      AnimatedImageResult var5 = AnimatedImageResult.forAnimatedImage(var1);
      (new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(var5, (Rect)null), new AnimatedImageCompositor.Callback() {
         public CloseableReference<Bitmap> getCachedBitmap(int var1) {
            return null;
         }

         public void onIntermediateResult(int var1, Bitmap var2) {
         }
      })).renderFrame(var3, (Bitmap)var4.get());
      return var4;
   }

   private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage var1, Config var2) {
      final ArrayList var3 = new ArrayList();
      AnimatedImageResult var4 = AnimatedImageResult.forAnimatedImage(var1);
      AnimatedDrawableBackend var5 = this.mAnimatedDrawableBackendProvider.get(var4, (Rect)null);
      AnimatedImageCompositor var6 = new AnimatedImageCompositor(var5, new AnimatedImageCompositor.Callback() {
         public CloseableReference<Bitmap> getCachedBitmap(int var1) {
            return CloseableReference.cloneOrNull((CloseableReference)var3.get(var1));
         }

         public void onIntermediateResult(int var1, Bitmap var2) {
         }
      });

      for(int var7 = 0; var7 < var5.getFrameCount(); ++var7) {
         CloseableReference var8 = this.createBitmap(var5.getWidth(), var5.getHeight(), var2);
         var6.renderFrame(var7, (Bitmap)var8.get());
         var3.add(var8);
      }

      return var3;
   }

   private CloseableAnimatedImage getCloseableImage(ImageDecodeOptions param1, AnimatedImage param2, Config param3) {
      // $FF: Couldn't be decompiled
   }

   public CloseableImage decodeGif(EncodedImage param1, ImageDecodeOptions param2, Config param3) {
      // $FF: Couldn't be decompiled
   }

   public CloseableImage decodeWebP(EncodedImage param1, ImageDecodeOptions param2, Config param3) {
      // $FF: Couldn't be decompiled
   }
}
