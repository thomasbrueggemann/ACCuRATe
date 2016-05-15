package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompatApi23;
import android.support.v4.graphics.drawable.DrawableCompatBase;
import android.support.v4.graphics.drawable.DrawableCompatEclair;
import android.support.v4.graphics.drawable.DrawableCompatHoneycomb;
import android.support.v4.graphics.drawable.DrawableCompatJellybeanMr1;
import android.support.v4.graphics.drawable.DrawableCompatKitKat;
import android.support.v4.graphics.drawable.DrawableCompatLollipop;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
   static final DrawableCompat.DrawableImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new DrawableCompat.MDrawableImpl();
      } else if(var0 >= 21) {
         IMPL = new DrawableCompat.LollipopDrawableImpl();
      } else if(var0 >= 19) {
         IMPL = new DrawableCompat.KitKatDrawableImpl();
      } else if(var0 >= 17) {
         IMPL = new DrawableCompat.JellybeanMr1DrawableImpl();
      } else if(var0 >= 11) {
         IMPL = new DrawableCompat.HoneycombDrawableImpl();
      } else if(var0 >= 5) {
         IMPL = new DrawableCompat.EclairDrawableImpl();
      } else {
         IMPL = new DrawableCompat.BaseDrawableImpl();
      }
   }

   public static void applyTheme(Drawable var0, Theme var1) {
      IMPL.applyTheme(var0, var1);
   }

   public static boolean canApplyTheme(Drawable var0) {
      return IMPL.canApplyTheme(var0);
   }

   public static int getAlpha(@NonNull Drawable var0) {
      return IMPL.getAlpha(var0);
   }

   public static ColorFilter getColorFilter(Drawable var0) {
      return IMPL.getColorFilter(var0);
   }

   public static int getLayoutDirection(@NonNull Drawable var0) {
      return IMPL.getLayoutDirection(var0);
   }

   public static void inflate(Drawable var0, Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws XmlPullParserException, IOException {
      IMPL.inflate(var0, var1, var2, var3, var4);
   }

   public static boolean isAutoMirrored(@NonNull Drawable var0) {
      return IMPL.isAutoMirrored(var0);
   }

   public static void jumpToCurrentState(@NonNull Drawable var0) {
      IMPL.jumpToCurrentState(var0);
   }

   public static void setAutoMirrored(@NonNull Drawable var0, boolean var1) {
      IMPL.setAutoMirrored(var0, var1);
   }

   public static void setHotspot(@NonNull Drawable var0, float var1, float var2) {
      IMPL.setHotspot(var0, var1, var2);
   }

   public static void setHotspotBounds(@NonNull Drawable var0, int var1, int var2, int var3, int var4) {
      IMPL.setHotspotBounds(var0, var1, var2, var3, var4);
   }

   public static void setLayoutDirection(@NonNull Drawable var0, int var1) {
      IMPL.setLayoutDirection(var0, var1);
   }

   public static void setTint(@NonNull Drawable var0, @ColorInt int var1) {
      IMPL.setTint(var0, var1);
   }

   public static void setTintList(@NonNull Drawable var0, @Nullable ColorStateList var1) {
      IMPL.setTintList(var0, var1);
   }

   public static void setTintMode(@NonNull Drawable var0, @Nullable Mode var1) {
      IMPL.setTintMode(var0, var1);
   }

   public static <T extends Drawable> T unwrap(@NonNull Drawable var0) {
      if(var0 instanceof DrawableWrapper) {
         var0 = ((DrawableWrapper)var0).getWrappedDrawable();
      }

      return var0;
   }

   public static Drawable wrap(@NonNull Drawable var0) {
      return IMPL.wrap(var0);
   }

   static class BaseDrawableImpl implements DrawableCompat.DrawableImpl {
      public void applyTheme(Drawable var1, Theme var2) {
      }

      public boolean canApplyTheme(Drawable var1) {
         return false;
      }

      public int getAlpha(Drawable var1) {
         return 0;
      }

      public ColorFilter getColorFilter(Drawable var1) {
         return null;
      }

      public int getLayoutDirection(Drawable var1) {
         return 0;
      }

      public void inflate(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Theme var5) throws IOException, XmlPullParserException {
         DrawableCompatBase.inflate(var1, var2, var3, var4, var5);
      }

      public boolean isAutoMirrored(Drawable var1) {
         return false;
      }

      public void jumpToCurrentState(Drawable var1) {
      }

      public void setAutoMirrored(Drawable var1, boolean var2) {
      }

      public void setHotspot(Drawable var1, float var2, float var3) {
      }

      public void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5) {
      }

      public void setLayoutDirection(Drawable var1, int var2) {
      }

      public void setTint(Drawable var1, int var2) {
         DrawableCompatBase.setTint(var1, var2);
      }

      public void setTintList(Drawable var1, ColorStateList var2) {
         DrawableCompatBase.setTintList(var1, var2);
      }

      public void setTintMode(Drawable var1, Mode var2) {
         DrawableCompatBase.setTintMode(var1, var2);
      }

      public Drawable wrap(Drawable var1) {
         return DrawableCompatBase.wrapForTinting(var1);
      }
   }

   interface DrawableImpl {
      void applyTheme(Drawable var1, Theme var2);

      boolean canApplyTheme(Drawable var1);

      int getAlpha(Drawable var1);

      ColorFilter getColorFilter(Drawable var1);

      int getLayoutDirection(Drawable var1);

      void inflate(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Theme var5) throws IOException, XmlPullParserException;

      boolean isAutoMirrored(Drawable var1);

      void jumpToCurrentState(Drawable var1);

      void setAutoMirrored(Drawable var1, boolean var2);

      void setHotspot(Drawable var1, float var2, float var3);

      void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5);

      void setLayoutDirection(Drawable var1, int var2);

      void setTint(Drawable var1, int var2);

      void setTintList(Drawable var1, ColorStateList var2);

      void setTintMode(Drawable var1, Mode var2);

      Drawable wrap(Drawable var1);
   }

   static class EclairDrawableImpl extends DrawableCompat.BaseDrawableImpl {
      public Drawable wrap(Drawable var1) {
         return DrawableCompatEclair.wrapForTinting(var1);
      }
   }

   static class HoneycombDrawableImpl extends DrawableCompat.EclairDrawableImpl {
      public void jumpToCurrentState(Drawable var1) {
         DrawableCompatHoneycomb.jumpToCurrentState(var1);
      }

      public Drawable wrap(Drawable var1) {
         return DrawableCompatHoneycomb.wrapForTinting(var1);
      }
   }

   static class JellybeanMr1DrawableImpl extends DrawableCompat.HoneycombDrawableImpl {
      public int getLayoutDirection(Drawable var1) {
         int var2 = DrawableCompatJellybeanMr1.getLayoutDirection(var1);
         return var2 >= 0?var2:0;
      }

      public void setLayoutDirection(Drawable var1, int var2) {
         DrawableCompatJellybeanMr1.setLayoutDirection(var1, var2);
      }
   }

   static class KitKatDrawableImpl extends DrawableCompat.JellybeanMr1DrawableImpl {
      public int getAlpha(Drawable var1) {
         return DrawableCompatKitKat.getAlpha(var1);
      }

      public boolean isAutoMirrored(Drawable var1) {
         return DrawableCompatKitKat.isAutoMirrored(var1);
      }

      public void setAutoMirrored(Drawable var1, boolean var2) {
         DrawableCompatKitKat.setAutoMirrored(var1, var2);
      }

      public Drawable wrap(Drawable var1) {
         return DrawableCompatKitKat.wrapForTinting(var1);
      }
   }

   static class LollipopDrawableImpl extends DrawableCompat.KitKatDrawableImpl {
      public void applyTheme(Drawable var1, Theme var2) {
         DrawableCompatLollipop.applyTheme(var1, var2);
      }

      public boolean canApplyTheme(Drawable var1) {
         return DrawableCompatLollipop.canApplyTheme(var1);
      }

      public ColorFilter getColorFilter(Drawable var1) {
         return DrawableCompatLollipop.getColorFilter(var1);
      }

      public void inflate(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Theme var5) throws IOException, XmlPullParserException {
         DrawableCompatLollipop.inflate(var1, var2, var3, var4, var5);
      }

      public void setHotspot(Drawable var1, float var2, float var3) {
         DrawableCompatLollipop.setHotspot(var1, var2, var3);
      }

      public void setHotspotBounds(Drawable var1, int var2, int var3, int var4, int var5) {
         DrawableCompatLollipop.setHotspotBounds(var1, var2, var3, var4, var5);
      }

      public void setTint(Drawable var1, int var2) {
         DrawableCompatLollipop.setTint(var1, var2);
      }

      public void setTintList(Drawable var1, ColorStateList var2) {
         DrawableCompatLollipop.setTintList(var1, var2);
      }

      public void setTintMode(Drawable var1, Mode var2) {
         DrawableCompatLollipop.setTintMode(var1, var2);
      }

      public Drawable wrap(Drawable var1) {
         return DrawableCompatLollipop.wrapForTinting(var1);
      }
   }

   static class MDrawableImpl extends DrawableCompat.LollipopDrawableImpl {
      public int getLayoutDirection(Drawable var1) {
         return DrawableCompatApi23.getLayoutDirection(var1);
      }

      public void setLayoutDirection(Drawable var1, int var2) {
         DrawableCompatApi23.setLayoutDirection(var1, var2);
      }

      public Drawable wrap(Drawable var1) {
         return var1;
      }
   }
}
