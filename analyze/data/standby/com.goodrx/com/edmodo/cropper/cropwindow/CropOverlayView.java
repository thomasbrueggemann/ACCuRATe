package com.edmodo.cropper.cropwindow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.cropwindow.handle.Handle;
import com.edmodo.cropper.util.AspectRatioUtil;
import com.edmodo.cropper.util.HandleUtil;
import com.edmodo.cropper.util.PaintUtil;

public class CropOverlayView extends View {
   private static final float DEFAULT_CORNER_EXTENSION_DP;
   private static final float DEFAULT_CORNER_OFFSET_DP;
   private static final float DEFAULT_CORNER_THICKNESS_DP = PaintUtil.getCornerThickness();
   private static final float DEFAULT_LINE_THICKNESS_DP = PaintUtil.getLineThickness();
   private boolean initializedCropWindow;
   private int mAspectRatioX = 1;
   private int mAspectRatioY = 1;
   private Paint mBackgroundPaint;
   private Rect mBitmapRect;
   private Paint mBorderPaint;
   private float mCornerExtension;
   private float mCornerLength;
   private float mCornerOffset;
   private Paint mCornerPaint;
   private boolean mFixAspectRatio = false;
   private Paint mGuidelinePaint;
   private int mGuidelines;
   private float mHandleRadius;
   private Handle mPressedHandle;
   private float mSnapRadius;
   private float mTargetAspectRatio;
   private Pair<Float, Float> mTouchOffset;

   static {
      DEFAULT_CORNER_OFFSET_DP = DEFAULT_CORNER_THICKNESS_DP / 2.0F - DEFAULT_LINE_THICKNESS_DP / 2.0F;
      DEFAULT_CORNER_EXTENSION_DP = DEFAULT_CORNER_THICKNESS_DP / 2.0F + DEFAULT_CORNER_OFFSET_DP;
   }

   public CropOverlayView(Context var1) {
      super(var1);
      this.mTargetAspectRatio = (float)this.mAspectRatioX / (float)this.mAspectRatioY;
      this.initializedCropWindow = false;
      this.init(var1);
   }

