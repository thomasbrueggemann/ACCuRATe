package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.internal.zzmd;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
   private static HashSet<Uri> zzajA = new HashSet();
   private static final Object zzajz = new Object();
   private final Context mContext;
   private final Handler mHandler;
   private final ExecutorService zzajD;
   private final ImageManager.zzb zzajE;
   private final zzmd zzajF;
   private final Map<zza, ImageManager.ImageReceiver> zzajG;
   private final Map<Uri, ImageManager.ImageReceiver> zzajH;
   private final Map<Uri, Long> zzajI;

   // $FF: synthetic method
   static Map zze(ImageManager var0) {
      return var0.zzajH;
   }

   // $FF: synthetic method
   static ImageManager.zzb zzh(ImageManager var0) {
      return var0.zzajE;
   }

   // $FF: synthetic method
   static Object zzqk() {
      return zzajz;
   }

   // $FF: synthetic method
   static HashSet zzql() {
      return zzajA;
   }

   @KeepName
   private final class ImageReceiver extends ResultReceiver {
      private final Uri mUri;
      private final ArrayList<zza> zzajJ;
      // $FF: synthetic field
      final ImageManager zzajK;

      public void onReceiveResult(int var1, Bundle var2) {
         ParcelFileDescriptor var3 = (ParcelFileDescriptor)var2.getParcelable("com.google.android.gms.extra.fileDescriptor");
         this.zzajK.zzajD.execute(this.zzajK.new zzc(this.mUri, var3));
      }
   }

   public interface OnImageLoadedListener {
      void onImageLoaded(Uri var1, Drawable var2, boolean var3);
   }

   private static final class zzb extends LruCache<zza.zza, Bitmap> {
      // $FF: synthetic method
      protected void entryRemoved(boolean var1, Object var2, Object var3, Object var4) {
         this.zza(var1, (zza.zza)var2, (Bitmap)var3, (Bitmap)var4);
      }

      // $FF: synthetic method
      protected int sizeOf(Object var1, Object var2) {
         return this.zza((zza.zza)var1, (Bitmap)var2);
      }

      protected int zza(zza.zza var1, Bitmap var2) {
         return var2.getHeight() * var2.getRowBytes();
      }

      protected void zza(boolean var1, zza.zza var2, Bitmap var3, Bitmap var4) {
         super.entryRemoved(var1, var2, var3, var4);
      }
   }

   private final class zzc implements Runnable {
      private final Uri mUri;
      private final ParcelFileDescriptor zzajL;

      public zzc(Uri var2, ParcelFileDescriptor var3) {
         this.mUri = var2;
         this.zzajL = var3;
      }

      public void run() {
         com.google.android.gms.common.internal.zzb.zzcE("LoadBitmapFromDiskRunnable can\'t be executed in the main thread");
         ParcelFileDescriptor var1 = this.zzajL;
         Bitmap var2 = null;
         boolean var3 = false;
         if(var1 != null) {
            label23: {
               Bitmap var12;
               try {
                  var12 = BitmapFactoryInstrumentation.decodeFileDescriptor(this.zzajL.getFileDescriptor());
               } catch (OutOfMemoryError var15) {
                  Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, var15);
                  var3 = true;
                  var2 = null;
                  break label23;
               }

               var2 = var12;
            }

            try {
               this.zzajL.close();
            } catch (IOException var14) {
               Log.e("ImageManager", "closed failed", var14);
            }
         }

         CountDownLatch var4 = new CountDownLatch(1);
         ImageManager.this.mHandler.post(ImageManager.this.new zzf(this.mUri, var2, var3, var4));

         try {
            var4.await();
         } catch (InterruptedException var13) {
            Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
         }
      }
   }

   private final class zzf implements Runnable {
      private final Bitmap mBitmap;
      private final Uri mUri;
      private boolean zzajN;
      private final CountDownLatch zzpJ;

      public zzf(Uri var2, Bitmap var3, boolean var4, CountDownLatch var5) {
         this.mUri = var2;
         this.mBitmap = var3;
         this.zzajN = var4;
         this.zzpJ = var5;
      }

      private void zza(ImageManager.ImageReceiver var1, boolean var2) {
         ArrayList var3 = var1.zzajJ;
         int var4 = var3.size();

         for(int var5 = 0; var5 < var4; ++var5) {
            zza var6 = (zza)var3.get(var5);
            if(var2) {
               var6.zza(ImageManager.this.mContext, this.mBitmap, false);
            } else {
               ImageManager.this.zzajI.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
               var6.zza(ImageManager.this.mContext, ImageManager.this.zzajF, false);
            }

            if(!(var6 instanceof zza.zzc)) {
               ImageManager.this.zzajG.remove(var6);
            }
         }

      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
