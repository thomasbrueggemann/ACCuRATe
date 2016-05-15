package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import java.util.Collection;
import java.util.List;

public class AnimatedImageResultBuilder {
   private List<CloseableReference<Bitmap>> mDecodedFrames;
   private int mFrameForPreview;
   private final AnimatedImage mImage;
   private CloseableReference<Bitmap> mPreviewBitmap;

   AnimatedImageResultBuilder(AnimatedImage var1) {
      this.mImage = var1;
   }

   public AnimatedImageResult build() {
      AnimatedImageResult var1;
      try {
         var1 = new AnimatedImageResult(this);
      } finally {
         CloseableReference.closeSafely(this.mPreviewBitmap);
         this.mPreviewBitmap = null;
         CloseableReference.closeSafely((Iterable)this.mDecodedFrames);
         this.mDecodedFrames = null;
      }

      return var1;
   }

   public List<CloseableReference<Bitmap>> getDecodedFrames() {
      return CloseableReference.cloneOrNull((Collection)this.mDecodedFrames);
   }

   public int getFrameForPreview() {
      return this.mFrameForPreview;
   }

   public AnimatedImage getImage() {
      return this.mImage;
   }

   public CloseableReference<Bitmap> getPreviewBitmap() {
      return CloseableReference.cloneOrNull(this.mPreviewBitmap);
   }

   public AnimatedImageResultBuilder setDecodedFrames(List<CloseableReference<Bitmap>> var1) {
      this.mDecodedFrames = CloseableReference.cloneOrNull((Collection)var1);
      return this;
   }

   public AnimatedImageResultBuilder setFrameForPreview(int var1) {
      this.mFrameForPreview = var1;
      return this;
   }

   public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference<Bitmap> var1) {
      this.mPreviewBitmap = CloseableReference.cloneOrNull(var1);
      return this;
   }
}
