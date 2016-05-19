package android.support.v7.app;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
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

   public static ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarDescription(ActionBarDrawerToggleHoneycomb.SetIndicatorInfo var0, Activity var1, int var2) {
      if(var0 == null) {
         var0 = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(var1);
      }

      if(var0.setHomeAsUpIndicator != null) {
         try {
            android.app.ActionBar var5 = var1.getActionBar();
            Method var6 = var0.setHomeActionContentDescription;
            Object[] var7 = new Object[]{Integer.valueOf(var2)};
            var6.invoke(var5, var7);
            if(VERSION.SDK_INT <= 19) {
               var5.setSubtitle(var5.getSubtitle());
            }
         } catch (Exception var8) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set content description via JB-MR2 API", var8);
            return var0;
         }
      }

      return var0;
   }

   public static ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarUpIndicator(ActionBarDrawerToggleHoneycomb.SetIndicatorInfo var0, Activity var1, Drawable var2, int var3) {
      ActionBarDrawerToggleHoneycomb.SetIndicatorInfo var4 = new ActionBarDrawerToggleHoneycomb.SetIndicatorInfo(var1);
      if(var4.setHomeAsUpIndicator != null) {
         try {
            android.app.ActionBar var8 = var1.getActionBar();
            var4.setHomeAsUpIndicator.invoke(var8, new Object[]{var2});
            Method var10 = var4.setHomeActionContentDescription;
            Object[] var11 = new Object[]{Integer.valueOf(var3)};
            var10.invoke(var8, var11);
            return var4;
         } catch (Exception var12) {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator via JB-MR2 API", var12);
            return var4;
         }
      } else if(var4.upIndicatorView != null) {
         var4.upIndicatorView.setImageDrawable(var2);
         return var4;
      } else {
         Log.w("ActionBarDrawerToggleHoneycomb", "Couldn\'t set home-as-up indicator");
         return var4;
      }
   }

   static class SetIndicatorInfo {
      public Method setHomeActionContentDescription;
      public Method setHomeAsUpIndicator;
      public ImageView upIndicatorView;

      SetIndicatorInfo(Activity var1) {
         try {
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
            Class[] var8 = new Class[]{Integer.TYPE};
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", var8);
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