   public CropOverlayView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.mTargetAspectRatio = (float)this.mAspectRatioX / (float)this.mAspectRatioY;
      this.initializedCropWindow = false;
      this.init(var1);
   }

   private void drawBackground(Canvas var1, Rect var2) {
      float var3 = Edge.LEFT.getCoordinate();
      float var4 = Edge.TOP.getCoordinate();
      float var5 = Edge.RIGHT.getCoordinate();
      float var6 = Edge.BOTTOM.getCoordinate();
      var1.drawRect((float)var2.left, (float)var2.top, (float)var2.right, var4, this.mBackgroundPaint);
      var1.drawRect((float)var2.left, var6, (float)var2.right, (float)var2.bottom, this.mBackgroundPaint);
      var1.drawRect((float)var2.left, var4, var3, var6, this.mBackgroundPaint);
      var1.drawRect(var5, var4, (float)var2.right, var6, this.mBackgroundPaint);
   }

   private void drawCorners(Canvas var1) {
      float var2 = Edge.LEFT.getCoordinate();
      float var3 = Edge.TOP.getCoordinate();
      float var4 = Edge.RIGHT.getCoordinate();
      float var5 = Edge.BOTTOM.getCoordinate();
      var1.drawLine(var2 - this.mCornerOffset, var3 - this.mCornerExtension, var2 - this.mCornerOffset, var3 + this.mCornerLength, this.mCornerPaint);
      var1.drawLine(var2, var3 - this.mCornerOffset, var2 + this.mCornerLength, var3 - this.mCornerOffset, this.mCornerPaint);
      var1.drawLine(var4 + this.mCornerOffset, var3 - this.mCornerExtension, var4 + this.mCornerOffset, var3 + this.mCornerLength, this.mCornerPaint);
      var1.drawLine(var4, var3 - this.mCornerOffset, var4 - this.mCornerLength, var3 - this.mCornerOffset, this.mCornerPaint);
      var1.drawLine(var2 - this.mCornerOffset, var5 + this.mCornerExtension, var2 - this.mCornerOffset, var5 - this.mCornerLength, this.mCornerPaint);
      var1.drawLine(var2, var5 + this.mCornerOffset, var2 + this.mCornerLength, var5 + this.mCornerOffset, this.mCornerPaint);
      var1.drawLine(var4 + this.mCornerOffset, var5 + this.mCornerExtension, var4 + this.mCornerOffset, var5 - this.mCornerLength, this.mCornerPaint);
      var1.drawLine(var4, var5 + this.mCornerOffset, var4 - this.mCornerLength, var5 + this.mCornerOffset, this.mCornerPaint);
   }

   private void drawRuleOfThirdsGuidelines(Canvas var1) {
      float var2 = Edge.LEFT.getCoordinate();
      float var3 = Edge.TOP.getCoordinate();
      float var4 = Edge.RIGHT.getCoordinate();
      float var5 = Edge.BOTTOM.getCoordinate();
      float var6 = Edge.getWidth() / 3.0F;
      float var7 = var2 + var6;
      var1.drawLine(var7, var3, var7, var5, this.mGuidelinePaint);
      float var8 = var4 - var6;
      var1.drawLine(var8, var3, var8, var5, this.mGuidelinePaint);
      float var9 = Edge.getHeight() / 3.0F;
      float var10 = var3 + var9;
      var1.drawLine(var2, var10, var4, var10, this.mGuidelinePaint);
      float var11 = var5 - var9;
      var1.drawLine(var2, var11, var4, var11, this.mGuidelinePaint);
   }

   private void init(Context var1) {
      DisplayMetrics var2 = var1.getResources().getDisplayMetrics();
      this.mHandleRadius = HandleUtil.getTargetRadius(var1);
      this.mSnapRadius = TypedValue.applyDimension(1, 6.0F, var2);
      this.mBorderPaint = PaintUtil.newBorderPaint(var1);
      this.mGuidelinePaint = PaintUtil.newGuidelinePaint();
      this.mBackgroundPaint = PaintUtil.newBackgroundPaint(var1);
      this.mCornerPaint = PaintUtil.newCornerPaint(var1);
      this.mCornerOffset = TypedValue.applyDimension(1, DEFAULT_CORNER_OFFSET_DP, var2);
      this.mCornerExtension = TypedValue.applyDimension(1, DEFAULT_CORNER_EXTENSION_DP, var2);
      this.mCornerLength = TypedValue.applyDimension(1, 20.0F, var2);
      this.mGuidelines = 1;
   }

   private void initCropWindow(Rect var1) {
      if(!this.initializedCropWindow) {
         this.initializedCropWindow = true;
      }

      if(this.mFixAspectRatio) {
         if(AspectRatioUtil.calculateAspectRatio(var1) > this.mTargetAspectRatio) {
            Edge.TOP.setCoordinate((float)var1.top);
            Edge.BOTTOM.setCoordinate((float)var1.bottom);
            float var7 = (float)this.getWidth() / 2.0F;
            float var8 = Math.max(40.0F, AspectRatioUtil.calculateWidth(Edge.TOP.getCoordinate(), Edge.BOTTOM.getCoordinate(), this.mTargetAspectRatio));
            if(var8 == 40.0F) {
               this.mTargetAspectRatio = 40.0F / (Edge.BOTTOM.getCoordinate() - Edge.TOP.getCoordinate());
            }

            float var9 = var8 / 2.0F;
            Edge.LEFT.setCoordinate(var7 - var9);
            Edge.RIGHT.setCoordinate(var7 + var9);
         } else {
            Edge.LEFT.setCoordinate((float)var1.left);
            Edge.RIGHT.setCoordinate((float)var1.right);
            float var4 = (float)this.getHeight() / 2.0F;
            float var5 = Math.max(40.0F, AspectRatioUtil.calculateHeight(Edge.LEFT.getCoordinate(), Edge.RIGHT.getCoordinate(), this.mTargetAspectRatio));
            if(var5 == 40.0F) {
               this.mTargetAspectRatio = (Edge.RIGHT.getCoordinate() - Edge.LEFT.getCoordinate()) / 40.0F;
            }

            float var6 = var5 / 2.0F;
            Edge.TOP.setCoordinate(var4 - var6);
            Edge.BOTTOM.setCoordinate(var4 + var6);
         }
      } else {
         float var2 = 0.1F * (float)var1.width();
         float var3 = 0.1F * (float)var1.height();
         Edge.LEFT.setCoordinate(var2 + (float)var1.left);
         Edge.TOP.setCoordinate(var3 + (float)var1.top);
         Edge.RIGHT.setCoordinate((float)var1.right - var2);
         Edge.BOTTOM.setCoordinate((float)var1.bottom - var3);
      }
   }

   private void onActionDown(float var1, float var2) {
      float var3 = Edge.LEFT.getCoordinate();
      float var4 = Edge.TOP.getCoordinate();
      float var5 = Edge.RIGHT.getCoordinate();
      float var6 = Edge.BOTTOM.getCoordinate();
      this.mPressedHandle = HandleUtil.getPressedHandle(var1, var2, var3, var4, var5, var6, this.mHandleRadius);
      if(this.mPressedHandle != null) {
         this.mTouchOffset = HandleUtil.getOffset(this.mPressedHandle, var1, var2, var3, var4, var5, var6);
         this.invalidate();
      }
   }

   private void onActionMove(float var1, float var2) {
      if(this.mPressedHandle != null) {
         float var3 = var1 + ((Float)this.mTouchOffset.first).floatValue();
         float var4 = var2 + ((Float)this.mTouchOffset.second).floatValue();
         if(this.mFixAspectRatio) {
            this.mPressedHandle.updateCropWindow(var3, var4, this.mTargetAspectRatio, this.mBitmapRect, this.mSnapRadius);
         } else {
            this.mPressedHandle.updateCropWindow(var3, var4, this.mBitmapRect, this.mSnapRadius);
         }

         this.invalidate();
      }
   }

   private void onActionUp() {
      if(this.mPressedHandle != null) {
         this.mPressedHandle = null;
         this.invalidate();
      }
   }

   public static boolean showGuidelines() {
      return Math.abs(Edge.LEFT.getCoordinate() - Edge.RIGHT.getCoordinate()) >= 100.0F && Math.abs(Edge.TOP.getCoordinate() - Edge.BOTTOM.getCoordinate()) >= 100.0F;
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      this.drawBackground(var1, this.mBitmapRect);
      if(showGuidelines()) {
         if(this.mGuidelines == 2) {
            this.drawRuleOfThirdsGuidelines(var1);
         } else if(this.mGuidelines == 1) {
            if(this.mPressedHandle != null) {
               this.drawRuleOfThirdsGuidelines(var1);
            }
         } else if(this.mGuidelines == 0) {
            ;
         }
      }

      var1.drawRect(Edge.LEFT.getCoordinate(), Edge.TOP.getCoordinate(), Edge.RIGHT.getCoordinate(), Edge.BOTTOM.getCoordinate(), this.mBorderPaint);
      this.drawCorners(var1);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      this.initCropWindow(this.mBitmapRect);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if(!this.isEnabled()) {
         return false;
      } else {
         switch(var1.getAction()) {
         case 0:
            this.onActionDown(var1.getX(), var1.getY());
            return true;
         case 1:
         case 3:
            this.getParent().requestDisallowInterceptTouchEvent(false);
            this.onActionUp();
            return true;
         case 2:
            this.onActionMove(var1.getX(), var1.getY());
            this.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
         default:
            return false;
         }
      }
   }

   public void resetCropOverlayView() {
      if(this.initializedCropWindow) {
         this.initCropWindow(this.mBitmapRect);
         this.invalidate();
      }

   }

   public void setAspectRatioX(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
      } else {
         this.mAspectRatioX = var1;
         this.mTargetAspectRatio = (float)this.mAspectRatioX / (float)this.mAspectRatioY;
         if(this.initializedCropWindow) {
            this.initCropWindow(this.mBitmapRect);
            this.invalidate();
         }

      }
   }

   public void setAspectRatioY(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
      } else {
         this.mAspectRatioY = var1;
         this.mTargetAspectRatio = (float)this.mAspectRatioX / (float)this.mAspectRatioY;
         if(this.initializedCropWindow) {
            this.initCropWindow(this.mBitmapRect);
            this.invalidate();
         }

      }
   }

   public void setBitmapRect(Rect var1) {
      this.mBitmapRect = var1;
      this.initCropWindow(this.mBitmapRect);
   }

   public void setFixedAspectRatio(boolean var1) {
      this.mFixAspectRatio = var1;
      if(this.initializedCropWindow) {
         this.initCropWindow(this.mBitmapRect);
         this.invalidate();
      }

   }

   public void setGuidelines(int var1) {
      if(var1 >= 0 && var1 <= 2) {
         this.mGuidelines = var1;
         if(this.initializedCropWindow) {
            this.initCropWindow(this.mBitmapRect);
            this.invalidate();
         }

      } else {
         throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
      }
   }

   public void setInitialAttributeValues(int var1, boolean var2, int var3, int var4) {
      if(var1 >= 0 && var1 <= 2) {
         this.mGuidelines = var1;
         this.mFixAspectRatio = var2;
         if(var3 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
         } else {
            this.mAspectRatioX = var3;
            this.mTargetAspectRatio = (float)this.mAspectRatioX / (float)this.mAspectRatioY;
            if(var4 <= 0) {
               throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else {
               this.mAspectRatioY = var4;
               this.mTargetAspectRatio = (float)this.mAspectRatioX / (float)this.mAspectRatioY;
            }
         }
      } else {
         throw new IllegalArgumentException("Guideline value must be set between 0 and 2. See documentation.");
      }
   }
}
