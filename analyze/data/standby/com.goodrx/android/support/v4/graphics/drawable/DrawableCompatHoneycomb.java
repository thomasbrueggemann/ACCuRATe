package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperHoneycomb;

class DrawableCompatHoneycomb {
   public static void jumpToCurrentState(Drawable var0) {
      var0.jumpToCurrentState();
   }

   public static Drawable wrapForTinting(Drawable var0) {
      if(!(var0 instanceof DrawableWrapperHoneycomb)) {
         var0 = new DrawableWrapperHoneycomb((Drawable)var0);
      }

      return (Drawable)var0;
   }
}
