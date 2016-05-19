package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.IntKeyframeSet;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;

class KeyframeSet {
   Keyframe mFirstKeyframe;
   Interpolator mInterpolator;
   ArrayList<Keyframe> mKeyframes;
   Keyframe mLastKeyframe;
   int mNumKeyframes;

   public KeyframeSet(Keyframe... var1) {
      this.mNumKeyframes = var1.length;
      this.mKeyframes = new ArrayList();
      this.mKeyframes.addAll(Arrays.asList(var1));
      this.mFirstKeyframe = (Keyframe)this.mKeyframes.get(0);
      this.mLastKeyframe = (Keyframe)this.mKeyframes.get(-1 + this.mNumKeyframes);
      this.mInterpolator = this.mLastKeyframe.getInterpolator();
   }

   public static KeyframeSet ofInt(int... var0) {
      int var1 = var0.length;
      Keyframe.IntKeyframe[] var2 = new Keyframe.IntKeyframe[Math.max(var1, 2)];
      if(var1 == 1) {
         var2[0] = (Keyframe.IntKeyframe)Keyframe.ofInt(0.0F);
         var2[1] = (Keyframe.IntKeyframe)Keyframe.ofInt(1.0F, var0[0]);
      } else {
         var2[0] = (Keyframe.IntKeyframe)Keyframe.ofInt(0.0F, var0[0]);

         for(int var3 = 1; var3 < var1; ++var3) {
            var2[var3] = (Keyframe.IntKeyframe)Keyframe.ofInt((float)var3 / (float)(var1 - 1), var0[var3]);
         }
      }

      return new IntKeyframeSet(var2);
   }

   public KeyframeSet clone() {
      ArrayList var1 = this.mKeyframes;
      int var2 = this.mKeyframes.size();
      Keyframe[] var3 = new Keyframe[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = ((Keyframe)var1.get(var4)).clone();
      }

      return new KeyframeSet(var3);
   }

   public String toString() {
      String var1 = " ";

      for(int var2 = 0; var2 < this.mNumKeyframes; ++var2) {
         var1 = var1 + ((Keyframe)this.mKeyframes.get(var2)).getValue() + "  ";
      }

      return var1;
   }
}
