package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ViewAware;
import com.nostra13.universalimageloader.utils.class_52;
import java.lang.reflect.Field;

public class ImageViewAware extends ViewAware {
   public ImageViewAware(ImageView var1) {
      super(var1);
   }

   private static int getImageViewFieldValue(Object var0, String var1) {
      int var4;
      try {
         Field var3 = ImageView.class.getDeclaredField(var1);
         var3.setAccessible(true);
         var4 = ((Integer)var3.get(var0)).intValue();
      } catch (Exception var6) {
         class_52.method_331(var6);
         return 0;
      }

      int var5 = 0;
      if(var4 > 0) {
         var5 = 0;
         if(var4 < Integer.MAX_VALUE) {
            var5 = var4;
         }
      }

      return var5;
   }

   public int getHeight() {
      int var1 = super.getHeight();
      if(var1 <= 0) {
         ImageView var2 = (ImageView)this.viewRef.get();
         if(var2 != null) {
            var1 = getImageViewFieldValue(var2, "mMaxHeight");
         }
      }

      return var1;
   }

   public ViewScaleType getScaleType() {
      ImageView var1 = (ImageView)this.viewRef.get();
      return var1 != null?ViewScaleType.fromImageView(var1):super.getScaleType();
   }

   public int getWidth() {
      int var1 = super.getWidth();
      if(var1 <= 0) {
         ImageView var2 = (ImageView)this.viewRef.get();
         if(var2 != null) {
            var1 = getImageViewFieldValue(var2, "mMaxWidth");
         }
      }

      return var1;
   }

   public ImageView getWrappedView() {
      return (ImageView)super.getWrappedView();
   }

   protected void setImageBitmapInto(Bitmap var1, View var2) {
      ((ImageView)var2).setImageBitmap(var1);
   }

   protected void setImageDrawableInto(Drawable var1, View var2) {
      ((ImageView)var2).setImageDrawable(var1);
      if(var1 instanceof AnimationDrawable) {
         ((AnimationDrawable)var1).start();
      }

   }
}
