package com.facebook.drawee.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import javax.annotation.Nullable;

public class AspectRatioMeasure {
   private static boolean shouldAdjust(int var0) {
      return var0 == 0 || var0 == -2;
   }

   public static void updateMeasureSpec(AspectRatioMeasure.Spec var0, float var1, @Nullable LayoutParams var2, int var3, int var4) {
      if(var1 > 0.0F && var2 != null) {
         if(shouldAdjust(var2.height)) {
            var0.height = MeasureSpec.makeMeasureSpec(View.resolveSize((int)((float)(MeasureSpec.getSize(var0.width) - var3) / var1 + (float)var4), var0.height), 1073741824);
            return;
         }

         if(shouldAdjust(var2.width)) {
            var0.width = MeasureSpec.makeMeasureSpec(View.resolveSize((int)(var1 * (float)(MeasureSpec.getSize(var0.height) - var4) + (float)var3), var0.width), 1073741824);
            return;
         }
      }

   }

   public static class Spec {
      public int height;
      public int width;
   }
}
