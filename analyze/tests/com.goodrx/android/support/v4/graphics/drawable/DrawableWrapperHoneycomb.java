package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableWrapperDonut;

class DrawableWrapperHoneycomb extends DrawableWrapperDonut {
   DrawableWrapperHoneycomb(Drawable var1) {
      super(var1);
   }

   DrawableWrapperHoneycomb(DrawableWrapperDonut.DrawableWrapperState var1, Resources var2) {
      super(var1, var2);
   }

   public void jumpToCurrentState() {
      this.mDrawable.jumpToCurrentState();
   }

   DrawableWrapperDonut.DrawableWrapperState mutateConstantState() {
      return new DrawableWrapperHoneycomb.DrawableWrapperStateHoneycomb(this.mState, (Resources)null);
   }

   private static class DrawableWrapperStateHoneycomb extends DrawableWrapperDonut.DrawableWrapperState {
      DrawableWrapperStateHoneycomb(@Nullable DrawableWrapperDonut.DrawableWrapperState var1, @Nullable Resources var2) {
         super(var1, var2);
      }

      public Drawable newDrawable(@Nullable Resources var1) {
         return new DrawableWrapperHoneycomb(this, var1);
      }
   }
}
