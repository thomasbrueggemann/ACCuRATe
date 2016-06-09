package com.nineoldandroids.animation;

import com.nineoldandroids.animation.Keyframe;
import com.nineoldandroids.animation.KeyframeSet;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet {
   private boolean firstTime = true;

   public IntKeyframeSet(Keyframe.IntKeyframe... var1) {
      super(var1);
   }

   public IntKeyframeSet clone() {
      ArrayList var1 = this.mKeyframes;
      int var2 = this.mKeyframes.size();
      Keyframe.IntKeyframe[] var3 = new Keyframe.IntKeyframe[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = (Keyframe.IntKeyframe)((Keyframe)var1.get(var4)).clone();
      }

      return new IntKeyframeSet(var3);
   }
}
