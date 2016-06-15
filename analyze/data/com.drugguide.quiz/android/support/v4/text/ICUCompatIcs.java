package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ICUCompatIcs {
   private static final String TAG = "ICUCompatIcs";
   private static Method sAddLikelySubtagsMethod;
   private static Method sGetScriptMethod;

   static {
      // $FF: Couldn't be decompiled
   }

   public static String addLikelySubtags(String var0) {
      try {
         if(sAddLikelySubtagsMethod != null) {
            Object[] var5 = new Object[]{var0};
            String var6 = (String)sAddLikelySubtagsMethod.invoke((Object)null, var5);
            return var6;
         }
      } catch (IllegalAccessException var7) {
         Log.w("ICUCompatIcs", var7);
      } catch (InvocationTargetException var8) {
         Log.w("ICUCompatIcs", var8);
      }

      return var0;
   }

   public static String getScript(String var0) {
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
}
