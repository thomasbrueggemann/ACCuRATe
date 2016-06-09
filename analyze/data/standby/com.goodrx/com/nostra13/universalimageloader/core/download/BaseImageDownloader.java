package com.nostra13.universalimageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore.Video.Thumbnails;
import android.webkit.MimeTypeMap;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseImageDownloader implements ImageDownloader {
   protected final int connectTimeout;
   protected final Context context;
   protected final int readTimeout;

   public BaseImageDownloader(Context var1) {
      this(var1, 5000, 20000);
   }

   public BaseImageDownloader(Context var1, int var2, int var3) {
      this.context = var1.getApplicationContext();
      this.connectTimeout = var2;
      this.readTimeout = var3;
   }

   @TargetApi(8)
   private InputStream getVideoThumbnailStream(String var1) {
      if(VERSION.SDK_INT >= 8) {
         Bitmap var2 = ThumbnailUtils.createVideoThumbnail(var1, 2);
         if(var2 != null) {
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            var2.compress(CompressFormat.PNG, 0, var3);
            return new ByteArrayInputStream(var3.toByteArray());
         }
      }

      return null;
   }

   private boolean isVideoContentUri(Uri var1) {
      String var2 = this.context.getContentResolver().getType(var1);
      return var2 != null && var2.startsWith("video/");
   }

   private boolean isVideoFileUri(String var1) {
      String var2 = MimeTypeMap.getFileExtensionFromUrl(var1);
      String var3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var2);
      return var3 != null && var3.startsWith("video/");
   }

   protected HttpURLConnection createConnection(String var1, Object var2) throws IOException {
      HttpURLConnection var3 = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(Uri.encode(var1, "@#&=*+-_.,:!?()/~\'%"))).openConnection());
      var3.setConnectTimeout(this.connectTimeout);
      var3.setReadTimeout(this.readTimeout);
      return var3;
   }

   @TargetApi(14)
   protected InputStream getContactPhotoStream(Uri var1) {
      ContentResolver var2 = this.context.getContentResolver();
      return VERSION.SDK_INT >= 14?Contacts.openContactPhotoInputStream(var2, var1, true):Contacts.openContactPhotoInputStream(var2, var1);
   }

   public InputStream getStream(String var1, Object var2) throws IOException {
      switch(null.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(var1).ordinal()]) {
      case 1:
      case 2:
         return this.getStreamFromNetwork(var1, var2);
      case 3:
         return this.getStreamFromFile(var1, var2);
      case 4:
         return this.getStreamFromContent(var1, var2);
      case 5:
         return this.getStreamFromAssets(var1, var2);
      case 6:
         return this.getStreamFromDrawable(var1, var2);
      default:
         return this.getStreamFromOtherSource(var1, var2);
      }
   }

   protected InputStream getStreamFromAssets(String var1, Object var2) throws IOException {
      String var3 = ImageDownloader.Scheme.ASSETS.crop(var1);
      return this.context.getAssets().open(var3);
   }

   protected InputStream getStreamFromContent(String var1, Object var2) throws FileNotFoundException {
      ContentResolver var3 = this.context.getContentResolver();
      Uri var4 = Uri.parse(var1);
      if(this.isVideoContentUri(var4)) {
         Bitmap var5 = Thumbnails.getThumbnail(var3, Long.valueOf(var4.getLastPathSegment()).longValue(), 1, (Options)null);
         if(var5 != null) {
            ByteArrayOutputStream var6 = new ByteArrayOutputStream();
            var5.compress(CompressFormat.PNG, 0, var6);
            return new ByteArrayInputStream(var6.toByteArray());
         }
      } else if(var1.startsWith("content://com.android.contacts/")) {
         return this.getContactPhotoStream(var4);
      }

      return var3.openInputStream(var4);
   }

   protected InputStream getStreamFromDrawable(String var1, Object var2) {
      int var3 = Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(var1));
      return this.context.getResources().openRawResource(var3);
   }

   protected InputStream getStreamFromFile(String var1, Object var2) throws IOException {
      String var3 = ImageDownloader.Scheme.FILE.crop(var1);
      return (InputStream)(this.isVideoFileUri(var1)?this.getVideoThumbnailStream(var3):new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(var3), '耀'), (int)(new File(var3)).length()));
   }

   protected InputStream getStreamFromNetwork(String var1, Object var2) throws IOException {
      HttpURLConnection var3 = this.createConnection(var1, var2);

      for(int var4 = 0; var3.getResponseCode() / 100 == 3 && var4 < 5; ++var4) {
         var3 = this.createConnection(var3.getHeaderField("Location"), var2);
      }

      InputStream var6;
      try {
         var6 = var3.getInputStream();
      } catch (IOException var7) {
         IoUtils.readAndCloseStream(var3.getErrorStream());
         throw var7;
      }

      if(!this.shouldBeProcessed(var3)) {
         IoUtils.closeSilently(var6);
         throw new IOException("Image request failed with response code " + var3.getResponseCode());
      } else {
         return new ContentLengthInputStream(new BufferedInputStream(var6, '耀'), var3.getContentLength());
      }
   }

   protected InputStream getStreamFromOtherSource(String var1, Object var2) throws IOException {
      throw new UnsupportedOperationException(String.format("UIL doesn\'t support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[]{var1}));
   }

   protected boolean shouldBeProcessed(HttpURLConnection var1) throws IOException {
      return var1.getResponseCode() == 200;
   }
}
