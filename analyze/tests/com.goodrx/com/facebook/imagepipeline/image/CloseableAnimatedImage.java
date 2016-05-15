package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.image.CloseableImage;

public class CloseableAnimatedImage extends CloseableImage {
   private AnimatedImageResult mImageResult;

   public CloseableAnimatedImage(AnimatedImageResult var1) {
      this.mImageResult = var1;
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   public int getHeight() {
      // $FF: Couldn't be decompiled
   }

   public AnimatedImage getImage() {
      // $FF: Couldn't be decompiled
   }

   public AnimatedImageResult getImageResult() {
      synchronized(this){}

      AnimatedImageResult var2;
      try {
         var2 = this.mImageResult;
      } finally {
         ;
      }

      return var2;
   }

   public int getSizeInBytes() {
      // $FF: Couldn't be decompiled
   }

   public int getWidth() {
      // $FF: Couldn't be decompiled
   }

   public boolean isClosed() {
      synchronized(this){}
      boolean var5 = false;

      AnimatedImageResult var2;
      try {
         var5 = true;
         var2 = this.mImageResult;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var3;
      if(var2 == null) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public boolean isStateful() {
      return true;
   }
}
