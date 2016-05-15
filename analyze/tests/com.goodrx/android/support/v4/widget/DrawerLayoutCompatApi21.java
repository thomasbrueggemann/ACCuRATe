package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayoutImpl;
import android.view.View;
import android.view.WindowInsets;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.MarginLayoutParams;

class DrawerLayoutCompatApi21 {
   private static final int[] THEME_ATTRS = new int[]{16843828};

   public static void applyMarginInsets(MarginLayoutParams var0, Object var1, int var2) {
      WindowInsets var3 = (WindowInsets)var1;
      if(var2 == 3) {
         var3 = var3.replaceSystemWindowInsets(var3.getSystemWindowInsetLeft(), var3.getSystemWindowInsetTop(), 0, var3.getSystemWindowInsetBottom());
      } else if(var2 == 5) {
         var3 = var3.replaceSystemWindowInsets(0, var3.getSystemWindowInsetTop(), var3.getSystemWindowInsetRight(), var3.getSystemWindowInsetBottom());
      }

      var0.leftMargin = var3.getSystemWindowInsetLeft();
      var0.topMargin = var3.getSystemWindowInsetTop();
      var0.rightMargin = var3.getSystemWindowInsetRight();
      var0.bottomMargin = var3.getSystemWindowInsetBottom();
   }

   public static void configureApplyInsets(View var0) {
      if(var0 instanceof DrawerLayoutImpl) {
         var0.setOnApplyWindowInsetsListener(new DrawerLayoutCompatApi21.InsetsListener());
         var0.setSystemUiVisibility(1280);
      }

   }

   public static void dispatchChildInsets(View var0, Object var1, int var2) {
      WindowInsets var3 = (WindowInsets)var1;
      if(var2 == 3) {
         var3 = var3.replaceSystemWindowInsets(var3.getSystemWindowInsetLeft(), var3.getSystemWindowInsetTop(), 0, var3.getSystemWindowInsetBottom());
      } else if(var2 == 5) {
         var3 = var3.replaceSystemWindowInsets(0, var3.getSystemWindowInsetTop(), var3.getSystemWindowInsetRight(), var3.getSystemWindowInsetBottom());
      }

      var0.dispatchApplyWindowInsets(var3);
   }

   public static Drawable getDefaultStatusBarBackground(Context var0) {
      TypedArray var1 = var0.obtainStyledAttributes(THEME_ATTRS);

      Drawable var3;
      try {
         var3 = var1.getDrawable(0);
      } finally {
         var1.recycle();
      }

      return var3;
   }

   public static int getTopInset(Object var0) {
      return var0 != null?((WindowInsets)var0).getSystemWindowInsetTop():0;
   }

   static class InsetsListener implements OnApplyWindowInsetsListener {
      public WindowInsets onApplyWindowInsets(View var1, WindowInsets var2) {
         DrawerLayoutImpl var3 = (DrawerLayoutImpl)var1;
         boolean var4;
         if(var2.getSystemWindowInsetTop() > 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         var3.setChildInsets(var2, var4);
         return var2.consumeSystemWindowInsets();
      }
   }
}
