package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

class ActionBarDrawerToggleJellybeanMR2 {
   private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
   private static final int[] THEME_ATTRS = new int[]{16843531};

   public static Drawable getThemeUpIndicator(Activity var0) {
      TypedArray var1 = var0.obtainStyledAttributes(THEME_ATTRS);
      Drawable var2 = var1.getDrawable(0);
      var1.recycle();
      return var2;
   }

   public static Object setActionBarDescription(Object var0, Activity var1, int var2) {
      ActionBar var3 = var1.getActionBar();
      if(var3 != null) {
         var3.setHomeActionContentDescription(var2);
      }

      return var0;
   }

   public static Object setActionBarUpIndicator(Object var0, Activity var1, Drawable var2, int var3) {
      ActionBar var4 = var1.getActionBar();
      if(var4 != null) {
         var4.setHomeAsUpIndicator(var2);
         var4.setHomeActionContentDescription(var3);
      }

      return var0;
   }
}
