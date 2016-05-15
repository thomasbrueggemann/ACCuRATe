package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperLollipop;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class DrawableCompatLollipop {
   public static void applyTheme(Drawable var0, Theme var1) {
      var0.applyTheme(var1);
   }

   public static boolean canApplyTheme(Drawable var0) {
      return var0.canApplyTheme();
   }

   public static ColorFilter getColorFilter(Drawable var0) {
      return var0.getColorFilter();
   }

   public static void inflate(Drawable var0, Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws IOException, XmlPullParserException {
      var0.inflate(var1, var2, var3, var4);
   }

   public static void setHotspot(Drawable var0, float var1, float var2) {
      var0.setHotspot(var1, var2);
   }

   public static void setHotspotBounds(Drawable var0, int var1, int var2, int var3, int var4) {
      var0.setHotspotBounds(var1, var2, var3, var4);
   }

   public static void setTint(Drawable var0, int var1) {
      var0.setTint(var1);
   }

   public static void setTintList(Drawable var0, ColorStateList var1) {
      var0.setTintList(var1);
   }

   public static void setTintMode(Drawable var0, Mode var1) {
      var0.setTintMode(var1);
   }

   public static Drawable wrapForTinting(Drawable var0) {
      if(!(var0 instanceof DrawableWrapperLollipop)) {
         var0 = new DrawableWrapperLollipop((Drawable)var0);
      }

      return (Drawable)var0;
   }
}
