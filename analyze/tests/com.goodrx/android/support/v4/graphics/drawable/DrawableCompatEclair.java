package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperEclair;

class DrawableCompatEclair {
   public static Drawable wrapForTinting(Drawable var0) {
      if(!(var0 instanceof DrawableWrapperEclair)) {
         var0 = new DrawableWrapperEclair((Drawable)var0);
      }

      return (Drawable)var0;
   }
}
