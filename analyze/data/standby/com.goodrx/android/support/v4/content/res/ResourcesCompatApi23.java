package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;

class ResourcesCompatApi23 {
   public static int getColor(Resources var0, int var1, Theme var2) throws NotFoundException {
      return var0.getColor(var1, var2);
   }

   public static ColorStateList getColorStateList(Resources var0, int var1, Theme var2) throws NotFoundException {
      return var0.getColorStateList(var1, var2);
   }
}
