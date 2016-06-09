package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(11)
@ThreadSafe
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
   private final EmptyJpegGenerator mJpegGenerator;
   private final PlatformDecoder mPurgeableDecoder;

   public HoneycombBitmapFactory(EmptyJpegGenerator var1, PlatformDecoder var2) {
      this.mJpegGenerator = var1;
      this.mPurgeableDecoder = var2;
   }

   public CloseableReference<Bitmap> createBitmap(int param1, int param2, Config param3) {
      // $FF: Couldn't be decompiled
   }
}
