package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompatHC {
   public static float getAlpha(View var0) {
      return var0.getAlpha();
   }

   static long getFrameTime() {
      return ValueAnimator.getFrameDelay();
   }

   public static int getLayerType(View var0) {
      return var0.getLayerType();
   }

   public static int getMeasuredHeightAndState(View var0) {
      return var0.getMeasuredHeightAndState();
   }

   public static int getMeasuredState(View var0) {
      return var0.getMeasuredState();
   }

   public static int getMeasuredWidthAndState(View var0) {
      return var0.getMeasuredWidthAndState();
   }

   public static float getPivotX(View var0) {
      return var0.getPivotX();
   }

   public static float getPivotY(View var0) {
      return var0.getPivotY();
   }

   public static float getRotation(View var0) {
      return var0.getRotation();
   }

   public static float getRotationX(View var0) {
      return var0.getRotationX();
   }

   public static float getRotationY(View var0) {
      return var0.getRotationY();
   }

   public static float getScaleX(View var0) {
      return var0.getScaleX();
   }

   public static float getScaleY(View var0) {
      return var0.getScaleY();
   }

   public static float getTranslationX(View var0) {
      return var0.getTranslationX();
   }

   public static float getTranslationY(View var0) {
      return var0.getTranslationY();
   }

   public static float getX(View var0) {
      return var0.getX();
   }

   public static float getY(View var0) {
      return var0.getY();
   }

   public static int resolveSizeAndState(int var0, int var1, int var2) {
      return View.resolveSizeAndState(var0, var1, var2);
   }

   public static void setAlpha(View var0, float var1) {
      var0.setAlpha(var1);
   }

   public static void setLayerType(View var0, int var1, Paint var2) {
      var0.setLayerType(var1, var2);
   }

   public static void setPivotX(View var0, float var1) {
      var0.setPivotX(var1);
   }

   public static void setPivotY(View var0, float var1) {
      var0.setPivotY(var1);
   }

   public static void setRotation(View var0, float var1) {
      var0.setRotation(var1);
   }

   public static void setRotationX(View var0, float var1) {
      var0.setRotationX(var1);
   }

   public static void setRotationY(View var0, float var1) {
      var0.setRotationY(var1);
   }

   public static void setScaleX(View var0, float var1) {
      var0.setScaleX(var1);
   }

   public static void setScaleY(View var0, float var1) {
      var0.setScaleY(var1);
   }

   public static void setTranslationX(View var0, float var1) {
      var0.setTranslationX(var1);
   }

   public static void setTranslationY(View var0, float var1) {
      var0.setTranslationY(var1);
   }

   public static void setX(View var0, float var1) {
      var0.setX(var1);
   }

   public static void setY(View var0, float var1) {
      var0.setY(var1);
   }
}
