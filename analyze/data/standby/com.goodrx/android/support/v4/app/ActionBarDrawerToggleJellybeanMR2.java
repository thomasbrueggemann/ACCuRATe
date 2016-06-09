package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

class ActionBarDrawerToggleJellybeanMR2 {
   private static final String TAG = "ActionBarDrawerToggleImplJellybeanMR2";
   private static final int[] THEME_ATTRS = new int[]{16843531};

   public static Drawable getThemeUpIndicator(Activity var0) {
      ActionBar var1 = var0.getActionBar();
      Object var2;
      if(var1 != null) {
         var2 = var1.getThemedContext();
      } else {
         var2 = var0;
      }

      TypedArray var3 = ((Context)var2).obtainStyledAttributes((AttributeSet)null, THEME_ATTRS, 16843470, 0);
      Drawable var4 = var3.getDrawable(0);
      var3.recycle();
      return var4;
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
