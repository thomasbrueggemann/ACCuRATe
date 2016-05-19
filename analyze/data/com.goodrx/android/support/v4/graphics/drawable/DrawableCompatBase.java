package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.graphics.drawable.DrawableWrapperDonut;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class DrawableCompatBase {
   public static void inflate(Drawable var0, Resources var1, XmlPullParser var2, AttributeSet var3, Theme var4) throws IOException, XmlPullParserException {
      var0.inflate(var1, var2, var3);
   }

   public static void setTint(Drawable var0, int var1) {
      if(var0 instanceof DrawableWrapper) {
         ((DrawableWrapper)var0).setCompatTint(var1);
      }

   }

   public static void setTintList(Drawable var0, ColorStateList var1) {
      if(var0 instanceof DrawableWrapper) {
         ((DrawableWrapper)var0).setCompatTintList(var1);
      }

   }

   public static void setTintMode(Drawable var0, Mode var1) {
      if(var0 instanceof DrawableWrapper) {
         ((DrawableWrapper)var0).setCompatTintMode(var1);
      }

   }

   public static Drawable wrapForTinting(Drawable var0) {
      if(!(var0 instanceof DrawableWrapperDonut)) {
         var0 = new DrawableWrapperDonut((Drawable)var0);
      }

      return (Drawable)var0;
   }
}
