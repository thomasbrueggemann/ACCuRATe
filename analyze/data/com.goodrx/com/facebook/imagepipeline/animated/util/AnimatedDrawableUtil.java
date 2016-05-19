package com.facebook.imagepipeline.animated.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import java.util.Arrays;

public class AnimatedDrawableUtil {
   private static final int FRAME_DURATION_MS_FOR_MIN = 100;
   private static final int MIN_FRAME_DURATION_MS = 11;

   public static boolean isOutsideRange(int var0, int var1, int var2) {
      if(var0 != -1 && var1 != -1) {
         if(var0 > var1) {
            boolean var3 = false;
            if(var2 < var0) {
               var3 = false;
               if(var2 > var1) {
                  var3 = true;
               }
            }

            return var3;
         } else {
            boolean var4;
            if(var2 >= var0) {
               var4 = false;
               if(var2 <= var1) {
                  return var4;
               }
            }

            var4 = true;
            return var4;
         }
      } else {
         return true;
      }
   }

   public void appendMemoryString(StringBuilder var1, int var2) {
      if(var2 < 1024) {
         var1.append(var2);
         var1.append("KB");
      } else {
         int var3 = var2 / 1024;
         int var4 = var2 % 1024 / 100;
         var1.append(var3);
         var1.append(".");
         var1.append(var4);
         var1.append("MB");
      }
   }

   public void fixFrameDurations(int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         if(var1[var2] < 11) {
            var1[var2] = 100;
         }
      }

   }

   public int getFrameForTimestampMs(int[] var1, int var2) {
      int var3 = Arrays.binarySearch(var1, var2);
      if(var3 < 0) {
         var3 = -1 + -1 + -var3;
      }

      return var3;
   }

   public int[] getFrameTimeStampsFromDurations(int[] var1) {
      int[] var2 = new int[var1.length];
      int var3 = 0;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var2[var4] = var3;
         var3 += var1[var4];
      }

      return var2;
   }

   @SuppressLint({"NewApi"})
   public int getSizeOfBitmap(Bitmap var1) {
      return VERSION.SDK_INT >= 19?var1.getAllocationByteCount():(VERSION.SDK_INT >= 12?var1.getByteCount():4 * var1.getWidth() * var1.getHeight());
   }

   public int getTotalDurationFromFrameDurations(int[] var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < var1.length; ++var3) {
         var2 += var1[var3];
      }

      return var2;
   }
}
