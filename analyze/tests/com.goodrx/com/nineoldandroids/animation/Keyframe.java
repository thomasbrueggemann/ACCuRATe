package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

public abstract class Keyframe implements Cloneable {
   float mFraction;
   boolean mHasValue = false;
   private Interpolator mInterpolator = null;
   Class mValueType;

   public static Keyframe ofInt(float var0) {
      return new Keyframe.IntKeyframe(var0);
   }

   public static Keyframe ofInt(float var0, int var1) {
      return new Keyframe.IntKeyframe(var0, var1);
   }

   public abstract Keyframe clone();

   public float getFraction() {
      return this.mFraction;
   }

   public Interpolator getInterpolator() {
      return this.mInterpolator;
   }

   public abstract Object getValue();

   public void setInterpolator(Interpolator var1) {
      this.mInterpolator = var1;
   }

   static class IntKeyframe extends Keyframe {
      int mValue;

      IntKeyframe(float var1) {
         this.mFraction = var1;
         this.mValueType = Integer.TYPE;
      }

      IntKeyframe(float var1, int var2) {
         this.mFraction = var1;
         this.mValue = var2;
         this.mValueType = Integer.TYPE;
         this.mHasValue = true;
      }

      public Keyframe.IntKeyframe clone() {
         Keyframe.IntKeyframe var1 = new Keyframe.IntKeyframe(this.getFraction(), this.mValue);
         var1.setInterpolator(this.getInterpolator());
         return var1;
      }

      public Object getValue() {
         return Integer.valueOf(this.mValue);
      }
   }
}
