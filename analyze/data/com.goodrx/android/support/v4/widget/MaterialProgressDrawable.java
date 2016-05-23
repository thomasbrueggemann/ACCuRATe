package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

class MaterialProgressDrawable extends Drawable implements Animatable {
   private static final int ANIMATION_DURATION = 1332;
   private static final int ARROW_HEIGHT = 5;
   private static final int ARROW_HEIGHT_LARGE = 6;
   private static final float ARROW_OFFSET_ANGLE = 5.0F;
   private static final int ARROW_WIDTH = 10;
   private static final int ARROW_WIDTH_LARGE = 12;
   private static final float CENTER_RADIUS = 8.75F;
   private static final float CENTER_RADIUS_LARGE = 12.5F;
   private static final int CIRCLE_DIAMETER = 40;
   private static final int CIRCLE_DIAMETER_LARGE = 56;
   private static final float COLOR_START_DELAY_OFFSET = 0.75F;
   static final int DEFAULT = 1;
   private static final float END_TRIM_START_DELAY_OFFSET = 0.5F;
   private static final float FULL_ROTATION = 1080.0F;
   static final int LARGE = 0;
   private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
   private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
   private static final float MAX_PROGRESS_ARC = 0.8F;
   private static final float NUM_POINTS = 5.0F;
   private static final float START_TRIM_DURATION_OFFSET = 0.5F;
   private static final float STROKE_WIDTH = 2.5F;
   private static final float STROKE_WIDTH_LARGE = 3.0F;
   private final int[] COLORS = new int[]{-16777216};
   private Animation mAnimation;
   private final ArrayList<Animation> mAnimators = new ArrayList();
   private final Callback mCallback = new Callback() {
      public void invalidateDrawable(Drawable var1) {
         MaterialProgressDrawable.this.invalidateSelf();
      }

      public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
         MaterialProgressDrawable.this.scheduleSelf(var2, var3);
      }

