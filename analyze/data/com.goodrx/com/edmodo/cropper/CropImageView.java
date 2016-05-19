package com.edmodo.cropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.edmodo.cropper.class_14;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.util.ImageViewUtil;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;

public class CropImageView extends FrameLayout {
   private static final Rect EMPTY_RECT = new Rect();
   private int mAspectRatioX = 1;
   private int mAspectRatioY = 1;
   private Bitmap mBitmap;
   private CropOverlayView mCropOverlayView;
   private int mDegreesRotated = 0;
   private boolean mFixAspectRatio = false;
   private int mGuidelines = 1;
   private int mImageResource = 0;
   private ImageView mImageView;
   private int mLayoutHeight;
   private int mLayoutWidth;

   public CropImageView(Context var1) {
      super(var1);
      this.init(var1);
   }

   public CropImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_14.styleable.CropImageView, 0, 0);

      try {
         this.mGuidelines = var3.getInteger(0, 1);
         this.mFixAspectRatio = var3.getBoolean(1, false);
         this.mAspectRatioX = var3.getInteger(2, 1);
         this.mAspectRatioY = var3.getInteger(3, 1);
         this.mImageResource = var3.getResourceId(4, 0);
      } finally {
         var3.recycle();
      }

      this.init(var1);
   }

   private static int getOnMeasureSpec(int var0, int var1, int var2) {
      return var0 == 1073741824?var1:(var0 == Integer.MIN_VALUE?Math.min(var2, var1):var2);
   }

   private void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(class_14.layout.crop_image_view, this, true);
      this.mImageView = (ImageView)var2.findViewById(class_14.class_106.ImageView_image);
      this.setImageResource(this.mImageResource);
      this.mCropOverlayView = (CropOverlayView)var2.findViewById(class_14.class_106.CropOverlayView);
      this.mCropOverlayView.setInitialAttributeValues(this.mGuidelines, this.mFixAspectRatio, this.mAspectRatioX, this.mAspectRatioY);
   }

   public RectF getActualCropRect() {
      Rect var1 = ImageViewUtil.getBitmapRectCenterInside(this.mBitmap, this.mImageView);
      float var2 = (float)this.mBitmap.getWidth() / (float)var1.width();
      float var3 = (float)this.mBitmap.getHeight() / (float)var1.height();
      float var4 = Edge.LEFT.getCoordinate() - (float)var1.left;
      float var5 = Edge.TOP.getCoordinate() - (float)var1.top;
      float var6 = Edge.getWidth();
      float var7 = Edge.getHeight();
      float var8 = var4 * var2;
      float var9 = var5 * var3;
      float var10 = var8 + var6 * var2;
      float var11 = var9 + var7 * var3;
      return new RectF(Math.max(0.0F, var8), Math.max(0.0F, var9), Math.min((float)this.mBitmap.getWidth(), var10), Math.min((float)this.mBitmap.getHeight(), var11));
   }

   public Bitmap getCroppedImage() {
      Rect var1 = ImageViewUtil.getBitmapRectCenterInside(this.mBitmap, this.mImageView);
      float var2 = (float)this.mBitmap.getWidth() / (float)var1.width();
      float var3 = (float)this.mBitmap.getHeight() / (float)var1.height();
      float var4 = Edge.LEFT.getCoordinate() - (float)var1.left;
      float var5 = Edge.TOP.getCoordinate() - (float)var1.top;
      float var6 = Edge.getWidth();
      float var7 = Edge.getHeight();
      float var8 = var4 * var2;
      float var9 = var5 * var3;
      float var10 = var6 * var2;
      float var11 = var7 * var3;
      return Bitmap.createBitmap(this.mBitmap, (int)var8, (int)var9, (int)var10, (int)var11);
   }

   public int getImageResource() {
      return this.mImageResource;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      if(this.mLayoutWidth > 0 && this.mLayoutHeight > 0) {
         LayoutParams var6 = this.getLayoutParams();
         var6.width = this.mLayoutWidth;
         var6.height = this.mLayoutHeight;
         this.setLayoutParams(var6);
      }

   }

   protected void onMeasure(int var1, int var2) {
      int var3 = MeasureSpec.getMode(var1);
      int var4 = MeasureSpec.getSize(var1);
      int var5 = MeasureSpec.getMode(var2);
      int var6 = MeasureSpec.getSize(var2);
      if(this.mBitmap != null) {
         super.onMeasure(var1, var2);
         if(var6 == 0) {
            var6 = this.mBitmap.getHeight();
         }

         double var7 = Double.POSITIVE_INFINITY;
         double var9 = Double.POSITIVE_INFINITY;
         if(var4 < this.mBitmap.getWidth()) {
            var7 = (double)var4 / (double)this.mBitmap.getWidth();
         }

         if(var6 < this.mBitmap.getHeight()) {
            var9 = (double)var6 / (double)this.mBitmap.getHeight();
         }

         int var11;
         int var12;
         if(var7 == Double.POSITIVE_INFINITY && var9 == Double.POSITIVE_INFINITY) {
            var12 = this.mBitmap.getWidth();
            var11 = this.mBitmap.getHeight();
         } else if(var7 <= var9) {
            var12 = var4;
            var11 = (int)(var7 * (double)this.mBitmap.getHeight());
         } else {
            var11 = var6;
            var12 = (int)(var9 * (double)this.mBitmap.getWidth());
         }

         int var13 = getOnMeasureSpec(var3, var4, var12);
         int var14 = getOnMeasureSpec(var5, var6, var11);
         this.mLayoutWidth = var13;
         this.mLayoutHeight = var14;
         Rect var15 = ImageViewUtil.getBitmapRectCenterInside(this.mBitmap.getWidth(), this.mBitmap.getHeight(), this.mLayoutWidth, this.mLayoutHeight);
         this.mCropOverlayView.setBitmapRect(var15);
         this.setMeasuredDimension(this.mLayoutWidth, this.mLayoutHeight);
      } else {
         this.mCropOverlayView.setBitmapRect(EMPTY_RECT);
         this.setMeasuredDimension(var4, var6);
      }
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if(var1 instanceof Bundle) {
         Bundle var2 = (Bundle)var1;
         if(this.mBitmap != null) {
            this.mDegreesRotated = var2.getInt("DEGREES_ROTATED");
            int var3 = this.mDegreesRotated;
            this.rotateImage(this.mDegreesRotated);
            this.mDegreesRotated = var3;
         }

         super.onRestoreInstanceState(var2.getParcelable("instanceState"));
      } else {
         super.onRestoreInstanceState(var1);
      }
   }

   public Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      var1.putParcelable("instanceState", super.onSaveInstanceState());
      var1.putInt("DEGREES_ROTATED", this.mDegreesRotated);
      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      if(this.mBitmap != null) {
         Rect var5 = ImageViewUtil.getBitmapRectCenterInside(this.mBitmap, this);
         this.mCropOverlayView.setBitmapRect(var5);
      } else {
         this.mCropOverlayView.setBitmapRect(EMPTY_RECT);
      }
   }

   public void rotateImage(int var1) {
      Matrix var2 = new Matrix();
      var2.postRotate((float)var1);
      this.mBitmap = Bitmap.createBitmap(this.mBitmap, 0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight(), var2, true);
      this.setImageBitmap(this.mBitmap);
      this.mDegreesRotated += var1;
      this.mDegreesRotated %= 360;
   }

   public void setAspectRatio(int var1, int var2) {
      this.mAspectRatioX = var1;
      this.mCropOverlayView.setAspectRatioX(this.mAspectRatioX);
      this.mAspectRatioY = var2;
      this.mCropOverlayView.setAspectRatioY(this.mAspectRatioY);
   }

   public void setFixedAspectRatio(boolean var1) {
      this.mCropOverlayView.setFixedAspectRatio(var1);
   }

   public void setGuidelines(int var1) {
      this.mCropOverlayView.setGuidelines(var1);
   }

   public void setImageBitmap(Bitmap var1) {
      this.mBitmap = var1;
      this.mImageView.setImageBitmap(this.mBitmap);
      if(this.mCropOverlayView != null) {
         this.mCropOverlayView.resetCropOverlayView();
      }

   }

   public void setImageResource(int var1) {
      if(var1 != 0) {
         this.setImageBitmap(BitmapFactoryInstrumentation.decodeResource(this.getResources(), var1));
      }

   }
}
