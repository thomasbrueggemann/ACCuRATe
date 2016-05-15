package android.support.v7.widget;

import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.widget.ThemeUtils;

class DrawableUtils {
   public static final Rect INSETS_NONE = new Rect();
   private static final String TAG = "DrawableUtils";
   private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
   private static Class<?> sInsetsClazz;

   static {
      if(VERSION.SDK_INT >= 18) {
         try {
            sInsetsClazz = Class.forName("android.graphics.Insets");
         } catch (ClassNotFoundException var1) {
            return;
         }
      }

   }

   static boolean canSafelyMutateDrawable(@NonNull Drawable var0) {
      if(var0 instanceof LayerDrawable) {
         if(VERSION.SDK_INT < 16) {
            return false;
         }
      } else if(var0 instanceof InsetDrawable) {
         if(VERSION.SDK_INT < 14) {
            return false;
         }
      } else if(var0 instanceof StateListDrawable) {
         if(VERSION.SDK_INT < 8) {
            return false;
         }
      } else if(var0 instanceof GradientDrawable) {
         if(VERSION.SDK_INT < 14) {
            return false;
         }
      } else if(var0 instanceof DrawableContainer) {
         ConstantState var1 = var0.getConstantState();
         if(var1 instanceof DrawableContainerState) {
            Drawable[] var2 = ((DrawableContainerState)var1).getChildren();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
               if(!canSafelyMutateDrawable(var2[var4])) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   static void fixDrawable(@NonNull Drawable var0) {
      if(VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(var0.getClass().getName())) {
         fixVectorDrawableTinting(var0);
      }

   }

   private static void fixVectorDrawableTinting(Drawable var0) {
      int[] var1 = var0.getState();
      if(var1 != null && var1.length != 0) {
         var0.setState(ThemeUtils.EMPTY_STATE_SET);
      } else {
         var0.setState(ThemeUtils.CHECKED_STATE_SET);
      }

      var0.setState(var1);
   }

   public static Rect getOpticalBounds(Drawable param0) {
      // $FF: Couldn't be decompiled
   }

   static Mode parseTintMode(int var0, Mode var1) {
      switch(var0) {
      case 3:
         return Mode.SRC_OVER;
      case 5:
         return Mode.SRC_IN;
      case 9:
         return Mode.SRC_ATOP;
      case 14:
         return Mode.MULTIPLY;
      case 15:
         return Mode.SCREEN;
      case 16:
         if(VERSION.SDK_INT >= 11) {
            return Mode.valueOf("ADD");
         }
      case 4:
      case 6:
      case 7:
      case 8:
      case 10:
      case 11:
      case 12:
      case 13:
      default:
         return var1;
      }
   }
}
