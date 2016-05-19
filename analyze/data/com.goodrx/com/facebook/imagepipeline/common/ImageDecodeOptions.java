package com.facebook.imagepipeline.common;

import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import java.util.Locale;
import javax.annotation.concurrent.Immutable;

@Immutable
public class ImageDecodeOptions {
   private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
   public final int backgroundColor;
   public final boolean decodeAllFrames;
   public final boolean decodePreviewFrame;
   public final boolean forceOldAnimationCode;
   public final int minDecodeIntervalMs;
   public final boolean useLastFrameForPreview;

   ImageDecodeOptions(ImageDecodeOptionsBuilder var1) {
      this.minDecodeIntervalMs = var1.getMinDecodeIntervalMs();
      this.backgroundColor = var1.getBackgroundColor();
      this.forceOldAnimationCode = var1.getForceOldAnimationCode();
      this.decodePreviewFrame = var1.getDecodePreviewFrame();
      this.useLastFrameForPreview = var1.getUseLastFrameForPreview();
      this.decodeAllFrames = var1.getDecodeAllFrames();
   }

   public static ImageDecodeOptions defaults() {
      return DEFAULTS;
   }

   public static ImageDecodeOptionsBuilder newBuilder() {
      return new ImageDecodeOptionsBuilder();
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null || this.getClass() != var1.getClass()) {
            return false;
         }

         ImageDecodeOptions var2 = (ImageDecodeOptions)var1;
         if(this.backgroundColor != var2.backgroundColor) {
            return false;
         }

         if(this.forceOldAnimationCode != var2.forceOldAnimationCode) {
            return false;
         }

         if(this.decodePreviewFrame != var2.decodePreviewFrame) {
            return false;
         }

         if(this.useLastFrameForPreview != var2.useLastFrameForPreview) {
            return false;
         }

         if(this.decodeAllFrames != var2.decodeAllFrames) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      int var1 = 31 * this.backgroundColor;
      byte var2;
      if(this.forceOldAnimationCode) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      return var1 + var2;
   }

   public String toString() {
      Locale var1 = (Locale)null;
      Object[] var2 = new Object[]{Integer.valueOf(this.minDecodeIntervalMs), Integer.valueOf(this.backgroundColor), Boolean.valueOf(this.forceOldAnimationCode), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames)};
      return String.format(var1, "%d-%d-%b-%b-%b-%b", var2);
   }
}
