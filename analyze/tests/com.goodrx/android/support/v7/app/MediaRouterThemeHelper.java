package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.mediarouter.class_16;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

final class MediaRouterThemeHelper {
   public static Context createThemedContext(Context var0) {
      int var1;
      if(isLightTheme(var0)) {
         var1 = class_16.style.Theme_MediaRouter_Light;
      } else {
         var1 = class_16.style.Theme_MediaRouter;
      }

      return new ContextThemeWrapper(var0, var1);
   }

   public static Drawable getThemeDrawable(Context var0, int var1) {
      int var2 = getThemeResource(var0, var1);
      return var2 != 0?var0.getResources().getDrawable(var2):null;
   }

   public static int getThemeResource(Context var0, int var1) {
      TypedValue var2 = new TypedValue();
      return var0.getTheme().resolveAttribute(var1, var2, true)?var2.resourceId:0;
   }

   private static boolean isLightTheme(Context var0) {
      TypedValue var1 = new TypedValue();
      return var0.getTheme().resolveAttribute(class_16.attr.isLightTheme, var1, true) && var1.data != 0;
   }
}
