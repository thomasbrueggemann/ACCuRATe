package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.drawee.drawable.DrawableUtils;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;

public class ForwardingDrawable extends Drawable implements Callback, DrawableParent, TransformAwareDrawable, TransformCallback {
   private static final Matrix sTempTransform = new Matrix();
   private Drawable mCurrentDelegate;
   private final DrawableProperties mDrawableProperties = new DrawableProperties();
   protected TransformCallback mTransformCallback;

   public ForwardingDrawable(Drawable var1) {
      this.mCurrentDelegate = var1;
      DrawableUtils.setCallbacks(this.mCurrentDelegate, this, this);
   }

   public void draw(Canvas var1) {
      this.mCurrentDelegate.draw(var1);
   }

   public Drawable getCurrent() {
      return this.mCurrentDelegate;
   }

   public Drawable getDrawable() {
      return this.getCurrent();
   }

   public int getIntrinsicHeight() {
      return this.mCurrentDelegate.getIntrinsicHeight();
   }

   public int getIntrinsicWidth() {
      return this.mCurrentDelegate.getIntrinsicWidth();
   }

   public int getOpacity() {
      return this.mCurrentDelegate.getOpacity();
   }

   public boolean getPadding(Rect var1) {
      return this.mCurrentDelegate.getPadding(var1);
   }

   protected void getParentTransform(Matrix var1) {
      if(this.mTransformCallback != null) {
         this.mTransformCallback.getTransform(var1);
      } else {
         var1.reset();
      }
   }

   public void getRootBounds(RectF var1) {
      if(this.mTransformCallback != null) {
         this.mTransformCallback.getRootBounds(var1);
      } else {
         var1.set(this.getBounds());
      }
   }

   public void getTransform(Matrix var1) {
      this.getParentTransform(var1);
   }

   public void getTransformedBounds(RectF var1) {
      this.getParentTransform(sTempTransform);
      var1.set(this.getBounds());
      sTempTransform.mapRect(var1);
   }

   public void invalidateDrawable(Drawable var1) {
      this.invalidateSelf();
   }

   public boolean isStateful() {
      return this.mCurrentDelegate.isStateful();
   }

   public Drawable mutate() {
      this.mCurrentDelegate.mutate();
      return this;
   }

   protected void onBoundsChange(Rect var1) {
      this.mCurrentDelegate.setBounds(var1);
   }

   protected boolean onLevelChange(int var1) {
      return this.mCurrentDelegate.setLevel(var1);
   }

   protected boolean onStateChange(int[] var1) {
      return this.mCurrentDelegate.setState(var1);
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      this.scheduleSelf(var2, var3);
   }

   public void setAlpha(int var1) {
      this.mDrawableProperties.setAlpha(var1);
      this.mCurrentDelegate.setAlpha(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.mDrawableProperties.setColorFilter(var1);
      this.mCurrentDelegate.setColorFilter(var1);
   }

   public Drawable setCurrent(Drawable var1) {
      Drawable var2 = this.setCurrentWithoutInvalidate(var1);
      this.invalidateSelf();
      return var2;
   }

   protected Drawable setCurrentWithoutInvalidate(Drawable var1) {
      Drawable var2 = this.mCurrentDelegate;
      DrawableUtils.setCallbacks(var2, (Callback)null, (TransformCallback)null);
      DrawableUtils.setCallbacks(var1, (Callback)null, (TransformCallback)null);
      DrawableUtils.setDrawableProperties(var1, this.mDrawableProperties);
      DrawableUtils.copyProperties(var1, var2);
      DrawableUtils.setCallbacks(var1, this, this);
      this.mCurrentDelegate = var1;
      return var2;
   }

   public void setDither(boolean var1) {
      this.mDrawableProperties.setDither(var1);
      this.mCurrentDelegate.setDither(var1);
   }

   public Drawable setDrawable(Drawable var1) {
      return this.setCurrent(var1);
   }

   public void setFilterBitmap(boolean var1) {
      this.mDrawableProperties.setFilterBitmap(var1);
      this.mCurrentDelegate.setFilterBitmap(var1);
   }

   public void setTransformCallback(TransformCallback var1) {
      this.mTransformCallback = var1;
   }

   public boolean setVisible(boolean var1, boolean var2) {
      super.setVisible(var1, var2);
      return this.mCurrentDelegate.setVisible(var1, var2);
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      this.unscheduleSelf(var2);
   }
}
