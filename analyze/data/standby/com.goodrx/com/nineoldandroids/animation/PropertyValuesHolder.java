package com.nineoldandroids.animation;

import com.nineoldandroids.animation.FloatEvaluator;
import com.nineoldandroids.animation.IntEvaluator;
import com.nineoldandroids.animation.IntKeyframeSet;
import com.nineoldandroids.animation.KeyframeSet;
import com.nineoldandroids.animation.TypeEvaluator;
import com.nineoldandroids.util.Property;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
   private static Class[] DOUBLE_VARIANTS;
   private static Class[] FLOAT_VARIANTS;
   private static Class[] INTEGER_VARIANTS;
   private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
   private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap;
   private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
   private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap;
   private Object mAnimatedValue;
   private TypeEvaluator mEvaluator;
   private Method mGetter;
   KeyframeSet mKeyframeSet;
   protected Property mProperty;
   final ReentrantReadWriteLock mPropertyMapLock;
   String mPropertyName;
   Method mSetter;
   final Object[] mTmpValueArray;
   Class mValueType;

   static {
      Class[] var0 = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
      FLOAT_VARIANTS = var0;
      Class[] var1 = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
      INTEGER_VARIANTS = var1;
      Class[] var2 = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
      DOUBLE_VARIANTS = var2;
      sSetterPropertyMap = new HashMap();
      sGetterPropertyMap = new HashMap();
   }

   private PropertyValuesHolder(String var1) {
      this.mSetter = null;
      this.mGetter = null;
      this.mKeyframeSet = null;
      this.mPropertyMapLock = new ReentrantReadWriteLock();
      this.mTmpValueArray = new Object[1];
      this.mPropertyName = var1;
   }

   // $FF: synthetic method
   PropertyValuesHolder(String var1, Object var2) {
      this(var1);
   }

   public static PropertyValuesHolder ofInt(String var0, int... var1) {
      return new PropertyValuesHolder.IntPropertyValuesHolder(var0, var1);
   }

   public PropertyValuesHolder clone() {
      try {
         PropertyValuesHolder var2 = (PropertyValuesHolder)super.clone();
         var2.mPropertyName = this.mPropertyName;
         var2.mProperty = this.mProperty;
         var2.mKeyframeSet = this.mKeyframeSet.clone();
         var2.mEvaluator = this.mEvaluator;
         return var2;
      } catch (CloneNotSupportedException var3) {
         return null;
      }
   }

   Object getAnimatedValue() {
      return this.mAnimatedValue;
   }

   public String getPropertyName() {
      return this.mPropertyName;
   }

   public void setIntValues(int... var1) {
      this.mValueType = Integer.TYPE;
      this.mKeyframeSet = KeyframeSet.ofInt(var1);
   }

   public String toString() {
      return this.mPropertyName + ": " + this.mKeyframeSet.toString();
   }

   static class IntPropertyValuesHolder extends PropertyValuesHolder {
      int mIntAnimatedValue;
      IntKeyframeSet mIntKeyframeSet;

      public IntPropertyValuesHolder(String var1, int... var2) {
         super(var1, null);
         this.setIntValues(var2);
      }

      public PropertyValuesHolder.IntPropertyValuesHolder clone() {
         PropertyValuesHolder.IntPropertyValuesHolder var1 = (PropertyValuesHolder.IntPropertyValuesHolder)super.clone();
         var1.mIntKeyframeSet = (IntKeyframeSet)var1.mKeyframeSet;
         return var1;
      }

      Object getAnimatedValue() {
         return Integer.valueOf(this.mIntAnimatedValue);
      }

      public void setIntValues(int... var1) {
         super.setIntValues(var1);
         this.mIntKeyframeSet = (IntKeyframeSet)this.mKeyframeSet;
      }
   }
}
