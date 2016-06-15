package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.a;
import com.google.android.gms.common.images.class_462;
import com.google.android.gms.internal.class_275;
import com.google.android.gms.internal.class_321;
import com.google.android.gms.internal.class_322;
import com.google.android.gms.internal.hr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
   // $FF: renamed from: EU java.lang.Object
   private static final Object field_2089 = new Object();
   // $FF: renamed from: EV java.util.HashSet
   private static HashSet<Uri> field_2090 = new HashSet();
   // $FF: renamed from: EW com.google.android.gms.common.images.ImageManager
   private static ImageManager field_2091;
   // $FF: renamed from: EX com.google.android.gms.common.images.ImageManager
   private static ImageManager field_2092;
   // $FF: renamed from: EY java.util.concurrent.ExecutorService
   private final ExecutorService field_2093;
   // $FF: renamed from: EZ com.google.android.gms.common.images.ImageManager$b
   private final ImageManager.class_876 field_2094;
   // $FF: renamed from: Fa com.google.android.gms.internal.gx
   private final class_321 field_2095;
   // $FF: renamed from: Fb java.util.Map
   private final Map<a, ImageManager.ImageReceiver> field_2096;
   // $FF: renamed from: Fc java.util.Map
   private final Map<Uri, ImageManager.ImageReceiver> field_2097;
   // $FF: renamed from: Fd java.util.Map
   private final Map<Uri, Long> field_2098;
   private final Context mContext;
   private final Handler mHandler;

   private ImageManager(Context var1, boolean var2) {
      this.mContext = var1.getApplicationContext();
      this.mHandler = new Handler(Looper.getMainLooper());
      this.field_2093 = Executors.newFixedThreadPool(4);
      if(var2) {
         this.field_2094 = new ImageManager.class_876(this.mContext);
         if(class_275.method_1853()) {
            this.method_2697();
         }
      } else {
         this.field_2094 = null;
      }

      this.field_2095 = new class_321();
      this.field_2096 = new HashMap();
      this.field_2097 = new HashMap();
      this.field_2098 = new HashMap();
   }

   // $FF: renamed from: a (com.google.android.gms.common.images.ImageManager, com.google.android.gms.common.images.a$a) android.graphics.Bitmap
   // $FF: synthetic method
   static Bitmap method_2689(ImageManager var0, class_462.class_1324 var1) {
      return var0.method_2690(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.images.a$a) android.graphics.Bitmap
   private Bitmap method_2690(class_462.class_1324 var1) {
      return this.field_2094 == null?null:(Bitmap)this.field_2094.get(var1);
   }

   // $FF: renamed from: a (android.content.Context, boolean) com.google.android.gms.common.images.ImageManager
   public static ImageManager method_2691(Context var0, boolean var1) {
      if(var1) {
         if(field_2092 == null) {
            field_2092 = new ImageManager(var0, true);
         }

         return field_2092;
      } else {
         if(field_2091 == null) {
            field_2091 = new ImageManager(var0, false);
         }

         return field_2091;
      }
   }

   public static ImageManager create(Context var0) {
      return method_2691(var0, false);
   }

   // $FF: renamed from: e (com.google.android.gms.common.images.ImageManager) java.util.Map
   // $FF: synthetic method
   static Map method_2696(ImageManager var0) {
      return var0.field_2097;
   }

   // $FF: renamed from: eX () void
   private void method_2697() {
      this.mContext.registerComponentCallbacks(new ImageManager.class_879(this.field_2094));
   }

   // $FF: renamed from: eY () java.lang.Object
   // $FF: synthetic method
   static Object method_2698() {
      return field_2089;
   }

   // $FF: renamed from: eZ () java.util.HashSet
   // $FF: synthetic method
   static HashSet method_2699() {
      return field_2090;
   }

   // $FF: renamed from: h (com.google.android.gms.common.images.ImageManager) com.google.android.gms.common.images.ImageManager$b
   // $FF: synthetic method
   static ImageManager.class_876 method_2702(ImageManager var0) {
      return var0.field_2094;
   }

   // $FF: renamed from: a (com.google.android.gms.common.images.a) void
   public void method_2703(class_462 var1) {
      class_322.method_2052("ImageManager.loadImage() must be called in the main thread");
      (new ImageManager.class_878(var1)).run();
   }

   public void loadImage(ImageView var1, int var2) {
      this.method_2703(new class_462.class_1325(var1, var2));
   }

   public void loadImage(ImageView var1, Uri var2) {
      this.method_2703(new class_462.class_1325(var1, var2));
   }

   public void loadImage(ImageView var1, Uri var2, int var3) {
      class_462.class_1325 var4 = new class_462.class_1325(var1, var2);
      var4.method_2871(var3);
      this.method_2703(var4);
   }

   public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2) {
      this.method_2703(new class_462.class_1326(var1, var2));
   }

   public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2, int var3) {
      class_462.class_1326 var4 = new class_462.class_1326(var1, var2);
      var4.method_2871(var3);
      this.method_2703(var4);
   }

   private final class ImageReceiver extends ResultReceiver {
      // $FF: renamed from: Fe java.util.ArrayList
      private final ArrayList<a> field_2912;
      private final Uri mUri;

      ImageReceiver(Uri var2) {
         super(new Handler(Looper.getMainLooper()));
         this.mUri = var2;
         this.field_2912 = new ArrayList();
      }

      // $FF: renamed from: b (com.google.android.gms.common.images.a) void
      public void method_3091(class_462 var1) {
         class_322.method_2052("ImageReceiver.addImageRequest() must be called in the main thread");
         this.field_2912.add(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.images.a) void
      public void method_3092(class_462 var1) {
         class_322.method_2052("ImageReceiver.removeImageRequest() must be called in the main thread");
         this.field_2912.remove(var1);
      }

      // $FF: renamed from: fa () void
      public void method_3093() {
         Intent var1 = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
         var1.putExtra("com.google.android.gms.extras.uri", this.mUri);
         var1.putExtra("com.google.android.gms.extras.resultReceiver", this);
         var1.putExtra("com.google.android.gms.extras.priority", 3);
         ImageManager.this.mContext.sendBroadcast(var1);
      }

      public void onReceiveResult(int var1, Bundle var2) {
         ParcelFileDescriptor var3 = (ParcelFileDescriptor)var2.getParcelable("com.google.android.gms.extra.fileDescriptor");
         ImageManager.this.field_2093.execute(ImageManager.this.new class_877(this.mUri, var3));
      }
   }

   public interface OnImageLoadedListener {
      void onImageLoaded(Uri var1, Drawable var2, boolean var3);
   }

   private static final class class_875 {
      // $FF: renamed from: a (android.app.ActivityManager) int
      static int method_4428(ActivityManager var0) {
         return var0.getLargeMemoryClass();
      }
   }

   private static final class class_876 extends hr<class_462.class_1324, Bitmap> {
      public class_876(Context var1) {
         super(method_2047(var1));
      }

      // $FF: renamed from: A (android.content.Context) int
      private static int method_2047(Context var0) {
         ActivityManager var1 = (ActivityManager)var0.getSystemService("activity");
         boolean var2;
         if((1048576 & var0.getApplicationInfo().flags) != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         int var3;
         if(var2 && class_275.method_1850()) {
            var3 = var1.getLargeMemoryClass();
         } else {
            var3 = var1.getMemoryClass();
         }

         return (int)(0.33F * (float)(var3 * 1048576));
      }

      // $FF: renamed from: a (com.google.android.gms.common.images.a$a, android.graphics.Bitmap) int
      protected int method_2048(class_462.class_1324 var1, Bitmap var2) {
         return var2.getHeight() * var2.getRowBytes();
      }

      // $FF: renamed from: a (boolean, com.google.android.gms.common.images.a$a, android.graphics.Bitmap, android.graphics.Bitmap) void
      protected void method_2049(boolean var1, class_462.class_1324 var2, Bitmap var3, Bitmap var4) {
         super.entryRemoved(var1, var2, var3, var4);
      }

      // $FF: synthetic method
      protected void entryRemoved(boolean var1, Object var2, Object var3, Object var4) {
         this.method_2049(var1, (class_462.class_1324)var2, (Bitmap)var3, (Bitmap)var4);
      }

      // $FF: synthetic method
      protected int sizeOf(Object var1, Object var2) {
         return this.method_2048((class_462.class_1324)var1, (Bitmap)var2);
      }
   }

   private final class class_877 implements Runnable {
      // $FF: renamed from: Fg android.os.ParcelFileDescriptor
      private final ParcelFileDescriptor field_4151;
      private final Uri mUri;

      public class_877(Uri var2, ParcelFileDescriptor var3) {
         this.mUri = var2;
         this.field_4151 = var3;
      }

      public void run() {
         class_322.method_2053("LoadBitmapFromDiskRunnable can\'t be executed in the main thread");
         ParcelFileDescriptor var1 = this.field_4151;
         Bitmap var2 = null;
         boolean var3 = false;
         if(var1 != null) {
            label23: {
               Bitmap var12;
               try {
                  var12 = BitmapFactory.decodeFileDescriptor(this.field_4151.getFileDescriptor());
               } catch (OutOfMemoryError var15) {
                  Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, var15);
                  var3 = true;
                  var2 = null;
                  break label23;
               }

               var2 = var12;
            }

            try {
               this.field_4151.close();
            } catch (IOException var14) {
               Log.e("ImageManager", "closed failed", var14);
            }
         }

         CountDownLatch var4 = new CountDownLatch(1);
         ImageManager.this.mHandler.post(ImageManager.this.new class_880(this.mUri, var2, var3, var4));

         try {
            var4.await();
         } catch (InterruptedException var13) {
            Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
         }
      }
   }

   private final class class_878 implements Runnable {
      // $FF: renamed from: Fh com.google.android.gms.common.images.a
      private final class_462 field_4149;

      public class_878(class_462 var2) {
         this.field_4149 = var2;
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   private static final class class_879 implements ComponentCallbacks2 {
      // $FF: renamed from: EZ com.google.android.gms.common.images.ImageManager$b
      private final ImageManager.class_876 field_4156;

      public class_879(ImageManager.class_876 var1) {
         this.field_4156 = var1;
      }

      public void onConfigurationChanged(Configuration var1) {
      }

      public void onLowMemory() {
         this.field_4156.evictAll();
      }

      public void onTrimMemory(int var1) {
         if(var1 >= 60) {
            this.field_4156.evictAll();
         } else if(var1 >= 20) {
            this.field_4156.trimToSize(this.field_4156.size() / 2);
            return;
         }

      }
   }

   private final class class_880 implements Runnable {
      // $FF: renamed from: Fi boolean
      private boolean field_4158;
      // $FF: renamed from: kI java.util.concurrent.CountDownLatch
      private final CountDownLatch field_4159;
      private final Bitmap mBitmap;
      private final Uri mUri;

      public class_880(Uri var2, Bitmap var3, boolean var4, CountDownLatch var5) {
         this.mUri = var2;
         this.mBitmap = var3;
         this.field_4158 = var4;
         this.field_4159 = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.common.images.ImageManager$ImageReceiver, boolean) void
      private void method_4430(ImageManager.ImageReceiver var1, boolean var2) {
         ArrayList var3 = var1.field_2912;
         int var4 = var3.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            class_462 var6 = (class_462)var3.get(var5);
            if(var2) {
               var6.method_2867(ImageManager.this.mContext, this.mBitmap, false);
            } else {
               ImageManager.this.field_2098.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
               var6.method_2869(ImageManager.this.mContext, ImageManager.this.field_2095, false);
            }

            if(!(var6 instanceof class_462.class_1326)) {
               ImageManager.this.field_2096.remove(var6);
            }
         }

      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
