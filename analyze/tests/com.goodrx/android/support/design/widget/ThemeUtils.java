package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.class_5;

class ThemeUtils {
   private static final int[] APPCOMPAT_CHECK_ATTRS;

   static {
      int[] var0 = new int[]{class_5.attr.colorPrimary};
      APPCOMPAT_CHECK_ATTRS = var0;
   }

   static void checkAppCompatTheme(Context var0) {
      TypedArray var1 = var0.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
      boolean var2 = var1.hasValue(0);
      boolean var3 = false;
      if(!var2) {
         var3 = true;
      }

      if(var1 != null) {
         var1.recycle();
      }

      if(var3) {
         throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
      }
   }
}
