package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;

class ResourcesCompatApi21 {
   public static Drawable getDrawable(Resources var0, int var1, Theme var2) throws NotFoundException {
      return var0.getDrawable(var1, var2);
   }

   public static Drawable getDrawableForDensity(Resources var0, int var1, int var2, Theme var3) throws NotFoundException {
      return var0.getDrawableForDensity(var1, var2, var3);
   }
}
