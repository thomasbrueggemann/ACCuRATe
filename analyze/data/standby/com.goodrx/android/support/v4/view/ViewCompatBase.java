package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.TintableBackgroundView;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ViewCompatBase {
   private static final String TAG = "ViewCompatBase";
   private static Field sMinHeightField;
   private static boolean sMinHeightFieldFetched;
   private static Field sMinWidthField;
   private static boolean sMinWidthFieldFetched;

   static ColorStateList getBackgroundTintList(View var0) {
      return var0 instanceof TintableBackgroundView?((TintableBackgroundView)var0).getSupportBackgroundTintList():null;
   }

   static Mode getBackgroundTintMode(View var0) {
      return var0 instanceof TintableBackgroundView?((TintableBackgroundView)var0).getSupportBackgroundTintMode():null;
   }

   static int getMinimumHeight(View var0) {
      if(!sMinHeightFieldFetched) {
         try {
            sMinHeightField = View.class.getDeclaredField("mMinHeight");
            sMinHeightField.setAccessible(true);
         } catch (NoSuchFieldException var4) {
            ;
         }

         sMinHeightFieldFetched = true;
      }

      if(sMinHeightField != null) {
         try {
            int var2 = ((Integer)sMinHeightField.get(var0)).intValue();
            return var2;
         } catch (Exception var5) {
            ;
         }
      }

      return 0;
   }

   static int getMinimumWidth(View var0) {
      if(!sMinWidthFieldFetched) {
         try {
            sMinWidthField = View.class.getDeclaredField("mMinWidth");
            sMinWidthField.setAccessible(true);
         } catch (NoSuchFieldException var4) {
            ;
         }

         sMinWidthFieldFetched = true;
      }

      if(sMinWidthField != null) {
         try {
            int var2 = ((Integer)sMinWidthField.get(var0)).intValue();
            return var2;
         } catch (Exception var5) {
            ;
         }
      }

      return 0;
   }

   static boolean isAttachedToWindow(View var0) {
      return var0.getWindowToken() != null;
   }

   static boolean isLaidOut(View var0) {
      return var0.getWidth() > 0 && var0.getHeight() > 0;
   }

   static void offsetLeftAndRight(View var0, int var1) {
      int var2 = var0.getLeft();
      var0.offsetLeftAndRight(var1);
      if(var1 != 0) {
         ViewParent var3 = var0.getParent();
         if(!(var3 instanceof View)) {
            var0.invalidate();
            return;
         }

         int var4 = Math.abs(var1);
         ((View)var3).invalidate(var2 - var4, var0.getTop(), var4 + var2 + var0.getWidth(), var0.getBottom());
      }

   }

   static void offsetTopAndBottom(View var0, int var1) {
      int var2 = var0.getTop();
      var0.offsetTopAndBottom(var1);
      if(var1 != 0) {
         ViewParent var3 = var0.getParent();
         if(!(var3 instanceof View)) {
            var0.invalidate();
            return;
         }

         int var4 = Math.abs(var1);
         ((View)var3).invalidate(var0.getLeft(), var2 - var4, var0.getRight(), var4 + var2 + var0.getHeight());
      }

   }

   static void setBackgroundTintList(View var0, ColorStateList var1) {
      if(var0 instanceof TintableBackgroundView) {
         ((TintableBackgroundView)var0).setSupportBackgroundTintList(var1);
      }

   }

   static void setBackgroundTintMode(View var0, Mode var1) {
      if(var0 instanceof TintableBackgroundView) {
         ((TintableBackgroundView)var0).setSupportBackgroundTintMode(var1);
      }

   }
}
