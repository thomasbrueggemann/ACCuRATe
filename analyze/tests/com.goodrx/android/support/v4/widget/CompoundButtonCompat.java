package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.CompoundButtonCompatApi23;
import android.support.v4.widget.CompoundButtonCompatDonut;
import android.support.v4.widget.CompoundButtonCompatLollipop;
import android.widget.CompoundButton;

public final class CompoundButtonCompat {
   private static final CompoundButtonCompat.CompoundButtonCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new CompoundButtonCompat.Api23CompoundButtonImpl();
      } else if(var0 >= 21) {
         IMPL = new CompoundButtonCompat.LollipopCompoundButtonImpl();
      } else {
         IMPL = new CompoundButtonCompat.BaseCompoundButtonCompat();
      }
   }

   @Nullable
   public static Drawable getButtonDrawable(@NonNull CompoundButton var0) {
      return IMPL.getButtonDrawable(var0);
   }

   @Nullable
   public static ColorStateList getButtonTintList(@NonNull CompoundButton var0) {
      return IMPL.getButtonTintList(var0);
   }

   @Nullable
   public static Mode getButtonTintMode(@NonNull CompoundButton var0) {
      return IMPL.getButtonTintMode(var0);
   }

   public static void setButtonTintList(@NonNull CompoundButton var0, @Nullable ColorStateList var1) {
      IMPL.setButtonTintList(var0, var1);
   }

   public static void setButtonTintMode(@NonNull CompoundButton var0, @Nullable Mode var1) {
      IMPL.setButtonTintMode(var0, var1);
   }

   static class Api23CompoundButtonImpl extends CompoundButtonCompat.LollipopCompoundButtonImpl {
      public Drawable getButtonDrawable(CompoundButton var1) {
         return CompoundButtonCompatApi23.getButtonDrawable(var1);
      }
   }

   static class BaseCompoundButtonCompat implements CompoundButtonCompat.CompoundButtonCompatImpl {
      public Drawable getButtonDrawable(CompoundButton var1) {
         return CompoundButtonCompatDonut.getButtonDrawable(var1);
      }

      public ColorStateList getButtonTintList(CompoundButton var1) {
         return CompoundButtonCompatDonut.getButtonTintList(var1);
      }

      public Mode getButtonTintMode(CompoundButton var1) {
         return CompoundButtonCompatDonut.getButtonTintMode(var1);
      }

      public void setButtonTintList(CompoundButton var1, ColorStateList var2) {
         CompoundButtonCompatDonut.setButtonTintList(var1, var2);
      }

      public void setButtonTintMode(CompoundButton var1, Mode var2) {
         CompoundButtonCompatDonut.setButtonTintMode(var1, var2);
      }
   }

   interface CompoundButtonCompatImpl {
      Drawable getButtonDrawable(CompoundButton var1);

      ColorStateList getButtonTintList(CompoundButton var1);

      Mode getButtonTintMode(CompoundButton var1);

      void setButtonTintList(CompoundButton var1, ColorStateList var2);

      void setButtonTintMode(CompoundButton var1, Mode var2);
   }

   static class LollipopCompoundButtonImpl extends CompoundButtonCompat.BaseCompoundButtonCompat {
      public ColorStateList getButtonTintList(CompoundButton var1) {
         return CompoundButtonCompatLollipop.getButtonTintList(var1);
      }

      public Mode getButtonTintMode(CompoundButton var1) {
         return CompoundButtonCompatLollipop.getButtonTintMode(var1);
      }

      public void setButtonTintList(CompoundButton var1, ColorStateList var2) {
         CompoundButtonCompatLollipop.setButtonTintList(var1, var2);
      }

      public void setButtonTintMode(CompoundButton var1, Mode var2) {
         CompoundButtonCompatLollipop.setButtonTintMode(var1, var2);
      }
   }
}
