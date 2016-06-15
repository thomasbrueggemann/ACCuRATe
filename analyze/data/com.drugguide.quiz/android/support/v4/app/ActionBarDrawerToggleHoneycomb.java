package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggleHoneycomb {
   private static final String TAG = "ActionBarDrawerToggleHoneycomb";
   private static final int[] THEME_ATTRS = new int[]{16843531};

   public static Drawable getThemeUpIndicator(Activity var0) {
      TypedArray var1 = var0.obtainStyledAttributes(THEME_ATTRS);
      Drawable var2 = var1.getDrawable(0);
      var1.recycle();
      return var2;
   }

   public static Object setActionBarDescription(Object var0, Activity var1, int var2) {
      if(var0 == null) {
         var0 = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(var1);
      }

      ActionBarDrawerToggleHoneycomb.SetIndicatorInfo var3 = (ActionBarDrawerToggleHoneycomb.SetIndicatorInfo)var0;
      if(var3.setHomeAsUpIndicator != null) {
         try {
            ActionBar var6 = var1.getActionBar();
            Method var7 = var3.setHomeActionContentDescription;
            Object[] var8 = new Object[]{Integer.valueOf(var2)};
            var7.invoke(var6, var8);
         } catch (Exception var9) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set content description via JB-MR2 API", var9);
            return var0;
         }
      }

      return var0;
   }

   public static Object setActionBarUpIndicator(Object var0, Activity var1, Drawable var2, int var3) {
      if(var0 == null) {
         var0 = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(var1);
      }

      ActionBarDrawerToggleHoneycomb.SetIndicatorInfo var4 = (ActionBarDrawerToggleHoneycomb.SetIndicatorInfo)var0;
      if(var4.setHomeAsUpIndicator != null) {
         try {
            ActionBar var8 = var1.getActionBar();
            var4.setHomeAsUpIndicator.invoke(var8, new Object[]{var2});
            Method var10 = var4.setHomeActionContentDescription;
            Object[] var11 = new Object[]{Integer.valueOf(var3)};
            var10.invoke(var8, var11);
            return var0;
         } catch (Exception var12) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator via JB-MR2 API", var12);
            return var0;
         }
      } else if(var4.upIndicatorView != null) {
         var4.upIndicatorView.setImageDrawable(var2);
         return var0;
      } else {
         Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator");
         return var0;
      }
   }

   private static class SetIndicatorInfo {
      public Method setHomeActionContentDescription;
      public Method setHomeAsUpIndicator;
      public ImageView upIndicatorView;

      SetIndicatorInfo(Activity var1) {
         try {
            this.setHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
            Class[] var8 = new Class[]{Integer.TYPE};
            this.setHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", var8);
         } catch (NoSuchMethodException var9) {
            View var3 = var1.findViewById(16908332);
            if(var3 != null) {
               ViewGroup var4 = (ViewGroup)var3.getParent();
               if(var4.getChildCount() == 2) {
                  View var5 = var4.getChildAt(0);
                  View var6 = var4.getChildAt(1);
                  View var7;
                  if(var5.getId() == 16908332) {
                     var7 = var6;
                  } else {
                     var7 = var5;
                  }

                  if(var7 instanceof ImageView) {
                     this.upIndicatorView = (ImageView)var7;
                     return;
                  }
               }
            }
         }

      }
   }
}
