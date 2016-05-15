package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.widget.TextViewCompatApi23;
import android.support.v4.widget.TextViewCompatDonut;
import android.support.v4.widget.TextViewCompatJb;
import android.support.v4.widget.TextViewCompatJbMr1;
import android.support.v4.widget.TextViewCompatJbMr2;
import android.widget.TextView;

public final class TextViewCompat {
   static final TextViewCompat.TextViewCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new TextViewCompat.Api23TextViewCompatImpl();
      } else if(var0 >= 18) {
         IMPL = new TextViewCompat.JbMr2TextViewCompatImpl();
      } else if(var0 >= 17) {
         IMPL = new TextViewCompat.JbMr1TextViewCompatImpl();
      } else if(var0 >= 16) {
         IMPL = new TextViewCompat.JbTextViewCompatImpl();
      } else {
         IMPL = new TextViewCompat.BaseTextViewCompatImpl();
      }
   }

   public static int getMaxLines(@NonNull TextView var0) {
      return IMPL.getMaxLines(var0);
   }

   public static int getMinLines(@NonNull TextView var0) {
      return IMPL.getMinLines(var0);
   }

   public static void setCompoundDrawablesRelative(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      IMPL.setCompoundDrawablesRelative(var0, var1, var2, var3, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, @DrawableRes int var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4) {
      IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(var0, var1, var2, var3, var4);
   }

   public static void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var0, @Nullable Drawable var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4) {
      IMPL.setCompoundDrawablesRelativeWithIntrinsicBounds(var0, var1, var2, var3, var4);
   }

   public static void setTextAppearance(@NonNull TextView var0, @StyleRes int var1) {
      IMPL.setTextAppearance(var0, var1);
   }

   static class Api23TextViewCompatImpl extends TextViewCompat.JbMr2TextViewCompatImpl {
      public void setTextAppearance(@NonNull TextView var1, @StyleRes int var2) {
         TextViewCompatApi23.setTextAppearance(var1, var2);
      }
   }

   static class BaseTextViewCompatImpl implements TextViewCompat.TextViewCompatImpl {
      public int getMaxLines(TextView var1) {
         return TextViewCompatDonut.getMaxLines(var1);
      }

      public int getMinLines(TextView var1) {
         return TextViewCompatDonut.getMinLines(var1);
      }

      public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         var1.setCompoundDrawables(var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4, @DrawableRes int var5) {
         var1.setCompoundDrawablesWithIntrinsicBounds(var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         var1.setCompoundDrawablesWithIntrinsicBounds(var2, var3, var4, var5);
      }

      public void setTextAppearance(TextView var1, @StyleRes int var2) {
         TextViewCompatDonut.setTextAppearance(var1, var2);
      }
   }

   static class JbMr1TextViewCompatImpl extends TextViewCompat.JbTextViewCompatImpl {
      public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr1.setCompoundDrawablesRelative(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4, @DrawableRes int var5) {
         TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr1.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }
   }

   static class JbMr2TextViewCompatImpl extends TextViewCompat.JbMr1TextViewCompatImpl {
      public void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr2.setCompoundDrawablesRelative(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4, @DrawableRes int var5) {
         TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }

      public void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5) {
         TextViewCompatJbMr2.setCompoundDrawablesRelativeWithIntrinsicBounds(var1, var2, var3, var4, var5);
      }
   }

   static class JbTextViewCompatImpl extends TextViewCompat.BaseTextViewCompatImpl {
      public int getMaxLines(TextView var1) {
         return TextViewCompatJb.getMaxLines(var1);
      }

      public int getMinLines(TextView var1) {
         return TextViewCompatJb.getMinLines(var1);
      }
   }

   interface TextViewCompatImpl {
      int getMaxLines(TextView var1);

      int getMinLines(TextView var1);

      void setCompoundDrawablesRelative(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5);

      void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @DrawableRes int var2, @DrawableRes int var3, @DrawableRes int var4, @DrawableRes int var5);

      void setCompoundDrawablesRelativeWithIntrinsicBounds(@NonNull TextView var1, @Nullable Drawable var2, @Nullable Drawable var3, @Nullable Drawable var4, @Nullable Drawable var5);

      void setTextAppearance(@NonNull TextView var1, @StyleRes int var2);
   }
}
