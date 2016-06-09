package com.facebook.imagepipeline.image;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class EncodedImage implements Closeable {
   public static final int DEFAULT_SAMPLE_SIZE = 1;
   public static final int UNKNOWN_HEIGHT = -1;
   public static final int UNKNOWN_ROTATION_ANGLE = -1;
   public static final int UNKNOWN_STREAM_SIZE = -1;
   public static final int UNKNOWN_WIDTH = -1;
   private int mHeight;
   private ImageFormat mImageFormat;
   @Nullable
   private final Supplier<FileInputStream> mInputStreamSupplier;
   @Nullable
   private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
   private int mRotationAngle;
   private int mSampleSize;
   private int mStreamSize;
   private int mWidth;

   public EncodedImage(Supplier<FileInputStream> var1) {
      this.mImageFormat = ImageFormat.UNKNOWN;
      this.mRotationAngle = -1;
      this.mWidth = -1;
      this.mHeight = -1;
      this.mSampleSize = 1;
      this.mStreamSize = -1;
      Preconditions.checkNotNull(var1);
      this.mPooledByteBufferRef = null;
      this.mInputStreamSupplier = var1;
   }

   public EncodedImage(Supplier<FileInputStream> var1, int var2) {
      this(var1);
      this.mStreamSize = var2;
   }

   public EncodedImage(CloseableReference<PooledByteBuffer> var1) {
      this.mImageFormat = ImageFormat.UNKNOWN;
      this.mRotationAngle = -1;
      this.mWidth = -1;
      this.mHeight = -1;
      this.mSampleSize = 1;
      this.mStreamSize = -1;
      Preconditions.checkArgument(CloseableReference.isValid(var1));
      this.mPooledByteBufferRef = var1.clone();
      this.mInputStreamSupplier = null;
   }

   public static EncodedImage cloneOrNull(EncodedImage var0) {
      return var0 != null?var0.cloneOrNull():null;
   }

   public static void closeSafely(@Nullable EncodedImage var0) {
      if(var0 != null) {
         var0.close();
      }

   }

   public static boolean isMetaDataAvailable(EncodedImage var0) {
      return var0.mRotationAngle >= 0 && var0.mWidth >= 0 && var0.mHeight >= 0;
   }

   public static boolean isValid(@Nullable EncodedImage var0) {
      return var0 != null && var0.isValid();
   }

   public EncodedImage cloneOrNull() {
      EncodedImage var1;
      if(this.mInputStreamSupplier != null) {
         var1 = new EncodedImage(this.mInputStreamSupplier, this.mStreamSize);
      } else {
         CloseableReference var2 = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
         if(var2 == null) {
            var1 = null;
         } else {
            try {
               var1 = new EncodedImage(var2);
            } finally {
               CloseableReference.closeSafely(var2);
            }
         }
      }

      if(var1 != null) {
         var1.copyMetaDataFrom(this);
      }

      return var1;
   }

   public void close() {
      CloseableReference.closeSafely(this.mPooledByteBufferRef);
   }

   public void copyMetaDataFrom(EncodedImage var1) {
      this.mImageFormat = var1.getImageFormat();
      this.mWidth = var1.getWidth();
      this.mHeight = var1.getHeight();
      this.mRotationAngle = var1.getRotationAngle();
      this.mSampleSize = var1.getSampleSize();
      this.mStreamSize = var1.getSize();
   }

   public CloseableReference<PooledByteBuffer> getByteBufferRef() {
      return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
   }

   public int getHeight() {
      return this.mHeight;
   }

   public ImageFormat getImageFormat() {
      return this.mImageFormat;
   }

   public InputStream getInputStream() {
      if(this.mInputStreamSupplier != null) {
         return (InputStream)this.mInputStreamSupplier.get();
      } else {
         CloseableReference var1 = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
         if(var1 != null) {
            PooledByteBufferInputStream var2;
            try {
               var2 = new PooledByteBufferInputStream((PooledByteBuffer)var1.get());
            } finally {
               CloseableReference.closeSafely(var1);
            }

            return var2;
         } else {
            return null;
         }
      }
   }

   public int getRotationAngle() {
      return this.mRotationAngle;
   }

   public int getSampleSize() {
      return this.mSampleSize;
   }

   public int getSize() {
      return this.mPooledByteBufferRef != null && this.mPooledByteBufferRef.get() != null?((PooledByteBuffer)this.mPooledByteBufferRef.get()).size():this.mStreamSize;
   }

   @VisibleForTesting
   public SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
      synchronized(this){}
      boolean var5 = false;

      SharedReference var2;
      SharedReference var3;
      label50: {
         try {
            var5 = true;
            if(this.mPooledByteBufferRef != null) {
               var3 = this.mPooledByteBufferRef.getUnderlyingReferenceTestOnly();
               var5 = false;
               break label50;
            }

            var5 = false;
         } finally {
            if(var5) {
               ;
            }
         }

         var2 = null;
         return var2;
      }

      var2 = var3;
      return var2;
   }

   public int getWidth() {
      return this.mWidth;
   }

   public boolean isCompleteAt(int var1) {
      if(this.mImageFormat == ImageFormat.JPEG && this.mInputStreamSupplier == null) {
         Preconditions.checkNotNull(this.mPooledByteBufferRef);
         PooledByteBuffer var3 = (PooledByteBuffer)this.mPooledByteBufferRef.get();
         if(var3.read(var1 - 2) != -1 || var3.read(var1 - 1) != -39) {
            return false;
         }
      }

      return true;
   }

   public boolean isValid() {
      synchronized(this){}
      boolean var5 = false;

      boolean var2;
      label45: {
         Supplier var3;
         try {
            var5 = true;
            if(CloseableReference.isValid(this.mPooledByteBufferRef)) {
               var5 = false;
               break label45;
            }

            var3 = this.mInputStreamSupplier;
            var5 = false;
         } finally {
            if(var5) {
               ;
            }
         }

         if(var3 == null) {
            var2 = false;
            return var2;
         }
      }

      var2 = true;
      return var2;
   }

   public void parseMetaData() {
      ImageFormat var1 = ImageFormatChecker.getImageFormat_WrapIOException(this.getInputStream());
      this.mImageFormat = var1;
      if(!ImageFormat.isWebpFormat(var1)) {
         Pair var2 = BitmapUtil.decodeDimensions(this.getInputStream());
         if(var2 != null) {
            this.mWidth = ((Integer)var2.first).intValue();
            this.mHeight = ((Integer)var2.second).intValue();
            if(var1 != ImageFormat.JPEG) {
               this.mRotationAngle = 0;
               return;
            }

            if(this.mRotationAngle == -1) {
               this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(JfifUtil.getOrientation(this.getInputStream()));
            }
         }
      }

   }

   public void setHeight(int var1) {
      this.mHeight = var1;
   }

   public void setImageFormat(ImageFormat var1) {
      this.mImageFormat = var1;
   }

   public void setRotationAngle(int var1) {
      this.mRotationAngle = var1;
   }

   public void setSampleSize(int var1) {
      this.mSampleSize = var1;
   }

   public void setStreamSize(int var1) {
      this.mStreamSize = var1;
   }

   public void setWidth(int var1) {
      this.mWidth = var1;
   }
}
