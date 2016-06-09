package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class CloseableStaticBitmap extends CloseableBitmap {
   private volatile Bitmap mBitmap;
   @GuardedBy("this")
   private CloseableReference<Bitmap> mBitmapReference;
   private final QualityInfo mQualityInfo;
   private final int mRotationAngle;

   public CloseableStaticBitmap(Bitmap var1, ResourceReleaser<Bitmap> var2, QualityInfo var3, int var4) {
      this.mBitmap = (Bitmap)Preconditions.checkNotNull(var1);
      this.mBitmapReference = CloseableReference.method_307(this.mBitmap, (ResourceReleaser)Preconditions.checkNotNull(var2));
      this.mQualityInfo = var3;
      this.mRotationAngle = var4;
   }

   public CloseableStaticBitmap(CloseableReference<Bitmap> var1, QualityInfo var2, int var3) {
      this.mBitmapReference = (CloseableReference)Preconditions.checkNotNull(var1.cloneOrNull());
      this.mBitmap = (Bitmap)this.mBitmapReference.get();
      this.mQualityInfo = var2;
      this.mRotationAngle = var3;
   }

   private CloseableReference<Bitmap> detachBitmapReference() {
      synchronized(this){}

      CloseableReference var2;
      try {
         var2 = this.mBitmapReference;
         this.mBitmapReference = null;
         this.mBitmap = null;
      } finally {
         ;
      }

      return var2;
   }

   public void close() {
      CloseableReference var1 = this.detachBitmapReference();
      if(var1 != null) {
         var1.close();
      }

   }

   public CloseableReference<Bitmap> convertToBitmapReference() {
      synchronized(this){}

      CloseableReference var3;
      try {
         Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
         var3 = this.detachBitmapReference();
      } finally {
         ;
      }

      return var3;
   }

   public int getHeight() {
      Bitmap var1 = this.mBitmap;
      return var1 == null?0:var1.getHeight();
   }

   public QualityInfo getQualityInfo() {
      return this.mQualityInfo;
   }

   public int getRotationAngle() {
      return this.mRotationAngle;
   }

   public int getSizeInBytes() {
      return BitmapUtil.getSizeInBytes(this.mBitmap);
   }

   public Bitmap getUnderlyingBitmap() {
      return this.mBitmap;
   }

   public int getWidth() {
      Bitmap var1 = this.mBitmap;
      return var1 == null?0:var1.getWidth();
   }

   public boolean isClosed() {
      synchronized(this){}
      boolean var5 = false;

      CloseableReference var2;
      try {
         var5 = true;
         var2 = this.mBitmapReference;
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
}
