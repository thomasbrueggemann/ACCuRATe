package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResultBuilder;
import java.util.List;
import javax.annotation.Nullable;

public class AnimatedImageResult {
   @Nullable
   private List<CloseableReference<Bitmap>> mDecodedFrames;
   private final int mFrameForPreview;
   private final AnimatedImage mImage;
   @Nullable
   private CloseableReference<Bitmap> mPreviewBitmap;

   private AnimatedImageResult(AnimatedImage var1) {
      this.mImage = (AnimatedImage)Preconditions.checkNotNull(var1);
      this.mFrameForPreview = 0;
   }

   AnimatedImageResult(AnimatedImageResultBuilder var1) {
      this.mImage = (AnimatedImage)Preconditions.checkNotNull(var1.getImage());
      this.mFrameForPreview = var1.getFrameForPreview();
      this.mPreviewBitmap = var1.getPreviewBitmap();
      this.mDecodedFrames = var1.getDecodedFrames();
   }

   public static AnimatedImageResult forAnimatedImage(AnimatedImage var0) {
      return new AnimatedImageResult(var0);
   }

   public static AnimatedImageResultBuilder newBuilder(AnimatedImage var0) {
      return new AnimatedImageResultBuilder(var0);
   }

   public void dispose() {
      synchronized(this){}

      try {
         CloseableReference.closeSafely(this.mPreviewBitmap);
         this.mPreviewBitmap = null;
         CloseableReference.closeSafely((Iterable)this.mDecodedFrames);
         this.mDecodedFrames = null;
      } finally {
         ;
      }

   }

   @Nullable
   public CloseableReference<Bitmap> getDecodedFrame(int var1) {
      synchronized(this){}
      boolean var6 = false;

      CloseableReference var3;
      CloseableReference var4;
      label50: {
         try {
            var6 = true;
            if(this.mDecodedFrames != null) {
               var4 = CloseableReference.cloneOrNull((CloseableReference)this.mDecodedFrames.get(var1));
               var6 = false;
               break label50;
            }

            var6 = false;
         } finally {
            if(var6) {
               ;
            }
         }

         var3 = null;
         return var3;
      }

      var3 = var4;
      return var3;
   }

   public int getFrameForPreview() {
      return this.mFrameForPreview;
   }

   public AnimatedImage getImage() {
      return this.mImage;
   }

   public CloseableReference<Bitmap> getPreviewBitmap() {
      synchronized(this){}

      CloseableReference var2;
      try {
         var2 = CloseableReference.cloneOrNull(this.mPreviewBitmap);
      } finally {
         ;
      }

      return var2;
   }

   public boolean hasDecodedFrame(int var1) {
      synchronized(this){}
      boolean var6 = false;

      boolean var3;
      label45: {
         Object var4;
         try {
            var6 = true;
            if(this.mDecodedFrames == null) {
               var6 = false;
               break label45;
            }

            var4 = this.mDecodedFrames.get(var1);
            var6 = false;
         } finally {
            if(var6) {
               ;
            }
         }

         if(var4 != null) {
            var3 = true;
            return var3;
         }
      }

      var3 = false;
      return var3;
   }
}
