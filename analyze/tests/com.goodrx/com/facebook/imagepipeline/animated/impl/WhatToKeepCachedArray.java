package com.facebook.imagepipeline.animated.impl;

import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class WhatToKeepCachedArray {
   private final boolean[] mData;

   WhatToKeepCachedArray(int var1) {
      this.mData = new boolean[var1];
   }

   boolean get(int var1) {
      return this.mData[var1];
   }

   void removeOutsideRange(int var1, int var2) {
      for(int var3 = 0; var3 < this.mData.length; ++var3) {
         if(AnimatedDrawableUtil.isOutsideRange(var1, var2, var3)) {
            this.mData[var3] = false;
         }
      }

   }

   void set(int var1, boolean var2) {
      this.mData[var1] = var2;
   }

   void setAll(boolean var1) {
      for(int var2 = 0; var2 < this.mData.length; ++var2) {
         this.mData[var2] = var1;
      }

   }
}
