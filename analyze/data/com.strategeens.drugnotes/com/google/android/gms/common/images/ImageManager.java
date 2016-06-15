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
import com.google.android.gms.common.images.class_559;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.class_352;
import com.google.android.gms.internal.class_712;
import com.google.android.gms.internal.kj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
   // $FF: renamed from: Lu java.lang.Object
   private static final Object field_1771 = new Object();
   // $FF: renamed from: Lv java.util.HashSet
   private static HashSet<Uri> field_1772 = new HashSet();
   // $FF: renamed from: Lw com.google.android.gms.common.images.ImageManager
   private static ImageManager field_1773;
   // $FF: renamed from: Lx com.google.android.gms.common.images.ImageManager
   private static ImageManager field_1774;
   // $FF: renamed from: LA com.google.android.gms.internal.jc
   private final class_352 field_1775;
   // $FF: renamed from: LB java.util.Map
   private final Map<a, ImageManager.ImageReceiver> field_1776;
   // $FF: renamed from: LC java.util.Map
   private final Map<Uri, ImageManager.ImageReceiver> field_1777;
   // $FF: renamed from: LD java.util.Map
   private final Map<Uri, Long> field_1778;
   // $FF: renamed from: Ly java.util.concurrent.ExecutorService
   private final ExecutorService field_1779;
   // $FF: renamed from: Lz com.google.android.gms.common.images.ImageManager$b
   private final ImageManager.class_1185 field_1780;
   private final Context mContext;
   private final Handler mHandler;

   private ImageManager(Context var1, boolean var2) {
      this.mContext = var1.getApplicationContext();
      this.mHandler = new Handler(Looper.getMainLooper());
      this.field_1779 = Executors.newFixedThreadPool(4);
      if(var2) {
         this.field_1780 = new ImageManager.class_1185(this.mContext);
         if(class_712.method_4180()) {
            this.method_3061();
         }
      } else {
         this.field_1780 = null;
      }

      this.field_1775 = new class_352();
      this.field_1776 = new HashMap();
      this.field_1777 = new HashMap();
      this.field_1778 = new HashMap();
   }

   // $FF: renamed from: a (com.google.android.gms.common.images.ImageManager, com.google.android.gms.common.images.a$a) android.graphics.Bitmap
   // $FF: synthetic method
   static Bitmap method_3050(ImageManager var0, class_559.class_1694 var1) {
      return var0.method_3051(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.common.images.a$a) android.graphics.Bitmap
   private Bitmap method_3051(class_559.class_1694 var1) {
      return this.field_1780 == null?null:(Bitmap)this.field_1780.get(var1);
   }

   // $FF: renamed from: c (android.content.Context, boolean) com.google.android.gms.common.images.ImageManager
   public static ImageManager method_3054(Context var0, boolean var1) {
      if(var1) {
         if(field_1774 == null) {
            field_1774 = new ImageManager(var0, true);
         }

         return field_1774;
      } else {
         if(field_1773 == null) {
            field_1773 = new ImageManager(var0, false);
         }

         return field_1773;
      }
   }

   public static ImageManager create(Context var0) {
      return method_3054(var0, false);
   }

   // $FF: renamed from: e (com.google.android.gms.common.images.ImageManager) java.util.Map
   // $FF: synthetic method
   static Map method_3057(ImageManager var0) {
      return var0.field_1777;
   }

   // $FF: renamed from: h (com.google.android.gms.common.images.ImageManager) com.google.android.gms.common.images.ImageManager$b
   // $FF: synthetic method
   static ImageManager.class_1185 method_3060(ImageManager var0) {
      return var0.field_1780;
   }

   // $FF: renamed from: hd () void
   private void method_3061() {
      this.mContext.registerComponentCallbacks(new ImageManager.class_1188(this.field_1780));
   }

   // $FF: renamed from: he () java.lang.Object
   // $FF: synthetic method
   static Object method_3062() {
      return field_1771;
   }

   // $FF: renamed from: hf () java.util.HashSet
   // $FF: synthetic method
   static HashSet method_3063() {
      return field_1772;
   }

   // $FF: renamed from: a (com.google.android.gms.common.images.a) void
   public void method_3064(class_559 var1) {
      class_349.method_2427("ImageManager.loadImage() must be called in the main thread");
      (new ImageManager.class_1187(var1)).run();
   }

   public void loadImage(ImageView var1, int var2) {
      this.method_3064(new class_559.class_1695(var1, var2));
   }

   public void loadImage(ImageView var1, Uri var2) {
      this.method_3064(new class_559.class_1695(var1, var2));
   }

   public void loadImage(ImageView var1, Uri var2, int var3) {
      class_559.class_1695 var4 = new class_559.class_1695(var1, var2);
      var4.method_3433(var3);
      this.method_3064(var4);
   }

   public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2) {
      this.method_3064(new class_559.class_1696(var1, var2));
   }

   public void loadImage(ImageManager.OnImageLoadedListener var1, Uri var2, int var3) {
      class_559.class_1696 var4 = new class_559.class_1696(var1, var2);
      var4.method_3433(var3);
      this.method_3064(var4);
   }

   private final class ImageReceiver extends ResultReceiver {
      // $FF: renamed from: LE java.util.ArrayList
      private final ArrayList<a> field_2768;
      private final Uri mUri;

      ImageReceiver(Uri var2) {
         super(new Handler(Looper.getMainLooper()));
         this.mUri = var2;
         this.field_2768 = new ArrayList();
      }

      // $FF: renamed from: b (com.google.android.gms.common.images.a) void
      public void method_3672(class_559 var1) {
         class_349.method_2427("ImageReceiver.addImageRequest() must be called in the main thread");
         this.field_2768.add(var1);
      }

      // $FF: renamed from: c (com.google.android.gms.common.images.a) void
      public void method_3673(class_559 var1) {
         class_349.method_2427("ImageReceiver.removeImageRequest() must be called in the main thread");
         this.field_2768.remove(var1);
      }

      // $FF: renamed from: hg () void
      public void method_3674() {
         Intent var1 = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
         var1.putExtra("com.google.android.gms.extras.uri", this.mUri);
         var1.putExtra("com.google.android.gms.extras.resultReceiver", this);
         var1.putExtra("com.google.android.gms.extras.priority", 3);
         ImageManager.this.mContext.sendBroadcast(var1);
      }

      public void onReceiveResult(int var1, Bundle var2) {
         ParcelFileDescriptor var3 = (ParcelFileDescriptor)var2.getParcelable("com.google.android.gms.extra.fileDescriptor");
         ImageManager.this.field_1779.execute(ImageManager.this.new class_1186(this.mUri, var3));
      }
   }

   public interface OnImageLoadedListener {
      void onImageLoaded(Uri var1, Drawable var2, boolean var3);
   }

   private static final class class_1184 {
      // $FF: renamed from: a (android.app.ActivityManager) int
      static int method_5622(ActivityManager var0) {
         return var0.getLargeMemoryClass();
      }
   }

   private static final class class_1185 extends kj<class_559.class_1694, Bitmap> {
      public class_1185(Context var1) {
         super(method_2432(var1));
      }

      // $FF: renamed from: I (android.content.Context) int
      private static int method_2432(Context var0) {
         ActivityManager var1 = (ActivityManager)var0.getSystemService("activity");
         boolean var2;
         if((1048576 & var0.getApplicationInfo().flags) != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         int var3;
         if(var2 && class_712.method_4177()) {
            var3 = var1.getLargeMemoryClass();
         } else {
            var3 = var1.getMemoryClass();
         }

         return (int)(0.33F * (float)(var3 * 1048576));
      }

      // $FF: renamed from: a (com.google.android.gms.common.images.a$a, android.graphics.Bitmap) int
      protected int method_2433(class_559.class_1694 var1, Bitmap var2) {
         return var2.getHeight() * var2.getRowBytes();
      }

      // $FF: renamed from: a (boolean, com.google.android.gms.common.images.a$a, android.graphics.Bitmap, android.graphics.Bitmap) void
      protected void method_2434(boolean var1, class_559.class_1694 var2, Bitmap var3, Bitmap var4) {
         super.entryRemoved(var1, var2, var3, var4);
      }

      // $FF: synthetic method
      protected void entryRemoved(boolean var1, Object var2, Object var3, Object var4) {
         this.method_2434(var1, (class_559.class_1694)var2, (Bitmap)var3, (Bitmap)var4);
      }

      // $FF: synthetic method
      protected int sizeOf(Object var1, Object var2) {
         return this.method_2433((class_559.class_1694)var1, (Bitmap)var2);
      }
   }

   private final class class_1186 implements Runnable {
      // $FF: renamed from: LG android.os.ParcelFileDescriptor
      private final ParcelFileDescriptor field_4299;
      private final Uri mUri;

      public class_1186(Uri var2, ParcelFileDescriptor var3) {
         this.mUri = var2;
         this.field_4299 = var3;
      }

      public void run() {
         class_349.method_2428("LoadBitmapFromDiskRunnable can\'t be executed in the main thread");
         ParcelFileDescriptor var1 = this.field_4299;
         Bitmap var2 = null;
         boolean var3 = false;
         if(var1 != null) {
            label23: {
               Bitmap var12;
               try {
                  var12 = BitmapFactory.decodeFileDescriptor(this.field_4299.getFileDescriptor());
               } catch (OutOfMemoryError var15) {
                  Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, var15);
                  var3 = true;
                  var2 = null;
                  break label23;
               }

               var2 = var12;
            }

            try {
               this.field_4299.close();
            } catch (IOException var14) {
               Log.e("ImageManager", "closed failed", var14);
            }
         }

         CountDownLatch var4 = new CountDownLatch(1);
         ImageManager.this.mHandler.post(ImageManager.this.new class_1189(this.mUri, var2, var3, var4));

         try {
            var4.await();
         } catch (InterruptedException var13) {
            Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
         }
      }
   }

   private final class class_1187 implements Runnable {
      // $FF: renamed from: LH com.google.android.gms.common.images.a
      private final class_559 field_4297;

      public class_1187(class_559 var2) {
         this.field_4297 = var2;
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   private static final class class_1188 implements ComponentCallbacks2 {
      // $FF: renamed from: Lz com.google.android.gms.common.images.ImageManager$b
      private final ImageManager.class_1185 field_4301;

      public class_1188(ImageManager.class_1185 var1) {
         this.field_4301 = var1;
      }

      public void onConfigurationChanged(Configuration var1) {
      }

      public void onLowMemory() {
         this.field_4301.evictAll();
      }

      public void onTrimMemory(int var1) {
         if(var1 >= 60) {
            this.field_4301.evictAll();
         } else if(var1 >= 20) {
            this.field_4301.trimToSize(this.field_4301.size() / 2);
            return;
         }

      }
   }

   private final class class_1189 implements Runnable {
      // $FF: renamed from: LI boolean
      private boolean field_4303;
      private final Bitmap mBitmap;
      private final Uri mUri;
      // $FF: renamed from: mr java.util.concurrent.CountDownLatch
      private final CountDownLatch field_4304;

      public class_1189(Uri var2, Bitmap var3, boolean var4, CountDownLatch var5) {
         this.mUri = var2;
         this.mBitmap = var3;
         this.field_4303 = var4;
         this.field_4304 = var5;
      }

      // $FF: renamed from: a (com.google.android.gms.common.images.ImageManager$ImageReceiver, boolean) void
      private void method_5646(ImageManager.ImageReceiver var1, boolean var2) {
         ArrayList var3 = var1.field_2768;
         int var4 = var3.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            class_559 var6 = (class_559)var3.get(var5);
            if(var2) {
               var6.method_3429(ImageManager.this.mContext, this.mBitmap, false);
            } else {
               ImageManager.this.field_1778.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
               var6.method_3431(ImageManager.this.mContext, ImageManager.this.field_1775, false);
            }

            if(!(var6 instanceof class_559.class_1696)) {
               ImageManager.this.field_1776.remove(var6);
            }
         }

      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
