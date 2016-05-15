package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalContentUriFetchProducer extends LocalFetchProducer {
   private static final float ACCEPTABLE_REQUESTED_TO_ACTUAL_SIZE_RATIO = 1.3333334F;
   private static final String DISPLAY_PHOTO_PATH;
   private static final Rect MICRO_THUMBNAIL_DIMENSIONS;
   private static final Rect MINI_THUMBNAIL_DIMENSIONS;
   private static final int NO_THUMBNAIL = 0;
   @VisibleForTesting
   static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
   private static final String[] PROJECTION;
   private static final Class<?> TAG = LocalContentUriFetchProducer.class;
   private static final String[] THUMBNAIL_PROJECTION;
   private final ContentResolver mContentResolver;

   static {
      DISPLAY_PHOTO_PATH = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo").getPath();
      PROJECTION = new String[]{"_id", "_data"};
      THUMBNAIL_PROJECTION = new String[]{"_data"};
      MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, 384);
      MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
   }

   public LocalContentUriFetchProducer(Executor var1, PooledByteBufferFactory var2, ContentResolver var3, boolean var4) {
      super(var1, var2, var4);
      this.mContentResolver = var3;
   }

   @Nullable
   private EncodedImage getCameraImage(Uri param1, ResizeOptions param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private static int getLength(String var0) {
      return var0 == null?-1:(int)(new File(var0)).length();
   }

   private static int getRotationAngle(String var0) {
      int var1 = 0;
      if(var0 != null) {
         int var3;
         try {
            var3 = JfifUtil.getAutoRotateAngleFromOrientation((new ExifInterface(var0)).getAttributeInt("Orientation", 1));
         } catch (IOException var4) {
            FLog.method_396(TAG, var4, "Unable to retrieve thumbnail rotation for %s", new Object[]{var0});
            return 0;
         }

         var1 = var3;
      }

      return var1;
   }

   private EncodedImage getThumbnail(ResizeOptions param1, int param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   private static int getThumbnailKind(ResizeOptions var0) {
      return isThumbnailBigEnough(var0, MICRO_THUMBNAIL_DIMENSIONS)?3:(isThumbnailBigEnough(var0, MINI_THUMBNAIL_DIMENSIONS)?1:0);
   }

   private static boolean isCameraUri(Uri var0) {
      String var1 = var0.toString();
      return var1.startsWith(Media.EXTERNAL_CONTENT_URI.toString()) || var1.startsWith(Media.INTERNAL_CONTENT_URI.toString());
   }

   private static boolean isContactUri(Uri var0) {
      return "com.android.contacts".equals(var0.getAuthority()) && !var0.getPath().startsWith(DISPLAY_PHOTO_PATH);
   }

   @VisibleForTesting
   static boolean isThumbnailBigEnough(ResizeOptions var0, Rect var1) {
      return (float)var0.width <= 1.3333334F * (float)var1.width() && (float)var0.height <= 1.3333334F * (float)var1.height();
   }

   protected EncodedImage getEncodedImage(ImageRequest var1) throws IOException {
      Uri var2 = var1.getSourceUri();
      EncodedImage var3;
      if(isContactUri(var2)) {
         InputStream var4;
         if(var2.toString().endsWith("/photo")) {
            var4 = this.mContentResolver.openInputStream(var2);
         } else {
            var4 = Contacts.openContactPhotoInputStream(this.mContentResolver, var2);
            if(var4 == null) {
               throw new IOException("Contact photo does not exist: " + var2);
            }
         }

         var3 = this.getEncodedImage(var4, -1);
         return var3;
      } else {
         if(isCameraUri(var2)) {
            var3 = this.getCameraImage(var2, var1.getResizeOptions());
            if(var3 != null) {
               return var3;
            }
         }

         return this.getEncodedImage(this.mContentResolver.openInputStream(var2), -1);
      }
   }

   protected String getProducerName() {
      return "LocalContentUriFetchProducer";
   }
}
