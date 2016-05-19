package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.v4.text.ICUCompatApi23;
import android.support.v4.text.ICUCompatIcs;
import java.util.Locale;

public final class ICUCompat {
   private static final ICUCompat.ICUCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new ICUCompat.ICUCompatImplLollipop();
      } else if(var0 >= 14) {
         IMPL = new ICUCompat.ICUCompatImplIcs();
      } else {
         IMPL = new ICUCompat.ICUCompatImplBase();
      }
   }

   public static String maximizeAndGetScript(Locale var0) {
      return IMPL.maximizeAndGetScript(var0);
   }

   interface ICUCompatImpl {
      String maximizeAndGetScript(Locale var1);
   }

   static class ICUCompatImplBase implements ICUCompat.ICUCompatImpl {
      public String maximizeAndGetScript(Locale var1) {
         return null;
      }
   }

   static class ICUCompatImplIcs implements ICUCompat.ICUCompatImpl {
      public String maximizeAndGetScript(Locale var1) {
         return ICUCompatIcs.maximizeAndGetScript(var1);
      }
   }

   static class ICUCompatImplLollipop implements ICUCompat.ICUCompatImpl {
      public String maximizeAndGetScript(Locale var1) {
         return ICUCompatApi23.maximizeAndGetScript(var1);
      }
   }
}
