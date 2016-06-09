package com.koushikdutta.ion;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import com.koushikdutta.async.future.TransformFuture;
import com.koushikdutta.async.parser.ByteBufferListParser;
import com.koushikdutta.ion.BitmapToBitmapInfo;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.IonDrawable;
import com.koushikdutta.ion.IonRequestBuilder;
import com.koushikdutta.ion.LoadBitmap;
import com.koushikdutta.ion.bitmap.BitmapInfo;
import com.koushikdutta.ion.bitmap.Transform;
import com.koushikdutta.ion.builder.BitmapFutureBuilder;
import com.koushikdutta.ion.builder.Builders;
import com.koushikdutta.ion.builder.ImageViewFutureBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class IonBitmapRequestBuilder implements Builders.class_9, ImageViewFutureBuilder, BitmapFutureBuilder, Builders.class_4 {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private static final SimpleFuture<Bitmap> FUTURE_BITMAP_NULL_URI;
   private static final SimpleFuture<ImageView> FUTURE_IMAGEVIEW_NULL_URI;
   String bitmapKey;
   IonRequestBuilder builder;
   Drawable errorDrawable;
   int errorResource;
   WeakReference<ImageView> imageViewPostRef;
   Animation inAnimation;
   int inAnimationResource;
   Ion ion;
   Animation loadAnimation;
   int loadAnimationResource;
   Drawable placeholderDrawable;
   int placeholderResource;
   int resizeHeight;
   int resizeWidth;
   IonBitmapRequestBuilder.ScaleMode scaleMode;
   ArrayList<Transform> transforms;

   static {
      boolean var0;
      if(!IonBitmapRequestBuilder.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      FUTURE_IMAGEVIEW_NULL_URI = new SimpleFuture() {
         {
            this.setComplete(new NullPointerException("uri"));
         }
      };
      FUTURE_BITMAP_NULL_URI = new SimpleFuture() {
         {
            this.setComplete(new NullPointerException("uri"));
         }
      };
   }

   public IonBitmapRequestBuilder(Ion var1) {
      this.scaleMode = IonBitmapRequestBuilder.ScaleMode.FitXY;
      this.ion = var1;
   }

   public IonBitmapRequestBuilder(IonRequestBuilder var1) {
      this.scaleMode = IonBitmapRequestBuilder.ScaleMode.FitXY;
      this.builder = var1;
      this.ion = var1.ion;
   }

   static void doAnimation(ImageView var0, Animation var1, int var2) {
      if(var0 != null) {
         if(var1 == null && var2 != 0) {
            var1 = AnimationUtils.loadAnimation(var0.getContext(), var2);
         }

         if(var1 == null) {
            var0.setAnimation((Animation)null);
         } else {
            var0.startAnimation(var1);
         }
      }
   }

   private void ensureBuilder() {
      if(this.builder == null) {
         this.builder = new IonRequestBuilder(((ImageView)this.imageViewPostRef.get()).getContext(), this.ion);
      }

   }

   private IonDrawable setIonDrawable(ImageView var1, BitmapInfo var2, int var3) {
      IonDrawable var4 = IonDrawable.getOrCreateIonDrawable(var1);
      var4.setBitmap(var2, var3);
      var4.setError(this.errorResource, this.errorDrawable);
      var4.setPlaceholder(this.placeholderResource, this.placeholderDrawable);
      var4.setInAnimation(this.inAnimation, this.inAnimationResource);
      var1.setImageDrawable(var4);
      return var4;
   }

   public IonBitmapRequestBuilder animateIn(int var1) {
      this.inAnimationResource = var1;
      return this;
   }

   public IonBitmapRequestBuilder animateIn(Animation var1) {
      this.inAnimation = var1;
      return this;
   }

   public IonBitmapRequestBuilder animateLoad(int var1) {
      this.loadAnimationResource = var1;
      return this;
   }

   public IonBitmapRequestBuilder animateLoad(Animation var1) {
      this.loadAnimation = var1;
      return this;
   }

   public Future<Bitmap> asBitmap() {
      if(this.builder.uri == null) {
         return FUTURE_BITMAP_NULL_URI;
      } else {
         BitmapInfo var1 = this.execute();
         if(var1 != null) {
            SimpleFuture var2 = new SimpleFuture();
            var2.setComplete((Object)var1.bitmap);
            return var2;
         } else {
            IonBitmapRequestBuilder.BitmapInfoToBitmap var4 = new IonBitmapRequestBuilder.BitmapInfoToBitmap(null);
            this.ion.bitmapsPending.add(this.bitmapKey, var4);
            return var4;
         }
      }
   }

   public IonBitmapRequestBuilder centerCrop() {
      if(this.resizeWidth != 0 && this.resizeHeight != 0) {
         this.scaleMode = IonBitmapRequestBuilder.ScaleMode.CenterCrop;
         return this;
      } else {
         throw new IllegalStateException("must call resize first");
      }
   }

   public IonBitmapRequestBuilder centerInside() {
      if(this.resizeWidth != 0 && this.resizeHeight != 0) {
         this.scaleMode = IonBitmapRequestBuilder.ScaleMode.CenterInside;
         return this;
      } else {
         throw new IllegalStateException("must call resize first");
      }
   }

   public IonBitmapRequestBuilder error(int var1) {
      this.errorResource = var1;
      return this;
   }

   public IonBitmapRequestBuilder error(Drawable var1) {
      this.errorDrawable = var1;
      return this;
   }

   BitmapInfo execute() {
      boolean var1 = true;
      final String var2 = this.builder.uri;
      if(!$assertionsDisabled && Thread.currentThread() != Looper.getMainLooper().getThread()) {
         throw new AssertionError();
      } else if(!$assertionsDisabled && var2 == null) {
         throw new AssertionError();
      } else {
         if(this.resizeHeight != 0 || this.resizeWidth != 0) {
            this.transform(new IonBitmapRequestBuilder.DefaultTransform(this.resizeWidth, this.resizeHeight, this.scaleMode));
         }

         this.bitmapKey = var2;
         boolean var4;
         if(this.transforms != null && this.transforms.size() > 0) {
            var4 = var1;
         } else {
            var4 = false;
         }

         Transform var11;
         if(var4) {
            for(Iterator var10 = this.transforms.iterator(); var10.hasNext(); this.bitmapKey = this.bitmapKey + var11.key()) {
               var11 = (Transform)var10.next();
            }
         }

         BitmapInfo var5 = this.builder.ion.bitmapCache.get(this.bitmapKey);
         if(var5 != null) {
            return var5;
         } else {
            if(!this.ion.bitmapsPending.contains(var2)) {
               this.builder.setHandler((Handler)null);
               IonRequestBuilder.EmitterTransform var7 = this.builder.execute(new ByteBufferListParser(), new Runnable() {
                  public void run() {
                     AsyncServer.post(Ion.mainHandler, new Runnable() {
                        public void run() {
                           IonBitmapRequestBuilder.this.ion.bitmapsPending.remove(var2);
                        }
                     });
                  }
               });
               Ion var8 = this.ion;
               if(var4) {
                  var1 = false;
               }

               var7.setCallback(new LoadBitmap(var8, var2, var1, this.resizeWidth, this.resizeHeight, var7));
            }

            if(!var4) {
               return null;
            } else {
               if(!this.ion.bitmapsPending.contains(var2) || !this.ion.bitmapsPending.contains(this.bitmapKey)) {
                  this.ion.bitmapsPending.add(var2, new BitmapToBitmapInfo(this.ion, this.bitmapKey, this.transforms));
               }

               return null;
            }
         }
      }
   }

   public Future<ImageView> intoImageView(ImageView var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("imageView");
      } else if(!$assertionsDisabled && Thread.currentThread() != Looper.getMainLooper().getThread()) {
         throw new AssertionError();
      } else if(this.builder.uri == null) {
         this.bitmapKey = null;
         this.setIonDrawable(var1, (BitmapInfo)null, 0).cancel();
         return FUTURE_IMAGEVIEW_NULL_URI;
      } else {
         BitmapInfo var2 = this.execute();
         if(var2 != null) {
            doAnimation(var1, (Animation)null, 0);
            IonDrawable var6 = this.setIonDrawable(var1, var2, 0);
            var6.cancel();
            SimpleFuture var8 = var6.getFuture();
            var8.reset();
            var8.setComplete((Object)var1);
            return var8;
         } else {
            IonDrawable var3 = this.setIonDrawable(var1, (BitmapInfo)null, 0);
            doAnimation(var1, this.loadAnimation, this.loadAnimationResource);
            SimpleFuture var4 = var3.getFuture();
            var4.reset();
            var3.register(this.ion, this.bitmapKey);
            return var4;
         }
      }
   }

   public Future<ImageView> load(String var1) {
      this.ensureBuilder();
      this.builder.load(var1);
      return this.intoImageView((ImageView)this.imageViewPostRef.get());
   }

   public Future<ImageView> load(String var1, String var2) {
      this.ensureBuilder();
      this.builder.load(var1, var2);
      return this.intoImageView((ImageView)this.imageViewPostRef.get());
   }

   public IonBitmapRequestBuilder placeholder(int var1) {
      this.placeholderResource = var1;
      return this;
   }

   public IonBitmapRequestBuilder placeholder(Drawable var1) {
      this.placeholderDrawable = var1;
      return this;
   }

   void reset() {
      this.placeholderDrawable = null;
      this.placeholderResource = 0;
      this.errorDrawable = null;
      this.errorResource = 0;
      this.ion = null;
      this.imageViewPostRef = null;
      this.transforms = null;
      this.bitmapKey = null;
      this.inAnimation = null;
      this.inAnimationResource = 0;
      this.loadAnimation = null;
      this.loadAnimationResource = 0;
      this.scaleMode = IonBitmapRequestBuilder.ScaleMode.FitXY;
      this.resizeWidth = 0;
      this.resizeHeight = 0;
      this.builder = null;
   }

   public IonBitmapRequestBuilder resize(int var1, int var2) {
      this.resizeWidth = var1;
      this.resizeHeight = var2;
      return this;
   }

   public IonBitmapRequestBuilder transform(Transform var1) {
      if(this.transforms == null) {
         this.transforms = new ArrayList();
      }

      this.transforms.add(var1);
      return this;
   }

   IonBitmapRequestBuilder withImageView(ImageView var1) {
      this.imageViewPostRef = new WeakReference(var1);
      return this;
   }

   private static class BitmapInfoToBitmap extends TransformFuture<Bitmap, BitmapInfo> {
      private BitmapInfoToBitmap() {
      }

      // $FF: synthetic method
      BitmapInfoToBitmap(Object var1) {
         this();
      }

      protected void transform(BitmapInfo var1) throws Exception {
         this.setComplete(var1.bitmap);
      }
   }

   private static class DefaultTransform implements Transform {
      int resizeHeight;
      int resizeWidth;
      IonBitmapRequestBuilder.ScaleMode scaleMode;

      public DefaultTransform(int var1, int var2, IonBitmapRequestBuilder.ScaleMode var3) {
         this.resizeWidth = var1;
         this.resizeHeight = var2;
         this.scaleMode = var3;
      }

      public String key() {
         return this.scaleMode.name() + this.resizeWidth + "x" + this.resizeHeight;
      }

      public Bitmap transform(Bitmap var1) {
         Bitmap var2 = Bitmap.createBitmap(this.resizeWidth, this.resizeHeight, var1.getConfig());
         Canvas var3 = new Canvas(var2);
         float var4 = (float)this.resizeWidth / (float)var1.getWidth();
         float var5 = (float)this.resizeHeight / (float)var1.getHeight();
         IonBitmapRequestBuilder.ScaleMode var6 = this.scaleMode;
         IonBitmapRequestBuilder.ScaleMode var7 = IonBitmapRequestBuilder.ScaleMode.FitXY;
         float var8 = 0.0F;
         float var9 = 0.0F;
         if(var6 != var7) {
            float var10;
            if(this.scaleMode == IonBitmapRequestBuilder.ScaleMode.CenterCrop) {
               var10 = Math.max(var4, var5);
            } else {
               var10 = Math.min(var4, var5);
            }

            var4 = var10;
            var5 = var10;
            float var11 = var10 * (float)var1.getWidth();
            float var12 = var10 * (float)var1.getHeight();
            var8 = ((float)this.resizeWidth - var11) / 2.0F;
            var9 = ((float)this.resizeHeight - var12) / 2.0F;
         }

         var3.scale(var4, var5);
         var3.drawBitmap(var1, var8, var9, (Paint)null);
         return var2;
      }
   }

   static enum ScaleMode {
      CenterCrop,
      CenterInside,
      FitXY;

      static {
         IonBitmapRequestBuilder.ScaleMode[] var0 = new IonBitmapRequestBuilder.ScaleMode[]{FitXY, CenterCrop, CenterInside};
      }
   }
}
