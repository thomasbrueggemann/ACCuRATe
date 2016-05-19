package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

class ICUCompatIcs {
   private static final String TAG = "ICUCompatIcs";
   private static Method sAddLikelySubtagsMethod;
   private static Method sGetScriptMethod;

   static {
      // $FF: Couldn't be decompiled
   }

   private static String addLikelySubtags(Locale var0) {
      String var1 = var0.toString();

      try {
         if(sAddLikelySubtagsMethod != null) {
            Object[] var6 = new Object[]{var1};
            String var7 = (String)sAddLikelySubtagsMethod.invoke((Object)null, var6);
            return var7;
         }
      } catch (IllegalAccessException var8) {
         Log.w("ICUCompatIcs", var8);
      } catch (InvocationTargetException var9) {
         Log.w("ICUCompatIcs", var9);
      }

      return var1;
   }

   private static String getScript(String var0) {
      try {
         if(sGetScriptMethod != null) {
            Object[] var5 = new Object[]{var0};
            String var6 = (String)sGetScriptMethod.invoke((Object)null, var5);
            return var6;
         }
      } catch (IllegalAccessException var7) {
         Log.w("ICUCompatIcs", var7);
      } catch (InvocationTargetException var8) {
         Log.w("ICUCompatIcs", var8);
      }

      return null;
   }

   public static String maximizeAndGetScript(Locale var0) {
      String var1 = addLikelySubtags(var0);
      return var1 != null?getScript(var1):null;
   }
}