      public void unscheduleDrawable(Drawable var1, Runnable var2) {
         MaterialProgressDrawable.this.unscheduleSelf(var2);
      }
   };
   boolean mFinishing;
   private double mHeight;
   private View mParent;
   private Resources mResources;
   private final MaterialProgressDrawable.Ring mRing;
   private float mRotation;
   private float mRotationCount;
   private double mWidth;

   public MaterialProgressDrawable(Context var1, View var2) {
      this.mParent = var2;
      this.mResources = var1.getResources();
      this.mRing = new MaterialProgressDrawable.Ring(this.mCallback);
      this.mRing.setColors(this.COLORS);
      this.updateSizes(1);
      this.setupAnimators();
   }

   private void applyFinishTranslation(float var1, MaterialProgressDrawable.Ring var2) {
      this.updateRingColor(var1, var2);
      float var3 = (float)(1.0D + Math.floor((double)(var2.getStartingRotation() / 0.8F)));
      float var4 = this.getMinProgressArc(var2);
      var2.setStartTrim(var2.getStartingStartTrim() + var1 * (var2.getStartingEndTrim() - var4 - var2.getStartingStartTrim()));
      var2.setEndTrim(var2.getStartingEndTrim());
      var2.setRotation(var2.getStartingRotation() + var1 * (var3 - var2.getStartingRotation()));
   }

   private int evaluateColorChange(float var1, int var2, int var3) {
      int var4 = Integer.valueOf(var2).intValue();
      int var5 = 255 & var4 >> 24;
      int var6 = 255 & var4 >> 16;
      int var7 = 255 & var4 >> 8;
      int var8 = var4 & 255;
      int var9 = Integer.valueOf(var3).intValue();
      int var10 = 255 & var9 >> 24;
      int var11 = 255 & var9 >> 16;
      int var12 = 255 & var9 >> 8;
      int var13 = var9 & 255;
      return var5 + (int)(var1 * (float)(var10 - var5)) << 24 | var6 + (int)(var1 * (float)(var11 - var6)) << 16 | var7 + (int)(var1 * (float)(var12 - var7)) << 8 | var8 + (int)(var1 * (float)(var13 - var8));
   }

   private float getMinProgressArc(MaterialProgressDrawable.Ring var1) {
      return (float)Math.toRadians((double)var1.getStrokeWidth() / (6.283185307179586D * var1.getCenterRadius()));
   }

   private float getRotation() {
      return this.mRotation;
   }

   private void setSizeParameters(double var1, double var3, double var5, double var7, float var9, float var10) {
      MaterialProgressDrawable.Ring var11 = this.mRing;
      float var12 = this.mResources.getDisplayMetrics().density;
      this.mWidth = var1 * (double)var12;
      this.mHeight = var3 * (double)var12;
      var11.setStrokeWidth(var12 * (float)var7);
      var11.setCenterRadius(var5 * (double)var12);
      var11.setColorIndex(0);
      var11.setArrowDimensions(var9 * var12, var10 * var12);
      var11.setInsets((int)this.mWidth, (int)this.mHeight);
   }

   private void setupAnimators() {
      final MaterialProgressDrawable.Ring var1 = this.mRing;
      Animation var2 = new Animation() {
         public void applyTransformation(float var1x, Transformation var2) {
            if(MaterialProgressDrawable.this.mFinishing) {
               MaterialProgressDrawable.this.applyFinishTranslation(var1x, var1);
            } else {
               float var3 = MaterialProgressDrawable.this.getMinProgressArc(var1);
               float var4 = var1.getStartingEndTrim();
               float var5 = var1.getStartingStartTrim();
               float var6 = var1.getStartingRotation();
               MaterialProgressDrawable.this.updateRingColor(var1x, var1);
               if(var1x <= 0.5F) {
                  float var12 = var1x / 0.5F;
                  float var13 = var5 + (0.8F - var3) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(var12);
                  var1.setStartTrim(var13);
               }

               if(var1x > 0.5F) {
                  float var9 = 0.8F - var3;
                  float var10 = (var1x - 0.5F) / 0.5F;
                  float var11 = var4 + var9 * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(var10);
                  var1.setEndTrim(var11);
               }

               float var7 = var6 + 0.25F * var1x;
               var1.setRotation(var7);
               float var8 = 216.0F * var1x + 1080.0F * (MaterialProgressDrawable.this.mRotationCount / 5.0F);
               MaterialProgressDrawable.this.setRotation(var8);
            }
         }
      };
      var2.setRepeatCount(-1);
      var2.setRepeatMode(1);
      var2.setInterpolator(LINEAR_INTERPOLATOR);
      var2.setAnimationListener(new AnimationListener() {
         public void onAnimationEnd(Animation var1x) {
         }

         public void onAnimationRepeat(Animation var1x) {
            var1.storeOriginals();
            var1.goToNextColor();
            var1.setStartTrim(var1.getEndTrim());
            if(MaterialProgressDrawable.this.mFinishing) {
               MaterialProgressDrawable.this.mFinishing = false;
               var1x.setDuration(1332L);
               var1.setShowArrow(false);
            } else {
               MaterialProgressDrawable.this.mRotationCount = (1.0F + MaterialProgressDrawable.this.mRotationCount) % 5.0F;
            }
         }

         public void onAnimationStart(Animation var1x) {
            MaterialProgressDrawable.this.mRotationCount = 0.0F;
         }
      });
      this.mAnimation = var2;
   }

   private void updateRingColor(float var1, MaterialProgressDrawable.Ring var2) {
      if(var1 > 0.75F) {
         var2.setColor(this.evaluateColorChange((var1 - 0.75F) / 0.25F, var2.getStartingColor(), var2.getNextColor()));
      }

   }

   public void draw(Canvas var1) {
      Rect var2 = this.getBounds();
      int var3 = var1.save();
      var1.rotate(this.mRotation, var2.exactCenterX(), var2.exactCenterY());
      this.mRing.draw(var1, var2);
      var1.restoreToCount(var3);
   }

   public int getAlpha() {
      return this.mRing.getAlpha();
   }

   public int getIntrinsicHeight() {
      return (int)this.mHeight;
   }

   public int getIntrinsicWidth() {
      return (int)this.mWidth;
   }

   public int getOpacity() {
      return -3;
   }

   public boolean isRunning() {
      ArrayList var1 = this.mAnimators;
      int var2 = var1.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         Animation var4 = (Animation)var1.get(var3);
         if(var4.hasStarted() && !var4.hasEnded()) {
            return true;
         }
      }

      return false;
   }

   public void setAlpha(int var1) {
      this.mRing.setAlpha(var1);
   }

   public void setArrowScale(float var1) {
      this.mRing.setArrowScale(var1);
   }

   public void setBackgroundColor(int var1) {
      this.mRing.setBackgroundColor(var1);
   }

   public void setColorFilter(ColorFilter var1) {
      this.mRing.setColorFilter(var1);
   }

   public void setColorSchemeColors(int... var1) {
      this.mRing.setColors(var1);
      this.mRing.setColorIndex(0);
   }

   public void setProgressRotation(float var1) {
      this.mRing.setRotation(var1);
   }

   void setRotation(float var1) {
      this.mRotation = var1;
      this.invalidateSelf();
   }

   public void setStartEndTrim(float var1, float var2) {
      this.mRing.setStartTrim(var1);
      this.mRing.setEndTrim(var2);
   }

   public void showArrow(boolean var1) {
      this.mRing.setShowArrow(var1);
   }

   public void start() {
      this.mAnimation.reset();
      this.mRing.storeOriginals();
      if(this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
         this.mFinishing = true;
         this.mAnimation.setDuration(666L);
         this.mParent.startAnimation(this.mAnimation);
      } else {
         this.mRing.setColorIndex(0);
         this.mRing.resetOriginals();
         this.mAnimation.setDuration(1332L);
         this.mParent.startAnimation(this.mAnimation);
      }
   }

   public void stop() {
      this.mParent.clearAnimation();
      this.setRotation(0.0F);
      this.mRing.setShowArrow(false);
      this.mRing.setColorIndex(0);
      this.mRing.resetOriginals();
   }

   public void updateSizes(@MaterialProgressDrawable.ProgressDrawableSize int var1) {
      if(var1 == 0) {
         this.setSizeParameters(56.0D, 56.0D, 12.5D, 3.0D, 12.0F, 6.0F);
      } else {
         this.setSizeParameters(40.0D, 40.0D, 8.75D, 2.5D, 10.0F, 5.0F);
      }
   }

   @Retention(RetentionPolicy.CLASS)
   public @interface ProgressDrawableSize {
   }

   private static class Ring {
      private int mAlpha;
      private Path mArrow;
      private int mArrowHeight;
      private final Paint mArrowPaint = new Paint();
      private float mArrowScale;
      private int mArrowWidth;
      private int mBackgroundColor;
      private final Callback mCallback;
      private final Paint mCirclePaint = new Paint(1);
      private int mColorIndex;
      private int[] mColors;
      private int mCurrentColor;
      private float mEndTrim = 0.0F;
      private final Paint mPaint = new Paint();
      private double mRingCenterRadius;
      private float mRotation = 0.0F;
      private boolean mShowArrow;
      private float mStartTrim = 0.0F;
      private float mStartingEndTrim;
      private float mStartingRotation;
      private float mStartingStartTrim;
      private float mStrokeInset = 2.5F;
      private float mStrokeWidth = 5.0F;
      private final RectF mTempBounds = new RectF();

      public Ring(Callback var1) {
         this.mCallback = var1;
         this.mPaint.setStrokeCap(Cap.SQUARE);
         this.mPaint.setAntiAlias(true);
         this.mPaint.setStyle(Style.STROKE);
         this.mArrowPaint.setStyle(Style.FILL);
         this.mArrowPaint.setAntiAlias(true);
      }

      private void drawTriangle(Canvas var1, float var2, float var3, Rect var4) {
         if(this.mShowArrow) {
            if(this.mArrow == null) {
               this.mArrow = new Path();
               this.mArrow.setFillType(FillType.EVEN_ODD);
            } else {
               this.mArrow.reset();
            }

            float var5 = (float)((int)this.mStrokeInset / 2) * this.mArrowScale;
            float var6 = (float)(this.mRingCenterRadius * Math.cos(0.0D) + (double)var4.exactCenterX());
            float var7 = (float)(this.mRingCenterRadius * Math.sin(0.0D) + (double)var4.exactCenterY());
            this.mArrow.moveTo(0.0F, 0.0F);
            this.mArrow.lineTo((float)this.mArrowWidth * this.mArrowScale, 0.0F);
            this.mArrow.lineTo((float)this.mArrowWidth * this.mArrowScale / 2.0F, (float)this.mArrowHeight * this.mArrowScale);
            this.mArrow.offset(var6 - var5, var7);
            this.mArrow.close();
            this.mArrowPaint.setColor(this.mCurrentColor);
            var1.rotate(var2 + var3 - 5.0F, var4.exactCenterX(), var4.exactCenterY());
            var1.drawPath(this.mArrow, this.mArrowPaint);
         }

      }

      private int getNextColorIndex() {
         return (1 + this.mColorIndex) % this.mColors.length;
      }

      private void invalidateSelf() {
         this.mCallback.invalidateDrawable((Drawable)null);
      }

      public void draw(Canvas var1, Rect var2) {
         RectF var3 = this.mTempBounds;
         var3.set(var2);
         var3.inset(this.mStrokeInset, this.mStrokeInset);
         float var4 = 360.0F * (this.mStartTrim + this.mRotation);
         float var5 = 360.0F * (this.mEndTrim + this.mRotation) - var4;
         this.mPaint.setColor(this.mCurrentColor);
         var1.drawArc(var3, var4, var5, false, this.mPaint);
         this.drawTriangle(var1, var4, var5, var2);
         if(this.mAlpha < 255) {
            this.mCirclePaint.setColor(this.mBackgroundColor);
            this.mCirclePaint.setAlpha(255 - this.mAlpha);
            var1.drawCircle(var2.exactCenterX(), var2.exactCenterY(), (float)(var2.width() / 2), this.mCirclePaint);
         }

      }

      public int getAlpha() {
         return this.mAlpha;
      }

      public double getCenterRadius() {
         return this.mRingCenterRadius;
      }

      public float getEndTrim() {
         return this.mEndTrim;
      }

      public float getInsets() {
         return this.mStrokeInset;
      }

      public int getNextColor() {
         return this.mColors[this.getNextColorIndex()];
      }

      public float getRotation() {
         return this.mRotation;
      }

      public float getStartTrim() {
         return this.mStartTrim;
      }

      public int getStartingColor() {
         return this.mColors[this.mColorIndex];
      }

      public float getStartingEndTrim() {
         return this.mStartingEndTrim;
      }

      public float getStartingRotation() {
         return this.mStartingRotation;
      }

      public float getStartingStartTrim() {
         return this.mStartingStartTrim;
      }

      public float getStrokeWidth() {
         return this.mStrokeWidth;
      }

      public void goToNextColor() {
         this.setColorIndex(this.getNextColorIndex());
      }

      public void resetOriginals() {
         this.mStartingStartTrim = 0.0F;
         this.mStartingEndTrim = 0.0F;
         this.mStartingRotation = 0.0F;
         this.setStartTrim(0.0F);
         this.setEndTrim(0.0F);
         this.setRotation(0.0F);
      }

      public void setAlpha(int var1) {
         this.mAlpha = var1;
      }

      public void setArrowDimensions(float var1, float var2) {
         this.mArrowWidth = (int)var1;
         this.mArrowHeight = (int)var2;
      }

      public void setArrowScale(float var1) {
         if(var1 != this.mArrowScale) {
            this.mArrowScale = var1;
            this.invalidateSelf();
         }

      }

      public void setBackgroundColor(int var1) {
         this.mBackgroundColor = var1;
      }

      public void setCenterRadius(double var1) {
         this.mRingCenterRadius = var1;
      }

      public void setColor(int var1) {
         this.mCurrentColor = var1;
      }

      public void setColorFilter(ColorFilter var1) {
         this.mPaint.setColorFilter(var1);
         this.invalidateSelf();
      }

      public void setColorIndex(int var1) {
         this.mColorIndex = var1;
         this.mCurrentColor = this.mColors[this.mColorIndex];
      }

      public void setColors(@NonNull int[] var1) {
         this.mColors = var1;
         this.setColorIndex(0);
      }

      public void setEndTrim(float var1) {
         this.mEndTrim = var1;
         this.invalidateSelf();
      }

      public void setInsets(int var1, int var2) {
         float var3 = (float)Math.min(var1, var2);
         float var4;
         if(this.mRingCenterRadius > 0.0D && var3 >= 0.0F) {
            var4 = (float)((double)(var3 / 2.0F) - this.mRingCenterRadius);
         } else {
            var4 = (float)Math.ceil((double)(this.mStrokeWidth / 2.0F));
         }

         this.mStrokeInset = var4;
      }

      public void setRotation(float var1) {
         this.mRotation = var1;
         this.invalidateSelf();
      }

      public void setShowArrow(boolean var1) {
         if(this.mShowArrow != var1) {
            this.mShowArrow = var1;
            this.invalidateSelf();
         }

      }

      public void setStartTrim(float var1) {
         this.mStartTrim = var1;
         this.invalidateSelf();
      }

      public void setStrokeWidth(float var1) {
         this.mStrokeWidth = var1;
         this.mPaint.setStrokeWidth(var1);
         this.invalidateSelf();
      }

      public void storeOriginals() {
         this.mStartingStartTrim = this.mStartTrim;
         this.mStartingEndTrim = this.mEndTrim;
         this.mStartingRotation = this.mRotation;
      }
   }
}