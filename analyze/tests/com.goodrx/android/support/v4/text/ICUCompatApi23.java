package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

class ICUCompatApi23 {
   private static final String TAG = "ICUCompatIcs";
   private static Method sAddLikelySubtagsMethod;

   static {
      try {
         sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
      } catch (Exception var1) {
         throw new IllegalStateException(var1);
      }
   }

   public static String maximizeAndGetScript(Locale var0) {
      try {
         Object[] var1 = new Object[]{var0};
         String var6 = ((Locale)sAddLikelySubtagsMethod.invoke((Object)null, var1)).getScript();
         return var6;
      } catch (InvocationTargetException var7) {
         Log.w("ICUCompatIcs", var7);
      } catch (IllegalAccessException var8) {
         Log.w("ICUCompatIcs", var8);
      }

      return var0.getScript();
   }
}
