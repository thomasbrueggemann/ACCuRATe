package com.nineoldandroids.animation;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.FloatEvaluator;
import com.nineoldandroids.animation.IntEvaluator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.TypeEvaluator;
import java.util.ArrayList;
import java.util.HashMap;

public class ValueAnimator extends Animator {
   private static ThreadLocal<Object> sAnimationHandler = new ThreadLocal();
   private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal() {
      protected ArrayList<ValueAnimator> initialValue() {
         return new ArrayList();
      }
   };
   private static final Interpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
   private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal() {
      protected ArrayList<ValueAnimator> initialValue() {
         return new ArrayList();
      }
   };
   private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal() {
      protected ArrayList<ValueAnimator> initialValue() {
         return new ArrayList();
      }
   };
   private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
   private static long sFrameDelay = 10L;
   private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
   private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal() {
      protected ArrayList<ValueAnimator> initialValue() {
         return new ArrayList();
      }
   };
   private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal() {
      protected ArrayList<ValueAnimator> initialValue() {
         return new ArrayList();
      }
   };
   private float mCurrentFraction = 0.0F;
   private int mCurrentIteration = 0;
   private long mDuration = 300L;
   boolean mInitialized = false;
   private Interpolator mInterpolator;
   private boolean mPlayingBackwards = false;
   int mPlayingState = 0;
   private int mRepeatCount = 0;
   private int mRepeatMode = 1;
   private boolean mRunning = false;
   long mSeekTime = -1L;
   private long mStartDelay = 0L;
   private boolean mStarted = false;
   private boolean mStartedDelay = false;
   private ArrayList<ValueAnimator.AnimatorUpdateListener> mUpdateListeners;
   PropertyValuesHolder[] mValues;
   HashMap<String, PropertyValuesHolder> mValuesMap;

   public ValueAnimator() {
      this.mInterpolator = sDefaultInterpolator;
      this.mUpdateListeners = null;
   }

   public void addUpdateListener(ValueAnimator.AnimatorUpdateListener var1) {
      if(this.mUpdateListeners == null) {
         this.mUpdateListeners = new ArrayList();
      }

      this.mUpdateListeners.add(var1);
   }

   public ValueAnimator clone() {
      ValueAnimator var1 = (ValueAnimator)super.clone();
      if(this.mUpdateListeners != null) {
         ArrayList var7 = this.mUpdateListeners;
         var1.mUpdateListeners = new ArrayList();
         int var8 = var7.size();

         for(int var9 = 0; var9 < var8; ++var9) {
            var1.mUpdateListeners.add(var7.get(var9));
         }
      }

      var1.mSeekTime = -1L;
      var1.mPlayingBackwards = false;
      var1.mCurrentIteration = 0;
      var1.mInitialized = false;
      var1.mPlayingState = 0;
      var1.mStartedDelay = false;
      PropertyValuesHolder[] var2 = this.mValues;
      if(var2 != null) {
         int var3 = var2.length;
         var1.mValues = new PropertyValuesHolder[var3];
         var1.mValuesMap = new HashMap(var3);

         for(int var4 = 0; var4 < var3; ++var4) {
            PropertyValuesHolder var5 = var2[var4].clone();
            var1.mValues[var4] = var5;
            var1.mValuesMap.put(var5.getPropertyName(), var5);
         }
      }

      return var1;
   }

   public Object getAnimatedValue() {
      return this.mValues != null && this.mValues.length > 0?this.mValues[0].getAnimatedValue():null;
   }

   public ValueAnimator setDuration(long var1) {
      if(var1 < 0L) {
         throw new IllegalArgumentException("Animators cannot have negative duration: " + var1);
      } else {
         this.mDuration = var1;
         return this;
      }
   }

   public void setIntValues(int... var1) {
      if(var1 != null && var1.length != 0) {
         if(this.mValues != null && this.mValues.length != 0) {
            this.mValues[0].setIntValues(var1);
         } else {
            PropertyValuesHolder[] var2 = new PropertyValuesHolder[]{PropertyValuesHolder.ofInt("", var1)};
            this.setValues(var2);
         }

         this.mInitialized = false;
      }
   }

   public void setInterpolator(Interpolator var1) {
      if(var1 != null) {
         this.mInterpolator = var1;
      } else {
         this.mInterpolator = new LinearInterpolator();
      }
   }

   public void setRepeatCount(int var1) {
      this.mRepeatCount = var1;
   }

   public void setRepeatMode(int var1) {
      this.mRepeatMode = var1;
   }

   public void setValues(PropertyValuesHolder... var1) {
      int var2 = var1.length;
      this.mValues = var1;
      this.mValuesMap = new HashMap(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         PropertyValuesHolder var4 = var1[var3];
         this.mValuesMap.put(var4.getPropertyName(), var4);
      }

      this.mInitialized = false;
   }

   public String toString() {
      String var1 = "ValueAnimator@" + Integer.toHexString(this.hashCode());
      if(this.mValues != null) {
         for(int var2 = 0; var2 < this.mValues.length; ++var2) {
            var1 = var1 + "\n    " + this.mValues[var2].toString();
         }
      }

      return var1;
   }

   public interface AnimatorUpdateListener {
   }
}
