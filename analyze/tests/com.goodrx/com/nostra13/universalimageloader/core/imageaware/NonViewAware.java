package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class NonViewAware implements ImageAware {
   protected final ImageSize imageSize;
   protected final String imageUri;
   protected final ViewScaleType scaleType;

   public NonViewAware(String var1, ImageSize var2, ViewScaleType var3) {
      if(var2 == null) {
         throw new IllegalArgumentException("imageSize must not be null");
      } else if(var3 == null) {
         throw new IllegalArgumentException("scaleType must not be null");
      } else {
         this.imageUri = var1;
         this.imageSize = var2;
         this.scaleType = var3;
      }
   }

   public int getHeight() {
      return this.imageSize.getHeight();
   }

   public int getId() {
      return TextUtils.isEmpty(this.imageUri)?super.hashCode():this.imageUri.hashCode();
   }

   public ViewScaleType getScaleType() {
      return this.scaleType;
   }

   public int getWidth() {
      return this.imageSize.getWidth();
   }

   public View getWrappedView() {
      return null;
   }

   public boolean isCollected() {
      return false;
   }

   public boolean setImageBitmap(Bitmap var1) {
      return true;
   }

   public boolean setImageDrawable(Drawable var1) {
      return true;
   }
}
