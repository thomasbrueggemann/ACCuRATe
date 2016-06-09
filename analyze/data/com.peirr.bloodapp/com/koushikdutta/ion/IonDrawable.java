package com.koushikdutta.ion;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.IonBitmapRequestBuilder;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class IonDrawable extends Drawable {
   private static final int DEFAULT_PAINT_FLAGS = 6;
   public static final long FADE_DURATION = 200L;
   private Bitmap bitmap;
   private IonDrawable.IonDrawableCallback callback;
   private Drawable error;
   private int errorResource;
   private BitmapInfo info;
   private int loadedFrom;
   private Paint paint;
   private Drawable placeholder;
   private int placeholderResource;
   int requestCount;
   private Resources resources;

   public IonDrawable(Resources var1, ImageView var2) {
      this.resources = var1;
      this.paint = new Paint(6);
      this.callback = new IonDrawable.IonDrawableCallback(this, var2);
   }

   static IonDrawable getOrCreateIonDrawable(ImageView var0) {
      Drawable var1 = var0.getDrawable();
      IonDrawable var2;
      if(var1 != null && var1 instanceof IonDrawable) {
         var2 = (IonDrawable)var1;
      } else {
         var2 = new IonDrawable(var0.getResources(), var0);
         var0.setImageDrawable(var2);
      }

      var0.setImageDrawable((Drawable)null);
      return var2;
   }

   public IonDrawable cancel() {
      ++this.requestCount;
      return this;
   }

   public void draw(Canvas var1) {
      if(this.info == null) {
         if(this.placeholder == null && this.placeholderResource != 0) {
            this.placeholder = this.resources.getDrawable(this.placeholderResource);
         }

         if(this.placeholder != null) {
            this.placeholder.setBounds(this.getBounds());
            this.placeholder.draw(var1);
         }
      } else {
         if(this.info.drawTime == 0L) {
            this.info.drawTime = SystemClock.uptimeMillis();
         }

         long var2 = Math.min((SystemClock.uptimeMillis() - this.info.drawTime << 8) / 200L, 255L);
         if(var2 != 255L) {
            if(this.placeholder == null && this.placeholderResource != 0) {
               this.placeholder = this.resources.getDrawable(this.placeholderResource);
            }

            if(this.placeholder != null) {
               this.placeholder.setBounds(this.getBounds());
               this.placeholder.draw(var1);
            }
         }

         if(this.bitmap != null) {
            this.paint.setAlpha((int)var2);
            var1.drawBitmap(this.bitmap, (Rect)null, this.getBounds(), this.paint);
            this.paint.setAlpha(255);
         } else {
            if(this.error == null && this.errorResource != 0) {
               this.error = this.resources.getDrawable(this.errorResource);
            }

            if(this.error != null) {
               this.error.setAlpha((int)var2);
               this.error.setBounds(this.getBounds());
               this.error.draw(var1);
               this.error.setAlpha(255);
            }
         }

         if(var2 != 255L) {
            this.invalidateSelf();
            return;
         }
      }

   }

   public SimpleFuture<ImageView> getFuture() {
      return this.callback.imageViewFuture;
   }

   public int getIntrinsicHeight() {
      return this.bitmap != null?this.bitmap.getScaledHeight(this.resources.getDisplayMetrics().densityDpi):(this.error != null?this.error.getIntrinsicHeight():(this.placeholder != null?this.placeholder.getIntrinsicHeight():-1));
   }

   public int getIntrinsicWidth() {
      return this.bitmap != null?this.bitmap.getScaledWidth(this.resources.getDisplayMetrics().densityDpi):(this.error != null?this.error.getIntrinsicWidth():(this.placeholder != null?this.placeholder.getIntrinsicWidth():-1));
   }

   public int getOpacity() {
      return this.bitmap != null && !this.bitmap.hasAlpha() && this.paint.getAlpha() >= 255?-1:-3;
   }

   public Drawable mutate() {
      throw new UnsupportedOperationException();
   }

   public void register(Ion var1, String var2) {
      IonDrawable.IonDrawableCallback var3 = this.callback;
      int var4 = 1 + this.requestCount;
      this.requestCount = var4;
      var3.requestId = var4;
      String var6 = this.callback.bitmapKey;
      if(!TextUtils.equals(var6, var2)) {
         this.callback.bitmapKey = var2;
         var1.bitmapsPending.add(var2, this.callback);
         if(var6 != null) {
            ArrayList var8 = (ArrayList)var1.bitmapsPending.get(var6);
            if(var8 != null) {
               var8.remove(this.callback);
               if(var8.size() == 0) {
                  var1.bitmapsPending.remove(var6);
                  return;
               }
            }
         }
      }

   }

   public void setAlpha(int var1) {
      this.paint.setAlpha(var1);
   }

   public IonDrawable setBitmap(BitmapInfo var1, int var2) {
      this.loadedFrom = var2;
      if(this.info == var1) {
         return this;
      } else {
         this.invalidateSelf();
         this.info = var1;
         if(var1 == null) {
            this.callback.bitmapKey = null;
            this.bitmap = null;
            return this;
         } else {
            this.callback.bitmapKey = var1.key;
            this.bitmap = var1.bitmap;
            return this;
         }
      }
   }

   public void setColorFilter(ColorFilter var1) {
      this.paint.setColorFilter(var1);
   }

   public void setDither(boolean var1) {
      this.paint.setDither(var1);
      this.invalidateSelf();
   }

   public IonDrawable setError(int var1, Drawable var2) {
      if((var2 == null || var2 != this.error) && (var1 == 0 || var1 != this.errorResource)) {
         this.errorResource = var1;
         this.error = var2;
         this.invalidateSelf();
         return this;
      } else {
         return this;
      }
   }

   public void setFilterBitmap(boolean var1) {
      this.paint.setFilterBitmap(var1);
      this.invalidateSelf();
   }

   public void setInAnimation(Animation var1, int var2) {
      this.callback.inAnimation = var1;
      this.callback.inAnimationResource = var2;
   }

   public IonDrawable setPlaceholder(int var1, Drawable var2) {
      if((var2 == null || var2 != this.placeholder) && (var1 == 0 || var1 != this.placeholderResource)) {
         this.placeholderResource = var1;
         this.placeholder = var2;
         this.invalidateSelf();
         return this;
      } else {
         return this;
      }
   }

   static class IonDrawableCallback implements FutureCallback<BitmapInfo> {
      // $FF: synthetic field
      static final boolean $assertionsDisabled;
      private String bitmapKey;
      private SimpleFuture<ImageView> imageViewFuture = new SimpleFuture();
      private WeakReference<ImageView> imageViewRef;
      private Animation inAnimation;
      private int inAnimationResource;
      private WeakReference<IonDrawable> ionDrawableRef;
      private int requestId;

      static {
         boolean var0;
         if(!IonDrawable.class.desiredAssertionStatus()) {
            var0 = true;
         } else {
            var0 = false;
         }

         $assertionsDisabled = var0;
      }

      public IonDrawableCallback(IonDrawable var1, ImageView var2) {
         this.ionDrawableRef = new WeakReference(var1);
         this.imageViewRef = new WeakReference(var2);
      }

      public void onCompleted(Exception var1, BitmapInfo var2) {
         if(!$assertionsDisabled && Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new AssertionError();
         } else if(!$assertionsDisabled && var2 == null) {
            throw new AssertionError();
         } else {
            ImageView var3 = (ImageView)this.imageViewRef.get();
            if(var3 != null) {
               IonDrawable var4 = (IonDrawable)this.ionDrawableRef.get();
               if(var4 != null && var3.getDrawable() == var4 && var4.requestCount == this.requestId) {
                  ++var4.requestCount;
                  var3.setImageDrawable((Drawable)null);
                  var4.setBitmap(var2, var2.loadedFrom);
                  var3.setImageDrawable(var4);
                  IonBitmapRequestBuilder.doAnimation(var3, this.inAnimation, this.inAnimationResource);
                  this.imageViewFuture.setComplete((Object)var3);
                  return;
               }
            }

         }
      }
   }
}
