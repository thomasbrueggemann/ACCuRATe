package com.koushikdutta.ion.bitmap;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.LruBitmapCache;

public class IonBitmapCache {
   // $FF: synthetic field
   static final boolean $assertionsDisabled = false;
   public static final long DEFAULT_ERROR_CACHE_DURATION = 30000L;
   LruBitmapCache cache;
   long errorCacheDuration = 30000L;
   Ion ion;
   DisplayMetrics metrics;
   Resources resources;

   static {
      boolean var0;
      if(!IonBitmapCache.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public IonBitmapCache(Ion var1) {
      Context var2 = var1.getContext();
      this.ion = var1;
      this.metrics = new DisplayMetrics();
      ((WindowManager)var2.getSystemService("window")).getDefaultDisplay().getMetrics(this.metrics);
      this.resources = new Resources(var2.getAssets(), this.metrics, var2.getResources().getConfiguration());
      this.cache = new LruBitmapCache(getHeapSize(var2) / 7);
   }

   private static int getHeapSize(Context var0) {
      return 1024 * 1024 * ((ActivityManager)var0.getSystemService("activity")).getMemoryClass();
   }

   public void dump() {
      Log.i("IonBitmapCache", "bitmap cache: " + this.cache.size());
      Log.i("IonBitmapCache", "freeMemory: " + Runtime.getRuntime().freeMemory());
   }

   public BitmapInfo get(String var1) {
      BitmapInfo var2;
      if(var1 == null) {
         var2 = null;
      } else {
         if(!$assertionsDisabled && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError();
         }

         var2 = (BitmapInfo)this.cache.get(var1);
         if(var2 != null && var2.bitmap == null && var2.loadTime + this.errorCacheDuration <= System.currentTimeMillis()) {
            this.cache.remove(var1);
            return null;
         }
      }

      return var2;
   }

   public long getErrorCacheDuration() {
      return this.errorCacheDuration;
   }

   public Bitmap loadBitmap(byte[] var1, int var2, int var3, int var4, int var5) {
      if(!$assertionsDisabled && Thread.currentThread() == Looper.getMainLooper().getThread()) {
         throw new AssertionError();
      } else {
         int var6 = var4;
         int var7 = var5;
         if(var4 <= 0) {
            var6 = this.metrics.widthPixels;
         }

         if(var6 <= 0) {
            var6 = Integer.MAX_VALUE;
         }

         if(var5 <= 0) {
            var7 = this.metrics.heightPixels;
         }

         if(var7 <= 0) {
            var7 = Integer.MAX_VALUE;
         }

         Options var8;
         if(var6 == Integer.MAX_VALUE) {
            var8 = null;
            if(var7 == Integer.MAX_VALUE) {
               return BitmapFactory.decodeByteArray(var1, var2, var3, var8);
            }
         }

         Options var9 = new Options();
         var9.inJustDecodeBounds = true;
         BitmapFactory.decodeByteArray(var1, var2, var3, var9);
         int var11 = Math.min(var9.outWidth / var6, var9.outHeight / var7);
         var8 = new Options();
         var8.inSampleSize = var11;
         return BitmapFactory.decodeByteArray(var1, var2, var3, var8);
      }
   }

   public void put(BitmapInfo var1) {
      if(!$assertionsDisabled && Thread.currentThread() != Looper.getMainLooper().getThread()) {
         throw new AssertionError();
      } else {
         this.cache.put(var1.key, var1);
      }
   }

   public BitmapInfo remove(String var1) {
      return (BitmapInfo)this.cache.remove(var1);
   }

   public void setErrorCacheDuration(long var1) {
      this.errorCacheDuration = var1;
   }
}
