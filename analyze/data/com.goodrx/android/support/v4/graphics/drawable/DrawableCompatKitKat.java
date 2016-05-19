package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperKitKat;

class DrawableCompatKitKat {
   public static int getAlpha(Drawable var0) {
      return var0.getAlpha();
   }

   public static boolean isAutoMirrored(Drawable var0) {
      return var0.isAutoMirrored();
   }

   public static void setAutoMirrored(Drawable var0, boolean var1) {
      var0.setAutoMirrored(var1);
   }

   public static Drawable wrapForTinting(Drawable var0) {
      if(!(var0 instanceof DrawableWrapperKitKat)) {
         var0 = new DrawableWrapperKitKat((Drawable)var0);
      }

      return (Drawable)var0;
   }
}
