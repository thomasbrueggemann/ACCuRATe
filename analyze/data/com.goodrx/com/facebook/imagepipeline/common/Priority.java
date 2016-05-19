package com.facebook.imagepipeline.common;

import javax.annotation.Nullable;

public enum Priority {
   HIGH,
   LOW,
   MEDIUM;

   static {
      Priority[] var0 = new Priority[]{LOW, MEDIUM, HIGH};
   }

   public static Priority getHigherPriority(@Nullable Priority var0, @Nullable Priority var1) {
      if(var0 != null) {
         if(var1 == null) {
            return var0;
         }

         if(var0.ordinal() > var1.ordinal()) {
            return var0;
         }
      }

      return var1;
   }
}
