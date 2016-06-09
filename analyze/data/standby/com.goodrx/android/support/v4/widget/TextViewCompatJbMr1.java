package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

class TextViewCompatJbMr1 {
   public static void setCompoundDrawablesRelative(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      byte var5 = 1;
      if(var0.getLayoutDirection() != var5) {
         var5 = 0;
      }

      Drawable var6;
      if(var5 != 0) {
         var6 = var3;
      } else {
         var6 = var1;
      }

      if(var5 == 0) {
         var1 = var3;
      }

      var0.setCompoundDrawables(var6, var2, var1, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, int var1, int var2, int var3, int var4) {
      byte var5 = 1;
      if(var0.getLayoutDirection() != var5) {
         var5 = 0;
      }

      int var6;
      if(var5 != 0) {
         var6 = var3;
      } else {
         var6 = var1;
      }

      if(var5 == 0) {
         var1 = var3;
      }

      var0.setCompoundDrawablesWithIntrinsicBounds(var6, var2, var1, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      byte var5 = 1;
      if(var0.getLayoutDirection() != var5) {
         var5 = 0;
      }

      Drawable var6;
      if(var5 != 0) {
         var6 = var3;
      } else {
         var6 = var1;
      }

      if(var5 == 0) {
         var1 = var3;
      }

      var0.setCompoundDrawablesWithIntrinsicBounds(var6, var2, var1, var4);
   }
}
