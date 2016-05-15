package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.class_22;
import android.util.AttributeSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
   public static final int ARROW_DIRECTION_END = 3;
   public static final int ARROW_DIRECTION_LEFT = 0;
   public static final int ARROW_DIRECTION_RIGHT = 1;
   public static final int ARROW_DIRECTION_START = 2;
   private static final float ARROW_HEAD_ANGLE = (float)Math.toRadians(45.0D);
   private float mArrowHeadLength;
   private float mArrowShaftLength;
   private float mBarGap;
   private float mBarLength;
   private int mDirection = 2;
   private float mMaxCutForBarSize;
   private final Paint mPaint = new Paint();
   private final Path mPath = new Path();
   private float mProgress;
   private final int mSize;
   private boolean mSpin;
   private boolean mVerticalMirror = false;

   public DrawerArrowDrawable(Context var1) {
      this.mPaint.setStyle(Style.STROKE);
      this.mPaint.setStrokeJoin(Join.MITER);
      this.mPaint.setStrokeCap(Cap.BUTT);
      this.mPaint.setAntiAlias(true);
      TypedArray var2 = var1.getTheme().obtainStyledAttributes((AttributeSet)null, class_22.styleable.DrawerArrowToggle, class_22.attr.drawerArrowStyle, class_22.style.Base_Widget_AppCompat_DrawerArrowToggle);
      this.setColor(var2.getColor(class_22.styleable.DrawerArrowToggle_color, 0));
      this.setBarThickness(var2.getDimension(class_22.styleable.DrawerArrowToggle_thickness, 0.0F));
      this.setSpinEnabled(var2.getBoolean(class_22.styleable.DrawerArrowToggle_spinBars, true));
      this.setGapSize((float)Math.round(var2.getDimension(class_22.styleable.DrawerArrowToggle_gapBetweenBars, 0.0F)));
      this.mSize = var2.getDimensionPixelSize(class_22.styleable.DrawerArrowToggle_drawableSize, 0);
      this.mBarLength = (float)Math.round(var2.getDimension(class_22.styleable.DrawerArrowToggle_barLength, 0.0F));
      this.mArrowHeadLength = (float)Math.round(var2.getDimension(class_22.styleable.DrawerArrowToggle_arrowHeadLength, 0.0F));
      this.mArrowShaftLength = var2.getDimension(class_22.styleable.DrawerArrowToggle_arrowShaftLength, 0.0F);
      var2.recycle();
   }

   private static float lerp(float var0, float var1, float var2) {
      return var0 + var2 * (var1 - var0);
   }

   public void draw(Canvas var1) {
      Rect var2 = this.getBounds();
      boolean var3;
      switch(this.mDirection) {
      case 0:
         var3 = false;
         break;
      case 1:
         var3 = true;
         break;
      case 2:
      default:
         if(DrawableCompat.getLayoutDirection(this) == 1) {
            var3 = true;
         } else {
            var3 = false;
         }
         break;
      case 3:
         if(DrawableCompat.getLayoutDirection(this) == 0) {
            var3 = true;
         } else {
            var3 = false;
         }
      }

      float var4 = (float)Math.sqrt((double)(2.0F * this.mArrowHeadLength * this.mArrowHeadLength));
      float var5 = lerp(this.mBarLength, var4, this.mProgress);
      float var6 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
      float var7 = (float)Math.round(lerp(0.0F, this.mMaxCutForBarSize, this.mProgress));
      float var8 = lerp(0.0F, ARROW_HEAD_ANGLE, this.mProgress);
      float var9;
      if(var3) {
         var9 = 0.0F;
      } else {
         var9 = -180.0F;
      }

      float var10;
      if(var3) {
         var10 = 180.0F;
      } else {
         var10 = 0.0F;
      }

      float var11 = this.mProgress;
      float var12 = lerp(var9, var10, var11);
      float var13 = (float)Math.round((double)var5 * Math.cos((double)var8));
      float var14 = (float)Math.round((double)var5 * Math.sin((double)var8));
      this.mPath.rewind();
      float var15 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
      float var16 = -var6 / 2.0F;
      this.mPath.moveTo(var16 + var7, 0.0F);
      this.mPath.rLineTo(var6 - 2.0F * var7, 0.0F);
      this.mPath.moveTo(var16, var15);
      this.mPath.rLineTo(var13, var14);
      this.mPath.moveTo(var16, -var15);
      this.mPath.rLineTo(var13, -var14);
      this.mPath.close();
      var1.save();
      float var18 = this.mPaint.getStrokeWidth();
      float var19 = (float)((double)((float)(2 * ((int)((float)var2.height() - 3.0F * var18 - 2.0F * this.mBarGap) / 4))) + 1.5D * (double)var18 + (double)this.mBarGap);
      var1.translate((float)var2.centerX(), var19);
      if(this.mSpin) {
         byte var20;
         if(var3 ^ this.mVerticalMirror) {
            var20 = -1;
         } else {
            var20 = 1;
         }

         var1.rotate(var12 * (float)var20);
      } else if(var3) {
         var1.rotate(180.0F);
      }

      var1.drawPath(this.mPath, this.mPaint);
      var1.restore();
   }

   public float getArrowHeadLength() {
      return this.mArrowHeadLength;
   }

   public float getArrowShaftLength() {
      return this.mArrowShaftLength;
   }

   public float getBarLength() {
      return this.mBarLength;
   }

   public float getBarThickness() {
      return this.mPaint.getStrokeWidth();
   }

   @ColorInt
   public int getColor() {
      return this.mPaint.getColor();
   }

   public int getDirection() {
      return this.mDirection;
   }

   public float getGapSize() {
      return this.mBarGap;
   }

   public int getIntrinsicHeight() {
      return this.mSize;
   }

   public int getIntrinsicWidth() {
      return this.mSize;
   }

   public int getOpacity() {
      return -3;
   }

   public final Paint getPaint() {
      return this.mPaint;
   }

   @FloatRange(
      from = 0.0D,
      to = 1.0D
   )
   public float getProgress() {
      return this.mProgress;
   }

   public boolean isSpinEnabled() {
      return this.mSpin;
   }

   public void setAlpha(int var1) {
      if(var1 != this.mPaint.getAlpha()) {
         this.mPaint.setAlpha(var1);
         this.invalidateSelf();
      }

   }

   public void setArrowHeadLength(float var1) {
      if(this.mArrowHeadLength != var1) {
         this.mArrowHeadLength = var1;
         this.invalidateSelf();
      }

   }

   public void setArrowShaftLength(float var1) {
      if(this.mArrowShaftLength != var1) {
         this.mArrowShaftLength = var1;
         this.invalidateSelf();
      }

   }

   public void setBarLength(float var1) {
      if(this.mBarLength != var1) {
         this.mBarLength = var1;
         this.invalidateSelf();
      }

   }

   public void setBarThickness(float var1) {
      if(this.mPaint.getStrokeWidth() != var1) {
         this.mPaint.setStrokeWidth(var1);
         this.mMaxCutForBarSize = (float)((double)(var1 / 2.0F) * Math.cos((double)ARROW_HEAD_ANGLE));
         this.invalidateSelf();
      }

   }

   public void setColor(@ColorInt int var1) {
      if(var1 != this.mPaint.getColor()) {
         this.mPaint.setColor(var1);
         this.invalidateSelf();
      }

   }

   public void setColorFilter(ColorFilter var1) {
      this.mPaint.setColorFilter(var1);
      this.invalidateSelf();
   }

   public void setDirection(int var1) {
      if(var1 != this.mDirection) {
         this.mDirection = var1;
         this.invalidateSelf();
      }

   }

   public void setGapSize(float var1) {
      if(var1 != this.mBarGap) {
         this.mBarGap = var1;
         this.invalidateSelf();
      }

   }

   public void setProgress(@FloatRange(
   from = 0.0D,
   to = 1.0D
) float var1) {
      if(this.mProgress != var1) {
         this.mProgress = var1;
         this.invalidateSelf();
      }

   }

   public void setSpinEnabled(boolean var1) {
      if(this.mSpin != var1) {
         this.mSpin = var1;
         this.invalidateSelf();
      }

   }

   public void setVerticalMirror(boolean var1) {
      if(this.mVerticalMirror != var1) {
         this.mVerticalMirror = var1;
         this.invalidateSelf();
      }

   }

   @Retention(RetentionPolicy.SOURCE)
   public @interface ArrowDirection {
   }
}
