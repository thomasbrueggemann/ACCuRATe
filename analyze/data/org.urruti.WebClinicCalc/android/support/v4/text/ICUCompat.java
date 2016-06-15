package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.v4.text.ICUCompatIcs;

public class ICUCompat {
   private static final ICUCompat.ICUCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new ICUCompat.ICUCompatImplIcs();
      } else {
         IMPL = new ICUCompat.ICUCompatImplBase();
      }
   }

   public static String addLikelySubtags(String var0) {
      return IMPL.addLikelySubtags(var0);
   }

   public static String getScript(String var0) {
      return IMPL.getScript(var0);
   }

   interface ICUCompatImpl {
      String addLikelySubtags(String var1);

      String getScript(String var1);
   }

   static class ICUCompatImplBase implements ICUCompat.ICUCompatImpl {
      public String addLikelySubtags(String var1) {
         return var1;
      }

      public String getScript(String var1) {
         return null;
      }
   }

   static class ICUCompatImplIcs implements ICUCompat.ICUCompatImpl {
      public String addLikelySubtags(String var1) {
         return ICUCompatIcs.addLikelySubtags(var1);
      }

      public String getScript(String var1) {
         return ICUCompatIcs.getScript(var1);
      }
   }
}
