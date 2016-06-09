package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.utils.class_52;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class ViewAware implements ImageAware {
   protected boolean checkActualViewSize;
   protected Reference<View> viewRef;

   public ViewAware(View var1) {
      this(var1, true);
   }

   public ViewAware(View var1, boolean var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("view must not be null");
      } else {
         this.viewRef = new WeakReference(var1);
         this.checkActualViewSize = var2;
      }
   }

   public int getHeight() {
      View var1 = (View)this.viewRef.get();
      if(var1 != null) {
         LayoutParams var2 = var1.getLayoutParams();
         boolean var3 = this.checkActualViewSize;
         int var4 = 0;
         if(var3) {
            var4 = 0;
            if(var2 != null) {
               int var5 = var2.height;
               var4 = 0;
               if(var5 != -2) {
                  var4 = var1.getHeight();
               }
            }
         }

         if(var4 <= 0 && var2 != null) {
            var4 = var2.height;
         }

         return var4;
      } else {
         return 0;
      }
   }

   public int getId() {
      View var1 = (View)this.viewRef.get();
      return var1 == null?super.hashCode():var1.hashCode();
   }

   public ViewScaleType getScaleType() {
      return ViewScaleType.CROP;
   }

   public int getWidth() {
      View var1 = (View)this.viewRef.get();
      if(var1 != null) {
         LayoutParams var2 = var1.getLayoutParams();
         boolean var3 = this.checkActualViewSize;
         int var4 = 0;
         if(var3) {
            var4 = 0;
            if(var2 != null) {
               int var5 = var2.width;
               var4 = 0;
               if(var5 != -2) {
                  var4 = var1.getWidth();
               }
            }
         }

         if(var4 <= 0 && var2 != null) {
            var4 = var2.width;
         }

         return var4;
      } else {
         return 0;
      }
   }

   public View getWrappedView() {
      return (View)this.viewRef.get();
   }

   public boolean isCollected() {
      return this.viewRef.get() == null;
   }

   public boolean setImageBitmap(Bitmap var1) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         View var2 = (View)this.viewRef.get();
         boolean var3 = false;
         if(var2 != null) {
            this.setImageBitmapInto(var1, var2);
            var3 = true;
         }

         return var3;
      } else {
         class_52.method_333("Can\'t set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
         return false;
      }
   }

   protected abstract void setImageBitmapInto(Bitmap var1, View var2);

   public boolean setImageDrawable(Drawable var1) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         View var2 = (View)this.viewRef.get();
         boolean var3 = false;
         if(var2 != null) {
            this.setImageDrawableInto(var1, var2);
            var3 = true;
         }

         return var3;
      } else {
         class_52.method_333("Can\'t set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
         return false;
      }
   }

   protected abstract void setImageDrawableInto(Drawable var1, View var2);
}
