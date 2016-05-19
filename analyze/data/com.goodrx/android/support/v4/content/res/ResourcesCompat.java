package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompatApi21;
import android.support.v4.content.res.ResourcesCompatApi23;
import android.support.v4.content.res.ResourcesCompatIcsMr1;

public final class ResourcesCompat {
   @ColorInt
   public static int getColor(@NonNull Resources var0, @ColorRes int var1, @Nullable Theme var2) throws NotFoundException {
      return VERSION.SDK_INT >= 23?ResourcesCompatApi23.getColor(var0, var1, var2):var0.getColor(var1);
   }

   @Nullable
   public static ColorStateList getColorStateList(@NonNull Resources var0, @ColorRes int var1, @Nullable Theme var2) throws NotFoundException {
      return VERSION.SDK_INT >= 23?ResourcesCompatApi23.getColorStateList(var0, var1, var2):var0.getColorStateList(var1);
   }

   @Nullable
   public static Drawable getDrawable(@NonNull Resources var0, @DrawableRes int var1, @Nullable Theme var2) throws NotFoundException {
      return VERSION.SDK_INT >= 21?ResourcesCompatApi21.getDrawable(var0, var1, var2):var0.getDrawable(var1);
   }

   @Nullable
   public static Drawable getDrawableForDensity(@NonNull Resources var0, @DrawableRes int var1, int var2, @Nullable Theme var3) throws NotFoundException {
      return VERSION.SDK_INT >= 21?ResourcesCompatApi21.getDrawableForDensity(var0, var1, var2, var3):(VERSION.SDK_INT >= 15?ResourcesCompatIcsMr1.getDrawableForDensity(var0, var1, var2):var0.getDrawable(var1));
   }
}
