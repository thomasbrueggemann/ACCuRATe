package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TintableCompoundButton;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class CompoundButtonCompatDonut {
   private static final String TAG = "CompoundButtonCompatDonut";
   private static Field sButtonDrawableField;
   private static boolean sButtonDrawableFieldFetched;

   static Drawable getButtonDrawable(CompoundButton var0) {
      if(!sButtonDrawableFieldFetched) {
         try {
            sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
            sButtonDrawableField.setAccessible(true);
         } catch (NoSuchFieldException var5) {
            Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", var5);
         }

         sButtonDrawableFieldFetched = true;
      }

      if(sButtonDrawableField != null) {
         try {
            Drawable var3 = (Drawable)sButtonDrawableField.get(var0);
            return var3;
         } catch (IllegalAccessException var6) {
            Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", var6);
            sButtonDrawableField = null;
         }
      }

      return null;
   }

   static ColorStateList getButtonTintList(CompoundButton var0) {
      return var0 instanceof TintableCompoundButton?((TintableCompoundButton)var0).getSupportButtonTintList():null;
   }

   static Mode getButtonTintMode(CompoundButton var0) {
      return var0 instanceof TintableCompoundButton?((TintableCompoundButton)var0).getSupportButtonTintMode():null;
   }

   static void setButtonTintList(CompoundButton var0, ColorStateList var1) {
      if(var0 instanceof TintableCompoundButton) {
         ((TintableCompoundButton)var0).setSupportButtonTintList(var1);
      }

   }

   static void setButtonTintMode(CompoundButton var0, Mode var1) {
      if(var0 instanceof TintableCompoundButton) {
         ((TintableCompoundButton)var0).setSupportButtonTintMode(var1);
      }

   }
}
